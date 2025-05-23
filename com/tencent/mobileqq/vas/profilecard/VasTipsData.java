package com.tencent.mobileqq.vas.profilecard;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004Bi\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\u0006H\u00c6\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u00c6\u0001J\b\u0010)\u001a\u00020\tH\u0016J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020\tH\u00d6\u0001J\t\u0010/\u001a\u00020\u0006H\u00d6\u0001J\u0018\u00100\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u00020\tH\u0016R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/VasTipsData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "leftIcon", "", "textContent", "textColor", "", "rightButtonText", "rightButtonColor", "buttonBg", "picBg", WadlProxyConsts.KEY_JUMP_URL, "clmParams", "diyPicBg", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonBg", "()Ljava/lang/String;", "getClmParams", "getDiyPicBg", "getJumpUrl", "getLeftIcon", "getPicBg", "getRightButtonColor", "()I", "getRightButtonText", "getTextColor", "getTextContent", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasTipsData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String buttonBg;

    @NotNull
    private final String clmParams;

    @NotNull
    private final String diyPicBg;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String leftIcon;

    @NotNull
    private final String picBg;
    private final int rightButtonColor;

    @NotNull
    private final String rightButtonText;
    private final int textColor;

    @NotNull
    private final String textContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/VasTipsData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/vas/profilecard/VasTipsData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/vas/profilecard/VasTipsData;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.vas.profilecard.VasTipsData$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion implements Parcelable.Creator<VasTipsData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VasTipsData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VasTipsData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VasTipsData[] newArray(int size) {
            return new VasTipsData[size];
        }
    }

    public VasTipsData() {
        this(null, null, 0, null, 0, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ VasTipsData copy$default(VasTipsData vasTipsData, String str, String str2, int i3, String str3, int i16, String str4, String str5, String str6, String str7, String str8, int i17, Object obj) {
        String str9;
        String str10;
        int i18;
        String str11;
        int i19;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        if ((i17 & 1) != 0) {
            str9 = vasTipsData.leftIcon;
        } else {
            str9 = str;
        }
        if ((i17 & 2) != 0) {
            str10 = vasTipsData.textContent;
        } else {
            str10 = str2;
        }
        if ((i17 & 4) != 0) {
            i18 = vasTipsData.textColor;
        } else {
            i18 = i3;
        }
        if ((i17 & 8) != 0) {
            str11 = vasTipsData.rightButtonText;
        } else {
            str11 = str3;
        }
        if ((i17 & 16) != 0) {
            i19 = vasTipsData.rightButtonColor;
        } else {
            i19 = i16;
        }
        if ((i17 & 32) != 0) {
            str12 = vasTipsData.buttonBg;
        } else {
            str12 = str4;
        }
        if ((i17 & 64) != 0) {
            str13 = vasTipsData.picBg;
        } else {
            str13 = str5;
        }
        if ((i17 & 128) != 0) {
            str14 = vasTipsData.jumpUrl;
        } else {
            str14 = str6;
        }
        if ((i17 & 256) != 0) {
            str15 = vasTipsData.clmParams;
        } else {
            str15 = str7;
        }
        if ((i17 & 512) != 0) {
            str16 = vasTipsData.diyPicBg;
        } else {
            str16 = str8;
        }
        return vasTipsData.copy(str9, str10, i18, str11, i19, str12, str13, str14, str15, str16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLeftIcon() {
        return this.leftIcon;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getDiyPicBg() {
        return this.diyPicBg;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getRightButtonText() {
        return this.rightButtonText;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRightButtonColor() {
        return this.rightButtonColor;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getButtonBg() {
        return this.buttonBg;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getPicBg() {
        return this.picBg;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getClmParams() {
        return this.clmParams;
    }

    @NotNull
    public final VasTipsData copy(@NotNull String leftIcon, @NotNull String textContent, int textColor, @NotNull String rightButtonText, int rightButtonColor, @NotNull String buttonBg, @NotNull String picBg, @NotNull String jumpUrl, @NotNull String clmParams, @NotNull String diyPicBg) {
        Intrinsics.checkNotNullParameter(leftIcon, "leftIcon");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(buttonBg, "buttonBg");
        Intrinsics.checkNotNullParameter(picBg, "picBg");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(clmParams, "clmParams");
        Intrinsics.checkNotNullParameter(diyPicBg, "diyPicBg");
        return new VasTipsData(leftIcon, textContent, textColor, rightButtonText, rightButtonColor, buttonBg, picBg, jumpUrl, clmParams, diyPicBg);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasTipsData)) {
            return false;
        }
        VasTipsData vasTipsData = (VasTipsData) other;
        if (Intrinsics.areEqual(this.leftIcon, vasTipsData.leftIcon) && Intrinsics.areEqual(this.textContent, vasTipsData.textContent) && this.textColor == vasTipsData.textColor && Intrinsics.areEqual(this.rightButtonText, vasTipsData.rightButtonText) && this.rightButtonColor == vasTipsData.rightButtonColor && Intrinsics.areEqual(this.buttonBg, vasTipsData.buttonBg) && Intrinsics.areEqual(this.picBg, vasTipsData.picBg) && Intrinsics.areEqual(this.jumpUrl, vasTipsData.jumpUrl) && Intrinsics.areEqual(this.clmParams, vasTipsData.clmParams) && Intrinsics.areEqual(this.diyPicBg, vasTipsData.diyPicBg)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getButtonBg() {
        return this.buttonBg;
    }

    @NotNull
    public final String getClmParams() {
        return this.clmParams;
    }

    @NotNull
    public final String getDiyPicBg() {
        return this.diyPicBg;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getLeftIcon() {
        return this.leftIcon;
    }

    @NotNull
    public final String getPicBg() {
        return this.picBg;
    }

    public final int getRightButtonColor() {
        return this.rightButtonColor;
    }

    @NotNull
    public final String getRightButtonText() {
        return this.rightButtonText;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    @NotNull
    public final String getTextContent() {
        return this.textContent;
    }

    public int hashCode() {
        return (((((((((((((((((this.leftIcon.hashCode() * 31) + this.textContent.hashCode()) * 31) + this.textColor) * 31) + this.rightButtonText.hashCode()) * 31) + this.rightButtonColor) * 31) + this.buttonBg.hashCode()) * 31) + this.picBg.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.clmParams.hashCode()) * 31) + this.diyPicBg.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasTipsData(leftIcon=" + this.leftIcon + ", textContent=" + this.textContent + ", textColor=" + this.textColor + ", rightButtonText=" + this.rightButtonText + ", rightButtonColor=" + this.rightButtonColor + ", buttonBg=" + this.buttonBg + ", picBg=" + this.picBg + ", jumpUrl=" + this.jumpUrl + ", clmParams=" + this.clmParams + ", diyPicBg=" + this.diyPicBg + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.leftIcon);
        parcel.writeString(this.textContent);
        parcel.writeInt(this.textColor);
        parcel.writeString(this.rightButtonText);
        parcel.writeInt(this.rightButtonColor);
        parcel.writeString(this.buttonBg);
        parcel.writeString(this.picBg);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.clmParams);
        parcel.writeString(this.diyPicBg);
    }

    public VasTipsData(@NotNull String leftIcon, @NotNull String textContent, int i3, @NotNull String rightButtonText, int i16, @NotNull String buttonBg, @NotNull String picBg, @NotNull String jumpUrl, @NotNull String clmParams, @NotNull String diyPicBg) {
        Intrinsics.checkNotNullParameter(leftIcon, "leftIcon");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
        Intrinsics.checkNotNullParameter(buttonBg, "buttonBg");
        Intrinsics.checkNotNullParameter(picBg, "picBg");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(clmParams, "clmParams");
        Intrinsics.checkNotNullParameter(diyPicBg, "diyPicBg");
        this.leftIcon = leftIcon;
        this.textContent = textContent;
        this.textColor = i3;
        this.rightButtonText = rightButtonText;
        this.rightButtonColor = i16;
        this.buttonBg = buttonBg;
        this.picBg = picBg;
        this.jumpUrl = jumpUrl;
        this.clmParams = clmParams;
        this.diyPicBg = diyPicBg;
    }

    public /* synthetic */ VasTipsData(String str, String str2, int i3, String str3, int i16, String str4, String str5, String str6, String str7, String str8, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? -16777216 : i3, (i17 & 8) != 0 ? "" : str3, (i17 & 16) == 0 ? i16 : -16777216, (i17 & 32) != 0 ? "" : str4, (i17 & 64) != 0 ? "" : str5, (i17 & 128) != 0 ? "" : str6, (i17 & 256) != 0 ? "" : str7, (i17 & 512) == 0 ? str8 : "");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VasTipsData(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r14 == null ? "" : r14);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        int readInt = parcel.readInt();
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        int readInt2 = parcel.readInt();
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
    }
}
