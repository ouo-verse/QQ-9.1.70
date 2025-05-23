package com.tencent.feedback.eup;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.GlobalConfig;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.bm;
import com.tencent.bugly.proguard.ck;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.z;
import com.tencent.feedback.eup.jni.NativeExceptionHandlerRqdImp;
import com.tencent.feedback.eup.jni.NativeExceptionUpload;
import com.tencent.feedback.upload.UploadHandleListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f105552a;

    /* renamed from: b, reason: collision with root package name */
    protected static boolean f105553b;

    /* renamed from: c, reason: collision with root package name */
    protected static CrashStrategyBean f105554c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f105555d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f105556e;

    /* renamed from: f, reason: collision with root package name */
    private static bm f105557f;

    /* renamed from: g, reason: collision with root package name */
    private static ap f105558g;

    /* renamed from: h, reason: collision with root package name */
    private static c f105559h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.feedback.eup.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1113a implements bm {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CrashHandleListener f105560a;

        C1113a(CrashHandleListener crashHandleListener) {
            this.f105560a = crashHandleListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) crashHandleListener);
            }
        }

        @Override // com.tencent.bugly.proguard.bm
        public final boolean a(boolean z16, String str, String str2, String str3, String str4, long j3, String str5, String str6, String str7, String str8) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f105560a.onCrashSaving(z16, str, str2, str3, str4, -1234567890, j3, str5, str6, str7, str8) : ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3, str4, Long.valueOf(j3), str5, str6, str7, str8)).booleanValue();
        }

        @Override // com.tencent.bugly.proguard.bm
        public final boolean b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f105560a.onCrashHandleEnd(z16) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, z16)).booleanValue();
        }

        @Override // com.tencent.bugly.proguard.bm
        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f105560a.onCrashHandleStart(z16);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        @Override // com.tencent.bugly.proguard.bm
        public final String b(boolean z16, String str, String str2, String str3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f105560a.getCrashExtraMessage(z16, str, str2, str3, -1234567890, j3) : (String) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, str3, Long.valueOf(j3));
        }

        @Override // com.tencent.bugly.proguard.bm
        public final byte[] a(boolean z16, String str, String str2, String str3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f105560a.getCrashExtraData(z16, str, str2, str3, -1234567890, j3) : (byte[]) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, str2, str3, Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b implements ap {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadHandleListener f105561a;

        b(UploadHandleListener uploadHandleListener) {
            this.f105561a = uploadHandleListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uploadHandleListener);
            }
        }

        @Override // com.tencent.bugly.proguard.ap
        public final void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f105561a.onUploadStart(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        @Override // com.tencent.bugly.proguard.ap
        public final void a(int i3, ck ckVar, long j3, long j16, boolean z16, String str, String str2, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f105561a.onUploadEnd(i3, ckVar == null ? -1 : ckVar.f98454b, j3, j16, z16, str, str2, j17);
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), ckVar, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), str, str2, Long.valueOf(j17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c extends o {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.bugly.proguard.o
        public String[] getTables() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new String[]{"t_cr"};
        }

        @Override // com.tencent.bugly.proguard.o
        public void init(Context context, boolean z16, BuglyStrategy buglyStrategy) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), buglyStrategy);
                return;
            }
            be a16 = be.a(1003, context, p.f98529c, null, a.f105557f);
            a16.d();
            a16.D = true;
            CrashStrategyBean crashStrategyBean = a.f105554c;
            if (crashStrategyBean != null) {
                a16.C = crashStrategyBean.getCallBackType();
                a16.D = a.f105554c.getCloseErrorCallback();
                if (!a.f105554c.isEnableCatchAnrTrace()) {
                    NativeCrashHandler.getInstance().disableCatchAnrTrace();
                } else {
                    NativeCrashHandler.getInstance().enableCatchAnrTrace();
                }
                ai.a(context).Z = a.f105554c.isEnableRecordAnrMainStack();
            } else {
                NativeCrashHandler.getInstance().enableCatchAnrTrace();
            }
            a16.l();
            if (buglyStrategy != null && !buglyStrategy.isEnableNativeCrashMonitor()) {
                av.a("[crash] Closed native crash monitor!", new Object[0]);
                a16.e();
            } else {
                String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
                ai a17 = ai.a(context);
                if (!ba.b(libBuglySOFilePath)) {
                    a17.B = libBuglySOFilePath;
                }
                NativeExceptionUpload.setmHandler(NativeExceptionHandlerRqdImp.getInstance(context));
                be a18 = be.a();
                if (a18 != null) {
                    a18.f();
                }
            }
            if (buglyStrategy != null && !buglyStrategy.isEnableANRCrashMonitor()) {
                av.a("[crash] Closed ANR monitor!", new Object[0]);
                a16.h();
            } else {
                a16.g();
            }
            bj.a(context);
            aq.a().f98072b = a.f105558g;
            if (buglyStrategy != null) {
                j3 = buglyStrategy.getAppReportDelay();
            } else {
                j3 = 3000;
            }
            a16.a(j3, true);
        }

        @Override // com.tencent.bugly.proguard.o
        public void onServerStrategyChanged(StrategyBean strategyBean) {
            be a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) strategyBean);
            } else if (strategyBean != null && (a16 = be.a()) != null) {
                a16.a(strategyBean);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f105552a = false;
        f105553b = true;
        f105554c = null;
        f105555d = false;
        f105556e = false;
        f105557f = null;
        f105558g = null;
        f105559h = new c();
    }

    public static void A(String str) {
        if (!ba.b(str) && ba.c(str)) {
            f105555d = true;
            ak.a(str);
            StrategyBean.f97836a = str;
            StrategyBean.f97837b = str;
            return;
        }
        av.d("URL is invalid.", new Object[0]);
    }

    public static void B(String str) {
        String d16 = ba.d(str);
        VersionLabelWrapper.setTestLabels(d16);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setTestLabel(d16);
        }
    }

    public static void C(Context context, String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 100) {
            String substring = str.substring(0, 100);
            av.d("userId %s length is over limit %d substring to %s", str, 100, substring);
            str = substring;
        }
        if (str.equals(ai.a(context).g())) {
            return;
        }
        ai a16 = ai.a(context);
        synchronized (a16.f97994ac) {
            a16.f98025m = str;
        }
        av.b("[user] set userId : %s", str);
        if (t.f98554a) {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            t.a();
        }
    }

    public static void D(boolean z16) {
        s.a(z16);
    }

    public static void E() {
        if (!f105552a) {
            Log.e(av.f98116b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
        } else {
            av.a("start to create a anr crash for test!", new Object[0]);
            be.a().i();
        }
    }

    public static void F() {
        if (!f105552a) {
            Log.e(av.f98116b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
            return;
        }
        throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
    }

    public static void G(boolean z16, boolean z17, boolean z18) {
        if (!f105552a) {
            Log.e(av.f98116b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
        } else {
            av.a("start to create a native crash for test!", new Object[0]);
            be.a().a(z16, z17, z18);
        }
    }

    public static void H(boolean z16) {
        av.d("update standalone mode: %s", Boolean.valueOf(z16));
        GlobalConfig.updateStandaloneMode(z16);
    }

    private static void b(Context context, String str, String str2) {
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.putKeyValueToNative(str, str2);
        }
        ai.a(context).a(str, str2);
    }

    public static String d(Context context, String str) {
        if (context == null) {
            av.d("getUserDataValue args context should not be null", new Object[0]);
            return null;
        }
        if (ba.b(str)) {
            return null;
        }
        return ai.a(context).i(str);
    }

    public static boolean e(final Thread thread, final Throwable th5, final String str, final byte[] bArr, final boolean z16) {
        final be a16 = be.a();
        if (a16 != null) {
            if (!z.a("error_portal_ratio")) {
                av.d("java error report is disabled, please modify your project's setting", new Object[0]);
                return true;
            }
            ThreadManager.runInLogThread(new Runnable() { // from class: com.tencent.bugly.proguard.be.3

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ boolean f98235a = false;

                /* renamed from: g, reason: collision with root package name */
                final /* synthetic */ boolean f98241g = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        av.c("post a throwable %b", Boolean.valueOf(this.f98235a));
                        be.this.G.a(thread, th5, false, str, bArr, z16);
                        if (this.f98241g) {
                            av.a("clear user datas", new Object[0]);
                            ai.a(be.this.E).v();
                        }
                    } catch (Throwable th6) {
                        if (!av.b(th6)) {
                            th6.printStackTrace();
                        }
                        av.e("java catch error: %s", th5.toString());
                    }
                }
            }, 0L);
            return true;
        }
        Log.w(av.f98116b, "Can not handle catch exception because bugly is disable.");
        return false;
    }

    public static void f(Context context, String str, boolean z16, CrashStrategyBean crashStrategyBean, long j3) {
        String str2;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (context == null || f105552a) {
            return;
        }
        if (GlobalConfig.isInStandaloneMode()) {
            Log.w("eup", "init bugly fail for app in standalone mode.");
            return;
        }
        ContextUtil.setGlobalContext(context);
        be.f98209c = 1;
        ai.a(context).T = true;
        be.f98208b = true;
        ak.f98043b = 21600000L;
        f105554c = crashStrategyBean;
        av.f98116b = "eup";
        av.f98115a = "eup";
        if (!f105555d) {
            StrategyBean.f97836a = "https://android.rqd.qq.com/analytics/async";
            StrategyBean.f97837b = "https://android.rqd.qq.com/analytics/async";
        }
        BuglyStrategy buglyStrategy = new BuglyStrategy();
        buglyStrategy.setAppReportDelay(j3);
        if (crashStrategyBean != null) {
            CrashHandleListener crashHandler = crashStrategyBean.getCrashHandler();
            if (crashHandler != null) {
                f105557f = new C1113a(crashHandler);
                be a16 = be.a();
                if (a16 != null) {
                    a16.a(f105557f);
                }
            }
            UploadHandleListener uploadListener = crashStrategyBean.getUploadListener();
            if (uploadListener != null) {
                f105558g = new b(uploadListener);
                aq a17 = aq.a();
                if (a17 != null) {
                    a17.f98072b = f105558g;
                }
            }
            be.f98217k = crashStrategyBean.getRecordOverDays() * 24 * 3600 * 1000;
            be.f98218l = crashStrategyBean.getOnlyLogTag();
            be.f98219m = crashStrategyBean.isStoreCrashSdcard();
            be.f98220n = crashStrategyBean.getStoreDirectoryPath();
            be.f98221o = crashStrategyBean.getCrashSdcardMaxSize();
            be.f98211e = crashStrategyBean.getMaxLogLength();
            be.f98215i = crashStrategyBean.getMaxStackLength();
            be.f98210d = crashStrategyBean.isMerged();
            be.f98222p = crashStrategyBean.isUploadSpotCrash();
            buglyStrategy.setEnableANRCrashMonitor(crashStrategyBean.isEnableANRCrashMonitor());
            buglyStrategy.setEnableNativeCrashMonitor(crashStrategyBean.isEnableNativeCrashMonitor());
            buglyStrategy.setUploadProcess(crashStrategyBean.isUploadProcess());
            buglyStrategy.setEnableUserInfo(f105553b);
            ai.a(context).f98018f = crashStrategyBean.isUploadProcess();
        }
        if (!f105556e && (str2 = ai.a(context).f98032t) != null && !ba.b(str2)) {
            int i3 = 0;
            for (char c16 : str2.toCharArray()) {
                if (c16 == '.') {
                    i3++;
                }
            }
            if (i3 < 3) {
                String str3 = str2 + "." + ai.a(context).N;
                ai.a(context).f98032t = str3;
                av.a("rqdp{ RQD version: %s }", str3);
            }
        }
        p.a(f105559h);
        p.a(context, str, z16, buglyStrategy, uptimeMillis);
        f105552a = true;
    }

    public static boolean g() {
        return f105552a;
    }

    public static void h(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map) {
        if (!p.f98527a) {
            Log.w(av.f98116b, "Can not post crash caught because bugly is disable.");
        } else {
            bj.a(thread, i3, str, str2, str3, map);
        }
    }

    public static void i(Context context, String str, String str2) {
        int i3;
        if (context == null) {
            av.d("putUserData args context should not be null", new Object[0]);
            return;
        }
        if (ba.b(str)) {
            av.d("putUserData args key should not be null", new Object[0]);
            return;
        }
        if (ba.b(str2)) {
            av.d("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (!str.matches("[a-zA-Z[0-9]_]+")) {
            av.d("putUserData args key should match [a-zA-Z[0-9]_]+  {" + str + "}", new Object[0]);
            return;
        }
        av.b("[param] set user ret: %s, data: %s - %s", Boolean.valueOf(com.tencent.rmonitor.custom.b.a().putUserData("C03_".concat(str), str2)), str, str2);
        if (str.contains("_userParam_")) {
            i3 = 4000;
        } else {
            i3 = 200;
        }
        if (str2.length() > i3) {
            av.d("user data value length over limit %d , has been cutted!", Integer.valueOf(i3));
            str2 = str2.substring(0, i3);
        }
        ai a16 = ai.a(context);
        if (a16.x().contains(str)) {
            av.b("[param] replace user data: %s - %s", str, str2);
            b(context, str, str2);
        } else if (a16.w() >= 500) {
            av.d("user data size is over limit %d , will drop this new key %s", 50, str);
        } else if (str.length() > 50) {
            av.d("user data key length over limit %d , will drop this new key %s", 50, str);
        } else {
            av.b("[param] set user data: %s - %s", str, str2);
            b(context, str, str2);
        }
    }

    public static boolean j() {
        if (!f105552a) {
            av.d("reRegisterHandler failed, please call initCrashReport first", new Object[0]);
            return false;
        }
        if (be.a() == null) {
            return false;
        }
        be.a().b();
        return true;
    }

    public static String k(Context context, String str) {
        if (context == null) {
            av.d("removeUserData args context should not be null", new Object[0]);
            return null;
        }
        if (ba.b(str)) {
            return null;
        }
        av.b("[param] remove user data: %s - %s", str, com.tencent.rmonitor.custom.b.a().t("C03_".concat(String.valueOf(str))));
        return ai.a(context).h(str);
    }

    public static void l(boolean z16) {
        try {
            be a16 = be.a();
            if (a16 != null) {
                if (z16) {
                    av.c("startANRMonitor", new Object[0]);
                    a16.g();
                } else {
                    av.c("stopANRMonitor", new Object[0]);
                    a16.h();
                }
            }
        } catch (Exception e16) {
            av.b(e16);
        }
    }

    public static boolean m(String[] strArr) {
        if (f105552a && p.f98527a) {
            if (strArr != null && strArr.length <= 10) {
                ArrayList<String> arrayList = new ArrayList<>();
                for (String str : strArr) {
                    if (!ba.b(str)) {
                        File file = new File(str);
                        if (file.exists() && file.isFile()) {
                            arrayList.add(str);
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    av.d("setAdditionalAttachmentPaths failed for all empty files", new Object[0]);
                    return false;
                }
                if (NativeCrashHandler.getInstance() != null) {
                    return NativeCrashHandler.getInstance().setAdditionalAttachmentPaths(arrayList);
                }
                av.d("setAdditionalAttachmentPaths failed, NativeCrashHandler is null", new Object[0]);
                return false;
            }
            av.d("setAdditionalAttachmentPaths failed for params check", new Object[0]);
            return false;
        }
        av.d("setAdditionalAttachmentPaths failed.", new Object[0]);
        return false;
    }

    public static void n(Context context, boolean z16, boolean z17) {
        ai a16 = ai.a(context);
        a16.X = z16;
        a16.Y = z17;
    }

    public static void o(Context context, String str) {
        if (context == null) {
            Log.w(av.f98116b, "setAppChannel args context should not be null");
            return;
        }
        if (str == null) {
            return;
        }
        ai.a(context).f98035w = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HotPatchWrapper.getInstance().setHotPatchNumCustom(str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setAppHotPatchNum(HotPatchWrapper.getInstance().getAppHotPatchNum());
        }
        av.a("set app hot patch num: %s", str);
    }

    public static void q(String str) {
        String d16 = ba.d(str);
        VersionLabelWrapper.setCaseLabels(d16);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setCaseLabel(d16);
        }
    }

    public static void r(Context context, String str) {
        ai.a(context).f98031s = String.valueOf(str);
    }

    public static void s(boolean z16) {
        w.f98578a = z16;
    }

    public static void t(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ai.a(context).b(str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeDeviceId(str);
            }
        }
    }

    public static void u(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ai.a(context).c(str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeDeviceModel(str);
            }
        }
    }

    public static void v(boolean z16) {
        be a16 = be.a();
        if (a16 != null) {
            if (z16) {
                a16.d();
            } else {
                a16.c();
            }
        }
    }

    public static void w(boolean z16) {
        be a16 = be.a();
        if (a16 != null) {
            if (z16) {
                a16.f();
            } else {
                a16.e();
            }
        }
    }

    public static void x(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                av.d("appVersion %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            f105556e = true;
            ai.a(context).f98032t = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void y(ArrayList<String> arrayList) {
        WeChatBacktrace.setQutLibraryPath(arrayList);
    }

    public static void z(String str) {
        ai c16 = ai.c();
        if (c16 == null) {
            av.d("Can not set RDM UUID if RQD has not been initialized.", new Object[0]);
            return;
        }
        c16.O = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppBuildNum(str);
        }
    }
}
