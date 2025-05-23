package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class LiveActivityServerOuterClass$GetRoomPendantRsp extends MessageMicro<LiveActivityServerOuterClass$GetRoomPendantRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pendant_list", "user_redpacket"}, new Object[]{null, null}, LiveActivityServerOuterClass$GetRoomPendantRsp.class);
    public final PBRepeatMessageField<PendantOuterClass$PendantMsg> pendant_list = PBField.initRepeatMessage(PendantOuterClass$PendantMsg.class);
    public LiveActivityServerOuterClass$UserRedpacket user_redpacket = new MessageMicro<LiveActivityServerOuterClass$UserRedpacket>() { // from class: com.tencent.icgame.trpc.yes.common.LiveActivityServerOuterClass$UserRedpacket
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"activity_id", "status"}, new Object[]{"", 0}, LiveActivityServerOuterClass$UserRedpacket.class);
        public final PBStringField activity_id = PBField.initString("");
        public final PBInt32Field status = PBField.initInt32(0);
    };
}
