package com.tencent.biz.subscribe.part;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static Bitmap a(Resources resources, int i3, Integer num, Integer num2) {
        int intValue;
        int intValue2;
        Drawable drawable = resources.getDrawable(i3);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            if (drawable.getIntrinsicWidth() > 0) {
                intValue = drawable.getIntrinsicWidth();
            } else {
                intValue = num.intValue();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                intValue2 = drawable.getIntrinsicHeight();
            } else {
                intValue2 = num2.intValue();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intValue, intValue2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            gradientDrawable.setBounds(0, 0, intValue, intValue2);
            gradientDrawable.setStroke(1, -16777216);
            gradientDrawable.setFilterBitmap(true);
            gradientDrawable.draw(canvas);
            return createBitmap;
        }
        if (drawable instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            Bitmap createBitmap2 = Bitmap.createBitmap(num.intValue(), num2.intValue(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            colorDrawable.setBounds(0, 0, num.intValue(), num2.intValue());
            colorDrawable.setFilterBitmap(true);
            colorDrawable.draw(canvas2);
            return createBitmap2;
        }
        return BitmapFactory.decodeResource(resources, i3).copy(Bitmap.Config.ARGB_8888, true);
    }

    public static TextView b(Context context, float f16, String str, String str2) {
        TextView textView = new TextView(context);
        textView.setTextSize(1, f16);
        textView.setTextColor(Color.parseColor(str));
        textView.setText(str2);
        return textView;
    }
}
