package com.tencent.mobileqq.activity.home.impl;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.j;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.u;
import com.tencent.mobileqq.activity.home.w;
import com.tencent.mobileqq.activity.home.x;
import com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.perf.startup.api.IQQFramesMonitor;
import com.tencent.mobileqq.perf.startup.api.IStartupMonitor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.crash.api.IRenderInSubThreadMonitor;
import com.tencent.mobileqq.tab.g;
import com.tencent.mobileqq.tianshu.api.IRedPointReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.mobileqq.widget.bn;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TabFrameControllerImpl implements ITabFrameController {
    static IPatchRedirector $redirector_ = null;
    public static final float EXTRA_LARGE_MARGIN_LEFT = -10.0f;
    public static final float TAB_HOST_HEIGHT_DP_DEFAULT_THEME = 54.0f;
    public static final float TAB_HOST_HEIGHT_DP_THIRD_PARTY_THEME = 64.0f;
    public static final String TAG = "FrameUtil.TabFrameControllerImpl";
    protected static ArrayList<c> mFrameInfoBeans;
    protected static final Map<String, w> sFrameBusinessCallbacks;
    protected static x sFrameControllerInjectInterface;
    private Drawable mCurrentTabHostBg;
    private d mFrameInitBean;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements com.tencent.mobileqq.tab.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameFragment f183035a;

        a(FrameFragment frameFragment) {
            this.f183035a = frameFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TabFrameControllerImpl.this, (Object) frameFragment);
            }
        }

        @Override // com.tencent.mobileqq.tab.d
        public void a(int i3, int i16) {
            be currentFrame;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == i16 && (currentFrame = this.f183035a.getCurrentFrame()) != null) {
                currentFrame.onFrameTabClick();
            }
            if (i3 != -1) {
                try {
                    String currentTabTag = this.f183035a.mTabIndicator.getCurrentTabTag();
                    FrameFragment frameFragment = this.f183035a;
                    if (i3 == i16) {
                        z16 = true;
                    }
                    TabControlReporter.i(frameFragment, currentTabTag, i16, z16);
                    int tabIndexFromName = TabFrameControllerImpl.this.getTabIndexFromName(currentTabTag);
                    QLog.i(TabFrameControllerImpl.TAG, 1, "onTabSelected tabIndex: " + tabIndexFromName);
                    TabFrameControllerImpl.this.dispatchUpdateFrameOnTabClick(this.f183035a, tabIndexFromName, currentTabTag);
                } catch (Exception e16) {
                    QLog.e(TabFrameControllerImpl.TAG, 1, "onTabSelected excetpion: " + e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.tab.d
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.i(TabFrameControllerImpl.TAG, 1, "beforeTabChanged tabId: " + str);
            if (af.d()) {
                this.f183035a.createTabContent(str);
            }
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else if ((com.tencent.mobileqq.activity.home.impl.b.B.equals(str) || com.tencent.mobileqq.activity.home.impl.b.C.equals(str)) && ((ILebaDataServicesApi) QRoute.api(ILebaDataServicesApi.class)).redTouchContainerNewGuide().booleanValue()) {
                ((ILebaDataServicesApi) QRoute.api(ILebaDataServicesApi.class)).hiddeNewGuide();
            }
        }

        @Override // com.tencent.mobileqq.tab.d
        public void onTabChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.i(TabFrameControllerImpl.TAG, 1, "onTabChanged tabId: " + str);
            c(str);
            this.f183035a.onTabChanged(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements GestureDetector.OnDoubleTapListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private FrameFragment f183037d;

        public b(FrameFragment frameFragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameFragment);
            } else {
                this.f183037d = frameFragment;
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TabFrameControllerImpl.TAG, 2, "onDoubleTap() called with: e = [" + motionEvent + "]");
            }
            this.f183037d.mOnDoubleTapTimestamp = SystemClock.uptimeMillis();
            TabFrameControllerImpl.dispatchOnDoubleTap(this.f183037d);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 62)) {
            redirector.redirect((short) 62);
            return;
        }
        sFrameBusinessCallbacks = new LinkedHashMap();
        mFrameInfoBeans = new ArrayList<>();
        try {
            Iterator<Class<? extends w>> it = u.f183142b.iterator();
            while (it.hasNext()) {
                w newInstance = it.next().newInstance();
                sFrameBusinessCallbacks.put(newInstance.getKey(), newInstance);
            }
            if (u.f183141a.size() > 0) {
                sFrameControllerInjectInterface = u.f183141a.get(0).newInstance();
            }
            dispatchRegisterInfo();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "TabFrameControllerImpl static statement: ", e16);
        }
    }

    public TabFrameControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCurrentTabHostBg = null;
        }
    }

    private void dispatchFragmentDrawerClose(FrameFragment frameFragment, int i3, int i16) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().onFragmentDrawerClosed(frameFragment, i3, i16);
        }
    }

    static void dispatchOnDoubleTap(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().m(frameFragment);
        }
    }

    static void dispatchRegisterInfo() {
        ArrayList<c> arrayList = mFrameInfoBeans;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().u();
        }
    }

    private static View generateRedTouch(Context context, FrameFragment frameFragment, View view, String str) {
        if (TianshuRedTouch.INSTANCE.j()) {
            TianshuRedTouch t16 = new TianshuRedTouch(context, view).h0(49).p0(TianshuRedTouch.RedTouchAssembleType.ME_REDTOUCH).r0(3.0f).j0(8.0f).t();
            QLog.d(TAG, 1, "buildTabIcon redTouch: " + str, "view" + view.toString());
            return t16;
        }
        RedTouch useRobotoTtf = new RedTouchTab(context, view).setGravity(49).setTopMargin(3.0f).setLeftAlign(true).setLeftMargin(5).applyTo().setUseRobotoTtf();
        QLog.d(TAG, 1, "buildTabIcon redTouch: " + str);
        return useRobotoTtf;
    }

    private View generateTabItem(c cVar) {
        View generateTabItem = generateTabItem(cVar.i(), cVar.d(), cVar.j(), cVar.e(), cVar.p(), cVar.h(), cVar.a(), cVar.b(), cVar.f(), cVar.g(), cVar.o(), cVar.n());
        QLog.d(TAG, 1, "buildTabIcon matching infoBean: " + cVar.m());
        return generateTabItem;
    }

    @Nullable
    private static Integer getInteger(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.A, 5);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.B, 0);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.C, 0);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.D, 7);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.E, 7);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.F, 102);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.G, 101);
        hashMap.put(com.tencent.mobileqq.activity.home.impl.b.H, 103);
        return (Integer) hashMap.get(str);
    }

    private ViewParent getTabHostBg(View view) {
        View findViewById;
        ViewParent parent;
        if (!(view instanceof QQTabHost) || (findViewById = view.findViewById(R.id.tabhost)) == null || (parent = findViewById.getParent()) == null) {
            return null;
        }
        return parent.getParent();
    }

    private boolean isChannelTab(FrameFragment frameFragment, int i3) {
        if (!frameFragment.mIsDefaultTheme && com.tencent.mobileqq.activity.home.impl.a.f183047j == i3) {
            return true;
        }
        return false;
    }

    public static boolean isLazyLoadTabView() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_drag_animation_view_908_115283916", true);
    }

    private Boolean isSwitchOn(String str, Boolean bool) {
        try {
            return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn(str, bool);
        } catch (Exception unused) {
            return bool;
        }
    }

    public static void registerFrameInfo(c cVar) {
        if (mFrameInfoBeans == null) {
            QLog.d(TAG, 1, "registerFrameInfo mFrameInfoBeans == null");
            return;
        }
        QLog.d(TAG, 1, "registerFrameInfo frameInfoBean index: " + cVar.l() + "ClassName: " + cVar.k().getName());
        mFrameInfoBeans.add(cVar);
    }

    private void reportTabChange(FrameFragment frameFragment, String str, String str2, be beVar) {
        if (TianshuRedTouch.INSTANCE.j() && str != null && frameFragment != null) {
            Integer integer = getInteger(str);
            if (integer != null && integer.intValue() == 0) {
                ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroClick(integer.intValue());
            }
            IRedTouchServer iRedTouchServer = (IRedTouchServer) frameFragment.app.getRuntimeService(IRedTouchServer.class, "");
            if (iRedTouchServer != null) {
                iRedTouchServer.sendRedpointReq(false, false, 11);
            }
        }
    }

    private void updateTabInfo(TianshuRedTouch tianshuRedTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (tianshuRedTouch == null) {
            return;
        }
        if (redTypeInfo != null) {
            QUIBadge qUIBadge = (QUIBadge) tianshuRedTouch.findViewById(com.tencent.mobileqq.R.id.khc);
            if (redTypeInfo.red_type.has() && redTypeInfo.red_type.get() == 5) {
                if (qUIBadge != null) {
                    qUIBadge.setRedNum(com.tencent.mobileqq.tianshu.ui.b.b(redTypeInfo));
                    qUIBadge.setDragType(0);
                    qUIBadge.setVisibility(0);
                }
                tianshuRedTouch.B0(null);
                return;
            }
            tianshuRedTouch.B0(redTypeInfo);
            if (qUIBadge != null) {
                qUIBadge.setVisibility(8);
                return;
            }
            return;
        }
        QUIBadge qUIBadge2 = (QUIBadge) tianshuRedTouch.findViewById(com.tencent.mobileqq.R.id.khc);
        if (qUIBadge2 != null) {
            qUIBadge2.setVisibility(8);
        }
        tianshuRedTouch.B0(null);
    }

    private void updateTabInfoWording(TianshuRedTouch tianshuRedTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (tianshuRedTouch == null) {
            return;
        }
        QUIBadge qUIBadge = (QUIBadge) tianshuRedTouch.findViewById(com.tencent.mobileqq.R.id.khc);
        if (qUIBadge != null && redTypeInfo != null) {
            qUIBadge.setDragType(0);
            qUIBadge.setVisibility(0);
            String str = redTypeInfo.red_content.get();
            if (str != null) {
                qUIBadge.setRedText(str);
            } else {
                qUIBadge.setRedText("\u66f4\u65b0");
            }
        } else if (qUIBadge != null) {
            qUIBadge.setVisibility(8);
        }
        tianshuRedTouch.B0(null);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void addFrame(FrameFragment frameFragment, View view, Class<? extends Frame> cls, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, frameFragment, view, cls, view2);
            return;
        }
        if (frameFragment.mTabHost == null) {
            frameFragment.mTabHost = (FrameFragment.c) view.findViewById(af.c());
            frameFragment.mTabWidget = (ViewGroup) view.findViewById(af.f());
            frameFragment.mTabIndicator = (FrameFragment.d) view.findViewById(af.g());
            QLog.i(TAG, 1, "addFrame mTabHost:" + System.identityHashCode(frameFragment.mTabHost));
            frameFragment.mTabHost.setup(frameFragment);
            frameFragment.mTabIndicator.setOnTabSelectionListener(new a(frameFragment));
            frameFragment.mTabSpecCache = new HashMap<>(4);
        }
        String name = cls.getName();
        FrameFragment.e eVar = frameFragment.mTabSpecCache.get(name);
        if (eVar == null) {
            if (af.d()) {
                eVar = new g(((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(cls), view2);
            } else {
                eVar = new QQTabHost.b(((QQTabHost) frameFragment.mTabHost).newTabSpec(name).setIndicator(view2).setContent(frameFragment), view2);
            }
            frameFragment.mTabSpecCache.put(name, eVar);
        }
        ArrayList<FrameFragment.e> arrayList = frameFragment.mTabHostTabList;
        if (arrayList != null) {
            arrayList.add(eVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void addFrameIndividual(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tabFrameControllerImpl, frameFragment, dVar);
        } else {
            dispatchAddFrameIndividual(tabFrameControllerImpl, frameFragment, dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        r4 = ((com.tencent.mobileqq.activity.home.ITabFrameCreator) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.activity.home.ITabFrameCreator.class)).buildFrameByKey(r5.m(), r8);
        r8 = com.tencent.mobileqq.util.cv.f306745a;
        com.tencent.mobileqq.util.cv.c("buildFrame_" + r5.m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
    
        if (r4 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.TAG, 1, "buildFrame not set creator for key: " + r5.m());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0096, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDebugVersion() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b1, code lost:
    
        throw new java.lang.RuntimeException("buildFrame not set creator for key: " + r5.m());
     */
    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Frame buildFrame(FrameFragment frameFragment, String str) {
        Frame frame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Frame) iPatchRedirector.redirect((short) 20, (Object) this, (Object) frameFragment, (Object) str);
        }
        QLog.d(TAG, 1, "buildFrame before tag: " + str);
        int i3 = 0;
        while (true) {
            frame = null;
            try {
                if (i3 >= mFrameInfoBeans.size()) {
                    break;
                }
                c cVar = mFrameInfoBeans.get(i3);
                if (str.equals(cVar.k().getName())) {
                    break;
                }
                i3++;
            } catch (Exception e16) {
                String str2 = "buildFrame error for" + str + ProgressTracer.SEPARATOR;
                if (!QLog.isDebugVersion()) {
                    QLog.e(TAG, 1, str2, e16);
                } else {
                    throw new RuntimeException(str2, e16);
                }
            }
        }
        if (frame == null) {
            QLog.d(TAG, 1, "buildFrame null tag: " + str);
        }
        return frame;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public View buildSingleTabIcon(String str, FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (View) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) frameFragment);
        }
        Iterator<c> it = mFrameInfoBeans.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.m().equals(str) && next.v()) {
                QLog.i(TAG, 1, "buildSingleTabIcon  key:" + str);
                View generateTabItem = generateTabItem(next);
                frameFragment.mTabViewMap.put(str, generateTabItem);
                QLog.i(TAG, 1, "buildSingleTabIcon  key:" + str + ", view=" + generateTabItem);
                w wVar = sFrameBusinessCallbacks.get(str);
                if (wVar == null) {
                    QLog.e(TAG, 1, "frameBusiness is null, key:" + str);
                } else {
                    wVar.e(frameFragment.getBaseActivity(), frameFragment.mTabViewMap);
                }
                if (next.u()) {
                    View generateRedTouch = generateRedTouch(frameFragment.getBaseActivity(), frameFragment, generateTabItem, str);
                    frameFragment.mTabViewMap.put(str, generateRedTouch);
                    QLog.i(TAG, 1, "buildSingleTabIcon  key:" + str + ", redTouch=" + generateRedTouch);
                    return generateRedTouch;
                }
                return generateTabItem;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public TabViewMap buildTabIcon(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TabViewMap) iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
        }
        QLog.d(TAG, 1, "buildTabIcon before");
        boolean isLazyLoadTabView = isLazyLoadTabView();
        QLog.i(TAG, 1, "isLazyLoadTabView lazyLoad:" + isLazyLoadTabView);
        d a16 = d.a();
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).checkBusinessSwitch(a16);
        TabViewMap tabViewMap = new TabViewMap();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
            c cVar = mFrameInfoBeans.get(i3);
            if (cVar.v()) {
                String m3 = cVar.m();
                if (!a16.c(m3) && isLazyLoadTabView) {
                    sb5.append("buildTabIcon business off, key:");
                    sb5.append(m3);
                    sb5.append("\n");
                } else {
                    View generateTabItem = generateTabItem(cVar);
                    QLog.i(TAG, 1, "buildTabIcon  key:" + m3);
                    tabViewMap.put(m3, generateTabItem);
                }
            }
        }
        if (sb5.length() > 0) {
            QLog.d(TAG, 1, sb5.toString());
        }
        dispatchBuildIconClkListener(context, tabViewMap);
        for (int i16 = 0; i16 < mFrameInfoBeans.size(); i16++) {
            c cVar2 = mFrameInfoBeans.get(i16);
            if (cVar2.v() && cVar2.u()) {
                String m16 = cVar2.m();
                if (a16.c(m16) || !isLazyLoadTabView) {
                    View generateRedTouch = generateRedTouch(context, null, tabViewMap.get(m16), m16);
                    QLog.i(TAG, 1, "buildTabIcon  key:" + m16 + ", RedTouchTab=" + generateRedTouch);
                    tabViewMap.put(m16, generateRedTouch);
                }
            }
        }
        QLog.d(TAG, 1, "buildTabIcon after");
        return tabViewMap;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void checkBusinessSwitch(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        } else {
            dispatchCheckBusinessSwitch(dVar);
        }
    }

    public void checkEnableTabAnim(FrameFragment frameFragment, boolean z16) {
        float f16;
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, frameFragment, Boolean.valueOf(z16));
            return;
        }
        ((IStartupMonitor) QRoute.api(IStartupMonitor.class)).traceBegin("TabFrameControllerImpl.checkEnableTabAnim");
        frameFragment.mIsDefaultTheme = com.tencent.mobileqq.activity.home.impl.b.l();
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "checkEnableTabAnim() called with: onPostThemeChanged = [" + z16 + "], mIsDefaultTheme=[" + frameFragment.mIsDefaultTheme + "]");
        }
        float f17 = frameFragment.getResources().getDisplayMetrics().density;
        if (QQTheme.isCustomTheme("", false)) {
            f16 = 64.0f;
        } else {
            f16 = 54.0f;
        }
        int round = Math.round(f16 * f17);
        replaceExtraIcon(frameFragment, Math.round(6.0f * f17));
        URLDrawable uRLDrawable = null;
        if (frameFragment.mTabDragIcon != null) {
            if (frameFragment.mIsDefaultTheme) {
                updateTabDefaultFocusIcon(frameFragment.app, frameFragment.mIsDefaultTheme, frameFragment.mTabDragIcon, sFrameControllerInjectInterface.k(frameFragment));
            } else {
                dispatchResetTabDrag(frameFragment);
            }
            boolean isNowThemeIsAnimate = ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).isNowThemeIsAnimate();
            int i18 = 0;
            while (i18 < frameFragment.mTabDragIcon.size()) {
                TabDragAnimationView valueAt = frameFragment.mTabDragIcon.valueAt(i18);
                valueAt.H0 = isNowThemeIsAnimate;
                valueAt.G0 = uRLDrawable;
                if (!frameFragment.mIsDefaultTheme && !TabDragAnimationView.y()) {
                    i3 = -1;
                } else {
                    i3 = (int) ((f17 * 29.0f) + 0.5f);
                }
                if (TabDragAnimationView.t()) {
                    i3 = (int) (f17 * 29.0f);
                }
                valueAt.setIconSize(i3, i3);
                if (TabDragAnimationView.t()) {
                    valueAt.setAnimEnable(false);
                } else {
                    valueAt.setAnimEnable(frameFragment.mIsDefaultTheme);
                }
                if (!frameFragment.mIsDefaultTheme && !TabDragAnimationView.y() && !TabDragAnimationView.t()) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
                valueAt.setIconGravity(i16);
                if (!frameFragment.mIsDefaultTheme && !TabDragAnimationView.y() && !TabDragAnimationView.t()) {
                    i17 = 0;
                } else {
                    i17 = (int) ((5.0f * f17) + 0.5f);
                }
                valueAt.setPadding(0, i17, 0, i17);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(valueAt.getLayoutParams());
                layoutParams.height = round;
                valueAt.setLayoutParams(layoutParams);
                i18++;
                uRLDrawable = null;
            }
        }
        View view = frameFragment.mRootView;
        if (view != null) {
            View findViewById = view.findViewById(af.f());
            if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = round;
                findViewById.setLayoutParams(layoutParams2);
                com.tencent.mobileqq.qui.b.f276860a.c(findViewById, round);
            }
            if (!z16 && frameFragment.mIsDefaultTheme) {
                long currentTimeMillis = System.currentTimeMillis();
                View findViewById2 = frameFragment.mRootView.findViewById(af.b());
                if (findViewById != null && findViewById2 != null) {
                    int paddingBottom = findViewById2.getPaddingBottom();
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "checkEnableTabAnim, height=" + round + ", padding=" + paddingBottom + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }
            View findViewById3 = frameFragment.mRootView.findViewById(af.b());
            QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) frameFragment.mRootView.findViewById(com.tencent.mobileqq.R.id.kmr);
            frameFragment.mTabBlurView = qQBlurViewWrapper;
            qQBlurViewWrapper.setDebugTag("TAB");
            frameFragment.mTabBlurView.setVisibility(8);
            frameFragment.mTabBlurView.onPause();
            frameFragment.mTabBlurView.onDestroy();
            boolean enableBlur = frameFragment.enableBlur();
            QLog.i(TAG, 1, "checkEnableTabAnim  needEnableBlur:" + enableBlur);
            if (enableBlur) {
                frameFragment.enableBlur(findViewById, findViewById3);
            } else {
                frameFragment.disableBlur(findViewById);
            }
            if (frameFragment.mTabDragIcon != null) {
                for (int i19 = 0; i19 < frameFragment.mTabDragIcon.size(); i19++) {
                    TabDragAnimationView valueAt2 = frameFragment.mTabDragIcon.valueAt(i19);
                    if (!TabDragAnimationView.y() && !TabDragAnimationView.t()) {
                        valueAt2.setEnableClickScaleAnimation(true);
                    } else {
                        valueAt2.setEnableClickScaleAnimation(false);
                    }
                    valueAt2.setClickAnimationDrawable(null);
                }
            }
            dispatchUpdateFaceId(frameFragment);
        }
        ((IStartupMonitor) QRoute.api(IStartupMonitor.class)).traceEnd("TabFrameControllerImpl.checkEnableTabAnim");
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public boolean checkFrameChanged(d dVar, FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) dVar, (Object) frameFragment)).booleanValue();
        }
        return dispatchCheckFrameChanged(dVar, frameFragment);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void clearUselessBackground(View view) {
        View view2;
        Drawable background;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) view);
            return;
        }
        Object tabHostBg = getTabHostBg(view);
        if (!(tabHostBg instanceof View) || (background = (view2 = (View) tabHostBg).getBackground()) == null) {
            return;
        }
        this.mCurrentTabHostBg = background;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearUselessBackground: setBackgroundDrawable null");
        }
        view2.setBackgroundDrawable(null);
    }

    void dispatchAddFrameIndividual(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, d dVar) {
        for (w wVar : sFrameBusinessCallbacks.values()) {
            long currentTimeMillis = System.currentTimeMillis();
            wVar.b(tabFrameControllerImpl, frameFragment, dVar);
            ((IQQFramesMonitor) QRoute.api(IQQFramesMonitor.class)).recordFrameAddCost(currentTimeMillis, wVar.getClass().getName());
        }
    }

    void dispatchBuildExtraListener(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().j(frameFragment);
        }
    }

    void dispatchBuildIconClkListener(Context context, HashMap<String, View> hashMap) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().e(context, hashMap);
        }
    }

    void dispatchCheckBusinessSwitch(d dVar) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().r(dVar);
        }
    }

    boolean dispatchCheckFrameChanged(d dVar, FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= it.next().h(dVar, frameFragment);
        }
        return z16;
    }

    boolean dispatchCheckUnReadRedPacket(AppRuntime appRuntime) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= it.next().t(appRuntime);
        }
        return z16;
    }

    void dispatchCommonBusinessOnTabChange(FrameFragment frameFragment, String str) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().w(frameFragment, str);
        }
    }

    void dispatchOnResumeAfter(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().a(frameFragment);
        }
    }

    void dispatchOnRevertIconChange(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().l(frameFragment);
        }
    }

    void dispatchOnTabChangeAfter(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().o(frameFragment);
        }
    }

    void dispatchPostThemeChanged(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().c(frameFragment);
        }
    }

    void dispatchResetTabDrag(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().d(frameFragment);
        }
    }

    void dispatchResumeUpdateSound(HashMap<String, View> hashMap, boolean z16) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().k(hashMap, z16);
        }
    }

    void dispatchTabChangeAfterFramesPause(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().p(frameFragment);
        }
    }

    void dispatchTabContentDescription(FrameFragment frameFragment, String str) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().v(frameFragment, str);
        }
    }

    public void dispatchTabDragIconAddTv(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) frameFragment);
            return;
        }
        FrameFragment.DragViewTouchListener dragViewTouchListener = new FrameFragment.DragViewTouchListener();
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().x(frameFragment, dragViewTouchListener);
        }
    }

    void dispatchUpdateFaceId(FrameFragment frameFragment) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().q(frameFragment);
        }
    }

    void dispatchUpdateFrameInfo() {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().A();
        }
    }

    void dispatchUpdateFrameOnTabChange(FrameFragment frameFragment, int i3, be beVar, int i16) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().y(frameFragment, i3, beVar, i16);
        }
    }

    void dispatchUpdateFrameOnTabClick(FrameFragment frameFragment, int i3, String str) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().s(frameFragment, i3, str);
        }
    }

    void dispatchUpdateTabFocusIcon(AppRuntime appRuntime, SparseArray<TabDragAnimationView> sparseArray, int i3) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().n(appRuntime, sparseArray, i3);
        }
    }

    void dispatchUpdateTadRedBadge(TianshuRedTouch tianshuRedTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().f(tianshuRedTouch, frameFragment, i3, redTypeInfo, iRedTouchManager);
        }
    }

    void dispatchUpdateTadRedTouch(RedTouch redTouch, FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().i(redTouch, frameFragment, i3, redTypeInfo, iRedTouchManager);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void doFramesPauseAfter(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frameFragment);
        } else {
            dispatchOnRevertIconChange(frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void doOnEntry(FrameFragment frameFragment, Intent intent) {
        int i3;
        ArrayList<FrameFragment.e> arrayList;
        FrameFragment.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) frameFragment, (Object) intent);
            return;
        }
        frameFragment.mNewIntent = intent;
        StringBuilder sb5 = new StringBuilder();
        if (QLog.isColorLevel()) {
            sb5.append("doOnNewIntent1 : url");
            sb5.append(intent.getStringExtra("url"));
            sb5.append("\n");
        }
        FrameFragment.mTabWidgetMoveFlag = false;
        if (sFrameControllerInjectInterface.i(frameFragment)) {
            if (QLog.isColorLevel()) {
                sb5.append("doCheckOnEntryInvalid\n");
            }
            if (sb5.length() > 0) {
                QLog.d("doOnEntry", 1, sb5.toString());
                return;
            }
            return;
        }
        sFrameControllerInjectInterface.d(frameFragment, intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        if (extras.getBoolean("EXIT", false)) {
            frameFragment.getBaseActivity().finish();
            return;
        }
        if (extras.containsKey("tab_index")) {
            i3 = extras.getInt("tab_index");
        } else if (extras.containsKey(AppConstants.MainTabIndex.MAIN_TAB_ID)) {
            i3 = mainTabID2TabIndex(extras);
        } else {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            sb5.append("onNewIntent tabIndex: ");
            sb5.append(i3);
            sb5.append("\n");
        }
        if (sb5.length() > 0) {
            QLog.d(TAG, 2, sb5.toString());
        }
        if (frameFragment.mTabHost != null && i3 >= 0 && (arrayList = frameFragment.mTabHostTabListWithOrder) != null && i3 < arrayList.size() && (eVar = frameFragment.mTabHostTabListWithOrder.get(i3)) != null) {
            TabControlReporter.p(eVar.getTag(), i3);
        }
        sFrameControllerInjectInterface.o(frameFragment);
        sFrameControllerInjectInterface.a(frameFragment, intent, extras, i3);
    }

    public int findIndexForList(String str, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) arrayList)).intValue();
        }
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (str.equals(arrayList.get(i3))) {
                    return i3;
                }
            }
        }
        return -100;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public String getCurrentTabTag(FrameFragment.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) dVar);
        }
        if (dVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getCurrentTabTag. mTabHost is null");
                return null;
            }
            return null;
        }
        String currentTabTag = dVar.getCurrentTabTag();
        if (currentTabTag != null) {
            for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
                c cVar = mFrameInfoBeans.get(i3);
                if (currentTabTag.equals(cVar.k().getName())) {
                    return cVar.s();
                }
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public c getFrameInfoByClazz(Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        if (mFrameInfoBeans != null && cls != null) {
            for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
                c cVar = mFrameInfoBeans.get(i3);
                if (cls.getName().equals(cVar.k().getName())) {
                    return cVar;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public c getFrameInfoByIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (mFrameInfoBeans == null) {
            return null;
        }
        for (int i16 = 0; i16 < mFrameInfoBeans.size(); i16++) {
            c cVar = mFrameInfoBeans.get(i16);
            if (i3 == cVar.l()) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public c getFrameInfoByKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (mFrameInfoBeans != null && !TextUtils.isEmpty(str)) {
            for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
                c cVar = mFrameInfoBeans.get(i3);
                if (str.equals(cVar.m())) {
                    return cVar;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public int getTabIndexFromName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
            c cVar = mFrameInfoBeans.get(i3);
            if (str.equals(cVar.k().getName())) {
                return cVar.l();
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public String getTabNameFromTabIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        for (int i16 = 0; i16 < mFrameInfoBeans.size(); i16++) {
            c cVar = mFrameInfoBeans.get(i16);
            Class k3 = cVar.k();
            if (cVar.l() == i3) {
                return k3.getName();
            }
        }
        return "";
    }

    public int getTabNoteTextStyle(HashMap<String, Object> hashMap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) hashMap, (Object) str)).intValue();
        }
        int m3 = sFrameControllerInjectInterface.m(0);
        if (hashMap == null) {
            return m3;
        }
        Object obj = hashMap.get(str + "_new");
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            return sFrameControllerInjectInterface.m(2);
        }
        Object obj2 = hashMap.get(str + "_num");
        if ((obj2 instanceof Integer) && ((Integer) obj2).intValue() > 0) {
            return sFrameControllerInjectInterface.m(3);
        }
        Object obj3 = hashMap.get(str + "_icon");
        if ((obj3 instanceof Boolean) && ((Boolean) obj3).booleanValue()) {
            return sFrameControllerInjectInterface.m(1);
        }
        return m3;
    }

    public String getTagFromType(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, i3, (Object) str);
        }
        switch (i3) {
            case 16:
                return str + "_num";
            case 17:
                return str + "_new";
            case 18:
                return str + "_icon";
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void handleThemeChanged(FrameFragment frameFragment) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) frameFragment);
            return;
        }
        if (frameFragment.simpleUIOn != QQTheme.isNowSimpleUI()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && frameFragment.mTabViewMap != null) {
            setFrames(frameFragment, false, 4);
        }
        dispatchPostThemeChanged(frameFragment);
        checkEnableTabAnim(frameFragment, true);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public boolean hasUnReadRedPacket(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return dispatchCheckUnReadRedPacket(appRuntime);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void initIconExtraListener(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) frameFragment);
        } else {
            dispatchBuildExtraListener(frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void initIconUnReadView(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) frameFragment);
            return;
        }
        for (int i3 = 0; i3 < mFrameInfoBeans.size(); i3++) {
            c cVar = mFrameInfoBeans.get(i3);
            if (cVar.v()) {
                String m3 = cVar.m();
                String s16 = cVar.s();
                View view = frameFragment.mTabViewMap.get(m3);
                if (view != null) {
                    frameFragment.setTabNotifyIcon(s16, view);
                    frameFragment.setTabNotifyIcon(s16 + "_num", view.findViewById(com.tencent.mobileqq.R.id.khc));
                }
            }
        }
    }

    public void initTabDragIconsAndTextViews(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) frameFragment);
        } else {
            frameFragment.mTabDragIcon = new SparseArray<>(3);
            frameFragment.mTabTextView = new SparseArray<>(3);
        }
    }

    public void initTabIndexByConfig(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) dVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder("CONVERSATION CONTACT LEBA");
        if (dVar.c(TabDataHelper.TAB_NEW_WORLD)) {
            sb5.append(" ");
            sb5.append(TabDataHelper.TAB_NEW_WORLD);
        }
        if (dVar.c(TabDataHelper.TAB_RIJ)) {
            sb5.append(" ");
            sb5.append(TabDataHelper.TAB_RIJ);
        }
        if (dVar.c("GUILD")) {
            sb5.append(" ");
            sb5.append("GUILD");
        }
        if (dVar.c(TabDataHelper.TAB_META_DREAM)) {
            sb5.append(" ");
            sb5.append(TabDataHelper.TAB_META_DREAM);
        }
        String[] tabConfigArray = TabDataHelper.getTabConfigArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : tabConfigArray) {
            if (sb5.toString().contains(str)) {
                arrayList.add(str);
            }
        }
        com.tencent.mobileqq.activity.home.impl.a.f183038a = findIndexForList(TabDataHelper.TAB_CONVERSATION, arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183047j = findIndexForList("GUILD", arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183039b = -100;
        com.tencent.mobileqq.activity.home.impl.a.f183042e = -100;
        com.tencent.mobileqq.activity.home.impl.a.f183040c = findIndexForList(TabDataHelper.TAB_CONTACT, arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183044g = findIndexForList(TabDataHelper.TAB_RIJ, arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183041d = findIndexForList(TabDataHelper.TAB_LEBA, arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183046i = findIndexForList(TabDataHelper.TAB_NEW_WORLD, arrayList);
        com.tencent.mobileqq.activity.home.impl.a.f183048k = findIndexForList(TabDataHelper.TAB_META_DREAM, arrayList);
        QLog.d(TAG, 1, "initTabIndexByConfig ConversationTab: " + com.tencent.mobileqq.activity.home.impl.a.f183038a + " GuildTab: " + com.tencent.mobileqq.activity.home.impl.a.f183047j + " ContactTab: " + com.tencent.mobileqq.activity.home.impl.a.f183040c + " KandianTab: " + com.tencent.mobileqq.activity.home.impl.a.f183044g + " LebaTab: " + com.tencent.mobileqq.activity.home.impl.a.f183041d + " QCircleTab: " + com.tencent.mobileqq.activity.home.impl.a.f183046i + " MetaDreamTab: " + com.tencent.mobileqq.activity.home.impl.a.f183048k);
        this.mFrameInitBean = dVar;
        dispatchUpdateFrameInfo();
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void initTabs(FrameFragment frameFragment, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) frameFragment, (Object) view);
        } else {
            sFrameControllerInjectInterface.g(this, frameFragment, view);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public boolean isFragmentNotMatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return sFrameControllerInjectInterface.h();
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public int mainTabID2TabIndex(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Integer) iPatchRedirector.redirect((short) 57, (Object) this, (Object) bundle)).intValue();
        }
        if (bundle == null || !bundle.containsKey(AppConstants.MainTabIndex.MAIN_TAB_ID)) {
            return Integer.MIN_VALUE;
        }
        switch (bundle.getInt(AppConstants.MainTabIndex.MAIN_TAB_ID)) {
            case 1:
                return com.tencent.mobileqq.activity.home.impl.a.f183038a;
            case 2:
                return com.tencent.mobileqq.activity.home.impl.a.f183039b;
            case 3:
                return com.tencent.mobileqq.activity.home.impl.a.f183040c;
            case 4:
                return com.tencent.mobileqq.activity.home.impl.a.f183041d;
            case 5:
                return com.tencent.mobileqq.activity.home.impl.a.f183042e;
            case 6:
            case 7:
            case 8:
            default:
                return Integer.MIN_VALUE;
            case 9:
                return com.tencent.mobileqq.activity.home.impl.a.f183045h;
            case 10:
                return com.tencent.mobileqq.activity.home.impl.a.f183046i;
            case 11:
                return com.tencent.mobileqq.activity.home.impl.a.f183047j;
            case 12:
                return com.tencent.mobileqq.activity.home.impl.a.f183044g;
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onConfigurationChanged(Configuration configuration, FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) configuration, (Object) frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onDrawCompleteAfter(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) frameFragment);
        } else {
            sFrameControllerInjectInterface.c(this, frameFragment, new ArrayList<>(sFrameBusinessCallbacks.values()));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onFragmentDrawerClosed(FrameFragment frameFragment, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            dispatchFragmentDrawerClose(frameFragment, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onFragmentDrawerInit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().onFragmentDrawerInit(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onResumeAfter(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) frameFragment);
            return;
        }
        j.h();
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).clearUselessBackground(frameFragment.mRootView);
        dispatchOnResumeAfter(frameFragment);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onResumeUpdateSound(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) frameFragment);
        } else {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable(frameFragment) { // from class: com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FrameFragment f183032d;

                {
                    this.f183032d = frameFragment;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TabFrameControllerImpl.this, (Object) frameFragment);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f183032d.getBaseActivity() == null) {
                        return;
                    }
                    ((IRenderInSubThreadMonitor) QRoute.api(IRenderInSubThreadMonitor.class)).disableMonitor();
                    FrameFragment frameFragment2 = this.f183032d;
                    frameFragment2.pref = PreferenceManager.getDefaultSharedPreferences(frameFragment2.app.getApp());
                    boolean z16 = true;
                    if (this.f183032d.pref.getBoolean("theme_voice_setting_" + this.f183032d.app.getCurrentAccountUin(), true)) {
                        IVasApngUtilApi iVasApngUtilApi = (IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class);
                        FrameFragment frameFragment3 = this.f183032d;
                        z16 = iVasApngUtilApi.isSoundEffectsEnable(frameFragment3.app, frameFragment3.getBaseActivity());
                    }
                    TabFrameControllerImpl.this.dispatchResumeUpdateSound(this.f183032d.getTabNotifyIconMap(), z16);
                    TabFrameControllerImpl.sFrameControllerInjectInterface.n(this.f183032d);
                    ((IRenderInSubThreadMonitor) QRoute.api(IRenderInSubThreadMonitor.class)).enableMonitor();
                }
            }, 1000L);
        }
    }

    public void onTabChangeDelayAction(FrameFragment frameFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) frameFragment, i3);
            return;
        }
        if (frameFragment.mHandler == null) {
            frameFragment.mHandler = new MqqHandler();
        }
        frameFragment.mHandler.postDelayed(new Runnable(frameFragment, i3) { // from class: com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FrameFragment f183033d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f183034e;

            {
                this.f183033d = frameFragment;
                this.f183034e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TabFrameControllerImpl.this, frameFragment, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String currentTabTag = TabFrameControllerImpl.this.getCurrentTabTag(this.f183033d.mTabIndicator);
                String str2 = com.tencent.mobileqq.activity.home.impl.b.f183049l;
                if (str2.equals(currentTabTag) || com.tencent.mobileqq.activity.home.impl.b.f183050m.equals(currentTabTag)) {
                    if (str2.equals(currentTabTag)) {
                        str = "Msg_tab";
                    } else {
                        str = "Contacts_tab";
                    }
                    String str3 = str;
                    ReportController.o(this.f183033d.app, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
                }
                SharedPreferences sharedPreferences = this.f183033d.pref;
                if (sharedPreferences != null) {
                    if (sharedPreferences.getBoolean("theme_voice_setting_" + this.f183033d.app.getCurrentAccountUin(), true)) {
                        TabFrameControllerImpl.sFrameControllerInjectInterface.e(this.f183033d, this.f183034e);
                    }
                }
                if (currentTabTag != null && AppSetting.f99565y) {
                    TabFrameControllerImpl.this.dispatchTabContentDescription(this.f183033d, currentTabTag);
                }
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void onTouchDragChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            sFrameControllerInjectInterface.p(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public bn preLoadMainViews(LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (bn) iPatchRedirector.redirect((short) 15, (Object) this, (Object) layoutInflater);
        }
        return sFrameControllerInjectInterface.j(this, layoutInflater);
    }

    public void realUpdateRedTouch(RedTouch redTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) redTouch, (Object) redTypeInfo);
        } else if (redTouch != null) {
            redTouch.applyTo();
            redTouch.parseRedTouch(redTypeInfo);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void recoverUselessBackground(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) view);
            return;
        }
        if (this.mCurrentTabHostBg == null) {
            return;
        }
        Object tabHostBg = getTabHostBg(view);
        if (!(tabHostBg instanceof View)) {
            return;
        }
        View view2 = (View) tabHostBg;
        if (view2.getBackground() != null) {
            return;
        }
        view2.setBackgroundDrawable(this.mCurrentTabHostBg);
    }

    public boolean replaceExtraIcon(FrameFragment frameFragment, int i3) {
        int i16;
        int i17;
        boolean z16;
        boolean z17;
        int i18;
        TextView textView;
        ArrayList<c> arrayList;
        Pair<Integer, Integer> h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) frameFragment, i3)).booleanValue();
        }
        SparseArray<TabDragAnimationView> sparseArray = frameFragment.mTabDragIcon;
        if (sparseArray != null && sparseArray.size() > 0) {
            int size = frameFragment.mTabHostTabListWithOrder.size();
            String[] strArr = new String[size];
            for (int i19 = 0; i19 < size; i19++) {
                strArr[i19] = com.tencent.mobileqq.activity.home.impl.b.b(frameFragment.mTabHostTabListWithOrder.get(i19).getTag());
            }
            for (int i26 = 0; i26 < frameFragment.mTabDragIcon.size(); i26++) {
                int keyAt = frameFragment.mTabDragIcon.keyAt(i26);
                TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(keyAt);
                if (tabDragAnimationView != null) {
                    int i27 = -1;
                    if (!frameFragment.mIsDefaultTheme && (h16 = com.tencent.mobileqq.activity.home.impl.b.h(strArr, com.tencent.mobileqq.activity.home.impl.b.i(keyAt))) != null) {
                        i17 = ((Integer) h16.first).intValue();
                        i16 = ((Integer) h16.second).intValue();
                    } else {
                        i16 = -1;
                        i17 = -1;
                    }
                    d dVar = this.mFrameInitBean;
                    if (dVar != null && dVar.e() && this.mFrameInitBean.c(TabDataHelper.TAB_NEW_WORLD)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i17 != -1 && i16 != -1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17 && (arrayList = mFrameInfoBeans) != null) {
                        Iterator<c> it = arrayList.iterator();
                        while (it.hasNext()) {
                            c next = it.next();
                            if (next.l() == keyAt) {
                                i17 = next.d();
                                i16 = next.e();
                                QLog.d(TAG, 1, "replaceExtraIcon bean.key=" + next.m() + ", resBg=" + i17 + "\uff0c resBgPressed=" + i16);
                            }
                            i27 = -1;
                        }
                        i18 = i27;
                    } else {
                        i18 = -1;
                    }
                    if (i17 != i18 && i16 != i18 && !z16) {
                        tabDragAnimationView.setBgDrawable(i17);
                        tabDragAnimationView.setBgPressedDrawable(i16);
                    }
                    SparseArray<TextView> sparseArray2 = frameFragment.mTabTextView;
                    if (sparseArray2 != null && (textView = sparseArray2.get(keyAt)) != null) {
                        if (!z17 && !frameFragment.mIsDefaultTheme && ((keyAt != com.tencent.mobileqq.activity.home.impl.a.f183046i || QQTheme.isThemeSimpleUI(QQTheme.getCurrentThemeId()) || !QQTheme.isCustomTheme("", false)) && !QQTheme.isNowSimpleUI() && !TabDragAnimationView.t() && !z16)) {
                            textView.setVisibility(8);
                            tabDragAnimationView.setShowTextView(false);
                        } else {
                            textView.setVisibility(0);
                            tabDragAnimationView.setShowTextView(true);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.bottomMargin = i3;
                                textView.setLayoutParams(layoutParams);
                            }
                        }
                    }
                }
            }
            updateTabSelectStatusOnTabChange(frameFragment, getTabIndexFromName(frameFragment.getCurrentTabName()));
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void revertTabIconChange(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) frameFragment);
        } else {
            dispatchTabChangeAfterFramesPause(frameFragment);
        }
    }

    public void setContactAndLebaTabDesc(FrameFragment frameFragment, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, frameFragment, Integer.valueOf(i3), str, str2);
            return;
        }
        if (i3 == 33) {
            frameFragment.mContactTabDesc = str;
        } else if (i3 == 49) {
            frameFragment.metaDreamRedtouchDesc = str;
        } else {
            frameFragment.lebaRedtouchDesc = str2;
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void setCurrentIntentParams(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) frameFragment);
            return;
        }
        try {
            Intent intent = frameFragment.getBaseActivity().getIntent();
            if (intent != null) {
                intent.putExtra(FrameFragment.CURRENT_TAB_PARAMS_TAG, frameFragment.getCurrentTab());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "setCurrentIntentParams", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public d setFrames(FrameFragment frameFragment, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (d) iPatchRedirector.redirect((short) 36, this, frameFragment, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        return sFrameControllerInjectInterface.f(this, frameFragment, z16, i3);
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void setIntent(Intent intent, FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) intent, (Object) frameFragment);
            return;
        }
        Iterator<w> it = sFrameBusinessCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().setIntent(intent, frameFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void setSoundEffectsEnableForTab(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, view, Boolean.valueOf(z16));
        } else {
            if (view == null) {
                return;
            }
            view.setSoundEffectsEnabled(z16);
        }
    }

    public void updateCommonBusinessOnTabChange(FrameFragment frameFragment, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) frameFragment, (Object) str);
        } else {
            dispatchCommonBusinessOnTabChange(frameFragment, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ff  */
    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateFrames(FrameFragment frameFragment, int i3, int i16, Object obj) {
        String str;
        boolean booleanValue;
        int tabNoteTextStyle;
        String str2;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, frameFragment, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        if (frameFragment.mTabViewMap == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "mTabViewMap == null");
                return;
            }
            return;
        }
        String str3 = "";
        if (i3 != 32) {
            if (i3 != 33) {
                if (i3 != 39) {
                    if (i3 != 48) {
                        if (i3 != 49) {
                            str = "";
                        } else {
                            str = com.tencent.mobileqq.activity.home.impl.b.f183057t;
                        }
                    } else {
                        str = com.tencent.mobileqq.activity.home.impl.b.f183056s;
                    }
                } else {
                    sFrameControllerInjectInterface.l(this, frameFragment, i16);
                    return;
                }
            } else {
                str = com.tencent.mobileqq.activity.home.impl.b.f183050m;
            }
        } else {
            str = com.tencent.mobileqq.activity.home.impl.b.f183049l;
        }
        String tagFromType = getTagFromType(i16, str);
        View tabNotifyIcon = frameFragment.getTabNotifyIcon(str + "_num");
        if (!(tabNotifyIcon instanceof QUIBadge)) {
            QLog.i(TAG, 1, "[updateFrames] not QuiBadge. v=" + tabNotifyIcon + ", tag=" + str);
            return;
        }
        if (tagFromType == null) {
            return;
        }
        if (obj instanceof Integer) {
            ((Integer) obj).intValue();
        } else if (obj instanceof Boolean) {
            booleanValue = ((Boolean) obj).booleanValue();
            frameFragment.mTabNotifyValue.put(tagFromType, obj);
            tabNoteTextStyle = getTabNoteTextStyle(frameFragment.mTabNotifyValue, str);
            if (tabNoteTextStyle != sFrameControllerInjectInterface.m(3)) {
                Object obj2 = frameFragment.mTabNotifyValue.get(str + "_num");
                if (obj2 instanceof Integer) {
                    i17 = ((Integer) obj2).intValue();
                    str2 = "";
                    QUIBadge qUIBadge = (QUIBadge) tabNotifyIcon;
                    if (i3 == 32) {
                        int dimensionPixelSize = frameFragment.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f159128wf);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) qUIBadge.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.setMargins(5, dimensionPixelSize, 0, 0);
                            qUIBadge.setLayoutParams(layoutParams);
                        }
                        if (hasUnReadRedPacket(frameFragment.app)) {
                            frameFragment.mIsPlayIcon = false;
                        }
                        if (!frameFragment.mIsPlayIcon) {
                            updateTabDefaultFocusIcon(frameFragment.app, frameFragment.mIsDefaultTheme, frameFragment.mTabDragIcon, i17);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "updateMain, [tabIndex = " + i3 + ",type = " + i16 + ",style = " + tabNoteTextStyle + ",unreadNum = " + i17 + ",isVisable = " + booleanValue + "]");
                    }
                    x xVar = sFrameControllerInjectInterface;
                    xVar.b(qUIBadge, i17, str2, tabNoteTextStyle, xVar.m(99));
                    if (AppSetting.f99565y) {
                        dispatchTabContentDescription(frameFragment, getCurrentTabTag(frameFragment.mTabIndicator));
                        return;
                    }
                    return;
                }
            } else if (tabNoteTextStyle == sFrameControllerInjectInterface.m(5)) {
                Object obj3 = frameFragment.mTabNotifyValue.get(str + "_text");
                if (obj3 instanceof String) {
                    str3 = (String) obj3;
                }
            }
            str2 = str3;
            i17 = 0;
            QUIBadge qUIBadge2 = (QUIBadge) tabNotifyIcon;
            if (i3 == 32) {
            }
            if (QLog.isColorLevel()) {
            }
            x xVar2 = sFrameControllerInjectInterface;
            xVar2.b(qUIBadge2, i17, str2, tabNoteTextStyle, xVar2.m(99));
            if (AppSetting.f99565y) {
            }
        }
        booleanValue = false;
        frameFragment.mTabNotifyValue.put(tagFromType, obj);
        tabNoteTextStyle = getTabNoteTextStyle(frameFragment.mTabNotifyValue, str);
        if (tabNoteTextStyle != sFrameControllerInjectInterface.m(3)) {
        }
        str2 = str3;
        i17 = 0;
        QUIBadge qUIBadge22 = (QUIBadge) tabNotifyIcon;
        if (i3 == 32) {
        }
        if (QLog.isColorLevel()) {
        }
        x xVar22 = sFrameControllerInjectInterface;
        xVar22.b(qUIBadge22, i17, str2, tabNoteTextStyle, xVar22.m(99));
        if (AppSetting.f99565y) {
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateRedBadge(FrameFragment frameFragment, int i3, TianshuRedTouch tianshuRedTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, frameFragment, Integer.valueOf(i3), tianshuRedTouch, redTypeInfo);
            return;
        }
        if (tianshuRedTouch == null) {
            return;
        }
        Integer num = com.tencent.mobileqq.activity.home.impl.b.f183060w.get(Integer.valueOf(i3));
        if (num != null && num.intValue() == 0) {
            ((IRedPointReportManager) QRoute.api(IRedPointReportManager.class)).reportLevelZeroExposure(num.intValue());
        }
        Boolean bool = com.tencent.mobileqq.activity.home.impl.b.f183058u.get(Integer.valueOf(i3));
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            redTypeInfo = com.tencent.mobileqq.activity.home.impl.b.d(frameFragment, i3);
        }
        Boolean bool2 = com.tencent.mobileqq.activity.home.impl.b.f183059v.get(Integer.valueOf(i3));
        if (bool2 != null && bool2.booleanValue()) {
            return;
        }
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 98) {
            updateTabInfoWording(tianshuRedTouch, redTypeInfo);
        } else {
            updateTabInfo(tianshuRedTouch, redTypeInfo);
        }
        setContactAndLebaTabDesc(frameFragment, i3, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208165bz), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208165bz));
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateRedTouch(FrameFragment frameFragment, int i3, RedTouch redTouch, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, frameFragment, Integer.valueOf(i3), redTouch, redTypeInfo);
            return;
        }
        if (redTouch != null && redTypeInfo != null) {
            int i16 = redTypeInfo.red_type.get();
            if (i16 != 0) {
                if (i16 == 4 || i16 == 5) {
                    redTouch.setLeftMargin(5);
                    if (i3 == 39) {
                        redTouch.setLeftMargin(11);
                    }
                    String str2 = redTypeInfo.red_content.get() + HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208175c0);
                    try {
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                    if (Integer.parseInt(redTypeInfo.red_content.get()) > 99) {
                        str = "\u591a\u4e8e99\u6761\u66f4\u65b0";
                        setContactAndLebaTabDesc(frameFragment, i3, str, str2);
                    }
                    str = str2;
                    setContactAndLebaTabDesc(frameFragment, i3, str, str2);
                }
            } else {
                redTouch.setLeftMargin(11);
                setContactAndLebaTabDesc(frameFragment, i3, HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208165bz), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208165bz));
            }
            realUpdateRedTouch(redTouch, redTypeInfo);
            return;
        }
        realUpdateRedTouch(redTouch, null);
        setContactAndLebaTabDesc(frameFragment, i3, "", "");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTabContentDescription(FrameFragment frameFragment, String str, String str2) {
        View tabNotifyIcon;
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, frameFragment, str, str2);
            return;
        }
        if (TextUtils.isEmpty(str2) || (tabNotifyIcon = frameFragment.getTabNotifyIcon(str)) == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (com.tencent.mobileqq.activity.home.impl.b.f183049l.equals(str)) {
            sb5.append("\u6d88\u606f ");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183050m.equals(str)) {
            sb5.append("\u8054\u7cfb\u4eba ");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183052o.equals(str)) {
            sb5.append("\u52a8\u6001 ");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183053p.equals(str)) {
            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208205c3));
            sb5.append(" ");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183056s.equals(str)) {
            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f139690by));
            sb5.append(" ");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183057t.equals(str)) {
            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f16525281));
            sb5.append(" ");
        } else {
            return;
        }
        int tabNoteTextStyle = getTabNoteTextStyle(frameFragment.mTabNotifyValue, str);
        if (tabNoteTextStyle == sFrameControllerInjectInterface.m(2)) {
            sb5.append("\u6709\u66f4\u65b0");
        } else if (tabNoteTextStyle == sFrameControllerInjectInterface.m(3)) {
            View tabNotifyIcon2 = frameFragment.getTabNotifyIcon(str + "_num");
            CharSequence contentDescription = tabNotifyIcon2.getContentDescription();
            if (contentDescription != null) {
                try {
                    parseInt = Integer.parseInt(contentDescription.toString());
                } catch (NumberFormatException unused) {
                }
                if (!com.tencent.mobileqq.activity.home.impl.b.f183049l.equals(str)) {
                    if (parseInt > 99) {
                        sb5.append("\u591a\u4e8e99\u6761\u672a\u8bfb");
                    } else {
                        sb5.append(parseInt);
                        sb5.append("\u6761\u672a\u8bfb");
                    }
                } else if (!com.tencent.mobileqq.activity.home.impl.b.f183050m.equals(str) && !com.tencent.mobileqq.activity.home.impl.b.f183056s.equals(str)) {
                    if (com.tencent.mobileqq.activity.home.impl.b.f183053p.equals(str) && tabNotifyIcon2.getVisibility() == 0) {
                        if (parseInt > 99) {
                            sb5.append("\u591a\u4e8e99\u4e2a\u65b0\u7684");
                            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208205c3));
                        } else {
                            sb5.append(parseInt);
                            sb5.append("\u4e2a\u65b0\u7684");
                            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.f208205c3));
                        }
                    }
                } else if (tabNotifyIcon2.getVisibility() == 0) {
                    if (parseInt > 99) {
                        sb5.append("\u591a\u4e8e99\u6761\u66f4\u65b0");
                    } else {
                        sb5.append(parseInt);
                        sb5.append("\u6761\u66f4\u65b0");
                    }
                } else {
                    sb5.append(frameFragment.mContactTabDesc);
                }
            }
            parseInt = 0;
            if (!com.tencent.mobileqq.activity.home.impl.b.f183049l.equals(str)) {
            }
        } else if (tabNoteTextStyle == sFrameControllerInjectInterface.m(1)) {
            sb5.append("\u6709\u65b0\u6d88\u606f");
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183050m.equals(str)) {
            sb5.append(frameFragment.mContactTabDesc);
        } else if (com.tencent.mobileqq.activity.home.impl.b.f183057t.equals(str)) {
            sb5.append(frameFragment.metaDreamRedtouchDesc);
        }
        if (com.tencent.mobileqq.activity.home.impl.b.f183052o.equals(str)) {
            sb5.append(frameFragment.lebaRedtouchDesc);
        }
        if (tabNotifyIcon instanceof RedTouchTab) {
            View target = ((RedTouchTab) tabNotifyIcon).getTarget();
            target.setContentDescription(sb5.toString());
            AccessibilityUtil.n(target, true);
        } else {
            tabNotifyIcon.setContentDescription(sb5.toString());
            AccessibilityUtil.n(tabNotifyIcon, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateTabDefaultFocusIcon(AppRuntime appRuntime, boolean z16, SparseArray<TabDragAnimationView> sparseArray, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, Boolean.valueOf(z16), sparseArray, Integer.valueOf(i3));
        } else if (z16 && sparseArray != null) {
            dispatchUpdateTabFocusIcon(appRuntime, sparseArray, i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateTabRedBadge(FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, frameFragment, Integer.valueOf(i3), redTypeInfo);
        } else if (frameFragment != null && frameFragment.hasTabNotifyIcon() != null) {
            dispatchUpdateTadRedBadge(null, frameFragment, i3, redTypeInfo, (IRedTouchManager) frameFragment.app.getRuntimeService(IRedTouchManager.class, ""));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateTabRedTouch(FrameFragment frameFragment, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, frameFragment, Integer.valueOf(i3), redTypeInfo);
        } else if (frameFragment != null && frameFragment.hasTabNotifyIcon() != null) {
            dispatchUpdateTadRedTouch(null, frameFragment, i3, redTypeInfo, (IRedTouchManager) frameFragment.app.getRuntimeService(IRedTouchManager.class, ""));
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateTabSelectStatusOnTabChange(FrameFragment frameFragment, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) frameFragment, i3);
            return;
        }
        TabDragAnimationView.setCurrentFragment(new WeakReference(frameFragment));
        TabDragAnimationView tabDragAnimationView = frameFragment.mTabDragIcon.get(i3);
        if (tabDragAnimationView != null) {
            tabDragAnimationView.setPressChanged(true);
        }
        TextView textView = frameFragment.mTabTextView.get(i3);
        if (textView != null) {
            textView.setTextColor(TabDragAnimationView.n(frameFragment.getResources()));
            if (tabDragAnimationView != null && tabDragAnimationView.O()) {
                textView.setVisibility(8);
            }
        }
        for (int i16 = 0; i16 < frameFragment.mTabDragIcon.size(); i16++) {
            if (frameFragment.mTabDragIcon.keyAt(i16) != i3) {
                frameFragment.mTabDragIcon.valueAt(i16).setPressChanged(false);
            }
        }
        for (int i17 = 0; i17 < frameFragment.mTabTextView.size(); i17++) {
            if (frameFragment.mTabDragIcon.keyAt(i17) != i3) {
                TextView valueAt = frameFragment.mTabTextView.valueAt(i17);
                valueAt.setTextColor(TabDragAnimationView.o(frameFragment.getResources()));
                TabDragAnimationView valueAt2 = frameFragment.mTabDragIcon.valueAt(i17);
                if (valueAt2 != null && valueAt2.B()) {
                    valueAt.setVisibility(0);
                } else {
                    valueAt.setVisibility(8);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.home.ITabFrameController
    public void updateUIAfterTabChange(FrameFragment frameFragment, String str, String str2, be beVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, frameFragment, str, str2, beVar);
            return;
        }
        try {
            int tabIndexFromName = getTabIndexFromName(str2);
            int tabIndexFromName2 = getTabIndexFromName(str);
            updateCommonBusinessOnTabChange(frameFragment, str);
            dispatchUpdateFrameOnTabChange(frameFragment, tabIndexFromName, beVar, tabIndexFromName2);
            frameFragment.mIsDefaultTheme = com.tencent.mobileqq.activity.home.impl.b.l();
            updateTabSelectStatusOnTabChange(frameFragment, tabIndexFromName2);
            onTabChangeDelayAction(frameFragment, tabIndexFromName2);
            dispatchOnTabChangeAfter(frameFragment);
            reportTabChange(frameFragment, str, str2, beVar);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateUIAfterTabChange excetpion: " + Log.getStackTraceString(e16));
        }
    }

    public View generateTabItem(int i3, int i16, int i17, int i18, int i19, String str, int i26, int i27, int i28, int i29, String str2, String str3) {
        int i36;
        int i37;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), str, Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), str2, str3);
        }
        if (BaseApplication.getContext() == null) {
            return null;
        }
        View inflate = View.inflate(BaseApplication.getContext(), com.tencent.mobileqq.R.layout.c07, null);
        ((QUIBadge) inflate.findViewById(com.tencent.mobileqq.R.id.khc)).setDragType(2);
        TabDragAnimationView tabDragAnimationView = (TabDragAnimationView) inflate.findViewById(com.tencent.mobileqq.R.id.j_k);
        if (com.tencent.mobileqq.activity.home.impl.b.l()) {
            i36 = -1;
            i37 = -1;
        } else {
            i36 = i3;
            i37 = i17;
        }
        tabDragAnimationView.setTabDrawable(i36, i16, i37, i18, i26, i27, i28, i29, str2, str3);
        TextView textView = (TextView) inflate.findViewById(com.tencent.mobileqq.R.id.kbi);
        textView.setTextColor(textView.getContext().getColor(com.tencent.mobileqq.R.color.qui_common_icon_primary));
        String qqStr = HardCodeUtil.qqStr(i19);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(qqStr);
        }
        textView.setTag(qqStr);
        return inflate;
    }

    public View generateTabItem(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? generateTabItem(i3, i16, i17, i18, i19, null, i26, i27, i28, i29, str, str2) : (View) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), str, str2);
    }
}
