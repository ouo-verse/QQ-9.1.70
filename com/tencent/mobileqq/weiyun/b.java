package com.tencent.mobileqq.weiyun;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements f {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean b(String str) {
        boolean z16 = true;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                QLog.d("WeiyunCreatePluginChecker", 1, "Weiyun urlString is not url!");
                return false;
            }
            String host = parse.getHost();
            if (TextUtils.isEmpty(host) || (!host.contains("share.weiyun.com") && !host.contains("h5.weiyun.com"))) {
                z16 = false;
            }
            return z16;
        } catch (Exception e16) {
            QLog.d("WeiyunCreatePluginChecker", 1, e16.getMessage(), e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.c
    public void onPreInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.f
    @NonNull
    public String[] providePreCreatePlugins(@NonNull Intent intent, @NonNull String str, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, this, intent, str, str2);
        }
        if (b(str)) {
            return new String[]{"Weiyun"};
        }
        return new String[0];
    }
}
