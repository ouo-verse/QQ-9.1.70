package com.tencent.av.foldable;

import android.content.res.Configuration;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends b {
    public void f(Configuration configuration, int i3) {
        int i16;
        if (configuration.screenWidthDp > 480 && (i3 < 0 || i3 >= 5)) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        e(Integer.valueOf(i16));
    }
}
