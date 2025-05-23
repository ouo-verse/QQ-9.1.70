package com.tencent.mobileqq.soload.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import com.tencent.mobileqq.soload.api.ISoLoadResService;
import com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService;
import com.tencent.mobileqq.soload.api.ISoLoaderCommonetService;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.impl.m;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoFeatureConfBean;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f288692a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f288693b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, SharedPreferences> f288694c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f288695d;

    /* renamed from: e, reason: collision with root package name */
    private static ISoLoaderBaseCommonetService f288696e;

    /* renamed from: f, reason: collision with root package name */
    private static SoFeatureConfBean f288697f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288694c = new HashMap();
            f288695d = null;
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean A(@NonNull SoLocalInfo soLocalInfo, @NonNull SoLoadInfo soLoadInfo) {
        if (TextUtils.equals(soLocalInfo.mSoPath, soLoadInfo.soPathToLoad) && soLocalInfo.mSoCRC != -1) {
            return true;
        }
        return false;
    }

    public static boolean B() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.QQSO_CLEAN_FILE_WHEN_CRC_FAILED, true);
    }

    public static boolean C() {
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.QQSO_CLEAR_OLD_VERSION_CONFIG, true);
    }

    private static boolean D(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(str2)) {
                return true;
            }
            boolean equals = str.replace(x(str), x(str2)).equals(str2);
            QLog.i("SoLoadWidget.SoLoadUtils", 2, "[isEqualIgnoreHost] :" + equals + ",curUrl:" + str2 + ",localUrl:" + str);
            return equals;
        }
        return false;
    }

    private static boolean E() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private static boolean F(@NonNull SoLocalInfo soLocalInfo, @NonNull SoDetailInfo soDetailInfo) {
        if (!D(soDetailInfo.url, soLocalInfo.mUrl)) {
            return false;
        }
        RelatedFileInfo relatedFileInfo = soDetailInfo.relatedFileInfo;
        if (relatedFileInfo != null && !D(relatedFileInfo.url, soLocalInfo.mRFileUrl)) {
            return false;
        }
        return true;
    }

    public static boolean G() {
        boolean z16 = true;
        if (v().getPriorityConf().getSwitch() != 1) {
            z16 = false;
        }
        QLog.d("SoLoadWidget.SoLoadUtils", 2, "[isPrioritySwitchEnable] enable:" + z16);
        return z16;
    }

    public static boolean H() {
        return MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface;
    }

    private static boolean I(@NonNull SoLocalInfo soLocalInfo, @NonNull SoLoadInfo soLoadInfo, RelatedFileInfo relatedFileInfo) {
        if (relatedFileInfo != null && !TextUtils.equals(soLocalInfo.mRFileFolder, soLoadInfo.rFileFolder)) {
            return false;
        }
        return true;
    }

    private static SoFeatureConfBean J() {
        try {
            return SoFeatureConfBean.parse(new JSONObject(QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeString(SoLoadConstants.QQ_SO_KEY_FEATURE_CONFIG, "")));
        } catch (Exception unused) {
            return new SoFeatureConfBean();
        }
    }

    public static void K(String str) {
        SharedPreferences s16 = s("dynamic_so_load");
        s16.edit().remove(p(str)).apply();
    }

    private static void L(JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString(SoLoadConstants.QQ_SO_KEY_FEATURE_CONFIG, jSONObject.toString());
        }
    }

    public static void M() {
        SharedPreferences s16 = s("dynamic_so_load");
        s16.edit().putLong("key_last_rsp_time", NetConnInfoCenter.getServerTimeMillis()).apply();
    }

    public static void N(LoadParam.LoadItem loadItem, String str) {
        try {
            s("dynamic_so_load").edit().putString(QWalletPreferenceApiImpl.KEY_PREFIX_LAST_SUCC + loadItem.name + u(), str).apply();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void O(LoadParam.LoadItem loadItem, @NonNull SoLoadInfo soLoadInfo) {
        String str;
        long b16;
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoadUtils", 2, "[saveLocalInfo] Path=" + soLoadInfo.soPathToLoad);
        }
        try {
            SoLocalInfo n3 = n(loadItem, soLoadInfo.soDetailInfo);
            RelatedFileInfo relatedFileInfo = soLoadInfo.soDetailInfo.relatedFileInfo;
            boolean A = A(n3, soLoadInfo);
            boolean I = I(n3, soLoadInfo, relatedFileInfo);
            if (A && I) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SoLoadWidget.SoLoadUtils", 2, "[saveLocalInfo] need cal crc or save!");
            }
            String str2 = soLoadInfo.soDetailInfo.url;
            if (relatedFileInfo != null) {
                str = relatedFileInfo.url;
            } else {
                str = null;
            }
            String str3 = str;
            if (A) {
                b16 = n3.mSoCRC;
            } else {
                b16 = a.b(new File(soLoadInfo.soPathToLoad));
            }
            s("dynamic_so_load").edit().putString(p(loadItem.name), new SoLocalInfo(soLoadInfo.getVer(), loadItem.name, soLoadInfo.soPathToLoad, b16, str2, str3, soLoadInfo.rFileFolder).encode()).apply();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void P(com.tencent.mobileqq.soload.entity.a aVar, String str) {
        SharedPreferences s16 = s("so_crash");
        s16.edit().putString(j(str), aVar.b()).apply();
    }

    public static void a(String str, String str2) {
        ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).checkIfClearOldSoVersion(str, str2);
    }

    public static void b() {
        try {
            s("dynamic_so_load").edit().clear().apply();
        } catch (Throwable th5) {
            QLog.e("SoLoadWidget.SoLoadUtils", 1, th5, new Object[0]);
        }
    }

    public static void c(String str) {
        com.tencent.mobileqq.soload.entity.a h16 = h(str);
        if (h16 != null) {
            h16.f288684b = 0;
            h16.f288685c = 0L;
            P(h16, str);
        }
    }

    public static void d(String str) {
        com.tencent.mobileqq.soload.entity.a h16 = h(str);
        if (h16 != null && !h16.g()) {
            h16.f288687e = 0L;
            P(h16, str);
        }
    }

    public static void e(String str, String str2, String str3, boolean z16, OnSoGetPathListener onSoGetPathListener) {
        w().getResPathAsync(str, str2, str3, z16, onSoGetPathListener);
    }

    public static long f() {
        return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
    }

    public static long g() {
        return s("dynamic_so_load").getLong("key_last_rsp_time", 0L);
    }

    public static com.tencent.mobileqq.soload.entity.a h(String str) {
        return com.tencent.mobileqq.soload.entity.a.a(s("so_crash").getString(j(str), ""));
    }

    public static com.tencent.mobileqq.soload.entity.a i(String str, String str2) {
        com.tencent.mobileqq.soload.entity.a h16 = h(str);
        if (h16 != null && h16.f288683a.equals(str2)) {
            return h16;
        }
        return null;
    }

    public static String j(String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("key_crash_info_");
        sb5.append(str);
        if (y()) {
            str2 = "_64";
        } else {
            str2 = "_32";
        }
        sb5.append(str2);
        return sb5.toString();
    }

    public static String k(LoadParam.LoadItem loadItem) {
        try {
            return s("dynamic_so_load").getString(QWalletPreferenceApiImpl.KEY_PREFIX_LAST_SUCC + loadItem.name + u(), "");
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static List<File> l(ClassLoader classLoader) {
        Field field;
        Object obj;
        Field field2;
        List<File> list = null;
        try {
            field = c.b(classLoader, "pathList");
        } catch (NoSuchFieldException e16) {
            e16.printStackTrace();
            field = null;
        }
        if (field == null) {
            return null;
        }
        try {
            obj = field.get(classLoader);
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        try {
            field2 = c.b(obj, "nativeLibraryDirectories");
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            field2 = null;
        }
        if (field2 == null) {
            return null;
        }
        try {
            List<File> list2 = (List) field2.get(obj);
            try {
                list2.addAll((List) c.b(obj, "systemNativeLibraryDirectories").get(obj));
                return list2;
            } catch (IllegalAccessException e19) {
                e = e19;
                list = list2;
                e.printStackTrace();
                return list;
            } catch (NoSuchFieldException e26) {
                e = e26;
                list = list2;
                e.printStackTrace();
                return list;
            }
        } catch (IllegalAccessException e27) {
            e = e27;
        } catch (NoSuchFieldException e28) {
            e = e28;
        }
    }

    private static SoLocalInfo m(LoadParam.LoadItem loadItem, @NonNull SoDetailInfo soDetailInfo) {
        SoLocalInfo n3 = n(loadItem, soDetailInfo);
        String str = n3.mSoPath;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            String resPathSync = w().getResPathSync(loadItem.soFileName, soDetailInfo.url, soDetailInfo.md5);
            QLog.i("SoLoadWidget.SoLoadUtils", 1, "[getLocalInfoByConfig] try get so from sync method,configSoFilePath:" + resPathSync);
            n3.mSoPath = resPathSync;
            n3.mSoCRC = -1L;
        }
        return n3;
    }

    public static SoLocalInfo n(LoadParam.LoadItem loadItem, @NonNull SoDetailInfo soDetailInfo) {
        try {
            SoLocalInfo createSoLocalInfo = SoLocalInfo.createSoLocalInfo(s("dynamic_so_load").getString(p(loadItem.name), ""));
            if (F(createSoLocalInfo, soDetailInfo)) {
                if (QLog.isColorLevel()) {
                    QLog.w("SoLoadWidget.GetSoTaskAsync", 2, "[getLocalInfoFromCache] hit cache: " + loadItem.soFileName);
                }
                return createSoLocalInfo;
            }
        } catch (Throwable th5) {
            QLog.e("SoLoadWidget.SoLoadUtils", 1, th5, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.e("SoLoadWidget.GetSoTaskAsync", 2, "[getLocalInfoFromCache] no cache, use default! " + loadItem.soFileName);
        }
        return new SoLocalInfo();
    }

    public static SoLocalInfo o(LoadParam.LoadItem loadItem, @NonNull SoDetailInfo soDetailInfo) {
        SoLocalInfo m3 = m(loadItem, soDetailInfo);
        m3.mRFileFolder = t(m3, soDetailInfo);
        if (QLog.isColorLevel()) {
            QLog.i("SoLoadWidget.SoLoadUtils", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
        }
        return m3;
    }

    public static String p(String str) {
        String str2 = "_64";
        if (m.f288614a.d(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("key_shiply_local_info_");
            sb5.append(str);
            if (!y()) {
                str2 = "_32";
            }
            sb5.append(str2);
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("key_local_info_");
        sb6.append(str);
        if (!y()) {
            str2 = "_32";
        }
        sb6.append(str2);
        return sb6.toString();
    }

    public static long q(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static long r(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public static SharedPreferences s(String str) {
        Map<String, SharedPreferences> map = f288694c;
        SharedPreferences sharedPreferences = map.get(str);
        if (sharedPreferences == null) {
            SharedPreferences p16 = p03.a.p(MobileQQ.sMobileQQ, str);
            map.put(str, p16);
            return p16;
        }
        return sharedPreferences;
    }

    private static String t(SoLocalInfo soLocalInfo, SoDetailInfo soDetailInfo) {
        String str = soLocalInfo.mRFileFolder;
        if (soDetailInfo.relatedFileInfo != null) {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                ISoLoaderBaseCommonetService w3 = w();
                RelatedFileInfo relatedFileInfo = soDetailInfo.relatedFileInfo;
                String resFolderPathSync = w3.getResFolderPathSync(relatedFileInfo.url, relatedFileInfo.md5);
                QLog.i("SoLoadWidget.SoLoadUtils", 1, "[getRelatedFileInfo] try get rPath from sync method, rFileFolder: " + resFolderPathSync);
                return resFolderPathSync;
            }
            return str;
        }
        return str;
    }

    private static String u() {
        if (y()) {
            return "_arm64_path";
        }
        return "_arm32_path";
    }

    public static SoFeatureConfBean v() {
        if (f288697f == null) {
            synchronized (f.class) {
                if (f288697f == null) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        JSONObject jSONObject = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject(SoLoadConstants.QQ_SO_PRIORITY_FEATURE_SWITCH, "");
                        f288697f = SoFeatureConfBean.parse(jSONObject);
                        L(jSONObject);
                    } else {
                        f288697f = J();
                    }
                    QLog.i("SoLoadWidget.SoLoadUtils", 1, "[getSoFeatureConf] app is " + peekAppRuntime + ",confBean:" + f288697f + ",processName:" + MobileQQ.sMobileQQ.getQQProcessName() + ",mainThread:" + E());
                }
            }
        }
        return f288697f;
    }

    public static ISoLoaderBaseCommonetService w() {
        if (f288696e == null) {
            synchronized (f.class) {
                if (f288696e == null) {
                    f288696e = (ISoLoaderBaseCommonetService) QRoute.api(ISoLoaderCommonetService.class);
                }
            }
            QLog.i("SoLoadWidget.SoLoadUtils", 1, "[getSoLoadOtherService] isQQProcess:" + H());
        }
        return f288696e;
    }

    public static String x(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.e("SoLoadWidget.SoLoadUtils", 1, e16, new Object[0]);
            return "";
        }
    }

    public static boolean y() {
        if (f288695d == null) {
            f288695d = Boolean.TRUE;
        }
        return f288695d.booleanValue();
    }

    public static boolean z(Context context) {
        if (!f288692a) {
            boolean z16 = true;
            f288692a = true;
            if (q(context) != r(context)) {
                z16 = false;
            }
            f288693b = z16;
        }
        QLog.i("SoLoadWidget.SoLoadUtils", 2, "[isAppFirstInstall] " + f288693b);
        return f288693b;
    }
}
