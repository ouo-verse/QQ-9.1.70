package com.tencent.minibox.contract;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020<H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001c\u00108\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000b\u00a8\u0006B"}, d2 = {"Lcom/tencent/minibox/contract/LaunchAppInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "extendBundle", "Landroid/os/Bundle;", "getExtendBundle", "()Landroid/os/Bundle;", "setExtendBundle", "(Landroid/os/Bundle;)V", "installDialogData", "Lcom/tencent/minibox/contract/LocalInstallInfo;", "getInstallDialogData", "()Lcom/tencent/minibox/contract/LocalInstallInfo;", "setInstallDialogData", "(Lcom/tencent/minibox/contract/LocalInstallInfo;)V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", MiniChatConstants.MINI_APP_LANDSCAPE, "", "()Z", "setLandscape", "(Z)V", "launch", "Lcom/tencent/minibox/contract/LaunchExtInfo;", "getLaunch", "()Lcom/tencent/minibox/contract/LaunchExtInfo;", "setLaunch", "(Lcom/tencent/minibox/contract/LaunchExtInfo;)V", "launchTime", "", "getLaunchTime", "()J", "setLaunchTime", "(J)V", "loadingIconPath", "getLoadingIconPath", "setLoadingIconPath", "needShowLoading", "getNeedShowLoading", "setNeedShowLoading", "packageName", "getPackageName", "setPackageName", "describeContents", "", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class LaunchAppInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String appId;

    @Nullable
    private String appVersion;

    @Nullable
    private Bundle extendBundle;

    @Nullable
    private LocalInstallInfo installDialogData;

    @Nullable
    private Intent intent;
    private boolean isLandscape;

    @Nullable
    private LaunchExtInfo launch;
    private long launchTime;

    @Nullable
    private String loadingIconPath;
    private boolean needShowLoading;

    @Nullable
    private String packageName;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/minibox/contract/LaunchAppInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/LaunchAppInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/LaunchAppInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.LaunchAppInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<LaunchAppInfo> {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LaunchAppInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new LaunchAppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LaunchAppInfo[] newArray(int size) {
            return new LaunchAppInfo[size];
        }
    }

    public LaunchAppInfo() {
        this.isLandscape = true;
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

    @Nullable
    public final Bundle getExtendBundle() {
        return this.extendBundle;
    }

    @Nullable
    public final LocalInstallInfo getInstallDialogData() {
        return this.installDialogData;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    @Nullable
    public final LaunchExtInfo getLaunch() {
        return this.launch;
    }

    public final long getLaunchTime() {
        return this.launchTime;
    }

    @Nullable
    public final String getLoadingIconPath() {
        return this.loadingIconPath;
    }

    public final boolean getNeedShowLoading() {
        return this.needShowLoading;
    }

    @Nullable
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    public final void setAppId(@Nullable String str) {
        this.appId = str;
    }

    public final void setAppVersion(@Nullable String str) {
        this.appVersion = str;
    }

    public final void setExtendBundle(@Nullable Bundle bundle) {
        this.extendBundle = bundle;
    }

    public final void setInstallDialogData(@Nullable LocalInstallInfo localInstallInfo) {
        this.installDialogData = localInstallInfo;
    }

    public final void setIntent(@Nullable Intent intent) {
        this.intent = intent;
    }

    public final void setLandscape(boolean z16) {
        this.isLandscape = z16;
    }

    public final void setLaunch(@Nullable LaunchExtInfo launchExtInfo) {
        this.launch = launchExtInfo;
    }

    public final void setLaunchTime(long j3) {
        this.launchTime = j3;
    }

    public final void setLoadingIconPath(@Nullable String str) {
        this.loadingIconPath = str;
    }

    public final void setNeedShowLoading(boolean z16) {
        this.needShowLoading = z16;
    }

    public final void setPackageName(@Nullable String str) {
        this.packageName = str;
    }

    @NotNull
    public String toString() {
        return "LaunchAppInfo(packageName=" + this.packageName + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ", launchTime=" + this.launchTime + "), intent=" + this.intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.packageName);
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
        parcel.writeLong(this.launchTime);
        parcel.writeParcelable(this.launch, flags);
        parcel.writeParcelable(this.installDialogData, flags);
        parcel.writeString(this.loadingIconPath);
        parcel.writeInt(this.needShowLoading ? 1 : 0);
        parcel.writeInt(this.isLandscape ? 1 : 0);
        parcel.writeParcelable(this.intent, flags);
        parcel.writeBundle(this.extendBundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LaunchAppInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.packageName = parcel.readString();
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.launchTime = parcel.readLong();
        this.launch = (LaunchExtInfo) parcel.readParcelable(LaunchExtInfo.class.getClassLoader());
        this.installDialogData = (LocalInstallInfo) parcel.readParcelable(LocalInstallInfo.class.getClassLoader());
        this.loadingIconPath = parcel.readString();
        this.needShowLoading = parcel.readInt() == 1;
        this.isLandscape = parcel.readInt() == 1;
        this.intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.extendBundle = parcel.readBundle();
    }
}
