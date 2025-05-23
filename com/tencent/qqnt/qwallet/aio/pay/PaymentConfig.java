package com.tencent.qqnt.qwallet.aio.pay;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/qwallet/aio/pay/e$b;", TransactionActivity.PREF_NAME_TRANSFER, "Lcom/tencent/qqnt/qwallet/aio/pay/e$b;", "g", "()Lcom/tencent/qqnt/qwallet/aio/pay/e$b;", "friendPay", "f", "aaPayOwner", "d", "aaPayPayer", "e", "<init>", "(Lcom/tencent/qqnt/qwallet/aio/pay/e$b;Lcom/tencent/qqnt/qwallet/aio/pay/e$b;Lcom/tencent/qqnt/qwallet/aio/pay/e$b;Lcom/tencent/qqnt/qwallet/aio/pay/e$b;)V", "a", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.qwallet.aio.pay.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class PaymentConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final PaymentConfig f361804b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static volatile PaymentConfig f361805c;

    @SerializedName("aa_pay_owner")
    @Nullable
    private final PaymentTypeItem aaPayOwner;

    @SerializedName("aa_pay_payer")
    @Nullable
    private final PaymentTypeItem aaPayPayer;

    @SerializedName("friend_pay")
    @Nullable
    private final PaymentTypeItem friendPay;

    @SerializedName(TransactionActivity.PREF_NAME_TRANSFER)
    @Nullable
    private final PaymentTypeItem transfer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/e$a;", "", "Lcom/tencent/qqnt/qwallet/aio/pay/e;", "a", "DEFAULT", "Lcom/tencent/qqnt/qwallet/aio/pay/e;", "b", "()Lcom/tencent/qqnt/qwallet/aio/pay/e;", "cache", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.e$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PaymentConfig a() {
            if (!Intrinsics.areEqual(PaymentConfig.f361805c, b())) {
                return PaymentConfig.f361805c;
            }
            PaymentConfig.f361805c = (PaymentConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_MSG_COMMON_CONFIG, b());
            if (!Intrinsics.areEqual(PaymentConfig.f361805c, b())) {
                QLog.i("WalletNT-PaymentConfig", 1, "has server config: " + PaymentConfig.f361805c);
            }
            return PaymentConfig.f361805c;
        }

        @NotNull
        public final PaymentConfig b() {
            return PaymentConfig.f361804b;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/e$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/qqnt/qwallet/aio/pay/e$c;", "stateDescList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "expiredSeconds", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "<init>", "(Ljava/util/List;Ljava/lang/Long;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.e$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class PaymentTypeItem {

        @SerializedName("expired_sec")
        @Nullable
        private final Long expiredSeconds;

        @SerializedName("state_desc_list")
        @Nullable
        private final List<StateDesc> stateDescList;

        public PaymentTypeItem(@Nullable List<StateDesc> list, @Nullable Long l3) {
            this.stateDescList = list;
            this.expiredSeconds = l3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Long getExpiredSeconds() {
            return this.expiredSeconds;
        }

        @Nullable
        public final List<StateDesc> b() {
            return this.stateDescList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaymentTypeItem)) {
                return false;
            }
            PaymentTypeItem paymentTypeItem = (PaymentTypeItem) other;
            if (Intrinsics.areEqual(this.stateDescList, paymentTypeItem.stateDescList) && Intrinsics.areEqual(this.expiredSeconds, paymentTypeItem.expiredSeconds)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            List<StateDesc> list = this.stateDescList;
            int i3 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int i16 = hashCode * 31;
            Long l3 = this.expiredSeconds;
            if (l3 != null) {
                i3 = l3.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "PaymentTypeItem(stateDescList=" + this.stateDescList + ", expiredSeconds=" + this.expiredSeconds + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/e$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "state", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "desc", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.e$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class StateDesc {

        @SerializedName("desc")
        @Nullable
        private final String desc;

        @SerializedName("state")
        @Nullable
        private final Integer state;

        public StateDesc(@Nullable Integer num, @Nullable String str) {
            this.state = num;
            this.desc = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getState() {
            return this.state;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateDesc)) {
                return false;
            }
            StateDesc stateDesc = (StateDesc) other;
            if (Intrinsics.areEqual(this.state, stateDesc.state) && Intrinsics.areEqual(this.desc, stateDesc.desc)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Integer num = this.state;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.desc;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "StateDesc(state=" + this.state + ", desc=" + this.desc + ")";
        }
    }

    static {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new StateDesc[]{new StateDesc(Integer.valueOf(EnumTransferState.Received.ordinal()), "\u5df2\u88ab\u63a5\u6536"), new StateDesc(Integer.valueOf(EnumTransferState.Timeout.ordinal()), "\u5df2\u8fc7\u671f")});
        PaymentTypeItem paymentTypeItem = new PaymentTypeItem(listOf, 86400L);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new StateDesc[]{new StateDesc(Integer.valueOf(EnumFriendPayState.Timeout.ordinal()), "\u5df2\u8d85\u65f6\u4e0d\u53ef\u652f\u4ed8"), new StateDesc(Integer.valueOf(EnumFriendPayState.PayedByMyself.ordinal()), "\u5df2\u81ea\u884c\u652f\u4ed8"), new StateDesc(Integer.valueOf(EnumFriendPayState.PayedByOwner.ordinal()), "\u5df2\u88ab\u597d\u53cb\u81ea\u884c\u652f\u4ed8"), new StateDesc(Integer.valueOf(EnumFriendPayState.PayedByOthers.ordinal()), "\u5df2\u88ab\u652f\u4ed8")});
        PaymentTypeItem paymentTypeItem2 = new PaymentTypeItem(listOf2, 840L);
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new StateDesc[]{new StateDesc(Integer.valueOf(EnumAAPayOwnerState.None.ordinal()), "\u4f60\u53d1\u8d77\u4e86\u4e00\u7b14\u7fa4\u6536\u6b3e"), new StateDesc(Integer.valueOf(EnumAAPayOwnerState.Close.ordinal()), "\u5df2\u505c\u6b62\u6536\u6b3e"), new StateDesc(Integer.valueOf(EnumAAPayOwnerState.Complete.ordinal()), "\u5df2\u6536\u9f50")});
        Long valueOf = Long.valueOf(JoinTimeType.SEVEN_DAY);
        PaymentTypeItem paymentTypeItem3 = new PaymentTypeItem(listOf3, valueOf);
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new StateDesc[]{new StateDesc(Integer.valueOf(EnumAAPayPayerState.None.ordinal()), "\u4f60\u9700\u652f\u4ed8%.2f\u5143"), new StateDesc(Integer.valueOf(EnumAAPayPayerState.NoNeedPay.ordinal()), "\u4f60\u65e0\u9700\u652f\u4ed8"), new StateDesc(Integer.valueOf(EnumAAPayPayerState.Payed.ordinal()), "\u4f60\u652f\u4ed8\u4e86%.2f\u5143")});
        PaymentConfig paymentConfig = new PaymentConfig(paymentTypeItem, paymentTypeItem2, paymentTypeItem3, new PaymentTypeItem(listOf4, valueOf));
        f361804b = paymentConfig;
        f361805c = paymentConfig;
    }

    public PaymentConfig(@Nullable PaymentTypeItem paymentTypeItem, @Nullable PaymentTypeItem paymentTypeItem2, @Nullable PaymentTypeItem paymentTypeItem3, @Nullable PaymentTypeItem paymentTypeItem4) {
        this.transfer = paymentTypeItem;
        this.friendPay = paymentTypeItem2;
        this.aaPayOwner = paymentTypeItem3;
        this.aaPayPayer = paymentTypeItem4;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final PaymentTypeItem getAaPayOwner() {
        return this.aaPayOwner;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final PaymentTypeItem getAaPayPayer() {
        return this.aaPayPayer;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentConfig)) {
            return false;
        }
        PaymentConfig paymentConfig = (PaymentConfig) other;
        if (Intrinsics.areEqual(this.transfer, paymentConfig.transfer) && Intrinsics.areEqual(this.friendPay, paymentConfig.friendPay) && Intrinsics.areEqual(this.aaPayOwner, paymentConfig.aaPayOwner) && Intrinsics.areEqual(this.aaPayPayer, paymentConfig.aaPayPayer)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final PaymentTypeItem getFriendPay() {
        return this.friendPay;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final PaymentTypeItem getTransfer() {
        return this.transfer;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        PaymentTypeItem paymentTypeItem = this.transfer;
        int i3 = 0;
        if (paymentTypeItem == null) {
            hashCode = 0;
        } else {
            hashCode = paymentTypeItem.hashCode();
        }
        int i16 = hashCode * 31;
        PaymentTypeItem paymentTypeItem2 = this.friendPay;
        if (paymentTypeItem2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = paymentTypeItem2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        PaymentTypeItem paymentTypeItem3 = this.aaPayOwner;
        if (paymentTypeItem3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = paymentTypeItem3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        PaymentTypeItem paymentTypeItem4 = this.aaPayPayer;
        if (paymentTypeItem4 != null) {
            i3 = paymentTypeItem4.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "PaymentConfig(transfer=" + this.transfer + ", friendPay=" + this.friendPay + ", aaPayOwner=" + this.aaPayOwner + ", aaPayPayer=" + this.aaPayPayer + ")";
    }
}
