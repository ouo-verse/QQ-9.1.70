package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class m {
    public static boolean b() {
        return BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime(FaceConstant.NEARBY_MODULAR_MODULE_ID) instanceof INearbyAppInterface;
    }

    public static void d(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(", [");
            for (Object obj : objArr) {
                sb5.append(obj);
                sb5.append(",");
            }
            sb5.append("]");
            QLog.i(LogTag.NEARBY, 2, sb5.toString());
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(", [");
            for (Object obj : objArr) {
                sb5.append(obj);
                sb5.append(",");
            }
            sb5.append("]");
            QLog.i(str, 4, sb5.toString());
        }
    }

    public static void f(Activity activity, int i3) {
        Intent intent = new Intent(activity, (Class<?>) BindNumberActivity.class);
        intent.putExtra("kSrouce", 20);
        activity.startActivityForResult(intent, i3);
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) BaseApplication.context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
