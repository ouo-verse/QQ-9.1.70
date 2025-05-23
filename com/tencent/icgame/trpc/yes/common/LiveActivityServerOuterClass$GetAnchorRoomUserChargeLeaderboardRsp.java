package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardRsp extends MessageMicro<LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"leaderboard"}, new Object[]{null}, LiveActivityServerOuterClass$GetAnchorRoomUserChargeLeaderboardRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AnchorRoomUserChargeLeaderboardItem> leaderboard = PBField.initRepeatMessage(LiveActivityServerOuterClass$AnchorRoomUserChargeLeaderboardItem.class);
}
