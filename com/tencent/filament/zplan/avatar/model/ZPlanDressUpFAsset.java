package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAsset;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAssetInfo;", h.F, "Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAssetInfo;", "c", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAssetInfo;", "assetInfo", "", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "gltfFilePath", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAssetInfo;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanDressUpFAsset extends ZPlanCommonGltfFAsset {
    public static final Parcelable.Creator<ZPlanDressUpFAsset> CREATOR = new a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanDressUpFAssetInfo assetInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String gltfFilePath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanDressUpFAsset> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanDressUpFAsset createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanDressUpFAsset(ZPlanDressUpFAssetInfo.CREATOR.createFromParcel(in5), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanDressUpFAsset[] newArray(int i3) {
            return new ZPlanDressUpFAsset[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanDressUpFAsset(@NotNull ZPlanDressUpFAssetInfo assetInfo, @Nullable String str) {
        super(assetInfo, null, 2, null);
        Intrinsics.checkNotNullParameter(assetInfo, "assetInfo");
        this.assetInfo = assetInfo;
        this.gltfFilePath = str;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset
    @Nullable
    /* renamed from: b, reason: from getter */
    public String getGltfFilePath() {
        return this.gltfFilePath;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset, com.tencent.filament.zplan.avatar.model.ZPlanFAsset
    @NotNull
    /* renamed from: c, reason: from getter */
    public ZPlanDressUpFAssetInfo getAssetInfo() {
        return this.assetInfo;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanCommonGltfFAsset, com.tencent.filament.zplan.avatar.model.ZPlanFAsset, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.assetInfo.writeToParcel(parcel, 0);
        parcel.writeString(this.gltfFilePath);
    }
}
