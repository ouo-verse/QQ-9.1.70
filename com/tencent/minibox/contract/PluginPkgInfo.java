package com.tencent.minibox.contract;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0019H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/minibox/contract/PluginPkgInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appIconUri", "Landroid/net/Uri;", "getAppIconUri", "()Landroid/net/Uri;", "setAppIconUri", "(Landroid/net/Uri;)V", "appLabel", "", "getAppLabel", "()Ljava/lang/String;", "setAppLabel", "(Ljava/lang/String;)V", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "setPackageInfo", "(Landroid/content/pm/PackageInfo;)V", "describeContents", "", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class PluginPkgInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Uri appIconUri;

    @Nullable
    private String appLabel;

    @Nullable
    private PackageInfo packageInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/minibox/contract/PluginPkgInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/minibox/contract/PluginPkgInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/minibox/contract/PluginPkgInfo;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
    /* renamed from: com.tencent.minibox.contract.PluginPkgInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion implements Parcelable.Creator<PluginPkgInfo> {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PluginPkgInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new PluginPkgInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PluginPkgInfo[] newArray(int size) {
            return new PluginPkgInfo[size];
        }
    }

    public PluginPkgInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Uri getAppIconUri() {
        return this.appIconUri;
    }

    @Nullable
    public final String getAppLabel() {
        return this.appLabel;
    }

    @Nullable
    public final PackageInfo getPackageInfo() {
        return this.packageInfo;
    }

    public final void setAppIconUri(@Nullable Uri uri) {
        this.appIconUri = uri;
    }

    public final void setAppLabel(@Nullable String str) {
        this.appLabel = str;
    }

    public final void setPackageInfo(@Nullable PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeParcelable(this.packageInfo, flags);
        parcel.writeString(this.appLabel);
        parcel.writeParcelable(this.appIconUri, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PluginPkgInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        this.packageInfo = (PackageInfo) parcel.readParcelable(PackageInfo.class.getClassLoader());
        this.appLabel = parcel.readString();
        this.appIconUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
