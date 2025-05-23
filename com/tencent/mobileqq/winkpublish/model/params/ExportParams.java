package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0014\u001a\u00020\nH\u00c6\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\bH\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "missionId", "", "resolutionLevel", "", "enableSpeedTest", "", "(Ljava/lang/String;IZ)V", "getEnableSpeedTest", "()Z", "getMissionId", "()Ljava/lang/String;", "getResolutionLevel", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ExportParams implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean enableSpeedTest;

    @NotNull
    private final String missionId;
    private final int resolutionLevel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/winkpublish/model/params/ExportParams;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.winkpublish.model.params.ExportParams$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<ExportParams> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExportParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExportParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExportParams[] newArray(int size) {
            return new ExportParams[size];
        }
    }

    public ExportParams(@NotNull String missionId, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        this.missionId = missionId;
        this.resolutionLevel = i3;
        this.enableSpeedTest = z16;
    }

    public static /* synthetic */ ExportParams copy$default(ExportParams exportParams, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = exportParams.missionId;
        }
        if ((i16 & 2) != 0) {
            i3 = exportParams.resolutionLevel;
        }
        if ((i16 & 4) != 0) {
            z16 = exportParams.enableSpeedTest;
        }
        return exportParams.copy(str, i3, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getResolutionLevel() {
        return this.resolutionLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableSpeedTest() {
        return this.enableSpeedTest;
    }

    @NotNull
    public final ExportParams copy(@NotNull String missionId, int resolutionLevel, boolean enableSpeedTest) {
        Intrinsics.checkNotNullParameter(missionId, "missionId");
        return new ExportParams(missionId, resolutionLevel, enableSpeedTest);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExportParams)) {
            return false;
        }
        ExportParams exportParams = (ExportParams) other;
        if (Intrinsics.areEqual(this.missionId, exportParams.missionId) && this.resolutionLevel == exportParams.resolutionLevel && this.enableSpeedTest == exportParams.enableSpeedTest) {
            return true;
        }
        return false;
    }

    public final boolean getEnableSpeedTest() {
        return this.enableSpeedTest;
    }

    @NotNull
    public final String getMissionId() {
        return this.missionId;
    }

    public final int getResolutionLevel() {
        return this.resolutionLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.missionId.hashCode() * 31) + this.resolutionLevel) * 31;
        boolean z16 = this.enableSpeedTest;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ExportParams(missionId=" + this.missionId + ", resolutionLevel=" + this.resolutionLevel + ", enableSpeedTest=" + this.enableSpeedTest + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.missionId);
        parcel.writeInt(this.resolutionLevel);
        parcel.writeByte(this.enableSpeedTest ? (byte) 1 : (byte) 0);
    }

    public /* synthetic */ ExportParams(String str, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? false : z16);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExportParams(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readInt(), parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
