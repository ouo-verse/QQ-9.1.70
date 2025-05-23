package com.tencent.qqnt.avatar.layer;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/avatar/layer/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "b", "()Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Z", "()Z", "clipOutOfChild", "c", "sourceRect", "<init>", "(Landroid/graphics/Rect;ZLandroid/graphics/Rect;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Rect rect;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean clipOutOfChild;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Rect sourceRect;

    public c() {
        this(null, false, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.clipOutOfChild;
    }

    @Nullable
    public final Rect b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Rect) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rect;
    }

    @Nullable
    public final Rect c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Rect) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sourceRect;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.rect, cVar.rect) && this.clipOutOfChild == cVar.clipOutOfChild && Intrinsics.areEqual(this.sourceRect, cVar.sourceRect)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        Rect rect = this.rect;
        int i3 = 0;
        if (rect == null) {
            hashCode = 0;
        } else {
            hashCode = rect.hashCode();
        }
        int i16 = hashCode * 31;
        boolean z16 = this.clipOutOfChild;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        Rect rect2 = this.sourceRect;
        if (rect2 != null) {
            i3 = rect2.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "ResourceDrawConfig(rect=" + this.rect + ", clipOutOfChild=" + this.clipOutOfChild + ", sourceRect=" + this.sourceRect + ")";
    }

    public c(@Nullable Rect rect, boolean z16, @Nullable Rect rect2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rect, Boolean.valueOf(z16), rect2);
            return;
        }
        this.rect = rect;
        this.clipOutOfChild = z16;
        this.sourceRect = rect2;
    }

    public /* synthetic */ c(Rect rect, boolean z16, Rect rect2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : rect, (i3 & 2) != 0 ? false : z16, (i3 & 4) == 0 ? rect2 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, rect, Boolean.valueOf(z16), rect2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
