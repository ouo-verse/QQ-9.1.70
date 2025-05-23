package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes17.dex */
public final class MsgSwitchPB$SwitchItem extends MessageMicro<MsgSwitchPB$SwitchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"switch_type", "title", "tip", "is_open", "report_flag"}, new Object[]{0, "", "", Boolean.FALSE, ""}, MsgSwitchPB$SwitchItem.class);
    public final PBEnumField switch_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField tip = PBField.initString("");
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField report_flag = PBField.initString("");
}
