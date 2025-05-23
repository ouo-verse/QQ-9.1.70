package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/ZPlanPinchFaceModel;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "J", "a", "()J", "groupID", "", "e", "D", "b", "()D", c.G, "<init>", "(JD)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ZPlanPinchFaceModel implements Parcelable {
    public static final Parcelable.Creator<ZPlanPinchFaceModel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long groupID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final double pos;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<ZPlanPinchFaceModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZPlanPinchFaceModel createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new ZPlanPinchFaceModel(in5.readLong(), in5.readDouble());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ZPlanPinchFaceModel[] newArray(int i3) {
            return new ZPlanPinchFaceModel[i3];
        }
    }

    public ZPlanPinchFaceModel(long j3, double d16) {
        this.groupID = j3;
        this.pos = d16;
    }

    /* renamed from: a, reason: from getter */
    public final long getGroupID() {
        return this.groupID;
    }

    /* renamed from: b, reason: from getter */
    public final double getPos() {
        return this.pos;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanPinchFaceModel) {
                ZPlanPinchFaceModel zPlanPinchFaceModel = (ZPlanPinchFaceModel) other;
                if (this.groupID != zPlanPinchFaceModel.groupID || Double.compare(this.pos, zPlanPinchFaceModel.pos) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j3 = this.groupID;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.pos);
        return i3 + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits));
    }

    @NotNull
    public String toString() {
        return "ZPlanPinchFaceModel(groupID=" + this.groupID + ", pos=" + this.pos + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.groupID);
        parcel.writeDouble(this.pos);
    }
}
