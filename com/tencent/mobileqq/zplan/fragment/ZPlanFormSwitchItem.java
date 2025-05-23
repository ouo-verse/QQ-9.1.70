package com.tencent.mobileqq.zplan.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;

/* loaded from: classes34.dex */
public class ZPlanFormSwitchItem extends FormSwitchItem {
    public ZPlanFormSwitchItem(Context context) {
        super(context);
    }

    public ZPlanFormSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.widget.FormSwitchItem
    protected Drawable getSelectorByTypeInternal(Resources resources, int i3) {
        if (i3 == 1) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i2z);
        }
        if (i3 == 2) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i2v);
        }
        if (i3 != 3) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i2x);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.i2t);
    }
}
