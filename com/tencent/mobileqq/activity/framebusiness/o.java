package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.minigame.api.IMiniGameMetaGuideBubbleApi;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o extends com.tencent.mobileqq.activity.framebusiness.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f182389h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f182390d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f182391e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.widget.tip.a f182392f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements a.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182393a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.gamecenter.metadream.a f182394b;

        a(FrameFragment frameFragment, com.tencent.mobileqq.gamecenter.metadream.a aVar) {
            this.f182393a = frameFragment;
            this.f182394b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, frameFragment, aVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
                return;
            }
            QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, bubble onClick, jumpUrl=", this.f182394b.f212208c);
            ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setTabRedpointInfo(this.f182394b);
            o.this.X(this.f182393a);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, bubble onDismiss");
                o.this.K(this.f182393a);
            }
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, bubble onShow");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68306);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f182389h = false;
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(FrameFragment frameFragment) {
        if (frameFragment == null) {
            return;
        }
        QLog.d("MetaDreamInjectImpl", 1, "clearRedPointInfo");
        View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183057t);
        if (!(tabNotifyIcon instanceof RedTouch)) {
            return;
        }
        if (tabNotifyIcon != null) {
            ((RedTouch) tabNotifyIcon).clearRedTouch();
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.onRedTouchItemClick(iRedTouchManager.getAppInfo(17, String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_META_DREAM_TAB)), null);
        this.f182390d = false;
    }

    private void L(FrameFragment frameFragment) {
        if (frameFragment == null) {
            QLog.w("MetaDreamInjectImpl", 1, "disableDrawer frameFragment null");
            return;
        }
        be currentFrame = frameFragment.getCurrentFrame();
        if (currentFrame == null) {
            QLog.w("MetaDreamInjectImpl", 1, "disableDrawer currentFrame null");
        } else if (((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).isMetaDreamFrame(currentFrame)) {
            QLog.d("MetaDreamInjectImpl", 1, "disableDrawer disable");
            FrameHelperActivity.gj(false, "MetaDreamInjectImpl");
        }
    }

    private com.tencent.mobileqq.gamecenter.metadream.a M(BusinessInfoCheckUpdate.AppInfo appInfo) {
        com.tencent.mobileqq.gamecenter.metadream.a aVar = null;
        if (appInfo == null) {
            return null;
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.red_type_info.get();
        if (list != null && list.size() != 0) {
            aVar = new com.tencent.mobileqq.gamecenter.metadream.a();
            for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
                int i3 = redTypeInfo.red_type.get();
                String str = redTypeInfo.red_content.get();
                int i16 = 0;
                QLog.d("MetaDreamInjectImpl", 1, "getMetaDreamTabRedInfo type=", Integer.valueOf(i3), ", content=", str);
                if (i3 != 3) {
                    if (i3 != 11) {
                        if (i3 != 20) {
                            if (i3 == 26) {
                                aVar.f212208c = str;
                            }
                        } else {
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    i16 = Integer.parseInt(str);
                                } catch (Exception e16) {
                                    QLog.e("MetaDreamInjectImpl", 1, "updateMetaDreamReddot, parse duration exception=", e16);
                                }
                            }
                            aVar.f212209d = i16;
                        }
                    } else {
                        aVar.f212207b = str;
                    }
                } else {
                    aVar.f212206a = str;
                }
            }
        }
        return aVar;
    }

    private String N() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return MobileQQ.sMobileQQ.getLastLoginUin();
        }
        return str;
    }

    private void O() {
        QLog.d("MetaDreamInjectImpl", 1, "hideBubbleTip");
        com.tencent.mobileqq.widget.tip.a aVar = this.f182392f;
        if (aVar != null && aVar.L()) {
            this.f182392f.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P() {
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).notifyTabChange(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q() {
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).notifyTabChange(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R() {
        ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).notifyLebaTabChange(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S() {
        ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).notifyLebaTabChange(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T() {
        ((IMiniGameMetaGuideBubbleApi) QRoute.api(IMiniGameMetaGuideBubbleApi.class)).dismissLebaMetaGuideBubble();
    }

    private void W(FrameFragment frameFragment, int i3, be beVar, int i16) {
        TianshuRedTouch redBadge;
        boolean z16;
        if (frameFragment != null && (redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183057t)) != null) {
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.H);
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.activity.home.impl.b.j(redBadge, com.tencent.mobileqq.activity.home.impl.b.g(103), com.tencent.mobileqq.activity.home.impl.b.f(redBadge.O()), Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(FrameFragment frameFragment) {
        if (frameFragment == null) {
            return;
        }
        ArrayList<FrameFragment.e> arrayList = frameFragment.mTabHostTabListWithOrder;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass().getName().equals(arrayList.get(i3).getTag())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = 0;
                break;
            }
        }
        QLog.d("MetaDreamInjectImpl", 1, "selectMetaDreamTab index=", Integer.valueOf(i3));
        frameFragment.setCurrentTab(i3);
    }

    private void Y(FrameFragment frameFragment, com.tencent.mobileqq.gamecenter.metadream.a aVar) {
        if (frameFragment != null && aVar != null) {
            View view = frameFragment.mTabViewMap.get(TabDataHelper.TAB_META_DREAM);
            QBaseActivity baseActivity = frameFragment.getBaseActivity();
            this.f182392f = com.tencent.mobileqq.widget.tip.a.r(baseActivity).S(view).R(0).k0(0).X(baseActivity.getResources().getDrawable(R.drawable.nb7)).T(new ColorDrawable(0)).i0(0.0f, 8.0f).o0(aVar.f212207b).b0(aVar.f212209d * 1000).f(new a(frameFragment, aVar));
            if (!TextUtils.isEmpty(aVar.f212206a)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                this.f182392f.U(new Drawable[]{URLDrawable.getDrawable(aVar.f212206a, obtain)});
            }
            this.f182392f.s0();
        }
    }

    private boolean Z(FrameFragment frameFragment, com.tencent.mobileqq.gamecenter.metadream.a aVar) {
        QLog.d("MetaDreamInjectImpl", 1, "showRedPoint metaDreamTabRedInfo=", aVar);
        if (aVar == null) {
            return false;
        }
        this.f182390d = true;
        if (!TextUtils.isEmpty(aVar.f212207b)) {
            QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, show bubble");
            int i3 = aVar.f212209d;
            if (i3 <= 0) {
                QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, invalid duration=", Integer.valueOf(i3));
                return false;
            }
            O();
            Y(frameFragment, aVar);
        } else {
            QLog.d("MetaDreamInjectImpl", 1, "showRedPoint, red point");
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_desc.set("");
            redTypeInfo.red_content.set("");
            if (TianshuRedTouch.INSTANCE.j()) {
                TianshuRedTouch redBadge = frameFragment.getRedBadge(com.tencent.mobileqq.activity.home.impl.b.f183057t);
                if (redBadge != null) {
                    ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedBadge(frameFragment, 49, redBadge, redTypeInfo);
                }
            } else {
                View tabNotifyIcon = frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183057t);
                if (!(tabNotifyIcon instanceof RedTouch)) {
                    return false;
                }
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateRedTouch(frameFragment, 49, (RedTouch) tabNotifyIcon, redTypeInfo);
            }
            ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setTabRedpointInfo(aVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void V(FrameFragment frameFragment) {
        BusinessInfoCheckUpdate.AppInfo appInfo;
        if (frameFragment == null) {
            QLog.w("MetaDreamInjectImpl", 1, "updateMetaDreamReddot frameFragment null");
            return;
        }
        be currentFrame = frameFragment.getCurrentFrame();
        if (currentFrame == null) {
            QLog.w("MetaDreamInjectImpl", 1, "updateMetaDreamReddot currentFrame null");
            return;
        }
        if (((IMiniGameMetaGuideBubbleApi) QRoute.api(IMiniGameMetaGuideBubbleApi.class)).showLebaMetaGuideBubble(frameFragment)) {
            QLog.d("MetaDreamInjectImpl", 1, "updateMetaDreamReddot showLebaMetaGuideBubble");
            return;
        }
        boolean isMetaDreamFrame = ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).isMetaDreamFrame(currentFrame);
        boolean isFrameAlive = ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getIsFrameAlive();
        QLog.d("MetaDreamInjectImpl", 1, "updateMetaDreamReddot isMetaDreamFrame=", Boolean.valueOf(isMetaDreamFrame), ", isMetaDreamFrameAlive=", Boolean.valueOf(isFrameAlive));
        if (!isMetaDreamFrame && !isFrameAlive) {
            String str = "";
            IRedTouchManager iRedTouchManager = (IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
            try {
                appInfo = iRedTouchManager.getAppInfo(17, String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_META_DREAM_TAB));
            } catch (Exception e16) {
                QLog.e("MetaDreamInjectImpl", 1, "updateMetaDreamReddot getAppInfo exception=", e16);
                appInfo = null;
            }
            if (appInfo != null) {
                int i3 = appInfo.iNewFlag.get();
                int i16 = appInfo.exposure_max.get();
                long j3 = appInfo.push_red_ts.get();
                PBRepeatField<String> pBRepeatField = appInfo.missions;
                if (pBRepeatField != null && pBRepeatField.get() != null && appInfo.missions.get().size() > 0) {
                    str = appInfo.missions.get().get(0);
                }
                QLog.d("MetaDreamInjectImpl", 1, "updateMetaDreamReddot newFlag=", Integer.valueOf(i3), ", exposureMax=", Integer.valueOf(i16), ", pushRedTs=", Long.valueOf(j3), ", adId=", str);
                if (RedTouch.hasRedTouch(appInfo)) {
                    com.tencent.mobileqq.gamecenter.metadream.a M = M(appInfo);
                    if (M != null && Z(frameFragment, M)) {
                        iRedTouchManager.onRedTouchItemExposure(appInfo, null);
                        return;
                    }
                    return;
                }
                QLog.d("MetaDreamInjectImpl", 1, "updateMetaDreamReddot appInfo no red point");
                return;
            }
            QLog.d("MetaDreamInjectImpl", 1, "updateMetaDreamReddot appInfo null");
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass());
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183048k);
        QLog.d("MetaDreamInjectImpl", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) frameFragment);
            return;
        }
        QLog.d("MetaDreamInjectImpl", 1, "doOnResumeAfter");
        L(frameFragment);
        W(frameFragment, 0, null, -1);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tabFrameControllerImpl, frameFragment, dVar);
            return;
        }
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setMainFragment(frameFragment);
        if (dVar.c(TabDataHelper.TAB_META_DREAM)) {
            View view = frameFragment.mTabViewMap.get(TabDataHelper.TAB_META_DREAM);
            if (view == null) {
                view = ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildSingleTabIcon(TabDataHelper.TAB_META_DREAM, frameFragment);
            }
            String str = com.tencent.mobileqq.activity.home.impl.b.f183057t;
            frameFragment.setTabNotifyIcon(str, view);
            frameFragment.setTabNotifyIcon(str + "_num", view.findViewById(R.id.khc));
            TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) view.findViewById(R.id.j_k);
            TextView textView = (TextView) view.findViewById(R.id.kbi);
            TabDragAnimationView.G(textView);
            if (tabDragAnimationView != null && textView != null) {
                frameFragment.mTabDragIcon.put(com.tencent.mobileqq.activity.home.impl.a.f183048k, tabDragAnimationView);
                frameFragment.mTabTextView.put(com.tencent.mobileqq.activity.home.impl.a.f183048k, textView);
                tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass(), view);
                f182389h = true;
                QLog.i("MetaDreamInjectImpl", 1, "doAddFrame addFrame success");
                return;
            }
            return;
        }
        if (TabFrameControllerImpl.isLazyLoadTabView()) {
            frameFragment.mTabViewMap.remove(TabDataHelper.TAB_META_DREAM);
        }
        frameFragment.mTabDragIcon.remove(com.tencent.mobileqq.activity.home.impl.a.f183048k);
        frameFragment.mTabTextView.remove(com.tencent.mobileqq.activity.home.impl.a.f183048k);
        frameFragment.removeFrame(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass());
        f182389h = false;
        QLog.i("MetaDreamInjectImpl", 1, "doAddFrame addFrame success");
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get(TabDataHelper.TAB_META_DREAM) != null) {
            hashMap.get(TabDataHelper.TAB_META_DREAM).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, final FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 49) {
            QLog.d("MetaDreamInjectImpl", 1, "doOnUpdateTadRedTouch mIsShowRedPoint=", Boolean.valueOf(this.f182390d));
            if (!this.f182390d) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.this.U(frameFragment);
                    }
                }, 900L);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TabDataHelper.TAB_META_DREAM;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean h(com.tencent.mobileqq.activity.home.impl.d dVar, FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar, (Object) frameFragment)).booleanValue();
        }
        boolean c16 = dVar.c(TabDataHelper.TAB_META_DREAM);
        if (f182389h != c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder b16 = dVar.b();
        b16.append("toShowMetaDream: ");
        b16.append(c16);
        b16.append(" ");
        b16.append("isMetaDreamTabChange: ");
        b16.append(z16);
        b16.append(" ");
        return z16;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, final FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 49) {
            QLog.d("MetaDreamInjectImpl", 1, "doOnUpdateTadRedTouch mIsShowRedPoint=", Boolean.valueOf(this.f182390d));
            if (!this.f182390d) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.this.V(frameFragment);
                    }
                }, 900L);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            W(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
        } else {
            frameFragment.updateTabFaceId(com.tencent.mobileqq.activity.home.impl.a.f183048k, R.drawable.h_v, R.drawable.h_w);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void r(com.tencent.mobileqq.activity.home.impl.d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
            return;
        }
        String N = N();
        boolean isExtendTabShow = TabDataHelper.isExtendTabShow(MobileQQ.sMobileQQ, N, TabDataHelper.TAB_META_DREAM);
        boolean isTabOverflow = TabDataHelper.isTabOverflow(MobileQQ.sMobileQQ, N);
        if (isExtendTabShow && !isTabOverflow) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f182391e = z16;
        QLog.d("MetaDreamInjectImpl", 1, "doOnCheckBusinessSwitch, isExtendTabShow=", isExtendTabShow + ", isTabOverflow=" + isTabOverflow);
        dVar.f(TabDataHelper.TAB_META_DREAM, this.f182391e);
        ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).setTabOn(this.f182391e);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H(TabDataHelper.TAB_META_DREAM).F(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass()).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183048k).Q(com.tencent.mobileqq.activity.home.impl.b.f183057t).w(R.drawable.qui_tab_meta_dream_default).x(R.drawable.qui_tab_meta_dream_default_pressed).N(R.string.f16525281).t(20).u(0).y(R.drawable.qui_tab_meta_dream_simple).z(R.drawable.qui_tab_meta_dream_simple_pressed).J("meta_dream.json").I("meta_dream_back.json").D(R.drawable.h_v).E(R.drawable.h_v).M(true).K(true).P(TabDataHelper.VALUE_SETTING_META_DREAM_REPORT).O(TabDataHelper.VALUE_SETTING_META_DREAM_CLICK).v(R.drawable.qui_tab_meta_dream_default_dark).R(R.drawable.skin_tab_icon_5).A());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabContentDescription(frameFragment, com.tencent.mobileqq.activity.home.impl.b.f183057t, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
            return;
        }
        if (i3 != i16) {
            int i17 = com.tencent.mobileqq.activity.home.impl.a.f183048k;
            if (i3 == i17) {
                QLog.d("MetaDreamInjectImpl", 1, "doOnUpdateFrameOnTabChange, notifyTabChange false");
                FrameHelperActivity.gj(true, "MetaDreamInjectImpl");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.P();
                    }
                });
            } else if (i16 == i17) {
                QLog.d("MetaDreamInjectImpl", 1, "doOnUpdateFrameOnTabChange, notifyTabChange true");
                FrameHelperActivity.gj(false, "MetaDreamInjectImpl");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.Q();
                    }
                });
                if (this.f182390d) {
                    K(frameFragment);
                }
            }
            int i18 = com.tencent.mobileqq.activity.home.impl.a.f183045h;
            if (i3 == i18) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.R();
                    }
                });
            } else if (i16 == i18) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.S();
                    }
                });
            }
            if (i16 == com.tencent.mobileqq.activity.home.impl.a.f183045h || i16 == com.tencent.mobileqq.activity.home.impl.a.f183041d) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.framebusiness.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.T();
                    }
                });
            }
        }
        W(frameFragment, i3, beVar, i16);
    }
}
