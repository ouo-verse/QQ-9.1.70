package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveRoomApi;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom;
import com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom;
import com.tencent.mobileqq.qqlive.sail.room.RoomTrtcProxyImpl;
import com.tencent.mobileqq.qqlive.sail.room.d;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.k;
import com.tencent.mobileqq.qqlive.sail.room.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/LiveRoomApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/ILiveRoomApi;", "", "appId", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "createTrtcRoom", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "uin", "getLastAnchorRoomInfo", "", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "playerConfig", "platform", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "createAudienceRoom", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveRoomApiImpl implements ILiveRoomApi {
    static IPatchRedirector $redirector_;

    public LiveRoomApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomApi
    @NotNull
    public e createAudienceRoom(@NotNull String appId, long roomId, @NotNull PlayerConfig playerConfig, @Nullable String platform) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, this, appId, Long.valueOf(roomId), playerConfig, platform);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(playerConfig, "playerConfig");
        return new LiveAudienceRoom(appId, roomId, new n(playerConfig, roomId, null, 4, null), platform);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomApi
    @NotNull
    public d createTrtcRoom(@NotNull String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appId);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        return new LiveAnchorTrtcRoom(appId, new RoomTrtcProxyImpl());
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomApi
    @Nullable
    public AnchorRoomInfo getLastAnchorRoomInfo(@NotNull String appId, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AnchorRoomInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appId, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return k.f272428a.a(appId, uin);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomApi
    @NotNull
    public e createAudienceRoom(@NotNull AudienceRoomInfo roomInfo, @NotNull PlayerConfig playerConfig, @Nullable IQQLivePlayer player) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, this, roomInfo, playerConfig, player);
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(playerConfig, "playerConfig");
        return new LiveAudienceRoom(roomInfo, new n(playerConfig, roomInfo.getRoomId(), player), roomInfo.p());
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomApi
    @Nullable
    public d createTrtcRoom(@NotNull AnchorRoomInfo roomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) roomInfo);
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        return new LiveAnchorTrtcRoom(roomInfo, new RoomTrtcProxyImpl());
    }
}
