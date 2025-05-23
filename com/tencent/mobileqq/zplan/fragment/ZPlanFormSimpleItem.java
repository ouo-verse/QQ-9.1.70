package com.tencent.mobileqq.zplan.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSimpleItem;

/* loaded from: classes34.dex */
public class ZPlanFormSimpleItem extends FormSimpleItem {
    public ZPlanFormSimpleItem(Context context) {
        super(context);
    }

    public ZPlanFormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mobileqq.widget.FormSimpleItem
    protected Drawable e(Resources resources, int i3) {
        if (i3 == 1) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i5q);
        }
        if (i3 == 2) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i5o);
        }
        if (i3 != 3) {
            return ContextCompat.getDrawable(getContext(), R.drawable.i5p);
        }
        return ContextCompat.getDrawable(getContext(), R.drawable.i5n);
    }
}
