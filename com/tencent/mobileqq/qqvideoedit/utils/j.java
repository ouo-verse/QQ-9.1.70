package com.tencent.mobileqq.qqvideoedit.utils;

import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFont;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static volatile j f276252b;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, PAGFont> f276253a;

    j() {
        this.f276253a = null;
        this.f276253a = new LruCache<>(10);
    }

    private void a() {
        if (this.f276253a == null) {
            this.f276253a = new LruCache<>(10);
        }
    }

    public static j c() {
        if (f276252b == null) {
            synchronized (j.class) {
                if (f276252b == null) {
                    f276252b = new j();
                }
            }
        }
        return f276252b;
    }

    private boolean d(String str) {
        PAGFont RegisterFont;
        a();
        if (this.f276253a.get(str) != null) {
            return true;
        }
        if (!new File(str).exists() || (RegisterFont = PAGFont.RegisterFont(str)) == null) {
            return false;
        }
        this.f276253a.put(str, RegisterFont);
        return true;
    }

    public PAGFont b(String str) {
        if (d(str)) {
            return this.f276253a.get(str);
        }
        return null;
    }
}
