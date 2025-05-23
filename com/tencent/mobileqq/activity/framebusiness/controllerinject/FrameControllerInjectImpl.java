package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.w;
import com.tencent.mobileqq.activity.home.x;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.widget.bn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.robot.api.IRobotPersonalInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FrameControllerInjectImpl implements x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.home.impl.d f182331a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameControllerInjectImpl.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FrameControllerInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean s() {
        IFeatureServiceProxy iFeatureServiceProxy = (IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class);
        if (!iFeatureServiceProxy.isAppRuntimeNull() && !iFeatureServiceProxy.isFeatureSwitchOn("is_init_tab_enabled")) {
            return false;
        }
        return true;
    }

    private void t(FrameFragment frameFragment) {
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.recoverTabBluer");
        View view = frameFragment.mRootView;
        if (view != null && frameFragment.mTabIndicator != null) {
            View findViewById = view.findViewById(af.b());
            QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) frameFragment.mRootView.findViewById(R.id.kmr);
            frameFragment.mTabBlurView = qQBlurViewWrapper;
            ViewGroup viewGroup = frameFragment.mTabWidget;
            if (qQBlurViewWrapper != null && findViewById != null) {
                qQBlurViewWrapper.setDebugTag("TAB");
                frameFragment.mTabBlurView.setVisibility(8);
                frameFragment.mTabBlurView.onPause();
                frameFragment.mTabBlurView.onDestroy();
                if (frameFragment.enableBlur()) {
                    frameFragment.enableBlur(viewGroup, findViewById);
                    frameFragment.resumeTabBlur();
                    QLog.d("FrameUtil.FrameControllerInjectImpl", 1, "resume tab blur");
                } else {
                    frameFragment.disableBlur(viewGroup);
                    frameFragment.pauseTabBlur();
                    QLog.d("FrameUtil.FrameControllerInjectImpl", 1, "pause tab Blur");
                }
                com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.recoverTabBluer");
                return;
            }
            QLog.d("FrameUtil.FrameControllerInjectImpl", 1, " recoverTabBluer return blurView empty");
            com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.recoverTabBluer");
            return;
        }
        QLog.d("FrameUtil.FrameControllerInjectImpl", 1, " recoverTabBluer return UI empty");
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.recoverTabBluer");
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void a(FrameFragment frameFragment, Intent intent, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, frameFragment, intent, bundle, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.activity.home.framejumpentry.a.h().g(frameFragment, intent, bundle, i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void b(QUIBadge qUIBadge, int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, qUIBadge, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            com.tencent.widget.d.a(qUIBadge, i16, i3, i17, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void c(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, ArrayList<w> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tabFrameControllerImpl, frameFragment, arrayList);
            return;
        }
        if (frameFragment.mIsFirst) {
            ((MainFragment) frameFragment).f182811s0.I();
            frameFragment.mIsFirst = false;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList, tabFrameControllerImpl, frameFragment) { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ArrayList f182332d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TabFrameControllerImpl f182333e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ FrameFragment f182334f;

                {
                    this.f182332d = arrayList;
                    this.f182333e = tabFrameControllerImpl;
                    this.f182334f = frameFragment;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FrameControllerInjectImpl.this, arrayList, tabFrameControllerImpl, frameFragment);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    StopWatch i3 = new StopWatch("FrameUtil.FrameControllerInjectImpl-dispatchOnFirstDrawCompleted", true).i();
                    com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.doOnDrawCompleteAfter");
                    QLog.d("FrameUtil.FrameControllerInjectImpl", 1, "doOnDrawCompleteAfter and dispatch");
                    Iterator it = this.f182332d.iterator();
                    while (it.hasNext()) {
                        w wVar = (w) it.next();
                        wVar.z(this.f182333e, this.f182334f, FrameControllerInjectImpl.this.f182331a);
                        i3.e("callback=" + wVar.getClass().getSimpleName());
                    }
                    com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.doOnDrawCompleteAfter");
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((IRobotPersonalInfoService) peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "")).doOnDrawCompleteAfter();
                    }
                    i3.b("end");
                }
            });
        }
        ei.a("Main_Start", null);
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void d(FrameFragment frameFragment, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment, (Object) intent);
        } else {
            com.tencent.mobileqq.activity.recent.bannerprocessor.d.b((QQAppInterface) frameFragment.app, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void e(FrameFragment frameFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) frameFragment, i3);
        } else {
            ((QQAppInterface) frameFragment.app).playThemeVoice(i3 + 1);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public synchronized com.tencent.mobileqq.activity.home.impl.d f(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, boolean z16, int i3) {
        boolean z17;
        Pair<Integer, String> pair;
        QQBlurViewWrapper qQBlurViewWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.activity.home.impl.d) iPatchRedirector.redirect((short) 6, this, tabFrameControllerImpl, frameFragment, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.doSetFrames");
        if (frameFragment != null && frameFragment.getContext() != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.controllerinject.FrameControllerInjectImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameControllerInjectImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ReportController.o(null, "dc00898", "", "", "0X800BDFF", "0X800BDFF", 0, 0, "", "", "", "");
                    }
                }
            }, 16, null, true);
            if (frameFragment.simpleUIOn != QQTheme.isNowSimpleUI()) {
                z17 = true;
            } else {
                z17 = false;
            }
            frameFragment.simpleUIOn = QQTheme.isNowSimpleUI();
            com.tencent.mobileqq.activity.home.impl.d r16 = r(frameFragment, z16, z17, i3);
            com.tencent.mobileqq.perf.startup.b.b("UpdateCheck");
            if (!r16.d()) {
                TabControlReporter.q(frameFragment.mTabIndicator, frameFragment.mTabHostTabListWithOrder);
                com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.doSetFrames");
                return r16;
            }
            QLog.d("FrameUtil.FrameControllerInjectImpl", 1, "doSetFrames  current frames:" + frameFragment.getFramesLog());
            t(frameFragment);
            wx.a.I = false;
            ((ILebaHelperService) frameFragment.app.getRuntimeService(ILebaHelperService.class, "all")).setFlagUpdateOnPause();
            if (frameFragment.mTabIndicator != null) {
                pair = new Pair<>(Integer.valueOf(frameFragment.mTabIndicator.getCurrentTab()), frameFragment.mTabIndicator.getCurrentTabTag());
                frameFragment.mTabHost.clearAllTabs();
            } else {
                pair = null;
            }
            ArrayList<FrameFragment.e> arrayList = frameFragment.mTabHostTabList;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<FrameFragment.e> arrayList2 = frameFragment.mTabHostTabListWithOrder;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TabDataHelper.TAB_CONVERSATION, 0);
            hashMap.put(TabDataHelper.TAB_CONTACT, 2);
            hashMap.put(TabDataHelper.TAB_LEBA, 3);
            hashMap.put(TabDataHelper.TAB_RIJ, 6);
            hashMap.put("QZONE", 7);
            hashMap.put(TabDataHelper.TAB_NEW_WORLD, 8);
            hashMap.put("GUILD", 10);
            for (Map.Entry<String, View> entry : frameFragment.mTabViewMap.entrySet()) {
                String key = entry.getKey();
                View value = entry.getValue();
                if (value != null) {
                    value.setSelected(false);
                    Integer num = (Integer) hashMap.get(key);
                    if (num != null) {
                        value.setId(num.intValue() + 16);
                    }
                }
            }
            tabFrameControllerImpl.initTabIndexByConfig(r16);
            tabFrameControllerImpl.initTabDragIconsAndTextViews(frameFragment);
            com.tencent.mobileqq.perf.startup.b.b("InitIndex");
            tabFrameControllerImpl.addFrameIndividual(tabFrameControllerImpl, frameFragment, r16);
            tabFrameControllerImpl.dispatchTabDragIconAddTv(frameFragment);
            com.tencent.mobileqq.perf.startup.b.b("AddFrame");
            k.b().d(frameFragment, pair, i3);
            com.tencent.mobileqq.perf.startup.b.b("ConfigTab");
            TabControlReporter.q(frameFragment.mTabIndicator, frameFragment.mTabHostTabListWithOrder);
            ei.a("Main_ui_create_tab123", null);
            tabFrameControllerImpl.checkEnableTabAnim(frameFragment, false);
            ArrayList<FrameFragment.e> arrayList3 = frameFragment.mTabHostTabListWithOrder;
            if (arrayList3 != null && arrayList3.size() > 5 && !frameFragment.mHandleNumException) {
                QLog.e("FrameUtil.FrameControllerInjectImpl", 1, "setFrames num error, setFrames again");
                frameFragment.mHandleNumException = true;
                f(tabFrameControllerImpl, frameFragment, z16, i3);
                com.tencent.mobileqq.perf.startup.b.b("HandleException");
            }
            if (i3 == 0) {
                o(frameFragment);
            }
            com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.doSetFrames");
            com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
            bVar.b(frameFragment.mTabBlurView);
            bVar.a(frameFragment.mTabWidget, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
            if (bVar.isOpen(frameFragment.getContext()) && (qQBlurViewWrapper = frameFragment.mTabBlurView) != null && !qQBlurViewWrapper.hasOnClickListeners()) {
                frameFragment.mTabBlurView.setOnClickListener(new a());
            }
            return r16;
        }
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.doSetFrames");
        return com.tencent.mobileqq.activity.home.impl.d.a().k(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.activity.home.x
    public void g(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tabFrameControllerImpl, frameFragment, view);
            return;
        }
        frameFragment.initTabNotifyIcon();
        frameFragment.mTabNotifyValue = new HashMap<>(13);
        bn bnVar = ((SplashActivity) frameFragment.getBaseActivity()).mSplashPreLoadUI;
        ((SplashActivity) frameFragment.getBaseActivity()).mSplashPreLoadUI = null;
        if (bnVar != null) {
            frameFragment.mDragHost = (DragFrameLayout) bnVar.a();
            frameFragment.mTabViewMap = bnVar.c();
        } else {
            frameFragment.mDragHost = (DragFrameLayout) view.findViewById(R.id.b9o);
            frameFragment.mTabViewMap = ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildTabIcon(frameFragment.getBaseActivity());
        }
        MainFragment mainFragment = (MainFragment) frameFragment;
        frameFragment.mDragHost.setOnDragListener(mainFragment.f182812t0);
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).initIconUnReadView(frameFragment);
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).initIconExtraListener(frameFragment);
        com.tencent.mobileqq.tab.a aVar = (com.tencent.mobileqq.tab.a) view.findViewById(af.f());
        if (aVar != 0) {
            if (aVar instanceof LinearLayout) {
                ((LinearLayout) aVar).setShowDividers(0);
            }
            aVar.setTabWidgetMoveListener(mainFragment.f182813u0.b());
            return;
        }
        QLog.i("FrameUtil.FrameControllerInjectImpl", 1, "initTabs tabWidget is null");
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (SplashActivity.currentFragment != 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public boolean i(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) frameFragment)).booleanValue();
        }
        if (((MainFragment) frameFragment).f182811s0 == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public bn j(TabFrameControllerImpl tabFrameControllerImpl, LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (bn) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tabFrameControllerImpl, (Object) layoutInflater);
        }
        bn bnVar = new bn();
        if (af.d()) {
            bnVar.e(layoutInflater.inflate(R.layout.fgm, (ViewGroup) null));
        } else {
            bnVar.e(layoutInflater.inflate(R.layout.f168257qm, (ViewGroup) null));
        }
        bnVar.d((DragFrameLayout) bnVar.b().findViewById(R.id.b9o));
        bnVar.f(((ITabFrameController) QRoute.api(ITabFrameController.class)).buildTabIcon(layoutInflater.getContext()));
        return bnVar;
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public int k(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameFragment)).intValue();
        }
        Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
        if (conversation != null) {
            return conversation.mUnReadCount;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void l(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tabFrameControllerImpl, frameFragment, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public int m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return com.tencent.mobileqq.activity.home.impl.b.c(i3);
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void n(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frameFragment);
        } else if (!MultiMsgManager.w().C()) {
            MultiMsgManager.w().I((QQAppInterface) frameFragment.app);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public boolean o(FrameFragment frameFragment) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment)).booleanValue();
        }
        if (s() && (intent = frameFragment.getBaseActivity().getIntent()) != null) {
            String stringExtra = intent.getStringExtra("key_tab_name");
            if (!TextUtils.isEmpty(stringExtra)) {
                intent.removeExtra("key_tab_name");
                frameFragment.mTabIndicator.setCurrentTabByTag(stringExtra);
                if (QLog.isColorLevel()) {
                    QLog.d("FrameUtil.FrameControllerInjectImpl", 2, "doSetInitTabByIntent, try to set tab: " + stringExtra);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.home.x
    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        if (z16 && GuildSlideCoordinator.s()) {
            return;
        }
        if (z16 && QCircleHostGlobalInfo.isCurrentTabActive() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebale_interceptor_frame_touch", true)) {
            FrameHelperActivity.gj(false, QCircleFrame.TAG);
            QLog.d("FrameUtil.FrameControllerInjectImpl", 1, "set drawer true but qcircle activity");
        } else {
            FrameHelperActivity.gj(z16, "FrameUtil.FrameControllerInjectImpl");
        }
    }

    public com.tencent.mobileqq.activity.home.impl.d r(FrameFragment frameFragment, boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.home.impl.d) iPatchRedirector.redirect((short) 3, this, frameFragment, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        }
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.doCheckNeedUpdate");
        com.tencent.mobileqq.activity.home.impl.d a16 = com.tencent.mobileqq.activity.home.impl.d.a();
        this.f182331a = a16;
        a16.g().l(i3).i(z16).m(z17).j(((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).isNewLayerMode());
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).checkBusinessSwitch(this.f182331a);
        this.f182331a.h(((ITabFrameController) QRoute.api(ITabFrameController.class)).checkFrameChanged(this.f182331a, frameFragment));
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.doCheckNeedUpdate");
        return this.f182331a;
    }
}
