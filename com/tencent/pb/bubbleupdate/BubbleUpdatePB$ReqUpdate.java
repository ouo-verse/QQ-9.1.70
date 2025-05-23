package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class BubbleUpdatePB$ReqUpdate extends MessageMicro<BubbleUpdatePB$ReqUpdate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"int32_cmd", "uint64_uin", "uint32_plat_id", "str_version", "msg_req_data"}, new Object[]{0, 0L, 0, "", null}, BubbleUpdatePB$ReqUpdate.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
    public final PBStringField str_version = PBField.initString("");
    public BubbleUpdatePB$ReqUpdateData msg_req_data = new MessageMicro<BubbleUpdatePB$ReqUpdateData>() { // from class: com.tencent.pb.bubbleupdate.BubbleUpdatePB$ReqUpdateData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_req_update"}, new Object[]{null}, BubbleUpdatePB$ReqUpdateData.class);
        public final PBRepeatMessageField<BubbleUpdatePB$ReqUpdateTable> rpt_msg_req_update = PBField.initRepeatMessage(BubbleUpdatePB$ReqUpdateTable.class);
    };
}
