package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.home.PullRefreshAppBarLayout;
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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0003>\u0014?B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0003\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0014J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0014R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\"\u0010'\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00105\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "", "offset", "totalRange", "", "U", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshState;", "newState", "O", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "onFinishInflate", "M", "T", "", "success", BdhLogUtil.LogTag.Tag_Req, "newOffset", "a", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$Behavior;", "Lkotlin/Lazy;", "N", "()Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$Behavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, ExifInterface.LATITUDE_SOUTH, "I", "lastOffset", "lastTotalRange", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshIndicator;", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshIndicator;", "refreshIndicator", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "V", "Landroidx/lifecycle/MutableLiveData;", "refreshStateLiveData", "W", "Z", "isDisabledRefresh", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;", "a0", "Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;", "getPullRefreshListener", "()Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;", "setPullRefreshListener", "(Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;)V", "pullRefreshListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Z", "isReadyState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b0", "Behavior", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PullRefreshAppBarLayout extends AppBarLayout implements OffsetAnimatorBehavior.b {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy behavior;

    /* renamed from: S, reason: from kotlin metadata */
    private int lastOffset;

    /* renamed from: T, reason: from kotlin metadata */
    private int lastTotalRange;

    /* renamed from: U, reason: from kotlin metadata */
    private PullRefreshIndicator refreshIndicator;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PullRefreshState> refreshStateLiveData;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isDisabledRefresh;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b pullRefreshListener;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$Behavior;", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/google/android/material/appbar/AppBarLayout;", "child", "Landroid/view/View;", "directTargetChild", "target", "", "nestedScrollAxes", "type", "", "onStartNestedScroll", "coordinatorLayout", "abl", "", "onStopNestedScroll", "Landroid/view/MotionEvent;", "ev", "g", "Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;", "listener", "<init>", "(Lcom/tencent/mobileqq/widget/OffsetAnimatorBehavior$b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class Behavior extends OffsetAnimatorBehavior {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(@NotNull OffsetAnimatorBehavior.b listener) {
            super(listener);
            Intrinsics.checkNotNullParameter(listener, "listener");
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean onTouchEvent(@NotNull CoordinatorLayout parent, @NotNull AppBarLayout child, @NotNull MotionEvent ev5) {
            PullRefreshAppBarLayout pullRefreshAppBarLayout;
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(ev5, "ev");
            if (ev5.getAction() == 1) {
                if (child instanceof PullRefreshAppBarLayout) {
                    pullRefreshAppBarLayout = (PullRefreshAppBarLayout) child;
                } else {
                    pullRefreshAppBarLayout = null;
                }
                if (pullRefreshAppBarLayout != null) {
                    pullRefreshAppBarLayout.T();
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
            if (type == 1) {
                return false;
            }
            return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes, type);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull AppBarLayout abl, @NotNull View target, int type) {
            Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(abl, "abl");
            Intrinsics.checkNotNullParameter(target, "target");
            super.onStopNestedScroll(coordinatorLayout, abl, target, type);
            PullRefreshAppBarLayout pullRefreshAppBarLayout = abl instanceof PullRefreshAppBarLayout ? (PullRefreshAppBarLayout) abl : null;
            if (pullRefreshAppBarLayout != null) {
                pullRefreshAppBarLayout.T();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/PullRefreshAppBarLayout$b;", "", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        void a();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277943a;

        static {
            int[] iArr = new int[PullRefreshState.values().length];
            try {
                iArr[PullRefreshState.REFRESHING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PullRefreshState.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PullRefreshState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PullRefreshState.FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PullRefreshState.PULLING_CAN_REFRESH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PullRefreshState.PULLING_NO_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f277943a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshAppBarLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Behavior N() {
        return (Behavior) this.behavior.getValue();
    }

    private final void O(PullRefreshState newState) {
        if (newState == null || this.refreshStateLiveData.getValue() == newState) {
            return;
        }
        this.refreshStateLiveData.setValue(newState);
        int i3 = c.f277943a[newState.ordinal()];
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                QLog.d("PullRefreshAppBarLayout", 1, "changeStateIfNeed: state " + newState);
                return;
            }
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.i
                @Override // java.lang.Runnable
                public final void run() {
                    PullRefreshAppBarLayout.P(PullRefreshAppBarLayout.this);
                }
            }, OffsetAnimatorBehavior.d(N(), -p(), p(), null, 4, null));
            return;
        }
        Behavior N = N();
        PullRefreshIndicator pullRefreshIndicator = this.refreshIndicator;
        if (pullRefreshIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshIndicator");
            pullRefreshIndicator = null;
        }
        OffsetAnimatorBehavior.d(N, pullRefreshIndicator.A0() - p(), p(), null, 4, null);
        b bVar = this.pullRefreshListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(PullRefreshAppBarLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O(PullRefreshState.READY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(PullRefreshAppBarLayout this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("PullRefreshAppBarLayout", 2, "addOnOffsetChangedListener: " + i3);
        int p16 = appBarLayout.p();
        if (this$0.lastOffset == i3 && this$0.lastTotalRange == p16) {
            return;
        }
        this$0.lastOffset = i3;
        this$0.lastTotalRange = p16;
        this$0.U(i3, appBarLayout.p());
    }

    private final void U(int offset, int totalRange) {
        PullRefreshState value = this.refreshStateLiveData.getValue();
        if (value == null) {
            return;
        }
        PullRefreshState pullRefreshState = PullRefreshState.PULLING_NO_REFRESH;
        if (value == pullRefreshState || value == PullRefreshState.PULLING_CAN_REFRESH || value == PullRefreshState.READY) {
            if (Math.abs(offset) < totalRange * 0.6666667f && !this.isDisabledRefresh) {
                pullRefreshState = PullRefreshState.PULLING_CAN_REFRESH;
            }
            O(pullRefreshState);
        }
    }

    public final void M() {
        this.isDisabledRefresh = true;
        PullRefreshIndicator pullRefreshIndicator = this.refreshIndicator;
        if (pullRefreshIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshIndicator");
            pullRefreshIndicator = null;
        }
        pullRefreshIndicator.setVisibility(8);
    }

    public final boolean Q() {
        if (this.refreshStateLiveData.getValue() == PullRefreshState.READY) {
            return true;
        }
        return false;
    }

    public final void R(boolean success) {
        PullRefreshState pullRefreshState;
        PullRefreshState value = this.refreshStateLiveData.getValue();
        if (value != null && value == PullRefreshState.REFRESHING) {
            if (success) {
                pullRefreshState = PullRefreshState.SUCCESS;
            } else {
                pullRefreshState = PullRefreshState.FAIL;
            }
            O(pullRefreshState);
        }
    }

    public final void T() {
        int i3;
        PullRefreshState pullRefreshState;
        PullRefreshState value = this.refreshStateLiveData.getValue();
        if (value == null) {
            i3 = -1;
        } else {
            i3 = c.f277943a[value.ordinal()];
        }
        if (i3 != 5) {
            if (i3 != 6) {
                pullRefreshState = null;
            } else {
                pullRefreshState = PullRefreshState.CANCEL;
            }
        } else {
            pullRefreshState = PullRefreshState.REFRESHING;
        }
        O(pullRefreshState);
    }

    @Override // com.tencent.mobileqq.widget.OffsetAnimatorBehavior.b
    public void a(int newOffset) {
        requestLayout();
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NotNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MutableLiveData<PullRefreshState> mutableLiveData = this.refreshStateLiveData;
        PullRefreshIndicator pullRefreshIndicator = this.refreshIndicator;
        if (pullRefreshIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshIndicator");
            pullRefreshIndicator = null;
        }
        mutableLiveData.observeForever(pullRefreshIndicator.B0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MutableLiveData<PullRefreshState> mutableLiveData = this.refreshStateLiveData;
        PullRefreshIndicator pullRefreshIndicator = this.refreshIndicator;
        if (pullRefreshIndicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshIndicator");
            pullRefreshIndicator = null;
        }
        mutableLiveData.removeObserver(pullRefreshIndicator.B0());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.xam);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.home_pull_refresh_layout)");
        this.refreshIndicator = (PullRefreshIndicator) findViewById;
        setOutlineProvider(null);
        if (Build.VERSION.SDK_INT >= 28) {
            setOutlineAmbientShadowColor(0);
            setOutlineSpotShadowColor(0);
        }
        e(new AppBarLayout.g() { // from class: com.tencent.mobileqq.qwallet.home.h
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                PullRefreshAppBarLayout.S(PullRefreshAppBarLayout.this, appBarLayout, i3);
            }
        });
    }

    public final void setPullRefreshListener(@Nullable b bVar) {
        this.pullRefreshListener = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PullRefreshAppBarLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PullRefreshAppBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Behavior>() { // from class: com.tencent.mobileqq.qwallet.home.PullRefreshAppBarLayout$behavior$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PullRefreshAppBarLayout.Behavior invoke() {
                return new PullRefreshAppBarLayout.Behavior(PullRefreshAppBarLayout.this);
            }
        });
        this.behavior = lazy;
        this.lastOffset = -1;
        this.lastTotalRange = -1;
        this.refreshStateLiveData = new MutableLiveData<>(PullRefreshState.READY);
    }
}
