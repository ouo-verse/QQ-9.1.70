package com.tencent.qqnt.aio.avatar.egg;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJA\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/avatar/egg/a;", "", "", "operationType", "Landroid/view/View;", "headEffectView", "atmosphereView", "fullScreenView", "changeFlag", "a", "", "toString", "hashCode", "other", "", "equals", "I", "g", "()I", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "c", "d", "e", h.F, "(I)V", "<init>", "(ILandroid/view/View;Landroid/view/View;Landroid/view/View;I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int operationType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View headEffectView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View atmosphereView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View fullScreenView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int changeFlag;

    public a(int i3, @Nullable View view, @Nullable View view2, @Nullable View view3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), view, view2, view3, Integer.valueOf(i16));
            return;
        }
        this.operationType = i3;
        this.headEffectView = view;
        this.atmosphereView = view2;
        this.fullScreenView = view3;
        this.changeFlag = i16;
    }

    public static /* synthetic */ a b(a aVar, int i3, View view, View view2, View view3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = aVar.operationType;
        }
        if ((i17 & 2) != 0) {
            view = aVar.headEffectView;
        }
        View view4 = view;
        if ((i17 & 4) != 0) {
            view2 = aVar.atmosphereView;
        }
        View view5 = view2;
        if ((i17 & 8) != 0) {
            view3 = aVar.fullScreenView;
        }
        View view6 = view3;
        if ((i17 & 16) != 0) {
            i16 = aVar.changeFlag;
        }
        return aVar.a(i3, view4, view5, view6, i16);
    }

    @NotNull
    public final a a(int operationType, @Nullable View headEffectView, @Nullable View atmosphereView, @Nullable View fullScreenView, int changeFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(operationType), headEffectView, atmosphereView, fullScreenView, Integer.valueOf(changeFlag));
        }
        return new a(operationType, headEffectView, atmosphereView, fullScreenView, changeFlag);
    }

    @Nullable
    public final View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.atmosphereView;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.changeFlag;
    }

    @Nullable
    public final View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fullScreenView;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.operationType == aVar.operationType && Intrinsics.areEqual(this.headEffectView, aVar.headEffectView) && Intrinsics.areEqual(this.atmosphereView, aVar.atmosphereView) && Intrinsics.areEqual(this.fullScreenView, aVar.fullScreenView) && this.changeFlag == aVar.changeFlag) {
            return true;
        }
        return false;
    }

    @Nullable
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.headEffectView;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.operationType;
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.changeFlag = i3;
        }
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int i3 = this.operationType * 31;
        View view = this.headEffectView;
        int i16 = 0;
        if (view == null) {
            hashCode = 0;
        } else {
            hashCode = view.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        View view2 = this.atmosphereView;
        if (view2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = view2.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        View view3 = this.fullScreenView;
        if (view3 != null) {
            i16 = view3.hashCode();
        }
        return ((i18 + i16) * 31) + this.changeFlag;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "AvatarEggInfo(operationType=" + this.operationType + ", headEffectView=" + this.headEffectView + ", atmosphereView=" + this.atmosphereView + ", fullScreenView=" + this.fullScreenView + ", changeFlag=" + this.changeFlag + ")";
    }

    public /* synthetic */ a(int i3, View view, View view2, View view3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? null : view, (i17 & 4) != 0 ? null : view2, (i17 & 8) != 0 ? null : view3, (i17 & 16) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, view2, view3, Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
