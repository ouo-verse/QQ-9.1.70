package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanMakeUpFAssetInfo;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "f", "J", "e", "()J", "slotId", h.F, "c", "itemId", "", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "<init>", "(JJLjava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanMakeUpFAssetInfo extends ZPlanFAssetInfo {
    public static final Parcelable.Creator<ZPlanMakeUpFAssetInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long slotId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long itemId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanMakeUpFAssetInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanMakeUpFAssetInfo createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanMakeUpFAssetInfo(in5.readLong(), in5.readLong(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanMakeUpFAssetInfo[] newArray(int i3) {
            return new ZPlanMakeUpFAssetInfo[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMakeUpFAssetInfo(long j3, long j16, @NotNull String url) {
        super(String.valueOf(j3), url);
        Intrinsics.checkNotNullParameter(url, "url");
        this.slotId = j3;
        this.itemId = j16;
        this.url = url;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    /* renamed from: c, reason: from getter */
    public final long getItemId() {
        return this.itemId;
    }

    /* renamed from: e, reason: from getter */
    public final long getSlotId() {
        return this.slotId;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.slotId);
        parcel.writeLong(this.itemId);
        parcel.writeString(this.url);
    }
}
