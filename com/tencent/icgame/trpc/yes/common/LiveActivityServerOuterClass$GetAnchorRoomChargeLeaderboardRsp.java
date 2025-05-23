package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardRsp extends MessageMicro<LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"leaderboard", "last_charge"}, new Object[]{null, null}, LiveActivityServerOuterClass$GetAnchorRoomChargeLeaderboardRsp.class);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem> leaderboard = PBField.initRepeatMessage(LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem.class);
    public LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem last_charge = new MessageMicro<LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem>() { // from class: com.tencent.icgame.trpc.yes.common.LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64}, new String[]{"anchor_uid", AudienceReportConst.ANCHOR_NAME, "anchor_icon", "charge_value", AudienceReportConst.ROOM_ID, "room_state", "anchor_charge_level", "charge_diff"}, new Object[]{0L, "", "", 0L, 0L, 0, 0, 0L}, LiveActivityServerOuterClass$AnchorRoomChargeLeaderboardItem.class);
        public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
        public final PBStringField anchor_name = PBField.initString("");
        public final PBStringField anchor_icon = PBField.initString("");
        public final PBUInt64Field charge_value = PBField.initUInt64(0);
        public final PBUInt64Field room_id = PBField.initUInt64(0);
        public final PBUInt32Field room_state = PBField.initUInt32(0);
        public final PBUInt32Field anchor_charge_level = PBField.initUInt32(0);
        public final PBUInt64Field charge_diff = PBField.initUInt64(0);
    };
}
