package com.tencent.icgame.game.ui.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f {
    public static void a(int i3) {
        b(MobileQQ.sMobileQQ.getResources().getString(i3));
    }

    public static void b(String str) {
        c(false, str);
    }

    public static void c(boolean z16, String str) {
        if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), z16 ? 1 : 0, str, 0).show();
        }
    }
}
