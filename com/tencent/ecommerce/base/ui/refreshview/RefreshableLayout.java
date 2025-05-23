package com.tencent.ecommerce.base.ui.refreshview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.list.IStateRefreshView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0086\u0001B\u001e\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u007f\u0012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\"\u0010(\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001d\u0010%\"\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010;\u001a\u0002058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0018\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010C\u001a\u0004\u0018\u00010<8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010I\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010O\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010K\u001a\u0004\b\u001c\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010!\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010W\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010!\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR\"\u0010[\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010!\u001a\u0004\b\u001f\u0010R\"\u0004\bZ\u0010TR?\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u0005\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR*\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR.\u0010q\u001a\u0004\u0018\u00010-2\b\u0010n\u001a\u0004\u0018\u00010-8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010/\u001a\u0004\b\u0017\u00101\"\u0004\bp\u00103R\"\u0010t\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010$\u001a\u0004\b\u001a\u0010%\"\u0004\bs\u0010'R\"\u0010x\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010$\u001a\u0004\bv\u0010%\"\u0004\bw\u0010'R\u0016\u0010z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010$R\"\u0010~\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b{\u0010!\u001a\u0004\b|\u0010R\"\u0004\b}\u0010T\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/RefreshableLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/ecommerce/base/list/IStateRefreshView;", "Landroid/view/MotionEvent;", "ev", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "dispatchTouchEvent", "onTouchEvent", "", "offset", "l", "currentY", "p", DomainData.DOMAIN_NAME, "isForceRefresh", "", "tag", "b", "isSucceeded", "finishRefresh", "d", UserInfo.SEX_FEMALE, "touchX", "e", "touchY", "f", h.F, "firstMoveY", "i", "scrollOffsetY", "Z", "isScrolling", BdhLogUtil.LogTag.Tag_Conn, "I", "()I", "t", "(I)V", "refreshState", "Landroid/os/Handler;", "D", "Landroid/os/Handler;", "_handler", "Landroid/view/View;", "E", "Landroid/view/View;", "getChildView", "()Landroid/view/View;", "r", "(Landroid/view/View;)V", "childView", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "g", "()Landroidx/recyclerview/widget/RecyclerView;", ReportConstant.COSTREPORT_PREFIX, "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "Landroid/animation/ValueAnimator;", "G", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "animator", "H", "getCurrPullDownDistance", "()F", "setCurrPullDownDistance", "(F)V", "currPullDownDistance", "Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;", "Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;", "()Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;", "setOnRefreshListener", "(Lcom/tencent/ecommerce/base/ui/refreshview/OnRefreshListener;)V", "onRefreshListener", "J", "getFixListWhenPullDown", "()Z", "setFixListWhenPullDown", "(Z)V", "fixListWhenPullDown", "K", "isEnableRefresh", "setEnableRefresh", "L", "setAutoRefreshAnimatorShow", "isAutoRefreshAnimatorShow", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offsetY", "M", "Lkotlin/jvm/functions/Function1;", "getOnScrollListener", "()Lkotlin/jvm/functions/Function1;", "setOnScrollListener", "(Lkotlin/jvm/functions/Function1;)V", "onScrollListener", "Lkotlin/Function0;", "N", "Lkotlin/jvm/functions/Function0;", "isTopGetter", "()Lkotlin/jvm/functions/Function0;", "setTopGetter", "(Lkotlin/jvm/functions/Function0;)V", "value", "P", "setHeaderView", "headerView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "setHeaderViewHeight", "headerViewHeight", BdhLogUtil.LogTag.Tag_Req, "getRefreshScrollThreshold", "setRefreshScrollThreshold", "refreshScrollThreshold", ExifInterface.LATITUDE_SOUTH, "refreshTag", "T", "j", "setRefreshing", "isRefreshing", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public abstract class RefreshableLayout extends RelativeLayout implements IStateRefreshView {

    /* renamed from: C, reason: from kotlin metadata */
    private int refreshState;

    /* renamed from: D, reason: from kotlin metadata */
    private final Handler _handler;

    /* renamed from: E, reason: from kotlin metadata */
    protected View childView;

    /* renamed from: F, reason: from kotlin metadata */
    protected RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private ValueAnimator animator;

    /* renamed from: H, reason: from kotlin metadata */
    private float currPullDownDistance;

    /* renamed from: I, reason: from kotlin metadata */
    private OnRefreshListener onRefreshListener;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean fixListWhenPullDown;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isEnableRefresh;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isAutoRefreshAnimatorShow;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<? super Float, Unit> onScrollListener;

    /* renamed from: N, reason: from kotlin metadata */
    private Function0<Boolean> isTopGetter;

    /* renamed from: P, reason: from kotlin metadata */
    private View headerView;

    /* renamed from: Q, reason: from kotlin metadata */
    private int headerViewHeight;

    /* renamed from: R, reason: from kotlin metadata */
    private int refreshScrollThreshold;

    /* renamed from: S, reason: from kotlin metadata */
    private int refreshTag;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isRefreshing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float touchX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float touchY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float currentY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float firstMoveY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float scrollOffsetY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isScrolling;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                View headerView = RefreshableLayout.this.getHeaderView();
                if (headerView != null) {
                    headerView.setY((-RefreshableLayout.this.getHeaderViewHeight()) + floatValue);
                }
                RefreshableLayout.this.l(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                View headerView = RefreshableLayout.this.getHeaderView();
                if (headerView != null) {
                    headerView.setY((-RefreshableLayout.this.getHeaderViewHeight()) + floatValue);
                }
                RefreshableLayout.this.l(floatValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public RefreshableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._handler = new Handler(Looper.getMainLooper());
        this.isEnableRefresh = true;
        this.isAutoRefreshAnimatorShow = true;
        this.refreshScrollThreshold = com.tencent.ecommerce.biz.util.e.c(44.0f);
        this.refreshTag = 1;
    }

    private final boolean k() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        if (recyclerView.getVisibility() == 0) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            if (ViewCompat.canScrollVertically(recyclerView2, -1)) {
                return false;
            }
        }
        return true;
    }

    private final void m(MotionEvent ev5) {
        float y16;
        OnRefreshListener onRefreshListener;
        OnRefreshListener onRefreshListener2;
        View view = this.headerView;
        if (view != null) {
            view.setVisibility(0);
            float y17 = ev5.getY() - this.firstMoveY;
            int i3 = this.headerViewHeight;
            if (y17 > i3) {
                y16 = i3 + (((ev5.getY() - this.firstMoveY) - this.headerViewHeight) / 2);
            } else {
                y16 = ev5.getY() - this.firstMoveY;
            }
            float f16 = y16 + this.scrollOffsetY;
            int i16 = this.headerViewHeight;
            if (f16 < (-i16)) {
                f16 = -i16;
            }
            view.setY(f16);
            l(this.headerViewHeight + f16);
            if (this.headerViewHeight + f16 > this.refreshScrollThreshold) {
                int i17 = this.refreshState;
                if ((i17 == 0 || i17 == 3) && (onRefreshListener2 = this.onRefreshListener) != null && onRefreshListener2.onRefreshPrepare()) {
                    this.refreshState = 1;
                    return;
                }
                return;
            }
            if (this.refreshState == 1 && (onRefreshListener = this.onRefreshListener) != null && onRefreshListener.onRefreshIdle()) {
                this.refreshState = 3;
            }
        }
    }

    public final void b(final boolean isForceRefresh, final int tag) {
        post(new Runnable() { // from class: com.tencent.ecommerce.base.ui.refreshview.RefreshableLayout$autoRefresh$1
            @Override // java.lang.Runnable
            public final void run() {
                if (RefreshableLayout.this.getIsRefreshing()) {
                    return;
                }
                if (RefreshableLayout.this.getRefreshState() == 0 || isForceRefresh) {
                    View headerView = RefreshableLayout.this.getHeaderView();
                    if (headerView != null) {
                        headerView.setVisibility(0);
                    }
                    RefreshableLayout.this.setRefreshing(true);
                    RefreshableLayout.this.refreshTag = tag;
                    OnRefreshListener onRefreshListener = RefreshableLayout.this.getOnRefreshListener();
                    if (onRefreshListener != null) {
                        onRefreshListener.onRefreshing(tag);
                    }
                    RefreshableLayout.this.t(2);
                    if (RefreshableLayout.this.getIsAutoRefreshAnimatorShow()) {
                        RefreshableLayout.o(RefreshableLayout.this, 0.0f, 1, null);
                    }
                }
            }
        });
    }

    /* renamed from: d, reason: from getter */
    public final View getHeaderView() {
        return this.headerView;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        boolean z16;
        if (!this.isEnableRefresh) {
            return super.dispatchTouchEvent(ev5);
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = ev5.getX();
                    float y16 = ev5.getY();
                    float f16 = x16 - this.touchX;
                    float f17 = y16 - this.touchY;
                    if (Math.abs(f16) > Math.abs(f17)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    boolean z17 = y16 > this.currentY;
                    this.currentY = y16;
                    int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                    if (!this.isScrolling && f17 < scaledTouchSlop) {
                        View view = this.childView;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("childView");
                        }
                        if (view.getY() == 0.0f) {
                            return super.dispatchTouchEvent(ev5);
                        }
                    }
                    if (f17 <= scaledTouchSlop || !k()) {
                        View view2 = this.childView;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("childView");
                        }
                        if (view2.getY() <= 0 || (!this.isScrolling && f17 >= (-scaledTouchSlop))) {
                            z16 = false;
                            if (!z16) {
                                if (this.firstMoveY == 0.0f) {
                                    this.firstMoveY = y16;
                                    View view3 = this.headerView;
                                    this.scrollOffsetY = view3 != null ? view3.getY() : 0.0f;
                                    ValueAnimator valueAnimator = this.animator;
                                    if (valueAnimator != null) {
                                        valueAnimator.cancel();
                                    }
                                }
                                m(ev5);
                                View view4 = this.childView;
                                if (view4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("childView");
                                }
                                if (view4.getY() <= 0.0f && !this.fixListWhenPullDown && !z17) {
                                    this.firstMoveY = 0.0f;
                                    this.refreshState = 0;
                                }
                                if (this.isScrolling) {
                                    return true;
                                }
                                this.isScrolling = true;
                                return super.dispatchTouchEvent(ev5);
                            }
                            return super.dispatchTouchEvent(ev5);
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                } else if (action != 3) {
                    return super.dispatchTouchEvent(ev5);
                }
            }
            this.firstMoveY = 0.0f;
            this.isScrolling = false;
            int i3 = this.refreshState;
            if (i3 != 1 && i3 != 2) {
                q(this, 0.0f, 1, null);
            } else {
                o(this, 0.0f, 1, null);
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(ev5);
        }
        this.touchX = ev5.getX();
        float y17 = ev5.getY();
        this.touchY = y17;
        this.currentY = y17;
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* renamed from: e, reason: from getter */
    public final int getHeaderViewHeight() {
        return this.headerViewHeight;
    }

    /* renamed from: f, reason: from getter */
    public final OnRefreshListener getOnRefreshListener() {
        return this.onRefreshListener;
    }

    @Override // com.tencent.ecommerce.base.list.IStateRefreshView
    public void finishRefresh(boolean isSucceeded) {
        OnRefreshListener onRefreshListener = this.onRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onRefreshFinish(isSucceeded, this.refreshTag);
        }
        if (this.isAutoRefreshAnimatorShow) {
            this._handler.removeCallbacksAndMessages(null);
            this._handler.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.base.ui.refreshview.RefreshableLayout$finishRefresh$1
                @Override // java.lang.Runnable
                public final void run() {
                    RefreshableLayout.q(RefreshableLayout.this, 0.0f, 1, null);
                    RefreshableLayout.this.setRefreshing(false);
                }
            }, 1000L);
        } else {
            this.isRefreshing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView g() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final int getRefreshState() {
        return this.refreshState;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsAutoRefreshAnimatorShow() {
        return this.isAutoRefreshAnimatorShow;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public void l(float offset) {
        if (!this.fixListWhenPullDown) {
            View view = this.childView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("childView");
            }
            view.setY(offset);
        }
        this.currPullDownDistance = offset;
        OnRefreshListener onRefreshListener = this.onRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.onPullDownDistance(offset);
        }
        Function1<? super Float, Unit> function1 = this.onScrollListener;
        if (function1 != null) {
            function1.invoke(Float.valueOf(offset));
        }
    }

    public void n(float currentY) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(currentY, this.headerViewHeight);
        this.animator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(400L);
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new b());
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new c());
        }
        ValueAnimator valueAnimator4 = this.animator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        return true;
    }

    public void p(float currentY) {
        if (this.isScrolling) {
            return;
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(currentY, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new d());
        ofFloat.addListener(new e());
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(View view) {
        this.childView = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public final void setAutoRefreshAnimatorShow(boolean z16) {
        this.isAutoRefreshAnimatorShow = z16;
    }

    public final void setEnableRefresh(boolean z16) {
        this.isEnableRefresh = z16;
    }

    public final void setFixListWhenPullDown(boolean z16) {
        this.fixListWhenPullDown = z16;
    }

    public final void setHeaderView(View view) {
        this.headerView = view;
        int i3 = this.headerViewHeight;
        if (i3 <= 0) {
            i3 = -2;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i3);
        if (view != null) {
            view.setVisibility(8);
            view.setY(-this.headerViewHeight);
        }
        addView(view, layoutParams);
    }

    public final void setHeaderViewHeight(int i3) {
        this.headerViewHeight = i3;
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    public final void setOnScrollListener(Function1<? super Float, Unit> function1) {
        this.onScrollListener = function1;
    }

    public final void setRefreshScrollThreshold(int i3) {
        this.refreshScrollThreshold = i3;
    }

    public final void setRefreshing(boolean z16) {
        this.isRefreshing = z16;
    }

    public final void setTopGetter(Function0<Boolean> function0) {
        this.isTopGetter = function0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(int i3) {
        this.refreshState = i3;
    }

    public static /* synthetic */ void o(RefreshableLayout refreshableLayout, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                View view = refreshableLayout.childView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("childView");
                }
                f16 = view.getY();
            }
            refreshableLayout.n(f16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshingTranslate");
    }

    public static /* synthetic */ void q(RefreshableLayout refreshableLayout, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                View view = refreshableLayout.childView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("childView");
                }
                f16 = view.getY();
            }
            refreshableLayout.p(f16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: revertTranslate");
    }

    public static /* synthetic */ void c(RefreshableLayout refreshableLayout, boolean z16, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                z16 = false;
            }
            if ((i16 & 2) != 0) {
                i3 = 1;
            }
            refreshableLayout.b(z16, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoRefresh");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/base/ui/refreshview/RefreshableLayout$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (RefreshableLayout.this.getIsRefreshing()) {
                return;
            }
            RefreshableLayout.this.setRefreshing(true);
            OnRefreshListener onRefreshListener = RefreshableLayout.this.getOnRefreshListener();
            if (onRefreshListener != null) {
                onRefreshListener.onRefreshing(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/base/ui/refreshview/RefreshableLayout$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            OnRefreshListener onRefreshListener = RefreshableLayout.this.getOnRefreshListener();
            if (onRefreshListener == null || !onRefreshListener.onRefreshIdle()) {
                return;
            }
            RefreshableLayout.this.t(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
