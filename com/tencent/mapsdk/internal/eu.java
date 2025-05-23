package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.view.View;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class eu implements ew {
    @Override // com.tencent.mapsdk.internal.ew
    public Rect a() {
        View[] b16 = b();
        Rect rect = new Rect();
        for (View view : b16) {
            rect.union(ht.a(view));
        }
        return rect;
    }

    public abstract View[] b();
}
