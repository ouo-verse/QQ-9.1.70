package com.tencent.timi.game.ui.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f {
    public static void a(String str) {
        QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show();
    }

    public static void b(int i3) {
        c(MobileQQ.sMobileQQ.getResources().getString(i3));
    }

    public static void c(String str) {
        d(false, str);
    }

    public static void d(boolean z16, String str) {
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), z16 ? 1 : 0, str, 0).show();
        }
    }
}
