package com.tenpay.payment.qrcodehb;

import com.tencent.mobileqq.qwallet.data.SendQrCodeHbResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "", "wishing", "", "totalNum", "", "receiveNum", QrCodeHbFragment.KEY_IN_QR_DATA, "sendListId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getQrData", "()Ljava/lang/String;", "getReceiveNum", "()Ljava/lang/Integer;", "setReceiveNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSendListId", "getTotalNum", "getWishing", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "equals", "", "other", "hashCode", "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class QrCodeHbInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String qrData;

    @Nullable
    private Integer receiveNum;

    @Nullable
    private final String sendListId;

    @Nullable
    private final Integer totalNum;

    @Nullable
    private final String wishing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo$Companion;", "", "()V", "fromSendHbResult", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "result", "Lcom/tencent/mobileqq/qwallet/data/SendQrCodeHbResult;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QrCodeHbInfo fromSendHbResult(@NotNull SendQrCodeHbResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String receiveNumStr = result.getReceiveNumStr();
            int i3 = 0;
            if (receiveNumStr != null) {
                try {
                    i3 = Integer.parseInt(receiveNumStr);
                } catch (NumberFormatException unused) {
                }
            }
            return new QrCodeHbInfo(result.getWishing(), result.getTotalNum(), Integer.valueOf(i3), result.getQrData(), result.getSendListId());
        }

        Companion() {
        }
    }

    public QrCodeHbInfo(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable String str3) {
        this.wishing = str;
        this.totalNum = num;
        this.receiveNum = num2;
        this.qrData = str2;
        this.sendListId = str3;
    }

    public static /* synthetic */ QrCodeHbInfo copy$default(QrCodeHbInfo qrCodeHbInfo, String str, Integer num, Integer num2, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qrCodeHbInfo.wishing;
        }
        if ((i3 & 2) != 0) {
            num = qrCodeHbInfo.totalNum;
        }
        Integer num3 = num;
        if ((i3 & 4) != 0) {
            num2 = qrCodeHbInfo.receiveNum;
        }
        Integer num4 = num2;
        if ((i3 & 8) != 0) {
            str2 = qrCodeHbInfo.qrData;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            str3 = qrCodeHbInfo.sendListId;
        }
        return qrCodeHbInfo.copy(str, num3, num4, str4, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getWishing() {
        return this.wishing;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getTotalNum() {
        return this.totalNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getReceiveNum() {
        return this.receiveNum;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getQrData() {
        return this.qrData;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getSendListId() {
        return this.sendListId;
    }

    @NotNull
    public final QrCodeHbInfo copy(@Nullable String wishing, @Nullable Integer totalNum, @Nullable Integer receiveNum, @Nullable String qrData, @Nullable String sendListId) {
        return new QrCodeHbInfo(wishing, totalNum, receiveNum, qrData, sendListId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrCodeHbInfo)) {
            return false;
        }
        QrCodeHbInfo qrCodeHbInfo = (QrCodeHbInfo) other;
        if (Intrinsics.areEqual(this.wishing, qrCodeHbInfo.wishing) && Intrinsics.areEqual(this.totalNum, qrCodeHbInfo.totalNum) && Intrinsics.areEqual(this.receiveNum, qrCodeHbInfo.receiveNum) && Intrinsics.areEqual(this.qrData, qrCodeHbInfo.qrData) && Intrinsics.areEqual(this.sendListId, qrCodeHbInfo.sendListId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getQrData() {
        return this.qrData;
    }

    @Nullable
    public final Integer getReceiveNum() {
        return this.receiveNum;
    }

    @Nullable
    public final String getSendListId() {
        return this.sendListId;
    }

    @Nullable
    public final Integer getTotalNum() {
        return this.totalNum;
    }

    @Nullable
    public final String getWishing() {
        return this.wishing;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
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
        Integer num2 = this.receiveNum;
        if (num2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str2 = this.qrData;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str3 = this.sendListId;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i19 + i3;
    }

    public final void setReceiveNum(@Nullable Integer num) {
        this.receiveNum = num;
    }

    @NotNull
    public String toString() {
        return "QrCodeHbInfo(wishing=" + this.wishing + ", totalNum=" + this.totalNum + ", receiveNum=" + this.receiveNum + ", qrData=" + this.qrData + ", sendListId=" + this.sendListId + ")";
    }
}
