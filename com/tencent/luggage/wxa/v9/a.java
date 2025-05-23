package com.tencent.luggage.wxa.v9;

import android.content.Context;
import android.provider.Settings;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static boolean a(Context context) {
        try {
            boolean booleanValue = ((Boolean) Settings.class.getDeclaredMethod("canDrawOverlays", Context.class).invoke(null, context)).booleanValue();
            w.d("MicroMsg.PermissionUtil", "isFloatWindowOpAllowed allowed: " + booleanValue);
            return booleanValue;
        } catch (Exception e16) {
            w.b("MicroMsg.PermissionUtil", "getDeclaredMethod:canDrawOverlays! Error:%s, etype:%s", e16.getMessage(), e16.getClass().getCanonicalName());
            return true;
        }
    }
}
