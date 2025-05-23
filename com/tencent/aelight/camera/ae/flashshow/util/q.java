package com.tencent.aelight.camera.ae.flashshow.util;

import android.content.Context;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {
    public static boolean a(Context context) {
        return context != null && context.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0;
    }
}
