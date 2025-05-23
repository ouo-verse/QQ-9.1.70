package com.tencent.mobileqq.qqlive.sail.ui.more;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\t\u0010\u001aR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "f", "()I", "nameResId", "b", "iconResId", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "d", "iconUrl", WadlProxyConsts.KEY_JUMP_URL, "", UserInfo.SEX_FEMALE, "()F", "height", "g", "Z", "getShowRedPoint", "()Z", "showRedPoint", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;FZ)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int nameResId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int iconResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float height;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean showRedPoint;

    public h(int i3, int i16, @NotNull String name, @NotNull String iconUrl, @NotNull String jumpUrl, float f16, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), name, iconUrl, jumpUrl, Float.valueOf(f16), Boolean.valueOf(z16));
            return;
        }
        this.nameResId = i3;
        this.iconResId = i16;
        this.name = name;
        this.iconUrl = iconUrl;
        this.jumpUrl = jumpUrl;
        this.height = f16;
        this.showRedPoint = z16;
    }

    public final float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.height;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.iconResId;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.iconUrl;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.jumpUrl;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.name;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.nameResId == hVar.nameResId && this.iconResId == hVar.iconResId && Intrinsics.areEqual(this.name, hVar.name) && Intrinsics.areEqual(this.iconUrl, hVar.iconUrl) && Intrinsics.areEqual(this.jumpUrl, hVar.jumpUrl) && Float.compare(this.height, hVar.height) == 0 && this.showRedPoint == hVar.showRedPoint) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.nameResId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        int hashCode = ((((((((((this.nameResId * 31) + this.iconResId) * 31) + this.name.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + Float.floatToIntBits(this.height)) * 31;
        boolean z16 = this.showRedPoint;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "MorePanelBtnInfo(nameResId=" + this.nameResId + ", iconResId=" + this.iconResId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", height=" + this.height + ", showRedPoint=" + this.showRedPoint + ")";
    }

    public /* synthetic */ h(int i3, int i16, String str, String str2, String str3, float f16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? "" : str3, (i17 & 32) != 0 ? 0.0f : f16, (i17 & 64) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, Float.valueOf(f16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
