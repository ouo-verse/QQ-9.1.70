package com.tencent.hlyyb.downloader.g.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f extends a {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean e(Context context) {
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            String c16 = g.c(g.b("ZnJwLndocWZocXcuZHFndXJsZy50dGdyenFvcmRnaHU="), -3);
            String c17 = g.c(g.b("ZnJwLm9seWguemR3aHVwaG9ycS5kZndseWx3Yi5HZGhwcnFEZndseWx3Yg=="), -3);
            if (!TextUtils.isEmpty(c16) && !TextUtils.isEmpty(c17)) {
                intent.setComponent(new ComponentName(c16, c17));
                intent.setFlags(268435456);
                intent.putExtra("from", "qd_qq_act");
                context.startActivity(intent);
                k.m(context, d(), 30, null);
                return true;
            }
            return false;
        } catch (Throwable th5) {
            if (!(th5 instanceof ActivityNotFoundException)) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("error", String.valueOf(th5));
                    k.m(context, d(), 31, hashMap);
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (g.e(this.f114655b, true)) {
            k.m(this.f114655b, d(), 33, null);
        } else {
            e(this.f114655b);
        }
    }

    @Override // com.tencent.hlyyb.downloader.g.a.a
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "e";
    }
}
