package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/Float3;", "Landroid/os/Parcelable;", "", "e", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", UserInfo.SEX_FEMALE, "a", "()F", "f0", "b", "f1", "f", "c", "f2", "<init>", "(FFF)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class Float3 implements Parcelable {
    public static final Parcelable.Creator<Float3> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f2;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<Float3> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float3 createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new Float3(in5.readFloat(), in5.readFloat(), in5.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Float3[] newArray(int i3) {
            return new Float3[i3];
        }
    }

    public Float3(float f16, float f17, float f18) {
        this.f0 = f16;
        this.f1 = f17;
        this.f2 = f18;
    }

    /* renamed from: a, reason: from getter */
    public final float getF0() {
        return this.f0;
    }

    /* renamed from: b, reason: from getter */
    public final float getF1() {
        return this.f1;
    }

    /* renamed from: c, reason: from getter */
    public final float getF2() {
        return this.f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final float[] e() {
        return new float[]{this.f0, this.f1, this.f2};
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Float3) {
                Float3 float3 = (Float3) other;
                if (Float.compare(this.f0, float3.f0) != 0 || Float.compare(this.f1, float3.f1) != 0 || Float.compare(this.f2, float3.f2) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f0) * 31) + Float.floatToIntBits(this.f1)) * 31) + Float.floatToIntBits(this.f2);
    }

    @NotNull
    public String toString() {
        return "Float3(f0=" + this.f0 + ", f1=" + this.f1 + ", f2=" + this.f2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeFloat(this.f0);
        parcel.writeFloat(this.f1);
        parcel.writeFloat(this.f2);
    }
}
