package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class AccountSecurityInfo$AccSecInfoRequire extends MessageMicro<AccountSecurityInfo$AccSecInfoRequire> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"u64_uin", "str_version", "u32_client_type"}, new Object[]{0L, "", 0}, AccountSecurityInfo$AccSecInfoRequire.class);
    public final PBUInt64Field u64_uin = PBField.initUInt64(0);
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field u32_client_type = PBField.initUInt32(0);
}
