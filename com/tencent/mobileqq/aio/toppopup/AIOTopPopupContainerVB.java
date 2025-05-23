package com.tencent.mobileqq.aio.toppopup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.toppopup.AIOTopPopupUIState;
import com.tencent.mobileqq.aio.toppopup.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u001b\u00102\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/toppopup/b;", "Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupUIState;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "param", "", "i1", "o1", ICustomDataEditor.NUMBER_PARAM_1, "", "l1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/aio/toppopup/a;", "h1", "state", "m1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "j1", "()Landroid/widget/FrameLayout;", "mContainer", "e", "Landroid/view/View;", "mContent", "f", "Landroid/animation/ValueAnimator;", "mShowAnimator", h.F, "mHideAnimator", "", "i", "Z", "mIsShowing", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsAnimation", BdhLogUtil.LogTag.Tag_Conn, "k1", "()Ljava/lang/String;", "mPeerId", "<init>", "()V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTopPopupContainerVB extends com.tencent.aio.base.mvvm.a<com.tencent.mobileqq.aio.toppopup.b, AIOTopPopupUIState> implements ValueAnimator.AnimatorUpdateListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPeerId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mShowAnimator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mHideAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnimation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB$a;", "", "", "ANIMATION_DURATION", "J", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTopPopupContainerVB.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOTopPopupContainerVB.this.mIsShowing = false;
                AIOTopPopupContainerVB.this.mIsAnimation = false;
                AIOTopPopupContainerVB.this.j1().removeView(AIOTopPopupContainerVB.this.mContent);
                AIOTopPopupContainerVB.this.j1().setVisibility(8);
                AIOTopPopupContainerVB.this.mContent = null;
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/toppopup/AIOTopPopupContainerVB$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTopPopupContainerVB.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOTopPopupContainerVB.this.mIsShowing = true;
                AIOTopPopupContainerVB.this.mIsAnimation = false;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOTopPopupContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB$mContainer$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopPopupContainerVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FrameLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FrameLayout frameLayout = new FrameLayout(AIOTopPopupContainerVB.this.getMContext());
                    frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    frameLayout.setVisibility(8);
                    return frameLayout;
                }
            });
            this.mContainer = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.toppopup.AIOTopPopupContainerVB$mPeerId$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTopPopupContainerVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String l16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    l16 = AIOTopPopupContainerVB.this.l1();
                    return l16;
                }
            });
            this.mPeerId = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void i1(int busiType, Object param) {
        if (this.mIsAnimation) {
            return;
        }
        if (this.mIsShowing) {
            n1();
        } else {
            o1(busiType, param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout j1() {
        return (FrameLayout) this.mContainer.getValue();
    }

    private final String k1() {
        return (String) this.mPeerId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l1() {
        b.a aVar = new b.a(null, 1, null);
        sendIntent(aVar);
        return aVar.a();
    }

    private final void n1() {
        sendIntent(b.C7367b.f194073d);
        View view = this.mContent;
        if (view != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(view.getHeight(), 0);
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(this);
            ofInt.addListener(new b());
            ofInt.start();
            this.mHideAnimator = ofInt;
            this.mIsAnimation = true;
        }
    }

    private final void o1(int busiType, Object param) {
        b.c cVar = new b.c(null);
        sendIntent(cVar);
        com.tencent.qqnt.aio.toppopup.a a16 = com.tencent.qqnt.aio.toppopup.b.f352150a.a(String.valueOf(busiType));
        if (a16 != null) {
            Context mContext = getMContext();
            String k16 = k1();
            if (param == null) {
                param = cVar.a();
            }
            a16.a(mContext, k16, param);
            this.mContent = a16.getView();
            j1().addView(this.mContent);
            j1().setVisibility(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, a16.getHeight());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(this);
            ofInt.addListener(new c());
            ofInt.start();
            this.mShowAnimator = ofInt;
            this.mIsAnimation = true;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public a createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOTopPopupUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOTopPopupUIState.ChangeState) {
            AIOTopPopupUIState.ChangeState changeState = (AIOTopPopupUIState.ChangeState) state;
            i1(changeState.a(), changeState.b());
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) animation);
            return;
        }
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        FrameLayout j16 = j1();
        ViewGroup.LayoutParams layoutParams = j16.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
        j16.requestLayout();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return j1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        View view = this.mContent;
        if (view != null) {
            j1().removeView(view);
            j1().setVisibility(8);
            this.mContent = null;
            this.mIsShowing = false;
        }
    }
}
