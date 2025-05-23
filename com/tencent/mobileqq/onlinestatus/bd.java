package com.tencent.mobileqq.onlinestatus;

import android.util.SparseArray;
import android.view.View;

/* compiled from: P */
/* loaded from: classes16.dex */
public class bd {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<View> f255579a = new SparseArray<>();

    public void a(int i3, View view) {
        if (this.f255579a.size() >= 3) {
            return;
        }
        this.f255579a.put(i3, view);
    }

    public View b(int i3) {
        if (i3 >= this.f255579a.size()) {
            return null;
        }
        return this.f255579a.valueAt(i3);
    }

    public View c(int i3) {
        if (this.f255579a.size() > 0) {
            View view = this.f255579a.get(i3);
            if (view != null) {
                this.f255579a.remove(i3);
            }
            return view;
        }
        return null;
    }

    public int d() {
        return this.f255579a.size();
    }
}
