package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StatusJsHandler extends a.b {
    static IPatchRedirector $redirector_;
    boolean C;
    String D;
    String E;
    private BusinessObserver F;
    private BusinessObserver G;

    /* renamed from: d, reason: collision with root package name */
    WeakReference<BaseActivity> f282256d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<WebView> f282257e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f282258f;

    /* renamed from: h, reason: collision with root package name */
    public String f282259h;

    /* renamed from: i, reason: collision with root package name */
    IPublicAccountDetail f282260i;

    /* renamed from: m, reason: collision with root package name */
    boolean f282261m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusJsHandler.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            BaseActivity baseActivity = StatusJsHandler.this.f282256d.get();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.RICH_STATUS, 2, "success:" + String.valueOf(z16));
                }
                if (!z16) {
                    StatusJsHandler.this.b(R.string.d6b);
                } else {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                            mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                            if (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                                IPublicAccountDetail iPublicAccountDetail = StatusJsHandler.this.f282260i;
                                if (iPublicAccountDetail == null || iPublicAccountDetail != null) {
                                    IPublicAccountDetail iPublicAccountDetail2 = (IPublicAccountDetail) QRoute.api(IPublicAccountDetail.class);
                                    iPublicAccountDetail2.init(mobileqq_mp_getpublicaccountdetailinforesponse);
                                    StatusJsHandler.this.e(baseActivity, iPublicAccountDetail2);
                                    StatusJsHandler statusJsHandler = StatusJsHandler.this;
                                    statusJsHandler.f(baseActivity, statusJsHandler.f282260i.getUin());
                                    return;
                                }
                            } else {
                                StatusJsHandler.this.b(R.string.d6b);
                            }
                        } else {
                            StatusJsHandler.this.b(R.string.d6b);
                        }
                    } catch (Exception unused) {
                    }
                }
                StatusJsHandler statusJsHandler2 = StatusJsHandler.this;
                statusJsHandler2.c(statusJsHandler2.E, "false");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StatusJsHandler.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            BaseActivity baseActivity = StatusJsHandler.this.f282256d.get();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.RICH_STATUS, 2, "success:" + String.valueOf(z16));
                }
                if (!z16) {
                    StatusJsHandler.this.b(R.string.d6b);
                } else {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                            mobileqq_mp_followresponse.mergeFrom(byteArray);
                            if (mobileqq_mp_followresponse.ret_info.has() && mobileqq_mp_followresponse.ret_info.get().ret_code.has()) {
                                i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                            } else {
                                i16 = -1;
                            }
                            if (i16 == 0) {
                                StatusJsHandler.this.f282260i.setFollowType(1);
                                StatusJsHandler statusJsHandler = StatusJsHandler.this;
                                statusJsHandler.e(baseActivity, statusJsHandler.f282260i);
                                ((IPublicAccountHandler) baseActivity.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).onFollowPublicAccount(StatusJsHandler.this.f282260i);
                                ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getMenuSetting(baseActivity.getApplicationContext(), baseActivity.app, StatusJsHandler.this.f282260i.getUin(), null, true);
                                StatusJsHandler statusJsHandler2 = StatusJsHandler.this;
                                statusJsHandler2.c(statusJsHandler2.E, "true");
                                return;
                            }
                            if (i16 == 58) {
                                StatusJsHandler.this.b(R.string.d69);
                            } else if (i16 == 65) {
                                StatusJsHandler.this.b(R.string.d5i);
                            } else {
                                StatusJsHandler.this.b(R.string.d6b);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                StatusJsHandler statusJsHandler3 = StatusJsHandler.this;
                statusJsHandler3.c(statusJsHandler3.E, "false");
            }
        }
    }

    public StatusJsHandler(BaseActivity baseActivity, WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, webView, str);
            return;
        }
        this.f282260i = null;
        this.f282261m = false;
        this.C = false;
        this.F = new a();
        this.G = new b();
        this.f282256d = new WeakReference<>(baseActivity);
        this.f282257e = new WeakReference<>(webView);
        this.f282259h = str;
    }

    private void d(BaseActivity baseActivity, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.RICH_STATUS, 2, "sendDetailInfoRequest");
        }
        NewIntent newIntent = new NewIntent(baseActivity, ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(str));
            newIntent.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
            newIntent.setObserver(this.F);
            baseActivity.app.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.RICH_STATUS, 2, "sendDetailInfoRequest exit");
            }
        } catch (Exception unused) {
            c(this.E, "false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(BaseActivity baseActivity, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.RICH_STATUS, 2, "follow");
        }
        NewIntent newIntent = new NewIntent(baseActivity, ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
        newIntent.putExtra("cmd", "follow");
        mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
        try {
            mobileqq_mp_followrequest.uin.set((int) Long.parseLong(str));
            mobileqq_mp_followrequest.ext.set("0");
            newIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
            newIntent.setObserver(this.G);
            baseActivity.app.startServlet(newIntent);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(baseActivity.app, str, 0);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.RICH_STATUS, 2, "follow exit");
            }
        } catch (Exception unused) {
            c(this.E, "false");
        }
    }

    void b(int i3) {
        BaseActivity baseActivity = this.f282256d.get();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            QQToast.makeText(baseActivity, i3, 0).show(baseActivity.getTitleBarHeight());
        }
    }

    void c(String str, String str2) {
        BaseActivity baseActivity = this.f282256d.get();
        WebView webView = this.f282257e.get();
        if (str != null && baseActivity != null && !baseActivity.isFinishing() && webView != null) {
            if (this.f282258f == null) {
                this.f282258f = new Handler(Looper.getMainLooper());
            }
            this.f282258f.post(new Runnable(str, str2, webView) { // from class: com.tencent.mobileqq.richstatus.StatusJsHandler.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f282263d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f282264e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ WebView f282265f;

                {
                    this.f282263d = str;
                    this.f282264e = str2;
                    this.f282265f = webView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, StatusJsHandler.this, str, str2, webView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        this.f282265f.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f282263d + "(" + this.f282264e + ")");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (this.f282263d.equals(StatusJsHandler.this.E)) {
                        StatusJsHandler.this.f282261m = false;
                    } else if (this.f282263d.equals(StatusJsHandler.this.D)) {
                        StatusJsHandler.this.C = false;
                    }
                }
            });
        }
    }

    void e(BaseActivity baseActivity, IPublicAccountDetail iPublicAccountDetail) {
        EntityManager createEntityManager = baseActivity.app.getEntityManagerFactory().createEntityManager();
        IPublicAccountDetail iPublicAccountDetail2 = this.f282260i;
        if (iPublicAccountDetail2 != null && iPublicAccountDetail2.getId() != -1) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.RICH_STATUS, 2, iPublicAccountDetail.getName());
            }
            this.f282260i.clone(iPublicAccountDetail);
            if (!createEntityManager.update(this.f282260i.getEntity())) {
                createEntityManager.drop((Class<? extends Entity>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class));
            }
        } else {
            this.f282260i = iPublicAccountDetail;
            createEntityManager.persist(iPublicAccountDetail.getEntity());
        }
        createEntityManager.close();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) baseActivity.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            iPublicAccountDataManager.saveAccountDetailInfoCache(iPublicAccountDetail);
        }
    }

    public void followAccount(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        BaseActivity baseActivity = this.f282256d.get();
        if (baseActivity == null || this.f282261m) {
            return;
        }
        this.f282261m = true;
        this.E = str2;
        EntityManager createEntityManager = baseActivity.app.getEntityManagerFactory().createEntityManager();
        IPublicAccountDetail iPublicAccountDetail = (IPublicAccountDetail) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), str);
        createEntityManager.close();
        if (iPublicAccountDetail != null) {
            f(baseActivity, str);
        } else {
            d(baseActivity, str);
        }
    }

    public void getLocation(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        BaseActivity baseActivity = this.f282256d.get();
        if (baseActivity == null || this.C) {
            return;
        }
        this.C = true;
        this.D = str;
        LocationManager locationManager = (LocationManager) baseActivity.getSystemService("location");
        if (locationManager == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable(locationManager) { // from class: com.tencent.mobileqq.richstatus.StatusJsHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LocationManager f282262d;

            {
                this.f282262d = locationManager;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StatusJsHandler.this, (Object) locationManager);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Criteria criteria = new Criteria();
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                try {
                    try {
                        criteria.setAccuracy(1);
                        Location lastKnownLocation = LocationMonitor.getLastKnownLocation(this.f282262d, this.f282262d.getBestProvider(criteria, true));
                        StatusJsHandler statusJsHandler = StatusJsHandler.this;
                        statusJsHandler.c(statusJsHandler.D, lastKnownLocation.getLongitude() + "," + lastKnownLocation.getLatitude());
                    } catch (Exception unused) {
                        criteria.setAccuracy(2);
                        Location lastKnownLocation2 = LocationMonitor.getLastKnownLocation(this.f282262d, this.f282262d.getBestProvider(criteria, true));
                        StatusJsHandler statusJsHandler2 = StatusJsHandler.this;
                        statusJsHandler2.c(statusJsHandler2.D, lastKnownLocation2.getLongitude() + "," + lastKnownLocation2.getLatitude());
                    }
                } catch (Exception unused2) {
                    StatusJsHandler statusJsHandler3 = StatusJsHandler.this;
                    statusJsHandler3.c(statusJsHandler3.D, "0, 0");
                }
            }
        }, 5, null, false);
    }

    public boolean hasFollowAccount(String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        BaseActivity baseActivity = this.f282256d.get();
        if (baseActivity == null || (iPublicAccountDataManager = (IPublicAccountDataManager) baseActivity.app.getRuntimeService(IPublicAccountDataManager.class, "all")) == null || ((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str)) == null) {
            return false;
        }
        return true;
    }

    public void setData(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        BaseActivity baseActivity = this.f282256d.get();
        if (baseActivity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(SignJsPlugin.PARAM_DATA_TEXT, str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(SignJsPlugin.PARAM_DATA_ID, Long.valueOf(str2));
        }
        baseActivity.setResult(-1, intent);
        baseActivity.finish();
    }
}
