package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanCommonGltfFAsset;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "e", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "a", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "assetInfo", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "gltfFilePath", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class ZPlanCommonGltfFAsset extends ZPlanFAsset {
    public static final Parcelable.Creator<ZPlanCommonGltfFAsset> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanFAssetInfo assetInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String gltfFilePath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanCommonGltfFAsset> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanCommonGltfFAsset createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanCommonGltfFAsset((ZPlanFAssetInfo) in5.readParcelable(ZPlanCommonGltfFAsset.class.getClassLoader()), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanCommonGltfFAsset[] newArray(int i3) {
            return new ZPlanCommonGltfFAsset[i3];
        }
    }

    public /* synthetic */ ZPlanCommonGltfFAsset(ZPlanFAssetInfo zPlanFAssetInfo, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(zPlanFAssetInfo, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset
    @NotNull
    /* renamed from: a, reason: from getter */
    public ZPlanFAssetInfo getAssetInfo() {
        return this.assetInfo;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public String getGltfFilePath() {
        return this.gltfFilePath;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset
    @NotNull
    public String toString() {
        return super.toString() + ", gltfFilePath:" + getGltfFilePath();
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.assetInfo, flags);
        parcel.writeString(this.gltfFilePath);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCommonGltfFAsset(@NotNull ZPlanFAssetInfo assetInfo, @Nullable String str) {
        super(assetInfo);
        Intrinsics.checkNotNullParameter(assetInfo, "assetInfo");
        this.assetInfo = assetInfo;
        this.gltfFilePath = str;
    }
}
