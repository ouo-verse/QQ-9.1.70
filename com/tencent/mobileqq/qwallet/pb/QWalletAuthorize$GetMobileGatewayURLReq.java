package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$GetMobileGatewayURLReq extends MessageMicro<QWalletAuthorize$GetMobileGatewayURLReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"appid", "sign", "info", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN}, new Object[]{0L, "", null, "", ""}, QWalletAuthorize$GetMobileGatewayURLReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField sign = PBField.initString("");
    public QWalletAuthorize$UserClient info = new QWalletAuthorize$UserClient();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
}
