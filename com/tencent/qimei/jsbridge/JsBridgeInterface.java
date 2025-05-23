package com.tencent.qimei.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ac.b;
import com.tencent.qimei.ac.d;
import com.tencent.qimei.ad.c;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qimei.uin.U;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBridgeInterface {
    static IPatchRedirector $redirector_ = null;
    public static final String JS_OBJECT_NAME = "qimeiBridge";
    private final d bridgeHandler;

    public JsBridgeInterface(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.bridgeHandler = new d(obj);
        }
    }

    @JavascriptInterface
    public String postMessage(String str) {
        b bVar;
        boolean z16;
        byte[] bArr;
        String str2;
        long j3;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        d dVar = this.bridgeHandler;
        dVar.getClass();
        byte[] bArr2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar = new b(jSONObject.optString(BaseJsHandler.JS_HANDLER_NAME), jSONObject.optString(a.f36102l), jSONObject.optString("time"), jSONObject.optString("token"));
        } catch (Exception unused) {
            c.a("QMBridge", "parse message error", new Object[0]);
            bVar = null;
        }
        if (bVar != null) {
            boolean z17 = true;
            if (!TextUtils.isEmpty(bVar.f342932a) && !TextUtils.isEmpty(bVar.f342933b) && !TextUtils.isEmpty(bVar.f342934c) && !TextUtils.isEmpty(bVar.f342935d)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str4 = bVar.f342935d;
                String str5 = com.tencent.qimei.ac.a.f342930a;
                int length = str4.length();
                if (length % 2 == 1) {
                    length++;
                    bArr = new byte[length / 2];
                    str4 = "0" + str4;
                } else {
                    bArr = new byte[length / 2];
                }
                int i3 = 0;
                int i16 = 0;
                while (i3 < length) {
                    int i17 = i3 + 2;
                    bArr[i16] = (byte) Integer.parseInt(str4.substring(i3, i17), 16);
                    i16++;
                    i3 = i17;
                }
                try {
                    bArr2 = U.a(bArr, "35b4cfe6f7eae7acbd7bace522d0db54".getBytes());
                } catch (Exception e16) {
                    c.a(com.tencent.qimei.ac.a.f342930a, "do plain message exception: " + e16, new Object[0]);
                }
                if (bArr2 != null) {
                    str2 = new String(bArr2);
                } else {
                    str2 = "";
                }
                if (TextUtils.isEmpty(str2)) {
                    str3 = "102";
                } else if (!String.format("%s-%s", bVar.f342933b, bVar.f342934c).equals(str2)) {
                    str3 = "103";
                } else {
                    String str6 = str2.split("-")[1];
                    if (!TextUtils.isEmpty(str6)) {
                        try {
                            j3 = Long.parseLong(str6);
                        } catch (Exception unused2) {
                            j3 = 0;
                        }
                        z17 = com.tencent.qimei.ab.d.a(j3 * 1000, 10L, TimeUnit.MINUTES);
                    }
                    if (z17) {
                        str3 = "101";
                    } else {
                        String str7 = com.tencent.qimei.u.a.f343382a;
                        if (!TextUtils.isEmpty(str7) && QimeiSDK.getInstance(str7).getQimei() != null) {
                            str3 = "0";
                        } else {
                            str3 = "-3";
                        }
                    }
                }
                if (str3.equals("0")) {
                    QimeiSDK.getInstance(com.tencent.qimei.u.a.f343382a).getQimei(new com.tencent.qimei.ac.c(dVar));
                    return com.tencent.qimei.f.a.c("0");
                }
                dVar.b("{}");
                return com.tencent.qimei.f.a.c(str3);
            }
        }
        return com.tencent.qimei.f.a.c("100");
    }
}
