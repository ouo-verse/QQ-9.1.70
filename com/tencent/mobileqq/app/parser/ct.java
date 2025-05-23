package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ct extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ct(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean H() {
        if (!TextUtils.isEmpty(this.f307441f.get("appid"))) {
            com.tencent.mobileqq.utils.ax.L = this.f307441f.get("appid");
        }
        if (!TextUtils.isEmpty(this.f307441f.get("openid"))) {
            com.tencent.mobileqq.utils.ax.M = this.f307441f.get("openid");
        }
        if (!TextUtils.isEmpty(this.f307441f.get("openkey"))) {
            com.tencent.mobileqq.utils.ax.O = this.f307441f.get("openkey");
        }
        if ("true".equals(this.f307441f.get("is_from_game"))) {
            return F();
        }
        return G();
    }

    protected boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String str = this.f307441f.get("uin");
        if (str != null && !"".equals(str) && str.length() >= 5) {
            Bundle d16 = com.tencent.mobileqq.troop.utils.aq.d(str, "", 14);
            if (this.f307441f.containsKey("appid")) {
                d16.putString("appid", this.f307441f.get("appid"));
            }
            if (this.f307441f.containsKey("openid")) {
                d16.putString("openid", com.tencent.mobileqq.utils.ax.E(com.tencent.mobileqq.utils.ax.M));
            }
            if (this.f307441f.containsKey("openkey")) {
                d16.putString("openkey", this.f307441f.get("openkey"));
            }
            if (this.f307441f.containsKey("is_from_game")) {
                d16.putString("is_from_game", this.f307441f.get("is_from_game"));
            }
            if (this.f307441f.containsKey("guild_id")) {
                d16.putString("guild_id", this.f307441f.get("guild_id"));
            }
            if (this.f307441f.containsKey("zone_id")) {
                d16.putString("zone_id", this.f307441f.get("zone_id"));
            }
            if (this.f307441f.containsKey("role_id")) {
                d16.putString("role_id", this.f307441f.get("role_id"));
            }
            if (this.f307441f.containsKey("gc")) {
                d16.putString("gc", this.f307441f.get("gc"));
            }
            TroopUtils.I(this.f307437b, d16, 2);
            return true;
        }
        return false;
    }

    protected boolean G() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        String str = this.f307441f.get("url");
        if (TextUtils.isEmpty(str)) {
            str = this.f307438c;
        }
        String str2 = this.f307441f.get("attr_original_url");
        Context context = this.f307437b;
        boolean z16 = false;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            z16 = intent.getBooleanExtra("fromQrcode", false);
        }
        ((IQRJumpApi) QRoute.api(IQRJumpApi.class)).startQRJumpActivity(this.f307437b, str, str2, z16);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            return H();
        } catch (Exception e16) {
            QLog.e("QrCodeAction", 1, "doAction error: " + e16.getMessage());
            i("QrCodeAction");
            return false;
        }
    }
}
