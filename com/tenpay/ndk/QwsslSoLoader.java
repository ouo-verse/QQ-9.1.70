package com.tenpay.ndk;

import com.tenpay.QwLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QwsslSoLoader {
    private static final String QWSSL_SO_NAME = "qwssl_1.0.2";
    private static final String QWSSL_SO_VERSION = "1.0.2";
    private static final AtomicBoolean mIsLoaded = new AtomicBoolean(false);

    public static synchronized void loadSo() {
        synchronized (QwsslSoLoader.class) {
            if (mIsLoaded.compareAndSet(false, true)) {
                try {
                    QwLog.i("load so: qwssl_1.0.2");
                    System.loadLibrary(QWSSL_SO_NAME);
                } catch (Throwable th5) {
                    QwLog.i("load so qwssl_1.0.2fail: " + th5);
                }
            }
        }
    }
}
