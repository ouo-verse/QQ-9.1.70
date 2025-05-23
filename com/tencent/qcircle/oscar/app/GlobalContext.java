package com.tencent.qcircle.oscar.app;

import android.app.Application;
import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GlobalContext {
    private static Application sApp;
    private static Context sContext;

    public static Application getApp() {
        return sApp;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setApp(Application application) {
        sApp = application;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
