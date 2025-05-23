package com.tencent.guild.aio.article.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 l2\u00020\u0001:\u0001mB'\b\u0007\u0012\u0006\u0010f\u001a\u00020e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010i\u001a\u00020\u000e\u00a2\u0006\u0004\bj\u0010kJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J0\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0014R\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010(R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010(R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00100R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010;\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010:R\u0016\u0010>\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010:R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010BR\"\u0010H\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u0010\"\"\u0004\bF\u0010GR.\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR.\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010M\"\u0004\bS\u0010OR4\u0010\\\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u00100\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010:\u00a8\u0006n"}, d2 = {"Lcom/tencent/guild/aio/article/widget/GuildSwipeBackLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "ev", "", "p", "", EventListener.KEY_DELTA, "", "d", DomainData.DOMAIN_NAME, "f", "horizontal", "c", "", "e", "g", "o", h.F, NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "computeScroll", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/view/View;", "Lkotlin/Lazy;", "j", "()Landroid/view/View;", "mContentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "mTouchSlop", "Landroidx/core/widget/ScrollerCompat;", "l", "()Landroidx/core/widget/ScrollerCompat;", "mScroller", UserInfo.SEX_FEMALE, "mInitialMotionX", "i", "mInitialMotionY", "mLastMotionX", BdhLogUtil.LogTag.Tag_Conn, "mLastMotionY", "D", "Z", "mIsSwipingHorizontally", "E", "mIsSwipingVertically", "mTouchTopEdge", "Landroid/view/VelocityTracker;", "G", "Landroid/view/VelocityTracker;", "mVelocityTracker", "H", "I", "mMinVelocity", "mContentViewLeft", "J", "mContentViewTop", "Landroid/view/inputmethod/InputMethodManager;", "K", "k", "()Landroid/view/inputmethod/InputMethodManager;", "mInputManager", "L", "getMTopEdgeSize", "setMTopEdgeSize", "(I)V", "mTopEdgeSize", "Lkotlin/Function1;", "M", "Lkotlin/jvm/functions/Function1;", "getOnScrollFinish", "()Lkotlin/jvm/functions/Function1;", "setOnScrollFinish", "(Lkotlin/jvm/functions/Function1;)V", "onScrollFinish", "N", "getOnPosChange", "setOnPosChange", "onPosChange", "Lkotlin/Function2;", "P", "Lkotlin/jvm/functions/Function2;", "getBeforeInteceptActionMove", "()Lkotlin/jvm/functions/Function2;", "setBeforeInteceptActionMove", "(Lkotlin/jvm/functions/Function2;)V", "beforeInteceptActionMove", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getEnableVerticalScroll", "()Z", "setEnableVerticalScroll", "(Z)V", "enableVerticalScroll", BdhLogUtil.LogTag.Tag_Req, "mDragState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ExifInterface.LATITUDE_SOUTH, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildSwipeBackLayout extends FrameLayout {

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Interpolator> T;

    /* renamed from: C, reason: from kotlin metadata */
    private float mLastMotionY;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsSwipingHorizontally;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsSwipingVertically;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mTouchTopEdge;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private VelocityTracker mVelocityTracker;

    /* renamed from: H, reason: from kotlin metadata */
    private final int mMinVelocity;

    /* renamed from: I, reason: from kotlin metadata */
    private int mContentViewLeft;

    /* renamed from: J, reason: from kotlin metadata */
    private int mContentViewTop;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInputManager;

    /* renamed from: L, reason: from kotlin metadata */
    private int mTopEdgeSize;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private Function1<? super Boolean, Unit> onScrollFinish;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private Function1<? super Float, Unit> onPosChange;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private Function2<? super Float, ? super Float, Unit> beforeInteceptActionMove;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean enableVerticalScroll;

    /* renamed from: R, reason: from kotlin metadata */
    private int mDragState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTouchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mScroller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mInitialMotionX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mInitialMotionY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mLastMotionX;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/article/widget/GuildSwipeBackLayout$a;", "", "Landroid/view/animation/Interpolator;", "sInterpolator$delegate", "Lkotlin/Lazy;", "b", "()Landroid/view/animation/Interpolator;", "sInterpolator", "", "DEFAULT_EVENT_POS", UserInfo.SEX_FEMALE, "", "DEFAULT_TOP_EDGE_SIZE", "I", "", "HORIZONTAL_PERCENT", "D", "SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "", "TAG", "Ljava/lang/String;", "VERTICAL_PERCENT", "mInitLeft", "mInitTop", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Interpolator b() {
            return (Interpolator) GuildSwipeBackLayout.T.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Interpolator> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(GuildSwipeBackLayout$Companion$sInterpolator$2.INSTANCE);
        T = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSwipeBackLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(float delta, boolean horizontal) {
        g();
        if (horizontal) {
            j().offsetLeftAndRight((int) delta);
            this.onPosChange.invoke(Float.valueOf(Math.abs((getLeft() + 0) / getWidth())));
        } else {
            int e16 = e((int) delta);
            if (e16 != 0) {
                j().offsetTopAndBottom(e16);
            }
            this.onPosChange.invoke(Float.valueOf(Math.abs((getTop() + 0) / getHeight())));
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildSwipeBackLayout", 1, "left: " + j().getLeft() + " | top: " + j().getTop());
        }
        this.mContentViewLeft = j().getLeft();
        this.mContentViewTop = j().getTop();
    }

    private final boolean d(float delta) {
        if (Math.abs(delta) > m()) {
            return true;
        }
        return false;
    }

    private final int e(int delta) {
        if (getTop() + delta < 0) {
            return -getTop();
        }
        return delta;
    }

    private final void f() {
        this.mInitialMotionX = -1.0f;
        this.mInitialMotionY = -1.0f;
        this.mLastMotionX = -1.0f;
        this.mLastMotionY = -1.0f;
        this.mIsSwipingHorizontally = false;
        this.mIsSwipingVertically = false;
        this.mTouchTopEdge = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private final void g() {
        try {
            if (k().isActive()) {
                k().hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception e16) {
            QLog.e("GuildSwipeBackLayout", 1, "closeSoftKeyboardIfActive: " + e16.getMessage());
        }
    }

    private final boolean h() {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = l().computeScrollOffset();
            int currX = l().getCurrX();
            int currY = l().getCurrY();
            int left = currX - j().getLeft();
            int top = currY - j().getTop();
            if (left != 0) {
                c(left, true);
            }
            if (top != 0) {
                c(top, false);
            }
            if (computeScrollOffset && currX == l().getFinalX() && currY == l().getFinalY()) {
                l().abortAnimation();
                computeScrollOffset = l().isFinished();
            }
            if (!computeScrollOffset) {
                post(new Runnable() { // from class: com.tencent.guild.aio.article.widget.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildSwipeBackLayout.i(GuildSwipeBackLayout.this);
                    }
                });
            }
        }
        if (this.mDragState == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildSwipeBackLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        this$0.mDragState = 0;
        Function1<? super Boolean, Unit> function1 = this$0.onScrollFinish;
        if (this$0.getLeft() == 0 && this$0.getTop() == 0) {
            z16 = true;
        }
        function1.invoke(Boolean.valueOf(z16));
    }

    private final View j() {
        return (View) this.mContentView.getValue();
    }

    private final InputMethodManager k() {
        return (InputMethodManager) this.mInputManager.getValue();
    }

    private final ScrollerCompat l() {
        Object value = this.mScroller.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mScroller>(...)");
        return (ScrollerCompat) value;
    }

    private final int m() {
        return ((Number) this.mTouchSlop.getValue()).intValue();
    }

    private final boolean n() {
        if (this.mInitialMotionY < this.mTopEdgeSize) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c3, code lost:
    
        if (r10 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(MotionEvent ev5) {
        int width;
        boolean z16;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.computeCurrentVelocity(1000);
        float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, MotionEventCompat.getPointerId(ev5, MotionEventCompat.getActionIndex(ev5)));
        float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, MotionEventCompat.getPointerId(ev5, MotionEventCompat.getActionIndex(ev5)));
        int i3 = 0;
        if (j().getLeft() <= j().getWidth() * 0.1d && (j().getLeft() <= 0 || xVelocity <= this.mMinVelocity)) {
            if (j().getLeft() >= (-j().getWidth()) * 0.1d && (j().getLeft() >= 0 || xVelocity >= (-this.mMinVelocity))) {
                width = 0;
            } else {
                width = -j().getWidth();
            }
        } else {
            width = j().getWidth();
        }
        if (j().getTop() > j().getHeight() * 0.05d && this.mIsSwipingVertically) {
            if (yVelocity <= this.mMinVelocity) {
                if (yVelocity == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            i3 = j().getHeight();
        }
        l().startScroll(j().getLeft(), j().getTop(), width - j().getLeft(), i3 - j().getTop(), 500);
        this.mDragState = 2;
        invalidate();
    }

    private final void p(MotionEvent ev5) {
        this.mLastMotionX = ev5.getX();
        this.mLastMotionY = ev5.getY();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (h()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r0 != 3) goto L38;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int actionMasked = MotionEventCompat.getActionMasked(ev5);
        if (actionMasked == 0) {
            f();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(ev5);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float x16 = ev5.getX() - this.mInitialMotionX;
                    float y16 = ev5.getY() - this.mInitialMotionY;
                    this.beforeInteceptActionMove.invoke(Float.valueOf(x16), Float.valueOf(y16));
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildSwipeBackLayout", 1, "intercept enableVerticalScroll: " + this.enableVerticalScroll + " | mDragState: " + this.mDragState + " | dy: " + y16);
                    }
                    if ((this.mTouchTopEdge || this.enableVerticalScroll) && d(y16) && Math.abs(y16) > Math.abs(x16)) {
                        this.mDragState = 1;
                        this.mIsSwipingVertically = true;
                    } else if (d(x16) && Math.abs(x16) > Math.abs(y16)) {
                        this.mDragState = 1;
                        this.mIsSwipingHorizontally = true;
                    }
                    p(ev5);
                }
            }
            f();
        } else {
            this.mInitialMotionX = ev5.getX();
            this.mInitialMotionY = ev5.getY();
            if (n()) {
                this.mTouchTopEdge = true;
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        j().offsetLeftAndRight(this.mContentViewLeft);
        j().offsetTopAndBottom(this.mContentViewTop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r0 != 3) goto L43;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int actionMasked = MotionEventCompat.getActionMasked(ev5);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(ev5);
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildSwipeBackLayout", 1, "enableVerticalScroll: " + this.enableVerticalScroll + " | mDragState: " + this.mDragState);
                }
                float x16 = ev5.getX() - this.mInitialMotionX;
                float y16 = ev5.getY() - this.mInitialMotionY;
                int i3 = this.mDragState;
                if (i3 == 1) {
                    if (this.mIsSwipingHorizontally) {
                        c(x16, true);
                    } else if (this.mIsSwipingVertically) {
                        c(y16, false);
                    }
                } else if (i3 == 0) {
                    if ((this.mTouchTopEdge || this.enableVerticalScroll) && d(y16) && Math.abs(y16) > Math.abs(x16)) {
                        this.mDragState = 1;
                        this.mIsSwipingVertically = true;
                    } else if (d(x16) && Math.abs(x16) > Math.abs(y16)) {
                        this.mDragState = 1;
                        this.mIsSwipingHorizontally = true;
                    }
                    p(ev5);
                }
            }
            return true;
        }
        if (this.mDragState == 1) {
            o(ev5);
        }
        f();
        return true;
    }

    public final void setBeforeInteceptActionMove(@NotNull Function2<? super Float, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.beforeInteceptActionMove = function2;
    }

    public final void setEnableVerticalScroll(boolean z16) {
        this.enableVerticalScroll = z16;
    }

    public final void setMTopEdgeSize(int i3) {
        this.mTopEdgeSize = i3;
    }

    public final void setOnPosChange(@NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPosChange = function1;
    }

    public final void setOnScrollFinish(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onScrollFinish = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSwipeBackLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildSwipeBackLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSwipeBackLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildSwipeBackLayout>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$mContentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSwipeBackLayout invoke() {
                return GuildSwipeBackLayout.this;
            }
        });
        this.mContentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$mTouchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(context).getScaledTouchSlop());
            }
        });
        this.mTouchSlop = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ScrollerCompat>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$mScroller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ScrollerCompat invoke() {
                Interpolator b16;
                Context context2 = context;
                b16 = GuildSwipeBackLayout.INSTANCE.b();
                return ScrollerCompat.create(context2, b16);
            }
        });
        this.mScroller = lazy3;
        this.mInitialMotionX = -1.0f;
        this.mInitialMotionY = -1.0f;
        this.mLastMotionX = -1.0f;
        this.mLastMotionY = -1.0f;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<InputMethodManager>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$mInputManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InputMethodManager invoke() {
                Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager) systemService;
            }
        });
        this.mInputManager = lazy4;
        this.mTopEdgeSize = 200;
        this.onScrollFinish = new Function1<Boolean, Unit>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$onScrollFinish$1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.onPosChange = new Function1<Float, Unit>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$onPosChange$1
            public final void invoke(float f16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }
        };
        this.beforeInteceptActionMove = new Function2<Float, Float, Unit>() { // from class: com.tencent.guild.aio.article.widget.GuildSwipeBackLayout$beforeInteceptActionMove$1
            public final void invoke(float f16, float f17) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Float f16, Float f17) {
                invoke(f16.floatValue(), f17.floatValue());
                return Unit.INSTANCE;
            }
        };
    }
}
