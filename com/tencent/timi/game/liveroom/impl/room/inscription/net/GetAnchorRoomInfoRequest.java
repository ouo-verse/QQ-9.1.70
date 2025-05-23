package com.tencent.timi.game.liveroom.impl.room.inscription.net;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.anchor.AnchorLiveSysMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.sso.request.QQLiveGetAnchorRoomInfoRequest;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest;", "", "", "anchorUid", "", VirtualAppProxy.KEY_GAME_ID, "roomId", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GetAnchorRoomInfoRequest {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GetAnchorRoomInfoRequest f377853a = new GetAnchorRoomInfoRequest();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u0003\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "a", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "b", "()Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "g", "(Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;)V", "info", "", "J", "d", "()J", "i", "(J)V", "roomId", "", "c", "I", "()I", h.F, "(I)V", "period", "", "Z", "()Z", "f", "(Z)V", "entranceShowFlag", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;", "e", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;", "()Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;", "j", "(Ltrpc/yes/common/PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;)V", "rsp", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private PremadesTeamServerOuterClass$AnchorGameInfo info;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long roomId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int period;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean entranceShowFlag;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp rsp;

        /* renamed from: a, reason: from getter */
        public final boolean getEntranceShowFlag() {
            return this.entranceShowFlag;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final PremadesTeamServerOuterClass$AnchorGameInfo getInfo() {
            return this.info;
        }

        /* renamed from: c, reason: from getter */
        public final int getPeriod() {
            return this.period;
        }

        /* renamed from: d, reason: from getter */
        public final long getRoomId() {
            return this.roomId;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp getRsp() {
            return this.rsp;
        }

        public final void f(boolean z16) {
            this.entranceShowFlag = z16;
        }

        public final void g(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo) {
            this.info = premadesTeamServerOuterClass$AnchorGameInfo;
        }

        public final void h(int i3) {
            this.period = i3;
        }

        public final void i(long j3) {
            this.roomId = j3;
        }

        public final void j(@Nullable PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp premadesTeamServerOuterClass$GetAnchorRoomInfoRsp) {
            this.rsp = premadesTeamServerOuterClass$GetAnchorRoomInfoRsp;
        }
    }

    GetAnchorRoomInfoRequest() {
    }

    public final void a(long anchorUid, int gameId, final long roomId, @Nullable final IResultListener<a> callback) {
        l.i("GetAnchorRoomInfoRequest", "[requestAnchorRoomInfo] gameId=" + gameId + ", roomId=" + roomId);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetAnchorRoomInfoRequest(roomId, anchorUid, gameId), new Function1<QQLiveResponse<PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest$requestAnchorRoomInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp> response) {
                String str;
                Intrinsics.checkNotNullParameter(response, "response");
                PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    GetAnchorRoomInfoRequest.a aVar = new GetAnchorRoomInfoRequest.a();
                    aVar.i(roomId);
                    PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo = rsp.game_info;
                    aVar.g(premadesTeamServerOuterClass$AnchorGameInfo != null ? premadesTeamServerOuterClass$AnchorGameInfo.get() : null);
                    PBInt32Field pBInt32Field = rsp.refresh_interval;
                    aVar.h((pBInt32Field != null ? pBInt32Field.get() : 0) * 1000);
                    aVar.f(rsp.equip_setting_status.get() == 1);
                    aVar.j(rsp);
                    IResultListener<GetAnchorRoomInfoRequest.a> iResultListener = callback;
                    if (iResultListener != null) {
                        iResultListener.onSuccess(aVar);
                    }
                    PBStringField pBStringField = rsp.tips;
                    if (pBStringField == null || (str = pBStringField.get()) == null) {
                        return;
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new AnchorLiveSysMsgEvent(roomId, str));
                    return;
                }
                l.e("GetAnchorRoomInfoRequest", "[requestAnchorRoomInfo] failed, retCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
                IResultListener<GetAnchorRoomInfoRequest.a> iResultListener2 = callback;
                if (iResultListener2 != null) {
                    iResultListener2.onError((int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }
}
