package com.tencent.ark.mmkv;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MMKVManager {
    private static IMMKV mMMKV;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class LazyHolder {
        static final MMKVManager gInstance = new MMKVManager();

        LazyHolder() {
        }
    }

    public static MMKVManager getInstance() {
        return LazyHolder.gInstance;
    }

    public IMMKV getArkMMKV() {
        return mMMKV;
    }

    public void setMMKV(IMMKV immkv) {
        mMMKV = immkv;
    }
}
