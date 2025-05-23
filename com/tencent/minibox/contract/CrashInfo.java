package com.tencent.minibox.contract;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020!H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000b\u00a8\u0006&"}, d2 = {"Lcom/tencent/minibox/contract/CrashInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "crashTime", "", "getCrashTime", "()J", "setCrashTime", "(J)V", "isReport", "", "()Z", "setReport", "(Z)V", "launchTime", "getLaunchTime", "setLaunchTime", "packageName", "getPackageName", "setPackageName", "describeContents", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class CrashInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String appId;

    @Nullable
    private String appVersion;
    private long crashTime;
    private boolean isReport;
    private long launchTime;

    @Nullable
    private String packageName;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/minibox/contract/CrashInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/CrashInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/CrashInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.CrashInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<CrashInfo> {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CrashInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new CrashInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CrashInfo[] newArray(int size) {
            return new CrashInfo[size];
        }
    }

    public CrashInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final long getCrashTime() {
        return this.crashTime;
    }

    public final long getLaunchTime() {
        return this.launchTime;
    }

    @Nullable
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: isReport, reason: from getter */
    public final boolean getIsReport() {
        return this.isReport;
    }

    public final void setAppId(@Nullable String str) {
        this.appId = str;
    }

    public final void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public final void setCrashTime(long j3) {
        this.crashTime = j3;
    }

    public final void setLaunchTime(long j3) {
        this.launchTime = j3;
    }

    public final void setPackageName(@Nullable String str) {
        this.packageName = str;
    }

    public final void setReport(boolean z16) {
        this.isReport = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.launchTime);
        parcel.writeLong(this.crashTime);
        parcel.writeByte(this.isReport ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CrashInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.packageName = parcel.readString();
        this.launchTime = parcel.readLong();
        this.crashTime = parcel.readLong();
        this.isReport = parcel.readByte() != ((byte) 0);
    }
}
