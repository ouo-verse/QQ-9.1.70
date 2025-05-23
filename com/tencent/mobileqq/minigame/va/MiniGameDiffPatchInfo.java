package com.tencent.mobileqq.minigame.va;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\u0006\u0010'\u001a\u00020\u0007J\b\u0010(\u001a\u00020\"H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\"H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "baseVersionName", "", "getBaseVersionName", "()Ljava/lang/String;", "setBaseVersionName", "(Ljava/lang/String;)V", "diffPatchUrl", "getDiffPatchUrl", "setDiffPatchUrl", "newApkDataSize", "", "getNewApkDataSize", "()J", "setNewApkDataSize", "(J)V", "newMd5", "getNewMd5", "setNewMd5", "newVersionName", "getNewVersionName", "setNewVersionName", "patchMd5", "getPatchMd5", "setPatchMd5", "patchSize", "getPatchSize", "setPatchSize", "describeContents", "", "equals", "", "other", "", "getDiffTaskKey", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.tencent.mobileqq.minigame.va.MiniBoxDiffPatchInfo, reason: from toString */
/* loaded from: classes15.dex */
public final class MiniGameDiffPatchInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String baseVersionName;

    @Nullable
    private String diffPatchUrl;
    private long newApkDataSize;

    @Nullable
    private String newMd5;

    @Nullable
    private String newVersionName;

    @Nullable
    private String patchMd5;
    private long patchSize;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/minigame/va/MiniBoxDiffPatchInfo;", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.minigame.va.MiniBoxDiffPatchInfo$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<MiniGameDiffPatchInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDiffPatchInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MiniGameDiffPatchInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MiniGameDiffPatchInfo[] newArray(int size) {
            return new MiniGameDiffPatchInfo[size];
        }
    }

    public MiniGameDiffPatchInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniGameDiffPatchInfo)) {
            return false;
        }
        MiniGameDiffPatchInfo miniGameDiffPatchInfo = (MiniGameDiffPatchInfo) other;
        if (Intrinsics.areEqual(this.diffPatchUrl, miniGameDiffPatchInfo.diffPatchUrl) && this.patchSize == miniGameDiffPatchInfo.patchSize && Intrinsics.areEqual(this.patchMd5, miniGameDiffPatchInfo.patchMd5) && Intrinsics.areEqual(this.baseVersionName, miniGameDiffPatchInfo.baseVersionName) && Intrinsics.areEqual(this.newVersionName, miniGameDiffPatchInfo.newVersionName) && Intrinsics.areEqual(this.newMd5, miniGameDiffPatchInfo.newMd5)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getBaseVersionName() {
        return this.baseVersionName;
    }

    @Nullable
    public final String getDiffPatchUrl() {
        return this.diffPatchUrl;
    }

    @NotNull
    public final String getDiffTaskKey() {
        return this.baseVersionName + util.base64_pad_url + this.newVersionName;
    }

    public final long getNewApkDataSize() {
        return this.newApkDataSize;
    }

    @Nullable
    public final String getNewMd5() {
        return this.newMd5;
    }

    @Nullable
    public final String getNewVersionName() {
        return this.newVersionName;
    }

    @Nullable
    public final String getPatchMd5() {
        return this.patchMd5;
    }

    public final long getPatchSize() {
        return this.patchSize;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.diffPatchUrl;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int a16 = ((i3 * 31) + androidx.fragment.app.a.a(this.patchSize)) * 31;
        String str2 = this.patchMd5;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (a16 + i16) * 31;
        String str3 = this.baseVersionName;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.newVersionName;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i28 = (i27 + i18) * 31;
        String str5 = this.newMd5;
        if (str5 != null) {
            i19 = str5.hashCode();
        }
        return i28 + i19;
    }

    public final void setBaseVersionName(@Nullable String str) {
        this.baseVersionName = str;
    }

    public final void setDiffPatchUrl(@Nullable String str) {
        this.diffPatchUrl = str;
    }

    public final void setNewApkDataSize(long j3) {
        this.newApkDataSize = j3;
    }

    public final void setNewMd5(@Nullable String str) {
        this.newMd5 = str;
    }

    public final void setNewVersionName(@Nullable String str) {
        this.newVersionName = str;
    }

    public final void setPatchMd5(@Nullable String str) {
        this.patchMd5 = str;
    }

    public final void setPatchSize(long j3) {
        this.patchSize = j3;
    }

    @NotNull
    public String toString() {
        return "MiniGameDiffPatchInfo(diffPatchUrl=" + this.diffPatchUrl + ", patchSize=" + this.patchSize + ", patchMd5=" + this.patchMd5 + ", baseVersionName=" + this.baseVersionName + ", newVersionName=" + this.newVersionName + ", newMd5=" + this.newMd5 + ", newApkDataSize=" + this.newApkDataSize + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.diffPatchUrl);
        parcel.writeLong(this.patchSize);
        parcel.writeString(this.patchMd5);
        parcel.writeString(this.baseVersionName);
        parcel.writeString(this.newVersionName);
        parcel.writeString(this.newMd5);
        parcel.writeLong(this.newApkDataSize);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniGameDiffPatchInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.diffPatchUrl = parcel.readString();
        this.patchSize = parcel.readLong();
        this.patchMd5 = parcel.readString();
        this.baseVersionName = parcel.readString();
        this.newVersionName = parcel.readString();
        this.newMd5 = parcel.readString();
        this.newApkDataSize = parcel.readLong();
    }
}
