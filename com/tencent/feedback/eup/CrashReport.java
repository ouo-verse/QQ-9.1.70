package com.tencent.feedback.eup;

import android.content.Context;
import android.util.Log;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rmonitor.base.thread.suspend.ThreadSuspend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CrashReport {
    static IPatchRedirector $redirector_ = null;
    public static final String ServerHostTypeBuglyOversea = "https://android.bugly.tencent.com";
    public static final String ServerHostTypeBuglyPreTest = "https://pre.rmonitor.qq.com";
    public static final String ServerHostTypeBuglyPro = "https://pro.bugly.qq.com";
    public static final String ServerHostTypeBuglyProTest = "https://t.pro.bugly.qq.com";
    public static final String ServerHostTypeDefault = "https://rmonitor.qq.com";
    public static final String ServerHostTypeDefaultTest = "https://t.rmonitor.qq.com";

    public CrashReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Deprecated
    public static boolean addPlugin(Context context, String str, String str2, String str3) {
        return ai.a(context).a(str, str2, str3);
    }

    @Deprecated
    public static void addSoFiles(Context context, List<SoFile> list) {
        if (context == null) {
            av.d("addSoFiles args context should not be null", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            ai a16 = ai.a(context);
            HashMap hashMap = new HashMap(list.size());
            for (SoFile soFile : list) {
                hashMap.put("sosha1_" + soFile.sha1, new PlugInBean(soFile.fileName, soFile.arch, soFile.sha1));
            }
            a16.b(hashMap);
        }
    }

    @Deprecated
    public static void clearSDKTotalConsume() {
        aq a16 = aq.a();
        if (a16 != null) {
            List<ag> a17 = a16.f98071a.a(3);
            if (a17 != null && a17.size() != 0) {
                a16.f98073c = 0L;
                a16.f98071a.a(a17);
                av.c("[UploadManager] Clear network consume.", new Object[0]);
            }
            List<ag> a18 = a16.f98071a.a(5);
            if (a18 != null && a18.size() != 0) {
                a16.f98074d = 0L;
                a16.f98071a.a(a18);
                av.c("[UploadManager] Clear network consume of stuck.", new Object[0]);
            }
        }
    }

    @Deprecated
    public static int countExceptionDatas() {
        List<CrashDetailBean> a16;
        if (be.a() == null || (a16 = bd.a()) == null) {
            return 0;
        }
        return a16.size();
    }

    @Deprecated
    public static int countStoredRecord() {
        return countExceptionDatas();
    }

    @Deprecated
    public static boolean doUploadExceptionDatas() {
        be a16 = be.a();
        if (a16 == null) {
            return false;
        }
        a16.a(0L, false);
        return true;
    }

    public static boolean enableHookJavaStackTrace(boolean z16, boolean z17) {
        return ThreadSuspend.c().a(z16, z17);
    }

    @Deprecated
    public static boolean enableNativeSubProcess(boolean z16) {
        av.a("sorry, enableNativeSubProcess interface is deprecated, please use native_sub_process config", new Object[0]);
        return false;
    }

    @Deprecated
    public static void filterSysLog(boolean z16, boolean z17) {
        NativeCrashHandler nativeCrashHandler;
        if (z16 && (nativeCrashHandler = NativeCrashHandler.getInstance()) != null) {
            nativeCrashHandler.filterSigabrtSysLog();
        }
        be.f98223q = z17;
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (context == null) {
            av.d("getAllUserDataKeys args context should not be null", new Object[0]);
            return null;
        }
        return ai.a(context).x();
    }

    @Deprecated
    public static CrashStrategyBean getCrashRuntimeStrategy() {
        return a.f105554c;
    }

    @Deprecated
    public static String getDeviceID(Context context) {
        return ai.a(context).h();
    }

    @Deprecated
    public static byte[] getExceptionDatas(Context context) {
        if (be.a() != null) {
            be a16 = be.a();
            return a16.f98229w.b(bd.a());
        }
        return null;
    }

    public static String getProcessLaunchId() {
        return TraceGenerator.getProcessLaunchId();
    }

    public static String getRomFingerPrint() {
        try {
            ai c16 = ai.c();
            if (c16 == null) {
                return "";
            }
            return c16.t();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Deprecated
    public static long getSDKTotalConsume() {
        aq a16 = aq.a();
        if (a16 != null) {
            return a16.a(false);
        }
        return -1L;
    }

    public static String getUserData(Context context, String str) {
        return a.d(context, str);
    }

    public static int getUserDatasSize(Context context) {
        if (context == null) {
            av.d("getUserDatasSize args context should not be null", new Object[0]);
            return -1;
        }
        return ai.a(context).w();
    }

    @Deprecated
    public static int getUserSceneTagId(Context context) {
        if (context == null) {
            av.d("getUserSceneTagId args context should not be null", new Object[0]);
            return -1;
        }
        return ai.a(context).A();
    }

    public static boolean handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr) {
        return handleCatchException(thread, th5, str, bArr, true);
    }

    public static void initCrashReport(Context context, String str, boolean z16) {
        initCrashReport(context, str, z16, null);
    }

    @Deprecated
    public static boolean needUploadCrash() {
        if (countExceptionDatas() > 0) {
            return true;
        }
        return false;
    }

    public static void postException(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map) {
        a.h(thread, i3, str, str2, str3, map);
    }

    static void putReservedRequestData(String str, String str2) {
        if (VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY.equals(str)) {
            VersionLabelWrapper.setShiplyVersionLabel(str2);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setAppVersionLabel(str2);
                return;
            }
            return;
        }
        if ("TestLabel".equals(str)) {
            setTestLabels(str2);
        } else {
            av.d("Failed to put reserved request data, key is null or illegal.", new Object[0]);
        }
    }

    @Deprecated
    public static void putUploadRequestData(Context context, String str, String str2) {
        if (context == null) {
            av.d("putUploadRequestData args context should not be null", new Object[0]);
            return;
        }
        if (ba.b(str)) {
            av.d("putUploadRequestData args key should not be null", new Object[0]);
            return;
        }
        if (ba.b(str2)) {
            av.d("putUploadRequestData args value should not be null", new Object[0]);
            return;
        }
        if (!str.matches("[a-zA-Z[0-9]]+")) {
            av.d("putUploadRequestData args key should match [a-zA-Z[0-9]_]+  {" + str + "}", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            av.d("upload request data value length over limit %d , has been cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        if (str.length() > 50) {
            av.d("upload request data key length over limit %d , will drop this new key %s", 50, str);
        } else {
            ai.a(context).a(str, str2, false);
            av.b("[param] put upload request data: %s - %s", str, str2);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        a.i(context, str, str2);
    }

    public static boolean reRegisterHandler() {
        return a.j();
    }

    @Deprecated
    public static void removePlugin(Context context, String str) {
        ai.a(context).g(str);
    }

    public static String removeUserData(Context context, String str) {
        return a.k(context, str);
    }

    @Deprecated
    public static void setAPKSHa1(Context context, String str) {
        ai.a(context).f98024l = str;
        av.c("set sha1 %s", str);
    }

    public static boolean setAdditionalAttachmentPaths(String[] strArr) {
        return a.m(strArr);
    }

    public static void setAllThreadStackEnable(Context context, boolean z16, boolean z17) {
        a.n(context, z16, z17);
    }

    public static void setAppChannel(Context context, String str) {
        a.o(context, str);
    }

    public static void setAppHotPatchNum(String str) {
        a.p(str);
    }

    public static void setCaseLabels(String str) {
        a.q(str);
    }

    @Deprecated
    public static void setCollectPrivacyInfo(Context context, boolean z16) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not set collect privacy info enable because bugly is disable.");
        } else if (context == null) {
            Log.w(av.f98116b, "setCollectPrivacyInfo args context should not be null");
        } else {
            Log.i(av.f98116b, "setCollectPrivacyInfo: ".concat(String.valueOf(z16)));
            ai.a(context).f98030r = z16;
        }
    }

    public static void setCountryName(Context context, String str) {
        a.r(context, str);
    }

    @Deprecated
    public static void setCrashFilter(String str) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not set App package because bugly is disable.");
        } else {
            Log.i(av.f98116b, "Set crash stack filter: ".concat(String.valueOf(str)));
            be.f98227u = str;
        }
    }

    @Deprecated
    public static void setCrashRegularFilter(String str) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not set App package because bugly is disable.");
        } else {
            Log.i(av.f98116b, "Set crash stack filter: ".concat(String.valueOf(str)));
            be.f98228v = str;
        }
    }

    public static void setCrashReportAble(boolean z16) {
        a.v(z16);
    }

    public static void setDatabaseCloseAfterUse(boolean z16) {
        ae.f97953a = z16;
    }

    @Deprecated
    public static void setDengtaAppKey(Context context, String str) {
        ai.a(context).f98017e = str;
    }

    public static void setDeviceId(Context context, String str) {
        a.t(context, str);
    }

    public static void setDeviceModel(Context context, String str) {
        a.u(context, str);
    }

    public static void setDeviceRooted(Context context, boolean z16) {
        ai.a(context).f98036x = Boolean.valueOf(z16);
    }

    @Deprecated
    public static void setDumpFilePath(Context context, String str) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not set App version because bugly is disable.");
            return;
        }
        if (context == null) {
            Log.w(av.f98116b, "setTombPath args context should not be null");
        } else if (str == null) {
            Log.w(av.f98116b, "tombstone path is null, will not set");
        } else {
            Log.i(av.f98116b, "user set tombstone path: ".concat(str));
            NativeCrashHandler.setDumpFilePath(str);
        }
    }

    public static void setIsAppForeground(Context context, int i3, boolean z16) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not set app fore ground because bugly is disable.");
            return;
        }
        if (context == null) {
            av.d("Context should not be null.", new Object[0]);
            return;
        }
        ai.a(context).a(z16);
        av.a("Set app fore ground: " + z16 + ", service hash: " + i3, new Object[0]);
    }

    @Deprecated
    public static void setIsDevelopmentDevice(Context context, boolean z16) {
        if (context == null) {
            av.d("Context should not be null.", new Object[0]);
            return;
        }
        if (z16) {
            av.c("This is a development device.", new Object[0]);
        } else {
            av.c("This is not a development device.", new Object[0]);
        }
        ai.a(context).Q = z16;
    }

    public static void setNativeCrashReportAble(boolean z16) {
        a.w(z16);
    }

    public static void setProductVersion(Context context, String str) {
        a.x(context, str);
    }

    public static void setQutLibraryPath(ArrayList<String> arrayList) {
        a.y(arrayList);
    }

    public static void setRdmUuid(String str) {
        a.z(str);
    }

    @Deprecated
    public static void setSOFile(Context context, List<SoFile> list) {
        if (context == null) {
            av.d("setSOFile args context should not be null", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            ai a16 = ai.a(context);
            HashMap hashMap = new HashMap(list.size());
            for (SoFile soFile : list) {
                hashMap.put("sosha1_" + soFile.sha1, new PlugInBean(soFile.fileName, soFile.arch, soFile.sha1));
            }
            a16.a(hashMap);
        }
    }

    public static boolean setServerHostType(String str) {
        return BuildConfigWrapper.setDomain(str);
    }

    public static void setServerUrl(String str) {
        a.A(str);
    }

    public static void setTestLabels(String str) {
        a.B(str);
    }

    @Deprecated
    public static void setThreadPoolService(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            at.a().a(scheduledExecutorService);
        }
    }

    public static void setUserId(Context context, String str) {
        a.C(context, str);
    }

    @Deprecated
    public static void setUserInfoEnable(boolean z16) {
        a.f105553b = z16;
    }

    public static void setUserInfoReportOpt(boolean z16) {
        a.D(z16);
    }

    @Deprecated
    public static void setUserSceneTag(Context context, int i3) {
        if (context == null) {
            av.d("setTag args context should not be null", new Object[0]);
            return;
        }
        if (i3 <= 0) {
            av.d("setTag args tagId should > 0", new Object[0]);
            return;
        }
        ai a16 = ai.a(context);
        synchronized (a16.f97993ab) {
            int i16 = a16.E;
            if (i16 != i3) {
                a16.E = i3;
                av.a("user scene tag %d changed to tag %d", Integer.valueOf(i16), Integer.valueOf(a16.E));
            }
        }
        av.b("[param] set user scene tag: %d", Integer.valueOf(i3));
    }

    public static void testANRCrash() {
        a.E();
    }

    public static void testJavaCrash() {
        a.F();
    }

    public static void testNativeCrash() {
        testNativeCrash(false, true, false);
    }

    @Deprecated
    static void triggerUserInfoUpload() {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not upload user info because bugly is disable.");
            return;
        }
        if (a.f105552a && t.f98555b != null) {
            av.c("trigger upload user info", new Object[0]);
            final s sVar = t.f98555b;
            if (sVar.b()) {
                final UserInfoBean a16 = s.a(sVar.f98538b, 8);
                s.a(a16);
                at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.s.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.a(Collections.singletonList(a16), true);
                    }
                });
                return;
            }
            return;
        }
        Log.w(av.f98116b, "Can not upload user info because bugly is not init.");
    }

    public static void updateStandaloneMode(boolean z16) {
        a.H(z16);
    }

    @Deprecated
    public static void uploadUserInfo() {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not upload user info because bugly is disable.");
            return;
        }
        s sVar = t.f98555b;
        if (sVar == null) {
            Log.w(av.f98116b, "Can not upload user info because bugly is not init.");
        } else {
            sVar.c();
        }
    }

    public static boolean handleCatchException(Thread thread, Throwable th5, String str, byte[] bArr, boolean z16) {
        return a.e(thread, th5, str, bArr, z16);
    }

    public static void initCrashReport(Context context, String str, boolean z16, CrashStrategyBean crashStrategyBean) {
        initCrashReport(context, str, z16, crashStrategyBean, 0L);
    }

    public static void postException(int i3, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i3, str, str2, str3, map);
    }

    public static void testNativeCrash(boolean z16, boolean z17, boolean z18) {
        a.G(z16, z17, z18);
    }

    public static void initCrashReport(Context context, String str, boolean z16, CrashStrategyBean crashStrategyBean, long j3) {
        a.f(context, str, z16, crashStrategyBean, j3);
    }
}
