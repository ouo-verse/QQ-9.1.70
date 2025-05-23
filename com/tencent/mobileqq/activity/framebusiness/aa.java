package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import cooperation.qzone.api.QZoneApiProxy;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aa extends com.tencent.mobileqq.activity.framebusiness.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f182311d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f182312e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f182313f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment.DragViewTouchListener f182314d;

        a(FrameFragment.DragViewTouchListener dragViewTouchListener) {
            this.f182314d = dragViewTouchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aa.this, (Object) dragViewTouchListener);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.U, motionEvent);
            return this.f182314d.onTouch(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b extends FrameFragment.DragViewPunctureClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public View f182316d;

        /* renamed from: e, reason: collision with root package name */
        public String f182317e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f182318f;

        public b(View view, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) str);
                return;
            }
            this.f182318f = true;
            this.f182316d = view;
            this.f182317e = str;
        }

        @Override // com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                super.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f182311d = com.tencent.mobileqq.activity.home.impl.b.f183051n;
        f182312e = QzoneFrame.class.getName();
        f182313f = false;
    }

    public aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean B(RedTouch redTouch) {
        if (redTouch != null && redTouch.hasRedTouch()) {
            return true;
        }
        return false;
    }

    private void C(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.setQzoneLebaTab");
        ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).fetchAndReportTeenageFeedModeExp();
        ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).setFrameFragment(frameFragment);
        f182313f = dVar.c("QZONE");
        QLog.i("TabFrameControllerImplBusiness", 1, "setQzoneLebaTab showQzoneFrame: " + f182313f);
        if (f182313f) {
            ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).showQzoneFrame();
            if (TabFrameControllerImpl.isLazyLoadTabView()) {
                frameFragment.mTabViewMap.remove(TabDataHelper.TAB_LEBA);
            }
            frameFragment.mTabDragIcon.remove(com.tencent.mobileqq.activity.home.impl.a.f183041d);
            frameFragment.mTabTextView.remove(com.tencent.mobileqq.activity.home.impl.a.f183041d);
            frameFragment.removeFrame(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
            View view = frameFragment.mTabViewMap.get("QZONE");
            if (view == null) {
                view = ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildSingleTabIcon("QZONE", frameFragment);
            }
            tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, QzoneFrame.class, view);
            String str = com.tencent.mobileqq.activity.home.impl.b.f183051n;
            frameFragment.setTabNotifyIcon(str, view);
            frameFragment.setTabNotifyIcon(str + "_num", view.findViewById(R.id.khc));
            ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).setNeedShowQZoneFrame(true);
        } else {
            ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).showLebaFrame();
            if (TabFrameControllerImpl.isLazyLoadTabView()) {
                frameFragment.mTabViewMap.remove("QZONE");
            }
            frameFragment.mTabDragIcon.remove(com.tencent.mobileqq.activity.home.impl.a.f183045h);
            frameFragment.mTabTextView.remove(com.tencent.mobileqq.activity.home.impl.a.f183045h);
            frameFragment.removeFrame(QzoneFrame.class);
            View view2 = frameFragment.mTabViewMap.get(TabDataHelper.TAB_LEBA);
            if (view2 == null) {
                view2 = ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildSingleTabIcon(TabDataHelper.TAB_LEBA, frameFragment);
            }
            tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), view2);
            String str2 = com.tencent.mobileqq.activity.home.impl.b.f183052o;
            frameFragment.setTabNotifyIcon(str2, view2);
            frameFragment.setTabNotifyIcon(str2 + "_num", view2.findViewById(R.id.khc));
            ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).setQZoneFrameClass(QzoneFrame.class.getName());
            ((ILebaUIStyleSettingApi) QRoute.api(ILebaUIStyleSettingApi.class)).setNeedShowQZoneFrame(false);
        }
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.setQzoneLebaTab");
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QzoneFrame.class);
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183045h);
        QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            C(tabFrameControllerImpl, frameFragment, dVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
            return;
        }
        be frame = frameFragment.getFrame(QzoneFrame.class);
        if (frame != null) {
            ((QzoneFrame) frame).onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get("QZONE") != null) {
            View view = hashMap.get("QZONE");
            view.setOnClickListener(new b(view, "QzoneTab"));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QZONE";
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean h(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar, (Object) frameFragment)).booleanValue();
        }
        boolean c16 = dVar.c("QZONE");
        boolean z17 = false;
        if (f182313f != c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        String name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
        if (GuildInjectImpl.L() && name.equals(TabDataHelper.getTabCurrentManualTag(frameFragment.app.getApp(), currentUin))) {
            dVar.b().append("not change for guild ");
        } else {
            z17 = z16;
        }
        StringBuilder b16 = dVar.b();
        b16.append("toShowQzone: ");
        b16.append(c16);
        b16.append(" ");
        b16.append("isQzoneChange: ");
        b16.append(z17);
        b16.append(" ");
        return z17;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, hashMap, Boolean.valueOf(z16));
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(hashMap.get(f182311d), z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void r(com.tencent.mobileqq.activity.home.impl.d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.isNeedShowQzoneFrame");
        boolean needShowQzoneFrame = QZoneApiProxy.needShowQzoneFrame(BaseApplication.getContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.isNeedShowQzoneFrame");
        boolean t16 = AppSetting.t(BaseApplicationImpl.getApplication());
        if (needShowQzoneFrame && !t16) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("TabFrameControllerImplBusiness", 1, "doOnCheckBusinessSwitch isShowQzone: " + z16 + ", isNeedShowQzoneFrame:" + needShowQzoneFrame + ", isSplitViewMode:" + t16);
        if (z16) {
            dVar.f("QZONE", true);
            dVar.f(TabDataHelper.TAB_LEBA, false);
        } else {
            dVar.f("QZONE", false);
            dVar.f(TabDataHelper.TAB_LEBA, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H("QZONE").F(QzoneFrame.class).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183045h).Q(com.tencent.mobileqq.activity.home.impl.b.f183051n).w(R.drawable.qui_tab_activity_default).x(R.drawable.qui_tab_activity_default_pressed).N(R.string.c77).t(14).u(4).y(R.drawable.qui_tab_activity_simple).z(R.drawable.qui_tab_activity_simple_pressed).J("activity.json").I("activity_back.json").D(-1).E(R.drawable.f162507ha0).M(true).K(true).A());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment, (Object) str);
            return;
        }
        if (f182312e.equals(str)) {
            be currentFrame = frameFragment.getCurrentFrame();
            if (currentFrame instanceof QzoneFrame) {
                if (TianshuRedTouch.INSTANCE.j()) {
                    z16 = frameFragment.hasRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183052o).booleanValue();
                } else {
                    View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183052o);
                    if (tabNotifyIcon instanceof RedTouch) {
                        B((RedTouch) tabNotifyIcon);
                    }
                    z16 = false;
                }
                ((QzoneFrame) currentFrame).onSwitchToQzone(z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameFragment, (Object) dragViewTouchListener);
            return;
        }
        boolean z16 = f182313f;
        if (z16) {
            str = "QZONE";
        } else {
            str = TabDataHelper.TAB_LEBA;
        }
        if (z16) {
            i3 = com.tencent.mobileqq.activity.home.impl.a.f183045h;
        } else {
            i3 = com.tencent.mobileqq.activity.home.impl.a.f183041d;
        }
        View view = frameFragment.mTabViewMap.get(str);
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) view.findViewById(R.id.j_k);
        TextView textView = (TextView) view.findViewById(R.id.kbi);
        frameFragment.mTabDragIcon.put(i3, tabDragAnimationView);
        frameFragment.mTabTextView.put(i3, textView);
        tabDragAnimationView.setOnTouchListener(new a(dragViewTouchListener));
        tabDragAnimationView.h("\u52a8\u6001");
        TabDragAnimationView.G(textView);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
        } else if (beVar instanceof QzoneFrame) {
            ((QzoneFrame) beVar).onSwitchOutofQzone();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void z(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, tabFrameControllerImpl, frameFragment, dVar);
        }
    }
}
