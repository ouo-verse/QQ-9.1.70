package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelStore;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.app.QZoneAppInterface;
import com.qzone.app.ResourcePreloader;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.banner.FootBanner;
import com.qzone.misc.web.QZoneTranslucentActivity;
import com.qzone.report.QZonePerfReporter;
import com.qzone.util.CreditLevelMonitor;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.widget.QZoneCustomToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.WatchActivityManager;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.ProcessUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.AndroidOUIWrapperUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class BaseActivity extends QBaseActivity implements SkinnableActivityProcesser.Callback, PerfTracer.PerfTimeReport, QZoneServiceCallback, ap.a, com.tencent.mobileqq.colornote.f {
    private static final int MENU_ID_MORE = 22;
    private static final int MENU_ID_SERVER = 1;
    public static final int MSG_CREDITLEVEL = -88;
    public static final int MSG_DELAY_REFRESH = 87;
    private static final int MSG_NET_STATE_CHANGED = 86;
    private static final int MSG_REFRESH = 0;
    private static final String NIGHT_MASK_COLOR = "#77000000";
    protected static final int NO_BACKGROUND = -1;
    protected static final int WHAT_NOT_NET = 100001;
    private static boolean hasNet = false;
    private static boolean isStartActivity = false;
    private static BaseActivity topActivity;
    public boolean isMoveToBG;
    protected IColorNoteController mColorNoteController;
    protected FootBanner mFootBanner;
    protected MiniMsgUser mMiniMsgUser;
    protected int mStatusBarHeight;
    protected long mUIThreadID;
    private ViewModelStore mViewModelStore;
    private View mViewNightMask;
    protected boolean netStateCallback;
    private NetworkState.NetworkStateListener netStateListener;
    private SkinnableActivityProcesser processer;
    protected String skinid;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static int lastOrientation = -1;
    private WatchActivityManager watchActivityManager = new WatchActivityManager();
    private int titleBottom = 0;
    private long lastNolinkToastShowTime = 0;
    private final long NO_LINK_TOAST_SHOW_INTERVAL = 2000;
    public String simpleClassname = getClass().getSimpleName();
    ShakeScreenShotLogic screenShotLogic = new ShakeScreenShotLogic();
    public boolean isTopExceptInputPanel = false;
    protected volatile boolean mReplace = false;
    private b contextMenuClosedListener = null;
    private Runnable checkCreditLevel = new Runnable() { // from class: com.qzone.common.activities.base.d
        @Override // java.lang.Runnable
        public final void run() {
            BaseActivity.this.lambda$new$1();
        }
    };
    protected Handler handler = new a();
    protected String TAG = getClass().getSimpleName();
    protected String mActivityName = "[Activity]" + this.TAG;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void onContextMenuClosed(Menu menu);
    }

    private void checkQZoneInitState() {
        if (!km.a.f412646a.a()) {
            RFWLog.i(this.TAG, RFWLog.USR, this + " qzone process do not need init env");
            return;
        }
        if (QZoneApiProxy.isQZonePluginInit()) {
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            RFWLog.i(this.TAG, RFWLog.USR, this + " checkQZoneInitState error, peekAppRuntime is null");
            if (!com.qzone.reborn.configx.g.f53821a.l().r()) {
                return;
            } else {
                MobileQQ.sMobileQQ.waitAppRuntime();
            }
        }
        QZoneApiProxy.initEnv(this, MobileQQ.sMobileQQ.peekAppRuntime());
        QZoneApiProxy.initServlet(this, MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private void dismissPluginLoading() {
        Intent intent = new Intent("action_launch_completed");
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "FriendFeed", QzoneConfig.DefaultValue.DEFAULT_FRIENDFEED_TITLE);
        intent.putExtra("plugin_apk", "qzone_plugin.apk");
        intent.putExtra("plugin_name", config);
        sendBroadcast(intent);
    }

    public static Activity getTopActivity() {
        return topActivity;
    }

    public static boolean getisStratActivity() {
        return isStartActivity;
    }

    private void handleJinYanMessage(QZoneResult qZoneResult) {
        com.qzone.util.o.d(this, qZoneResult.getReturnCode());
    }

    private void iniStatusBarHeight() {
        this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(this);
    }

    private void initFeed() {
        com.qzone.proxy.feedcomponent.e.c(BaseApplicationImpl.getApplication().getApplicationContext(), BaseApplicationImpl.getApplication());
    }

    private void initImageEnv() {
        if (ImageManagerEnv.getAppContext() == null) {
            ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
        }
    }

    public static boolean isMoveTaskToBack(Intent intent) {
        return intent.getComponent() == null || !intent.getComponent().getPackageName().equals(BaseApplication.getContext().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleFootBanner$9(com.qzone.feed.business.model.a aVar) {
        if (canShowFootBanner(aVar.f47123g.eAdType)) {
            if (this.mFootBanner == null) {
                this.mFootBanner = new FootBanner(this);
                this.mFootBanner.h((ViewStub) findViewById(R.id.hig));
            }
            FootBanner footBanner = this.mFootBanner;
            if (footBanner == null || footBanner.l()) {
                return;
            }
            this.mFootBanner.t(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        CreditLevelMonitor.c().b(getHandler());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        RDMEtraMsgCollector.getInstance().addActivityName(this.mActivityName);
        RDMEtraMsgCollector.getInstance().addActivityEvent(this.mActivityName + " onCreate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDestroy$3() {
        RDMEtraMsgCollector.getInstance().addActivityEvent(this.mActivityName + " onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$7() {
        RDMEtraMsgCollector.getInstance().addActivityEvent(this.mActivityName + " onPause");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$5(QZoneResult qZoneResult) {
        if (isFinishing()) {
            return;
        }
        onServiceResult(qZoneResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$2() {
        RDMEtraMsgCollector.getInstance().addActivityEvent(this.mActivityName + " onResume");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStop$8() {
        RDMEtraMsgCollector.getInstance().addActivityEvent(this.mActivityName + " onStop");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNetStateCallback$4(boolean z16) {
        QZLog.w(QZLog.TO_DEVICE_TAG, this.TAG + "\t onNetworkConnect() connected: " + z16);
        Message obtain = Message.obtain();
        obtain.what = 86;
        obtain.obj = Boolean.valueOf(z16);
        this.handler.sendMessageDelayed(obtain, 3000L);
    }

    private void setNightMaskVisible(boolean z16) {
        View view = this.mViewNightMask;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
            return;
        }
        if (z16) {
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(new ColorDrawable(Color.parseColor(NIGHT_MASK_COLOR)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mViewNightMask = imageView;
            View decorView = getWindow().getDecorView();
            if (decorView instanceof ViewGroup) {
                View view2 = this.mViewNightMask;
                ((ViewGroup) decorView).addView(view2, view2.getLayoutParams());
            } else {
                Window window = getWindow();
                View view3 = this.mViewNightMask;
                window.addContentView(view3, view3.getLayoutParams());
            }
        }
    }

    public static void toast(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.r(str);
    }

    public <T extends View> T $(int i3) {
        return (T) findViewById(i3);
    }

    protected boolean canShowFootBanner(int i3) {
        if (4 == i3) {
            return true;
        }
        return false;
    }

    public boolean checkNetworkConnect() {
        return hasNet;
    }

    protected void closeMiniAIO() {
        if (needMiniAIO() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true) && this.mMiniMsgUser != null) {
            MiniMsgIPCClient.getInstance().removetMiniUser(this.mMiniMsgUser);
            this.mMiniMsgUser = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (isEnableNightMask() && QQTheme.isNowThemeIsNightForQzone()) {
            setNightMaskVisible(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        if (isNeedQZoneStyleActivityAnim()) {
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        super.finish();
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        return null;
    }

    public String getCurSkinId() {
        return this.skinid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFeedListBackgroundId() {
        return R.drawable.a_m;
    }

    public Handler getHandler() {
        return this.handler;
    }

    protected MiniMsgUserParam getMiniMsgUserParam() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 1;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 0;
        miniMsgUserParam.positionX = -1;
        miniMsgUserParam.positionY = -1;
        miniMsgUserParam.colorType = 0;
        miniMsgUserParam.filterMsgType = 0;
        return miniMsgUserParam;
    }

    protected int getNetworkNoLinkTipsId() {
        return R.string.ghi;
    }

    public String getRMonitorTraceName() {
        return getClass().getCanonicalName();
    }

    @Override // com.qzone.util.ap.a
    public int getReportPageId() {
        return -1;
    }

    public int getTitleBottom() {
        return this.titleBottom;
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (BaseApplicationImpl.getApplication() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public WatchActivityManager getWatchActivityManager() {
        return this.watchActivityManager;
    }

    protected void handleFootBanner(QZoneResult qZoneResult) {
        ArrayList arrayListFromBundle = ParcelableWrapper.getArrayListFromBundle(qZoneResult.getBundle(), BusinessADBannerData.STORE_KEY);
        int i3 = 0;
        if (arrayListFromBundle != null && arrayListFromBundle.size() > 0) {
            int i16 = 0;
            while (i3 < arrayListFromBundle.size()) {
                BusinessADBannerData businessADBannerData = (BusinessADBannerData) arrayListFromBundle.get(i3);
                final com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
                aVar.f47123g = businessADBannerData;
                if (businessADBannerData != null && canShowFootBanner(businessADBannerData.eAdType)) {
                    getHandler().postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            BaseActivity.this.lambda$handleFootBanner$9(aVar);
                        }
                    }, 500L);
                    i16 = 1;
                }
                i3++;
            }
            i3 = i16;
        }
        FootBanner footBanner = this.mFootBanner;
        if (footBanner != null && footBanner.l() && i3 == 0) {
            this.mFootBanner.g();
        }
    }

    public void hideMiniAIO() {
        MiniMsgUser miniMsgUser;
        if (needMiniAIO() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true) && (miniMsgUser = this.mMiniMsgUser) != null) {
            miniMsgUser.hideEntry();
            this.mMiniMsgUser.onBackground();
        }
    }

    public boolean isEnableNightMask() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isNeedMiniMsg() {
        return true;
    }

    protected boolean isNeedQZoneStyleActivityAnim() {
        return true;
    }

    public boolean isRumtimeReady() {
        if (MobileQQ.getMobileQQ().isRuntimeReady()) {
            AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
            if (waitAppRuntime != null) {
                boolean isModuleRunning = waitAppRuntime.isModuleRunning("qzone_plugin.apk");
                QZLog.i(this.TAG, 1, "isRumtimeReady:" + isModuleRunning);
                return isModuleRunning;
            }
            QZLog.i(this.TAG, 1, "isRumtimeReady appRuntime ==null isRumtimeReady=false");
            return false;
        }
        QZLog.i(this.TAG, 1, "isRumtimeReady MobileQQ.getMobileQQ().isRuntimeReady()=false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUIThread() {
        return Thread.currentThread().getId() == this.mUIThreadID;
    }

    public boolean needCheckCreditLevel() {
        return false;
    }

    public boolean needMiniAIO() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAdapter(final BaseAdapter baseAdapter) {
        if (!isUIThread()) {
            runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.e
                @Override // java.lang.Runnable
                public final void run() {
                    BaseActivity.lambda$notifyAdapter$6(baseAdapter);
                }
            });
        } else if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onBackPress() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "[Activity]" + this.TAG + " onBackPress");
        return false;
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "[Activity]" + this.TAG + " onBackPressed");
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th5) {
            QZLog.e(this.TAG, "onConfigurationChanged", th5);
        }
        int i3 = configuration.orientation;
        if ((i3 == 1 || i3 == 2) && i3 != lastOrientation) {
            lastOrientation = i3;
            u5.a.f();
            onScreenOrientationChange();
        }
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        b bVar = this.contextMenuClosedListener;
        if (bVar != null) {
            bVar.onContextMenuClosed(menu);
        }
        super.onContextMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        if (shouldSetOrientation()) {
            if (AppSetting.o(this)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        }
        if (isNeedQZoneStyleActivityAnim()) {
            overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
        this.mNeedStatusTrans = false;
        isStartActivity = true;
        ProcessUtils.setTopActivity(this, this.TAG);
        PerfTracer.traceClick2Activity(getIntent());
        ResourcePreloader.b().f44470a = true;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onCreate$0();
            }
        });
        super.onCreate(bundle);
        checkQZoneInitState();
        this.watchActivityManager.onCreate(this);
        this.processer = new SkinnableActivityProcesser(this, this);
        if (getFeedListBackgroundId() > 0 && getFeedListBackgroundId() != -1) {
            getWindow().setBackgroundDrawableResource(getFeedListBackgroundId());
        }
        iniStatusBarHeight();
        initFeed();
        initImageEnv();
        this.mUIThreadID = Thread.currentThread().getId();
        this.screenShotLogic.c();
        setNetStateCallback(true);
        QZoneLoginReportHelper.handleLoginFromIntent(getIntent());
        QZoneAppInterface.initActivityStartParameters();
        if (needMiniAIO() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true) && isNeedMiniMsg()) {
            this.mMiniMsgUser = new MiniMsgUser(this, getMiniMsgUserParam());
        }
        IOnSetTheme();
        VideoReport.addToDetectionWhitelist(this);
        if (shouldReportUsage()) {
            QZonePerfReporter.f59697a.j("page", this.mActivityName);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (ServerListProvider.isDebugEnable()) {
            menu.add(0, 1, 0, com.qzone.util.l.a(R.string.jwi));
            menu.add(0, 22, 0, com.qzone.util.l.a(R.string.jwh));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        NetworkState.NetworkStateListener networkStateListener;
        this.watchActivityManager.onDestroy();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onDestroy$3();
            }
        });
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.netStateCallback && (networkStateListener = this.netStateListener) != null) {
            NetworkState.removeListener(networkStateListener);
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).removeTask(this.checkCreditLevel);
        this.screenShotLogic.d();
        SkinnableActivityProcesser skinnableActivityProcesser = this.processer;
        if (skinnableActivityProcesser != null) {
            skinnableActivityProcesser.destory();
        }
        super.onDestroy();
        if (this.mViewModelStore != null && !isChangingConfigurations()) {
            this.mViewModelStore.clear();
        }
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHandleMessage(Message message) {
        QZoneResult unpack;
        if (isFinishing() || (unpack = QZoneResult.unpack(message)) == null) {
            return;
        }
        handleJinYanMessage(unpack);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        this.watchActivityManager.onKeyDown(i3, keyEvent);
        if (i3 == 4 && keyEvent.getRepeatCount() == 0 && onBackPress()) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 1) {
            if (itemId != 22) {
                return super.onMenuItemSelected(i3, menuItem);
            }
            ho.h.c(this);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNetStateChanged(boolean z16) {
        QZLog.w(QZLog.TO_DEVICE_TAG, this.TAG + "\t onNetStateChanged() hasNet: " + z16);
        hasNet = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onPause$7();
            }
        });
        this.screenShotLogic.e();
        this.isMoveToBG = true;
        topActivity = null;
        QZoneCustomToast.a();
        hideMiniAIO();
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
        po.a.f426574a.a(getRMonitorTraceName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        po.a.f426574a.b(getRMonitorTraceName());
        com.qzone.util.ap.h(this);
        this.watchActivityManager.onResume();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onResume$2();
            }
        });
        topActivity = this;
        this.isMoveToBG = false;
        this.screenShotLogic.f(getClass().getName());
        FootBanner footBanner = this.mFootBanner;
        if (footBanner != null) {
            footBanner.r();
        }
        showMiniAIO();
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.isTopExceptInputPanel = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.isTopExceptInputPanel = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onStop$8();
            }
        });
        this.screenShotLogic.g();
        this.watchActivityManager.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Intent intent = new Intent("tencent.notify.background");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("selfuin", LoginData.getInstance().getUinString());
        intent.putExtra("classname", getClass().getName());
        sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        long j3;
        MiniMsgUser miniMsgUser;
        int width;
        super.onWindowFocusChanged(z16);
        if (!z16 || this.mReplace) {
            return;
        }
        this.mReplace = true;
        if (getWindow() != null && getWindow().getDecorView() != null && (width = getWindow().getDecorView().getWidth()) != ViewUtils.getScreenWidth()) {
            Configuration configuration = BaseApplication.getContext().getResources().getConfiguration();
            configuration.screenWidthDp = com.qzone.util.ar.r(width);
            ViewUtils.resetScreenSize();
            onConfigurationChanged(configuration);
        }
        View findViewById = getWindow().findViewById(android.R.id.content);
        if (findViewById != null) {
            this.titleBottom = findViewById.getTop();
        }
        Intent intent = getIntent();
        if (intent != null) {
            boolean z17 = intent.getBooleanExtra("QZoneExtra.Plugin.isloading", false) || QZoneTranslucentActivity.D;
            if (QLog.isColorLevel()) {
                QLog.i("Perf.Qzone", 2, "QZone baseactivity onWindowFocusChanged isShowPluginLoading: " + z17);
            }
            if (z17) {
                dismissPluginLoading();
                QZoneTranslucentActivity.D = false;
            }
        }
        if (getIntent().hasExtra(PerfTracer.PARAM_CLICK_TIME)) {
            j3 = getIntent().getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
        } else if (getIntent().hasExtra("preAct_time")) {
            j3 = getIntent().getLongExtra("preAct_time", 0L);
        } else {
            QZLog.e(this.TAG, 1, "no clickTime found in Intent");
            j3 = 0;
        }
        if (j3 > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - j3);
            if (currentTimeMillis > 0) {
                AccManager.reportActivitySwitch(this.TAG, currentTimeMillis);
            }
            QZLog.i(this.TAG, 1, "click to window show cost:", Integer.valueOf(currentTimeMillis));
        }
        if (needMiniAIO() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true) && (miniMsgUser = this.mMiniMsgUser) != null) {
            miniMsgUser.showOnFirst();
        }
    }

    public void setNetStateCallback(boolean z16) {
        this.netStateCallback = z16;
        if (z16) {
            if (this.netStateListener == null) {
                this.netStateListener = new NetworkState.NetworkStateListener() { // from class: com.qzone.common.activities.base.h
                    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
                    public final void onNetworkConnect(boolean z17) {
                        BaseActivity.this.lambda$setNetStateCallback$4(z17);
                    }
                };
            }
            NetworkState.addListener(this.netStateListener);
            hasNet = NetworkState.isNetSupport();
            return;
        }
        NetworkState.NetworkStateListener networkStateListener = this.netStateListener;
        if (networkStateListener != null) {
            NetworkState.removeListener(networkStateListener);
        }
    }

    public void setOnContextMenuClosedListener(b bVar) {
        this.contextMenuClosedListener = bVar;
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void setRequestedOrientation(int i3) {
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            return;
        }
        super.setRequestedOrientation(i3);
    }

    protected boolean shouldReportUsage() {
        return true;
    }

    public boolean shouldSetOrientation() {
        return true;
    }

    public void showMiniAIO() {
        MiniMsgUser miniMsgUser;
        if (needMiniAIO() && QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true) && (miniMsgUser = this.mMiniMsgUser) != null) {
            miniMsgUser.onForeground();
        }
    }

    public void showNoNetworkTips() {
        if (this.isMoveToBG) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastNolinkToastShowTime < 2000) {
            return;
        }
        this.lastNolinkToastShowTime = currentTimeMillis;
        toast(getNetworkNoLinkTipsId());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(intent);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        if (!isMoveTaskToBack(intent)) {
            intent.addFlags(262144);
        }
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, setLastActivityName());
        try {
            super.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean supportColorNote() {
        return false;
    }

    public AppRuntime waitAppRuntime() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        ci.b(getIntent());
        AppRuntime qzoneAppInterface = LoginData.getInstance().getQzoneAppInterface();
        if (qzoneAppInterface != null && (qzoneAppInterface instanceof QZoneAppInterface)) {
            ((QZoneAppInterface) qzoneAppInterface).onActivityCreate();
        }
        if (needCheckCreditLevel()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).removeTask(this.checkCreditLevel);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(this.checkCreditLevel);
        }
        return waitAppRuntime;
    }

    public <T extends View> T $(View view, int i3) {
        return (T) view.findViewById(i3);
    }

    @Override // com.qzone.adapter.feedcomponent.IServiceCallback
    public final void onResult(final QZoneResult qZoneResult) {
        if (qZoneResult == null || isFinishing()) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.i
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.lambda$onResult$5(qZoneResult);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == -4015) {
                if (BaseActivity.this.isFinishing()) {
                    return;
                }
                com.qzone.util.o.c(BaseActivity.this);
                return;
            }
            if (i3 == -88) {
                if (BaseActivity.this.isFinishing()) {
                    return;
                }
                CreditLevelMonitor.c().e(BaseActivity.this, (String) message.obj);
            } else if (i3 == 86) {
                BaseActivity.this.onNetStateChanged(((Boolean) message.obj).booleanValue());
            } else {
                if (i3 != 999910 && i3 != 999914) {
                    BaseActivity.this.onHandleMessage(message);
                    return;
                }
                QZoneResult unpack = QZoneResult.unpack(message);
                if (unpack != null) {
                    BaseActivity.this.handleFootBanner(unpack);
                }
                BaseActivity.this.onHandleMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyAdapter$6(BaseAdapter baseAdapter) {
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public static void toast(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ToastUtil.s(str, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(intent, bundle);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        return getString(R.string.button_back);
    }

    public static void toast(int i3) {
        ToastUtil.n(i3);
    }

    public static void toast(int i3, int i16) {
        ToastUtil.o(i3, i16);
    }

    public final void runOnUiThread(Runnable runnable, long j3) {
        if (j3 == 0) {
            runOnUiThread(runnable);
        } else {
            mainHandler.postDelayed(runnable, j3);
        }
    }

    public void IOnSetTheme() {
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public Activity getActivity() {
        return this;
    }

    public Activity getOutActivity() {
        return this;
    }

    public Activity getRealActivity() {
        return this;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
    }

    protected void onScreenOrientationChange() {
    }

    protected void onServiceResult(QZoneResult qZoneResult) {
    }

    @Override // cooperation.qzone.util.PerfTracer.PerfTimeReport
    public void reportPerfTime(TimeCostTrace timeCostTrace) {
    }
}
