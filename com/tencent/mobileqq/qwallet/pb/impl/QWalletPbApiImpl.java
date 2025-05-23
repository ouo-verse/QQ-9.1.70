package com.tencent.mobileqq.qwallet.pb.impl;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qwallet.pb.IQWalletPbApi;
import com.tencent.mobileqq.qwallet.pb.WxQrcodePayEncrypt$EncryptReq;
import com.tencent.mobileqq.qwallet.pb.WxQrcodePayEncrypt$EncryptRsp;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import pl2.o;
import pl2.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ*\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/impl/QWalletPbApiImpl;", "Lcom/tencent/mobileqq/qwallet/pb/IQWalletPbApi;", "", WadlProxyConsts.CHANNEL, "Lkotlin/Function2;", "Landroid/os/Bundle;", "", "receiver", "requestWxQrcodePayToken", "<init>", "()V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPbApiImpl implements IQWalletPbApi {

    @NotNull
    private static final String CMD_GET_WORD_DETAIL = "trpc.qqhb.sendhbdetail.sendhbdetail.GetWordDetail";

    @NotNull
    private static final String CMD_GET_WX_QRCODE_PAY_TOKEN = "trpc.qpay.encryptedtransfer.Encryption.SsoUINEncrypt";

    @NotNull
    private static final String TAG = "QWalletPbApiImpl";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f278713d;

        public b(o oVar) {
            this.f278713d = oVar;
        }

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
                    MessageMicro rsp = ((MessageMicro) WxQrcodePayEncrypt$EncryptRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f278713d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + WxQrcodePayEncrypt$EncryptRsp.class + " failed.");
                    o oVar2 = this.f278713d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f278713d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/pb/impl/QWalletPbApiImpl$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/WxQrcodePayEncrypt$EncryptRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<WxQrcodePayEncrypt$EncryptRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, Bundle, Unit> f278714a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function2<? super Integer, ? super Bundle, Unit> function2) {
            this.f278714a = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull WxQrcodePayEncrypt$EncryptRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (rsp.ret_code.get() == 0) {
                Bundle bundle = new Bundle();
                bundle.putString("token", rsp.token.get());
                this.f278714a.invoke(1, bundle);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString("extra_error_msg", rsp.err_msg.get());
                this.f278714a.invoke(-1, bundle2);
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Bundle bundle = new Bundle();
            bundle.putString("extra_error_msg", errMsg);
            this.f278714a.invoke(-1, bundle);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pb.IQWalletPbApi
    public void requestWxQrcodePayToken(int channel, @NotNull Function2<? super Integer, ? super Bundle, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        WxQrcodePayEncrypt$EncryptReq wxQrcodePayEncrypt$EncryptReq = new WxQrcodePayEncrypt$EncryptReq();
        wxQrcodePayEncrypt$EncryptReq.channel.set(channel);
        c cVar = new c(receiver);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + CMD_GET_WX_QRCODE_PAY_TOKEN + " callback: " + cVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", CMD_GET_WX_QRCODE_PAY_TOKEN);
        newIntent.putExtra("data", fh.b(wxQrcodePayEncrypt$EncryptReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }
}
