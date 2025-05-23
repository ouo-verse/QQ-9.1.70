package com.tencent.timi.game.liveroom.impl.room.message.stack;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.NormalFloatingBannerItemView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.impl.room.event.PayLevelFloatingBannerChangedEvent;
import com.tencent.timi.game.liveroom.impl.room.event.PurchaseFloatingBannerChangedEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00010\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0001R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "", "", NodeProps.VISIBLE, "", DomainData.DOMAIN_NAME, "", "roomId", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Landroid/view/animation/Animation;", "f", "d", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, h.F, "anchorId", "j", MiniChatConstants.MINI_APP_LANDSCAPE, "i", "k", "l", "a", "Landroid/widget/FrameLayout;", "bannerContainer", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/NormalFloatingBannerItemView;", "b", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/NormalFloatingBannerItemView;", "floatingBannerItemView", "c", "J", "Z", "bannerStayDuration", "g", "bannerIsShowing", "Landroid/view/animation/TranslateAnimation;", "Landroid/view/animation/TranslateAnimation;", "translateAnimation", "Landroid/view/animation/AlphaAnimation;", "Landroid/view/animation/AlphaAnimation;", "alphaAnimation", "com/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic$b", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic$b;", "receiver", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "hideRunnable", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class NormalFloatingBannerLogic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout bannerContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NormalFloatingBannerItemView floatingBannerItemView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean bannerIsShowing;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TranslateAnimation translateAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AlphaAnimation alphaAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long bannerStayDuration = ht3.a.c("chat_area_normal_banner_auto_dismiss_duration", 2000);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b receiver = new b();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.message.stack.c
        @Override // java.lang.Runnable
        public final void run() {
            NormalFloatingBannerLogic.g(NormalFloatingBannerLogic.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0007`\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements SimpleEventReceiver<SimpleBaseEvent> {
        b() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(PayLevelFloatingBannerChangedEvent.class);
            arrayList.add(PurchaseFloatingBannerChangedEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            boolean z16 = true;
            if (event instanceof PayLevelFloatingBannerChangedEvent) {
                PayLevelFloatingBannerChangedEvent payLevelFloatingBannerChangedEvent = (PayLevelFloatingBannerChangedEvent) event;
                AegisLogger.INSTANCE.i("Float_Banner|NormalFloatingBannerLogic", "PayLevelFloatingBannerChangedEvent", "visible:" + payLevelFloatingBannerChangedEvent.getVisible());
                NormalFloatingBannerLogic normalFloatingBannerLogic = NormalFloatingBannerLogic.this;
                if (payLevelFloatingBannerChangedEvent.getVisible() || NormalFloatingBannerLogic.this.isLandscape) {
                    z16 = false;
                }
                normalFloatingBannerLogic.n(z16);
                return;
            }
            if (event instanceof PurchaseFloatingBannerChangedEvent) {
                PurchaseFloatingBannerChangedEvent purchaseFloatingBannerChangedEvent = (PurchaseFloatingBannerChangedEvent) event;
                AegisLogger.INSTANCE.i("Float_Banner|NormalFloatingBannerLogic", "PurchaseFloatingBannerChangedEvent", "visible:" + purchaseFloatingBannerChangedEvent.getVisible());
                NormalFloatingBannerLogic normalFloatingBannerLogic2 = NormalFloatingBannerLogic.this;
                if (purchaseFloatingBannerChangedEvent.getVisible() || NormalFloatingBannerLogic.this.isLandscape) {
                    z16 = false;
                }
                normalFloatingBannerLogic2.n(z16);
            }
        }
    }

    private final Animation d() {
        AlphaAnimation alphaAnimation = this.alphaAnimation;
        if (alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(100L);
            this.alphaAnimation = alphaAnimation2;
            return alphaAnimation2;
        }
        return alphaAnimation;
    }

    private final long e() {
        if (this.bannerIsShowing) {
            return this.bannerStayDuration;
        }
        return this.bannerStayDuration + 200;
    }

    private final Animation f() {
        TranslateAnimation translateAnimation = this.translateAnimation;
        if (translateAnimation == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, -1.0f, 2, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(200L);
            translateAnimation2.setInterpolator(a.INSTANCE.a());
            translateAnimation2.setFillAfter(true);
            this.translateAnimation = translateAnimation2;
            return translateAnimation2;
        }
        return translateAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NormalFloatingBannerLogic this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.bannerContainer;
        if (frameLayout != null) {
            frameLayout.startAnimation(this$0.d());
        }
        this$0.bannerIsShowing = false;
    }

    private final void m(long roomId, vi2.a dataSupport, vi2.c playFunc, Object msg2) {
        NormalFloatingBannerItemView normalFloatingBannerItemView;
        NormalFloatingBannerItemView normalFloatingBannerItemView2 = this.floatingBannerItemView;
        if (normalFloatingBannerItemView2 != null) {
            normalFloatingBannerItemView2.setRoomId(roomId);
            normalFloatingBannerItemView2.setSupportFunc(dataSupport, playFunc);
        }
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.b) {
            NormalFloatingBannerItemView normalFloatingBannerItemView3 = this.floatingBannerItemView;
            if (normalFloatingBannerItemView3 != null) {
                normalFloatingBannerItemView3.D((com.tencent.mobileqq.qqlive.widget.chat.message.b) msg2, this.anchorId);
                return;
            }
            return;
        }
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.g) {
            NormalFloatingBannerItemView normalFloatingBannerItemView4 = this.floatingBannerItemView;
            if (normalFloatingBannerItemView4 != null) {
                normalFloatingBannerItemView4.F((com.tencent.mobileqq.qqlive.widget.chat.message.g) msg2, this.anchorId);
                return;
            }
            return;
        }
        if ((msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.c) && (normalFloatingBannerItemView = this.floatingBannerItemView) != null) {
            normalFloatingBannerItemView.E((com.tencent.mobileqq.qqlive.widget.chat.message.c) msg2, this.anchorId, new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.message.stack.NormalFloatingBannerLogic$updateBannerContent$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean visible) {
        if (visible) {
            NormalFloatingBannerItemView normalFloatingBannerItemView = this.floatingBannerItemView;
            if (normalFloatingBannerItemView != null) {
                normalFloatingBannerItemView.setVisibility(0);
                return;
            }
            return;
        }
        NormalFloatingBannerItemView normalFloatingBannerItemView2 = this.floatingBannerItemView;
        if (normalFloatingBannerItemView2 != null) {
            normalFloatingBannerItemView2.setVisibility(4);
        }
    }

    public final void h(@NotNull Context context, @NotNull FrameLayout container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        this.bannerContainer = container;
        this.floatingBannerItemView = new NormalFloatingBannerItemView(context);
        FrameLayout frameLayout = this.bannerContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(this.floatingBannerItemView);
        }
    }

    public final void i(boolean isLandscape) {
        AegisLogger.INSTANCE.i("Float_Banner|NormalFloatingBannerLogic", "onConfigurationChanged isLandscape:" + isLandscape);
        this.isLandscape = isLandscape;
        n(isLandscape ^ true);
    }

    public final void j(long roomId, long anchorId) {
        this.roomId = roomId;
        this.anchorId = anchorId;
        SimpleEventBus.getInstance().registerReceiver(this.receiver);
    }

    public final void k() {
        SimpleEventBus.getInstance().unRegisterReceiver(this.receiver);
        RFWThreadManager.getUIHandler().removeCallbacks(this.hideRunnable);
        FrameLayout frameLayout = this.bannerContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        FrameLayout frameLayout2 = this.bannerContainer;
        if (frameLayout2 != null) {
            frameLayout2.clearAnimation();
        }
        FrameLayout frameLayout3 = this.bannerContainer;
        if (frameLayout3 != null) {
            frameLayout3.removeAllViews();
        }
        this.bannerContainer = null;
    }

    public final void l(long roomId, @NotNull vi2.a dataSupport, @NotNull vi2.c playFunc, @NotNull Object msg2) {
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        RFWThreadManager.getUIHandler().removeCallbacks(this.hideRunnable);
        m(roomId, dataSupport, playFunc, msg2);
        if (!this.bannerIsShowing) {
            this.bannerIsShowing = true;
            FrameLayout frameLayout = this.bannerContainer;
            if (frameLayout != null) {
                frameLayout.startAnimation(f());
            }
        }
        RFWThreadManager.getUIHandler().postDelayed(this.hideRunnable, e());
    }
}
