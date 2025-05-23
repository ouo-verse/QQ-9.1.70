package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$Contract extends MessageMicro<QWalletAuthorize$Contract> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "url", "filter"}, new Object[]{"", "", null}, QWalletAuthorize$Contract.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public QWalletAuthorize$Filter filter = new QWalletAuthorize$Filter();
}
