package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class ElementPB$CreDate extends MessageMicro<ElementPB$CreDate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"begin", "expire"}, new Object[]{"", ""}, ElementPB$CreDate.class);
    public final PBStringField begin = PBField.initString("");
    public final PBStringField expire = PBField.initString("");
}
