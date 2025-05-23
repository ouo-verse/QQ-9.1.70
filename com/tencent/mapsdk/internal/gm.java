package com.tencent.mapsdk.internal;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gm {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<gl> f148506a = new ArrayList<>();

    private gl a(int i3) {
        return this.f148506a.get(i3);
    }

    private int b() {
        return this.f148506a.size();
    }

    public final void a(gl glVar) {
        this.f148506a.add(glVar);
    }

    private void a(gm gmVar) {
        this.f148506a.addAll(gmVar.f148506a);
    }

    public final float[] a() {
        float[] fArr = new float[this.f148506a.size() * 3];
        for (int i3 = 0; i3 < this.f148506a.size(); i3++) {
            int i16 = i3 * 3;
            fArr[i16 + 0] = this.f148506a.get(i3).f148502a;
            fArr[i16 + 1] = this.f148506a.get(i3).f148503b;
            fArr[i16 + 2] = this.f148506a.get(i3).f148504c;
        }
        return fArr;
    }
}
