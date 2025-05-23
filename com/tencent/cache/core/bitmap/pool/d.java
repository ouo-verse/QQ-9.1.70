package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque<c> f98688a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f98688a = new ArrayDeque<>(20);
        }
    }

    @NotNull
    public final c a(int i3, @NotNull Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        c poll = this.f98688a.poll();
        if (poll != null) {
            poll.f98686b = i3;
            Intrinsics.checkNotNullParameter(config, "<set-?>");
            poll.f98687c = config;
            return poll;
        }
        return new c(this, i3, config);
    }
}
