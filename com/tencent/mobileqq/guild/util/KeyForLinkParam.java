package com.tencent.mobileqq.guild.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bn;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "jumpUrlKey", "c", "previewKey", "d", "titleKey", "descKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.util.bn, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class KeyForLinkParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrlKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String previewKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String titleKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String descKey;

    public KeyForLinkParam(@NotNull String jumpUrlKey, @NotNull String previewKey, @NotNull String titleKey, @NotNull String descKey) {
        Intrinsics.checkNotNullParameter(jumpUrlKey, "jumpUrlKey");
        Intrinsics.checkNotNullParameter(previewKey, "previewKey");
        Intrinsics.checkNotNullParameter(titleKey, "titleKey");
        Intrinsics.checkNotNullParameter(descKey, "descKey");
        this.jumpUrlKey = jumpUrlKey;
        this.previewKey = previewKey;
        this.titleKey = titleKey;
        this.descKey = descKey;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDescKey() {
        return this.descKey;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getJumpUrlKey() {
        return this.jumpUrlKey;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPreviewKey() {
        return this.previewKey;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitleKey() {
        return this.titleKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyForLinkParam)) {
            return false;
        }
        KeyForLinkParam keyForLinkParam = (KeyForLinkParam) other;
        if (Intrinsics.areEqual(this.jumpUrlKey, keyForLinkParam.jumpUrlKey) && Intrinsics.areEqual(this.previewKey, keyForLinkParam.previewKey) && Intrinsics.areEqual(this.titleKey, keyForLinkParam.titleKey) && Intrinsics.areEqual(this.descKey, keyForLinkParam.descKey)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.jumpUrlKey.hashCode() * 31) + this.previewKey.hashCode()) * 31) + this.titleKey.hashCode()) * 31) + this.descKey.hashCode();
    }

    @NotNull
    public String toString() {
        return "KeyForLinkParam(jumpUrlKey=" + this.jumpUrlKey + ", previewKey=" + this.previewKey + ", titleKey=" + this.titleKey + ", descKey=" + this.descKey + ')';
    }
}
