package com.tencent.mapsdk.internal;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class p implements Serializable {
    public static final byte BYTE = 0;
    public static final byte DOUBLE = 5;
    public static final byte FLOAT = 4;
    public static final byte INT = 2;
    public static final int JCE_MAX_STRING_LENGTH = 104857600;
    public static final byte LIST = 9;
    public static final byte LONG = 3;
    public static final byte MAP = 8;
    public static final byte SHORT = 1;
    public static final byte SIMPLE_LIST = 13;
    public static final byte STRING1 = 6;
    public static final byte STRING4 = 7;
    public static final byte STRUCT_BEGIN = 10;
    public static final byte STRUCT_END = 11;
    public static final byte ZERO_TAG = 12;

    /* renamed from: a, reason: collision with root package name */
    private Object f149481a;

    public static String toDisplaySimpleString(p pVar) {
        if (pVar == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        pVar.displaySimple(sb5, 0);
        return sb5.toString();
    }

    public String className() {
        return "";
    }

    public boolean containField(String str) {
        return false;
    }

    public Object getFieldByName(String str) {
        return null;
    }

    public Object getTag() {
        return this.f149481a;
    }

    public p newInit() {
        return null;
    }

    public abstract void readFrom(m mVar);

    public void setTag(Object obj) {
        this.f149481a = obj;
    }

    public byte[] toByteArray() {
        n nVar = new n();
        writeTo(nVar);
        return nVar.a();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        display(sb5, 0);
        return sb5.toString();
    }

    public abstract void writeTo(n nVar);

    public byte[] toByteArray(String str) {
        n nVar = new n();
        nVar.a(str);
        writeTo(nVar);
        return nVar.a();
    }

    public void recyle() {
    }

    public void display(StringBuilder sb5, int i3) {
    }

    public void displaySimple(StringBuilder sb5, int i3) {
    }

    public void setFieldByName(String str, Object obj) {
    }
}
