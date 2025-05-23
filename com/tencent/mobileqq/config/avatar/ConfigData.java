package com.tencent.mobileqq.config.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/config/avatar/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "actionResUrl", "c", "actionResUrlMd5", "d", "e", "normalBgUrl", "normalBgColor", "f", "getTofuBackground", "tofuBackground", "g", "posterText", tl.h.F, "posterStatusTextColor", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.config.avatar.i, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class ConfigData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String actionResUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String actionResUrlMd5;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String normalBgUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String normalBgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tofuBackground;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posterText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String posterStatusTextColor;

    public ConfigData(int i3, @NotNull String actionResUrl, @NotNull String actionResUrlMd5, @NotNull String normalBgUrl, @NotNull String normalBgColor, @NotNull String tofuBackground, @NotNull String posterText, @NotNull String posterStatusTextColor) {
        Intrinsics.checkNotNullParameter(actionResUrl, "actionResUrl");
        Intrinsics.checkNotNullParameter(actionResUrlMd5, "actionResUrlMd5");
        Intrinsics.checkNotNullParameter(normalBgUrl, "normalBgUrl");
        Intrinsics.checkNotNullParameter(normalBgColor, "normalBgColor");
        Intrinsics.checkNotNullParameter(tofuBackground, "tofuBackground");
        Intrinsics.checkNotNullParameter(posterText, "posterText");
        Intrinsics.checkNotNullParameter(posterStatusTextColor, "posterStatusTextColor");
        this.actionId = i3;
        this.actionResUrl = actionResUrl;
        this.actionResUrlMd5 = actionResUrlMd5;
        this.normalBgUrl = normalBgUrl;
        this.normalBgColor = normalBgColor;
        this.tofuBackground = tofuBackground;
        this.posterText = posterText;
        this.posterStatusTextColor = posterStatusTextColor;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getActionResUrl() {
        return this.actionResUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getActionResUrlMd5() {
        return this.actionResUrlMd5;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getNormalBgColor() {
        return this.normalBgColor;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getNormalBgUrl() {
        return this.normalBgUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) other;
        if (this.actionId == configData.actionId && Intrinsics.areEqual(this.actionResUrl, configData.actionResUrl) && Intrinsics.areEqual(this.actionResUrlMd5, configData.actionResUrlMd5) && Intrinsics.areEqual(this.normalBgUrl, configData.normalBgUrl) && Intrinsics.areEqual(this.normalBgColor, configData.normalBgColor) && Intrinsics.areEqual(this.tofuBackground, configData.tofuBackground) && Intrinsics.areEqual(this.posterText, configData.posterText) && Intrinsics.areEqual(this.posterStatusTextColor, configData.posterStatusTextColor)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPosterStatusTextColor() {
        return this.posterStatusTextColor;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getPosterText() {
        return this.posterText;
    }

    public int hashCode() {
        return (((((((((((((this.actionId * 31) + this.actionResUrl.hashCode()) * 31) + this.actionResUrlMd5.hashCode()) * 31) + this.normalBgUrl.hashCode()) * 31) + this.normalBgColor.hashCode()) * 31) + this.tofuBackground.hashCode()) * 31) + this.posterText.hashCode()) * 31) + this.posterStatusTextColor.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfigData(actionId=" + this.actionId + ", actionResUrl=" + this.actionResUrl + ", actionResUrlMd5=" + this.actionResUrlMd5 + ", normalBgUrl=" + this.normalBgUrl + ", normalBgColor=" + this.normalBgColor + ", tofuBackground=" + this.tofuBackground + ", posterText=" + this.posterText + ", posterStatusTextColor=" + this.posterStatusTextColor + ")";
    }
}
