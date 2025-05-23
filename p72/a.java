package p72;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.login_svr.login_svr.LoginSvr$LoginInfoReportRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$DocumentConfig;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f425671a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f425672b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f425673c;

    /* renamed from: d, reason: collision with root package name */
    public String f425674d;

    /* renamed from: e, reason: collision with root package name */
    public String f425675e;

    /* renamed from: f, reason: collision with root package name */
    public String f425676f;

    /* renamed from: g, reason: collision with root package name */
    public int f425677g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f425678h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f425679i;

    public byte[] b() {
        LoginSvr$LoginInfoReportRsp loginSvr$LoginInfoReportRsp = new LoginSvr$LoginInfoReportRsp();
        loginSvr$LoginInfoReportRsp.open_id.set(this.f425671a);
        loginSvr$LoginInfoReportRsp.is_new_user.set(this.f425672b);
        loginSvr$LoginInfoReportRsp.ret_code.set(this.f425673c ? 2 : 0);
        loginSvr$LoginInfoReportRsp.new_register.set(this.f425678h);
        loginSvr$LoginInfoReportRsp.user_type.set(this.f425679i);
        if (this.f425673c) {
            userInfo$DocumentConfig userinfo_documentconfig = new userInfo$DocumentConfig();
            userinfo_documentconfig.title.set(this.f425674d);
            userinfo_documentconfig.body.set(this.f425675e);
            userinfo_documentconfig.tips.set(this.f425676f);
            userinfo_documentconfig.window_type.set(this.f425677g);
            loginSvr$LoginInfoReportRsp.document_config.set(userinfo_documentconfig);
        }
        return loginSvr$LoginInfoReportRsp.toByteArray();
    }

    public String toString() {
        return "openId:" + this.f425671a + ";isNewUser:" + this.f425672b + ";isNewRegister:" + this.f425678h + ";userType:" + this.f425679i + ";isForbid:" + this.f425673c + ";forbidTitle:" + this.f425674d + ";forbidBody:" + this.f425675e + ";forbidTips:" + this.f425676f + ";forbidWindowType:" + this.f425677g + ";";
    }

    public static a a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        LoginSvr$LoginInfoReportRsp loginSvr$LoginInfoReportRsp = new LoginSvr$LoginInfoReportRsp();
        try {
            loginSvr$LoginInfoReportRsp.mergeFrom(bArr);
            a aVar = new a();
            aVar.f425671a = loginSvr$LoginInfoReportRsp.open_id.get();
            aVar.f425672b = loginSvr$LoginInfoReportRsp.is_new_user.get();
            aVar.f425678h = loginSvr$LoginInfoReportRsp.new_register.get();
            aVar.f425679i = loginSvr$LoginInfoReportRsp.user_type.get();
            int i3 = loginSvr$LoginInfoReportRsp.ret_code.get();
            if (i3 == 0) {
                aVar.f425673c = false;
            } else if (2 == i3) {
                aVar.f425673c = true;
                userInfo$DocumentConfig userinfo_documentconfig = loginSvr$LoginInfoReportRsp.document_config;
                if (userinfo_documentconfig != null) {
                    aVar.f425674d = userinfo_documentconfig.title.get();
                    aVar.f425675e = loginSvr$LoginInfoReportRsp.document_config.body.get();
                    aVar.f425676f = loginSvr$LoginInfoReportRsp.document_config.tips.get();
                    aVar.f425677g = loginSvr$LoginInfoReportRsp.document_config.window_type.get();
                }
            }
            return aVar;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("MatchFriend.LoginInfo", 1, "fromBytes fail", e16);
            return null;
        }
    }
}
