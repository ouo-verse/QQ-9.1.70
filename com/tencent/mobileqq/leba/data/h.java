package com.tencent.mobileqq.leba.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/leba/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "resName", "b", "getLocaleName", "localeName", "c", "I", "f", "()I", QCircleLpReportDc010001.KEY_SUBTYPE, "d", "iconUrl", "gridIconUrl", WadlProxyConsts.KEY_JUMP_URL, "g", "extConf", tl.h.F, "getDefaultState", "defaultState", "i", "getSimpleMode", "simpleMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String localeName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int subType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String gridIconUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumpUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String extConf;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int defaultState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int simpleMode;

    public h(@NotNull String resName, @Nullable String str, int i3, @NotNull String iconUrl, @NotNull String gridIconUrl, @NotNull String jumpUrl, @NotNull String extConf, int i16, int i17) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(gridIconUrl, "gridIconUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(extConf, "extConf");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resName, str, Integer.valueOf(i3), iconUrl, gridIconUrl, jumpUrl, extConf, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.resName = resName;
        this.localeName = str;
        this.subType = i3;
        this.iconUrl = iconUrl;
        this.gridIconUrl = gridIconUrl;
        this.jumpUrl = jumpUrl;
        this.extConf = extConf;
        this.defaultState = i16;
        this.simpleMode = i17;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.extConf;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.gridIconUrl;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.jumpUrl;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.resName;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (Intrinsics.areEqual(this.resName, hVar.resName) && Intrinsics.areEqual(this.localeName, hVar.localeName) && this.subType == hVar.subType && Intrinsics.areEqual(this.iconUrl, hVar.iconUrl) && Intrinsics.areEqual(this.gridIconUrl, hVar.gridIconUrl) && Intrinsics.areEqual(this.jumpUrl, hVar.jumpUrl) && Intrinsics.areEqual(this.extConf, hVar.extConf) && this.defaultState == hVar.defaultState && this.simpleMode == hVar.simpleMode) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.subType;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int hashCode2 = this.resName.hashCode() * 31;
        String str = this.localeName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((((((((((hashCode2 + hashCode) * 31) + this.subType) * 31) + this.iconUrl.hashCode()) * 31) + this.gridIconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.extConf.hashCode()) * 31) + this.defaultState) * 31) + this.simpleMode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "PluginXmlBean(resName=" + this.resName + ", localeName=" + this.localeName + ", subType=" + this.subType + ", iconUrl=" + this.iconUrl + ", gridIconUrl=" + this.gridIconUrl + ", jumpUrl=" + this.jumpUrl + ", extConf=" + this.extConf + ", defaultState=" + this.defaultState + ", simpleMode=" + this.simpleMode + ")";
    }

    public /* synthetic */ h(String str, String str2, int i3, String str3, String str4, String str5, String str6, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i18 & 4) != 0 ? 0 : i3, str3, str4, str5, str6, (i18 & 128) != 0 ? 0 : i16, (i18 & 256) != 0 ? 0 : i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), str3, str4, str5, str6, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
