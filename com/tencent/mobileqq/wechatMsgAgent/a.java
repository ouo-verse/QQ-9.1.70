package com.tencent.mobileqq.wechatMsgAgent;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public boolean f315066d;

    /* renamed from: e, reason: collision with root package name */
    public String f315067e;

    /* renamed from: f, reason: collision with root package name */
    public String f315068f;

    /* renamed from: h, reason: collision with root package name */
    public String f315069h;

    /* renamed from: i, reason: collision with root package name */
    public int f315070i;

    /* renamed from: m, reason: collision with root package name */
    public String f315071m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    public static a a(String str) {
        QLog.d("WeChatAgentConfigData", 1, "parse config = ", str);
        if (TextUtils.isEmpty(str)) {
            return new a();
        }
        a aVar = new a();
        aVar.f315071m = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f315066d = jSONObject.optBoolean("switchOn");
            aVar.f315067e = jSONObject.optString("activePageJumpUrl");
            aVar.f315068f = jSONObject.optString("miniAppId");
            aVar.f315069h = jSONObject.optString("miniAppPath");
            String optString = jSONObject.optString("androidMiniAppDebugMode");
            if (optString != null) {
                try {
                    aVar.f315070i = Integer.parseInt(optString);
                } catch (NumberFormatException e16) {
                    QLog.e("WeChatAgentConfigData", 1, "parse number: " + e16);
                }
            }
            return aVar;
        } catch (JSONException e17) {
            QLog.e("WeChatAgentConfigData", 1, "parse: " + e17);
            return new a();
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "WeChatAgentConfigData{switchOn=" + this.f315066d + ", activePageJumpUrl=" + this.f315067e + ", miniAppId=" + this.f315068f + ", miniAppPath=" + this.f315069h + ", debugMode=" + this.f315070i + '}';
    }
}
