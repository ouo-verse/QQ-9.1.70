package com.tencent.minibox.business.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0013H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "iconFilePath", "getIconFilePath", "setIconFilePath", PushClientConstants.TAG_PKG_NAME, "getPkgName", "setPkgName", "versionCode", "", "getVersionCode", "()I", "setVersionCode", "(I)V", "versionName", "getVersionName", "setVersionName", "describeContents", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxBusiness_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class MiniBoxAppInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String appName;

    @Nullable
    private String iconFilePath;

    @Nullable
    private String pkgName;
    private int versionCode;

    @Nullable
    private String versionName;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001d\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/minibox/business/api/MiniBoxAppInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "()V", "createFromPackageInfo", "context", "Landroid/content/Context;", "packageInfo", "Landroid/content/pm/PackageInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "MiniBoxBusiness_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.business.api.MiniBoxAppInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<MiniBoxAppInfo> {
        Companion() {
        }

        @NotNull
        public final MiniBoxAppInfo createFromPackageInfo(@NotNull Context context, @NotNull PackageInfo packageInfo) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(packageInfo, "packageInfo");
            MiniBoxAppInfo miniBoxAppInfo = new MiniBoxAppInfo();
            miniBoxAppInfo.setAppName(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
            miniBoxAppInfo.setVersionName(packageInfo.versionName);
            miniBoxAppInfo.setVersionCode(packageInfo.versionCode);
            miniBoxAppInfo.setPkgName(packageInfo.packageName);
            miniBoxAppInfo.setIconFilePath(h51.a.f404332a.e(context, packageInfo));
            return miniBoxAppInfo;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniBoxAppInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new MiniBoxAppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniBoxAppInfo[] newArray(int size) {
            return new MiniBoxAppInfo[size];
        }
    }

    public MiniBoxAppInfo() {
        this.versionCode = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    public final String getIconFilePath() {
        return this.iconFilePath;
    }

    @Nullable
    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @Nullable
    public final String getVersionName() {
        return this.versionName;
    }

    public final void setAppName(@Nullable String str) {
        this.appName = str;
    }

    public final void setIconFilePath(@Nullable String str) {
        this.iconFilePath = str;
    }

    public final void setPkgName(@Nullable String str) {
        this.pkgName = str;
    }

    public final void setVersionCode(int i3) {
        this.versionCode = i3;
    }

    public final void setVersionName(@Nullable String str) {
        this.versionName = str;
    }

    @NotNull
    public String toString() {
        return "MiniBoxAppInfo(appName=" + this.appName + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", iconFilePath=" + this.iconFilePath + ", pkgName=" + this.pkgName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.appName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeString(this.iconFilePath);
        parcel.writeString(this.pkgName);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniBoxAppInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.appName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.iconFilePath = parcel.readString();
        this.pkgName = parcel.readString();
    }
}
