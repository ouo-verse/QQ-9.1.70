package com.tenpay.cache;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ICacheEnc {
    public static final int LENGTH_OF_TIME = 10;

    String cacheDec(String str);

    String cacheEnc(String str);

    String hashKey(String str);
}
