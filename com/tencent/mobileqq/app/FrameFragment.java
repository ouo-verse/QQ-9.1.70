package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Argus;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FrameFragment extends QBaseFragment implements TabHost.TabContentFactory, com.tencent.mobileqq.fpsreport.a {
    static IPatchRedirector $redirector_ = null;
    public static final String CURRENT_TAB_PARAMS_TAG = "current_tab_tag";
    private static final String TAG = "FrameUtil.FrameFragment";
    public static boolean isFirstChangeIcon;
    public static int mPreResIndex;
    public static boolean mTabWidgetMoveFlag;
    public AppRuntime app;
    protected String currentTabName;
    private final boolean disableBlurEffectOnLowEndDevices;
    private final boolean enableBlurSourceDirtyState;
    private final boolean enableBlurViewDirectDraw;
    public boolean hasSpecialCareFriend;
    public String lebaRedtouchDesc;
    protected boolean mBlurSuspended;
    public String mContactTabDesc;
    public DragFrameLayout mDragHost;
    protected boolean mForceDoIt;
    public TabFrameControllerImpl.b mFrameDoubleTapListener;
    private final Map<String, be> mFrames;
    public boolean mHandleNumException;
    public MqqHandler mHandler;
    public boolean mIsDefaultTheme;
    public boolean mIsFirst;
    public boolean mIsPlayIcon;
    public Intent mNewIntent;
    public long mOnDoubleTapTimestamp;
    public Intent mPendingIntent;
    public View mRootView;
    public QQBlurViewWrapper mTabBlurView;
    public SparseArray<TabDragAnimationView> mTabDragIcon;
    public c mTabHost;
    public View mTabHostDivider;
    public ArrayList<e> mTabHostTabList;
    public ArrayList<e> mTabHostTabListWithOrder;
    public d mTabIndicator;
    private HashMap<String, View> mTabNotifyIcon;
    public HashMap<String, Object> mTabNotifyValue;
    public HashMap<String, e> mTabSpecCache;
    public SparseArray<TextView> mTabTextView;
    public TabViewMap mTabViewMap;
    public ViewGroup mTabWidget;
    public Handler mUiHandler;
    protected Vibrator mVibrator;
    public Runnable mVibratorRunnable;
    public String metaDreamRedtouchDesc;
    private be preFrame;
    public SharedPreferences pref;
    public boolean simpleUIOn;
    long tabBeginActionTime;
    String tabName;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class DragViewPunctureClickListener implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        public DragViewPunctureClickListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!FrameFragment.mTabWidgetMoveFlag) {
                    viewGroup.callOnClick();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class DragViewTouchListener implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        public DragViewTouchListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    ((ITabFrameController) QRoute.api(ITabFrameController.class)).onTouchDragChange(true);
                }
            } else {
                ((ITabFrameController) QRoute.api(ITabFrameController.class)).onTouchDragChange(false);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements f.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Map<View, ArrayList<View>> f194641a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameFragment.this);
            } else {
                this.f194641a = new HashMap();
            }
        }

        private void b(boolean z16) {
            View currentView;
            if (com.tencent.mobileqq.util.af.d()) {
                be currentFrame = FrameFragment.this.getCurrentFrame();
                if (currentFrame == null) {
                    return;
                } else {
                    currentView = currentFrame.getContentView();
                }
            } else {
                currentView = ((QQTabHost) FrameFragment.this.mTabHost).getCurrentView();
            }
            ArrayList<View> arrayList = this.f194641a.get(currentView);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                c(currentView, arrayList);
                this.f194641a.put(currentView, arrayList);
            }
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof FPSXListView) {
                    ((FPSXListView) next).b0(z16);
                } else if (next instanceof FPSSwipListView) {
                    ((FPSSwipListView) next).b0(z16);
                }
            }
        }

        private void c(View view, ArrayList<View> arrayList) {
            if (view != null && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (((viewGroup instanceof FPSXListView) || (viewGroup instanceof FPSSwipListView)) && !arrayList.contains(viewGroup)) {
                    arrayList.add(viewGroup);
                }
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    c(viewGroup.getChildAt(i3), arrayList);
                }
            }
        }

        @Override // com.tencent.qui.quiblurview.f.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                b(true);
            }
        }

        @Override // com.tencent.qui.quiblurview.f.c
        public void onDrawBegin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class b implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        View f194643a;

        b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameFragment.this, (Object) view);
            } else {
                this.f194643a = view;
            }
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            f.b blurDirtyState;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            be currentFrame = FrameFragment.this.getCurrentFrame();
            if (currentFrame != null && (blurDirtyState = currentFrame.getBlurDirtyState()) != null) {
                return blurDirtyState.a();
            }
            return this.f194643a.isDirty();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        View a();

        void b(int i3);

        void c(e eVar);

        void clearAllTabs();

        void setFirstDrawTrue();

        void setOnDrawCompleteListener(com.tencent.mobileqq.fpsreport.a aVar);

        void setup(FrameFragment frameFragment);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        Context getContext();

        int getCurrentTab();

        String getCurrentTabTag();

        void setCurrentTab(int i3);

        void setCurrentTab(int i3, boolean z16);

        void setCurrentTabByTag(String str);

        void setOnTabSelectionListener(com.tencent.mobileqq.tab.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface e {
        View a();

        String getTag();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 60)) {
            redirector.redirect((short) 60);
            return;
        }
        mPreResIndex = 0;
        mTabWidgetMoveFlag = false;
        isFirstChangeIcon = true;
        Argus.INSTANCE.addBlockCreator(new com.tencent.mobileqq.app.argus.a());
    }

    public FrameFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsFirst = true;
        this.mPendingIntent = null;
        this.mTabHostTabList = new ArrayList<>();
        this.mTabHostTabListWithOrder = new ArrayList<>();
        this.mHandleNumException = false;
        this.mFrames = new HashMap(4);
        this.simpleUIOn = false;
        this.mTabViewMap = null;
        this.mTabDragIcon = null;
        this.mTabTextView = null;
        this.tabBeginActionTime = -1L;
        this.tabName = null;
        this.mNewIntent = null;
        this.mTabNotifyIcon = null;
        this.mContactTabDesc = "";
        this.lebaRedtouchDesc = "";
        this.metaDreamRedtouchDesc = "";
        this.mIsDefaultTheme = true;
        this.mBlurSuspended = false;
        this.pref = null;
        this.mIsPlayIcon = false;
        this.hasSpecialCareFriend = false;
        this.mTabNotifyValue = null;
        this.mVibratorRunnable = new Runnable() { // from class: com.tencent.mobileqq.app.FrameFragment.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    FrameFragment frameFragment = FrameFragment.this;
                    if (frameFragment.mVibrator == null) {
                        frameFragment.mVibrator = (Vibrator) frameFragment.getBaseActivity().getSystemService("vibrator");
                    }
                    FrameFragment.this.mVibrator.vibrate(20L);
                } catch (Exception e16) {
                    QLog.e(FrameFragment.TAG, 2, "Vibrator exception.");
                    e16.printStackTrace();
                }
            }
        };
        this.mForceDoIt = false;
        this.mFrameDoubleTapListener = new TabFrameControllerImpl.b(this);
        this.enableBlurSourceDirtyState = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_tab_use_blur_source_dirty_state_8890_116658741", true);
        this.enableBlurViewDirectDraw = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_tab_use_blur_view_direct_draw_8996", true);
        this.disableBlurEffectOnLowEndDevices = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_tab_disable_blur_effect_on_low_end_devices_8996", true);
    }

    private f.c getDrawBackgroundListener() {
        return new a();
    }

    private be getFrame(String str) {
        if (this.mFrames.containsKey(str)) {
            return this.mFrames.get(str);
        }
        QLog.i(TAG, 1, "getFrame  className:" + str + ", mTabHost:" + System.identityHashCode(this.mTabHost) + ", frameFragment:" + System.identityHashCode(this) + ", mFrame:" + getFramesLog());
        return ((ITabFrameController) QRoute.api(ITabFrameController.class)).buildFrame(this, str);
    }

    private String getUin() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null || waitAppRuntime.getAccount() == null) {
            return "0";
        }
        return waitAppRuntime.getAccount();
    }

    private Boolean ifHiddenTabNotifyIcon(String str) {
        if (str == null) {
            return Boolean.TRUE;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183050m + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183051n + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183052o + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183053p + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183054q + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183055r + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183056s + "_num");
        arrayList.add(com.tencent.mobileqq.activity.home.impl.b.f183057t + "_num");
        return Boolean.valueOf(arrayList.contains(str));
    }

    public static com.tencent.mobileqq.widget.bn preloadMainUI(LayoutInflater layoutInflater) {
        return ((ITabFrameController) QRoute.api(ITabFrameController.class)).preLoadMainViews(layoutInflater);
    }

    private void refreshBlurView(QQBlurViewWrapper qQBlurViewWrapper) {
        Object parent = qQBlurViewWrapper.getParent();
        if (parent instanceof View) {
            ((View) parent).postInvalidate();
        }
    }

    private void tabPrefTrack(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1142840208:
                if (str.equals("com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame")) {
                    c16 = 0;
                    break;
                }
                break;
            case -414462903:
                if (str.equals("com.tencent.mobileqq.activity.home.Conversation")) {
                    c16 = 1;
                    break;
                }
                break;
            case 407018872:
                if (str.equals("com.tencent.mobileqq.leba.Leba")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1360123902:
                if (str.equals("com.tencent.mobileqq.activity.contacts.base.Contacts")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1782751074:
                if (str.equals("com.tencent.mobileqq.activity.qcircle.QCircleFrame")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.b(IQQHodorPrefApi.class)).collectTrackInfo("guild_tab_begin_business");
                return;
            case 1:
                ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.b(IQQHodorPrefApi.class)).collectTrackInfo("conversation_tab_begin_business");
                return;
            case 2:
                ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.b(IQQHodorPrefApi.class)).collectTrackInfo("leba_tab_begin_business");
                return;
            case 3:
                ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.b(IQQHodorPrefApi.class)).collectTrackInfo("contacts_tab_begin_business");
                return;
            case 4:
                ((IQQHodorPrefApi) com.tencent.qqnt.trace.g.b(IQQHodorPrefApi.class)).collectTrackInfo("qcircle_tab_begin_business");
                return;
            default:
                QLog.d(TAG, 1, "nextTabName no match tab");
                return;
        }
    }

    @Override // android.widget.TabHost.TabContentFactory
    public View createTabContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? createTabContent(str, true) : (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public void disableBlur(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            QLog.e(TAG, 1, "disableBlur: tabWidget == null");
            return;
        }
        QLog.i(TAG, 1, "disableBlur  tabWidget setViewBackground");
        com.tencent.mobileqq.util.dd.a(view, R.drawable.qui_tab_bottom_nav_bg);
        this.mTabBlurView.setDisableDrawable(null);
        Iterator<Map.Entry<String, View>> it = this.mTabViewMap.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (value != null) {
                com.tencent.mobileqq.util.dd.a(value, R.drawable.b5g);
            }
        }
    }

    public void dismissLocalSearchDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        be currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            currentFrame.dismissLocalSearchDialog();
        }
    }

    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        be currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            currentFrame.notifyActivityResult(i3, i16, intent);
        }
    }

    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().notifyDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent);
            return;
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).doOnEntry(this, intent);
        be currentFrame = getCurrentFrame();
        if (currentFrame != null && currentFrame.hasInited()) {
            currentFrame.notifyNewIntent(intent);
        }
    }

    public void doOnRestoreInstanceState(Bundle bundle) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
            return;
        }
        StringBuilder sb5 = new StringBuilder("[" + System.identityHashCode(this) + "] doOnRestoreInstanceState");
        String string = bundle.getString("currentTab");
        sb5.append(", restoreTag:");
        sb5.append(string);
        if (string != null && (dVar = this.mTabIndicator) != null) {
            String currentTabTag = dVar.getCurrentTabTag();
            sb5.append(", curTag:");
            sb5.append(currentTabTag);
            if (currentTabTag != null && !currentTabTag.endsWith(string)) {
                this.mTabIndicator.setCurrentTabByTag(string);
            }
        }
        QLog.i(TAG, 1, sb5.toString());
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().notifyRestoreInstanceState(bundle);
        }
    }

    public void doOnSaveInstanceState(Bundle bundle) {
        String currentTabTag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        d dVar = this.mTabIndicator;
        if (dVar != null && (currentTabTag = dVar.getCurrentTabTag()) != null) {
            bundle.putString("currentTab", currentTabTag);
        }
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().notifySaveInstanceState(bundle);
        }
    }

    public boolean enableBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? (!this.disableBlurEffectOnLowEndDevices || com.tencent.qui.quiblurview.c.f363628c.b(BaseApplication.context)) && Color.alpha(this.mTabBlurView.getContext().getResources().getColor(R.color.qui_common_bg_nav_bottom)) < 255 : ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
    }

    public QBaseActivity getBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        return super.getQBaseActivity();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public String getCIOPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (String) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        if (getCurrentFrame() != null) {
            return getCurrentFrame().getClass().getName();
        }
        return super.getCIOPageName();
    }

    public be getCurrentFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (be) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        d dVar = this.mTabIndicator;
        if (dVar == null) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(TAG, 2, "mTabHost=null");
            return null;
        }
        return getCurrentFrame(dVar.getCurrentTabTag());
    }

    public int getCurrentTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        d dVar = this.mTabIndicator;
        if (dVar != null) {
            return dVar.getCurrentTab();
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "getCurrentTab");
        }
        return 0;
    }

    public String getCurrentTabName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        String str = this.currentTabName;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String getFramesLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.mFrames.toString();
    }

    public TianshuRedTouch getRedBadge(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
        }
        View view = this.mTabNotifyIcon.get(str);
        if (view instanceof TianshuRedTouch) {
            return (TianshuRedTouch) view;
        }
        return null;
    }

    public c getTabHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (c) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mTabHost;
    }

    public View getTabNotifyIcon(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (View) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
        }
        if (ifHiddenTabNotifyIcon(str).booleanValue() && TianshuRedTouch.INSTANCE.j()) {
            return null;
        }
        return this.mTabNotifyIcon.get(str);
    }

    public HashMap<String, View> getTabNotifyIconMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (HashMap) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return this.mTabViewMap;
    }

    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public Boolean hasRedBadge(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Boolean) iPatchRedirector.redirect((short) 51, (Object) this, (Object) str);
        }
        boolean z16 = true;
        if (TianshuRedTouch.INSTANCE.j()) {
            TianshuRedTouch redBadge = getRedBadge(str);
            if (redBadge != null) {
                if (!redBadge.Q() || redBadge.getVisibility() != 0) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        } else {
            View tabNotifyIcon = getTabNotifyIcon(str);
            if (tabNotifyIcon != null && (tabNotifyIcon instanceof RedTouch)) {
                if (!((RedTouch) tabNotifyIcon).hasRedTouch() || tabNotifyIcon.getVisibility() != 0) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
        }
        return Boolean.FALSE;
    }

    public Boolean hasTabNotifyIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (Boolean) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return Boolean.valueOf(!this.mTabNotifyIcon.isEmpty());
    }

    public void initTabNotifyIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mTabNotifyIcon = new HashMap<>(9);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public View loadFrameContent(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? loadFrameContent(str, z16, true) : (View) iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FrameActivity", 2, "onAccountChanged");
        }
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().onAccountChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().notifyConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else if (com.tencent.mobileqq.util.af.d()) {
            inflate = layoutInflater.inflate(R.layout.fgm, (ViewGroup) null);
        } else {
            inflate = layoutInflater.inflate(R.layout.f168257qm, (ViewGroup) null);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().notifyDestroy();
        }
    }

    public void onDrawComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.tabBeginActionTime;
        Log.i("AutoMonitor", this.tabName + "TabSwitch, cost=" + uptimeMillis);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.PERFORMANCE_TRACE, 2, this.tabName + "TabSwitch, cost=" + uptimeMillis);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getUin(), "actSwitch" + this.tabName, true, uptimeMillis, 0L, null, null);
        be currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            currentFrame.onDrawComplete();
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).onDrawCompleteAfter(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFramesDestroyAfter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onDestroy();
        }
        Runnable runnable = this.mVibratorRunnable;
        this.mVibratorRunnable = null;
        ThreadManager.getSubThreadHandler().removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFramesPauseAfter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onPause();
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).doFramesPauseAfter(this);
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
    }

    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) logoutReason);
            return;
        }
        Iterator<be> it = this.mFrames.values().iterator();
        while (it.hasNext()) {
            it.next().onLogout(logoutReason);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        be currentFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onPause();
        if ((!((ITabFrameController) QRoute.api(ITabFrameController.class)).isFragmentNotMatch() || this.mForceDoIt) && (currentFrame = getCurrentFrame()) != null) {
            currentFrame.notifyPause(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "FrameFragment#onPostThemeChanged");
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).handleThemeChanged(this);
        if (com.tencent.mobileqq.util.af.d()) {
            Collection<be> values = this.mFrames.values();
            be currentFrame = getCurrentFrame();
            for (be beVar : values) {
                if (currentFrame != beVar) {
                    SkinEngine.invalidateAll(beVar.getContentView());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        be currentFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        if (!((ITabFrameController) QRoute.api(ITabFrameController.class)).isFragmentNotMatch() && (currentFrame = getCurrentFrame()) != null && currentFrame.hasInited()) {
            currentFrame.notifyResume(false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onStart();
        if (((ITabFrameController) QRoute.api(ITabFrameController.class)).isFragmentNotMatch()) {
            return;
        }
        for (be beVar : this.mFrames.values()) {
            if (beVar != null) {
                beVar.notifyStart();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onStop();
        if (((ITabFrameController) QRoute.api(ITabFrameController.class)).isFragmentNotMatch() && !this.mForceDoIt) {
            return;
        }
        for (be beVar : this.mFrames.values()) {
            if (beVar != null) {
                beVar.notifyStop();
            }
        }
    }

    public void onTabChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        QLog.i(TAG, 1, "onTabChanged tabId: " + str + ", preTabName: " + this.currentTabName);
        if (str != null) {
            this.tabName = str;
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                this.tabName = str.substring(lastIndexOf + 1, str.length());
            }
            this.tabBeginActionTime = SystemClock.uptimeMillis();
            this.mTabHost.setFirstDrawTrue();
        }
        if (this.preFrame == null && com.tencent.mobileqq.util.af.d() && com.tencent.mobileqq.util.af.a()) {
            this.preFrame = getCurrentFrame(this.currentTabName);
        }
        be beVar = this.preFrame;
        if (beVar != null) {
            beVar.notifyPause(true);
            this.preFrame.dismissLocalSearchDialog();
        }
        be beVar2 = this.preFrame;
        this.preFrame = getCurrentFrame();
        String str2 = this.currentTabName;
        this.currentTabName = str;
        if (com.tencent.mobileqq.util.af.d()) {
            if (this.mIsFirst && str2 == null) {
                QLog.d(TAG, 1, "First show! Not execute update tab changed.");
                return;
            }
        } else if (this.mIsFirst && beVar2 == null) {
            QLog.d(TAG, 1, "First show! Not execute update tab changed.");
            return;
        }
        be beVar3 = this.preFrame;
        if (beVar3 != null && beVar3.hasInited()) {
            this.preFrame.notifyResume(true);
            if (this.preFrame.getContentView() != null) {
                Argus.INSTANCE.updatePage(this.preFrame.getContentView());
            } else {
                QLog.e(TAG, 1, "preFrame has init, but contentView is null");
            }
        }
        ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateUIAfterTabChange(this, str, str2, beVar2);
        if (!"com.tencent.mobileqq.activity.qcircle.QCircleFrame".equals(str)) {
            recoverTab();
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (this.preFrame != null && baseActivity != null) {
            QUIImmersiveHelper.t(baseActivity.getWindow(), true, this.preFrame.getContentView(), true, this.preFrame.getContentView());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    public void pauseBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null && !qQBlurViewWrapper.isPaused()) {
            this.mTabBlurView.onPause();
        }
    }

    public void pauseTabBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onPause();
            this.mBlurSuspended = true;
        }
    }

    public void recoverTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            recoverTab(this, null);
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    public void removeFrame(Class<? extends Frame> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) cls);
            return;
        }
        be frame = getFrame(cls);
        if (frame != null) {
            frame.notifyDestroy();
        }
        String name = cls.getName();
        this.mFrames.remove(name);
        HashMap<String, e> hashMap = this.mTabSpecCache;
        if (hashMap != null) {
            hashMap.remove(name);
        }
        QLog.i(TAG, 1, "removeFrame  clz:" + cls + ", removableFrame:" + frame + ", mTabHost:" + System.identityHashCode(this.mTabHost));
    }

    public void resumeBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onResume();
        }
    }

    public void resumeTabBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this);
            return;
        }
        QQBlurViewWrapper qQBlurViewWrapper = this.mTabBlurView;
        if (qQBlurViewWrapper != null) {
            qQBlurViewWrapper.onResume();
            this.mBlurSuspended = false;
        }
    }

    public void setCurrentTab(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        d dVar = this.mTabIndicator;
        if (dVar != null) {
            dVar.setCurrentTab(i3);
        }
    }

    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        be currentFrame = getCurrentFrame();
        if (currentFrame != null) {
            return currentFrame.getLastActivityName();
        }
        return null;
    }

    public void setQQHeadVisibility(int i3, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, i3, (Object) str);
        }
    }

    public void setTabNotifyIcon(String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str, (Object) view);
        } else {
            this.mTabNotifyIcon.put(str, view);
        }
    }

    public void updateMain(int i3, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).updateFrames(this, i3, i16, obj);
        }
    }

    protected void updateNecessaryUI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateSoundEffectEnableOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ((ITabFrameController) QRoute.api(ITabFrameController.class)).onResumeUpdateSound(this);
        }
    }

    public void updateTabFaceId(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        TabDragAnimationView tabDragAnimationView = this.mTabDragIcon.get(i3);
        if (tabDragAnimationView != null) {
            if (this.mIsDefaultTheme) {
                i16 = -1;
            }
            tabDragAnimationView.setFaceDrawable(i16);
            if (this.mIsDefaultTheme) {
                i17 = -1;
            }
            tabDragAnimationView.setFacePressedDrawable(i17);
        }
    }

    public void updateTabSetting(@Nullable BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, IRedTouchManager iRedTouchManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) redTypeInfo, (Object) iRedTouchManager);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    public static void recoverTab(FrameFragment frameFragment, View view) {
        QQBlurViewWrapper qQBlurViewWrapper;
        if (frameFragment == null || (qQBlurViewWrapper = frameFragment.mTabBlurView) == null) {
            return;
        }
        qQBlurViewWrapper.invalidate();
    }

    public View createTabContent(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        }
        QLog.i(TAG, 1, "createTabContent  tag:" + str);
        View view = null;
        if (getBaseActivity() == null) {
            QLog.e(TAG, 1, "FrameFragment.createTabContent getActivity == null");
            return null;
        }
        if (getBaseActivity().getAppRuntime() == null) {
            QLog.e(TAG, 1, "FrameFragment.createTabContent appRuntime == null");
            return null;
        }
        be beVar = this.mFrames.get(str);
        if (beVar != null && beVar.getContentView() != null) {
            QLog.e(TAG, 1, "createTabContent cache className:" + str);
            view = beVar.getContentView();
        }
        if (view == null) {
            view = loadFrameContent(str, false, z16);
        }
        Argus.INSTANCE.getNode(view, this.mFrames.get(str), true);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public View loadFrameContent(String str, boolean z16, boolean z17) {
        View notifyCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            QLog.e(TAG, 1, "loadFrameContent activity is null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "loadFrameContent className is empty");
            return null;
        }
        be frame = getFrame(str);
        if (frame == null) {
            QLog.e(TAG, 1, "loadFrameContent frame is null");
            return null;
        }
        frame.setActivity(baseActivity);
        if (z16) {
            notifyCreateView = frame.preLoadView(baseActivity.getLayoutInflater());
        } else {
            notifyCreateView = frame.notifyCreateView(baseActivity.getLayoutInflater());
        }
        if (notifyCreateView != null) {
            notifyCreateView.setTag(R.id.tx6, str);
        }
        frame.notifyContentView(notifyCreateView);
        frame.notifyCreate();
        if (this.mFrames.isEmpty() && com.tencent.mobileqq.util.af.d() && z17) {
            frame.notifyResume(false);
        }
        updateNecessaryUI(str);
        this.mFrames.put(str, frame);
        QLog.i(TAG, 1, "loadFrameContent className=" + str + ", isPreload=" + z16);
        return notifyCreateView;
    }

    public void setCurrentTab(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        d dVar = this.mTabIndicator;
        if (dVar != null) {
            dVar.setCurrentTab(i3, z16);
        }
    }

    private be getCurrentFrame(String str) {
        if (str == null) {
            QLog.e(TAG, 1, "tabTag=null");
            return null;
        }
        return this.mFrames.get(str);
    }

    public void enableBlur(View view, View view2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) view, (Object) view2);
            return;
        }
        if (view == null) {
            QLog.e(TAG, 1, "enableBlur: tabWidget == null");
            return;
        }
        int color = this.mTabBlurView.getContext().getResources().getColor(R.color.qui_common_bg_nav_bottom);
        f.a aVar = new f.a(Build.VERSION.SDK_INT >= 24, 64.0f, view2, color, new ColorDrawable(color), Integer.valueOf(R.drawable.qui_tab_bottom_nav_bg));
        aVar.l(this.enableBlurViewDirectDraw);
        aVar.m(true);
        if (this.enableBlurSourceDirtyState) {
            aVar.n(new f.d(new b(view2), null));
        }
        this.mTabBlurView.setVisibility(0);
        this.mTabBlurView.a(aVar);
        this.mTabBlurView.setDrawBackgroundListener(getDrawBackgroundListener());
        if (!this.mBlurSuspended) {
            this.mTabBlurView.onResume();
        }
        view.setBackgroundColor(0);
        Iterator<Map.Entry<String, View>> it = this.mTabViewMap.entrySet().iterator();
        while (it.hasNext()) {
            View value = it.next().getValue();
            if (value != null) {
                value.setBackgroundColor(0);
            }
        }
        refreshBlurView(this.mTabBlurView);
        QLog.i(TAG, 1, "enableBlur:" + System.identityHashCode(this.mTabBlurView) + " mBlurSuspended:" + this.mBlurSuspended + " visibility:" + this.mTabBlurView.getVisibility());
    }

    public be getFrame(Class<? extends Frame> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (be) iPatchRedirector.redirect((short) 40, (Object) this, (Object) cls);
        }
        Map<String, be> map = this.mFrames;
        if (map != null) {
            return map.get(cls.getName());
        }
        return null;
    }
}
