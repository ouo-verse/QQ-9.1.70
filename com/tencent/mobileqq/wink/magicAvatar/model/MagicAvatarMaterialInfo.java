package com.tencent.mobileqq.wink.magicAvatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b,\u0010.J\u0006\u0010\u0002\u001a\u00020\u0000J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "Landroid/os/Parcelable;", "copy", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Ljava/lang/String;", "getMaterialId", "()Ljava/lang/String;", "setMaterialId", "(Ljava/lang/String;)V", "styleName", "getStyleName", "setStyleName", "materialUrl", "getMaterialUrl", "setMaterialUrl", "localPicPath", "getLocalPicPath", "setLocalPicPath", "generateUrl", "getGenerateUrl", "setGenerateUrl", "generateQRUrl", "getGenerateQRUrl", "setGenerateQRUrl", "", "isSelected", "Z", "()Z", "setSelected", "(Z)V", "type", "I", "getType", "()I", "setType", "(I)V", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarMaterialInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String generateQRUrl;

    @NotNull
    private String generateUrl;
    private boolean isSelected;

    @NotNull
    private String localPicPath;

    @NotNull
    private String materialId;

    @NotNull
    private String materialUrl;

    @NotNull
    private String styleName;
    private int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<MagicAvatarMaterialInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MagicAvatarMaterialInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MagicAvatarMaterialInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MagicAvatarMaterialInfo[] newArray(int size) {
            return new MagicAvatarMaterialInfo[size];
        }

        Companion() {
        }
    }

    public MagicAvatarMaterialInfo() {
        this.materialId = "";
        this.styleName = "";
        this.materialUrl = "";
        this.localPicPath = "";
        this.generateUrl = "";
        this.generateQRUrl = "";
    }

    @NotNull
    public final MagicAvatarMaterialInfo copy() {
        MagicAvatarMaterialInfo magicAvatarMaterialInfo = new MagicAvatarMaterialInfo();
        magicAvatarMaterialInfo.materialId = this.materialId;
        magicAvatarMaterialInfo.styleName = this.styleName;
        magicAvatarMaterialInfo.materialUrl = this.materialUrl;
        magicAvatarMaterialInfo.localPicPath = this.localPicPath;
        magicAvatarMaterialInfo.generateUrl = this.generateUrl;
        magicAvatarMaterialInfo.generateQRUrl = this.generateQRUrl;
        magicAvatarMaterialInfo.isSelected = this.isSelected;
        magicAvatarMaterialInfo.type = this.type;
        return magicAvatarMaterialInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getGenerateQRUrl() {
        return this.generateQRUrl;
    }

    @NotNull
    public final String getGenerateUrl() {
        return this.generateUrl;
    }

    @NotNull
    public final String getLocalPicPath() {
        return this.localPicPath;
    }

    @NotNull
    public final String getMaterialId() {
        return this.materialId;
    }

    @NotNull
    public final String getMaterialUrl() {
        return this.materialUrl;
    }

    @NotNull
    public final String getStyleName() {
        return this.styleName;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setGenerateQRUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.generateQRUrl = str;
    }

    public final void setGenerateUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.generateUrl = str;
    }

    public final void setLocalPicPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localPicPath = str;
    }

    public final void setMaterialId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.materialId = str;
    }

    public final void setMaterialUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.materialUrl = str;
    }

    public final void setSelected(boolean z16) {
        this.isSelected = z16;
    }

    public final void setStyleName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.styleName = str;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.materialId);
        parcel.writeString(this.styleName);
        parcel.writeString(this.materialUrl);
        parcel.writeString(this.localPicPath);
        parcel.writeString(this.generateUrl);
        parcel.writeString(this.generateQRUrl);
        parcel.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.type);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MagicAvatarMaterialInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.materialId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.styleName = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.materialUrl = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.localPicPath = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.generateUrl = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        this.generateQRUrl = readString6 != null ? readString6 : "";
        this.isSelected = parcel.readByte() != 0;
        this.type = parcel.readInt();
    }
}
