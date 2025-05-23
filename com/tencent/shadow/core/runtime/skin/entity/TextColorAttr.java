package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TextColorAttr extends SkinAttr {
    @Override // com.tencent.shadow.core.runtime.skin.entity.SkinAttr
    public boolean applyInner(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (isColorAttr()) {
                textView.setTextColor(getColorStateList());
                return true;
            }
            return false;
        }
        return false;
    }
}
