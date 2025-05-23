package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$MaskPhoneData extends MessageMicro<QWalletLocalPhone$MaskPhoneData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"mask", "contract"}, new Object[]{"", null}, QWalletLocalPhone$MaskPhoneData.class);
    public final PBStringField mask = PBField.initString("");
    public final PBRepeatMessageField<QWalletLocalPhone$SimpleContract> contract = PBField.initRepeatMessage(QWalletLocalPhone$SimpleContract.class);
}
