package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_grey_interface$GreyInterfaceReq extends MessageMicro<ilive_grey_interface$GreyInterfaceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48}, new String[]{"uin", "version", "deviceType", "clientType", "strVersion", "key"}, new Object[]{0L, 0, "", 0, "", 0}, ilive_grey_interface$GreyInterfaceReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField deviceType = PBField.initString("");
    public final PBUInt32Field clientType = PBField.initUInt32(0);
    public final PBStringField strVersion = PBField.initString("");
    public final PBUInt32Field key = PBField.initUInt32(0);
}
