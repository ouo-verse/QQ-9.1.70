package com.tencent.luggage.wxa.d1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static Drawable a(Context context) {
        int i3;
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            i3 = R.drawable.f162705of1;
        } else {
            i3 = R.drawable.f162704of0;
        }
        return ContextCompat.getDrawable(context.getApplicationContext(), i3);
    }
}
