package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.PrivExtV2Rsp;
import MQQ.VipMedalList;
import MQQ.VipUserInfo;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.dt;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DrawerBizFacade extends com.tencent.mobileqq.a implements com.tencent.mobileqq.processor.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.tencent.mobileqq.processor.b> f184645b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f184646c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f184647d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f184648e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<FrameHelperActivity> f184649f;

    /* renamed from: g, reason: collision with root package name */
    private final dt f184650g;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.mobileqq.observer.a f184651h;

    /* renamed from: i, reason: collision with root package name */
    private final CardObserver f184652i;

    /* renamed from: j, reason: collision with root package name */
    private final AnonymousObserver f184653j;

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.mobileqq.app.ar f184654k;

    /* renamed from: l, reason: collision with root package name */
    private final ProfileCardObserver f184655l;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 extends dt {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(l lVar) {
            if (lVar != null) {
                ((com.tencent.mobileqq.processor.b) lVar).e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, l lVar, AppRuntime appRuntime) {
            QLog.e("BaseDrawerBizFacade", 1, "VipInfoHandler paySuccess " + ((Bundle) obj).getInt("type"));
            if (lVar != null && lVar.h().f184938d != null && lVar.h().f184938d.payHide == 1) {
                lVar.h().f184938d.enable = 0;
                QLog.e("BaseDrawerBizFacade", 1, "VipInfoHandler paySuccess clear bubble");
                VipInfoHandler.U2(appRuntime.getCurrentUin(), lVar.h().f184938d);
                final com.tencent.mobileqq.processor.b bVar = (com.tencent.mobileqq.processor.b) lVar;
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.mobileqq.processor.b.this.e();
                    }
                });
            }
            QVipConfigManager.setLong(appRuntime, QVipConfigManager.KEY_LONG_LAST_PULL_PAY_RULE, 0L);
            TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
            VasLogNtReporter.getVipIcon().reportDebug("pay success and request vipinfo data");
            ((VipInfoHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).sendGetBaseVipInfoReq(VasSkey.getSkey(ticketManager, appRuntime.getCurrentAccountUin()), appRuntime.getCurrentUin());
        }

        @Override // com.tencent.mobileqq.app.dt
        protected void a(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && i3 >= 0 && peekAppRuntime != null) {
                SharedPreferences preferences = peekAppRuntime.getPreferences();
                if (preferences != null) {
                    preferences.edit().putInt(AppConstants.Preferences.KEY_SELFVIP_GROWTHVALUE, i3).commit();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BaseDrawerBizFacade", 2, "updateLevelAndVip from mVipInfoObserver");
                }
                DrawerBizFacade.this.e("d_head_vip").e();
            }
        }

        @Override // com.tencent.mobileqq.app.dt, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, final Object obj) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            final l lVar = (l) DrawerBizFacade.this.e("d_vip_identity");
            if (i3 == 1) {
                if (z16) {
                    PrivExtV2Rsp privExtV2Rsp = (PrivExtV2Rsp) obj;
                    VipUserInfo vipUserInfo = privExtV2Rsp.vipInfo;
                    if (vipUserInfo != null && vipUserInfo.bUpdate == 1 && (str = vipUserInfo.sUri) != null) {
                        if (lVar != null) {
                            lVar.h().f184936b = str;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("BaseDrawerBizFacade", 2, "vip url = " + str);
                        }
                        if (VasToggle.BUG_102518313.isEnable(true)) {
                            VasMMKV.getCommon(peekAppRuntime.getCurrentAccountUin()).encodeString("VIPCenter_url_key", str);
                        } else {
                            SharedPreferences sharedPreferences = peekAppRuntime.getApplication().getSharedPreferences(peekAppRuntime.getCurrentAccountUin(), 4);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putString("VIPCenter_url_key", str).apply();
                            }
                        }
                    }
                    DrawerBizFacade.this.e("d_head_vip").e();
                    VipMedalList vipMedalList = privExtV2Rsp.medalInfoList;
                    if (vipMedalList != null) {
                        PrettyAccountUtil.updateFlagInfoForSelf(vipMedalList.lhNumFlag, vipMedalList.lhLogoLv);
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.mobileqq.processor.b e16 = DrawerBizFacade.this.e("d_vip_card");
                            if (e16 != null) {
                                e16.e();
                            }
                        }
                    });
                }
                DrawerBizFacade.this.e("d_pretty_num").e();
                return;
            }
            if (z16 && i3 == 6) {
                DrawerBizFacade.this.e("d_pretty_num").e();
            } else if (i3 == 4) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrawerBizFacade.AnonymousClass1.d(l.this);
                    }
                });
            } else if (i3 == 5) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrawerBizFacade.AnonymousClass1.e(obj, lVar, peekAppRuntime);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.a, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (DrawerBizFacade.this.f184648e) {
                DrawerBizFacade.this.m(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends CardObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            DrawerBizFacade.this.e("d_daily").e();
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetMedal(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && DrawerBizFacade.this.f184648e) {
                DrawerBizFacade.this.e("d_avatar").i(false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseDrawerBizFacade", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", Boolean.valueOf(z16), Boolean.valueOf(DrawerBizFacade.this.f184648e), Boolean.valueOf(z17)));
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetSignInInfo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else if (z16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrawerBizFacade.b.this.b();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetMedal(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16 && DrawerBizFacade.this.f184648e) {
                DrawerBizFacade.this.e("d_avatar").i(false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseDrawerBizFacade", 2, String.format("onSetMedal [%b %b]", Boolean.valueOf(z16), Boolean.valueOf(DrawerBizFacade.this.f184648e)));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends AnonymousObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver
        public void onAnonymousSettingMeRedPoint(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseDrawerBizFacade", 2, String.format("onAnonymousSettingMeRedPoint success=%s enable=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
            }
            if (z16 && DrawerBizFacade.this.f184648e) {
                DrawerBizFacade.this.e("d_avatar").i(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            DrawerBizFacade.this.e("d_nickname").e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            DrawerBizFacade.this.e("d_nickname").e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            DrawerBizFacade.this.e("d_signature").e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetStoreFace(boolean z16, HashSet<String> hashSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), hashSet);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && DrawerBizFacade.this.f184648e && peekAppRuntime != null && Utils.p(str, peekAppRuntime.getCurrentAccountUin())) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrawerBizFacade.d.this.d();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z17 && z16 && DrawerBizFacade.this.f184648e) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        DrawerBizFacade.d.this.e();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateSignature(boolean z16, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), strArr);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && DrawerBizFacade.this.f184648e && strArr != null && strArr.length > 0) {
                String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                for (int i3 = 0; currentAccountUin != null && i3 < strArr.length; i3++) {
                    if (currentAccountUin.equals(strArr[i3])) {
                        break;
                    }
                }
                z17 = false;
                if (z17) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            DrawerBizFacade.d.this.f();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e extends ProfileCardObserver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DrawerBizFacade.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            DrawerBizFacade.this.e("d_nickname").e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void d(Card card) {
            if (DrawerBizFacade.this.f184649f.get() != 0) {
                QLog.i("BaseDrawerBizFacade", 2, "profileCardObserver setDrawerBg");
                ((FrameHelperActivity) DrawerBizFacade.this.f184649f.get()).fj(card);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (z16 && (obj instanceof Card)) {
                final Card card = (Card) obj;
                if (peekAppRuntime.getCurrentAccountUin().equals(card.uin)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            DrawerBizFacade.e.this.c();
                        }
                    });
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            DrawerBizFacade.e.this.d(card);
                        }
                    }, 16, null, true);
                    return;
                }
            }
            QLog.i("BaseDrawerBizFacade", 2, "profileCardObserver isSuccess:" + z16);
        }
    }

    public DrawerBizFacade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184645b = new ConcurrentHashMap<>();
        this.f184646c = new ArrayList<>();
        this.f184649f = new WeakReference<>(null);
        this.f184650g = new AnonymousClass1();
        this.f184651h = new a();
        this.f184652i = new b();
        this.f184653j = new c();
        this.f184654k = new d();
        this.f184655l = new e();
    }

    private void k(com.tencent.mobileqq.processor.b bVar) {
        if (!QQSettingMeConstant.a(bVar.w()) || (QQSettingMeConstant.a(bVar.w()) && this.f184646c.contains(bVar.w()))) {
            this.f184645b.put(bVar.w(), bVar);
        }
    }

    private void l() {
        FrameHelperActivity frameHelperActivity;
        try {
            frameHelperActivity = FrameHelperActivity.ji((BaseActivity) QBaseActivity.sTopActivity);
        } catch (Exception e16) {
            e16.printStackTrace();
            frameHelperActivity = null;
        }
        if (frameHelperActivity != null) {
            this.f184649f = new WeakReference<>(frameHelperActivity);
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void c(AppRuntime appRuntime) {
        AppRuntime appRuntime2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        WeakReference<AppRuntime> weakReference = this.f174419a;
        if (weakReference == null) {
            appRuntime2 = null;
        } else {
            appRuntime2 = weakReference.get();
        }
        if (this.f184647d && (appRuntime2 instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime2;
            qQAppInterface.unRegistObserver(this.f184651h);
            qQAppInterface.removeObserver(this.f184652i);
            qQAppInterface.removeObserver(this.f184654k);
            qQAppInterface.removeObserver(this.f184655l);
            qQAppInterface.removeObserver(this.f184650g);
            qQAppInterface.removeObserver(this.f184653j);
        }
        this.f174419a = new WeakReference<>(appRuntime);
        if (appRuntime != null) {
            QLog.i("BaseDrawerBizFacade", 2, "fillData addObserver");
            appRuntime.registObserver(this.f184651h);
            QQAppInterface qQAppInterface2 = (QQAppInterface) appRuntime;
            qQAppInterface2.addObserver(this.f184652i);
            qQAppInterface2.addObserver(this.f184653j);
            qQAppInterface2.addObserver(this.f184654k, true);
            qQAppInterface2.addObserver(this.f184655l, true);
            qQAppInterface2.addObserver(this.f184650g, true);
            this.f184647d = true;
        }
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseDrawerBizFacade", 2, "fillData(), app == null");
                return;
            }
            return;
        }
        QLog.d("BaseDrawerBizFacade", 1, "fillData mDrawerProcessors size:" + this.f184645b.size());
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().c(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
    }

    @Override // com.tencent.mobileqq.processor.a
    public com.tencent.mobileqq.processor.b e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.processor.b) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        if (this.f184645b.get(str) == null) {
            QLog.e("BaseDrawerBizFacade", 1, "getBizProcessor null:" + str);
        }
        return this.f184645b.get(str);
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void f(QBaseActivity qBaseActivity, LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) lifecycleOwner);
            return;
        }
        super.f(qBaseActivity, lifecycleOwner);
        Iterator<com.tencent.mobileqq.processor.b> it = ((IDrawerApi) QRoute.api(IDrawerApi.class)).getProcessors().iterator();
        while (it.hasNext()) {
            k(it.next());
        }
        if (this.f184645b.size() == 0) {
            QLog.e("BaseDrawerBizFacade", 1, "init: mDrawerProcessors.size = 0 ");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Iterator<com.tencent.mobileqq.processor.b> it5 = this.f184645b.values().iterator();
        while (it5.hasNext()) {
            it5.next().k(peekAppRuntime, qBaseActivity, lifecycleOwner);
        }
        l();
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            if (QQSettingMeConstant.a(str)) {
                this.f184646c.add(str);
                return;
            }
            q qVar = new q();
            qVar.l(str);
            this.f184645b.put(str, qVar);
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            ThreadManagerV2.excute(new Runnable(z16) { // from class: com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f184658d;

                {
                    this.f184658d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DrawerBizFacade.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    for (com.tencent.mobileqq.processor.b bVar : DrawerBizFacade.this.f184645b.values()) {
                        View h16 = com.tencent.mobileqq.qqsettingme.a.h(bVar.w());
                        boolean a16 = QQSettingMeConstant.a(bVar.w());
                        if (!a16 || (h16 != null && h16.getVisibility() == 0)) {
                            if (!a16 && !(bVar instanceof q)) {
                                bVar.i(this.f184658d);
                            } else {
                                QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bVar.w());
                                if (c16 != null) {
                                    bVar.j(((IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(c16.o()), this.f184658d);
                                }
                            }
                        }
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void onConfigurationChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged();
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void onDestroy() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        WeakReference<AppRuntime> weakReference = this.f174419a;
        if (weakReference == null) {
            appRuntime = null;
        } else {
            appRuntime = weakReference.get();
        }
        if (this.f184647d && (appRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            qQAppInterface.unRegistObserver(this.f184651h);
            qQAppInterface.removeObserver(this.f184652i);
            qQAppInterface.removeObserver(this.f184654k);
            qQAppInterface.removeObserver(this.f184655l);
            qQAppInterface.removeObserver(this.f184650g);
            qQAppInterface.removeObserver(this.f184653j);
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.f184647d = false;
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
        SceneTracker.f258213d.traceEnd("QQSettingMe");
        this.f184648e = false;
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().onPostThemeChanged();
        }
        ((IRedTouchServer) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void onResume() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        SceneTracker.f258213d.m("QQSettingMe");
        WeakReference<AppRuntime> weakReference = this.f174419a;
        if (weakReference == null) {
            appRuntime = null;
        } else {
            appRuntime = weakReference.get();
        }
        if (!this.f184647d && (appRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            qQAppInterface.registObserver(this.f184651h);
            qQAppInterface.addObserver(this.f184652i, true);
            qQAppInterface.addObserver(this.f184654k, true);
            qQAppInterface.addObserver(this.f184655l, true);
            qQAppInterface.addObserver(this.f184650g, true);
            qQAppInterface.addObserver(this.f184653j, true);
            this.f184647d = true;
        }
        for (com.tencent.mobileqq.processor.b bVar : this.f184645b.values()) {
            long currentTimeMillis = System.currentTimeMillis();
            bVar.onResume();
            if (QLog.isDevelopLevel()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 2) {
                    QLog.d("BaseDrawerBizFacade", 2, "onResume " + bVar.getClass().getName(), ", costTime:", Long.valueOf(currentTimeMillis2));
                }
            }
        }
        m(true);
        if (this.f184649f.get() == null) {
            l();
        }
        this.f184648e = true;
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.processor.b> it = this.f184645b.values().iterator();
        while (it.hasNext()) {
            it.next().preload();
        }
    }

    @Override // com.tencent.mobileqq.a, com.tencent.mobileqq.s
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.f184646c.clear();
        this.f184645b.clear();
        QLog.i("BaseDrawerBizFacade", 2, "mDrawerProcessors reset");
    }
}
