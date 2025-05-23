package com.tencent.component.appx.utils;

import android.content.Context;
import com.tencent.component.appx.utils.impl.AppConfig;
import com.tencent.component.appx.utils.impl.AppUI;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppUtils {
    public static IAppConfig Config = null;
    public static IAppUI UI = null;
    public static volatile boolean isInited = false;

    public static void zInitGlobal(Context context) {
        synchronized (AppUtils.class) {
            if (isInited) {
                return;
            }
            isInited = true;
            Config = new AppConfig(context.getApplicationContext());
            UI = new AppUI(context.getApplicationContext());
        }
    }
}
