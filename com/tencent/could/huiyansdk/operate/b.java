package com.tencent.could.huiyansdk.operate;

import android.util.Log;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.could.huiyansdk.operate.a f100250a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f100251a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16522);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100251a = new b();
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100250a = new com.tencent.could.huiyansdk.operate.a();
        }
    }

    public com.tencent.could.huiyansdk.operate.a a() {
        boolean z16;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.could.huiyansdk.operate.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        f fVar = f.a.f100288a;
        boolean z17 = false;
        if (fVar.f100282k && fVar.f100278g != null) {
            jSONObject = fVar.f100278g.b();
        } else {
            k kVar = k.a.f100197a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get DeviceInfoJson, turing is not create! ");
            sb5.append(fVar.f100282k);
            sb5.append(", ");
            if (fVar.f100278g == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            kVar.a(2, "TuringSdkHelper", sb5.toString());
            jSONObject = null;
        }
        if (jSONObject == null) {
            k.a.f100197a.a(1, "DeviceInfoHelper", "get DeviceInfoJson is null!");
            return this.f100250a;
        }
        try {
            Log.e("DeviceInfoHelper", "turing: " + jSONObject);
            if (jSONObject.has("chargeState")) {
                int i3 = jSONObject.getInt("chargeState");
                com.tencent.could.huiyansdk.operate.a aVar = this.f100250a;
                aVar.f100243j = i3;
                if (1 == i3) {
                    z17 = true;
                }
                aVar.f100249p = z17;
            }
            if (jSONObject.has("batterLevel")) {
                this.f100250a.f100244k = jSONObject.getInt("batterLevel");
            }
            if (jSONObject.has("bootTime")) {
                this.f100250a.f100245l = jSONObject.getLong("bootTime");
            }
            Log.e("DeviceInfoHelper", "currentDeviceInfo:" + this.f100250a);
        } catch (JSONException e16) {
            k.a.f100197a.a(2, "DeviceInfoHelper", "createInfoWithTuring error: " + e16.getLocalizedMessage());
        }
        return this.f100250a;
    }
}
