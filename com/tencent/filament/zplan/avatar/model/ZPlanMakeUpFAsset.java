package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAsset;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAssetInfo;", "e", "Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAssetInfo;", "b", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAssetInfo;", "assetInfo", "", "f", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "dirPath", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAssetInfo;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanMakeUpFAsset extends ZPlanFAsset {
    public static final Parcelable.Creator<ZPlanMakeUpFAsset> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanMakeUpFAssetInfo assetInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String dirPath;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanMakeUpFAsset> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanMakeUpFAsset createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanMakeUpFAsset(ZPlanMakeUpFAssetInfo.CREATOR.createFromParcel(in5), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanMakeUpFAsset[] newArray(int i3) {
            return new ZPlanMakeUpFAsset[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMakeUpFAsset(@NotNull ZPlanMakeUpFAssetInfo assetInfo, @Nullable String str) {
        super(assetInfo);
        Intrinsics.checkNotNullParameter(assetInfo, "assetInfo");
        this.assetInfo = assetInfo;
        this.dirPath = str;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset
    @NotNull
    /* renamed from: b, reason: from getter */
    public ZPlanMakeUpFAssetInfo getAssetInfo() {
        return this.assetInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getDirPath() {
        return this.dirPath;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAsset, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.assetInfo.writeToParcel(parcel, 0);
        parcel.writeString(this.dirPath);
    }
}
