package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, Bitmap> f96011a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final short[] f96012b = {13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 196, 127, 128, 130, 131, 132, 133, 134, 7};

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Integer> f96013c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f96014d = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);

    public static Drawable a(int i3, float f16, Context context, Drawable.Callback callback) {
        int i16 = (int) ((f16 * 22.0d) + 0.5d);
        try {
            Drawable drawable = context.getResources().getDrawable(o.f96037h[i3]);
            drawable.setBounds(0, 0, i16, i16);
            return drawable;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Drawable b(int i3, float f16, Context context, Drawable.Callback callback) {
        int i16 = (int) ((f16 * 22.0d) + 0.5d);
        try {
            Drawable drawable = context.getResources().getDrawable(o.f96036g[i3]);
            drawable.setBounds(0, 0, i16, i16);
            return drawable;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void c(Context context, SpannableStringBuilder spannableStringBuilder) {
        try {
            if (TextUtils.isEmpty(spannableStringBuilder)) {
                return;
            }
            float f16 = context.getResources().getDisplayMetrics().density;
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            int i3 = 0;
            while (true) {
                String[] strArr = o.f96034e;
                if (i3 < strArr.length) {
                    int indexOf = spannableStringBuilder2.indexOf(strArr[i3]);
                    while (indexOf >= 0) {
                        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(a(i3, f16, context, null), 0);
                        String[] strArr2 = o.f96034e;
                        spannableStringBuilder.setSpan(verticalCenterImageSpan, indexOf, strArr2[i3].length() + indexOf, 33);
                        String str = strArr2[i3];
                        indexOf = spannableStringBuilder2.indexOf(str, indexOf + str.length());
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }
}
