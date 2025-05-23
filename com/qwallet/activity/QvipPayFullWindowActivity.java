package com.qwallet.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.compat.f;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webviewplugin.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QvipPayFullWindowActivity extends QWalletBaseFragment implements u {
    public static final String ACTION_CLICK_SUCCESS = "action_click_success";
    public static final String ACTION_PAY_SUCCESS_ACTIVITY = "action_pay_success_activity";
    public static final String EXTRA_KEY_CLICK_TIME = "extra_key_click_time";
    public static String FROM_QWALLET_MAIN_PAGE = "from_qwallet_main_page";
    public static String FROM_QWALLET_SUCCESS_PAGE = "from_qwallet_success_page";
    private static final String KEY_FROM = "FROM";
    private static final String KEY_OPTION = "OPTION";
    private static final String KEY_PENETRATION = "PENETRATION";
    private static final String KEY_TIME = "TIME";
    private static final String KEY_URL = "URL";
    public static final String TAG = "QvipPayFullWindowActivity";
    private static List<String> existList = new ArrayList();
    protected Rect clickRect;
    private String from;
    private boolean isNeedPenetration;
    protected long mClickTime;
    protected int mCurrentStep;
    private boolean mIsWebViewCache;
    private OfflinePlugin mOfflinePlugin;
    protected ResultReceiver mResultReceiver;
    protected long mTimeBeforeLoadUrl;
    private CustomWebView mWebView;
    protected long onCreateTime;
    public int option;
    private b reciver;
    private int statusColor;
    private z3.a webViewBuilder;
    private boolean isOverloading = false;
    private int mCanClickHeight = -1;
    private boolean errorFinish = false;
    private long mStartLoadUrlMilliTimeStamp = 0;
    protected long mOnCreateMilliTimeStamp = 0;
    private boolean mFirstRequest = true;
    protected long mCurrentStepTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends z3.a {
        a(Context context, Activity activity, AppRuntime appRuntime) {
            super(context, activity, appRuntime);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!"about:blank".equalsIgnoreCase(str)) {
                QvipPayFullWindowActivity qvipPayFullWindowActivity = QvipPayFullWindowActivity.this;
                if (qvipPayFullWindowActivity.mCurrentStep == 2) {
                    qvipPayFullWindowActivity.mCurrentStep = 8;
                    qvipPayFullWindowActivity.mCurrentStepTime = System.currentTimeMillis();
                }
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!isIsFirstOnPageStart()) {
                QvipPayFullWindowActivity.this.mFirstRequest = false;
                QvipPayFullWindowActivity.this.resetTimer(null);
            }
            if (isIsFirstOnPageStart()) {
                setIsFirstOnPageStart(false);
                setStartLoadUrlMilliTimeStamp(System.currentTimeMillis());
            }
            if (!"about:blank".equalsIgnoreCase(str)) {
                QvipPayFullWindowActivity qvipPayFullWindowActivity = QvipPayFullWindowActivity.this;
                qvipPayFullWindowActivity.mCurrentStep = 2;
                qvipPayFullWindowActivity.mCurrentStepTime = System.currentTimeMillis();
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i(AbsWebView.TAG, 2, "onReceivedError code = " + i3 + " desc = " + str + "errorFinish = " + QvipPayFullWindowActivity.this.errorFinish + " failurl = " + str2);
            }
            if (QvipPayFullWindowActivity.this.errorFinish) {
                QvipPayFullWindowActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<QvipPayFullWindowActivity> f41272a;

        public b(QvipPayFullWindowActivity qvipPayFullWindowActivity) {
            this.f41272a = new WeakReference<>(qvipPayFullWindowActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (intent != null && intent.getAction() != null) {
                QvipPayFullWindowActivity qvipPayFullWindowActivity = this.f41272a.get();
                if (qvipPayFullWindowActivity != null && !qvipPayFullWindowActivity.isFinishing()) {
                    String action = intent.getAction();
                    if (QLog.isColorLevel()) {
                        QLog.i(QvipPayFullWindowActivity.TAG, 2, "pros action = " + action);
                    }
                    if (action.equals("cn.abel.action.broadcast")) {
                        qvipPayFullWindowActivity.finish();
                        return;
                    }
                    if (QvipPayFullWindowActivity.ACTION_CLICK_SUCCESS.equals(action)) {
                        if (qvipPayFullWindowActivity.option == 2) {
                            qvipPayFullWindowActivity.finish();
                            return;
                        }
                        return;
                    } else {
                        if (QvipPayFullWindowActivity.ACTION_PAY_SUCCESS_ACTIVITY.equals(action) && (extras = intent.getExtras()) != null) {
                            qvipPayFullWindowActivity.initClickRect(extras);
                            return;
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i(QvipPayFullWindowActivity.TAG, 2, "error call, back..." + qvipPayFullWindowActivity);
                }
            }
        }
    }

    private boolean canPassTouchEventToHost(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        Rect rect = this.clickRect;
        if (rect != null && rect.contains(rawX, rawY)) {
            return true;
        }
        int i3 = this.mCanClickHeight;
        if (i3 != -1 && i3 > rawY) {
            return true;
        }
        return false;
    }

    private void checkOfflinePlugin() {
        CustomWebView customWebView;
        WebViewPluginEngine pluginEngine;
        WebViewPlugin m3;
        if (this.mOfflinePlugin == null && (customWebView = this.mWebView) != null && (pluginEngine = customWebView.getPluginEngine()) != null && (m3 = pluginEngine.m("offline")) != null && (m3 instanceof OfflinePlugin)) {
            this.mOfflinePlugin = (OfflinePlugin) m3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initClickRect(Bundle bundle) {
        this.clickRect = (Rect) bundle.getParcelable("clickRect");
        this.mCanClickHeight = bundle.getInt("canClickHeight");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "clickRect = " + this.clickRect + ", mCanClickHeight = " + this.mCanClickHeight);
        }
    }

    private void initFullWebView(Intent intent, String str) {
        this.isOverloading = false;
        String stringExtra = intent.getStringExtra(KEY_FROM);
        this.from = stringExtra;
        List<String> list = existList;
        if (list != null) {
            list.add(stringExtra);
        }
        this.isNeedPenetration = intent.getBooleanExtra(KEY_PENETRATION, false);
        this.option = intent.getIntExtra(KEY_OPTION, 0);
        if (TextUtils.isEmpty(str)) {
            finish();
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.mResultReceiver = (ResultReceiver) extras.getParcelable("receiver");
            this.errorFinish = extras.getBoolean("errorFinish");
            initClickRect(extras);
            syncCookie(str, (Map) extras.getSerializable("cookieMap"));
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "url = " + str);
        }
        this.mWebView.loadUrl(str);
    }

    private void initFullWebViewControler(Bundle bundle) {
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime(getModuleId());
        a aVar = new a(getActivity(), getOutActivity(), appRuntime);
        this.webViewBuilder = aVar;
        aVar.a(true);
        new m(this.webViewBuilder).a(bundle, appRuntime, getIntent());
        this.mWebView = this.webViewBuilder.getWebView();
    }

    private void initOverLoadingWebView(Intent intent, String str) {
        this.isOverloading = true;
        printCookies(str);
        this.mWebView.loadUrl(str);
    }

    private void initReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("cn.abel.action.broadcast");
        intentFilter.addAction(ACTION_CLICK_SUCCESS);
        intentFilter.addAction(ACTION_PAY_SUCCESS_ACTIVITY);
        b bVar = new b(this);
        this.reciver = bVar;
        try {
            registerReceiver(bVar, intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public static boolean isFullWindowExist(String str) {
        List<String> list = existList;
        if (list != null && list.contains(str)) {
            return true;
        }
        return false;
    }

    public static Intent mkIntent(QWalletBaseFragment qWalletBaseFragment, String str, boolean z16, int i3, String str2) {
        if (qWalletBaseFragment != null && !TextUtils.isEmpty(str)) {
            if (FROM_QWALLET_MAIN_PAGE.equals(str2)) {
                QWalletHelperDelegate.sFullWindowActivitySource = 1;
            } else if (FROM_QWALLET_SUCCESS_PAGE.equals(str2)) {
                QWalletHelperDelegate.sFullWindowActivitySource = 2;
            }
            Intent intent = new Intent();
            intent.putExtra(KEY_FROM, str2);
            intent.putExtra("URL", str);
            intent.putExtra(KEY_TIME, System.currentTimeMillis());
            intent.putExtra(KEY_PENETRATION, z16);
            intent.putExtra(KEY_OPTION, i3);
            if (PatternLockUtils.isPatternLockOpened(qWalletBaseFragment.getContext(), QWalletUtils.h())) {
                intent.putExtra(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, true);
            }
            return intent;
        }
        return null;
    }

    public static void openUrl(QWalletBaseFragment qWalletBaseFragment, String str, boolean z16, int i3, String str2) {
        Intent mkIntent = mkIntent(qWalletBaseFragment, str, z16, i3, str2);
        if (mkIntent == null) {
            return;
        }
        qWalletBaseFragment.launchFragment(mkIntent, QvipPayFullWindowActivity.class);
    }

    private void printCookies(String str) {
        try {
            String host = new URL(str).getHost();
            CookieManager cookieManager = CookieManager.getInstance();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "host = " + host + ", cookies = " + cookieManager.getCookie(host));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private void syncCookie(String str, Map<String, String> map) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "syncCookie start......");
        }
        if (map == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "no cookie set.");
                return;
            }
            return;
        }
        try {
            String host = new URL(str).getHost();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            for (String str2 : map.keySet()) {
                cookieManager.setCookie(str, com.tencent.mobileqq.webview.swift.cookie.b.b(str2, map.get(str2), host, false));
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "get cookies = " + cookieManager.getCookie(host));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    public void callReceiverWhenDestroy() {
        if (!this.isOverloading && this.mResultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "full_webview_finish");
            bundle.putString(KEY_FROM, this.from);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "mResultReceiver callback : " + bundle);
            }
            this.mResultReceiver.send(0, bundle);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        CustomWebView customWebView;
        boolean dispatchTouchEvent;
        if (isFinishing()) {
            return false;
        }
        if (!canPassTouchEventToHost(motionEvent)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "the click point is out of scrop...");
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.isOverloading && (customWebView = this.mWebView) != null && this.isNeedPenetration) {
            try {
                customWebView.setDrawingCacheEnabled(true);
                this.mWebView.buildDrawingCache(true);
                Bitmap drawingCache = this.mWebView.getDrawingCache();
                if (drawingCache == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "drawingCache is null!");
                    }
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                } else {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (rawX >= 0.0f && rawX < drawingCache.getWidth() && rawY >= 0.0f && rawY < drawingCache.getHeight()) {
                        int pixel = drawingCache.getPixel((int) rawX, (int) rawY);
                        int i3 = pixel >>> 24;
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "color = 0x" + Integer.toHexString(pixel) + ", a = " + Integer.toHexString(i3));
                        }
                        if (i3 >= 64) {
                            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "start dispatch event to super activity.");
                            }
                            if (FROM_QWALLET_SUCCESS_PAGE.equalsIgnoreCase(this.from)) {
                                Intent intent = new Intent(IActivity.ACTION_TOUCH_EVENT + FROM_QWALLET_SUCCESS_PAGE);
                                intent.putExtra(KEY_FROM, this.from);
                                Bundle bundle = new Bundle();
                                bundle.putString("type", "full_webview_event");
                                bundle.putParcelable("event", motionEvent);
                                bundle.putString(KEY_FROM, this.from);
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "mResultReceiver back : " + bundle);
                                }
                                intent.putExtras(bundle);
                                intent.putExtra(IActivity.EXTRA_KEY_EVENT, motionEvent);
                                getApplicationContext().sendBroadcast(intent);
                            } else {
                                Intent intent2 = new Intent(IActivity.ACTION_TOUCH_EVENT);
                                intent2.putExtra(KEY_FROM, this.from);
                                intent2.putExtra(IActivity.EXTRA_KEY_EVENT, motionEvent);
                                getApplicationContext().sendBroadcast(intent2);
                            }
                            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        }
                    }
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                }
                return dispatchTouchEvent;
            } finally {
                this.mWebView.destroyDrawingCache();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "dispatchTouchEvent isOverloading = " + this.isOverloading);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public Bundle getBundle() {
        return getIntent().getExtras();
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getDetect302Time() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public boolean getIsReloadUrl() {
        return false;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getOpenUrlAfterCheckOfflineTime() {
        checkOfflinePlugin();
        OfflinePlugin offlinePlugin = this.mOfflinePlugin;
        if (offlinePlugin != null) {
            return offlinePlugin.L;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getReadIndexFromOfflineTime() {
        checkOfflinePlugin();
        OfflinePlugin offlinePlugin = this.mOfflinePlugin;
        if (offlinePlugin != null) {
            return offlinePlugin.M;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public JSONObject getX5Performance() {
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getgetWebViewTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getinitBrowserTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getinitTBSTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getinitTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public boolean getisWebViewCache() {
        return this.mIsWebViewCache;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getmClickTime() {
        return this.mClickTime;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getmOnCreateMilliTimeStamp() {
        return this.mOnCreateMilliTimeStamp;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public boolean getmPerfFirstLoadTag() {
        return this.mFirstRequest;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getmStartLoadUrlMilliTimeStamp() {
        return this.mStartLoadUrlMilliTimeStamp;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getmTimeBeforeLoadUrl() {
        return this.mTimeBeforeLoadUrl;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getonCreateTime() {
        return this.onCreateTime;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getpluginFinished() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public long getviewInflateTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public boolean isMainPageUseLocalFile() {
        checkOfflinePlugin();
        OfflinePlugin offlinePlugin = this.mOfflinePlugin;
        if (offlinePlugin != null) {
            return offlinePlugin.T;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onActivityResult requestCode = " + i3 + " resultCode = " + i16 + " intent = " + intent);
        }
        if (i3 == 5) {
            finish();
        } else if (i16 == 4660) {
            super.setResult(4660);
            finish();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i3;
        super.onCreate(bundle);
        if (WebAccelerateHelper.isWebViewEntered) {
            this.mIsWebViewCache = true;
        }
        this.onCreateTime = System.currentTimeMillis();
        CookieSyncManager.createInstance(getContext());
        boolean b16 = ul2.a.b();
        if (b16) {
            i3 = -1;
        } else {
            i3 = -16777216;
        }
        this.statusColor = i3;
        ul2.a aVar = new ul2.a(getActivity(), this.statusColor, null);
        if (b16) {
            aVar.f(true);
        }
        Intent intent = getIntent();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start fullwindow cost:" + (System.currentTimeMillis() - intent.getLongExtra(KEY_TIME, 0L)));
        }
        initFullWebViewControler(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initReceiver();
        View b16 = this.webViewBuilder.b();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, b16);
        return b16;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onDestroy......");
        }
        super.onDestroy();
        callReceiverWhenDestroy();
        List<String> list = existList;
        if (list != null) {
            list.remove(this.from);
        }
        z3.a aVar = this.webViewBuilder;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.reciver;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.reciver = null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        z3.a aVar = this.webViewBuilder;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        z3.a aVar = this.webViewBuilder;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Intent intent = getIntent();
        String string = intent.getExtras().getString("url");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "overloading url = " + string);
        }
        if (!TextUtils.isEmpty(string)) {
            initOverLoadingWebView(intent, string);
        } else {
            initFullWebView(intent, intent.getStringExtra("URL"));
        }
    }

    public void resetTimer(Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mOnCreateMilliTimeStamp = currentTimeMillis;
        this.mCurrentStepTime = currentTimeMillis;
        if (intent != null) {
            this.mClickTime = intent.getLongExtra(EXTRA_KEY_CLICK_TIME, currentTimeMillis);
        } else {
            this.mClickTime = System.currentTimeMillis();
        }
        this.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
        this.mTimeBeforeLoadUrl = System.currentTimeMillis();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.webviewplugin.u
    public void setX5Performance(JSONObject jSONObject) {
    }
}
