package com.tencent.mobileqq.vas.pay.api.impl.helper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.vas.pay.api.impl.pbFile.midasPayCoinb$BuyGoodsRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class PayHelper {

    /* renamed from: a, reason: collision with root package name */
    private Handler f310128a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private String f310129b = VasNativePayManagerImpl.OFFER_ID_B_DEFAULT;

    /* renamed from: c, reason: collision with root package name */
    private IVasNativePayManager.ReportData f310130c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f310131d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public static class VasPayResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final b f310138d;

        public VasPayResultReceiver(Handler handler, b bVar) {
            super(handler);
            this.f310138d = bVar;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            PayHelper.e(bundle, this.f310138d);
        }
    }

    /* loaded from: classes20.dex */
    public static abstract class a<T> implements b {

        /* renamed from: a, reason: collision with root package name */
        private final String f310139a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<T> f310140b;

        public a(String str, T t16) {
            this.f310139a = str;
            this.f310140b = new WeakReference<>(t16);
        }

        @Nullable
        public T b() {
            return this.f310140b.get();
        }

        public void c() {
            QLog.i("PayHelper", 1, "from:" + this.f310139a);
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void a(int i3);

        void onPayError(int i3);
    }

    public PayHelper(IVasNativePayManager.ReportData reportData, Activity activity) {
        this.f310130c = reportData;
        this.f310131d = activity;
    }

    @NotNull
    private String d(IVasNativePayManager.ReportData reportData) {
        return "" + ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion() + "|" + VasNativePayManagerImpl.PAY_VERSION + "_" + reportData.mBusinessId + "_" + reportData.mSubBusinessId + "_" + reportData.mSource + "_" + reportData.mExt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Bundle bundle, b bVar) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(bundle.getString("result"));
            if (jSONObject.has(QzoneIPCModule.RESULT_CODE)) {
                i3 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
            } else {
                i3 = -1;
            }
            new HashMap().put("topup_status_info", Integer.valueOf(i3));
            if (i3 == -1) {
                bVar.onPayError(i3);
            } else if (i3 == 0) {
                bVar.a(i3);
            }
        } catch (JSONException e16) {
            QLog.e("PayHelper", 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Object obj, b bVar, boolean z16, String str) {
        if ((obj instanceof byte[]) && ((byte[]) obj).length != 0) {
            midasPayCoinb$BuyGoodsRsp midaspaycoinb_buygoodsrsp = new midasPayCoinb$BuyGoodsRsp();
            try {
                midaspaycoinb_buygoodsrsp.mergeFrom((byte[]) obj);
                String str2 = midaspaycoinb_buygoodsrsp.url_params.get();
                QLog.i("PayHelper", 1, "rsp : tokenUrl=" + str2);
                if (!TextUtils.isEmpty(str2)) {
                    i(str, str2, true, z16, bVar);
                } else {
                    bVar.onPayError(-1);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("PayHelper", 1, "", e16);
            }
        }
    }

    private void i(String str, String str2, boolean z16, boolean z17, b bVar) {
        String str3;
        int i3;
        String str4;
        String str5;
        AppInterface a16 = com.tencent.mobileqq.vas.pay.api.impl.helper.a.a();
        if (a16 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("callbackSn", "callbackSn");
        String str6 = ",userId : '" + a16.getCurrentAccountUin() + "'";
        String str7 = ",saveValue : '" + str + "'";
        String str8 = ",aid : '" + d(this.f310130c) + "'";
        if (!TextUtils.isEmpty(str2) && z16) {
            str4 = "offerId : '" + this.f310129b + "'";
            str3 = ",tokenUrl : '" + str2 + "'";
            str5 = ",numberVisible : false";
            i3 = 7;
        } else {
            str3 = "";
            i3 = 6;
            str4 = "offerId : '1450030730'";
            str5 = "";
        }
        if (z17) {
            str5 = ",numberVisible : true";
        }
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, "{" + str4 + str6 + str7 + ",isCanChange : false" + str8 + str3 + str5 + "}");
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 5);
        VasPayResultReceiver vasPayResultReceiver = new VasPayResultReceiver(new Handler(), bVar);
        if (this.f310131d != null) {
            ((IPayLogic) QRoute.api(IPayLogic.class)).newPay(a16, this.f310131d, vasPayResultReceiver, i3, bundle);
        }
    }

    public void g(String str, String str2, int i3, final String str3, final boolean z16, final b bVar) {
        int i16;
        this.f310129b = str;
        try {
            i16 = Integer.valueOf(this.f310130c.mBusinessId).intValue();
        } catch (NumberFormatException e16) {
            QLog.e("PayHelper", 1, "", e16);
            i16 = 0;
        }
        BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i17, boolean z17, final Object obj) {
                PayHelper.this.f310128a.post(new Runnable() { // from class: com.tencent.mobileqq.vas.pay.api.impl.helper.PayHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        PayHelper.this.f(obj, bVar, z16, str3);
                    }
                });
            }
        };
        f23.b.a().b(com.tencent.mobileqq.vas.pay.api.impl.helper.a.a(), i16, str2, i3, d(this.f310130c), businessObserver);
    }

    public void h(String str, boolean z16, b bVar) {
        i(str, null, false, z16, bVar);
    }
}
