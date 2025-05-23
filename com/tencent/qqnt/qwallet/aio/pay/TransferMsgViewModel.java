package com.tencent.qqnt.qwallet.aio.pay;

import android.net.Uri;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.IReportApi;
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
import com.tenpay.sdk.net.http.request.CgiBizData;
import com.tenpay.sdk.net.http.result.HttpResult;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0006H\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/TransferMsgViewModel;", "Lcom/tencent/qqnt/qwallet/aio/pay/j;", "Lcom/tencent/qqnt/qwallet/db/i;", "stateEntity", "", "isFromServer", "", "q2", "", "i2", ICustomDataEditor.NUMBER_PARAM_2, "Lorg/json/JSONObject;", "bizJSON", "m2", "Lcom/tencent/qqnt/qwallet/aio/pay/g;", "rawData", ICustomDataEditor.STRING_ARRAY_PARAM_2, SemanticAttributes.DbSystemValues.H2, "onResume", "j2", "l2", "Z1", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "stateUpdateListener", "G", "Z", "refreshState", "<init>", "()V", "H", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TransferMsgViewModel extends j {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> stateUpdateListener = new Function0<Unit>() { // from class: com.tencent.qqnt.qwallet.aio.pay.TransferMsgViewModel$stateUpdateListener$1
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
            String i26;
            String tag = TransferMsgViewModel.this.getTAG();
            i26 = TransferMsgViewModel.this.i2();
            QLog.d(tag, 4, "TransferMsgViewModel: stateUpdateListener " + i26);
            PaymentData Q1 = TransferMsgViewModel.this.Q1();
            Q1.g(Integer.valueOf(R.drawable.otm));
            Q1.h(f.b(PaymentConfig.INSTANCE.a().getTransfer(), Integer.valueOf(EnumTransferState.Received.ordinal()), null, 2, null));
            Q1.f(true);
            TransferMsgViewModel.this.S1().postValue(Q1);
        }
    };

    /* renamed from: G, reason: from kotlin metadata */
    private boolean refreshState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/TransferMsgViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "sellerName", "Ljava/lang/String;", "getSellerName", "()Ljava/lang/String;", "sellerUin", "getSellerUin", "payerNickName", "getPayerNickName", "payerUin", "b", "listId", "a", "state", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.TransferMsgViewModel$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class TransferDetailRsp {

        @SerializedName("listid")
        @Nullable
        private final String listId;

        @SerializedName("payer_name")
        @Nullable
        private final String payerNickName;

        @SerializedName("payer_uin")
        @Nullable
        private final String payerUin;

        @SerializedName("seller_name")
        @Nullable
        private final String sellerName;

        @SerializedName("seller_uin")
        @Nullable
        private final String sellerUin;

        @SerializedName("state")
        @Nullable
        private final Integer state;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getListId() {
            return this.listId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPayerUin() {
            return this.payerUin;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Integer getState() {
            return this.state;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransferDetailRsp)) {
                return false;
            }
            TransferDetailRsp transferDetailRsp = (TransferDetailRsp) other;
            if (Intrinsics.areEqual(this.sellerName, transferDetailRsp.sellerName) && Intrinsics.areEqual(this.sellerUin, transferDetailRsp.sellerUin) && Intrinsics.areEqual(this.payerNickName, transferDetailRsp.payerNickName) && Intrinsics.areEqual(this.payerUin, transferDetailRsp.payerUin) && Intrinsics.areEqual(this.listId, transferDetailRsp.listId) && Intrinsics.areEqual(this.state, transferDetailRsp.state)) {
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
            String str = this.sellerName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.sellerUin;
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
            String str5 = this.listId;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Integer num = this.state;
            if (num != null) {
                i3 = num.hashCode();
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            return "TransferDetailRsp(sellerName=" + this.sellerName + ", sellerUin=" + this.sellerUin + ", payerNickName=" + this.payerNickName + ", payerUin=" + this.payerUin + ", listId=" + this.listId + ", state=" + this.state + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qwallet/aio/pay/TransferMsgViewModel$c", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "", "url", "result", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements NetCallback<HttpResult> {
        c() {
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNetFailed(@NotNull String url, @NotNull HttpResult result) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.w(TransferMsgViewModel.this.getTAG(), 1, "requestTransferDetail fail: " + result.getBizResponse());
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
                    TransferMsgViewModel.this.m2(jSONObject);
                    return;
                }
                QLog.w(TransferMsgViewModel.this.getTAG(), 1, "requestTransferDetail fail: " + num + " " + str);
            } catch (Exception e16) {
                QLog.w(TransferMsgViewModel.this.getTAG(), 1, "parse transfer detail fail", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i2() {
        boolean z16;
        String billNo = M1().getBillNo();
        if (billNo.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            billNo = Uri.parse(M1().getReceiver().linkUrl).getQueryParameter(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID);
            if (billNo == null) {
                billNo = "";
            }
            Intrinsics.checkNotNullExpressionValue(billNo, "Uri.parse(aioModel.recei\u2026arameter(\"transId\") ?: \"\"");
        }
        return billNo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(TransferMsgViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q2(QWalletDBManager.f361825a.z(this$0.i2(), this$0.M1().d(), EnumPaymentType.Transfer), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2(JSONObject bizJSON) {
        int i3;
        JSONObject jSONObject;
        boolean contains;
        int ordinal;
        JSONArray optJSONArray = bizJSON.optJSONArray("records");
        if (optJSONArray != null) {
            i3 = optJSONArray.length();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            QLog.w(getTAG(), 1, "requestTransferDetail fail, record length: 0");
            return;
        }
        if (optJSONArray != null) {
            jSONObject = optJSONArray.getJSONObject(0);
        } else {
            jSONObject = null;
        }
        TransferDetailRsp transferDetailRsp = (TransferDetailRsp) new GsonBuilder().create().fromJson(String.valueOf(jSONObject), TransferDetailRsp.class);
        QLog.i(getTAG(), 2, "requestTransferDetail success: " + jSONObject);
        String listId = transferDetailRsp.getListId();
        if (listId == null) {
            listId = i2();
        }
        String str = listId;
        String d16 = M1().d();
        int ordinal2 = EnumPaymentType.Transfer.ordinal();
        String payerUin = transferDetailRsp.getPayerUin();
        if (payerUin == null) {
            payerUin = "";
        }
        String str2 = payerUin;
        Integer state = transferDetailRsp.getState();
        if (state == null) {
            ordinal = EnumTransferState.Init.ordinal();
        } else if (state.intValue() == 2) {
            ordinal = EnumTransferState.Init.ordinal();
        } else if (state.intValue() != 3) {
            contains = ArraysKt___ArraysKt.contains(new int[]{4, 5, 7}, state.intValue());
            if (contains) {
                ordinal = EnumTransferState.Timeout.ordinal();
            } else {
                ordinal = EnumTransferState.Init.ordinal();
            }
        } else {
            ordinal = EnumTransferState.Received.ordinal();
        }
        PaymentStateEntity paymentStateEntity = new PaymentStateEntity(null, str, d16, ordinal2, str2, ordinal, 1, null);
        QWalletDBManager.f361825a.i(paymentStateEntity);
        q2(paymentStateEntity, true);
    }

    private final void n2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("listid", i2());
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        linkedHashMap.put("_t", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        CgiBizData cgiBizData = new CgiBizData(com.tencent.mobileqq.base.a.c(), false, false, null, linkedHashMap, null, null, 104, null);
        String URI_PAYMENT_TRANS_DETAIL = Cgi.URI_PAYMENT_TRANS_DETAIL;
        Intrinsics.checkNotNullExpressionValue(URI_PAYMENT_TRANS_DETAIL, "URI_PAYMENT_TRANS_DETAIL");
        PayCgiService.sendRequest(null, URI_PAYMENT_TRANS_DETAIL, linkedHashMap, cgiBizData, CallbackThreadEnum.MAIN, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(TransferMsgViewModel this$0, PaymentData rawData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rawData, "$rawData");
        PaymentStateEntity z16 = QWalletDBManager.f361825a.z(this$0.i2(), this$0.M1().d(), EnumPaymentType.Transfer);
        boolean z17 = false;
        if (z16 != null && z16.getState() == EnumTransferState.OwnerClicked.ordinal()) {
            z17 = true;
        }
        if (z17) {
            rawData.f(true);
        }
        this$0.S1().postValue(rawData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(TransferMsgViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q2(QWalletDBManager.f361825a.z(this$0.i2(), this$0.M1().d(), EnumPaymentType.Transfer), false);
    }

    private final void q2(PaymentStateEntity stateEntity, boolean isFromServer) {
        Integer num;
        long j3;
        boolean z16;
        Long expiredSeconds;
        PaymentData Q1 = Q1();
        PaymentConfig.Companion companion = PaymentConfig.INSTANCE;
        PaymentConfig.PaymentTypeItem transfer = companion.a().getTransfer();
        if (stateEntity != null) {
            num = Integer.valueOf(stateEntity.getState());
        } else {
            num = null;
        }
        String b16 = f.b(transfer, num, null, 2, null);
        long msgTime = M1().getMsgTime();
        PaymentConfig.PaymentTypeItem transfer2 = companion.a().getTransfer();
        if (transfer2 != null && (expiredSeconds = transfer2.getExpiredSeconds()) != null) {
            j3 = expiredSeconds.longValue();
        } else {
            j3 = 0;
        }
        long j16 = msgTime + j3;
        boolean z17 = false;
        if (stateEntity != null && stateEntity.getState() == EnumTransferState.Received.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Q1.g(Integer.valueOf(R.drawable.otm));
            Q1.h(b16);
            Q1.f(true);
        } else {
            if (stateEntity != null && stateEntity.getState() == EnumTransferState.Timeout.ordinal()) {
                z17 = true;
            }
            if (z17) {
                Q1.h(b16);
                Q1.f(true);
            } else if (!isFromServer && ((stateEntity == null || stateEntity.getState() == EnumTransferState.Init.ordinal()) && j16 < NetConnInfoCenter.getServerTime())) {
                n2();
            }
        }
        S1().postValue(Q1);
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    protected void Z1() {
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("aio.zhuanzhang.show", "1", "", "", M1().getPeerUinStr());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    public void a2(@NotNull final PaymentData rawData) {
        String c16;
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        int templateId = M1().getTemplateId();
        if (templateId != 1) {
            if (templateId != 2) {
                if (templateId != 3) {
                    QLog.e(getTAG(), 1, "updatePaymentData: error cannot do this");
                    super.a2(rawData);
                    return;
                }
                rawData.f(true);
                rawData.g(Integer.valueOf(R.drawable.otm));
                S1().postValue(rawData);
                if (!Intrinsics.areEqual(M1().d(), M1().getPeerUinStr())) {
                    c16 = M1().getPeerUinStr();
                } else {
                    c16 = com.tencent.mobileqq.base.a.c();
                }
                QWalletDBManager.f361825a.i(new PaymentStateEntity(null, i2(), c16, EnumPaymentType.Transfer.ordinal(), M1().getPeerUinStr(), EnumTransferState.Received.ordinal(), 1, null));
                h.f361811a.c(i2());
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.m
                @Override // java.lang.Runnable
                public final void run() {
                    TransferMsgViewModel.p2(TransferMsgViewModel.this);
                }
            }, 32, null, true);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.l
            @Override // java.lang.Runnable
            public final void run() {
                TransferMsgViewModel.o2(TransferMsgViewModel.this, rawData);
            }
        }, 32, null, true);
    }

    public final void h2() {
        if (M1().getTemplateId() == 1) {
            QWalletDBManager.f361825a.i(new PaymentStateEntity(null, i2(), M1().d(), EnumPaymentType.Transfer.ordinal(), M1().getPeerUinStr(), EnumTransferState.OwnerClicked.ordinal(), 1, null));
            PaymentData Q1 = Q1();
            Q1.f(true);
            S1().postValue(Q1);
            return;
        }
        if (M1().getTemplateId() == 2) {
            this.refreshState = true;
        }
    }

    public final void j2() {
        if (M1().getTemplateId() == 2) {
            h.f361811a.a(i2(), this.stateUpdateListener);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.k
                @Override // java.lang.Runnable
                public final void run() {
                    TransferMsgViewModel.k2(TransferMsgViewModel.this);
                }
            }, 32, null, true);
        }
    }

    public final void l2() {
        if (M1().getTemplateId() == 2) {
            h.f361811a.b(i2());
        }
    }

    public final void onResume() {
        QLog.d(getTAG(), 1, "onResume: " + hashCode() + " isCoverClicked " + this.refreshState);
        if (this.refreshState) {
            n2();
            this.refreshState = false;
        }
    }
}
