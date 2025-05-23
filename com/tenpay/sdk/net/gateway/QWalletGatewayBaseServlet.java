package com.tenpay.sdk.net.gateway;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.impl.a;
import com.tenpay.view.WalletProgressDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.b;
import pl2.g;
import pl2.k;
import pl2.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\\\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/sdk/net/gateway/QWalletGatewayBaseServlet;", "", "", "silentMode", "needLoading", "Lpl2/k;", "", "bizCallback", "Landroid/app/Dialog;", "showLoadingIfNeed", "", "service", "method", "reqPayload", "needEncrypt", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "transInfo", "", "sendRequest", "TAG", "Ljava/lang/String;", "GATEWAY_CMD", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class QWalletGatewayBaseServlet {

    @NotNull
    public static final String GATEWAY_CMD = "trpc.qpay.gateway.Gateway.SsoHandle";

    @NotNull
    public static final QWalletGatewayBaseServlet INSTANCE = new QWalletGatewayBaseServlet();

    @NotNull
    public static final String TAG = "QWalletGatewayServlet";

    QWalletGatewayBaseServlet() {
    }

    public static /* synthetic */ void sendRequest$default(QWalletGatewayBaseServlet qWalletGatewayBaseServlet, String str, String str2, byte[] bArr, boolean z16, boolean z17, boolean z18, List list, k kVar, int i3, Object obj) {
        boolean z19;
        boolean z26;
        boolean z27;
        List list2;
        if ((i3 & 8) != 0) {
            z19 = false;
        } else {
            z19 = z16;
        }
        if ((i3 & 16) != 0) {
            z26 = false;
        } else {
            z26 = z17;
        }
        if ((i3 & 32) != 0) {
            z27 = false;
        } else {
            z27 = z18;
        }
        if ((i3 & 64) != 0) {
            list2 = null;
        } else {
            list2 = list;
        }
        qWalletGatewayBaseServlet.sendRequest(str, str2, bArr, z19, z26, z27, list2, kVar);
    }

    private final Dialog showLoadingIfNeed(boolean silentMode, boolean needLoading, k<byte[]> bizCallback) {
        if (silentMode || !needLoading) {
            return null;
        }
        g a16 = l.a(bizCallback);
        if (!(a16 instanceof b)) {
            return null;
        }
        Context context = ((b) a16).getContext();
        if (!(context instanceof Activity)) {
            return null;
        }
        WalletProgressDialog walletProgressDialog = new WalletProgressDialog(context);
        walletProgressDialog.show();
        return walletProgressDialog;
    }

    static /* synthetic */ Dialog showLoadingIfNeed$default(QWalletGatewayBaseServlet qWalletGatewayBaseServlet, boolean z16, boolean z17, k kVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        return qWalletGatewayBaseServlet.showLoadingIfNeed(z16, z17, kVar);
    }

    public final void sendRequest(@NotNull String service, @NotNull String method, @NotNull byte[] reqPayload, boolean needEncrypt, boolean silentMode, boolean needLoading, @Nullable List<PayGatewayProto$TransInfo> transInfo, @NotNull k<byte[]> bizCallback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqPayload, "reqPayload");
        Intrinsics.checkNotNullParameter(bizCallback, "bizCallback");
        Dialog showLoadingIfNeed = showLoadingIfNeed(silentMode, needLoading, bizCallback);
        CoroutineScope f16 = a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, TAG, null, null, null, new QWalletGatewayBaseServlet$sendRequest$1(service, method, reqPayload, needEncrypt, transInfo, silentMode, showLoadingIfNeed, bizCallback, null), 14, null);
        }
    }
}
