package com.tencent.hippy.qq.adapter.image.decoder;

import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AvifLibraryLoader {
    public static final String AVIF_SO_NAME = "avif-jni";
    private static String TAG = "AvifLibraryLoader";
    private static AtomicBoolean mIsLibReady = new AtomicBoolean(false);
    private static AtomicBoolean mIsLoading = new AtomicBoolean(false);

    public static boolean isLibReady() {
        return mIsLibReady.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadLibrary$0(int i3, LoadExtResult loadExtResult) {
        QLog.i(TAG, 1, "avif load result:" + i3);
        mIsLoading.set(false);
        if (i3 == 0) {
            mIsLibReady.set(true);
        } else {
            mIsLibReady.set(false);
        }
    }

    public static synchronized void loadLibrary() {
        synchronized (AvifLibraryLoader.class) {
            try {
                QLog.i(TAG, 1, "ready to load avif so. isReady:" + mIsLibReady.get());
            } finally {
            }
            if (mIsLibReady.get()) {
                return;
            }
            if (mIsLoading.get()) {
                return;
            }
            mIsLoading.set(true);
            SoLoadManager.getInstance().load(AVIF_SO_NAME, new OnLoadListener() { // from class: com.tencent.hippy.qq.adapter.image.decoder.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    AvifLibraryLoader.lambda$loadLibrary$0(i3, loadExtResult);
                }
            });
        }
    }

    public static void onDecodeAvifFailure(String str) {
        QLog.i(TAG, 1, str);
        mIsLibReady.set(false);
    }
}
