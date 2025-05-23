package com.tencent.mobileqq.shortvideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.annotation.RequiresApi;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.a;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.ShortVideoForPicThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.util.VersionUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoUtils implements ShortVideoConstants {
    private static final int CLEAN_TEMP_FILE_INTERVAL = 604800000;
    private static String[] FULL_SCREEN_BLACK_LIST = null;
    public static final int MERGE_TIPS_SHOW_TIME = 3;
    public static final int MSG_SAVE_DISMISS = 10003;
    public static final int MSG_SAVE_FAILED = 10001;
    public static final int MSG_SAVE_SUCCESS = 10000;
    public static final String SHORT_VIDEO_AE_CAMERA_TAKE_SAME_SWITCH = "short_video_ae_pitu_takesame_switch";
    public static final String SHORT_VIDEO_AIO_RED_DOT_SHOWED = "short_video_red_dot_showed";
    public static final String SHORT_VIDEO_AIO_TIPS_SHOWED = "short_video_tips_showed";
    public static final String SHORT_VIDEO_AND_HOT_PIC_CONFIG_SP = "ptv_and_hot_pic_reddot_sp";
    public static final String SHORT_VIDEO_HOT_PIC_CONFIG_PIC_VERSION = "short_video_hotpic_pic_version_";
    public static final String SHORT_VIDEO_HOT_PIC_CONFIG_PTV_VERSION = "short_video_hotpic_ptv_version_";
    public static final String SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PIC = "short_video_hotpic_show_pic_";
    public static final String SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PTV = "short_video_hotpic_show_ptv_";
    public static final String SHORT_VIDEO_PHOTO_MORE_FILTER = "short_video_photo_more_filter";
    public static final String T2 = "0X8008E50";
    public static final String T3 = "0X8008E51";
    public static final String T5 = "0X8008E53";
    public static final String TAG = "ShortVideoUtils";
    public static final int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;
    private static volatile boolean mSoLoadState = false;
    private static boolean sDarkModeInited = false;
    public static boolean sPredownloadShortVideoInited = false;
    private static boolean sShutdownSkipClipPhoto = false;
    private static boolean sShutdownSkipClipPhotoInited = false;
    private static boolean sSupportPhotoMergeInited = false;
    public static boolean sSupportShortVideo = true;
    private static Boolean sVideoEmoticonAllowAutoDownloadInMobileNetwork;
    private static AtomicInteger mDefaultShortVideoPreDownloadStrategy = new AtomicInteger(0);
    private static int mDefaultShortVideoPreDownloadTime = 2;
    private static int mSupportPhotoMerge = 1;
    private static int[] sDarkModeValues = {1, 97, 125};
    public static boolean isPtvConfiginitied = false;
    public static boolean isHotPicConfiginitied = false;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class ShortVideoPlayConfig {
        private static final String TAG = "ShortVideo.ShortVideoPlayConfig";
        public static boolean sAutoPlayInAIO = true;
        public static boolean sReadFromDPC = false;
        public static int sRequestedFPS = 18;

        public static void initConfig() {
            String[] split;
            if (!sReadFromDPC) {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.ShortVideoPlayInAIO.name(), null);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initConfig(), videoPlayConfig=" + featureValue);
                }
                if (!TextUtils.isEmpty(featureValue) && (split = featureValue.split("\\|")) != null && split.length >= 2) {
                    if (!TextUtils.isEmpty(split[0])) {
                        sAutoPlayInAIO = split[0].equals("1");
                    }
                    if (!TextUtils.isEmpty(split[1])) {
                        try {
                            sRequestedFPS = Integer.parseInt(split[1]);
                        } catch (Exception unused) {
                            sRequestedFPS = 18;
                        }
                    }
                    sReadFromDPC = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initVideoPlayConfig(), sReadFromDPC=" + sReadFromDPC + ", sAutoPlayInAIO:" + sAutoPlayInAIO + ", sRequestedFPS:" + sRequestedFPS);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class VideoFileSaveRunnable implements Runnable {
        public static final int MSG_TYPE_SAVE_EXITS = 3;
        public static final int MSG_TYPE_SAVE_FAILURE = 1;
        public static final int MSG_TYPE_SAVE_SUCCESS = 2;
        MqqHandler mHandler;
        boolean mNeedReplace;
        String mUniqueName;
        String mVideoPath;
        boolean mbKeepUniqueName = false;

        public VideoFileSaveRunnable(String str, MqqHandler mqqHandler, String str2, boolean z16) {
            this.mVideoPath = str;
            this.mHandler = mqqHandler;
            this.mUniqueName = str2;
            this.mNeedReplace = z16;
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            File file;
            String shortVideoSaveFileName;
            FileInputStream fileInputStream;
            if (!TextUtils.isEmpty(this.mVideoPath) && FileUtils.fileExists(this.mVideoPath)) {
                File file2 = new File(this.mVideoPath);
                if (VersionUtils.isrFroyo()) {
                    file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
                } else {
                    file = new File(AppConstants.SDCARD_VIDEO);
                }
                file.mkdirs();
                if (this.mbKeepUniqueName) {
                    shortVideoSaveFileName = this.mUniqueName;
                } else {
                    shortVideoSaveFileName = ShortVideoUtils.getShortVideoSaveFileName(this.mUniqueName);
                }
                File file3 = new File(file, shortVideoSaveFileName);
                if (!this.mNeedReplace && file3.exists()) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.mVideoPath));
                    return;
                }
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                    try {
                        fileInputStream = new FileInputStream(file2);
                        try {
                            byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                                fileOutputStream2.flush();
                            }
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, file3.getAbsolutePath()));
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        } catch (Exception e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            try {
                                if (QLog.isColorLevel()) {
                                    QLog.e(ShortVideoUtils.TAG, 2, "save file failue", e);
                                }
                                this.mHandler.sendEmptyMessage(1);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (fileInputStream == null) {
                                    return;
                                }
                                fileInputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (fileInputStream == null) {
                                    try {
                                        fileInputStream.close();
                                        throw th;
                                    } catch (IOException unused4) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                            }
                            if (fileInputStream == null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        fileInputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = null;
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    fileInputStream = null;
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e(ShortVideoUtils.TAG, 2, "save file failue, mVideoPath=" + this.mVideoPath);
                }
                this.mHandler.sendEmptyMessage(1);
            }
        }

        public void setKeepUniqueName(boolean z16) {
            this.mbKeepUniqueName = z16;
        }
    }

    static {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "GIFEngine");
                    ShortVideoUtils.mSoLoadState = true;
                } catch (UnsatisfiedLinkError e16) {
                    e16.printStackTrace();
                    ShortVideoUtils.mSoLoadState = false;
                }
            }
        }, 64, null, false);
        FULL_SCREEN_BLACK_LIST = new String[]{QzoneConfig.QZONE_FACADE_DYNAMIC_DEFAULT_BLACK_LIST};
    }

    public static native int adjustMoovPosition(String str, String str2);

    public static int[] adjustSize(int i3, int i16) {
        int i17;
        boolean z16;
        String str;
        int i18;
        String str2;
        int i19;
        int i26;
        String str3;
        int f16;
        int i27 = 100;
        if (i3 > 0) {
            i17 = i3;
        } else {
            i17 = 100;
        }
        if (i16 > 0) {
            i27 = i16;
        }
        int i28 = (int) (BaseChatItemLayout.N + 0.5d);
        int videoThumbMaxDp = URLDrawableHelper.getVideoThumbMaxDp();
        if (videoThumbMaxDp >= 135 && (f16 = BaseAIOUtils.f(videoThumbMaxDp, BaseApplicationImpl.getApplication().getResources())) < i28) {
            i28 = f16;
        }
        int f17 = BaseAIOUtils.f(305.0f, BaseApplicationImpl.getApplication().getResources());
        if (i28 > f17) {
            i28 = f17;
        }
        if (i17 >= i27) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            float f18 = i17 / i27;
            if (f18 > 1.5555556f) {
                i26 = (int) (((i28 * 9.0f) / 16.0f) + 0.5d);
                str3 = "landscape close to 16:9";
            } else if (f18 > 1.1666667f) {
                i26 = (int) (((i28 * 3.0f) / 4.0f) + 0.5d);
                str3 = "landscape close to 4:3";
            } else {
                str = "landscape close to 1:1";
                str2 = str;
                i18 = i28;
                i19 = i18;
            }
            str2 = str3;
            i19 = i26;
            i18 = i28;
        } else if (i27 / i17 > 1.3f) {
            i18 = (int) (((i28 * 10.0f) / 16.0f) + 0.5d);
            str2 = "portrait close to 10:16";
            i19 = i28;
        } else {
            str = "portrait close to 1:1";
            str2 = str;
            i18 = i28;
            i19 = i18;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "adjustSize " + str2 + " maxPixel:" + i28 + " ow:" + i3 + " oh:" + i16 + " w:" + i18 + " h:" + i19);
        }
        return new int[]{i18, i19};
    }

    public static int[] calculateScaledThumbWH(Bitmap bitmap) {
        if (bitmap == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "calculateThumbWH, bitmap == null \uff01");
            }
            return null;
        }
        if (bitmap.isRecycled()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "calculateThumbWH, bitmap isRecycled !");
            }
            return null;
        }
        return calculateScaledThumbWH(new int[]{bitmap.getWidth(), bitmap.getHeight()});
    }

    public static boolean canRecordShortVideo() {
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + featureValue);
        }
        String[] split = featureValue.split("\\|");
        if (split.length < 3) {
            return false;
        }
        return split[2].equals("1");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0013. Please report as an issue. */
    public static boolean checkEntranceType(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5 && i3 != 122) {
            switch (i3) {
                default:
                    switch (i3) {
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            return false;
                    }
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    return true;
            }
        }
        return true;
    }

    public static boolean checkShortVideoSoReadyToLoad() {
        try {
            if (VideoEnvironment.supportShortVideoRecordAndPlay()) {
                if (isVideoSoLibLoaded()) {
                    return true;
                }
                return VideoEnvironment.checkShortVideoSoReadyToLoad();
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "checkShortVideoSoReadyToLoad failure.", e16);
                return false;
            }
            return false;
        }
    }

    public static void deleteCacheFileByMsg(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return;
        }
        if (TextUtils.isEmpty(messageForShortVideo.getMd5())) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "deleteCacheFileByMessage, md5 == null! ");
                return;
            }
            return;
        }
        FileUtils.deleteFile(j.j(messageForShortVideo, "mp4"));
    }

    public static void deleteDownloadTempFile() {
        deleteDownloadTempFile("", false);
    }

    public static boolean ensureShortVideoSoLoaded(AppInterface appInterface) {
        if (isVideoSoLibLoaded()) {
            return true;
        }
        loadShortVideoSo(appInterface);
        if (isVideoSoLibLoaded()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static String findVideoPathIfExists(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return null;
        }
        String j3 = j.j(messageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(j3)) {
            return j3;
        }
        if (messageForShortVideo.isSendFromLocal()) {
            String str = messageForShortVideo.videoFileName;
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                return str;
            }
        }
        return null;
    }

    public static String getCameraPath() {
        String str;
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (upperCase.contains("GN9000L")) {
            str = AppConstants.SDCARD_ROOT + HardCodeUtil.qqStr(R.string.jno);
        } else if (!upperCase.contains("MX4") && !upperCase.contains("MX6") && !upperCase.contains("MX5") && !upperCase.contains("M355") && !upperCase.contains("M571C")) {
            if (upperCase.contains("M040")) {
                str = AppConstants.SDCARD_IMG_VIDEO_RUBBISH_MX040;
            } else if (!upperCase.contains("VIVO X7") && !upperCase.contains("VIVO X6A") && !upperCase.contains("VIVO XPLAY6") && !upperCase.contains("VIVO X5PRO") && !upperCase.contains("VIVO X9 PLUS") && !upperCase.contains("VIVO Y51A") && !upperCase.contains("VIVO X9I") && !upperCase.contains("VIVO X9") && !upperCase.contains("VIVO X6D")) {
                str = AppConstants.SDCARD_IMG_CAMERA;
            } else {
                str = AppConstants.SDCARD_ROOT + HardCodeUtil.qqStr(R.string.jnp);
            }
        } else {
            str = AppConstants.SDCARD_IMG_VIDEO;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCameraPath: commonPath=" + str);
        }
        return str;
    }

    public static int[] getDarkModeDPCValues() {
        return sDarkModeValues;
    }

    public static AtomicInteger getDefaultShortVideoStrategy() {
        if (!sPredownloadShortVideoInited) {
            initPredownloadParam();
            sPredownloadShortVideoInited = true;
        }
        return mDefaultShortVideoPreDownloadStrategy;
    }

    public static int getDisplayProgress(int i3, int i16) {
        if (i3 <= 0) {
            return i16;
        }
        if (i3 >= 100) {
            return 100;
        }
        return (int) (((i3 * (100 - i16)) / 100.0f) + i16);
    }

    public static String getDownloadTmpPath(MessageForShortVideo messageForShortVideo) {
        return j.j(messageForShortVideo, "mp4") + "." + MD5.toMD5(messageForShortVideo.uuid) + ".tmp";
    }

    public static long getDuration(String str) {
        long j3 = -1;
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Path:" + str + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(str);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    @TargetApi(14)
    public static long getDurationOfVideo(String str) {
        if (!FileUtils.fileExists(str)) {
            return 0L;
        }
        return VideoCompositeHelper.j(str);
    }

    public static int getHotPiCRedDotConfigVersion(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(SHORT_VIDEO_HOT_PIC_CONFIG_PIC_VERSION + str, 0);
    }

    public static boolean getHotPicRedDotStatus(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PIC + str, false);
    }

    public static String getLocalShortVideoPath() {
        String cameraPath = getCameraPath();
        StringBuilder sb5 = new StringBuilder(cameraPath);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        while (true) {
            sb5.append(VidUtil.generateVid());
            sb5.append(".mp4");
            if (!new File(sb5.toString()).exists()) {
                return sb5.toString();
            }
            sb5 = new StringBuilder(cameraPath);
        }
    }

    public static String getMergeVideoPath(File file) {
        if (file == null) {
            return null;
        }
        return vc0.a.f441365e + VidUtil.getVidFromSourceDirFile(file) + ".mp4";
    }

    public static String getNetTypeStr(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "Others";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }
        return Global.TRACKING_WIFI;
    }

    public static int getPreDownloadTime() {
        if (!sPredownloadShortVideoInited) {
            initPredownloadParam();
            sPredownloadShortVideoInited = true;
        }
        return mDefaultShortVideoPreDownloadTime;
    }

    public static int getPtvRedDotConfigVersion(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(SHORT_VIDEO_HOT_PIC_CONFIG_PTV_VERSION + str, 0);
    }

    public static boolean getPtvRedDotStatus(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PTV + str, false);
    }

    public static String getRecentPOI(String str) {
        if (!TextUtils.isEmpty(str)) {
            return null;
        }
        return getSharedPref(ShortVideoConstants.SP_USER_CACHE_DATA).getString("recent_poi_" + str, null);
    }

    public static SharedPreferences getSharedPref(String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + MobileQQ.sProcessId, 0);
    }

    @TargetApi(9)
    public static String getShortVideoCompressPath(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String md5 = MD5.toMD5(str);
            StringBuilder sb5 = new StringBuilder(j.e());
            sb5.append("shortvideo");
            sb5.append(File.separator);
            sb5.append(md5);
            sb5.append(".");
            sb5.append(str2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getShortVideoCompressPath: sourcePath=" + str + "/n compressPath=" + sb5.toString());
            }
            return sb5.toString();
        }
        return null;
    }

    public static String getShortVideoPath(String str, String str2) {
        return j.h() + str + "." + str2;
    }

    @TargetApi(9)
    public static String getShortVideoRawCompressPath(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String md5 = MD5.toMD5(str);
            StringBuilder sb5 = new StringBuilder(j.e());
            sb5.append("shortvideo");
            sb5.append(File.separator);
            sb5.append(md5);
            sb5.append("_raw");
            sb5.append(".");
            sb5.append(str2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getShortVideoCompressPath: sourcePath=" + str + "/n compressPath=" + sb5.toString());
            }
            return sb5.toString();
        }
        return null;
    }

    public static String getShortVideoSaveFileName(String str) {
        return "QQ\u89c6\u9891_" + str;
    }

    public static String getTempAudioPath(File file) {
        if (file == null) {
            return null;
        }
        String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(file);
        StringBuilder sb5 = new StringBuilder(j.e());
        sb5.append("shortvideo");
        String str = File.separator;
        sb5.append(str);
        sb5.append(FaceUtil.IMG_TEMP);
        sb5.append(str);
        sb5.append("audio");
        sb5.append(str);
        sb5.append(vidFromSourceDirFile);
        sb5.append(".mp4");
        return sb5.toString();
    }

    public static String getTempVideoPath(File file) {
        if (file == null) {
            return null;
        }
        String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(file);
        StringBuilder sb5 = new StringBuilder(j.e());
        sb5.append("shortvideo");
        String str = File.separator;
        sb5.append(str);
        sb5.append(FaceUtil.IMG_TEMP);
        sb5.append(str);
        sb5.append("source");
        sb5.append(str);
        sb5.append(vidFromSourceDirFile);
        sb5.append(".mp4");
        return sb5.toString();
    }

    public static URL getThumbPicUrl(String str) {
        try {
            return new URL(ShortVideoForPicThumbDownloader.PROTOCOL_SHORT_VIDEO_FOR_PIC_THUMB, (String) null, str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static URL getThumbUrl(String str) {
        try {
            return new URL(ShortVideoThumbDownloader.PROTOCOL_SHORT_VIDEO_THUMB, (String) null, str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int[] getVideoFileRtAndTime(String str) {
        int[] iArr = {0, 0, 0};
        if (VersionUtils.isIceScreamSandwich()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
                    iArr[0] = Integer.valueOf(extractMetadata).intValue();
                    iArr[1] = Integer.valueOf(extractMetadata2).intValue();
                    iArr[2] = Math.round(Integer.valueOf(extractMetadata3).intValue() / 1000.0f);
                    if (!TextUtils.isEmpty(extractMetadata4)) {
                        int parseInt = Integer.parseInt(extractMetadata4);
                        if (parseInt == 90 || parseInt == 270) {
                            int i3 = iArr[0];
                            iArr[0] = iArr[1];
                            iArr[1] = i3;
                        }
                    } else {
                        iArr[0] = 0;
                        iArr[1] = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_FILE_VIDEO, 2, "getVideoResolution: w=" + iArr[0] + ", h=" + iArr[1] + ", dr=" + iArr[2] + ", rt=" + extractMetadata4 + ", p=" + str);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_TROOP_FILE_VIDEO, 2, "getVideoResolution exp", e16);
                    }
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return iArr;
    }

    public static String getVideoOutputPath(String str) {
        if (str == null) {
            return null;
        }
        try {
            return getShortVideoPath(new File(str).getParentFile());
        } catch (Exception e16) {
            QZLog.i(TAG, 1, "get target path error encode error", e16);
            return null;
        }
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str) {
        return getVideoThumbnail(context, str, 640);
    }

    public static String getVideoTmpPath(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return "";
        }
        if (messageForShortVideo.isSendFromLocal()) {
            if (messageForShortVideo.sendRawVideo) {
                return getShortVideoRawCompressPath(messageForShortVideo.videoFileName, "tmp");
            }
            return getShortVideoCompressPath(messageForShortVideo.videoFileName, "tmp");
        }
        return getDownloadTmpPath(messageForShortVideo);
    }

    private static void initPredownloadParam() {
        try {
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), IDPCApiConstant.AIO_PREDOWNLOAD_SHORTVIDEO);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDefaultShortVideoStrategy:" + featureValue);
            }
            String[] split = featureValue.split("\\|");
            if (split.length > 6) {
                String[] split2 = split[6].split("_");
                if (split2.length >= 2) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    if (intValue >= 0 && intValue <= 2) {
                        mDefaultShortVideoPreDownloadStrategy = new AtomicInteger(intValue);
                    }
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (intValue2 >= 0 && intValue2 <= 60) {
                        mDefaultShortVideoPreDownloadTime = intValue2;
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "needBlockBrokenVideo e:" + e16.toString());
            }
        }
    }

    public static boolean isAEPituTakeSameOpen() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(SHORT_VIDEO_AE_CAMERA_TAKE_SAME_SWITCH, false);
    }

    public static boolean isAllowAutoDownloadVideoEmoticon(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.w(TAG, 2, "isAllowAutoDownloadVideoEmoticon return, appRuntime is null!");
            return false;
        }
        if (NetworkUtil.isWifiConnected(appRuntime.getApplicationContext())) {
            return true;
        }
        Boolean bool = sVideoEmoticonAllowAutoDownloadInMobileNetwork;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("video_emoticon_use_pic_auto_download_strategy_869817969")) {
            sVideoEmoticonAllowAutoDownloadInMobileNetwork = Boolean.TRUE;
        } else {
            sVideoEmoticonAllowAutoDownloadInMobileNetwork = Boolean.FALSE;
        }
        QLog.d(TAG, 1, "[isAllowAutoDownloadVideoEmoticon] sVideoEmoticonAllowAutoDownloadInMobileNetwork=", sVideoEmoticonAllowAutoDownloadInMobileNetwork);
        return sVideoEmoticonAllowAutoDownloadInMobileNetwork.booleanValue();
    }

    @RequiresApi(api = 16)
    public static boolean isDeviceSupportEncodeH265Video() {
        boolean isHardwareAccelerated;
        if (!QzoneConfig.isWinkPublishEnableHevc()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] not enable hevc");
            }
            return false;
        }
        String winkPublishHevcBlacklist = QzoneConfig.getWinkPublishHevcBlacklist();
        if (winkPublishHevcBlacklist.contains(DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] in blacklist, model=" + DeviceInfoMonitor.getModel() + ", blacklist=" + winkPublishHevcBlacklist);
            }
            return false;
        }
        int winkPublishHevcOsVersion = QzoneConfig.getWinkPublishHevcOsVersion();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < winkPublishHevcOsVersion) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] OS Version limited, " + i3 + " < " + winkPublishHevcOsVersion);
            }
            return false;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i16 = 0; i16 < codecCount; i16++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i16);
            String name = codecInfoAt.getName();
            if (codecInfoAt.isEncoder() && (name.contains("hevc") || name.contains("HEVC"))) {
                if (Build.VERSION.SDK_INT >= 29) {
                    isHardwareAccelerated = codecInfoAt.isHardwareAccelerated();
                    if (isHardwareAccelerated) {
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] encoder not hardware accelerated");
                    }
                } else {
                    return true;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[H265_VIDEO]", "[isSupportEncodeH265Video] no hevc encoder codec");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r1 = r2.equalsIgnoreCase("video/hevc");
     */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isH265FormatShortVideo(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        boolean z16 = false;
        try {
            try {
                mediaExtractor.setDataSource(str);
                int i3 = 0;
                while (true) {
                    if (i3 >= mediaExtractor.getTrackCount()) {
                        break;
                    }
                    String string = mediaExtractor.getTrackFormat(i3).getString("mime");
                    if (string.startsWith("video/")) {
                        break;
                    }
                    i3++;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "isH265FormatShortVideo e:", e16);
                }
            }
            return z16;
        } finally {
            mediaExtractor.release();
        }
    }

    public static boolean isInFullScreenBlackList() {
        boolean z16 = false;
        for (String str : FULL_SCREEN_BLACK_LIST) {
            if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isInFullScreenBlackList(), result=" + z16);
        }
        return z16;
    }

    public static boolean isSkipClipShutDown() {
        if (!sShutdownSkipClipPhotoInited) {
            sShutdownSkipClipPhotoInited = true;
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isSkipClipShutDown:" + featureValue);
                }
                String[] split = featureValue.split("\\|");
                if (split.length > 16) {
                    sShutdownSkipClipPhoto = split[16].equals("1");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isSkipClipShutDown e:" + e16.toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSkipClipShutDown sShutdownSkipClipPhoto " + sShutdownSkipClipPhoto);
        }
        return sShutdownSkipClipPhoto;
    }

    public static boolean isSupportProgressive(File file) {
        int i3;
        boolean z16 = false;
        if (file != null && file.exists() && file.isFile()) {
            long currentTimeMillis = System.currentTimeMillis();
            String d16 = j.d(file);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isSupportProgressive(), moovInfoStr: " + d16 + ", filePath:" + file.getAbsolutePath());
            }
            if (!TextUtils.isEmpty(d16)) {
                String[] split = d16.split("\\|");
                if (!TextUtils.isEmpty(split[0])) {
                    try {
                        i3 = Integer.parseInt(split[0]);
                    } catch (Exception unused) {
                        i3 = -1;
                    }
                    if (i3 > 0) {
                        float length = i3 / ((float) file.length());
                        if (length > 0.0f && length < 0.5f) {
                            z16 = true;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "isSupportProgressive(), ratio: " + length + ", result: " + z16 + ", cost:" + currentTimeMillis2);
                        }
                    }
                }
            }
        }
        return z16;
    }

    public static boolean isVideoExist(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return false;
        }
        if (FileUtils.fileExistsAndNotEmpty(j.j(messageForShortVideo, "mp4"))) {
            return true;
        }
        if (!messageForShortVideo.isSendFromLocal() || !FileUtils.fileExistsAndNotEmpty(messageForShortVideo.videoFileName)) {
            return false;
        }
        return true;
    }

    public static boolean isVideoSoLibLoaded() {
        return VideoEnvironment.isShortVideoSoLibLoaded();
    }

    public static void loadShortVideoSo(AppInterface appInterface) {
        try {
            if (VideoEnvironment.supportShortVideoRecordAndPlay()) {
                VideoEnvironment.loadAVCodecSo();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Load libAVCodec.so failure", th5);
            }
        }
    }

    public static boolean moveMoovAtom(String str, String str2) {
        if (TextUtils.isEmpty(str) || !mSoLoadState || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "moveMoovAtom() srcFilePath = " + str + " , desFilePath = " + str2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = str2 + ".tmp";
        int adjustMoovPosition = adjustMoovPosition(str, str3);
        if (adjustMoovPosition != 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "moveMoovAtom() adjust fail, ret = " + adjustMoovPosition);
            }
            return false;
        }
        if (!FileUtils.rename(str3, str2)) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "moveMoovAtom() rename fail");
            }
            return false;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "moveMoovAtom() success, cost = " + currentTimeMillis2 + "ms");
            return true;
        }
        return true;
    }

    public static boolean needTwoEntrance() {
        boolean supportShortVideoMergePhoto = supportShortVideoMergePhoto();
        boolean k3 = com.tencent.mobileqq.camera.utils.a.k();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "supportShortVideoMergePhoto dpc:" + mSupportPhotoMerge + " choiceQC:" + k3);
        }
        if (!supportShortVideoMergePhoto) {
            return true;
        }
        return !k3;
    }

    public static String realGetShortVideoSavePath(String str, String str2, long j3, String str3) {
        return j.g(str) + str2 + Math.abs(j3) + "." + str3;
    }

    public static void recordClickTimes(String str) {
        int decodeInt = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(str + "aio_short_video_click_times", 0);
        if (decodeInt <= 3) {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(str + "aio_short_video_click_times", decodeInt + 1);
        }
    }

    public static void reportAIOVideoPlayError(MessageForShortVideo messageForShortVideo, int i3, String str) {
        if (messageForShortVideo == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "reportAIOVideoPlayError error, invalid params!");
            }
        } else {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_busiType", String.valueOf(messageForShortVideo.busiType));
            hashMap.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format"));
            hashMap.put("param_FailCode", String.valueOf(i3));
            hashMap.put(ReportConstant.KEY_ERR_DESC, str);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHORTVIDEO_PLAY, false, 0L, 0L, hashMap, "");
        }
    }

    public static void reportAIOVideoPlaySuccess(AppInterface appInterface, MessageForShortVideo messageForShortVideo) {
        if (appInterface != null && messageForShortVideo != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_busiType", String.valueOf(messageForShortVideo.busiType));
            hashMap.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format"));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SHORTVIDEO_PLAY, true, 0L, 0L, hashMap, "");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "reportAIOVideoPlaySuccess error, invalid params!");
        }
    }

    public static void reportCancelSendVideo(String str, int i3) {
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 2;
            } else if (i3 == 3000) {
                i16 = 3;
            } else {
                i16 = 4;
            }
        }
        ReportController.o(null, "dc00898", "", "", str, str, i16, 0, "", "", "", "");
    }

    public static void reportVideoPlay(String str, String str2, String str3, int i3, String str4, String str5) {
        a.C8615a c8615a = new a.C8615a();
        c8615a.f289936a = str3;
        c8615a.f289937b = T5;
        if (i3 == 0) {
            c8615a.f289939d = "1";
        } else if (i3 == 1) {
            c8615a.f289939d = "2";
        } else if (i3 == 3000) {
            c8615a.f289939d = "3";
        }
        c8615a.f289938c = "2";
        c8615a.f289940e = str4;
        c8615a.f289941f = str5;
        com.tencent.mobileqq.statistics.a.b(str, "dc01178", str2, c8615a);
    }

    public static void reportVideoPlayEvent(QQAppInterface qQAppInterface, int i3, String str, int i16, int i17, long j3, long j16) {
        long j17;
        int i18;
        String str2;
        int i19;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1025 && i3 != 7400 && i3 != 10004 && i3 != 10008 && i3 != 10010) {
                    switch (i3) {
                        default:
                            switch (i3) {
                                case 1020:
                                case 1021:
                                case 1022:
                                case 1023:
                                    break;
                                default:
                                    i19 = 4;
                                    break;
                            }
                        case 1003:
                        case 1004:
                        case 1005:
                        case 1006:
                            i19 = 3;
                            break;
                    }
                    j17 = j3;
                    i18 = i19;
                }
                i19 = 3;
                j17 = j3;
                i18 = i19;
            } else {
                j17 = j3;
                i18 = 2;
            }
        } else {
            j17 = j3;
            i18 = 1;
        }
        String format = String.format("%.2f", Double.valueOf(j17 / 1000.0d));
        String format2 = String.format("%.2f", Double.valueOf(j16 / 1000.0d));
        String valueOf = String.valueOf(i16);
        String valueOf2 = String.valueOf(i17);
        String str3 = format + ";" + format2;
        if (i18 == 2) {
            str2 = str;
        } else {
            str2 = "";
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "0X8009AA6", "0X8009AA6", i18, 0, valueOf, valueOf2, str3, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ea, code lost:
    
        r1 = (int) ((r10 * (r5 / r9)) + 0.5f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f1, code lost:
    
        if (r1 <= r8) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f3, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f5, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4 A[Catch: OutOfMemoryError -> 0x0126, TryCatch #0 {OutOfMemoryError -> 0x0126, blocks: (B:3:0x0004, B:5:0x0037, B:6:0x0073, B:8:0x0098, B:9:0x00a0, B:11:0x00ae, B:19:0x00c9, B:20:0x0104, B:25:0x00d4, B:26:0x00d9, B:28:0x00dc, B:29:0x00de, B:30:0x00e3, B:31:0x00e0, B:32:0x00d7, B:34:0x00ea, B:39:0x00f7, B:43:0x00b0, B:45:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc A[Catch: OutOfMemoryError -> 0x0126, TryCatch #0 {OutOfMemoryError -> 0x0126, blocks: (B:3:0x0004, B:5:0x0037, B:6:0x0073, B:8:0x0098, B:9:0x00a0, B:11:0x00ae, B:19:0x00c9, B:20:0x0104, B:25:0x00d4, B:26:0x00d9, B:28:0x00dc, B:29:0x00de, B:30:0x00e3, B:31:0x00e0, B:32:0x00d7, B:34:0x00ea, B:39:0x00f7, B:43:0x00b0, B:45:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0 A[Catch: OutOfMemoryError -> 0x0126, TryCatch #0 {OutOfMemoryError -> 0x0126, blocks: (B:3:0x0004, B:5:0x0037, B:6:0x0073, B:8:0x0098, B:9:0x00a0, B:11:0x00ae, B:19:0x00c9, B:20:0x0104, B:25:0x00d4, B:26:0x00d9, B:28:0x00dc, B:29:0x00de, B:30:0x00e3, B:31:0x00e0, B:32:0x00d7, B:34:0x00ea, B:39:0x00f7, B:43:0x00b0, B:45:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7 A[Catch: OutOfMemoryError -> 0x0126, TryCatch #0 {OutOfMemoryError -> 0x0126, blocks: (B:3:0x0004, B:5:0x0037, B:6:0x0073, B:8:0x0098, B:9:0x00a0, B:11:0x00ae, B:19:0x00c9, B:20:0x0104, B:25:0x00d4, B:26:0x00d9, B:28:0x00dc, B:29:0x00de, B:30:0x00e3, B:31:0x00e0, B:32:0x00d7, B:34:0x00ea, B:39:0x00f7, B:43:0x00b0, B:45:0x00b6), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RoundRectBitmap resizeAndClipBitmap(Bitmap bitmap, DownloadParams downloadParams, ThumbWidthHeightDP thumbWidthHeightDP, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        float f16;
        float f17;
        float f18;
        float f19;
        try {
            float f26 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
            int i19 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
            float roundCorner = URLDrawableHelper.getRoundCorner() * f26;
            int imgThumbMinPx = CommonImgThumbHelper.getImgThumbMinPx(z16);
            int imgThumbMinPx2 = CommonImgThumbHelper.getImgThumbMinPx(z16);
            int imgThumbMaxPx = CommonImgThumbHelper.getImgThumbMaxPx(z16);
            int imgThumbMaxPx2 = CommonImgThumbHelper.getImgThumbMaxPx(z16);
            if (thumbWidthHeightDP != null) {
                imgThumbMinPx = BaseAIOUtils.f(thumbWidthHeightDP.mMinWidth, BaseApplicationImpl.getApplication().getResources());
                imgThumbMinPx2 = BaseAIOUtils.f(thumbWidthHeightDP.mMinHeight, BaseApplicationImpl.getApplication().getResources());
                imgThumbMaxPx = BaseAIOUtils.f(thumbWidthHeightDP.mMaxWidth, BaseApplicationImpl.getApplication().getResources());
                imgThumbMaxPx2 = BaseAIOUtils.f(thumbWidthHeightDP.mMaxHeight, BaseApplicationImpl.getApplication().getResources());
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            int imgThumbMinDp = CommonImgThumbHelper.getImgThumbMinDp(z16);
            int imgThumbMinDp2 = CommonImgThumbHelper.getImgThumbMinDp(z16);
            int imgThumbMaxDp = CommonImgThumbHelper.getImgThumbMaxDp(z16);
            int imgThumbMaxDp2 = CommonImgThumbHelper.getImgThumbMaxDp(z16);
            if (thumbWidthHeightDP != null) {
                imgThumbMinDp = thumbWidthHeightDP.mMinWidth;
                imgThumbMinDp2 = thumbWidthHeightDP.mMinHeight;
                imgThumbMaxDp = thumbWidthHeightDP.mMaxWidth;
                imgThumbMaxDp2 = thumbWidthHeightDP.mMaxHeight;
            }
            float f27 = width;
            float f28 = height;
            float f29 = f28 * 3.0f;
            if (f27 > f29) {
                i3 = (int) f29;
            } else {
                float f36 = f27 * 3.0f;
                if (f28 > f36) {
                    i16 = (int) f36;
                    i3 = width;
                    if (i3 >= imgThumbMinDp && i16 >= imgThumbMinDp2) {
                        if (i3 < imgThumbMaxDp || i16 >= imgThumbMaxDp2) {
                            if (i3 <= i16) {
                                f16 = imgThumbMaxPx;
                                f17 = i3;
                            } else {
                                f16 = imgThumbMaxPx2;
                                f17 = i16;
                            }
                            float f37 = f16 / f17;
                            if (i3 <= i16) {
                                f18 = imgThumbMinPx2;
                                f19 = i16;
                            } else {
                                f18 = imgThumbMinPx;
                                f19 = i3;
                            }
                            f26 = Math.max(f37, f18 / f19);
                        }
                        imgThumbMinPx = (int) ((i3 * f26) + 0.5f);
                        i18 = (int) ((i16 * f26) + 0.5f);
                        Bitmap createBitmap = Bitmap.createBitmap(imgThumbMinPx, i18, URLDrawableHelper.mThumbConfig);
                        createBitmap.setDensity(i19);
                        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, imgThumbMinPx, i18), paint);
                        return new RoundRectBitmap(createBitmap, roundCorner);
                    }
                    i17 = (int) ((i3 * (imgThumbMinPx2 / i16)) + 0.5f);
                    if (i17 <= imgThumbMaxPx) {
                        imgThumbMinPx = imgThumbMaxPx;
                    } else {
                        imgThumbMinPx = i17;
                    }
                    i18 = imgThumbMinPx2;
                    Bitmap createBitmap2 = Bitmap.createBitmap(imgThumbMinPx, i18, URLDrawableHelper.mThumbConfig);
                    createBitmap2.setDensity(i19);
                    new Canvas(createBitmap2).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, imgThumbMinPx, i18), paint);
                    return new RoundRectBitmap(createBitmap2, roundCorner);
                }
                i3 = width;
            }
            i16 = height;
            if (i3 >= imgThumbMinDp) {
                if (i3 < imgThumbMaxDp) {
                }
                if (i3 <= i16) {
                }
                float f372 = f16 / f17;
                if (i3 <= i16) {
                }
                f26 = Math.max(f372, f18 / f19);
                imgThumbMinPx = (int) ((i3 * f26) + 0.5f);
                i18 = (int) ((i16 * f26) + 0.5f);
                Bitmap createBitmap22 = Bitmap.createBitmap(imgThumbMinPx, i18, URLDrawableHelper.mThumbConfig);
                createBitmap22.setDensity(i19);
                new Canvas(createBitmap22).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, imgThumbMinPx, i18), paint);
                return new RoundRectBitmap(createBitmap22, roundCorner);
            }
            i17 = (int) ((i3 * (imgThumbMinPx2 / i16)) + 0.5f);
            if (i17 <= imgThumbMaxPx) {
            }
            i18 = imgThumbMinPx2;
            Bitmap createBitmap222 = Bitmap.createBitmap(imgThumbMinPx, i18, URLDrawableHelper.mThumbConfig);
            createBitmap222.setDensity(i19);
            new Canvas(createBitmap222).drawBitmap(bitmap, new Rect(0, 0, i3, i16), new Rect(0, 0, imgThumbMinPx, i18), paint);
            return new RoundRectBitmap(createBitmap222, roundCorner);
        } catch (OutOfMemoryError unused) {
            return new RoundRectBitmap(bitmap, URLDrawableHelper.getRoundCorner());
        }
    }

    public static Bitmap resizeThumb(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] calculateScaledThumbWH = calculateScaledThumbWH(bitmap);
            if (calculateScaledThumbWH == null) {
                return null;
            }
            int i3 = calculateScaledThumbWH[0];
            int i16 = calculateScaledThumbWH[1];
            if (width == i3 && height == i16) {
                return bitmap;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resizeThumb ==> dstW:" + i3 + ", dstH:" + i16);
            }
            float f16 = i3;
            float f17 = i16;
            Matrix matrix = new Matrix();
            matrix.postScale(f16 / width, f17 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Canvas canvas = new Canvas(createBitmap);
            RectF rectF = new RectF(0.0f, 0.0f, f16, f17);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "resizeThumb, OutOfMemoryError ", e16);
            }
            return bitmap;
        }
    }

    public static void setAEPituCameraTaKeSameSwitch(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(SHORT_VIDEO_AE_CAMERA_TAKE_SAME_SWITCH, z16);
    }

    public static void setHotPiCRedDotConfigVersion(String str, int i3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(SHORT_VIDEO_HOT_PIC_CONFIG_PIC_VERSION + str, i3);
    }

    public static void setHotPicRedDotStatus(String str, boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PIC + str, z16);
    }

    public static void setPtvRedDotConfigVersion(String str, int i3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(SHORT_VIDEO_HOT_PIC_CONFIG_PTV_VERSION + str, i3);
    }

    public static void setPtvRedDotStatus(String str, boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PTV + str, z16);
    }

    public static void setRecentPOI(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            getSharedPref(ShortVideoConstants.SP_USER_CACHE_DATA).edit().putString("recent_poi_" + str, str2).apply();
        }
    }

    public static void startShortVideoPlayActivity(MessageForShortVideo messageForShortVideo, Activity activity, int i3, String str, Rect rect, int i16) {
        String l3 = j.l(messageForShortVideo.thumbMD5, "jpg");
        Bundle bundle = new Bundle();
        bundle.putInt("uintype", messageForShortVideo.istroop);
        bundle.putString(ShortVideoConstants.FROM_UIN, j.c(messageForShortVideo));
        bundle.putInt(ShortVideoConstants.FROM_UIN_TYPE, i3);
        bundle.putString(ShortVideoConstants.FROM_SESSION_UIN, str);
        bundle.putInt(ShortVideoConstants.FROM_BUSI_TYPE, messageForShortVideo.busiType);
        bundle.putInt(ShortVideoConstants.FILE_SEND_SIZE, messageForShortVideo.videoFileSize);
        bundle.putInt(ShortVideoConstants.FILE_SEND_DURATION, messageForShortVideo.videoFileTime);
        bundle.putString("file_name", messageForShortVideo.videoFileName);
        bundle.putInt(ShortVideoConstants.FILE_FORMAT, messageForShortVideo.videoFileFormat);
        bundle.putString(ShortVideoConstants.THUMBFILE_SEND_PATH, l3);
        bundle.putString(ShortVideoConstants.FILE_SHORTVIDEO_MD5, messageForShortVideo.md5);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_WIDTH, messageForShortVideo.thumbWidth);
        bundle.putInt(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, messageForShortVideo.thumbHeight);
        bundle.putString(ShortVideoConstants.THUMBFILE_MD5, messageForShortVideo.thumbMD5);
        bundle.putString(ShortVideoConstants.FILE_SOURCE, messageForShortVideo.fileSource);
        bundle.putString(ShortVideoConstants.FILE_UUID, messageForShortVideo.uuid);
        bundle.putInt(ShortVideoConstants.FILE_THUMB_SIZE, messageForShortVideo.thumbFileSize);
        bundle.putBoolean(ShortVideoConstants.SUPPORT_PROGRESSIVE, messageForShortVideo.supportProgressive);
        bundle.putInt(ShortVideoConstants.FILE_WIDTH, messageForShortVideo.fileWidth);
        bundle.putInt(ShortVideoConstants.FILE_HEIGHT, messageForShortVideo.fileHeight);
        bundle.putParcelable("KEY_THUMBNAL_BOUND", rect);
        bundle.putInt(ShortVideoConstants.VIDEO_PLAY_CALLER, 0);
        bundle.putParcelable(ShortVideoConstants.KEY_MESSAGE_FOR_SHORTVIDEO, messageForShortVideo);
        bundle.putLong(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
        bundle.putInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE, i16);
        if (messageForShortVideo.checkIsHotVideo()) {
            bundle.putBoolean(ShortVideoConstants.IS_HOTVIDEO, true);
            bundle.putString(ShortVideoConstants.HOT_VIDEO_ICON, messageForShortVideo.hotVideoIconUrl);
            bundle.putString(ShortVideoConstants.HOT_VIDEO_ICON_SUB, messageForShortVideo.hotVideoSubIconUrl);
            bundle.putString(ShortVideoConstants.HOT_VIDEO_TITLE, messageForShortVideo.hotVideoTitle);
            bundle.putString(ShortVideoConstants.HOT_VIDEO_URL, messageForShortVideo.hotVideoUrl);
        }
        bundle.putInt(ShortVideoConstants.SPECIAL_VIDEO_TYPE, messageForShortVideo.specialVideoType);
        bundle.putInt(ShortVideoConstants.MSG_TAIL_TYPE, messageForShortVideo.msgTailType);
        Intent intent = new Intent(activity, (Class<?>) ShortVideoPlayActivity.class);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, TVKEventId.PLAYER_STATE_UPDATE_VIEW);
        activity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
    }

    public static String stringForFileSize(Context context, long j3) {
        String formatShortFileSize = Formatter.formatShortFileSize(context, j3);
        int length = formatShortFileSize.length();
        if (length > 3) {
            formatShortFileSize = formatShortFileSize.substring(0, length - 1);
        }
        return formatShortFileSize.replace(" ", "");
    }

    public static String stringForTime(long j3) {
        int i3 = ((int) j3) / 1000;
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            return String.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16)).toString();
        }
        return String.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16)).toString();
    }

    public static boolean supportShortVideoMergePhoto() {
        int intValue;
        if (!sSupportPhotoMergeInited) {
            sSupportPhotoMergeInited = true;
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "supportShortVideoMergePhoto:" + featureValue);
                }
                String[] split = featureValue.split("\\|");
                if (split.length > 10 && (intValue = Integer.valueOf(split[10]).intValue()) >= 0 && intValue <= 1) {
                    mSupportPhotoMerge = intValue;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "supportShortVideoMergePhoto e:" + e16.toString());
                }
            }
        }
        if (mSupportPhotoMerge == 1) {
            return true;
        }
        return false;
    }

    public static boolean verifyFileModifyTime(String str, long j3) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && 0 != j3) {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            long length = file.length();
            if (file.isFile() && length > 0) {
                if (j3 == file.lastModified()) {
                    z16 = true;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " verifyFileModifyTime(), result = " + z16 + ", cost time: " + (currentTimeMillis2 - currentTimeMillis) + " ms");
                }
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " verifyFileModifyTime(), filePath or lastModifyTime is vilid.");
        }
        return false;
    }

    public static void deleteDownloadTempFile(String str, boolean z16) {
        File[] listFiles;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteDownloadTempFile, exclude :" + str + ",compareModifiedTime : " + z16);
        }
        File file = new File(j.h());
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                File[] listFiles2 = file2.listFiles();
                if (listFiles2 != null) {
                    for (File file3 : listFiles2) {
                        if (!file3.getName().equals(str) && file3.isFile() && file3.getName().contains(".tmp")) {
                            if (!z16) {
                                file3.delete();
                            } else if (604800000 <= System.currentTimeMillis() - file3.lastModified()) {
                                file3.delete();
                            }
                        }
                    }
                }
            }
        }
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str, int i3) {
        return getVideoThumbnail(context, str, i3, -1L);
    }

    @TargetApi(10)
    public static Bitmap getVideoThumbnail(Context context, String str, int i3, long j3) {
        Bitmap bitmap;
        if (i3 <= 0) {
            i3 = 640;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        Bitmap bitmap2 = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(j3);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused) {
                }
                if (bitmap == null) {
                    return null;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int max = Math.max(width, height);
                if (max > i3) {
                    float f16 = i3 / max;
                    try {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(width * f16), Math.round(f16 * height), true);
                    } catch (OutOfMemoryError e16) {
                        e16.printStackTrace();
                    }
                } else {
                    bitmap2 = bitmap;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (bitmap2 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getVideoThumbnail => success, width=" + bitmap2.getWidth() + ", height=" + bitmap2.getHeight() + ", videoPath=" + str + ", cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getVideoThumbnail => fail,  videoPath=" + str);
                }
                return bitmap2;
            } catch (IllegalArgumentException | RuntimeException unused2) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused3) {
                    bitmap = null;
                }
            } catch (OutOfMemoryError e17) {
                QLog.d(TAG, 1, "getVideoThumbnail OOM, ", e17);
                mediaMetadataRetriever.release();
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused4) {
            }
            throw th5;
        }
    }

    public static String getShortVideoPath(File file) {
        if (file == null) {
            return null;
        }
        String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(file);
        String str = AppConstants.SDCARD_IMG_CAMERA;
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return str + vidFromSourceDirFile + ".mp4";
    }

    public static int[] calculateScaledThumbWH(int[] iArr) {
        float f16;
        float f17;
        if (iArr == null) {
            return null;
        }
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (i3 == 0 || i16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "calculateThumbWH, w or h == 0 !");
            }
            return null;
        }
        if (i16 > i3) {
            f16 = i16;
            f17 = i3;
        } else {
            f16 = i3;
            f17 = i16;
        }
        float f18 = f16 / f17;
        if (f18 > 2.0f) {
            f18 = 2.0f;
        }
        if (i16 > i3) {
            if (i16 > 160) {
                i16 = 160;
            } else if (i16 < 100) {
                i16 = 100;
            }
            int i17 = (int) (i16 / f18);
            if (i17 >= 80) {
                r5 = i17;
            }
        } else {
            if (i3 > 160) {
                i3 = 160;
            } else if (i3 < 100) {
                i3 = 100;
            }
            int i18 = (int) (i3 / f18);
            i16 = i18 >= 80 ? i18 : 80;
            r5 = i3;
        }
        return new int[]{r5, i16};
    }

    public static void reportVideoPlay(AppInterface appInterface, String str, SessionInfo sessionInfo, MessageRecord messageRecord, Context context) {
        a.C8615a c8615a = new a.C8615a();
        c8615a.f289937b = str;
        int i3 = sessionInfo.f179555d;
        if (i3 == 0) {
            c8615a.f289939d = "1";
        } else if (i3 == 1) {
            c8615a.f289939d = "2";
        } else if (i3 == 3000) {
            c8615a.f289939d = "3";
        }
        if (str == T5) {
            c8615a.f289938c = "2";
        } else {
            c8615a.f289938c = "1";
        }
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            c8615a.f289936a = String.valueOf(messageForShortVideo.videoFileTime * 1000);
            int i16 = messageForShortVideo.busiType;
            if (i16 == 0) {
                c8615a.f289940e = "1";
            } else if (i16 == 1) {
                c8615a.f289940e = "2";
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, Long.valueOf(messageRecord.uniseq));
            }
        } else {
            c8615a.f289936a = "0";
            c8615a.f289940e = "3";
        }
        if (!(context instanceof SplashActivity) && !(context instanceof ChatActivity)) {
            c8615a.f289941f = "2";
        } else {
            c8615a.f289941f = "1";
        }
        com.tencent.mobileqq.statistics.a.b(appInterface.getAccount(), "dc01178", sessionInfo.f179557e, c8615a);
    }

    public static String getShortVideoPath(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String vidFromSourceDirFile = VidUtil.getVidFromSourceDirFile(file);
        String str2 = AppConstants.SDCARD_IMG_CAMERA;
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return str2 + str + vidFromSourceDirFile + ".mp4";
    }
}
