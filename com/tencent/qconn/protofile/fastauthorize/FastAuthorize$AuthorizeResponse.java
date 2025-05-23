package com.tencent.qconn.protofile.fastauthorize;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FastAuthorize$AuthorizeResponse extends MessageMicro<FastAuthorize$AuthorizeResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"ret", "msg", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "expires_in", "openid", "pay_token", "encrytoken", AdParam.PF, "pfkey", "encrykey", "md5key", "apk_name"}, new Object[]{"", "", "", 0L, "", "", "", "", "", "", "", ""}, FastAuthorize$AuthorizeResponse.class);
    public final PBStringField ret = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342473msg = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pay_token = PBField.initString("");
    public final PBStringField encrytoken = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342474pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBStringField encrykey = PBField.initString("");
    public final PBStringField md5key = PBField.initString("");
    public final PBStringField apk_name = PBField.initString("");
}
