package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/Color;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/filament/zplan/avatar/model/Float4;", "d", "Lcom/tencent/filament/zplan/avatar/model/Float4;", HippyTextInputController.COMMAND_getValue, "()Lcom/tencent/filament/zplan/avatar/model/Float4;", "value", "Lcom/tencent/filament/zplan/avatar/model/ColorType;", "e", "Lcom/tencent/filament/zplan/avatar/model/ColorType;", "getType", "()Lcom/tencent/filament/zplan/avatar/model/ColorType;", "type", "<init>", "(Lcom/tencent/filament/zplan/avatar/model/Float4;Lcom/tencent/filament/zplan/avatar/model/ColorType;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class Color implements Parcelable {
    public static final Parcelable.Creator<Color> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Float4 value;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ColorType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<Color> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Color createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new Color(Float4.CREATOR.createFromParcel(in5), (ColorType) Enum.valueOf(ColorType.class, in5.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Color[] newArray(int i3) {
            return new Color[i3];
        }
    }

    public Color(@NotNull Float4 value, @NotNull ColorType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = value;
        this.type = type;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", ColorType.INSTANCE.a(this.type.getValue()));
        jSONObject.put("value", this.value.a());
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Color) {
                Color color = (Color) other;
                if (!Intrinsics.areEqual(this.value, color.value) || !Intrinsics.areEqual(this.type, color.type)) {
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
        Float4 float4 = this.value;
        int i16 = 0;
        if (float4 != null) {
            i3 = float4.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        ColorType colorType = this.type;
        if (colorType != null) {
            i16 = colorType.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "Color(value=" + this.value + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.value.writeToParcel(parcel, 0);
        parcel.writeString(this.type.name());
    }
}
