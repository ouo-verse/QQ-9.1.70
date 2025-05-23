package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SrcAttr extends SkinAttr {
    @Override // com.tencent.shadow.core.runtime.skin.entity.SkinAttr
    public boolean applyInner(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (isColorAttr()) {
                imageView.setImageResource(getColor());
                return true;
            }
            if (isDrawableAttr()) {
                imageView.setImageDrawable(getDrawable());
                return true;
            }
            return false;
        }
        return false;
    }
}
