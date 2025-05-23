package com.tencent.mobileqq.main.api;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/main/api/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "avatarLayout", "b", "d", "nameLayout", "c", "e", "optionLayout", "contentView", "bottomView", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View avatarLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View nameLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View optionLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View bottomView;

    public a(@Nullable View view, @Nullable View view2, @Nullable View view3, @Nullable View view4, @Nullable View view5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, view2, view3, view4, view5);
            return;
        }
        this.avatarLayout = view;
        this.nameLayout = view2;
        this.optionLayout = view3;
        this.contentView = view4;
        this.bottomView = view5;
    }

    @Nullable
    public final View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.avatarLayout;
    }

    @Nullable
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.bottomView;
    }

    @Nullable
    public final View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.contentView;
    }

    @Nullable
    public final View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.nameLayout;
    }

    @Nullable
    public final View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.optionLayout;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.avatarLayout, aVar.avatarLayout) && Intrinsics.areEqual(this.nameLayout, aVar.nameLayout) && Intrinsics.areEqual(this.optionLayout, aVar.optionLayout) && Intrinsics.areEqual(this.contentView, aVar.contentView) && Intrinsics.areEqual(this.bottomView, aVar.bottomView)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        View view = this.avatarLayout;
        int i3 = 0;
        if (view == null) {
            hashCode = 0;
        } else {
            hashCode = view.hashCode();
        }
        int i16 = hashCode * 31;
        View view2 = this.nameLayout;
        if (view2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = view2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        View view3 = this.optionLayout;
        if (view3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = view3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        View view4 = this.contentView;
        if (view4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = view4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        View view5 = this.bottomView;
        if (view5 != null) {
            i3 = view5.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "AccessibilitySeqParam(avatarLayout=" + this.avatarLayout + ", nameLayout=" + this.nameLayout + ", optionLayout=" + this.optionLayout + ", contentView=" + this.contentView + ", bottomView=" + this.bottomView + ")";
    }
}
