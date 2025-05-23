package com.tencent.mobileqq.newnearby.servlet;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {
    public static void b(ServletObserver servletObserver, byte[] bArr, String str, Bundle bundle, boolean z16) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        NewIntent newIntent = new NewIntent(runtime.getApplicationContext(), a.class);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        servletObserver.f254229d = new WeakReference<>(runtime);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("isResend", z16);
        newIntent.setObserver(servletObserver);
        runtime.startServlet(newIntent);
    }

    public static void a(ServletObserver servletObserver, byte[] bArr, String str) {
        b(servletObserver, bArr, str, null, false);
    }
}
