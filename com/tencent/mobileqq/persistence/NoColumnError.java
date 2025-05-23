package com.tencent.mobileqq.persistence;

/* compiled from: P */
/* loaded from: classes16.dex */
public class NoColumnError extends Error {
    public String mColumnName;
    public Class mColumnType;

    public NoColumnError() {
    }

    public NoColumnError(String str) {
        super(str);
    }

    public NoColumnError(String str, Class cls) {
        super("No_Such_Column_" + str);
        this.mColumnName = str;
        this.mColumnType = cls;
    }
}
