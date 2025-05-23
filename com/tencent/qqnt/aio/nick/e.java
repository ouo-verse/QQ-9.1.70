package com.tencent.qqnt.aio.nick;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/nick/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/util/SparseArray;", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/util/SparseArray;", "getNumberDrawable", "()Landroid/util/SparseArray;", "numberDrawable", "b", "Landroid/graphics/drawable/Drawable;", "getLvDrawable", "()Landroid/graphics/drawable/Drawable;", "lvDrawable", "c", "background", "<init>", "(Landroid/util/SparseArray;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SparseArray<Drawable> numberDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable lvDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable background;

    public e(@Nullable SparseArray<Drawable> sparseArray, @Nullable Drawable drawable, @NotNull Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sparseArray, drawable, background);
            return;
        }
        this.numberDrawable = sparseArray;
        this.lvDrawable = drawable;
        this.background = background;
    }

    @NotNull
    public final Drawable a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.background;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.numberDrawable, eVar.numberDrawable) && Intrinsics.areEqual(this.lvDrawable, eVar.lvDrawable) && Intrinsics.areEqual(this.background, eVar.background)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        SparseArray<Drawable> sparseArray = this.numberDrawable;
        int i3 = 0;
        if (sparseArray == null) {
            hashCode = 0;
        } else {
            hashCode = sparseArray.hashCode();
        }
        int i16 = hashCode * 31;
        Drawable drawable = this.lvDrawable;
        if (drawable != null) {
            i3 = drawable.hashCode();
        }
        return ((i16 + i3) * 31) + this.background.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "MemberLevelDrawable(numberDrawable=" + this.numberDrawable + ", lvDrawable=" + this.lvDrawable + ", background=" + this.background + ")";
    }
}
