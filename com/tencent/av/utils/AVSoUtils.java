package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVSoUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f76646a = "qav_rtc_sdk";

    /* renamed from: b, reason: collision with root package name */
    public static String f76647b = "libqav_rtc_sdk.so";

    /* renamed from: c, reason: collision with root package name */
    public static String f76648c = "traeimp-qq";

    /* renamed from: d, reason: collision with root package name */
    public static String f76649d = "libtraeimp-qq.so";

    /* renamed from: e, reason: collision with root package name */
    public static String f76650e = "r265_enc";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f76651f = {"qav_rtc_sdk", "xplatform", SoLoadConstants.SONAME_AV_HEVC_ENC, "c++_shared", SoLoadConstants.SONAME_SHARPDEC, "traeimp-qq", "wwise_rtc_proxy", "rtc_node_report", "r265_enc"};

    /* renamed from: g, reason: collision with root package name */
    private static String f76652g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f76653h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f76654i = "";

    /* renamed from: j, reason: collision with root package name */
    private static String f76655j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f76656k = "";

    /* renamed from: l, reason: collision with root package name */
    private static boolean f76657l = false;

    /* renamed from: m, reason: collision with root package name */
    private static String f76658m = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements OnLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f76659a;

        a(String str) {
            this.f76659a = str;
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            QLog.e("AVSoUtils", 1, "getHevcSoDirAndDownloadSo. download onLoadResult. soName = " + this.f76659a + ", result = " + loadExtResult + ", resCode = " + i3);
        }
    }

    public static boolean A() {
        return f76657l;
    }

    private static boolean B() {
        boolean z16;
        LoadExtResult F = F(SoLoadConstants.SONAME_AV_HEVC_DEC);
        if (F != null && F.isSucc()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String soLoadPath = F.getSoLoadPath(SoLoadConstants.SONAME_AV_HEVC_DEC);
            String str = f76653h;
            if (!TextUtils.isEmpty(soLoadPath)) {
                f76653h = soLoadPath;
            }
            QLog.i("AVSoUtils", 1, "loadAndDownloadSo. new HevcDecSoDir = " + f76653h + ", old HevcDecSoDir = " + str);
        }
        return z16;
    }

    private static boolean C() {
        boolean z16;
        LoadExtResult F = F(SoLoadConstants.SONAME_AV_HEVC_ENC);
        if (F != null && F.isSucc()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String soLoadPath = F.getSoLoadPath(SoLoadConstants.SONAME_AV_HEVC_ENC);
            String str = f76652g;
            if (!TextUtils.isEmpty(soLoadPath)) {
                f76652g = soLoadPath;
            }
            QLog.i("AVSoUtils", 1, "loadAndDownloadSo. new HevcEncSoDir = " + f76652g + ", old HevcEncSoDir = " + str);
        }
        return z16;
    }

    public static boolean D() {
        boolean z16;
        LoadExtResult F = F(SoLoadConstants.SONAME_AV_LIGHT_SR);
        if (F != null && F.isSucc()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String soLoadPath = F.getSoLoadPath(SoLoadConstants.SONAME_AV_LIGHT_SR);
            String str = f76655j;
            if (!TextUtils.isEmpty(soLoadPath)) {
                f76655j = soLoadPath.substring(0, soLoadPath.lastIndexOf(File.separator));
            }
            QLog.i("AVSoUtils", 1, "loadAndDownloadSo. new sLightSRSoDir = " + f76655j + ", old sLightSRSoDir = " + str);
        }
        return z16;
    }

    private static boolean E() {
        boolean z16;
        LoadExtResult F = F(f76650e);
        if (F != null && F.isSucc()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String soLoadPath = F.getSoLoadPath(f76650e);
            String str = f76658m;
            if (!TextUtils.isEmpty(soLoadPath)) {
                f76658m = soLoadPath;
            }
            QLog.i("AVSoUtils", 1, "loadAndDownloadSo. new R265EncSoDir = " + f76658m + ", old R265EncSoDir = " + str);
        }
        return z16;
    }

    @Nullable
    public static LoadExtResult F(String str) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        SoLoadManager.getInstance().download(str, new a(str));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(str);
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadAndDownloadSo. soName = ");
        sb5.append(str);
        sb5.append(", result = ");
        sb5.append(loadSync);
        sb5.append(", download call time = ");
        sb5.append(currentTimeMillis2);
        sb5.append(", load cost time: ");
        sb5.append(currentTimeMillis3);
        sb5.append(", so path = ");
        if (loadSync != null) {
            str2 = loadSync.getSoLoadPath(str);
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QLog.i("AVSoUtils", 1, sb5.toString());
        return loadSync;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean G(long j3, Context context, String str, boolean z16) {
        boolean z17;
        String stackTraceString;
        String stackTraceString2;
        String str2;
        boolean z18;
        String str3;
        boolean z19;
        long j16;
        File file;
        QLog.d("AVSoUtils", 1, "LoadExtractedSo begin, libName[" + str + "], seq[" + j3 + "]");
        String str4 = "";
        String str5 = null;
        try {
            str5 = context.getFilesDir().getParent() + SoLoadCore.PATH_TX_LIB + s(str);
            File file2 = new File(str5);
            z17 = file2.exists();
            try {
                if (e.k()) {
                    QLog.w("AVSoUtils", 1, "LoadExtractedSo, strLibPath[" + str5 + "], exists[" + z17 + "], seq[" + j3 + "], size[" + file2.length() + "]");
                }
                stackTraceString = "";
            } catch (Exception e16) {
                e = e16;
                stackTraceString = QLog.getStackTraceString(e);
                QLog.w("AVSoUtils", 1, "LoadExtractedSo Exception, seq[" + j3 + "]", e);
                System.load(str5);
                z18 = true;
                str2 = "";
                stackTraceString2 = str2;
                if (!z18) {
                }
                if (!z18) {
                }
                QLog.w("AVSoUtils", 1, "LoadExtractedSo end , result[" + z18 + "], libName[" + str + "], seq[" + j3 + "]");
                return z18;
            }
        } catch (Exception e17) {
            e = e17;
            z17 = false;
        }
        try {
            System.load(str5);
            z18 = true;
            str2 = "";
            stackTraceString2 = str2;
        } catch (UnsatisfiedLinkError e18) {
            stackTraceString2 = QLog.getStackTraceString(e18);
            QLog.w("AVSoUtils", 1, "LoadExtractedSo, Exception, seq[" + j3 + "]", e18);
            File file3 = new File(str5);
            if (file3.exists()) {
                boolean delete = file3.delete();
                if (QLog.isDevelopLevel()) {
                    QLog.w("AVSoUtils", 1, "LoadExtractedSo, del file ret[" + delete + "], seq[" + j3 + "]");
                }
            } else {
                QLog.w("AVSoUtils", 1, "LoadExtractedSo file not exists, seq[" + j3 + "]");
            }
            QLog.w("AVSoUtils", 1, "LoadExtractedSo, re extractLibraryFromAssert, bret[" + h(j3, context, str, z16) + "], seq[" + j3 + "]");
            try {
                System.load(str5);
                str2 = "";
                z18 = true;
            } catch (UnsatisfiedLinkError e19) {
                String stackTraceString3 = QLog.getStackTraceString(e19);
                QLog.w("AVSoUtils", 1, "LoadExtractedSo Exception, seq[" + j3 + "]", e18);
                str2 = stackTraceString3;
                z18 = false;
            }
        }
        if (!z18) {
            str3 = "";
        } else {
            QLog.w("AVSoUtils", 1, "LoadExtractedSo,  system way. seq[" + j3 + "]");
            try {
                System.loadLibrary(str);
                str3 = "";
                z18 = true;
            } catch (UnsatisfiedLinkError e26) {
                String stackTraceString4 = QLog.getStackTraceString(e26);
                QLog.w("AVSoUtils", 1, "LoadExtractedSo Exception, seq[" + j3 + "]", e26);
                str3 = stackTraceString4;
            }
        }
        if (!z18) {
            try {
                file = new File(str5);
                z19 = file.exists();
            } catch (Exception unused) {
                z19 = false;
            }
            try {
                str4 = com.tencent.open.base.g.b(file);
                j16 = file.length();
            } catch (Exception unused2) {
                j16 = 0;
                QLog.w("AVSoUtils", 1, "LoadExtractedSo,  failed. seq[" + j3 + "], msg1[" + stackTraceString + "], msg2[" + stackTraceString2 + "], msg3[" + str2 + "], msg4[" + str3 + "]");
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("soname", str);
                hashMap.put("existFirst", String.valueOf(z17));
                hashMap.put("existLast", String.valueOf(z19));
                hashMap.put("md5", str4);
                hashMap.put("fileLength", String.valueOf(j16));
                hashMap.put("msg1", O(stackTraceString));
                hashMap.put("msg2", O(stackTraceString2));
                hashMap.put("msg3", O(str2));
                hashMap.put("msg4", O(str3));
                hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("man", O(Build.MANUFACTURER));
                hashMap.put("mod", O(DeviceInfoMonitor.getModel()));
                hashMap.put("qq_ver", String.valueOf(ba.getQQVersion()));
                StatisticCollector.getInstance(context).collectPerformance("", "AV_LOAD_SO_FAILED", false, 0L, 0L, hashMap, "");
                QLog.w("AVSoUtils", 1, "LoadExtractedSo end , result[" + z18 + "], libName[" + str + "], seq[" + j3 + "]");
                return z18;
            }
            QLog.w("AVSoUtils", 1, "LoadExtractedSo,  failed. seq[" + j3 + "], msg1[" + stackTraceString + "], msg2[" + stackTraceString2 + "], msg3[" + str2 + "], msg4[" + str3 + "]");
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("soname", str);
            hashMap2.put("existFirst", String.valueOf(z17));
            hashMap2.put("existLast", String.valueOf(z19));
            hashMap2.put("md5", str4);
            hashMap2.put("fileLength", String.valueOf(j16));
            hashMap2.put("msg1", O(stackTraceString));
            hashMap2.put("msg2", O(stackTraceString2));
            hashMap2.put("msg3", O(str2));
            hashMap2.put("msg4", O(str3));
            hashMap2.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            hashMap2.put("man", O(Build.MANUFACTURER));
            hashMap2.put("mod", O(DeviceInfoMonitor.getModel()));
            hashMap2.put("qq_ver", String.valueOf(ba.getQQVersion()));
            StatisticCollector.getInstance(context).collectPerformance("", "AV_LOAD_SO_FAILED", false, 0L, 0L, hashMap2, "");
        }
        QLog.w("AVSoUtils", 1, "LoadExtractedSo end , result[" + z18 + "], libName[" + str + "], seq[" + j3 + "]");
        return z18;
    }

    public static boolean H() {
        String str;
        String str2;
        new HashMap();
        if (f76657l) {
            return true;
        }
        try {
            BaseApplication context = BaseApplication.getContext();
            SoLoadUtil.m(context, "c++_shared", 0, false);
            SoLoadUtil.m(context, "xplatform", 0, false);
            ResMgr.q();
            String r16 = ResMgr.r();
            f76656k = r16;
            if (TextUtils.isEmpty(r16)) {
                G(0L, context, f76646a, true);
                com.tencent.av.so.b.d("Qav_Rtc_SDK_Load", com.tencent.av.so.b.b(f76647b, l(), "null", true, true, 0));
            } else {
                System.load(f76656k + f76647b);
                ResInfo w3 = ResMgr.q().w(ResInfo.RES_ID_QAV_RTC_SDK_SO);
                if (w3 != null) {
                    com.tencent.av.so.b.d("Qav_Rtc_SDK_Load", com.tencent.av.so.b.b(f76647b, w3.resVersion, w3.resMd5, false, true, 0));
                }
            }
            f76657l = true;
            QLog.i("AVSoUtils", 1, "loadQavRtcSdkSo successfully. sDownloadedgetQAVRTCSDKSoDir = " + f76656k, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        } catch (UnsatisfiedLinkError e16) {
            f76657l = false;
            if (TextUtils.isEmpty(f76656k)) {
                com.tencent.av.so.b.d("Qav_Rtc_SDK_Load", com.tencent.av.so.b.b(f76647b, l(), "null", true, false, 0));
            } else {
                ResInfo w16 = ResMgr.q().w(ResInfo.RES_ID_QAV_RTC_SDK_SO);
                String str3 = f76647b;
                if (w16 == null) {
                    str = "";
                } else {
                    str = w16.resVersion;
                }
                if (w16 == null) {
                    str2 = "";
                } else {
                    str2 = w16.resMd5;
                }
                com.tencent.av.so.b.d("Qav_Rtc_SDK_Load", com.tencent.av.so.b.b(str3, str, str2, false, false, 0));
            }
            QLog.e("AVSoUtils", 1, "loadQavRtcSdkSo failed. err = " + e16.getMessage(), new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
        return f76657l;
    }

    public static void I() {
        String y16 = y();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("printSO, ");
        sb5.append(n(y16 + "DecodeSo"));
        QLog.w("AVSoUtils", 1, sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("printSO, ");
        sb6.append(n(y16 + "libTcHevcDec.so"));
        QLog.w("AVSoUtils", 1, sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("printSO, ");
        sb7.append(n(y16 + "libTcHevcDec2.so"));
        QLog.w("AVSoUtils", 1, sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("printSO, ");
        sb8.append(n(y16 + f76649d));
        QLog.w("AVSoUtils", 1, sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("printSO, ");
        sb9.append(n(y16 + "libqav_utils.so"));
        QLog.w("AVSoUtils", 1, sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("printSO, ");
        sb10.append(n(y16 + "libxplatform.so"));
        QLog.w("AVSoUtils", 1, sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("printSO, ");
        sb11.append(n(y16 + "libc++_shared.so"));
        QLog.w("AVSoUtils", 1, sb11.toString());
        String b16 = com.tencent.mobileqq.util.ak.b(BaseApplication.getContext());
        StringBuilder sb12 = new StringBuilder();
        sb12.append("printSO, ");
        sb12.append(n(b16 + "libc++_shared.so"));
        QLog.w("AVSoUtils", 1, sb12.toString());
    }

    public static String J(String str) {
        QLog.i("AVSoUtils", 1, "processTraeSoLoadFailure start. traeSoFullFilename: " + str);
        String str2 = y() + f76649d;
        if (str.equalsIgnoreCase(str2)) {
            File file = new File(str);
            if (file.exists()) {
                QLog.i("AVSoUtils", 1, "processTraeSoLoadFailure. soFileMd5: " + ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(str));
                file.delete();
            } else {
                QLog.i("AVSoUtils", 1, "processTraeSoLoadFailure. so is not existed.");
            }
            i(BaseApplication.getContext(), f76648c, true);
        } else {
            str = str2;
        }
        QLog.i("AVSoUtils", 1, "processTraeSoLoadFailure end. traeSoFullFilename: " + str);
        return str;
    }

    public static void K(String str, boolean z16, int i3) {
        String i16 = vu.a.c().i(x(f76648c));
        boolean equalsIgnoreCase = str.equalsIgnoreCase(y() + f76649d);
        QLog.i("AVSoUtils", 1, "reportTraeSoLoadResult. traeSoFullFilename: " + str + ", version: " + l() + ", soFileMd5: " + i16 + ", isLoadFromLocal: " + equalsIgnoreCase + ", isLoadSuccess: " + z16 + ", retryCnt: " + i3);
        new HashMap();
        com.tencent.av.so.b.d("Qav_Rtc_SDK_Load", com.tencent.av.so.b.b(f76649d, l(), i16, equalsIgnoreCase, z16, i3));
    }

    public static synchronized void L(Context context, String str) {
        synchronized (AVSoUtils.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("so_sp", 4);
                    String u16 = u(str);
                    String l3 = l();
                    String m3 = m();
                    String string = sharedPreferences.getString(u16, m3);
                    if (TextUtils.equals(l3, string) && !z(l3)) {
                        sharedPreferences.edit().putString(u16, m3).apply();
                    }
                    QLog.i("AVSoUtils", 1, "resetVersionForFailUpgrade, libName[" + str + "], old[" + string + "], cur[" + l3 + "], def[" + m3 + "]");
                }
            }
        }
    }

    public static void M() {
        if (!TextUtils.isEmpty(r()) && !TextUtils.isEmpty(p())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.AVSoUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    AVSoUtils.b();
                    AVSoUtils.a();
                    AVSoUtils.c();
                }
            }, 16, null, false);
            return;
        }
        C();
        B();
        E();
    }

    private static void N(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences == null) {
            return;
        }
        if (z(str)) {
            sharedPreferences.edit().putString(str2, m()).commit();
        } else {
            sharedPreferences.edit().putString(str2, str).commit();
        }
    }

    public static String O(String str) {
        return str.replace(ContainerUtils.KEY_VALUE_DELIMITER, "@1").replace(ContainerUtils.FIELD_DELIMITER, "@2").replace("|", "@3").replace("\"", "@6");
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return B();
    }

    static /* bridge */ /* synthetic */ boolean b() {
        return C();
    }

    static /* bridge */ /* synthetic */ boolean c() {
        return E();
    }

    public static void d() {
        String q16 = q();
        String[] strArr = {"8426156758421E709EFED29E7289A83F", "5445668E9DD196CA64E5BD666FF5B05E", "3C738B9778923BDDC9DE0A4A2E4B8670", "92391145955DE4D436B6FD49C8A7967B", "CC4855EBC55D469BD5C02AABADEDC15E"};
        for (int i3 = 0; i3 < 5; i3++) {
            f(q16 + strArr[i3] + File.separatorChar + "libTcHevcDec2.so");
        }
    }

    public static void e() {
        boolean z16;
        String[] strArr;
        if (!com.tencent.mobileqq.automator.a.f199911b) {
            return;
        }
        if (AVCoreSystemInfo.getCpuArchitecture() <= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        String y16 = y();
        if (z16) {
            strArr = new String[]{"libTcVpxDec-armeabi.so", "libTcVpxEnc-armeabi.so", "libtraeimp-armeabi.so"};
        } else {
            strArr = new String[]{"libTcHevcDec.so", "libTcHevcDec2.so", "libTcHevcEnc.so", "libtraeopus-armeabi.so", "libtraeopus-armeabi-v7a.so"};
        }
        String[] strArr2 = {f76647b, f76649d, "libqav_utils.so", "libTcVpxEnc.so", "libTcVpxDec.so"};
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        arrayList.addAll(Arrays.asList(strArr2));
        arrayList.addAll(Arrays.asList("libSDKCommon.so", "libqav_graphics.so", "libhwcodec.so", "libqav_gaudio_engine.so", "libqav_media_engine.so", "libVideoCtrl.so"));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f(y16 + ((String) it.next()));
        }
        d();
    }

    @VisibleForTesting
    public static void f(String str) {
        boolean z16;
        try {
            File file = new File(str);
            boolean exists = file.exists();
            if (exists) {
                z16 = file.delete();
            } else {
                z16 = false;
            }
            QLog.w("AVSoUtils", 1, "delSoFromCache, soPath[" + str + "], exist[" + exists + "], ret[" + z16 + "]");
        } catch (Exception unused) {
        }
    }

    public static void g(long j3) {
        QLog.i("AVSoUtils", 1, "extractAVModulesFromAssets, seq:" + j3);
        BaseApplication context = BaseApplication.getContext();
        h(j3, context, f76646a, true);
        h(j3, context, f76648c, true);
    }

    public static synchronized boolean h(long j3, Context context, String str, boolean z16) {
        synchronized (AVSoUtils.class) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("so_sp", 4);
            String u16 = u(str);
            String string = sharedPreferences.getString(u16, m());
            String l3 = l();
            String x16 = x(str);
            String string2 = sharedPreferences.getString(x16, "");
            String y16 = y();
            boolean isEmpty = TextUtils.isEmpty(y16);
            File file = new File(y16 + s(str));
            boolean z17 = true;
            QLog.i("AVSoUtils", 1, "extractLibraryFromAssert start. libname[" + str + "], oldVer[" + string + "], newVer[" + l3 + "], soFileMd5[" + string2 + "], needDecodeWith7z[" + z16 + "], istxLibPathEmpty[" + isEmpty + "], txSoFile exists[" + file.exists() + "], seq[" + j3 + "]");
            if (isEmpty) {
                QLog.e("AVSoUtils", 1, "extractLibraryFromAssert failed. txLibPath is empty. libname[" + str + "], oldVer[" + string + "], newVer[" + l3 + "]");
                return false;
            }
            if (TextUtils.equals(string, l3) && file.exists()) {
                QLog.i("AVSoUtils", 1, "extractLibraryFromAssert end but not need extract.");
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                z17 = j(j3, context, file, y16, str, sharedPreferences, l3, u16, z16, false);
                String str2 = "";
                if (z17 && str.equalsIgnoreCase(f76648c)) {
                    str2 = ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getFileMD5String(y16 + s(str));
                    vu.a.c().n(x16, str2);
                }
                QLog.i("AVSoUtils", 1, "extractLibraryFromAssert end. libName[" + str + "], costTime[" + (SystemClock.uptimeMillis() - uptimeMillis) + "], txSoFile exists[" + file.exists() + "], oldSoFileMd5[" + string2 + "], newSoFileMd5[" + str2 + "], seq[" + j3 + "]");
            }
            return z17;
        }
    }

    public static synchronized boolean i(Context context, String str, boolean z16) {
        boolean h16;
        synchronized (AVSoUtils.class) {
            h16 = h(0L, context, str, z16);
        }
        return h16;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0274 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0267 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0262 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean j(long j3, Context context, File file, String str, String str2, SharedPreferences sharedPreferences, String str3, String str4, boolean z16, boolean z17) {
        InputStream inputStream;
        InputStream inputStream2;
        IOException iOException;
        boolean z18;
        boolean z19;
        file.delete();
        if (file.exists()) {
            QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, del fail, seq[" + j3 + "]");
        } else {
            String str5 = "], seq[";
            int i3 = 0;
            if (z16) {
                int s16 = SoLoadUtil.s(context, str, "txlib", s(str2));
                if (file.exists()) {
                    if (s16 != 0) {
                        file.delete();
                        QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, error1, res[" + s16 + "], seq[" + j3 + "]");
                        return false;
                    }
                    N(sharedPreferences, str3, str4);
                    QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, saveSP, versionKey[" + str4 + "], strNewVer[" + str3 + "], seq[" + j3 + "]");
                    return true;
                }
                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, error2, res[" + s16 + "], exists[false], seq[" + j3 + "]");
            } else {
                FileOutputStream fileOutputStream = null;
                try {
                    File file2 = new File(str);
                    if (file2.exists() || file2.mkdir()) {
                        try {
                            inputStream = context.getAssets().open(t() + s(str2));
                        } catch (FileNotFoundException unused) {
                            inputStream = context.getAssets().open(t() + s(str2) + "aa");
                            if (inputStream != null) {
                                try {
                                    inputStream2 = context.getAssets().open(t() + s(str2) + "ab");
                                } catch (IOException e16) {
                                    iOException = e16;
                                    inputStream2 = null;
                                    z18 = z17;
                                    QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                                    if (fileOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (inputStream2 != null) {
                                    }
                                    return z18;
                                } catch (Throwable th5) {
                                    th = th5;
                                    inputStream2 = null;
                                    if (fileOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (inputStream2 != null) {
                                    }
                                }
                            }
                        }
                        inputStream2 = null;
                        if (inputStream != null) {
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(str + s(str2), true);
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                            throw th;
                                        } catch (IOException unused4) {
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e17) {
                                e = e17;
                                iOException = e;
                                z18 = z17;
                                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException unused7) {
                                    }
                                }
                                return z18;
                            }
                        }
                        int i16 = 8192;
                        byte[] bArr = new byte[8192];
                        long j16 = 0;
                        while (inputStream != null) {
                            try {
                                int read = inputStream.read(bArr, i3, i16);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, i3, read);
                                j16 += read;
                                fileOutputStream = fileOutputStream;
                                i16 = 8192;
                                i3 = 0;
                            } catch (IOException e18) {
                                e = e18;
                                iOException = e;
                                z18 = z17;
                                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                return z18;
                            } catch (Throwable th7) {
                                th = th7;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                            }
                        }
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        while (inputStream2 != null) {
                            try {
                                int read2 = inputStream2.read(bArr, 0, 8192);
                                if (read2 == -1) {
                                    break;
                                }
                                FileOutputStream fileOutputStream3 = fileOutputStream2;
                                fileOutputStream3.write(bArr, 0, read2);
                                j16 += read2;
                                fileOutputStream2 = fileOutputStream3;
                                str5 = str5;
                            } catch (IOException e19) {
                                e = e19;
                                fileOutputStream = fileOutputStream2;
                                iOException = e;
                                z18 = z17;
                                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                return z18;
                            } catch (Throwable th8) {
                                th = th8;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                            }
                        }
                        fileOutputStream = fileOutputStream2;
                        String str6 = str5;
                        if (!file.exists()) {
                            QLog.w("AVSoUtils", 1, "extractLibraryFromAssert fail2, seq[" + j3 + "]");
                            z19 = z17;
                        } else if (j16 != file.length()) {
                            file.delete();
                            try {
                                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert,  error 2, seq[" + j3 + "]");
                                z19 = false;
                            } catch (IOException e26) {
                                iOException = e26;
                                z18 = false;
                                QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (inputStream2 != null) {
                                }
                                return z18;
                            }
                        } else {
                            N(sharedPreferences, str3, str4);
                            QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, saveSP1, versionKey[" + str4 + "], strNewVer[" + str3 + str6 + j3 + "]");
                            z19 = true;
                        }
                    } else {
                        z19 = z17;
                        inputStream = null;
                        inputStream2 = null;
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused10) {
                        }
                    }
                    z18 = z19;
                } catch (IOException e27) {
                    iOException = e27;
                    inputStream = null;
                    inputStream2 = null;
                    z18 = z17;
                    QLog.w("AVSoUtils", 1, "extractLibraryFromAssert, IOException, seq[" + j3 + "]", iOException);
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return z18;
                } catch (Throwable th9) {
                    th = th9;
                    inputStream = null;
                    inputStream2 = null;
                    if (fileOutputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                }
                return z18;
            }
        }
        return z17;
    }

    public static String k() {
        String m3 = ResMgr.m();
        if (!TextUtils.isEmpty(m3)) {
            return m3 + f76649d;
        }
        return y() + f76649d;
    }

    public static String l() {
        return AppSetting.l() + SoLoadUtil.h();
    }

    public static String m() {
        return "-1" + SoLoadUtil.h();
    }

    public static String n(String str) {
        String str2;
        File file = new File(str);
        try {
            str2 = com.tencent.qqprotect.singleupdate.a.d(file);
        } catch (Exception unused) {
            str2 = "Exception";
        }
        return ("[" + str + "], exists[" + file.exists()) + "], md5[" + str2 + "]";
    }

    public static String o() {
        return f76654i;
    }

    public static String p() {
        return f76653h;
    }

    @VisibleForTesting
    public static String q() {
        return BaseApplication.getContext().getFilesDir().getParent() + "/files/QWallet/.preloaduni/";
    }

    public static String r() {
        return f76652g;
    }

    public static String s(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    public static String t() {
        return "lib/armeabi/";
    }

    public static String u(String str) {
        return "key_so_version_" + str;
    }

    public static String v() {
        if (vu.a.c().k()) {
            D();
        }
        return f76655j;
    }

    public static String w() {
        if (!TextUtils.isEmpty(f76658m)) {
            return f76658m;
        }
        return "";
    }

    public static String x(String str) {
        return "key_so_file_md5_" + str;
    }

    public static String y() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("AVSoUtils", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + SoLoadCore.PATH_TX_LIB;
    }

    public static boolean z(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.equals(str, "0" + SoLoadUtil.h())) {
                return false;
            }
        }
        return true;
    }
}
