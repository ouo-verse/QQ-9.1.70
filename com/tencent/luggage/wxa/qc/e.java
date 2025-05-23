package com.tencent.luggage.wxa.qc;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.os.Message;
import com.tencent.luggage.wxa.ef.o;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.qc.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uc.j;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends f implements ComponentCallbacks2 {

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f138664b;

    /* renamed from: c, reason: collision with root package name */
    public int f138665c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f138666a;

        static {
            int[] iArr = new int[e.d.values().length];
            f138666a = iArr;
            try {
                iArr[e.d.LAUNCH_MINI_PROGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138666a[e.d.LAUNCH_NATIVE_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138666a[e.d.HOME_PRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(g gVar, com.tencent.luggage.wxa.ic.g gVar2) {
        super(gVar);
        this.f138665c = 0;
        this.f138664b = gVar2;
    }

    @Override // com.tencent.luggage.wxa.qc.f, com.tencent.luggage.wxa.wn.b
    public void a() {
        this.f138665c = p();
        super.a();
        c(0);
    }

    @Override // com.tencent.luggage.wxa.wn.b
    public void b() {
        super.b();
        this.f138665c = 0;
        try {
            z.c().unregisterComponentCallbacks(this);
        } catch (Exception unused) {
        }
    }

    public final void c(int i3) {
        this.f138665c &= ~i3;
        w.d("MicroMsg.MultipleConditionBackgroundState", "removeFlag, appId:%s, flag: %d, result: %d", this.f138664b.getAppId(), Integer.valueOf(i3), Integer.valueOf(this.f138665c));
        if (this.f138665c == 0) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared, appId:%s", this.f138664b.getAppId());
            o();
        }
    }

    public final void d() {
        String appId = this.f138664b.getAppId();
        e.d d16 = com.tencent.luggage.wxa.ic.e.d(appId);
        w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAdjustByPauseType, appId:%s, pauseType:%s", appId, d16);
        int i3 = a.f138666a[d16.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && a(this.f138664b) && !c.f138608g) {
                    a(8);
                    w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAdjustByPauseType, appId:%s, add HOME_PRESSED", appId);
                    return;
                }
                return;
            }
            a(4);
            return;
        }
        a(16);
    }

    public final void e() {
        com.tencent.luggage.wxa.uc.h hVar = (com.tencent.luggage.wxa.uc.h) this.f138664b.c(com.tencent.luggage.wxa.uc.h.class);
        if (hVar != null) {
            boolean a16 = hVar.a();
            w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", Boolean.valueOf(a16));
            if (a16) {
                a(128);
            }
        }
    }

    public final void f() {
        com.tencent.luggage.wxa.uc.i iVar = (com.tencent.luggage.wxa.uc.i) this.f138664b.c(com.tencent.luggage.wxa.uc.i.class);
        if (iVar != null) {
            boolean a16 = iVar.a();
            w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", Boolean.valueOf(a16));
            if (a16) {
                a(64);
            }
        }
    }

    public final void g() {
        com.tencent.luggage.wxa.k0.d.a(this.f138664b.c(j.class));
    }

    public final void h() {
        com.tencent.luggage.wxa.ge.e.f126695b.a(this.f138664b);
        w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagBluetoothIfNeed, client is null");
    }

    public final void i() {
        if (!this.f138664b.z0()) {
            return;
        }
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagForForegroundService processInfo.importance:%d, importanceReasonCode:%d, importanceReasonComponent:%s", Integer.valueOf(runningAppProcessInfo.importance), Integer.valueOf(runningAppProcessInfo.importanceReasonCode), runningAppProcessInfo.importanceReasonComponent);
        if (100 == runningAppProcessInfo.importance) {
            a(1024);
            z.c().registerComponentCallbacks(this);
        }
    }

    public final void j() {
        o oVar;
        boolean z16;
        boolean z17 = ((com.tencent.luggage.wxa.qc.a) this.f138664b.a(com.tencent.luggage.wxa.qc.a.class)).f138599b;
        w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", Boolean.valueOf(z17));
        if (z17 && (oVar = (o) this.f138664b.c(o.class)) != null) {
            if (oVar.p() && oVar.q()) {
                z16 = true;
            } else {
                z16 = false;
            }
            w.d("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", Boolean.valueOf(oVar.p()), Boolean.valueOf(oVar.q()));
            if (z16) {
                a(32);
            }
        }
    }

    public boolean k() {
        if ((this.f138665c & 1) > 0) {
            return true;
        }
        return false;
    }

    public final int l() {
        return this.f138665c;
    }

    public void m() {
        b("StateMachineMessage");
    }

    public void n() {
        c("StateMachineMessage");
    }

    public abstract void o();

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        a("onLowMemory");
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        w.d("MicroMsg.MultipleConditionBackgroundState", "onTrimMemory level:%d", Integer.valueOf(i3));
        a("onTrimMemory");
    }

    public final int p() {
        boolean z16 = false;
        this.f138665c = 0;
        String appId = this.f138664b.getAppId();
        com.tencent.luggage.wxa.qc.a aVar = (com.tencent.luggage.wxa.qc.a) this.f138664b.a(com.tencent.luggage.wxa.qc.a.class);
        if (aVar != null && aVar.f138598a) {
            z16 = true;
        }
        if (z16) {
            if (com.tencent.luggage.wxa.pi.a.a(appId)) {
                a(1);
            }
        } else {
            com.tencent.luggage.wxa.pi.a.f137604c.c(appId);
        }
        j();
        f();
        e();
        g();
        h();
        c();
        i();
        d();
        return this.f138665c;
    }

    @Override // com.tencent.luggage.wxa.wn.b
    public boolean a(Message message) {
        if (d.k.a(message.what) == d.k.ON_STOP_BACKGROUND_LOCATION_LISTENING) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
            c(32);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_STOP_BACKGROUND_LIVE_VOIP) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
            c(64);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_STOP_AUDIO_BACKGROUND_PLAY) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
            c(128);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_STOP_BACKGROUND_VOIP_1v1) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
            c(256);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_CONTAINER_FORCED_MOVE_TO_BACK) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_CONTAINER_FORCED_MOVE_TO_BACK, appId:%s", this.f138664b.getAppId());
            c(4);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_STOP_BACKGROUND_BLUETOOTH) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_BLUETOOTH");
            c(512);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_STOP_BACKGROUND_AI) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_AI");
            c(2048);
            return true;
        }
        if (d.k.a(message.what) == d.k.ON_RESET_TO_TOP_OF_STACK) {
            w.d("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_RESET_TO_TOP_OF_STACK");
            c(16);
            return true;
        }
        if (d.k.a(message.what) == d.k.CHECK_PROCESS_IMPORTANCE) {
            a("CHECK_PROCESS_IMPORTANCE");
            return true;
        }
        if (message.what != d.k.ON_BACKGROUND_AUDIO_PREEMPTED.b() && message.what != d.k.ON_BACKGROUND_AUDIO_STOPPED.b()) {
            return super.a(message);
        }
        if (this.f138664b.e0() == null) {
            c("BACKGROUND_AUDIO_STOPPED_OR_PREEMPTED");
        }
        if ((this.f138664b.n0() instanceof WindowAndroidActivityImpl) && ((WindowAndroidActivityImpl) this.f138664b.n0()).r()) {
            b("BACKGROUND_AUDIO_STOPPED_OR_PREEMPTED");
        }
        a("BACKGROUND_AUDIO_STOPPED_OR_PREEMPTED");
        c(1);
        return true;
    }

    public final boolean b(int i3) {
        return (i3 & this.f138665c) != 0;
    }

    public final void b(String str) {
        w.d("MicroMsg.MultipleConditionBackgroundState", "onContainerActivityStopped %s, reason:%s", this.f138664b.getAppId(), str);
        c(1024);
    }

    public final void c() {
        com.tencent.luggage.wxa.k0.d.a(this.f138664b.c(com.tencent.luggage.wxa.uc.g.class));
    }

    public final void c(String str) {
        w.d("MicroMsg.MultipleConditionBackgroundState", "onDetachFromStack %s, reason:%s", this.f138664b.getAppId(), str);
        c(16);
        c(1024);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public final void a(int i3) {
        this.f138665c |= i3;
        w.d("MicroMsg.MultipleConditionBackgroundState", "addFlag, appId:%s, flag: %d, result: %d", this.f138664b.getAppId(), Integer.valueOf(i3), Integer.valueOf(this.f138665c));
    }

    public static boolean a(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar.e0() == null) {
            return false;
        }
        if (gVar.e0().h().runInStandaloneTask()) {
            return gVar.d0() != null;
        }
        return true;
    }

    public final void a(String str) {
        int i3;
        ComponentName componentName;
        int i16;
        boolean b16 = b(1024);
        if (b16) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            i3 = runningAppProcessInfo.importance;
            i16 = runningAppProcessInfo.importanceReasonCode;
            componentName = runningAppProcessInfo.importanceReasonComponent;
            if (100 != i3) {
                c(1024);
            }
        } else {
            i3 = -1;
            componentName = null;
            i16 = -1;
        }
        w.d("MicroMsg.MultipleConditionBackgroundState", "checkRemoveFlagForForegroundService(%s), hasFlag?:%b, importance:%d, importanceReasonCode:%d, importanceReasonComponent:%s, currentPauseType:%s", str, Boolean.valueOf(b16), Integer.valueOf(i3), Integer.valueOf(i16), componentName, com.tencent.luggage.wxa.ic.e.d(this.f138664b.getAppId()));
    }
}
