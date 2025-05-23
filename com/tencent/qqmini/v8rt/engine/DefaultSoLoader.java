package com.tencent.qqmini.v8rt.engine;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DefaultSoLoader implements LibLoader {
    public static final String LOG_TAG = "DefaultSoLoader";

    @Override // com.tencent.qqmini.v8rt.engine.LibLoader
    public boolean loadSo() {
        try {
            System.loadLibrary("tv8rt");
            Logger.i(LOG_TAG, "loadSo success");
            return true;
        } catch (Exception e16) {
            Logger.e(LOG_TAG, "loadSo Error", e16);
            return false;
        }
    }
}
