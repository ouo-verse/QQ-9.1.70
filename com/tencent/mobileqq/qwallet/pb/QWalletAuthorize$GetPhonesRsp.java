package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$GetPhonesRsp extends MessageMicro<QWalletAuthorize$GetPhonesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"phones", "maximum"}, new Object[]{null, 0}, QWalletAuthorize$GetPhonesRsp.class);
    public final PBRepeatMessageField<QWalletAuthorize$PhoneNo> phones = PBField.initRepeatMessage(QWalletAuthorize$PhoneNo.class);
    public final PBInt32Field maximum = PBField.initInt32(0);
}
