package com.tencent.mobileqq.guild.home.views.embeddable;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003fghB'\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010b\u001a\u00020\b\u00a2\u0006\u0004\bc\u0010dJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J-\u0010\u0012\u001a\u00020\u0011\"\f\b\u0000\u0010\u000e*\u00020\f*\u00020\r2\u0006\u0010\u000f\u001a\u00028\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016JB\u0010 \u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J:\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\bH\u0016J4\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\bH\u0016J \u0010%\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020$2\u0006\u0010\n\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020$2\u0006\u0010\n\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0006H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0016R\u0018\u00100\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00106R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00106R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00106R\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00106R\u0014\u0010F\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u00106R\u0014\u0010H\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00106R\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001f\u0010V\u001a\u00060RR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010N\u001a\u0004\bT\u0010UR\"\u0010]\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingChild2;", "Landroidx/core/view/NestedScrollingChild3;", "Landroid/view/MotionEvent;", "ev", "", "l", "", "velocityX", "velocityY", "i", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "Landroid/view/View;", "T", "view", "needAddView", "", "setupView", "(Landroid/view/View;Z)V", "axes", "type", "startNestedScroll", "stopNestedScroll", "hasNestedScrollingParent", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "offsetInWindow", "consumed", "dispatchNestedScroll", "dx", "dy", "dispatchNestedPreScroll", "", "dispatchNestedFling", "dispatchNestedPreFling", NodeProps.ENABLED, "setNestedScrollingEnabled", "isNestedScrollingEnabled", "dispatchTouchEvent", "onTouchEvent", "direction", "canScrollVertically", "d", "Lcom/tencent/mobileqq/guild/home/views/embeddable/e;", "webView", "Landroidx/core/view/NestedScrollingChildHelper;", "e", "Landroidx/core/view/NestedScrollingChildHelper;", "mChildHelper", "f", "I", "mDownX", h.F, "mDownY", "mLastX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mLastY", BdhLogUtil.LogTag.Tag_Conn, "mNestedOffsetY", "D", "mTotalOffset", "E", "mDiffX", UserInfo.SEX_FEMALE, "mDiffY", "G", "mPagingTouchSlop", "H", "mTouchSlop", "Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$b;", "Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$b;", "mGestureState", "Landroid/view/VelocityTracker;", "J", "Lkotlin/Lazy;", "j", "()Landroid/view/VelocityTracker;", "mVelocityTracker", "Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$ViewFlinger;", "K", "k", "()Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$ViewFlinger;", "mViewFlinger", "L", "Z", "getChildHandleDispatchTouchEvent", "()Z", "setChildHandleDispatchTouchEvent", "(Z)V", "childHandleDispatchTouchEvent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "ViewFlinger", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class ScrollableLayout extends FrameLayout implements NestedScrollingChild2, NestedScrollingChild3 {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int mNestedOffsetY;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTotalOffset;

    /* renamed from: E, reason: from kotlin metadata */
    private int mDiffX;

    /* renamed from: F, reason: from kotlin metadata */
    private int mDiffY;

    /* renamed from: G, reason: from kotlin metadata */
    private final int mPagingTouchSlop;

    /* renamed from: H, reason: from kotlin metadata */
    private final int mTouchSlop;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GestureState mGestureState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mVelocityTracker;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewFlinger;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean childHandleDispatchTouchEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e webView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private NestedScrollingChildHelper mChildHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mDownX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mDownY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLastX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mLastY;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$ViewFlinger;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "stop", h.F, "f", "", "velocityX", "velocityY", "c", "d", "I", "mLastFlingX", "e", "mLastFlingY", "", "Z", "mEatRunOnAnimationRequest", "mReSchedulePostAnimationCallback", "i", "mRunningCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[I", "()[I", "setMReusableIntPair", "([I)V", "mReusableIntPair", "Landroid/widget/OverScroller;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/OverScroller;", "getMOverScroller", "()Landroid/widget/OverScroller;", "setMOverScroller", "(Landroid/widget/OverScroller;)V", "mOverScroller", "Landroid/view/animation/Interpolator;", "D", "Landroid/view/animation/Interpolator;", "getMInterpolator", "()Landroid/view/animation/Interpolator;", "mInterpolator", "<init>", "(Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class ViewFlinger implements Runnable {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private OverScroller mOverScroller;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final Interpolator mInterpolator;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mLastFlingX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mLastFlingY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean mEatRunOnAnimationRequest;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean mReSchedulePostAnimationCallback;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int mRunningCount;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private int[] mReusableIntPair = {0, 0};

        public ViewFlinger() {
            Interpolator interpolator = new Interpolator() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.d
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f16) {
                    float g16;
                    g16 = ScrollableLayout.ViewFlinger.g(f16);
                    return g16;
                }
            };
            this.mInterpolator = interpolator;
            this.mOverScroller = new OverScroller(ScrollableLayout.this.getContext(), interpolator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float g(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }

        public final void c(int velocityX, int velocityY) {
            this.mRunningCount = 0;
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.mOverScroller.fling(0, 0, velocityX, velocityY, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            h();
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final int[] getMReusableIntPair() {
            return this.mReusableIntPair;
        }

        public final void f() {
            ScrollableLayout.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(ScrollableLayout.this, this);
        }

        public final void h() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                f();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01ea  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01f9  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0226  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0259  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01fb  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            String str;
            int i3;
            int i16;
            e eVar;
            int i17;
            int i18;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26 = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("ScrollableContainerLayout", "run() / computeScrollOffset() scroller: " + overScroller.getCurrX() + ", " + overScroller.getCurrY() + " " + this.mRunningCount);
                }
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i19 = currX - this.mLastFlingX;
                int i26 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int[] iArr = this.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (this.mRunningCount == 0 && i26 == 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (QLog.isDevelopLevel()) {
                    Log.d("ScrollableContainerLayout", "run() / needDispatchNestedScroll?(" + z16 + ") " + i26 + " " + this.mRunningCount);
                }
                if (this.mRunningCount == 0 && z16) {
                    ScrollableLayout.this.startNestedScroll(3, 1);
                }
                if (z16) {
                    str = ") ";
                    i3 = i26;
                    if (ScrollableLayout.this.dispatchNestedPreScroll(i19, i26, this.mReusableIntPair, null, 1)) {
                        if (QLog.isDevelopLevel()) {
                            Log.d("ScrollableContainerLayout", "run() / dispatchNestedPreScroll(" + i19 + ", " + i3 + str + getMReusableIntPair()[1] + " return true");
                        }
                        int[] iArr2 = this.mReusableIntPair;
                        i19 -= iArr2[0];
                        i16 = i3 - iArr2[1];
                        int[] iArr3 = this.mReusableIntPair;
                        iArr3[0] = 0;
                        iArr3[1] = 0;
                        eVar = ScrollableLayout.this.webView;
                        if (eVar != null) {
                            eVar.c(i19, i16, this.mReusableIntPair);
                        }
                        int[] iArr4 = this.mReusableIntPair;
                        i17 = iArr4[0];
                        i18 = iArr4[1];
                        int i27 = i19 - i17;
                        int i28 = i16 - i18;
                        iArr4[0] = 0;
                        iArr4[1] = 0;
                        if (z16) {
                            ScrollableLayout.this.dispatchNestedScroll(i17, i18, i27, i28, null, 1, iArr4);
                            if (QLog.isDevelopLevel()) {
                                Log.d("ScrollableContainerLayout", "run() / dispatchNestedScroll(" + i17 + ", " + i18 + ", " + i27 + ", " + i28 + str + getMReusableIntPair()[1]);
                            }
                        }
                        int[] iArr5 = this.mReusableIntPair;
                        int i29 = i27 - iArr5[0];
                        int i36 = i28 - iArr5[1];
                        if ((i17 == 0 || i18 != 0) && QLog.isDevelopLevel()) {
                            Log.d("ScrollableContainerLayout", "run() / dispatchOnScrolled(" + i17 + ", " + i18 + ") ?");
                        }
                        if (!ScrollableLayout.this.awakenScrollBars()) {
                            ScrollableLayout.this.invalidate();
                        }
                        if (overScroller.getCurrX() != overScroller.getFinalX()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (overScroller.getCurrY() != overScroller.getFinalY()) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (overScroller.isFinished() && ((!z17 && i29 == 0) || (!z18 && i36 == 0))) {
                            z19 = false;
                        } else {
                            z19 = true;
                        }
                        this.mRunningCount++;
                        if (QLog.isDevelopLevel()) {
                            Log.d("ScrollableContainerLayout", "doneScrolling? " + z19 + "(finish=" + overScroller.isFinished() + ", " + z18 + "," + i36);
                        }
                        if (!z19) {
                            if (QLog.isDevelopLevel()) {
                                Log.d("ScrollableContainerLayout", "run -> postOnAnimation()");
                            }
                            h();
                        }
                        z26 = false;
                    } else if (QLog.isDevelopLevel()) {
                        Log.d("ScrollableContainerLayout", "run() / dispatchNestedPreScroll(" + i19 + ", " + i3 + str + getMReusableIntPair()[1] + " return false");
                    }
                } else {
                    if (QLog.isDevelopLevel()) {
                        Log.d("ScrollableContainerLayout", "run() / won't dispatchNestedPreScroll");
                    }
                    str = ") ";
                    i3 = i26;
                }
                i16 = i3;
                int[] iArr32 = this.mReusableIntPair;
                iArr32[0] = 0;
                iArr32[1] = 0;
                eVar = ScrollableLayout.this.webView;
                if (eVar != null) {
                }
                int[] iArr42 = this.mReusableIntPair;
                i17 = iArr42[0];
                i18 = iArr42[1];
                int i272 = i19 - i17;
                int i282 = i16 - i18;
                iArr42[0] = 0;
                iArr42[1] = 0;
                if (z16) {
                }
                int[] iArr52 = this.mReusableIntPair;
                int i292 = i272 - iArr52[0];
                int i362 = i282 - iArr52[1];
                if (i17 == 0) {
                }
                Log.d("ScrollableContainerLayout", "run() / dispatchOnScrolled(" + i17 + ", " + i18 + ") ?");
                if (!ScrollableLayout.this.awakenScrollBars()) {
                }
                if (overScroller.getCurrX() != overScroller.getFinalX()) {
                }
                if (overScroller.getCurrY() != overScroller.getFinalY()) {
                }
                if (overScroller.isFinished()) {
                }
                z19 = true;
                this.mRunningCount++;
                if (QLog.isDevelopLevel()) {
                }
                if (!z19) {
                }
                z26 = false;
            } else {
                z16 = true;
            }
            this.mEatRunOnAnimationRequest = z26;
            if (this.mReSchedulePostAnimationCallback) {
                f();
                return;
            }
            if (z16) {
                ScrollableLayout.this.stopNestedScroll(1);
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("ScrollableContainerLayout", "run() / won't dispatchNestedPreScroll stopNestedScroll(1)");
            }
        }

        public final void stop() {
            ScrollableLayout.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$a;", "", "Landroid/view/View;", "currentView", "", "enable", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(View currentView, boolean enable) {
            Logger.f235387a.d().i("ScrollableContainerLayout", 1, "enableParentRecyclerViewImplUserInput " + enable);
            for (ViewParent parent = currentView.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ViewPager2) {
                    ((ViewPager2) parent).setUserInputEnabled(enable);
                    return;
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\b\u0018\u0000 92\u00020\u0001:\u0001\u000eBW\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\b7\u00108J\u001a\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u0017\u00104\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b'\u00103R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b5\u00102\u001a\u0004\b \u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/ScrollableLayout$b;", "", "", "downX", "downY", "", "g", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "i", "(Z)V", "hasScrolled", h.F, "hasInnerScrolled", "c", UserInfo.SEX_FEMALE, "()F", "setInitDownX", "(F)V", "initDownX", "d", "setInitDownY", "initDownY", "e", "I", "getStartDirection", "()I", "setStartDirection", "(I)V", "startDirection", "f", "getScrollableBitset", "setScrollableBitset", "scrollableBitset", "getTotalParentScrolled", "setTotalParentScrolled", "totalParentScrolled", "getTotalChildScrolled", "setTotalChildScrolled", "totalChildScrolled", "", "[I", "()[I", "scrollOffset", "j", "scrollConsumed", "<init>", "(ZZFFIIFF)V", "k", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GestureState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasScrolled;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean hasInnerScrolled;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private float initDownX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private float initDownY;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int startDirection;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int scrollableBitset;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private float totalParentScrolled;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private float totalChildScrolled;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final int[] scrollOffset;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final int[] scrollConsumed;

        public GestureState() {
            this(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasInnerScrolled() {
            return this.hasInnerScrolled;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasScrolled() {
            return this.hasScrolled;
        }

        /* renamed from: c, reason: from getter */
        public final float getInitDownX() {
            return this.initDownX;
        }

        /* renamed from: d, reason: from getter */
        public final float getInitDownY() {
            return this.initDownY;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final int[] getScrollConsumed() {
            return this.scrollConsumed;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GestureState)) {
                return false;
            }
            GestureState gestureState = (GestureState) other;
            if (this.hasScrolled == gestureState.hasScrolled && this.hasInnerScrolled == gestureState.hasInnerScrolled && Float.compare(this.initDownX, gestureState.initDownX) == 0 && Float.compare(this.initDownY, gestureState.initDownY) == 0 && this.startDirection == gestureState.startDirection && this.scrollableBitset == gestureState.scrollableBitset && Float.compare(this.totalParentScrolled, gestureState.totalParentScrolled) == 0 && Float.compare(this.totalChildScrolled, gestureState.totalChildScrolled) == 0) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final int[] getScrollOffset() {
            return this.scrollOffset;
        }

        public final void g(float downX, float downY) {
            this.hasScrolled = false;
            this.hasInnerScrolled = false;
            this.initDownX = downX;
            this.initDownY = downY;
            this.startDirection = 0;
            this.totalChildScrolled = 0.0f;
            this.totalParentScrolled = 0.0f;
        }

        public final void h(boolean z16) {
            this.hasInnerScrolled = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        public int hashCode() {
            boolean z16 = this.hasScrolled;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.hasInnerScrolled;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((((((((((((i16 + i3) * 31) + Float.floatToIntBits(this.initDownX)) * 31) + Float.floatToIntBits(this.initDownY)) * 31) + this.startDirection) * 31) + this.scrollableBitset) * 31) + Float.floatToIntBits(this.totalParentScrolled)) * 31) + Float.floatToIntBits(this.totalChildScrolled);
        }

        public final void i(boolean z16) {
            this.hasScrolled = z16;
        }

        @NotNull
        public String toString() {
            boolean z16 = this.hasScrolled;
            float f16 = this.initDownX;
            float f17 = this.initDownY;
            int i3 = this.startDirection;
            int i16 = this.scrollableBitset;
            float f18 = this.totalParentScrolled;
            float f19 = this.totalChildScrolled;
            String arrays = Arrays.toString(this.scrollOffset);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            String arrays2 = Arrays.toString(this.scrollConsumed);
            Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
            return "GestureState(hasScrolled=" + z16 + ", initDownX=" + f16 + ", initDownY=" + f17 + ", startDirection=" + i3 + ", scrollableBitset=" + i16 + ", totalParentScrolled=" + f18 + ", totalChildScrolled=" + f19 + ", scrollOffset=" + arrays + ", scrollConsumed=" + arrays2 + ", scrolled: " + this.totalChildScrolled + "/" + this.totalParentScrolled + ")";
        }

        public GestureState(boolean z16, boolean z17, float f16, float f17, int i3, int i16, float f18, float f19) {
            this.hasScrolled = z16;
            this.hasInnerScrolled = z17;
            this.initDownX = f16;
            this.initDownY = f17;
            this.startDirection = i3;
            this.scrollableBitset = i16;
            this.totalParentScrolled = f18;
            this.totalChildScrolled = f19;
            this.scrollOffset = new int[2];
            this.scrollConsumed = new int[2];
        }

        public /* synthetic */ GestureState(boolean z16, boolean z17, float f16, float f17, int i3, int i16, float f18, float f19, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? false : z17, (i17 & 4) != 0 ? 0.0f : f16, (i17 & 8) != 0 ? 0.0f : f17, (i17 & 16) != 0 ? 0 : i3, (i17 & 32) == 0 ? i16 : 0, (i17 & 64) != 0 ? 0.0f : f18, (i17 & 128) == 0 ? f19 : 0.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScrollableLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean i(int velocityX, int velocityY) {
        float f16 = velocityX;
        float f17 = velocityY;
        if (!dispatchNestedPreFling(f16, f17)) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("ScrollableContainerLayout", "fling(" + velocityX + ", " + velocityY + ") inner dispatch!");
            }
            dispatchNestedFling(f16, f17, true);
            k().c(velocityX, velocityY);
        }
        return true;
    }

    private final VelocityTracker j() {
        Object value = this.mVelocityTracker.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mVelocityTracker>(...)");
        return (VelocityTracker) value;
    }

    private final ViewFlinger k() {
        return (ViewFlinger) this.mViewFlinger.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x036a, code lost:
    
        if (i((int) r3, (int) r8) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0362, code lost:
    
        if (r9 == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0370, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0372, code lost:
    
        android.util.Log.d("ScrollableContainerLayout", "dispatch fling(" + r3 + ", " + r8 + ")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0393, code lost:
    
        r2 = 0;
        r16 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean l(MotionEvent ev5) {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        boolean z19;
        int i16;
        char c16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        boolean z26;
        MotionEvent event = MotionEvent.obtain(ev5);
        int actionMasked = MotionEventCompat.getActionMasked(event);
        boolean z27 = false;
        if (actionMasked == 0) {
            this.mNestedOffsetY = 0;
        }
        int y16 = (int) event.getY();
        int x16 = (int) event.getX();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ScrollableContainerLayout", "dispatchTouchEvent " + event.getX() + ", " + event.getY() + ", " + this.mNestedOffsetY + " " + this.mTotalOffset + " " + this.mGestureState);
        }
        e eVar = this.webView;
        if (eVar == null) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        z16 = false;
                    }
                } else {
                    int i28 = this.mLastY - y16;
                    int i29 = this.mLastX;
                    int i36 = i29 - x16;
                    this.mDiffX = i29 - x16;
                    this.mDiffY = this.mDownY - y16;
                    float abs = Math.abs(event.getX() - this.mGestureState.getInitDownX());
                    float abs2 = Math.abs(event.getY() - this.mGestureState.getInitDownY());
                    if (QLog.isDevelopLevel()) {
                        int i37 = this.mDiffX;
                        int i38 = this.mDiffY;
                        if (abs > this.mPagingTouchSlop) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        i16 = y16;
                        sb5.append("dispatchTouchEvent MOVE ");
                        sb5.append(abs);
                        sb5.append(" / ");
                        sb5.append(i37);
                        sb5.append(" / ");
                        sb5.append(abs2);
                        sb5.append(" / ");
                        sb5.append(i38);
                        sb5.append(" diffX > mPagingTouchSlop = ");
                        sb5.append(z26);
                        Log.d("ScrollableContainerLayout", sb5.toString());
                    } else {
                        i16 = y16;
                    }
                    if (!eVar.a((int) Math.signum(event.getX() - this.mGestureState.getInitDownX())) && !this.mGestureState.getHasScrolled() && abs > this.mPagingTouchSlop && abs > 1.5f * abs2) {
                        INSTANCE.b(this, true);
                        return false;
                    }
                    if (!this.mGestureState.getHasScrolled() && abs2 > this.mTouchSlop) {
                        this.mGestureState.i(true);
                    }
                    if (!this.mGestureState.getHasScrolled()) {
                        return eVar.dispatchTouchEvent(ev5);
                    }
                    if (dispatchNestedPreScroll(i36, i28, this.mGestureState.getScrollConsumed(), this.mGestureState.getScrollOffset())) {
                        if (QLog.isDevelopLevel()) {
                            String arrays = Arrays.toString(this.mGestureState.getScrollOffset());
                            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                            Log.d("ScrollableContainerLayout", "dispatchTouchEvent dispatchNestedPreScroll mScrollOffset = " + arrays + ", scrollDy=" + i28 + ", consumedDy=" + this.mGestureState.getScrollConsumed()[1]);
                        }
                        int i39 = this.mGestureState.getScrollOffset()[0] + 0;
                        c16 = 1;
                        int i46 = this.mGestureState.getScrollOffset()[1] + 0;
                        int i47 = i36 - this.mGestureState.getScrollConsumed()[0];
                        int i48 = i28 - this.mGestureState.getScrollConsumed()[1];
                        this.mNestedOffsetY += this.mGestureState.getScrollOffset()[1];
                        i17 = i48;
                        i26 = i46;
                        i19 = i39;
                        i18 = i47;
                    } else {
                        c16 = 1;
                        i17 = i28;
                        i18 = i36;
                        i19 = 0;
                        i26 = 0;
                    }
                    int i49 = this.mGestureState.getScrollOffset()[0];
                    int i56 = this.mGestureState.getScrollOffset()[c16];
                    this.mTotalOffset += i56;
                    if (QLog.isDevelopLevel()) {
                        float x17 = event.getX();
                        float y17 = event.getY();
                        StringBuilder sb6 = new StringBuilder();
                        i27 = x16;
                        sb6.append("post dispatch to delegateView: ");
                        sb6.append(x17);
                        sb6.append(", ");
                        sb6.append(y17);
                        Log.d("ScrollableContainerLayout", sb6.toString());
                    } else {
                        i27 = x16;
                    }
                    event.offsetLocation(0.0f, -this.mGestureState.getScrollOffset()[1]);
                    Intrinsics.checkNotNullExpressionValue(event, "event");
                    boolean dispatchTouchEvent = eVar.dispatchTouchEvent(event);
                    if (QLog.isDevelopLevel()) {
                        Log.d("ScrollableContainerLayout", "dispatch to delegateView: " + event.getX() + ", " + event.getY() + " -- " + dispatchTouchEvent);
                    }
                    if (Math.abs(i56) == 0) {
                        this.mGestureState.h(true);
                    }
                    if (dispatchNestedScroll(i49, i56, i18, i17, this.mGestureState.getScrollOffset())) {
                        if (QLog.isDevelopLevel()) {
                            Log.d("ScrollableContainerLayout", "dispatchTouchEvent dispatchNestedScroll dY = " + i56 + ", restDy=" + i17 + ", mScrollOffsetDy=" + this.mGestureState.getScrollOffset()[1]);
                        }
                        i19 += this.mGestureState.getScrollOffset()[0];
                        i26 += this.mGestureState.getScrollOffset()[1];
                        this.mNestedOffsetY += this.mGestureState.getScrollOffset()[1];
                        this.mLastX -= this.mGestureState.getScrollOffset()[0];
                        z16 = true;
                        this.mLastY -= this.mGestureState.getScrollOffset()[1];
                    } else {
                        z16 = true;
                    }
                    this.mLastX = i27 - i19;
                    this.mLastY = i16 - i26;
                    z27 = false;
                }
            }
            if (actionMasked == 1) {
                if (QLog.isDevelopLevel()) {
                    Log.d("ScrollableContainerLayout", "dispatchTouchEvent ACTION_UP");
                }
                j().addMovement(event);
                j().computeCurrentVelocity(1000, 8000.0f);
                float f16 = -j().getXVelocity();
                float f17 = -j().getYVelocity();
                if (f16 == 0.0f) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (f17 == 0.0f) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                }
            } else {
                if (QLog.isDevelopLevel()) {
                    Log.d("ScrollableContainerLayout", "dispatchTouchEvent CANCEL");
                }
                i3 = 0;
                z17 = false;
            }
            this.mTotalOffset = i3;
            INSTANCE.b(this, true);
            if (!this.mGestureState.getHasInnerScrolled() && this.mGestureState.getHasScrolled()) {
                if (actionMasked == 1 && QLog.isDevelopLevel()) {
                    Log.d("ScrollableContainerLayout", "dispatchTouchEvent ACTION_UP -- change to --> ACTION_CANCEL");
                }
                event.setAction(3);
            }
            Intrinsics.checkNotNullExpressionValue(event, "event");
            eVar.dispatchTouchEvent(event);
            stopNestedScroll();
            z16 = true;
            z27 = z17;
        } else {
            this.mGestureState.g(event.getX(), event.getY());
            this.mTotalOffset = 0;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            eVar.dispatchTouchEvent(event);
            INSTANCE.b(this, false);
            this.mLastX = x16;
            this.mDownX = x16;
            this.mLastY = y16;
            this.mDownY = y16;
            k().stop();
            startNestedScroll(2);
            z16 = true;
            z27 = false;
        }
        if (!z27) {
            j().addMovement(event);
        }
        event.recycle();
        return z16;
    }

    public static /* synthetic */ void setupView$default(ScrollableLayout scrollableLayout, View view, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            scrollableLayout.setupView(view, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupView");
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        e eVar = this.webView;
        if (eVar != null) {
            return eVar.canScrollVertically(direction);
        }
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int dx5, int dy5, @Nullable int[] consumed, @Nullable int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedPreScroll(dx5, dy5, consumed, offsetInWindow, type);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.childHandleDispatchTouchEvent) {
            return super.dispatchTouchEvent(ev5);
        }
        return l(ev5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int type) {
        return this.mChildHelper.hasNestedScrollingParent(type);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.childHandleDispatchTouchEvent) {
            return l(ev5);
        }
        return super.onTouchEvent(ev5);
    }

    public final void setChildHandleDispatchTouchEvent(boolean z16) {
        this.childHandleDispatchTouchEvent = z16;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean enabled) {
        this.mChildHelper.setNestedScrollingEnabled(enabled);
    }

    public final <T extends View & e> void setupView(@NotNull T view, boolean needAddView) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.webView = view;
        if (needAddView) {
            addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int axes, int type) {
        return this.mChildHelper.startNestedScroll(axes, type);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int type) {
        this.mChildHelper.stopNestedScroll(type);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScrollableLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public /* synthetic */ ScrollableLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScrollableLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPagingTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mGestureState = new GestureState(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 255, null);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<VelocityTracker>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout$mVelocityTracker$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VelocityTracker invoke() {
                return VelocityTracker.obtain();
            }
        });
        this.mVelocityTracker = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ViewFlinger>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout$mViewFlinger$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScrollableLayout.ViewFlinger invoke() {
                return new ScrollableLayout.ViewFlinger();
            }
        });
        this.mViewFlinger = lazy2;
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
}
