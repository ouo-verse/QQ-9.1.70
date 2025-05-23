package com.tencent.mtt.hippy.c.c.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    protected final int f337135a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f337136b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            this.f337135a = i3;
            this.f337136b = i16;
            return;
        }
        throw new NegativeArraySizeException();
    }
}
