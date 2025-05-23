package com.tencent.mobileqq.qwallet.pb;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* loaded from: classes16.dex */
public final class StudentPB$ConfirmAuthReq extends MessageMicro<StudentPB$ConfirmAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"appid", "openid", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "timestamp", "sign", WadlProxyConsts.CHANNEL}, new Object[]{"", "", "", 0L, "", ""}, StudentPB$ConfirmAuthReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField channel = PBField.initString("");
}
