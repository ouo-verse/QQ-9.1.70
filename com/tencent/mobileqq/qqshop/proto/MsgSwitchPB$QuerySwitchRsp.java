package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes17.dex */
public final class MsgSwitchPB$QuerySwitchRsp extends MessageMicro<MsgSwitchPB$QuerySwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, MsgSwitchPB$QuerySwitchRsp.class);
    public final PBRepeatMessageField<MsgSwitchPB$SwitchItem> items = PBField.initRepeatMessage(MsgSwitchPB$SwitchItem.class);
}
