package com.tencent.mobileqq.qwallet.hb.detail;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.hb.detail.HbSkinAppBarLayout;
import com.tencent.mobileqq.widget.OffsetAnimatorBehavior;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0002*+B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "", "P", "verticalOffset", "", "U", "T", "onFinishInflate", "", "hasWindowFocus", "onWindowFocusChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinViewModel;", "viewModel", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/Observer;", "stateObserver", "Z", "isStateInitialized", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinAppBarLayout$DisableFlingBehavior;", "Lkotlin/Lazy;", "O", "()Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinAppBarLayout$DisableFlingBehavior;", "disableFlingBehavior", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "V", "a", "DisableFlingBehavior", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinAppBarLayout extends AppBarLayout {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final HbSkinViewModel viewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Observer<HbSkinState> stateObserver;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isStateInitialized;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy disableFlingBehavior;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinAppBarLayout$DisableFlingBehavior;", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/google/android/material/appbar/AppBarLayout;", "child", "Landroid/view/View;", "directTargetChild", "target", "", "nestedScrollAxes", "type", "", "onStartNestedScroll", "coordinatorLayout", "abl", "", "onStopNestedScroll", "Landroid/view/MotionEvent;", "ev", "g", "j", "Z", "isFling", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "listener", "<init>", "(Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;)V", "k", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class DisableFlingBehavior extends OffsetAnimatorBehavior {

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean isFling;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisableFlingBehavior(@NotNull OffsetAnimatorBehavior.b listener) {
            super(listener);
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean onTouchEvent(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull MotionEvent ev5) {
            HbSkinAppBarLayout hbSkinAppBarLayout;
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(ev5, "ev");
            if (ev5.getAction() == 1) {
                if (child instanceof HbSkinAppBarLayout) {
                    hbSkinAppBarLayout = (HbSkinAppBarLayout) child;
                } else {
                    hbSkinAppBarLayout = null;
                }
                if (hbSkinAppBarLayout != null) {
                    hbSkinAppBarLayout.U(getTopAndBottomOffset());
                }
                return true;
            }
            return super.onTouchEvent(parent, child, ev5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull View directTargetChild, @NotNull View target, int nestedScrollAxes, int type) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
            Intrinsics.checkNotNullParameter(target, "target");
            ValueAnimator offsetAnimator = getOffsetAnimator();
            if (offsetAnimator != null && offsetAnimator.isRunning()) {
                offsetAnimator.cancel();
            }
            if (type == 1) {
                if (target.getScrollY() <= 0 && getTopAndBottomOffset() <= (-child.p())) {
                    return false;
                }
                this.isFling = true;
            }
            return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout abl, @NotNull View target, int type) {
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(abl, "abl");
            Intrinsics.checkNotNullParameter(target, "target");
            super.onStopNestedScroll(coordinatorLayout, abl, target, type);
            if (this.isFling && type == 0) {
                this.isFling = false;
                return;
            }
            this.isFling = false;
            HbSkinAppBarLayout hbSkinAppBarLayout = abl instanceof HbSkinAppBarLayout ? (HbSkinAppBarLayout) abl : null;
            if (hbSkinAppBarLayout != null) {
                hbSkinAppBarLayout.U(getTopAndBottomOffset());
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277312a;

        static {
            int[] iArr = new int[HbSkinState.values().length];
            try {
                iArr[HbSkinState.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HbSkinState.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HbSkinState.INTERMEDIATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f277312a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinAppBarLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final DisableFlingBehavior O() {
        return (DisableFlingBehavior) this.disableFlingBehavior.getValue();
    }

    private final int P() {
        return this.viewModel.P1(p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(HbSkinAppBarLayout this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.viewModel.Z1().getValue() != null) {
            this$0.T(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(HbSkinAppBarLayout this$0, HbSkinState hbSkinState) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hbSkinState == null) {
            i3 = -1;
        } else {
            i3 = b.f277312a[hbSkinState.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                } else {
                    i16 = this$0.P();
                }
            } else {
                i16 = -this$0.p();
            }
        } else {
            i16 = 0;
        }
        this$0.O().c(i16, this$0.p(), hbSkinState.interpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(int verticalOffset) {
        this.viewModel.e2(p(), verticalOffset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(int verticalOffset) {
        if (this.viewModel.d2(p(), verticalOffset) == HbSkinState.EXPANDED) {
            HbDetailModule.l("redpacket.firstpic.drag", String.valueOf(this.viewModel.getSkinId()), "", this.viewModel.getUniqueSkinId());
        }
    }

    @NotNull
    /* renamed from: Q, reason: from getter */
    public final HbSkinViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("HbSkinAppBarLayout", 2, "onAttachedToWindow: ");
        this.viewModel.Z1().observeForever(this.stateObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("HbSkinAppBarLayout", 2, "onDetachedFromWindow: ");
        this.viewModel.Z1().removeObserver(this.stateObserver);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        QLog.d("HbSkinAppBarLayout", 2, "onFinishInflate: ");
        e(new AppBarLayout.g() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ad
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                HbSkinAppBarLayout.R(HbSkinAppBarLayout.this, appBarLayout, i3);
            }
        });
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && !this.isStateInitialized) {
            this.isStateInitialized = true;
            O().setTopAndBottomOffset(P());
            this.viewModel.Q1(HbSkinState.INITIAL);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HbSkinAppBarLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public HbSkinAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof ComponentActivity) {
            ViewModel viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(HbSkinViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(contex\u2026kinViewModel::class.java)");
            this.viewModel = (HbSkinViewModel) viewModel;
            this.stateObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.ac
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HbSkinAppBarLayout.S(HbSkinAppBarLayout.this, (HbSkinState) obj);
                }
            };
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<DisableFlingBehavior>() { // from class: com.tencent.mobileqq.qwallet.hb.detail.HbSkinAppBarLayout$disableFlingBehavior$2

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/detail/HbSkinAppBarLayout$disableFlingBehavior$2$a", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "", "newOffset", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes16.dex */
                public static final class a implements OffsetAnimatorBehavior.b {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ HbSkinAppBarLayout f277313d;

                    a(HbSkinAppBarLayout hbSkinAppBarLayout) {
                        this.f277313d = hbSkinAppBarLayout;
                    }

                    @Override // com.tencent.mobileqq.widget.OffsetAnimatorBehavior.b
                    public void a(int newOffset) {
                        this.f277313d.T(newOffset);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final HbSkinAppBarLayout.DisableFlingBehavior invoke() {
                    return new HbSkinAppBarLayout.DisableFlingBehavior(new a(HbSkinAppBarLayout.this));
                }
            });
            this.disableFlingBehavior = lazy;
            return;
        }
        throw new IllegalArgumentException("Make sure host activity inherited from ComponentActivity");
    }
}
