package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$AuthConfirmReq extends MessageMicro<QWalletAuthorize$AuthConfirmReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{"appid", "phone", "msg_no", "info", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "save_gw_phone"}, new Object[]{0L, null, "", null, "", "", Boolean.FALSE}, QWalletAuthorize$AuthConfirmReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public QWalletAuthorize$PhoneNo phone = new QWalletAuthorize$PhoneNo();
    public final PBStringField msg_no = PBField.initString("");
    public QWalletAuthorize$UserClient info = new QWalletAuthorize$UserClient();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBBoolField save_gw_phone = PBField.initBool(false);
}
