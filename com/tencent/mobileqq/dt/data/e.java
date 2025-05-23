package com.tencent.mobileqq.dt.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/dt/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "b", "I", "c", "()I", "quiklyEnable", "minResVersion", "", "Ljava/util/Set;", "()Ljava/util/Set;", "appIdBlackList", "e", "shortAppIdList", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reportUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int quiklyEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String minResVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> appIdBlackList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> shortAppIdList;

    public e(@NotNull String reportUrl, int i3, @NotNull String minResVersion, @NotNull Set<String> appIdBlackList, @NotNull Set<String> shortAppIdList) {
        Intrinsics.checkNotNullParameter(reportUrl, "reportUrl");
        Intrinsics.checkNotNullParameter(minResVersion, "minResVersion");
        Intrinsics.checkNotNullParameter(appIdBlackList, "appIdBlackList");
        Intrinsics.checkNotNullParameter(shortAppIdList, "shortAppIdList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, reportUrl, Integer.valueOf(i3), minResVersion, appIdBlackList, shortAppIdList);
            return;
        }
        this.reportUrl = reportUrl;
        this.quiklyEnable = i3;
        this.minResVersion = minResVersion;
        this.appIdBlackList = appIdBlackList;
        this.shortAppIdList = shortAppIdList;
    }

    @NotNull
    public final Set<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.appIdBlackList;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.minResVersion;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.quiklyEnable;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.reportUrl;
    }

    @NotNull
    public final Set<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.shortAppIdList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.reportUrl, eVar.reportUrl) && this.quiklyEnable == eVar.quiklyEnable && Intrinsics.areEqual(this.minResVersion, eVar.minResVersion) && Intrinsics.areEqual(this.appIdBlackList, eVar.appIdBlackList) && Intrinsics.areEqual(this.shortAppIdList, eVar.shortAppIdList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((((this.reportUrl.hashCode() * 31) + this.quiklyEnable) * 31) + this.minResVersion.hashCode()) * 31) + this.appIdBlackList.hashCode()) * 31) + this.shortAppIdList.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "ReportConfigData(reportUrl=" + this.reportUrl + ", quiklyEnable=" + this.quiklyEnable + ", minResVersion=" + this.minResVersion + ", appIdBlackList=" + this.appIdBlackList + ", shortAppIdList=" + this.shortAppIdList + ')';
    }
}
