package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$SimpleContract extends MessageMicro<QWalletLocalPhone$SimpleContract> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "url"}, new Object[]{"", ""}, QWalletLocalPhone$SimpleContract.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
