package com.tencent.mobileqq.activity.specialcare;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.servlet.QzoneAioStoryFeedServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static void a(Activity activity, String str, int i3) {
        b(activity, str, null, i3);
    }

    public static void b(Activity activity, String str, String str2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) QQSpecialCareSettingActivity.class);
        intent.putExtra("key_friend_uin", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(QzoneAioStoryFeedServlet.KEY_FRIEND_UIN, str2);
        }
        intent.putExtra("key_start_from", i3);
        activity.startActivity(intent);
    }
}
