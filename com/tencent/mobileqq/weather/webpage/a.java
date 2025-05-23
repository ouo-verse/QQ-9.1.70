package com.tencent.mobileqq.weather.webpage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\t\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/weather/webpage/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "appName", "b", h.F, "(Ljava/lang/String;)V", "appMeta", "d", "appVersion", "e", QQCustomArkDialogUtil.APP_VIEW, "I", "g", "()I", "pushType", "f", VasWebviewConstants.KEY_PAGE_URL, "", "Ljava/util/List;", "()Ljava/util/List;", "advPosIDs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appMeta;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int pushType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String pageUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> advPosIDs;

    public a(@NotNull String appName, @NotNull String appMeta, @NotNull String appVersion, @NotNull String appView, int i3, @NotNull String pageUrl, @NotNull List<String> advPosIDs) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appMeta, "appMeta");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appView, "appView");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        Intrinsics.checkNotNullParameter(advPosIDs, "advPosIDs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appName, appMeta, appVersion, appView, Integer.valueOf(i3), pageUrl, advPosIDs);
            return;
        }
        this.appName = appName;
        this.appMeta = appMeta;
        this.appVersion = appVersion;
        this.appView = appView;
        this.pushType = i3;
        this.pageUrl = pageUrl;
        this.advPosIDs = advPosIDs;
    }

    @NotNull
    public final List<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.advPosIDs;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appMeta;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appName;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appVersion;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.appView;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.appName, aVar.appName) && Intrinsics.areEqual(this.appMeta, aVar.appMeta) && Intrinsics.areEqual(this.appVersion, aVar.appVersion) && Intrinsics.areEqual(this.appView, aVar.appView) && this.pushType == aVar.pushType && Intrinsics.areEqual(this.pageUrl, aVar.pageUrl) && Intrinsics.areEqual(this.advPosIDs, aVar.advPosIDs)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.pageUrl;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.pushType;
    }

    public final void h(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appMeta = str;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return (((((((((((this.appName.hashCode() * 31) + this.appMeta.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.appView.hashCode()) * 31) + this.pushType) * 31) + this.pageUrl.hashCode()) * 31) + this.advPosIDs.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "WaterfallArk(appName=" + this.appName + ", appMeta=" + this.appMeta + ", appVersion=" + this.appVersion + ", appView=" + this.appView + ", pushType=" + this.pushType + ", pageUrl=" + this.pageUrl + ", advPosIDs=" + this.advPosIDs + ")";
    }
}
