package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes9.dex */
public class cb {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, BaseActivity baseActivity, Intent intent, String str, boolean z16) {
        if (!"msg_tab_camera".equals(str) || intent == null) {
            return;
        }
        QZoneHelper.forwardToWriteMood(baseActivity, qQAppInterface, intent, 20005, z16);
    }

    public static void b() {
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) JumpActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        intent.addFlags(131072);
        intent.setData(Uri.parse("mqqapi://qzone/to_friend_feeds"));
        BaseApplication.getContext().startActivity(intent);
    }
}
