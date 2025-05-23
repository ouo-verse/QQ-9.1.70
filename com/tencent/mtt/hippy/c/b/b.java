package com.tencent.mtt.hippy.c.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Object obj) {
        super(String.format("[%s] could not be cloned", r0));
        String str;
        Object[] objArr = new Object[1];
        if (obj != null) {
            str = obj.toString();
        } else {
            str = "null";
        }
        objArr[0] = str;
    }
}
