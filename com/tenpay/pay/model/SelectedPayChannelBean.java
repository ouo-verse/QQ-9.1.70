package com.tenpay.pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tenpay.pay.model.PayChannelBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006,"}, d2 = {"Lcom/tenpay/pay/model/SelectedPayChannelBean;", "Landroid/os/Parcelable;", "payType", "", "bindSerial", "", "bankType", "cardTail", "bankIndex", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBankIndex", "()I", "setBankIndex", "(I)V", "getBankType", "()Ljava/lang/String;", "setBankType", "(Ljava/lang/String;)V", "getBindSerial", "setBindSerial", "getCardTail", "setCardTail", "getPayType", "setPayType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "save", "", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class SelectedPayChannelBean implements Parcelable {
    private int bankIndex;

    @Nullable
    private String bankType;

    @Nullable
    private String bindSerial;

    @Nullable
    private String cardTail;
    private int payType;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<SelectedPayChannelBean> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/pay/model/SelectedPayChannelBean$Companion;", "", "()V", "fromAutoPay", "Lcom/tenpay/pay/model/SelectedPayChannelBean;", "payChannel", "Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "fromBank", "Lcom/tenpay/pay/model/PayChannelBean$Bank;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SelectedPayChannelBean fromAutoPay(@NotNull PayChannelBean.AutoPayCard payChannel) {
            int i3;
            Intrinsics.checkNotNullParameter(payChannel, "payChannel");
            String busiType = payChannel.getBusiType();
            Integer indexInJSON = payChannel.getIndexInJSON();
            if (indexInJSON != null) {
                i3 = indexInJSON.intValue();
            } else {
                i3 = 0;
            }
            return new SelectedPayChannelBean(5, null, busiType, null, i3);
        }

        @JvmStatic
        @NotNull
        public final SelectedPayChannelBean fromBank(@NotNull PayChannelBean.Bank payChannel) {
            int i3;
            Intrinsics.checkNotNullParameter(payChannel, "payChannel");
            String bindSerial = payChannel.getBindSerial();
            String bankType = payChannel.getBankType();
            String cardTail = payChannel.getCardTail();
            Integer indexInJSON = payChannel.getIndexInJSON();
            if (indexInJSON != null) {
                i3 = indexInJSON.intValue();
            } else {
                i3 = 0;
            }
            return new SelectedPayChannelBean(1, bindSerial, bankType, cardTail, i3);
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<SelectedPayChannelBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectedPayChannelBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectedPayChannelBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectedPayChannelBean[] newArray(int i3) {
            return new SelectedPayChannelBean[i3];
        }
    }

    public SelectedPayChannelBean() {
        this(0, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ SelectedPayChannelBean copy$default(SelectedPayChannelBean selectedPayChannelBean, int i3, String str, String str2, String str3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = selectedPayChannelBean.payType;
        }
        if ((i17 & 2) != 0) {
            str = selectedPayChannelBean.bindSerial;
        }
        String str4 = str;
        if ((i17 & 4) != 0) {
            str2 = selectedPayChannelBean.bankType;
        }
        String str5 = str2;
        if ((i17 & 8) != 0) {
            str3 = selectedPayChannelBean.cardTail;
        }
        String str6 = str3;
        if ((i17 & 16) != 0) {
            i16 = selectedPayChannelBean.bankIndex;
        }
        return selectedPayChannelBean.copy(i3, str4, str5, str6, i16);
    }

    @JvmStatic
    @NotNull
    public static final SelectedPayChannelBean fromAutoPay(@NotNull PayChannelBean.AutoPayCard autoPayCard) {
        return INSTANCE.fromAutoPay(autoPayCard);
    }

    @JvmStatic
    @NotNull
    public static final SelectedPayChannelBean fromBank(@NotNull PayChannelBean.Bank bank) {
        return INSTANCE.fromBank(bank);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPayType() {
        return this.payType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getBindSerial() {
        return this.bindSerial;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getBankType() {
        return this.bankType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCardTail() {
        return this.cardTail;
    }

    /* renamed from: component5, reason: from getter */
    public final int getBankIndex() {
        return this.bankIndex;
    }

    @NotNull
    public final SelectedPayChannelBean copy(int payType, @Nullable String bindSerial, @Nullable String bankType, @Nullable String cardTail, int bankIndex) {
        return new SelectedPayChannelBean(payType, bindSerial, bankType, cardTail, bankIndex);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectedPayChannelBean)) {
            return false;
        }
        SelectedPayChannelBean selectedPayChannelBean = (SelectedPayChannelBean) other;
        if (this.payType == selectedPayChannelBean.payType && Intrinsics.areEqual(this.bindSerial, selectedPayChannelBean.bindSerial) && Intrinsics.areEqual(this.bankType, selectedPayChannelBean.bankType) && Intrinsics.areEqual(this.cardTail, selectedPayChannelBean.cardTail) && this.bankIndex == selectedPayChannelBean.bankIndex) {
            return true;
        }
        return false;
    }

    public final int getBankIndex() {
        return this.bankIndex;
    }

    @Nullable
    public final String getBankType() {
        return this.bankType;
    }

    @Nullable
    public final String getBindSerial() {
        return this.bindSerial;
    }

    @Nullable
    public final String getCardTail() {
        return this.cardTail;
    }

    public final int getPayType() {
        return this.payType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i3 = this.payType * 31;
        String str = this.bindSerial;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.bankType;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        String str3 = this.cardTail;
        if (str3 != null) {
            i16 = str3.hashCode();
        }
        return ((i18 + i16) * 31) + this.bankIndex;
    }

    public final void save() {
        g.p("qwallet_last_pay_channel_" + a.c(), this);
    }

    public final void setBankIndex(int i3) {
        this.bankIndex = i3;
    }

    public final void setBankType(@Nullable String str) {
        this.bankType = str;
    }

    public final void setBindSerial(@Nullable String str) {
        this.bindSerial = str;
    }

    public final void setCardTail(@Nullable String str) {
        this.cardTail = str;
    }

    public final void setPayType(int i3) {
        this.payType = i3;
    }

    @NotNull
    public String toString() {
        return "SelectedPayChannelBean(payType=" + this.payType + ", bindSerial=" + this.bindSerial + ", bankType=" + this.bankType + ", cardTail=" + this.cardTail + ", bankIndex=" + this.bankIndex + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.payType);
        parcel.writeString(this.bindSerial);
        parcel.writeString(this.bankType);
        parcel.writeString(this.cardTail);
        parcel.writeInt(this.bankIndex);
    }

    public SelectedPayChannelBean(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, int i16) {
        this.payType = i3;
        this.bindSerial = str;
        this.bankType = str2;
        this.cardTail = str3;
        this.bankIndex = i16;
    }

    public /* synthetic */ SelectedPayChannelBean(int i3, String str, String str2, String str3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? null : str2, (i17 & 8) == 0 ? str3 : null, (i17 & 16) != 0 ? 0 : i16);
    }
}
