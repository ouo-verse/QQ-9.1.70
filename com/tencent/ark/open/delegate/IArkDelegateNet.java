package com.tencent.ark.open.delegate;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IArkDelegateNet {
    void get(String str, HashMap<String, String> hashMap, IArkDelegateHTTPCallback iArkDelegateHTTPCallback);

    int getNetworkType();

    boolean isNetworkAvailable();

    void post(String str, HashMap<String, String> hashMap, byte[] bArr, IArkDelegateHTTPCallback iArkDelegateHTTPCallback);
}
