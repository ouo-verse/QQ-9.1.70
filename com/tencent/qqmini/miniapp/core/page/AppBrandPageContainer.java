package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class AppBrandPageContainer extends FrameLayout implements IAppBrandPageContainer, TabBar.OnTabItemClickListener, Preloadable {
    public static final String KEY_APPID = "appId";
    public static final String KEY_SCENE = "scene";
    public static final int MAX_ALIVEWEBVIEWCOUNT = 10;
    public static final int MAX_LAST_CLICK_COUNT = 10;
    public static final String ON_APP_ENTER_BACKGROUND = "onAppEnterBackground";
    public static final String ON_APP_ENTER_FOREGROUND = "onAppEnterForeground";
    public static final String ON_KEYBOARD_HEIGHT_CHANGE = "onKeyboardHeightChange";
    private static final String TAG = "minisdk-start-AppBrandPageContainer";
    public int aliveWebViewCount;
    private LinkedList<AppBrandPage> appBrandPages;
    private int curShowingInputId;
    private ConcurrentLinkedQueue<ClickPoint> lastClickList;
    private long lastTouchDownTimeStamp;
    private int lastTouchDownX;
    private int lastTouchDownY;
    private int lastTouchUpX;
    private int lastTouchUpY;
    private WeakReference<Activity> mActivity;
    private ApkgInfo mApkgInfo;
    private AppBrandPagePool mAppBrandPagePool;
    private MonitorBroadcastReceiver mBroadcastReceiver;
    private IMiniAppContext mContext;
    private EntryModel mEntryModel;
    EventListener mEventListener;
    private boolean mFromReload;
    private ToastView mLoadingView;
    private MiniAppInfo mMiniAppInfo;
    private MiniAppMonitorInfoView mMiniAppMonitorInfoView;
    private SoftKeyboardStateHelper mSoftKeyboardStateHelper;
    private List<SoftKeyboardStateHelper.SoftKeyboardStateListener> mSoftKeyboardStateListenerList;
    private ConcurrentLinkedQueue<AppBrandPage> redirectOldPages;

    /* loaded from: classes23.dex */
    public static class ClickPoint {
        long clickTimeMills;
        int downX;
        int downY;
        int upX;
        int upY;

        public ClickPoint(int i3, int i16, int i17, int i18, long j3) {
            this.downX = i3;
            this.downY = i16;
            this.upX = i17;
            this.upY = i18;
            this.clickTimeMills = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class MonitorBroadcastReceiver extends BroadcastReceiver {
        MonitorBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals(MiniAppMonitorInfoView.ACTION_SHOW_MONITOR_VIEW)) {
                String str = "show";
                boolean booleanExtra = intent.getBooleanExtra("show", true);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceive action action.qq.miniapp.show.monitorview, ");
                if (!booleanExtra) {
                    str = "hide";
                }
                sb5.append(str);
                sb5.append(" monitor view!");
                QMLog.d(AppBrandPageContainer.TAG, sb5.toString());
                if (AppBrandPageContainer.this.isMonitorViewShowing() != booleanExtra) {
                    AppBrandPageContainer.this.toggleMonitorPanel();
                }
            }
        }
    }

    public AppBrandPageContainer(IMiniAppContext iMiniAppContext, EventListener eventListener) {
        super(iMiniAppContext.getContext());
        this.aliveWebViewCount = 0;
        this.mFromReload = false;
        this.appBrandPages = new LinkedList<>();
        this.curShowingInputId = -1;
        this.mSoftKeyboardStateListenerList = new CopyOnWriteArrayList();
        this.redirectOldPages = new ConcurrentLinkedQueue<>();
        this.lastClickList = new ConcurrentLinkedQueue<>();
        this.mContext = iMiniAppContext;
        this.mEventListener = eventListener;
        this.mSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this);
        this.mAppBrandPagePool = new AppBrandPagePool(iMiniAppContext);
        this.mSoftKeyboardStateHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.1
            @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
            public void onSoftKeyboardClosed() {
                QMLog.e(AppBrandPageContainer.TAG, "onSoftKeyboardClosed ");
                AppBrandPageContainer.this.onSoftKeyClosed();
            }

            @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
            public void onSoftKeyboardOpened(int i3) {
                QMLog.e(AppBrandPageContainer.TAG, "onSoftKeyboardOpened " + i3);
                AppBrandPageContainer.this.onSoftKeyOpened(i3);
            }
        });
    }

    private void executeDownMainPackage(String str) {
        executeDownSubPackage("/__APP__/", str);
    }

    private void executeDownSubPackage(String str, String str2) {
        WeakReference<AppBrandPageContainer> weakReference = new WeakReference<>(this);
        WeakReference<Activity> weakReference2 = this.mActivity;
        if (weakReference2 != null && weakReference2.get() != null) {
            ToastView toastView = new ToastView(this.mActivity.get(), this);
            this.mLoadingView = toastView;
            toastView.show(1, ToastView.ICON_LOADING, null, "\u6b63\u5728\u52a0\u8f7d\u6a21\u5757...", -1, true);
        }
        ApkgManager.getInstance().downloadSubPack(this.mApkgInfo, this.mContext.getMiniAppInfo(), str, getOnInitApkgListener(str, str2, weakReference));
    }

    private AppBrandPage getBrandPage() {
        AppBrandPage appBrandPage;
        LinkedList<AppBrandPage> linkedList = this.appBrandPages;
        if (linkedList != null && linkedList.size() > 0) {
            appBrandPage = this.appBrandPages.poll();
            if (appBrandPage != null) {
                appBrandPage.onPause();
            }
        } else {
            appBrandPage = null;
        }
        if (appBrandPage == null) {
            AppBrandPage appBrandPage2 = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
            addView(appBrandPage2, new FrameLayout.LayoutParams(-1, -1));
            return appBrandPage2;
        }
        return appBrandPage;
    }

    private String getMenuButtonBoundingClientRect(NativeViewRequestEvent nativeViewRequestEvent) {
        if (this.mActivity.get() == null) {
            QMLog.e(TAG, "getMenuButtonBoundingClientRect mActivity == null");
            return "";
        }
        if (getCapsuleButton() != null) {
            int width = (int) (r0.getWidth() / DisplayUtil.getDensity(this.mActivity.get()));
            int height = (int) (r0.getHeight() / DisplayUtil.getDensity(this.mActivity.get()));
            int left = (int) (r0.getLeft() / DisplayUtil.getDensity(this.mActivity.get()));
            int top = (int) (r0.getTop() / DisplayUtil.getDensity(this.mActivity.get()));
            int right = (int) (r0.getRight() / DisplayUtil.getDensity(this.mActivity.get()));
            int bottom = (int) (r0.getBottom() / DisplayUtil.getDensity(this.mActivity.get()));
            Rect rect = new Rect(267, 34, i.CTRL_INDEX, 64);
            if (width != 0) {
                rect = new Rect(left, top, right, bottom);
            } else {
                width = 80;
                height = 30;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("width", width);
                jSONObject.put("height", height);
                jSONObject.put("top", rect.top);
                jSONObject.put("right", rect.right);
                jSONObject.put("bottom", rect.bottom);
                jSONObject.put("left", rect.left);
                nativeViewRequestEvent.ok();
                QMLog.d(TAG, "getMenuButtonBoundingClientRect : " + jSONObject.toString());
                return jSONObject.toString();
            } catch (JSONException e16) {
                QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
                return "";
            }
        }
        QMLog.e(TAG, "EVENT_GET_MENU_BUTTON_RECT view is null.");
        nativeViewRequestEvent.fail();
        return getMenuButtonDefaultValue();
    }

    private String getMenuButtonDefaultValue() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", 80);
            jSONObject.put("height", 30);
            jSONObject.put("top", 34);
            jSONObject.put("right", i.CTRL_INDEX);
            jSONObject.put("bottom", 64);
            jSONObject.put("left", 267);
            QMLog.d(TAG, "getMenuButtonDefaultValue : " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e16) {
            QMLog.e(TAG, "getDefaultValue error.", e16);
            return "";
        }
    }

    private NativeViewContainer getNativeViewContainer() {
        PageWebviewContainer pageWebviewContainer = getPageWebviewContainer();
        if (pageWebviewContainer == null) {
            return null;
        }
        return pageWebviewContainer.getNativeViewContainer();
    }

    private ApkgManager.OnInitApkgListener getOnInitApkgListener(final String str, final String str2, final WeakReference<AppBrandPageContainer> weakReference) {
        return new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.6
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public void onInitApkgInfo(final int i3, final ApkgInfo apkgInfo, final String str3) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AppBrandPageContainer.this.mLoadingView != null) {
                            try {
                                AppBrandPageContainer.this.mLoadingView.hide();
                                AppBrandPageContainer.this.mLoadingView.onViewDestroy();
                                AppBrandPageContainer.this.mLoadingView = null;
                            } catch (Throwable th5) {
                                QMLog.e(AppBrandPageContainer.TAG, "", th5);
                            }
                        }
                        int i16 = i3;
                        if (i16 == 0) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            AppBrandPageContainer.this.handleInitApkgResultSuc(apkgInfo, str, weakReference, str2);
                            return;
                        }
                        if (i16 == 5) {
                            if (QMLog.isColorLevel()) {
                                QMLog.e(AppBrandPageContainer.TAG, "executeDownSubPackage url is empty." + str3);
                            }
                            AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                            AppBrandPageContainer.this.handleInitApkgResultSuc(apkgInfo, str, weakReference, str2);
                            return;
                        }
                        QMLog.e(AppBrandPageContainer.TAG, "executeDownSubPackage failed." + str3);
                    }
                });
            }
        };
    }

    private AppBrandPage getPageByWebviewId(int i3) {
        LinkedList<AppBrandPage> linkedList = this.appBrandPages;
        if (linkedList == null && linkedList.size() > 0) {
            for (int i16 = 0; i16 < this.appBrandPages.size(); i16++) {
                AppBrandPage appBrandPage = this.appBrandPages.get(i16);
                if (appBrandPage != null && appBrandPage.getPageWebviewId() == i3) {
                    return appBrandPage;
                }
            }
        }
        return null;
    }

    private PageWebviewContainer getPageWebviewContainer() {
        AppBrandPage showingPage = getShowingPage();
        if (showingPage == null) {
            return null;
        }
        return showingPage.getPageWebviewContainer();
    }

    private MiniReportManager.MiniAppLaunchState getState() {
        return MiniReportManager.getLaunchState(this.mContext.getMiniAppInfo().appId);
    }

    private void handleEventSetBackgroundColor(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppBrandPageContainer.this.setBackgroundColor(ColorUtils.parseColor(new JSONObject(nativeViewRequestEvent.jsonParams).optString("backgroundColor", "#FFFFFF")));
                    nativeViewRequestEvent.ok();
                } catch (Exception e16) {
                    nativeViewRequestEvent.fail();
                    QMLog.e(AppBrandPageContainer.TAG, nativeViewRequestEvent.event + " error.", e16);
                }
            }
        });
    }

    private void handleEventSetBackgroundTextStyle(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.9
            @Override // java.lang.Runnable
            public void run() {
                int i3 = -1;
                try {
                    if (!MiniAppConst.MENU_STYLE_LIGHT.equals(new JSONObject(nativeViewRequestEvent.jsonParams).optString("textStyle", MiniAppConst.MENU_STYLE_LIGHT))) {
                        i3 = -16777216;
                    }
                } catch (Exception e16) {
                    QMLog.e(AppBrandPageContainer.TAG, nativeViewRequestEvent.event + " error.", e16);
                }
                Iterator it = AppBrandPageContainer.this.appBrandPages.iterator();
                while (it.hasNext()) {
                    ((AppBrandPage) it.next()).notifyChangePullDownRefreshStyle(i3);
                }
                nativeViewRequestEvent.ok();
            }
        });
    }

    private void handleEventSetEnableDebug(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final boolean optBoolean = new JSONObject(nativeViewRequestEvent.jsonParams).optBoolean("enableDebug");
            if (optBoolean != DebugUtil.getDebugEnabled(this.mContext.getMiniAppInfo())) {
                this.mContext.getAttachActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogUtil.createCustomDialog(AppBrandPageContainer.this.mContext.getAttachActivity(), 230, "\u91cd\u542f\u540e\u751f\u6548", (String) null, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.7.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                DebugUtil.setDebugEnabled(AppBrandPageContainer.this.mContext.getMiniAppInfo().appId, optBoolean, true);
                                AppBrandPageContainer appBrandPageContainer = AppBrandPageContainer.this;
                                appBrandPageContainer.hideSoftInput(appBrandPageContainer);
                                ProcessUtil.exitProcess(AppBrandPageContainer.this.mContext);
                            }
                        }, (DialogInterface.OnClickListener) null).show();
                    }
                });
            } else {
                nativeViewRequestEvent.ok();
            }
        } catch (JSONException unused) {
            nativeViewRequestEvent.fail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInitApkgResultSuc(ApkgInfo apkgInfo, String str, WeakReference<AppBrandPageContainer> weakReference, String str2) {
        AppConfigInfo appConfigInfo;
        if (apkgInfo != null && apkgInfo.isUrlFileExist(str)) {
            AppBrandPageContainer appBrandPageContainer = weakReference.get();
            if (appBrandPageContainer != null) {
                if ("navigateTo".equals(str2)) {
                    appBrandPageContainer.navigateTo(str, -1);
                    return;
                }
                if ("redirectTo".equals(str2)) {
                    appBrandPageContainer.redirectTo(str, -1);
                    return;
                } else if (EventListener.APPLAUNCH.equals(str2)) {
                    appBrandPageContainer.launch(str, EventListener.APPLAUNCH);
                    return;
                } else {
                    if ("reLaunch".equals(str2)) {
                        appBrandPageContainer.launch(str, "reLaunch");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        sendPageNotFoundEvent(str);
        if (apkgInfo != null && (appConfigInfo = apkgInfo.mAppConfigInfo) != null) {
            String str3 = appConfigInfo.entryPagePath;
            if (isUrlFileExist(apkgInfo, str3)) {
                weakReference.get().launch(str3, EventListener.APPLAUNCH);
            } else if (isActivityValid()) {
                this.mContext.getAttachActivity().moveTaskToBack(false);
            }
        }
    }

    private void handleOnTabItemTap(int i3, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("index", i3);
            jSONObject.put("pagePath", str);
            jSONObject.put("text", str2);
            this.mContext.performAction(ServiceSubscribeEvent.obtain("onTabItemTap", jSONObject.toString(), getShowingPageWebViewId()));
        } catch (Throwable th5) {
            QMLog.e(TAG, "onTabItemClick error,", th5);
        }
    }

    private String handlePageEvent(NativeViewRequestEvent nativeViewRequestEvent) {
        if ("setEnableDebug".equals(nativeViewRequestEvent.event)) {
            handleEventSetEnableDebug(nativeViewRequestEvent);
            return null;
        }
        if ("setBackgroundTextStyle".equals(nativeViewRequestEvent.event)) {
            handleEventSetBackgroundTextStyle(nativeViewRequestEvent);
            return null;
        }
        if ("setBackgroundColor".equals(nativeViewRequestEvent.event)) {
            handleEventSetBackgroundColor(nativeViewRequestEvent);
            return null;
        }
        if ("getMenuButtonBoundingClientRect".equals(nativeViewRequestEvent.event)) {
            return getMenuButtonBoundingClientRect(nativeViewRequestEvent);
        }
        if ("reportKeyValue".equals(nativeViewRequestEvent.event)) {
            reportKeyValue(nativeViewRequestEvent);
            return null;
        }
        return null;
    }

    private void initMonitor() {
        if (this.mActivity.get() == null) {
            QMLog.e(TAG, "initMonitor mActivity == null");
            return;
        }
        this.mBroadcastReceiver = new MonitorBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MiniAppMonitorInfoView.ACTION_SHOW_MONITOR_VIEW);
        this.mActivity.get().registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    private void initNetwork() {
        ApkgBaseInfo apkgBaseInfo;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && (apkgBaseInfo = miniAppInfo.apkgInfo) != null && (apkgBaseInfo instanceof ApkgInfo)) {
            ApkgInfo.initNetwork((ApkgInfo) apkgBaseInfo);
        }
    }

    private boolean isActivityValid() {
        IMiniAppContext iMiniAppContext = this.mContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !this.mContext.getAttachActivity().isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean isIndexHtmlValid(String str) {
        File apkgFile;
        String readApkgToString;
        String readApkgToString2;
        boolean z16;
        boolean z17 = this.mMiniAppInfo.launchParam.isFlutterMode;
        if (this.mApkgInfo == null) {
            return true;
        }
        try {
            str = AppBrandUtil.getUrlWithoutParams(str);
            if (z17) {
                readApkgToString2 = FileUtils.readFileToStr(new File(this.mApkgInfo.getChildFileAbsolutePath(str)));
            } else {
                readApkgToString2 = this.mApkgInfo.readApkgToString(str);
            }
            if (TextUtils.isEmpty(readApkgToString2)) {
                return true;
            }
            if (readApkgToString2.indexOf("<script>") >= 0 && readApkgToString2.indexOf("</script>") >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            if (!TextUtils.isEmpty(readApkgToString2) && !FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                QMLog.e(TAG, "url file cache invalid! content: " + readApkgToString2);
            }
            return false;
        } catch (Throwable th5) {
            try {
                String urlWithoutParams = AppBrandUtil.getUrlWithoutParams(str);
                if (z17) {
                    apkgFile = new File(this.mApkgInfo.getChildFileAbsolutePath(urlWithoutParams));
                } else {
                    apkgFile = this.mApkgInfo.getApkgFile(urlWithoutParams);
                }
                if (z17) {
                    readApkgToString = FileUtils.readFileToStr(apkgFile);
                } else {
                    readApkgToString = this.mApkgInfo.readApkgToString(urlWithoutParams);
                }
                QMLog.e(TAG, "isUrlLocalFileValid exception! url= " + urlWithoutParams + " filePath=" + apkgFile.getAbsolutePath() + " htmlContent=" + readApkgToString, th5);
            } catch (Throwable th6) {
                QMLog.e(TAG, "", th6);
            }
            return false;
        }
    }

    private boolean isMainPackageUrl(String str) {
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo != null) {
            return TextUtils.isEmpty(apkgInfo.getRootPath(str));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMonitorViewShowing() {
        MiniAppMonitorInfoView miniAppMonitorInfoView = this.mMiniAppMonitorInfoView;
        if (miniAppMonitorInfoView != null && miniAppMonitorInfoView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean isSubFileCacheValid(String str, String str2) {
        String readApkgToString;
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo == null) {
            return true;
        }
        try {
            String rootPath = apkgInfo.getRootPath(str);
            if (TextUtils.isEmpty(rootPath)) {
                return true;
            }
            String absolutePath = new File(com.tencent.qqmini.sdk.launcher.core.model.ApkgManager.getApkgFolderPath(this.mMiniAppInfo), rootPath).getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return true;
            }
            if (this.mMiniAppInfo.launchParam.isFlutterMode) {
                readApkgToString = FileUtils.readFileToStr(new File(absolutePath + File.separator + str2));
            } else {
                readApkgToString = this.mApkgInfo.readApkgToString(str);
            }
            if (TextUtils.isEmpty(readApkgToString) || !readApkgToString.contains(new String(new byte[20]))) {
                return true;
            }
            QMLog.e(TAG, str2 + " file invalid! ");
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
            return false;
        }
    }

    private boolean isUrlFileExist(ApkgInfo apkgInfo, String str) {
        if (!TextUtils.isEmpty(str) && apkgInfo.isUrlFileExist(str)) {
            return true;
        }
        return false;
    }

    private boolean isUrlLocalFileValid(String str) {
        if (isIndexHtmlValid(str) && isSubFileCacheValid(str, "app-service.js") && isSubFileCacheValid(str, "page-frame.js")) {
            return true;
        }
        return false;
    }

    private boolean isUrlReady(String str) {
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo == null || !apkgInfo.isUrlResReady(str, this.mContext.getMiniAppInfo()) || !this.mApkgInfo.isUrlFileExist(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSoftKeyClosed() {
        List<SoftKeyboardStateHelper.SoftKeyboardStateListener> list = this.mSoftKeyboardStateListenerList;
        if (list != null && list.size() > 0) {
            for (SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener : this.mSoftKeyboardStateListenerList) {
                if (softKeyboardStateListener != null) {
                    softKeyboardStateListener.onSoftKeyboardClosed();
                }
            }
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("height", 0);
                    jSONObject.put("inputId", AppBrandPageContainer.this.getCurShowingInputId());
                    EventListener eventListener = AppBrandPageContainer.this.mEventListener;
                    if (eventListener != null) {
                        eventListener.onWebViewEvent("onKeyboardHeightChange", jSONObject.toString(), AppBrandPageContainer.this.getShowingPageWebViewId());
                    }
                } catch (Throwable th5) {
                    QMLog.e(AppBrandPageContainer.TAG, "KeyboardObserver error, ", th5);
                }
                AppBrandPageContainer.this.resetCurShowingInputId();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSoftKeyOpened(final int i3) {
        Activity activity;
        IMiniAppContext iMiniAppContext = this.mContext;
        if (iMiniAppContext != null) {
            activity = iMiniAppContext.getAttachActivity();
        } else {
            activity = null;
        }
        if (activity != null && DisplayUtil.hasNavBar(activity) && DisplayUtil.isNavigationBarExist(activity)) {
            i3 -= DisplayUtil.getNavigationBarHeight(activity);
        }
        List<SoftKeyboardStateHelper.SoftKeyboardStateListener> list = this.mSoftKeyboardStateListenerList;
        if (list != null && list.size() > 0) {
            for (SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener : this.mSoftKeyboardStateListenerList) {
                if (softKeyboardStateListener != null) {
                    softKeyboardStateListener.onSoftKeyboardOpened(i3);
                }
            }
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("height", (int) (i3 / DisplayUtil.getDensity(AppBrandPageContainer.this.mContext.getContext())));
                    jSONObject.put("inputId", AppBrandPageContainer.this.getCurShowingInputId());
                    if (AppBrandPageContainer.this.mEventListener != null) {
                        QMLog.d(AppBrandPageContainer.TAG, "onKeyboardHeightChange : " + jSONObject.toString());
                        AppBrandPageContainer.this.mEventListener.onWebViewEvent("onKeyboardHeightChange", jSONObject.toString(), AppBrandPageContainer.this.getShowingPageWebViewId());
                    }
                } catch (Throwable th5) {
                    QMLog.e(AppBrandPageContainer.TAG, "KeyboardObserver error, ", th5);
                }
            }
        }, 50L);
    }

    private void recordEndSwitchTime(int i3) {
        MiniReportManager.MiniAppLaunchState state = getState();
        if (state != null) {
            state.eventTime.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void recordSwitchTime() {
        MiniReportManager.MiniAppLaunchState state = getState();
        if (state != null) {
            state.eventTime.put(44, Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void reportEventDisplay(NativeViewRequestEvent nativeViewRequestEvent, MiniAppInfo miniAppInfo, JSONObject jSONObject) throws JSONException {
        int parseInt;
        String[] split = jSONObject.getString("value").split(",");
        if (split.length > 8 && !split[0].equals("2") && (parseInt = Integer.parseInt(split[7])) > 0) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " REPORT_EVENT_DISPLAY: " + parseInt);
            MiniReportManager.reportEventType(miniAppInfo, 638, null, null, null, 0, "0", (long) parseInt, null);
        }
    }

    private void reportEventSpeed(NativeViewRequestEvent nativeViewRequestEvent, MiniAppInfo miniAppInfo, JSONObject jSONObject) throws JSONException {
        String[] split = jSONObject.getString("value").split(",");
        int parseInt = Integer.parseInt(split[0]);
        if (9 == parseInt || 6 == parseInt) {
            long parseLong = Long.parseLong(split[4]) - Long.parseLong(split[1]);
            if (parseLong > 0) {
                QMLog.e(TAG, nativeViewRequestEvent.event + " REPORT_EVENT_SPEED: " + parseLong);
                if (9 == parseInt) {
                    MiniReportManager.reportEventType(miniAppInfo, 636, null, null, null, 0, "0", parseLong, null);
                } else {
                    MiniReportManager.reportEventType(miniAppInfo, 637, null, null, null, 0, "0", parseLong, null);
                }
            }
        }
    }

    private void reportKeyValue(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            MiniAppInfo miniAppInfo = this.mContext.getMiniAppInfo();
            JSONArray jSONArray = new JSONObject(nativeViewRequestEvent.jsonParams).getJSONArray("dataArray");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                int i16 = jSONObject.getInt("key");
                if (15496 == i16) {
                    reportEventDisplay(nativeViewRequestEvent, miniAppInfo, jSONObject);
                } else if (13544 == i16) {
                    reportEventSpeed(nativeViewRequestEvent, miniAppInfo, jSONObject);
                } else if (13582 == i16) {
                    try {
                        MiniReportManager.reportJsError(miniAppInfo, getCurrentPageUrl(), jSONObject.getString("value"));
                    } catch (Exception e16) {
                        QMLog.e(TAG, nativeViewRequestEvent.event + " REPORT_EVENT_JS_EXCEPTION: failed:", e16);
                    }
                }
            }
        } catch (Exception e17) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e17);
        }
    }

    private void sendBackGroundToJs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", this.mMiniAppInfo.launchParam.scene);
            jSONObject.put("appId", this.mContext.getMiniAppInfo().appId);
        } catch (JSONException e16) {
            e16.printStackTrace();
            QMLog.w(TAG, "onPause,paramsObj", e16);
        }
        EventListener eventListener = this.mEventListener;
        if (eventListener != null) {
            eventListener.onWebViewEvent("onAppEnterBackground", jSONObject.toString(), 0);
        }
    }

    private void sendForegroundToJs() {
        String str;
        boolean z16;
        EventListener eventListener;
        if (this.mFromReload && (eventListener = this.mEventListener) != null && eventListener.isFirstDomReady() && !TextUtils.isEmpty(this.mMiniAppInfo.launchParam.entryPath)) {
            str = this.mMiniAppInfo.launchParam.entryPath;
            this.mFromReload = false;
            z16 = true;
        } else {
            str = null;
            z16 = false;
        }
        boolean booleanValue = ((Boolean) this.mContext.performAction(new Action<Boolean>() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public Boolean perform(BaseRuntime baseRuntime) {
                BaseAppBrandRuntime baseAppBrandRuntime = baseRuntime instanceof BaseAppBrandRuntime ? (BaseAppBrandRuntime) baseRuntime : null;
                return Boolean.valueOf((baseAppBrandRuntime == null || baseAppBrandRuntime.getAppStateManager() == null || !baseAppBrandRuntime.getAppStateManager().isFromPrelaunch) ? false : true);
            }
        })).booleanValue();
        EventListener eventListener2 = this.mEventListener;
        if (eventListener2 != null) {
            if (eventListener2.isFirstDomReady() || booleanValue) {
                if (TextUtils.isEmpty(str) && getShowingPage() != null) {
                    str = getShowingPage().getCurShowingUrl();
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject appLaunchInfo = AppBrandUtil.getAppLaunchInfo(str, this.mMiniAppInfo);
                    try {
                        appLaunchInfo.put("reLaunch", z16);
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "appLaunchInfo error.", th5);
                    }
                    QMLog.i(TAG, "appLaunchInfo : " + appLaunchInfo.toString());
                    this.mEventListener.onWebViewEvent("onAppEnterForeground", appLaunchInfo.toString(), 0);
                }
                initNetwork();
            }
        }
    }

    private void sendPageNotFoundEvent(String str) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str);
            jSONObject.put("query", AppBrandUtil.getQueryJson(str));
            LinkedList<AppBrandPage> linkedList = this.appBrandPages;
            if (linkedList != null && linkedList.size() > 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            jSONObject.put("isEntryPage", z16);
            this.mContext.performAction(ServiceSubscribeEvent.obtain("onPageNotFound", jSONObject.toString(), 0));
        } catch (JSONException e16) {
            QMLog.e(TAG, "onPageNotFound error", e16);
        }
    }

    public boolean addCoverView(int i3, int i16, CoverView coverView, boolean z16) {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            return nativeViewContainer.addCoverView(i3, i16, coverView, z16);
        }
        return false;
    }

    public boolean addNativeView(View view, ViewGroup.LayoutParams layoutParams) {
        NativeViewContainer nativeViewContainer;
        if (view == null || (nativeViewContainer = getNativeViewContainer()) == null) {
            return false;
        }
        if (layoutParams != null) {
            nativeViewContainer.addView(view, layoutParams);
            return true;
        }
        nativeViewContainer.addView(view);
        return true;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void cleanup(boolean z16) {
        ApkgInfo apkgInfo;
        Iterator<AppBrandPage> it = this.appBrandPages.iterator();
        while (it.hasNext()) {
            AppBrandPage next = it.next();
            if (next != null && (!z16 || (apkgInfo = this.mApkgInfo) == null || !apkgInfo.isTabBarPage(next.getCurShowingUrl()))) {
                next.onPause();
                try {
                    next.cleanUp();
                    removeView(next);
                    it.remove();
                } catch (Throwable th5) {
                    QMLog.e(TAG, "cleanup error." + th5.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent) {
        if (nativeViewRequestEvent.dispatchTarget == 3) {
            return handlePageEvent(nativeViewRequestEvent);
        }
        AppBrandPage showingPage = getShowingPage();
        if (showingPage == null) {
            return null;
        }
        if (nativeViewRequestEvent.dispatchTarget == 0) {
            return showingPage.handleNativeUIEvent(nativeViewRequestEvent);
        }
        PageWebviewContainer pageWebviewContainer = showingPage.getPageWebviewContainer();
        if (pageWebviewContainer == null) {
            return null;
        }
        if (nativeViewRequestEvent.dispatchTarget == 1) {
            return pageWebviewContainer.handleNativeUIEvent(nativeViewRequestEvent);
        }
        NativeViewContainer nativeViewContainer = pageWebviewContainer.getNativeViewContainer();
        if (nativeViewContainer == null || nativeViewRequestEvent.dispatchTarget != 2) {
            return null;
        }
        return nativeViewContainer.handleNativeUIEvent(nativeViewRequestEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void dispatchEventToWebView(String str, String str2, int[] iArr) {
        BrandPageWebview brandPageWebviewById;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                Iterator it = new LinkedList(this.appBrandPages).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppBrandPage appBrandPage = (AppBrandPage) it.next();
                    if (appBrandPage != null && (brandPageWebviewById = appBrandPage.getBrandPageWebviewById(i3)) != null) {
                        brandPageWebviewById.evaluateSubscribeJSInService(str, str2, i3);
                        break;
                    }
                }
            }
            return;
        }
        for (AppBrandPage appBrandPage2 : new LinkedList(this.appBrandPages)) {
            if (appBrandPage2 != null && appBrandPage2.getBrandPageWebview() != null) {
                appBrandPage2.getBrandPageWebview().evaluateSubscribeJSInService(str, str2, appBrandPage2.getPageWebviewId());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float density = ViewUtils.getDensity();
        try {
            int x16 = (int) (motionEvent.getX() / density);
            int y16 = (int) (motionEvent.getY() / density);
            if (motionEvent.getAction() == 0) {
                this.lastTouchDownX = x16;
                this.lastTouchDownY = y16;
                this.lastTouchDownTimeStamp = System.currentTimeMillis();
            } else if (motionEvent.getAction() == 1) {
                this.lastTouchUpX = x16;
                this.lastTouchUpY = y16;
                if (this.lastClickList.size() > 10) {
                    this.lastClickList.poll();
                }
                QMLog.d(TAG, "wesley size: " + this.lastClickList.size() + " x:" + this.lastTouchDownX + " y:" + this.lastTouchDownY);
                this.lastClickList.add(new ClickPoint(this.lastTouchDownX, this.lastTouchDownY, this.lastTouchUpX, this.lastTouchUpY, this.lastTouchDownTimeStamp));
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "dispatchTouchEvent failed,", e16);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        try {
            getShowingPage().getBrandPageWebview().doDispatchKeyEvent(keyEvent);
            return false;
        } catch (Throwable th5) {
            QMLog.e(TAG, "doDispatchKeyEvent error,", th5);
            return false;
        }
    }

    public AppBrandPagePool getAppBrandPagePool() {
        return this.mAppBrandPagePool;
    }

    public CoverView getCoverView(int i3) {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            return nativeViewContainer.getCoverView(i3);
        }
        return null;
    }

    public int getCurShowingInputId() {
        return this.curShowingInputId;
    }

    public String getCurrentPageUrl() {
        if (getShowingPage() != null) {
            return getShowingPage().getCurShowingUrl();
        }
        return "";
    }

    public EmbeddedWidgetClientFactory getCurrentX5EmbeddedWidgetClientFactory() {
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null && peek.getCurrentPageWebview() != null) {
            return peek.getCurrentPageWebview().getEmbeddedWidgetClientFactory();
        }
        return null;
    }

    public EntryModel getEntryModel() {
        return this.mEntryModel;
    }

    public CoverView.JsRuntimeListener getJsRuntimeListener() {
        return getPageWebviewContainer();
    }

    public String getLastClicks() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        Iterator<ClickPoint> it = this.lastClickList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ClickPoint next = it.next();
            if (i3 > 0) {
                sb5.append(",");
            }
            sb5.append("[");
            sb5.append(next.downX);
            sb5.append(",");
            sb5.append(next.downY);
            sb5.append(",");
            sb5.append(next.upX);
            sb5.append(",");
            sb5.append(next.upY);
            sb5.append(",");
            sb5.append(next.clickTimeMills);
            sb5.append("]");
            i3++;
        }
        sb5.append("]");
        return sb5.toString();
    }

    public String getNaviBarStyle() {
        NavigationBar navBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek == null || (navBar = peek.getNavBar()) == null) {
            return "default";
        }
        return navBar.getNavbarStyle();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarTextStyle() {
        NavigationBar navBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek == null || (navBar = peek.getNavBar()) == null) {
            return -1;
        }
        return navBar.getStatusNavigationBarTextStyle();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarVisibility() {
        NavigationBar navBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek == null || (navBar = peek.getNavBar()) == null) {
            return 8;
        }
        return navBar.getVisibility();
    }

    public int getPageCount() {
        LinkedList<AppBrandPage> linkedList = this.appBrandPages;
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public AppPageInfo getPageInfo(int i3) {
        PageWebviewContainer pageWebviewContainer;
        PageWebviewContainer pageWebviewContainer2;
        String str;
        AppPageInfo.Builder builder = new AppPageInfo.Builder();
        AppBrandPage peek = this.appBrandPages.peek();
        if (AppPageInfo.enableGetPageId(i3) && peek != null && peek.getCurrentPageWebview() != null) {
            builder.setPageId(peek.getCurrentPageWebview().getPageWebViewId());
        }
        if (AppPageInfo.enableGetPageUrl(i3)) {
            if (peek != null) {
                str = peek.getCurShowingUrl();
            } else {
                str = null;
            }
            builder.setPageUrl(str);
        }
        if (AppPageInfo.enableGetWebViewUrl(i3) && peek != null && peek.getRootContainer() != null && peek.getRootContainer().getNativeViewContainer() != null) {
            builder.setWebViewUrl(peek.getRootContainer().getNativeViewContainer().getInnerWebViewUrl());
        }
        if (AppPageInfo.enableGetPageWindowWidth(i3) && (pageWebviewContainer2 = getPageWebviewContainer()) != null) {
            builder.setWindowWidth(pageWebviewContainer2.getWidth());
        }
        if (AppPageInfo.enableGetPageWindowHeight(i3) && (pageWebviewContainer = getPageWebviewContainer()) != null) {
            builder.setWindowHeight(pageWebviewContainer.getHeight());
        }
        return builder.build();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public String getPageOrientation() {
        PageWebviewContainer pageWebviewContainer = getPageWebviewContainer();
        if (pageWebviewContainer != null) {
            return pageWebviewContainer.getPageOrientation();
        }
        return "";
    }

    public String getReferPageUrl() {
        AppBrandPage next;
        QMLog.i(TAG, "getReferPageUrl ");
        if (getPageCount() < 2) {
            return "";
        }
        Iterator<AppBrandPage> it = this.appBrandPages.iterator();
        if (it.hasNext()) {
            it.next();
            if (it.hasNext() && (next = it.next()) != null) {
                return next.getCurShowingUrl();
            }
        }
        return "";
    }

    public AppBrandPage getShowingPage() {
        if (getPageCount() > 0) {
            return this.appBrandPages.peek();
        }
        return null;
    }

    public int getShowingPageWebViewId() {
        LinkedList<AppBrandPage> linkedList = this.appBrandPages;
        if (linkedList != null && linkedList.peek() != null) {
            return this.appBrandPages.peek().getPageWebviewId();
        }
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getTabBarVisibility() {
        TabBar tabBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek == null || (tabBar = peek.getTabBar()) == null) {
            return 8;
        }
        return tabBar.getVisibility();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean hideLoading() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void hideSoftInput(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // com.tencent.qqmini.sdk.core.Preloadable
    public void init(Object obj) {
        AppBrandPagePool appBrandPagePool = this.mAppBrandPagePool;
        if (appBrandPagePool != null) {
            appBrandPagePool.preLoadAppBrandPage(this.mContext, this);
        }
    }

    public void initBaseJs(BaselibLoader.BaselibContent baselibContent) {
        AppBrandPagePool appBrandPagePool = this.mAppBrandPagePool;
        if (appBrandPagePool != null) {
            appBrandPagePool.initBaseJs(this, baselibContent);
        }
    }

    public boolean isCurrentTabBarPage() {
        AppBrandPage showingPage = getShowingPage();
        if (showingPage != null) {
            return showingPage.isTabBarPage();
        }
        return false;
    }

    public boolean isHomePageInStackBottom() {
        if (getPageCount() <= 0) {
            return false;
        }
        AppBrandPage appBrandPage = this.appBrandPages.get(getPageCount() - 1);
        if (!appBrandPage.isHomePage() && !appBrandPage.isTabPage()) {
            return false;
        }
        return true;
    }

    public boolean isPageInStackBottom(AppBrandPage appBrandPage) {
        if (getPageCount() <= 0 || this.appBrandPages.get(getPageCount() - 1).getPageWebviewId() != appBrandPage.getPageWebviewId()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void launch(String str, String str2) {
        boolean z16;
        if (isUrlReady(str) && isUrlLocalFileValid(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && isMainPackageUrl(str)) {
            executeDownMainPackage(str2);
            return;
        }
        if (z16) {
            executeDownSubPackage(str, str2);
            return;
        }
        AppBrandPage appBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
        this.appBrandPages.push(appBrandPage);
        appBrandPage.loadUrl(str, str2, this.mEventListener);
        addView(appBrandPage, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public boolean navigateBack(int i3, int i16) {
        final AppBrandPage next;
        QMLog.i(TAG, "navigateBack delta : " + i3);
        AppBrandPage showingPage = getShowingPage();
        if (i16 == -1 && showingPage != null && showingPage.handleBackPressed()) {
            return true;
        }
        int pageCount = getPageCount();
        if (pageCount < 2 || i3 < 1) {
            return false;
        }
        if (i3 >= pageCount) {
            i3 = pageCount - 1;
        }
        Iterator<AppBrandPage> it = this.appBrandPages.iterator();
        for (int i17 = 0; i17 < i3 && this.appBrandPages.size() >= 1; i17++) {
            if (it.hasNext() && (next = it.next()) != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getContext(), R.anim.mini_sdk_page_slide_out_to_right);
                loadAnimation.setDuration(200L);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        next.setVisibility(8);
                        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    next.cleanUp();
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    AppBrandPageContainer.this.removeView(next);
                                } catch (Throwable th5) {
                                    QMLog.e(AppBrandPageContainer.TAG, " cleanUp e = " + th5.getMessage(), th5);
                                }
                            }
                        }, 50L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                next.startAnimation(loadAnimation);
                next.onPause();
                it.remove();
            }
        }
        hideSoftInput(this);
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null) {
            peek.onResume();
            if (isActivityValid()) {
                peek.updateNavigationByWindowInfo(this.mContext.getAttachActivity());
                peek.refreshOrientation();
            }
            this.mEventListener.onWebViewReady("navigateBack", peek.getCurShowingUrl(), peek.getPageWebviewId());
        }
        return true;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void navigateTo(String str, int i3) {
        QMLog.i(TAG, "navigateTo url : " + str);
        if (this.aliveWebViewCount > 10) {
            MiniToast.makeText(getContext(), "\u6253\u5f00\u9875\u9762\u8d85\u8fc7\u4e0a\u9650\uff0c\u8bf7\u8fd4\u56de", 0).show();
            QMLog.e(TAG, "\u6253\u5f00WebView\u6570\u91cf\u8d85\u8fc7\u4e0a\u9650");
            return;
        }
        if (isUrlReady(str) && isUrlLocalFileValid(str)) {
            AppBrandPage peek = this.appBrandPages.peek();
            if (peek != null) {
                peek.onPause();
            }
            AppBrandPage appBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
            this.appBrandPages.push(appBrandPage);
            appBrandPage.loadUrl(str, "navigateTo", this.mEventListener);
            if (!appBrandPage.isHomePage()) {
                appBrandPage.setVisibility(4);
            }
            addView(appBrandPage, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        executeDownSubPackage(str, "navigateTo");
    }

    public void notifyOnAddColorNote() {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            nativeViewContainer.notifyOnColorNoteAnimStart();
        }
    }

    public void notifyOnPageWebViewDestory() {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            nativeViewContainer.notifyOnPageWebViewDestory();
        }
    }

    public void notifyOnPageWebViewPause(int i3) {
        NativeViewContainer nativeViewContainer;
        AppBrandPage pageByWebviewId = getPageByWebviewId(i3);
        if (pageByWebviewId != null && pageByWebviewId.getPageWebviewContainer() != null) {
            nativeViewContainer = pageByWebviewId.getPageWebviewContainer().getNativeViewContainer();
        } else {
            nativeViewContainer = null;
        }
        if (nativeViewContainer != null) {
            nativeViewContainer.notifyOnPageWebViewPause();
        }
    }

    public void notifyOnPageWebViewResume() {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            nativeViewContainer.notifyOnPageWebViewResume();
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void onAttachedToActivity(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
        initMonitor();
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null) {
            peek.updateNavigationByWindowInfo(activity);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void onDestroy() {
        AppBrandPagePool appBrandPagePool = this.mAppBrandPagePool;
        if (appBrandPagePool != null) {
            appBrandPagePool.destroyCachePage();
            this.mAppBrandPagePool = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mBroadcastReceiver != null && this.mActivity.get() != null) {
            this.mActivity.get().unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public void onNewPageCompleted() {
        while (!this.redirectOldPages.isEmpty()) {
            AppBrandPage poll = this.redirectOldPages.poll();
            if (poll != null) {
                poll.onPause();
                poll.cleanUp();
                removeView(poll);
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void onPause() {
        if (this.mMiniAppInfo == null) {
            return;
        }
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null) {
            peek.onPause();
        }
        sendBackGroundToJs();
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void onResume() {
        sendForegroundToJs();
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null) {
            peek.onResume();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.TabBar.OnTabItemClickListener
    public void onTabItemClick(int i3, String str, String str2) {
        recordSwitchTime();
        switchTab(str);
        handleOnTabItemTap(i3, str, str2);
        recordEndSwitchTime(33);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateCustomButton(String str, long j3, JSONObject jSONObject, View.OnClickListener onClickListener) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateFloatDragAd(String str, FloatDragAdInfo floatDragAdInfo) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operatePendantAd(String str, PendantAdInfo pendantAdInfo) {
        return false;
    }

    public void recyclePreLoadAppBrandPage() {
        AppBrandPagePool appBrandPagePool = this.mAppBrandPagePool;
        if (appBrandPagePool != null) {
            appBrandPagePool.destroyPageWebviewCache();
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void redirectTo(String str, int i3) {
        QMLog.i(TAG, "redirectTo url : " + str);
        if (isUrlReady(str) && isUrlLocalFileValid(str)) {
            LinkedList<AppBrandPage> linkedList = this.appBrandPages;
            if (linkedList != null && linkedList.size() > 0) {
                this.redirectOldPages.add(this.appBrandPages.poll());
            }
            AppBrandPage appBrandPage = this.mAppBrandPagePool.getAppBrandPage(this.mContext, this);
            LinkedList<AppBrandPage> linkedList2 = this.appBrandPages;
            if (linkedList2 != null) {
                linkedList2.push(appBrandPage);
            }
            appBrandPage.loadUrl(str, "redirectTo", this.mEventListener);
            if (!appBrandPage.isHomePage()) {
                appBrandPage.setVisibility(4);
            }
            addView(appBrandPage, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        executeDownSubPackage(str, "redirectTo");
    }

    public boolean removeCoverView(int i3) {
        NativeViewContainer nativeViewContainer = getNativeViewContainer();
        if (nativeViewContainer != null) {
            return nativeViewContainer.removeCoverView(i3);
        }
        return false;
    }

    public boolean removeNativeView(View view) {
        NativeViewContainer nativeViewContainer;
        if (view == null || (nativeViewContainer = getNativeViewContainer()) == null) {
            return false;
        }
        nativeViewContainer.removeView(view);
        return true;
    }

    public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        List<SoftKeyboardStateHelper.SoftKeyboardStateListener> list;
        if (softKeyboardStateListener != null && (list = this.mSoftKeyboardStateListenerList) != null) {
            list.remove(softKeyboardStateListener);
        }
    }

    public void resetCurShowingInputId() {
        this.curShowingInputId = -1;
    }

    public void setCurShowingInputId(int i3) {
        this.curShowingInputId = i3;
    }

    public void setEntryMode(EntryModel entryModel) {
        this.mEntryModel = entryModel;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void setFromReload(boolean z16) {
        this.mFromReload = z16;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean setMiniAIOEntranceVisible(boolean z16, JSONObject jSONObject) {
        AppBrandPage showingPage = getShowingPage();
        if (showingPage == null) {
            return false;
        }
        if (z16) {
            return showingPage.showMiniAIOEntrance(jSONObject);
        }
        showingPage.hideMiniAIOEntrance();
        return true;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
        this.mApkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
    }

    public void setNaviBarStyle(String str) {
        NavigationBar navBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null && (navBar = peek.getNavBar()) != null) {
            navBar.setBarStyle(str);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setNaviVisibility(int i3) {
        NavigationBar navBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null && (navBar = peek.getNavBar()) != null) {
            navBar.setVisibility(i3);
        }
    }

    public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        if (softKeyboardStateListener == null) {
            return;
        }
        if (this.mSoftKeyboardStateListenerList == null) {
            this.mSoftKeyboardStateListenerList = new ArrayList();
        }
        this.mSoftKeyboardStateListenerList.add(softKeyboardStateListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setTabBarVisibility(int i3) {
        TabBar tabBar;
        AppBrandPage peek = this.appBrandPages.peek();
        if (peek != null && (tabBar = peek.getTabBar()) != null) {
            tabBar.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean showLoading() {
        return false;
    }

    public void showSoftInput(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void switchTab(String str) {
        QMLog.i(TAG, "switchTab url : " + str);
        cleanup(true);
        AppBrandPage brandPage = getBrandPage();
        this.appBrandPages.push(brandPage);
        brandPage.loadUrl(str, "switchTab", this.mEventListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean toggleDebugPanel() {
        MiniAppInfo miniAppInfo;
        IMiniAppContext iMiniAppContext = this.mContext;
        if (iMiniAppContext != null) {
            miniAppInfo = iMiniAppContext.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        boolean z16 = !DebugUtil.getDebugEnabled(miniAppInfo);
        DebugUtil.setDebugEnabled(miniAppInfo, z16);
        return z16;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean toggleMonitorPanel() {
        Activity attachActivity = this.mContext.getAttachActivity();
        if (attachActivity != null) {
            MiniAppMonitorInfoView miniAppMonitorInfoView = this.mMiniAppMonitorInfoView;
            if (miniAppMonitorInfoView == null) {
                this.mMiniAppMonitorInfoView = new MiniAppMonitorInfoView(attachActivity, null, 0);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 53;
                attachActivity.addContentView(this.mMiniAppMonitorInfoView, layoutParams);
                this.mMiniAppMonitorInfoView.setVisibility(0);
                this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
            } else if (miniAppMonitorInfoView.getVisibility() == 0) {
                this.mMiniAppMonitorInfoView.stopRefreshMonitorUi();
                this.mMiniAppMonitorInfoView.setVisibility(8);
            } else {
                this.mMiniAppMonitorInfoView.startRefreshMonitorUi();
                this.mMiniAppMonitorInfoView.setVisibility(0);
            }
        }
        return isMonitorViewShowing();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public CapsuleButton getCapsuleButton() {
        AppBrandPage showingPage = getShowingPage();
        if (showingPage != null) {
            return showingPage.getCapsuleButton();
        }
        return null;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public View getContentView() {
        return this;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer
    public void onStop() {
    }
}
