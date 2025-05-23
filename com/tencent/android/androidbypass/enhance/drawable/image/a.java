package com.tencent.android.androidbypass.enhance.drawable.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/drawable/image/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "contextRef", "b", "I", "d", "()I", "mBackgroundColor", "c", "fontColor", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "failedTipsDrawable", "<init>", "(Ljava/lang/ref/WeakReference;IILandroid/graphics/drawable/Drawable;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mBackgroundColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int fontColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable failedTipsDrawable;

    public a(@NotNull WeakReference<Context> contextRef, int i3, int i16, @NotNull Drawable failedTipsDrawable) {
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(failedTipsDrawable, "failedTipsDrawable");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, contextRef, Integer.valueOf(i3), Integer.valueOf(i16), failedTipsDrawable);
            return;
        }
        this.contextRef = contextRef;
        this.mBackgroundColor = i3;
        this.fontColor = i16;
        this.failedTipsDrawable = failedTipsDrawable;
    }

    @NotNull
    public final WeakReference<Context> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (WeakReference) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.contextRef;
    }

    @NotNull
    public final Drawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.failedTipsDrawable;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.fontColor;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mBackgroundColor;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (!Intrinsics.areEqual(this.contextRef, aVar.contextRef) || this.mBackgroundColor != aVar.mBackgroundColor || this.fontColor != aVar.fontColor || !Intrinsics.areEqual(this.failedTipsDrawable, aVar.failedTipsDrawable)) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        WeakReference<Context> weakReference = this.contextRef;
        int i16 = 0;
        if (weakReference != null) {
            i3 = weakReference.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = ((((i3 * 31) + this.mBackgroundColor) * 31) + this.fontColor) * 31;
        Drawable drawable = this.failedTipsDrawable;
        if (drawable != null) {
            i16 = drawable.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "LoadFailedDrawableParam(contextRef=" + this.contextRef + ", mBackgroundColor=" + this.mBackgroundColor + ", fontColor=" + this.fontColor + ", failedTipsDrawable=" + this.failedTipsDrawable + ")";
    }
}
