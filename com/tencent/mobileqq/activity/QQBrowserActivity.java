package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@RoutePage(desc = "\u5185\u7f6e\u6d4f\u89c8\u5668", path = RouterConstants.UI_ROUTE_BROWSER)
/* loaded from: classes9.dex */
public class QQBrowserActivity extends QBaseActivity implements com.tencent.mobileqq.webviewplugin.j, b.e, IBrowserThirdAppReport {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_NAME = "action_name";
    public static final String ACTION_UPDATE_VIP_INFO = "com.tencent.mobileqq.opencenter.vipInfo";
    public static final String ACTION_VIEW_SELF_ALBUM = "com.tencent.mobileqq.view.self.album";
    public static final String APP_ID = "appid";
    public static final String APP_PARAM = "extraParams";
    public static final String ARTICAL_CHANNEL_EXTRAL_INFO = "ARTICAL_CHANNEL_EXTRAL_INFO";
    public static final String BROADCAST_ACTION_KEY = "broadcastAction";
    public static final int CHANNEL_C2C_AIO = 2;
    public static final int CHANNEL_CONTACT_ADD_SEARCH = 12;
    public static final int CHANNEL_CONTACT_SEARCH = 11;
    public static final int CHANNEL_DISCUSSION_AIO = 4;
    public static final int CHANNEL_DYBAMIC_SEARCH = 13;
    public static final int CHANNEL_KANDIAN = 7;
    public static final int CHANNEL_NO_REPORT = 0;
    public static final int CHANNEL_PB_AIO = 1;
    public static final int CHANNEL_QZONE_FEED = 5;
    public static final int CHANNEL_QZONE_KANDIAN = 6;
    public static final int CHANNEL_READINJOY_CONVERSION = 9;
    public static final int CHANNEL_READINJOY_SEARCH = 14;
    public static final int CHANNEL_TAB_SEARCH = 10;
    public static final int CHANNEL_TROOP_AIO = 3;
    public static final String EXTRA_FINISH_ANIMATION_NONE = "finish_animation_none";
    public static final String EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT = "finish_animation_out_to_right";
    public static final String EXTRA_FINISH_ANIMATION_OUT_TO_TOP = "finish_animation_out_to_top";
    public static final String EXTRA_FINISH_ANIMATION_UP_DOWN = "finish_animation_up_down";
    public static final String EXTRA_FINISH_ANIMATION_UP_DOWN_GUILD = "finish_animation_up_down_guild";
    public static final String EXTRA_THEME_ID = "extra_theme_id";
    private static final String FLAG_BROWSER_RESTORE = "browserRestoreFlag";
    public static final String FRAGMENT_CLASS = "fragment_class";
    public static final HashSet<String> HW_FORBINDDEN_LIST;
    public static final String INEWS_HEADLINES_URL = "miniqb://home";
    public static final String INEWS_PUBLIC_UIN = "2909288299";
    public static final String IS_OPENING_QUN_APP = "isOpeningQunApp";
    public static final String IS_WRAP_CONTENT = "is_wrap_content";
    public static final String KEY_DISCUSS_GROUP_UIN = "dicussgroup_uin";
    public static final String KEY_FAV_GROUP_ID = "favGroupID";
    public static final String KEY_FAV_ID = "favID";
    public static final String KEY_FRIEND_UIN = "friend_uin";
    public static final String KEY_FROM_FAV = "fromFav";
    public static final String KEY_FROM_NEARBY = "fromNearby";
    public static final String KEY_GROUP_UIN = "groupUin";
    public static final String KEY_IS_SEND = "is_send";
    public static final String KEY_IS_TRANSPARENT_TITLE = "isTransparentTitle";
    private static final String KEY_MAINTAB_INDEX = "key_maintab";
    public static final String KEY_MSG_TYPE = "msgType";
    public static final String KEY_PAY_ACTION_RESULT = "key_pay_action_result";
    public static final String KEY_SENDER_UIN = "friendUin";
    public static final String KEY_UIN_TYPE = "uinType";
    public static final String MAIN_ACTION = "webview";
    public static final int PLUGIN_START_REQUEST_CODE = 10000;
    public static final String QB_DOT_SHOW_VERSION_CODE_KEY = "version_code_key";
    public static final String QQBROWSER_DOWNLOAD_URL_DIRECT = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079";
    public static final String QQBROWSER_DOWNLOAD_URL_DIRECT_QBSHARE = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367";
    public static final int REQ_TYPE_BROWSE_ALBUM = 2;
    public static final int REQ_TYPE_TROOP_MEMBER_LEVEL = 5;
    public static final int RESULT_FINISHSELF = 4660;
    public static final int SUMMARY_FOR_SEND_TO_FRIEND = 1;
    public static final int SUMMARY_FOR_SEND_TO_READINJOY = 5;
    public static final int SUMMARY_FOR_SEND_TO_WECHAT = 3;
    public static final int SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE = 4;
    public static final int SUMMARY_FOR_SHARE_TO_QZONE = 2;
    public static final String TAB_CONFIG_DATA = "tabConfigData";
    public static final String TAB_DEFAULT_INDEX = "tabDefaultIndex";
    public static final String TAG = "WebLog_QQBrowserActivity";
    public static final String TOPTAB_SELECT_INDEX = "topTabSelectIndex";
    public static final String TOPTAB_SWITCH_FRAGMENT = "topTabSwitchFragment";
    public static final String TROOP_ID = "troopid";
    public static final String WEB_FLOAT_SHORTCUT_FROM = "qqbrowser_float_shortcut";
    public static int sQQBrowserActivityCounter;
    public int currentTabIndex;
    private FrameLayout fragmentContentView;
    private boolean fromRestore;

    @NonNull
    private com.tencent.mobileqq.webview.util.k inject;
    public final com.tencent.mobileqq.webview.swift.component.b mComponentsProvider;
    public Class<? extends WebViewFragment> mFragmentClass;
    public int oldTabSelectIndex;
    public ArrayList<WebViewTabBarData> tabBarConfigData;
    private View tabBarView;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class a implements TabBarView.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final WeakReference<QQBrowserActivity> f176746d;

        a(QQBrowserActivity qQBrowserActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQBrowserActivity);
            } else {
                this.f176746d = new WeakReference<>(qQBrowserActivity);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabBarView.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QQBrowserActivity qQBrowserActivity = this.f176746d.get();
            if (qQBrowserActivity != null && i3 != i16) {
                QQBrowserActivity.switchFragment(i16, qQBrowserActivity);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
        } else {
            HW_FORBINDDEN_LIST = com.tencent.mobileqq.webview.util.w.f314885b;
            sQQBrowserActivityCounter = 0;
        }
    }

    public QQBrowserActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.oldTabSelectIndex = -1;
        this.currentTabIndex = 0;
        this.fromRestore = false;
        this.mFragmentClass = null;
        this.mComponentsProvider = createComponentsProvider();
        this.inject = (com.tencent.mobileqq.webview.util.k) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.util.k.class);
    }

    private void doOverrideAnim() {
        if (this.inject.c()) {
            overridePendingTransition(0, 0);
        }
        if (getIntent().getBooleanExtra(EXTRA_FINISH_ANIMATION_UP_DOWN, false)) {
            overridePendingTransition(0, R.anim.f154423k);
        }
        if (getIntent().getBooleanExtra(EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, false)) {
            overridePendingTransition(0, R.anim.f154880eu);
        }
        if (getIntent().getBooleanExtra(EXTRA_FINISH_ANIMATION_OUT_TO_TOP, false)) {
            overridePendingTransition(0, R.anim.h_);
        }
        if (getIntent().getBooleanExtra(EXTRA_FINISH_ANIMATION_NONE, false)) {
            overridePendingTransition(0, 0);
        }
        if (getIntent().getBooleanExtra(EXTRA_FINISH_ANIMATION_UP_DOWN_GUILD, false)) {
            overridePendingTransition(0, R.anim.f154636p8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$postReportDestroyException$0(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", str);
        hashMap.put("message", str2);
        hashMap.put("osVer", "" + Build.VERSION.SDK_INT);
        try {
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "QQBrowserActivity_destroy_exception", true, 0L, 0L, hashMap, "");
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "postReportDestroyException: " + th5.getMessage(), th5);
        }
    }

    public static void postReportDestroyException(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.eq
            @Override // java.lang.Runnable
            public final void run() {
                QQBrowserActivity.lambda$postReportDestroyException$0(str, str2);
            }
        }, 128, null, true);
    }

    public static WebViewFragment switchFragment(int i3, QQBrowserActivity qQBrowserActivity) {
        WebViewTabBarData webViewTabBarData = qQBrowserActivity.tabBarConfigData.get(i3);
        WebViewFragment fragmentByTabBarData = qQBrowserActivity.getFragmentByTabBarData(webViewTabBarData);
        FragmentTransaction beginTransaction = qQBrowserActivity.getSupportFragmentManager().beginTransaction();
        qQBrowserActivity.hideCurrentWebViewFragment(beginTransaction);
        if (!fragmentByTabBarData.isAdded()) {
            beginTransaction.add(R.id.b9v, fragmentByTabBarData, webViewTabBarData.tag);
        } else {
            beginTransaction.show(fragmentByTabBarData);
        }
        beginTransaction.commitAllowingStateLoss();
        qQBrowserActivity.currentTabIndex = i3;
        return fragmentByTabBarData;
    }

    protected boolean checkShouldNavigate(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.component.e eVar = (com.tencent.mobileqq.webview.swift.component.e) this.mComponentsProvider.a(1);
        if (eVar != null) {
            if (eVar.h(intent)) {
                QLog.e(TAG, 1, "navigate to another activity!");
                return true;
            }
            if (eVar.g(intent) && QLog.isColorLevel()) {
                QLog.i(TAG, 2, "switch to different fragment.");
                return false;
            }
            return false;
        }
        return false;
    }

    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.webview.swift.component.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.webview.swift.component.b(this, 513, null);
    }

    public WebViewFragment createFragment(Intent intent) {
        WebViewFragment webViewFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 24, (Object) this, (Object) intent);
        }
        Class<? extends WebViewFragment> cls = this.mFragmentClass;
        if (cls != null) {
            try {
                webViewFragment = cls.newInstance();
            } catch (Exception unused) {
                webViewFragment = new WebViewFragment();
            }
        } else if (!TextUtils.isEmpty(intent.getStringExtra("fragment_class"))) {
            try {
                Object newInstance = Class.forName(intent.getStringExtra("fragment_class")).newInstance();
                if (newInstance instanceof WebViewFragment) {
                    webViewFragment = (WebViewFragment) newInstance;
                } else {
                    webViewFragment = null;
                }
                if (webViewFragment == null) {
                    webViewFragment = new WebViewFragment();
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (ClassNotFoundException e17) {
                e17.printStackTrace();
            } catch (InstantiationException e18) {
                e18.printStackTrace();
            } finally {
                new WebViewFragment();
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        webViewFragment.setArguments(bundle);
        return webViewFragment;
    }

    public void createTabBarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ArrayList<WebViewTabBarData> arrayList = this.tabBarConfigData;
        if (arrayList != null && arrayList.size() > 1 && this.tabBarView == null) {
            View a16 = com.tencent.mobileqq.webview.swift.aq.a(this, super.getIntent(), this.tabBarConfigData, new a(this));
            this.tabBarView = a16;
            a16.setId(R.id.j9z);
            ViewParent parent = this.fragmentContentView.getParent();
            if (parent instanceof FrameLayout) {
                if (!super.getIntent().getBooleanExtra(TOPTAB_SWITCH_FRAGMENT, false)) {
                    ((FrameLayout) parent).addView(this.tabBarView, new FrameLayout.LayoutParams(-1, -2, 80));
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fragmentContentView.getLayoutParams();
                    layoutParams.bottomMargin = (int) ((getResources().getDisplayMetrics().density * 54.0f) + 0.5f);
                    this.fragmentContentView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            QLog.e(TAG, 1, "doOnCreate error:should not enter here!");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                throw new UnknownError("should not enter here!");
            }
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.j
    public WebViewFragment createWebViewFragment(WebViewTabBarData webViewTabBarData, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webViewTabBarData, (Object) intent);
        }
        intent.putExtra("url", webViewTabBarData.url);
        WebViewFragment b16 = com.tencent.mobileqq.webview.swift.aa.b(intent.getIntExtra("fragmentStyle", 0), this, webViewTabBarData, intent);
        if (b16 != null) {
            return b16;
        }
        WebViewFragment a16 = com.tencent.mobileqq.webview.swift.aa.a(this, webViewTabBarData, intent);
        if (a16 != null) {
            return a16;
        }
        return createFragment(intent);
    }

    protected boolean directSuperDoOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) bundle)).booleanValue();
        }
        return super.doOnCreate(bundle);
    }

    protected void directSuperOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void doFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "finish");
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.activityFinish();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && super.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(super.getCurrentFocus().getWindowToken(), 0);
        }
        super.finish();
        doOverrideAnim();
        if (currentWebViewFragment != null && currentWebViewFragment.getUIStyle() != null) {
            if ((currentWebViewFragment.getUIStyle().f314625h & 256) != 0) {
                overridePendingTransition(0, 0);
            } else if ((currentWebViewFragment.getUIStyle().f314625h & 512) != 0) {
                overridePendingTransition(0, R.anim.f154458a7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("doOnActivityResult resultCode=0x%x requestCode=0x%x", Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        if (i16 == 4660) {
            if (intent != null) {
                super.setResult(4660, intent);
            } else {
                super.setResult(4660);
            }
            finish();
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.doOnActivityResult(i3, i16, intent);
        }
        if (currentWebViewFragment == null && QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("doOnActivityResult curFragment is null", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Class<? extends WebViewFragment> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate start");
        }
        int i3 = Build.VERSION.SDK_INT;
        if (!HW_FORBINDDEN_LIST.contains(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel())) {
            getWindow().addFlags(16777216);
        }
        getWindow().setFormat(-3);
        View view = null;
        getWindow().setBackgroundDrawable(null);
        this.mNeedStatusTrans = false;
        FrameLayout frameLayout = new FrameLayout(this);
        super.doOnCreate(bundle);
        int i16 = -1;
        super.setContentView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            super.getActivity().getWindow().addFlags(67108864);
        }
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        Intent intent = super.getIntent();
        long longExtra = intent.getLongExtra("startOpenPageTime", -1L);
        if (longExtra == -1 || System.currentTimeMillis() - longExtra > 5000) {
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        Bundle extras = intent.getExtras();
        if (extras != null && (cls = (Class) extras.getSerializable("fragmentClass")) != null) {
            this.mFragmentClass = cls;
        }
        this.tabBarConfigData = com.tencent.mobileqq.webview.swift.aq.b(intent);
        int intExtra = intent.getIntExtra(TAB_DEFAULT_INDEX, 0);
        intent.removeExtra(TAB_DEFAULT_INDEX);
        this.fragmentContentView = frameLayout;
        if (this.tabBarConfigData.size() > 1 && !(frameLayout.getParent() instanceof FrameLayout)) {
            FrameLayout frameLayout2 = new FrameLayout(this);
            this.fragmentContentView = frameLayout2;
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            QLog.i(TAG, 1, "doOnCreate warning:content is not an instance of FrameLayout.");
        }
        this.fragmentContentView.setId(R.id.b9v);
        WebViewTabBarData webViewTabBarData = this.tabBarConfigData.get(intExtra);
        WebViewFragment fragmentByTabBarData = getFragmentByTabBarData(webViewTabBarData);
        if (!fragmentByTabBarData.isAdded()) {
            super.getSupportFragmentManager().beginTransaction().add(R.id.b9v, fragmentByTabBarData, webViewTabBarData.tag).commitAllowingStateLoss();
        } else {
            super.getSupportFragmentManager().beginTransaction().show(fragmentByTabBarData).commitAllowingStateLoss();
        }
        if (QLog.isColorLevel() && i3 == 34) {
            View findViewById = findViewById(R.id.b9v);
            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
            if (viewGroup != null) {
                view = viewGroup.getChildAt(0);
            }
            if (view != null) {
                i16 = view.getId();
            }
            QLog.d(TAG, 1, "doOnCreate fromRestore=" + this.fromRestore + ", containerView = " + findViewById + ", rootView = " + viewGroup + ", childView = " + view + ", childId= " + i16);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        sQQBrowserActivityCounter--;
        FrameLayout frameLayout = this.fragmentContentView;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.tabBarView);
            }
            this.tabBarView = null;
        }
        try {
            super.doOnDestroy();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        com.tencent.mobileqq.webview.c.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.doOnKeyDown(i3, keyEvent);
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.doOnNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.doOnPause();
            doOverrideAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean(FLAG_BROWSER_RESTORE, true);
        if (this.tabBarConfigData != null) {
            bundle.putInt(KEY_MAINTAB_INDEX, this.currentTabIndex);
        }
        super.doOnSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        Intent intent = new Intent("tencent.notify.background");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("selfuin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
        intent.putExtra("AccountInfoSync", AppConstants.SYNCWEB);
        intent.putExtra("classname", getClass().getName());
        sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        super.doOnUserLeaveHint();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        if (QLog.isColorLevel() && Build.VERSION.SDK_INT == 34 && i3 == R.id.b9v) {
            T t16 = (T) super.findViewById(i3);
            QLog.d(TAG, 1, "findViewById[content_fragment] result = " + t16);
            return t16;
        }
        return (T) super.findViewById(i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else if (!this.inject.b()) {
            doFinish();
        }
    }

    @Override // mqq.app.IBrowserThirdAppReport
    public String getCurrentUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        try {
            WebView hostWebView = getHostWebView();
            if (hostWebView != null) {
                return hostWebView.getUrl();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public WebViewFragment getCurrentWebViewFragment() {
        List<Fragment> fragments;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        FragmentManager supportFragmentManager = super.getSupportFragmentManager();
        if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if ((fragment instanceof WebViewFragment) && fragment.isVisible()) {
                    return (WebViewFragment) fragment;
                }
            }
            return null;
        }
        return null;
    }

    public WebViewFragment getFragmentByTabBarData(WebViewTabBarData webViewTabBarData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 25, (Object) this, (Object) webViewTabBarData);
        }
        if (webViewTabBarData != null) {
            WebViewFragment webViewFragment = (WebViewFragment) super.getSupportFragmentManager().findFragmentByTag(webViewTabBarData.tag);
            if (webViewFragment == null) {
                Intent intent = super.getIntent();
                Intent intent2 = new Intent(intent);
                WebViewFragment createWebViewFragment = createWebViewFragment(webViewTabBarData, intent2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getFragmentByTabBarData " + createWebViewFragment.getClass().getName());
                }
                createWebViewFragment.onPreInit(intent2);
                intent.removeExtra("startOpenPageTime");
                intent.removeExtra("qqBrowserActivityCreateTime");
                intent.removeExtra("reportSourcsourceeFrom");
                return createWebViewFragment;
            }
            return webViewFragment;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public Activity getHostActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Activity) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebView getHostWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (WebView) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (getWebViewProvider() != null) {
            return getWebViewProvider().getHostWebView();
        }
        return null;
    }

    @Override // mqq.app.AppActivity
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return "modular_web";
    }

    @Override // mqq.app.IBrowserThirdAppReport
    public String getOriginalUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        try {
            Intent intent = getIntent();
            if (intent == null) {
                return "";
            }
            return intent.getStringExtra("url");
        } catch (Throwable unused) {
            return "";
        }
    }

    public FrameLayout getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.fragmentContentView;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return iPatchRedirector.redirect((short) 47, (Object) this, (Object) str);
        }
        int i3 = Build.VERSION.SDK_INT;
        if ((i3 == 34 || i3 == 33) && "uimode".equals(str)) {
            return BaseApplication.getContext().getSystemService("uimode");
        }
        if (i3 == 34 && WebRTCSDK.PRIVILEGE_SENSOR.equals(str)) {
            return BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        if ("connectivity".equals(str)) {
            return BaseApplication.getContext().getSystemService("connectivity");
        }
        return super.getSystemService(str);
    }

    public com.tencent.mobileqq.webview.util.k getWebColorNoteInjector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (com.tencent.mobileqq.webview.util.k) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return this.inject;
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.e
    public WebViewProvider getWebViewProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (WebViewProvider) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return getCurrentWebViewFragment();
    }

    public void hideCurrentWebViewFragment(FragmentTransaction fragmentTransaction) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) fragmentTransaction);
            return;
        }
        if (fragmentTransaction != null && (supportFragmentManager = super.getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if ((fragment instanceof WebViewFragment) && fragment.isVisible()) {
                    fragmentTransaction.hide(fragment);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (!getIntent().getBooleanExtra(IS_WRAP_CONTENT, false)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.doOnBackEvent();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("onConfigurationChanged ori=%d", Integer.valueOf(configuration.orientation)));
            }
            WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
            if (currentWebViewFragment != null) {
                currentWebViewFragment.doOnConfigurationChanged(configuration);
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        com.tencent.mobileqq.webview.e.a(this, bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCreate start :" + getClass().getSimpleName());
        }
        sQQBrowserActivityCounter++;
        com.tencent.mobileqq.webview.swift.v.f(com.tencent.mobileqq.webview.swift.v.f314810f);
        Intent intent = super.getIntent();
        com.tencent.mobileqq.ax.a(this);
        DebugTrace.Step step = DebugTrace.Step.activity_onCreate;
        DebugTrace.h(step, intent.getLongExtra(DebugTrace.Step.click_2_open.name(), 0L));
        int intExtra = intent.getIntExtra("extra_theme_id", 0);
        if (intExtra != 0) {
            setTheme(intExtra);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("custom themeId=%b", Integer.valueOf(intExtra)));
            }
        }
        if (checkShouldNavigate(intent)) {
            super.onCreate(bundle);
            super.getActivity().finish();
            return;
        }
        if (bundle != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.fromRestore = z16;
        if (bundle != null) {
            if (bundle.getBoolean(FLAG_BROWSER_RESTORE)) {
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            }
            int i3 = bundle.getInt(KEY_MAINTAB_INDEX, 0);
            if (i3 != 0) {
                intent.putExtra(KEY_MAINTAB_INDEX, i3);
            }
        }
        intent.putExtra("qqBrowserActivityCreateTime", System.currentTimeMillis());
        QLog.d(TAG, 1, "onCreate createTime = " + System.currentTimeMillis() + ", fromRestore = " + this.fromRestore);
        com.tencent.mobileqq.webview.swift.component.a aVar = (com.tencent.mobileqq.webview.swift.component.a) this.mComponentsProvider.a(512);
        if (aVar != null) {
            aVar.g(intent);
        }
        if (getIntent().getBooleanExtra("isFromFavourite", false)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putAll(intent.getExtras());
        }
        registerActivityLifecycleCallbacks(this.inject);
        super.onCreate(bundle);
        DebugTrace.e(step);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            super.onDestroy();
        } catch (Exception e16) {
            QLog.w(TAG, 1, "onDestroy exception:" + e16.getMessage(), e16);
            postReportDestroyException(e16.getClass().getSimpleName(), e16.getMessage());
        }
    }

    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) webView, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.onPostThemeChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        DebugTrace.Step step = DebugTrace.Step.activity_onResume;
        DebugTrace.g(step);
        super.onResume();
        DebugTrace.e(step);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            super.onStart();
        } catch (IllegalArgumentException e16) {
            throw new IllegalArgumentException(e16.getMessage() + ", " + getCurrentFragments() + ", fromRestore=" + this.fromRestore + ", containerView=" + findViewById(R.id.b9v), e16);
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        super.onWindowFocusChanged(z16);
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.doOnWindowFocusChanged(z16);
        }
        if (z16) {
            com.tencent.mobileqq.ax.b(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void receiveScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        super.receiveScreenOff();
        if (this.mCanLock && ((com.tencent.mobileqq.webview.swift.injector.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.b.class)).a(this)) {
            startUnlockActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) intent);
        } else if (getWindow().getContainer() == null) {
            requestWindowFeature(7);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, z16)).booleanValue();
        }
        View view = this.tabBarView;
        if (view != null) {
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view.setVisibility(i16);
        }
        FrameLayout frameLayout = this.fragmentContentView;
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            if (z16) {
                i3 = 54;
            } else {
                i3 = 0;
            }
            layoutParams.bottomMargin = (int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f);
            this.fragmentContentView.setLayoutParams(layoutParams);
        }
        return false;
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) charSequence);
            return;
        }
        WebViewFragment currentWebViewFragment = getCurrentWebViewFragment();
        if (currentWebViewFragment != null) {
            currentWebViewFragment.setTitle(charSequence.toString());
        }
        super.setTitle(charSequence);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i3, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, fragment, intent, Integer.valueOf(i3), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("startActivityFromFragment requestCode=0x%x", Integer.valueOf(i3)));
        }
        if (i3 == -1) {
            ActivityCompat.startActivityForResult(this, intent, -1, bundle);
        } else {
            ActivityCompat.startActivityForResult(this, intent, i3, bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(@NonNull Fragment fragment, IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, fragment, intentSender, Integer.valueOf(i3), intent, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bundle);
        } else {
            ActivityCompat.startIntentSenderForResult(this, intentSender, i3, intent, i16, i17, i18, bundle);
        }
    }
}
