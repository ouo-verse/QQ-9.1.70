package com.tencent.timi.game.liveroom.impl.room.inscription.net;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.c;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$GetAnchorGameRoleListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/a;", "", "", "roomId", "", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "", VirtualAppProxy.KEY_GAME_ID, "userId", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f377859a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/inscription/net/a$a", "Lpl4/d;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.inscription.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9940a implements d<GameDataServerOuterClass$GetAnchorGameRoleListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> f377860a;

        C9940a(IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener) {
            this.f377860a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameDataServerOuterClass$GetAnchorGameRoleListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("GetAnchorGameRoleListRequest", "requestAnchorGameRoleList - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener = this.f377860a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameDataServerOuterClass$GetAnchorGameRoleListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener = this.f377860a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    a() {
    }

    public final void a(long roomId, @NotNull String businessID, int gameId, long userId, @Nullable IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> callback) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        l.i("GetAnchorGameRoleListRequest", "requestAnchorGameRoleList ");
        ((c) mm4.b.b(c.class)).F1(qj4.a.INSTANCE.a(roomId, businessID, gameId, userId), GameDataServerOuterClass$GetAnchorGameRoleListRsp.class, new C9940a(callback));
    }
}
