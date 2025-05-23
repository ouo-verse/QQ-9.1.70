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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanUpdateHairInfo;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "b", "()Z", "needUpdate", "", "e", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "itemId", "<init>", "(ZLjava/lang/Long;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ZPlanUpdateHairInfo implements Parcelable {
    public static final Parcelable.Creator<ZPlanUpdateHairInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needUpdate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long itemId;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanUpdateHairInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanUpdateHairInfo createFromParcel(@NotNull Parcel in5) {
            boolean z16;
            Long l3;
            Intrinsics.checkNotNullParameter(in5, "in");
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (in5.readInt() != 0) {
                l3 = Long.valueOf(in5.readLong());
            } else {
                l3 = null;
            }
            return new ZPlanUpdateHairInfo(z16, l3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanUpdateHairInfo[] newArray(int i3) {
            return new ZPlanUpdateHairInfo[i3];
        }
    }

    public ZPlanUpdateHairInfo(boolean z16, @Nullable Long l3) {
        this.needUpdate = z16;
        this.itemId = l3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Long getItemId() {
        return this.itemId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanUpdateHairInfo) {
                ZPlanUpdateHairInfo zPlanUpdateHairInfo = (ZPlanUpdateHairInfo) other;
                if (this.needUpdate != zPlanUpdateHairInfo.needUpdate || !Intrinsics.areEqual(this.itemId, zPlanUpdateHairInfo.itemId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        int i3;
        boolean z16 = this.needUpdate;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        Long l3 = this.itemId;
        if (l3 != null) {
            i3 = l3.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanUpdateHairInfo(needUpdate=" + this.needUpdate + ", itemId=" + this.itemId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.needUpdate ? 1 : 0);
        Long l3 = this.itemId;
        if (l3 != null) {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        } else {
            parcel.writeInt(0);
        }
    }

    public /* synthetic */ ZPlanUpdateHairInfo(boolean z16, Long l3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : l3);
    }
}
