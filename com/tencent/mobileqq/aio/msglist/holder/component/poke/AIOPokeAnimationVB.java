package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeAnimationUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.GreatMoveCombolEffectView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001HB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "", "q1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationUIState$AddSixView;", "state", "m1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationUIState$StartGreatMoveView;", "u1", "B1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationUIState$StartHeartView;", "y1", "w1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationUIState$StartVasView;", "A1", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/ViewGroup;", "r1", "Lcom/tencent/aio/base/mvvm/b;", ICustomDataEditor.NUMBER_PARAM_1, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p1", "d", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/SixCombolEffectView;", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/SixCombolEffectView;", "mSixCombolEffectView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/GreatMoveCombolEffectView;", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/GreatMoveCombolEffectView;", "mGreatMoveCombolEffectView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/ZanCombolEffectView;", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/ZanCombolEffectView;", "mZanComboleEffectView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/HeartCombolEffectView;", "i", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/HeartCombolEffectView;", "mHeartCombolEffectView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/HeartBreakCombolEffectView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/HeartBreakCombolEffectView;", "mHeartBreakCombolEffectView", "Lcom/airbnb/lottie/LottieAnimationView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/airbnb/lottie/LottieAnimationView;", "mFullscreenLottieAnimationView", "", "D", "Z", "isVasPokeFullscreenAdded", "E", "mImplictViewAIOView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/ah;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/ah;", "mViewAnimation", "Landroid/os/Handler;", "G", "Lkotlin/Lazy;", "o1", "()Landroid/os/Handler;", "uiHandler", "<init>", "(Landroid/view/ViewGroup;)V", "H", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPokeAnimationVB extends com.tencent.aio.base.mvvm.a<at.d, Reserve2UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static volatile boolean I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView mFullscreenLottieAnimationView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isVasPokeFullscreenAdded;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LottieAnimationView mImplictViewAIOView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ah mViewAnimation;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SixCombolEffectView mSixCombolEffectView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GreatMoveCombolEffectView mGreatMoveCombolEffectView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ZanCombolEffectView mZanComboleEffectView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HeartCombolEffectView mHeartCombolEffectView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HeartBreakCombolEffectView mHeartBreakCombolEffectView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationVB$a;", "", "", "isForbidPokeMessageAnimationPlay", "Z", "a", "()Z", "setForbidPokeMessageAnimationPlay", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeAnimationVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOPokeAnimationVB.I;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationVB$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeAnimationVB.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationStart(animation);
            ah ahVar = AIOPokeAnimationVB.this.mViewAnimation;
            if (ahVar != null) {
                AIOPokeAnimationVB aIOPokeAnimationVB = AIOPokeAnimationVB.this;
                ahVar.f191655d = null;
                LottieAnimationView lottieAnimationView = aIOPokeAnimationVB.mImplictViewAIOView;
                if (lottieAnimationView != null) {
                    j3 = lottieAnimationView.getDuration();
                } else {
                    j3 = 0;
                }
                ahVar.setDuration(j3);
                ae aeVar = ae.f191631a;
                Context context = aIOPokeAnimationVB.rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "this@AIOPokeAnimationVB.rootView.context");
                aeVar.A(context, ahVar);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeAnimationVB$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOPokeAnimationVB.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            if (AIOPokeAnimationVB.this.isVasPokeFullscreenAdded) {
                AIOPokeAnimationVB.this.isVasPokeFullscreenAdded = false;
                LottieAnimationView lottieAnimationView = AIOPokeAnimationVB.this.mFullscreenLottieAnimationView;
                Intrinsics.checkNotNull(lottieAnimationView);
                lottieAnimationView.setImageDrawable(null);
                AIOPokeAnimationVB.this.rootView.removeView(AIOPokeAnimationVB.this.mFullscreenLottieAnimationView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOPokeAnimationVB(@NotNull ViewGroup rootView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView);
            return;
        }
        this.rootView = rootView;
        lazy = LazyKt__LazyJVMKt.lazy(AIOPokeAnimationVB$uiHandler$2.INSTANCE);
        this.uiHandler = lazy;
    }

    private final void A1(AIOPokeAnimationUIState.StartVasView state) {
        LottieAnimationView lottieAnimationView;
        float f16;
        LottieAnimationView lottieAnimationView2 = this.mFullscreenLottieAnimationView;
        if (lottieAnimationView2 == null) {
            LottieAnimationView lottieAnimationView3 = new LottieAnimationView(this.rootView.getContext());
            lottieAnimationView3.setScaleType(ImageView.ScaleType.FIT_XY);
            lottieAnimationView3.addAnimatorListener(new c());
            lottieAnimationView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mFullscreenLottieAnimationView = lottieAnimationView3;
        } else {
            Intrinsics.checkNotNull(lottieAnimationView2);
            if (lottieAnimationView2.isAnimating()) {
                LottieAnimationView lottieAnimationView4 = this.mFullscreenLottieAnimationView;
                Intrinsics.checkNotNull(lottieAnimationView4);
                lottieAnimationView4.cancelAnimation();
            }
        }
        LottieAnimationView lottieAnimationView5 = this.mFullscreenLottieAnimationView;
        if (lottieAnimationView5 != null) {
            if (state.b()) {
                f16 = 1.0f;
            } else {
                f16 = -1.0f;
            }
            lottieAnimationView5.setScaleX(f16);
        }
        if (!this.isVasPokeFullscreenAdded) {
            this.isVasPokeFullscreenAdded = true;
            this.rootView.addView(this.mFullscreenLottieAnimationView);
        }
        ae aeVar = ae.f191631a;
        LottieAnimationView lottieAnimationView6 = this.mFullscreenLottieAnimationView;
        Intrinsics.checkNotNull(lottieAnimationView6);
        aeVar.f(lottieAnimationView6, null, state.a(), ReportConst.ACTION.FULLSCREEN);
        LottieAnimationView lottieAnimationView7 = this.mImplictViewAIOView;
        boolean z16 = false;
        if (lottieAnimationView7 != null && lottieAnimationView7.isAnimating()) {
            z16 = true;
        }
        if (z16 && (lottieAnimationView = this.mImplictViewAIOView) != null) {
            lottieAnimationView.cancelAnimation();
        }
        ah ahVar = this.mViewAnimation;
        if (ahVar != null) {
            ahVar.h(true ^ state.b());
        }
        LottieAnimationView lottieAnimationView8 = this.mImplictViewAIOView;
        Intrinsics.checkNotNull(lottieAnimationView8);
        aeVar.f(lottieAnimationView8, null, state.a(), "view_aio");
    }

    private final void B1() {
        if (this.mZanComboleEffectView == null) {
            this.mZanComboleEffectView = new ZanCombolEffectView(this.rootView.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ZanCombolEffectView zanCombolEffectView = this.mZanComboleEffectView;
            if (zanCombolEffectView != null) {
                zanCombolEffectView.i(this.rootView.getResources().getDisplayMetrics().widthPixels, com.tencent.mobileqq.utils.x.a(40.0f), 0.0f, 150.0f, com.tencent.mobileqq.utils.x.a(100.0f), com.tencent.mobileqq.utils.x.a(3.0f), com.tencent.mobileqq.utils.x.a(800.0f), this.rootView.getResources().getDisplayMetrics().heightPixels, ae.f191631a.w());
            }
            this.rootView.addView(this.mZanComboleEffectView, layoutParams);
        }
        o1().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.g
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeAnimationVB.C1(AIOPokeAnimationVB.this);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(AIOPokeAnimationVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZanCombolEffectView zanCombolEffectView = this$0.mZanComboleEffectView;
        if (zanCombolEffectView != null) {
            zanCombolEffectView.j(Integer.valueOf(R.drawable.cd8), Integer.valueOf(R.drawable.cd9), Integer.valueOf(R.drawable.cd_), Integer.valueOf(R.drawable.cda), Integer.valueOf(R.drawable.cdb), Integer.valueOf(R.drawable.cdc));
        }
    }

    private final void m1(AIOPokeAnimationUIState.AddSixView state) {
        if (this.mSixCombolEffectView == null) {
            this.mSixCombolEffectView = new SixCombolEffectView(this.rootView.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = ScreenUtil.dip2px(50.0f);
            this.rootView.addView(this.mSixCombolEffectView, layoutParams);
        }
        state.b(this.mSixCombolEffectView);
    }

    private final Handler o1() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void q1() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.rootView.getContext());
        lottieAnimationView.addAnimatorListener(new b());
        this.mViewAnimation = new ah(lottieAnimationView);
        this.mImplictViewAIOView = lottieAnimationView;
        this.rootView.addView(this.mImplictViewAIOView, new RelativeLayout.LayoutParams(1, 1));
    }

    private final void s1() {
        SixCombolEffectView sixCombolEffectView = this.mSixCombolEffectView;
        if (sixCombolEffectView != null) {
            this.rootView.removeView(sixCombolEffectView);
            sixCombolEffectView.g();
            this.mSixCombolEffectView = null;
        }
        GreatMoveCombolEffectView greatMoveCombolEffectView = this.mGreatMoveCombolEffectView;
        if (greatMoveCombolEffectView != null) {
            this.rootView.removeView(greatMoveCombolEffectView);
            greatMoveCombolEffectView.h();
            this.mGreatMoveCombolEffectView = null;
        }
        ZanCombolEffectView zanCombolEffectView = this.mZanComboleEffectView;
        if (zanCombolEffectView != null) {
            this.rootView.removeView(zanCombolEffectView);
            this.mZanComboleEffectView = null;
        }
        HeartCombolEffectView heartCombolEffectView = this.mHeartCombolEffectView;
        if (heartCombolEffectView != null) {
            this.rootView.removeView(heartCombolEffectView);
            this.mHeartCombolEffectView = null;
        }
        HeartBreakCombolEffectView heartBreakCombolEffectView = this.mHeartBreakCombolEffectView;
        if (heartBreakCombolEffectView != null) {
            this.rootView.removeView(heartBreakCombolEffectView);
            heartBreakCombolEffectView.h();
            this.mHeartCombolEffectView = null;
        }
        LottieAnimationView lottieAnimationView = this.mFullscreenLottieAnimationView;
        if (lottieAnimationView != null && this.isVasPokeFullscreenAdded) {
            this.isVasPokeFullscreenAdded = false;
            this.rootView.removeView(lottieAnimationView);
            this.mFullscreenLottieAnimationView = null;
        }
    }

    private final void u1(final AIOPokeAnimationUIState.StartGreatMoveView state) {
        if (this.mGreatMoveCombolEffectView == null) {
            GreatMoveCombolEffectView greatMoveCombolEffectView = new GreatMoveCombolEffectView(this.rootView.getContext());
            greatMoveCombolEffectView.setId(R.id.vsn);
            this.mGreatMoveCombolEffectView = greatMoveCombolEffectView;
            this.rootView.addView(this.mGreatMoveCombolEffectView, new FrameLayout.LayoutParams(-1, -1));
        }
        GreatMoveCombolEffectView greatMoveCombolEffectView2 = this.mGreatMoveCombolEffectView;
        if (greatMoveCombolEffectView2 != null) {
            greatMoveCombolEffectView2.n(state.b(), state.d(), state.c(), new GreatMoveCombolEffectView.b() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.i
                @Override // com.tencent.mobileqq.aio.msglist.holder.component.poke.GreatMoveCombolEffectView.b
                public final void a() {
                    AIOPokeAnimationVB.v1(AIOPokeAnimationUIState.StartGreatMoveView.this);
                }
            });
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOPokeAnimationVB", 2, "start great move full screen animation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(AIOPokeAnimationUIState.StartGreatMoveView state) {
        Intrinsics.checkNotNullParameter(state, "$state");
        state.a().run();
    }

    private final void w1() {
        if (this.mHeartBreakCombolEffectView == null) {
            this.mHeartBreakCombolEffectView = new HeartBreakCombolEffectView(this.rootView.getContext());
            this.rootView.addView(this.mHeartBreakCombolEffectView, new RelativeLayout.LayoutParams(-1, -1));
        }
        o1().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.h
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeAnimationVB.x1(AIOPokeAnimationVB.this);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(AIOPokeAnimationVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HeartBreakCombolEffectView heartBreakCombolEffectView = this$0.mHeartBreakCombolEffectView;
        if (heartBreakCombolEffectView != null) {
            heartBreakCombolEffectView.k();
        }
    }

    private final void y1(final AIOPokeAnimationUIState.StartHeartView state) {
        if (this.mHeartCombolEffectView == null) {
            this.mHeartCombolEffectView = new HeartCombolEffectView(this.rootView.getContext(), ae.f191631a.w());
            this.rootView.addView(this.mHeartCombolEffectView, new RelativeLayout.LayoutParams(-1, -1));
        }
        o1().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.f
            @Override // java.lang.Runnable
            public final void run() {
                AIOPokeAnimationVB.z1(AIOPokeAnimationVB.this, state);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(AIOPokeAnimationVB this$0, AIOPokeAnimationUIState.StartHeartView state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        HeartCombolEffectView heartCombolEffectView = this$0.mHeartCombolEffectView;
        if (heartCombolEffectView != null) {
            heartCombolEffectView.d(state.a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.d, Reserve2UIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new j();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        o1().removeCallbacksAndMessages(null);
        this.rootView.clearAnimation();
        s1();
        ae.f191631a.x();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull Reserve2UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOPokeAnimationUIState.AddSixView) {
            m1((AIOPokeAnimationUIState.AddSixView) state);
            return;
        }
        if (state instanceof AIOPokeAnimationUIState.StartGreatMoveView) {
            u1((AIOPokeAnimationUIState.StartGreatMoveView) state);
            return;
        }
        if (state instanceof AIOPokeAnimationUIState.StartZanView) {
            B1();
            return;
        }
        if (state instanceof AIOPokeAnimationUIState.StartHeartView) {
            y1((AIOPokeAnimationUIState.StartHeartView) state);
        } else if (state instanceof AIOPokeAnimationUIState.StartHeartBreakView) {
            w1();
        } else if (state instanceof AIOPokeAnimationUIState.StartVasView) {
            A1((AIOPokeAnimationUIState.StartVasView) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public ViewGroup onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ViewGroup viewGroup = this.rootView;
        q1();
        return viewGroup;
    }
}
