package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class QWalletAuthorize$AddReq extends MessageMicro<QWalletAuthorize$AddReq> {
    public static final int ONLY_CHECK = 0;
    public static final int SAVE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"appid", "action", "phone_no", "verify_code", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN}, new Object[]{0L, 0, "", "", "", ""}, QWalletAuthorize$AddReq.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBEnumField action = PBField.initEnum(0);
    public final PBStringField phone_no = PBField.initString("");
    public final PBStringField verify_code = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
}
