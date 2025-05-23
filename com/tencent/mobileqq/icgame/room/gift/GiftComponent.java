package com.tencent.mobileqq.icgame.room.gift;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import av0.l;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftPanelEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.api.room.QQLiveGiftSDKConfigHelper;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import i22.g;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ab\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003HKN\u0018\u0000 \"2\u00020\u0001:\u0001UB\u000f\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020!J\u0006\u0010#\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u0006\u0010(\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R#\u00106\u001a\n 1*\u0004\u0018\u000100008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010AR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010O\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/gift/GiftComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", "v", "", "L", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "msg", "", "u", HippyTKDListViewAdapter.X, "giftMessage", "M", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "animTotalData", "w", "", "t", "y", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftEvent;", "simpleBaseEvent", "H", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftPanelEvent;", "event", "I", "J", "isVisible", "K", "k", "i", "Li22/h;", "G", "E", "Li22/g;", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "", "state", "D", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/res/Configuration;", "newConfig", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lfu0/c;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lfu0/c;", "liveRoomService", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "liveLikeViewService", "Lcom/tencent/mobileqq/icgame/room/likeowner/a;", "Lb42/b;", "audienceSupport", "Lb42/b;", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", h.F, "Z", "hasInit", MiniChatConstants.MINI_APP_LANDSCAPE, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "mGiftAnimationEngine", "com/tencent/mobileqq/icgame/room/gift/GiftComponent$b", "Lcom/tencent/mobileqq/icgame/room/gift/GiftComponent$b;", "giftEventReceiver", "com/tencent/mobileqq/icgame/room/gift/GiftComponent$c", "Lcom/tencent/mobileqq/icgame/room/gift/GiftComponent$c;", "giftPanelEventReceiver", "com/tencent/mobileqq/icgame/room/gift/GiftComponent$d", "Lcom/tencent/mobileqq/icgame/room/gift/GiftComponent$d;", "mReceiveGiftMessageListener", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GiftComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b giftEventReceiver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c giftPanelEventReceiver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final d mReceiveGiftMessageListener;

    @InjectService(key = b42.b.class)
    private b42.b audienceSupport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    @InjectService(key = com.tencent.mobileqq.icgame.room.likeowner.a.class)
    private com.tencent.mobileqq.icgame.room.likeowner.a liveLikeViewService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.b mGiftAnimationEngine;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/gift/GiftComponent$b", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements SimpleEventReceiver<TimiGiftEvent> {
        b() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<TimiGiftEvent>> getEventClass() {
            ArrayList<Class<TimiGiftEvent>> arrayList = new ArrayList<>();
            arrayList.add(TimiGiftEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof TimiGiftEvent) {
                GiftComponent.this.H((TimiGiftEvent) event);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/gift/GiftComponent$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/icgame/game/gift/impl/timi/TimiGiftPanelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements SimpleEventReceiver<TimiGiftPanelEvent> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<TimiGiftPanelEvent>> getEventClass() {
            ArrayList<Class<TimiGiftPanelEvent>> arrayList = new ArrayList<>();
            arrayList.add(TimiGiftPanelEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof TimiGiftPanelEvent) {
                TimiGiftPanelEvent timiGiftPanelEvent = (TimiGiftPanelEvent) event;
                if (timiGiftPanelEvent.getRoomId() == GiftComponent.this.t()) {
                    GiftComponent.this.I(timiGiftPanelEvent);
                    GiftComponent.this.J(timiGiftPanelEvent);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/room/gift/GiftComponent$d", "Lv22/a;", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "giftMessage", "", "a", "", "code", "", "msg", "onError", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements v22.a {
        d() {
        }

        @Override // v22.a
        public void a(@Nullable GiftMessage giftMessage) {
            a.Companion companion = rt0.a.INSTANCE;
            companion.k("ICGameGift", "onGiftMessageReceive", "receive gift msg: " + giftMessage);
            if (giftMessage == null) {
                return;
            }
            LiveUserInfo selfUserInfo = GiftComponent.this.s().getSelfUserInfo();
            if (selfUserInfo == null) {
                companion.k("ICGameGift", "onGiftMessageReceive", "self info none");
                return;
            }
            if (giftMessage.sender == selfUserInfo.uid && giftMessage.comboSeq != 0) {
                companion.k("ICGameGift", "onGiftMessageReceive", "receive self gift msg");
                return;
            }
            if (!giftMessage.comboOver) {
                GiftComponent.this.M(giftMessage);
                return;
            }
            companion.k("ICGameGift", "onGiftMessageReceive", "git combo over, gift_id=" + giftMessage.giftID + ", gift_name=" + giftMessage.giftName);
        }

        @Override // v22.a
        public void onError(int code, @Nullable String msg2) {
            GiftComponent.this.log.e("ICGameGift", GiftComponent.this.t() + " GiftMessageListener onError, code " + code + ", msg " + msg2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.mobileqq.icgame.room.gift.GiftComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.giftEventReceiver = new b();
        this.giftPanelEventReceiver = new c();
        this.mReceiveGiftMessageListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(TimiGiftEvent simpleBaseEvent) {
        if (this.hasInit && t() == simpleBaseEvent.getRoomId() && L()) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a a16 = lx0.a.a(simpleBaseEvent.getGiftMsg());
            a16.f264916g = 100;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.mGiftAnimationEngine;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
                bVar = null;
            }
            bVar.d(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(TimiGiftPanelEvent event) {
        b42.b bVar = null;
        if (event.getCmd() == 2) {
            rt0.a.INSTANCE.k("ICGameGift", "resetGiftBannerContainer", "gift panel hide");
            b42.b bVar2 = this.audienceSupport;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            } else {
                bVar = bVar2;
            }
            LinearLayout b16 = bVar.b();
            if (b16 != null) {
                ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(2, R.id.xcx);
                layoutParams2.addRule(12, 0);
                layoutParams2.leftMargin = ViewUtils.dpToPx(0.0f);
                layoutParams2.bottomMargin = ViewUtils.dpToPx(28.0f);
                b16.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        if (event.getCmd() == 1) {
            rt0.a.INSTANCE.k("ICGameGift", "resetGiftBannerContainer", "gift panel show, gift_panel_height=" + event.getPanelHeight() + ", screen_height=" + ViewUtils.getScreenHeight());
            b42.b bVar3 = this.audienceSupport;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            } else {
                bVar = bVar3;
            }
            LinearLayout b17 = bVar.b();
            if (b17 != null) {
                b17.getLocationOnScreen(new int[2]);
                if ((ViewUtils.getScreenHeight() / 2) - ViewUtils.dip2px(39.0f) < event.getPanelHeight() && !this.isLandscape) {
                    ViewGroup.LayoutParams layoutParams3 = b17.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    layoutParams4.addRule(12);
                    layoutParams4.leftMargin = ViewUtils.dpToPx(0.0f);
                    layoutParams4.bottomMargin = event.getPanelHeight() + ViewUtils.dip2px(10.0f);
                    b17.setLayoutParams(layoutParams4);
                    return;
                }
                y32.d.I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(TimiGiftPanelEvent event) {
        if (event.getCmd() == 2) {
            com.tencent.mobileqq.icgame.room.likeowner.a aVar = this.liveLikeViewService;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveLikeViewService");
                aVar = null;
            }
            aVar.a(false);
        }
    }

    private final void K(boolean isVisible) {
        int i3;
        b42.b bVar = this.audienceSupport;
        b42.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            bVar = null;
        }
        LinearLayout b16 = bVar.b();
        int i16 = 0;
        if (b16 != null) {
            if (isVisible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            b16.setVisibility(i3);
        }
        b42.b bVar3 = this.audienceSupport;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
        } else {
            bVar2 = bVar3;
        }
        FrameLayout h16 = bVar2.h();
        if (h16 != null) {
            if (!isVisible) {
                i16 = 8;
            }
            h16.setVisibility(i16);
        }
    }

    private final boolean L() {
        boolean c16 = hw0.a.f406502a.c();
        rt0.a.INSTANCE.k("ICGameGift", "showGiftAniLog", "isLandScape " + x() + ", isSwitchOpen " + c16);
        if (!x()) {
            return true;
        }
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(GiftMessage giftMessage) {
        if (!this.hasInit || !L()) {
            return;
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, u(giftMessage));
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a animTotalData = a.a(giftMessage);
        Intrinsics.checkNotNullExpressionValue(animTotalData, "animTotalData");
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = null;
        if (!w(animTotalData)) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = this.mGiftAnimationEngine;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
            } else {
                bVar = bVar2;
            }
            bVar.d(animTotalData);
            return;
        }
        for (int i3 = animTotalData.f264915f - 1; -1 < i3; i3--) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a a16 = a.a(giftMessage);
            a16.f264915f = 1;
            int i16 = a16.f264926q - i3;
            a16.f264926q = i16;
            a16.f264928s = i16;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar3 = this.mGiftAnimationEngine;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
                bVar3 = null;
            }
            bVar3.d(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final fu0.c s() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long t() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        return aVar.getRoomId();
    }

    private final String u(GiftMessage msg2) {
        int sceneId = msg2.getSceneId();
        if (sceneId <= 0) {
            sceneId = QQLiveSDKConfigHelper.getSceneId();
        }
        return String.valueOf(sceneId);
    }

    private final void v() {
        if (this.hasInit) {
            return;
        }
        h22.a aVar = this.qqLiveRoomService;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        this.log.i("ICGameGift", "initGiftEngine, roomId " + roomId);
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveGiftSDKConfigHelper.INSTANCE.getSceneIdAuto(Long.valueOf(roomId)));
        if (!sDKImpl.isInited()) {
            this.log.i("ICGameGift", "giftSdk not init");
            return;
        }
        if (sDKImpl.isDestroyed()) {
            this.log.i("ICGameGift", "giftSdk is destroyed");
            return;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b A = sDKImpl.d().A(getComponentContext().getContext(), 1);
        Intrinsics.checkNotNullExpressionValue(A, "giftSDK.viewModule.creat\u2026E_DOUBLE_BANNER\n        )");
        this.mGiftAnimationEngine = A;
        if (A == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
        } else {
            bVar = A;
        }
        bVar.prepare();
        this.hasInit = true;
    }

    private final boolean w(com.tencent.mobileqq.qqgift.mvvm.business.anim.a animTotalData) {
        int i3;
        int i16;
        if (animTotalData.f264924o != 1 || (i3 = animTotalData.f264915f) > 5 || (i16 = animTotalData.f264926q) <= 1 || i16 < i3) {
            return false;
        }
        return true;
    }

    private final boolean x() {
        if (getComponentContext().getContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private final void y(String msg2) {
        IAegisLogApi iAegisLogApi = this.log;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iAegisLogApi.i("ICGameGift", "roomId " + aVar.getRoomId() + " " + msg2);
    }

    public final void A(@NotNull Configuration newConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        y("onConfigurationChanged, isLandscape " + z16);
        if (this.isLandscape == z16) {
            return;
        }
        this.isLandscape = z16;
        b42.b bVar = null;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = null;
        if (z16 && !com.tencent.icgame.game.liveroom.impl.room.util.b.c(getComponentContext().getContext())) {
            b42.b bVar3 = this.audienceSupport;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
                bVar3 = null;
            }
            FrameLayout h16 = bVar3.h();
            if (h16 != null) {
                h16.setVisibility(4);
            }
            b42.b bVar4 = this.audienceSupport;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
                bVar4 = null;
            }
            LinearLayout b16 = bVar4.b();
            if (b16 != null) {
                ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(2, 0);
                layoutParams2.addRule(12);
                layoutParams2.leftMargin = ViewUtils.dpToPx(47.0f);
                layoutParams2.bottomMargin = ViewUtils.dpToPx(62.0f);
                b16.setLayoutParams(layoutParams2);
            }
            if (!L() && this.hasInit) {
                com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar5 = this.mGiftAnimationEngine;
                if (bVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
                } else {
                    bVar2 = bVar5;
                }
                bVar2.reset();
            }
        } else {
            b42.b bVar6 = this.audienceSupport;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
                bVar6 = null;
            }
            FrameLayout h17 = bVar6.h();
            if (h17 != null) {
                h17.setVisibility(0);
            }
            b42.b bVar7 = this.audienceSupport;
            if (bVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            } else {
                bVar = bVar7;
            }
            LinearLayout b17 = bVar.b();
            if (b17 != null) {
                ViewGroup.LayoutParams layoutParams3 = b17.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                layoutParams4.addRule(2, R.id.xcx);
                layoutParams4.addRule(12, 0);
                layoutParams4.leftMargin = ViewUtils.dpToPx(0.0f);
                layoutParams4.bottomMargin = ViewUtils.dpToPx(28.0f);
                b17.setLayoutParams(layoutParams4);
            }
        }
        l.INSTANCE.b();
    }

    public final void B() {
        SimpleEventBus.getInstance().registerReceiver(this.giftEventReceiver);
        SimpleEventBus.getInstance().registerReceiver(this.giftPanelEventReceiver);
        ILiveRoomMessage k3 = s().k(t());
        if (k3 != null) {
            k3.registerReceiveGiftMessageListener(this.mReceiveGiftMessageListener);
        }
        h22.a aVar = this.qqLiveRoomService;
        Integer num = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        LiveInfo curLiveInfo = aVar.getCurLiveInfo();
        if (curLiveInfo != null) {
            h22.a aVar2 = this.qqLiveRoomService;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar2 = null;
            }
            LiveRoomExtraInfo extraInfo = aVar2.getExtraInfo();
            if (extraInfo != null) {
                num = Integer.valueOf(extraInfo.f114883h);
            }
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).preloadGiftRes(QQLiveSDKConfigHelper.getSceneId(), 1, String.valueOf(num), String.valueOf(curLiveInfo.anchorInfo.uid), true);
        }
    }

    public final void C() {
        l.INSTANCE.b();
        SimpleEventBus.getInstance().unRegisterReceiver(this.giftEventReceiver);
        SimpleEventBus.getInstance().unRegisterReceiver(this.giftPanelEventReceiver);
    }

    public final void D(int state) {
        boolean z16 = true;
        if (state != 1) {
            z16 = false;
        }
        K(z16);
    }

    public final void F(@NotNull g event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ILiveRoomMessage k3 = s().k(t());
        if (k3 != null) {
            k3.unRegisterReceiveGiftMessageListener(this.mReceiveGiftMessageListener);
        }
    }

    public final void G(@NotNull i22.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        v();
        if (!this.hasInit) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.bottomMargin = o42.a.a(4);
        b42.b bVar = this.audienceSupport;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            bVar = null;
        }
        LinearLayout b16 = bVar.b();
        if (b16 != null) {
            y("init GiftBannerContainer");
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar3 = this.mGiftAnimationEngine;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
                bVar3 = null;
            }
            b16.addView(bVar3.b(), marginLayoutParams);
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar4 = this.mGiftAnimationEngine;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
                bVar4 = null;
            }
            b16.addView(bVar4.i(), new ViewGroup.MarginLayoutParams(-2, -2));
        }
        b42.b bVar5 = this.audienceSupport;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            bVar5 = null;
        }
        FrameLayout h16 = bVar5.h();
        if (h16 != null) {
            y("init GiftEffectContainer");
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar6 = this.mGiftAnimationEngine;
            if (bVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
            } else {
                bVar2 = bVar6;
            }
            h16.addView(bVar2.k(), new RelativeLayout.LayoutParams(-1, -2));
        }
        l.INSTANCE.c();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        this.isLandscape = x();
    }

    public final void z() {
        if (!this.hasInit) {
            return;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.mGiftAnimationEngine;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGiftAnimationEngine");
            bVar = null;
        }
        bVar.release();
    }

    public final void E() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }
}
