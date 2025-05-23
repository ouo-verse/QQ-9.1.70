package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class msgDetail$SourceInfo extends MessageMicro<msgDetail$SourceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"src", "type", "sub_type", "src_name", "type_name", "icon"}, new Object[]{0, 0, 0, "", "", ""}, msgDetail$SourceInfo.class);
    public final PBUInt32Field src = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field sub_type = PBField.initUInt32(0);
    public final PBStringField src_name = PBField.initString("");
    public final PBStringField type_name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
