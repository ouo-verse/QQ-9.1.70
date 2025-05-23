package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.home.impl.c;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.activity.framebusiness.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f182319d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f182320e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f182321f;

    /* renamed from: h, reason: collision with root package name */
    public static final Random f182322h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment.DragViewTouchListener f182323d;

        a(FrameFragment.DragViewTouchListener dragViewTouchListener) {
            this.f182323d = dragViewTouchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) dragViewTouchListener);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).mainPageReport(com.tencent.mobileqq.dt.api.c.Q, motionEvent);
            return this.f182323d.onTouch(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.framebusiness.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7165b implements TabDragAnimationView.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182325a;

        C7165b(FrameFragment frameFragment) {
            this.f182325a = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) frameFragment);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabDragAnimationView.b
        public void onDragEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.C(this.f182325a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameFragment f182327d;

        c(FrameFragment frameFragment) {
            this.f182327d = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) frameFragment);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                if (this.f182327d.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TabFrameControllerImplBusiness", 2, "Mainfragment onLongClick");
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long j3 = this.f182327d.mOnDoubleTapTimestamp;
                    long j16 = uptimeMillis - j3;
                    if (j3 > 0 && j16 < 1000) {
                        QLog.d("TabFrameControllerImplBusiness", 1, "Mainfragment onLongClick interval = [" + j16 + "], not start multi aio");
                        z16 = false;
                    }
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        f182319d = com.tencent.mobileqq.activity.home.impl.b.f183049l;
        f182320e = new int[]{R.drawable.skin_tab_icon_conversation_selected, R.drawable.d1g, R.drawable.d1h, R.drawable.d1i, R.drawable.d1j, R.drawable.d1k, R.drawable.chh, R.drawable.d1l};
        f182321f = new int[]{R.drawable.skin_tab_icon_conversation_normal, R.drawable.d1m, R.drawable.d1n, R.drawable.d1o};
        f182322h = new Random();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void C(FrameFragment frameFragment) {
        int i3;
        TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(com.tencent.mobileqq.activity.home.impl.a.f183038a);
        String str = (String) tabDragAnimationView.getTag();
        if (QLog.isColorLevel()) {
            QLog.d("DynimiIcon", 2, "onConversationTabIconMoveResult mIsDefaultTheme = " + frameFragment.mIsDefaultTheme + ", tag = " + str);
        }
        if (frameFragment.mIsDefaultTheme && frameFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a && !TextUtils.isEmpty(str) && str.equals(com.tencent.mobileqq.activity.home.impl.b.f183049l)) {
            Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
            if (conversation != null) {
                i3 = conversation.mUnReadCount;
            } else {
                i3 = 0;
            }
            if (i3 <= 0) {
                F(frameFragment, tabDragAnimationView, frameFragment.app, frameFragment.mVibratorRunnable);
                if (!frameFragment.mIsPlayIcon) {
                    frameFragment.mIsPlayIcon = true;
                }
            }
        }
    }

    private void D(FrameFragment frameFragment, int i3, be beVar, int i16) {
        int i17;
        boolean z16;
        if (frameFragment == null) {
            return;
        }
        QUIBadge qUIBadge = (QUIBadge) frameFragment.getTabNotifyIcon(com.tencent.mobileqq.activity.home.impl.b.f183049l + "_num");
        if (qUIBadge != null) {
            if (qUIBadge.hasContent()) {
                i17 = 2;
            } else {
                i17 = 1;
            }
            String tabNameFromTabIndex = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getTabNameFromTabIndex(i16);
            if (tabNameFromTabIndex != null) {
                z16 = tabNameFromTabIndex.equals(com.tencent.mobileqq.activity.home.impl.b.f183063z);
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.activity.home.impl.b.j(qUIBadge, com.tencent.mobileqq.activity.home.impl.b.g(10000), i17, Boolean.valueOf(z16));
        }
    }

    private void E(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment) {
        com.tencent.mobileqq.perf.startup.f.g("FrameControllerInjectImpl.setConversionTab");
        ei.a(null, "Main_ui_create_tab0");
        tabFrameControllerImpl.addFrame(frameFragment, frameFragment.mRootView, Conversation.class, frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONVERSATION));
        ei.a("Main_ui_create_tab0", "Main_ui_create_tab123");
        com.tencent.mobileqq.perf.startup.f.h("FrameControllerInjectImpl.setConversionTab");
    }

    public static void F(FrameFragment frameFragment, TabDragAnimationView tabDragAnimationView, AppRuntime appRuntime, Runnable runnable) {
        int[] iArr = f182320e;
        int length = iArr.length - 1;
        int length2 = iArr.length - 1;
        int nextInt = f182322h.nextInt(100000) % length;
        if (nextInt == FrameFragment.mPreResIndex) {
            nextInt = (nextInt + 1) % length;
        }
        FrameFragment.mPreResIndex = nextInt;
        if (!((ITabFrameController) QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(frameFragment.app)) {
            length2 = nextInt;
        }
        tabDragAnimationView.setBgPressedDrawable(iArr[length2]);
        if (runnable != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(runnable);
            ThreadManager.getSubThreadHandler().post(runnable);
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynimiIcon", 2, "updateTabFocusIcon currIndex = " + nextInt);
        }
        ReportController.o(appRuntime, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
        if (FrameFragment.isFirstChangeIcon) {
            FrameFragment.isFirstChangeIcon = false;
            ReportController.o(appRuntime, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
        }
    }

    private boolean G() {
        if (((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).isNewLayerMode() && uq3.c.M6()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByClazz = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Conversation.class);
        frameInfoByClazz.w(com.tencent.mobileqq.activity.home.impl.a.f183038a);
        QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + frameInfoByClazz.k().getName() + " tabIndex: " + frameInfoByClazz.l());
    }

    public void B(FrameFragment frameFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) frameFragment, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynimiIcon", 2, "onConversationTabIconDoubleClick mIsDefaultTheme = " + frameFragment.mIsDefaultTheme + ", unread = " + i3);
        }
        AppRuntime appRuntime = frameFragment.app;
        if (appRuntime != null) {
            MqqHandler handler = ((QQAppInterface) appRuntime).getHandler(Conversation.class);
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(1071);
                obtainMessage.arg1 = i3;
                handler.sendMessage(obtainMessage);
            }
            if (frameFragment.mIsDefaultTheme) {
                F(frameFragment, frameFragment.mTabDragIcon.get(com.tencent.mobileqq.activity.home.impl.a.f183038a), frameFragment.app, frameFragment.mVibratorRunnable);
                if (!frameFragment.mIsPlayIcon) {
                    frameFragment.mIsPlayIcon = true;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) frameFragment);
        } else {
            D(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void b(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            E(tabFrameControllerImpl, frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void c(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameFragment);
            return;
        }
        be frame = frameFragment.getFrame(Conversation.class);
        if (frame != null) {
            ((Conversation) frame).onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void d(FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) frameFragment);
            return;
        }
        if (G()) {
            return;
        }
        TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(com.tencent.mobileqq.activity.home.impl.a.f183038a);
        SkinEngine instances = SkinEngine.getInstances();
        int i3 = R.drawable.skin_tab_icon_1;
        boolean checkResExist = instances.checkResExist(R.drawable.skin_tab_icon_1);
        int i16 = R.drawable.skin_tab_icon_1_selected;
        if (checkResExist && SkinEngine.getInstances().checkResExist(R.drawable.skin_tab_icon_1_selected)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i16 = f182320e[0];
        }
        tabDragAnimationView.setBgPressedDrawable(i16);
        if (!z16) {
            i3 = f182321f[0];
        }
        tabDragAnimationView.setBgDrawable(i3);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void e(Context context, HashMap<String, View> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context, (Object) hashMap);
        } else if (hashMap != null && hashMap.get(TabDataHelper.TAB_CONVERSATION) != null) {
            hashMap.get(TabDataHelper.TAB_CONVERSATION).setOnClickListener(new FrameFragment.DragViewPunctureClickListener());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void f(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, tianshuRedTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 35) {
            frameFragment.updateTabSetting(redTypeInfo, iRedTouchManager);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TabDataHelper.TAB_CONVERSATION;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void i(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, redTouch, frameFragment, Integer.valueOf(i3), redTypeInfo, iRedTouchManager);
        } else if (i3 == 35) {
            frameFragment.updateTabSetting(redTypeInfo, iRedTouchManager);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void j(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) frameFragment);
            return;
        }
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONVERSATION).findViewById(R.id.j_k);
        tabDragAnimationView.setTag(com.tencent.mobileqq.activity.home.impl.b.f183049l);
        tabDragAnimationView.setOnDragListener(new C7165b(frameFragment));
        tabDragAnimationView.setOnLongClickListener(new c(frameFragment));
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void k(HashMap<String, View> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, hashMap, Boolean.valueOf(z16));
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(hashMap.get(f182319d), z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void l(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) frameFragment);
        } else if (frameFragment.getCurrentTab() == com.tencent.mobileqq.activity.home.impl.a.f183038a) {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).revertTabIconChange(frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void m(FrameFragment frameFragment) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) frameFragment);
            return;
        }
        Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
        if (conversation != null) {
            i3 = conversation.mUnReadCount;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynimiIcon", 2, "onDoubleTap() unReadCount = " + i3);
        }
        B(frameFragment, i3);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void n(AppRuntime appRuntime, SparseArray<TabDragAnimationView> sparseArray, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 3;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, appRuntime, sparseArray, Integer.valueOf(i3));
            return;
        }
        if (G()) {
            return;
        }
        TabDragAnimationView tabDragAnimationView = sparseArray.get(com.tencent.mobileqq.activity.home.impl.a.f183038a);
        if (((ITabFrameController) QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(appRuntime)) {
            i16 = f182320e.length - 1;
            FrameFragment.mPreResIndex = i16;
        } else if (i3 >= 30) {
            i16 = 5;
            FrameFragment.mPreResIndex = 5;
            c16 = 2;
        } else {
            FrameFragment.mPreResIndex = 0;
            c16 = 0;
        }
        tabDragAnimationView.setBgPressedDrawable(f182320e[i16]);
        tabDragAnimationView.setBgDrawable(f182321f[c16]);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            D(frameFragment, 0, null, -1);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void p(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) frameFragment);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynimiIcon", 2, "revertConversationIconChange mPreResIndex = " + FrameFragment.mPreResIndex);
        }
        FrameFragment.isFirstChangeIcon = true;
        int i3 = 0;
        frameFragment.mIsPlayIcon = false;
        Conversation conversation = (Conversation) frameFragment.getFrame(Conversation.class);
        if (conversation != null) {
            i3 = conversation.mUnReadCount;
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabDefaultFocusIcon(frameFragment.app, frameFragment.mIsDefaultTheme, frameFragment.mTabDragIcon, i3);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void q(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) frameFragment);
        } else {
            frameFragment.updateTabFaceId(com.tencent.mobileqq.activity.home.impl.a.f183038a, R.drawable.h_x, R.drawable.h_y);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public boolean t(AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) appRuntime)).booleanValue();
        }
        com.tencent.imcore.message.n f16 = ((QQAppInterface) appRuntime).getProxyManager().f();
        if (f16 != null && com.tencent.mobileqq.activity.recent.g.c().f185399b.size() > 0) {
            ArrayList<RecentBaseData> arrayList = new ArrayList(com.tencent.mobileqq.activity.recent.g.c().f185399b);
            if (arrayList.size() > 0) {
                for (RecentBaseData recentBaseData : arrayList) {
                    if (recentBaseData != null) {
                        int i3 = recentBaseData.mUnreadFlag;
                        if (i3 != 1 && i3 != 4) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16 && f16.n(recentBaseData)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            TabFrameControllerImpl.registerFrameInfo(c.b.B().H(TabDataHelper.TAB_CONVERSATION).F(Conversation.class).L(false).G(com.tencent.mobileqq.activity.home.impl.a.f183038a).Q(com.tencent.mobileqq.activity.home.impl.b.f183049l).w(R.drawable.qui_tab_conversation_default).x(R.drawable.qui_tab_conversation_default_pressed).N(R.string.c76).t(11).u(2).y(R.drawable.qui_tab_conversation_simple).z(R.drawable.qui_tab_conversation_simple_pressed).J("conversation.json").I("conversation_back.json").D(R.drawable.h_x).E(R.drawable.h_y).M(true).K(false).v(R.drawable.qui_tab_conversation_default_dark).R(R.drawable.skin_tab_icon_1).A());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void v(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateTabContentDescription(frameFragment, com.tencent.mobileqq.activity.home.impl.b.f183049l, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void w(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) frameFragment, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void x(FrameFragment frameFragment, FrameFragment.DragViewTouchListener dragViewTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameFragment, (Object) dragViewTouchListener);
            return;
        }
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONVERSATION).findViewById(R.id.j_k);
        tabDragAnimationView.setOnTouchListener(new a(dragViewTouchListener));
        tabDragAnimationView.h(QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME);
        TextView textView = (TextView) frameFragment.mTabViewMap.get(TabDataHelper.TAB_CONVERSATION).findViewById(R.id.kbi);
        TabDragAnimationView.G(textView);
        frameFragment.mTabDragIcon.put(com.tencent.mobileqq.activity.home.impl.a.f183038a, tabDragAnimationView);
        frameFragment.mTabTextView.put(com.tencent.mobileqq.activity.home.impl.a.f183038a, textView);
        y(frameFragment, -1, null, com.tencent.mobileqq.activity.home.impl.a.f183038a);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        Conversation conversation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = com.tencent.mobileqq.activity.home.impl.b.f183049l;
        sb5.append(str);
        sb5.append("_num");
        QUIBadge qUIBadge = (QUIBadge) frameFragment.getTabNotifyIcon(sb5.toString());
        if (qUIBadge == null) {
            QLog.d("Conversation", 2, "getNumber badge fail");
            return;
        }
        int i17 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
        if (i16 == i17) {
            qUIBadge.setTag(str);
            qUIBadge.setOnModeChangeListener(frameFragment.mDragHost);
            qUIBadge.setDragGroup(str);
            qUIBadge.setDragType(2);
            TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(com.tencent.mobileqq.activity.home.impl.a.f183038a);
            MainFragment mainFragment = (MainFragment) frameFragment;
            mainFragment.f182812t0.f185379d = tabDragAnimationView;
            if (tabDragAnimationView != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
                }
                try {
                    tabDragAnimationView.setOnDoubleTapListener(frameFragment.mFrameDoubleTapListener);
                    qUIBadge.setOnDoubleTapListener(frameFragment.mFrameDoubleTapListener);
                } catch (Throwable th5) {
                    QLog.e("DynimiIcon", 2, th5, new Object[0]);
                }
            }
            mainFragment.f182812t0.f185380e = qUIBadge;
        } else {
            try {
                TabDragAnimationView tabDragAnimationView2 = frameFragment.mTabDragIcon.get(i17);
                if (tabDragAnimationView2 != null) {
                    tabDragAnimationView2.setOnDoubleTapListener(null);
                }
                qUIBadge.setOnDoubleTapListener(null);
            } catch (Throwable th6) {
                QLog.e("DynimiIcon", 2, th6, new Object[0]);
            }
            qUIBadge.setOnModeChangeListener(null);
        }
        int i18 = com.tencent.mobileqq.activity.home.impl.a.f183038a;
        if (i3 == i18 && i16 != i18 && (conversation = (Conversation) frameFragment.getFrame(Conversation.class)) != null) {
            conversation.onConversationTabExit();
        }
        D(frameFragment, i3, beVar, i16);
    }
}
