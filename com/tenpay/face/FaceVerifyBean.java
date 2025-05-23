package com.tenpay.face;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020\tH\u00d6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u00d6\u0003J\t\u0010'\u001a\u00020\tH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tH\u00d6\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f\u00a8\u0006."}, d2 = {"Lcom/tenpay/face/FaceVerifyBean;", "Landroid/os/Parcelable;", "tokenId", "", "channelInfo", WadlProxyConsts.CHANNEL, "name", "creId", "creType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "getChannelInfo", "getCreId", "setCreId", "getCreType", "()Ljava/lang/Integer;", "setCreType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getTokenId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tenpay/face/FaceVerifyBean;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class FaceVerifyBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FaceVerifyBean> CREATOR = new Creator();

    @Nullable
    private String channel;

    @Nullable
    private final String channelInfo;

    @Nullable
    private String creId;

    @Nullable
    private Integer creType;

    @Nullable
    private String name;

    @Nullable
    private final String tokenId;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<FaceVerifyBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FaceVerifyBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FaceVerifyBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FaceVerifyBean[] newArray(int i3) {
            return new FaceVerifyBean[i3];
        }
    }

    public FaceVerifyBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FaceVerifyBean copy$default(FaceVerifyBean faceVerifyBean, String str, String str2, String str3, String str4, String str5, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = faceVerifyBean.tokenId;
        }
        if ((i3 & 2) != 0) {
            str2 = faceVerifyBean.channelInfo;
        }
        String str6 = str2;
        if ((i3 & 4) != 0) {
            str3 = faceVerifyBean.channel;
        }
        String str7 = str3;
        if ((i3 & 8) != 0) {
            str4 = faceVerifyBean.name;
        }
        String str8 = str4;
        if ((i3 & 16) != 0) {
            str5 = faceVerifyBean.creId;
        }
        String str9 = str5;
        if ((i3 & 32) != 0) {
            num = faceVerifyBean.creType;
        }
        return faceVerifyBean.copy(str, str6, str7, str8, str9, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTokenId() {
        return this.tokenId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getChannelInfo() {
        return this.channelInfo;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCreId() {
        return this.creId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getCreType() {
        return this.creType;
    }

    @NotNull
    public final FaceVerifyBean copy(@Nullable String tokenId, @Nullable String channelInfo, @Nullable String channel, @Nullable String name, @Nullable String creId, @Nullable Integer creType) {
        return new FaceVerifyBean(tokenId, channelInfo, channel, name, creId, creType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceVerifyBean)) {
            return false;
        }
        FaceVerifyBean faceVerifyBean = (FaceVerifyBean) other;
        if (Intrinsics.areEqual(this.tokenId, faceVerifyBean.tokenId) && Intrinsics.areEqual(this.channelInfo, faceVerifyBean.channelInfo) && Intrinsics.areEqual(this.channel, faceVerifyBean.channel) && Intrinsics.areEqual(this.name, faceVerifyBean.name) && Intrinsics.areEqual(this.creId, faceVerifyBean.creId) && Intrinsics.areEqual(this.creType, faceVerifyBean.creType)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
    }

    @Nullable
    public final String getChannelInfo() {
        return this.channelInfo;
    }

    @Nullable
    public final String getCreId() {
        return this.creId;
    }

    @Nullable
    public final Integer getCreType() {
        return this.creType;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTokenId() {
        return this.tokenId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.tokenId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.channelInfo;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.channel;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.name;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.creId;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Integer num = this.creType;
        if (num != null) {
            i3 = num.hashCode();
        }
        return i26 + i3;
    }

    public final void setChannel(@Nullable String str) {
        this.channel = str;
    }

    public final void setCreId(@Nullable String str) {
        this.creId = str;
    }

    public final void setCreType(@Nullable Integer num) {
        this.creType = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @NotNull
    public String toString() {
        return "FaceVerifyBean(tokenId=" + this.tokenId + ", channelInfo=" + this.channelInfo + ", channel=" + this.channel + ", name=" + this.name + ", creId=" + this.creId + ", creType=" + this.creType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int intValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.tokenId);
        parcel.writeString(this.channelInfo);
        parcel.writeString(this.channel);
        parcel.writeString(this.name);
        parcel.writeString(this.creId);
        Integer num = this.creType;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
    }

    public FaceVerifyBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num) {
        this.tokenId = str;
        this.channelInfo = str2;
        this.channel = str3;
        this.name = str4;
        this.creId = str5;
        this.creType = num;
    }

    public /* synthetic */ FaceVerifyBean(String str, String str2, String str3, String str4, String str5, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) == 0 ? str5 : null, (i3 & 32) != 0 ? 1 : num);
    }
}
