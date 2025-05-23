package com.tencent.mobileqq.zootopia.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JH\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaFetchWxCodeIPCImpl;", "", "", "appId", "Lcom/tencent/mobileqq/zootopia/ipc/t;", "callback", "", "fetchWxCode", "", "timestamp", PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, "packageStr", PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY, "Lcom/tencent/mobileqq/zootopia/ipc/am;", "requestWxPay", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaFetchWxCodeIPCImpl {
    public static final String TAG = "ZootopiaFetchWxCodeIPCImpl";

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/ipc/ZootopiaFetchWxCodeIPCImpl$b", "Lpr2/c;", "", "code", "", "b", "", "retCode", "msg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements pr2.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f328335a;

        b(t tVar) {
            this.f328335a = tVar;
        }

        @Override // pr2.c
        public void a(int retCode, String msg2) {
            t tVar = this.f328335a;
            if (tVar != null) {
                tVar.onResult(retCode, "", msg2);
            }
        }

        @Override // pr2.c
        public void b(String code) {
            t tVar = this.f328335a;
            if (tVar != null) {
                tVar.onResult(0, code, "success");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ipc/ZootopiaFetchWxCodeIPCImpl$c", "Lcom/tencent/mobileqq/wxmini/api/data/b;", "", "success", "Landroid/os/Bundle;", "data", "", "onCallback", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.wxmini.api.data.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ am f328336a;

        c(am amVar) {
            this.f328336a = amVar;
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.b
        public void onCallback(boolean success, Bundle data) {
            if (success) {
                am amVar = this.f328336a;
                if (amVar != null) {
                    amVar.onResult(0, data != null ? data.getString("result", "") : null);
                    return;
                }
                return;
            }
            am amVar2 = this.f328336a;
            if (amVar2 != null) {
                amVar2.onResult(-1, data != null ? data.getString("result", "") : null);
            }
        }
    }

    public void fetchWxCode(String appId, t callback) {
        if (!TextUtils.isEmpty(appId)) {
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).fetchWxAppCode(appId, new b(callback));
        } else if (callback != null) {
            callback.onResult(-1, "", "empty appid");
        }
    }

    public void requestWxPay(String appId, long timestamp, String nonceStr, String packageStr, String signType, String paySign, am callback) {
        Intrinsics.checkNotNullParameter(nonceStr, "nonceStr");
        Intrinsics.checkNotNullParameter(paySign, "paySign");
        if (!TextUtils.isEmpty(appId)) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).requestPayment(appId, timestamp, nonceStr, packageStr, signType, paySign, new c(callback));
        } else if (callback != null) {
            callback.onResult(-1, "empty appid");
        }
    }
}
