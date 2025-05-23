package com.tencent.mobileqq.main.loginpart;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.main.api.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqsettingme.QQSettingMe;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.simpleui.f;
import com.tencent.mobileqq.t;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQSettingMeRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0014\u0010'\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/main/loginpart/DrawerFramePart;", "Lcom/tencent/mobileqq/main/api/c;", "", "o", DomainData.DOMAIN_NAME, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "v", "Lcom/tencent/mobileqq/main/api/d;", "proxy", "d", h.F, "onPostThemeChanged", "f", "Lcom/tencent/mobileqq/qqsettingme/QQSettingMe;", "a", "Lcom/tencent/mobileqq/qqsettingme/QQSettingMe;", "qqSettingMe", "b", "Lcom/tencent/mobileqq/main/api/d;", "Ljava/lang/ref/WeakReference;", "Lmqq/app/AppRuntime;", "c", "Ljava/lang/ref/WeakReference;", "appRef", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", "", "e", "Lkotlin/Lazy;", "p", "()J", "delay", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "qqSettingMePreloadRunnable", "g", "qqSettingMeFillDataRunnable", "Lcom/tencent/mobileqq/simpleui/f;", "Lcom/tencent/mobileqq/simpleui/f;", "simpleUIObserver", "<init>", "()V", "i", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class DrawerFramePart implements com.tencent.mobileqq.main.api.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QQSettingMe qqSettingMe;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.main.api.d proxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<AppRuntime> appRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isInit = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy delay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable qqSettingMePreloadRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Runnable qqSettingMeFillDataRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final f simpleUIObserver;

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/main/loginpart/DrawerFramePart$c", "Lcom/tencent/mobileqq/app/FrameHelperActivity$p;", "", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", DownloadInfo.spKey_Config, "onConfigurationChanged", "", "isInited", "Landroid/view/ViewGroup;", "getContent", "hasCover", "b", "c", "Lcom/tencent/mobileqq/t;", "callback", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements FrameHelperActivity.p {
        c() {
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void a(t callback) {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.k0(callback);
            }
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void b(boolean hasCover) {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.v(hasCover);
            }
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public boolean c() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                return qQSettingMe.n();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public ViewGroup getContent() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                return qQSettingMe.f274439h;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public boolean isInited() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                return qQSettingMe.c0();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void onConfigurationChanged(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.o(config);
            }
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void onDestroy() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.e0();
            }
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void onPause() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.p();
            }
        }

        @Override // com.tencent.mobileqq.app.FrameHelperActivity.p
        public void onResume() {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.q();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/main/loginpart/DrawerFramePart$d", "Lcom/tencent/mobileqq/simpleui/f;", "", "isSuc", "bChangeTheme", "bSwitchElsePref", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends f {
        d() {
        }

        @Override // com.tencent.mobileqq.simpleui.f
        protected void e(boolean isSuc, boolean bChangeTheme, boolean bSwitchElsePref, int statusCode) {
            QLog.i("DrawerFramePart", 1, "onSwitchSimpleUICallback");
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.onPostThemeChanged();
            }
            QQSettingMe qQSettingMe2 = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe2 != null) {
                qQSettingMe2.a(isSuc);
            }
        }
    }

    public DrawerFramePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.main.loginpart.DrawerFramePart$delay$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(((IDrawerApi) QRoute.api(IDrawerApi.class)).getQQSettingMeInitDelayTime());
            }
        });
        this.delay = lazy;
        this.qqSettingMePreloadRunnable = new Runnable() { // from class: com.tencent.mobileqq.main.loginpart.a
            @Override // java.lang.Runnable
            public final void run() {
                DrawerFramePart.s(DrawerFramePart.this);
            }
        };
        ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadConfig();
        this.qqSettingMeFillDataRunnable = new Runnable() { // from class: com.tencent.mobileqq.main.loginpart.b
            @Override // java.lang.Runnable
            public final void run() {
                DrawerFramePart.r(DrawerFramePart.this);
            }
        };
        this.simpleUIObserver = new d();
    }

    private final void n() {
        WeakReference<AppRuntime> weakReference = this.appRef;
        Object obj = weakReference != null ? (AppRuntime) weakReference.get() : null;
        QQAppInterface qQAppInterface = obj instanceof QQAppInterface ? (QQAppInterface) obj : null;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.simpleUIObserver);
        }
    }

    private final void o() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQSettingMe qQSettingMe = this.qqSettingMe;
        if (qQSettingMe != null) {
            qQSettingMe.b(peekAppRuntime);
        }
        t();
        this.appRef = new WeakReference<>(peekAppRuntime);
        n();
    }

    private final long p() {
        return ((Number) this.delay.getValue()).longValue();
    }

    private final void q() {
        if (this.isInit.compareAndSet(false, true)) {
            v();
            u();
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.qqSettingMePreloadRunnable, p());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DrawerFramePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("DrawerFramePart", 1, "qqSettingMeFillDataRunnable run");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DrawerFramePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.qqSettingMe != null) {
            QLog.i("DrawerFramePart", 1, "qqSettingMePreloadRunnable run");
            QQSettingMe qQSettingMe = this$0.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.i0();
            }
        }
    }

    private final void t() {
        WeakReference<AppRuntime> weakReference = this.appRef;
        Object obj = weakReference != null ? (AppRuntime) weakReference.get() : null;
        QQAppInterface qQAppInterface = obj instanceof QQAppInterface ? (QQAppInterface) obj : null;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.simpleUIObserver);
        }
    }

    private final void u() {
        b bVar = new b();
        com.tencent.mobileqq.main.api.d dVar = this.proxy;
        FrameFragment a16 = dVar != null ? dVar.a() : null;
        FrameHelperActivity frameHelperActivity = a16 instanceof FrameHelperActivity ? (FrameHelperActivity) a16 : null;
        if (frameHelperActivity != null) {
            frameHelperActivity.Qh(bVar);
        }
    }

    private final void v() {
        com.tencent.mobileqq.main.api.d dVar = this.proxy;
        QBaseActivity qBaseActivity = null;
        FrameFragment a16 = dVar != null ? dVar.a() : null;
        FrameHelperActivity frameHelperActivity = a16 instanceof FrameHelperActivity ? (FrameHelperActivity) a16 : null;
        if (frameHelperActivity != null) {
            FragmentActivity activity = frameHelperActivity.getActivity();
            if (activity != null && (activity instanceof QBaseActivity)) {
                qBaseActivity = (QBaseActivity) activity;
            }
            if (qBaseActivity == null) {
                QLog.e("DrawerFramePart", 1, "setQQSettingMeListener qBaseActivity is null");
            } else {
                this.qqSettingMe = new QQSettingMe(qBaseActivity, new QQSettingMeRelativeLayout(qBaseActivity));
                frameHelperActivity.kj(new c());
            }
        }
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void a(com.tencent.mobileqq.main.api.d dVar) {
        c.a.a(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void b(com.tencent.mobileqq.main.api.d dVar, boolean z16) {
        c.a.d(this, dVar, z16);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void c(com.tencent.mobileqq.main.api.d dVar) {
        c.a.b(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void d(com.tencent.mobileqq.main.api.d proxy) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        this.proxy = proxy;
        QLog.i("DrawerFramePart", 1, "onCreate");
        q();
        o();
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void e(com.tencent.mobileqq.main.api.d dVar) {
        c.a.j(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void f(com.tencent.mobileqq.main.api.d proxy) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        QLog.i("DrawerFramePart", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        c.a.f(this, proxy);
        QQSettingMe qQSettingMe = this.qqSettingMe;
        if (qQSettingMe != null) {
            qQSettingMe.e0();
        }
        this.qqSettingMe = null;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.qqSettingMePreloadRunnable);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.qqSettingMeFillDataRunnable);
        t();
        this.proxy = null;
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void g(com.tencent.mobileqq.main.api.d dVar, boolean z16) {
        c.a.c(this, dVar, z16);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void h(com.tencent.mobileqq.main.api.d proxy) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        QLog.i("DrawerFramePart", 1, "onAccountChanged");
        ((IDrawerApi) QRoute.api(IDrawerApi.class)).clearConfig();
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.qqSettingMeFillDataRunnable, 1000L);
        ((IDrawerApi) QRoute.api(IDrawerApi.class)).preloadConfig();
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void i(com.tencent.mobileqq.main.api.d dVar) {
        c.a.g(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void j(com.tencent.mobileqq.main.api.d dVar) {
        c.a.h(this, dVar);
    }

    @Override // com.tencent.mobileqq.main.api.c
    public void onPostThemeChanged() {
        QLog.i("DrawerFramePart", 1, "onPostThemeChanged");
        QQSettingMe qQSettingMe = this.qqSettingMe;
        if (qQSettingMe != null) {
            qQSettingMe.onPostThemeChanged();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/main/loginpart/DrawerFramePart$b", "Lcom/tencent/mobileqq/activity/recent/DrawerFrame$d;", "", "side", "", "d", "actionFlag", "a", "b", "", "scale", "e", "", "open", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements DrawerFrame.d {
        b() {
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void a(int side, int actionFlag) {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.g0();
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void b(int side, int actionFlag) {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.f0();
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void d(int side) {
            QQSettingMe qQSettingMe = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe != null) {
                qQSettingMe.a0();
            }
            QQSettingMe qQSettingMe2 = DrawerFramePart.this.qqSettingMe;
            if (qQSettingMe2 != null) {
                qQSettingMe2.r();
            }
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void c(int side, boolean open) {
        }

        @Override // com.tencent.mobileqq.activity.recent.DrawerFrame.d
        public void e(int side, float scale) {
        }
    }
}
