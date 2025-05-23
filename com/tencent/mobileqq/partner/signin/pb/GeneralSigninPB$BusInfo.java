package com.tencent.mobileqq.partner.signin.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class GeneralSigninPB$BusInfo extends MessageMicro<GeneralSigninPB$BusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"status", "name", "type", "member_info", "space_id"}, new Object[]{0, "", 0, null, ""}, GeneralSigninPB$BusInfo.class);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBRepeatMessageField<GeneralSigninPB$MemberInfo> member_info = PBField.initRepeatMessage(GeneralSigninPB$MemberInfo.class);
    public final PBStringField space_id = PBField.initString("");
}
