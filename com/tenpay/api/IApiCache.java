package com.tenpay.api;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IApiCache extends IApiBase {
    public static final String LOGIC = "com.tenpay.impl.ApiCacheImpl";

    Object getUinValue(String str, String str2, Object obj);

    Object getValue(String str, Object obj);

    void removeKey(String str);

    void removeUinKey(String str, String str2);

    boolean resetCacheTime(String str, long j3);

    boolean resetUinCacheTime(String str, String str2, long j3);

    void setUinValue(String str, String str2, Object obj, long j3);

    void setValue(String str, Object obj, long j3);
}
