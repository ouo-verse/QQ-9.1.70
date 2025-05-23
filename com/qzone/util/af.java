package com.qzone.util;

import android.content.Context;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class af {
    public static int a(Context context, String str) {
        if (context == null) {
            context = RFWApplication.getApplication();
        }
        if (context != null) {
            return context.checkSelfPermission(str) == 0 ? 0 : -1;
        }
        QLog.d("QZonePermissionUtil", 1, "[checkPermission] context is null");
        return -1;
    }
}
