package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$ABTest extends MessageMicro<QWalletHomePage$ABTest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"exp_name", "exp_version_key", "params_json"}, new Object[]{"", "", ""}, QWalletHomePage$ABTest.class);
    public final PBStringField exp_name = PBField.initString("");
    public final PBStringField exp_version_key = PBField.initString("");
    public final PBStringField params_json = PBField.initString("");
}
