package com.tencent.mobileqq.webview.swift.component.navigate;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.d;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(String str) {
        String queryParameter;
        Uri parse = Uri.parse(str);
        if (parse != null && parse.isHierarchical() && (queryParameter = parse.getQueryParameter("_wwv")) != null) {
            try {
                if (0 == (Long.parseLong(queryParameter.trim()) & 2048)) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQBrowser", 4, "sorry, i can not get rules from QQBrowser url, maybe have more than one '_wv' in the url");
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, intent, activity, str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && activity.getClass() != SingleTaskQQBrowser.class && a(str)) {
            if (AuthorizeConfig.y().O("aio_authorize_config", str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIONavigationItem", 1, "WebViewSwitchAio canSwitchAIO  url " + str);
                }
                Intent intent2 = new Intent(intent);
                intent2.setComponent(new ComponentName(activity, (Class<?>) SingleTaskQQBrowser.class));
                intent2.setFlags(402653184);
                activity.startActivity(intent2);
                return true;
            }
            QLog.e("AIONavigationItem", 1, "WebViewSwitchAio want to switchToAIO, but don't have command right. url : " + str);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, intent, activity, str)).booleanValue();
        }
        return false;
    }
}
