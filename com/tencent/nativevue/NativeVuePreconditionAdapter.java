package com.tencent.nativevue;

/* loaded from: classes21.dex */
public interface NativeVuePreconditionAdapter {

    /* loaded from: classes21.dex */
    public interface LoadSoResult {
        void onLoadError();

        void onLoadSuccess();
    }

    void loadNativeVueSo(LoadSoResult loadSoResult);
}
