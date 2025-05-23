package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class BindBank$ProtoFile extends MessageMicro<BindBank$ProtoFile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "url", "version"}, new Object[]{"", "", ""}, BindBank$ProtoFile.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField version = PBField.initString("");
}
