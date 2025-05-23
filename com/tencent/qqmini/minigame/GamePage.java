package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.DebugSocketAction;
import com.tencent.qqmini.minigame.action.GetGameInfoManager;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.minigame.api.MiniGamePackage;
import com.tencent.qqmini.minigame.api.MiniGamePackageManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.manager.CustomButtonManager;
import com.tencent.qqmini.minigame.manager.FloatDragAdManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameVConsoleManager;
import com.tencent.qqmini.minigame.manager.PendantManager;
import com.tencent.qqmini.minigame.widget.GameNavigationBar;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.monitor.ui.MiniGameMonitorView;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.MiniToast;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class GamePage implements Preloadable<IMiniAppContext>, IPage {
    private static final String TAG = "GamePage";
    private Activity mActivity;
    private CustomButtonManager mCustomButtonManager;
    private TextView mDebuggerEndBtn;
    private View mDebuggerLayer;
    private TextView mDebuggerStatusTv;
    private ViewGroup mDebuggerView;
    private FloatDragAdManager mFloatDragAdManager;
    private ViewGroup mGameContainerView;
    private MiniGamePackage mGameInfo;
    private SurfaceView mGameSurfaceView;
    private IMiniAppContext mMiniAppContext;
    private MiniGameMonitorView mMiniAppMonitorInfoView;
    private BaseGameNavigationBar mNavigationBar;
    private View mPayForFriendView;
    private PendantManager mPendantManager;
    private ViewGroup mRootView;
    private GamePackage.Orientation mTargetOrientation;
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());
    private final GameVConsoleManager vConsoleManager = new GameVConsoleManager();
    private int mGameWidth = 0;
    private int mGameHeight = 0;

    private void attachGameSurfaceView(ViewGroup viewGroup) {
        if (this.mGameInfo == null) {
            QMLog.w(TAG, "Failed to attach game surface view, game info is null");
            return;
        }
        AppStateEvent.obtain(2031).notifyRuntime(this.mMiniAppContext);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_sdk_game_layout, viewGroup, false);
        this.mGameContainerView = viewGroup2;
        this.mGameSurfaceView = (SurfaceView) viewGroup2.findViewById(R.id.mini_sdk_game_layout_surface_view);
        viewGroup.addView(this.mGameContainerView, 0);
        QMLog.i(TAG, " createGameView width :" + this.mGameWidth + " height:" + this.mGameHeight);
    }

    private void attachNavigationBar(ViewGroup viewGroup) {
        boolean z16;
        if (viewGroup == null) {
            QMLog.w(TAG, "Failed to attach navigation bar, root view is null");
            return;
        }
        BaseGameNavigationBar baseGameNavigationBar = this.mNavigationBar;
        if (baseGameNavigationBar != null && baseGameNavigationBar.getParent() != null) {
            ((ViewGroup) this.mNavigationBar.getParent()).removeView(this.mNavigationBar);
        }
        if (this.mActivity != null) {
            if (isOrientationLandscape() && this.mActivity.getRequestedOrientation() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            BaseGameNavigationBar baseGameNavigationBar2 = this.mNavigationBar;
            if (baseGameNavigationBar2 != null) {
                ICapsuleButton capsuleButton = baseGameNavigationBar2.getCapsuleButton();
                if (capsuleButton instanceof CapsuleButton) {
                    ((CapsuleButton) capsuleButton).updateTopMargin(z16);
                }
            }
        }
        viewGroup.addView(this.mNavigationBar);
    }

    private void calcTargetWidthAndHeight() {
        boolean z16;
        int statusBarHeight;
        QMLog.i(TAG, "initGameUI start create game SurfaceView & inject preload js");
        if (this.mGameInfo.getOrientation() == GamePackage.Orientation.LANDSCAPE) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.mActivity.getResources().getDisplayMetrics().widthPixels;
        int i16 = this.mActivity.getResources().getDisplayMetrics().heightPixels;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        int i17 = displayMetrics.heightPixels;
        int i18 = displayMetrics.widthPixels;
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            if (Settings.Secure.getInt(this.mActivity.getContentResolver(), "display_notch_status", 0) == 1 && z16) {
                statusBarHeight = DisplayUtil.getStatusBarHeight(this.mActivity);
                i18 -= statusBarHeight;
            }
        } else if (str.equalsIgnoreCase("xiaomi") && Settings.Global.getInt(this.mActivity.getContentResolver(), "force_black", 0) == 1) {
            QMLog.i(TAG, "xiaomi has notch");
            if (z16) {
                statusBarHeight = DisplayUtil.getStatusBarHeight(this.mActivity);
                i18 -= statusBarHeight;
            } else {
                i17 -= DisplayUtil.getStatusBarHeight(this.mActivity);
            }
        }
        if ((z16 && i18 <= i17) || (!z16 && i17 <= i18)) {
            int i19 = i17;
            i17 = i18;
            i18 = i19;
        }
        this.mGameWidth = i18;
        this.mGameHeight = i17;
    }

    private void changeWindowInfo(final MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || this.mActivity == null || QUAUtil.isMicroApp()) {
            return;
        }
        if (miniAppInfo.isInternalApp()) {
            QMLog.i(TAG, "skip changeWindowInfo for InternalApp.");
        } else {
            final Activity activity = this.mActivity;
            ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.GamePage.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bitmap drawableToBitmap = ImageUtil.drawableToBitmap(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(activity, URLDecoder.decode(miniAppInfo.iconUrl), 0, 0, null));
                        if (drawableToBitmap != null) {
                            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(GamePage.this.mActivity.getResources(), drawableToBitmap);
                            create.setCornerRadius((int) (drawableToBitmap.getWidth() / 4.0f));
                            create.setAntiAlias(true);
                            GamePage.this.mActivity.setTaskDescription(new ActivityManager.TaskDescription(miniAppInfo.name, ImageUtil.drawableToBitmap(create)));
                            if (!drawableToBitmap.isRecycled()) {
                                drawableToBitmap.recycle();
                            }
                        }
                    } catch (Throwable th5) {
                        QMLog.e(GamePage.TAG, "changeWindowInfo exception.", th5);
                    }
                }
            });
        }
    }

    private void checkNavigationBarType(MiniAppInfo miniAppInfo) {
        BaseGameNavigationBar createCustomNavigationBar;
        String str;
        if (this.mNavigationBar != null && this.mMiniAppContext != null) {
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy == null) {
                createCustomNavigationBar = null;
            } else {
                createCustomNavigationBar = qQCustomizedProxy.createCustomNavigationBar(this.mMiniAppContext.getContext(), miniAppInfo);
            }
            if (createCustomNavigationBar == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkNavigationBarType, need recreate navigation bar, type is ");
            sb5.append(createCustomNavigationBar);
            sb5.append(", appid = ");
            if (miniAppInfo == null) {
                str = "null";
            } else {
                str = miniAppInfo.appId;
            }
            sb5.append(str);
            QMLog.d(TAG, sb5.toString());
            initNavigationBar(createCustomNavigationBar);
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                attachNavigationBar(viewGroup);
            }
        }
    }

    private BaseGameNavigationBar createNavigationBar(MiniAppInfo miniAppInfo) {
        boolean z16;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        BaseGameNavigationBar baseGameNavigationBar = null;
        if (iMiniAppContext != null && iMiniAppContext.getContext() != null) {
            Context context = this.mMiniAppContext.getContext();
            QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
            if (qQCustomizedProxy != null) {
                baseGameNavigationBar = qQCustomizedProxy.createCustomNavigationBar(context, miniAppInfo);
            }
            if (baseGameNavigationBar == null) {
                return new GameNavigationBar(context);
            }
            return baseGameNavigationBar;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("createNavigationBar failed, (mMiniAppContext == null) is ");
        if (this.mMiniAppContext == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QMLog.d(TAG, sb5.toString());
        return null;
    }

    private int dip2px(float f16) {
        return DisplayUtil.dip2px(this.mActivity, f16);
    }

    private Pair<Integer, Integer> getExpectedGameViewDimensions() {
        int i3;
        ViewGroup viewGroup = this.mGameContainerView;
        int i16 = 0;
        if (viewGroup != null) {
            i3 = viewGroup.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        ViewGroup viewGroup2 = this.mGameContainerView;
        if (viewGroup2 != null) {
            i16 = viewGroup2.getMeasuredHeight();
        }
        if (com.tencent.qqmini.minigame.utils.b.b(this.mActivity) && this.mGameSurfaceView != null) {
            return new Pair<>(Integer.valueOf(this.mGameSurfaceView.getWidth()), Integer.valueOf(this.mGameSurfaceView.getHeight()));
        }
        if ((isOrientationLandscape() && i16 > i3) || (!isOrientationLandscape() && i3 > i16)) {
            return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i3));
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initDebuggerLayout() {
        if (this.mDebuggerView == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px(140.0f), dip2px(25.0f));
            layoutParams.setMargins(0, dip2px(50.0f), dip2px(10.0f), 0);
            layoutParams.addRule(10, 1);
            layoutParams.addRule(11, 1);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.mini_sdk_game_debugger_layout, (ViewGroup) null);
            this.mDebuggerView = viewGroup;
            this.mRootView.addView(viewGroup, layoutParams);
            this.mDebuggerStatusTv = (TextView) this.mDebuggerView.findViewById(R.id.debugger_status_tv);
            TextView textView = (TextView) this.mDebuggerView.findViewById(R.id.debugger_end_btn);
            this.mDebuggerEndBtn = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.minigame.GamePage.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    DebugSocketAction.obtain(GamePage.this.mMiniAppContext).quitDebugSocket();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.mDebuggerLayer = new View(this.mActivity);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            this.mDebuggerLayer.setBackgroundColor(this.mActivity.getResources().getColor(R.color.mini_sdk_color_hei_trans_8));
            this.mRootView.addView(this.mDebuggerLayer, layoutParams2);
        }
    }

    private void initNavigationBar() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            QMLog.d(TAG, "createNavigationBar, miniAppContext is null");
        } else {
            initNavigationBar(createNavigationBar(iMiniAppContext.getMiniAppInfo()));
        }
    }

    private void initOrientation() {
        this.mTargetOrientation = this.mGameInfo.getOrientation();
    }

    private boolean isMonitorViewShowing() {
        MiniGameMonitorView miniGameMonitorView = this.mMiniAppMonitorInfoView;
        if (miniGameMonitorView != null && miniGameMonitorView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private void setStatusBar() {
        try {
            boolean optBoolean = new JSONObject(this.mGameInfo.getGameConfig()).optBoolean("showStatusBar", false);
            QMLog.i(TAG, "initGameUI game config showStatusBar=" + optBoolean);
            if (!optBoolean) {
                this.mActivity.getWindow().setFlags(1024, 1024);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "getStatusBar config error -->", e16);
        }
    }

    public void adjustViewForOrientation() {
        long j3;
        if (ViewUtils.isActivityInvalid(this.mActivity)) {
            return;
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            j3 = qQCustomizedProxy.getRequestLandscapeDelay(this.mActivity);
            QMLog.d(TAG, "adjustView: delay =" + j3);
        } else {
            j3 = 0;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.GamePage.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                Activity activity = GamePage.this.mActivity;
                if (ViewUtils.isActivityInvalid(activity)) {
                    return;
                }
                if (GamePage.this.mTargetOrientation == GamePackage.Orientation.LANDSCAPE && (activity.getRequestedOrientation() != 0 || activity.getResources().getConfiguration().orientation != 2)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QMLog.d(GamePage.TAG, "adjustView: toLandscape =" + z16 + ", orientation = " + activity.getRequestedOrientation());
                if (!z16) {
                    return;
                }
                if (GamePage.this.mNavigationBar != null) {
                    GamePage.this.mNavigationBar.requestLandscapeLayout();
                }
                activity.setRequestedOrientation(0);
            }
        }, j3);
    }

    public void checkPayForFriendLogic(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && !TextUtils.isEmpty(miniAppInfo.prepayId)) {
            View view = this.mPayForFriendView;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mPayForFriendView.getParent()).removeView(this.mPayForFriendView);
            }
            final PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
            View payForFriendView = payProxy.getPayForFriendView(this.mActivity, miniAppInfo.prepayId, miniAppInfo.appId, miniAppInfo.name, miniAppInfo.iconUrl, miniAppInfo.versionId, miniAppInfo.verType);
            this.mPayForFriendView = payForFriendView;
            if (payForFriendView != null) {
                this.mPayForFriendView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.mRootView.addView(this.mPayForFriendView);
                this.mPayForFriendView.setVisibility(0);
                this.mPayForFriendView.bringToFront();
                QMLog.d("PayForFriendView", "checkPayForFriendLogic show webview success");
                ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.minigame.GamePage.5
                    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                    public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                        PayProxy payProxy2;
                        if (i3 == 3004) {
                            if (GamePage.this.mPayForFriendView != null && (payProxy2 = payProxy) != null) {
                                payProxy2.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);", GamePage.this.mPayForFriendView);
                            }
                            ActivityResultManager.g().removeActivityResultListener(this);
                            return true;
                        }
                        return false;
                    }
                });
                return;
            }
            return;
        }
        QMLog.d("PayForFriendView", "checkPayForFriendLogic not payforfriend mode");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent) {
        if ("getMenuButtonBoundingClientRect".equals(nativeViewRequestEvent.event)) {
            return getMenuButtonBoundingClientRect(nativeViewRequestEvent);
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public ICapsuleButton getCapsuleButton() {
        BaseGameNavigationBar baseGameNavigationBar = this.mNavigationBar;
        if (baseGameNavigationBar != null) {
            return baseGameNavigationBar.getCapsuleButton();
        }
        return null;
    }

    public ViewGroup getGameContainerView() {
        return this.mGameContainerView;
    }

    public MiniGamePackage getGamePackage() {
        return this.mGameInfo;
    }

    public SurfaceView getGameSurfaceView() {
        return this.mGameSurfaceView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMenuButtonBoundingClientRect(NativeViewRequestEvent nativeViewRequestEvent) {
        Object capsuleButton = getCapsuleButton();
        if ((capsuleButton instanceof View) && this.mActivity != null) {
            View view = (View) capsuleButton;
            int width = (int) (view.getWidth() / DisplayUtil.getDensity(this.mActivity));
            int height = (int) (view.getHeight() / DisplayUtil.getDensity(this.mActivity));
            int left = (int) (view.getLeft() / DisplayUtil.getDensity(this.mActivity));
            int top = (int) (view.getTop() / DisplayUtil.getDensity(this.mActivity));
            int right = (int) (view.getRight() / DisplayUtil.getDensity(this.mActivity));
            int bottom = (int) (view.getBottom() / DisplayUtil.getDensity(this.mActivity));
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

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarTextStyle() {
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getNaviBarVisibility() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public AppPageInfo getPageInfo(int i3) {
        Pair<Integer, Integer> expectedGameViewDimensions = getExpectedGameViewDimensions();
        int intValue = ((Integer) expectedGameViewDimensions.first).intValue();
        return new AppPageInfo.Builder().setSurfaceViewWidth(intValue).setSurfaceViewHeight(((Integer) expectedGameViewDimensions.second).intValue()).setWindowWidth(this.mGameWidth).setWindowHeight(this.mGameHeight).build();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public String getPageOrientation() {
        MiniGamePkg miniGamePkg;
        GameInfoManager obtain = GetGameInfoManager.obtain(this.mMiniAppContext);
        if (obtain != null) {
            miniGamePkg = obtain.getMiniGamePkg();
        } else {
            miniGamePkg = null;
        }
        if (miniGamePkg != null) {
            return miniGamePkg.mGameConfigJson.f346445a;
        }
        return "portrait";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public int getTabBarVisibility() {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean hideLoading() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOrientationLandscape() {
        if (this.mTargetOrientation == GamePackage.Orientation.LANDSCAPE) {
            return true;
        }
        return false;
    }

    public void onAttachWindow(Activity activity, ViewGroup viewGroup) {
        this.mActivity = activity;
        this.mRootView = viewGroup;
        initOrientation();
        setStatusBar();
        this.vConsoleManager.h(viewGroup, this.mMiniAppContext);
        attachNavigationBar(viewGroup);
        attachGameSurfaceView(viewGroup);
        calcTargetWidthAndHeight();
    }

    public void onCreate(MiniAppInfo miniAppInfo) {
        this.mGameInfo = MiniGamePackageManager.createGamePackage(this.mMiniAppContext);
        checkNavigationBarType(miniAppInfo);
    }

    public void onDestroy() {
        this.mCustomButtonManager = null;
        FloatDragAdManager floatDragAdManager = this.mFloatDragAdManager;
        if (floatDragAdManager != null) {
            floatDragAdManager.removeDragAd();
            this.mFloatDragAdManager = null;
        }
        PendantManager pendantManager = this.mPendantManager;
        if (pendantManager != null) {
            pendantManager.removePendantAd();
            this.mPendantManager = null;
        }
        this.vConsoleManager.l();
    }

    public void onDetachWindow(Activity activity) {
        QMLog.i(TAG, "GamePage onDetachWindow call!");
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.mActivity = null;
        this.mRootView = null;
        this.mGameContainerView = null;
        this.mGameSurfaceView = null;
    }

    public void onResume(MiniAppInfo miniAppInfo) {
        changeWindowInfo(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateCustomButton(String str, long j3, JSONObject jSONObject, View.OnClickListener onClickListener) {
        String str2;
        if (this.mCustomButtonManager == null) {
            Activity activity = this.mActivity;
            ViewGroup viewGroup = this.mRootView;
            MiniGamePackage miniGamePackage = this.mGameInfo;
            if (miniGamePackage != null) {
                str2 = miniGamePackage.getId();
            } else {
                str2 = "";
            }
            this.mCustomButtonManager = new CustomButtonManager(activity, viewGroup, str2, DisplayUtil.getDensity(this.mActivity));
        }
        if (OperateCustomButton.OPERATE_CREATE.equals(str)) {
            return this.mCustomButtonManager.createCustomButton(jSONObject, onClickListener);
        }
        if ("show".equals(str)) {
            return this.mCustomButtonManager.setCustomButtonVisible(j3, true);
        }
        if ("hide".equals(str)) {
            return this.mCustomButtonManager.setCustomButtonVisible(j3, false);
        }
        if ("destroy".equals(str)) {
            return this.mCustomButtonManager.destroyCustomButton(j3);
        }
        if (!"update".equals(str)) {
            return false;
        }
        return this.mCustomButtonManager.updateCustomButton(jSONObject, onClickListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operateFloatDragAd(String str, FloatDragAdInfo floatDragAdInfo) {
        FloatDragAdManager floatDragAdManager;
        if ("add".equals(str)) {
            if (this.mFloatDragAdManager == null) {
                this.mFloatDragAdManager = new FloatDragAdManager(this.mActivity, this.mMiniAppContext, this.mRootView);
            }
            return this.mFloatDragAdManager.showDragAd(floatDragAdInfo);
        }
        if ("remove".equals(str) && (floatDragAdManager = this.mFloatDragAdManager) != null) {
            return floatDragAdManager.removeDragAd();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean operatePendantAd(String str, PendantAdInfo pendantAdInfo) {
        PendantManager pendantManager;
        if ("add".equals(str)) {
            if (this.mPendantManager == null) {
                this.mPendantManager = new PendantManager(this.mActivity, this.mMiniAppContext, this.mRootView);
            }
            return this.mPendantManager.showPendantAd(pendantAdInfo);
        }
        if ("remove".equals(str) && (pendantManager = this.mPendantManager) != null) {
            return pendantManager.removePendantAd();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean setMiniAIOEntranceVisible(boolean z16, JSONObject jSONObject) {
        return false;
    }

    public void setUnderGameView(boolean z16) {
        if (this.mGameSurfaceView == null) {
            QMLog.e(TAG, "setUnderGameView: mGameSurfaceView is null. isUnderGameView=" + z16);
            return;
        }
        QMLog.d(TAG, "setUnderGameView isUnderGameView=" + z16);
        this.mGameSurfaceView.setZOrderMediaOverlay(true);
        if (z16) {
            this.mGameSurfaceView.getHolder().setFormat(-2);
        } else {
            this.mGameSurfaceView.getHolder().setFormat(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showKingCardTips() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || getCapsuleButton() == null) {
            return;
        }
        ((KingCardProxy) ProxyManager.get(KingCardProxy.class)).showKingCardTips(this.mMiniAppContext, getCapsuleButton().getMoreView());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean showLoading() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public boolean toggleDebugPanel() {
        MiniAppInfo miniAppInfo;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
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
        if (this.mRootView != null) {
            MiniGameMonitorView miniGameMonitorView = this.mMiniAppMonitorInfoView;
            if (miniGameMonitorView == null) {
                this.mMiniAppMonitorInfoView = new MiniGameMonitorView(this.mActivity);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 53;
                this.mRootView.addView(this.mMiniAppMonitorInfoView, layoutParams);
                this.mMiniAppMonitorInfoView.setVisibility(0);
                this.mMiniAppMonitorInfoView.a();
            } else if (miniGameMonitorView.getVisibility() == 0) {
                this.mMiniAppMonitorInfoView.b();
                this.mMiniAppMonitorInfoView.setVisibility(8);
            } else {
                this.mMiniAppMonitorInfoView.a();
                this.mMiniAppMonitorInfoView.setVisibility(0);
            }
        }
        return isMonitorViewShowing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateDebuggerStatus(final String str, final String str2, final boolean z16) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.GamePage.3
            @Override // java.lang.Runnable
            public void run() {
                GamePage.this.initDebuggerLayout();
                if (GamePage.this.mDebuggerStatusTv != null && !TextUtils.isEmpty(str)) {
                    GamePage.this.mDebuggerStatusTv.setText(str);
                }
                int i3 = 0;
                if (!TextUtils.isEmpty(str2)) {
                    MiniToast.makeText(GamePage.this.mActivity, str2, 0).show();
                }
                if (GamePage.this.mDebuggerLayer != null) {
                    View view = GamePage.this.mDebuggerLayer;
                    if (!z16) {
                        i3 = 8;
                    }
                    view.setVisibility(i3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateMonitorFPSText(float f16, long j3) {
        if (isMonitorViewShowing()) {
            this.mMiniAppMonitorInfoView.d(f16, j3);
        }
    }

    @Override // com.tencent.qqmini.sdk.core.Preloadable
    public void init(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
        initNavigationBar();
    }

    private void initNavigationBar(BaseGameNavigationBar baseGameNavigationBar) {
        if (baseGameNavigationBar == null) {
            return;
        }
        this.mNavigationBar = baseGameNavigationBar;
        baseGameNavigationBar.setContentDescription(QzoneConfig.MAIN_KEY_NAVIGATOR_BAR);
        this.mNavigationBar.setId(R.id.mini_sdk_navigation_bar);
        this.mNavigationBar.attachMiniAppContext(this.mMiniAppContext);
        this.mNavigationBar.setWindowInfo(GameNavigationBar.fakeWindowInfo());
    }

    public void onPause() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void hideSoftInput(View view) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setNaviVisibility(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void setTabBarVisibility(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IPage
    public void dispatchEventToWebView(String str, String str2, int[] iArr) {
    }
}
