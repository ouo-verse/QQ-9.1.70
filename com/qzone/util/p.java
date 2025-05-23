package com.qzone.util;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f59828a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Field f59829b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Field f59830c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Field f59831d = null;

    /* renamed from: e, reason: collision with root package name */
    private static Field f59832e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f59833f = false;

    static {
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mFlingRunnable");
            f59829b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = p.class.getClassLoader().loadClass("android.widget.AbsListView$FlingRunnable").getDeclaredField("mScroller");
            f59830c = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = p.class.getClassLoader().loadClass("android.widget.OverScroller").getDeclaredField("mScrollerY");
            f59831d = declaredField3;
            declaredField3.setAccessible(true);
            Field declaredField4 = p.class.getClassLoader().loadClass("android.widget.OverScroller$SplineOverScroller").getDeclaredField("mCurrVelocity");
            f59832e = declaredField4;
            declaredField4.setAccessible(true);
            f59828a = true;
        } catch (Exception unused) {
            f59828a = false;
        }
    }

    public static boolean a(com.tencent.widget.AbsListView absListView, int i3) {
        if (f59833f) {
            return false;
        }
        float b16 = b(absListView);
        if (Float.isNaN(b16)) {
            f59833f = true;
            return false;
        }
        float abs = Math.abs(b16);
        return abs > 0.0f && abs < ((float) i3) / 2.0f;
    }

    public static float b(com.tencent.widget.AbsListView absListView) {
        if (absListView != null && f59828a) {
            try {
                return ((Float) f59832e.get(f59831d.get(f59830c.get(f59829b.get(absListView))))).floatValue();
            } catch (Exception unused) {
            }
        }
        return Float.NaN;
    }
}
