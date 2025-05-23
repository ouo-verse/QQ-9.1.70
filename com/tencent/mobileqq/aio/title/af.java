package com.tencent.mobileqq.aio.title;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u001e\u0010\u001fJ?\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\t\u0010\f\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\r\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u0015\u0010\u001aR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/title/af;", "", "", "showRedDot", "visiable", "Landroid/graphics/drawable/Drawable;", "src", "", "contentDescription", "", "from", "a", "toString", "hashCode", "other", "equals", "Z", "d", "()Z", "b", "f", "c", "Landroid/graphics/drawable/Drawable;", "e", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/String;", "()Ljava/lang/String;", "I", "getFrom", "()I", "<init>", "(ZZLandroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class af {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean showRedDot;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean visiable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable src;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String contentDescription;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int from;

    public af(boolean z16, boolean z17, @Nullable Drawable drawable, @Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), drawable, str, Integer.valueOf(i3));
            return;
        }
        this.showRedDot = z16;
        this.visiable = z17;
        this.src = drawable;
        this.contentDescription = str;
        this.from = i3;
    }

    public static /* synthetic */ af b(af afVar, boolean z16, boolean z17, Drawable drawable, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = afVar.showRedDot;
        }
        if ((i16 & 2) != 0) {
            z17 = afVar.visiable;
        }
        boolean z18 = z17;
        if ((i16 & 4) != 0) {
            drawable = afVar.src;
        }
        Drawable drawable2 = drawable;
        if ((i16 & 8) != 0) {
            str = afVar.contentDescription;
        }
        String str2 = str;
        if ((i16 & 16) != 0) {
            i3 = afVar.from;
        }
        return afVar.a(z16, z18, drawable2, str2, i3);
    }

    @NotNull
    public final af a(boolean showRedDot, boolean visiable, @Nullable Drawable src, @Nullable String contentDescription, int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (af) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(showRedDot), Boolean.valueOf(visiable), src, contentDescription, Integer.valueOf(from));
        }
        return new af(showRedDot, visiable, src, contentDescription, from);
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.contentDescription;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.showRedDot;
    }

    @Nullable
    public final Drawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.src;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof af)) {
            return false;
        }
        af afVar = (af) other;
        if (this.showRedDot == afVar.showRedDot && this.visiable == afVar.visiable && Intrinsics.areEqual(this.src, afVar.src) && Intrinsics.areEqual(this.contentDescription, afVar.contentDescription) && this.from == afVar.from) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.visiable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        boolean z16 = this.showRedDot;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.visiable;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i17 = (i16 + i3) * 31;
        Drawable drawable = this.src;
        int i18 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int i19 = (i17 + hashCode) * 31;
        String str = this.contentDescription;
        if (str != null) {
            i18 = str.hashCode();
        }
        return ((i19 + i18) * 31) + this.from;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "Right1IvData(showRedDot=" + this.showRedDot + ", visiable=" + this.visiable + ", src=" + this.src + ", contentDescription=" + this.contentDescription + ", from=" + this.from + ")";
    }
}
