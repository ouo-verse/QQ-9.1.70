package mi0;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J%\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0097\u0001R\u0014\u0010\u000e\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lmi0/a;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "goodsTokenUrl", "", "from", "payTypeId", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "payCallBack", "", OpenConstants.ApiName.PAY, "", "isReleaseEnv", "loggable", "init", "a", "()Z", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a implements IECPayApi {

    /* renamed from: b, reason: collision with root package name */
    public static final a f416850b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IECPayApi f416851a = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPayApi();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"mi0/a$a", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "", "onPayNeedLogin", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "onPayResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: mi0.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10786a implements IECPayApi.ECPayCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f416852a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IECPayApi.ECPayCallback f416853b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f416854c;

        C10786a(int i3, IECPayApi.ECPayCallback eCPayCallback, long j3) {
            this.f416852a = i3;
            this.f416853b = eCPayCallback;
            this.f416854c = j3;
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
        public void onPayNeedLogin() {
            if (this.f416852a == 0) {
                i.f101155b.c(R.string.woz, ECToastIcon.ICON_ERROR, 0);
            }
            this.f416853b.onPayNeedLogin();
            com.tencent.ecommerce.biz.orders.buyerorders.submit.i.f103574a.a(new IECPayApi.PayResult(-1, -1, -1, "payNeedLogin"), SystemClock.uptimeMillis() - this.f416854c);
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
        public void onPayResult(IECPayApi.PayResult payResult) {
            if (this.f416852a == 0) {
                b.e(payResult);
            }
            this.f416853b.onPayResult(payResult);
            com.tencent.ecommerce.biz.orders.buyerorders.submit.i.f103574a.a(payResult, SystemClock.uptimeMillis() - this.f416854c);
        }
    }

    a() {
    }

    private final boolean a() {
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isPublicVersion()) {
            return true;
        }
        return IECLocalConfig.a.c(ECLocalConfig.f100650f, "is_release_env", true, null, 4, null);
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    public void init(Context activity, boolean isReleaseEnv, boolean loggable) {
        this.f416851a.init(activity, isReleaseEnv, loggable);
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    public void pay(Context activity, String goodsTokenUrl, int from, int payTypeId, IECPayApi.ECPayCallback payCallBack) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isPublicVersion() && qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isTestEnv() && a()) {
            i.f(i.f101155b, "\u5f53\u524d\u662f SSO \u6d4b\u8bd5\u73af\u5883\uff0c\u8bf7\u628a\u652f\u4ed8\u73af\u5883\u5207\u5230\u6c99\u7bb1\u73af\u5883\uff01", ECToastIcon.ICON_ERROR, 0, 4, null);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        init(activity, a(), true);
        qQEcommerceSdk.getGlobalInternalSdk().getPayApi().pay(activity, goodsTokenUrl, from, payTypeId, new C10786a(from, payCallBack, uptimeMillis));
    }
}
