package com.tencent.mobileqq.aio.input.fullscreen;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/a;", "Landroid/text/style/ImageSpan;", "Lcom/tencent/mobileqq/aio/input/fullscreen/b;", "d", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "getOriginDrawable", "()Landroid/graphics/drawable/Drawable;", "setOriginDrawable", "(Landroid/graphics/drawable/Drawable;)V", "originDrawable", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "path", "Landroid/net/Uri;", "f", "Landroid/net/Uri;", "a", "()Landroid/net/Uri;", "originUri", "", tl.h.F, "Z", "c", "()Z", "isRwa", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/net/Uri;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends ImageSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable originDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Uri originUri;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isRwa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Drawable originDrawable, @NotNull String path, @Nullable Uri uri, boolean z16) {
        super(originDrawable);
        Intrinsics.checkNotNullParameter(originDrawable, "originDrawable");
        Intrinsics.checkNotNullParameter(path, "path");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, originDrawable, path, uri, Boolean.valueOf(z16));
            return;
        }
        this.originDrawable = originDrawable;
        this.path = path;
        this.originUri = uri;
        this.isRwa = z16;
    }

    @Nullable
    public final Uri a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Uri) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.originUri;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.path;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isRwa;
    }

    @NotNull
    public final b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new b(this.path, this.originUri, this.isRwa);
    }
}
