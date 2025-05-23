package com.tencent.cache.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/cache/api/g;", "", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "value", "", "I", "()I", "size", "<init>", "(Ljava/lang/Object;I)V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int size;

    public g(@NotNull Object value, int i3) {
        Intrinsics.checkNotNullParameter(value, "value");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, value, i3);
        } else {
            this.value = value;
            this.size = i3;
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.size;
    }

    @NotNull
    public final Object b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }
}
