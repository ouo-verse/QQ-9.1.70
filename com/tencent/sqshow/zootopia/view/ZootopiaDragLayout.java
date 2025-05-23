package com.tencent.sqshow.zootopia.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.utils.aa;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0005ABC#DB'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u001f\u00a2\u0006\u0004\b>\u0010?J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\f\u001a\u00020\tH\u0014J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u001a\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0002R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006E"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/View;", "captureView", "panelView", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$c;", DownloadInfo.spKey_Config, "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$a;", "callback", "", "t", HippyTKDListViewAdapter.X, "onFinishInflate", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "p", "v", "", "xvel", "yvel", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "w", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "notify", "r", "", "height", "y", "Landroidx/customview/widget/ViewDragHelper;", "d", "Landroidx/customview/widget/ViewDragHelper;", "dragHelper", "e", "Landroid/view/View;", "view", "f", h.F, "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$a;", "i", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "currentBgColor", BdhLogUtil.LogTag.Tag_Conn, "Z", "isMoving", "D", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "E", "Landroid/view/MotionEvent;", "motionEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "b", "c", "State", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaDragLayout extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isMoving;

    /* renamed from: D, reason: from kotlin metadata */
    private State state;

    /* renamed from: E, reason: from kotlin metadata */
    private MotionEvent motionEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewDragHelper dragHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View captureView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private c config;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentBgColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "", "(Ljava/lang/String;I)V", "TALL", "SHORT", "DISAPPEAR", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum State {
        TALL,
        SHORT,
        DISAPPEAR
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$a;", "", "Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$State;", "state", "", "Qd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void Qd(State state);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f373322a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.TALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.DISAPPEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f373322a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/view/ZootopiaDragLayout$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f373326e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ State f373327f;

        g(boolean z16, State state) {
            this.f373326e = z16;
            this.f373327f = state;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            a aVar;
            ZootopiaDragLayout.this.isMoving = false;
            if (!this.f373326e || (aVar = ZootopiaDragLayout.this.callback) == null) {
                return;
            }
            aVar.Qd(this.f373327f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            a aVar;
            ZootopiaDragLayout.this.isMoving = false;
            if (!this.f373326e || (aVar = ZootopiaDragLayout.this.callback) == null) {
                return;
            }
            aVar.Qd(this.f373327f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDragLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(State state) {
        int i3 = this.currentBgColor;
        int color = e.f373322a[state.ordinal()] != 1 ? 0 : getResources().getColor(R.color.f8236e);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "backgroundColor", i3, color);
        ofInt.setDuration(400L);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addListener(new f(color));
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(State state, boolean notify) {
        int maxPanelHeight;
        float abs;
        View view = this.view;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view = null;
        }
        int measuredHeight = view.getMeasuredHeight();
        int[] iArr = e.f373322a;
        int i3 = iArr[state.ordinal()];
        if (i3 != 1) {
            maxPanelHeight = i3 != 2 ? 0 : this.config.getInitPanelHeight();
        } else {
            maxPanelHeight = this.config.getMaxPanelHeight();
        }
        if (iArr[state.ordinal()] == 3) {
            View view3 = this.view;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            } else {
                view2 = view3;
            }
            abs = view2.getMeasuredHeight() / this.config.getInitPanelHeight();
        } else {
            int abs2 = Math.abs(this.config.getMaxPanelHeight() - this.config.getInitPanelHeight());
            abs = Math.abs(maxPanelHeight - measuredHeight) / Math.max(r2, abs2);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, maxPanelHeight);
        ofInt.setDuration(((float) 400) * abs);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZootopiaDragLayout.s(ZootopiaDragLayout.this, valueAnimator);
            }
        });
        ofInt.addListener(new g(notify, state));
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZootopiaDragLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.y(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v(MotionEvent event) {
        View view = this.captureView;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + view.getMeasuredHeight();
        int i3 = iArr[1];
        int rawY = (int) event.getRawY();
        return i3 + 1 <= rawY && rawY < measuredHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final int height) {
        View view = this.view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view = null;
        }
        aa.h(view, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.sqshow.zootopia.view.ZootopiaDragLayout$updatePanelHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RelativeLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.height = height;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        this.motionEvent = ev5;
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new d());
        Intrinsics.checkNotNullExpressionValue(create, "create(this, 1.0f, DragHelperCallback())");
        this.dragHelper = create;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int actionMasked = ev5.getActionMasked();
        ViewDragHelper viewDragHelper = null;
        if ((actionMasked == 3 || actionMasked == 1) && !v(ev5)) {
            ViewDragHelper viewDragHelper2 = this.dragHelper;
            if (viewDragHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
            } else {
                viewDragHelper = viewDragHelper2;
            }
            viewDragHelper.cancel();
            return false;
        }
        ViewDragHelper viewDragHelper3 = this.dragHelper;
        if (viewDragHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
        } else {
            viewDragHelper = viewDragHelper3;
        }
        return viewDragHelper.shouldInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!v(event) && !this.isMoving) {
            return super.onTouchEvent(event);
        }
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragHelper");
            viewDragHelper = null;
        }
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    public final void p() {
        int color = getResources().getColor(R.color.f8236e);
        this.currentBgColor = color;
        setBackgroundColor(color);
    }

    public final void t(View captureView, View panelView, c config, a callback) {
        Intrinsics.checkNotNullParameter(captureView, "captureView");
        Intrinsics.checkNotNullParameter(panelView, "panelView");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.captureView = captureView;
        this.view = panelView;
        this.callback = callback;
        this.config = config;
        y(config.getInitPanelHeight());
        captureView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDragLayout.u(view);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void x() {
        setBackgroundColor(0);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J0\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$d;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroid/view/View;", "child", "", "pointerId", "", "tryCaptureView", "top", "dy", "clampViewPositionVertical", "getViewVerticalDragRange", "state", "", "onViewDragStateChanged", "releasedChild", "", "xvel", "yvel", "onViewReleased", "changedView", "left", "dx", "onViewPositionChanged", "<init>", "(Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class d extends ViewDragHelper.Callback {
        public d() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View child, int top, int dy5) {
            Intrinsics.checkNotNullParameter(child, "child");
            return top;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            if (ZootopiaDragLayout.this.config.getIsHeightFixed()) {
                return ZootopiaDragLayout.this.config.getInitPanelHeight();
            }
            return ZootopiaDragLayout.this.config.getMaxPanelHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int left, int top, int dx5, int dy5) {
            int maxPanelHeight;
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            if (ZootopiaDragLayout.this.config.getIsHeightFixed()) {
                maxPanelHeight = ZootopiaDragLayout.this.config.getInitPanelHeight();
            } else {
                maxPanelHeight = ZootopiaDragLayout.this.config.getMaxPanelHeight();
            }
            View view = ZootopiaDragLayout.this.view;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
                view = null;
            }
            ZootopiaDragLayout.this.y(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(view.getMeasuredHeight() - dy5, maxPanelHeight), 0));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            boolean z16;
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            State w3 = ZootopiaDragLayout.this.w(xvel, yvel);
            if (ZootopiaDragLayout.this.state != w3) {
                ZootopiaDragLayout.this.state = w3;
                if (ZootopiaDragLayout.this.state != State.DISAPPEAR) {
                    a aVar = ZootopiaDragLayout.this.callback;
                    if (aVar != null) {
                        aVar.Qd(w3);
                    }
                    ZootopiaDragLayout zootopiaDragLayout = ZootopiaDragLayout.this;
                    zootopiaDragLayout.q(zootopiaDragLayout.state);
                } else {
                    ZootopiaDragLayout.this.x();
                    z16 = true;
                    ZootopiaDragLayout zootopiaDragLayout2 = ZootopiaDragLayout.this;
                    zootopiaDragLayout2.r(zootopiaDragLayout2.state, z16);
                }
            }
            z16 = false;
            ZootopiaDragLayout zootopiaDragLayout22 = ZootopiaDragLayout.this;
            zootopiaDragLayout22.r(zootopiaDragLayout22.state, z16);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            MotionEvent motionEvent = ZootopiaDragLayout.this.motionEvent;
            if (motionEvent != null) {
                return ZootopiaDragLayout.this.v(motionEvent);
            }
            return false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int state) {
            if (state == 1) {
                ZootopiaDragLayout.this.isMoving = true;
            }
        }
    }

    public /* synthetic */ ZootopiaDragLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDragLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.config = new c(0, 0, 0, false, 15, null);
        this.state = State.SHORT;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaDragLayout$c;", "", "", "a", "I", "()I", "initPanelHeight", "b", "maxPanelHeight", "c", "triggerDistance", "", "d", "Z", "()Z", "isHeightFixed", "<init>", "(IIIZ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int initPanelHeight;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int maxPanelHeight;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int triggerDistance;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isHeightFixed;

        public c(int i3, int i16, int i17, boolean z16) {
            this.initPanelHeight = i3;
            this.maxPanelHeight = i16;
            this.triggerDistance = i17;
            this.isHeightFixed = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getInitPanelHeight() {
            return this.initPanelHeight;
        }

        /* renamed from: b, reason: from getter */
        public final int getMaxPanelHeight() {
            return this.maxPanelHeight;
        }

        /* renamed from: c, reason: from getter */
        public final int getTriggerDistance() {
            return this.triggerDistance;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsHeightFixed() {
            return this.isHeightFixed;
        }

        public /* synthetic */ c(int i3, int i16, int i17, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? 800 : i3, (i18 & 2) != 0 ? 1400 : i16, (i18 & 4) != 0 ? 200 : i17, (i18 & 8) != 0 ? false : z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State w(float xvel, float yvel) {
        double d16 = yvel;
        if (d16 > 800.0d && xvel < yvel && this.state == State.TALL && !this.config.getIsHeightFixed()) {
            return State.SHORT;
        }
        if (d16 < -800.0d && xvel > yvel && this.state == State.SHORT && !this.config.getIsHeightFixed()) {
            return State.TALL;
        }
        int i3 = e.f373322a[this.state.ordinal()];
        View view = null;
        if (i3 == 1) {
            int maxPanelHeight = this.config.getMaxPanelHeight();
            View view2 = this.view;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            } else {
                view = view2;
            }
            if (maxPanelHeight - view.getMeasuredHeight() < this.config.getTriggerDistance()) {
                return State.TALL;
            }
            return State.SHORT;
        }
        if (i3 != 2) {
            return State.DISAPPEAR;
        }
        View view3 = this.view;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
            view3 = null;
        }
        if (view3.getMeasuredHeight() - this.config.getInitPanelHeight() > this.config.getTriggerDistance()) {
            return State.TALL;
        }
        int initPanelHeight = this.config.getInitPanelHeight();
        View view4 = this.view;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        } else {
            view = view4;
        }
        if (initPanelHeight - view.getMeasuredHeight() > this.config.getTriggerDistance()) {
            return State.DISAPPEAR;
        }
        return State.SHORT;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/view/ZootopiaDragLayout$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f373324e;

        f(int i3) {
            this.f373324e = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ZootopiaDragLayout.this.currentBgColor = this.f373324e;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(View view) {
    }
}
