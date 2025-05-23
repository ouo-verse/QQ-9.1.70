package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, int i3) {
        if (qQAppInterface == null) {
            return;
        }
        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(qQAppInterface.getAccount(), "sp_key_card_redpoint_count", Integer.valueOf(i3));
        if (QLog.isColorLevel()) {
            QLog.i("CardUtil", 2, String.format("updateCardRedPoint count:%d", Integer.valueOf(i3)));
        }
    }
}
