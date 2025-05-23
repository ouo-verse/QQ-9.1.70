package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u0018\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/GradientColor;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "D", HippyQQPagView.FunctionName.GET_PROGRESS, "()D", "progress", "Lcom/tencent/filament/zplan/avatar/model/Float4;", "e", "Lcom/tencent/filament/zplan/avatar/model/Float4;", "getFromColor", "()Lcom/tencent/filament/zplan/avatar/model/Float4;", "fromColor", "f", "getToColor", "toColor", "Lcom/tencent/filament/zplan/avatar/model/ColorType;", h.F, "Lcom/tencent/filament/zplan/avatar/model/ColorType;", "getType", "()Lcom/tencent/filament/zplan/avatar/model/ColorType;", "type", "<init>", "(DLcom/tencent/filament/zplan/avatar/model/Float4;Lcom/tencent/filament/zplan/avatar/model/Float4;Lcom/tencent/filament/zplan/avatar/model/ColorType;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class GradientColor implements Parcelable {
    public static final Parcelable.Creator<GradientColor> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final double progress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Float4 fromColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Float4 toColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ColorType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<GradientColor> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GradientColor createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            double readDouble = in5.readDouble();
            Parcelable.Creator<Float4> creator = Float4.CREATOR;
            return new GradientColor(readDouble, creator.createFromParcel(in5), creator.createFromParcel(in5), (ColorType) Enum.valueOf(ColorType.class, in5.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GradientColor[] newArray(int i3) {
            return new GradientColor[i3];
        }
    }

    public GradientColor(double d16, @NotNull Float4 fromColor, @NotNull Float4 toColor, @NotNull ColorType type) {
        Intrinsics.checkNotNullParameter(fromColor, "fromColor");
        Intrinsics.checkNotNullParameter(toColor, "toColor");
        Intrinsics.checkNotNullParameter(type, "type");
        this.progress = d16;
        this.fromColor = fromColor;
        this.toColor = toColor;
        this.type = type;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enable", true);
        jSONObject.put("progress", this.progress);
        jSONObject.put("fromColor", this.fromColor.a());
        jSONObject.put("toColor", this.toColor.a());
        jSONObject.put("type", ColorType.INSTANCE.a(this.type.getValue()));
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof GradientColor) {
                GradientColor gradientColor = (GradientColor) other;
                if (Double.compare(this.progress, gradientColor.progress) != 0 || !Intrinsics.areEqual(this.fromColor, gradientColor.fromColor) || !Intrinsics.areEqual(this.toColor, gradientColor.toColor) || !Intrinsics.areEqual(this.type, gradientColor.type)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        long doubleToLongBits = Double.doubleToLongBits(this.progress);
        int i17 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        Float4 float4 = this.fromColor;
        int i18 = 0;
        if (float4 != null) {
            i3 = float4.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        Float4 float42 = this.toColor;
        if (float42 != null) {
            i16 = float42.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        ColorType colorType = this.type;
        if (colorType != null) {
            i18 = colorType.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "GradientColor(progress=" + this.progress + ", fromColor=" + this.fromColor + ", toColor=" + this.toColor + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeDouble(this.progress);
        this.fromColor.writeToParcel(parcel, 0);
        this.toColor.writeToParcel(parcel, 0);
        parcel.writeString(this.type.name());
    }
}
