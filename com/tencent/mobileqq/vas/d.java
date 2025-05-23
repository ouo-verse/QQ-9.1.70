package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    public static boolean a(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", str);
            intent.setData(Uri.parse(str));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            context.startActivity(intent);
            return true;
        } catch (Exception e16) {
            QLog.e("BrowserUtils", 2, e16, new Object[0]);
            return false;
        }
    }
}
