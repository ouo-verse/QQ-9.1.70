package com.tencent.mobileqq.guild.discovery.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.banner.OverScrollLoadingView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0002Z[B\u0017\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u0003H\u0014J\b\u0010!\u001a\u00020\u0003H\u0014J\b\u0010\"\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0005H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010FR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00105R\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010NR\u0016\u0010O\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00105R\u0016\u0010T\u001a\u0004\u0018\u00010R8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010S\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/richframework/part/IRefreshViewProvider;", "", "u", "", "offset", ReportConstant.COSTREPORT_PREFIX, "destHeight", HippyTKDListViewAdapter.X, "t", "p", "height", "w", "Landroidx/lifecycle/Observer;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/richframework/part/block/base/NestScrollRecyclerView;", "recyclerView", "k", "o", "Lcom/tencent/biz/richframework/part/IRefreshViewProvider$OnRefreshListener;", "listener", "setOnRefreshListener", "Landroid/view/MotionEvent;", "event", "handleRefreshGesture", "isRefresh", "isRefreshing", "setRefreshing", "Landroidx/recyclerview/widget/RecyclerView;", "callRefresh", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "setState", "", "d", "Ljava/lang/String;", "source", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "e", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "innerLoadingView", "Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView$b;", "f", "Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView$b;", "loadingFrameLayout", tl.h.F, "Lcom/tencent/biz/richframework/part/IRefreshViewProvider$OnRefreshListener;", "onRefreshListener", "i", "I", "currentState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "", BdhLogUtil.LogTag.Tag_Conn, "J", "starRefreshTime", "D", "savedMeasuredHeight", "Landroid/os/Handler;", "E", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/os/Handler;", "mainHandler", "", UserInfo.SEX_FEMALE, "touchEventLastY", "G", "slideOffset", "H", "Landroidx/lifecycle/Observer;", "changeLoadingViewObserver", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "attachCount", "K", "detachCount", "Landroidx/recyclerview/widget/LinearLayoutManager;", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "L", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoveryLoadingHeaderView extends LinearLayout implements IRefreshViewProvider {

    /* renamed from: C, reason: from kotlin metadata */
    private long starRefreshTime;

    /* renamed from: D, reason: from kotlin metadata */
    private int savedMeasuredHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mainHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private float touchEventLastY;

    /* renamed from: G, reason: from kotlin metadata */
    private int slideOffset;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Observer<Boolean> changeLoadingViewObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private WeakReference<RecyclerView> recyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private int attachCount;

    /* renamed from: K, reason: from kotlin metadata */
    private int detachCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OverScrollLoadingView innerLoadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b loadingFrameLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRefreshViewProvider.OnRefreshListener onRefreshListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isRefreshing;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/DiscoveryLoadingHeaderView$b;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "d", "Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "a", "()Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "innerLoadingView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final OverScrollLoadingView innerLoadingView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            OverScrollLoadingView overScrollLoadingView = new OverScrollLoadingView(context);
            overScrollLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.innerLoadingView = overScrollLoadingView;
            setClipChildren(false);
            setClipToPadding(false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) cw.b(20), (int) cw.b(20));
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            addView(overScrollLoadingView, layoutParams);
            setPadding(0, (int) cw.b(10), 0, (int) cw.b(10));
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final OverScrollLoadingView getInnerLoadingView() {
            return this.innerLoadingView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoveryLoadingHeaderView(@NotNull Context context, @NotNull String source) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.guild.discovery.widget.DiscoveryLoadingHeaderView$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mainHandler = lazy;
        this.touchEventLastY = -1.0f;
        this.changeLoadingViewObserver = q();
        this.recyclerView = new WeakReference<>(null);
        setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        b bVar = new b(context);
        setGravity(17);
        this.loadingFrameLayout = bVar;
        this.innerLoadingView = bVar.getInnerLoadingView();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(bVar, layoutParams2);
        measure(-2, -2);
        this.savedMeasuredHeight = getMeasuredHeight();
        GuildThemeManager.f235286a.d().observeForever(this.changeLoadingViewObserver);
        Logger.f235387a.d().i("DiscoveryLoadingHeaderView", 1, "[" + this.source + "] init DiscoveryLoadingHeaderView, height: " + this.savedMeasuredHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final LinearLayoutManager m() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.recyclerView.get();
        if (recyclerView != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return null;
        }
        return (LinearLayoutManager) layoutManager;
    }

    private final Handler n() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int p() {
        return this.loadingFrameLayout.getLayoutParams().height;
    }

    private final Observer<Boolean> q() {
        return new Observer() { // from class: com.tencent.mobileqq.guild.discovery.widget.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DiscoveryLoadingHeaderView.r(DiscoveryLoadingHeaderView.this, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DiscoveryLoadingHeaderView this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryLoadingHeaderView", "newChangeLoadingViewObserver: " + bool);
        }
        this$0.innerLoadingView.setLoadingColorType(1, false);
        this$0.innerLoadingView.setStaticImageDrawable();
    }

    private final void s(int offset) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryLoadingHeaderView", "onMove, offset: " + offset + ", " + this.currentState);
        }
        if (offset > 0) {
            w(offset);
            int i3 = offset - this.savedMeasuredHeight;
            if (i3 > 0) {
                this.innerLoadingView.setTranslationY(0.0f);
                this.innerLoadingView.setRotation((i3 * 3) % 360);
            } else {
                this.innerLoadingView.setTranslationY(i3);
            }
            if (this.currentState <= 1) {
                if (p() > this.savedMeasuredHeight) {
                    setState(1);
                } else {
                    setState(0);
                }
            }
        }
    }

    private final void t() {
        if (p() > this.savedMeasuredHeight && this.currentState < 2) {
            setState(2);
        }
        if (this.currentState == 2) {
            x(this.savedMeasuredHeight);
        }
        if (this.currentState != 2) {
            x(0);
        }
    }

    private final void u() {
        int i3 = this.currentState;
        if (i3 != 4 && i3 != 2) {
            return;
        }
        long uptimeMillis = 500 - (SystemClock.uptimeMillis() - this.starRefreshTime);
        if (uptimeMillis > 0) {
            n().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    DiscoveryLoadingHeaderView.v(DiscoveryLoadingHeaderView.this);
                }
            }, uptimeMillis);
        } else {
            setState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DiscoveryLoadingHeaderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.currentState;
        if (i3 == 4 || i3 == 2) {
            this$0.setState(3);
        }
    }

    private final void w(int height) {
        int coerceAtLeast;
        ViewGroup.LayoutParams layoutParams = this.loadingFrameLayout.getLayoutParams();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(height, 0);
        layoutParams.height = coerceAtLeast;
        this.loadingFrameLayout.setLayoutParams(layoutParams);
    }

    private final void x(final int destHeight) {
        if (destHeight == p()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("DiscoveryLoadingHeaderView", "smoothScrollTo: same height, dstHeight[" + destHeight + "] visiHeight[" + p() + "]");
            }
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(p(), destHeight);
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.discovery.widget.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DiscoveryLoadingHeaderView.y(DiscoveryLoadingHeaderView.this, destHeight, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(DiscoveryLoadingHeaderView this$0, int i3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.w(intValue);
        if (i3 == 0 && intValue == 0) {
            this$0.setState(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void callRefresh(@Nullable final RecyclerView recyclerView) {
        setState(2);
        n().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                DiscoveryLoadingHeaderView.l(RecyclerView.this);
            }
        }, 100L);
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void handleRefreshGesture(@NotNull MotionEvent event) {
        boolean z16;
        LinearLayoutManager m3;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z17 = true;
        if (this.touchEventLastY == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.touchEventLastY = event.getRawY();
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 2) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("DiscoveryLoadingHeaderView", "handleRefreshGesture, " + event.getAction());
                }
                this.touchEventLastY = -1.0f;
                this.slideOffset = 0;
                if (getParent() != null && !this.isRefreshing) {
                    t();
                    return;
                }
                return;
            }
            float rawY = event.getRawY();
            float f16 = this.touchEventLastY;
            float f17 = (rawY - f16) / 2.0f;
            if (f16 != -1.0f) {
                z17 = false;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("DiscoveryLoadingHeaderView", "handleRefreshGesture, dy: " + f17 + ", touchEventLastY: " + this.touchEventLastY + ", isRefreshing: " + this.isRefreshing);
            }
            if (getParent() != null && !this.isRefreshing && !z17) {
                s(this.slideOffset + ((int) f17));
                if (f17 > 0.0f && (m3 = m()) != null) {
                    m3.scrollToPositionWithOffset(0, 0);
                    return;
                }
                return;
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryLoadingHeaderView", "handleRefreshGesture, " + event.getAction());
        }
        this.touchEventLastY = event.getRawY();
        this.slideOffset = p();
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    /* renamed from: isRefresh, reason: from getter */
    public boolean getIsRefreshing() {
        return this.isRefreshing;
    }

    public final void k(@Nullable NestScrollRecyclerView recyclerView) {
        this.recyclerView = new WeakReference<>(recyclerView);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachCount++;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void onDestroy() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryLoadingHeaderView", "onDestroy()");
        }
        n().removeCallbacksAndMessages(null);
        GuildThemeManager.f235286a.d().removeObserver(this.changeLoadingViewObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.detachCount++;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setOnRefreshListener(@Nullable IRefreshViewProvider.OnRefreshListener listener) {
        this.onRefreshListener = listener;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setRefreshing(boolean isRefreshing) {
        this.isRefreshing = isRefreshing;
        if (!isRefreshing) {
            u();
        }
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    public void setState(int state) {
        if (this.currentState == state) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("DiscoveryLoadingHeaderView", "setState: " + state);
        }
        if (state != 1) {
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        this.starRefreshTime = SystemClock.uptimeMillis();
                        this.innerLoadingView.setDynamicImageDrawable();
                        x(this.savedMeasuredHeight);
                        setRefreshing(true);
                    }
                } else {
                    x(0);
                    this.innerLoadingView.setStaticImageDrawable();
                    this.innerLoadingView.setRotation(0.0f);
                }
            } else {
                this.starRefreshTime = SystemClock.uptimeMillis();
                this.innerLoadingView.setDynamicImageDrawable();
                x(this.savedMeasuredHeight);
                IRefreshViewProvider.OnRefreshListener onRefreshListener = this.onRefreshListener;
                if (onRefreshListener != null) {
                    onRefreshListener.onRefresh();
                }
            }
        } else {
            QQGuildUIUtil.T(20L);
        }
        this.currentState = state;
    }

    @Override // com.tencent.biz.richframework.part.IRefreshViewProvider
    @NotNull
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public DiscoveryLoadingHeaderView getRefreshView() {
        return this;
    }
}
