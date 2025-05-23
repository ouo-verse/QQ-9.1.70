package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$DelReq extends MessageMicro<QWalletAuthorize$DelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"appid", "token", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN}, new Object[]{0L, "", "", ""}, QWalletAuthorize$DelReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField token = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
}
