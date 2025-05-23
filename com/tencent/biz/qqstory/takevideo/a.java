package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f94270a;

    /* renamed from: b, reason: collision with root package name */
    private static int f94271b;

    /* renamed from: c, reason: collision with root package name */
    private static float f94272c;

    public static float a(Resources resources) {
        if (f94271b == 0 || f94270a == 0) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            f94270a = i3;
            int i16 = displayMetrics.heightPixels;
            f94271b = i16;
            f94272c = (i16 * 1.0f) / i3;
        }
        return f94272c;
    }

    public static int b(Resources resources) {
        if (f94270a == 0) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            f94270a = i3;
            int i16 = displayMetrics.heightPixels;
            f94271b = i16;
            f94272c = (i16 * 1.0f) / i3;
        }
        return f94270a;
    }
}
