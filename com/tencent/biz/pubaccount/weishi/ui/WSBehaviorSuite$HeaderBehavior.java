package com.tencent.biz.pubaccount.weishi.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002JKB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0016J \u0010\"\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J \u0010#\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J8\u0010'\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J@\u0010,\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020\tH\u0016JP\u00101\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00109R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010;R\u0016\u0010=\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010<R\u0016\u0010>\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010<R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010@R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010BR\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010BR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010BR\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010BR\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010B\u00a8\u0006L"}, d2 = {"com/tencent/biz/pubaccount/weishi/ui/WSBehaviorSuite$HeaderBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/widget/LinearLayout;", "Landroid/view/ViewGroup;", "child", "", "j", "k", ReportConstant.COSTREPORT_PREFIX, "", "velocityY", h.F, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "directTargetChild", "", "g", "b", "offsetDelta", "u", "i", "offset", "l", "height", "w", "Lcom/tencent/biz/pubaccount/weishi/ui/b;", "listener", "v", "t", "layoutDirection", DomainData.DOMAIN_NAME, "Landroid/view/MotionEvent;", "ev", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", "target", "nestedScrollAxes", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dx", "dy", "", "consumed", "o", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "p", "Landroidx/core/view/NestedScrollingChildHelper;", "Landroidx/core/view/NestedScrollingChildHelper;", "nestedScrollingChildHelper", "Landroid/view/VelocityTracker;", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/widget/OverScroller;", "Landroid/widget/OverScroller;", "scroller", "Lcom/tencent/biz/pubaccount/weishi/ui/b;", "Z", "hasInit", "isBeDragging", "", UserInfo.SEX_FEMALE, "lastMotionY", "I", "touchSlop", "minimumVelocity", "maximumVelocity", "toolbarHeight", "totalOffset", "<init>", "()V", "a", "FlingRunnable", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSBehaviorSuite$HeaderBehavior extends CoordinatorLayout.Behavior<LinearLayout> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private NestedScrollingChildHelper nestedScrollingChildHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VelocityTracker velocityTracker;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private OverScroller scroller;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private b listener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isBeDragging;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float lastMotionY;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int minimumVelocity;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int maximumVelocity;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int toolbarHeight;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int totalOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/WSBehaviorSuite$HeaderBehavior$FlingRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/biz/pubaccount/weishi/ui/WSBehaviorSuite$HeaderBehavior;", "d", "Lcom/tencent/biz/pubaccount/weishi/ui/WSBehaviorSuite$HeaderBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "child", "Landroid/widget/OverScroller;", "f", "Landroid/widget/OverScroller;", "scroller", "", h.F, "I", "lastScrollY", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/ui/WSBehaviorSuite$HeaderBehavior;Landroid/widget/LinearLayout;Landroid/widget/OverScroller;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WSBehaviorSuite$HeaderBehavior behavior;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final LinearLayout child;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final OverScroller scroller;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int lastScrollY;

        public FlingRunnable(WSBehaviorSuite$HeaderBehavior behavior, LinearLayout child, OverScroller scroller) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(scroller, "scroller");
            this.behavior = behavior;
            this.child = child;
            this.scroller = scroller;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.scroller.computeScrollOffset()) {
                int i3 = this.behavior.i(this.child);
                if (this.lastScrollY == 0) {
                    this.lastScrollY = this.scroller.getCurrY();
                } else {
                    int currY = this.scroller.getCurrY() - this.lastScrollY;
                    this.lastScrollY = this.scroller.getCurrY();
                    if (this.child.getTop() != (-i3)) {
                        this.behavior.u(this.child, currY);
                    } else {
                        int[] iArr = new int[2];
                        NestedScrollingChildHelper nestedScrollingChildHelper = this.behavior.nestedScrollingChildHelper;
                        if (nestedScrollingChildHelper != null) {
                            nestedScrollingChildHelper.dispatchNestedScroll(0, 0, 0, currY, null, 0, iArr);
                        }
                        if (iArr[1] == 0) {
                            this.behavior.b();
                        }
                    }
                }
                ViewCompat.postOnAnimation(this.child, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        OverScroller overScroller = this.scroller;
        if (overScroller != null) {
            overScroller.abortAnimation();
        }
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollingChildHelper;
        if (nestedScrollingChildHelper != null) {
            nestedScrollingChildHelper.stopNestedScroll(0);
        }
    }

    private final boolean g(CoordinatorLayout parent, LinearLayout child, View directTargetChild) {
        return parent.getHeight() - directTargetChild.getHeight() <= child.getHeight();
    }

    private final void h(LinearLayout child, int velocityY) {
        OverScroller overScroller = this.scroller;
        if (overScroller == null) {
            return;
        }
        overScroller.fling(0, 0, 0, velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postOnAnimation(child, new FlingRunnable(this, child, overScroller));
    }

    private final void j(ViewGroup child) {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        Context context = child.getContext();
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(child);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollingChildHelper = nestedScrollingChildHelper;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.scroller = new OverScroller(context);
    }

    private final void k() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        } else {
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.clear();
        }
    }

    private final void l(LinearLayout child, int offset) {
        ViewCompat.offsetTopAndBottom(child, offset);
        this.totalOffset += offset;
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a(Math.abs(child.getTop()) / i(child), -child.getTop());
        }
    }

    private final void s() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(LinearLayout child, int offsetDelta) {
        int i3 = i(child);
        if (offsetDelta < 0) {
            if ((-child.getTop()) - offsetDelta > i3) {
                offsetDelta = (-child.getTop()) - i3;
            }
        } else if (child.getTop() + offsetDelta > 0) {
            offsetDelta = -child.getTop();
        } else if ((-child.getTop()) == i3) {
            offsetDelta = 0;
        }
        l(child, offsetDelta);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, LinearLayout child, MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action == 2 && this.isBeDragging && Math.abs(ev5.getY() - this.lastMotionY) > this.touchSlop) {
                this.lastMotionY = ev5.getY();
                return true;
            }
        } else {
            float x16 = ev5.getX();
            float y16 = ev5.getY();
            boolean isPointInChildBounds = parent.isPointInChildBounds(child, (int) x16, (int) y16);
            this.isBeDragging = isPointInChildBounds;
            if (isPointInChildBounds) {
                this.lastMotionY = y16;
                j(child);
                b();
                k();
                NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollingChildHelper;
                if (nestedScrollingChildHelper != null) {
                    nestedScrollingChildHelper.startNestedScroll(2);
                }
            }
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev5);
        }
        return super.onInterceptTouchEvent(parent, child, ev5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean onLayoutChild(CoordinatorLayout parent, LinearLayout child, int layoutDirection) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        int paddingLeft = parent.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + this.totalOffset;
        child.layout(paddingLeft, i3, child.getMeasuredWidth() + paddingLeft, child.getMeasuredHeight() + i3);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void onNestedPreScroll(CoordinatorLayout parent, LinearLayout child, View target, int dx5, int dy5, int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dy5 > 0) {
            int top = child.getTop();
            int i3 = i(child);
            if ((-top) + dy5 >= i3) {
                int i16 = i3 + top;
                l(child, -i16);
                consumed[1] = i16;
            } else {
                l(child, -dy5);
                consumed[1] = dy5;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onNestedScroll(CoordinatorLayout parent, LinearLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dyUnconsumed < 0) {
            if (child.getTop() - dyUnconsumed > 0) {
                dyUnconsumed = child.getTop();
            }
            l(child, -dyUnconsumed);
            consumed[1] = dyUnconsumed;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(CoordinatorLayout parent, LinearLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        b();
        return (Intrinsics.areEqual(target, child) || (nestedScrollAxes & 2) == 0 || !g(parent, child, directTargetChild)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(CoordinatorLayout parent, LinearLayout child, MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action == 0) {
            return true;
        }
        if (action == 1) {
            this.isBeDragging = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
            }
            VelocityTracker velocityTracker2 = this.velocityTracker;
            int yVelocity = velocityTracker2 != null ? (int) velocityTracker2.getYVelocity() : 0;
            s();
            if (Math.abs(yVelocity) >= this.minimumVelocity) {
                h(child, yVelocity);
                return true;
            }
        } else {
            if (action == 2) {
                int y16 = (int) (ev5.getY() - this.lastMotionY);
                this.lastMotionY = ev5.getY();
                VelocityTracker velocityTracker3 = this.velocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(ev5);
                }
                u(child, y16);
                return true;
            }
            if (action == 3) {
                this.isBeDragging = false;
                s();
            }
        }
        return super.onTouchEvent(parent, child, ev5);
    }

    public final void t(LinearLayout child) {
        Intrinsics.checkNotNullParameter(child, "child");
        int i3 = this.totalOffset;
        if (i3 == 0) {
            return;
        }
        l(child, -i3);
    }

    public final void v(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void w(int height) {
        this.toolbarHeight = height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(LinearLayout child) {
        int height = child.getChildAt(0).getHeight() - this.toolbarHeight;
        if (height >= 0) {
            return height;
        }
        return 0;
    }
}
