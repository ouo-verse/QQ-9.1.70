package com.tencent.mobileqq.wink.newalbum.forward;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f324232b;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f324233a = new AtomicBoolean(false);

    private boolean a(WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        if (FileUtils.fileExists(winkNewAlbumResFetchResult.getSoLibOpenMPPath()) && FileUtils.fileExists(winkNewAlbumResFetchResult.getSoLibCryptoPath()) && FileUtils.fileExists(winkNewAlbumResFetchResult.getSoLibSslPath()) && FileUtils.fileExists(winkNewAlbumResFetchResult.getSoLibNcnnPath()) && FileUtils.fileExists(winkNewAlbumResFetchResult.getSoLibWeClipPath())) {
            return true;
        }
        return false;
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f324232b == null) {
                synchronized (f.class) {
                    if (f324232b == null) {
                        f324232b = new f();
                    }
                }
            }
            fVar = f324232b;
        }
        return fVar;
    }

    public boolean c(WinkNewAlbumResFetchResult winkNewAlbumResFetchResult) {
        boolean z16;
        if (this.f324233a.get()) {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardSoManager", 1, "already loaded so!");
            return true;
        }
        if (!a(winkNewAlbumResFetchResult)) {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardSoManager", 1, "So files don't all exist!");
            return false;
        }
        try {
            System.load(winkNewAlbumResFetchResult.getSoLibOpenMPPath());
            System.load(winkNewAlbumResFetchResult.getSoLibCryptoPath());
            System.load(winkNewAlbumResFetchResult.getSoLibSslPath());
            System.load(winkNewAlbumResFetchResult.getSoLibNcnnPath());
            System.load(winkNewAlbumResFetchResult.getSoLibWeClipPath());
            this.f324233a.set(true);
        } catch (Throwable th5) {
            th = th5;
            z16 = false;
        }
        try {
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardSoManager", 1, "load all so complete!");
            return true;
        } catch (Throwable th6) {
            th = th6;
            z16 = true;
            QLog.d("WinkNewAlbum_WinkNewAlbumForwardSoManager", 1, th, new Object[0]);
            return z16;
        }
    }
}
