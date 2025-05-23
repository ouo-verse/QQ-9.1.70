package com.tencent.mobileqq.splashad.processor;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.gdtad.splash.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.splashad.o;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u0010B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u0018\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0015R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/splashad/processor/b;", "Lcom/tencent/mobileqq/splashad/processor/d;", "", "getTag", "", "getBizType", "()Ljava/lang/Integer;", "Lmqq/app/AppActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/splashad/SplashWidget;", "splashWidget", "Lcom/tencent/mobileqq/splash/c$a;", "listener", "Lcom/tencent/mobileqq/splash/a;", "callback", "", "b", "isWarmStartUp", "", "c", "a", "", "durationMillis", tl.h.F, "i", "j", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "TAG", "Z", "mCanRealTimeOrder", "Lcom/tencent/mobileqq/splashad/o;", "Lcom/tencent/mobileqq/splashad/o;", "mSplashGuardManager", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean mCanRealTimeOrder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o mSplashGuardManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR(\u0010\u0013\u001a\b\u0018\u00010\fR\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/splashad/processor/b$a;", "Lcom/tencent/mobileqq/splash/c;", "Lcom/tencent/mobileqq/splash/c$a;", "listener", "", "a", "c", "b", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "Ljava/lang/ref/WeakReference;", "mWeakActivity", "Lcom/tencent/mobileqq/splashad/processor/b$b;", "Lcom/tencent/mobileqq/splashad/processor/b;", "d", "Lcom/tencent/mobileqq/splashad/processor/b$b;", "()Lcom/tencent/mobileqq/splashad/processor/b$b;", "setMCallback", "(Lcom/tencent/mobileqq/splashad/processor/b$b;)V", "mCallback", "", "order", "iSetupListenerWeakReference", "<init>", "(Lcom/tencent/mobileqq/splashad/processor/b;Ljava/lang/ref/WeakReference;Ljava/lang/Object;Ljava/lang/ref/WeakReference;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public final class a extends com.tencent.mobileqq.splash.c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Activity> mWeakActivity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private C8603b mCallback;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f288857e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, @Nullable WeakReference<Activity> mWeakActivity, @Nullable Object obj, WeakReference<c.a> weakReference) {
            super(obj);
            Intrinsics.checkNotNullParameter(mWeakActivity, "mWeakActivity");
            this.f288857e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, mWeakActivity, obj, weakReference);
            } else {
                this.mWeakActivity = mWeakActivity;
                this.mCallback = new C8603b(weakReference);
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void a(@NotNull c.a listener) {
            ViewGroup viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
                return;
            }
            Intrinsics.checkNotNullParameter(listener, "listener");
            long currentTimeMillis = System.currentTimeMillis();
            Activity activity = this.mWeakActivity.get();
            if (activity != null) {
                viewGroup = (ViewGroup) activity.findViewById(R.id.j0l);
            } else {
                viewGroup = null;
            }
            try {
                if (this.f288857e.mCanRealTimeOrder) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).showHotGdtRealTimeSplash(this.mWeakActivity, new WeakReference<>(viewGroup), new WeakReference<>(this.mCallback));
                } else {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).showHotGdtSplash(this.mWeakActivity, new WeakReference<>(viewGroup), new WeakReference<>(this.mCallback));
                }
            } catch (Throwable th5) {
                QLog.e(this.f288857e.g(), 1, "[GdtSplashProcessorCallBack][bindView]", th5);
                this.f288857e.i(listener, 0L);
                this.mCallback = null;
            }
            QLog.i(this.f288857e.g(), 1, "[GdtSplashProcessorCallBack][bindView] cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }

        @Override // com.tencent.mobileqq.splash.c
        public void b() {
            GuardManager guardManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            QLog.i(this.f288857e.g(), 1, "[GdtSplashProcessorCallBack][end]");
            this.f288710a = true;
            try {
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).clearHotSplashCache();
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).recycleHotSplash();
                if (this.f288857e.mSplashGuardManager != null && (guardManager = GuardManager.sInstance) != null) {
                    guardManager.unregisterCallback(this.f288857e.mSplashGuardManager);
                    this.f288857e.mSplashGuardManager = null;
                }
            } catch (Throwable th5) {
                QLog.e(this.f288857e.g(), 1, "[GdtSplashProcessorCallBack][end]", th5);
            }
            this.mCallback = null;
        }

        @Override // com.tencent.mobileqq.splash.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).onPrepareTimeOut();
            }
        }

        @Nullable
        public final C8603b d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C8603b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mCallback;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001e\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/splashad/processor/b$b;", "Lcom/tencent/gdtad/splash/w;", "", "durationMillis", "", "onDurationUpdate", "a", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/splash/c$a;", "Ljava/lang/ref/WeakReference;", "mWeakListener", "<init>", "(Lcom/tencent/mobileqq/splashad/processor/b;Ljava/lang/ref/WeakReference;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.splashad.processor.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public final class C8603b implements w {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<c.a> mWeakListener;

        public C8603b(@Nullable WeakReference<c.a> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) weakReference);
            } else {
                this.mWeakListener = weakReference;
            }
        }

        @Override // com.tencent.gdtad.splash.w
        public void a(long durationMillis) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, durationMillis);
                return;
            }
            WeakReference<c.a> weakReference = this.mWeakListener;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            b.this.i(aVar, durationMillis);
        }

        @Override // com.tencent.gdtad.splash.w
        public void b(long durationMillis) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, durationMillis);
                return;
            }
            WeakReference<c.a> weakReference = this.mWeakListener;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            b.this.j(aVar, durationMillis);
        }

        @Override // com.tencent.gdtad.splash.w
        public void onDurationUpdate(long durationMillis) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, durationMillis);
                return;
            }
            WeakReference<c.a> weakReference = this.mWeakListener;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            b.this.h(aVar, durationMillis);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "GdtHotSplashProcessor";
            this.mCanRealTimeOrder = (!((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).canRealTimeOrderHot() || SplashADUtil.s() || SplashADUtil.t()) ? false : true;
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mCanRealTimeOrder;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean b(@Nullable AppActivity activity, @Nullable SplashWidget splashWidget, @Nullable c.a listener, @Nullable com.tencent.mobileqq.splash.a callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, activity, splashWidget, listener, callback)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (listener == null) {
            QLog.e(this.TAG, 1, "[doProcess] error, listener is null cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return false;
        }
        if (!((IGdtAPI) QRoute.api(IGdtAPI.class)).getCanHotAmsSplash()) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 1, "[doProcess] cancel");
            }
            return false;
        }
        if (this.mCanRealTimeOrder) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 1, "[doProcess] realTime success");
            }
            WeakReference<Activity> weakReference = new WeakReference<>(activity);
            a aVar = new a(this, weakReference, null, new WeakReference(listener));
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).hotRealTimePrepare(weakReference, new WeakReference<>(aVar.d()), new WeakReference<>(callback));
            listener.b(aVar);
            return true;
        }
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316018);
        try {
            z16 = ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).hasHotSplashPrepare(new WeakReference<>(callback));
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "[doProcess]", th5);
            z16 = false;
        }
        if (!z16) {
            QLog.i(this.TAG, 1, "[doProcess] return false, order is null cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return false;
        }
        listener.b(new a(this, new WeakReference(activity), null, new WeakReference(listener)));
        QLog.i(this.TAG, 1, "[doProcess] return true cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public void c(boolean isWarmStartUp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isWarmStartUp);
        }
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    @NotNull
    public Integer getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.TAG;
    }

    public final void h(@Nullable c.a listener, long durationMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, listener, Long.valueOf(durationMillis));
            return;
        }
        if (listener == null) {
            QLog.e(this.TAG, 1, "[onDurationUpdate] error, listener is null");
            return;
        }
        QLog.i(this.TAG, 1, "[onDurationUpdate] durationMillis:" + durationMillis);
        listener.onDurationUpdate(durationMillis);
    }

    public final void i(@Nullable c.a listener, long durationMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, listener, Long.valueOf(durationMillis));
            return;
        }
        if (listener == null) {
            QLog.e(this.TAG, 1, "[onSplashFinish] error, listener is null");
            return;
        }
        QLog.i(this.TAG, 1, "[onSplashFinish] durationMillis:" + durationMillis);
        listener.a(durationMillis);
    }

    public final void j(@Nullable c.a listener, long durationMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, listener, Long.valueOf(durationMillis));
            return;
        }
        if (listener == null) {
            QLog.e(this.TAG, 1, "[onSplashShow] error, listener is null");
            return;
        }
        QLog.i(this.TAG, 1, "[onSplashShow] durationMillis:" + durationMillis);
        listener.c(durationMillis);
        if (GuardManager.sInstance != null) {
            o oVar = new o("ams", "", true);
            this.mSplashGuardManager = oVar;
            GuardManager.sInstance.registerCallBack(oVar);
        }
    }
}
