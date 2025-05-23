package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean e(JSONObject jSONObject) {
        n nVar;
        if (this.f154219b.d() instanceof n) {
            nVar = (n) this.f154219b.d();
        } else {
            nVar = null;
        }
        n nVar2 = nVar;
        if (nVar2 == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("desc");
        String optString3 = jSONObject.optString("shareUrl");
        String optString4 = jSONObject.optString("imageUrl");
        String str = this.f154095a.k().f246795d;
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("source_name", str);
            bundle.putString("source_icon", this.f154095a.k().f246798g);
        }
        bundle.putInt("extra_url_info_from", 1);
        return nVar2.setSummary(optString, optString2, optString3, optString4, bundle);
    }

    private boolean f(com.tencent.mobileqq.Doraemon.a aVar) {
        n nVar;
        Share share;
        if (this.f154219b.d() instanceof n) {
            nVar = (n) this.f154219b.d();
        } else {
            nVar = null;
        }
        if (nVar == null || (share = (Share) nVar.getShare()) == null) {
            return false;
        }
        share.c0(aVar);
        return true;
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 2) {
            if (i3 != 22) {
                if (i3 != 25) {
                    if (i3 != 26) {
                        return false;
                    }
                    if (f(aVar)) {
                        DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                    } else {
                        DoraemonUtil.c(aVar, -1, "");
                    }
                } else if (e(jSONObject)) {
                    DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                } else {
                    DoraemonUtil.c(aVar, -1, "");
                }
            } else {
                DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
            }
        } else {
            DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
            Activity j3 = this.f154095a.j();
            if (j3 != null && !j3.isFinishing()) {
                j3.finish();
            } else {
                QLog.e("WVUIModule", 1, "execute activity is null or finish");
                return false;
            }
        }
        return true;
    }
}
