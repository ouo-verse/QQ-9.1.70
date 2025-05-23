package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.provider.Settings;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Bergamot {
    public static boolean a(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) == 0) {
            return false;
        }
        return true;
    }
}
