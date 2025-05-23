package com.tencent.mobileqq.guild.setting.qrcode.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/PlatformType;", "a", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/PlatformType;", "c", "()Lcom/tencent/mobileqq/guild/setting/qrcode/view/PlatformType;", "platformType", "b", "I", "()I", "platformIcon", "Ljava/lang/String;", "()Ljava/lang/String;", "platformName", "<init>", "(Lcom/tencent/mobileqq/guild/setting/qrcode/view/PlatformType;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.qrcode.view.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SharePlatformItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PlatformType platformType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int platformIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String platformName;

    public SharePlatformItemData(@NotNull PlatformType platformType, int i3, @NotNull String platformName) {
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        this.platformType = platformType;
        this.platformIcon = i3;
        this.platformName = platformName;
    }

    /* renamed from: a, reason: from getter */
    public final int getPlatformIcon() {
        return this.platformIcon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final PlatformType getPlatformType() {
        return this.platformType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharePlatformItemData)) {
            return false;
        }
        SharePlatformItemData sharePlatformItemData = (SharePlatformItemData) other;
        if (this.platformType == sharePlatformItemData.platformType && this.platformIcon == sharePlatformItemData.platformIcon && Intrinsics.areEqual(this.platformName, sharePlatformItemData.platformName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.platformType.hashCode() * 31) + this.platformIcon) * 31) + this.platformName.hashCode();
    }

    @NotNull
    public String toString() {
        return "SharePlatformItemData(platformType=" + this.platformType + ", platformIcon=" + this.platformIcon + ", platformName=" + this.platformName + ")";
    }
}
