package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config[] f98680a;

    /* renamed from: b, reason: collision with root package name */
    public static final Bitmap.Config[] f98681b;

    /* renamed from: c, reason: collision with root package name */
    public static final Bitmap.Config[] f98682c;

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f98683d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final b f98684e;

    static {
        Bitmap.Config[] configArr;
        Bitmap.Config config;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13563);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98684e = new b();
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, config};
        } else {
            configArr = new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        }
        f98680a = configArr;
        f98681b = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f98682c = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f98683d = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Set<Bitmap.Config> a() {
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Bitmap.Config[] array = Bitmap.Config.values();
        Intrinsics.checkNotNullParameter(array, "array");
        HashSet hashSet = new HashSet();
        for (Bitmap.Config config2 : array) {
            hashSet.add(config2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return hashSet;
    }

    @NotNull
    public final Bitmap.Config[] b(@NotNull Bitmap.Config requested) {
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap.Config[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) requested);
        }
        Intrinsics.checkNotNullParameter(requested, "requested");
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            if (config == requested) {
                return f98680a;
            }
        }
        int i3 = a.f98679a[requested.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return new Bitmap.Config[]{requested};
                    }
                    return f98683d;
                }
                return f98682c;
            }
            return f98681b;
        }
        return f98680a;
    }
}
