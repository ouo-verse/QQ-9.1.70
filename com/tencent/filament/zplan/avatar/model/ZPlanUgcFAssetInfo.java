package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b!\u0010\"J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanUgcFAssetInfo;", "Lcom/tencent/filament/zplan/avatar/model/ZPlanFAssetInfo;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "f", "I", "c", "()I", "slotId", "", h.F, "J", "getUgcId", "()J", "setUgcId", "(J)V", "ugcId", "", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "e", "()Z", "isLocalFileUrl", "<init>", "(IJLjava/lang/String;Z)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanUgcFAssetInfo extends ZPlanFAssetInfo {
    public static final Parcelable.Creator<ZPlanUgcFAssetInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int slotId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long ugcId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isLocalFileUrl;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanUgcFAssetInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanUgcFAssetInfo createFromParcel(@NotNull Parcel in5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(in5, "in");
            int readInt = in5.readInt();
            long readLong = in5.readLong();
            String readString = in5.readString();
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new ZPlanUgcFAssetInfo(readInt, readLong, readString, z16);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanUgcFAssetInfo[] newArray(int i3) {
            return new ZPlanUgcFAssetInfo[i3];
        }
    }

    public /* synthetic */ ZPlanUgcFAssetInfo(int i3, long j3, String str, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3, str, (i16 & 8) != 0 ? false : z16);
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    /* renamed from: c, reason: from getter */
    public final int getSlotId() {
        return this.slotId;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsLocalFileUrl() {
        return this.isLocalFileUrl;
    }

    @Override // com.tencent.filament.zplan.avatar.model.ZPlanFAssetInfo, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.slotId);
        parcel.writeLong(this.ugcId);
        parcel.writeString(this.url);
        parcel.writeInt(this.isLocalFileUrl ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUgcFAssetInfo(int i3, long j3, @NotNull String url, boolean z16) {
        super(String.valueOf(i3), url);
        Intrinsics.checkNotNullParameter(url, "url");
        this.slotId = i3;
        this.ugcId = j3;
        this.url = url;
        this.isLocalFileUrl = z16;
    }
}
