package com.tencent.mobileqq.vip.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J:\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipPayApiImpl;", "Lcom/tencent/mobileqq/vip/api/IVipPayApi;", "Landroid/os/Bundle;", "resultData", "Lcom/tencent/mobileqq/vip/api/k;", "callBackVip", "", "handlePayResult", "", "payJsonString", "", "invokerId", "url", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "newPay", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipPayApiImpl implements IVipPayApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "VAS_PAY";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipPayApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipPayApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50222);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VipPayApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePayResult(Bundle resultData, com.tencent.mobileqq.vip.api.k callBackVip) {
        int i3;
        String msg2;
        try {
            JSONObject jSONObject = new JSONObject(resultData.getString("result"));
            if (jSONObject.has(QzoneIPCModule.RESULT_CODE)) {
                i3 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
            } else {
                i3 = -1;
            }
            if (jSONObject.has("resultMsg")) {
                msg2 = jSONObject.getString("resultMsg");
            } else {
                msg2 = jSONObject.optString("retmsg", "");
            }
            if (i3 != -1) {
                if (i3 != 0) {
                    if (callBackVip != null) {
                        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                        callBackVip.c(i3, msg2);
                        return;
                    }
                    return;
                }
                if (callBackVip != null) {
                    callBackVip.a(i3);
                    return;
                }
                return;
            }
            if (callBackVip != null) {
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                callBackVip.c(i3, msg2);
            }
        } catch (JSONException e16) {
            QLog.e("VAS_PAY", 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipPayApi
    public void newPay(@NotNull String payJsonString, int invokerId, @NotNull String url, @NotNull String reportAction, @NotNull Activity activity, @Nullable final com.tencent.mobileqq.vip.api.k callBackVip) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, payJsonString, Integer.valueOf(invokerId), url, reportAction, activity, callBackVip);
            return;
        }
        Intrinsics.checkNotNullParameter(payJsonString, "payJsonString");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(reportAction, "reportAction");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (QLog.isColorLevel()) {
            QLog.i("VAS_PAY", 2, "params:" + payJsonString);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, payJsonString);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 5);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, currentTimeMillis);
        bundle.putString("payparmas_h5_url", url);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        AppInterface appInterface2 = appInterface;
        if (appInterface2 == null) {
            return;
        }
        final Handler handler = new Handler();
        ((IPayLogic) QRoute.api(IPayLogic.class)).newPay(appInterface2, activity, new ResultReceiver(callBackVip, handler) { // from class: com.tencent.mobileqq.vip.api.impl.VipPayApiImpl$newPay$resultReceiver$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.vip.api.k f312850e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(handler);
                this.f312850e = callBackVip;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VipPayApiImpl.this, callBackVip, handler);
                }
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, resultCode, (Object) resultData);
                } else {
                    Intrinsics.checkNotNullParameter(resultData, "resultData");
                    VipPayApiImpl.this.handlePayResult(resultData, this.f312850e);
                }
            }
        }, invokerId, bundle);
    }
}
