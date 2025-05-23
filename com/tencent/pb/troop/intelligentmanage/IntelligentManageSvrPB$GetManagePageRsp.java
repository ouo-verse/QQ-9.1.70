package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x934.cmd0x934$RspBody;

/* loaded from: classes22.dex */
public final class IntelligentManageSvrPB$GetManagePageRsp extends MessageMicro<IntelligentManageSvrPB$GetManagePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"cmd0x934_rsp_body", "need_admin_0x934_item_ids", "other_entrances"}, new Object[]{null, 0, null}, IntelligentManageSvrPB$GetManagePageRsp.class);
    public cmd0x934$RspBody cmd0x934_rsp_body = new cmd0x934$RspBody();
    public final PBRepeatField<Integer> need_admin_0x934_item_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<IntelligentManageSvrPB$Entrance> other_entrances = PBField.initRepeatMessage(IntelligentManageSvrPB$Entrance.class);
}
