package com.tencent.qqnt.qwallet.aio.pay;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
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
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.qqwallet.qqwalletaio_resv$Payer;
import tk2.GoldMsgTipsElemBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/b;", "Lcom/tencent/qqnt/qwallet/aio/pay/j;", "Lcom/tencent/qqnt/qwallet/aio/pay/g;", "rawData", "", "i2", "Lcom/tencent/qqnt/qwallet/db/i;", "entity", "", "isFromServer", "m2", "l2", "Lorg/json/JSONObject;", "bizJSON", "g2", SemanticAttributes.DbSystemValues.H2, "Q1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "T1", "e2", "onResume", "Lux3/a;", UserInfo.SEX_FEMALE, "Lux3/a;", "f2", "()Lux3/a;", "pushCallback", "G", "Z", "refreshState", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends j {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ux3.a pushCallback = new C9690b();

    /* renamed from: G, reason: from kotlin metadata */
    private boolean refreshState;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "sellerUin", "Ljava/lang/String;", "getSellerUin", "()Ljava/lang/String;", "", "totalAmount", "Ljava/lang/Float;", "getTotalAmount", "()Ljava/lang/Float;", "recvAmount", "getRecvAmount", "recvType", "Ljava/lang/Integer;", "getRecvType", "()Ljava/lang/Integer;", "groupId", "a", "state", "c", "", "Lcom/tencent/qqnt/qwallet/aio/pay/b$a$a;", "payerList", "Ljava/util/List;", "b", "()Ljava/util/List;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.b$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class AAPayDetailRsp {

        @SerializedName("group_id")
        @Nullable
        private final String groupId;

        @SerializedName("payer_list")
        @Nullable
        private final List<Payer> payerList;

        @SerializedName("recv_amount")
        @Nullable
        private final Float recvAmount;

        @SerializedName("recv_type")
        @Nullable
        private final Integer recvType;

        @SerializedName("seller_uin")
        @Nullable
        private final String sellerUin;

        @SerializedName("state")
        @Nullable
        private final Integer state;

        @SerializedName("amount")
        @Nullable
        private final Float totalAmount;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/b$a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "uin", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "getName", "", "amount", "Ljava/lang/Float;", "getAmount", "()Ljava/lang/Float;", "state", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.qwallet.aio.pay.b$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes25.dex */
        public static final /* data */ class Payer {

            @SerializedName("amount")
            @Nullable
            private final Float amount;

            @SerializedName("name")
            @Nullable
            private final String name;

            @SerializedName("state")
            @Nullable
            private final Integer state;

            @SerializedName("uin")
            @Nullable
            private final String uin;

            @Nullable
            /* renamed from: a, reason: from getter */
            public final Integer getState() {
                return this.state;
            }

            @Nullable
            /* renamed from: b, reason: from getter */
            public final String getUin() {
                return this.uin;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Payer)) {
                    return false;
                }
                Payer payer = (Payer) other;
                if (Intrinsics.areEqual(this.uin, payer.uin) && Intrinsics.areEqual(this.name, payer.name) && Intrinsics.areEqual((Object) this.amount, (Object) payer.amount) && Intrinsics.areEqual(this.state, payer.state)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int hashCode;
                int hashCode2;
                int hashCode3;
                String str = this.uin;
                int i3 = 0;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i16 = hashCode * 31;
                String str2 = this.name;
                if (str2 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = str2.hashCode();
                }
                int i17 = (i16 + hashCode2) * 31;
                Float f16 = this.amount;
                if (f16 == null) {
                    hashCode3 = 0;
                } else {
                    hashCode3 = f16.hashCode();
                }
                int i18 = (i17 + hashCode3) * 31;
                Integer num = this.state;
                if (num != null) {
                    i3 = num.hashCode();
                }
                return i18 + i3;
            }

            @NotNull
            public String toString() {
                return "Payer(uin=" + this.uin + ", name=" + this.name + ", amount=" + this.amount + ", state=" + this.state + ")";
            }
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        @Nullable
        public final List<Payer> b() {
            return this.payerList;
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
            if (!(other instanceof AAPayDetailRsp)) {
                return false;
            }
            AAPayDetailRsp aAPayDetailRsp = (AAPayDetailRsp) other;
            if (Intrinsics.areEqual(this.sellerUin, aAPayDetailRsp.sellerUin) && Intrinsics.areEqual((Object) this.totalAmount, (Object) aAPayDetailRsp.totalAmount) && Intrinsics.areEqual((Object) this.recvAmount, (Object) aAPayDetailRsp.recvAmount) && Intrinsics.areEqual(this.recvType, aAPayDetailRsp.recvType) && Intrinsics.areEqual(this.groupId, aAPayDetailRsp.groupId) && Intrinsics.areEqual(this.state, aAPayDetailRsp.state) && Intrinsics.areEqual(this.payerList, aAPayDetailRsp.payerList)) {
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
            String str = this.sellerUin;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            Float f16 = this.totalAmount;
            if (f16 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = f16.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Float f17 = this.recvAmount;
            if (f17 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = f17.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Integer num = this.recvType;
            if (num == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = num.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str2 = this.groupId;
            if (str2 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str2.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Integer num2 = this.state;
            if (num2 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = num2.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            List<Payer> list = this.payerList;
            if (list != null) {
                i3 = list.hashCode();
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            return "AAPayDetailRsp(sellerUin=" + this.sellerUin + ", totalAmount=" + this.totalAmount + ", recvAmount=" + this.recvAmount + ", recvType=" + this.recvType + ", groupId=" + this.groupId + ", state=" + this.state + ", payerList=" + this.payerList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/aio/pay/b$b", "Lux3/a;", "Ltk2/b;", "msgPushBean", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.aio.pay.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9690b implements ux3.a {
        C9690b() {
        }

        @Override // ux3.a
        public void a(@Nullable GoldMsgTipsElemBean msgPushBean) {
            String str;
            if (msgPushBean != null) {
                str = msgPushBean.getBillNo();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, b.this.M1().getBillNo())) {
                QLog.d(b.this.getTAG(), 4, "onPushArrived: " + msgPushBean);
                b.j2(b.this, null, 1, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qwallet/aio/pay/b$c", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "", "url", "result", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements NetCallback<HttpResult> {
        c() {
        }

        @Override // com.tenpay.sdk.net.core.callback.NetCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNetFailed(@NotNull String url, @NotNull HttpResult result) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.w(b.this.getTAG(), 1, "requestTransferDetail fail: " + result.getBizResponse());
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
                    b.this.g2(jSONObject);
                    return;
                }
                QLog.w(b.this.getTAG(), 1, "refreshPfa fail: " + num + " " + str);
            } catch (Exception e16) {
                QLog.w(b.this.getTAG(), 1, "parse pfa fail", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0043, code lost:
    
        if (r2 == null) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g2(JSONObject bizJSON) {
        EnumAAPayOwnerState enumAAPayOwnerState;
        boolean z16;
        String str;
        int ordinal;
        Integer state;
        PaymentStateEntity paymentStateEntity;
        String str2;
        AAPayDetailRsp aAPayDetailRsp = (AAPayDetailRsp) new GsonBuilder().create().fromJson(bizJSON.toString(), AAPayDetailRsp.class);
        QLog.i(getTAG(), 2, "requestAAPayDetail success: " + aAPayDetailRsp);
        boolean U1 = U1();
        Integer state2 = aAPayDetailRsp.getState();
        if (state2 != null) {
            enumAAPayOwnerState = EnumAAPayOwnerState.INSTANCE.a(state2.intValue());
        }
        enumAAPayOwnerState = EnumAAPayOwnerState.Init;
        if (U1) {
            String billNo = M1().getBillNo();
            int ordinal2 = EnumPaymentType.AAPayOwner.ordinal();
            String groupId = aAPayDetailRsp.getGroupId();
            if (groupId == null) {
                str2 = "";
            } else {
                str2 = groupId;
            }
            paymentStateEntity = new PaymentStateEntity(null, billNo, "", ordinal2, str2, enumAAPayOwnerState.ordinal(), 1, null);
        } else {
            List<AAPayDetailRsp.Payer> b16 = aAPayDetailRsp.b();
            AAPayDetailRsp.Payer payer = null;
            if (b16 != null) {
                Iterator<T> it = b16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((AAPayDetailRsp.Payer) next).getUin(), com.tencent.mobileqq.base.a.c())) {
                        payer = next;
                        break;
                    }
                }
                payer = payer;
            }
            boolean z17 = false;
            if (payer != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            String billNo2 = M1().getBillNo();
            int ordinal3 = EnumPaymentType.AAPayPayer.ordinal();
            String groupId2 = aAPayDetailRsp.getGroupId();
            if (groupId2 == null) {
                str = "";
            } else {
                str = groupId2;
            }
            if (!z16) {
                ordinal = EnumAAPayPayerState.NoNeedPay.ordinal();
            } else {
                if (payer != null && (state = payer.getState()) != null && state.intValue() == 2) {
                    z17 = true;
                }
                if (z17) {
                    ordinal = EnumAAPayPayerState.Payed.ordinal();
                } else if (enumAAPayOwnerState == EnumAAPayOwnerState.Close) {
                    ordinal = EnumAAPayPayerState.NoNeedPay.ordinal();
                } else {
                    ordinal = EnumAAPayPayerState.Init.ordinal();
                }
            }
            paymentStateEntity = new PaymentStateEntity(null, billNo2, "", ordinal3, str, ordinal, 1, null);
        }
        QWalletDBManager.f361825a.i(paymentStateEntity);
        m2(paymentStateEntity, true);
    }

    private final void i2(PaymentData rawData) {
        boolean z16;
        Object obj;
        boolean z17;
        long a16 = com.tencent.mobileqq.base.a.a();
        List<qqwalletaio_resv$Payer> list = M1().getElemResv().rpt_payer.get();
        Intrinsics.checkNotNullExpressionValue(list, "aioModel.elemResv.rpt_payer.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                obj = it.next();
                if (((qqwalletaio_resv$Payer) obj).uint64_uin.get() == a16) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            z16 = true;
        }
        if (!z16 && !U1()) {
            rawData.g(Integer.valueOf(R.drawable.otg));
            rawData.h("\u4f60\u65e0\u9700\u652f\u4ed8");
            rawData.f(true);
            S1().postValue(rawData);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.pay.a
            @Override // java.lang.Runnable
            public final void run() {
                b.k2(b.this);
            }
        }, 32, null, true);
    }

    static /* synthetic */ void j2(b bVar, PaymentData paymentData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            paymentData = bVar.Q1();
        }
        bVar.i2(paymentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(b this$0) {
        EnumPaymentType enumPaymentType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.U1()) {
            enumPaymentType = EnumPaymentType.AAPayOwner;
        } else {
            enumPaymentType = EnumPaymentType.AAPayPayer;
        }
        this$0.m2(QWalletDBManager.f361825a.z(this$0.M1().getBillNo(), "", enumPaymentType), false);
    }

    private final void l2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("collection_no", M1().getBillNo());
        linkedHashMap.put("uin", com.tencent.mobileqq.base.a.c());
        linkedHashMap.put("_t", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        CgiBizData cgiBizData = new CgiBizData(com.tencent.mobileqq.base.a.c(), false, false, null, linkedHashMap, null, null, 104, null);
        String URI_AAPAY_DETAIL = Cgi.URI_AAPAY_DETAIL;
        Intrinsics.checkNotNullExpressionValue(URI_AAPAY_DETAIL, "URI_AAPAY_DETAIL");
        PayCgiService.sendRequest(null, URI_AAPAY_DETAIL, linkedHashMap, cgiBizData, CallbackThreadEnum.MAIN, new c());
    }

    private final void m2(PaymentStateEntity entity, boolean isFromServer) {
        Integer num;
        boolean z16;
        Object obj;
        Integer num2;
        PBUInt32Field pBUInt32Field;
        boolean z17;
        Long expiredSeconds;
        Object obj2;
        Integer num3;
        PBUInt32Field pBUInt32Field2;
        boolean z18;
        Integer num4;
        Long expiredSeconds2;
        QLog.d(getTAG(), 2, "updatePaymentDataByDB: " + entity + " isFromServer=" + isFromServer);
        PaymentData Q1 = Q1();
        boolean U1 = U1();
        long j3 = 0;
        Integer valueOf = Integer.valueOf(R.drawable.otm);
        Integer valueOf2 = Integer.valueOf(R.drawable.otg);
        boolean z19 = false;
        if (U1) {
            if (entity != null) {
                num4 = Integer.valueOf(entity.getState());
            } else {
                num4 = null;
            }
            int ordinal = EnumAAPayOwnerState.Close.ordinal();
            if (num4 != null && num4.intValue() == ordinal) {
                Q1.g(valueOf2);
                Q1.f(true);
                Q1.h(f.b(PaymentConfig.INSTANCE.a().getAaPayOwner(), Integer.valueOf(entity.getState()), null, 2, null));
            } else {
                int ordinal2 = EnumAAPayOwnerState.Complete.ordinal();
                if (num4 != null && num4.intValue() == ordinal2) {
                    Q1.g(valueOf);
                    Q1.f(true);
                    Q1.h(f.b(PaymentConfig.INSTANCE.a().getAaPayOwner(), Integer.valueOf(entity.getState()), null, 2, null));
                } else {
                    long msgTime = M1().getMsgTime();
                    PaymentConfig.Companion companion = PaymentConfig.INSTANCE;
                    PaymentConfig.PaymentTypeItem aaPayOwner = companion.a().getAaPayOwner();
                    if (aaPayOwner != null && (expiredSeconds2 = aaPayOwner.getExpiredSeconds()) != null) {
                        j3 = expiredSeconds2.longValue();
                    }
                    long j16 = msgTime + j3;
                    if (!isFromServer && j16 < NetConnInfoCenter.getServerTime()) {
                        l2();
                    }
                    String subtitle = Q1.getSubtitle();
                    if (subtitle.length() == 0) {
                        z19 = true;
                    }
                    if (z19) {
                        subtitle = f.b(companion.a().getAaPayOwner(), Integer.valueOf(EnumAAPayOwnerState.None.ordinal()), null, 2, null);
                    }
                    Q1.h(subtitle);
                }
            }
        } else {
            if (entity != null) {
                num = Integer.valueOf(entity.getState());
            } else {
                num = null;
            }
            int ordinal3 = EnumAAPayPayerState.NoNeedPay.ordinal();
            if (num != null && num.intValue() == ordinal3) {
                Q1.g(valueOf2);
                Q1.f(true);
                Q1.h(f.b(PaymentConfig.INSTANCE.a().getAaPayPayer(), Integer.valueOf(entity.getState()), null, 2, null));
            } else {
                int ordinal4 = EnumAAPayPayerState.Payed.ordinal();
                if (num != null && num.intValue() == ordinal4) {
                    Q1.g(valueOf);
                    Q1.f(true);
                    Q1.h("");
                    List<qqwalletaio_resv$Payer> list = M1().getElemResv().rpt_payer.get();
                    Intrinsics.checkNotNullExpressionValue(list, "aioModel.elemResv.rpt_payer.get()");
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (((qqwalletaio_resv$Payer) obj2).uint64_uin.get() == com.tencent.mobileqq.base.a.a()) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    qqwalletaio_resv$Payer qqwalletaio_resv_payer = (qqwalletaio_resv$Payer) obj2;
                    if (qqwalletaio_resv_payer != null && (pBUInt32Field2 = qqwalletaio_resv_payer.uint32_amount) != null) {
                        num3 = Integer.valueOf(pBUInt32Field2.get());
                    } else {
                        num3 = null;
                    }
                    if (num3 != null && num3.intValue() != 0) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(f.b(PaymentConfig.INSTANCE.a().getAaPayPayer(), Integer.valueOf(entity.getState()), null, 2, null), Arrays.copyOf(new Object[]{Float.valueOf(num3.intValue() / 100.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        Q1.h(format);
                    } else {
                        Q1.h("\u8d26\u5355\u5df2\u652f\u4ed8");
                    }
                } else {
                    Q1.g(Integer.valueOf(R.drawable.oti));
                    long msgTime2 = M1().getMsgTime();
                    PaymentConfig.PaymentTypeItem aaPayPayer = PaymentConfig.INSTANCE.a().getAaPayPayer();
                    if (aaPayPayer != null && (expiredSeconds = aaPayPayer.getExpiredSeconds()) != null) {
                        j3 = expiredSeconds.longValue();
                    }
                    long j17 = msgTime2 + j3;
                    if (!isFromServer && j17 < NetConnInfoCenter.getServerTime()) {
                        l2();
                    }
                    String subtitle2 = Q1.getSubtitle();
                    if (subtitle2.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        List<qqwalletaio_resv$Payer> list2 = M1().getElemResv().rpt_payer.get();
                        Intrinsics.checkNotNullExpressionValue(list2, "aioModel.elemResv.rpt_payer.get()");
                        Iterator<T> it5 = list2.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                obj = it5.next();
                                if (((qqwalletaio_resv$Payer) obj).uint64_uin.get() == com.tencent.mobileqq.base.a.a()) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (z17) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        qqwalletaio_resv$Payer qqwalletaio_resv_payer2 = (qqwalletaio_resv$Payer) obj;
                        if (qqwalletaio_resv_payer2 != null && (pBUInt32Field = qqwalletaio_resv_payer2.uint32_amount) != null) {
                            num2 = Integer.valueOf(pBUInt32Field.get());
                        } else {
                            num2 = null;
                        }
                        if (num2 != null && num2.intValue() != 0) {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            subtitle2 = String.format(f.b(PaymentConfig.INSTANCE.a().getAaPayPayer(), Integer.valueOf(EnumAAPayPayerState.None.ordinal()), null, 2, null), Arrays.copyOf(new Object[]{Float.valueOf(num2.intValue() / 100.0f)}, 1));
                            Intrinsics.checkNotNullExpressionValue(subtitle2, "format(format, *args)");
                        } else {
                            subtitle2 = "\u8d26\u5355\u5f85\u652f\u4ed8";
                        }
                    }
                    Q1.h(subtitle2);
                }
            }
        }
        S1().postValue(Q1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    @NotNull
    public PaymentData Q1() {
        WalletAio T1 = T1();
        String str = T1.subTitle;
        Intrinsics.checkNotNullExpressionValue(str, "it.subTitle");
        String str2 = T1.title;
        Intrinsics.checkNotNullExpressionValue(str2, "it.title");
        String str3 = T1.content;
        Intrinsics.checkNotNullExpressionValue(str3, "it.content");
        return new PaymentData(str, str2, str3, false);
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    @NotNull
    protected WalletAio T1() {
        return M1().getReceiver();
    }

    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    protected void Z1() {
        ((IReportApi) QRoute.api(IReportApi.class)).reportHongbaoTo644("aio.shoukuan.show", "3", "", "", M1().getPeerUinStr());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.pay.j
    public void a2(@NotNull PaymentData rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        i2(rawData);
    }

    public final void e2() {
        if (M1().getMsgType() != 10) {
            this.refreshState = true;
        }
    }

    @NotNull
    /* renamed from: f2, reason: from getter */
    public final ux3.a getPushCallback() {
        return this.pushCallback;
    }

    public final void h2() {
        QLog.d(getTAG(), 4, NodeProps.ON_ATTACHED_TO_WINDOW);
        j2(this, null, 1, null);
    }

    public final void onResume() {
        QLog.d(getTAG(), 1, "onResume: " + hashCode() + " isCoverClicked " + this.refreshState);
        if (this.refreshState) {
            l2();
            this.refreshState = false;
        }
    }
}
