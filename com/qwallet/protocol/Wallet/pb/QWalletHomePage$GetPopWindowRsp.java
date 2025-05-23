package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$GetPopWindowRsp extends MessageMicro<QWalletHomePage$GetPopWindowRsp> {
    public static final int KUIKLY = 1;
    public static final int UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "biz_response", "kuikly_action"}, new Object[]{0, "", null}, QWalletHomePage$GetPopWindowRsp.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField biz_response = PBField.initString("");
    public QWalletHomePage$KuiklyAction kuikly_action = new QWalletHomePage$KuiklyAction();
}
