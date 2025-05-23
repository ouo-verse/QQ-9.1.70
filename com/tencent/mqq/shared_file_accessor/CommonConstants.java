package com.tencent.mqq.shared_file_accessor;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public class CommonConstants {
    static final String CMD_CLR = "3";
    static final String CMD_COMMIT = "5";
    static final String CMD_DEL = "2";
    static final String CMD_GET = "0";
    static final String CMD_LOG = "101";
    static final String CMD_PUT = "1";
    static final String CMD_SYNC_FILENAME = "4";
    static final String KEY_FOR_DELETE_ALL = "*";
    static final String KEY_FOR_GET_ALL = "*";
    static final boolean NOT_USE_CP_IF_POSSIBLE = true;
    static final String URI_PARAM_CMD = "cmd";
    static final String URI_PARAM_KEY_DEFAULT_VALUE = "default";
    static final String URI_PARAM_KEY_FILE = "file";
    static final String URI_PARAM_KEY_KEY = "key";
    static final String URI_PARAM_KEY_LOG = "log";
    static final String URI_PARAM_KEY_PROCESS = "process";
    static final String URI_PARAM_KEY_VALUE_TYPE = "value_type";
    public static final ValueType VALUE_TYPE_ANY;
    public static final ValueType VALUE_TYPE_BOOLEAN;
    public static final ValueType VALUE_TYPE_FLOAT;
    public static final ValueType VALUE_TYPE_INT;
    public static final ValueType VALUE_TYPE_LONG;
    public static final ValueType VALUE_TYPE_STRING;
    public static final ValueType VALUE_TYPE_STRSET;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class ValueType {
        public static final int VALUE_TYPE_ENUM_ANY = 0;
        public static final int VALUE_TYPE_ENUM_BOOLEAN = 5;
        public static final int VALUE_TYPE_ENUM_FLOAT = 3;
        public static final int VALUE_TYPE_ENUM_INT = 1;
        public static final int VALUE_TYPE_ENUM_LONG = 2;
        public static final int VALUE_TYPE_ENUM_STRING = 4;
        public static final int VALUE_TYPE_ENUM_STRSET = 6;
        public int mEnumValue;
        public String mTypeName;

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Integer) {
                if (this.mEnumValue != ((Integer) obj).intValue()) {
                    return false;
                }
                return true;
            }
            if (obj instanceof String) {
                return this.mTypeName.equals(obj);
            }
            return super.equals(obj);
        }

        public String toString() {
            return this.mTypeName;
        }

        ValueType(int i3, String str) {
            this.mEnumValue = i3;
            this.mTypeName = str;
        }
    }

    static {
        VALUE_TYPE_ANY = new ValueType(0, "*");
        VALUE_TYPE_INT = new ValueType(1, Integer.class.getName());
        VALUE_TYPE_LONG = new ValueType(2, Long.class.getName());
        VALUE_TYPE_FLOAT = new ValueType(3, Float.class.getName());
        VALUE_TYPE_STRING = new ValueType(4, String.class.getName());
        VALUE_TYPE_BOOLEAN = new ValueType(5, Boolean.class.getName());
        VALUE_TYPE_STRSET = new ValueType(6, Set.class.getName());
    }
}
