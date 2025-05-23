package com.tencent.mobileqq.vasgift.api.impl.service;

import android.app.Activity;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.vasgift.utils.k;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.auth.AuthScene;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import oh2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements IQQGiftRechargeModule {

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, String> f311459g;

    /* renamed from: a, reason: collision with root package name */
    private nh2.c f311460a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, IQQGiftRechargeCallback> f311461b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, WeakReference<IVasNativePayManager.PayObserver>> f311462c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private String f311463d;

    /* renamed from: e, reason: collision with root package name */
    private long f311464e;

    /* renamed from: f, reason: collision with root package name */
    private long f311465f;

    static {
        HashMap hashMap = new HashMap();
        f311459g = hashMap;
        hashMap.put(HippyQQConstants.HIPPY_CHANNEL, "1002");
        f311459g.put("10002", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
        f311459g.put("10003", PluginJumpManager.CONFIG_BID);
        f311459g.put("10004", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR);
        f311459g.put("10005", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR);
        f311459g.put("10006", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
        f311459g.put("10007", PluginJumpManager.CONFIG_BID);
        f311459g.put("10008", AppConstants.GRAY_TIP_BUSI_ID);
        f311459g.put("10010", "1003");
        f311459g.put("10011", "1002");
        f311459g.put("10013", AppConstants.GRAY_TIP_BUSI_ID);
        f311459g.put("10014", AppConstants.GRAY_TIP_BUSI_ID);
        f311459g.put("10015", HippyQQConstants.HIPPY_BID);
        f311459g.put("10016", QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED);
    }

    private static String a0(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return str + ContainerUtils.FIELD_DELIMITER + str2;
            }
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str;
    }

    private String b0(Map<String, String> map) {
        StringBuilder sb5 = new StringBuilder();
        if (map == null) {
            return sb5.toString();
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        int size = entrySet.size();
        int i3 = 0;
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb5.append(key);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(c0(value));
            i3++;
            if (i3 < size) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb5.toString();
    }

    private String c0(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            QLog.e("QQGiftRechargeModuleImpl", 1, "encode url param: " + str + " failed.");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Activity activity, int i3, boolean z16, IQQGiftRechargeCallback iQQGiftRechargeCallback, boolean z17, boolean z18, int i16, String str) {
        if (z18) {
            h0(activity, i3, z16, iQQGiftRechargeCallback);
            return;
        }
        QLog.e("QQGiftRechargeModuleImpl", 1, "\u672a\u6210\u5e74\u4eba\u8ba4\u8bc1\u5931\u8d25" + i16 + ", " + str);
        if (i16 == -11153) {
            if (!z17) {
                h0(activity, i3, z16, iQQGiftRechargeCallback);
                return;
            } else {
                QQToast.makeText(BaseApplication.getContext(), "\u672a\u5b9e\u540d\u8ba4\u8bc1", 1).show();
                return;
            }
        }
        if (i16 == -11154) {
            QQToast.makeText(BaseApplication.getContext(), "\u672a\u6ee118\u5468\u5c81\u5145\u503c\u529f\u80fd\u6682\u4e0d\u53ef\u7528", 1).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), str, 1).show();
        }
    }

    private void h0(Activity activity, int i3, boolean z16, IQQGiftRechargeCallback iQQGiftRechargeCallback) {
        String str;
        String str2;
        String str3;
        if (z16) {
            QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f209905go), 0).show();
        }
        if (e0() && ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).isSwitchEnable()) {
            String str4 = "0";
            if (iQQGiftRechargeCallback.a().get("qqlive_subscene_id") == null) {
                str = "0";
            } else {
                str = iQQGiftRechargeCallback.a().get("qqlive_subscene_id");
            }
            String valueOf = String.valueOf(this.f311460a.getSDKConfig().f264972a);
            if (this.f311460a.a() != null) {
                valueOf = String.valueOf(this.f311460a.a().c());
            }
            if (f311459g.get(valueOf) != null) {
                str2 = f311459g.get(valueOf);
            } else {
                str2 = this.f311460a.getSDKConfig().f264978g;
            }
            if (iQQGiftRechargeCallback.a().get("main_recharge_id") == null) {
                str3 = "0";
            } else {
                str3 = iQQGiftRechargeCallback.a().get("main_recharge_id");
            }
            if (iQQGiftRechargeCallback.a().get("sub_recharge_id") != null) {
                str4 = iQQGiftRechargeCallback.a().get("sub_recharge_id");
            }
            IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData(str2, str, String.valueOf(i3), "0_0_" + str3 + "_" + str4);
            reportData.mDtData = iQQGiftRechargeCallback.a();
            ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(activity, IVasNativePayManager.TITLE_RECHARGE, "", reportData, new a(i3, iQQGiftRechargeCallback));
            return;
        }
        g0(i3, iQQGiftRechargeCallback);
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public void I(final Activity activity, final int i3, final boolean z16, final IQQGiftRechargeCallback iQQGiftRechargeCallback) {
        boolean isEnable;
        k kVar = k.f312037a;
        if (kVar.a(this.f311460a)) {
            isEnable = kVar.b(AuthScene.RECHARGE);
        } else {
            isEnable = VasToggle.VAS_RECHARGE_AUTH_ENABLE.isEnable(false);
        }
        if (activity != null) {
            final boolean z17 = isEnable;
            this.f311460a.e().m(activity, isEnable, new c.a() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.a
                @Override // oh2.c.a
                public final void a(boolean z18, int i16, String str) {
                    b.this.f0(activity, i3, z16, iQQGiftRechargeCallback, z17, z18, i16, str);
                }
            });
        }
    }

    @Override // nh2.a
    public void N(nh2.c cVar) {
        this.f311460a = cVar;
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public String U(String str) {
        if (TextUtils.isEmpty(f311459g.get(str))) {
            return "0";
        }
        return f311459g.get(str);
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public void a(int i3, boolean z16, int i16, String str) {
        IQQGiftRechargeCallback remove;
        ConcurrentHashMap<Integer, IQQGiftRechargeCallback> concurrentHashMap = this.f311461b;
        if (concurrentHashMap != null && (remove = concurrentHashMap.remove(Integer.valueOf(i3))) != null) {
            remove.b(z16, i16, str);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public void d(long j3, long j16) {
        this.f311464e = j3;
        this.f311465f = j16;
    }

    public String d0() {
        return this.f311463d;
    }

    @Override // nh2.a
    public void destroy() {
        ConcurrentHashMap<Integer, IQQGiftRechargeCallback> concurrentHashMap = this.f311461b;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<Integer, WeakReference<IVasNativePayManager.PayObserver>> concurrentHashMap2 = this.f311462c;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public boolean e0() {
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) com.tencent.mobileqq.qqgift.utils.a.a().getRuntimeService(IFeatureRuntimeService.class, "all");
        if (iFeatureRuntimeService == null) {
            return false;
        }
        return iFeatureRuntimeService.isFeatureSwitchEnable("live_recharge_panel_switch");
    }

    public void g0(@IQQGiftRechargeModule.RechargeSource int i3, IQQGiftRechargeCallback iQQGiftRechargeCallback) {
        nh2.c cVar = this.f311460a;
        if (cVar != null && !cVar.isDestroyed()) {
            if (iQQGiftRechargeCallback == null) {
                QLog.w("QQGiftRechargeModuleImpl", 1, "onRecharge: callback == null");
                return;
            }
            String a06 = a0(a0("https://qlive.qq.com/v2/vip/live/qlive-h5/pages/charge.html?qq_gift_app_id={qq_gift_app_id}&source={source}&asyncMode=3".replace("{qq_gift_app_id}", String.valueOf(this.f311460a.getSDKConfig().f264972a)).replace("{source}", String.valueOf(i3)), b0(iQQGiftRechargeCallback.a())), d0());
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftRechargeModuleImpl", 2, "onRecharge url:" + a06);
            }
            int hashCode = iQQGiftRechargeCallback.hashCode();
            QQGiftHalfTranslucentBrowserActivity.S2(this.f311460a.getAppRuntime().getApplicationContext(), a06, hashCode, this.f311460a.getSDKConfig().f264972a);
            ConcurrentHashMap<Integer, IQQGiftRechargeCallback> concurrentHashMap = this.f311461b;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(Integer.valueOf(hashCode), iQQGiftRechargeCallback);
                return;
            }
            return;
        }
        QLog.e("QQGiftRechargeModuleImpl", 1, "onRecharge sdk state error! sdk:" + this.f311460a);
        iQQGiftRechargeCallback.b(false, 99998, "sdk\u72b6\u6001\u5f02\u5e38!");
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public void k(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            this.f311463d = b0(hashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public long s() {
        return this.f311464e;
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public long u() {
        return this.f311465f;
    }

    @Override // com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule
    public void y(IVasNativePayManager.PayObserver payObserver) {
        if (payObserver == null) {
            return;
        }
        this.f311462c.put(Integer.valueOf(payObserver.hashCode()), new WeakReference<>(payObserver));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IVasNativePayManager.PayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f311466a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IQQGiftRechargeCallback f311467b;

        a(int i3, IQQGiftRechargeCallback iQQGiftRechargeCallback) {
            this.f311466a = i3;
            this.f311467b = iQQGiftRechargeCallback;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            b.this.g0(this.f311466a, this.f311467b);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            this.f311467b.b(true, 0, "");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            IVasNativePayManager.PayObserver payObserver;
            for (WeakReference weakReference : b.this.f311462c.values()) {
                if (weakReference != null && (payObserver = (IVasNativePayManager.PayObserver) weakReference.get()) != null) {
                    payObserver.onPayViewClose();
                }
            }
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int i3) {
        }
    }
}
