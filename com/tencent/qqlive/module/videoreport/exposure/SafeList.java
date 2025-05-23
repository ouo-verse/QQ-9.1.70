package com.tencent.qqlive.module.videoreport.exposure;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class SafeList<T> extends ArrayList<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeList(int i3) {
        super(i3);
    }

    private void ensureElement(int i3) {
        while (size() < i3) {
            add(initValue());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T get(int i3) {
        ensureElement(i3 + 1);
        return (T) super.get(i3);
    }

    abstract T initValue();

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i3, T t16) {
        ensureElement(i3 + 1);
        return (T) super.set(i3, t16);
    }
}
