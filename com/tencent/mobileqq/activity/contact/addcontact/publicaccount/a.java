package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, Context context, int i3, String str, String str2, int i16, String str3, int i17) {
        if (i3 == 1) {
            Intent intent = new Intent();
            intent.putExtra("source", i17);
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, qQAppInterface, context, str, -7);
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra("uinname", str3);
            intent2.putExtra("source", i17);
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent2, qQAppInterface, context, str2, i16);
        }
    }
}
