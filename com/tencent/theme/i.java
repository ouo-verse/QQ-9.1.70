package com.tencent.theme;

import android.graphics.ColorFilter;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface i {
    boolean addResources(int i3, String str);

    boolean needBlockSetAlpha(BaseConstantState baseConstantState, int i3);

    boolean needBlockSetColorFilter(BaseConstantState baseConstantState, ColorFilter colorFilter);

    void onColorLoaded(SkinnableColorStateList skinnableColorStateList);

    void onColorReloaded(SkinnableColorStateList skinnableColorStateList);

    void onDrawableLoaded(BaseConstantState baseConstantState);

    void onDrawableReloaded(BaseConstantState baseConstantState);
}
