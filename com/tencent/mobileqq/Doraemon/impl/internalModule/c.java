package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.e;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends e {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        Activity j3 = this.f154095a.j();
        if (j3 != null && !j3.isFinishing()) {
            switch (i3) {
                case 19:
                    String optString = jSONObject.optString("action", "");
                    if (optString != null && optString.startsWith("mqqapi:")) {
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(optString));
                        RouteUtils.startActivity(j3, intent, RouterConstants.UI_ROUTER_JUMP);
                        DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                    } else {
                        DoraemonUtil.c(aVar, -1, "scheme not support");
                    }
                    return true;
                case 20:
                    return true;
                case 21:
                    String optString2 = jSONObject.optString("url", "");
                    Intent intent2 = new Intent();
                    intent2.putExtra("url", optString2);
                    RouteUtils.startActivity(j3, intent2, RouterConstants.UI_ROUTE_BROWSER);
                    DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                    return true;
                default:
                    return false;
            }
        }
        QLog.e("NavigateModule", 1, "execute activity is null or finish");
        return false;
    }
}
