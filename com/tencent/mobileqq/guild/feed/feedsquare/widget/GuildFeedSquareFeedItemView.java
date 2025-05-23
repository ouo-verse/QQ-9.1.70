package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.guild.feed.util.aw;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001jB\u0011\b\u0016\u0012\u0006\u0010a\u001a\u00020`\u00a2\u0006\u0004\bb\u0010cB\u0019\b\u0016\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010e\u001a\u00020d\u00a2\u0006\u0004\bb\u0010fB!\b\u0016\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010g\u001a\u00020\u001c\u00a2\u0006\u0004\bb\u0010hJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJV\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00112!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u00132!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u0013J\u001e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0006H\u0014J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%J\u0012\u0010*\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0002j\u0002`)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010<\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010,R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010,R\u0016\u0010C\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010,R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001e\u0010L\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010P\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u00105\u001a\u0004\bN\u0010OR\u001b\u0010R\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00105\u001a\u0004\bQ\u0010OR\u001b\u0010U\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u00105\u001a\u0004\bT\u0010OR\u001b\u0010Z\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR+\u0010_\u001a\u0012\u0012\u0004\u0012\u00020%0[j\b\u0012\u0004\u0012\u00020%`\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u00105\u001a\u0004\b=\u0010^\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareFeedItemView;", "Landroid/widget/LinearLayout;", "Landroid/view/MotionEvent;", "ev", "", "l", "", HippyTKDListViewAdapter.X, "", "msg", "u", "event", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/feed/util/c;", "listener", "setCombinedClickListener", "", "longPressDuration", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", NodeProps.ON_CLICK, e.a.NAME, "needInject", "", "", "exceptViewIds", "setInjectClickEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/m;", "processor", "j", "w", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongClickEvent;", "v", "d", "Z", "injectClickEvent", "e", "Ljava/util/List;", "exceptClickViewIds", "f", "Lcom/tencent/mobileqq/guild/feed/util/c;", "longPressListener", tl.h.F, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "touchSlop", "i", "p", "()J", "tapTimeout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isLongPress", BdhLogUtil.LogTag.Tag_Conn, "isReleased", "D", "I", "downX", "E", "downY", UserInfo.SEX_FEMALE, "shouldTriggerClick", "G", "J", "H", "Landroid/view/MotionEvent;", "longClickEvent", "Ljava/lang/Runnable;", DomainData.DOMAIN_NAME, "()Ljava/lang/Runnable;", "longPressRunnable", "o", "tapRunnable", "K", "r", "unsetPressedRunnable", "L", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "t", "()Z", "isInScrollingContainer", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "M", "()Ljava/util/LinkedHashSet;", "longClickEventProcessors", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedItemView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isReleased;

    /* renamed from: D, reason: from kotlin metadata */
    private int downX;

    /* renamed from: E, reason: from kotlin metadata */
    private int downY;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean shouldTriggerClick;

    /* renamed from: G, reason: from kotlin metadata */
    private long longPressDuration;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private MotionEvent longClickEvent;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy longPressRunnable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy tapRunnable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy unsetPressedRunnable;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.utils.a isInScrollingContainer;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy longClickEventProcessors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean injectClickEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> exceptClickViewIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.util.c longPressListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy touchSlop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tapTimeout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLongPress;
    static final /* synthetic */ KProperty<Object>[] P = {Reflection.property1(new PropertyReference1Impl(GuildFeedSquareFeedItemView.class, "isInScrollingContainer", "isInScrollingContainer()Z", 0))};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareFeedItemView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        this.exceptClickViewIds = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(GuildFeedSquareFeedItemView.this.getContext()).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$tapTimeout$2.INSTANCE);
        this.tapTimeout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$longPressRunnable$2(this));
        this.longPressRunnable = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$tapRunnable$2(this));
        this.tapRunnable = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$unsetPressedRunnable$2(this));
        this.unsetPressedRunnable = lazy5;
        this.isInScrollingContainer = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(new GuildFeedSquareFeedItemView$isInScrollingContainer$2(this), ComputedKt.a(), GuildFeedSquareFeedItemView$isInScrollingContainer$3.INSTANCE);
        lazy6 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$longClickEventProcessors$2.INSTANCE);
        this.longClickEventProcessors = lazy6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildFeedSquareFeedItemView this$0) {
        Function1<View, Unit> c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.feed.util.c cVar = this$0.longPressListener;
        if (cVar != null && (c16 = cVar.c()) != null) {
            c16.invoke(this$0);
        }
        this$0.performAccessibilityAction(16, null);
        this$0.u("trigger click");
        this$0.postDelayed(this$0.r(), ViewConfiguration.getPressedStateDuration());
    }

    private final boolean l(MotionEvent ev5) {
        Iterator<T> it = this.exceptClickViewIds.iterator();
        while (it.hasNext()) {
            if (aw.f223853a.b(findViewById(((Number) it.next()).intValue()), ev5)) {
                return true;
            }
        }
        return false;
    }

    private final LinkedHashSet<m> m() {
        return (LinkedHashSet) this.longClickEventProcessors.getValue();
    }

    private final Runnable n() {
        return (Runnable) this.longPressRunnable.getValue();
    }

    private final Runnable o() {
        return (Runnable) this.tapRunnable.getValue();
    }

    private final long p() {
        return ((Number) this.tapTimeout.getValue()).longValue();
    }

    private final int q() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    private final Runnable r() {
        return (Runnable) this.unsetPressedRunnable.getValue();
    }

    private final boolean s(MotionEvent event) {
        if (Math.abs(event.getX() - this.downX) < q() && Math.abs(event.getY() - this.downY) < q()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void setCombinedClickListener$default(GuildFeedSquareFeedItemView guildFeedSquareFeedItemView, long j3, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 200;
        }
        guildFeedSquareFeedItemView.setCombinedClickListener(j3, function1, function12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setInjectClickEvent$default(GuildFeedSquareFeedItemView guildFeedSquareFeedItemView, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        guildFeedSquareFeedItemView.setInjectClickEvent(z16, list);
    }

    private final boolean t() {
        return ((Boolean) this.isInScrollingContainer.getValue(this, P[0])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String msg2) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedSquareFeedItemView", 1, msg2);
        }
    }

    private final void x() {
        removeCallbacks(n());
        removeCallbacks(o());
        removeCallbacks(r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 onClick, GuildFeedSquareFeedItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClick.invoke(this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean z() {
        if (this.longPressListener != null && this.longPressDuration > 0 && !this.injectClickEvent && !hasOnClickListeners()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r0 != 4) goto L25;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!z()) {
            return super.dispatchTouchEvent(event);
        }
        this.longClickEvent = event;
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                    }
                } else if (!s(event)) {
                    x();
                    this.shouldTriggerClick = false;
                    setPressed(false);
                    u("move outside the slop(" + s(event) + "), cancel long press");
                }
            }
            x();
            this.isReleased = true;
            r().run();
            if (this.isLongPress) {
                ViewCompat.replaceAccessibilityAction(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK, null, null);
                return true;
            }
            u("up: " + this.downX + ", " + this.downY);
        } else {
            this.downX = (int) event.getX();
            this.downY = (int) event.getY();
            this.isReleased = false;
            this.isLongPress = false;
            this.shouldTriggerClick = true;
            postDelayed(n(), this.longPressDuration);
            u("down: " + this.downX + ", " + this.downY);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        if (event.getAction() == 1 && !dispatchTouchEvent && this.shouldTriggerClick && s(event)) {
            removeCallbacks(n());
            if (!isPressed()) {
                setPressed(true);
            }
            getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareFeedItemView.k(GuildFeedSquareFeedItemView.this);
                }
            });
        }
        if (event.getAction() == 0 && !dispatchTouchEvent) {
            removeCallbacks(r());
            if (t()) {
                postDelayed(o(), p());
                return true;
            }
            setPressed(true);
            return true;
        }
        return dispatchTouchEvent;
    }

    public final void j(@NotNull m processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        m().add(processor);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
        this.longClickEvent = null;
        if (isPressed()) {
            setPressed(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        if (!z()) {
            return;
        }
        info.addAction(16);
        info.addAction(32);
        info.setClickable(true);
        info.setLongClickable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        if (this.injectClickEvent && !l(ev5)) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    public final void setCombinedClickListener(@NotNull com.tencent.mobileqq.guild.feed.util.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.longPressDuration = listener.getLongPressDuration();
        this.longPressListener = listener;
    }

    public final void setInjectClickEvent(boolean needInject, @NotNull List<Integer> exceptViewIds) {
        final Function1<View, Unit> c16;
        Intrinsics.checkNotNullParameter(exceptViewIds, "exceptViewIds");
        this.injectClickEvent = needInject;
        if (needInject) {
            this.exceptClickViewIds = exceptViewIds;
            com.tencent.mobileqq.guild.feed.util.c cVar = this.longPressListener;
            if (cVar != null && (c16 = cVar.c()) != null) {
                setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildFeedSquareFeedItemView.y(Function1.this, this, view);
                    }
                });
                return;
            }
            return;
        }
        this.exceptClickViewIds.clear();
        setOnClickListener(null);
    }

    public final boolean v(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<m> it = m().iterator();
        while (it.hasNext()) {
            if (it.next().a(event)) {
                return true;
            }
        }
        return false;
    }

    public final void w(@NotNull m processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        m().remove(processor);
    }

    public final void setCombinedClickListener(long longPressDuration, @NotNull Function1<? super View, Unit> onClick, @NotNull Function1<? super View, Unit> onLongPress) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onLongPress, "onLongPress");
        setCombinedClickListener(new com.tencent.mobileqq.guild.feed.util.c(longPressDuration, onLongPress, onClick));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareFeedItemView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.exceptClickViewIds = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(GuildFeedSquareFeedItemView.this.getContext()).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$tapTimeout$2.INSTANCE);
        this.tapTimeout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$longPressRunnable$2(this));
        this.longPressRunnable = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$tapRunnable$2(this));
        this.tapRunnable = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$unsetPressedRunnable$2(this));
        this.unsetPressedRunnable = lazy5;
        this.isInScrollingContainer = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(new GuildFeedSquareFeedItemView$isInScrollingContainer$2(this), ComputedKt.a(), GuildFeedSquareFeedItemView$isInScrollingContainer$3.INSTANCE);
        lazy6 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$longClickEventProcessors$2.INSTANCE);
        this.longClickEventProcessors = lazy6;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareFeedItemView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.exceptClickViewIds = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(GuildFeedSquareFeedItemView.this.getContext()).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$tapTimeout$2.INSTANCE);
        this.tapTimeout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$longPressRunnable$2(this));
        this.longPressRunnable = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$tapRunnable$2(this));
        this.tapRunnable = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new GuildFeedSquareFeedItemView$unsetPressedRunnable$2(this));
        this.unsetPressedRunnable = lazy5;
        this.isInScrollingContainer = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(new GuildFeedSquareFeedItemView$isInScrollingContainer$2(this), ComputedKt.a(), GuildFeedSquareFeedItemView$isInScrollingContainer$3.INSTANCE);
        lazy6 = LazyKt__LazyJVMKt.lazy(GuildFeedSquareFeedItemView$longClickEventProcessors$2.INSTANCE);
        this.longClickEventProcessors = lazy6;
    }
}
