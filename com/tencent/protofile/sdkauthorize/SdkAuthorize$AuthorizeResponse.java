package com.tencent.protofile.sdkauthorize;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.qconn.protofile.appType$PassData;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkAuthorize$AuthorizeResponse extends MessageMicro<SdkAuthorize$AuthorizeResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130, 138, 146, 152}, new String[]{"ret", "msg", QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "expires_in", "openid", "pay_token", "encrytoken", AdParam.PF, "pfkey", "encrykey", "md5key", "sendinstall", "installwording", "passDataResp", "signQQkey", "md5QQkey", "callbackURL", "universalLink", "pause_duration"}, new Object[]{0, "", "", 0L, "", "", "", "", "", "", "", 0, "", null, "", "", "", "", 0}, SdkAuthorize$AuthorizeResponse.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342206msg = PBField.initString("");
    public final PBStringField access_token = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pay_token = PBField.initString("");
    public final PBStringField encrytoken = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342207pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBStringField encrykey = PBField.initString("");
    public final PBStringField md5key = PBField.initString("");
    public final PBUInt32Field sendinstall = PBField.initUInt32(0);
    public final PBStringField installwording = PBField.initString("");
    public final PBRepeatMessageField<appType$PassData> passDataResp = PBField.initRepeatMessage(appType$PassData.class);
    public final PBStringField signQQkey = PBField.initString("");
    public final PBStringField md5QQkey = PBField.initString("");
    public final PBStringField callbackURL = PBField.initString("");
    public final PBStringField universalLink = PBField.initString("");
    public final PBUInt32Field pause_duration = PBField.initUInt32(0);
}
