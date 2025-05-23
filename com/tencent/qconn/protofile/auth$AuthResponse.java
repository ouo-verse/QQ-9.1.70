package com.tencent.qconn.protofile;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class auth$AuthResponse extends MessageMicro<auth$AuthResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66, 74, 82, 114, 162, 322, 402, 482}, new String[]{"ret", "msg", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "code", "expires_in", "openid", "pay_token", "encrytoken", AdParam.PF, "pfkey", "pass_data_resp", "callback_url", "universal_link", "proxy_auth_resp", "state"}, new Object[]{0, "", "", "", 0L, "", "", "", "", "", null, "", "", null, ""}, auth$AuthResponse.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342469msg = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBStringField code = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pay_token = PBField.initString("");
    public final PBStringField encrytoken = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342470pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBRepeatMessageField<appType$PassData> pass_data_resp = PBField.initRepeatMessage(appType$PassData.class);
    public final PBStringField callback_url = PBField.initString("");
    public final PBStringField universal_link = PBField.initString("");
    public auth$ProxyAuthResponse proxy_auth_resp = new auth$ProxyAuthResponse();
    public final PBStringField state = PBField.initString("");
}
