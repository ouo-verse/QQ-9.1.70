package com.tencent.mobileqq.activity.richmedia;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f185860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f185861b;

    public i(int i3, int i16) {
        this.f185860a = i3;
        this.f185861b = i16;
    }

    public int a() {
        return this.f185861b;
    }

    public int b() {
        return this.f185860a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f185860a != iVar.f185860a || this.f185861b != iVar.f185861b) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.f185860a + HippyTKDListViewAdapter.X + this.f185861b;
    }
}
