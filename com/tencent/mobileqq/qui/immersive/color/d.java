package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d extends a {
    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(View view) {
        return canHandle(view.getBackground());
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.a, com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(View view, IColorFetcher.Area area) {
        return super.getColor(view.getBackground(), area);
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(Drawable drawable) {
        return (drawable == null || drawable.getClass().getClassLoader() == ColorDrawable.class.getClassLoader()) ? false : true;
    }
}
