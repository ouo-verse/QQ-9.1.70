package com.tencent.mvi.base.route;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<Integer, WeakReference<String>> f337762a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f337762a = new LruCache<>(50);
        }
    }

    private static String a(Class cls) {
        Class<?> enclosingClass = cls.getEnclosingClass();
        if (enclosingClass == null) {
            return cls.getName();
        }
        String a16 = a(enclosingClass);
        if (a16 == null) {
            return null;
        }
        return a16 + "." + cls.getSimpleName();
    }

    @MainThread
    @NotNull
    public static String b(Class<?> cls) {
        String str;
        int hashCode = cls.hashCode();
        LruCache<Integer, WeakReference<String>> lruCache = f337762a;
        WeakReference<String> weakReference = lruCache.get(Integer.valueOf(hashCode));
        if (weakReference != null) {
            str = weakReference.get();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            String a16 = a(cls);
            lruCache.put(Integer.valueOf(hashCode), new WeakReference<>(a16));
            return a16;
        }
        return str;
    }
}
