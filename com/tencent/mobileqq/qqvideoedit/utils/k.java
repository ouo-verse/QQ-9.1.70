package com.tencent.mobileqq.qqvideoedit.utils;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import java.io.File;
import org.libpag.PAGFile;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    private static volatile k f276254b;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, PAGFile> f276255a;

    k() {
        this.f276255a = null;
        this.f276255a = new LruCache<>(10);
    }

    private void a() {
        if (this.f276255a == null) {
            this.f276255a = new LruCache<>(10);
        }
    }

    public static k b() {
        if (f276254b == null) {
            synchronized (k.class) {
                if (f276254b == null) {
                    f276254b = new k();
                }
            }
        }
        return f276254b;
    }

    public PAGFile c(String str) {
        a();
        if (!TextUtils.isEmpty(str)) {
            PAGFile pAGFile = this.f276255a.get(str);
            if (pAGFile != null) {
                return pAGFile.copyOriginal();
            }
            if (new File(str).exists()) {
                PAGFile Load = PagViewMonitor.Load(str);
                if (Load != null) {
                    this.f276255a.put(str, Load);
                    return Load;
                }
                return Load;
            }
            return pAGFile;
        }
        return null;
    }
}
