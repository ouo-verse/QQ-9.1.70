package com.tencent.luggage.wxa.kj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q1 {
    public static void a(View view, View view2, Canvas canvas) {
        if (!a(view2, canvas) && (view2 instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2;
            viewGroup.draw(canvas);
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                float x16 = childAt.getX();
                float y16 = childAt.getY();
                canvas.save();
                canvas.translate(x16, y16);
                a(view, childAt, canvas);
                canvas.restore();
            }
        }
    }

    public static void b(View view, Canvas canvas) {
        a(view, view, canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(View view, Canvas canvas) {
        if (view.getVisibility() != 0) {
            return true;
        }
        if (view instanceof com.tencent.luggage.wxa.hp.a) {
            return ((com.tencent.luggage.wxa.hp.a) view).a(canvas);
        }
        if (view instanceof ViewGroup) {
            return false;
        }
        view.draw(canvas);
        return true;
    }

    public static Bitmap a(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        a(view, view, new Canvas(createBitmap));
        return createBitmap;
    }
}
