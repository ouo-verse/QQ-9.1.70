package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ContactsInjectImpl extends com.tencent.mobileqq.activity.framebusiness.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f182271d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f182272e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment.DragViewTouchListener f182274d;

        a(FrameFragment.DragViewTouchListener dragViewTouchListener) {
            this.f182274d = dragViewTouchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactsInjectImpl.this, (Object) dragViewTouchListener);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.T, motionEvent);
            return this.f182274d.onTouch(view, motionEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f182271d = com.tencent.mobileqq.activity.home.impl.b.f183050m;
            f182272e = Contacts.class.getName();
        }
    }

    public ContactsInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void B(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        boolean z16;
        if (frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183050m)) != null) {
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.A);
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.activity.home.impl.b.j(redBadge, com.tencent.mobileqq.activity.home.impl.b.g(5), com.tencent.mobileqq.activity.home.impl.b.f(redBadge.O()), Boolean.valueOf(z16));
        }
    }

    private void C(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment) {
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.setContactsTab");
        tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, Contacts.class, frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONTACT));
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.setContactsTab");
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Contacts.class);
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183040c);
        QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) frameFragment);
        } else {
            B(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            C(tabFrameControllerImpl, frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
            return;
        }
        be frame = frameFragment.getFrame(Contacts.class);
        if (frame != null) {
            ViewGroup viewGroup = frameFragment.mTabWidget;
            if (viewGroup != null) {
                i3 = viewGroup.getHeight();
            } else {
                i3 = -1;
            }
            ((Contacts) frame).onPostThemeChanged(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get(TabDataHelper.TAB_CONTACT) != null) {
            hashMap.get(TabDataHelper.TAB_CONTACT).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        TianshuRedTouch redBadge;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else {
            if (i3 != 33 || (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183050m)) == null) {
                return;
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, i3, redBadge, redTypeInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TabDataHelper.TAB_CONTACT;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 33) {
            View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183050m);
            if (!(tabNotifyIcon instanceof RedTouch)) {
                return;
            }
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedTouch(frameFragment, i3, (RedTouch) tabNotifyIcon, redTypeInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, hashMap, Boolean.valueOf(z16));
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(hashMap.get(f182271d), z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            B(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment);
        } else {
            frameFragment.updateTabFaceId(com.tencent.mobileqq.activity.home.impl.a.f183040c, R.drawable.h_v, R.drawable.h_w);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H(TabDataHelper.TAB_CONTACT).F(Contacts.class).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183040c).Q(com.tencent.mobileqq.activity.home.impl.b.f183050m).w(R.drawable.qui_tab_contact_default).x(R.drawable.qui_tab_contact_default_pressed).N(R.string.c75).t(12).u(3).y(R.drawable.qui_tab_contact_simple).z(R.drawable.qui_tab_contact_simple_pressed).J("contact.json").I("contact_back.json").D(R.drawable.h_v).E(R.drawable.h_v).M(true).K(true).v(R.drawable.qui_tab_contact_default_dark).R(R.drawable.skin_tab_icon_2).A());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabContentDescription(frameFragment, com.tencent.mobileqq.activity.home.impl.b.f183050m, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) frameFragment, (Object) str);
        } else if (f182272e.equals(str)) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(frameFragment) { // from class: com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FrameFragment f182273d;

                {
                    this.f182273d = frameFragment;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactsInjectImpl.this, (Object) frameFragment);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SpecialCare", 2, "getSpecialRecommendStat=" + FriendListHandler.getSpecialRecommendStat);
                    }
                    int i3 = FriendListHandler.getSpecialRecommendStat;
                    if (i3 != 0 && i3 != 2 && i3 != 3) {
                        FrameFragment frameFragment2 = this.f182273d;
                        if (frameFragment2.hasSpecialCareFriend) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SpecialCare", 2, "hasSpecialCareFriend=true");
                                return;
                            }
                            return;
                        }
                        if (frameFragment2.app == null) {
                            return;
                        }
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b friendsCategoryInfo = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsCategoryInfo(String.valueOf(((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()), "TabFrameControllerImplBusiness");
                        if (friendsCategoryInfo == null) {
                            return;
                        }
                        ArrayList<String> c16 = friendsCategoryInfo.c();
                        if (c16 != null && c16.size() > 0) {
                            this.f182273d.hasSpecialCareFriend = true;
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SpecialCare", 2, "hasSpecialCareFriend=" + this.f182273d.hasSpecialCareFriend);
                        }
                        ((FriendListHandler) ((QQAppInterface) this.f182273d.app).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSpecialCareRecommend(0, 10, null, true, true);
                    }
                }
            }, 500L);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameFragment, (Object) dragViewTouchListener);
            return;
        }
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONTACT).findViewById(R.id.j_k);
        tabDragAnimationView.setOnTouchListener(new a(dragViewTouchListener));
        tabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.dpToPx(2.0f));
        tabDragAnimationView.h("\u8054\u7cfb\u4eba");
        frameFragment.mTabDragIcon.put(com.tencent.mobileqq.activity.home.impl.a.f183040c, tabDragAnimationView);
        TextView textView = (TextView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONTACT).findViewById(R.id.kbi);
        TabDragAnimationView.G(textView);
        frameFragment.mTabTextView.put(com.tencent.mobileqq.activity.home.impl.a.f183040c, textView);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        AppRuntime appRuntime;
        com.tencent.mobileqq.qcall.f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
            return;
        }
        int i17 = com.tencent.mobileqq.activity.home.impl.a.f183039b;
        if (i3 == i17 && i16 != i17 && (appRuntime = frameFragment.app) != null && (fVar = (com.tencent.mobileqq.qcall.f) appRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE)) != null) {
            fVar.K(com.tencent.mobileqq.service.message.e.K0());
        }
        B(frameFragment, i3, beVar, i16);
    }
}
