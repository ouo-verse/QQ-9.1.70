package com.tencent.luggage.wxa.ll;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f133596a;

    /* renamed from: b, reason: collision with root package name */
    public int f133597b = 0;

    public b(ViewGroup viewGroup) {
        this.f133596a = viewGroup;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View next() {
        ViewGroup viewGroup = this.f133596a;
        int i3 = this.f133597b;
        this.f133597b = i3 + 1;
        return viewGroup.getChildAt(i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f133597b < this.f133596a.getChildCount()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f133596a.removeViewAt(this.f133597b - 1);
    }
}
