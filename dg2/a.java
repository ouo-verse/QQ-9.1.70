package dg2;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J0\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Ldg2/a;", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi;", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "goodsTokenUrl", "", "from", "payTypeId", "a2Key", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "payCallBack", "", "b", "", "isReleaseEnv", "loggable", "init", OpenConstants.ApiName.PAY, "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECPayApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Ldg2/a$b;", "Lcom/tencent/midas/api/IMidasLogCallback;", "", "type", "", "tag", "msg", "", "onLogging", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class b implements IMidasLogCallback {
        @Override // com.tencent.midas.api.IMidasLogCallback
        public void onLogging(int type, String tag, String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (type == 3) {
                QLog.i(tag, 1, msg2);
                return;
            }
            if (type == 4) {
                QLog.w(tag, 1, msg2);
            } else if (type != 5) {
                QLog.d(tag, 2, msg2);
            } else {
                QLog.e(tag, 1, msg2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"dg2/a$c", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements MainTicketCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f393733b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f393734c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f393735d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f393736e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IECPayApi.ECPayCallback f393737f;

        c(Context context, String str, int i3, int i16, IECPayApi.ECPayCallback eCPayCallback) {
            this.f393733b = context;
            this.f393734c = str;
            this.f393735d = i3;
            this.f393736e = i16;
            this.f393737f = eCPayCallback;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, String errorMsg) {
            QLog.e("ECMidasApi", 1, "[pay] get async ticket fail, errorCode:" + errorCode + ", errorMsg:" + errorMsg);
            a.this.b(this.f393733b, this.f393734c, this.f393735d, this.f393736e, "", this.f393737f);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo info) {
            QLog.i("ECMidasApi", 1, "[pay] get async ticket suc");
            a aVar = a.this;
            Context context = this.f393733b;
            String str = this.f393734c;
            int i3 = this.f393735d;
            int i16 = this.f393736e;
            String a26 = info != null ? info.getA2() : null;
            if (a26 == null) {
                a26 = "";
            }
            aVar.b(context, str, i3, i16, a26, this.f393737f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"dg2/a$d", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "", "MidasPayNeedLogin", "Lcom/tencent/midas/api/APMidasResponse;", "rsp", "MidasPayCallBack", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements IAPMidasPayCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECPayApi.ECPayCallback f393738a;

        d(IECPayApi.ECPayCallback eCPayCallback) {
            this.f393738a = eCPayCallback;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse rsp) {
            int i3 = rsp != null ? rsp.resultCode : -1;
            int i16 = rsp != null ? rsp.payState : -1;
            int i17 = rsp != null ? rsp.payChannel : -1;
            String str = rsp != null ? rsp.resultMsg : null;
            if (str == null) {
                str = "rsp is null";
            }
            this.f393738a.onPayResult(new IECPayApi.PayResult(i3, i16, i17, str));
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            this.f393738a.onPayNeedLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Context activity, String goodsTokenUrl, int from, int payTypeId, String a2Key, IECPayApi.ECPayCallback payCallBack) {
        Activity a16 = af2.b.f25996a.a(activity);
        APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
        aPMidasGoodsRequest.setOfferId("1450039816");
        aPMidasGoodsRequest.setOpenId(String.valueOf(ECRuntimeManager.INSTANCE.e()));
        aPMidasGoodsRequest.setOpenKey(a2Key);
        aPMidasGoodsRequest.setSessionId("uin");
        aPMidasGoodsRequest.setSessionType("a2_key");
        aPMidasGoodsRequest.setPf("qq_m_qq-2001-android");
        aPMidasGoodsRequest.setPfKey("pfKey");
        aPMidasGoodsRequest.setZoneId("1");
        aPMidasGoodsRequest.setTokenType(1);
        aPMidasGoodsRequest.setGoodsTokenUrl(goodsTokenUrl);
        aPMidasGoodsRequest.setShowNum(false);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ecpay_support_qqpay", false) && payTypeId == 3) {
            QLog.i("ECMidasApi", 1, "ecpay support qqpay");
            aPMidasGoodsRequest.reserv = "payment_method=PAYMENT_METHOD_QQ_APP";
        } else {
            aPMidasGoodsRequest.setPayChannel("wechat");
        }
        APMidasPayAPI.init(a16, aPMidasGoodsRequest);
        APMidasPayAPI.launchPay(a16, aPMidasGoodsRequest, new d(payCallBack));
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    public void init(Context activity, boolean isReleaseEnv, boolean loggable) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        af2.b.f25996a.a(activity);
        if (isReleaseEnv) {
            str = "release";
        } else {
            str = "test";
        }
        APMidasPayAPI.setEnv(str);
        APMidasPayAPI.setLogEnable(loggable && QLog.isColorLevel());
        APMidasPayAPI.setLogCallback(b.class);
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi
    public void pay(Context activity, String goodsTokenUrl, int from, int payTypeId, IECPayApi.ECPayCallback payCallBack) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(goodsTokenUrl, "goodsTokenUrl");
        Intrinsics.checkNotNullParameter(payCallBack, "payCallBack");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Manager manager = runtime != null ? runtime.getManager(2) : null;
        TicketManager ticketManager = manager instanceof TicketManager ? (TicketManager) manager : null;
        boolean z16 = false;
        if (ticketManager != null && ticketManager.useAsyncTicketInterface()) {
            z16 = true;
        }
        if (z16) {
            ticketManager.getA2(ECRuntimeManager.INSTANCE.e(), 16, new c(activity, goodsTokenUrl, from, payTypeId, payCallBack));
            return;
        }
        QLog.i("ECMidasApi", 1, "[pay] get sync ticket");
        String a26 = ticketManager != null ? ticketManager.getA2(ECRuntimeManager.INSTANCE.a()) : null;
        b(activity, goodsTokenUrl, from, payTypeId, a26 == null ? "" : a26, payCallBack);
    }
}
