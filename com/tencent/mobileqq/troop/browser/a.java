package com.tencent.mobileqq.troop.browser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, Bundle bundle, String str) {
        if (context != null && bundle != null) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtras(bundle);
            intent.putExtra("url", str);
            intent.putExtra("isShowAd", false);
            context.startActivity(intent);
        }
    }
}
