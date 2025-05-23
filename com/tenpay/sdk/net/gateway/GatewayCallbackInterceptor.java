package com.tenpay.sdk.net.gateway;

import android.app.Dialog;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyReq;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyRsp;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.impl.a;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.gateway.GatewayFakeUrlController;
import com.tenpay.sdk.net.gateway.GatewayPbCodec;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.b;
import pl2.g;
import pl2.k;
import pl2.l;
import pl2.o;
import pl2.p;
import pl2.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B/\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 \u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000eJ\u001e\u0010\u0019\u001a\u00020\u000e2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayCallbackInterceptor;", "Lpl2/o;", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ProxyRsp;", "Lpl2/q;", "", "rspByteArray", "", "onCallbackSuccess", "Lcom/tenpay/sdk/net/gateway/GatewayPbCodec;", "gatewayPbCodec", "", "", BaseConstants.ATTR_KET_EXTRA_MAP, "retryRequest", "", "checkIsAlive", "()Ljava/lang/Boolean;", "rsp", "onSuccess", "", "errCode", "errMsg", "onFail", "needToast", "onCallbackFail", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "silentMode", "Z", "Lcom/tenpay/sdk/net/gateway/GatewayPbCodec;", "Landroid/app/Dialog;", "loadingDialog", "Landroid/app/Dialog;", "Lpl2/k;", "callback", "Lpl2/k;", "getCallback", "()Lpl2/k;", "Lpl2/g;", "bizAbility", "Lpl2/g;", "<init>", "(ZLcom/tenpay/sdk/net/gateway/GatewayPbCodec;Landroid/app/Dialog;Lpl2/k;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GatewayCallbackInterceptor implements o<PayGatewayProto$ProxyRsp>, q {

    @Nullable
    private final g bizAbility;

    @NotNull
    private final k<byte[]> callback;

    @NotNull
    private final GatewayPbCodec gatewayPbCodec;

    @Nullable
    private final Dialog loadingDialog;
    private final boolean silentMode;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GatewayFakeUrlController.EnumHandleResult.values().length];
            try {
                iArr[GatewayFakeUrlController.EnumHandleResult.HANDLE_NEED_INTERCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GatewayFakeUrlController.EnumHandleResult.HANDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GatewayFakeUrlController.EnumHandleResult.NO_HANDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GatewayCallbackInterceptor(boolean z16, @NotNull GatewayPbCodec gatewayPbCodec, @Nullable Dialog dialog, @NotNull k<byte[]> callback) {
        Intrinsics.checkNotNullParameter(gatewayPbCodec, "gatewayPbCodec");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.silentMode = z16;
        this.gatewayPbCodec = gatewayPbCodec;
        this.loadingDialog = dialog;
        this.callback = callback;
        this.bizAbility = l.a(callback);
    }

    private final Boolean checkIsAlive() {
        g gVar = this.bizAbility;
        if (!(gVar instanceof b)) {
            ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, GatewayFakeUrlController.TAG, "not ContextAbility: " + gVar, null, 4, null);
            return null;
        }
        if (((b) gVar).getContext() != null && ((b) this.bizAbility).isAlive()) {
            return Boolean.TRUE;
        }
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, GatewayFakeUrlController.TAG, "ContextAbility has destroy: " + this.bizAbility, null, 4, null);
        return Boolean.FALSE;
    }

    public static /* synthetic */ void onCallbackFail$default(GatewayCallbackInterceptor gatewayCallbackInterceptor, int i3, String str, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = !gatewayCallbackInterceptor.silentMode;
        }
        gatewayCallbackInterceptor.onCallbackFail(i3, str, z16);
    }

    private final void onCallbackSuccess(byte[] rspByteArray) {
        ILogAgent.DefaultImpls.i$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " success.", null, 4, null);
        CoroutineScope f16 = a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, QWalletGatewayBaseServlet.TAG, null, null, null, new GatewayCallbackInterceptor$onCallbackSuccess$1(this, rspByteArray, null), 14, null);
        }
    }

    private final void retryRequest(GatewayPbCodec gatewayPbCodec, Map<String, String> extraMap) {
        String str;
        Set<Map.Entry<String, String>> entrySet;
        if (Intrinsics.areEqual(checkIsAlive(), Boolean.FALSE)) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, "stop retry request. context is not alive.", null, 4, null);
            return;
        }
        if (extraMap != null && (entrySet = extraMap.entrySet()) != null) {
            str = CollectionsKt___CollectionsKt.joinToString$default(entrySet, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.tenpay.sdk.net.gateway.GatewayCallbackInterceptor$retryRequest$proxyReq$1
                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CharSequence invoke2(@NotNull Map.Entry<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) it.getValue());
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                    return invoke2((Map.Entry<String, String>) entry);
                }
            }, 30, null);
        } else {
            str = null;
        }
        PayGatewayProto$ProxyReq updateRetryParams = gatewayPbCodec.updateRetryParams(str);
        if (updateRetryParams == null) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, "stop retry request. context is not alive.", null, 4, null);
            return;
        }
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + this + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
        newIntent.putExtra("data", fh.b(updateRetryParams.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.sdk.net.gateway.GatewayCallbackInterceptor$retryRequest$$inlined$sendRequest$default$1
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str2;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str2 = bundle.getString("rsp_msg");
                } else {
                    str2 = null;
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
                    if (str2 == null) {
                        str2 = "empty bundle";
                    }
                    oVar3.onFail(i16, str2);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    @NotNull
    public final k<byte[]> getCallback() {
        return this.callback;
    }

    public final void onCallbackFail(int errCode, @NotNull String errMsg, boolean needToast) {
        boolean z16;
        CoroutineScope f16;
        String errMsg2 = errMsg;
        Intrinsics.checkNotNullParameter(errMsg2, "errMsg");
        Boolean checkIsAlive = checkIsAlive();
        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " onFail: [errCode=" + errCode + "][errMsg=" + errMsg2 + "][isAlive=" + checkIsAlive + "][silentMode=" + this.silentMode + "]", null, 4, null);
        if (errMsg.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            errMsg2 = p.INSTANCE.a();
        }
        String str = errMsg2;
        if (!Intrinsics.areEqual(checkIsAlive, Boolean.FALSE) && (f16 = a.f261834a.f(i.e.f261783e)) != null) {
            CorountineFunKt.e(f16, QWalletGatewayBaseServlet.TAG, null, null, null, new GatewayCallbackInterceptor$onCallbackFail$1(this, needToast, str, errCode, null), 14, null);
        }
    }

    @Override // pl2.k
    public void onFail(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        onCallbackFail$default(this, errCode, errMsg, false, 4, null);
    }

    @Override // pl2.q
    public boolean retry(@Nullable Map<String, String> extraMap) {
        retryRequest(this.gatewayPbCodec, extraMap);
        return true;
    }

    @Override // pl2.k
    public void onSuccess(@NotNull PayGatewayProto$ProxyRsp rsp) {
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        DLog dLog = DLog.INSTANCE;
        ILogAgent.DefaultImpls.i$default(dLog, QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " finish: retCode=" + rsp.retcode.get() + " msg=" + rsp.retmsg.get(), null, 4, null);
        try {
            Boolean checkIsAlive = checkIsAlive();
            GatewayPbCodec.DecodeResult decode = this.gatewayPbCodec.decode(rsp);
            if ((this.bizAbility instanceof TranInfoAbility) && (f16 = a.f261834a.f(i.e.f261783e)) != null) {
                CorountineFunKt.e(f16, QWalletGatewayBaseServlet.TAG, null, null, null, new GatewayCallbackInterceptor$onSuccess$1(this, decode, null), 14, null);
            }
            if (decode.getRspByteArray() != null && !Intrinsics.areEqual(checkIsAlive, Boolean.FALSE)) {
                onCallbackSuccess(decode.getRspByteArray());
                return;
            }
            if (decode.getErrDetail() != null && !this.silentMode && Intrinsics.areEqual(checkIsAlive, Boolean.TRUE)) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[GatewayFakeUrlController.INSTANCE.processError(decode.getErrCode(), decode.getErrMsg(), decode.getErrDetail(), this.bizAbility, this).ordinal()];
                if (i3 == 1) {
                    ILogAgent.DefaultImpls.i$default(dLog, QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " callback intercepted.", null, 4, null);
                    return;
                }
                if (i3 == 2) {
                    onCallbackFail(decode.getErrCode(), decode.getErrMsg(), false);
                    return;
                } else {
                    if (i3 == 3) {
                        onFail(decode.getErrCode(), decode.getErrMsg());
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            onFail(decode.getErrCode(), decode.getErrMsg());
        } catch (Exception e16) {
            DLog dLog2 = DLog.INSTANCE;
            dLog2.w(QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " occur error: ", e16);
            if (GatewayExceptionHandler.INSTANCE.handeException(e16, this)) {
                ILogAgent.DefaultImpls.w$default(dLog2, QWalletGatewayBaseServlet.TAG, this.gatewayPbCodec.getSvrMethod() + " ignored callback, has handle error: " + e16, null, 4, null);
                return;
            }
            String retMsg = rsp.retmsg.get();
            if (retMsg == null || retMsg.length() == 0) {
                retMsg = GatewayFakeUrlController.INSTANCE.getDEFAULT_ERROR_TIPS();
            }
            int i16 = rsp.retcode.get();
            Intrinsics.checkNotNullExpressionValue(retMsg, "retMsg");
            onFail(i16, retMsg);
        }
    }
}
