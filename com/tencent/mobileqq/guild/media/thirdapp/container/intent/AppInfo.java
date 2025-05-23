package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "url", "b", "g", "title", "c", "iconUrl", "d", "appId", "e", "I", "()I", "capacity", "f", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "getMinMembers", "minMembers", "getMaxMembers", "maxMembers", "i", "setPerLoadingMaterialUrl", "(Ljava/lang/String;)V", "perLoadingMaterialUrl", "j", "setPerLoadingMaterialType", "(I)V", "perLoadingMaterialType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class AppInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String iconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int capacity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int screenMode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int minMembers;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxMembers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String perLoadingMaterialUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int perLoadingMaterialType;

    public AppInfo(@NotNull String url, @NotNull String title, @NotNull String iconUrl, @NotNull String appId, int i3, int i16, int i17, int i18, @NotNull String perLoadingMaterialUrl, int i19) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(perLoadingMaterialUrl, "perLoadingMaterialUrl");
        this.url = url;
        this.title = title;
        this.iconUrl = iconUrl;
        this.appId = appId;
        this.capacity = i3;
        this.screenMode = i16;
        this.minMembers = i17;
        this.maxMembers = i18;
        this.perLoadingMaterialUrl = perLoadingMaterialUrl;
        this.perLoadingMaterialType = i19;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final int getCapacity() {
        return this.capacity;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: d, reason: from getter */
    public final int getPerLoadingMaterialType() {
        return this.perLoadingMaterialType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPerLoadingMaterialUrl() {
        return this.perLoadingMaterialUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppInfo)) {
            return false;
        }
        AppInfo appInfo = (AppInfo) other;
        if (Intrinsics.areEqual(this.url, appInfo.url) && Intrinsics.areEqual(this.title, appInfo.title) && Intrinsics.areEqual(this.iconUrl, appInfo.iconUrl) && Intrinsics.areEqual(this.appId, appInfo.appId) && this.capacity == appInfo.capacity && this.screenMode == appInfo.screenMode && this.minMembers == appInfo.minMembers && this.maxMembers == appInfo.maxMembers && Intrinsics.areEqual(this.perLoadingMaterialUrl, appInfo.perLoadingMaterialUrl) && this.perLoadingMaterialType == appInfo.perLoadingMaterialType) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getScreenMode() {
        return this.screenMode;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((((((((((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.capacity) * 31) + this.screenMode) * 31) + this.minMembers) * 31) + this.maxMembers) * 31) + this.perLoadingMaterialUrl.hashCode()) * 31) + this.perLoadingMaterialType;
    }

    @NotNull
    public String toString() {
        return "AppInfo(url=" + this.url + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ", appId=" + this.appId + ", capacity=" + this.capacity + ", screenMode=" + this.screenMode + ", minMembers=" + this.minMembers + ", maxMembers=" + this.maxMembers + ", perLoadingMaterialUrl=" + this.perLoadingMaterialUrl + ", perLoadingMaterialType=" + this.perLoadingMaterialType + ")";
    }
}
