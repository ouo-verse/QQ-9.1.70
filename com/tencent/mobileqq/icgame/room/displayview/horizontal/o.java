package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController;
import com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView;
import com.tencent.icgame.liveroom.impl.room.live.widget.BottomControllerView;
import com.tencent.icgame.liveroom.impl.room.live.widget.HorBottomControllerView;
import com.tencent.icgame.liveroom.impl.room.live.widget.TopControllerView;
import com.tencent.icgame.liveroom.impl.room.widget.GiftEntranceView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.framework.component.SingleUIComponent;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.displayview.horizontal.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rv0.AutoCollapseViewExpanded;
import rv0.DefinitionNeedChangeEvent;
import rv0.SoftKeyBoardStateEvent;

/* compiled from: P */
@ComponentEvent(eventList = {DefinitionNeedChangeEvent.class, AutoCollapseViewExpanded.class, SoftKeyBoardStateEvent.class})
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010n\u001a\u00020m\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002J\n\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020)H\u0002R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010AR\u0016\u0010D\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\rR\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\rR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010k\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/o;", "Lcom/tencent/mobileqq/icgame/framework/component/SingleUIComponent;", "Landroid/view/View;", DomainData.DOMAIN_NAME, "", "k", "i", "", "a", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i0", "b0", "Z", "a0", "V", "W", "Ld42/g;", "event", "c0", "U", ExifInterface.LATITUDE_SOUTH, "T", BdhLogUtil.LogTag.Tag_Req, "X", "P", MiniChatConstants.MINI_APP_LANDSCAPE, "Y", "H", "show", "j0", "", "J", "k0", "l0", "forceAutoCollapse", "E", "visibility", "d0", "e0", "h0", "", "I", "forbidExpose", "g0", "msg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/icgame/common/api/IAegisLogApi;", tl.h.F, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lb42/b;", "audienceComponent", "Lb42/b;", "Lcom/tencent/mobileqq/icgame/room/gift/c;", "giftEntranceService", "Lcom/tencent/mobileqq/icgame/room/gift/c;", "Lcom/tencent/mobileqq/icgame/room/displayview/definition/c;", "definitionService", "Lcom/tencent/mobileqq/icgame/room/displayview/definition/c;", "isPageIn", "Landroid/content/Context;", "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "videoLandscape", "D", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b;", "autoCollapseController", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/CustomDanmakuView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/CustomDanmakuView;", "customDanmakuView", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/f;", "G", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/f;", "horDanmakuController", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/TopControllerView;", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/TopControllerView;", "topControllerView", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/BottomControllerView;", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/BottomControllerView;", "bottomControllerView", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/q;", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/q;", "verBottomViewController", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "K", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/HorBottomControllerView;", "bottomControllerViewHor", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/d;", "L", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/d;", "horBottomViewController", "Ldw0/d;", "M", "Ldw0/d;", "horBottomGiftEntranceController", "Lfu0/c;", "N", "Lfu0/c;", "liveRoomService", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$c;", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$c;", "definitionListener", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class o extends SingleUIComponent<View> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean videoLandscape;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.room.displayview.horizontal.b autoCollapseController;

    /* renamed from: F, reason: from kotlin metadata */
    private CustomDanmakuView customDanmakuView;

    /* renamed from: G, reason: from kotlin metadata */
    private f horDanmakuController;

    /* renamed from: H, reason: from kotlin metadata */
    private TopControllerView topControllerView;

    /* renamed from: I, reason: from kotlin metadata */
    private BottomControllerView bottomControllerView;

    /* renamed from: J, reason: from kotlin metadata */
    private q verBottomViewController;

    /* renamed from: K, reason: from kotlin metadata */
    private HorBottomControllerView bottomControllerViewHor;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.icgame.room.displayview.horizontal.d horBottomViewController;

    /* renamed from: M, reason: from kotlin metadata */
    private dw0.d horBottomGiftEntranceController;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private fu0.c liveRoomService;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final DefinitionController.c definitionListener;

    @InjectService(key = b42.b.class)
    private b42.b audienceComponent;

    @InjectService(key = com.tencent.mobileqq.icgame.room.displayview.definition.c.class)
    private com.tencent.mobileqq.icgame.room.displayview.definition.c definitionService;

    @InjectService(key = com.tencent.mobileqq.icgame.room.gift.c.class)
    private com.tencent.mobileqq.icgame.room.gift.c giftEntranceService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPageIn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/o$b", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$c;", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements b.c {
        b() {
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.horizontal.b.c
        public boolean a() {
            if (o.this.isLandscape) {
                com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = o.this.horBottomViewController;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
                    dVar = null;
                }
                if (dVar.g() == 1) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/o$c", "Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/b$b;", "", "a", "b", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements b.InterfaceC7928b {
        c() {
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.horizontal.b.InterfaceC7928b
        public void a() {
            if (o.this.isLandscape) {
                o.this.getComponentContext().w0(new DefinitionNeedChangeEvent(o.this.J(), false));
            }
            o.this.getComponentContext().w0(new AutoCollapseViewExpanded(o.this.J(), false));
        }

        @Override // com.tencent.mobileqq.icgame.room.displayview.horizontal.b.InterfaceC7928b
        public void b() {
            o.this.getComponentContext().w0(new AutoCollapseViewExpanded(o.this.J(), true));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/displayview/horizontal/o$d", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/d;", "", "text", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements com.tencent.icgame.liveroom.impl.room.live.widget.d {
        d() {
        }

        @Override // com.tencent.icgame.liveroom.impl.room.live.widget.d
        public void a(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            b42.b bVar = o.this.audienceComponent;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audienceComponent");
                bVar = null;
            }
            bVar.g(text);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull f32.a componentContext) {
        super(componentContext);
        boolean z16;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        Context context = componentContext.getContext();
        this.context = context;
        if (context.getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isLandscape = z16;
        this.autoCollapseController = new com.tencent.mobileqq.icgame.room.displayview.horizontal.b();
        mm4.a b16 = qx0.a.b(fu0.c.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ITgLiveRoomService::class.java)");
        this.liveRoomService = (fu0.c) b16;
        this.definitionListener = new DefinitionController.c() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.m
            @Override // com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.c
            public final void a(EnterRoomInfo.VideoDefinition videoDefinition, String str) {
                o.G(o.this, videoDefinition, str);
            }
        };
    }

    private final void E(boolean forceAutoCollapse) {
        HorBottomControllerView horBottomControllerView = null;
        if (this.isLandscape) {
            e0(8);
            h0(0);
            d0(0);
            HorBottomControllerView horBottomControllerView2 = this.bottomControllerViewHor;
            if (horBottomControllerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
                horBottomControllerView2 = null;
            }
            horBottomControllerView2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.F(o.this);
                }
            }, 1000L);
            com.tencent.mobileqq.icgame.room.displayview.horizontal.b bVar = this.autoCollapseController;
            TopControllerView topControllerView = this.topControllerView;
            if (topControllerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
                topControllerView = null;
            }
            HorBottomControllerView horBottomControllerView3 = this.bottomControllerViewHor;
            if (horBottomControllerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            } else {
                horBottomControllerView = horBottomControllerView3;
            }
            bVar.o(topControllerView, horBottomControllerView);
            if (this.isPageIn) {
                this.autoCollapseController.r();
                return;
            }
            return;
        }
        if (this.videoLandscape) {
            h0(8);
            d0(8);
            e0(0);
            com.tencent.mobileqq.icgame.room.displayview.horizontal.b bVar2 = this.autoCollapseController;
            BottomControllerView bottomControllerView = this.bottomControllerView;
            if (bottomControllerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControllerView");
                bottomControllerView = null;
            }
            bVar2.o(null, bottomControllerView);
            if (this.isPageIn || forceAutoCollapse) {
                this.autoCollapseController.r();
                return;
            }
            return;
        }
        e0(8);
        h0(8);
        d0(8);
        this.autoCollapseController.o(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = this$0.horBottomViewController;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar = null;
        }
        dVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(o this$0, EnterRoomInfo.VideoDefinition videoDefinition, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q("updateDefinitionText " + str);
        q qVar = this$0.verBottomViewController;
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verBottomViewController");
            qVar = null;
        }
        qVar.a(str);
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = this$0.horBottomViewController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
        } else {
            dVar = dVar2;
        }
        dVar.o(str);
    }

    private final String I() {
        return com.tencent.icgame.game.liveroom.impl.room.definition.b.e(com.tencent.icgame.game.liveroom.impl.room.definition.b.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long J() {
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        return aVar.getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b42.b bVar = this$0.audienceComponent;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceComponent");
            bVar = null;
        }
        bVar.c(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.icgame.room.gift.c cVar = this$0.giftEntranceService;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("giftEntranceService");
            cVar = null;
        }
        cVar.showGiftPanel();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.icgame.room.displayview.definition.c cVar = this$0.definitionService;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionService");
            cVar = null;
        }
        cVar.c();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getComponentContext().getContext();
        long J = this$0.J();
        h22.a aVar = this$0.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        yw0.h.x(context, J, aVar.getExtraInfo());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = this$0.horBottomViewController;
        b42.b bVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar = null;
        }
        dVar.j();
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = this$0.horBottomViewController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar2 = null;
        }
        dVar2.k();
        b42.b bVar2 = this$0.audienceComponent;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceComponent");
        } else {
            bVar = bVar2;
        }
        bVar.c(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q(String msg2) {
        IAegisLogApi iAegisLogApi = this.log;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iAegisLogApi.i("ICGameHorizontalCtrlComponent", "roomId " + aVar.getRoomId() + " " + msg2);
    }

    private final void d0(int visibility) {
        HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
        if (horBottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView = null;
        }
        horBottomControllerView.setVisibility(visibility);
    }

    private final void e0(final int visibility) {
        BottomControllerView bottomControllerView = this.bottomControllerView;
        if (bottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerView");
            bottomControllerView = null;
        }
        bottomControllerView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.n
            @Override // java.lang.Runnable
            public final void run() {
                o.f0(o.this, visibility);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(o this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomControllerView bottomControllerView = this$0.bottomControllerView;
        if (bottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerView");
            bottomControllerView = null;
        }
        bottomControllerView.setVisibility(i3);
    }

    private final void g0(boolean forbidExpose) {
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = this.horBottomViewController;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar = null;
        }
        dVar.l(forbidExpose);
    }

    private final void h0(int visibility) {
        TopControllerView topControllerView = this.topControllerView;
        if (topControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView = null;
        }
        topControllerView.setVisibility(visibility);
    }

    private final void k0() {
        this.isLandscape = true;
        E(true);
        dw0.d dVar = this.horBottomGiftEntranceController;
        TopControllerView topControllerView = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        dVar.o(true);
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = this.horBottomViewController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar2 = null;
        }
        dVar2.i();
        f fVar = this.horDanmakuController;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.l();
        TopControllerView topControllerView2 = this.topControllerView;
        if (topControllerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
        } else {
            topControllerView = topControllerView2;
        }
        topControllerView.setIsVerMode(false);
    }

    private final void l0() {
        this.isLandscape = false;
        E(true);
        dw0.d dVar = this.horBottomGiftEntranceController;
        TopControllerView topControllerView = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        dVar.o(false);
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = this.horBottomViewController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
            dVar2 = null;
        }
        dVar2.j();
        f fVar = this.horDanmakuController;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.m();
        TopControllerView topControllerView2 = this.topControllerView;
        if (topControllerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
        } else {
            topControllerView = topControllerView2;
        }
        topControllerView.setIsVerMode(true);
    }

    @NotNull
    public final View H() {
        View definitionButton;
        View view = null;
        if (this.isLandscape) {
            HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
            if (horBottomControllerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            } else {
                view = horBottomControllerView;
            }
            definitionButton = view.findViewById(R.id.ufs);
        } else {
            BottomControllerView bottomControllerView = this.bottomControllerView;
            if (bottomControllerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomControllerView");
            } else {
                view = bottomControllerView;
            }
            definitionButton = view.findViewById(R.id.ufs);
        }
        Intrinsics.checkNotNullExpressionValue(definitionButton, "definitionButton");
        return definitionButton;
    }

    public final boolean P() {
        View findViewById = p().findViewById(R.id.vog);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void R() {
        TopControllerView topControllerView = this.topControllerView;
        f fVar = null;
        if (topControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView = null;
        }
        topControllerView.release();
        f fVar2 = this.horDanmakuController;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
        } else {
            fVar = fVar2;
        }
        fVar.d();
    }

    public final void S() {
        f fVar = this.horDanmakuController;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.e();
    }

    public final void T() {
        f fVar = this.horDanmakuController;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.f();
    }

    public final void U() {
        long J = J();
        this.log.i("ICGameHorizontalCtrlComponent", "roomId " + J + ", onDynamicConfigReady");
        dw0.d dVar = this.horBottomGiftEntranceController;
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        dVar.k(J);
        f fVar = this.horDanmakuController;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.h(J);
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar3 = this.horBottomViewController;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
        } else {
            dVar2 = dVar3;
        }
        dVar2.h(J);
    }

    public final void V() {
        Q("onEnterRoom");
        long J = J();
        dw0.d dVar = this.horBottomGiftEntranceController;
        f fVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        dVar.m(J);
        HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
        if (horBottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView = null;
        }
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        horBottomControllerView.N0(J, aVar.getRoomType());
        TopControllerView topControllerView = this.topControllerView;
        if (topControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView = null;
        }
        topControllerView.A0(J, false);
        f fVar2 = this.horDanmakuController;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
        } else {
            fVar = fVar2;
        }
        fVar.i(J);
    }

    public final void W() {
        TopControllerView topControllerView = this.topControllerView;
        dw0.d dVar = null;
        if (topControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView = null;
        }
        topControllerView.B0(J());
        HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
        if (horBottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView = null;
        }
        horBottomControllerView.O0();
        dw0.d dVar2 = this.horBottomGiftEntranceController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
        } else {
            dVar = dVar2;
        }
        dVar.n();
    }

    public final void X() {
        HorBottomControllerView horBottomControllerView = this.bottomControllerViewHor;
        if (horBottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView = null;
        }
        horBottomControllerView.L0();
        this.autoCollapseController.m();
    }

    public final void Y(boolean isLandscape) {
        g0(!isLandscape);
        if (isLandscape) {
            k0();
        } else {
            l0();
        }
    }

    public final void Z() {
        this.isPageIn = true;
        q qVar = this.verBottomViewController;
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verBottomViewController");
            qVar = null;
        }
        qVar.a(I());
        com.tencent.mobileqq.icgame.room.displayview.horizontal.d dVar2 = this.horBottomViewController;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomViewController");
        } else {
            dVar = dVar2;
        }
        dVar.o(I());
        this.autoCollapseController.r();
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent, com.tencent.mobileqq.icgame.framework.component.i
    public boolean a() {
        return true;
    }

    public final void a0() {
        this.isPageIn = false;
        dw0.d dVar = this.horBottomGiftEntranceController;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        dVar.p(J());
    }

    public final void b0() {
        dw0.d dVar = this.horBottomGiftEntranceController;
        h22.a aVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horBottomGiftEntranceController");
            dVar = null;
        }
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar2;
        }
        dVar.u(aVar.getExtraInfo());
    }

    public final void c0(@NotNull d42.g event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        IAegisLogApi iAegisLogApi = this.log;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iAegisLogApi.i("ICGameHorizontalCtrlComponent", "roomId " + aVar.getRoomId() + " onVideoSizeChange, width " + event.getWidth() + ", height " + event.getHeight());
        if (event.getWidth() > event.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.videoLandscape = z16;
        if (this.isLandscape) {
            k0();
        } else {
            l0();
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        this.autoCollapseController.n();
        f fVar = this.horDanmakuController;
        com.tencent.mobileqq.icgame.room.displayview.definition.c cVar = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("horDanmakuController");
            fVar = null;
        }
        fVar.g();
        com.tencent.mobileqq.icgame.room.displayview.definition.c cVar2 = this.definitionService;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionService");
        } else {
            cVar = cVar2;
        }
        cVar.a(this.definitionListener);
    }

    public final void i0() {
        this.autoCollapseController.r();
    }

    public final void j0(boolean show) {
        if (show) {
            this.autoCollapseController.k();
        } else {
            this.autoCollapseController.e();
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        Q("initComponent");
        View findViewById = p().findViewById(R.id.ucq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.custom_danmaku_view)");
        this.customDanmakuView = (CustomDanmakuView) findViewById;
        View findViewById2 = p().findViewById(R.id.f99515q0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.topControllerView)");
        TopControllerView topControllerView = (TopControllerView) findViewById2;
        this.topControllerView = topControllerView;
        com.tencent.mobileqq.icgame.room.displayview.definition.c cVar = null;
        if (topControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView = null;
        }
        topControllerView.setLifecycleOwner(getComponentContext().getLifecycleOwner());
        TopControllerView topControllerView2 = this.topControllerView;
        if (topControllerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView2 = null;
        }
        ((ImageView) topControllerView2.findViewById(R.id.xav)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.K(o.this, view);
            }
        });
        TopControllerView topControllerView3 = this.topControllerView;
        if (topControllerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topControllerView");
            topControllerView3 = null;
        }
        ((AnchorTopHeadView) topControllerView3.findViewById(R.id.sna)).setQQLive();
        View findViewById3 = p().findViewById(R.id.t9j);
        HorBottomControllerView horBottomControllerView = (HorBottomControllerView) findViewById3;
        horBottomControllerView.setComponentContext(getComponentContext());
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<HorBot\u2026entContext)\n            }");
        this.bottomControllerViewHor = horBottomControllerView;
        HorBottomControllerView horBottomControllerView2 = this.bottomControllerViewHor;
        if (horBottomControllerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView2 = null;
        }
        View findViewById4 = horBottomControllerView2.findViewById(R.id.vog);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "bottomControllerViewHor.\u2026me_game.impl.R.id.giftIv)");
        GiftEntranceView giftEntranceView = (GiftEntranceView) findViewById4;
        HorBottomControllerView horBottomControllerView3 = this.bottomControllerViewHor;
        if (horBottomControllerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView3 = null;
        }
        this.horBottomGiftEntranceController = new dw0.d(giftEntranceView, horBottomControllerView3, new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.L(o.this, view);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.M(o.this, view);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.N(o.this, view);
            }
        };
        d dVar = new d();
        HorBottomControllerView horBottomControllerView4 = this.bottomControllerViewHor;
        if (horBottomControllerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView4 = null;
        }
        this.horBottomViewController = new com.tencent.mobileqq.icgame.room.displayview.horizontal.d(horBottomControllerView4, onClickListener2, onClickListener, dVar);
        this.autoCollapseController.p(new b());
        this.autoCollapseController.q(new c());
        View findViewById5 = p().findViewById(R.id.t9i);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.bottomControllerView)");
        this.bottomControllerView = (BottomControllerView) findViewById5;
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.displayview.horizontal.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.O(o.this, view);
            }
        };
        BottomControllerView bottomControllerView = this.bottomControllerView;
        if (bottomControllerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerView");
            bottomControllerView = null;
        }
        this.verBottomViewController = new q(bottomControllerView, onClickListener3, onClickListener);
        HorBottomControllerView horBottomControllerView5 = this.bottomControllerViewHor;
        if (horBottomControllerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomControllerViewHor");
            horBottomControllerView5 = null;
        }
        ImageView danmakuIcon = (ImageView) horBottomControllerView5.findViewById(R.id.udf);
        Intrinsics.checkNotNullExpressionValue(danmakuIcon, "danmakuIcon");
        CustomDanmakuView customDanmakuView = this.customDanmakuView;
        if (customDanmakuView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customDanmakuView");
            customDanmakuView = null;
        }
        this.horDanmakuController = new f(danmakuIcon, customDanmakuView, this.liveRoomService);
        b0();
        Z();
        S();
        fu0.c cVar2 = this.liveRoomService;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        if (cVar2.H(aVar.getRoomId())) {
            V();
        }
        com.tencent.mobileqq.icgame.room.displayview.definition.c cVar3 = this.definitionService;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("definitionService");
        } else {
            cVar = cVar3;
        }
        cVar.b(this.definitionListener);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.i
    public int m() {
        return R.id.f166074yl0;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.SingleUIComponent
    @NotNull
    public View n() {
        View inflate = LayoutInflater.from(getComponentContext().getContext()).inflate(R.layout.fam, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(componentContext.ge\u2026_video_ctrl_layout, null)");
        return inflate;
    }
}
