package com.tencent.mobileqq.qwallet.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/data/SendQrCodeHbResult;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "wishing", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "totalNum", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "receiveNumStr", "c", QrCodeHbFragment.KEY_IN_QR_TOKEN, "b", QrCodeHbFragment.KEY_IN_QR_DATA, "a", "sendListId", "e", "validSeconds", "getValidSeconds", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class SendQrCodeHbResult implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SendQrCodeHbResult> CREATOR = new a();

    @SerializedName("qr_data")
    @Nullable
    private final String qrData;

    @SerializedName("qr_token")
    @Nullable
    private final String qrToken;

    @SerializedName("recv_num")
    @Nullable
    private final String receiveNumStr;

    @SerializedName("send_listid")
    @Nullable
    private final String sendListId;

    @SerializedName("total_num")
    @Nullable
    private final Integer totalNum;

    @SerializedName("valid_seconds")
    @Nullable
    private final String validSeconds;

    @SerializedName("wishing")
    @Nullable
    private final String wishing;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a implements Parcelable.Creator<SendQrCodeHbResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SendQrCodeHbResult createFromParcel(@NotNull Parcel parcel) {
            Integer valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(parcel.readInt());
            }
            return new SendQrCodeHbResult(readString, valueOf, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SendQrCodeHbResult[] newArray(int i3) {
            return new SendQrCodeHbResult[i3];
        }
    }

    public SendQrCodeHbResult(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.wishing = str;
        this.totalNum = num;
        this.receiveNumStr = str2;
        this.qrToken = str3;
        this.qrData = str4;
        this.sendListId = str5;
        this.validSeconds = str6;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getQrData() {
        return this.qrData;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getQrToken() {
        return this.qrToken;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getReceiveNumStr() {
        return this.receiveNumStr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getSendListId() {
        return this.sendListId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendQrCodeHbResult)) {
            return false;
        }
        SendQrCodeHbResult sendQrCodeHbResult = (SendQrCodeHbResult) other;
        if (Intrinsics.areEqual(this.wishing, sendQrCodeHbResult.wishing) && Intrinsics.areEqual(this.totalNum, sendQrCodeHbResult.totalNum) && Intrinsics.areEqual(this.receiveNumStr, sendQrCodeHbResult.receiveNumStr) && Intrinsics.areEqual(this.qrToken, sendQrCodeHbResult.qrToken) && Intrinsics.areEqual(this.qrData, sendQrCodeHbResult.qrData) && Intrinsics.areEqual(this.sendListId, sendQrCodeHbResult.sendListId) && Intrinsics.areEqual(this.validSeconds, sendQrCodeHbResult.validSeconds)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Integer getTotalNum() {
        return this.totalNum;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getWishing() {
        return this.wishing;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.wishing;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.totalNum;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.receiveNumStr;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.qrToken;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str4 = this.qrData;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str5 = this.sendListId;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str6 = this.validSeconds;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return i27 + i3;
    }

    @NotNull
    public String toString() {
        return "SendQrCodeHbResult(wishing=" + this.wishing + ", totalNum=" + this.totalNum + ", receiveNumStr=" + this.receiveNumStr + ", qrToken=" + this.qrToken + ", qrData=" + this.qrData + ", sendListId=" + this.sendListId + ", validSeconds=" + this.validSeconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int intValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.wishing);
        Integer num = this.totalNum;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        parcel.writeString(this.receiveNumStr);
        parcel.writeString(this.qrToken);
        parcel.writeString(this.qrData);
        parcel.writeString(this.sendListId);
        parcel.writeString(this.validSeconds);
    }
}
