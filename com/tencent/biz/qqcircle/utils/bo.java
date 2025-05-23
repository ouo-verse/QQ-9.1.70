package com.tencent.biz.qqcircle.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bo {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f92716a = com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_FIT_SYSTEM_WINDOW_CONTROLLER, 0);

    private static String a(int i3) {
        if (i3 != 0 && i3 != -1) {
            try {
                return QCircleApplication.getAPP().getResources().getResourceEntryName(i3);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static boolean b(View view) {
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        boolean z16 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                if (ViewCompat.getFitsSystemWindows(childAt)) {
                    if (f92716a) {
                        QLog.e("QFSFitSystemWindowUtils", 1, "view is:", childAt.getClass().getName(), ",id is:", a(childAt.getId()), "children is:\n", c(childAt));
                    }
                    z16 = true;
                }
                z16 |= b(childAt);
            }
        }
        return z16;
    }

    private static String c(View view) {
        StringBuilder sb5 = new StringBuilder();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    sb5.append("child view class is:");
                    sb5.append(childAt.getClass().getName());
                    sb5.append(",id is:");
                    sb5.append(a(childAt.getId()));
                    sb5.append("\n");
                    sb5.append(c(childAt));
                }
            }
        }
        return sb5.toString();
    }
}
