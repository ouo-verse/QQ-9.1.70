package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$KuiklyAction extends MessageMicro<QWalletHomePage$KuiklyAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26}, new String[]{"page_name", "bundle_name"}, new Object[]{"", ""}, QWalletHomePage$KuiklyAction.class);
    public final PBStringField page_name = PBField.initString("");
    public final PBStringField bundle_name = PBField.initString("");
}
