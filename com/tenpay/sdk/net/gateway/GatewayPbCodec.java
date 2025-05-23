package com.tenpay.sdk.net.gateway;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyReq;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyRsp;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.gateway.data.GatewayEncryptResult;
import com.tenpay.sdk.net.gateway.data.TransInfoInput;
import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayPbCodec;", "", "service", "", "method", "(Ljava/lang/String;Ljava/lang/String;)V", "encodeResult", "Lcom/tenpay/sdk/net/gateway/GatewayPbCodec$EncodeResult;", "getMethod", "()Ljava/lang/String;", "getService", "decode", "Lcom/tenpay/sdk/net/gateway/GatewayPbCodec$DecodeResult;", "rsp", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyRsp;", "encode", "reqByteArray", "", "needEncrypt", "", "bizTrans", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "getSvrMethod", "updateRetryParams", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyReq;", "extraParam", "Companion", "DecodeResult", "EncodeResult", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GatewayPbCodec {

    @NotNull
    private static final String TAG = "GatewayPbCodec";

    @Nullable
    private EncodeResult encodeResult;

    @NotNull
    private final String method;

    @NotNull
    private final String service;

    public GatewayPbCodec(@NotNull String service, @NotNull String method) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        this.service = service;
        this.method = method;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EncodeResult encode$default(GatewayPbCodec gatewayPbCodec, byte[] bArr, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            list = null;
        }
        return gatewayPbCodec.encode(bArr, z16, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail] */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail] */
    @NotNull
    public final DecodeResult decode(@NotNull PayGatewayProto$ProxyRsp rsp) {
        GatewayEncryptResult gatewayEncryptResult;
        boolean z16;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        TransInfoOutput.Companion companion = TransInfoOutput.INSTANCE;
        List<PayGatewayProto$TransInfo> list = rsp.trans.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.trans.get()");
        TransInfoOutput fromPb = companion.fromPb(list);
        GatewayEncryptResult gatewayEncryptResult2 = null;
        if (rsp.retcode.get() == 0) {
            byte[] payloadBytes = rsp.payload.get().toByteArray();
            Intrinsics.checkNotNullExpressionValue(payloadBytes, "payloadBytes");
            if (payloadBytes.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, "[" + this.service + ":" + this.method + "] callback empty rsp: " + rsp, null, 4, null);
                return new DecodeResult(payloadBytes, fromPb, 0, null, null, 28, null);
            }
            DLog dLog = DLog.INSTANCE;
            ILogAgent.DefaultImpls.i$default(dLog, TAG, "decode transInfoOutput: " + fromPb, null, 4, null);
            GatewayEncryptController gatewayEncryptController = GatewayEncryptController.INSTANCE;
            EncodeResult encodeResult = this.encodeResult;
            if (encodeResult != null) {
                gatewayEncryptResult2 = encodeResult.getEncryptResult();
            }
            byte[] decrypt = gatewayEncryptController.decrypt(payloadBytes, fromPb, gatewayEncryptResult2);
            if (decrypt != null) {
                ILogAgent.DefaultImpls.w$default(dLog, QWalletGatewayBaseServlet.TAG, "[" + this.service + ":" + this.method + "] onSuccess.", null, 4, null);
                return new DecodeResult(decrypt, fromPb, 0, null, null, 28, null);
            }
            return new DecodeResult(null, fromPb, -1002, p.INSTANCE.a(), null, 16, null);
        }
        try {
            GatewayEncryptController gatewayEncryptController2 = GatewayEncryptController.INSTANCE;
            byte[] byteArray = rsp.err.get().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "rsp.err.get().toByteArray()");
            EncodeResult encodeResult2 = this.encodeResult;
            if (encodeResult2 != null) {
                gatewayEncryptResult = encodeResult2.getEncryptResult();
            } else {
                gatewayEncryptResult = null;
            }
            byte[] decrypt2 = gatewayEncryptController2.decrypt(byteArray, fromPb, gatewayEncryptResult);
            if (decrypt2 != null) {
                gatewayEncryptResult2 = ((PayGatewayProto$ErrDetail) PayGatewayProto$ErrDetail.class.newInstance()).mergeFrom(decrypt2);
            }
        } catch (Exception e16) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "decode errorDetail error: " + e16, null, 4, null);
        }
        ?? r102 = gatewayEncryptResult2;
        int i3 = rsp.retcode.get();
        String str = rsp.retmsg.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.retmsg.get()");
        return new DecodeResult(null, fromPb, i3, str, r102);
    }

    @NotNull
    public final EncodeResult encode(@NotNull byte[] reqByteArray, boolean needEncrypt, @Nullable List<PayGatewayProto$TransInfo> bizTrans) {
        List<PayGatewayProto$TransInfo> mutableList;
        Intrinsics.checkNotNullParameter(reqByteArray, "reqByteArray");
        PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = new PayGatewayProto$ProxyReq();
        payGatewayProto$ProxyReq.service.set(this.service);
        payGatewayProto$ProxyReq.method.set(this.method);
        GatewayEncryptResult encrypt = GatewayEncryptController.INSTANCE.encrypt(reqByteArray, needEncrypt);
        DLog dLog = DLog.INSTANCE;
        ILogAgent.DefaultImpls.i$default(dLog, TAG, "encrypt finish: needEncrypt=" + needEncrypt + " size=" + encrypt.getContent().length, null, 4, null);
        payGatewayProto$ProxyReq.payload.set(ByteStringMicro.copyFrom(encrypt.getContent()));
        try {
            ArrayList arrayList = new ArrayList();
            TransInfoInput transInputInfo = encrypt.getTransInputInfo();
            if (transInputInfo != null && (mutableList = transInputInfo.toMutableList()) != null) {
                arrayList.addAll(mutableList);
            }
            if (bizTrans != null) {
                arrayList.addAll(bizTrans);
            }
            payGatewayProto$ProxyReq.trans.set(arrayList);
            ILogAgent.DefaultImpls.i$default(dLog, TAG, "transInputInfo: " + encrypt.getTransInputInfo(), null, 4, null);
        } catch (Exception unused) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "trans: " + encrypt.getTransInputInfo(), null, 4, null);
        }
        EncodeResult encodeResult = new EncodeResult(payGatewayProto$ProxyReq, encrypt, 0, null, 12, null);
        this.encodeResult = encodeResult;
        return encodeResult;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final String getService() {
        return this.service;
    }

    @NotNull
    public final String getSvrMethod() {
        return "[" + this.service + ":" + this.method + "]";
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if (r4 == null) goto L15;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PayGatewayProto$ProxyReq updateRetryParams(@Nullable String extraParam) {
        PayGatewayProto$ProxyReq req;
        List<PayGatewayProto$TransInfo> arrayList;
        GatewayEncryptResult encryptResult;
        TransInfoInput transInputInfo;
        EncodeResult encodeResult = this.encodeResult;
        if (encodeResult != null && (req = encodeResult.getReq()) != null) {
            PBRepeatMessageField<PayGatewayProto$TransInfo> pBRepeatMessageField = req.trans;
            EncodeResult encodeResult2 = this.encodeResult;
            if (encodeResult2 != null && (encryptResult = encodeResult2.getEncryptResult()) != null && (transInputInfo = encryptResult.getTransInputInfo()) != null) {
                transInputInfo.setRetryTransParam(extraParam);
                arrayList = transInputInfo.toMutableList();
            }
            arrayList = new ArrayList<>();
            pBRepeatMessageField.set(arrayList);
            return req;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J5\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\tH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayPbCodec$EncodeResult;", "", "req", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyReq;", "encryptResult", "Lcom/tenpay/sdk/net/gateway/data/GatewayEncryptResult;", "errCode", "", "errMsg", "", "(Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyReq;Lcom/tenpay/sdk/net/gateway/data/GatewayEncryptResult;ILjava/lang/String;)V", "getEncryptResult", "()Lcom/tenpay/sdk/net/gateway/data/GatewayEncryptResult;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getReq", "()Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyReq;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class EncodeResult {

        @Nullable
        private final GatewayEncryptResult encryptResult;
        private final int errCode;

        @NotNull
        private final String errMsg;

        @Nullable
        private final PayGatewayProto$ProxyReq req;

        public EncodeResult(@Nullable PayGatewayProto$ProxyReq payGatewayProto$ProxyReq, @Nullable GatewayEncryptResult gatewayEncryptResult, int i3, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.req = payGatewayProto$ProxyReq;
            this.encryptResult = gatewayEncryptResult;
            this.errCode = i3;
            this.errMsg = errMsg;
        }

        public static /* synthetic */ EncodeResult copy$default(EncodeResult encodeResult, PayGatewayProto$ProxyReq payGatewayProto$ProxyReq, GatewayEncryptResult gatewayEncryptResult, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                payGatewayProto$ProxyReq = encodeResult.req;
            }
            if ((i16 & 2) != 0) {
                gatewayEncryptResult = encodeResult.encryptResult;
            }
            if ((i16 & 4) != 0) {
                i3 = encodeResult.errCode;
            }
            if ((i16 & 8) != 0) {
                str = encodeResult.errMsg;
            }
            return encodeResult.copy(payGatewayProto$ProxyReq, gatewayEncryptResult, i3, str);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final PayGatewayProto$ProxyReq getReq() {
            return this.req;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final GatewayEncryptResult getEncryptResult() {
            return this.encryptResult;
        }

        /* renamed from: component3, reason: from getter */
        public final int getErrCode() {
            return this.errCode;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        @NotNull
        public final EncodeResult copy(@Nullable PayGatewayProto$ProxyReq req, @Nullable GatewayEncryptResult encryptResult, int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            return new EncodeResult(req, encryptResult, errCode, errMsg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EncodeResult)) {
                return false;
            }
            EncodeResult encodeResult = (EncodeResult) other;
            if (Intrinsics.areEqual(this.req, encodeResult.req) && Intrinsics.areEqual(this.encryptResult, encodeResult.encryptResult) && this.errCode == encodeResult.errCode && Intrinsics.areEqual(this.errMsg, encodeResult.errMsg)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final GatewayEncryptResult getEncryptResult() {
            return this.encryptResult;
        }

        public final int getErrCode() {
            return this.errCode;
        }

        @NotNull
        public final String getErrMsg() {
            return this.errMsg;
        }

        @Nullable
        public final PayGatewayProto$ProxyReq getReq() {
            return this.req;
        }

        public int hashCode() {
            int hashCode;
            PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = this.req;
            int i3 = 0;
            if (payGatewayProto$ProxyReq == null) {
                hashCode = 0;
            } else {
                hashCode = payGatewayProto$ProxyReq.hashCode();
            }
            int i16 = hashCode * 31;
            GatewayEncryptResult gatewayEncryptResult = this.encryptResult;
            if (gatewayEncryptResult != null) {
                i3 = gatewayEncryptResult.hashCode();
            }
            return ((((i16 + i3) * 31) + this.errCode) * 31) + this.errMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "EncodeResult(req=" + this.req + ", encryptResult=" + this.encryptResult + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
        }

        public /* synthetic */ EncodeResult(PayGatewayProto$ProxyReq payGatewayProto$ProxyReq, GatewayEncryptResult gatewayEncryptResult, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(payGatewayProto$ProxyReq, (i16 & 2) != 0 ? null : gatewayEncryptResult, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JA\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0007H\u00d6\u0001J\t\u0010!\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayPbCodec$DecodeResult;", "", "rspByteArray", "", "transInfo", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "errCode", "", "errMsg", "", "errDetail", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "([BLcom/tenpay/sdk/net/gateway/data/TransInfoOutput;ILjava/lang/String;Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;)V", "getErrCode", "()I", "getErrDetail", "()Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "getErrMsg", "()Ljava/lang/String;", "getRspByteArray", "()[B", "getTransInfo", "()Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class DecodeResult {
        private final int errCode;

        @Nullable
        private final PayGatewayProto$ErrDetail errDetail;

        @NotNull
        private final String errMsg;

        @Nullable
        private final byte[] rspByteArray;

        @Nullable
        private final TransInfoOutput transInfo;

        public DecodeResult(@Nullable byte[] bArr, @Nullable TransInfoOutput transInfoOutput, int i3, @NotNull String errMsg, @Nullable PayGatewayProto$ErrDetail payGatewayProto$ErrDetail) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.rspByteArray = bArr;
            this.transInfo = transInfoOutput;
            this.errCode = i3;
            this.errMsg = errMsg;
            this.errDetail = payGatewayProto$ErrDetail;
        }

        public static /* synthetic */ DecodeResult copy$default(DecodeResult decodeResult, byte[] bArr, TransInfoOutput transInfoOutput, int i3, String str, PayGatewayProto$ErrDetail payGatewayProto$ErrDetail, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                bArr = decodeResult.rspByteArray;
            }
            if ((i16 & 2) != 0) {
                transInfoOutput = decodeResult.transInfo;
            }
            TransInfoOutput transInfoOutput2 = transInfoOutput;
            if ((i16 & 4) != 0) {
                i3 = decodeResult.errCode;
            }
            int i17 = i3;
            if ((i16 & 8) != 0) {
                str = decodeResult.errMsg;
            }
            String str2 = str;
            if ((i16 & 16) != 0) {
                payGatewayProto$ErrDetail = decodeResult.errDetail;
            }
            return decodeResult.copy(bArr, transInfoOutput2, i17, str2, payGatewayProto$ErrDetail);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final byte[] getRspByteArray() {
            return this.rspByteArray;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final TransInfoOutput getTransInfo() {
            return this.transInfo;
        }

        /* renamed from: component3, reason: from getter */
        public final int getErrCode() {
            return this.errCode;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final PayGatewayProto$ErrDetail getErrDetail() {
            return this.errDetail;
        }

        @NotNull
        public final DecodeResult copy(@Nullable byte[] rspByteArray, @Nullable TransInfoOutput transInfo, int errCode, @NotNull String errMsg, @Nullable PayGatewayProto$ErrDetail errDetail) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            return new DecodeResult(rspByteArray, transInfo, errCode, errMsg, errDetail);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DecodeResult)) {
                return false;
            }
            DecodeResult decodeResult = (DecodeResult) other;
            if (Intrinsics.areEqual(this.rspByteArray, decodeResult.rspByteArray) && Intrinsics.areEqual(this.transInfo, decodeResult.transInfo) && this.errCode == decodeResult.errCode && Intrinsics.areEqual(this.errMsg, decodeResult.errMsg) && Intrinsics.areEqual(this.errDetail, decodeResult.errDetail)) {
                return true;
            }
            return false;
        }

        public final int getErrCode() {
            return this.errCode;
        }

        @Nullable
        public final PayGatewayProto$ErrDetail getErrDetail() {
            return this.errDetail;
        }

        @NotNull
        public final String getErrMsg() {
            return this.errMsg;
        }

        @Nullable
        public final byte[] getRspByteArray() {
            return this.rspByteArray;
        }

        @Nullable
        public final TransInfoOutput getTransInfo() {
            return this.transInfo;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            byte[] bArr = this.rspByteArray;
            int i3 = 0;
            if (bArr == null) {
                hashCode = 0;
            } else {
                hashCode = Arrays.hashCode(bArr);
            }
            int i16 = hashCode * 31;
            TransInfoOutput transInfoOutput = this.transInfo;
            if (transInfoOutput == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = transInfoOutput.hashCode();
            }
            int hashCode3 = (((((i16 + hashCode2) * 31) + this.errCode) * 31) + this.errMsg.hashCode()) * 31;
            PayGatewayProto$ErrDetail payGatewayProto$ErrDetail = this.errDetail;
            if (payGatewayProto$ErrDetail != null) {
                i3 = payGatewayProto$ErrDetail.hashCode();
            }
            return hashCode3 + i3;
        }

        @NotNull
        public String toString() {
            return "DecodeResult(rspByteArray=" + Arrays.toString(this.rspByteArray) + ", transInfo=" + this.transInfo + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", errDetail=" + this.errDetail + ")";
        }

        public /* synthetic */ DecodeResult(byte[] bArr, TransInfoOutput transInfoOutput, int i3, String str, PayGatewayProto$ErrDetail payGatewayProto$ErrDetail, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, (i16 & 2) != 0 ? null : transInfoOutput, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? null : payGatewayProto$ErrDetail);
        }
    }
}
