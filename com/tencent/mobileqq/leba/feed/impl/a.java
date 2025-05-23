package com.tencent.mobileqq.leba.feed.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.h;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.leba.feed.LebaPluginFeedView;
import com.tencent.mobileqq.leba.feed.c;
import com.tencent.mobileqq.leba.feed.d;
import com.tencent.mobileqq.leba.more.LebaMoreFragment;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.view.LebaDrawablePreloadHelper;
import com.tencent.mobileqq.leba.view.LebaFeedItemPreLoader;
import com.tencent.mobileqq.leba.view.f;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements c, h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f240577a;

    /* renamed from: b, reason: collision with root package name */
    private QBaseActivity f240578b;

    /* renamed from: c, reason: collision with root package name */
    LebaRedTouchBase f240579c;

    /* renamed from: d, reason: collision with root package name */
    private LebaPluginFeedView f240580d;

    /* renamed from: e, reason: collision with root package name */
    private f f240581e;

    /* renamed from: f, reason: collision with root package name */
    private ResourcePluginListener f240582f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.feed.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7963a extends ResourcePluginListener {
        static IPatchRedirector $redirector_;

        C7963a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.observer.ResourcePluginListener
        public void c(byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
                return;
            }
            QLog.i("LebaPluginFeedController", 1, "ResourcePluginListener listener notify = " + ((int) b16));
            com.tencent.mobileqq.leba.core.b.c(1, "notifyLebaState state: " + ((int) b16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends LebaRedTouchBase {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f240584f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("leba_feed_redtouch_block_set_type", true);
            this.f240584f = isSwitchOn;
            QLog.i("Q.lebatab.LebaRedTouchBase", 1, "LebaFeedRedTouch switchBlockSetType" + isSwitchOn);
        }

        @Override // com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
        public BusinessInfoCheckUpdate.AppInfo c(AppRuntime appRuntime, String str) {
            PBUInt32Field pBUInt32Field;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) str);
            }
            if (!TextUtils.isEmpty(str) && String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_KANDIAN).equals(str)) {
                return null;
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, str);
            if (appInfo == null) {
                QLog.e("Q.lebatab.LebaRedTouchBase", 1, "getAppInfoByResId resId: " + str + " return null");
                return null;
            }
            if (appInfo.type != null) {
                ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).showOrHideBanner(str, RedTouch.hasRedTouch(appInfo), appInfo);
            }
            if (RedTouch.hasRedTouch(appInfo) && !TianshuRedTouch.INSTANCE.j()) {
                if (!this.f240584f && (pBUInt32Field = appInfo.type) != null) {
                    pBUInt32Field.set(0);
                }
                appInfo.red_display_info.red_type_info.clear();
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                appInfo.red_display_info.red_type_info.add(redTypeInfo);
            }
            return appInfo;
        }

        @Override // com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
        public void d(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) redTouch, (Object) appInfo);
            } else {
                redTouch.parseRedTouchInLebaTable(appInfo);
            }
        }
    }

    public a(Context context, AppRuntime appRuntime, QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appRuntime, qBaseActivity);
            return;
        }
        this.f240579c = new b();
        this.f240581e = new f();
        this.f240582f = new C7963a();
        this.f240577a = context;
        this.f240578b = qBaseActivity;
        LebaDrawablePreloadHelper.e();
        LebaFeedItemPreLoader.d(this.f240581e);
        View findViewById = qBaseActivity.findViewById(R.id.root);
        if (findViewById instanceof ViewGroup) {
            LebaFeedItemPreLoader.e((ViewGroup) findViewById);
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f240580d == null) {
            this.f240580d = new LebaPluginFeedView(this.f240577a);
        }
        return this.f240580d;
    }

    @Override // com.tencent.mobileqq.leba.entity.h
    public void b(View view, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, (Object) nVar);
        } else {
            QLog.i("LebaPluginFeedController", 1, "onMoreClick");
            QPublicFragmentActivity.start(this.f240577a, LebaMoreFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.h
    public void c(View view, n nVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, view, nVar, Integer.valueOf(i3));
            return;
        }
        QLog.i("LebaPluginFeedController", 1, "onPluginClick position=" + i3);
        new com.tencent.mobileqq.leba.entity.f().f240480d = true;
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.i("LebaPluginFeedController", 1, "onTabClick");
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            QLog.i("LebaPluginFeedController", 1, "reloadData");
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, "onAccountChanged");
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.f();
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, "onCreate");
        ILebaHelperService iLebaHelperService = (ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI);
        iLebaHelperService.initLebaHelper();
        iLebaHelperService.addLebaListener(this.f240582f);
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.g();
            this.f240580d.e();
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).removeLebaListener(this.f240582f);
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.m();
            this.f240580d.h();
        }
        LebaDrawablePreloadHelper.b();
        LebaFeedItemPreLoader.f(this.f240581e);
        ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).onDestory();
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.f240579c.h(MobileQQ.sMobileQQ.peekAppRuntime());
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.i();
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, "onPostThemeChanged");
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.k();
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("LebaPluginFeedController", 1, "onResume");
        d.d(true);
        e(true);
        ((ILebaHelperService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ILebaHelperService.class, ProcessConstant.MULTI)).checkModleAndRefesh();
        LebaPluginFeedView lebaPluginFeedView = this.f240580d;
        if (lebaPluginFeedView != null) {
            lebaPluginFeedView.l(false);
        }
    }

    @Override // com.tencent.mobileqq.leba.feed.c
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.i("LebaPluginFeedController", 1, DKHippyEvent.EVENT_STOP);
        }
    }
}
