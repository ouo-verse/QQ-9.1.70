package com.tencent.mobileqq.wink.magicAvatar.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/wink/magicAvatar/model/d;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "magicAvatarStyles", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "homePageHeadBgPag", "<init>", "(Ljava/util/List;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicAvatar.model.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PageInfoCallbackInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MagicAvatarStyleBanner> magicAvatarStyles;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final MetaMaterial homePageHeadBgPag;

    public PageInfoCallbackInfo(@NotNull List<MagicAvatarStyleBanner> magicAvatarStyles, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(magicAvatarStyles, "magicAvatarStyles");
        this.magicAvatarStyles = magicAvatarStyles;
        this.homePageHeadBgPag = metaMaterial;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final MetaMaterial getHomePageHeadBgPag() {
        return this.homePageHeadBgPag;
    }

    @NotNull
    public final List<MagicAvatarStyleBanner> b() {
        return this.magicAvatarStyles;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageInfoCallbackInfo)) {
            return false;
        }
        PageInfoCallbackInfo pageInfoCallbackInfo = (PageInfoCallbackInfo) other;
        if (Intrinsics.areEqual(this.magicAvatarStyles, pageInfoCallbackInfo.magicAvatarStyles) && Intrinsics.areEqual(this.homePageHeadBgPag, pageInfoCallbackInfo.homePageHeadBgPag)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.magicAvatarStyles.hashCode() * 31;
        MetaMaterial metaMaterial = this.homePageHeadBgPag;
        if (metaMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = metaMaterial.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "PageInfoCallbackInfo(magicAvatarStyles=" + this.magicAvatarStyles + ", homePageHeadBgPag=" + this.homePageHeadBgPag + ")";
    }
}
