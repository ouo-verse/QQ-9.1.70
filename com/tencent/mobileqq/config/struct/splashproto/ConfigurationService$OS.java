package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$OS extends MessageMicro<ConfigurationService$OS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"type", "version", "sdk", "kernel", "rom"}, new Object[]{1, "", "", "", ""}, ConfigurationService$OS.class);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField version = PBField.initString("");
    public final PBStringField sdk = PBField.initString("");
    public final PBStringField kernel = PBField.initString("");
    public final PBStringField rom = PBField.initString("");
}
