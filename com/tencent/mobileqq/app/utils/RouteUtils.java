package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RouteUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RouteUtils";

    public RouteUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void startActivity(Context context, Intent intent, String str) {
        QLog.d(TAG, 1, "startActivity, path : ", str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            Bundle extra = activityURIRequest.extra();
            if (extras == null) {
                extras = new Bundle();
            }
            extra.putAll(extras);
            activityURIRequest.setFlags(intent.getFlags());
            activityURIRequest.setData(intent.getData());
            activityURIRequest.setType(intent.getType());
            activityURIRequest.setIntentAction(intent.getAction());
        }
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static void startActivityForResult(Context context, Intent intent, String str, int i3) {
        QLog.d(TAG, 1, "startActivityForResult, path : ", str, " code : ", Integer.valueOf(i3));
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        if (intent != null) {
            Bundle extras = intent.getExtras();
            Bundle extra = activityURIRequest.extra();
            if (extras == null) {
                extras = new Bundle();
            }
            extra.putAll(extras);
            activityURIRequest.setFlags(intent.getFlags());
            activityURIRequest.setData(intent.getData());
            activityURIRequest.setType(intent.getType());
            activityURIRequest.setIntentAction(intent.getAction());
        }
        activityURIRequest.setRequestCode(i3);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }
}
