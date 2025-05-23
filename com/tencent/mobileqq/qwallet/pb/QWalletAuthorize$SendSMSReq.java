package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$SendSMSReq extends MessageMicro<QWalletAuthorize$SendSMSReq> {
    public static final int PLAINTEXT_PHONE = 0;
    public static final int QPAY_TOKEN = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58}, new String[]{"appid", "phone_no", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "check_type", "qpay_token", "mask_phone_no"}, new Object[]{0L, "", "", "", 0, "", ""}, QWalletAuthorize$SendSMSReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField phone_no = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBEnumField check_type = PBField.initEnum(0);
    public final PBStringField qpay_token = PBField.initString("");
    public final PBStringField mask_phone_no = PBField.initString("");
}
