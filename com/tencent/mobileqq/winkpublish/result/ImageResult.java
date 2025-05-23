package com.tencent.mobileqq.winkpublish.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BU\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010'\u001a\u00020\nH\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\b\u0010-\u001a\u00020\nH\u0016J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u00d6\u0003J\t\u00102\u001a\u00020\nH\u00d6\u0001J\t\u00103\u001a\u00020\u0006H\u00d6\u0001J\u0018\u00104\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u00020\nH\u0016R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "Lcom/tencent/mobileqq/winkpublish/result/MediaUploadResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "smallUrl", "", "bigUrl", "originUrl", "bigWidth", "", "bigHeight", "originWidth", "originHeight", "md5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;)V", "getBigHeight", "()I", "setBigHeight", "(I)V", "getBigUrl", "()Ljava/lang/String;", "setBigUrl", "(Ljava/lang/String;)V", "getBigWidth", "setBigWidth", "getMd5", "setMd5", "getOriginHeight", "setOriginHeight", "getOriginUrl", "setOriginUrl", "getOriginWidth", "setOriginWidth", "getSmallUrl", "setSmallUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "CREATOR", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ImageResult extends MediaUploadResult {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int bigHeight;

    @NotNull
    private String bigUrl;
    private int bigWidth;

    @NotNull
    private String md5;
    private int originHeight;

    @NotNull
    private String originUrl;
    private int originWidth;

    @NotNull
    private String smallUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/result/ImageResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.winkpublish.result.ImageResult$CREATOR, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<ImageResult> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ImageResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ImageResult[] newArray(int size) {
            return new ImageResult[size];
        }
    }

    public ImageResult() {
        this(null, null, null, 0, 0, 0, 0, null, 255, null);
    }

    public static /* synthetic */ ImageResult copy$default(ImageResult imageResult, String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, int i19, Object obj) {
        String str5;
        String str6;
        String str7;
        int i26;
        int i27;
        int i28;
        int i29;
        String str8;
        if ((i19 & 1) != 0) {
            str5 = imageResult.smallUrl;
        } else {
            str5 = str;
        }
        if ((i19 & 2) != 0) {
            str6 = imageResult.bigUrl;
        } else {
            str6 = str2;
        }
        if ((i19 & 4) != 0) {
            str7 = imageResult.originUrl;
        } else {
            str7 = str3;
        }
        if ((i19 & 8) != 0) {
            i26 = imageResult.bigWidth;
        } else {
            i26 = i3;
        }
        if ((i19 & 16) != 0) {
            i27 = imageResult.bigHeight;
        } else {
            i27 = i16;
        }
        if ((i19 & 32) != 0) {
            i28 = imageResult.originWidth;
        } else {
            i28 = i17;
        }
        if ((i19 & 64) != 0) {
            i29 = imageResult.originHeight;
        } else {
            i29 = i18;
        }
        if ((i19 & 128) != 0) {
            str8 = imageResult.md5;
        } else {
            str8 = str4;
        }
        return imageResult.copy(str5, str6, str7, i26, i27, i28, i29, str8);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSmallUrl() {
        return this.smallUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBigUrl() {
        return this.bigUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getOriginUrl() {
        return this.originUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBigWidth() {
        return this.bigWidth;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBigHeight() {
        return this.bigHeight;
    }

    /* renamed from: component6, reason: from getter */
    public final int getOriginWidth() {
        return this.originWidth;
    }

    /* renamed from: component7, reason: from getter */
    public final int getOriginHeight() {
        return this.originHeight;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final ImageResult copy(@NotNull String smallUrl, @NotNull String bigUrl, @NotNull String originUrl, int bigWidth, int bigHeight, int originWidth, int originHeight, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(smallUrl, "smallUrl");
        Intrinsics.checkNotNullParameter(bigUrl, "bigUrl");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new ImageResult(smallUrl, bigUrl, originUrl, bigWidth, bigHeight, originWidth, originHeight, md5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageResult)) {
            return false;
        }
        ImageResult imageResult = (ImageResult) other;
        if (Intrinsics.areEqual(this.smallUrl, imageResult.smallUrl) && Intrinsics.areEqual(this.bigUrl, imageResult.bigUrl) && Intrinsics.areEqual(this.originUrl, imageResult.originUrl) && this.bigWidth == imageResult.bigWidth && this.bigHeight == imageResult.bigHeight && this.originWidth == imageResult.originWidth && this.originHeight == imageResult.originHeight && Intrinsics.areEqual(this.md5, imageResult.md5)) {
            return true;
        }
        return false;
    }

    public final int getBigHeight() {
        return this.bigHeight;
    }

    @NotNull
    public final String getBigUrl() {
        return this.bigUrl;
    }

    public final int getBigWidth() {
        return this.bigWidth;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    public final int getOriginHeight() {
        return this.originHeight;
    }

    @NotNull
    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final int getOriginWidth() {
        return this.originWidth;
    }

    @NotNull
    public final String getSmallUrl() {
        return this.smallUrl;
    }

    public int hashCode() {
        return (((((((((((((this.smallUrl.hashCode() * 31) + this.bigUrl.hashCode()) * 31) + this.originUrl.hashCode()) * 31) + this.bigWidth) * 31) + this.bigHeight) * 31) + this.originWidth) * 31) + this.originHeight) * 31) + this.md5.hashCode();
    }

    public final void setBigHeight(int i3) {
        this.bigHeight = i3;
    }

    public final void setBigUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bigUrl = str;
    }

    public final void setBigWidth(int i3) {
        this.bigWidth = i3;
    }

    public final void setMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.md5 = str;
    }

    public final void setOriginHeight(int i3) {
        this.originHeight = i3;
    }

    public final void setOriginUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originUrl = str;
    }

    public final void setOriginWidth(int i3) {
        this.originWidth = i3;
    }

    public final void setSmallUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.smallUrl = str;
    }

    @NotNull
    public String toString() {
        return "ImageResult(smallUrl=" + this.smallUrl + ", bigUrl=" + this.bigUrl + ", originUrl=" + this.originUrl + ", bigWidth=" + this.bigWidth + ", bigHeight=" + this.bigHeight + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", md5=" + this.md5 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.smallUrl);
        parcel.writeString(this.bigUrl);
        parcel.writeString(this.originUrl);
        parcel.writeInt(this.bigWidth);
        parcel.writeInt(this.bigHeight);
        parcel.writeInt(this.originWidth);
        parcel.writeInt(this.originHeight);
        parcel.writeString(this.md5);
    }

    public /* synthetic */ ImageResult(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? "" : str2, (i19 & 4) != 0 ? "" : str3, (i19 & 8) != 0 ? -1 : i3, (i19 & 16) != 0 ? -1 : i16, (i19 & 32) != 0 ? -1 : i17, (i19 & 64) == 0 ? i18 : -1, (i19 & 128) == 0 ? str4 : "");
    }

    public ImageResult(@NotNull String smallUrl, @NotNull String bigUrl, @NotNull String originUrl, int i3, int i16, int i17, int i18, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(smallUrl, "smallUrl");
        Intrinsics.checkNotNullParameter(bigUrl, "bigUrl");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.smallUrl = smallUrl;
        this.bigUrl = bigUrl;
        this.originUrl = originUrl;
        this.bigWidth = i3;
        this.bigHeight = i16;
        this.originWidth = i17;
        this.originHeight = i18;
        this.md5 = md5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageResult(@NotNull Parcel parcel) {
        this(null, null, null, 0, 0, 0, 0, null, 255, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.smallUrl = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.bigUrl = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.originUrl = readString3 == null ? "" : readString3;
        this.bigWidth = parcel.readInt();
        this.bigHeight = parcel.readInt();
        this.originWidth = parcel.readInt();
        this.originHeight = parcel.readInt();
        String readString4 = parcel.readString();
        this.md5 = readString4 != null ? readString4 : "";
    }
}
