package com.tencent.trpcprotocol.zplan.data_card.data_card;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class dataCard$KV extends MessageMicro<dataCard$KV> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, dataCard$KV.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
