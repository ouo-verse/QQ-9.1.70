package com.tencent.tavcut.core.render.builder.light.model.asset;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003JE\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/asset/LightAssetModel;", "", "fontAssets", "", "Lcom/tencent/tavcut/core/render/builder/light/model/asset/FontAsset;", "musicIds", "", "materialConfig", "Lcom/tencent/tavcut/core/render/builder/light/model/asset/MaterialConfig;", "boundsTrackerPlaceHolders", "(Ljava/util/List;Ljava/util/List;Lcom/tencent/tavcut/core/render/builder/light/model/asset/MaterialConfig;Ljava/util/List;)V", "getBoundsTrackerPlaceHolders", "()Ljava/util/List;", "getFontAssets", "getMaterialConfig", "()Lcom/tencent/tavcut/core/render/builder/light/model/asset/MaterialConfig;", "getMusicIds", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class LightAssetModel {

    @NotNull
    private final List<String> boundsTrackerPlaceHolders;

    @NotNull
    private final List<FontAsset> fontAssets;

    @Nullable
    private final MaterialConfig materialConfig;

    @NotNull
    private final List<String> musicIds;

    public LightAssetModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LightAssetModel copy$default(LightAssetModel lightAssetModel, List list, List list2, MaterialConfig materialConfig, List list3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = lightAssetModel.fontAssets;
        }
        if ((i3 & 2) != 0) {
            list2 = lightAssetModel.musicIds;
        }
        if ((i3 & 4) != 0) {
            materialConfig = lightAssetModel.materialConfig;
        }
        if ((i3 & 8) != 0) {
            list3 = lightAssetModel.boundsTrackerPlaceHolders;
        }
        return lightAssetModel.copy(list, list2, materialConfig, list3);
    }

    @NotNull
    public final List<FontAsset> component1() {
        return this.fontAssets;
    }

    @NotNull
    public final List<String> component2() {
        return this.musicIds;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final MaterialConfig getMaterialConfig() {
        return this.materialConfig;
    }

    @NotNull
    public final List<String> component4() {
        return this.boundsTrackerPlaceHolders;
    }

    @NotNull
    public final LightAssetModel copy(@NotNull List<FontAsset> fontAssets, @NotNull List<String> musicIds, @Nullable MaterialConfig materialConfig, @NotNull List<String> boundsTrackerPlaceHolders) {
        Intrinsics.checkParameterIsNotNull(fontAssets, "fontAssets");
        Intrinsics.checkParameterIsNotNull(musicIds, "musicIds");
        Intrinsics.checkParameterIsNotNull(boundsTrackerPlaceHolders, "boundsTrackerPlaceHolders");
        return new LightAssetModel(fontAssets, musicIds, materialConfig, boundsTrackerPlaceHolders);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LightAssetModel) {
                LightAssetModel lightAssetModel = (LightAssetModel) other;
                if (!Intrinsics.areEqual(this.fontAssets, lightAssetModel.fontAssets) || !Intrinsics.areEqual(this.musicIds, lightAssetModel.musicIds) || !Intrinsics.areEqual(this.materialConfig, lightAssetModel.materialConfig) || !Intrinsics.areEqual(this.boundsTrackerPlaceHolders, lightAssetModel.boundsTrackerPlaceHolders)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<String> getBoundsTrackerPlaceHolders() {
        return this.boundsTrackerPlaceHolders;
    }

    @NotNull
    public final List<FontAsset> getFontAssets() {
        return this.fontAssets;
    }

    @Nullable
    public final MaterialConfig getMaterialConfig() {
        return this.materialConfig;
    }

    @NotNull
    public final List<String> getMusicIds() {
        return this.musicIds;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        List<FontAsset> list = this.fontAssets;
        int i18 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        List<String> list2 = this.musicIds;
        if (list2 != null) {
            i16 = list2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        MaterialConfig materialConfig = this.materialConfig;
        if (materialConfig != null) {
            i17 = materialConfig.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        List<String> list3 = this.boundsTrackerPlaceHolders;
        if (list3 != null) {
            i18 = list3.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "LightAssetModel(fontAssets=" + this.fontAssets + ", musicIds=" + this.musicIds + ", materialConfig=" + this.materialConfig + ", boundsTrackerPlaceHolders=" + this.boundsTrackerPlaceHolders + ")";
    }

    public LightAssetModel(@NotNull List<FontAsset> fontAssets, @NotNull List<String> musicIds, @Nullable MaterialConfig materialConfig, @NotNull List<String> boundsTrackerPlaceHolders) {
        Intrinsics.checkParameterIsNotNull(fontAssets, "fontAssets");
        Intrinsics.checkParameterIsNotNull(musicIds, "musicIds");
        Intrinsics.checkParameterIsNotNull(boundsTrackerPlaceHolders, "boundsTrackerPlaceHolders");
        this.fontAssets = fontAssets;
        this.musicIds = musicIds;
        this.materialConfig = materialConfig;
        this.boundsTrackerPlaceHolders = boundsTrackerPlaceHolders;
    }

    public /* synthetic */ LightAssetModel(List list, List list2, MaterialConfig materialConfig, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? null : materialConfig, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3);
    }
}
