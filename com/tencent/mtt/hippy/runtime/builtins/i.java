package com.tencent.mtt.hippy.runtime.builtins;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class i implements Cloneable {
    public static boolean a(Object obj) {
        return obj instanceof i;
    }

    public static Object b(Object obj) throws CloneNotSupportedException {
        if (obj instanceof i) {
            return ((i) obj).clone();
        }
        return obj;
    }

    public boolean j() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.a.a;
    }

    public boolean k() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.a.b;
    }

    public boolean l() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.a.c;
    }

    public boolean m() {
        return this instanceof e;
    }

    public boolean n() {
        return this instanceof c;
    }

    public boolean o() {
        return this instanceof g;
    }

    public boolean p() {
        return this instanceof d;
    }

    public boolean q() {
        return this instanceof h;
    }

    public boolean r() {
        return this instanceof b;
    }

    public boolean s() {
        return this instanceof JSSharedArrayBuffer;
    }

    public boolean t() {
        return this instanceof a;
    }

    public boolean u() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.b.b;
    }

    public boolean v() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.b.e;
    }

    public boolean w() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.b.a;
    }

    public boolean x() {
        return this instanceof com.tencent.mtt.hippy.runtime.builtins.b.c;
    }
}
