package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bh {
    public static final boolean a(Activity activity, boolean z16) {
        if (activity != null && !activity.isFinishing()) {
            try {
                if (bg.f().j()) {
                    String c16 = bg.c(activity);
                    if (!TextUtils.isEmpty(c16)) {
                        if (z16) {
                            QQToast.makeText(activity, 1, c16, 1000).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                        activity.moveTaskToBack(true);
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpForwardPkgManager", 2, "checkAllowShare false");
                            return false;
                        }
                        return false;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }
}
