package com.tencent.mobileqq.triton.font;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class TTFTableName {
    private final String name;
    public static final TTFTableName TABLE_DIRECTORY = new TTFTableName("tableDirectory");
    public static final TTFTableName NAME = new TTFTableName("name");

    TTFTableName(String str) {
        this.name = str;
    }

    public static TTFTableName getValue(String str) {
        if (str != null) {
            return new TTFTableName(str);
        }
        throw new IllegalArgumentException("A TrueType font table name must not be null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TTFTableName)) {
            return false;
        }
        return this.name.equals(((TTFTableName) obj).getName());
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }
}
