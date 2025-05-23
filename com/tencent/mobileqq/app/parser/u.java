package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class u extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public u(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    public boolean F() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Intent intent = new Intent(this.f307437b, (Class<?>) QQBrowserActivity.class);
        if (this.f307441f.containsKey("url")) {
            this.f307441f.remove("url");
        }
        for (Map.Entry<String, String> entry : this.f307441f.entrySet()) {
            intent.putExtra(entry.getKey(), Uri.decode(entry.getValue()));
        }
        if (this.f307441f.containsKey("weburl")) {
            str = Uri.decode(this.f307441f.get("weburl"));
        } else {
            str = "";
        }
        if (!str.startsWith("https://sou.qq.com/") && !str.startsWith("https://sou.html5.qq.com/")) {
            return false;
        }
        intent.putExtra("url", str);
        intent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
        this.f307437b.startActivity(intent);
        if ((this.f307437b instanceof Activity) && !"1".equals(this.f307441f.get("openanimtype"))) {
            ((Activity) this.f307437b).overridePendingTransition(0, 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("FTSSearchOpenMixWebAction", 1, "doAction error: " + e16.getMessage());
            i("FTSSearchOpenMixWebAction");
            return false;
        }
    }
}
