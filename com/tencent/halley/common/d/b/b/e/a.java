package com.tencent.halley.common.d.b.b.e;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.halley.common.a.c;
import com.tencent.halley.common.d.b.b.b;
import com.tencent.halley.common.d.i;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f113518a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f113519b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f113520c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f113518a = false;
        f113519b = false;
        f113520c = false;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(com.tencent.halley.common.d.b.b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "state";
    }

    @Override // com.tencent.halley.common.d.b.b.b
    public final void a(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            String optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        i.a("");
                        return;
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            String optString2 = jSONObject.optString(Constants.SP_DEVICE_ID);
            if (TextUtils.isEmpty(optString2)) {
                i.a("");
            } else {
                String a16 = i.a();
                if (!TextUtils.isEmpty(optString2) && !optString2.equals(a16)) {
                    i.a(optString2);
                }
            }
            String optString3 = jSONObject.optString("oper");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            com.tencent.halley.common.d.b.a.b.a().a(c.b(), optString3);
        } catch (Throwable th6) {
            d.a("halley-cloud-", "HttpStateHandler.onHttpRsp error.", th6);
        }
    }
}
