package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@PluginInterface
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b!\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010)\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\"\u0010/\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\"\u00102\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001f\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "selectShareByDefault", "Z", "getSelectShareByDefault", "()Z", "setSelectShareByDefault", "(Z)V", "showShare", "getShowShare", "setShowShare", "avatarSource", "I", "getAvatarSource", "()I", "setAvatarSource", "(I)V", "", "shareTipsText", "Ljava/lang/String;", "getShareTipsText", "()Ljava/lang/String;", "setShareTipsText", "(Ljava/lang/String;)V", "magicAvatarDelegateClassName", "getMagicAvatarDelegateClassName", "setMagicAvatarDelegateClassName", "currentAvatarUrl", "getCurrentAvatarUrl", "setCurrentAvatarUrl", "requestCode", "getRequestCode", "setRequestCode", "oldAvatarFilePath", "getOldAvatarFilePath", "setOldAvatarFilePath", "modifyChancesUsedUp", "getModifyChancesUsedUp", "setModifyChancesUsedUp", "modifyAvatarErrorMessage", "getModifyAvatarErrorMessage", "setModifyAvatarErrorMessage", "openVipSchema", "getOpenVipSchema", "setOpenVipSchema", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ModifyAvatarConfig implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int avatarSource;

    @NotNull
    private String currentAvatarUrl;

    @Nullable
    private String magicAvatarDelegateClassName;

    @NotNull
    private String modifyAvatarErrorMessage;
    private boolean modifyChancesUsedUp;

    @NotNull
    private String oldAvatarFilePath;

    @NotNull
    private String openVipSchema;
    private int requestCode;
    private boolean selectShareByDefault;

    @NotNull
    private String shareTipsText;
    private boolean showShare;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.ModifyAvatarConfig$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<ModifyAvatarConfig> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ModifyAvatarConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ModifyAvatarConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ModifyAvatarConfig[] newArray(int size) {
            return new ModifyAvatarConfig[size];
        }

        Companion() {
        }
    }

    public ModifyAvatarConfig() {
        this.showShare = true;
        this.shareTipsText = "";
        this.currentAvatarUrl = "";
        this.oldAvatarFilePath = "";
        this.modifyAvatarErrorMessage = "";
        this.openVipSchema = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAvatarSource() {
        return this.avatarSource;
    }

    @NotNull
    public final String getCurrentAvatarUrl() {
        return this.currentAvatarUrl;
    }

    @Nullable
    public final String getMagicAvatarDelegateClassName() {
        return this.magicAvatarDelegateClassName;
    }

    @NotNull
    public final String getModifyAvatarErrorMessage() {
        return this.modifyAvatarErrorMessage;
    }

    public final boolean getModifyChancesUsedUp() {
        return this.modifyChancesUsedUp;
    }

    @NotNull
    public final String getOldAvatarFilePath() {
        return this.oldAvatarFilePath;
    }

    @NotNull
    public final String getOpenVipSchema() {
        return this.openVipSchema;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final boolean getSelectShareByDefault() {
        return this.selectShareByDefault;
    }

    @NotNull
    public final String getShareTipsText() {
        return this.shareTipsText;
    }

    public final boolean getShowShare() {
        return this.showShare;
    }

    public final void setAvatarSource(int i3) {
        this.avatarSource = i3;
    }

    public final void setCurrentAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentAvatarUrl = str;
    }

    public final void setMagicAvatarDelegateClassName(@Nullable String str) {
        this.magicAvatarDelegateClassName = str;
    }

    public final void setModifyAvatarErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modifyAvatarErrorMessage = str;
    }

    public final void setModifyChancesUsedUp(boolean z16) {
        this.modifyChancesUsedUp = z16;
    }

    public final void setOldAvatarFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oldAvatarFilePath = str;
    }

    public final void setOpenVipSchema(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.openVipSchema = str;
    }

    public final void setRequestCode(int i3) {
        this.requestCode = i3;
    }

    public final void setSelectShareByDefault(boolean z16) {
        this.selectShareByDefault = z16;
    }

    public final void setShareTipsText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareTipsText = str;
    }

    public final void setShowShare(boolean z16) {
        this.showShare = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeByte(this.selectShareByDefault ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showShare ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.avatarSource);
        parcel.writeString(this.shareTipsText);
        parcel.writeString(this.magicAvatarDelegateClassName);
        parcel.writeString(this.currentAvatarUrl);
        parcel.writeInt(this.requestCode);
        parcel.writeString(this.oldAvatarFilePath);
        parcel.writeByte(this.modifyChancesUsedUp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.modifyAvatarErrorMessage);
        parcel.writeString(this.openVipSchema);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModifyAvatarConfig(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.selectShareByDefault = parcel.readByte() != 0;
        this.showShare = parcel.readByte() != 0;
        this.avatarSource = parcel.readInt();
        String readString = parcel.readString();
        this.shareTipsText = readString == null ? "" : readString;
        this.magicAvatarDelegateClassName = parcel.readString();
        String readString2 = parcel.readString();
        this.currentAvatarUrl = readString2 == null ? "" : readString2;
        this.requestCode = parcel.readInt();
        String readString3 = parcel.readString();
        this.oldAvatarFilePath = readString3 == null ? "" : readString3;
        this.modifyChancesUsedUp = parcel.readByte() != 0;
        String readString4 = parcel.readString();
        this.modifyAvatarErrorMessage = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.openVipSchema = readString5 != null ? readString5 : "";
    }
}
