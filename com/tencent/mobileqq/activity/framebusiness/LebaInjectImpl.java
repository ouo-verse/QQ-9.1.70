package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.aa;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.events.QZoneFrameInitCheckEvents;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LebaInjectImpl extends a implements SimpleEventReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final String f182285f;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<FrameFragment> f182286d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f182287e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            f182285f = com.tencent.mobileqq.activity.home.impl.b.f183052o;
        }
    }

    public LebaInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void C(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        boolean z16;
        if (frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o)) != null) {
            BusinessInfoCheckUpdate.RedTypeInfo d16 = com.tencent.mobileqq.activity.home.impl.b.d(frameFragment, 34);
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.B);
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            com.tencent.mobileqq.activity.home.impl.b.j(redBadge, com.tencent.mobileqq.activity.home.impl.b.g(0), com.tencent.mobileqq.activity.home.impl.b.e(d16), valueOf);
            if (valueOf.booleanValue()) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroExposure(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183041d);
        QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public Handler B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Handler) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.f182287e == null) {
            this.f182287e = new Handler(Looper.getMainLooper());
        }
        return this.f182287e;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        TianshuRedTouch redBadge;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameFragment);
        } else if (TianshuRedTouch.INSTANCE.j() && frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o)) != null) {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, 34, redBadge, null);
            C(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment);
        } else {
            ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).onPostThemeChanged(frameFragment.getFrame(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass()));
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get(TabDataHelper.TAB_LEBA) != null) {
            View view = hashMap.get(TabDataHelper.TAB_LEBA);
            view.setOnClickListener(new aa.b(view, "lebaTab"));
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        TianshuRedTouch redBadge;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
            return;
        }
        this.f182286d = new WeakReference<>(frameFragment);
        if (i3 == 34 && TianshuRedTouch.INSTANCE.j() && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o)) != null) {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, i3, redBadge, redTypeInfo);
            ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroExposure(0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFrameInitCheckEvents.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TabDataHelper.TAB_LEBA;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
            return;
        }
        this.f182286d = new WeakReference<>(frameFragment);
        if (i3 == 34) {
            View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183052o);
            if (!(tabNotifyIcon instanceof RedTouch)) {
                return;
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedTouch(frameFragment, i3, (RedTouch) tabNotifyIcon, redTypeInfo);
            if (TianshuRedTouch.INSTANCE.j()) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroExposure(0);
            } else {
                iRedTouchManager.reportLevelZeroRedInfo(0, 30);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, hashMap, Boolean.valueOf(z16));
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(hashMap.get(f182285f), z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            C(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        WeakReference<FrameFragment> weakReference;
        FrameFragment frameFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if ((simpleBaseEvent instanceof QZoneFrameInitCheckEvents) && (weakReference = this.f182286d) != null && (frameFragment = weakReference.get()) != null) {
            QLog.i("TabFrameControllerImplBusiness", 1, "needShowQzoneFrame receive QZoneFrameInitCheckEvents doSetFrames");
            B().post(new Runnable(frameFragment) { // from class: com.tencent.mobileqq.activity.framebusiness.LebaInjectImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FrameFragment f182288d;

                {
                    this.f182288d = frameFragment;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaInjectImpl.this, (Object) frameFragment);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((ITabFrameController) QRoute.api(ITabFrameController.class)).setFrames(this.f182288d, false, 5);
                    }
                }
            });
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment);
        } else {
            frameFragment.updateTabFaceId(com.tencent.mobileqq.activity.home.impl.a.f183041d, -1, R.drawable.f162507ha0);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H(TabDataHelper.TAB_LEBA).F(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass()).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183041d).Q(com.tencent.mobileqq.activity.home.impl.b.f183052o).w(R.drawable.qui_tab_activity_default).x(R.drawable.qui_tab_activity_default_pressed).N(R.string.c77).t(14).u(4).y(R.drawable.qui_tab_activity_simple).z(R.drawable.qui_tab_activity_simple_pressed).J("activity.json").I("activity_back.json").D(-1).E(R.drawable.f162507ha0).M(true).K(true).v(R.drawable.qui_tab_activity_default_dark).R(R.drawable.skin_tab_icon_4).A());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabContentDescription(frameFragment, com.tencent.mobileqq.activity.home.impl.b.f183052o, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) frameFragment, (Object) str);
            return;
        }
        if (frameFragment.app != null && ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).isLeba(str)) {
            be currentFrame = frameFragment.getCurrentFrame();
            if (((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).isLebaFrame(currentFrame)) {
                TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = null;
                boolean z16 = true;
                if (companion.j()) {
                    TianshuRedTouch redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o);
                    if (redBadge == null || !redBadge.Q()) {
                        z16 = false;
                    }
                    if (redBadge != null) {
                        redTypeInfo = companion.k(redBadge.L());
                    }
                    ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).onSwitchToLeba(currentFrame, z16, redTypeInfo);
                    com.tencent.mobileqq.service.report.b.d(frameFragment.getActivity(), false);
                    return;
                }
                View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183052o);
                if (!(tabNotifyIcon instanceof RedTouch)) {
                    return;
                }
                RedTouch redTouch = (RedTouch) tabNotifyIcon;
                if (redTouch == null || !redTouch.hasRedTouch()) {
                    z16 = false;
                }
                if (redTouch != null) {
                    redTypeInfo = redTouch.getRedType();
                }
                ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).onSwitchToLeba(currentFrame, z16, redTypeInfo);
                com.tencent.mobileqq.service.report.b.d(frameFragment.getActivity(), false);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
        } else {
            C(frameFragment, i3, beVar, i16);
        }
    }
}
