package com.tencent.tavsticker;

import android.app.Application;
import android.content.Context;
import com.tencent.tavsticker.log.TLog;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerHelper {
    private static final String TAG = "TAVStickerHelper";
    private static Context sContext = null;
    private static boolean sIsDebug = false;

    private static Application getApplication() {
        try {
            return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static Context getContext() {
        if (sContext == null) {
            sContext = getApplication();
        }
        return sContext;
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static boolean isDebug() {
        return sIsDebug;
    }

    public static void setDebugMode(boolean z16) {
        TLog.d(TAG, "setDebugMode -> sIsDebug : " + z16);
        sIsDebug = z16;
    }
}
