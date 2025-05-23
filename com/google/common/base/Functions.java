package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Functions {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private enum ToStringFunction implements d<Object, String> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        @Override // com.google.common.base.d
        public String apply(Object obj) {
            j.m(obj);
            return obj.toString();
        }
    }

    public static d<Object, String> a() {
        return ToStringFunction.INSTANCE;
    }
}
