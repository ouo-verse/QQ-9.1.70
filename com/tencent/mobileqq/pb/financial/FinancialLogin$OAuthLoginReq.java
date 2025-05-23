package com.tencent.mobileqq.pb.financial;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class FinancialLogin$OAuthLoginReq extends MessageMicro<FinancialLogin$OAuthLoginReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"open_id", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN}, new Object[]{"", ""}, FinancialLogin$OAuthLoginReq.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
}
