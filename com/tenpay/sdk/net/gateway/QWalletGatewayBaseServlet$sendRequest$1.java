package com.tenpay.sdk.net.gateway;

import android.app.Dialog;
import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyReq;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyRsp;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.gateway.GatewayPbCodec;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.k;
import pl2.o;
import pl2.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tenpay.sdk.net.gateway.QWalletGatewayBaseServlet$sendRequest$1", f = "QWalletGatewayBaseServlet.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
public final class QWalletGatewayBaseServlet$sendRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k<byte[]> $bizCallback;
    final /* synthetic */ Dialog $loadingDialog;
    final /* synthetic */ String $method;
    final /* synthetic */ boolean $needEncrypt;
    final /* synthetic */ byte[] $reqPayload;
    final /* synthetic */ String $service;
    final /* synthetic */ boolean $silentMode;
    final /* synthetic */ List<PayGatewayProto$TransInfo> $transInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletGatewayBaseServlet$sendRequest$1(String str, String str2, byte[] bArr, boolean z16, List<PayGatewayProto$TransInfo> list, boolean z17, Dialog dialog, k<byte[]> kVar, Continuation<? super QWalletGatewayBaseServlet$sendRequest$1> continuation) {
        super(2, continuation);
        this.$service = str;
        this.$method = str2;
        this.$reqPayload = bArr;
        this.$needEncrypt = z16;
        this.$transInfo = list;
        this.$silentMode = z17;
        this.$loadingDialog = dialog;
        this.$bizCallback = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletGatewayBaseServlet$sendRequest$1(this.$service, this.$method, this.$reqPayload, this.$needEncrypt, this.$transInfo, this.$silentMode, this.$loadingDialog, this.$bizCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, "start request: [" + this.$service + ":" + this.$method + "]", null, 4, null);
            GatewayPbCodec gatewayPbCodec = new GatewayPbCodec(this.$service, this.$method);
            GatewayPbCodec.EncodeResult encode = gatewayPbCodec.encode(this.$reqPayload, this.$needEncrypt, this.$transInfo);
            final GatewayCallbackInterceptor gatewayCallbackInterceptor = new GatewayCallbackInterceptor(this.$silentMode, gatewayPbCodec, this.$loadingDialog, this.$bizCallback);
            if (encode.getReq() == null) {
                gatewayCallbackInterceptor.onFail(encode.getErrCode(), encode.getErrMsg());
                return Unit.INSTANCE;
            }
            p.Companion companion = p.INSTANCE;
            PayGatewayProto$ProxyReq req = encode.getReq();
            QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + gatewayCallbackInterceptor + TokenParser.SP);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
            newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
            newIntent.putExtra("data", fh.b(req.toByteArray()));
            newIntent.putExtra("timeout", 30000L);
            newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.sdk.net.gateway.QWalletGatewayBaseServlet$sendRequest$1$invokeSuspend$$inlined$sendRequest$default$1
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    int i16;
                    String str;
                    if (bundle != null) {
                        i16 = bundle.getInt("rsp_code");
                    } else {
                        i16 = 1001;
                    }
                    if (bundle != null) {
                        str = bundle.getString("rsp_msg");
                    } else {
                        str = null;
                    }
                    if (z16) {
                        try {
                            MessageMicro rsp = ((MessageMicro) PayGatewayProto$ProxyRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                            o oVar = o.this;
                            if (oVar != null) {
                                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                                oVar.onSuccess((o) rsp);
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PayGatewayProto$ProxyRsp.class + " failed.");
                            o oVar2 = o.this;
                            if (oVar2 != null) {
                                oVar2.onFail(i16, p.INSTANCE.a());
                                return;
                            }
                            return;
                        }
                    }
                    o oVar3 = o.this;
                    if (oVar3 != null) {
                        if (str == null) {
                            str = "empty bundle";
                        }
                        oVar3.onFail(i16, str);
                    }
                }
            });
            waitAppRuntime.startServlet(newIntent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QWalletGatewayBaseServlet$sendRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
