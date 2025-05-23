package com.tencent.image;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.oskplayer.proxy.VideoProxy;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SafeBitmapFactory {
    static IPatchRedirector $redirector_ = null;
    public static String FLASH_BACK_TEST_PATH = null;
    public static final long FLASH_BACK_TEST_PX_THRESHOID = 10000000;
    public static String FLASH_BACK_TEST_REGION_PATH = null;
    public static String LARGE_MAP_CACHE_PATH = null;
    public static final int PX_SLICE = 4000;
    public static final long PX_THRESHOID_DEFAULTS = 100000000;
    public static final int RAM_THRESHOID_DEFAULTS = 8;
    public static String ROOT_PATH = null;
    public static final String SAFE_DECODE_FROM = "from";
    private static final String SP_NEED_REGION_DECODE = "sp_need_region_decode";
    private static final String SP_PX_THRESHOID = "sp_px_threshoid";
    private static final String SP_RAM_THRESHOID = "sp_ram_threshoid";
    private static final String SP_SAFE_BITMAP = "sp_safe_bitmap";
    private static final String SP_THREADS_COUNT = "sp_thread_count";
    private static final String TAG = "SafeBitmapFactory";
    public static final int THREADS_COUNT_DEFAULTS = 7;
    public static Object lock;
    public static AtomicBoolean sInjectHotPatch;
    public static int sNeedRegionDecode;
    public static long sPxThreshold;
    public static int sRamThreshold;
    public static int sThreadCount;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SafeDecodeOption {
        static IPatchRedirector $redirector_;
        public String dataSourceType;
        public long flashTestThreshold;
        public boolean inNeedCache;
        public boolean inNeedFlashBackTest;
        public BitmapFactory.Options inOptions;
        public int isBeforeFlashBackPic;
        public int isBeforeFlashBackPicRegion;
        public boolean isGetBitmap;
        public boolean isInJustDecodeBounds;
        public int isPng;
        public boolean needFlashBackTest;
        public boolean needRegionDecode;
        public long pxThreshold;
        public long ram;
        public int ramThreshold;
        public int rawHeight;
        public int rawWidth;
        public int regionDecodeOpen;
        public long runTime;

        public SafeDecodeOption() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.inNeedCache = true;
            this.inNeedFlashBackTest = true;
            this.inOptions = null;
            this.runTime = -1L;
            this.isInJustDecodeBounds = false;
            this.regionDecodeOpen = -1;
            this.dataSourceType = "";
            this.rawWidth = -1;
            this.rawHeight = -1;
            this.isPng = -1;
            this.needRegionDecode = false;
            this.needFlashBackTest = false;
            this.isBeforeFlashBackPic = -1;
            this.isBeforeFlashBackPicRegion = -1;
            this.ram = -1L;
            this.ramThreshold = -1;
            this.pxThreshold = -1L;
            this.flashTestThreshold = -1L;
            this.isGetBitmap = false;
        }

        public HashMap<String, String> getInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("isGetBitmap", "" + (this.isGetBitmap ? 1 : 0));
            hashMap.put("runTime", "" + this.runTime);
            hashMap.put("needRegionDecode", "" + (this.needRegionDecode ? 1 : 0));
            hashMap.put("needCache", "" + (this.inNeedCache ? 1 : 0));
            hashMap.put("inNeedFlashBackTest", "" + (this.inNeedFlashBackTest ? 1 : 0));
            if (this.inOptions != null) {
                hashMap.put("inSampleSize", "" + this.inOptions.inSampleSize);
            }
            hashMap.put("needFlashBackTest", "" + (this.needFlashBackTest ? 1 : 0));
            hashMap.put("isInJustDecodeBounds", "" + (this.isInJustDecodeBounds ? 1 : 0));
            if (this.regionDecodeOpen != -1) {
                hashMap.put("regionDecodeOpen", "" + this.regionDecodeOpen);
            }
            if (!this.dataSourceType.equals("")) {
                hashMap.put(VideoProxy.PARAM_DATASOURCE_TYPE, this.dataSourceType);
            }
            if (this.rawWidth != -1) {
                hashMap.put("rawWidth", "" + this.rawWidth);
            }
            if (this.rawHeight != -1) {
                hashMap.put("rawHeight", "" + this.rawHeight);
            }
            if (this.isPng != -1) {
                hashMap.put("isPng", "" + this.isPng);
            }
            if (this.isBeforeFlashBackPic != -1) {
                hashMap.put("isBeforeFlashBackPic", "" + this.isBeforeFlashBackPic);
            }
            if (this.ram != -1) {
                hashMap.put("ram", "" + this.ram);
            }
            if (this.ramThreshold != -1) {
                hashMap.put("ramThreshold", "" + this.ramThreshold);
            }
            if (this.pxThreshold != -1) {
                hashMap.put("pxThreshold", "" + this.pxThreshold);
            }
            if (this.flashTestThreshold != -1) {
                hashMap.put("flashTestThreshold", "" + this.flashTestThreshold);
            }
            return hashMap;
        }

        public String toString() {
            String str;
            boolean z16;
            String sb5;
            String str2;
            String str3;
            String str4;
            boolean z17;
            String sb6;
            String sb7;
            String str5;
            String str6;
            String str7;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("RegionDecodeInfo{  isGetBitmap=");
            sb8.append(this.isGetBitmap);
            sb8.append(", runTime=");
            sb8.append(this.runTime);
            sb8.append(", needRegionDecode=");
            sb8.append(this.needRegionDecode);
            sb8.append(", inNeedCache=");
            sb8.append(this.inNeedCache);
            sb8.append(", inNeedFlashBackTest=");
            sb8.append(this.inNeedFlashBackTest);
            String str8 = "";
            if (this.inOptions == null) {
                str = "";
            } else {
                str = ", inSampleSize=" + this.inOptions.inSampleSize;
            }
            sb8.append(str);
            sb8.append(", isInJustDecodeBounds=");
            sb8.append(this.isInJustDecodeBounds);
            boolean z18 = false;
            if (this.regionDecodeOpen == -1) {
                sb5 = "";
            } else {
                StringBuilder sb9 = new StringBuilder();
                sb9.append(", regionDecodeOpen=");
                if (this.regionDecodeOpen == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb9.append(z16);
                sb5 = sb9.toString();
            }
            sb8.append(sb5);
            if (this.dataSourceType.equals("")) {
                str2 = "";
            } else {
                str2 = ", dataSourceType=" + this.dataSourceType;
            }
            sb8.append(str2);
            if (this.rawWidth == -1) {
                str3 = "";
            } else {
                str3 = ", rawWidth=" + this.rawWidth;
            }
            sb8.append(str3);
            if (this.rawHeight == -1) {
                str4 = "";
            } else {
                str4 = ", rawHeight=" + this.rawHeight;
            }
            sb8.append(str4);
            if (this.isPng == -1) {
                sb6 = "";
            } else {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(", isPng=");
                if (this.isPng == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb10.append(z17);
                sb6 = sb10.toString();
            }
            sb8.append(sb6);
            sb8.append(", needFlashBackTest=");
            sb8.append(this.needFlashBackTest);
            if (this.isBeforeFlashBackPic == -1) {
                sb7 = "";
            } else {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(", isBeforeFlashBackPic=");
                if (this.isBeforeFlashBackPic == 1) {
                    z18 = true;
                }
                sb11.append(z18);
                sb7 = sb11.toString();
            }
            sb8.append(sb7);
            if (this.ram == -1) {
                str5 = "";
            } else {
                str5 = ", ram=" + this.ram;
            }
            sb8.append(str5);
            if (this.ramThreshold == -1) {
                str6 = "";
            } else {
                str6 = ", ramThreshold=" + this.ramThreshold;
            }
            sb8.append(str6);
            if (this.pxThreshold == -1) {
                str7 = "";
            } else {
                str7 = ", pxThreshold=" + this.pxThreshold;
            }
            sb8.append(str7);
            if (this.flashTestThreshold != -1) {
                str8 = ", flashTestThreshold=" + this.flashTestThreshold;
            }
            sb8.append(str8);
            sb8.append('}');
            return sb8.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sRamThreshold = -1;
        sPxThreshold = -1L;
        sThreadCount = -1;
        sNeedRegionDecode = -1;
        sInjectHotPatch = new AtomicBoolean(false);
        lock = new Object();
    }

    public SafeBitmapFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeByteArray(bArr, i3, i16, options);
    }

    @TargetApi(10)
    private static Bitmap decodeData(Object obj, BitmapFactory.Options options) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 4, "\u89e3\u7801\u56fe\u7247\u6587\u4ef6\u8def\u5f84\uff1a" + str);
            }
            return BitmapFactory.decodeFile(str, options);
        }
        if (obj instanceof InputStream) {
            InputStream inputStream = (InputStream) obj;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "\u89e3\u7801\u56fe\u7247\u6587\u4ef6\u6d41");
            }
            return BitmapFactory.decodeStream(inputStream, null, options);
        }
        if (obj instanceof FileDescriptor) {
            FileDescriptor fileDescriptor = (FileDescriptor) obj;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "\u89e3\u7801\u56fe\u7247\u6587\u4ef6\u63cf\u8ff0");
            }
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        }
        if (!(obj instanceof byte[])) {
            return null;
        }
        byte[] bArr = (byte[]) obj;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "\u89e3\u7801\u56fe\u7247\u5b57\u8282\u6570\u7ec4");
        }
        if (options != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static int getNeedRegionDecode() {
        if (sNeedRegionDecode == -1) {
            if (URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).getBoolean(SP_NEED_REGION_DECODE, true)) {
                sNeedRegionDecode = 1;
            } else {
                sNeedRegionDecode = 0;
            }
        }
        return sNeedRegionDecode;
    }

    public static long getPxThreshoid() {
        if (sPxThreshold == -1) {
            sPxThreshold = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).getLong(SP_PX_THRESHOID, PX_THRESHOID_DEFAULTS);
        }
        return sPxThreshold;
    }

    public static int getRamThreshoid() {
        if (sRamThreshold == -1) {
            sRamThreshold = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).getInt(SP_RAM_THRESHOID, 8);
        }
        return sRamThreshold;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(10)
    public static BitmapRegionDecoder getRegionDecoder(Object obj, boolean z16) throws IOException {
        if (obj instanceof String) {
            return BitmapRegionDecoder.newInstance((String) obj, z16);
        }
        if (obj instanceof FileDescriptor) {
            return BitmapRegionDecoder.newInstance((FileDescriptor) obj, z16);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, z16);
        }
        return null;
    }

    public static int getThreadCount() {
        if (sThreadCount == -1) {
            sThreadCount = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).getInt(SP_THREADS_COUNT, 7);
        }
        return sThreadCount;
    }

    private static void initRegionCacheFilePath() {
        URLDrawableDepWrap uRLDrawableDepWrap = URLDrawable.depImp;
        if (uRLDrawableDepWrap == null || ROOT_PATH != null) {
            return;
        }
        String str = uRLDrawableDepWrap.mTool.getContext().getFilesDir().getAbsolutePath() + "/urldrawable/hugeimagecache";
        ROOT_PATH = str;
        LARGE_MAP_CACHE_PATH = str;
        FLASH_BACK_TEST_PATH = ROOT_PATH + "/flashback.mc";
        FLASH_BACK_TEST_REGION_PATH = ROOT_PATH + "/flashbackRegion.mc";
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0285  */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean needRegionDecode(Object obj, SafeDecodeOption safeDecodeOption) {
        Throwable th5;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        boolean z16;
        Throwable th6;
        BufferedReader bufferedReader;
        long j3;
        int findOrAddItem;
        initRegionCacheFilePath();
        BitmapFactory.Options options = safeDecodeOption.inOptions;
        if (options != null && options.inJustDecodeBounds) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "\u53ea\u8981\u83b7\u53d6\u56fe\u7247\u6570\u636e\uff0c\u4e0d\u9700\u8981\u89e3\u7801\u56fe\u7247\uff0c\u4e0d\u4f7f\u7528\u533a\u57df\u89e3\u7801");
            }
            safeDecodeOption.isInJustDecodeBounds = true;
            return false;
        }
        safeDecodeOption.isInJustDecodeBounds = false;
        if (getNeedRegionDecode() == 0) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "\u533a\u57df\u89e3\u7801\u5f00\u5173 needRegionDecode \u5173\u95ed\uff0c\u4e0d\u4f7f\u7528\u533a\u57df\u89e3\u7801");
            }
            safeDecodeOption.regionDecodeOpen = 0;
            return false;
        }
        safeDecodeOption.regionDecodeOpen = 1;
        if (obj instanceof InputStream) {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "\u6e90\u6570\u636e\u662fInputStream\uff0c\u4e0d\u4f7f\u7528\u533a\u57df\u89e3\u7801");
            }
            safeDecodeOption.dataSourceType = "InputStream";
            return false;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        decodeData(obj, options2);
        options2.inJustDecodeBounds = false;
        int i3 = options2.outWidth;
        safeDecodeOption.rawWidth = i3;
        int i16 = options2.outHeight;
        safeDecodeOption.rawHeight = i16;
        safeDecodeOption.flashTestThreshold = 10000000L;
        ?? r132 = i16;
        try {
            if (i3 * r132 < 10000000) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG, 4, "\u56fe\u7247\u592a\u5c0f\uff0c\u5c0f\u4e8e\u95ea\u9000\u68c0\u6d4b\u9608\u503c\uff0c\u4e0d\u7528\u533a\u57df\u89e3\u7801\u3002rawWidth\uff1a" + options2.outWidth + ", rawHeight :" + options2.outHeight + ",sPxThreshold:" + sPxThreshold);
                }
                return false;
            }
            try {
            } catch (FileNotFoundException e16) {
                e = e16;
                inputStream3 = null;
            } catch (IOException e17) {
                e = e17;
                inputStream2 = null;
            } catch (Throwable th7) {
                th5 = th7;
                inputStream = null;
            }
            try {
                if (obj instanceof String) {
                    inputStream4 = new FileInputStream((String) obj);
                    safeDecodeOption.dataSourceType = Entry.DATA_TYPE_STRING;
                } else if (obj instanceof FileDescriptor) {
                    inputStream4 = new FileInputStream((FileDescriptor) obj);
                    safeDecodeOption.dataSourceType = "FileDescriptor";
                } else if (obj instanceof byte[]) {
                    inputStream4 = new ByteArrayInputStream((byte[]) obj);
                    safeDecodeOption.dataSourceType = "byte[]";
                } else {
                    inputStream4 = null;
                }
                byte[] bArr = new byte[29];
                inputStream4.read(bArr);
                if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[28] == 1) {
                    safeDecodeOption.isPng = 1;
                    try {
                        inputStream4.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    safeDecodeOption.pxThreshold = getPxThreshoid();
                    if (options2.outWidth * options2.outHeight < sPxThreshold) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(TAG, 2, "\u56fe\u7247\u5c0f\u4e8e\u533a\u57df\u89e3\u7801\u9608\u503c\u3002rawWidth\uff1a" + options2.outWidth + ", rawHeight :" + options2.outHeight + ",sPxThreshold:" + sPxThreshold);
                        }
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    Context context = URLDrawable.mApplicationContext;
                    try {
                        try {
                            if (context != null) {
                                ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                                if (activityManager != null) {
                                    activityManager.getMemoryInfo(memoryInfo);
                                }
                                j3 = (((memoryInfo.totalMem / 1024) / 1024) / 1024) + 1;
                            } else {
                                try {
                                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"));
                                    try {
                                        long longValue = ((Long.valueOf(bufferedReader2.readLine().split("\\s+")[1]).longValue() / 1024) / 1024) + 1;
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e19) {
                                            e19.printStackTrace();
                                        }
                                        j3 = longValue;
                                    } catch (FileNotFoundException e26) {
                                        e = e26;
                                        bufferedReader = bufferedReader2;
                                        e.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        j3 = -1;
                                        safeDecodeOption.ram = j3;
                                        safeDecodeOption.ramThreshold = getRamThreshoid();
                                        if (j3 > sRamThreshold) {
                                        }
                                        if (!z16) {
                                            findOrAddItem = MmapCache.getInstance(FLASH_BACK_TEST_PATH).findOrAddItem((String) obj);
                                            if (findOrAddItem == 0) {
                                            }
                                        }
                                        return z16;
                                    } catch (IOException e27) {
                                        e = e27;
                                        bufferedReader = bufferedReader2;
                                        e.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        j3 = -1;
                                        safeDecodeOption.ram = j3;
                                        safeDecodeOption.ramThreshold = getRamThreshoid();
                                        if (j3 > sRamThreshold) {
                                        }
                                        if (!z16) {
                                        }
                                        return z16;
                                    } catch (Throwable th8) {
                                        th6 = th8;
                                        bufferedReader = bufferedReader2;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                                throw th6;
                                            } catch (IOException e28) {
                                                e28.printStackTrace();
                                                throw th6;
                                            }
                                        }
                                        throw th6;
                                    }
                                } catch (FileNotFoundException e29) {
                                    e = e29;
                                    bufferedReader = null;
                                } catch (IOException e36) {
                                    e = e36;
                                    bufferedReader = null;
                                } catch (Throwable th9) {
                                    th6 = th9;
                                    bufferedReader = null;
                                }
                            }
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                        safeDecodeOption.ram = j3;
                        safeDecodeOption.ramThreshold = getRamThreshoid();
                        if (j3 > sRamThreshold) {
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.d(TAG, 2, "\u624b\u673a\u5185\u5b58\u591f\u5927\u3002ram\uff1a" + j3 + ",sRamThreshold:" + sRamThreshold);
                            }
                            z16 = false;
                        }
                        if (!z16 && safeDecodeOption.inNeedFlashBackTest && options2.outWidth * options2.outHeight > 10000000 && (obj instanceof String)) {
                            findOrAddItem = MmapCache.getInstance(FLASH_BACK_TEST_PATH).findOrAddItem((String) obj);
                            if (findOrAddItem == 0) {
                                if (findOrAddItem == 1) {
                                    safeDecodeOption.isBeforeFlashBackPic = 1;
                                    if (!URLDrawable.depImp.mLog.isColorLevel()) {
                                        return true;
                                    }
                                    URLDrawable.depImp.mLog.d(TAG, 2, "\u95ea\u9000\u7f13\u5b58\u4e2d\u5b58\u5728\u8be5\u6570\u636e\uff0c\u8bf4\u660e\u4e4b\u524d\u5d29\u6e83\uff0c\u91c7\u7528\u533a\u57df\u89e3\u7801\u3002");
                                    return true;
                                }
                            } else {
                                safeDecodeOption.needFlashBackTest = true;
                                safeDecodeOption.isBeforeFlashBackPic = 0;
                            }
                        }
                        return z16;
                    } catch (Throwable th10) {
                        th6 = th10;
                    }
                }
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG, 2, "\u4e0d\u662f\u9694\u884c\u626b\u63cf\u7684png\u56fe\u7247\uff0c\u4e0d\u7528\u533a\u57df\u89e3\u7801");
                }
                safeDecodeOption.isPng = 0;
                try {
                    inputStream4.close();
                } catch (IOException e38) {
                    e38.printStackTrace();
                }
                return false;
            } catch (FileNotFoundException e39) {
                e = e39;
                inputStream3 = r132;
                e.printStackTrace();
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e46) {
                        e46.printStackTrace();
                    }
                }
                return false;
            } catch (IOException e47) {
                e = e47;
                inputStream2 = r132;
                e.printStackTrace();
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e48) {
                        e48.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th11) {
                th5 = th11;
                inputStream = r132;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        throw th5;
                    } catch (IOException e49) {
                        e49.printStackTrace();
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Throwable th12) {
            th5 = th12;
        }
    }

    @TargetApi(10)
    private static Bitmap regionDecodeData(Object obj, SafeDecodeOption safeDecodeOption) {
        BitmapFactory.Options options;
        int threadCount;
        long j3;
        Bitmap regionDecodeFromCache;
        BitmapFactory.Options options2 = safeDecodeOption.inOptions;
        if (options2 == null) {
            options = new BitmapFactory.Options();
        } else {
            options = options2;
        }
        if (safeDecodeOption.inNeedCache && (regionDecodeFromCache = regionDecodeFromCache(obj, options2)) != null) {
            return regionDecodeFromCache;
        }
        int i3 = 0;
        if (safeDecodeOption.inNeedFlashBackTest && (obj instanceof String)) {
            int findOrAddItem = MmapCache.getInstance(FLASH_BACK_TEST_REGION_PATH).findOrAddItem((String) obj);
            if (findOrAddItem != 0) {
                if (findOrAddItem == 1) {
                    safeDecodeOption.isBeforeFlashBackPicRegion = 1;
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG, 2, "\u95ea\u9000\u7f13\u5b58\u4e2d\u5b58\u5728\u8be5\u6570\u636e\uff0c\u8bf4\u660e\u4e4b\u524d\u7528\u533a\u57df\u89e3\u7801\u5d29\u6e83\u8fc7\u3002\u964d\u4f4e\u7ebf\u7a0b\u6570");
                    }
                }
            } else {
                safeDecodeOption.isBeforeFlashBackPicRegion = 0;
            }
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            Context context = URLDrawable.mApplicationContext;
            if (context != null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                }
                j3 = (memoryInfo.availMem / 1024) / 1024;
            } else {
                j3 = -1;
            }
            URLDrawable.depImp.mLog.d(TAG, 4, "\u5f53\u524d\u7cfb\u7edf\u5269\u4f59\u5185\u5b58\u3002availMem\uff1a" + j3 + "MB");
        }
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inJustDecodeBounds = true;
        decodeData(obj, options3);
        options3.inJustDecodeBounds = false;
        int i16 = options3.outWidth;
        int i17 = (i16 / 4000) + 1;
        int i18 = options3.outHeight;
        int i19 = (i18 / 4000) + 1;
        int i26 = options.inSampleSize;
        if (i26 > 0) {
            i16 /= i26;
        }
        if (i26 > 0) {
            i18 /= i26;
        }
        int i27 = i16 / i17;
        int i28 = i18 / i19;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "\u533a\u57df\u89e3\u7801\u539f\u56fe \u5bbd\uff1a" + options3.outWidth + ", \u9ad8" + options3.outHeight);
            ILog iLog = URLDrawable.depImp.mLog;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u533a\u57df\u89e3\u7801\u539f\u56fe inSampleSize\uff1a");
            sb5.append(options.inSampleSize);
            iLog.d(TAG, 2, sb5.toString());
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i18, options.inPreferredConfig);
        CountDownLatch countDownLatch = new CountDownLatch(i19 * i17);
        if (safeDecodeOption.isBeforeFlashBackPicRegion == 1) {
            threadCount = (getThreadCount() / 2) + 1;
        } else {
            threadCount = getThreadCount();
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "threadCount\uff1a" + threadCount);
        }
        Semaphore semaphore = new Semaphore(threadCount);
        Canvas canvas = new Canvas(createBitmap);
        int i29 = 0;
        while (i29 < i19) {
            int i36 = i3;
            while (i36 < i17) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                int i37 = i36;
                int i38 = i29;
                Canvas canvas2 = canvas;
                Semaphore semaphore2 = semaphore;
                CountDownLatch countDownLatch2 = countDownLatch;
                URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new Runnable(options, i37, i27, i38, i28, obj, canvas2, countDownLatch2) { // from class: com.tencent.image.SafeBitmapFactory.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Canvas val$canvas;
                    final /* synthetic */ CountDownLatch val$countDownLatch;
                    final /* synthetic */ Object val$dataSource;
                    final /* synthetic */ int val$fi;
                    final /* synthetic */ int val$fj;
                    final /* synthetic */ BitmapFactory.Options val$fopts;
                    final /* synthetic */ int val$perHeight;
                    final /* synthetic */ int val$perWidth;

                    {
                        this.val$fopts = options;
                        this.val$fj = i37;
                        this.val$perWidth = i27;
                        this.val$fi = i38;
                        this.val$perHeight = i28;
                        this.val$dataSource = obj;
                        this.val$canvas = canvas2;
                        this.val$countDownLatch = countDownLatch2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, options, Integer.valueOf(i37), Integer.valueOf(i27), Integer.valueOf(i38), Integer.valueOf(i28), obj, canvas2, countDownLatch2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            try {
                                int i39 = this.val$fopts.inSampleSize;
                                if (i39 <= 0) {
                                    i39 = 1;
                                }
                                int i46 = this.val$fj;
                                int i47 = this.val$perWidth;
                                int i48 = this.val$fi;
                                int i49 = this.val$perHeight;
                                Rect rect = new Rect(i46 * i47 * i39, i48 * i49 * i39, (i46 + 1) * i47 * i39, (i48 + 1) * i49 * i39);
                                BitmapRegionDecoder regionDecoder = SafeBitmapFactory.getRegionDecoder(this.val$dataSource, true);
                                Bitmap decodeRegion = regionDecoder.decodeRegion(rect, this.val$fopts);
                                synchronized (this.val$canvas) {
                                    this.val$canvas.drawBitmap(decodeRegion, this.val$fj * this.val$perWidth, this.val$fi * this.val$perHeight, (Paint) null);
                                }
                                decodeRegion.recycle();
                                regionDecoder.recycle();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        } finally {
                            this.val$countDownLatch.countDown();
                        }
                    }
                }, null, true);
                semaphore2.release();
                i36 = i37 + 1;
                createBitmap = createBitmap;
                i29 = i38;
                canvas = canvas2;
                semaphore = semaphore2;
                countDownLatch = countDownLatch2;
                i19 = i19;
                i17 = i17;
            }
            i29++;
            i3 = 0;
        }
        Bitmap bitmap = createBitmap;
        try {
            countDownLatch.await(20L, TimeUnit.SECONDS);
        } catch (InterruptedException e17) {
            e17.printStackTrace();
        }
        if (safeDecodeOption.inNeedCache) {
            regionDecodeToCache(obj, bitmap, options2);
        }
        if (options2 != null) {
            options2.inJustDecodeBounds = true;
            decodeData(obj, options2);
            options2.inJustDecodeBounds = false;
        }
        if (safeDecodeOption.isBeforeFlashBackPicRegion == 0) {
            MmapCache.getInstance(FLASH_BACK_TEST_REGION_PATH).deleteItem((String) obj);
        }
        return bitmap;
    }

    private static Bitmap regionDecodeFromCache(Object obj, BitmapFactory.Options options) {
        String str = LARGE_MAP_CACHE_PATH + File.separator + (Utils.Crc64String(MD5Util.getMd5(obj)) + "_" + options.inSampleSize);
        File file = new File(str);
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "\u7f13\u5b58PATH:" + str);
        }
        if (file.exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return null;
    }

    private static void regionDecodeToCache(Object obj, Bitmap bitmap, BitmapFactory.Options options) {
        String str = LARGE_MAP_CACHE_PATH + File.separator + (Utils.Crc64String(MD5Util.getMd5(obj)) + "_" + options.inSampleSize);
        try {
            File file = new File(LARGE_MAP_CACHE_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public static Bitmap safeDecode(Object obj, BitmapFactory.Options options, boolean z16) {
        SafeDecodeOption safeDecodeOption = new SafeDecodeOption();
        safeDecodeOption.inOptions = options;
        safeDecodeOption.inNeedCache = z16;
        return safeDecode(obj, safeDecodeOption);
    }

    public static void setNeedRegionDecode(boolean z16) {
        if (z16) {
            sNeedRegionDecode = 1;
        } else {
            sNeedRegionDecode = 0;
        }
        SharedPreferences.Editor edit = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).edit();
        edit.putBoolean(SP_NEED_REGION_DECODE, z16);
        edit.commit();
    }

    public static void setPxThreshoidToSp(long j3) {
        if (j3 < 0) {
            return;
        }
        sPxThreshold = j3;
        SharedPreferences.Editor edit = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).edit();
        edit.putLong(SP_PX_THRESHOID, j3);
        edit.commit();
    }

    public static void setRamThreshoidToSp(int i3) {
        if (i3 < 0) {
            return;
        }
        sRamThreshold = i3;
        SharedPreferences.Editor edit = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).edit();
        edit.putInt(SP_RAM_THRESHOID, i3);
        edit.commit();
    }

    public static void setThreadCountToSp(int i3) {
        if (i3 < 1) {
            return;
        }
        sThreadCount = i3;
        SharedPreferences.Editor edit = URLDrawable.mApplicationContext.getSharedPreferences(SP_SAFE_BITMAP, 4).edit();
        edit.putLong(SP_THREADS_COUNT, i3);
        edit.commit();
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i3, int i16) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeByteArray(bArr, i3, i16);
    }

    public static Bitmap decodeFile(String str) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        injectBitmapHotPatch();
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap safeDecode(Object obj, BitmapFactory.Options options) {
        SafeDecodeOption safeDecodeOption = new SafeDecodeOption();
        safeDecodeOption.inOptions = options;
        return safeDecode(obj, safeDecodeOption);
    }

    public static Bitmap safeDecode(Object obj, SafeDecodeOption safeDecodeOption) {
        Bitmap bitmap;
        if (safeDecodeOption == null) {
            safeDecodeOption = new SafeDecodeOption();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean needRegionDecode = needRegionDecode(obj, safeDecodeOption);
        safeDecodeOption.needRegionDecode = needRegionDecode;
        if (needRegionDecode) {
            bitmap = regionDecodeData(obj, safeDecodeOption);
        } else {
            Bitmap decodeData = decodeData(obj, safeDecodeOption.inOptions);
            if ((obj instanceof String) && safeDecodeOption.needFlashBackTest) {
                MmapCache.getInstance(FLASH_BACK_TEST_PATH).deleteItem((String) obj);
            }
            bitmap = decodeData;
        }
        if (bitmap != null) {
            safeDecodeOption.isGetBitmap = true;
        }
        safeDecodeOption.runTime = System.currentTimeMillis() - currentTimeMillis;
        return bitmap;
    }

    public static void injectBitmapHotPatch() {
    }

    @Deprecated
    public static void registProxyInstance() {
    }
}
