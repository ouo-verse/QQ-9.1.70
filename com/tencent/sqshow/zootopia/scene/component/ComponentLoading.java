package com.tencent.sqshow.zootopia.scene.component;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.f;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanAvatarSceneLoadingView;
import com.tencent.sqshow.zootopia.scene.component.ComponentLoading;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001n\b\u0016\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001wB\u0011\u0012\b\b\u0002\u0010;\u001a\u000206\u00a2\u0006\u0004\bu\u0010vJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\"\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J,\u0010#\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%J\u0012\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u0004\u0018\u00010+J\u0010\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0014J\b\u00101\u001a\u000200H\u0014J \u00104\u001a\u00020\u00052\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\u0005H\u0002R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010F\u001a\u0004\u0018\u00010!8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010L\u001a\u0004\u0018\u00010+8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010MR\u0016\u0010Q\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\"\u0010R\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010'\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010VR\u0014\u0010\\\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010PR\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010'R\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010VR\u0018\u0010a\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010`R\u0016\u0010b\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010PR\"\u0010c\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\bc\u0010S\"\u0004\bd\u0010UR\u0018\u0010f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010eR\"\u0010m\u001a\u00020g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010oR$\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u00030qj\b\u0012\u0004\u0012\u00020\u0003`r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010s\u00a8\u0006x"}, d2 = {"Lcom/tencent/sqshow/zootopia/scene/component/ComponentLoading;", "Lwb4/b;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Lc84/a;", "l", "", "N", "show", "", "W", "Landroid/graphics/drawable/Drawable;", "O", "c0", "", "U", "o", "Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", BdhLogUtil.LogTag.Tag_Req, "outDuration", "Lkotlin/Function0;", "callback", "X", "f", "Lpd3/b;", "b0", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, UserInfo.SEX_FEMALE, "G", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "listener", "Z", "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "V", "Landroid/content/Context;", "context", "P", "", ExifInterface.LATITUDE_SOUTH, "start", "end", "d0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "()Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", TagName.ENGINE_TYPE, "", "D", "Ljava/lang/String;", "TAG", "E", "Landroid/view/ViewGroup;", "getLoadingContainerView", "()Landroid/view/ViewGroup;", "setLoadingContainerView", "(Landroid/view/ViewGroup;)V", "loadingContainerView", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "T", "()Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "setLoadingView", "(Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;)V", "loadingView", "Lpd3/b;", "loadingCallback", "H", "I", "systemUiVisibility", "isEngineSceneReady", "()Z", "setEngineSceneReady", "(Z)V", "J", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView$b;", "closeClickListener", "K", "startTime", "L", "randomFastProgress", "M", "hasFastAnimationRun", "progressDuration", "Landroid/animation/ValueAnimator;", "progressAnimation", "fakeProgress", "isEnd", "setEnd", "Landroid/animation/ObjectAnimator;", "loadingHideAnim", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getCurrentSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a0", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "currentSource", "com/tencent/sqshow/zootopia/scene/component/ComponentLoading$c", "Lcom/tencent/sqshow/zootopia/scene/component/ComponentLoading$c;", "pauseListener", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mLoadingListenerPool", "<init>", "(Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ComponentLoading extends wb4.b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final AvatarEngineType engineType;

    /* renamed from: D, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup loadingContainerView;

    /* renamed from: F, reason: from kotlin metadata */
    private ISceneLoadingView loadingView;

    /* renamed from: G, reason: from kotlin metadata */
    private pd3.b loadingCallback;

    /* renamed from: H, reason: from kotlin metadata */
    private int systemUiVisibility;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isEngineSceneReady;

    /* renamed from: J, reason: from kotlin metadata */
    private ISceneLoadingView.b closeClickListener;

    /* renamed from: K, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: L, reason: from kotlin metadata */
    private final int randomFastProgress;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasFastAnimationRun;

    /* renamed from: N, reason: from kotlin metadata */
    private long progressDuration;

    /* renamed from: P, reason: from kotlin metadata */
    private ValueAnimator progressAnimation;

    /* renamed from: Q, reason: from kotlin metadata */
    private int fakeProgress;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: S, reason: from kotlin metadata */
    private ObjectAnimator loadingHideAnim;

    /* renamed from: T, reason: from kotlin metadata */
    private ZootopiaSource currentSource;

    /* renamed from: U, reason: from kotlin metadata */
    private final c pauseListener;

    /* renamed from: V, reason: from kotlin metadata */
    private final HashSet<c84.a> mLoadingListenerPool;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/scene/component/ComponentLoading$c", "Landroid/animation/Animator$AnimatorPauseListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationPause", "onAnimationResume", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animator.AnimatorPauseListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ComponentLoading this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ISceneLoadingView loadingView = this$0.getLoadingView();
            if (loadingView != null) {
                loadingView.pauseAnim();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ComponentLoading this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ISceneLoadingView loadingView = this$0.getLoadingView();
            if (loadingView != null) {
                loadingView.resumeAnim();
            }
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animation) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ComponentLoading componentLoading = ComponentLoading.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.scene.component.b
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentLoading.c.c(ComponentLoading.this);
                }
            });
        }

        @Override // android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animation) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ComponentLoading componentLoading = ComponentLoading.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.scene.component.a
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentLoading.c.d(ComponentLoading.this);
                }
            });
        }
    }

    public /* synthetic */ ComponentLoading(AvatarEngineType avatarEngineType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AvatarEngineType.FILAMENT : avatarEngineType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        QLog.i(this.TAG, 1, "doHide loadingView");
        ISceneLoadingView iSceneLoadingView = this.loadingView;
        if (iSceneLoadingView != null) {
            if (iSceneLoadingView.getView().getVisibility() == 8) {
                return;
            }
            iSceneLoadingView.getView().setVisibility(8);
            ViewGroup viewGroup = this.loadingContainerView;
            if (viewGroup != null) {
                viewGroup.removeView(iSceneLoadingView.getView());
            }
        }
        ISceneLoadingView iSceneLoadingView2 = this.loadingView;
        if (iSceneLoadingView2 != null) {
            iSceneLoadingView2.destroy();
        }
        this.loadingView = null;
        pd3.b bVar = this.loadingCallback;
        if (bVar != null) {
            bVar.U();
        }
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        this.loadingView = null;
        ViewGroup viewGroup = this.loadingContainerView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.loadingContainerView = container;
        boolean d16 = FilamentApiImpl.f369933a.d();
        QLog.i(this.TAG, 1, "bind loadingView isFilamentEngine:" + d16);
    }

    public final void N(c84.a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mLoadingListenerPool.add(l3);
    }

    protected Drawable O() {
        return null;
    }

    protected ISceneLoadingView P(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanAvatarSceneLoadingView zPlanAvatarSceneLoadingView = new ZPlanAvatarSceneLoadingView(context, null, 0, 6, null);
        zPlanAvatarSceneLoadingView.setStyleMode(getStyleMode());
        return zPlanAvatarSceneLoadingView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ObjectAnimator R(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        float alpha = view.getAlpha();
        QLog.i(this.TAG, 1, "currentAlpha :" + alpha);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, alpha, alpha, alpha * 0.95f, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(\n            vie\u2026urrentAlpha, 0f\n        )");
        return ofFloat;
    }

    /* renamed from: S */
    protected int getStyleMode() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: T, reason: from getter */
    public final ISceneLoadingView getLoadingView() {
        return this.loadingView;
    }

    protected long U() {
        return 250L;
    }

    public final ISceneLoadingView V() {
        return this.loadingView;
    }

    protected boolean W() {
        return true;
    }

    public void X(long outDuration, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.isEnd = true;
        if (outDuration == 0) {
            callback.invoke();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(this.TAG, 4, "onProgressEnd current:" + currentTimeMillis + ", start:" + this.startTime + ", fakeProgress:" + this.fakeProgress);
        b bVar = new b(callback, this);
        long U = U();
        long j3 = this.progressDuration - (currentTimeMillis - this.startTime);
        if (j3 == 0) {
            callback.invoke();
            return;
        }
        if (1 <= j3 && j3 <= U) {
            ValueAnimator valueAnimator = this.progressAnimation;
            if (valueAnimator != null) {
                valueAnimator.addListener(bVar);
                return;
            }
            return;
        }
        d0(this.fakeProgress, 100, U);
        ValueAnimator valueAnimator2 = this.progressAnimation;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(bVar);
        }
    }

    public final void Z(ISceneLoadingView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeClickListener = listener;
        ISceneLoadingView iSceneLoadingView = this.loadingView;
        if (iSceneLoadingView != null) {
            iSceneLoadingView.setCloseListener(listener);
        }
    }

    public final void a0(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.currentSource = zootopiaSource;
    }

    public void b0(pd3.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.loadingCallback = callback;
    }

    public final void c0() {
        QLog.d(this.TAG, 4, "startProgress");
        this.progressDuration = 5000L;
        this.isEnd = false;
        this.startTime = System.currentTimeMillis();
        d0(0, this.randomFastProgress, this.progressDuration);
    }

    @Override // wb4.a, od3.c
    public void f(long outDuration) {
        QLog.i(this.TAG, 1, "hide loadingView is null " + (this.loadingView == null));
        pd3.b bVar = this.loadingCallback;
        if (bVar != null) {
            bVar.Bb();
        }
        if (outDuration == 0) {
            this.isEnd = true;
            Q();
        } else {
            X(outDuration, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.scene.component.ComponentLoading$hide$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    String str;
                    ComponentLoading.this.hasFastAnimationRun = false;
                    ISceneLoadingView loadingView = ComponentLoading.this.getLoadingView();
                    ViewGroup view = loadingView != null ? loadingView.getView() : null;
                    str = ComponentLoading.this.TAG;
                    QLog.i(str, 1, "hide view :" + view);
                    if (view == null) {
                        return;
                    }
                    ObjectAnimator R = ComponentLoading.this.R(view);
                    ComponentLoading.this.loadingHideAnim = R;
                    R.setDuration(ComponentLoading.this.o());
                    R.addListener(new a(ComponentLoading.this));
                    R.start();
                }

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/scene/component/ComponentLoading$hide$1$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes34.dex */
                public static final class a extends f {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ComponentLoading f372997d;

                    a(ComponentLoading componentLoading) {
                        this.f372997d = componentLoading;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        String str;
                        str = this.f372997d.TAG;
                        QLog.i(str, 1, "on hide loading Animation Cancel");
                    }

                    @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        String str;
                        str = this.f372997d.TAG;
                        QLog.i(str, 1, "on hide loading Animation End");
                        this.f372997d.Q();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                    }
                }
            });
        }
    }

    /* renamed from: g0, reason: from getter */
    public final AvatarEngineType getEngineType() {
        return this.engineType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long o() {
        return 10L;
    }

    @Override // wb4.a, od3.c
    public void show() {
        ViewGroup viewGroup;
        boolean isEngineReady = FilamentApiImpl.f369933a.d() ? true : ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
        this.isEngineSceneReady = isEngineReady;
        String str = this.TAG;
        boolean z16 = this.loadingView == null;
        ObjectAnimator objectAnimator = this.loadingHideAnim;
        QLog.i(str, 1, "show loadingView is null " + z16 + ", isEngineSceneReady:" + isEngineReady + ", loadingHideAnim:" + objectAnimator + " , running:" + (objectAnimator != null ? Boolean.valueOf(objectAnimator.isRunning()) : null));
        ObjectAnimator objectAnimator2 = this.loadingHideAnim;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        if (this.loadingView == null && (viewGroup = this.loadingContainerView) != null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            ISceneLoadingView P = P(context);
            ISceneLoadingView.b bVar = this.closeClickListener;
            if (bVar != null) {
                P.setCloseListener(bVar);
            }
            P.getView().setVisibility(8);
            if (W()) {
                View closeIcon = P.getCloseIcon();
                if (closeIcon != null) {
                    closeIcon.setVisibility(0);
                    ISceneLoadingView.b bVar2 = this.closeClickListener;
                    if (bVar2 != null) {
                        bVar2.K2(viewGroup, 0L);
                    }
                }
            } else {
                View closeIcon2 = P.getCloseIcon();
                if (closeIcon2 != null) {
                    closeIcon2.setVisibility(8);
                }
            }
            Drawable O = O();
            if (O != null) {
                P.x().setBackground(O);
            }
            if (this.isEngineSceneReady) {
                Y(this, 0L, null, 3, null);
            }
            viewGroup.addView(P.getView(), -1, -1);
            this.loadingView = P;
        }
        ISceneLoadingView iSceneLoadingView = this.loadingView;
        if (iSceneLoadingView != null) {
            iSceneLoadingView.getView().setAlpha(1.0f);
            if (iSceneLoadingView.getView().getVisibility() == 0) {
                return;
            }
            iSceneLoadingView.getView().setVisibility(0);
            pd3.b bVar3 = this.loadingCallback;
            if (bVar3 != null) {
                bVar3.w0();
            }
            c0();
        }
    }

    @Override // wb4.a
    public void G() {
        this.loadingCallback = null;
        this.closeClickListener = null;
        ValueAnimator valueAnimator = this.progressAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = this.loadingHideAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ISceneLoadingView iSceneLoadingView = this.loadingView;
        if (iSceneLoadingView != null) {
            iSceneLoadingView.destroy();
        }
    }

    public ComponentLoading(AvatarEngineType engineType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        this.engineType = engineType;
        this.TAG = "ZPlanPortalComponentLoading-" + hashCode();
        this.systemUiVisibility = -1;
        this.randomFastProgress = new Random().nextInt(10) + 70;
        this.progressDuration = 60000L;
        this.currentSource = ZootopiaSource.INSTANCE.g();
        this.pauseListener = new c();
        this.mLoadingListenerPool = new HashSet<>();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        Object animatedValue = animation != null ? animation.getAnimatedValue() : null;
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int intValue = num.intValue();
            if (!this.hasFastAnimationRun && !this.isEnd && intValue == this.randomFastProgress) {
                this.hasFastAnimationRun = true;
                long max = Math.max(System.currentTimeMillis() - this.startTime, 0L);
                QLog.i(this.TAG, 1, "onAnimationUpdate costTime = " + max);
                d0(intValue, 100, 60000 - max);
                return;
            }
            if (intValue > 99 && !this.isEnd) {
                QLog.i(this.TAG, 1, "waiting first frame");
                animation.removeAllUpdateListeners();
                animation.removeAllListeners();
                animation.cancel();
                return;
            }
            this.fakeProgress = intValue;
            ISceneLoadingView iSceneLoadingView = this.loadingView;
            if (iSceneLoadingView != null) {
                iSceneLoadingView.setProgress(intValue);
            }
            Iterator<T> it = this.mLoadingListenerPool.iterator();
            while (it.hasNext()) {
                ((c84.a) it.next()).setProgress(this.fakeProgress);
            }
        }
    }

    private final void d0(int start, int end, long outDuration) {
        long coerceAtLeast = outDuration != 0 ? RangesKt___RangesKt.coerceAtLeast(outDuration, 100L) : 0L;
        QLog.i(this.TAG, 1, "updateDurationAndReStartProgress start:" + start + ", newDuration:" + coerceAtLeast + ", outDuration:" + outDuration);
        this.progressDuration = coerceAtLeast;
        ValueAnimator valueAnimator = this.progressAnimation;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.progressAnimation;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.progressAnimation;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(start, end);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(this.progressDuration);
        ofInt.addUpdateListener(this);
        ofInt.addPauseListener(this.pauseListener);
        this.progressAnimation = ofInt;
        ofInt.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Y(ComponentLoading componentLoading, long j3, Function0 function0, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = -1;
            }
            if ((i3 & 2) != 0) {
                function0 = new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.scene.component.ComponentLoading$onProgressEnd$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                };
            }
            componentLoading.X(j3, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onProgressEnd");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/scene/component/ComponentLoading$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f372994d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ComponentLoading f372995e;

        b(Function0<Unit> function0, ComponentLoading componentLoading) {
            this.f372994d = function0;
            this.f372995e = componentLoading;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f372994d.invoke();
            this.f372995e.fakeProgress = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
