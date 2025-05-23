package com.tencent.mobileqq.mini.cache;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class Entry {
    public static final String DATA_SPLITER = ":";
    public static final String DATA_TYPE_Array = "Array";
    public static final String DATA_TYPE_OBJ = "Object";
    public static final String DATA_TYPE_STRING = "String";
    public static HashMap<String, Coder> sCoderList = new HashMap<>();
    public String mContent;
    public String mDataType;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static abstract class Coder {
        public String mDataType;

        Coder() {
        }

        public abstract String decoder(String str);

        public abstract String encode(String str);
    }

    public String decode() {
        return null;
    }

    public String encode() {
        return this.mContent + ":" + this.mDataType;
    }
}
