package com.tencent.timi.game.team.impl;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static ColorDrawable f379404a = new ColorDrawable(1224736767);

    private static int[] a(List<String> list, int i3) {
        if (list != null && list.size() != 0) {
            int[] iArr = new int[list.size()];
            for (int i16 = 0; i16 < list.size(); i16++) {
                iArr[i16] = Color.parseColor(list.get(i16));
            }
            return iArr;
        }
        if (i3 > 0) {
            return new int[]{i3};
        }
        return new int[0];
    }

    public static URLDrawable.URLDrawableOptions b(URLImageView uRLImageView, Drawable drawable) {
        Drawable drawable2;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable3 = uRLImageView.getDrawable();
        if (drawable3 != null) {
            drawable2 = drawable3;
        } else {
            drawable2 = f379404a;
        }
        obtain.mLoadingDrawable = drawable2;
        if (drawable == null) {
            if (drawable3 != null) {
                drawable = drawable3;
            } else {
                drawable = f379404a;
            }
        }
        obtain.mFailedDrawable = drawable;
        return obtain;
    }

    public static void c(TextView textView, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            textView.setTextColor(i3);
        } else {
            textView.setTextColor(Color.parseColor(str));
        }
    }

    public static void d(View view, List<String> list, int i3) {
        e(view, list, i3, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void e(View view, List<String> list, int i3, float f16, float f17, float f18, float f19) {
        boolean z16;
        int[] a16 = a(list, i3);
        if (f16 <= 0.0f && f17 <= 0.0f && f18 <= 0.0f && f19 <= 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && a16.length <= 1) {
            if (a16.length == 1) {
                view.setBackgroundColor(a16[0]);
                return;
            }
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (a16.length > 1) {
            gradientDrawable.setColors(a16);
        } else if (a16.length == 1) {
            gradientDrawable.setColor(a16[0]);
        }
        if (!z16) {
            gradientDrawable.setCornerRadii(new float[]{f16, f16, f17, f17, f19, f19, f18, f18});
        }
        view.setBackgroundDrawable(gradientDrawable);
    }

    public static void f(URLImageView uRLImageView, String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            Drawable drawable = null;
            if (i3 > 0) {
                drawable = ResourcesCompat.getDrawable(MobileQQ.sMobileQQ.getResources(), i3, null);
            }
            com.tencent.timi.game.utils.b.g(uRLImageView, str, b(uRLImageView, drawable));
            return;
        }
        if (i3 > 0) {
            uRLImageView.setImageResource(i3);
        }
    }
}
