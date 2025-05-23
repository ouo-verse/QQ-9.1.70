package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.common.cache.ProcessContextWrapper;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ao;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.manager.LinkDataWrapper;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f98527a = true;

    /* renamed from: b, reason: collision with root package name */
    public static List<o> f98528b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f98529c;

    /* renamed from: d, reason: collision with root package name */
    private static ae f98530d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f98531e;

    /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[Catch: all -> 0x040f, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0009, B:6:0x000e, B:11:0x001a, B:15:0x0026, B:19:0x0031, B:21:0x0035, B:22:0x0079, B:24:0x00ad, B:28:0x00b9, B:29:0x00bb, B:33:0x00cc, B:34:0x00ce, B:35:0x00e0, B:37:0x0101, B:41:0x011e, B:44:0x0122, B:46:0x013d, B:48:0x0143, B:49:0x015a, B:51:0x016a, B:53:0x0170, B:55:0x017a, B:57:0x0180, B:58:0x0197, B:59:0x01c5, B:60:0x01da, B:62:0x01e4, B:64:0x01ea, B:65:0x0202, B:66:0x0212, B:68:0x0218, B:70:0x021e, B:71:0x0236, B:72:0x0243, B:74:0x0249, B:75:0x0256, B:76:0x0268, B:83:0x0296, B:93:0x0299, B:96:0x02a8, B:99:0x02b0, B:101:0x02ba, B:102:0x02cf, B:108:0x02ff, B:110:0x033a, B:111:0x0345, B:113:0x034f, B:114:0x0352, B:116:0x0358, B:117:0x036d, B:119:0x0383, B:120:0x03d1, B:131:0x03c3, B:133:0x02e9, B:135:0x02fc, B:136:0x02c5, B:87:0x028d, B:89:0x0293, B:139:0x01a8, B:141:0x01b3, B:143:0x01be, B:145:0x01d3, B:147:0x01d7, B:148:0x0109, B:150:0x0112, B:124:0x038c, B:126:0x03a2, B:129:0x03b9, B:104:0x02d2, B:106:0x02da, B:79:0x0270, B:81:0x0280), top: B:3:0x0009, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0122 A[Catch: all -> 0x040f, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0009, B:6:0x000e, B:11:0x001a, B:15:0x0026, B:19:0x0031, B:21:0x0035, B:22:0x0079, B:24:0x00ad, B:28:0x00b9, B:29:0x00bb, B:33:0x00cc, B:34:0x00ce, B:35:0x00e0, B:37:0x0101, B:41:0x011e, B:44:0x0122, B:46:0x013d, B:48:0x0143, B:49:0x015a, B:51:0x016a, B:53:0x0170, B:55:0x017a, B:57:0x0180, B:58:0x0197, B:59:0x01c5, B:60:0x01da, B:62:0x01e4, B:64:0x01ea, B:65:0x0202, B:66:0x0212, B:68:0x0218, B:70:0x021e, B:71:0x0236, B:72:0x0243, B:74:0x0249, B:75:0x0256, B:76:0x0268, B:83:0x0296, B:93:0x0299, B:96:0x02a8, B:99:0x02b0, B:101:0x02ba, B:102:0x02cf, B:108:0x02ff, B:110:0x033a, B:111:0x0345, B:113:0x034f, B:114:0x0352, B:116:0x0358, B:117:0x036d, B:119:0x0383, B:120:0x03d1, B:131:0x03c3, B:133:0x02e9, B:135:0x02fc, B:136:0x02c5, B:87:0x028d, B:89:0x0293, B:139:0x01a8, B:141:0x01b3, B:143:0x01be, B:145:0x01d3, B:147:0x01d7, B:148:0x0109, B:150:0x0112, B:124:0x038c, B:126:0x03a2, B:129:0x03b9, B:104:0x02d2, B:106:0x02da, B:79:0x0270, B:81:0x0280), top: B:3:0x0009, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, String str, boolean z16, BuglyStrategy buglyStrategy, final long j3) {
        boolean z17;
        byte[] bArr;
        synchronized (p.class) {
            if (f98531e) {
                av.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(av.f98116b, "[init] context is null, check it.");
                return;
            }
            if (str == null) {
                Log.e(av.f98116b, "init arg 'crashReportAppID' should not be null!");
                return;
            }
            f98531e = true;
            if (z16) {
                f98529c = true;
                av.f98117c = true;
                av.d("Bugly debug\u6a21\u5f0f\u5f00\u542f\uff0c\u8bf7\u5728\u53d1\u5e03\u65f6\u628aisDebug\u5173\u95ed\u3002 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                av.e("--------------------------------------------------------------------------------------------", new Object[0]);
                av.d("Bugly debug\u6a21\u5f0f\u5c06\u6709\u4ee5\u4e0b\u884c\u4e3a\u7279\u6027 -- The following list shows the behaviour of debug model: ", new Object[0]);
                av.d("[1] \u8f93\u51fa\u8be6\u7ec6\u7684Bugly SDK\u7684Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                av.d("[2] \u6bcf\u4e00\u6761Crash\u90fd\u4f1a\u88ab\u7acb\u5373\u4e0a\u62a5 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                av.d("[3] \u81ea\u5b9a\u4e49\u65e5\u5fd7\u5c06\u4f1a\u5728Logcat\u4e2d\u8f93\u51fa -- Custom log will be output to logcat.", new Object[0]);
                av.e("--------------------------------------------------------------------------------------------", new Object[0]);
                av.b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            av.a(" crash report start initializing...", new Object[0]);
            av.b("[init] Bugly start initializing...", new Object[0]);
            av.a("[init] Bugly complete version: v%s", "4.4.3");
            final Context a16 = ba.a(context);
            ai a17 = ai.a(a16);
            com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("crash");
            if (d16 instanceof v) {
                int i3 = ((v) d16).f98575c;
                if (i3 > 0 && i3 < 1024000) {
                    be.f98211e = i3;
                }
                long j16 = ((v) d16).f98576d;
                if (j16 > 0 && j16 < 10) {
                    be.f98224r = j16;
                }
                ai.a(a16).f97992aa = ((v) d16).f98574b;
                NativeCrashHandler.setCustomFileUploadAble(((v) d16).f98573a);
            }
            a17.p();
            ay.a(a16);
            f98530d = ae.a(a16, f98528b);
            aq.a(a16);
            ak.a(a16, f98528b);
            ac a18 = ac.a(a16);
            List<String> list = a17.D;
            if (list == null || !list.contains("bugly")) {
                if (z.a("crash_portal_ratio")) {
                    z17 = false;
                    if (!z17) {
                        f98527a = false;
                        return;
                    }
                    a17.a(str);
                    av.a("[param] Set APP ID:%s", str);
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            av.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        a17.f98032t = appVersion;
                        av.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    av.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f98530d.a(PlayerResources.ViewId.CONTROLLER_PROGRESS, "app_channel", appChannel.getBytes(), false);
                                a17.f98035w = appChannel;
                            }
                        } else {
                            Map<String, byte[]> a19 = f98530d.a(PlayerResources.ViewId.CONTROLLER_PROGRESS, (ad) null);
                            if (a19 != null && (bArr = a19.get("app_channel")) != null) {
                                a17.f98035w = new String(bArr);
                            }
                        }
                        av.a("[param] Set App channel: %s", a17.f98035w);
                    } catch (Exception e16) {
                        if (f98529c) {
                            e16.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            av.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        a17.f98015c = appPackageName;
                        av.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            av.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        a17.b(deviceID);
                        av.a("[param] Set device ID: %s", deviceID);
                    }
                    String deviceModel = buglyStrategy.getDeviceModel();
                    if (deviceModel != null) {
                        a17.c(deviceModel);
                        av.a("[param] Set device model: %s", deviceModel);
                    }
                    a17.f98018f = buglyStrategy.isUploadProcess();
                    ay.f98122b = buglyStrategy.isBuglyLogUpload();
                    NetworkWatcher.INSTANCE.init();
                    for (int i16 = 0; i16 < f98528b.size(); i16++) {
                        try {
                            if (a18.b(f98528b.get(i16).f98526id)) {
                                f98528b.get(i16).init(a16, z16, buglyStrategy);
                            }
                        } catch (Throwable th5) {
                            if (!av.a(th5)) {
                                th5.printStackTrace();
                            }
                        }
                    }
                    ai c16 = ai.c();
                    boolean z18 = !ba.b(c16.B);
                    String str2 = c16.B;
                    if (!z18) {
                        str2 = "Bugly_Native";
                    }
                    if (!NativeCrashHandler.getInstance().tryLoadSo(str2, z18)) {
                        av.c("Failed to load so: %s", "Bugly_Native");
                    } else {
                        av.a("Success to load so: %s", "Bugly_Native");
                    }
                    au.b(a16);
                    try {
                        if (TextUtils.isEmpty(a17.f98027o)) {
                            a17.f98027o = NativeCrashHandler.getInstance().getProperties(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
                        }
                    } catch (Throwable th6) {
                        if (!av.d("Failed to read cpu type. ".concat(String.valueOf(th6)), new Object[0])) {
                            th6.printStackTrace();
                        }
                    }
                    final String str3 = a16.getFilesDir().getAbsolutePath() + File.separator + "bugly_crash_processing";
                    at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.az.1

                        /* renamed from: a */
                        final /* synthetic */ Context f98156a;

                        /* renamed from: b */
                        final /* synthetic */ String f98157b;

                        public AnonymousClass1(final Context a162, final String str32) {
                            r1 = a162;
                            r2 = str32;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            ao aoVar;
                            if (!ba.a(r1, "processing_record_lock")) {
                                av.c("Failed to lock file for uploading processing record.", new Object[0]);
                                return;
                            }
                            File file = new File(r2);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            if (file.list().length > 0) {
                                aoVar = ao.a.f98059a;
                                aoVar.a(r2);
                            } else {
                                av.a("No crash processing file exist.", new Object[0]);
                            }
                            ba.b(r1, "processing_record_lock");
                        }
                    });
                    bw.a(a162);
                    HotPatchWrapper.getInstance().setHotPatchInfoFromSp(a162);
                    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                    if (nativeCrashHandler != null) {
                        nativeCrashHandler.setAppHotPatchNum(HotPatchWrapper.getInstance().getAppHotPatchNum());
                    }
                    String initShiplyVersionLabel = VersionLabelWrapper.initShiplyVersionLabel();
                    NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                    if (nativeCrashHandler2 != null) {
                        nativeCrashHandler2.setAppVersionLabel(initShiplyVersionLabel);
                    }
                    NativeCrashHandler nativeCrashHandler3 = NativeCrashHandler.getInstance();
                    if (nativeCrashHandler3 != null) {
                        nativeCrashHandler3.setStage(com.tencent.rmonitor.common.lifecycle.a.f());
                        nativeCrashHandler3.setTestLabel(VersionLabelWrapper.getTestLabels());
                        nativeCrashHandler3.setCaseLabel(VersionLabelWrapper.getCaseLabels());
                    }
                    com.tencent.rmonitor.common.lifecycle.a.i().n(new by());
                    if (PluginLinkDataProxy.getInstance().isInitDBCache()) {
                        av.a("init linkage before.", new Object[0]);
                    } else {
                        try {
                            Method declaredMethod = LinkDataWrapper.class.getDeclaredMethod("initLinkage", Context.class, String.class);
                            if (declaredMethod != null) {
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(null, a162, str);
                                av.a("init linkage success.", new Object[0]);
                            } else {
                                av.a("init linkage fail for method is null.", new Object[0]);
                            }
                        } catch (Throwable th7) {
                            av.a("init linkage fail for %s.", th7.getMessage());
                        }
                    }
                    t.a(a162, buglyStrategy);
                    long appReportDelay = buglyStrategy.getAppReportDelay();
                    final ak a26 = ak.a();
                    a26.f98046c.a(new BaseThread() { // from class: com.tencent.bugly.proguard.ak.1
                        public AnonymousClass1() {
                        }

                        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            try {
                                Map<String, byte[]> a27 = ae.a().a(ak.f98042a, (ad) null);
                                if (a27 != null) {
                                    byte[] bArr2 = a27.get("device");
                                    byte[] bArr3 = a27.get("gateway");
                                    if (bArr2 != null) {
                                        ai.a(ak.this.f98050h).e(new String(bArr2));
                                    }
                                    if (bArr3 != null) {
                                        ai.a(ak.this.f98050h).d(new String(bArr3));
                                    }
                                }
                                ak.this.f98049g = ak.d();
                                if (ak.this.f98049g != null) {
                                    if (ba.b(ak.f98045i) || !ba.c(ak.f98045i)) {
                                        ak.this.f98049g.f97852q = StrategyBean.f97836a;
                                        ak.this.f98049g.f97853r = StrategyBean.f97837b;
                                    } else {
                                        ak.this.f98049g.f97852q = ak.f98045i;
                                        ak.this.f98049g.f97853r = ak.f98045i;
                                    }
                                }
                            } catch (Throwable th8) {
                                if (!av.a(th8)) {
                                    th8.printStackTrace();
                                }
                            }
                            ak akVar = ak.this;
                            akVar.a(akVar.f98049g, false);
                        }
                    }, appReportDelay);
                    GcInfoStatHelper.getInstance().startGCStat(QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY);
                    final long uptimeMillis = SystemClock.uptimeMillis();
                    final boolean z19 = a17.T;
                    at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.p.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str4;
                            ProcessContextWrapper.getInstance().initStorage(new bl());
                            if (z.a("launch_time_ratio")) {
                                ao a27 = ao.a.a();
                                String uuid = UUID.randomUUID().toString();
                                long currentTimeMillis = System.currentTimeMillis();
                                long j17 = uptimeMillis - j3;
                                if (z19) {
                                    str4 = "BuglyOA";
                                } else {
                                    str4 = "BuglyQQ";
                                }
                                a27.a(new ao.c(uuid, "BuglySLALaunchEvent", currentTimeMillis, true, j17, str4, null));
                                return;
                            }
                            av.c("launch time cost is disabled", new Object[0]);
                        }
                    });
                    av.b("[init] Bugly initialization finished.", new Object[0]);
                    return;
                }
                av.d("crash report is disabled, please modify your project's setting", new Object[0]);
            }
            z17 = true;
            if (!z17) {
            }
        }
    }

    public static synchronized void a(o oVar) {
        synchronized (p.class) {
            if (!f98528b.contains(oVar)) {
                f98528b.add(oVar);
            }
        }
    }
}
