package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BackgroundAttr extends SkinAttr {
    private static final String TAG = "SKIN" + BackgroundAttr.class.getSimpleName();

    @Override // com.tencent.shadow.core.runtime.skin.entity.SkinAttr
    public boolean applyInner(View view) {
        if (isColorAttr()) {
            view.setBackgroundColor(getColor());
            return true;
        }
        if (isDrawableAttr()) {
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingBottom = view.getPaddingBottom();
            view.setBackground(getDrawable());
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            return true;
        }
        return false;
    }
}
