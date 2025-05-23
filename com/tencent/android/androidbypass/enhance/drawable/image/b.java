package com.tencent.android.androidbypass.enhance.drawable.image;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/image/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "contextRef", "b", "I", "c", "()I", "mBackgroundColor", "fontColor", "<init>", "(Ljava/lang/ref/WeakReference;II)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mBackgroundColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int fontColor;

    public b(@NotNull WeakReference<Context> contextRef, int i3, int i16) {
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, contextRef, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.contextRef = contextRef;
        this.mBackgroundColor = i3;
        this.fontColor = i16;
    }

    @NotNull
    public final WeakReference<Context> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (WeakReference) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.contextRef;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.fontColor;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mBackgroundColor;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof b) {
                b bVar = (b) other;
                if (!Intrinsics.areEqual(this.contextRef, bVar.contextRef) || this.mBackgroundColor != bVar.mBackgroundColor || this.fontColor != bVar.fontColor) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference != null) {
            i3 = weakReference.hashCode();
        } else {
            i3 = 0;
        }
        return (((i3 * 31) + this.mBackgroundColor) * 31) + this.fontColor;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "LoadingDrawableParam(contextRef=" + this.contextRef + ", mBackgroundColor=" + this.mBackgroundColor + ", fontColor=" + this.fontColor + ")";
    }
}
