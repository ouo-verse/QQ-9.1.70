package com.tencent.icgame.game.liveroom.impl.room.audience.preload;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController;
import com.tencent.icgame.game.liveroom.impl.room.util.i;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.IReportEnterRoom;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.PreloadSuperPlayerParams;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.timi.game.api.strategy.IPlayerStrategy;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@ComponentEvent(eventList = {ExitRoomAndPreloadSucEvent.class})
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/audience/preload/PreloadRoomComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/icgame/api/room/IcgRoomPlayerConfig;", "r", "", "msg", "u", "k", "i", "Li22/h;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "w", "y", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lfu0/c;", "f", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lfu0/c;", "liveRoomService", h.F, "Ljava/lang/String;", "t", "()Ljava/lang/String;", "B", "(Ljava/lang/String;)V", "preLoadVideoUrl", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$b;", "definitionChangedListener", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class PreloadRoomComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String preLoadVideoUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DefinitionController.b definitionChangedListener;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/audience/preload/PreloadRoomComponent$b", "Lcom/tencent/icgame/game/liveroom/impl/room/definition/DefinitionController$b;", "", "id", "Lcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo$VideoDefinition;", "definition", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends DefinitionController.b {
        b() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionController.b
        public void a(long id5, @NotNull EnterRoomInfo.VideoDefinition definition) {
            Intrinsics.checkNotNullParameter(definition, "definition");
            h22.a aVar = PreloadRoomComponent.this.qqLiveRoomService;
            h22.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar = null;
            }
            if (aVar.getRoomId() != id5 && !TextUtils.isEmpty(PreloadRoomComponent.this.getPreLoadVideoUrl())) {
                PreloadRoomComponent preloadRoomComponent = PreloadRoomComponent.this;
                h22.a aVar3 = preloadRoomComponent.qqLiveRoomService;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar3 = null;
                }
                long roomId = aVar3.getRoomId();
                String preLoadVideoUrl = PreloadRoomComponent.this.getPreLoadVideoUrl();
                h22.a aVar4 = PreloadRoomComponent.this.qqLiveRoomService;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar4 = null;
                }
                String j3 = com.tencent.icgame.game.liveroom.impl.room.definition.b.j(roomId, preLoadVideoUrl, aVar4.getExtraInfo());
                Intrinsics.checkNotNullExpressionValue(j3, "getVideoUrl(\n           \u2026aInfo()\n                )");
                preloadRoomComponent.B(j3);
                PreloadRoomComponent preloadRoomComponent2 = PreloadRoomComponent.this;
                preloadRoomComponent2.u("onDefinitionChanged, videoUrl " + preloadRoomComponent2.getPreLoadVideoUrl());
                fu0.c s16 = PreloadRoomComponent.this.s();
                h22.a aVar5 = PreloadRoomComponent.this.qqLiveRoomService;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                } else {
                    aVar2 = aVar5;
                }
                if (!s16.H(aVar2.getRoomId())) {
                    PreloadRoomComponent.this.A();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadRoomComponent(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.audience.preload.PreloadRoomComponent$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.preLoadVideoUrl = "";
        this.context = componentContext.getContext();
        this.definitionChangedListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        boolean isWifiConnected = NetworkUtil.isWifiConnected(this.context);
        boolean isPreloadEnable = ((IPlayerStrategy) QRoute.api(IPlayerStrategy.class)).isPreloadEnable();
        u("preloadVideo, isWifi " + isWifiConnected + ", isPreloadEnable " + isPreloadEnable);
        if (isWifiConnected && isPreloadEnable) {
            q();
        }
    }

    private final void q() {
        s().E1(r());
        IReportEnterRoom iReportEnterRoom = (IReportEnterRoom) QRoute.api(IReportEnterRoom.class);
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iReportEnterRoom.reportQQLiveVideoFormat(aVar.getRoomId(), this.preLoadVideoUrl, true);
    }

    private final IcgRoomPlayerConfig r() {
        int i3;
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        if (aVar.getRoomType() == 0) {
            i3 = 2;
        } else {
            h22.a aVar3 = this.qqLiveRoomService;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar3 = null;
            }
            aVar3.getRoomType();
            i3 = 0;
        }
        h22.a aVar4 = this.qqLiveRoomService;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar4 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar4.getExtraInfo();
        this.log.i("ICGamePreloadRoomComponent", "extraInfo extraInfo:" + extraInfo);
        int i16 = StreamType.NONE.value;
        if (extraInfo != null) {
            i16 = extraInfo.a("streamtype", 0);
        }
        int i17 = i16;
        PreloadSuperPlayerParams a16 = com.tencent.icgame.game.liveroom.impl.room.util.h.a(i3, true, this.preLoadVideoUrl, extraInfo);
        PreloadTRTCPlayerParams a17 = i.a(extraInfo);
        h22.a aVar5 = this.qqLiveRoomService;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar5 = null;
        }
        long roomId = aVar5.getRoomId();
        h22.a aVar6 = this.qqLiveRoomService;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar6;
        }
        return new IcgRoomPlayerConfig(roomId, aVar2.getRoomType(), i17, a16, a17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final fu0.c s() {
        Object value = this.liveRoomService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-liveRoomService>(...)");
        return (fu0.c) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String msg2) {
        IAegisLogApi iAegisLogApi = this.log;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iAegisLogApi.i("ICGamePreloadRoomComponent", "roomId " + aVar.getRoomId() + " " + msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(PreloadRoomComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f32.a componentContext = this$0.getComponentContext();
        h22.a aVar = this$0.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        componentContext.w0(new ExitRoomAndPreloadSucEvent(aVar.getRoomId(), this$0.preLoadVideoUrl));
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.preLoadVideoUrl = str;
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        DefinitionController.F(this.definitionChangedListener);
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
        DefinitionController.w(this.definitionChangedListener);
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getPreLoadVideoUrl() {
        return this.preLoadVideoUrl;
    }

    public final void v() {
        LiveWatchMediaInfo liveWatchMediaInfo;
        LiveWatchMediaInfo liveWatchMediaInfo2;
        IReportEnterRoom iReportEnterRoom = (IReportEnterRoom) QRoute.api(IReportEnterRoom.class);
        h22.a aVar = this.qqLiveRoomService;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        iReportEnterRoom.reportQQLiveVideoFormat(aVar.getRoomId(), this.preLoadVideoUrl, false);
        if (TextUtils.isEmpty(this.preLoadVideoUrl)) {
            h22.a aVar2 = this.qqLiveRoomService;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                aVar2 = null;
            }
            LiveInfo curLiveInfo = aVar2.getCurLiveInfo();
            if (curLiveInfo != null) {
                liveWatchMediaInfo = curLiveInfo.watchMediaInfo;
            } else {
                liveWatchMediaInfo = null;
            }
            if (liveWatchMediaInfo != null) {
                h22.a aVar3 = this.qqLiveRoomService;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar3 = null;
                }
                LiveInfo curLiveInfo2 = aVar3.getCurLiveInfo();
                if (curLiveInfo2 != null && (liveWatchMediaInfo2 = curLiveInfo2.watchMediaInfo) != null) {
                    str = liveWatchMediaInfo2.mRtmpUrl;
                }
                if (str == null) {
                    str = "";
                }
                this.preLoadVideoUrl = str;
            }
        }
    }

    public final void w() {
        u("onExitRoomAndRePreloadEvent");
        fu0.c s16 = s();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        if (!s16.H(aVar.getRoomId())) {
            A();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.audience.preload.b
                @Override // java.lang.Runnable
                public final void run() {
                    PreloadRoomComponent.x(PreloadRoomComponent.this);
                }
            });
        }
    }

    public final void z(@NotNull i22.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String j3 = com.tencent.icgame.game.liveroom.impl.room.definition.b.j(event.getRoomId(), event.getCom.tencent.mobileqq.app.AppConstants.Key.KEY_QZONE_VIDEO_URL java.lang.String(), event.getExtraInfo());
        Intrinsics.checkNotNullExpressionValue(j3, "getVideoUrl(event.roomId\u2026ideoUrl, event.extraInfo)");
        this.preLoadVideoUrl = j3;
        u("onPagePreload, videoUrl " + j3);
        if (!s().H(event.getRoomId())) {
            A();
        }
    }

    public final void y() {
    }
}
