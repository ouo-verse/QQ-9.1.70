package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.pi.ITGChangeBackgroundStatusManager;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f38568a;

    /* renamed from: b, reason: collision with root package name */
    private volatile C0280b f38569b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f38570c;

    /* renamed from: d, reason: collision with root package name */
    private c f38571d;

    /* renamed from: e, reason: collision with root package name */
    private ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack f38572e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f38573f;

    /* renamed from: g, reason: collision with root package name */
    private volatile int f38574g = 200;

    /* renamed from: h, reason: collision with root package name */
    private volatile long f38575h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f38576i;

    /* renamed from: j, reason: collision with root package name */
    private long f38577j;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.ad.clickcomponent.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0280b {

        /* renamed from: a, reason: collision with root package name */
        public String f38583a;

        /* renamed from: b, reason: collision with root package name */
        public JSONObject f38584b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<Activity> f38585c;

        /* renamed from: d, reason: collision with root package name */
        public int f38586d = 502;

        public boolean a() {
            WeakReference<Activity> weakReference;
            if (!TextUtils.isEmpty(this.f38583a) && JSONUtilStub.notNull(this.f38584b) && (weakReference = this.f38585c) != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }

        public String toString() {
            String str;
            Activity activity;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("TGDelayLandingPageParams{landingPageUrl='");
            if (TextUtils.isEmpty(this.f38583a)) {
                str = "";
            } else {
                str = this.f38583a;
            }
            sb5.append(str);
            sb5.append('\'');
            sb5.append(", weakActivity=");
            WeakReference<Activity> weakReference = this.f38585c;
            if (weakReference != null && weakReference.get() != null) {
                activity = this.f38585c.get();
            } else {
                activity = null;
            }
            sb5.append(activity);
            sb5.append('}');
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<Activity> f38587a;

        public void a(WeakReference<Activity> weakReference) {
            this.f38587a = weakReference;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Activity activity2;
            WeakReference<Activity> weakReference = this.f38587a;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            if (activity2 == null || activity2 == activity) {
                GDTLogger.i("DelayLandingPageManager[onActivityDestroyed]  target activity:" + activity2);
                try {
                    b.a().f();
                } catch (Throwable th5) {
                    GDTLogger.e("DelayLandingPageManager[onActivityDestroyed]", th5);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            Activity activity2;
            WeakReference<Activity> weakReference = this.f38587a;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            if (activity2 == activity) {
                long currentTimeMillis = System.currentTimeMillis();
                GDTLogger.i("DelayLandingPageManager[onActivityPaused] target activity:" + activity2 + ",currentTime:" + currentTimeMillis);
                try {
                    b.a().b(currentTimeMillis);
                } catch (Throwable th5) {
                    GDTLogger.e("DelayLandingPageManager[onActivityStopped]", th5);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            Activity activity2;
            WeakReference<Activity> weakReference = this.f38587a;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            if (activity2 == null || activity2 == activity) {
                GDTLogger.i("DelayLandingPageManager[onActivityResumed]  target activity:" + activity2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            Activity activity2;
            WeakReference<Activity> weakReference = this.f38587a;
            if (weakReference != null) {
                activity2 = weakReference.get();
            } else {
                activity2 = null;
            }
            if (activity2 == activity) {
                GDTLogger.i("DelayLandingPageManager[onActivityStopped] target activity:" + activity2 + "pausedTime:" + b.a().i() + ",currentTime:" + System.currentTimeMillis());
                try {
                    b.a().f();
                } catch (Throwable th5) {
                    GDTLogger.e("DelayLandingPageManager[onActivityStopped]", th5);
                }
            }
        }

        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.4
                @Override // java.lang.Runnable
                public void run() {
                    ITGChangeBackgroundStatusManager iTGChangeBackgroundStatusManager;
                    WeakReference<ITGChangeBackgroundStatusManager> tGChangeBackgroundStatusListener = GlobalSetting.getTGChangeBackgroundStatusListener();
                    if (tGChangeBackgroundStatusListener != null) {
                        iTGChangeBackgroundStatusManager = tGChangeBackgroundStatusListener.get();
                    } else {
                        iTGChangeBackgroundStatusManager = null;
                    }
                    if (iTGChangeBackgroundStatusManager == null) {
                        GDTLogger.e("DelayLandingPageManagerunRegisterBackGroundListener error");
                        return;
                    }
                    if (b.this.f38572e == null) {
                        GDTLogger.e("DelayLandingPageManagerunRegisterBackGroundListener unRegistered");
                        return;
                    }
                    try {
                        iTGChangeBackgroundStatusManager.unRegister(new WeakReference<>(b.this.f38572e));
                        b.this.f38572e = null;
                    } catch (Throwable unused) {
                        GDTLogger.e("DelayLandingPageManagerunRegisterBackGroundListener error");
                    }
                }
            });
        } catch (Throwable th5) {
            GDTLogger.e("DelayLandingPageManagerunRegisterBackGroundListener error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long i() {
        return this.f38575h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        return this.f38576i;
    }

    private void d() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis() - this.f38575h;
        GDTLogger.i("DelayLandingPageManager[onActivityResultCallBack] timeGap" + currentTimeMillis);
        if (this.f38575h != 0 && currentTimeMillis < this.f38574g) {
            GDTLogger.i("DelayLandingPageManager[onActivityResultCallBack] direct dump");
            return;
        }
        a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_START_WITH_CONFIRMATION, 0, currentTimeMillis);
        C0280b c0280b = this.f38569b;
        if (c0280b == null) {
            GDTLogger.i("DelayLandingPageManager[onActivityResultCallBack] pageParams is null:");
            a(1);
            a().a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_SUCCESS_WITH_CONFIRMATION, 0, currentTimeMillis);
            return;
        }
        if (this.f38575h == 0) {
            a(3);
        } else {
            a(2);
        }
        a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_FAILED_WITH_CONFIRMATION, 0, currentTimeMillis);
        a(13200302, 0, System.currentTimeMillis() - c());
        if (!c0280b.a()) {
            GDTLogger.i("DelayLandingPageManager[onActivityResultCallBack] pageParams is invalid:" + c0280b);
            a().a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_FALLBACK_TO_URL_FAILED_WITH_CONFIRMATION, 206, currentTimeMillis);
            return;
        }
        try {
            WeakReference<Activity> weakReference = c0280b.f38585c;
            Activity activity = weakReference != null ? weakReference.get() : null;
            CustomLandingPageListener.Params params = new CustomLandingPageListener.Params();
            params.setLandingPageUrl(c0280b.f38583a);
            params.setAdData(String.valueOf(c0280b.f38584b));
            params.setWeakContext(new WeakReference<>(activity));
            params.setBundle(GlobalSetting.getCustomBundle());
            params.setActCode(c0280b.f38586d);
            z16 = StubVisitor.getInstance().jumpToCustomLandingPage(params);
        } catch (Throwable th5) {
            GDTLogger.e("DelayLandingPageManager[onActivityResultCallBack]", th5);
            z16 = false;
        }
        GDTLogger.i("DelayLandingPageManager[onActivityResultCallBack] webViewOpened" + z16);
        if (z16) {
            return;
        }
        a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_FALLBACK_TO_URL_FAILED_WITH_CONFIRMATION, 0, currentTimeMillis);
    }

    private void e() {
        this.f38574g = com.qq.e.comm.plugin.j.c.a("systemWindowShowThreshold", 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext;
                    if (b.this.f38573f) {
                        b.this.f38569b = null;
                        try {
                            appContext = GDTADManager.getInstance().getAppContext();
                        } catch (Throwable th5) {
                            GDTLogger.e("DelayLandingPageManager[unRegister]", th5);
                        }
                        if (!(appContext instanceof Application)) {
                            GDTLogger.e("DelayLandingPageManager[register] appContext is invalid");
                            return;
                        }
                        ((Application) appContext).unregisterActivityLifecycleCallbacks(b.this.f38571d);
                        b.this.f38573f = false;
                        GDTLogger.i("DelayLandingPageManager[unRegister]");
                        return;
                    }
                    GDTLogger.i("DelayLandingPageManager[unRegister] isRegistered");
                }
            });
        } catch (Throwable th5) {
            GDTLogger.e("DelayLandingPageManager[unRegister] error", th5);
        }
    }

    private void g() {
        if (!com.qq.e.comm.plugin.j.c.a("supportDualOpenH5Report", 1, 1)) {
            GDTLogger.i("DelayLandingPageManager[registerBackGroundListener] not register");
            return;
        }
        try {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.3
                @Override // java.lang.Runnable
                public void run() {
                    ITGChangeBackgroundStatusManager iTGChangeBackgroundStatusManager;
                    WeakReference<ITGChangeBackgroundStatusManager> tGChangeBackgroundStatusListener = GlobalSetting.getTGChangeBackgroundStatusListener();
                    if (tGChangeBackgroundStatusListener != null) {
                        iTGChangeBackgroundStatusManager = tGChangeBackgroundStatusListener.get();
                    } else {
                        iTGChangeBackgroundStatusManager = null;
                    }
                    if (iTGChangeBackgroundStatusManager == null) {
                        GDTLogger.e("DelayLandingPageManagerregisterBackGroundListener error");
                        return;
                    }
                    if (b.this.f38572e != null) {
                        GDTLogger.e("DelayLandingPageManagerregisterBackGroundListener registered");
                        return;
                    }
                    b.this.f38572e = new a();
                    try {
                        iTGChangeBackgroundStatusManager.register(new WeakReference<>(b.this.f38572e));
                    } catch (Throwable unused) {
                        GDTLogger.e("DelayLandingPageManagerregisterBackGroundListener error");
                    }
                }
            });
        } catch (Throwable th5) {
            GDTLogger.e("DelayLandingPageManagerregisterBackGroundListener error", th5);
        }
    }

    public void b() {
        d();
        f();
        this.f38575h = 0L;
    }

    public long c() {
        return this.f38577j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j3) {
        this.f38575h = j3;
    }

    public static b a() {
        if (f38568a == null) {
            synchronized (GDTADManager.class) {
                if (f38568a == null) {
                    f38568a = new b();
                }
            }
        }
        return f38568a;
    }

    public void a(final C0280b c0280b) {
        e();
        this.f38575h = 0L;
        a(System.currentTimeMillis());
        try {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    C0280b c0280b2 = c0280b;
                    if (c0280b2 != null && c0280b2.a()) {
                        b.this.f38569b = c0280b;
                        b.this.f38570c = c0280b.f38584b;
                        if (b.this.f38571d == null) {
                            b.this.f38571d = new c();
                        }
                        b.this.f38571d.a(c0280b.f38585c);
                        try {
                            if (b.this.f38573f) {
                                GDTLogger.i("DelayLandingPageManager[register] isRegistered");
                                return;
                            }
                            Context appContext = GDTADManager.getInstance().getAppContext();
                            if (!(appContext instanceof Application)) {
                                GDTLogger.e("DelayLandingPageManager[register] appContext is invalid");
                                b.this.a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_UNKNOWN, 319, 0L);
                                return;
                            }
                            ((Application) appContext).registerActivityLifecycleCallbacks(b.this.f38571d);
                            GDTLogger.i("DelayLandingPageManager[register] pageParams:" + c0280b);
                            b.this.f38573f = true;
                            return;
                        } catch (Throwable th5) {
                            b.this.a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_UNKNOWN, 999, 0L);
                            GDTLogger.e("DelayLandingPageManager[register]", th5);
                            return;
                        }
                    }
                    GDTLogger.e("DelayLandingPageManager[register] activity is null");
                    b.this.a(sdk_event_log.SdkEventDimension.EVENT_LAUNCH_DEEPLINK_UNKNOWN, 206, 0L);
                }
            });
            g();
        } catch (Throwable th5) {
            GDTLogger.e("DelayLandingPageManagerregister error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, int i16, long j3) {
        com.qq.e.comm.plugin.stat.b a16 = z.a(this.f38570c, (JSONObject) null);
        a16.a(j3);
        a16.e(i16);
        StatTracer.trackEvent(i3, 0, a16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack {
        a() {
        }

        @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack
        public void onBackground() {
            try {
                long currentTimeMillis = System.currentTimeMillis() - b.a().c();
                com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
                bVar.e(b.a().j());
                bVar.a(currentTimeMillis);
                StatTracer.trackEvent(13200303, 0, bVar);
                b.a().a(0);
                b.a().h();
            } catch (Throwable th5) {
                GDTLogger.e("DelayLandingPageManager[onBackground]", th5);
            }
        }

        @Override // com.qq.e.comm.pi.ITGChangeBackgroundStatusManager.IChangeBackgroundStatusCallBack
        public void onForeground() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        this.f38576i = i3;
    }

    public void a(long j3) {
        this.f38577j = j3;
    }
}
