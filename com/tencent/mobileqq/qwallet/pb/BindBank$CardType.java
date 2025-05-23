package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$CardType extends MessageMicro<BindBank$CardType> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "bank_type"}, new Object[]{"", ""}, BindBank$CardType.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField bank_type = PBField.initString("");
}
