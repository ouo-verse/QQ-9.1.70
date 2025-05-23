package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c implements com.tencent.cache.core.bitmap.base.lrucache.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final d f98685a;

    /* renamed from: b, reason: collision with root package name */
    public int f98686b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Bitmap.Config f98687c;

    public c(@NotNull d keyPool, int i3, @NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(keyPool, "keyPool");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, keyPool, Integer.valueOf(i3), config);
            return;
        }
        this.f98685a = keyPool;
        this.f98686b = i3;
        this.f98687c = config;
    }

    @Override // com.tencent.cache.core.bitmap.base.lrucache.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        d dVar = this.f98685a;
        dVar.getClass();
        Intrinsics.checkNotNullParameter(this, "key");
        if (dVar.f98688a.size() < 20) {
            dVar.f98688a.offer(this);
        }
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f98686b == cVar.f98686b && this.f98687c == cVar.f98687c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f98687c.hashCode() + (this.f98686b * 31);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return '[' + this.f98686b + "](" + this.f98687c + ')';
    }
}
