package com.tencent.timi.game.liveroom.impl.room.anchor;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataConfigInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.timi.game.liveroom.impl.room.inscription.net.GetAnchorRoomInfoRequest;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/n;", "", "", "currentAnchorConfig", "", "b", "gameAnchorConfig", "e", SkinConstants.TintConstant.KEY_COMMON_CONFIG, "c", "", "roomId", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "callback", "a", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataConfigInfo;", DownloadInfo.spKey_Config, "d", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f377492a = new n();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/anchor/n$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/room/inscription/net/GetAnchorRoomInfoRequest$a;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<GetAnchorRoomInfoRequest.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f377493a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener<GetAnchorRoomInfoRequest.a> f377494b;

        a(long j3, IResultListener<GetAnchorRoomInfoRequest.a> iResultListener) {
            this.f377493a = j3;
            this.f377494b = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GetAnchorRoomInfoRequest.a result) {
            int i3;
            PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp rsp;
            PBInt32Field pBInt32Field;
            boolean z16 = false;
            if (result != null && (rsp = result.getRsp()) != null && (pBInt32Field = rsp.hide_nick_status) != null) {
                i3 = pBInt32Field.get();
            } else {
                i3 = 0;
            }
            com.tencent.timi.game.liveroom.impl.room.manager.d a16 = com.tencent.timi.game.liveroom.impl.room.manager.d.INSTANCE.a();
            long j3 = this.f377493a;
            if (i3 == 1) {
                z16 = true;
            }
            a16.e(j3, z16);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            IResultListener<GetAnchorRoomInfoRequest.a> iResultListener = this.f377494b;
            if (iResultListener != null) {
                iResultListener.onError(errorCode, errorMessage);
            }
        }
    }

    n() {
    }

    private final void b(String currentAnchorConfig) {
        com.tencent.timi.game.utils.l.b("TGAnchorConfigHelper", ">>parseAnchorConfig currentAnchorConfig=" + currentAnchorConfig);
        try {
            new JSONObject(currentAnchorConfig);
        } catch (JSONException unused) {
        }
    }

    private final void c(String commonConfig) {
        com.tencent.timi.game.utils.l.b("TGAnchorConfigHelper", ">>parseCommonConfig commonConfig=" + commonConfig);
        try {
            new JSONObject(commonConfig);
        } catch (JSONException unused) {
        }
    }

    private final void e(String gameAnchorConfig) {
        com.tencent.timi.game.utils.l.b("TGAnchorConfigHelper", ">>parseGameAnchorConfig gameAnchorConfig=" + gameAnchorConfig);
        try {
            new JSONObject(gameAnchorConfig);
        } catch (JSONException unused) {
        }
    }

    public final void a(long roomId, @Nullable IResultListener<GetAnchorRoomInfoRequest.a> callback) {
        GetAnchorRoomInfoRequest.f377853a.a(0L, 0, roomId, new a(roomId, callback));
    }

    public final void d(@Nullable QQLiveAnchorDataConfigInfo config) {
        if (config != null) {
            n nVar = f377492a;
            String str = config.commonConfig;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "config.commonConfig ?: \"\"");
            }
            nVar.c(str);
            String str3 = config.currentAnchorConfig;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "config.currentAnchorConfig ?: \"\"");
            }
            nVar.b(str3);
            String str4 = config.gameAnchorConfig;
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "config.gameAnchorConfig ?: \"\"");
                str2 = str4;
            }
            nVar.e(str2);
        }
    }
}
