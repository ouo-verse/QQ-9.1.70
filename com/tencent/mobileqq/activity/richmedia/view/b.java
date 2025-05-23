package com.tencent.mobileqq.activity.richmedia.view;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends Animation {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f186108d;

    /* renamed from: e, reason: collision with root package name */
    private int f186109e;

    public b(ArrayList<Integer> arrayList) {
        b(arrayList);
    }

    public int a() {
        return this.f186109e;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f16, Transformation transformation) {
        super.applyTransformation(f16, transformation);
        ArrayList<Integer> arrayList = this.f186108d;
        if (arrayList != null && arrayList.size() >= 2) {
            float size = 1.0f / (this.f186108d.size() - 1);
            int i3 = (int) (f16 / size);
            float f17 = (f16 - (i3 * size)) / size;
            if (i3 == this.f186108d.size() - 1) {
                i3 = this.f186108d.size() - 2;
            }
            int intValue = this.f186108d.get(i3).intValue();
            int intValue2 = this.f186108d.get(i3 + 1).intValue();
            if (f16 < 1.0f) {
                intValue2 = Color.argb((int) (Color.alpha(intValue) + ((Color.alpha(intValue2) - Color.alpha(intValue)) * f17)), (int) (Color.red(intValue) + ((Color.red(intValue2) - Color.red(intValue)) * f17)), (int) (Color.green(intValue) + ((Color.green(intValue2) - Color.green(intValue)) * f17)), (int) (Color.blue(intValue) + (f17 * (Color.blue(intValue2) - Color.blue(intValue)))));
            }
            this.f186109e = intValue2;
        }
    }

    public void b(ArrayList<Integer> arrayList) {
        this.f186108d = arrayList;
    }
}
