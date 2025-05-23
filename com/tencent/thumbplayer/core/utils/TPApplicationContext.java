package com.tencent.thumbplayer.core.utils;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPApplicationContext {
    private static Context sContext;

    @NonNull
    public static synchronized Context getContext() {
        Context context;
        synchronized (TPApplicationContext.class) {
            context = sContext;
        }
        return context;
    }

    public static synchronized void setContext(@NonNull Context context) {
        synchronized (TPApplicationContext.class) {
            sContext = context.getApplicationContext();
        }
    }
}
