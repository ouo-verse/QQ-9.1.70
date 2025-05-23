package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.os.Build;
import android.view.Display;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    public static Display a(Activity activity) {
        Display display;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                display = activity.getDisplay();
            } catch (UnsupportedOperationException unused) {
                display = null;
            }
            if (display != null) {
                return display;
            }
        }
        return activity.getWindowManager().getDefaultDisplay();
    }
}
