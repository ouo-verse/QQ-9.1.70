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
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010 \u001a\u00020\u0012\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u0017\u0010 \u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/Float4;", "Landroid/os/Parcelable;", "Lorg/json/JSONArray;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", UserInfo.SEX_FEMALE, "getF0", "()F", "f0", "e", "getF1", "f1", "f", "getF2", "f2", h.F, "getF3", "f3", "<init>", "(FFFF)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class Float4 implements Parcelable {
    public static final Parcelable.Creator<Float4> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f0;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final float f3;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<Float4> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float4 createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new Float4(in5.readFloat(), in5.readFloat(), in5.readFloat(), in5.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Float4[] newArray(int i3) {
            return new Float4[i3];
        }
    }

    public Float4(float f16, float f17, float f18, float f19) {
        this.f0 = f16;
        this.f1 = f17;
        this.f2 = f18;
        this.f3 = f19;
    }

    @NotNull
    public final JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(Float.valueOf(this.f0));
        jSONArray.mo162put(Float.valueOf(this.f1));
        jSONArray.mo162put(Float.valueOf(this.f2));
        jSONArray.mo162put(Float.valueOf(this.f3));
        return jSONArray;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Float4) {
                Float4 float4 = (Float4) other;
                if (Float.compare(this.f0, float4.f0) != 0 || Float.compare(this.f1, float4.f1) != 0 || Float.compare(this.f2, float4.f2) != 0 || Float.compare(this.f3, float4.f3) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f0) * 31) + Float.floatToIntBits(this.f1)) * 31) + Float.floatToIntBits(this.f2)) * 31) + Float.floatToIntBits(this.f3);
    }

    @NotNull
    public String toString() {
        return "Float4(f0=" + this.f0 + ", f1=" + this.f1 + ", f2=" + this.f2 + ", f3=" + this.f3 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeFloat(this.f0);
        parcel.writeFloat(this.f1);
        parcel.writeFloat(this.f2);
        parcel.writeFloat(this.f3);
    }
}
