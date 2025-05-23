package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ai {
    public static void a(Context context, Intent intent, String str) {
        QLog.d("RouteUtils", 1, "startActivity, path : ", str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            Bundle extra = activityURIRequest.extra();
            if (extras == null) {
                extras = new Bundle();
            }
            extra.putAll(extras);
            activityURIRequest.setFlags(intent.getFlags());
        }
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }
}
