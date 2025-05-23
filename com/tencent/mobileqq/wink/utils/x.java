package com.tencent.mobileqq.wink.utils;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import java.io.File;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes21.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    private static volatile x f326737b;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, PAGFile> f326738a;

    x() {
        this.f326738a = null;
        this.f326738a = new LruCache<>(10);
    }

    private void a() {
        if (this.f326738a == null) {
            this.f326738a = new LruCache<>(10);
        }
    }

    public static x b() {
        if (f326737b == null) {
            synchronized (x.class) {
                if (f326737b == null) {
                    f326737b = new x();
                }
            }
        }
        return f326737b;
    }

    public PAGFile c(String str) {
        a();
        if (!TextUtils.isEmpty(str)) {
            PAGFile pAGFile = this.f326738a.get(str);
            if (pAGFile != null) {
                return pAGFile.copyOriginal();
            }
            if (new File(str).exists()) {
                PAGFile Load = PagViewMonitor.Load(str);
                if (Load != null) {
                    this.f326738a.put(str, Load);
                    return Load;
                }
                return Load;
            }
            return pAGFile;
        }
        return null;
    }
}
