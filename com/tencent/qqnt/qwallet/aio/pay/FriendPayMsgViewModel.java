package com.tencent.qqnt.qwallet.aio.pay;

import android.content.Context;
import android.net.Uri;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.pay.PaymentConfig;
import com.tencent.qqnt.qwallet.db.PaymentStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.callback.CallbackThreadEnum;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.http.PayCgiService;
import com.tenpay.sdk.net.http.result.HttpResult;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel;", "Lcom/tencent/qqnt/qwallet/aio/pay/j;", "Lcom/tencent/qqnt/qwallet/db/i;", "stateEntity", "", "isFromServer", "", "o2", "", SemanticAttributes.DbSystemValues.H2, "m2", "Lorg/json/JSONObject;", "bizJSON", "l2", "Lcom/tencent/qqnt/qwallet/aio/pay/g;", "rawData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "g2", "onResume", "i2", "k2", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "stateUpdateListener", "G", "Z", "refreshState", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class FriendPayMsgViewModel extends j {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> stateUpdateListener = new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.pay.FriendPayMsgViewModel$stateUpdateListener$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String h26;
            String tag = FriendPayMsgViewModel.this.getTAG();
            h26 = FriendPayMsgViewModel.this.h2();
            QLog.d(tag, 4, "FriendPayMsgViewModel: stateUpdateListener " + h26);
            PaymentData Q1 = FriendPayMsgViewModel.this.Q1();
            Q1.g(Integer.valueOf(R.drawable.otm));
            Q1.f(true);
            FriendPayMsgViewModel.this.S1().postValue(Q1);
        }
    };

    /* renamed from: G, reason: from kotlin metadata */
    private boolean refreshState;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "buyerNickName", "Ljava/lang/String;", "getBuyerNickName", "()Ljava/lang/String;", "buyerUin", "a", "payerNickName", "getPayerNickName", "payerUin", "c", "tokenId", "getTokenId", "Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$a$a;", "order", "Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$a$a;", "b", "()Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$a$a;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.FriendPayMsgViewModel$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class PfaDetailRsp {

        @SerializedName("buyer_nickname")
        @Nullable
        private final String buyerNickName;

        @SerializedName("buyer_uin")
        @Nullable
        private final String buyerUin;

        @SerializedName("order")
        @Nullable
        private final Order order;

        @SerializedName("payer_nickname")
        @Nullable
        private final String payerNickName;

        @SerializedName("payer_uin")
        @Nullable
        private final String payerUin;

        @SerializedName("token_id")
        @Nullable
        private final String tokenId;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "totalFee", "Ljava/lang/String;", "getTotalFee", "()Ljava/lang/String;", "tradeState", "c", "desc", "getDesc", "spName", "getSpName", "bargainerTrueName", "getBargainerTrueName", "expireInterval", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "paySuccessUin", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.qwallet.aio.pay.FriendPayMsgViewModel$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes25.dex */
        public static final /* data */ class Order {

            @SerializedName("bargainor_true_name")
            @Nullable
            private final String bargainerTrueName;

            @SerializedName("desc")
            @Nullable
            private final String desc;

            @SerializedName("pfa_expire_interval")
            @Nullable
            private final Integer expireInterval;

            @SerializedName("pay_succ_uin")
            @Nullable
            private final String paySuccessUin;

            @SerializedName("sp_name")
            @Nullable
            private final String spName;

            @SerializedName("total_fee")
            @Nullable
            private final String totalFee;

            @SerializedName("trade_state")
            @Nullable
            private final String tradeState;

            @Nullable
            /* renamed from: a, reason: from getter */
            public final Integer getExpireInterval() {
                return this.expireInterval;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final String getPaySuccessUin() {
                return this.paySuccessUin;
            }

            @Nullable
            /* renamed from: c, reason: from getter */
            public final String getTradeState() {
                return this.tradeState;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Order)) {
                    return false;
                }
                Order order = (Order) other;
                if (Intrinsics.areEqual(this.totalFee, order.totalFee) && Intrinsics.areEqual(this.tradeState, order.tradeState) && Intrinsics.areEqual(this.desc, order.desc) && Intrinsics.areEqual(this.spName, order.spName) && Intrinsics.areEqual(this.bargainerTrueName, order.bargainerTrueName) && Intrinsics.areEqual(this.expireInterval, order.expireInterval) && Intrinsics.areEqual(this.paySuccessUin, order.paySuccessUin)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2;
                int hashCode3;
                int hashCode4;
                int hashCode5;
                int hashCode6;
                String str = this.totalFee;
                int i3 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i16 = hashCode * 31;
                String str2 = this.tradeState;
                if (str2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = str2.hashCode();
                }
                int i17 = (i16 + hashCode2) * 31;
                String str3 = this.desc;
                if (str3 == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = str3.hashCode();
                }
                int i18 = (i17 + hashCode3) * 31;
                String str4 = this.spName;
                if (str4 == null) {
                    hashCode4 = 0;
                } else {
                    hashCode4 = str4.hashCode();
                }
                int i19 = (i18 + hashCode4) * 31;
                String str5 = this.bargainerTrueName;
                if (str5 == null) {
                    hashCode5 = 0;
                } else {
                    hashCode5 = str5.hashCode();
                }
                int i26 = (i19 + hashCode5) * 31;
                Integer num = this.expireInterval;
                if (num == null) {
                    hashCode6 = 0;
                } else {
                    hashCode6 = num.hashCode();
                }
                int i27 = (i26 + hashCode6) * 31;
                String str6 = this.paySuccessUin;
                if (str6 != null) {
                    i3 = str6.hashCode();
                }
                return i27 + i3;
            }

            @NotNull
            public String toString() {
                return "Order(totalFee=" + this.totalFee + ", tradeState=" + this.tradeState + ", desc=" + this.desc + ", spName=" + this.spName + ", bargainerTrueName=" + this.bargainerTrueName + ", expireInterval=" + this.expireInterval + ", paySuccessUin=" + this.paySuccessUin + ")";
            }
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getBuyerUin() {
            return this.buyerUin;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Order getOrder() {
            return this.order;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getPayerUin() {
            return this.payerUin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PfaDetailRsp)) {
                return false;
            }
            PfaDetailRsp pfaDetailRsp = (PfaDetailRsp) other;
            if (Intrinsics.areEqual(this.buyerNickName, pfaDetailRsp.buyerNickName) && Intrinsics.areEqual(this.buyerUin, pfaDetailRsp.buyerUin) && Intrinsics.areEqual(this.payerNickName, pfaDetailRsp.payerNickName) && Intrinsics.areEqual(this.payerUin, pfaDetailRsp.payerUin) && Intrinsics.areEqual(this.tokenId, pfaDetailRsp.tokenId) && Intrinsics.areEqual(this.order, pfaDetailRsp.order)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            String str = this.buyerNickName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.buyerUin;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.payerNickName;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.payerUin;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.tokenId;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Order order = this.order;
            if (order != null) {
                i3 = order.hashCode();
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            return "PfaDetailRsp(buyerNickName=" + this.buyerNickName + ", buyerUin=" + this.buyerUin + ", payerNickName=" + this.payerNickName + ", payerUin=" + this.payerUin + ", tokenId=" + this.tokenId + ", order=" + this.order + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qwallet/aio/pay/FriendPayMsgViewModel$b", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "", "url", "result", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements NetCallback<HttpResult> {
        b() {
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNetFailed(@NotNull String url, @NotNull HttpResult result) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.w(FriendPayMsgViewModel.this.getTAG(), 1, "refreshPfa fail: " + result.getBizResponse());
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNetSucceed(@NotNull String url, @NotNull HttpResult result) {
            JSONObject jSONObject;
            Integer num;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                Object bizResponse = result.getBizResponse();
                String str = null;
                if (bizResponse instanceof JSONObject) {
                    jSONObject = (JSONObject) bizResponse;
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    num = Integer.valueOf(jSONObject.optInt("retcode"));
                } else {
                    num = null;
                }
                if (jSONObject != null) {
                    str = jSONObject.optString("retmsg");
                }
                if (num != null && num.intValue() == 0) {
                    FriendPayMsgViewModel.this.l2(jSONObject);
                    return;
                }
                QLog.w(FriendPayMsgViewModel.this.getTAG(), 1, "refreshPfa fail: " + num + " " + str);
            } catch (Exception e16) {
                QLog.w(FriendPayMsgViewModel.this.getTAG(), 1, "parse pfa fail", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h2() {
        boolean z16;
        String billNo = M1().getBillNo();
        if (billNo.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            billNo = Uri.parse(M1().getReceiver().nativeAndroid).getQueryParameter("tokenid");
            if (billNo == null) {
                billNo = "";
            }
            Intrinsics.checkNotNullExpressionValue(billNo, "Uri.parse(aioModel.recei\u2026arameter(\"tokenid\") ?: \"\"");
        }
        return billNo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(FriendPayMsgViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o2(QWalletDBManager.f361825a.z(this$0.h2(), this$0.M1().d(), EnumPaymentType.FriendPay), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(JSONObject bizJSON) {
        String str;
        int ordinal;
        int i3;
        PfaDetailRsp pfaDetailRsp = (PfaDetailRsp) new GsonBuilder().create().fromJson(bizJSON.toString(), PfaDetailRsp.class);
        QLog.i(getTAG(), 2, "refreshPfa success: " + pfaDetailRsp);
        String h26 = h2();
        String d16 = M1().d();
        int ordinal2 = EnumPaymentType.FriendPay.ordinal();
        String payerUin = pfaDetailRsp.getPayerUin();
        if (payerUin == null) {
            payerUin = "";
        }
        String str2 = payerUin;
        PfaDetailRsp.Order order = pfaDetailRsp.getOrder();
        String str3 = null;
        if (order != null) {
            str = order.getTradeState();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "SUCCESS")) {
            if (Intrinsics.areEqual(pfaDetailRsp.getOrder().getPaySuccessUin(), pfaDetailRsp.getBuyerUin())) {
                if (U1()) {
                    ordinal = EnumFriendPayState.PayedByMyself.ordinal();
                } else {
                    ordinal = EnumFriendPayState.PayedByOwner.ordinal();
                }
            } else if (U1()) {
                ordinal = EnumFriendPayState.Payed.ordinal();
            } else if (Intrinsics.areEqual(pfaDetailRsp.getOrder().getPaySuccessUin(), com.tencent.mobileqq.base.a.c())) {
                ordinal = EnumFriendPayState.Payed.ordinal();
            } else {
                ordinal = EnumFriendPayState.PayedByOthers.ordinal();
            }
        } else {
            PfaDetailRsp.Order order2 = pfaDetailRsp.getOrder();
            if (order2 != null) {
                str3 = order2.getTradeState();
            }
            if (Intrinsics.areEqual(str3, "PAYING")) {
                Integer expireInterval = pfaDetailRsp.getOrder().getExpireInterval();
                if (expireInterval != null) {
                    i3 = expireInterval.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 <= 0) {
                    ordinal = EnumFriendPayState.Timeout.ordinal();
                }
            }
            ordinal = EnumFriendPayState.Init.ordinal();
        }
        PaymentStateEntity paymentStateEntity = new PaymentStateEntity(null, h26, d16, ordinal2, str2, ordinal, 1, null);
        QWalletDBManager.f361825a.i(paymentStateEntity);
        o2(paymentStateEntity, true);
    }

    private final void m2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pfa_req", M1().getReceiver().nativeAndroid);
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        String URL_FRIENDPAY_ORDER_QUERY = Cgi.URL_FRIENDPAY_ORDER_QUERY;
        Intrinsics.checkNotNullExpressionValue(URL_FRIENDPAY_ORDER_QUERY, "URL_FRIENDPAY_ORDER_QUERY");
        PayCgiService.sendRequest((Context) null, URL_FRIENDPAY_ORDER_QUERY, linkedHashMap, CallbackThreadEnum.MAIN, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(FriendPayMsgViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o2(QWalletDBManager.f361825a.z(this$0.h2(), this$0.M1().d(), EnumPaymentType.FriendPay), false);
    }

    private final void o2(PaymentStateEntity stateEntity, boolean isFromServer) {
        Integer num;
        long j3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Long expiredSeconds;
        PaymentData Q1 = Q1();
        PaymentConfig.Companion companion = PaymentConfig.INSTANCE;
        PaymentConfig.PaymentTypeItem friendPay = companion.a().getFriendPay();
        Integer num2 = null;
        if (stateEntity != null) {
            num = Integer.valueOf(stateEntity.getState());
        } else {
            num = null;
        }
        String b16 = f.b(friendPay, num, null, 2, null);
        long msgTime = M1().getMsgTime();
        PaymentConfig.PaymentTypeItem friendPay2 = companion.a().getFriendPay();
        if (friendPay2 != null && (expiredSeconds = friendPay2.getExpiredSeconds()) != null) {
            j3 = expiredSeconds.longValue();
        } else {
            j3 = 0;
        }
        long j16 = msgTime + j3;
        boolean z26 = false;
        if (stateEntity != null && stateEntity.getState() == EnumFriendPayState.Payed.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Q1.g(Integer.valueOf(R.drawable.otm));
            Q1.f(true);
        } else {
            if (stateEntity != null && stateEntity.getState() == EnumFriendPayState.Timeout.ordinal()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                Q1.h(b16);
                Q1.f(true);
            } else {
                if (stateEntity != null && stateEntity.getState() == EnumFriendPayState.PayedByMyself.ordinal()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    Q1.h(b16);
                    Q1.f(true);
                } else {
                    if (stateEntity != null && stateEntity.getState() == EnumFriendPayState.PayedByOwner.ordinal()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        Q1.h(b16);
                        Q1.f(true);
                    } else {
                        if (stateEntity != null && stateEntity.getState() == EnumFriendPayState.PayedByOthers.ordinal()) {
                            z26 = true;
                        }
                        if (z26) {
                            Q1.h(b16);
                            Q1.f(true);
                        } else if (!isFromServer && ((stateEntity == null || stateEntity.getState() == EnumFriendPayState.Init.ordinal()) && j16 < NetConnInfoCenter.getServerTime())) {
                            QLog.d(getTAG(), 2, "is expired, but no need refresh");
                        } else {
                            String tag = getTAG();
                            if (stateEntity != null) {
                                num2 = Integer.valueOf(stateEntity.getState());
                            }
                            QLog.d(tag, 2, "nothing update: isFromServer=" + isFromServer + " state=" + num2 + " expire=" + M1().f());
                        }
                    }
                }
            }
        }
        S1().postValue(Q1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    public void a2(@NotNull PaymentData rawData) {
        String c16;
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        int msgType = M1().getMsgType();
        if (msgType != 9) {
            if (msgType != 10) {
                QLog.e(getTAG(), 1, "updatePaymentData: error cannot do this");
                super.a2(rawData);
                return;
            }
            h hVar = h.f361811a;
            hVar.c(h2());
            rawData.f(true);
            rawData.g(Integer.valueOf(R.drawable.otm));
            S1().postValue(rawData);
            if (!Intrinsics.areEqual(M1().d(), M1().getPeerUinStr())) {
                c16 = M1().getPeerUinStr();
            } else {
                c16 = com.tencent.mobileqq.base.a.c();
            }
            QWalletDBManager.f361825a.i(new PaymentStateEntity(null, h2(), c16, EnumPaymentType.FriendPay.ordinal(), M1().getPeerUinStr(), EnumFriendPayState.Payed.ordinal(), 1, null));
            hVar.c(h2());
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.d
            @Override // java.lang.Runnable
            public final void run() {
                FriendPayMsgViewModel.n2(FriendPayMsgViewModel.this);
            }
        }, 32, null, true);
    }

    public final void g2() {
        if (M1().getMsgType() != 10) {
            this.refreshState = true;
        }
    }

    public final void i2() {
        if (M1().getMsgType() != 10) {
            h.f361811a.a(h2(), this.stateUpdateListener);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.c
                @Override // java.lang.Runnable
                public final void run() {
                    FriendPayMsgViewModel.j2(FriendPayMsgViewModel.this);
                }
            }, 32, null, true);
        }
    }

    public final void k2() {
        if (M1().getMsgType() != 10) {
            h.f361811a.b(h2());
        }
    }

    public final void onResume() {
        QLog.d(getTAG(), 1, "onResume: " + hashCode() + " isCoverClicked " + this.refreshState);
        if (this.refreshState) {
            m2();
            this.refreshState = false;
        }
    }
}
