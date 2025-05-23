package com.tencent.mobileqq.qqgift.webview;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(String str) {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.addFlags(268435456);
        BaseApplication.getContext().startActivity(intent);
    }
}
