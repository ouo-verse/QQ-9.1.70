package com.heytap.databaseengine.apiv2;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class _HeytapHealth {

    @SuppressLint({"StaticFieldLeak"})
    private static Context sContext = null;
    private static boolean sHasInit = false;
    public static final int sdkVersion = 2010300;

    public static Context getContext() {
        return sContext;
    }

    public static boolean hasInit() {
        return sHasInit;
    }

    public static void init(Context context) {
        sContext = context;
        sHasInit = true;
    }
}
