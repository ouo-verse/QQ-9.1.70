package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class BubbleUpdatePB$RspUpdate extends MessageMicro<BubbleUpdatePB$RspUpdate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"int32_ret", "uint64_uin", "uint32_used_item_id", "msg_rsp_data"}, new Object[]{0, 0L, 0, null}, BubbleUpdatePB$RspUpdate.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_used_item_id = PBField.initUInt32(0);
    public BubbleUpdatePB$RspUpdateData msg_rsp_data = new MessageMicro<BubbleUpdatePB$RspUpdateData>() { // from class: com.tencent.pb.bubbleupdate.BubbleUpdatePB$RspUpdateData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_rsp_update"}, new Object[]{null}, BubbleUpdatePB$RspUpdateData.class);
        public final PBRepeatMessageField<BubbleUpdatePB$RspUpdateTable> rpt_msg_rsp_update = PBField.initRepeatMessage(BubbleUpdatePB$RspUpdateTable.class);
    };
}
