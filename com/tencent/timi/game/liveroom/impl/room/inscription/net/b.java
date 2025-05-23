package com.tencent.timi.game.liveroom.impl.room.inscription.net;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.c;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/b;", "", "", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "", GdtGetUserInfoHandler.KEY_AREA, "partition", "equipStatus", "", "uid", "roomId", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f377861a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/inscription/net/b$a", "Lpl4/d;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements d<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> f377862a;

        a(IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener) {
            this.f377862a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameDataServerOuterClass$SetAnchorGameEquipRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("SetAnchorGameEquipRoleRequest", "setAnchorGameEquipRole - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener = this.f377862a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameDataServerOuterClass$SetAnchorGameEquipRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener = this.f377862a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    b() {
    }

    public final void a(@NotNull String businessID, int area, int partition, int equipStatus, long uid, long roomId, @Nullable IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> callback) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        l.i("SetAnchorGameEquipRoleRequest", "SetAnchorGameEquipRoleRequest ");
        ((c) mm4.b.b(c.class)).F1(qj4.b.INSTANCE.a(businessID, area, partition, equipStatus, uid, roomId), GameDataServerOuterClass$SetAnchorGameEquipRoleRsp.class, new a(callback));
    }
}
