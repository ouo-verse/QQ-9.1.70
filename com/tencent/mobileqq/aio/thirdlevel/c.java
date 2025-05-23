package com.tencent.mobileqq.aio.thirdlevel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.thirdlevel.AIOCenterContainerUIState;
import com.tencent.mobileqq.aio.thirdlevel.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.f;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u001c\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/thirdlevel/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/thirdlevel/a;", "Lcom/tencent/mobileqq/aio/thirdlevel/AIOCenterContainerUIState;", "", "show", "Landroid/view/View;", "loadingView", "", "k1", "withAnim", "j1", "d1", "i1", "fadeIn", "fadeOut", "e1", "c1", "h1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "", "Ljava/lang/Class;", "getObserverStates", "state", "g1", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mCenterContainer", "e", "mFragmentContainer", "f", "mLoadingContainer", h.F, "Z", "mViewAdded", "Landroid/animation/ValueAnimator;", "i", "Landroid/animation/ValueAnimator;", "fadeInOutAnimator", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, AIOCenterContainerUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mCenterContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mFragmentContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mLoadingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mViewAdded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator fadeInOutAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/thirdlevel/c$a;", "", "", "FADE_IN_OUT_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.thirdlevel.c$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/thirdlevel/c$b", "Lcom/tencent/mobileqq/widget/f;", "", "e", "Landroid/animation/Animator;", "animation", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "onAnimationStart", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f193776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f193777e;

        b(View view, View view2) {
            this.f193776d = view;
            this.f193777e = view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) view2);
            }
        }

        private final void e() {
            Integer num;
            if (QLog.isColorLevel()) {
                View view = this.f193777e;
                Integer num2 = null;
                if (view != null) {
                    num = Integer.valueOf(view.hashCode());
                } else {
                    num = null;
                }
                View view2 = this.f193776d;
                if (view2 != null) {
                    num2 = Integer.valueOf(view2.hashCode());
                }
                QLog.i("AIOCenterContainerVB", 2, "onAnimFinish out: " + num + ", in: " + num2);
            }
            View view3 = this.f193777e;
            if (view3 != null) {
                view3.setAlpha(0.0f);
            }
            View view4 = this.f193777e;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View view5 = this.f193776d;
            if (view5 != null) {
                view5.setAlpha(1.0f);
            }
            View view6 = this.f193776d;
            if (view6 != null) {
                view6.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                e();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
                return;
            }
            View view = this.f193776d;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            View view2 = this.f193776d;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = this.f193777e;
            if (view3 != null) {
                view3.setAlpha(1.0f);
            }
            View view4 = this.f193777e;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c1() {
        ValueAnimator valueAnimator;
        if (h1() && (valueAnimator = this.fadeInOutAnimator) != null) {
            valueAnimator.cancel();
        }
    }

    private final void d1() {
        if (!this.mViewAdded) {
            this.mViewAdded = true;
            FrameLayout frameLayout = null;
            if (this.mFragmentContainer == null) {
                FrameLayout frameLayout2 = this.mCenterContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                    frameLayout2 = null;
                }
                FrameLayout frameLayout3 = new FrameLayout(frameLayout2.getContext());
                frameLayout3.setId(R.id.f164104sh4);
                this.mFragmentContainer = frameLayout3;
            }
            if (this.mLoadingContainer == null) {
                FrameLayout frameLayout4 = this.mCenterContainer;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                    frameLayout4 = null;
                }
                FrameLayout frameLayout5 = new FrameLayout(frameLayout4.getContext());
                frameLayout5.setVisibility(8);
                this.mLoadingContainer = frameLayout5;
            }
            FrameLayout frameLayout6 = this.mCenterContainer;
            if (frameLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                frameLayout6 = null;
            }
            frameLayout6.addView(this.mFragmentContainer, new ViewGroup.LayoutParams(-1, -1));
            FrameLayout frameLayout7 = this.mCenterContainer;
            if (frameLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
            } else {
                frameLayout = frameLayout7;
            }
            frameLayout.addView(this.mLoadingContainer, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private final void e1(final View fadeIn, final View fadeOut) {
        c1();
        if (this.fadeInOutAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(500L);
            this.fadeInOutAnimator = ofFloat;
        }
        ValueAnimator valueAnimator = this.fadeInOutAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.thirdlevel.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    c.f1(fadeIn, fadeOut, valueAnimator2);
                }
            });
            valueAnimator.addListener(new b(fadeIn, fadeOut));
        }
        ValueAnimator valueAnimator2 = this.fadeInOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(View view, View view2, ValueAnimator valueAnimator) {
        Object obj;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        Float f16 = (Float) obj;
        if (f16 != null) {
            f16.floatValue();
            if (view != null) {
                view.setAlpha(Math.min(f16.floatValue(), 1.0f));
            }
            if (view2 != null) {
                view2.setAlpha(Math.max(0.0f, 1.0f - f16.floatValue()));
            }
        }
    }

    private final boolean h1() {
        ValueAnimator valueAnimator = this.fadeInOutAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return false;
        }
        return true;
    }

    private final void i1() {
        QLog.i("AIOCenterContainerVB", 1, "onClear");
        FrameLayout frameLayout = this.mCenterContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.mCenterContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(4);
        this.mViewAdded = false;
        FrameLayout frameLayout4 = this.mFragmentContainer;
        if (frameLayout4 != null) {
            frameLayout4.removeAllViews();
        }
        FrameLayout frameLayout5 = this.mLoadingContainer;
        if (frameLayout5 != null) {
            frameLayout5.removeAllViews();
        }
    }

    private final void j1(boolean show, boolean withAnim) {
        QLog.i("AIOCenterContainerVB", 1, "onShowFragment show:" + show + " withAnim:" + withAnim);
        if (show) {
            d1();
        }
        FrameLayout frameLayout = null;
        if (withAnim) {
            if (show) {
                FrameLayout frameLayout2 = this.mCenterContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                    frameLayout2 = null;
                }
                e1(frameLayout2, null);
                return;
            }
            FrameLayout frameLayout3 = this.mCenterContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                frameLayout3 = null;
            }
            e1(null, frameLayout3);
            return;
        }
        c1();
        if (show) {
            if (QLog.isColorLevel()) {
                FrameLayout frameLayout4 = this.mCenterContainer;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                    frameLayout4 = null;
                }
                QLog.i("AIOCenterContainerVB", 2, "mCenterContainer: " + frameLayout4.hashCode() + ", visible");
            }
            FrameLayout frameLayout5 = this.mCenterContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                frameLayout5 = null;
            }
            frameLayout5.setVisibility(0);
            FrameLayout frameLayout6 = this.mCenterContainer;
            if (frameLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
            } else {
                frameLayout = frameLayout6;
            }
            frameLayout.setAlpha(1.0f);
            return;
        }
        if (QLog.isColorLevel()) {
            FrameLayout frameLayout7 = this.mCenterContainer;
            if (frameLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
                frameLayout7 = null;
            }
            QLog.i("AIOCenterContainerVB", 2, "mCenterContainer: " + frameLayout7.hashCode() + ", invisible");
        }
        FrameLayout frameLayout8 = this.mCenterContainer;
        if (frameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        } else {
            frameLayout = frameLayout8;
        }
        frameLayout.setVisibility(4);
    }

    private final void k1(boolean show, View loadingView) {
        if (show) {
            d1();
            if (loadingView != null) {
                FrameLayout frameLayout = this.mLoadingContainer;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                sendIntent(new a.b(true, loadingView));
                FrameLayout frameLayout2 = this.mLoadingContainer;
                if (frameLayout2 != null) {
                    frameLayout2.addView(loadingView, new ViewGroup.LayoutParams(-1, -1));
                }
                FrameLayout frameLayout3 = this.mLoadingContainer;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        FrameLayout frameLayout4 = this.mLoadingContainer;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(4);
            sendIntent(new a.b(false, frameLayout4));
            frameLayout4.removeAllViews();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            sendIntent(a.C7359a.f193765d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, AIOCenterContainerUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOCenterContainerUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOCenterContainerUIState.ShowLoading) {
            AIOCenterContainerUIState.ShowLoading showLoading = (AIOCenterContainerUIState.ShowLoading) state;
            k1(showLoading.b(), showLoading.a());
        } else if (state instanceof AIOCenterContainerUIState.ShowFragment) {
            AIOCenterContainerUIState.ShowFragment showFragment = (AIOCenterContainerUIState.ShowFragment) state;
            j1(showFragment.a(), showFragment.b());
        } else if (state instanceof AIOCenterContainerUIState.ClearState) {
            i1();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AIOCenterContainerUIState>> getObserverStates() {
        List<Class<? extends AIOCenterContainerUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AIOCenterContainerUIState.ShowFragment.class, AIOCenterContainerUIState.ClearState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setId(R.id.f164103sh3);
        frameLayout.setVisibility(8);
        this.mCenterContainer = frameLayout;
        return frameLayout;
    }
}
