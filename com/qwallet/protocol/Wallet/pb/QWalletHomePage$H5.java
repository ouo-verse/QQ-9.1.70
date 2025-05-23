package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$H5 extends MessageMicro<QWalletHomePage$H5> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"is_open", "url", "skeleton"}, new Object[]{Boolean.FALSE, "", ""}, QWalletHomePage$H5.class);
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBStringField skeleton = PBField.initString("");
}
