package com.qzone.app;

import com.tencent.hippy.qq.adapter.image.decoder.AvifLibraryLoader;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f44490a = "QzoneAvifLibraryLoader";

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f44491b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f44492c = new AtomicBoolean(false);

    public static boolean b() {
        return f44491b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(int i3, LoadExtResult loadExtResult) {
        QLog.i(f44490a, 1, "avif load result:" + i3);
        f44492c.set(false);
        if (i3 == 0) {
            f44491b.set(true);
        } else {
            f44491b.set(false);
        }
    }

    public static synchronized void d() {
        synchronized (j.class) {
            try {
                QLog.i(f44490a, 1, "ready to load avif so. isReady:" + f44491b.get());
            } finally {
            }
            if (f44491b.get()) {
                return;
            }
            if (f44492c.get()) {
                return;
            }
            f44492c.set(true);
            SoLoadManager.getInstance().load(AvifLibraryLoader.AVIF_SO_NAME, new OnLoadListener() { // from class: com.qzone.app.i
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    j.c(i3, loadExtResult);
                }
            });
        }
    }
}
