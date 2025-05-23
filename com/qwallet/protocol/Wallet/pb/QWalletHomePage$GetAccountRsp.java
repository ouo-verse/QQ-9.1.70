package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetAccountRsp extends MessageMicro<QWalletHomePage$GetAccountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"top_entry"}, new Object[]{null}, QWalletHomePage$GetAccountRsp.class);
    public final PBRepeatMessageField<QWalletHomePage$Entry> top_entry = PBField.initRepeatMessage(QWalletHomePage$Entry.class);
}
