package com.tencent.mobileqq.minigame.publicaccount;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator;
import com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes33.dex */
public class MiniGamePublicAccountWebFragment extends PublicBaseFragment implements View.OnClickListener {
    public static final String EMPTY_IMG_URL = "https://sola.gtimg.cn/aoi/sola/20200717141546_FIOiVDF9l3.png";
    private static final int GAME_STORE_HEIGHT = 0;
    private static final int MORE_MSG_MARGIN = 20;
    public static final String TAG = "MiniGamePublicAccountWebFragment";
    public URLImageView emptyImage;
    public LinearLayout emptyLayout;
    public long enterQQGamePubTime;
    public MiniGamePublicAccountHeadLayout headLayout;
    public View headerLayoutBg;
    public long initUiTime;
    public long initWebViewTime;
    public View layoutTitleBar;
    public LinearLayout loadLayout;
    public long loadUrlEndTime;
    private GestureDetector mGestureDetector;
    public MiniGamePublicAccountViewPagerIndicator mIndicator;
    private List<QQGameMsgInfo> mMsgInfoList;
    public TextView moreMsgBtn;
    public RelativeLayout moreMsgLayout;
    public TextView moreMsgText;
    public TextView navTitle;
    public BaseHeaderAdapter pagerAdapter;
    public LinearLayout pagerContainer;
    public long parsePageEndTime;
    public View rootView;
    public MiniGamePublicAccountNavBar titleBar;
    public MiniGamePubViewpager viewPager;
    public MiniGamePublicAccountWebView webView;
    private MiniGamePublicAccountWebViewBuilder webViewBuilder;
    public long startTime = 0;
    private List<Boolean> exposeReported = new ArrayList();
    private MiniGamePublicAccountUIController mUiController = new MiniGamePublicAccountUIController(this);
    private EIPCResultCallback getMsgCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1
        @Override // eipc.EIPCResultCallback
        public void onCallback(final EIPCResult eIPCResult) {
            MiniGamePublicAccountWebFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle;
                    EIPCResult eIPCResult2 = eIPCResult;
                    if (eIPCResult2.code == 0 && (bundle = eIPCResult2.data) != null) {
                        MiniGamePublicAccountWebFragment.this.mMsgInfoList = (List) bundle.getSerializable(MiniGamePublicAccountIPCModule.KEY_MSG_LIST);
                        if (MiniGamePublicAccountWebFragment.this.mMsgInfoList == null) {
                            MiniGamePublicAccountWebFragment.this.mMsgInfoList = new ArrayList();
                        }
                    }
                    if (MiniGamePublicAccountWebFragment.this.mMsgInfoList == null) {
                        return;
                    }
                    int size = MiniGamePublicAccountWebFragment.this.mMsgInfoList.size();
                    if (size > 0) {
                        MiniGamePublicAccountWebFragment.this.emptyLayout.setVisibility(8);
                        MiniGamePublicAccountWebFragment.this.pagerContainer.setVisibility(0);
                        MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment = MiniGamePublicAccountWebFragment.this;
                        miniGamePublicAccountWebFragment.notifyWebHeaderHeight(miniGamePublicAccountWebFragment.getWebHeaderHeight());
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_more", "expo", null, null, null);
                        MiniGamePublicAccountWebFragment.this.exposeReported = new ArrayList(Collections.nCopies(size, Boolean.FALSE));
                        MiniGamePublicAccountWebFragment.this.refreshHead(0);
                        MiniGamePublicAccountWebFragment.this.webView.loadUrl(QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_WEB_URL, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_WEB_URL));
                        MiniGamePublicAccountWebFragment.this.reportMsgExpose(0, false);
                        return;
                    }
                    MiniGamePublicAccountWebFragment.this.pagerContainer.setVisibility(8);
                    MiniGamePublicAccountWebFragment.this.emptyLayout.setVisibility(0);
                    MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment2 = MiniGamePublicAccountWebFragment.this;
                    miniGamePublicAccountWebFragment2.notifyWebHeaderHeight(miniGamePublicAccountWebFragment2.getWebHeaderHeight());
                }
            });
        }
    };

    private boolean checkTianshuData(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("xmodal");
            if ((optJSONObject2 == null && (optJSONObject2 = jSONObject.optJSONObject("notification")) == null) || !optJSONObject2.optBoolean("isFromPublicLandingPage", false) || (optJSONObject = optJSONObject2.optJSONObject("tianshuAdData")) == null || TextUtils.isEmpty(optJSONObject.optString("adId"))) {
                return false;
            }
            return !TextUtils.isEmpty(optJSONObject.optString("appid"));
        } catch (JSONException unused) {
            return false;
        }
    }

    private void getGameMsgList() {
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_GET_MINI_GAME_PUBLIC_MSG, null, this.getMsgCallback);
    }

    private AppInterface getToolAppRuntime() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWebHeaderHeight() {
        LinearLayout linearLayout;
        if (getActivity() == null || !isAdded()) {
            return 0;
        }
        if (this.pagerContainer.getVisibility() == 0) {
            linearLayout = this.pagerContainer;
        } else {
            linearLayout = this.emptyLayout;
        }
        return (int) (0 + BaseAIOUtils.l(linearLayout.getMeasuredHeight() + this.moreMsgLayout.getMeasuredHeight(), getResources()) + 20.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoAccountDetail() {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putString("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
        activityURIRequest.extra().putBoolean("fromMiniGamePub", true);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDefaultLoading() {
        LinearLayout linearLayout = this.loadLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        TextView textView = new TextView(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = BaseAIOUtils.f(7.0f, getActivity().getResources());
        textView.setText(HardCodeUtil.qqStr(R.string.qqr));
        textView.setTextColor(HWColorFormat.COLOR_FormatVendorStartUnused);
        ImageView imageView = new ImageView(getActivity());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = getActivity().getResources().getDrawable(R.drawable.fos);
        obtain.mLoadingDrawable = getActivity().getResources().getDrawable(R.drawable.fos);
        imageView.setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.HEAD_REFRESH, obtain));
        imageView.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        imageView.startAnimation(rotateAnimation);
        this.loadLayout.addView(imageView, new LinearLayout.LayoutParams(BaseAIOUtils.f(15.0f, getActivity().getResources()), BaseAIOUtils.f(15.0f, getActivity().getResources())));
        this.loadLayout.addView(textView, layoutParams);
    }

    private void initLoad(final View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.heightPixels;
        try {
            this.loadLayout = (LinearLayout) view.findViewById(R.id.rev);
            int f16 = BaseAIOUtils.f(418.0f, getActivity().getResources());
            ViewGroup.LayoutParams layoutParams = this.loadLayout.getLayoutParams();
            layoutParams.height = BaseAIOUtils.f(i3 - f16, getActivity().getResources());
            this.loadLayout.setLayoutParams(layoutParams);
            IPreloadServiceProxy iPreloadServiceProxy = (IPreloadServiceProxy) BaseApplicationImpl.getApplication().peekAppRuntime().getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI);
            if (TextUtils.isEmpty(com.tencent.mobileqq.qwallet.preload.a.j(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, false, 0).filePath)) {
                handleDefaultLoading();
                iPreloadServiceProxy.getResPath(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, new IPreloadService.c() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.3
                    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                    public void onResult(int i16, IPreloadService.PathResult pathResult) {
                        if (i16 != 0 || TextUtils.isEmpty(pathResult.folderPath)) {
                            return;
                        }
                        QLog.d(MiniGamePublicAccountWebFragment.TAG, 1, "loading apng download succ!");
                    }
                });
            } else {
                iPreloadServiceProxy.getResPath(MiniGamePublicAccountConst.QQGAME_WEB_LOADING_APNG, new IPreloadService.c() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4
                    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                    public void onResult(final int i16, final IPreloadService.PathResult pathResult) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (i16 != 0 || TextUtils.isEmpty(pathResult.filePath)) {
                                    MiniGamePublicAccountWebFragment.this.handleDefaultLoading();
                                    return;
                                }
                                Drawable drawableForWallet = ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(pathResult.filePath, null, null);
                                if (drawableForWallet == null) {
                                    MiniGamePublicAccountWebFragment.this.handleDefaultLoading();
                                } else {
                                    ((ImageView) view.findViewById(R.id.f163676re3)).setImageDrawable(drawableForWallet);
                                }
                            }
                        });
                    }
                });
            }
        } catch (Exception unused) {
            this.loadLayout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshHead(final int i3) {
        BaseHeaderAdapter baseHeaderAdapter = this.pagerAdapter;
        if (baseHeaderAdapter != null) {
            baseHeaderAdapter.setData(this.mMsgInfoList);
            this.mIndicator.refreshIndicator();
            if (i3 != -1) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.9
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniGamePubViewpager miniGamePubViewpager;
                        if (MiniGamePublicAccountWebFragment.this.getActivity() == null || MiniGamePublicAccountWebFragment.this.getActivity().isFinishing() || (miniGamePubViewpager = MiniGamePublicAccountWebFragment.this.viewPager) == null) {
                            return;
                        }
                        miniGamePubViewpager.setCurrentItem(i3);
                    }
                }, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBrowsetTime() {
        if (this.startTime < 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTime;
        if (elapsedRealtime > 0) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "period", String.valueOf(elapsedRealtime), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMsgExpose(int i3, boolean z16) {
        QQGameMsgInfo qQGameMsgInfo = i3 < this.mMsgInfoList.size() ? this.mMsgInfoList.get(i3) : null;
        if (qQGameMsgInfo == null || this.exposeReported.get(i3).booleanValue()) {
            return;
        }
        this.exposeReported.set(i3, Boolean.TRUE);
        if (z16) {
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(qQGameMsgInfo.arkAppName, "", "msg_expose", qQGameMsgInfo.arkMetaList);
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_ark_test", "expo", qQGameMsgInfo.advId, null, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void initTitleEvent() {
        this.mGestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.navTitle.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return MiniGamePublicAccountWebFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public long initWebView() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.webView == null) {
            this.webView = new MiniGamePublicAccountWebView(getActivity());
        }
        MiniGamePublicAccountWebViewBuilder miniGamePublicAccountWebViewBuilder = new MiniGamePublicAccountWebViewBuilder(getActivity(), getActivity(), getToolAppRuntime(), this.webView) { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.5
            @Override // com.tencent.mobileqq.qqgamepub.web.c, com.tencent.mobileqq.webview.AbsWebView
            public void onPageFinished(WebView webView, String str) {
                MiniGamePublicAccountWebFragment.this.parsePageEndTime = SystemClock.elapsedRealtime();
                super.onPageFinished(webView, str);
                MiniGamePublicAccountWebFragment.this.webView.setVisibility(0);
                LinearLayout linearLayout = MiniGamePublicAccountWebFragment.this.loadLayout;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                MiniGamePublicAccountWebFragment.this.notifyWebHeaderHeight(MiniGamePublicAccountWebFragment.this.getWebHeaderHeight());
            }

            @Override // com.tencent.mobileqq.qqgamepub.web.c, com.tencent.mobileqq.webview.AbsWebView
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                MiniGamePublicAccountWebFragment.this.loadUrlEndTime = SystemClock.elapsedRealtime();
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.tencent.mobileqq.webview.AbsWebView
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        };
        this.webViewBuilder = miniGamePublicAccountWebViewBuilder;
        miniGamePublicAccountWebViewBuilder.setTimeBeforeLoadUrl(System.currentTimeMillis());
        new m(this.webViewBuilder).a(null, getToolAppRuntime(), null);
        MiniGamePublicAccountWebView miniGamePublicAccountWebView = (MiniGamePublicAccountWebView) this.webViewBuilder.getWebView();
        this.webView = miniGamePublicAccountWebView;
        miniGamePublicAccountWebView.setWillNotCacheDrawing(false);
        this.webView.setDrawingCacheEnabled(true);
        if (getActivity() != null && getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("ignoreLoginWeb", true);
        }
        return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    public void notifyWebHeaderHeight(int i3) {
        WebViewPluginEngine pluginEngine;
        try {
            MiniGamePublicAccountWebView miniGamePublicAccountWebView = this.webView;
            if (miniGamePublicAccountWebView == null || (pluginEngine = miniGamePublicAccountWebView.getPluginEngine()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            if (i3 != -1) {
                hashMap.put("height", Integer.valueOf(i3));
            }
            pluginEngine.s(this.webView.getUrl(), 8589934624L, hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "notify web error", th5);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        reportBrowsetTime();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.f163705rk2) {
            return;
        }
        enterAIO(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.startTime = SystemClock.elapsedRealtime();
        getGameMsgList();
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("startTime")) {
            long longExtra = getActivity().getIntent().getLongExtra("startTime", 0L);
            if (longExtra > 0) {
                this.enterQQGamePubTime = SystemClock.elapsedRealtime() - longExtra;
            }
        }
        View inflate = layoutInflater.inflate(R.layout.dka, viewGroup, false);
        this.rootView = inflate.findViewById(R.id.f163711rl3);
        initHead(inflate);
        this.initUiTime = SystemClock.elapsedRealtime() - this.startTime;
        this.initWebViewTime = initWebView();
        initTitle(inflate);
        initLoad(inflate);
        this.mUiController.setupStrategy();
        this.mUiController.initGameCenter(getActivity(), this.rootView, this.webView);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseHeaderAdapter baseHeaderAdapter = this.pagerAdapter;
        if (baseHeaderAdapter != null) {
            baseHeaderAdapter.onDestroy();
        }
        MiniGamePublicAccountWebViewBuilder miniGamePublicAccountWebViewBuilder = this.webViewBuilder;
        if (miniGamePublicAccountWebViewBuilder != null) {
            miniGamePublicAccountWebViewBuilder.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        BaseHeaderAdapter baseHeaderAdapter = this.pagerAdapter;
        if (baseHeaderAdapter != null) {
            baseHeaderAdapter.onDestroyView();
        }
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MiniGamePublicAccountWebViewBuilder miniGamePublicAccountWebViewBuilder = this.webViewBuilder;
        if (miniGamePublicAccountWebViewBuilder != null) {
            miniGamePublicAccountWebViewBuilder.onPause();
        }
        BaseHeaderAdapter baseHeaderAdapter = this.pagerAdapter;
        if (baseHeaderAdapter != null) {
            baseHeaderAdapter.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MiniGamePublicAccountWebViewBuilder miniGamePublicAccountWebViewBuilder = this.webViewBuilder;
        if (miniGamePublicAccountWebViewBuilder != null) {
            miniGamePublicAccountWebViewBuilder.onResume();
        }
        BaseHeaderAdapter baseHeaderAdapter = this.pagerAdapter;
        if (baseHeaderAdapter != null) {
            baseHeaderAdapter.onResume();
        }
        try {
            int size = this.mMsgInfoList.size();
            MiniGamePubViewpager miniGamePubViewpager = this.viewPager;
            if (miniGamePubViewpager != null && size > 0 && miniGamePubViewpager.getCurrentItem() == size) {
                this.viewPager.setCurrentItem(size - 1);
            }
        } catch (Throwable th5) {
            QLog.w(TAG, 1, "onResume catch: ", th5);
        }
        QIPCClientHelper.getInstance().callServer("MiniGamePublicAccountIPCModule", MiniGamePublicAccountIPCModule.ACTION_DO_ON_RESUME, null, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    static {
        l91.a.c(true);
        l91.a.a();
    }

    public void enterAIO(boolean z16) {
        try {
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(getActivity()));
            Intent m3 = BaseAIOUtils.m(intent, new int[]{1});
            m3.putExtra("shouldreport", true);
            m3.putExtra("has_unread_msg", false);
            m3.putExtra("jump_from", 1);
            m3.setClass(getActivity(), ChatActivity.class);
            m3.putExtra("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
            m3.putExtra("uintype", 1008);
            m3.putExtra("uinname", getString(R.string.f167742dr));
            m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
            m3.putExtra("aio_msg_source", 0);
            getActivity().startActivity(m3);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_news_more", "click", null, null, null);
            if (z16) {
                getActivity().finish();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "enterAIO error", th5);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private void initHead(View view) {
        this.headLayout = (MiniGamePublicAccountHeadLayout) view.findViewById(R.id.rkq);
        this.webView = (MiniGamePublicAccountWebView) view.findViewById(R.id.rkr);
        this.headLayout.attachToRootView();
        this.webView.attachHeaderView(this.headLayout);
        this.pagerContainer = (LinearLayout) this.headLayout.findViewById(R.id.rel);
        this.viewPager = (MiniGamePubViewpager) this.headLayout.findViewById(R.id.rdk);
        this.mIndicator = (MiniGamePublicAccountViewPagerIndicator) this.headLayout.findViewById(R.id.rka);
        this.moreMsgText = (TextView) this.headLayout.findViewById(R.id.f163707rk4);
        this.moreMsgBtn = (TextView) this.headLayout.findViewById(R.id.f163705rk2);
        this.moreMsgLayout = (RelativeLayout) this.headLayout.findViewById(R.id.f163706rk3);
        this.emptyLayout = (LinearLayout) this.headLayout.findViewById(R.id.rdh);
        this.emptyImage = (URLImageView) this.headLayout.findViewById(R.id.rdi);
        this.headerLayoutBg = this.headLayout.findViewById(R.id.rdt);
        this.moreMsgBtn.setOnClickListener(this);
        this.emptyImage.setBackgroundURL(EMPTY_IMG_URL);
        BaseHeaderAdapter createAdapter = this.mUiController.createAdapter(getActivity());
        this.pagerAdapter = createAdapter;
        this.viewPager.setAdapter(createAdapter);
        this.viewPager.setOffscreenPageLimit(3);
        this.mIndicator.setViewPager(this.viewPager);
        this.mIndicator.setIndicatorViewConfig(this.mUiController.getIndicatorViewConfig());
        this.mIndicator.refreshIndicator();
        this.mIndicator.setOnPageSelectedListener(new MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.2
            @Override // com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener
            public void onPageSelected(int i3) {
                MiniGamePublicAccountWebFragment.this.pagerAdapter.initArk(i3);
                MiniGamePublicAccountWebFragment.this.reportMsgExpose(i3, false);
            }
        });
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "expo", null, null, null);
    }

    public void initTitle(View view) {
        this.layoutTitleBar = view.findViewById(R.id.rem);
        MiniGamePublicAccountNavBar miniGamePublicAccountNavBar = (MiniGamePublicAccountNavBar) view.findViewById(R.id.f163708rl0);
        this.titleBar = miniGamePublicAccountNavBar;
        miniGamePublicAccountNavBar.setTitleBarTransparent();
        TextView titleTextView = this.titleBar.getTitleTextView();
        this.navTitle = titleTextView;
        titleTextView.setText(R.string.f167742dr);
        this.navTitle.setTextColor(-1);
        this.titleBar.setOnItemSelectListener(new com.tencent.mobileqq.widget.navbar.a() { // from class: com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.6
            @Override // com.tencent.mobileqq.widget.navbar.a
            public void onItemSelect(View view2, int i3) {
                if (i3 == 5) {
                    MiniGamePublicAccountWebFragment.this.gotoAccountDetail();
                } else if (i3 == 1) {
                    MiniGamePublicAccountWebFragment.this.reportBrowsetTime();
                    MiniGamePublicAccountWebFragment.this.getActivity().finish();
                }
            }

            public void onItemLonClick(View view2, int i3) {
            }
        });
        initTitleEvent();
    }
}
