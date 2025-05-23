package com.qq.e.comm.adevent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ADEvent {

    /* renamed from: a, reason: collision with root package name */
    private final int f38125a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f38126b;

    public ADEvent(int i3) {
        this(i3, null);
    }

    public Object[] getParas() {
        Object[] objArr = this.f38126b;
        if (objArr == null) {
            return new Object[0];
        }
        return objArr;
    }

    public int getType() {
        return this.f38125a;
    }

    public ADEvent(int i3, Object[] objArr) {
        this.f38125a = i3;
        this.f38126b = objArr;
    }
}
