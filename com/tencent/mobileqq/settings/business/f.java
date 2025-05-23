package com.tencent.mobileqq.settings.business;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0011\u0010\fR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/settings/business/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "b", "f", "text", "c", "iconToken", "iconUrl", "e", WadlProxyConsts.KEY_JUMP_URL, "Z", "()Z", "setShowSwitch", "(Z)V", "showSwitch", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconToken;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean showSwitch;

    public f(@NotNull String sceneId, @NotNull String text, @NotNull String iconToken, @NotNull String iconUrl, @NotNull String jumpUrl, boolean z16) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(iconToken, "iconToken");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sceneId, text, iconToken, iconUrl, jumpUrl, Boolean.valueOf(z16));
            return;
        }
        this.sceneId = sceneId;
        this.text = text;
        this.iconToken = iconToken;
        this.iconUrl = iconUrl;
        this.jumpUrl = jumpUrl;
        this.showSwitch = z16;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.iconToken;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.iconUrl;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.jumpUrl;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sceneId;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.showSwitch;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.sceneId, fVar.sceneId) && Intrinsics.areEqual(this.text, fVar.text) && Intrinsics.areEqual(this.iconToken, fVar.iconToken) && Intrinsics.areEqual(this.iconUrl, fVar.iconUrl) && Intrinsics.areEqual(this.jumpUrl, fVar.jumpUrl) && this.showSwitch == fVar.showSwitch) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int hashCode = ((((((((this.sceneId.hashCode() * 31) + this.text.hashCode()) * 31) + this.iconToken.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31;
        boolean z16 = this.showSwitch;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "GrowthPushSwitchItem(sceneId=" + this.sceneId + ", text=" + this.text + ", iconToken=" + this.iconToken + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", showSwitch=" + this.showSwitch + ")";
    }

    public /* synthetic */ f(String str, String str2, String str3, String str4, String str5, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i3 & 32) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
