package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {
    public static Drawable a(Resources resources, int i3, int i16, boolean z16, int i17, int i18, Drawable drawable, boolean z17) {
        Drawable drawable2;
        LayerDrawable layerDrawable;
        Drawable drawable3 = resources.getDrawable(i3);
        if (z16) {
            drawable2 = aw.a(resources, i3, i16);
        } else {
            drawable2 = drawable3;
        }
        drawable2.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        Drawable drawable4 = resources.getDrawable(i17);
        aw a16 = aw.a(resources, i17, i18);
        a16.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        if (drawable == null) {
            if (z17) {
                layerDrawable = new LayerDrawable(new Drawable[]{drawable2});
                layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            } else {
                layerDrawable = new LayerDrawable(new Drawable[]{a16, drawable2});
                layerDrawable.setLayerInset(0, 0, 0, 0, 0);
                layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            }
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{a16, drawable2, drawable});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            layerDrawable.setLayerInset(1, 0, 0, 0, 0);
            layerDrawable.setLayerInset(2, 0, 0, 0, 0);
        }
        layerDrawable.setBounds(0, 0, drawable4.getIntrinsicWidth(), drawable4.getIntrinsicHeight());
        return layerDrawable;
    }

    public static Drawable b(Resources resources, int i3, boolean z16, boolean z17) {
        int i16;
        if (z17) {
            i16 = R.color.c_e;
        } else {
            i16 = R.color.f157514ro;
        }
        return a(resources, i3, R.color.f157511rl, true, R.drawable.d_p, i16, null, z16);
    }

    public static Drawable c(Resources resources, int i3, boolean z16, boolean z17, boolean z18) {
        int i16;
        if (z18) {
            i16 = R.color.c_e;
        } else {
            i16 = R.color.f157514ro;
        }
        return a(resources, i3, R.color.f157511rl, z16, R.drawable.d_p, i16, null, z17);
    }

    public static Drawable d(Resources resources, int i3, Drawable drawable, boolean z16, boolean z17, boolean z18) {
        int i16;
        if (z18) {
            i16 = R.color.c_e;
        } else {
            i16 = R.color.f157514ro;
        }
        return a(resources, i3, R.color.f157511rl, z16, R.drawable.d_p, i16, drawable, z17);
    }
}
