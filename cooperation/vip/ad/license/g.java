package cooperation.vip.ad.license;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import cooperation.vip.tianshu.TianShuMMKVUtil;
import cooperation.vip.tianshu.bean.TSSplashUserAction;
import tianshu.TianShuQuantityLimit$GetAdLicenseRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {

    /* renamed from: e, reason: collision with root package name */
    private static volatile g f391186e;

    /* renamed from: a, reason: collision with root package name */
    private final b f391187a;

    /* renamed from: b, reason: collision with root package name */
    private final a f391188b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f391189c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler.Callback f391190d;

    g() {
        Handler.Callback callback = new Handler.Callback() { // from class: cooperation.vip.ad.license.d
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean m3;
                m3 = g.this.m(message);
                return m3;
            }
        };
        this.f391190d = callback;
        this.f391187a = new b();
        this.f391188b = new a();
        this.f391189c = RFWThreadManager.createNewThreadHandler("QSplash@-TSL-TianShuSplashLicenseManager", 0, callback);
    }

    public static g g() {
        if (f391186e == null) {
            synchronized (g.class) {
                if (f391186e == null) {
                    f391186e = new g();
                }
            }
        }
        return f391186e;
    }

    private void h(boolean z16, long j3, TianShuQuantityLimit$GetAdLicenseRsp tianShuQuantityLimit$GetAdLicenseRsp) {
        if (z16 && j3 == 0 && tianShuQuantityLimit$GetAdLicenseRsp != null) {
            this.f391188b.c(tianShuQuantityLimit$GetAdLicenseRsp.ad_licenses.get());
            n(tianShuQuantityLimit$GetAdLicenseRsp.minIntervalSecs.get());
        } else {
            QLog.e("QSplash@-TSL-TianShuSplashLicenseManager", 1, "handleAdLicenseRsp  rsp error");
        }
    }

    private void i(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof TSSplashUserAction) {
                TSSplashUserAction tSSplashUserAction = (TSSplashUserAction) obj;
                QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "handleAddSplashUserAction  userAction = " + tSSplashUserAction.toString());
                this.f391187a.b(tSSplashUserAction);
            }
        }
    }

    private void j() {
        QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "triggerAdSplashLicense");
        if (QzoneConfig.getInstance().getConfig("qqsetting", QzoneConfig.SECONDARY_DOBHE_SPLASH_PLAY_CONTROL_REQUEST_SHOULD_CLOSE, 0) == 1) {
            f();
            QLog.w("QSplash@-TSL-TianShuSplashLicenseManager", 1, "handleRequestAdSplashLicenseMessage  wns isClose = 1, close adSplashLicense, return");
        } else if (bl.b(com.tencent.mobileqq.vassplash.common.c.j(BaseApplication.getContext(), ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()))) {
            f();
            QLog.w("QSplash@-TSL-TianShuSplashLicenseManager", 1, "handleRequestAdSplashLicenseMessage  localIds is empty, return");
        } else {
            TianShuAdLicenseRequest tianShuAdLicenseRequest = new TianShuAdLicenseRequest(this.f391187a.c());
            QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "triggerAdSplashLicense request...");
            VSNetworkHelper.getInstance().sendRequest(tianShuAdLicenseRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: cooperation.vip.ad.license.e
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    g.this.l(baseRequest, z16, j3, str, (TianShuQuantityLimit$GetAdLicenseRsp) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(boolean z16, BaseRequest baseRequest, long j3, String str, TianShuQuantityLimit$GetAdLicenseRsp tianShuQuantityLimit$GetAdLicenseRsp) {
        QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "triggerAdSplashLicense responseLog  | isSuccess:" + z16 + " | cmd:" + baseRequest.getCmd() + " | traceId = " + baseRequest.getTraceId() + " | seqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        h(z16, j3, tianShuQuantityLimit$GetAdLicenseRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(final BaseRequest baseRequest, final boolean z16, final long j3, final String str, final TianShuQuantityLimit$GetAdLicenseRsp tianShuQuantityLimit$GetAdLicenseRsp) {
        this.f391189c.post(new Runnable() { // from class: cooperation.vip.ad.license.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.k(z16, baseRequest, j3, str, tianShuQuantityLimit$GetAdLicenseRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            i(message);
            return true;
        }
        j();
        return true;
    }

    private void n(int i3) {
        QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "updateMinIntervalSecsTime  minIntervalSecs = " + i3);
        if (i3 <= 0) {
            return;
        }
        o(i3, "polling");
    }

    public void d(String str, int i3) {
        Message message = new Message();
        message.what = 2;
        TSSplashUserAction tSSplashUserAction = new TSSplashUserAction(str, i3);
        tSSplashUserAction.setActionTime(NetConnInfoCenter.getServerTime());
        message.obj = tSSplashUserAction;
        this.f391189c.sendMessage(message);
    }

    public boolean e(String str) {
        boolean a16 = this.f391188b.a(str);
        QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "canShowSplashAd   | adId = " + str + " | canShow = " + a16);
        return a16;
    }

    public void f() {
        long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
        TianShuMMKVUtil.g(i3 + "").removeKey(TianShuMMKVConstant.SplashKey.TS_SPLASH_USER_ACTION_INFO);
        TianShuMMKVUtil.g(i3 + "").removeKey(TianShuMMKVConstant.SplashKey.TS_SPLASH_AD_LICENSE_INFO);
        QLog.d("QSplash@-TSL-TianShuSplashLicenseManager", 1, "clearLocalAdLicenseInfo  clear userAction and ad licenseInfo");
    }

    public void o(int i3, String str) {
        QLog.i("QSplash@-TSL-TianShuSplashLicenseManager", 1, "triggerRequestAdSplashLicense  | delayTimeSecs = " + i3 + " | reqType = " + str);
        if (i3 <= 0) {
            return;
        }
        this.f391189c.removeMessages(1);
        this.f391189c.sendEmptyMessageDelayed(1, i3 * 1000);
    }
}
