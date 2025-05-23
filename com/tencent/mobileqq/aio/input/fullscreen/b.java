package com.tencent.mobileqq.aio.input.fullscreen;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/b;", "", "Lcom/tencent/mobileqq/aio/input/fullscreen/a;", "a", "", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "path", "Landroid/net/Uri;", "b", "Landroid/net/Uri;", "getOriginUri", "()Landroid/net/Uri;", "originUri", "", "c", "Z", "isRwa", "()Z", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri originUri;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isRwa;

    public b(@NotNull String path, @Nullable Uri uri, boolean z16) {
        Intrinsics.checkNotNullParameter(path, "path");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, path, uri, Boolean.valueOf(z16));
            return;
        }
        this.path = path;
        this.originUri = uri;
        this.isRwa = z16;
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return p.f189662a.a(this.path, this.originUri, this.isRwa);
    }
}
