package com.tencent.qqperf.crashdefend;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.startup.task.bv;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    HotFixOnStartStepHelper f363088a = new HotFixOnStartStepHelper();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static d f363089a = new d();
    }

    d() {
    }

    public static d e() {
        return a.f363089a;
    }

    @Override // com.tencent.qqperf.crashdefend.g
    public void a() {
        if (MobileQQ.sProcessId == 1) {
            this.f363088a.n(true);
            return;
        }
        wy3.b.a("HotFix", "doOnStartStepCrash is jump processID:" + MobileQQ.sProcessId);
    }

    @Override // com.tencent.qqperf.crashdefend.g
    public void b(String str, String str2) {
        if (SafeModeUtil.b(str, str2)) {
            SafeModeUtil.f(HardCodeUtil.qqStr(R.string.t0x));
            QQCrashReportManager.f363164h = true;
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new Throwable(str2), "notExitOnSafeMode");
        }
    }

    @Override // com.tencent.qqperf.crashdefend.g
    public void c() {
        if (CrashDefendManager.i().c()) {
            bv.b();
        }
    }

    @Override // com.tencent.qqperf.crashdefend.g
    public void d() {
        wy3.b.a("HotFix", "doOnStartUpDefenderFinish invoke");
        if (CrashDefendManager.i().d() && !this.f363088a.e()) {
            this.f363088a.q();
            this.f363088a.g(2);
        }
    }

    public void f(Context context) {
        if (CrashDefendManager.i().c()) {
            this.f363088a.h(context);
        }
    }

    public void g(int i3, boolean z16) {
        wy3.b.a("HotFix", "onPatchFixCallBack invoke: " + i3 + "|" + z16);
        this.f363088a.l(i3, z16);
    }

    public void h(int i3, boolean z16) {
        wy3.b.a("HotFix", "onSafeModeConfigFixCallBack invoke: " + i3 + "|" + z16);
        this.f363088a.m(i3, z16);
    }
}
