package com.tencent.mobileqq.guild.media.widget;

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
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
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
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0085\u0001B+\b\u0007\u0012\u0006\u0010~\u001a\u00020}\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u000f\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J0\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0014R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b&\u0010$R\u001b\u0010+\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010,R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010,R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010,R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00104R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010B\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010<R\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010\u001f\u001a\u0004\bG\u0010HR\"\u0010N\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010<\u001a\u0004\bK\u0010$\"\u0004\bL\u0010MR.\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR4\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R(\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00040_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR(\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00040_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010a\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR.\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010Q\u001a\u0004\bl\u0010S\"\u0004\bm\u0010UR\"\u0010t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u00104\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR4\u0010x\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010Y\u001a\u0004\bv\u0010[\"\u0004\bw\u0010]R\u0016\u0010z\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010<R\u0014\u0010|\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b{\u0010<\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildSwipeBackLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "ev", "", "u", "", EventListener.KEY_DELTA, "", "isHorizontal", "f", "r", "i", "horizontal", "e", "", tl.h.F, "j", ReportConstant.COSTREPORT_PREFIX, "k", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "computeScroll", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/view/View;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "mContentView", "p", "()I", "mTouchSlop", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mWidePageTouchSlop", "Landroidx/core/widget/ScrollerCompat;", "o", "()Landroidx/core/widget/ScrollerCompat;", "mScroller", UserInfo.SEX_FEMALE, "mInitialMotionX", "mInitialMotionY", BdhLogUtil.LogTag.Tag_Conn, "mLastMotionX", "D", "mLastMotionY", "E", "Z", "mIsSwipingHorizontally", "mIsSwipingVertically", "G", "mIsSwipingAioAreaFromRightToLeft", "H", "mTouchTopEdge", "Landroid/view/VelocityTracker;", "I", "Landroid/view/VelocityTracker;", "mVelocityTracker", "J", "mMinVelocity", "K", "mContentViewLeft", "L", "mContentViewTop", "Landroid/view/inputmethod/InputMethodManager;", "M", DomainData.DOMAIN_NAME, "()Landroid/view/inputmethod/InputMethodManager;", "mInputManager", "N", "getMTopEdgeSize", "setMTopEdgeSize", "(I)V", "mTopEdgeSize", "Lkotlin/Function1;", "P", "Lkotlin/jvm/functions/Function1;", "getOnScrollFinish", "()Lkotlin/jvm/functions/Function1;", "setOnScrollFinish", "(Lkotlin/jvm/functions/Function1;)V", "onScrollFinish", "Lkotlin/Function2;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/jvm/functions/Function2;", "getBeforeInteceptActionMove", "()Lkotlin/jvm/functions/Function2;", "setBeforeInteceptActionMove", "(Lkotlin/jvm/functions/Function2;)V", "beforeInteceptActionMove", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/jvm/functions/Function0;", "getOnStartSwipeEvent", "()Lkotlin/jvm/functions/Function0;", "setOnStartSwipeEvent", "(Lkotlin/jvm/functions/Function0;)V", "onStartSwipeEvent", ExifInterface.LATITUDE_SOUTH, "getOnSwipeAioAreaFromRightToLeftEvent", "setOnSwipeAioAreaFromRightToLeftEvent", "onSwipeAioAreaFromRightToLeftEvent", "T", "getOnTouch", "setOnTouch", "onTouch", "U", "getEnableVerticalScroll", "()Z", "setEnableVerticalScroll", "(Z)V", "enableVerticalScroll", "V", "getBizInterceptScroll", "setBizInterceptScroll", "bizInterceptScroll", "W", "mDragState", "a0", "ERR_VALUE", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSwipeBackLayout extends FrameLayout {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Interpolator> f229778c0;

    /* renamed from: C, reason: from kotlin metadata */
    private float mLastMotionX;

    /* renamed from: D, reason: from kotlin metadata */
    private float mLastMotionY;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsSwipingHorizontally;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsSwipingVertically;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsSwipingAioAreaFromRightToLeft;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mTouchTopEdge;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private VelocityTracker mVelocityTracker;

    /* renamed from: J, reason: from kotlin metadata */
    private final int mMinVelocity;

    /* renamed from: K, reason: from kotlin metadata */
    private int mContentViewLeft;

    /* renamed from: L, reason: from kotlin metadata */
    private int mContentViewTop;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInputManager;

    /* renamed from: N, reason: from kotlin metadata */
    private int mTopEdgeSize;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private Function1<? super Boolean, Unit> onScrollFinish;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private Function2<? super Float, ? super Float, Unit> beforeInteceptActionMove;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> onStartSwipeEvent;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Function0<Unit> onSwipeAioAreaFromRightToLeftEvent;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Function1<? super MotionEvent, Unit> onTouch;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean enableVerticalScroll;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private Function2<? super Float, ? super Float, Boolean> bizInterceptScroll;

    /* renamed from: W, reason: from kotlin metadata */
    private int mDragState;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int ERR_VALUE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTouchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mWidePageTouchSlop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mScroller;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mInitialMotionX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mInitialMotionY;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\nR\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildSwipeBackLayout$a;", "", "Landroid/view/animation/Interpolator;", "sInterpolator$delegate", "Lkotlin/Lazy;", "b", "()Landroid/view/animation/Interpolator;", "sInterpolator", "", "AIO_AREA_HEIGHT_RATIO", "D", "", "DEFAULT_EVENT_POS", UserInfo.SEX_FEMALE, "", "DEFAULT_TOP_EDGE_SIZE", "I", "HORIZONTAL_PERCENT", "SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "", "TAG", "Ljava/lang/String;", "VERTICAL_PERCENT", "mInitLeft", "mInitTop", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Interpolator b() {
            return (Interpolator) GuildSwipeBackLayout.f229778c0.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Interpolator> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(GuildSwipeBackLayout$Companion$sInterpolator$2.INSTANCE);
        f229778c0 = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSwipeBackLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(float delta, boolean horizontal) {
        Number valueOf;
        j();
        if (horizontal) {
            int i3 = this.mContentViewLeft;
            if (i3 + delta < 0.0f) {
                valueOf = Integer.valueOf(-i3);
            } else {
                valueOf = Float.valueOf(delta);
            }
            m().offsetTopAndBottom(valueOf.intValue());
            m().setTop((int) (2 * valueOf.floatValue()));
        } else {
            int h16 = h((int) delta);
            if (h16 != 0) {
                m().offsetTopAndBottom(h16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildSwipeBackLayout", 1, "left: " + m().getLeft() + " | top: " + m().getTop());
        }
        this.mContentViewLeft = m().getLeft();
        this.mContentViewTop = m().getTop();
    }

    private final boolean f(float delta, boolean isHorizontal) {
        if (isHorizontal && MediaChannelUtils.f228046a.x(this)) {
            if (Math.abs(delta) > q()) {
                return true;
            }
            return false;
        }
        if (Math.abs(delta) > p()) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean g(GuildSwipeBackLayout guildSwipeBackLayout, float f16, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildSwipeBackLayout.f(f16, z16);
    }

    private final int h(int delta) {
        if (getTop() + delta < 0) {
            return -getTop();
        }
        return delta;
    }

    private final void i() {
        this.mInitialMotionX = -1.0f;
        this.mInitialMotionY = -1.0f;
        this.mLastMotionX = -1.0f;
        this.mLastMotionY = -1.0f;
        this.mIsSwipingHorizontally = false;
        this.mIsSwipingVertically = false;
        this.mIsSwipingAioAreaFromRightToLeft = false;
        this.mTouchTopEdge = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private final void j() {
        try {
            if (n().isActive()) {
                n().hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception e16) {
            QLog.e("GuildSwipeBackLayout", 1, "closeSoftKeyboardIfActive: " + e16.getMessage());
        }
    }

    private final boolean k() {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = o().computeScrollOffset();
            int currX = o().getCurrX();
            int currY = o().getCurrY();
            int left = currX - m().getLeft();
            int top = currY - m().getTop();
            if (left != 0) {
                e(left, true);
            }
            if (top != 0) {
                e(top, false);
            }
            QLog.d("GuildSwipeBackLayout", 4, "onScrollFinish: 1-  " + o().getFinalY() + "  " + currY);
            if (computeScrollOffset && Math.abs(currX - o().getFinalX()) <= this.ERR_VALUE && Math.abs(currY - o().getFinalY()) <= this.ERR_VALUE) {
                o().abortAnimation();
                computeScrollOffset = o().isFinished();
            }
            if (!computeScrollOffset) {
                post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.at
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildSwipeBackLayout.l(GuildSwipeBackLayout.this);
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
    public static final void l(GuildSwipeBackLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        this$0.mDragState = 0;
        Function1<? super Boolean, Unit> function1 = this$0.onScrollFinish;
        if (this$0.getLeft() == 0 && this$0.getTop() == 0) {
            z16 = true;
        }
        function1.invoke(Boolean.valueOf(z16));
    }

    private final View m() {
        return (View) this.mContentView.getValue();
    }

    private final InputMethodManager n() {
        return (InputMethodManager) this.mInputManager.getValue();
    }

    private final ScrollerCompat o() {
        Object value = this.mScroller.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mScroller>(...)");
        return (ScrollerCompat) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int p() {
        return ((Number) this.mTouchSlop.getValue()).intValue();
    }

    private final int q() {
        return ((Number) this.mWidePageTouchSlop.getValue()).intValue();
    }

    private final boolean r() {
        if (this.mInitialMotionY < this.mTopEdgeSize) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
    
        if (r0 <= r1) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void s(MotionEvent ev5) {
        boolean z16;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.computeCurrentVelocity(1000);
        float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, MotionEventCompat.getPointerId(ev5, MotionEventCompat.getActionIndex(ev5)));
        float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, MotionEventCompat.getPointerId(ev5, MotionEventCompat.getActionIndex(ev5)));
        if (m().getTop() > m().getMeasuredHeight()) {
            this.onScrollFinish.invoke(Boolean.FALSE);
            return;
        }
        int i3 = 0;
        if (m().getTop() > m().getHeight() * 0.05d) {
            int i16 = this.mMinVelocity;
            if (yVelocity <= i16) {
                if (yVelocity == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (xVelocity >= (-i16)) {
                    }
                }
            }
            i3 = m().getHeight();
        }
        QLog.d("GuildSwipeBackLayout", 4, "onScrollFinish: 0-  " + i3);
        o().startScroll(m().getLeft(), m().getTop(), 0, i3 - m().getTop(), 500);
        this.mDragState = 2;
        invalidate();
        m().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.au
            @Override // java.lang.Runnable
            public final void run() {
                GuildSwipeBackLayout.t(GuildSwipeBackLayout.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildSwipeBackLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mDragState != 0) {
            this$0.onScrollFinish.invoke(Boolean.FALSE);
            this$0.mDragState = 0;
        }
    }

    private final void u(MotionEvent ev5) {
        this.mLastMotionX = ev5.getX();
        this.mLastMotionY = ev5.getY();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (k()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        if (r0 != 3) goto L54;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.bizInterceptScroll.invoke(Float.valueOf(ev5.getX()), Float.valueOf(ev5.getY())).booleanValue()) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(ev5);
        if (actionMasked == 0) {
            i();
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
                    if (this.mInitialMotionX == -1.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        if (this.mInitialMotionY == -1.0f) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            float x16 = ev5.getX() - this.mInitialMotionX;
                            float y16 = ev5.getY() - this.mInitialMotionY;
                            this.beforeInteceptActionMove.invoke(Float.valueOf(x16), Float.valueOf(y16));
                            if ((this.mTouchTopEdge || this.enableVerticalScroll) && g(this, y16, false, 2, null) && Math.abs(y16) > Math.abs(x16)) {
                                this.mDragState = 1;
                                this.mIsSwipingVertically = true;
                                this.onStartSwipeEvent.invoke();
                            } else if (f(x16, true) && Math.abs(x16) > Math.abs(y16)) {
                                this.mDragState = 1;
                                this.mIsSwipingHorizontally = true;
                                this.onStartSwipeEvent.invoke();
                                if (x16 < 0.0f && ev5.getY() > getHeight() * 0.6d) {
                                    this.mIsSwipingAioAreaFromRightToLeft = true;
                                }
                            }
                            u(ev5);
                        }
                    }
                    return false;
                }
            }
            i();
        } else {
            this.mInitialMotionX = ev5.getX();
            this.mInitialMotionY = ev5.getY();
            this.onTouch.invoke(ev5);
            if (r()) {
                this.mTouchTopEdge = true;
            }
        }
        if (this.mDragState != 1) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        try {
            super.onLayout(changed, left, top, right, bottom);
        } catch (Exception e16) {
            QLog.w("GuildSwipeBackLayout", 1, e16.getMessage());
        }
        m().offsetLeftAndRight(this.mContentViewLeft);
        m().offsetTopAndBottom(this.mContentViewTop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if (r0 != 3) goto L46;
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
                        e(x16, true);
                    } else if (this.mIsSwipingVertically) {
                        e(y16, false);
                    }
                } else if (i3 == 0) {
                    if ((this.mTouchTopEdge || this.enableVerticalScroll) && g(this, y16, false, 2, null) && Math.abs(y16) > Math.abs(x16)) {
                        this.mDragState = 1;
                        this.mIsSwipingVertically = true;
                        this.onStartSwipeEvent.invoke();
                    } else if (f(x16, true) && Math.abs(x16) > Math.abs(y16)) {
                        this.mDragState = 1;
                        this.mIsSwipingHorizontally = true;
                        this.onStartSwipeEvent.invoke();
                    }
                    u(ev5);
                }
            }
            return true;
        }
        if (this.mDragState == 1) {
            s(ev5);
        }
        if (this.mIsSwipingAioAreaFromRightToLeft) {
            this.onSwipeAioAreaFromRightToLeftEvent.invoke();
        }
        i();
        return true;
    }

    public final void setBeforeInteceptActionMove(@NotNull Function2<? super Float, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.beforeInteceptActionMove = function2;
    }

    public final void setBizInterceptScroll(@NotNull Function2<? super Float, ? super Float, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.bizInterceptScroll = function2;
    }

    public final void setEnableVerticalScroll(boolean z16) {
        this.enableVerticalScroll = z16;
    }

    public final void setMTopEdgeSize(int i3) {
        this.mTopEdgeSize = i3;
    }

    public final void setOnScrollFinish(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onScrollFinish = function1;
    }

    public final void setOnStartSwipeEvent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onStartSwipeEvent = function0;
    }

    public final void setOnSwipeAioAreaFromRightToLeftEvent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onSwipeAioAreaFromRightToLeftEvent = function0;
    }

    public final void setOnTouch(@NotNull Function1<? super MotionEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTouch = function1;
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
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildSwipeBackLayout>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$mContentView$2
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
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$mTouchSlop$2
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
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$mWidePageTouchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int p16;
                int coerceAtLeast;
                p16 = GuildSwipeBackLayout.this.p();
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(p16, ViewUtils.dpToPx(12.0f));
                return Integer.valueOf(coerceAtLeast);
            }
        });
        this.mWidePageTouchSlop = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ScrollerCompat>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$mScroller$2
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
        this.mScroller = lazy4;
        this.mInitialMotionX = -1.0f;
        this.mInitialMotionY = -1.0f;
        this.mLastMotionX = -1.0f;
        this.mLastMotionY = -1.0f;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<InputMethodManager>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$mInputManager$2
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
        this.mInputManager = lazy5;
        this.mTopEdgeSize = 300;
        this.onScrollFinish = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$onScrollFinish$1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.beforeInteceptActionMove = new Function2<Float, Float, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$beforeInteceptActionMove$1
            public final void invoke(float f16, float f17) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Float f16, Float f17) {
                invoke(f16.floatValue(), f17.floatValue());
                return Unit.INSTANCE;
            }
        };
        this.onStartSwipeEvent = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$onStartSwipeEvent$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.onSwipeAioAreaFromRightToLeftEvent = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$onSwipeAioAreaFromRightToLeftEvent$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.onTouch = new Function1<MotionEvent, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$onTouch$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MotionEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                invoke2(motionEvent);
                return Unit.INSTANCE;
            }
        };
        this.bizInterceptScroll = new Function2<Float, Float, Boolean>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildSwipeBackLayout$bizInterceptScroll$1
            @NotNull
            public final Boolean invoke(float f16, float f17) {
                return Boolean.FALSE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }
        };
        this.ERR_VALUE = 1;
    }
}
