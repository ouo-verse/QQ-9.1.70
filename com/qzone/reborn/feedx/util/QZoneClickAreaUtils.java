package com.qzone.reborn.feedx.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneClickAreaUtils {
    public static void b(View view, List<View> list, int i3) {
        Rect rect = new Rect();
        rect.left = i3;
        rect.top = i3;
        rect.right = i3;
        rect.bottom = i3;
        c(view, list, rect);
    }

    public static void a(View view, int i3) {
        if (view == null || !(view.getParent() instanceof View)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        b((View) view.getParent(), arrayList, i3);
    }

    public static void c(final View view, final List<View> list, final Rect rect) {
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.qzone.reborn.feedx.util.QZoneClickAreaUtils.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a(view);
                for (View view2 : list) {
                    Rect rect2 = new Rect();
                    view2.getHitRect(rect2);
                    int i3 = rect2.top;
                    Rect rect3 = rect;
                    rect2.top = i3 - rect3.top;
                    rect2.bottom += rect3.bottom;
                    rect2.left -= rect3.left;
                    rect2.right += rect3.right;
                    aVar.a(new TouchDelegate(rect2, view2));
                }
                view.setTouchDelegate(aVar);
            }
        });
    }
}
