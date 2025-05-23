package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* loaded from: classes16.dex */
public final class QWalletAuthorize$GetPhonesReq extends MessageMicro<QWalletAuthorize$GetPhonesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"appid", "mobile_gateway_tokens", "info", "msg_no", "sign", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN}, new Object[]{0L, null, null, "", "", "", ""}, QWalletAuthorize$GetPhonesReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBRepeatMessageField<QWalletAuthorize$GatewayToken> mobile_gateway_tokens = PBField.initRepeatMessage(QWalletAuthorize$GatewayToken.class);
    public QWalletAuthorize$UserClient info = new QWalletAuthorize$UserClient();
    public final PBStringField msg_no = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
}
