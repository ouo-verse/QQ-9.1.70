package com.tencent.mobileqq.aio.title;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0019\u0010\u000bR%\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u0015\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/title/ah;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "showRedDot", "b", "e", "visiable", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "src", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "type", "f", "isSelectedMode", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "viewInit", "<init>", "(ZZLandroid/graphics/drawable/Drawable;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean showRedDot;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean visiable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable src;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelectedMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<View, Unit> viewInit;

    public ah(boolean z16, boolean z17, @Nullable Drawable drawable, @NotNull String type, boolean z18, @Nullable Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), drawable, type, Boolean.valueOf(z18), function1);
            return;
        }
        this.showRedDot = z16;
        this.visiable = z17;
        this.src = drawable;
        this.type = type;
        this.isSelectedMode = z18;
        this.viewInit = function1;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.showRedDot;
    }

    @Nullable
    public final Drawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.src;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.type;
    }

    @Nullable
    public final Function1<View, Unit> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Function1) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.viewInit;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.visiable;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ah)) {
            return false;
        }
        ah ahVar = (ah) other;
        if (this.showRedDot == ahVar.showRedDot && this.visiable == ahVar.visiable && Intrinsics.areEqual(this.src, ahVar.src) && Intrinsics.areEqual(this.type, ahVar.type) && this.isSelectedMode == ahVar.isSelectedMode && Intrinsics.areEqual(this.viewInit, ahVar.viewInit)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isSelectedMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        boolean z16 = this.showRedDot;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.visiable;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        Drawable drawable = this.src;
        int i19 = 0;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        int hashCode2 = (((i18 + hashCode) * 31) + this.type.hashCode()) * 31;
        boolean z17 = this.isSelectedMode;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i26 = (hashCode2 + i3) * 31;
        Function1<View, Unit> function1 = this.viewInit;
        if (function1 != null) {
            i19 = function1.hashCode();
        }
        return i26 + i19;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "Right3IvData(showRedDot=" + this.showRedDot + ", visiable=" + this.visiable + ", src=" + this.src + ", type=" + this.type + ", isSelectedMode=" + this.isSelectedMode + ", viewInit=" + this.viewInit + ")";
    }
}
