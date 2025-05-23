package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.av;
import com.tencent.bugly.proguard.bb;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* renamed from: c, reason: collision with root package name */
    private static int f97803c;

    /* renamed from: e, reason: collision with root package name */
    private static CrashModule f97804e = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f97805a;

    /* renamed from: b, reason: collision with root package name */
    private BuglyStrategy.a f97806b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f97807d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            ai.a(context).B = libBuglySOFilePath;
            av.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f97806b = buglyStrategy.getCrashHandleCallback();
            av.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f97805a = appReportDelay;
            av.a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f97804e;
        crashModule.f98526id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f97807d;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[Catch: all -> 0x00cc, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0034, B:14:0x0056, B:15:0x0067, B:17:0x006c, B:20:0x0073, B:22:0x0084, B:25:0x008b, B:27:0x009c, B:29:0x00a4, B:30:0x00ab, B:35:0x0097, B:36:0x007f, B:37:0x005c, B:38:0x0062), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4 A[Catch: all -> 0x00cc, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0034, B:14:0x0056, B:15:0x0067, B:17:0x006c, B:20:0x0073, B:22:0x0084, B:25:0x008b, B:27:0x009c, B:29:0x00a4, B:30:0x00ab, B:35:0x0097, B:36:0x007f, B:37:0x005c, B:38:0x0062), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    @Override // com.tencent.bugly.proguard.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, boolean z16, BuglyStrategy buglyStrategy) {
        long j3;
        if (context != null) {
            if (!this.f97807d) {
                av.a("Initializing crash module.", new Object[0]);
                ac a16 = ac.a();
                int i3 = f97803c + 1;
                f97803c = i3;
                a16.a(i3);
                this.f97807d = true;
                q.f98535a = context;
                a(context, buglyStrategy);
                be a17 = be.a(1004, context, z16, this.f97806b, null);
                a17.d();
                if (buglyStrategy != null) {
                    a17.C = buglyStrategy.getCallBackType();
                    a17.D = buglyStrategy.getCloseErrorCallback();
                    be.f98222p = buglyStrategy.isUploadSpotCrash();
                    ai.a(context).Z = buglyStrategy.isEnableRecordAnrMainStack();
                    if (!buglyStrategy.isEnableCatchAnrTrace()) {
                        a17.f98230x.disableCatchAnrTrace();
                    } else {
                        a17.f98230x.enableCatchAnrTrace();
                    }
                } else {
                    a17.f98230x.enableCatchAnrTrace();
                }
                a17.l();
                if (buglyStrategy != null && !buglyStrategy.isEnableNativeCrashMonitor()) {
                    av.a("[crash] Closed native crash monitor!", new Object[0]);
                    a17.e();
                    if (buglyStrategy != null && !buglyStrategy.isEnableANRCrashMonitor()) {
                        av.a("[crash] Closed ANR monitor!", new Object[0]);
                        a17.h();
                        if (buglyStrategy != null) {
                            be.f98210d = buglyStrategy.isMerged();
                        }
                        if (buglyStrategy == null) {
                            j3 = buglyStrategy.getAppReportDelay();
                        } else {
                            j3 = 0;
                        }
                        a17.a(j3, true);
                        bj.a(context);
                        bb a18 = bb.a();
                        a18.a("android.net.conn.CONNECTIVITY_CHANGE");
                        a18.a(context);
                        ac a19 = ac.a();
                        int i16 = f97803c - 1;
                        f97803c = i16;
                        a19.a(i16);
                    }
                    a17.g();
                    if (buglyStrategy != null) {
                    }
                    if (buglyStrategy == null) {
                    }
                    a17.a(j3, true);
                    bj.a(context);
                    bb a182 = bb.a();
                    a182.a("android.net.conn.CONNECTIVITY_CHANGE");
                    a182.a(context);
                    ac a192 = ac.a();
                    int i162 = f97803c - 1;
                    f97803c = i162;
                    a192.a(i162);
                }
                a17.f();
                if (buglyStrategy != null) {
                    av.a("[crash] Closed ANR monitor!", new Object[0]);
                    a17.h();
                    if (buglyStrategy != null) {
                    }
                    if (buglyStrategy == null) {
                    }
                    a17.a(j3, true);
                    bj.a(context);
                    bb a1822 = bb.a();
                    a1822.a("android.net.conn.CONNECTIVITY_CHANGE");
                    a1822.a(context);
                    ac a1922 = ac.a();
                    int i1622 = f97803c - 1;
                    f97803c = i1622;
                    a1922.a(i1622);
                }
                a17.g();
                if (buglyStrategy != null) {
                }
                if (buglyStrategy == null) {
                }
                a17.a(j3, true);
                bj.a(context);
                bb a18222 = bb.a();
                a18222.a("android.net.conn.CONNECTIVITY_CHANGE");
                a18222.a(context);
                ac a19222 = ac.a();
                int i16222 = f97803c - 1;
                f97803c = i16222;
                a19222.a(i16222);
            }
        }
    }

    @Override // com.tencent.bugly.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        be a16;
        if (strategyBean != null && (a16 = be.a()) != null) {
            a16.a(strategyBean);
        }
    }
}
