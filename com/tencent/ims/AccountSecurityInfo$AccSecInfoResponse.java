package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class AccountSecurityInfo$AccSecInfoResponse extends MessageMicro<AccountSecurityInfo$AccSecInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"u32_valid", "str_wording", "str_AccInfoUrl"}, new Object[]{0, "", ""}, AccountSecurityInfo$AccSecInfoResponse.class);
    public final PBUInt32Field u32_valid = PBField.initUInt32(0);
    public final PBStringField str_wording = PBField.initString("");
    public final PBStringField str_AccInfoUrl = PBField.initString("");
}
