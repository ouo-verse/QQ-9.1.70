package com.tencent.mobileqq.vip;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static Map<String, Long> f313034d;

    /* renamed from: a, reason: collision with root package name */
    private String f313035a;

    /* renamed from: b, reason: collision with root package name */
    private int f313036b;

    /* renamed from: c, reason: collision with root package name */
    private int f313037c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f313034d = new HashMap(10);
        }
    }

    public m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f313036b = -1;
        this.f313037c = -1;
        this.f313035a = str;
    }

    private JSONObject a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("req", jSONObject);
            jSONObject2.put("12042", jSONObject3);
            return jSONObject2;
        } catch (Throwable th5) {
            QLog.e("LhHelper", 1, "buildReqData exception e = ", th5);
            return null;
        }
    }

    private String b(int i3) {
        try {
            String c16 = c(i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", i3);
            jSONObject.put("sign", c16);
            jSONObject.put("uin", this.f313035a);
            return "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?data=" + a(jSONObject);
        } catch (Throwable th5) {
            QLog.e("LhHelper", 1, "buildReqUrl cmd = " + i3 + "exception e = ", th5);
            return null;
        }
    }

    private String c(int i3) {
        return MD5.toMD5("cmd=" + i3 + "&key=a4d7ea5belhtimecard&uin=" + this.f313035a);
    }

    private String d() {
        return MD5.toMD5("cmd=rsp&key=a4d7ea5belhtimecard&uin=" + this.f313035a);
    }

    private OkHttpClient h() {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return newBuilder.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build();
    }

    private JSONObject j(int i3) {
        String b16;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            b16 = b(i3);
        } catch (Throwable th5) {
            QLog.e("LhHelper", 1, "reqCgi exception cmd =" + i3 + ", e = ", th5);
        }
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        QLog.d("LhHelper", 1, "reqCgi cmd = " + i3);
        Response execute = h().newCall(new Request.Builder().url(b16).build()).execute();
        int code = execute.code();
        if (code == 200) {
            JSONObject optJSONObject3 = new JSONObject(execute.body().string()).optJSONObject("12042");
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("data")) == null || (optJSONObject2 = optJSONObject.optJSONObject("rsp")) == null) {
                return null;
            }
            int optInt = optJSONObject2.optInt("ret");
            String optString = optJSONObject2.optString("sign");
            QLog.d("LhHelper", 1, "reqCgi retCode = " + optInt);
            if (optInt == 0 && d().equalsIgnoreCase(optString)) {
                return optJSONObject2;
            }
            QLog.e("LhHelper", 1, "reqCgi rsp sign error, cmd = " + i3);
            return null;
        }
        QLog.e("LhHelper", 1, "reqCgi http errorCode = " + code + " ,cmd = " + i3);
        return null;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            JSONObject j3 = j(1);
            if (j3 != null) {
                this.f313036b = j3.optInt("buyoutMonth", -1);
                this.f313037c = j3.optInt("buyoutType", -1);
                int optInt = j3.optInt("cardState", -1);
                if (this.f313036b != -1 && this.f313037c != -1) {
                    if (optInt == 0) {
                        return 1;
                    }
                    return 2;
                }
                QLog.e("LhHelper", 1, "checkUserStatus buyoutData is error");
                return 3;
            }
            QLog.e("LhHelper", 1, "checkUserStatus rsp data is empty");
            return 3;
        } catch (Throwable th5) {
            QLog.e("LhHelper", 1, "checkUserStatus exception e = ", th5);
            return 3;
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f313036b;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f313037c;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        try {
            if (j(2) != null) {
                return true;
            }
            QLog.e("LhHelper", 1, "receiveReq rsp data is error");
            return false;
        } catch (Throwable th5) {
            QLog.e("LhHelper", 1, "receiveReq exception e = ", th5);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public boolean k() {
        String str = "LhHelper";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        try {
            JSONObject j3 = j(3);
            if (j3 != null) {
                int optInt = j3.optInt("lhState", -1);
                QLog.d("LhHelper", 1, "reqLhStatus lhState = " + optInt);
                str = 2;
                if (optInt == 2) {
                    return true;
                }
            } else {
                QLog.e("LhHelper", 1, "reqLhStatus rsp data is error");
                str = str;
            }
            return false;
        } catch (Throwable th5) {
            QLog.e(str, 1, "reqLhStatus exception e = ", th5);
            return false;
        }
    }
}
