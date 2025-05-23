package com.tribe.async.async;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bosses {
    private static Context sApp;
    private static volatile Boss sBoss;
    private static Looper sLooper;

    @NonNull
    public static Boss get() {
        if (sBoss != null) {
            return sBoss;
        }
        synchronized (Bosses.class) {
            if (sBoss != null) {
                return sBoss;
            }
            sBoss = new BossImp(sApp, sLooper);
            return sBoss;
        }
    }

    public static void init(Context context) {
        init(context, Looper.myLooper());
    }

    public static void initWithBoss(Context context, Boss boss) {
        sApp = context.getApplicationContext();
        synchronized (Bosses.class) {
            sBoss = boss;
        }
    }

    public static void init(Context context, Looper looper) {
        sApp = context.getApplicationContext();
        sLooper = looper;
    }
}
