package com.tencent.luggage.wxa.tn;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static String a(Context context, int i3) {
        int i16 = (i3 >> 8) & 255;
        if (i16 == 0) {
            return "" + ((i3 >> 24) & 15) + "." + ((i3 >> 16) & 255);
        }
        return "" + ((i3 >> 24) & 15) + "." + ((i3 >> 16) & 255) + "." + i16;
    }
}
