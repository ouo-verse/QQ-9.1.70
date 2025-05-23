package com.tencent.oskplayer.support;

import android.content.Context;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskSupport {
    public static final String LOG_TAG = "OskSupport";
    private static boolean isInit = false;
    private static Context sContext;
    private static NativeLibLoader sLibLoader;

    public static Context getContext() {
        return sContext;
    }

    public static NativeLibLoader getLibLoader() {
        return sLibLoader;
    }

    public static ILogger getLogger() {
        return Logger.g();
    }

    public static void init(Context context, ILogger iLogger, NativeLibLoader nativeLibLoader) {
        if (context != null) {
            if (iLogger != null) {
                if (nativeLibLoader == null) {
                    iLogger.i(LOG_TAG, "libLoader is not set, use DefaultNativeLibLoader");
                }
                synchronized (OskSupport.class) {
                    if (!isInit) {
                        sContext = context.getApplicationContext();
                        Logger.setLogger(iLogger);
                        if (nativeLibLoader == null) {
                            nativeLibLoader = new DefaultNativeLibLoader();
                        }
                        sLibLoader = nativeLibLoader;
                        isInit = true;
                    }
                }
                return;
            }
            throw new RuntimeException("need a valid logger implementation");
        }
        throw new RuntimeException("need a valid applicationContext");
    }
}
