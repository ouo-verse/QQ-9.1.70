package com.tencent.mobileqq.guild.media.thirdapp;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0019\u0010\u001cR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/media/thirdapp/PreloadFrom;", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/PreloadFrom;", "getFrom", "()Lcom/tencent/mobileqq/guild/media/thirdapp/PreloadFrom;", "from", "b", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "url", "c", "f", "title", "d", "iconUrl", "e", "appId", "I", "()I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "g", "setPerLoadingMaterialType", "(I)V", "perLoadingMaterialType", tl.h.F, "setPerLoadingMaterialUrl", "(Ljava/lang/String;)V", "perLoadingMaterialUrl", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/PreloadFrom;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PreloadFrom from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int screenMode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int perLoadingMaterialType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String perLoadingMaterialUrl;

    public e(@NotNull PreloadFrom from, @NotNull String url, @NotNull String title, @NotNull String iconUrl, @NotNull String appId, int i3, int i16, @NotNull String perLoadingMaterialUrl) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(perLoadingMaterialUrl, "perLoadingMaterialUrl");
        this.from = from;
        this.url = url;
        this.title = title;
        this.iconUrl = iconUrl;
        this.appId = appId;
        this.screenMode = i3;
        this.perLoadingMaterialType = i16;
        this.perLoadingMaterialUrl = perLoadingMaterialUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: c, reason: from getter */
    public final int getPerLoadingMaterialType() {
        return this.perLoadingMaterialType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPerLoadingMaterialUrl() {
        return this.perLoadingMaterialUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getScreenMode() {
        return this.screenMode;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (this.from == eVar.from && Intrinsics.areEqual(this.url, eVar.url) && Intrinsics.areEqual(this.title, eVar.title) && Intrinsics.areEqual(this.iconUrl, eVar.iconUrl) && Intrinsics.areEqual(this.appId, eVar.appId) && this.screenMode == eVar.screenMode && this.perLoadingMaterialType == eVar.perLoadingMaterialType && Intrinsics.areEqual(this.perLoadingMaterialUrl, eVar.perLoadingMaterialUrl)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.from.hashCode() * 31) + this.url.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.screenMode) * 31) + this.perLoadingMaterialType) * 31) + this.perLoadingMaterialUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "url[" + this.url + "] title[" + this.title + "] iconUrl[" + this.iconUrl + "] appId[" + this.appId + "] screenMode[" + this.screenMode + "]";
    }
}
