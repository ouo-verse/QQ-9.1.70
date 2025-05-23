package dw0;

import android.view.View;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.icgame.liveroom.impl.room.live.widget.HorBottomControllerView;
import com.tencent.icgame.liveroom.impl.room.widget.GiftEntranceView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.o;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00101\u00a8\u00065"}, d2 = {"Ldw0/d;", "", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", "anchorInfo", "", "roomId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "j", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "u", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MiniChatConstants.MINI_APP_LANDSCAPE, "o", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;", "a", "Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;", "giftEntranceView", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "b", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "bottomControllerViewHor", "Landroid/view/View$OnClickListener;", "c", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "e", "J", "f", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "g", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAnchorInfo;", h.F, "Z", "enableGifViewFromConfig", "i", "enableGiftViewFromServer", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "refreshGiftTimeoutRunnable", "<init>", "(Lcom/tencent/icgame/liveroom/impl/room/widget/GiftEntranceView;Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;Landroid/view/View$OnClickListener;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final a f395081k = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GiftEntranceView giftEntranceView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HorBottomControllerView bottomControllerViewHor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View.OnClickListener onClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveRoomExtraInfo roomExtraInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveAnchorInfo anchorInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean enableGifViewFromConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean enableGiftViewFromServer;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable refreshGiftTimeoutRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Ldw0/d$a;", "", "", "TAG", "Ljava/lang/String;", "TAG_GIFT_ENTRANCE", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"dw0/d$b", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "", "code", "", "msg", "", "onFailed", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "isSpecialAnchor", "onSuccess", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements OnQueryGiftIconCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f395093b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LiveAnchorInfo f395094c;

        b(long j3, LiveAnchorInfo liveAnchorInfo) {
            this.f395093b = j3;
            this.f395094c = liveAnchorInfo;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onFailed(int code, @Nullable String msg2) {
            d.this.aegisLogger.e("ICGameHorBottomGiftEntranceController", "refreshGiftEntrance#onFailed: " + code + " " + msg2);
            d.this.enableGiftViewFromServer = true;
            d.this.t();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onSuccess(boolean canShow, boolean isSpecialAnchor) {
            if (d.this.roomId == this.f395093b) {
                LiveAnchorInfo liveAnchorInfo = d.this.anchorInfo;
                boolean z16 = false;
                if (liveAnchorInfo != null && liveAnchorInfo.getAnchorUid() == this.f395094c.getAnchorUid()) {
                    z16 = true;
                }
                if (z16) {
                    d.this.aegisLogger.e("ICGameHorBottomGiftEntranceController", "refreshGiftEntrance#onSuccess: canShow:" + canShow);
                    d.this.enableGiftViewFromServer = canShow;
                    d.this.t();
                }
            }
        }
    }

    public d(@NotNull GiftEntranceView giftEntranceView, @NotNull HorBottomControllerView bottomControllerViewHor, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(giftEntranceView, "giftEntranceView");
        Intrinsics.checkNotNullParameter(bottomControllerViewHor, "bottomControllerViewHor");
        this.giftEntranceView = giftEntranceView;
        this.bottomControllerViewHor = bottomControllerViewHor;
        this.onClickListener = onClickListener;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        this.enableGifViewFromConfig = true;
        giftEntranceView.setOnClickListener(new View.OnClickListener() { // from class: dw0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.d(d.this, view);
            }
        });
        this.refreshGiftTimeoutRunnable = new Runnable() { // from class: dw0.c
            @Override // java.lang.Runnable
            public final void run() {
                d.r(d.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d this$0, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("tag_gift_entrance") && (onClickListener = this$0.onClickListener) != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean j() {
        xw0.b bVar = xw0.b.f448881a;
        if (bVar.d() == bVar.u()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j16 = this$0.roomId;
        if (j16 == j3) {
            this$0.s();
            return;
        }
        this$0.aegisLogger.e("ICGameHorBottomGiftEntranceController", "onConfigUpdate error set:" + j3 + " cur:" + j16);
    }

    private final void q(LiveAnchorInfo anchorInfo, long roomId) {
        this.aegisLogger.i("ICGameHorBottomGiftEntranceController", "refreshGiftEntrance");
        if (this.roomExtraInfo == null) {
            e32.c.d(new Exception("roomExtraInfo is null"));
            this.aegisLogger.e("ICGameHorBottomGiftEntranceController", "roomExtraInfo is null");
            return;
        }
        if (anchorInfo == null) {
            this.aegisLogger.e("ICGameHorBottomGiftEntranceController", "anchorInfo is null");
            return;
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.refreshGiftTimeoutRunnable, 2000L);
            sDKImpl.getGiftEntranceService().needShowGiftIcon(roomId, new b(roomId, anchorInfo));
        } else {
            this.aegisLogger.e("ICGameHorBottomGiftEntranceController", "liveSdk not init");
            this.enableGiftViewFromServer = true;
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enableGiftViewFromServer = true;
        this$0.t();
    }

    private final void s() {
        this.enableGifViewFromConfig = true;
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        int i3;
        boolean z16 = false;
        this.giftEntranceView.setBackgroundResource(0);
        GiftEntranceView giftEntranceView = this.giftEntranceView;
        if (this.enableGiftViewFromServer && this.enableGifViewFromConfig && !j()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        giftEntranceView.setVisibility(i3);
        HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
        if (this.enableGiftViewFromServer && this.enableGifViewFromConfig) {
            z16 = true;
        }
        horBottomControllerView.setGiftEntranceVisibility(z16);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.refreshGiftTimeoutRunnable);
    }

    public final void k(final long roomId) {
        this.giftEntranceView.post(new Runnable() { // from class: dw0.a
            @Override // java.lang.Runnable
            public final void run() {
                d.l(d.this, roomId);
            }
        });
    }

    public final void m(long roomId) {
        this.aegisLogger.i("ICGameHorBottomGiftEntranceController", "onEnterRoom " + roomId);
        this.roomId = roomId;
        LiveAnchorInfo a16 = m.a(roomId);
        this.anchorInfo = a16;
        q(a16, roomId);
    }

    public final void n() {
        this.aegisLogger.i("ICGameHorBottomGiftEntranceController", "onExitRoom");
        this.giftEntranceView.c();
        this.giftEntranceView.setVisibility(8);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.refreshGiftTimeoutRunnable);
    }

    public final void o(boolean isLandscape) {
        this.aegisLogger.i("ICGameHorBottomGiftEntranceController", "onOrientationChange isLandscape:" + isLandscape);
        if (isLandscape) {
            this.giftEntranceView.b();
        } else {
            this.giftEntranceView.c();
        }
    }

    public final void p(long roomId) {
        this.aegisLogger.i("ICGameHorBottomGiftEntranceController", "onPageOut");
    }

    public final void u(@Nullable LiveRoomExtraInfo roomExtraInfo) {
        this.roomExtraInfo = roomExtraInfo;
    }
}
