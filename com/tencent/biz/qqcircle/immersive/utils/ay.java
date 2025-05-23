package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets.QFSGradientTextView;
import com.tencent.biz.qqcircle.utils.cx;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    private static final int f90165a = cx.a(24.0f);

    /* renamed from: b, reason: collision with root package name */
    private static final int f90166b = cx.a(12.0f);

    /* renamed from: c, reason: collision with root package name */
    private static int f90167c;

    /* renamed from: d, reason: collision with root package name */
    private static int f90168d;

    /* renamed from: e, reason: collision with root package name */
    private static int f90169e;

    /* renamed from: f, reason: collision with root package name */
    private static int f90170f;

    private static void a(@NonNull View view, @NonNull View view2) {
        view.measure(0, 0);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        f90167c = iArr[0] + view.getMeasuredWidth();
        f90168d = iArr[0] + view.getMeasuredWidth() + f90165a;
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        int i3 = iArr2[0];
        f90169e = i3 - f90166b;
        f90170f = i3;
    }

    public static void b(List<com.tencent.biz.qqcircle.immersive.views.h> list, View view, View view2) {
        if (list != null && list.size() != 0 && view != null && view2 != null) {
            a(view, view2);
            c(list);
        }
    }

    private static void c(@NonNull List<com.tencent.biz.qqcircle.immersive.views.h> list) {
        int i3;
        Iterator<com.tencent.biz.qqcircle.immersive.views.h> it = list.iterator();
        while (it.hasNext()) {
            QFSGradientTextView b16 = it.next().b();
            int currentTextColor = b16.getCurrentTextColor();
            int[] iArr = new int[2];
            b16.getLocationInWindow(iArr);
            int alpha = Color.alpha(currentTextColor);
            int red = Color.red(currentTextColor);
            int green = Color.green(currentTextColor);
            int blue = Color.blue(currentTextColor);
            int width = b16.getWidth();
            int i16 = f90167c;
            if (i16 > 0 && (i3 = f90170f) > 0 && width > 0) {
                int i17 = iArr[0];
                int i18 = f90168d;
                if (i17 < i18 && i17 > i16) {
                    b16.setGradient(0.0f, 0.0f, i18 - i17, 0.0f, Color.argb(((i17 - i16) * alpha) / f90165a, red, green, blue), Color.argb(alpha, red, green, blue));
                } else if (i17 <= i16 && i17 + width >= i18) {
                    b16.setGradient(i16 - i17, 0.0f, i18 - i17, 0.0f, Color.argb(0, red, green, blue), Color.argb(alpha, red, green, blue));
                } else if (i17 + width > i16 && i17 + width < i18) {
                    b16.setGradient(i16 - i17, 0.0f, width, 0.0f, Color.argb(0, red, green, blue), Color.argb((((i17 + width) - i16) * alpha) / f90165a, red, green, blue));
                } else {
                    int i19 = i17 + width;
                    int i26 = f90169e;
                    if (i19 > i26 && i17 + width < i3) {
                        b16.setGradient(i26 - i17, 0.0f, width, 0.0f, Color.argb(alpha, red, green, blue), Color.argb((((i3 - i17) - width) * alpha) / f90165a, red, green, blue));
                    } else if (width + i17 >= i3 && i17 <= i26) {
                        b16.setGradient(i26 - i17, 0.0f, i3 - i17, 0.0f, Color.argb(alpha, red, green, blue), Color.argb(0, red, green, blue));
                    } else if (i17 > i26 && i17 < i3) {
                        b16.setGradient(0.0f, 0.0f, i3 - i17, 0.0f, Color.argb(((i3 - i17) * alpha) / f90165a, red, green, blue), Color.argb(0, red, green, blue));
                    } else {
                        b16.a();
                    }
                }
            } else {
                Log.e("QFSTabMaskUtils", "intercept mask leftMaskStart: " + f90167c + " sRightMaskEnd: " + f90170f + " width: " + width);
                return;
            }
        }
    }
}
