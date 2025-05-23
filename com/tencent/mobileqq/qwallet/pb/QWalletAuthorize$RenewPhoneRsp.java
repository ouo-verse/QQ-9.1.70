package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$RenewPhoneRsp extends MessageMicro<QWalletAuthorize$RenewPhoneRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"phone"}, new Object[]{null}, QWalletAuthorize$RenewPhoneRsp.class);
    public QWalletAuthorize$PhoneNo phone = new QWalletAuthorize$PhoneNo();
}
