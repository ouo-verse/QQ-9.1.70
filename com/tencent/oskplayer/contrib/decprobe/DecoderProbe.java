package com.tencent.oskplayer.contrib.decprobe;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.oskplayer.contrib.ImageHash;
import com.tencent.oskplayer.contrib.ImageHashError;
import com.tencent.oskplayer.miscellaneous.DecodeProbe;
import com.tencent.oskplayer.miscellaneous.HardwareDecodeProbe;
import com.tencent.oskplayer.miscellaneous.SoftwareDecodeProbe;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.io.AbsDownloader;
import com.tencent.oskplayer.support.io.AbsDownloaderFactory;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.thread.AbsThreadManager;
import com.tencent.oskplayer.support.util.OskBitmap;
import com.tencent.oskplayer.support.util.OskCollection;
import com.tencent.oskplayer.support.util.OskDebug;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes34.dex */
public class DecoderProbe {
    public static final String LOG_TAG = "DecoderProbe";
    public static final int RESULT_BLACKLIST = -3;
    public static final int RESULT_ERR_LIBRARY = -4;
    public static final int RESULT_NO = 2;
    public static final int RESULT_PROBE_NOT_SUPPORT = -2;
    public static final int RESULT_UNKNOWN = -1;
    public static final int RESULT_YES = 1;
    private static final String SP_NAME = "decoderprobe";
    public static final int SP_VERSION = 1;
    public static final String VIDEO_PROFILE_HVC_1080P = "hvc1080P";
    public static final String VIDEO_PROFILE_HVC_540P = "hvc540P";
    public static final String VIDEO_PROFILE_HVC_720P = "hvc720P";
    public static final String VIDEO_PROFILE_UNKNOWN = "profile_unknown";
    private static final int[] sFrameSeq = {1, 8, 64};
    private static DecoderProbe sInstance;
    private String blacklistModels;
    private AbsDownloaderFactory downloaderFactory;
    private boolean isResourceAvailable;
    private boolean isSupport;
    private String mResDir;
    private AbsThreadManager threadManager;
    private volatile boolean mIsDownloading = false;
    private volatile boolean mIsProbing = false;
    private Map<String, String> mVideoProfileResource = new HashMap();
    public String[] supportedProfiles = {VIDEO_PROFILE_HVC_540P, VIDEO_PROFILE_HVC_720P, VIDEO_PROFILE_HVC_1080P};
    BitSet printFlags = new BitSet(16);
    private SharedPreferences mPreferences = OskSupport.getContext().getSharedPreferences(SP_NAME, 0);
    private Map<String, ProbeResultCache> mProbeResultCache = new ConcurrentHashMap();

    /* loaded from: classes34.dex */
    private class BitmapHolder {
        Bitmap bitmap;
        BitmapFactory.Options opts;
        String path;
        long phash;

        BitmapHolder() {
            this.phash = 0L;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes34.dex */
    public @interface HwDecodeStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes34.dex */
    public @interface HwDecodeVideoProfile {
    }

    /* loaded from: classes34.dex */
    public static class ProbeResult {
        public long avgHwDecFrameCost;
        public long avgSwDecFrameCost;
        public long fpsHwDec;
        public long fpsSwDec;
        public float progress;
        public int statusCode;
        public long timeCostHwDecode;
        public long timeCostSwDecode;
        public long timeCostTotal;
        public String videoProfile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class ProbeResultCache {
        Object cachedResult;

        ProbeResultCache() {
        }
    }

    /* loaded from: classes34.dex */
    public interface ProbeResultCallback {
        void onProbeResult(ProbeResult probeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class ProbeResultHolder {
        static final String SOURCE_HW = "hw";
        static final String SOURCE_SW = "sw";
        static final int TYPE_PROBE_PROGRESS = 1;
        static final int TYPE_PROBE_RESULT = 2;
        long avgDecFrameCost;
        String source;
        long timeCost;
        int type;
        int value;

        ProbeResultHolder() {
        }
    }

    DecoderProbe() {
        this.mResDir = null;
        this.mResDir = OskFile.ensureFilesDir("decoder_probe_res");
        StringBuilder sb5 = new StringBuilder("readSp ");
        for (String str : this.supportedProfiles) {
            ProbeResultCache probeResultCache = new ProbeResultCache();
            probeResultCache.cachedResult = Integer.valueOf(readSp(str, -1));
            this.mProbeResultCache.put(getSpKey(str), probeResultCache);
            sb5.append(str);
            sb5.append(":");
            sb5.append(probeResultCache.cachedResult);
            sb5.append(",");
        }
        Logger.g().i(LOG_TAG, sb5.toString());
    }

    private String downloadVideoResource(String str) {
        String str2;
        String str3 = this.mVideoProfileResource.get(str);
        if (TextUtils.isEmpty(str3)) {
            str2 = null;
        } else {
            str2 = str + ".mp4";
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            Pair<String, Integer> parseConfig = parseConfig(str3);
            if (parseConfig == null) {
                Logger.g().w(LOG_TAG, "invalid config " + str3);
                return null;
            }
            String str4 = (String) parseConfig.first;
            final Integer num = (Integer) parseConfig.second;
            final File file = new File(this.mResDir + File.separator + str2);
            if (file.exists() && file.isFile() && file.length() == num.intValue()) {
                Logger.g().i(LOG_TAG, "found a valid file for " + str);
                return file.getAbsolutePath();
            }
            if (isDownloading()) {
                Logger.g().w(LOG_TAG, "something is downloading, try again");
                return null;
            }
            AbsDownloader create = this.downloaderFactory.create(str4, null);
            create.setDownloadListener(new AbsDownloader.DownloadListener() { // from class: com.tencent.oskplayer.contrib.decprobe.DecoderProbe.1
                @Override // com.tencent.oskplayer.support.io.AbsDownloader.DownloadListener
                public void onDownloadCanceled(String str5) {
                    DecoderProbe.this.setDownloading(false);
                    Logger.g().w(DecoderProbe.LOG_TAG, "download canceled " + str5);
                }

                @Override // com.tencent.oskplayer.support.io.AbsDownloader.DownloadListener
                public void onDownloadFailed(String str5) {
                    DecoderProbe.this.setDownloading(false);
                    Logger.g().w(DecoderProbe.LOG_TAG, "download failed " + str5);
                }

                @Override // com.tencent.oskplayer.support.io.AbsDownloader.DownloadListener
                public void onDownloadProgress(String str5, float f16) {
                    DecoderProbe.this.setDownloading(true);
                }

                @Override // com.tencent.oskplayer.support.io.AbsDownloader.DownloadListener
                public void onDownloadSucceed(String str5, String str6) {
                    File file2 = new File(str6);
                    if (file2.exists() && file2.isFile() && file2.length() == num.intValue()) {
                        if (file.exists()) {
                            file.delete();
                        }
                        if (file2.renameTo(file)) {
                            Logger.g().i(DecoderProbe.LOG_TAG, "download success " + str5);
                        } else {
                            try {
                                OskFile.copy(file2, file);
                            } catch (Exception unused) {
                                Logger.g().i(DecoderProbe.LOG_TAG, "failed copy file from " + file2);
                            }
                            if (file.exists() && file.isFile() && file.length() == num.intValue()) {
                                Logger.g().i(DecoderProbe.LOG_TAG, "download copy success " + str5);
                            }
                        }
                    } else {
                        Logger.g().e(DecoderProbe.LOG_TAG, "download file error, length not match " + file2.length() + " vs " + num);
                        file2.delete();
                    }
                    DecoderProbe.this.setDownloading(false);
                }
            });
            setDownloading(true);
            create.download();
            return null;
        }
        Logger.g().w(LOG_TAG, "empty configStr for key " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmap(String str, BitmapFactory.Options options) {
        new BitmapFactory.Options();
        int calculateInSampleSizeLow = OskBitmap.calculateInSampleSizeLow(options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = calculateInSampleSizeLow;
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            try {
                return BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(str), 8192), null, options2);
            } catch (OutOfMemoryError e16) {
                Logger.g().e(LOG_TAG, "\u5185\u5b58\u5360\u7528\u8fc7\u5927\uff0c\u56fe\u7247\u89e3\u7801\u5931", e16);
                return null;
            } catch (Throwable th5) {
                Logger.g().e(LOG_TAG, "decode bitmap failed", th5);
                return null;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapFactory.Options getBitmapBounds(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            try {
                BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(str), 8192), new Rect(), options);
            } catch (OutOfMemoryError e16) {
                Logger.g().e(LOG_TAG, "\u5185\u5b58\u5360\u7528\u8fc7\u5927\uff0c\u56fe\u7247\u89e3\u7801\u5931", e16);
            } catch (Throwable th5) {
                Logger.g().e(LOG_TAG, "decode bitmap failed", th5);
            }
            return options;
        } catch (IOException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getErrorCode(Throwable th5) {
        if (th5 instanceof ImageHashError) {
            return ((ImageHashError) th5).errCode;
        }
        return Integer.MIN_VALUE;
    }

    public static DecoderProbe getInstance() {
        if (sInstance == null) {
            synchronized (DecoderProbe.class) {
                if (sInstance == null) {
                    sInstance = new DecoderProbe();
                }
            }
        }
        return sInstance;
    }

    private File getProbeResultFile(String str) {
        return new File(this.mResDir + File.separator + str + "_pr.txt");
    }

    private String getSpKey(String str) {
        return str + 1;
    }

    private synchronized boolean isDownloading() {
        return this.mIsDownloading;
    }

    private synchronized boolean isProbing() {
        return this.mIsProbing;
    }

    private Pair<String, Integer> parseConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\|");
        try {
            if (split.length >= 2) {
                return new Pair<>(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return null;
        } catch (Exception e16) {
            Logger.g().e(LOG_TAG, "unable parseConfig " + str, e16);
            return null;
        }
    }

    private void probe(final String str, final ProbeResultCallback probeResultCallback) {
        String downloadVideoResource = downloadVideoResource(str);
        if (TextUtils.isEmpty(downloadVideoResource)) {
            Logger.g().i(LOG_TAG, "probe " + str + ", local file missing, try later");
            return;
        }
        setProbing(true);
        probeUrl(downloadVideoResource, str, new ProbeResultCallback() { // from class: com.tencent.oskplayer.contrib.decprobe.DecoderProbe.2
            @Override // com.tencent.oskplayer.contrib.decprobe.DecoderProbe.ProbeResultCallback
            public void onProbeResult(ProbeResult probeResult) {
                Logger.g().i(DecoderProbe.LOG_TAG, "probe " + str + ", resultCode=" + probeResult.statusCode);
                DecoderProbe.this.saveResult(str, probeResult.statusCode);
                ProbeResultCallback probeResultCallback2 = probeResultCallback;
                if (probeResultCallback2 != null) {
                    probeResultCallback2.onProbeResult(probeResult);
                }
                DecoderProbe.this.setProbing(false);
            }
        });
    }

    private static String readFileAsString(File file) {
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
        } catch (FileNotFoundException e16) {
            Logger.g().w(LOG_TAG, "read file no such file " + file.getAbsolutePath(), e16);
        } catch (IOException e17) {
            Logger.g().w(LOG_TAG, "read file io exception " + file.getAbsolutePath(), e17);
        }
        return sb5.toString();
    }

    private int readSp(String str, int i3) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(getSpKey(str), i3);
        }
        Logger.g().i(LOG_TAG, "no preference");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setDownloading(boolean z16) {
        this.mIsDownloading = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setProbing(boolean z16) {
        this.mIsProbing = z16;
    }

    private Integer[] wrapIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            numArr[i16] = Integer.valueOf(iArr[i3]);
            i3++;
            i16++;
        }
        return numArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeStringAsFile(String str, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e16) {
            Logger.g().w(LOG_TAG, "error writing file " + file.getAbsolutePath(), e16);
        }
    }

    public void addDecResource(String str, String str2) {
        this.mVideoProfileResource.put(str, str2);
    }

    public int canHwDecByProfile(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.g().w(LOG_TAG, "canHwDecByProfile empty video profile");
            return -1;
        }
        ProbeResultCache probeResultCache = this.mProbeResultCache.get(getSpKey(str));
        if (probeResultCache == null) {
            Logger.g().i(LOG_TAG, "canHwDecByProfile unsupported profile " + str);
            return -1;
        }
        int intValue = ((Integer) probeResultCache.cachedResult).intValue();
        if (intValue == -1) {
            return -1;
        }
        int index = OskCollection.index(this.supportedProfiles, str);
        if (!this.printFlags.get(index) && printFileContentToLog(getProbeResultFile(str))) {
            this.printFlags.set(index);
        }
        Logger.g().d(LOG_TAG, "canHwDecByProfile " + str + ":" + intValue);
        if (intValue == 0) {
            return 1;
        }
        if (intValue == -3 || intValue == -2 || intValue == -4) {
            return intValue;
        }
        return 2;
    }

    public synchronized void runProbe(String str, ProbeResultCallback probeResultCallback) {
        if (TextUtils.isEmpty(str)) {
            Logger.g().w(LOG_TAG, "runProbe empty video profile");
            return;
        }
        if (!ImageHash.isNativeLibReady(OskSupport.getLibLoader())) {
            Logger.g().w(LOG_TAG, "runProbe wait probe library ready");
            return;
        }
        if (this.mProbeResultCache.get(getSpKey(str)) == null) {
            Logger.g().i(LOG_TAG, "runProbe unknown profile " + str);
            return;
        }
        int canHwDecByProfile = canHwDecByProfile(str);
        ProbeResult probeResult = new ProbeResult();
        probeResult.videoProfile = str;
        if (canHwDecByProfile == -1) {
            if (!TextUtils.isEmpty(this.blacklistModels) && this.blacklistModels.toLowerCase().contains(DeviceInfoMonitor.getModel().toLowerCase())) {
                saveResult(str, -3);
                probeResult.statusCode = -3;
                probeResultCallback.onProbeResult(probeResult);
            } else if (!isProbing()) {
                Logger.g().i(LOG_TAG, "canUseHardDecodeForVideoProfile isSupport=" + this.isSupport + ",ResourceAvailable=" + this.isResourceAvailable);
                if (this.isSupport) {
                    if (!this.isResourceAvailable) {
                        ImageHash.loadLibrariesOnce(OskSupport.getLibLoader());
                        if (ImageHash.sIsLibLoadSuccess) {
                            probe(str, probeResultCallback);
                        } else {
                            saveResult(str, -4);
                            probeResult.statusCode = -4;
                            probeResultCallback.onProbeResult(probeResult);
                        }
                    } else {
                        Logger.g().i(LOG_TAG, "abort, sysbusy");
                    }
                } else {
                    saveResult(str, -2);
                    probeResult.statusCode = -2;
                    probeResultCallback.onProbeResult(probeResult);
                }
            }
        }
    }

    @Deprecated
    public void saveResult(String str, int i3) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(getSpKey(str), i3).apply();
        } else {
            Logger.g().i(LOG_TAG, "no preference");
        }
        ProbeResultCache probeResultCache = new ProbeResultCache();
        probeResultCache.cachedResult = Integer.valueOf(i3);
        this.mProbeResultCache.put(getSpKey(str), probeResultCache);
    }

    public void setBlackListModel(String str) {
        this.blacklistModels = str;
    }

    public void setDownloader(AbsDownloaderFactory absDownloaderFactory) {
        this.downloaderFactory = absDownloaderFactory;
    }

    public void setIsResourceAvailable(boolean z16) {
        this.isResourceAvailable = z16;
    }

    public void setIsSupport(boolean z16) {
        this.isSupport = z16;
    }

    public void setThreadManager(AbsThreadManager absThreadManager) {
        this.threadManager = absThreadManager;
    }

    private boolean printFileContentToLog(File file) {
        if (file == null || !file.isFile() || !file.exists()) {
            return false;
        }
        String readFileAsString = readFileAsString(file);
        Logger.g().i(LOG_TAG, file.getName() + ":" + readFileAsString);
        return true;
    }

    private void probeUrl(final String str, final String str2, final ProbeResultCallback probeResultCallback) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        int[] iArr = sFrameSeq;
        Integer[] wrapIntArray = wrapIntArray(iArr);
        DecodeProbe.getInstance().addSaveFrame(iArr);
        DecodeProbe.getInstance().cleanPicOutDir();
        final ProgressMum progressMum = new ProgressMum();
        progressMum.setMaxStep(wrapIntArray[wrapIntArray.length - 1].intValue());
        final ProgressMum progressMum2 = new ProgressMum();
        progressMum2.setMaxStep(wrapIntArray[wrapIntArray.length - 1].intValue());
        final ProgressMum progressMum3 = new ProgressMum();
        progressMum3.setMaxStep(wrapIntArray.length);
        ProgressMum progressMum4 = new ProgressMum();
        progressMum4.addProgress(progressMum, 0.5f);
        progressMum4.addProgress(progressMum2, 0.5f);
        final ProgressMum progressMum5 = new ProgressMum();
        progressMum5.addProgress(progressMum4, 0.5f);
        progressMum5.addProgress(progressMum3, 0.5f);
        final ProbeResultHolder probeResultHolder = new ProbeResultHolder();
        final ProbeResultHolder probeResultHolder2 = new ProbeResultHolder();
        final File probeResultFile = getProbeResultFile(str2);
        this.threadManager.postJobOnIOThread(new Runnable() { // from class: com.tencent.oskplayer.contrib.decprobe.DecoderProbe.3
            /* JADX WARN: Removed duplicated region for block: B:12:0x0429  */
            /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                String str3;
                String str4;
                int i3;
                int i16;
                boolean z17;
                int i17;
                long j3;
                String str5;
                String str6;
                String str7;
                int i18;
                BitmapHolder bitmapHolder;
                BitmapHolder bitmapHolder2;
                BitmapHolder[] bitmapHolderArr;
                String str8;
                int i19;
                String str9;
                long j16;
                int i26;
                int hwProbe;
                int i27 = 1;
                try {
                    DecodeProbe.getInstance().setHwProbeCallback(new HardwareDecodeProbe.HwProbeCallback() { // from class: com.tencent.oskplayer.contrib.decprobe.DecoderProbe.3.1
                        @Override // com.tencent.oskplayer.miscellaneous.HardwareDecodeProbe.HwProbeCallback
                        public void onHwProbeOneFrame(int i28) {
                            ProbeResultHolder probeResultHolder3 = new ProbeResultHolder();
                            progressMum.updateStep(i28);
                            probeResultHolder3.source = "hw";
                            probeResultHolder3.type = 1;
                            probeResultHolder3.value = i28;
                            Logger.g().i(DecoderProbe.LOG_TAG, "ProbeDecEvent type:" + probeResultHolder3.type + ",source:" + probeResultHolder3.source + ",value=" + probeResultHolder3.value);
                        }
                    });
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    hwProbe = DecodeProbe.getInstance().hwProbe(str);
                    ProbeResultHolder probeResultHolder3 = probeResultHolder;
                    probeResultHolder3.source = "hw";
                    probeResultHolder3.type = 2;
                    probeResultHolder3.value = hwProbe;
                    probeResultHolder3.timeCost = SystemClock.uptimeMillis() - uptimeMillis2;
                    probeResultHolder.avgDecFrameCost = DecodeProbe.getInstance().getHwDecodeAvgCost();
                    progressMum.markFinishForce();
                    Logger.g().i(DecoderProbe.LOG_TAG, "ProbeDecEvent type:" + probeResultHolder.type + ",source:" + probeResultHolder.source + ",value=" + probeResultHolder.value);
                } catch (Throwable th5) {
                    try {
                        Logger.g().e(DecoderProbe.LOG_TAG, "\u89e3\u7801\u6d41\u7a0b\u5931\u8d25 " + th5);
                        long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
                        progressMum3.markFinishForce();
                        progressMum2.markFinishForce();
                        progressMum.markFinishForce();
                        ProbeResult probeResult = new ProbeResult();
                        probeResult.videoProfile = str2;
                        probeResult.statusCode = DecoderProbe.this.getErrorCode(th5);
                        probeResult.timeCostHwDecode = probeResultHolder.timeCost;
                        probeResult.timeCostSwDecode = probeResultHolder2.timeCost;
                        probeResult.timeCostTotal = uptimeMillis3;
                        probeResult.progress = progressMum5.getProgress();
                        DecoderProbe.writeStringAsFile("error decoding ,hwDecodeTimeCost=" + probeResultHolder.timeCost + ",swDecodeTimeCost=" + probeResultHolder2.timeCost + OskDebug.getPrintableStackTrace(th5), probeResultFile);
                        probeResultCallback.onProbeResult(probeResult);
                        DecodeProbe.getInstance().setHwProbeCallback(null);
                        DecodeProbe.getInstance().setSwProbeCallback(null);
                        z16 = false;
                    } catch (Throwable th6) {
                        DecodeProbe.getInstance().setHwProbeCallback(null);
                        DecodeProbe.getInstance().setSwProbeCallback(null);
                        throw th6;
                    }
                }
                if (hwProbe == 0) {
                    DecodeProbe.getInstance().setSwProbeCallback(new SoftwareDecodeProbe.SwProbeCallback() { // from class: com.tencent.oskplayer.contrib.decprobe.DecoderProbe.3.2
                        @Override // com.tencent.oskplayer.miscellaneous.SoftwareDecodeProbe.SwProbeCallback
                        public void onSwProbeOneFrame(int i28) {
                            ProbeResultHolder probeResultHolder4 = new ProbeResultHolder();
                            progressMum2.updateStep(i28);
                            probeResultHolder4.source = "sw";
                            probeResultHolder4.type = 1;
                            probeResultHolder4.value = i28;
                            Logger.g().i(DecoderProbe.LOG_TAG, "ProbeDecEvent type:" + probeResultHolder4.type + ",source:" + probeResultHolder4.source + ",value=" + probeResultHolder4.value);
                        }
                    });
                    long uptimeMillis4 = SystemClock.uptimeMillis();
                    int swProbe = DecodeProbe.getInstance().swProbe(str);
                    ProbeResultHolder probeResultHolder4 = probeResultHolder2;
                    probeResultHolder4.source = "sw";
                    probeResultHolder4.type = 2;
                    probeResultHolder4.value = swProbe;
                    probeResultHolder4.timeCost = SystemClock.uptimeMillis() - uptimeMillis4;
                    probeResultHolder2.avgDecFrameCost = DecodeProbe.getInstance().getSwDecodeAvgCost();
                    progressMum2.markFinishForce();
                    Logger.g().i(DecoderProbe.LOG_TAG, "ProbeDecEvent type:" + probeResultHolder2.type + ",source:" + probeResultHolder2.source + ",value=" + probeResultHolder2.value);
                    if (swProbe == 0) {
                        DecodeProbe.getInstance().setHwProbeCallback(null);
                        DecodeProbe.getInstance().setSwProbeCallback(null);
                        z16 = true;
                        String str10 = ",frameCount=";
                        String str11 = ",totalTimeCost=";
                        if (!z16) {
                            str7 = ",frameCount=";
                            str5 = ",totalTimeCost=";
                            str6 = ",hwDecodeTimeCost=";
                            i3 = 0;
                            i16 = 0;
                            z17 = false;
                            i17 = -1;
                            j3 = -1;
                        } else {
                            try {
                                File picOutDir = DecodeProbe.getInstance().getPicOutDir();
                                int[] iArr2 = DecoderProbe.sFrameSeq;
                                int length = iArr2.length;
                                int i28 = 0;
                                z17 = false;
                                int i29 = 0;
                                long j17 = -1;
                                int i36 = -1;
                                while (i28 < length) {
                                    try {
                                        int i37 = iArr2[i28];
                                        Locale locale = Locale.getDefault();
                                        int[] iArr3 = iArr2;
                                        Object[] objArr = new Object[i27];
                                        i3 = 0;
                                        try {
                                            objArr[0] = Integer.valueOf(i37);
                                            File file = new File(picOutDir, String.format(locale, "hw-%d.jpg", objArr));
                                            Locale locale2 = Locale.getDefault();
                                            int i38 = length;
                                            Object[] objArr2 = new Object[i27];
                                            objArr2[0] = Integer.valueOf(i37);
                                            File file2 = new File(picOutDir, String.format(locale2, "sw-%d.jpg", objArr2));
                                            BitmapHolder bitmapHolder3 = new BitmapHolder();
                                            bitmapHolder3.path = file.getAbsolutePath();
                                            bitmapHolder3.bitmap = null;
                                            BitmapHolder bitmapHolder4 = new BitmapHolder();
                                            bitmapHolder4.path = file2.getAbsolutePath();
                                            bitmapHolder4.bitmap = null;
                                            BitmapHolder[] bitmapHolderArr2 = new BitmapHolder[2];
                                            i3 = 0;
                                            bitmapHolderArr2[0] = bitmapHolder3;
                                            bitmapHolderArr2[i27] = bitmapHolder4;
                                            int i39 = 0;
                                            for (int i46 = 2; i39 < i46; i46 = 2) {
                                                BitmapHolder bitmapHolder5 = bitmapHolderArr2[i39];
                                                if (bitmapHolder5 != null && !TextUtils.isEmpty(bitmapHolder5.path)) {
                                                    File file3 = new File(bitmapHolder5.path);
                                                    if (file3.isFile() && file3.exists()) {
                                                        BitmapFactory.Options bitmapBounds = DecoderProbe.this.getBitmapBounds(bitmapHolder5.path);
                                                        bitmapHolder5.opts = bitmapBounds;
                                                        bitmapHolder5.bitmap = DecoderProbe.this.getBitmap(bitmapHolder5.path, bitmapBounds);
                                                    }
                                                }
                                                i39++;
                                            }
                                            for (int i47 = 0; i47 < 2; i47++) {
                                                BitmapHolder bitmapHolder6 = bitmapHolderArr2[i47];
                                                Bitmap bitmap = bitmapHolder6.bitmap;
                                                if (bitmap != null) {
                                                    bitmapHolder6.phash = ImageHash.getPHash(bitmap);
                                                }
                                            }
                                            for (int i48 = 0; i48 < 2; i48++) {
                                                BitmapHolder bitmapHolder7 = bitmapHolderArr2[i48];
                                                BitmapFactory.Options options = bitmapHolder7.opts;
                                                if (options != null) {
                                                    OskBitmap.calculateInSampleSizeLow(options);
                                                    BitmapFactory.Options options2 = bitmapHolder7.opts;
                                                    int i49 = options2.outWidth;
                                                    int i56 = options2.outHeight;
                                                    Long.toHexString(bitmapHolder7.phash);
                                                }
                                            }
                                            StringBuilder sb5 = new StringBuilder("Hamming Distance:");
                                            int i57 = i36;
                                            int i58 = 0;
                                            while (i58 < 2 && (i18 = i58 + 1) < 2) {
                                                try {
                                                    bitmapHolder = bitmapHolderArr2[i58];
                                                    bitmapHolder2 = bitmapHolderArr2[i18];
                                                    str3 = str10;
                                                    str4 = str11;
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    str3 = str10;
                                                    str4 = str11;
                                                }
                                                try {
                                                    long j18 = bitmapHolder.phash;
                                                    if (j18 != 0) {
                                                        bitmapHolderArr = bitmapHolderArr2;
                                                        long j19 = bitmapHolder2.phash;
                                                        if (j19 != 0) {
                                                            long hammingDistance = ImageHash.getHammingDistance(j18, j19);
                                                            sb5.append(hammingDistance);
                                                            if (hammingDistance > j17) {
                                                                j17 = hammingDistance;
                                                            }
                                                            if (i57 == -1) {
                                                                i57 = 0;
                                                            }
                                                            i17 = (int) (i57 + hammingDistance);
                                                            i16 = i29 + 1;
                                                            try {
                                                                progressMum3.updateStep(i16);
                                                                i57 = i17;
                                                                i29 = i16;
                                                                i58 += 2;
                                                                bitmapHolderArr2 = bitmapHolderArr;
                                                                str10 = str3;
                                                                str11 = str4;
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                j3 = j17;
                                                                Logger.g().e(DecoderProbe.LOG_TAG, "\u54c8\u5e0c\u8ba1\u7b97\u6d41\u7a0b\u5931\u8d25", e);
                                                                long uptimeMillis5 = SystemClock.uptimeMillis() - uptimeMillis;
                                                                progressMum3.markFinishForce();
                                                                ProbeResult probeResult2 = new ProbeResult();
                                                                probeResult2.videoProfile = str2;
                                                                probeResult2.statusCode = DecoderProbe.this.getErrorCode(e);
                                                                probeResult2.timeCostHwDecode = probeResultHolder.timeCost;
                                                                probeResult2.timeCostSwDecode = probeResultHolder2.timeCost;
                                                                probeResult2.timeCostTotal = uptimeMillis5;
                                                                probeResult2.progress = progressMum5.getProgress();
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append("error hashing maxDistance=");
                                                                sb6.append(j3);
                                                                sb6.append(",averageDistance=");
                                                                sb6.append(-1);
                                                                sb6.append(",totalDistance=");
                                                                sb6.append(i17);
                                                                sb6.append(",hwDecodeTimeCost=");
                                                                sb6.append(probeResultHolder.timeCost);
                                                                sb6.append(",swDecodeTimeCost=");
                                                                sb6.append(probeResultHolder2.timeCost);
                                                                str5 = str4;
                                                                sb6.append(str5);
                                                                str6 = ",hwDecodeTimeCost=";
                                                                sb6.append(SystemClock.uptimeMillis() - uptimeMillis);
                                                                str7 = str3;
                                                                sb6.append(str7);
                                                                sb6.append(i16);
                                                                sb6.append(OskDebug.getPrintableStackTrace(e));
                                                                DecoderProbe.writeStringAsFile(sb6.toString(), probeResultFile);
                                                                probeResultCallback.onProbeResult(probeResult2);
                                                                if (z17) {
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        bitmapHolderArr = bitmapHolderArr2;
                                                    }
                                                    sb5.append("unknown");
                                                    Logger.g().w(DecoderProbe.LOG_TAG, "hash_error occurred");
                                                    i58 += 2;
                                                    bitmapHolderArr2 = bitmapHolderArr;
                                                    str10 = str3;
                                                    str11 = str4;
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    i17 = i57;
                                                    i16 = i29;
                                                    j3 = j17;
                                                    Logger.g().e(DecoderProbe.LOG_TAG, "\u54c8\u5e0c\u8ba1\u7b97\u6d41\u7a0b\u5931\u8d25", e);
                                                    long uptimeMillis52 = SystemClock.uptimeMillis() - uptimeMillis;
                                                    progressMum3.markFinishForce();
                                                    ProbeResult probeResult22 = new ProbeResult();
                                                    probeResult22.videoProfile = str2;
                                                    probeResult22.statusCode = DecoderProbe.this.getErrorCode(e);
                                                    probeResult22.timeCostHwDecode = probeResultHolder.timeCost;
                                                    probeResult22.timeCostSwDecode = probeResultHolder2.timeCost;
                                                    probeResult22.timeCostTotal = uptimeMillis52;
                                                    probeResult22.progress = progressMum5.getProgress();
                                                    StringBuilder sb62 = new StringBuilder();
                                                    sb62.append("error hashing maxDistance=");
                                                    sb62.append(j3);
                                                    sb62.append(",averageDistance=");
                                                    sb62.append(-1);
                                                    sb62.append(",totalDistance=");
                                                    sb62.append(i17);
                                                    sb62.append(",hwDecodeTimeCost=");
                                                    sb62.append(probeResultHolder.timeCost);
                                                    sb62.append(",swDecodeTimeCost=");
                                                    sb62.append(probeResultHolder2.timeCost);
                                                    str5 = str4;
                                                    sb62.append(str5);
                                                    str6 = ",hwDecodeTimeCost=";
                                                    sb62.append(SystemClock.uptimeMillis() - uptimeMillis);
                                                    str7 = str3;
                                                    sb62.append(str7);
                                                    sb62.append(i16);
                                                    sb62.append(OskDebug.getPrintableStackTrace(e));
                                                    DecoderProbe.writeStringAsFile(sb62.toString(), probeResultFile);
                                                    probeResultCallback.onProbeResult(probeResult22);
                                                    if (z17) {
                                                    }
                                                }
                                            }
                                            String str12 = str10;
                                            String str13 = str11;
                                            Logger.g().i(DecoderProbe.LOG_TAG, sb5.toString());
                                            i28++;
                                            i36 = i57;
                                            iArr2 = iArr3;
                                            length = i38;
                                            str10 = str12;
                                            str11 = str13;
                                            i27 = 1;
                                            z17 = true;
                                        } catch (Exception e19) {
                                            e = e19;
                                            str3 = str10;
                                            str4 = str11;
                                            i16 = i29;
                                            j3 = j17;
                                            i17 = i36;
                                            Logger.g().e(DecoderProbe.LOG_TAG, "\u54c8\u5e0c\u8ba1\u7b97\u6d41\u7a0b\u5931\u8d25", e);
                                            long uptimeMillis522 = SystemClock.uptimeMillis() - uptimeMillis;
                                            progressMum3.markFinishForce();
                                            ProbeResult probeResult222 = new ProbeResult();
                                            probeResult222.videoProfile = str2;
                                            probeResult222.statusCode = DecoderProbe.this.getErrorCode(e);
                                            probeResult222.timeCostHwDecode = probeResultHolder.timeCost;
                                            probeResult222.timeCostSwDecode = probeResultHolder2.timeCost;
                                            probeResult222.timeCostTotal = uptimeMillis522;
                                            probeResult222.progress = progressMum5.getProgress();
                                            StringBuilder sb622 = new StringBuilder();
                                            sb622.append("error hashing maxDistance=");
                                            sb622.append(j3);
                                            sb622.append(",averageDistance=");
                                            sb622.append(-1);
                                            sb622.append(",totalDistance=");
                                            sb622.append(i17);
                                            sb622.append(",hwDecodeTimeCost=");
                                            sb622.append(probeResultHolder.timeCost);
                                            sb622.append(",swDecodeTimeCost=");
                                            sb622.append(probeResultHolder2.timeCost);
                                            str5 = str4;
                                            sb622.append(str5);
                                            str6 = ",hwDecodeTimeCost=";
                                            sb622.append(SystemClock.uptimeMillis() - uptimeMillis);
                                            str7 = str3;
                                            sb622.append(str7);
                                            sb622.append(i16);
                                            sb622.append(OskDebug.getPrintableStackTrace(e));
                                            DecoderProbe.writeStringAsFile(sb622.toString(), probeResultFile);
                                            probeResultCallback.onProbeResult(probeResult222);
                                            if (z17) {
                                            }
                                        }
                                    } catch (Exception e26) {
                                        e = e26;
                                        str3 = str10;
                                        str4 = str11;
                                        i3 = 0;
                                    }
                                }
                                i3 = 0;
                                str7 = str10;
                                str5 = str11;
                                str6 = ",hwDecodeTimeCost=";
                                i16 = i29;
                                j3 = j17;
                                i17 = i36;
                            } catch (Exception e27) {
                                e = e27;
                                str3 = ",frameCount=";
                                str4 = ",totalTimeCost=";
                                i3 = 0;
                                i16 = 0;
                                z17 = false;
                                i17 = -1;
                                j3 = -1;
                            }
                        }
                        if (z17) {
                            return;
                        }
                        String str14 = str7;
                        long uptimeMillis6 = SystemClock.uptimeMillis() - uptimeMillis;
                        if (i16 > 0) {
                            i26 = i17 / i16;
                            if (j3 == -1 || j3 > 4 || i26 > 2) {
                                str8 = str5;
                                i19 = ImageHashError.ERROR_LARGE_DISTANCE;
                                str9 = str6;
                                j16 = 0;
                            } else {
                                ProbeResultHolder probeResultHolder5 = probeResultHolder;
                                str8 = str5;
                                if (probeResultHolder5.avgDecFrameCost == 0) {
                                    probeResultHolder5.avgDecFrameCost = 1L;
                                }
                                long j26 = probeResultHolder5.avgDecFrameCost;
                                long j27 = j26 > 0 ? 1000 / j26 : 0L;
                                if (j26 > 33) {
                                    i19 = ImageHashError.ERROR_LOW_FPS;
                                    j16 = j27;
                                } else {
                                    j16 = j27;
                                    i19 = i3;
                                }
                                str9 = str6;
                            }
                        } else {
                            str8 = str5;
                            i19 = -2147483638;
                            str9 = str6;
                            j16 = 0;
                            i26 = -1;
                        }
                        int i59 = i16;
                        long j28 = probeResultHolder2.avgDecFrameCost;
                        long j29 = j28 > 0 ? 1000 / j28 : 0L;
                        ProbeResult probeResult3 = new ProbeResult();
                        probeResult3.videoProfile = str2;
                        probeResult3.statusCode = i19;
                        ProbeResultHolder probeResultHolder6 = probeResultHolder;
                        probeResult3.timeCostHwDecode = probeResultHolder6.timeCost;
                        probeResult3.fpsHwDec = j16;
                        probeResult3.avgHwDecFrameCost = probeResultHolder6.avgDecFrameCost;
                        ProbeResultHolder probeResultHolder7 = probeResultHolder2;
                        probeResult3.timeCostSwDecode = probeResultHolder7.timeCost;
                        probeResult3.fpsSwDec = j29;
                        probeResult3.avgSwDecFrameCost = probeResultHolder7.avgDecFrameCost;
                        probeResult3.timeCostTotal = uptimeMillis6;
                        probeResult3.progress = progressMum5.getProgress();
                        String str15 = "onCompleted videoProfile=" + str2 + ",maxDistance=" + j3 + ",averageDistance=" + i26 + ",totalDistance=" + i17 + str9 + probeResultHolder.timeCost + ",swDecodeTimeCost=" + probeResultHolder2.timeCost + str8 + (SystemClock.uptimeMillis() - uptimeMillis) + ",hwDecFrameFPS=" + j16 + ",hwDecFrameCostAvg=" + probeResult3.avgHwDecFrameCost + ",swDecFrameFPS=" + j29 + ",swDecFrameCostAvg=" + probeResult3.avgSwDecFrameCost + ",resultCode=" + i19 + str14 + i59;
                        Logger.g().i(DecoderProbe.LOG_TAG, str15);
                        DecoderProbe.writeStringAsFile(str15, probeResultFile);
                        probeResultCallback.onProbeResult(probeResult3);
                        return;
                    }
                    throw new ImageHashError(swProbe, "swProbe Error " + swProbe);
                }
                throw new ImageHashError(hwProbe, "hwProbe Error " + hwProbe);
            }
        });
    }
}
