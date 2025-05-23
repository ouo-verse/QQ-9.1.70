package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.room.d;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/ILiveRoomApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "appId", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "createTrtcRoom", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "uin", "getLastAnchorRoomInfo", "", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "playerConfig", "platform", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "createAudienceRoom", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ILiveRoomApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ e createAudienceRoom$default(ILiveRoomApi iLiveRoomApi, AudienceRoomInfo audienceRoomInfo, PlayerConfig playerConfig, IQQLivePlayer iQQLivePlayer, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    iQQLivePlayer = null;
                }
                return iLiveRoomApi.createAudienceRoom(audienceRoomInfo, playerConfig, iQQLivePlayer);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAudienceRoom");
        }
    }

    @NotNull
    e createAudienceRoom(@NotNull AudienceRoomInfo roomInfo, @NotNull PlayerConfig playerConfig, @Nullable IQQLivePlayer player);

    @NotNull
    e createAudienceRoom(@NotNull String appId, long roomId, @NotNull PlayerConfig playerConfig, @Nullable String platform);

    @Nullable
    d createTrtcRoom(@NotNull AnchorRoomInfo roomInfo);

    @NotNull
    d createTrtcRoom(@NotNull String appId);

    @Nullable
    AnchorRoomInfo getLastAnchorRoomInfo(@NotNull String appId, @NotNull String uin);
}
