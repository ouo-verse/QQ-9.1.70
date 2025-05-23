package com.tencent.mobileqq.mutualmark.widget.util;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f252468a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f252468a = new LruCache<>(10);
        }
    }

    public static boolean a(@NonNull String str) {
        return b(str, 500L);
    }

    public static boolean b(@NonNull String str, long j3) {
        LruCache<String, Long> lruCache = f252468a;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 == null) {
            lruCache.put(str, valueOf);
            return false;
        }
        if (Math.abs(valueOf.longValue() - l3.longValue()) >= j3) {
            lruCache.put(str, valueOf);
            return false;
        }
        return true;
    }
}
