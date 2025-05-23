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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanDressUpFAssetInfo;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "f", "J", "getSlotId", "()J", "slotId", h.F, "c", "itemId", "", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "<init>", "(JJLjava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanDressUpFAssetInfo extends ZPlanFAssetInfo {
    public static final Parcelable.Creator<ZPlanDressUpFAssetInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long slotId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long itemId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanDressUpFAssetInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanDressUpFAssetInfo createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanDressUpFAssetInfo(in5.readLong(), in5.readLong(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanDressUpFAssetInfo[] newArray(int i3) {
            return new ZPlanDressUpFAssetInfo[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanDressUpFAssetInfo(long j3, long j16, @NotNull String url) {
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

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.slotId);
        parcel.writeLong(this.itemId);
        parcel.writeString(this.url);
    }
}
