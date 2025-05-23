package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import sk2.WalletConstantsConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\r\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qrcode/processor/QWalletNativePayQRProcessor;", "Lcom/tencent/biz/qrcode/processor/BaseQRScanResultProcessor;", "", "", DomainData.DOMAIN_NAME, "", "type", "result", "qBarType", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "", "a", "k", "getName", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qrscan/k;", "onQRHandleResultCallback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "c", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class QWalletNativePayQRProcessor extends BaseQRScanResultProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletNativePayQRProcessor(AppRuntime appRuntime, k onQRHandleResultCallback) {
        super(appRuntime, onQRHandleResultCallback);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(onQRHandleResultCallback, "onQRHandleResultCallback");
    }

    private final List<String> n() {
        boolean z16 = true;
        List<String> b16 = ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().b();
        List<String> list = b16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        }
        return z16 ? WalletConstantsConfig.INSTANCE.a() : b16;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "QWalletNativePayQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean k(String result, String qBarType, ScannerParams scannerParams) {
        if (result == null) {
            QLog.i("QWalletNativePayQRProcessor", 1, "scanUrl is null");
            return false;
        }
        Context context = this.f94980b.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            QLog.i("QWalletNativePayQRProcessor", 1, "context is not activity: " + this.f94980b.getContext());
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("pay_requestcode", 15);
        intent.putExtra(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 11);
        intent.putExtra(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 5);
        intent.putExtra("payparmas_native_url", result);
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 25);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
        this.f94980b.finish();
        return true;
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int type, String result, String qBarType, ScannerParams scannerParams) {
        boolean startsWith$default;
        boolean z16;
        boolean z17 = false;
        if (result != null) {
            String lowerCase = result.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (lowerCase != null) {
                List<String> n3 = n();
                if (m(type)) {
                    List<String> list = n3;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            String lowerCase2 = ((String) it.next()).toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, lowerCase2, false, 2, null);
                            if (startsWith$default) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                        z17 = true;
                    }
                }
                QLog.d("QWalletNativePayQRProcessor", 1, "intercept=" + z17 + ", type=" + type + ", prefixUrls=" + n3);
            }
        }
        return z17;
    }
}
