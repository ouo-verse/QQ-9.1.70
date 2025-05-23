package com.tencent.luggage.wxa.kj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class s1 {
    public static void a(Canvas canvas, View view, float f16, float f17) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof TextureView) {
            Bitmap bitmap = ((TextureView) view).getBitmap(view.getWidth(), view.getHeight());
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(bitmap, f16, f17, (Paint) null);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                a(canvas, childAt, childAt.getX() + f16, childAt.getY() + f17);
            }
            return;
        }
        canvas.save();
        canvas.translate(f16, f17);
        view.draw(canvas);
        canvas.restore();
    }

    public static boolean a(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        boolean z16 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof TextureView) {
                z16 = true;
            }
            if (childAt instanceof ViewGroup) {
                z16 = a((ViewGroup) childAt);
            }
            if (z16) {
                break;
            }
        }
        return z16;
    }
}
