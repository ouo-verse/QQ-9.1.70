package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class msgDetail$Image extends MessageMicro<msgDetail$Image> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"url", "height", "width"}, new Object[]{"", 0, 0}, msgDetail$Image.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
}
