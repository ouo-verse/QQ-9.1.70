package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dd {
    public static void a(View view, int i3) {
        if (view != null && i3 != 0) {
            Context context = view.getContext();
            if (context == null) {
                QLog.e("WidgetUtil", 1, "setViewBackground  context is null");
                return;
            } else {
                view.setBackgroundDrawable(context.getResources().getDrawable(i3));
                return;
            }
        }
        QLog.e("WidgetUtil", 1, "setViewBackground  view:" + view + ", resId:" + i3);
    }
}
