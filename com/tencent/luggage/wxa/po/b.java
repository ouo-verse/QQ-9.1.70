package com.tencent.luggage.wxa.po;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.Window;
import com.tencent.luggage.wxa.lo.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends f {
    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        return c(activity.getWindow());
    }

    public static void b(Window window) {
        if (window == null) {
            return;
        }
        int i3 = window.getAttributes().flags;
        int i16 = ((-67108865) & i3) | Integer.MIN_VALUE;
        if (i16 != i3) {
            window.setFlags(i16, i16);
        }
        if (window.getStatusBarColor() != 0) {
            window.setStatusBarColor(0);
        }
    }

    public static boolean c(Window window) {
        if (window == null || window.getDecorView() == null || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static Activity h(Context context) {
        return com.tencent.luggage.wxa.bo.a.a(context);
    }

    public static ContextThemeWrapper i(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof ContextThemeWrapper) {
            return (ContextThemeWrapper) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
            return null;
        }
        return i(baseContext);
    }
}
