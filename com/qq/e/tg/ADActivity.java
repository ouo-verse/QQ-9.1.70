package com.qq.e.tg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ADActivity extends Activity {
    public static final String DOWNLOAD_MANAGE = "downloadManage";
    public static final String FULL_SCREEN_DETAIL = "fullScreenDetail";
    public static final String GDT_CANVAS = "gdtCanvas";
    public static final String HALF_SCREEN = "halfScreen";
    public static final String INNER_BROWSER = "innerBrowser";
    public static final String INTERSTITIAL_FULL_SCREEN = "interstitialFullScreen";
    public static final String POPUP_APK_DETAIL = "popupAPKDetail";
    public static final String TANGRAMREWARD_VIDEO = "tangramrewardVideo";
    public static final String TANGRAM_HIPPY_PAGE = "tangramRewardHippy";
    public static final String TANGRAM_REWARD_PAGE_AD = "tangramRewardPageAd";
    public static final String TANGRAM_REWARD_PIC = "tangramRewardPic";
    public static final String TANGRAM_REWARD_VIDEO_CEILING = "tangramRewardVideoCeiling";
    public static final String VIDEO_CEILING = "videoCeiling";

    /* renamed from: a, reason: collision with root package name */
    private ACTD f40414a;

    /* renamed from: b, reason: collision with root package name */
    private GestureDetector f40415b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f40416c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f40417d = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class AdLandingPageGestureListener implements GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ADActivity> f40418a;

        AdLandingPageGestureListener(WeakReference<ADActivity> weakReference) {
            this.f40418a = weakReference;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            GDTLogger.d("LandingPageGesture_onDown:");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            ADActivity aDActivity;
            if (motionEvent != null && motionEvent2 != null) {
                GDTLogger.d("LandingPageGesture_onFling: e1 " + motionEvent + " e2 " + motionEvent2);
                float rawX = motionEvent2.getRawX() - motionEvent.getRawX();
                WeakReference<ADActivity> weakReference = this.f40418a;
                if (weakReference != null) {
                    aDActivity = weakReference.get();
                } else {
                    aDActivity = null;
                }
                if (aDActivity != null && ADActivity.a(aDActivity, aDActivity.f40416c) && rawX >= ADActivity.a((Context) aDActivity) / 2.0f) {
                    aDActivity.finish();
                    return false;
                }
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            GDTLogger.d("LandingPageGesture_onLongPress:");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
            GDTLogger.d("LandingPageGesture_onShowPress:");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            GDTLogger.d("LandingPageGesture_onSingleTapUp:");
            return false;
        }
    }

    static /* synthetic */ int a(Context context) {
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        GDTLogger.e("getScreenWidth error");
        return Integer.MIN_VALUE;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        GestureDetector gestureDetector = this.f40415b;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013c A[Catch: all -> 0x0155, TryCatch #1 {all -> 0x0155, blocks: (B:8:0x0033, B:10:0x0041, B:12:0x004c, B:15:0x0059, B:17:0x0064, B:20:0x0071, B:22:0x007c, B:24:0x0087, B:26:0x0092, B:28:0x009d, B:31:0x00a9, B:33:0x00b4, B:36:0x00c0, B:38:0x00cb, B:39:0x00e0, B:40:0x0138, B:42:0x013c, B:43:0x014d, B:45:0x00e3, B:46:0x00f9, B:47:0x010f, B:48:0x0125), top: B:7:0x0033 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        String str;
        ACTD activityDelegate;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f40416c = extras.getString(ACTD.DELEGATE_NAME_KEY);
            this.f40417d = extras.getBoolean(ACTD.NEED_GESTURE_BACK);
            String string = extras.getString("appid");
            if (!StringUtil.isEmpty(this.f40416c) && !StringUtil.isEmpty(string)) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), string)) {
                        if (!this.f40416c.equals("innerBrowser") && !this.f40416c.equals("downloadManage")) {
                            if (!this.f40416c.equals("gdtCanvas") && !this.f40416c.equals("halfScreen")) {
                                if (!this.f40416c.equals("tangramrewardVideo") && !this.f40416c.equals("tangramRewardPageAd") && !this.f40416c.equals("tangramRewardVideoCeiling") && !this.f40416c.equals("tangramRewardPic") && !this.f40416c.equals("tangramRewardHippy")) {
                                    if (!this.f40416c.equals("videoCeiling") && !this.f40416c.equals("fullScreenDetail")) {
                                        if (this.f40416c.equals("interstitialFullScreen")) {
                                            activityDelegate = GDTADManager.getInstance().getPM().getPOFactory(PM.INTERSITIAL_AD).getActivityDelegate(this.f40416c, this);
                                            this.f40414a = activityDelegate;
                                        }
                                        if (this.f40414a == null) {
                                            str = "Init ADActivity Delegate return null,delegateName" + this.f40416c;
                                        }
                                    }
                                    activityDelegate = GDTADManager.getInstance().getPM().getPOFactory(PM.NATIVE_UNIFIED_AD).getActivityDelegate(this.f40416c, this);
                                    this.f40414a = activityDelegate;
                                    if (this.f40414a == null) {
                                    }
                                }
                                activityDelegate = GDTADManager.getInstance().getPM().getPOFactory(PM.REWARD_AD).getActivityDelegate(this.f40416c, this);
                                this.f40414a = activityDelegate;
                                if (this.f40414a == null) {
                                }
                            }
                            activityDelegate = GDTADManager.getInstance().getPM().getPOFactory(PM.CANVAS).getActivityDelegate(this.f40416c, this);
                            this.f40414a = activityDelegate;
                            if (this.f40414a == null) {
                            }
                        }
                        activityDelegate = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(this.f40416c, this);
                        this.f40414a = activityDelegate;
                        if (this.f40414a == null) {
                        }
                    } else {
                        str = "Init GDTADManager fail in AdActivity";
                    }
                    GDTLogger.e(str);
                } catch (Throwable th5) {
                    GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + this.f40416c, th5);
                    GDTADManager.getInstance().getPM().autoRollbackPlugin(th5.toString());
                }
            }
        }
        if (GDTADManager.getInstance() != null && GDTADManager.getInstance().getSM() != null && GDTADManager.getInstance().getSM().getInteger("key_set_webview_muti_process_dir", 1) == 1 && Build.VERSION.SDK_INT >= 28) {
            String processName = SystemUtil.getProcessName(this);
            try {
                if (!getPackageName().equals(processName)) {
                    WebView.setDataDirectorySuffix(processName);
                }
            } catch (Throwable th6) {
                GDTLogger.e("setDataDirectorySuffix exception", th6);
            }
        }
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            finish();
        }
        try {
            super.onCreate(bundle);
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        this.f40415b = new GestureDetector(new AdLandingPageGestureListener(new WeakReference(this)));
        ACTD actd2 = this.f40414a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            ACTD actd = this.f40414a;
            if (actd != null) {
                actd.onResume();
            }
            GlobalSetting.setIsCurrentPageAllowAutoInstall(true);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.f40414a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
        GlobalSetting.setIsCurrentPageAllowAutoInstall(false);
    }

    static /* synthetic */ boolean a(ADActivity aDActivity, String str) {
        if ("tangramrewardVideo".equals(str) || "tangramRewardPageAd".equals(str)) {
            return false;
        }
        return aDActivity.f40417d;
    }
}
