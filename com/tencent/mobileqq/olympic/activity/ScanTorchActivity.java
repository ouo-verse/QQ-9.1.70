package com.tencent.mobileqq.olympic.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.IActivityModule;
import com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.ar.ARArguments;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.view.ScanEntryProviderContainerView;
import com.tencent.mobileqq.ar.view.ScanGLRenderEnvFragment;
import com.tencent.mobileqq.ar.w;
import com.tencent.mobileqq.ar.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.api.IScanABTestApi;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.g;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.h;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.PerfTracer;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;
import z81.a;

/* compiled from: P */
@RoutePage(desc = "\u626b\u4e00\u626bAR\u706b\u70ac", path = RouterConstants.UI_ROUTE_SCAN_TORCH_ACTIVITY)
/* loaded from: classes16.dex */
public class ScanTorchActivity extends OlympicToolBaseActivity implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static boolean IMMERSE_AR_SOFTWARE = false;
    public static final String KEY_ICON_TEXT = "icon_text";
    public static final String KEY_ICON_URL = "icon_url";
    public static final String KEY_JUMP_FROM_WEB = "jump_from_web";
    public static final String KEY_LOG_NO = "log_on";
    public static final String KEY_URL_FROM_WEB_SWITCH = "web_url_switch";
    public static final String TAG = "ScanTorchActivity";
    private static Boolean sNeedBeaconReportLaunch;
    public static boolean specialTestOn;
    long firstGetFaceTrackResultTime;
    volatile boolean isPause;
    private long mARInitBeginTime;
    private long mActivityLastVisibleTime;
    private long mActivityVisibleTime;
    public long mAddFragmentTime;
    public ARArguments mArArguments;
    private boolean mArEnabled;
    public w mArconfigManager;
    private long mConfigManagerBindTime;
    private long mConfigManagerInitTime;
    private long mConfigReadyTime;
    private int mCountBroadcast;
    public String mCurrentNickName;
    private String mGalleryFilePath;
    public boolean mHasArAnimStarted;
    private boolean mHasDestroy;
    boolean mHasDisplayMultiWindowTip;
    private boolean mHasFirstWindowFocus;
    private boolean mHideAlbum;
    private boolean mIsARViewLazyInit;
    private boolean mIsNewUI;
    public int mLastArAnimState;
    private int mLastScreenH;
    private int mLastScreenW;
    private boolean mLaunchDataReported;
    public String mLinkUrl;
    private HashMap<String, Integer> mLotteryMap;
    private boolean mNeedDownloadARResource;
    private BroadcastReceiver mOnFinishReceiver;
    public long mOnStartTime;
    a.b mPromotionInfo;
    private QQBroadcastReceiver mReceiver;
    private long mResourceCheckEndTime;
    public RelativeLayout mRoot;
    public com.tencent.mobileqq.ar.model.c mScanEntryResManager;
    private ScanEntryProviderContainerView mScanEntryRootView;
    private ScanGLRenderEnvFragment mScanGLRenderFragment;
    Rect mScanRect;
    private boolean mShowDebugTips;
    public long mTimeArReady;
    private long mTimeOnCreate;
    public Handler mUiHandler;
    volatile boolean needReportRedDot;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.olympic.activity.ScanTorchActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        class ViewOnClickListenerC8177a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            ViewOnClickListenerC8177a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ScanTorchActivity.this.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                QLog.d(ScanTorchActivity.TAG, 1, "checkSelfPermission grant");
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                QLog.d(ScanTorchActivity.TAG, 1, "checkSelfPermission deny");
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) permissionRequestDialog, (Object) list);
                return;
            }
            super.onDialogShow(permissionRequestDialog, list);
            QLog.d(ScanTorchActivity.TAG, 1, "checkSelfPermission onDialogShow");
            permissionRequestDialog.setOnDisAllowClickListener(new ViewOnClickListenerC8177a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends DefaultActivityModuleProvider {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        class a extends SystemBarActivityModule {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule, com.tencent.mobileqq.app.activitymodule.ISystemBar
            public void initNavigationBarColor() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activitymodule.DefaultActivityModuleProvider
        protected IActivityModule getSystemBarModule() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IActivityModule) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends QQBroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
            }
        }

        @Override // mqq.app.QQBroadcastReceiver
        public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent);
                return;
            }
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d(ScanTorchActivity.TAG, 2, "onReceive, action=", action);
            }
            if (MobileQQ.ACTION_MAIN_PROCESS_ALIVE.equals(action)) {
                ScanTorchActivity.this.mCountBroadcast++;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73438);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        IMMERSE_AR_SOFTWARE = false;
        specialTestOn = false;
        sNeedBeaconReportLaunch = null;
    }

    public ScanTorchActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLinkUrl = null;
        this.mLastArAnimState = -1;
        this.mHasArAnimStarted = false;
        this.mTimeOnCreate = -1L;
        this.mTimeArReady = -1L;
        this.mAddFragmentTime = -1L;
        this.mHasDestroy = false;
        this.mLotteryMap = new HashMap<>();
        this.mIsARViewLazyInit = false;
        this.mArEnabled = true;
        this.mHideAlbum = false;
        this.mPromotionInfo = null;
        this.mIsNewUI = true;
        this.isPause = false;
        this.firstGetFaceTrackResultTime = -1L;
        this.mHasDisplayMultiWindowTip = false;
        this.mReceiver = new c();
        this.mOnFinishReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.olympic.activity.ScanTorchActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                } else {
                    ScanTorchActivity.this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.olympic.activity.ScanTorchActivity.5.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                QLog.d(ScanTorchActivity.TAG, 1, "OnFinishReceiver, finish");
                                ScanTorchActivity.this.finish();
                            }
                        }
                    });
                }
            }
        };
        this.mLastScreenH = 0;
    }

    private void addScanGLEnvFragment() {
        if (!this.mHasDestroy && this.mScanGLRenderFragment == null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.f164415wu);
            if (findFragmentById != null) {
                QLog.i(TAG, 1, "addScanGLEnvFragment has fragment.");
                this.mScanGLRenderFragment = (ScanGLRenderEnvFragment) findFragmentById;
                return;
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            ScanGLRenderEnvFragment wh5 = ScanGLRenderEnvFragment.wh(null);
            this.mScanGLRenderFragment = wh5;
            beginTransaction.add(R.id.f164415wu, wh5);
            beginTransaction.commitAllowingStateLoss();
            if (this.mAddFragmentTime < 0) {
                this.mAddFragmentTime = System.currentTimeMillis();
            }
        }
    }

    private static String format(int i3) {
        return String.format("%.2f", Float.valueOf(i3 / 1000.0f));
    }

    private void initArConfig() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("initArConfig mArEnabled=%s", Boolean.valueOf(this.mArEnabled)));
        }
        if (!this.mArEnabled) {
            return;
        }
        w wVar = this.mArconfigManager;
        com.tencent.mobileqq.ar.model.c cVar = this.mScanEntryResManager;
        wVar.e(this, true, cVar, cVar, cVar);
        this.mConfigManagerInitTime = System.currentTimeMillis();
    }

    private void initData() {
        Bundle bundle;
        long j3;
        this.mUiHandler = new Handler(this);
        Intent intent = getIntent();
        if (intent != null) {
            intent.setExtrasClassLoader(ScanTorchActivity.class.getClassLoader());
            d.f255224a = intent.getBooleanExtra(KEY_LOG_NO, false);
            this.mCurrentNickName = intent.getStringExtra("CurrentNickname");
            bundle = intent.getBundleExtra("web_invoke_params");
            if (QLog.isDevelopLevel()) {
                QQAudioHelper.l("ScanTorchActivity.initData", bundle);
            }
            if (bundle != null) {
                j3 = bundle.getLong("PromotionType", 0L);
            } else {
                j3 = 0;
            }
            if (j3 != 2) {
                if (j3 == 3) {
                    a.C11663a c11663a = new a.C11663a();
                    this.mPromotionInfo = c11663a;
                    c11663a.a(this.app, bundle);
                } else if (j3 == 1) {
                    a.d dVar = new a.d();
                    this.mPromotionInfo = dVar;
                    dVar.a(this.app, bundle);
                }
            }
        } else {
            bundle = null;
        }
        if (this.mPromotionInfo == null) {
            this.mPromotionInfo = new a.c();
            QLog.w(TAG, 1, "initData, \u6ca1\u6709\u8fd0\u8425\u6570\u636e");
        }
        this.mArArguments = new ARArguments(false);
        w wVar = new w();
        this.mArconfigManager = wVar;
        this.mScanEntryResManager = new com.tencent.mobileqq.ar.model.c(wVar);
        initArConfig();
        if (bundle != null) {
            a.b bVar = this.mPromotionInfo;
            if ((bVar instanceof a.d) && (bVar.f452144a & 4096) != 0) {
                a.C11663a c11663a2 = new a.C11663a();
                this.mPromotionInfo = c11663a2;
                c11663a2.a(this.app, bundle);
                if (TextUtils.isEmpty(((a.C11663a) this.mPromotionInfo).f452143g)) {
                    ((a.C11663a) this.mPromotionInfo).f452143g = "-1";
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "transfer Promotion to AR TransferPromotion");
                }
            }
        }
        this.mScanEntryRootView.k0(this.mPromotionInfo, !this.mArEnabled);
    }

    private void initQrScanRectDisplay() {
        boolean z16;
        int i3 = z81.c.f452158a;
        int i16 = z81.c.f452159b;
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            i16 -= ImmersiveUtils.getStatusBarHeight(this);
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("initQrScanRectDisplay screenWidth=%s, screenHeight=%s, exclude=%b", Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16)));
        }
        int min = (int) (Math.min(i16, i3) * y.a().f198843c);
        if (min <= 0) {
            min = BaseAIOUtils.f(248.0f, getResources());
        }
        Rect rect = new Rect(0, 0, min, min);
        this.mScanRect = rect;
        if (this.mIsNewUI) {
            int dpToPx = ViewUtils.dpToPx(106.0f);
            Rect rect2 = this.mScanRect;
            rect2.offset((i3 / 2) - rect2.centerX(), ((i16 - dpToPx) / 2) - (this.mScanRect.height() / 2));
            return;
        }
        rect.offset((i3 / 2) - rect.centerX(), (int) ((i16 / 2) - (this.mScanRect.height() * 0.55f)));
    }

    private void initView() {
        this.mRoot = (RelativeLayout) findViewById(R.id.root);
        initQrScanRectDisplay();
        addScanGLEnvFragment();
        ScanEntryProviderContainerView scanEntryProviderContainerView = (ScanEntryProviderContainerView) findViewById(R.id.ign);
        this.mScanEntryRootView = scanEntryProviderContainerView;
        scanEntryProviderContainerView.setScanRect(this.mScanRect, !this.mHideAlbum);
        this.mScanEntryRootView.setRenderEngine(this.mScanGLRenderFragment.rh());
        this.mScanEntryRootView.setInitEnv(this.app, this);
        this.mScanEntryRootView.setEntranceType(getIntent().getIntExtra("key_entrance_type", 0));
        this.mScanEntryRootView.a0();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.olympic.activity.ScanTorchActivity.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ScanTorchActivity.this.updateQRRect();
                }
            }
        }, 100L);
    }

    private boolean isCostTimeInvalid(long j3) {
        if (j3 >= 0 && j3 <= 60000) {
            return false;
        }
        return true;
    }

    private void onSelectPicResult(Intent intent) {
        if (intent == null) {
            return;
        }
        AlbumResult albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
        if (albumResult == null) {
            QLog.i(TAG, 1, "[onSelectPicResult]AlbumResult is null.");
            return;
        }
        List<LocalMediaInfo> e16 = albumResult.e();
        if (e16 != null && !e16.isEmpty()) {
            String path = e16.get(0).getPath();
            if (TextUtils.isEmpty(path)) {
                QLog.i(TAG, 1, "[onSelectPicResult]path is empty.");
                return;
            }
            ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
            if (scanEntryProviderContainerView != null) {
                scanEntryProviderContainerView.T(path);
                return;
            }
            return;
        }
        QLog.i(TAG, 1, "[onSelectPicResult]selectInfo is null or empty.");
    }

    private void reportLaunchCostTime(long j3, long j16, long j17, long j18, boolean z16, boolean z17) {
        boolean z18;
        Object obj;
        String str;
        boolean z19 = true;
        QLog.i(TAG, 1, "reportLaunchCostTime wait=" + j3 + ", processLoad=" + j16 + ", activity=" + j17 + ", total=" + j18 + ", waitProcessLoad=" + z16 + ", hasPreloadProcess=" + z17);
        if (!isCostTimeInvalid(j3) && !isCostTimeInvalid(j16) && !isCostTimeInvalid(j17) && !isCostTimeInvalid(j18)) {
            Boolean bool = sNeedBeaconReportLaunch;
            if (bool != null) {
                z18 = bool.booleanValue();
            } else {
                if (new Random().nextInt(10) != 0) {
                    z19 = false;
                }
                sNeedBeaconReportLaunch = Boolean.valueOf(z19);
                z18 = z19;
            }
            if (z18) {
                HashMap hashMap = new HashMap();
                hashMap.put("wait_process_time", String.valueOf(j3));
                hashMap.put("process_load_time", String.valueOf(j16));
                hashMap.put("activity_time", String.valueOf(j17));
                hashMap.put("total_time", String.valueOf(j18));
                String str2 = "1";
                if (z16) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                hashMap.put("wait_process_load", obj);
                if (!z17) {
                    str2 = "0";
                }
                hashMap.put("preload_process", str2);
                AppInterface appInterface = this.app;
                if (appInterface != null) {
                    str = appInterface.getCurrentAccountUin();
                } else {
                    str = "";
                }
                QQBeaconReport.report(str, "scan_launch_performance", hashMap);
            }
            ReportController.o(null, "dc00898", "", "", "0X800C3BE", "0X800C3BE", 0, 0, String.valueOf(j18), "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, mqq.app.AppActivity
    protected void doOnActivityResult(int i3, int i16, Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnActivityResult, requestCode=");
        sb5.append(i3);
        sb5.append(", resultCode=");
        sb5.append(i16);
        sb5.append("data ");
        if (intent == null) {
            str = "is null";
        } else {
            str = "not null.";
        }
        sb5.append(str);
        QLog.i(TAG, 1, sb5.toString());
        if (i3 == d.f255225b) {
            onSelectPicResult(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnBackPressed");
        }
        ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
        if (scanEntryProviderContainerView == null || !scanEntryProviderContainerView.O()) {
            doOnBackPressed(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) configuration);
            return;
        }
        super.doOnConfigurationChanged(configuration);
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i16 = getResources().getDisplayMetrics().heightPixels;
        if (i3 == this.mLastScreenW && i16 == this.mLastScreenH) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("doOnConfigurationChanged [%d,%d,%b]", Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16)));
        }
        if (z16) {
            this.mLastScreenW = i3;
            this.mLastScreenH = i16;
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.olympic.activity.ScanTorchActivity.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScanTorchActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ScanTorchActivity.this.updateQRRect();
                    }
                }
            }, 100L);
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnCreate");
        }
        if (((IScanABTestApi) QRoute.api(IScanABTestApi.class)).isScanUIExpOnline() && ((IScanABTestApi) QRoute.api(IScanABTestApi.class)).isScanUIExperimentB()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsNewUI = z16;
        QLog.i(TAG, 1, "isNewUI = " + this.mIsNewUI);
        getWindow().setFormat(-3);
        getWindow().addFlags(128);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (Build.VERSION.SDK_INT > 28) {
                super.getWindow().addFlags(1024);
            } else {
                super.getWindow().addFlags(256);
                super.getWindow().addFlags(512);
            }
        }
        this.mHasDestroy = false;
        this.mTimeOnCreate = currentTimeMillis;
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        if (bundle != null) {
            try {
                bundle.setClassLoader(ArConfigInfo.class.getClassLoader());
            } catch (Exception e16) {
                QLog.d(TAG, 1, "doOnCreate fail!", e16);
                this.mReceiver = null;
                this.mOnFinishReceiver = null;
                finish();
                return true;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("STF-AL10") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("LON-AL00-PD") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo Y55A") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("OPPO_R11st") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo_Xplay5A") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("EML-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("SM-G9250") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("Pixel 2")) {
            this.isClearCoverLayer = false;
        }
        super.doOnCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("super.doOnCreate time cost:%sms SDK version %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Integer.valueOf(Build.VERSION.SDK_INT)));
        }
        setContentView(R.layout.ayv);
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.t3v), 0).show();
            finish();
            return true;
        }
        hideTitleBar();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("from_qr", false)) {
                this.mArEnabled = intent.getBooleanExtra("ar_enabled", false);
            }
            if (!this.mArEnabled) {
                this.mHideAlbum = intent.getBooleanExtra("hide_album", false);
            }
        }
        initView();
        initData();
        if (this.mReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(MobileQQ.ACTION_MAIN_PROCESS_ALIVE);
            registerReceiver(this.mReceiver, intentFilter);
        }
        if (this.mOnFinishReceiver != null) {
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(IQRJumpApi.ACTION_FINISH_SCAN_TORCH_ACTIVITY);
            registerReceiver(this.mOnFinishReceiver, intentFilter2);
        }
        this.mScanEntryRootView.setUniformResManager(this.mScanEntryResManager);
        ScanEntranceReport.c().j();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_OLYMPIC_TORCH, QQPermissionConstants.Business.SCENE.QQ_AR_OLYMPIC_TORCH));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            QLog.d(TAG, 1, "checkSelfPermission. not grant");
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
        } else {
            QLog.d(TAG, 1, "checkSelfPermission. grant");
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("doOnCreate time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        QQAudioHelper.u(this.mApp);
        return true;
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnDestroy,  needReportRedDot = " + this.needReportRedDot);
        }
        if (this.needReportRedDot) {
            AppInterface appInterface = this.app;
            g.a(appInterface, "dc00898", "", appInterface.getCurrentAccountUin(), "0X8008614", "0X8008614", 0, 0, "", "", "", "");
        }
        if (NeonControl.f197457e) {
            NeonControl.d().c();
        }
        try {
            QQBroadcastReceiver qQBroadcastReceiver = this.mReceiver;
            if (qQBroadcastReceiver != null) {
                unregisterReceiver(qQBroadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver = this.mOnFinishReceiver;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        Handler handler = this.mUiHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HashMap<String, Integer> hashMap = this.mLotteryMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        doReport();
        try {
            w wVar = this.mArconfigManager;
            if (wVar != null) {
                wVar.f();
                this.mArconfigManager = null;
            }
        } catch (Exception e17) {
            QLog.d(TAG, 2, "doOnDestroy mArconfigManager unbind fail. ", e17);
        }
        ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
        if (scanEntryProviderContainerView != null) {
            scanEntryProviderContainerView.c0();
        }
        super.doOnDestroy();
        if (isNowSimpleUI()) {
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
        this.mHasDestroy = true;
        com.tencent.mobileqq.qrscan.utils.b.c(this);
        h.a(this);
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("doOnNewIntent filePath=%s", stringExtra));
        }
        this.mGalleryFilePath = stringExtra;
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnPause");
        }
        this.isPause = true;
        ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
        if (scanEntryProviderContainerView != null) {
            scanEntryProviderContainerView.d0();
        }
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPostResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnPostResume();
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnResume() {
        ScanEntryProviderContainerView scanEntryProviderContainerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnResume");
        }
        super.doOnResume();
        ScanEntryProviderContainerView scanEntryProviderContainerView2 = this.mScanEntryRootView;
        if (scanEntryProviderContainerView2 != null) {
            scanEntryProviderContainerView2.e0();
        }
        if (!TextUtils.isEmpty(this.mGalleryFilePath) && (scanEntryProviderContainerView = this.mScanEntryRootView) != null) {
            scanEntryProviderContainerView.T(this.mGalleryFilePath);
            this.mGalleryFilePath = null;
        }
        if (isInMultiWindow() && !this.mHasDisplayMultiWindowTip) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.t3u), 1).show();
            this.mHasDisplayMultiWindowTip = true;
        }
        if (isNowSimpleUI()) {
            ImmersiveUtils.setStatusTextColor(false, getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnStart();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnStart");
        }
        this.mOnStartTime = System.currentTimeMillis();
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnStop();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnStop");
        }
        g.a(this.app, "CliOper", "", "", "0X80069CB", "0X80069CB", 0, 0, "1", String.valueOf(System.currentTimeMillis() - this.mOnStartTime), "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("doOnWindowFocusChanged isFocused=%s mIsARViewLazyInit=%s", Boolean.valueOf(z16), Boolean.valueOf(this.mIsARViewLazyInit)));
        }
        synchronized (this) {
            if (z16) {
                if (!this.mHasFirstWindowFocus) {
                    this.mHasFirstWindowFocus = true;
                    ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
                    if (scanEntryProviderContainerView != null) {
                        scanEntryProviderContainerView.P();
                    }
                }
            }
        }
        if (z16) {
            this.mActivityLastVisibleTime = System.currentTimeMillis();
        }
        if (z16 && !this.mLaunchDataReported) {
            Intent intent = getIntent();
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("proc_exist", false);
                long longExtra = intent.getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
                long longExtra2 = intent.getLongExtra(QZoneHelper.Constants.KEY_LAUNCH_TIME, 0L);
                ScanEntranceReport.c().g(booleanExtra, longExtra, longExtra2, intent.getStringExtra("from"));
                if (longExtra > 0) {
                    boolean booleanExtra2 = intent.getBooleanExtra("wait_process_load", true);
                    boolean booleanExtra3 = intent.getBooleanExtra("preload_process", false);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = this.mTimeOnCreate;
                    long j16 = currentTimeMillis - longExtra;
                    reportLaunchCostTime(longExtra2 - longExtra, j3 - longExtra2, currentTimeMillis - j3, j16, booleanExtra2, booleanExtra3);
                    if (!this.mShowDebugTips) {
                        return;
                    } else {
                        try {
                            QQToast.makeText(this, 0, String.format(HardCodeUtil.qqStr(R.string.t3w), Long.valueOf(j16)), 0).show();
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            this.mLaunchDataReported = true;
            this.mActivityVisibleTime = System.currentTimeMillis();
        }
    }

    public void doReport() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Intent intent = getIntent();
        if (intent != null && this.mTimeOnCreate > 0 && this.mAddFragmentTime > 0 && this.mTimeArReady > 0) {
            long longExtra = intent.getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
            int i3 = (int) (this.mTimeOnCreate - longExtra);
            long j3 = this.mTimeArReady;
            long j16 = this.mAddFragmentTime;
            int i16 = (int) (j3 - j16);
            int i17 = (int) (j16 - longExtra);
            if (i3 > 0 && i16 > 0 && i17 > 0) {
                HashMap<String, String> hashMap = new HashMap<>();
                String str2 = "1";
                if (intent.getBooleanExtra("proc_exist", false)) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("proc_exist", str);
                if (!intent.getBooleanExtra("first_click", false)) {
                    str2 = "0";
                }
                hashMap.put("first_click", str2);
                hashMap.put("rcv_kill_broadcast", String.valueOf(this.mCountBroadcast));
                hashMap.put("time_oncreate", format(i3));
                hashMap.put("time_ar_ready", format(i16));
                hashMap.put("time_add_fragment", format(i17));
                StatisticCollector.getInstance(this).collectPerformance("", "olympic_tool_proc_report", true, i16, 0L, hashMap, "", true);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doReport, params=", hashMap);
                }
            }
        }
        if (this.firstGetFaceTrackResultTime > 0) {
            long currentTimeMillis = (System.currentTimeMillis() - this.firstGetFaceTrackResultTime) / 1000;
            if (currentTimeMillis < 7200) {
                StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "actARFaceRecog", true, currentTimeMillis, 0L, (HashMap<String, String>) null, "", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public IActivityModuleProvider getActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IActivityModuleProvider) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    public long getTimeActivityVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.mActivityVisibleTime;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        return true;
    }

    public final boolean isNowSimpleUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return QQTheme.isThemeSimpleDayUI(ThemeUtil.getCurrentThemeId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    public void notifyRenderReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
        if (scanEntryProviderContainerView != null) {
            scanEntryProviderContainerView.b0();
        }
    }

    @Override // com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity, com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        super.onMultiWindowModeChanged(z16);
        QLog.i(TAG, 2, "onMultiWindowModeChanged" + z16);
    }

    protected void updateQRRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (isFinishing()) {
            return;
        }
        int width = this.mRoot.getWidth();
        int height = this.mRoot.getHeight();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("updateQRRect [%d,%d]", Integer.valueOf(width), Integer.valueOf(height)));
        }
        if (width > 0 && height > 0) {
            if (z81.c.f452158a != width || z81.c.f452159b != height) {
                z81.c.f452158a = width;
                z81.c.f452159b = height;
                initQrScanRectDisplay();
                ScanEntryProviderContainerView scanEntryProviderContainerView = this.mScanEntryRootView;
                if (scanEntryProviderContainerView != null) {
                    scanEntryProviderContainerView.f0(this.mScanRect);
                }
            }
        }
    }

    public void doOnBackPressed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        ARVideoRecordUIControllerImpl.t().C(4);
        setResult(11);
        finish();
    }
}
