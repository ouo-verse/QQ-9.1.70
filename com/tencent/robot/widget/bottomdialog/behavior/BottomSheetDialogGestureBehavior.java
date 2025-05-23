package com.tencent.robot.widget.bottomdialog.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.robot.widget.bottomdialog.behavior.TouchDragHelper;
import com.tencent.robot.widget.bottomdialog.behavior.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001[B\u000f\u0012\u0006\u00107\u001a\u000203\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J!\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002J!\u0010\u0015\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J8\u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0016J8\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0016J0\u0010$\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J@\u0010)\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0003H\u0016J(\u0010*\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0003H\u0016J \u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J \u0010/\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016R\u001a\u00107\u001a\u0002038\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b2\u00104\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010>\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=R\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010AR\"\u0010F\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010A\u001a\u0004\b?\u0010C\"\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010AR\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010AR\u0016\u0010J\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010IR\u0016\u0010K\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00109R\"\u0010O\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00109\u001a\u0004\bL\u0010=\"\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010QR$\u0010U\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010=\"\u0004\bT\u0010NR$\u0010X\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bV\u0010=\"\u0004\bW\u0010N\u00a8\u0006\\"}, d2 = {"Lcom/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/ViewGroup;", "", "availableDeltaScrollY", "", "e", "currScrollY", "maxScrollY", "deltaYToBeApplied", "f", "", "velocityY", "flingDistance", "", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/Float;F)Z", "o", "(Ljava/lang/Float;)Z", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Float;F)V", "Landroid/view/View;", "child", "deltaScrollY", "d", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "directTargetChild", "target", "axes", "type", "v", "u", "velocityX", ReportConstant.COSTREPORT_PREFIX, "dx", "dy", "", "consumed", "t", "w", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/MotionEvent;", "ev", "r", HippyTKDListViewAdapter.X, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "k", "()Lcom/tencent/robot/widget/bottomdialog/behavior/c;", "mUIOperator", h.F, "I", "mTopPadding", "i", "Lkotlin/Lazy;", "()I", "mFlingVelocityThreshold", "j", "mDisplayMode", "Z", "mNestScrolledAccepted", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Z)V", "mInterceptTouchEventAccepted", "mHasConsumedNestedScroll", "mHasDetectedFling", UserInfo.SEX_FEMALE, "mNestFlingVelocityY", "mNestedScrollDisplacement", "getNestScrollTargetViewId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "nestScrollTargetViewId", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper;", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper;", "mTouchDragHelper", "value", "y", "displayMode", "getTopPadding", "B", "topPadding", "<init>", "(Lcom/tencent/robot/widget/bottomdialog/behavior/c;)V", "a", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class BottomSheetDialogGestureBehavior extends CoordinatorLayout.Behavior<ViewGroup> {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mUIOperator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTopPadding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFlingVelocityThreshold;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int mDisplayMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mNestScrolledAccepted;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mInterceptTouchEventAccepted;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasConsumedNestedScroll;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean mHasDetectedFling;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float mNestFlingVelocityY;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int mNestedScrollDisplacement;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int nestScrollTargetViewId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TouchDragHelper mTouchDragHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/widget/bottomdialog/behavior/BottomSheetDialogGestureBehavior$b", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper$a;", "Lcom/tencent/robot/widget/bottomdialog/behavior/TouchDragHelper;", "helper", "", "c", "", "deltaX", "deltaY", "b", "a", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements TouchDragHelper.a {
        b() {
        }

        @Override // com.tencent.robot.widget.bottomdialog.behavior.TouchDragHelper.a
        public boolean a(@NotNull TouchDragHelper helper) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            BottomSheetDialogGestureBehavior.this.z(false);
            helper.d().computeCurrentVelocity(1000);
            BottomSheetDialogGestureBehavior.this.q(Float.valueOf(helper.d().getYVelocity()), Math.abs(helper.getCurrPoint().y - helper.getDownPoint().y));
            return true;
        }

        @Override // com.tencent.robot.widget.bottomdialog.behavior.TouchDragHelper.a
        public boolean b(@NotNull TouchDragHelper helper, float deltaX, float deltaY) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            c mUIOperator = BottomSheetDialogGestureBehavior.this.getMUIOperator();
            BottomSheetDialogGestureBehavior bottomSheetDialogGestureBehavior = BottomSheetDialogGestureBehavior.this;
            mUIOperator.scrollBy(bottomSheetDialogGestureBehavior.f(bottomSheetDialogGestureBehavior.getMUIOperator().getScrollY(), BottomSheetDialogGestureBehavior.this.l(), -((int) deltaY)), 0);
            return true;
        }

        @Override // com.tencent.robot.widget.bottomdialog.behavior.TouchDragHelper.a
        public boolean c(@NotNull TouchDragHelper helper) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            return BottomSheetDialogGestureBehavior.this.getMInterceptTouchEventAccepted();
        }
    }

    public BottomSheetDialogGestureBehavior(@NotNull c mUIOperator) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mUIOperator, "mUIOperator");
        this.mUIOperator = mUIOperator;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Integer>() { // from class: com.tencent.robot.widget.bottomdialog.behavior.BottomSheetDialogGestureBehavior$mFlingVelocityThreshold$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(BottomSheetDialogGestureBehavior.this.getMUIOperator().getView().getContext()).getScaledMinimumFlingVelocity() * 3);
            }
        });
        this.mFlingVelocityThreshold = lazy;
        this.nestScrollTargetViewId = -1;
        this.mTouchDragHelper = new TouchDragHelper(new b());
    }

    private final boolean C(Float velocityY, float flingDistance) {
        if (!p() && (!o(velocityY) || !n(flingDistance))) {
            return true;
        }
        return false;
    }

    private final boolean d(View child, int deltaScrollY) {
        if (this.mUIOperator.getScrollY() < 0 || !child.canScrollVertically(deltaScrollY)) {
            return true;
        }
        return false;
    }

    private final void e(int availableDeltaScrollY) {
        this.mHasConsumedNestedScroll = true;
        this.mUIOperator.d();
        this.mUIOperator.scrollBy(availableDeltaScrollY, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(int currScrollY, int maxScrollY, int deltaYToBeApplied) {
        if (currScrollY + deltaYToBeApplied > maxScrollY) {
            return maxScrollY - currScrollY;
        }
        return deltaYToBeApplied;
    }

    private final int i() {
        return ((Number) this.mFlingVelocityThreshold.getValue()).intValue();
    }

    private final boolean n(float flingDistance) {
        if (Math.abs(flingDistance) > this.mUIOperator.getViewport().height() / 6) {
            return true;
        }
        return false;
    }

    private final boolean o(Float velocityY) {
        if (velocityY != null && velocityY.floatValue() > 0.0f && velocityY.floatValue() > i()) {
            return true;
        }
        return false;
    }

    private final boolean p() {
        if (this.mUIOperator.getScrollY() < m()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Float velocityY, float flingDistance) {
        if (C(velocityY, flingDistance)) {
            c.a.c(this.mUIOperator, 0, 0, 2, null);
        } else {
            c.a.c(this.mUIOperator, g(), 0, 2, null);
        }
    }

    public final void A(int i3) {
        this.nestScrollTargetViewId = i3;
    }

    public final void B(int i3) {
        this.mTopPadding = i3;
    }

    public int g() {
        return -this.mUIOperator.getViewport().height();
    }

    /* renamed from: h, reason: from getter */
    public final int getMDisplayMode() {
        return this.mDisplayMode;
    }

    /* renamed from: j, reason: from getter */
    protected final boolean getMInterceptTouchEventAccepted() {
        return this.mInterceptTouchEventAccepted;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: k, reason: from getter */
    public final c getMUIOperator() {
        return this.mUIOperator;
    }

    public int l() {
        if (this.mDisplayMode == 1) {
            int mTranslationY = this.mUIOperator.getMTranslationY();
            int i3 = this.mTopPadding;
            return Math.min(mTranslationY - i3, i3 / 3);
        }
        return this.mTopPadding / 3;
    }

    public int m() {
        c cVar = this.mUIOperator;
        return (-(cVar.getViewport().height() - cVar.getMTranslationY())) / 3;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean onInterceptTouchEvent(@NotNull CoordinatorLayout parent, @NotNull ViewGroup child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z16 = false;
        View childAt = child.getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (ev5.getAction() == 0 && y64.a.e(childAt, ev5)) {
            z16 = true;
        }
        this.mInterceptTouchEventAccepted = z16;
        return z16;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean onNestedPreFling(@NotNull CoordinatorLayout coordinatorLayout, @NotNull ViewGroup child, @NotNull View target, float velocityX, float velocityY) {
        boolean z16;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mNestFlingVelocityY = velocityY;
        if (target.getId() == this.nestScrollTargetViewId && target.getId() != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mHasDetectedFling = z16;
        if (!z16 || this.mDisplayMode != 1) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onNestedPreScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull ViewGroup child, @NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (this.mNestScrolledAccepted && type == 0) {
            int f16 = f(this.mUIOperator.getScrollY(), l(), dy5);
            if (this.mDisplayMode == 1) {
                consumed[1] = dy5;
                e(f16);
            } else if (target.getId() == this.nestScrollTargetViewId && d(target, dy5)) {
                consumed[1] = dy5;
                e(f16);
            }
            this.mNestedScrollDisplacement += dy5;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onNestedScrollAccepted(@NotNull CoordinatorLayout coordinatorLayout, @NotNull ViewGroup child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        boolean z16;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        if (type == 0 && target.getId() == this.nestScrollTargetViewId && axes == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mNestScrolledAccepted = z16;
        if (z16) {
            this.mHasDetectedFling = false;
            this.mHasConsumedNestedScroll = false;
            this.mNestedScrollDisplacement = 0;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull ViewGroup child, @NotNull View directTargetChild, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(directTargetChild, "directTargetChild");
        Intrinsics.checkNotNullParameter(target, "target");
        if (type == 0 && target.getId() == this.nestScrollTargetViewId && axes == 2 && target.getId() != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onStopNestedScroll(@NotNull CoordinatorLayout coordinatorLayout, @NotNull ViewGroup child, @NotNull View target, int type) {
        Float f16;
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (target.getId() == this.nestScrollTargetViewId && this.mNestScrolledAccepted && this.mHasConsumedNestedScroll) {
            this.mNestScrolledAccepted = false;
            this.mHasConsumedNestedScroll = false;
            if (this.mHasDetectedFling) {
                f16 = Float.valueOf(-this.mNestFlingVelocityY);
            } else {
                f16 = null;
            }
            q(f16, this.mNestedScrollDisplacement);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public boolean onTouchEvent(@NotNull CoordinatorLayout parent, @NotNull ViewGroup child, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        return this.mTouchDragHelper.i(ev5);
    }

    public final void y(int i3) {
        this.mDisplayMode = i3;
    }

    protected final void z(boolean z16) {
        this.mInterceptTouchEventAccepted = z16;
    }
}
