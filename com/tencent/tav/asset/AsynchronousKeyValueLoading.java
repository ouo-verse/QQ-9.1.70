package com.tencent.tav.asset;

import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface AsynchronousKeyValueLoading {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface loadCallback {
        void loadSucceeds();
    }

    void loadValuesAsynchronouslyForKeys(List<String> list, loadCallback loadcallback);

    int statusOfValueForKey(String str) throws Exception;
}
