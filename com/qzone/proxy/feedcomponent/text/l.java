package com.qzone.proxy.feedcomponent.text;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class l extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<TextCellLayout> f50756d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f50757e;

    /* renamed from: f, reason: collision with root package name */
    private int f50758f;

    public l(TextCellLayout textCellLayout, ArrayList<Integer> arrayList) {
        b(textCellLayout, arrayList);
    }

    public int a() {
        return this.f50758f;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f16, Transformation transformation) {
        ArrayList<Integer> arrayList;
        super.applyTransformation(f16, transformation);
        if (this.f50756d == null || (arrayList = this.f50757e) == null || arrayList.size() < 2 || this.f50756d.get() == null) {
            return;
        }
        float size = 1.0f / (this.f50757e.size() - 1);
        int i3 = (int) (f16 / size);
        float f17 = (f16 - (i3 * size)) / size;
        if (i3 == this.f50757e.size() - 1) {
            i3 = this.f50757e.size() - 2;
        }
        int intValue = this.f50757e.get(i3).intValue();
        int intValue2 = this.f50757e.get(i3 + 1).intValue();
        if (f16 < 1.0f) {
            intValue2 = Color.argb((int) (Color.alpha(intValue) + ((Color.alpha(intValue2) - Color.alpha(intValue)) * f17)), (int) (Color.red(intValue) + ((Color.red(intValue2) - Color.red(intValue)) * f17)), (int) (Color.green(intValue) + ((Color.green(intValue2) - Color.green(intValue)) * f17)), (int) (Color.blue(intValue) + (f17 * (Color.blue(intValue2) - Color.blue(intValue)))));
        }
        this.f50758f = intValue2;
    }

    public void b(TextCellLayout textCellLayout, ArrayList<Integer> arrayList) {
        this.f50756d = new WeakReference<>(textCellLayout);
        this.f50757e = arrayList;
    }
}
