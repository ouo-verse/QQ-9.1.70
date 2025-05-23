package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class AccountSecurityInfo$SecCheckBanner extends MessageMicro<AccountSecurityInfo$SecCheckBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"str_wording", "u32_timeToShow"}, new Object[]{"", 0}, AccountSecurityInfo$SecCheckBanner.class);
    public final PBStringField str_wording = PBField.initString("");
    public final PBUInt32Field u32_timeToShow = PBField.initUInt32(0);
}
