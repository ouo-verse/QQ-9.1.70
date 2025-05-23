package com.tencent.luggage.wxa.aa;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {
    public static int a(Context context) {
        return a(context, 0);
    }

    public static int a(Context context, int i3) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            return identifier != 0 ? resources.getDimensionPixelSize(identifier) : i3;
        } catch (Resources.NotFoundException e16) {
            w.a("MicroMsg.ResourceCompat", e16, "get res of status_bar_height fail", new Object[0]);
            return i3;
        }
    }
}
