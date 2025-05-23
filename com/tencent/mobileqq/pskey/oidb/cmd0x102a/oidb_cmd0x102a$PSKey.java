package com.tencent.mobileqq.pskey.oidb.cmd0x102a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class oidb_cmd0x102a$PSKey extends MessageMicro<oidb_cmd0x102a$PSKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"domain", "key", "key_expire", "uskey", "uskey_expire"}, new Object[]{"", "", 0L, "", 0L}, oidb_cmd0x102a$PSKey.class);
    public final PBStringField domain = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBInt64Field key_expire = PBField.initInt64(0);
    public final PBStringField uskey = PBField.initString("");
    public final PBInt64Field uskey_expire = PBField.initInt64(0);
}
