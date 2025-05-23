package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$AuthConfirmRsp extends MessageMicro<QWalletAuthorize$AuthConfirmRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{""}, QWalletAuthorize$AuthConfirmRsp.class);
    public final PBStringField data = PBField.initString("");
}
