package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C11732b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010-R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010/R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010/R\u0014\u00103\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyPageAsyncLoader;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;", "", "f", "", "reusePageController", "d", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "Landroid/util/Size;", "g", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "k", "Landroid/os/Bundle;", "args", "j", "showErrorView", "hideErrorView", "showLoadingView", "hideLoadingView", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Q3", "eh", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "pageController", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/e;", "e", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/e;", "replaceContext", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "emptyFrameLayout", "", "Ljava/lang/String;", "id", "Z", "hadDestroyAsyncLoader", "doStartActivity", BdhLogUtil.LogTag.Tag_Conn, "myTag", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "firstScreenTimeoutHandler", "E", "Landroid/content/Context;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "G", "Landroid/os/Bundle;", "<init>", "()V", "H", "Companion", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyPageAsyncLoader implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, h {
    private static int I;

    /* renamed from: C, reason: from kotlin metadata */
    private final String myTag;

    /* renamed from: D, reason: from kotlin metadata */
    private final Handler firstScreenTimeoutHandler;

    /* renamed from: E, reason: from kotlin metadata */
    private Context context;

    /* renamed from: F, reason: from kotlin metadata */
    private Activity activity;

    /* renamed from: G, reason: from kotlin metadata */
    private Bundle args;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private g pageController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private e replaceContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout emptyFrameLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String id;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hadDestroyAsyncLoader;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean doStartActivity;

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, QQKuiklyPageAsyncLoader> J = new LinkedHashMap();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u0017\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyPageAsyncLoader$Companion;", "", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "args", "", "j", "f", "bundle", "", tl.h.F, "", "g", "", "id", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyPageAsyncLoader;", "asyncLoader", "d", "i", "e", "KEY_ASYNC_LOADER_ID", "Ljava/lang/String;", "KEY_ENABLE_ASYNC_LOAD", "asyncLoaderControllerIdProduct", "I", "", "pageAsyncLoaderMap", "Ljava/util/Map;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String id5, QQKuiklyPageAsyncLoader asyncLoader) {
            QQKuiklyPageAsyncLoader.J.put(id5, asyncLoader);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Activity f(Context context) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            return qBaseActivity != null ? qBaseActivity : Foreground.getTopActivity();
        }

        private final int g(Bundle bundle) {
            Object obj = bundle.get("process_name");
            if (Intrinsics.areEqual("main", obj)) {
                return 1;
            }
            if (Intrinsics.areEqual("tool", obj)) {
                return 7;
            }
            if (Intrinsics.areEqual("local", obj)) {
                return MobileQQ.sProcessId;
            }
            return 1;
        }

        private final boolean h(Bundle bundle) {
            return MobileQQ.sProcessId == g(bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final QQKuiklyPageAsyncLoader i(String id5) {
            return (QQKuiklyPageAsyncLoader) QQKuiklyPageAsyncLoader.J.remove(id5);
        }

        private final void j(final Context context, final Activity activity, final Bundle args) {
            C11732b.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyPageAsyncLoader$Companion$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        new QQKuiklyPageAsyncLoader().j(context, activity, args);
                    } else {
                        QLog.i("QQKuiklyPageAsyncLoader", 1, "activity is finishing or destroyed");
                    }
                }
            });
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean e(Context context, Bundle args) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(args, "args");
            Activity f16 = f(context);
            if (f16 == null || args.containsKey("kr_async_loader_id") || args.containsKey(KuiklyLaunchParams.PARAM_MODAL_MODE) || KuiklyLaunchParams.INSTANCE.k(args) || !h(args)) {
                return false;
            }
            String string = args.getString("page_name");
            if (string == null) {
                string = "";
            }
            if (!QQKuiklyConfigManager.f262835a.a(string)) {
                return false;
            }
            String b16 = QQKuiklyRenderView.INSTANCE.b(string, args.getString(KuiklyLaunchParams.PARAM_TURBO_DISPLAY));
            if (b16 != null) {
                if (b16.length() > 0) {
                    z16 = true;
                    if (!z16) {
                        return false;
                    }
                    j(context, f16, args);
                    return true;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }

        Companion() {
        }
    }

    public QQKuiklyPageAsyncLoader() {
        int i3 = I;
        I = i3 + 1;
        this.id = String.valueOf(i3);
        this.myTag = "QQKuiklyPageAsyncLoader_" + hashCode();
        this.firstScreenTimeoutHandler = new Handler(Looper.getMainLooper());
    }

    private final void c() {
        if (this.hadDestroyAsyncLoader) {
            return;
        }
        this.hadDestroyAsyncLoader = true;
        m();
        INSTANCE.i(this.id);
        FrameLayout frameLayout = this.emptyFrameLayout;
        ViewParent parent = frameLayout != null ? frameLayout.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.emptyFrameLayout);
        }
        QLog.i(this.myTag, 1, "destroyAsyncLoader, " + (this.activity != null));
    }

    private final void d(boolean reusePageController) {
        Context context;
        Bundle bundle;
        if (this.doStartActivity || (context = this.context) == null || (bundle = this.args) == null) {
            return;
        }
        this.doStartActivity = true;
        if (reusePageController) {
            bundle.putString("kr_async_loader_id", this.id);
        }
        bundle.remove("kr_enable_async_load");
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, bundle);
        c();
    }

    private final void f() {
        Bundle bundle = this.args;
        if (bundle != null) {
            bundle.putBoolean(KuiklyLaunchParams.PARAM_SYNC_RENDERING, false);
            bundle.putString("kr_enable_async_load", "1");
        }
    }

    private final Size g() {
        return new Size(ScreenUtil.getInstantScreenWidth(this.context), ScreenUtil.getInstantScreenHeight(this.context) + ImmersiveUtils.statusHeight);
    }

    private final void h() {
        this.replaceContext = new e(this.context);
        Bundle bundle = new Bundle();
        bundle.putBundle("launchKuiklyParams", this.args);
        g gVar = new g(bundle, false, this, this.replaceContext);
        gVar.x(null);
        gVar.y(this, null, g());
        g.INSTANCE.a(this.id, gVar);
        this.pageController = gVar;
        INSTANCE.d(this.id, this);
    }

    private final void i(Context context, Activity activity) {
        c cVar = new c(context);
        this.emptyFrameLayout = cVar;
        activity.addContentView(cVar, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void k() {
        QLog.i(this.myTag, 1, "start firstScreenTimeoutTask timeout");
        this.firstScreenTimeoutHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.d
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyPageAsyncLoader.l(QQKuiklyPageAsyncLoader.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QQKuiklyPageAsyncLoader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INSTANCE.i(this$0.id);
        QLog.i(this$0.myTag, 1, "firstScreenTimeoutTask timeout");
        g gVar = this$0.pageController;
        if (gVar != null) {
            gVar.c(4);
        }
        e(this$0, false, 1, null);
    }

    private final void m() {
        this.firstScreenTimeoutHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.container.h
    /* renamed from: Q3, reason: from getter */
    public Context getContext() {
        return this.context;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.container.h
    /* renamed from: eh, reason: from getter */
    public Activity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
        QLog.i(this.myTag, 1, "[hideErrorView]");
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.q();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
        QLog.i(this.myTag, 1, "[hideLoadingView]");
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.r();
        }
    }

    public final void j(Context context, Activity activity, Bundle args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(args, "args");
        this.args = args;
        this.context = context;
        this.activity = INSTANCE.f(context);
        i(context, activity);
        f();
        h();
        k();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.d(this.myTag, 1, "onPageLoadComplete: isSucceed=" + isSucceed + ", errorReason=" + errorReason + ", executeMode=" + executeMode);
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.c(1);
        }
        e(this, false, 1, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
        QLog.i(this.myTag, 1, "[showErrorView]");
        if (this.hadDestroyAsyncLoader) {
            QLog.i(this.myTag, 1, "[showErrorView] hadDestroyAsyncLoader");
            return;
        }
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.c(2);
        }
        e(this, false, 1, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
        QLog.i(this.myTag, 1, "[showLoadingView]");
        if (this.hadDestroyAsyncLoader) {
            QLog.i(this.myTag, 1, "[showLoadingView] hadDestroyAsyncLoader");
            return;
        }
        g gVar = this.pageController;
        if (gVar != null) {
            gVar.c(3);
        }
        e(this, false, 1, null);
    }

    static /* synthetic */ void e(QQKuiklyPageAsyncLoader qQKuiklyPageAsyncLoader, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qQKuiklyPageAsyncLoader.d(z16);
    }
}
