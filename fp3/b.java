package fp3;

import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$AuthorizeResponse;
import com.tencent.qconn.protofile.appType$PassData;
import com.tencent.qconn.protofile.auth$AuthResponse;
import com.tencent.qconn.protofile.auth$ProxyAuthResponse;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public PBUInt32Field f400227a = PBField.initUInt32(0);

    /* renamed from: b, reason: collision with root package name */
    public PBStringField f400228b = PBField.initString("");

    /* renamed from: c, reason: collision with root package name */
    public PBStringField f400229c = PBField.initString("");

    /* renamed from: d, reason: collision with root package name */
    public PBInt64Field f400230d = PBField.initInt64(0);

    /* renamed from: e, reason: collision with root package name */
    public PBStringField f400231e = PBField.initString("");

    /* renamed from: f, reason: collision with root package name */
    public PBStringField f400232f = PBField.initString("");

    /* renamed from: g, reason: collision with root package name */
    public PBStringField f400233g = PBField.initString("");

    /* renamed from: h, reason: collision with root package name */
    public PBStringField f400234h = PBField.initString("");

    /* renamed from: i, reason: collision with root package name */
    public PBStringField f400235i = PBField.initString("");

    /* renamed from: j, reason: collision with root package name */
    public PBStringField f400236j = PBField.initString("");

    /* renamed from: k, reason: collision with root package name */
    public PBStringField f400237k = PBField.initString("");

    /* renamed from: l, reason: collision with root package name */
    public PBUInt32Field f400238l = PBField.initUInt32(0);

    /* renamed from: m, reason: collision with root package name */
    public PBStringField f400239m = PBField.initString("");

    /* renamed from: n, reason: collision with root package name */
    public PBRepeatMessageField<appType$PassData> f400240n = PBField.initRepeatMessage(appType$PassData.class);

    /* renamed from: o, reason: collision with root package name */
    public PBStringField f400241o = PBField.initString("");

    /* renamed from: p, reason: collision with root package name */
    public PBStringField f400242p = PBField.initString("");

    /* renamed from: q, reason: collision with root package name */
    public PBStringField f400243q = PBField.initString("");

    /* renamed from: r, reason: collision with root package name */
    public auth$ProxyAuthResponse f400244r = new auth$ProxyAuthResponse();

    /* renamed from: s, reason: collision with root package name */
    public PBStringField f400245s = PBField.initString("");

    /* renamed from: t, reason: collision with root package name */
    public PBUInt32Field f400246t = PBField.initUInt32(0);

    public static b a(SdkAuthorize$AuthorizeResponse sdkAuthorize$AuthorizeResponse) {
        b bVar = new b();
        bVar.f400227a = sdkAuthorize$AuthorizeResponse.ret;
        bVar.f400228b = sdkAuthorize$AuthorizeResponse.f342206msg;
        bVar.f400229c = sdkAuthorize$AuthorizeResponse.access_token;
        bVar.f400230d = sdkAuthorize$AuthorizeResponse.expires_in;
        bVar.f400231e = sdkAuthorize$AuthorizeResponse.openid;
        bVar.f400232f = sdkAuthorize$AuthorizeResponse.pay_token;
        bVar.f400233g = sdkAuthorize$AuthorizeResponse.encrytoken;
        bVar.f400234h = sdkAuthorize$AuthorizeResponse.f342207pf;
        bVar.f400235i = sdkAuthorize$AuthorizeResponse.pfkey;
        bVar.f400236j = sdkAuthorize$AuthorizeResponse.encrykey;
        bVar.f400237k = sdkAuthorize$AuthorizeResponse.md5key;
        bVar.f400238l = sdkAuthorize$AuthorizeResponse.sendinstall;
        bVar.f400239m = sdkAuthorize$AuthorizeResponse.installwording;
        bVar.f400240n = sdkAuthorize$AuthorizeResponse.passDataResp;
        bVar.f400241o = sdkAuthorize$AuthorizeResponse.signQQkey;
        bVar.f400242p = sdkAuthorize$AuthorizeResponse.md5QQkey;
        bVar.f400243q = sdkAuthorize$AuthorizeResponse.callbackURL;
        bVar.f400246t = sdkAuthorize$AuthorizeResponse.pause_duration;
        return bVar;
    }

    public static b b(auth$AuthResponse auth_authresponse) {
        b bVar = new b();
        bVar.f400227a = auth_authresponse.ret;
        bVar.f400228b = auth_authresponse.f342469msg;
        bVar.f400229c = auth_authresponse.access_token;
        bVar.f400230d = auth_authresponse.expires_in;
        bVar.f400231e = auth_authresponse.openid;
        bVar.f400232f = auth_authresponse.pay_token;
        bVar.f400233g = auth_authresponse.encrytoken;
        bVar.f400234h = auth_authresponse.f342470pf;
        bVar.f400235i = auth_authresponse.pfkey;
        bVar.f400240n = auth_authresponse.pass_data_resp;
        bVar.f400243q = auth_authresponse.callback_url;
        bVar.f400244r = auth_authresponse.proxy_auth_resp;
        bVar.f400245s = auth_authresponse.code;
        return bVar;
    }
}
