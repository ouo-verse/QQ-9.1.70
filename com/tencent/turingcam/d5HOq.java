package com.tencent.turingcam;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d5HOq {
    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a() {
        Context context;
        boolean isExternalStorageLegacy;
        int i3 = Build.VERSION.SDK_INT;
        synchronized (eh5ma.class) {
            context = eh5ma.f382207a;
        }
        if (a(context, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            return false;
        }
        if (i3 < 29) {
            return true;
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy;
    }
}
