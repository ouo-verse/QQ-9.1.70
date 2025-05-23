package com.tencent.av.foldable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a extends h<Integer> {
    public a() {
        super(-1);
    }

    public abstract int f();

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        int i3;
        int f16 = f();
        if (f16 >= 30 && f16 <= 150) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        e(Integer.valueOf(i3));
    }
}
