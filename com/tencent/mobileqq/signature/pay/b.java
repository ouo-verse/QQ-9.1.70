package com.tencent.mobileqq.signature.pay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(String str, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", str);
        intent.setData(Uri.parse(str));
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        activity.startActivity(intent);
    }
}
