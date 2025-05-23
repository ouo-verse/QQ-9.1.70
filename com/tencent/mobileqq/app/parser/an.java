package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class an extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public an(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        StringBuilder sb5 = new StringBuilder(this.f307441f.get("url"));
        sb5.append("?a=1");
        for (String str : this.f307441f.keySet()) {
            if (!"url".equals(str)) {
                try {
                    String encode = URLEncoder.encode(this.f307441f.get(str), "UTF-8");
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(str);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(encode);
                } catch (UnsupportedEncodingException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("HuaYangAction", 1, e16, new Object[0]);
                    }
                }
            }
        }
        String sb6 = sb5.toString();
        if (QLog.isDevelopLevel()) {
            QLog.e("HuaYangAction", 4, "gotoHuayang url==" + sb6);
        }
        Context context = this.f307437b;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.setFlags(536870912);
        intent.putExtra("url", sb6);
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("HuaYangAction", 1, "doAction error: " + e16.getMessage());
            i("HuaYangAction");
            return false;
        }
    }
}
