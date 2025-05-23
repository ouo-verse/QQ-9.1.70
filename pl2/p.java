package pl2;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lpl2/p;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class p extends MSFServlet {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f426459e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lpl2/p$a;", "", "", "DEFAULT_ERR_MSG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "DEFAULT_TIMEOUT", "J", "EXTRA_CMD", "EXTRA_DATA", "EXTRA_RSP_BYTES", "EXTRA_RSP_CODE", "EXTRA_RSP_MSG", "EXTRA_TIMEOUT", "GATEWAY_CMD", "", "RSP_HEADER_LENGTH", "I", "TAG", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pl2.p$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return p.f426459e;
        }

        Companion() {
        }
    }

    static {
        String string = BaseApplication.context.getString(R.string.e_t);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.qb_tenpay_network_error)");
        f426459e = string;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @Nullable FromServiceMsg response) {
        Unit unit;
        boolean z16;
        boolean z17;
        Bundle bundle = new Bundle();
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_PB_HANDLE_TRPC_ERROR);
        if (response != null) {
            if (response.isSuccess()) {
                if (isSwitchOn && response.getTrpcRspFuncRetCode() != 0 && response.getTrpcRspRetCode() != 0) {
                    byte[] trpcRspErrorMsg = response.getTrpcRspErrorMsg();
                    Intrinsics.checkNotNullExpressionValue(trpcRspErrorMsg, "it.trpcRspErrorMsg");
                    String str = new String(trpcRspErrorMsg, Charsets.UTF_8);
                    QLog.w("QWalletHttp-QWalletPbServlet", 1, "response trpc fail retCode = " + response.getTrpcRspRetCode() + ", funcRetCode = " + response.getTrpcRspRetCode() + ", " + str);
                    bundle.putString("rsp_msg", str);
                    bundle.putInt("rsp_code", response.getTrpcRspRetCode());
                } else {
                    try {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "response success: " + response.getServiceCmd());
                        int length = response.getWupBuffer().length - 4;
                        byte[] bArr = new byte[length];
                        PkgTools.copyData(bArr, 0, response.getWupBuffer(), 4, length);
                        bundle.putByteArray("rsp_bytes", bArr);
                        z16 = true;
                    } catch (Exception e16) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "error when parse rsp", e16);
                        bundle.putString("rsp_msg", response.getShortStringForLog());
                    }
                    unit = Unit.INSTANCE;
                }
            } else {
                QLog.w("QWalletHttp-QWalletPbServlet", 1, "response fail resultCode = " + response.getResultCode() + ", " + response.getShortStringForLog());
                bundle.putString("rsp_msg", response.getShortStringForLog());
                bundle.putInt("rsp_code", response.getResultCode());
            }
            z16 = false;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
            z16 = false;
        }
        if (unit == null) {
            bundle.putString("rsp_msg", "response is null");
            bundle.putInt("rsp_code", 1001);
            QLog.w("QWalletHttp-QWalletPbServlet", 1, "response is null");
        }
        if (isSwitchOn) {
            z17 = z16;
        } else if (response != null) {
            z17 = response.isSuccess();
        } else {
            z17 = false;
        }
        notifyObserver(request, 0, z17, bundle, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        if (request != null) {
            String stringExtra = request.getStringExtra("cmd");
            long longExtra = request.getLongExtra("timeout", 30000L);
            byte[] byteArrayExtra = request.getByteArrayExtra("data");
            if (packet != null) {
                packet.setSSOCommand(stringExtra);
                packet.setTimeout(longExtra);
                packet.putSendData(byteArrayExtra);
                com.tencent.mobileqq.qwallet.utils.f.a("QWalletHttp-QWalletPbServlet", "onSend ");
                return;
            }
            com.tencent.mobileqq.qwallet.utils.f.a("QWalletHttp-QWalletPbServlet", "onSend, packet is null");
            return;
        }
        com.tencent.mobileqq.qwallet.utils.f.a("QWalletHttp-QWalletPbServlet", "onSend, request is null");
    }
}
