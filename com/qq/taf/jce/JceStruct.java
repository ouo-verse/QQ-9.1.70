package com.qq.taf.jce;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class JceStruct implements Serializable {
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

    public static String toDisplaySimpleString(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        jceStruct.displaySimple(sb5, 0);
        return sb5.toString();
    }

    public boolean containField(String str) {
        return false;
    }

    public Object getFieldByName(String str) {
        return null;
    }

    public JceStruct newInit() {
        return null;
    }

    public abstract void readFrom(JceInputStream jceInputStream);

    public byte[] toByteArray() {
        JceOutputStream jceOutputStream = new JceOutputStream();
        writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        display(sb5, 0);
        return sb5.toString();
    }

    public abstract void writeTo(JceOutputStream jceOutputStream);

    public byte[] toByteArray(String str) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(str);
        writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
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
