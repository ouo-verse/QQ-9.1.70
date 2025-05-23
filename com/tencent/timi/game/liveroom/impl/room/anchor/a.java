package com.tencent.timi.game.liveroom.impl.room.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/anchor/a;", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "", "getRoomId", "<init>", "()V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements com.tencent.mobileqq.qqlive.base.room.service.roominfo.b {
    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    @Nullable
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        return com.tencent.mobileqq.qqlive.anchor.live.a.a().b();
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    public long getRoomId() {
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        QQLiveAnchorRoomInfo anchorRoomInfo = getAnchorRoomInfo();
        if (anchorRoomInfo != null && (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) != null) {
            return qQLiveAnchorDataRoomInfo.getRoomId();
        }
        return -1L;
    }
}
