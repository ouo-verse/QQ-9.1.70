package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/MakeUpConfig;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "getPngPath", "()Ljava/lang/String;", "pngPath", "e", "getJsonPath", "jsonPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class MakeUpConfig implements Parcelable {
    public static final Parcelable.Creator<MakeUpConfig> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pngPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jsonPath;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<MakeUpConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MakeUpConfig createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new MakeUpConfig(in5.readString(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MakeUpConfig[] newArray(int i3) {
            return new MakeUpConfig[i3];
        }
    }

    public MakeUpConfig(@NotNull String pngPath, @NotNull String jsonPath) {
        Intrinsics.checkNotNullParameter(pngPath, "pngPath");
        Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
        this.pngPath = pngPath;
        this.jsonPath = jsonPath;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pngPath", this.pngPath);
        jSONObject.put("jsonPath", this.jsonPath);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MakeUpConfig) {
                MakeUpConfig makeUpConfig = (MakeUpConfig) other;
                if (!Intrinsics.areEqual(this.pngPath, makeUpConfig.pngPath) || !Intrinsics.areEqual(this.jsonPath, makeUpConfig.jsonPath)) {
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
        String str = this.pngPath;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.jsonPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "MakeUpConfig(pngPath=" + this.pngPath + ", jsonPath=" + this.jsonPath + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.pngPath);
        parcel.writeString(this.jsonPath);
    }
}
