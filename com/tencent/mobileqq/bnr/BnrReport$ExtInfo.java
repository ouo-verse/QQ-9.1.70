package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$ExtInfo extends MessageMicro<BnrReport$ExtInfo> {
    public static final int APP_VER_FIELD_NUMBER = 1;
    public static final int SYS_VER_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_ver", "sys_ver"}, new Object[]{"", ""}, BnrReport$ExtInfo.class);
    public final PBStringField app_ver = PBField.initString("");
    public final PBStringField sys_ver = PBField.initString("");
}
