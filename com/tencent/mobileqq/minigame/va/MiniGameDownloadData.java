package com.tencent.mobileqq.minigame.va;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J\u0018\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u000204H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000b\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "apkPath", "", "getApkPath", "()Ljava/lang/String;", "setApkPath", "(Ljava/lang/String;)V", "diffPatchInfo", "Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "getDiffPatchInfo", "()Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "setDiffPatchInfo", "(Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;)V", "downloadSize", "", "getDownloadSize", "()J", "setDownloadSize", "(J)V", "downloadUrl", "getDownloadUrl", "setDownloadUrl", "gameIcon", "getGameIcon", "setGameIcon", VirtualAppProxy.KEY_GAME_ID, "getGameId", "setGameId", "gameName", "getGameName", "setGameName", "miniVersionCode", "getMiniVersionCode", "setMiniVersionCode", PushClientConstants.TAG_PKG_NAME, "getPkgName", "setPkgName", "size", "getSize", "setSize", "tickets", "getTickets", "setTickets", "versionCode", "getVersionCode", "setVersionCode", "describeContents", "", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class MiniGameDownloadData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String apkPath;

    @Nullable
    private MiniGameDiffPatchInfo diffPatchInfo;
    private long downloadSize;

    @Nullable
    private String downloadUrl;

    @NotNull
    private String gameIcon;

    @NotNull
    private String gameId;

    @NotNull
    private String gameName;

    @Nullable
    private String miniVersionCode;

    @Nullable
    private String pkgName;
    private long size;

    @Nullable
    private String tickets;

    @Nullable
    private String versionCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.minigame.va.MiniGameDownloadData$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<MiniGameDownloadData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDownloadData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MiniGameDownloadData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDownloadData[] newArray(int size) {
            return new MiniGameDownloadData[size];
        }
    }

    public MiniGameDownloadData() {
        this.gameId = "";
        this.gameIcon = "";
        this.gameName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getApkPath() {
        return this.apkPath;
    }

    @Nullable
    public final MiniGameDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    public final long getDownloadSize() {
        return this.downloadSize;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @NotNull
    public final String getGameIcon() {
        return this.gameIcon;
    }

    @NotNull
    public final String getGameId() {
        return this.gameId;
    }

    @NotNull
    public final String getGameName() {
        return this.gameName;
    }

    @Nullable
    public final String getMiniVersionCode() {
        return this.miniVersionCode;
    }

    @Nullable
    public final String getPkgName() {
        return this.pkgName;
    }

    public final long getSize() {
        return this.size;
    }

    @Nullable
    public final String getTickets() {
        return this.tickets;
    }

    @Nullable
    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setApkPath(@Nullable String str) {
        this.apkPath = str;
    }

    public final void setDiffPatchInfo(@Nullable MiniGameDiffPatchInfo miniGameDiffPatchInfo) {
        this.diffPatchInfo = miniGameDiffPatchInfo;
    }

    public final void setDownloadSize(long j3) {
        this.downloadSize = j3;
    }

    public final void setDownloadUrl(@Nullable String str) {
        this.downloadUrl = str;
    }

    public final void setGameIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameIcon = str;
    }

    public final void setGameId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameId = str;
    }

    public final void setGameName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameName = str;
    }

    public final void setMiniVersionCode(@Nullable String str) {
        this.miniVersionCode = str;
    }

    public final void setPkgName(@Nullable String str) {
        this.pkgName = str;
    }

    public final void setSize(long j3) {
        this.size = j3;
    }

    public final void setTickets(@Nullable String str) {
        this.tickets = str;
    }

    public final void setVersionCode(@Nullable String str) {
        this.versionCode = str;
    }

    @NotNull
    public String toString() {
        return "MiniGameDownloadData(gameId='" + this.gameId + "', gameIcon='" + this.gameIcon + "', gameName='" + this.gameName + "', pkgName=" + this.pkgName + ", versionCode=" + this.versionCode + ", downloadUrl=" + this.downloadUrl + ", tickets=" + this.tickets + ", apkPath=" + this.apkPath + ", miniVersionCode=" + this.miniVersionCode + ", downloadSize=" + this.downloadSize + ", size=" + this.size + ", diffPatchInfo=" + this.diffPatchInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.gameId);
        parcel.writeString(this.gameIcon);
        parcel.writeString(this.gameName);
        parcel.writeString(this.pkgName);
        parcel.writeString(this.versionCode);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.tickets);
        parcel.writeString(this.apkPath);
        parcel.writeLong(this.downloadSize);
        parcel.writeLong(this.size);
        parcel.writeParcelable(this.diffPatchInfo, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniGameDownloadData(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.gameId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.gameIcon = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.gameName = readString3 != null ? readString3 : "";
        this.pkgName = parcel.readString();
        this.versionCode = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.tickets = parcel.readString();
        this.apkPath = parcel.readString();
        this.downloadSize = parcel.readLong();
        this.size = parcel.readLong();
        this.diffPatchInfo = (MiniGameDiffPatchInfo) parcel.readParcelable(MiniGameDiffPatchInfo.class.getClassLoader());
    }
}
