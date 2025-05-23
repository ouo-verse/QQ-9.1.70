package com.tencent.minibox.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u00c6\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001J\u0006\u0010\u001a\u001a\u00020\bJ\t\u0010\u001b\u001a\u00020\bH\u00d6\u0001J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0006H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/minibox/contract/LaunchExtInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scene", "", "via", "", "reportData", "(ILjava/lang/String;Ljava/lang/String;)V", "getReportData", "()Ljava/lang/String;", "getScene", "()I", "getVia", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "info2String", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final /* data */ class LaunchExtInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String reportData;
    private final int scene;

    @Nullable
    private final String via;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/minibox/contract/LaunchExtInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/LaunchExtInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/LaunchExtInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.LaunchExtInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<LaunchExtInfo> {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LaunchExtInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new LaunchExtInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LaunchExtInfo[] newArray(int size) {
            return new LaunchExtInfo[size];
        }
    }

    public LaunchExtInfo(int i3, @Nullable String str, @Nullable String str2) {
        this.scene = i3;
        this.via = str;
        this.reportData = str2;
    }

    public static /* synthetic */ LaunchExtInfo copy$default(LaunchExtInfo launchExtInfo, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = launchExtInfo.scene;
        }
        if ((i16 & 2) != 0) {
            str = launchExtInfo.via;
        }
        if ((i16 & 4) != 0) {
            str2 = launchExtInfo.reportData;
        }
        return launchExtInfo.copy(i3, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getVia() {
        return this.via;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    public final LaunchExtInfo copy(int scene, @Nullable String via, @Nullable String reportData) {
        return new LaunchExtInfo(scene, via, reportData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LaunchExtInfo) {
                LaunchExtInfo launchExtInfo = (LaunchExtInfo) other;
                if (this.scene != launchExtInfo.scene || !Intrinsics.areEqual(this.via, launchExtInfo.via) || !Intrinsics.areEqual(this.reportData, launchExtInfo.reportData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    public final int getScene() {
        return this.scene;
    }

    @Nullable
    public final String getVia() {
        return this.via;
    }

    public int hashCode() {
        int i3;
        int i16 = this.scene * 31;
        String str = this.via;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.reportData;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i18 + i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r4 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String info2String() {
        boolean z16;
        String valueOf;
        String str;
        boolean isBlank;
        boolean isBlank2;
        String str2 = this.via;
        boolean z17 = false;
        if (str2 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
                z16 = false;
                String str3 = "";
                if (!z16) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(this.via);
                }
                str = this.reportData;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                }
                z17 = true;
                if (!z17) {
                    str3 = String.valueOf(this.reportData);
                }
                return this.scene + ';' + valueOf + ';' + str3;
            }
        }
        z16 = true;
        String str32 = "";
        if (!z16) {
        }
        str = this.reportData;
        if (str != null) {
        }
        z17 = true;
        if (!z17) {
        }
        return this.scene + ';' + valueOf + ';' + str32;
    }

    @NotNull
    public String toString() {
        return "LaunchExtInfo(scene=" + this.scene + ", via=" + this.via + ", reportData=" + this.reportData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.scene);
        parcel.writeString(this.via);
        parcel.writeString(this.reportData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LaunchExtInfo(@NotNull Parcel parcel) {
        this(parcel.readInt(), parcel.readString(), parcel.readString());
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
    }
}
