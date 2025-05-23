package com.tencent.mobileqq.persistence;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OGColumn {
    public String defaultValue;
    public String name;
    public Class<?> type;

    public OGColumn() {
    }

    public String toString() {
        return this.name;
    }

    public OGColumn(Class<?> cls, String str, String str2) {
        this.type = cls;
        this.name = str;
        this.defaultValue = str2;
    }
}
