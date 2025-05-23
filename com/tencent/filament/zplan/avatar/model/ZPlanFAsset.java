package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanFAsset;", "Landroid/os/Parcelable;", "", "toString", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "d", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "a", "()Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "assetInfo", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public class ZPlanFAsset implements Parcelable {
    public static final Parcelable.Creator<ZPlanFAsset> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanFAssetInfo assetInfo;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanFAsset> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanFAsset createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanFAsset((ZPlanFAssetInfo) in5.readParcelable(ZPlanFAsset.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanFAsset[] newArray(int i3) {
            return new ZPlanFAsset[i3];
        }
    }

    public ZPlanFAsset(@NotNull ZPlanFAssetInfo assetInfo) {
        Intrinsics.checkNotNullParameter(assetInfo, "assetInfo");
        this.assetInfo = assetInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public ZPlanFAssetInfo getAssetInfo() {
        return this.assetInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public String toString() {
        return "ZPlanFAsset:{assetInfo:" + getAssetInfo() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.assetInfo, flags);
    }
}
