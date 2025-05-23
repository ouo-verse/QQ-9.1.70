package com.qq.e.comm.plugin.base.ad.e;

import android.graphics.Rect;
import android.view.View;
import com.qq.e.comm.plugin.k.n;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static Random f38829a = new Random();

    public static double a(View view) {
        if (view == null || view.getVisibility() != 0 || !c(view)) {
            return 0.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || rect.left >= n.c(view.getContext()) || rect.top >= n.d(view.getContext()) || rect.right <= 0 || rect.bottom <= 0) {
            return 0.0d;
        }
        return ((rect.width() * 1.0d) * rect.height()) / (view.getWidth() * view.getHeight());
    }

    public static boolean b(View view) {
        if (view != null && view.getVisibility() == 0 && c(view)) {
            return view.getGlobalVisibleRect(new Rect());
        }
        return false;
    }

    private static boolean c(View view) {
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }
}
