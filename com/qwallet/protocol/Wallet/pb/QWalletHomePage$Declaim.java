package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$Declaim extends MessageMicro<QWalletHomePage$Declaim> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"statement_title", "statement_content", "statement_btn_text"}, new Object[]{"", "", ""}, QWalletHomePage$Declaim.class);
    public final PBStringField statement_title = PBField.initString("");
    public final PBStringField statement_content = PBField.initString("");
    public final PBStringField statement_btn_text = PBField.initString("");
}
