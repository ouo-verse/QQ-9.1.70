package com.tencent.mobileqq.mini.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdReportHelper;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLoadingAdLayout extends RelativeLayout {
    public static final String AD_REF_ID = "biz_src_miniappD";
    public static final int FULL_SCREEN_TYPE = 0;
    private static final int MINI_LOADING_AD_ACTIVITY_RESULT_CODE = 7777;
    private static final int MIN_SWIPE_UP_OFFSET = 150;
    public static final int ONLY_BUTTON_TYPE = 1;
    public static final int ONLY_SLIDE_ARROW_TYPE = 4;
    private static final String SLIDE_AD_ARROW_URL = "https://business-ad.cdn-go.cn/cdn-website/latest/public/ad/motvie_arrow.png";
    private static final String SLIDE_AD_FINGER_URL = "https://business-ad.cdn-go.cn/cdn-website/latest/public/ad/motvie_finger.png";
    private static final int SLIDE_ANIMATION_DURATION = 700;
    public static final int SLIDE_ARROW_TYPE = 3;
    public static final int SLIDE_FINGER_TYPE = 2;
    private static final String SLIDE_UP_TEXT = "\u5411\u4e0a\u6ed1\u52a8";
    private static final String TAG = "MiniLoadingAdLayout";
    private boolean autoDownload;
    private int countdownTime;
    private float densityDpi;
    private int lastTouchDownX;
    private int lastTouchDownY;
    private int lastTouchUpX;
    private int lastTouchUpY;
    private GdtAd mAdInfo;
    private RelativeLayout mAppLayout;
    private ImageView mAppLogoView;
    private TextView mAppNameView;
    private ImageView mCountdownContainerBg;
    private Runnable mCountdownRunnable;
    private TextView mCountdownTextView;
    private TextView mDeveloperDescView;
    private OnDismissListener mDismissListener;
    private RelativeLayout mGameLayout;
    private ImageView mGameLogoView;
    private TextView mGameNameView;
    private TextView mGamePublicationInfoFirstLineView;
    private TextView mGamePublicationInfoSecondLineView;
    private ImageView mLoadingAdBar;
    private FrameLayout mLoadingAdBottomLayoutContainer;
    private ImageView mLoadingAdImgView;
    private TextView mLoadingAdSkipBtn;
    private ImageView mLoadingAdSlideIcon;
    private ImageView mLoadingAdSlideLight;
    private View mLoadingAdSlideMask;
    private TextView mLoadingAdSlideText;
    private View mLoadingAdSlideView;
    private TextView mLoadingAdTextView;
    private RelativeLayout mLoadingSlideAdBar;
    private float mTouchLastY;
    private int mUIType;
    private Handler mUiHandler;
    private ISuperPlayer mVideoPlayer;
    private View mVideoView;
    private MiniAppInfo miniAppInfo;
    private long pressInterval;
    private long showAdStamp;
    private int showSkipTime;
    private long touchStamp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class LoadingAdOnClickListener implements View.OnClickListener {
        public static final int TYPE_CLICK_BAR = 1;
        public static final int TYPE_CLICK_IMG = 0;
        private AdProxy.ILoadingAdListener loadingAdListener;
        private int type;

        public LoadingAdOnClickListener(int i3, AdProxy.ILoadingAdListener iLoadingAdListener) {
            this.type = i3;
            this.loadingAdListener = iLoadingAdListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (MiniLoadingAdLayout.this.mAdInfo != null) {
                str = MiniLoadingAdLayout.this.mAdInfo.getTraceId();
            } else {
                str = "";
            }
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_AD_CLICK, MiniLoadingAdLayout.this.miniAppInfo, str);
            MiniLoadingAdLayout.this.handleAdClick();
            AdProxy.ILoadingAdListener iLoadingAdListener = this.loadingAdListener;
            if (iLoadingAdListener != null) {
                iLoadingAdListener.onAdClick(this.type);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnDismissListener {
        void onDismiss(boolean z16);
    }

    public MiniLoadingAdLayout(Context context) {
        super(context);
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
        this.countdownTime = config;
        this.showSkipTime = config - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 0);
        this.autoDownload = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.densityDpi = 1.0f;
    }

    private void adjustUI(boolean z16, String str, String str2, String str3, String str4, AdProxy.ILoadingAdListener iLoadingAdListener) {
        ImageView imageView;
        TextView textView;
        ImageView.ScaleType scaleType;
        if (TextUtils.isEmpty(str3)) {
            str3 = HardCodeUtil.qqStr(R.string.f169852xz0);
        }
        if (AdUtils.isFolderScreenOpenMode(getContext())) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.rew);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) constraintLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = wr0.a.f446116a.b(QidPagView.DESIGN_PAG_WIDTH);
                layoutParams.gravity = 1;
                constraintLayout.setLayoutParams(layoutParams);
            }
        }
        try {
            Drawable createFromPath = Drawable.createFromPath(str4);
            if (createFromPath != null) {
                ImageView imageView2 = this.mLoadingAdImgView;
                if (createFromPath.getIntrinsicWidth() < createFromPath.getIntrinsicHeight()) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                } else {
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                }
                imageView2.setScaleType(scaleType);
            }
            this.mLoadingAdImgView.setImageDrawable(createFromPath);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "create image drawable fail " + e16);
            this.mLoadingAdImgView.setImageDrawable(null);
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        int parseColor = isNowThemeIsNight ? -1 : Color.parseColor("#333333");
        int i3 = isNowThemeIsNight ? -16777216 : -1;
        ((FrameLayout) findViewById(R.id.rez)).setBackgroundColor(i3);
        this.mLoadingAdBottomLayoutContainer.setBackgroundColor(i3);
        this.mCountdownTextView.setText(this.countdownTime + "\u79d2");
        if (TextUtils.isEmpty(str3)) {
            str3 = HardCodeUtil.qqStr(R.string.f169852xz0);
        }
        this.mDeveloperDescView.setText(HardCodeUtil.qqStr(R.string.xzi) + str3 + HardCodeUtil.qqStr(R.string.xzh));
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mCountdownContainerBg.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ImmersiveUtils.getStatusBarHeight(getContext()) + DisplayUtil.dip2px(getContext(), 10.0f);
        if (z16) {
            RelativeLayout relativeLayout = (RelativeLayout) ((ViewStub) findViewById(R.id.f163698rj0)).inflate();
            this.mGameLayout = relativeLayout;
            TextView textView2 = (TextView) relativeLayout.findViewById(R.id.f163699rj1);
            this.mGameNameView = textView2;
            textView2.setTextColor(parseColor);
            imageView = (ImageView) this.mGameLayout.findViewById(R.id.rix);
            this.mGameLogoView = imageView;
            textView = this.mGameNameView;
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) ((ViewStub) findViewById(R.id.rio)).inflate();
            this.mAppLayout = relativeLayout2;
            TextView textView3 = (TextView) relativeLayout2.findViewById(R.id.rip);
            this.mAppNameView = textView3;
            textView3.setTextColor(parseColor);
            imageView = (ImageView) this.mAppLayout.findViewById(R.id.rim);
            this.mAppLogoView = imageView;
            textView = this.mAppNameView;
        }
        this.mCountdownContainerBg.setLayoutParams(layoutParams2);
        textView.setText(str);
        imageView.setImageDrawable(MiniAppUtils.getIcon(getContext(), str2, true, 10));
        if (this.mUIType == 0) {
            setOnClickListener(new LoadingAdOnClickListener(0, iLoadingAdListener));
            this.mLoadingAdBottomLayoutContainer.setOnClickListener(new LoadingAdOnClickListener(1, iLoadingAdListener));
            this.mLoadingAdBar.setOnClickListener(new LoadingAdOnClickListener(1, iLoadingAdListener));
        } else {
            this.mLoadingAdBar.setOnClickListener(new LoadingAdOnClickListener(1, iLoadingAdListener));
        }
        int i16 = this.mUIType;
        if (i16 == 2 || i16 == 3 || i16 == 4) {
            if (i16 != 4) {
                this.mLoadingSlideAdBar.setOnClickListener(new LoadingAdOnClickListener(1, iLoadingAdListener));
            }
            initSlideEvent();
        }
    }

    private JSONObject createLoadingAntiParamForClickCGI(MiniAppInfo miniAppInfo) {
        JSONObject createLoadingAntiParamForExpoCGI = createLoadingAntiParamForExpoCGI(miniAppInfo);
        if (createLoadingAntiParamForExpoCGI == null) {
            try {
                createLoadingAntiParamForExpoCGI = new JSONObject();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "createLoadingAntiParamForClickCGI failed", e16);
            }
        }
        createLoadingAntiParamForExpoCGI.put("aa", String.valueOf(this.lastTouchDownX));
        createLoadingAntiParamForExpoCGI.put("ab", String.valueOf(this.lastTouchDownY));
        createLoadingAntiParamForExpoCGI.put("ba", String.valueOf(this.lastTouchUpX));
        createLoadingAntiParamForExpoCGI.put("bb", String.valueOf(this.lastTouchUpY));
        createLoadingAntiParamForExpoCGI.put("g", String.valueOf(this.pressInterval));
        return createLoadingAntiParamForExpoCGI;
    }

    private JSONObject createLoadingAntiParamForExpoCGI(MiniAppInfo miniAppInfo) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                int screenWidth = DisplayHelper.getScreenWidth(getContext());
                int screenHeight = DisplayHelper.getScreenHeight(getContext());
                jSONObject2.put("da", String.valueOf((int) (screenWidth / this.densityDpi)));
                jSONObject2.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf((int) (screenHeight / this.densityDpi)));
                jSONObject2.put("px", "0");
                jSONObject2.put("py", "0");
                jSONObject2.put(HippyTKDListViewAdapter.X, "0");
                return jSONObject2;
            } catch (Exception e16) {
                e = e16;
                jSONObject = jSONObject2;
                QLog.e(TAG, 1, "createLoadingAntiParamForExpoCGI failed", e);
                return jSONObject;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick() {
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = 11;
        params.activity = new WeakReference<>((Activity) getContext());
        params.f108486ad = this.mAdInfo;
        params.reportForClick = true;
        params.appAutoDownload = this.autoDownload;
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniappD");
        params.extra = bundle;
        JSONObject createLoadingAntiParamForClickCGI = createLoadingAntiParamForClickCGI(this.miniAppInfo);
        params.antiSpamParams = createLoadingAntiParamForClickCGI.toString();
        QLog.i(TAG, 1, "report click antiSpamParams=" + createLoadingAntiParamForClickCGI);
        params.startActivityRequestCode = 7777;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        QLog.i(TAG, 1, "C2S Click third::" + this.mAdInfo.info.get());
        com.tencent.gdtad.statistics.a.b(1, 0, this.mAdInfo.info);
    }

    private void initSlideEvent() {
        this.mLoadingAdSlideView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float y16 = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    MiniLoadingAdLayout.this.mTouchLastY = y16;
                } else if (action == 1) {
                    if (MiniLoadingAdLayout.this.mTouchLastY - y16 > GdtUIUtils.getOffsetByBaseline(150, 750, GdtUIUtils.getMinScreenSize(MiniLoadingAdLayout.this.getContext()))) {
                        MiniLoadingAdLayout.this.handleAdClick();
                    }
                    MiniLoadingAdLayout.this.mTouchLastY = y16;
                }
                return true;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initVideo(String str) {
        Context context = getContext();
        WeakListener weakListener = new WeakListener();
        if (this.mVideoView == null) {
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
            createPlayerVideoView.addViewCallBack(weakListener);
            View view = (View) createPlayerVideoView;
            this.mVideoView = view;
            view.setBackgroundColor(0);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = wr0.a.f446116a.b(120);
            this.mVideoView.setLayoutParams(layoutParams);
            ((ConstraintLayout) findViewById(R.id.rew)).addView(this.mVideoView, 0);
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.mAdInfo.getVideoUrl(), 1, str);
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(context, 104, (ISPlayerVideoView) this.mVideoView);
        this.mVideoPlayer = createMediaPlayer;
        createMediaPlayer.setOnVideoPreparedListener(weakListener);
        this.mVideoPlayer.setOnErrorListener(weakListener);
        this.mVideoPlayer.setOnInfoListener(weakListener);
        this.mVideoPlayer.setOnCompletionListener(weakListener);
        this.mVideoPlayer.setLoopback(false);
        this.mVideoPlayer.openMediaPlayer(context, createVideoInfoForUrl, 0L);
        this.mVideoPlayer.setOutputMute(true);
        this.mVideoPlayer.setXYaxis(this.mAdInfo.getVideoWidth() > this.mAdInfo.getVideoHeight() ? 3 : 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSlideAdMaskAnimation$0(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        double d16 = animatedFraction * 0.1d;
        float f16 = (float) (animatedFraction < 0.5f ? d16 + 1.0d : 1.1d - d16);
        this.mLoadingSlideAdBar.setScaleX(f16);
        this.mLoadingSlideAdBar.setScaleY(f16);
        ImageView imageView = this.mLoadingAdSlideLight;
        if (imageView == null) {
            return;
        }
        double d17 = animatedFraction;
        if (d17 < 0.11d) {
            imageView.setAlpha((float) (d17 / 0.11d));
        }
        if (d17 > 0.86d) {
            this.mLoadingAdSlideLight.setAlpha((float) (1.0d - ((d17 - 0.86d) * 10.0d)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSlideTipApng() {
        String str;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setUseCache(true);
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        if (this.mUIType == 2) {
            str = SLIDE_AD_FINGER_URL;
        } else {
            str = SLIDE_AD_ARROW_URL;
        }
        this.mLoadingAdSlideIcon.setImageDrawable(iVasApngFactory.getApngURLDrawable(TAG, str, apngOptions));
    }

    private void reportToGdt(final String str, long j3) {
        QLog.i(TAG, 1, "yuki reportToGdt LoadingAd reportUrl = " + str);
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.3
            @Override // java.lang.Runnable
            public void run() {
                HttpURLConnection httpURLConnection;
                Throwable th5;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (Throwable th6) {
                    httpURLConnection = null;
                    th5 = th6;
                }
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.connect();
                    QLog.i(MiniLoadingAdLayout.TAG, 1, "reportToGdt LoadingAd rspCode" + httpURLConnection.getResponseCode());
                } catch (Throwable th7) {
                    th5 = th7;
                    try {
                        QLog.i(MiniLoadingAdLayout.TAG, 1, "reportToGdt LoadingAd error, url = " + str, th5);
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            }
        });
    }

    private void showAdBar() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo;
        TextView textView;
        GdtAd gdtAd = this.mAdInfo;
        if (gdtAd == null || (adInfo = gdtAd.info) == null || (displayInfo = adInfo.display_info) == null || (basicInfo = displayInfo.basic_info) == null || basicInfo.txt == null) {
            return;
        }
        String str = "";
        if (displayInfo.button_info.has() && this.mAdInfo.info.display_info.button_info.get() != null && this.mAdInfo.info.display_info.button_info.get().size() > 0) {
            for (int i3 = 0; i3 < this.mAdInfo.info.display_info.button_info.get().size(); i3++) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = this.mAdInfo.info.display_info.button_info.get(i3);
                if (buttonInfo.pos.get() == 2 && !TextUtils.isEmpty(buttonInfo.txt.get())) {
                    str = buttonInfo.txt.get();
                }
            }
        }
        if (TextUtils.isEmpty(str) || (textView = this.mLoadingAdTextView) == null) {
            return;
        }
        textView.setText(str);
    }

    private void showPublicationInfo() {
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo == null) {
            this.mGamePublicationInfoFirstLineView.setVisibility(8);
            this.mGamePublicationInfoSecondLineView.setVisibility(8);
            this.mDeveloperDescView.setVisibility(0);
            return;
        }
        if (!TextUtils.isEmpty(miniAppInfo.gamePublicationNumber) && !TextUtils.isEmpty(this.miniAppInfo.gameOperatingCompany) && !TextUtils.isEmpty(this.miniAppInfo.gameApprovalNumber) && !TextUtils.isEmpty(this.miniAppInfo.gameOperatingCompany)) {
            this.mGamePublicationInfoFirstLineView.setVisibility(0);
            this.mGamePublicationInfoSecondLineView.setVisibility(0);
            this.mDeveloperDescView.setVisibility(8);
            String str = HardCodeUtil.qqStr(R.string.xz9) + this.miniAppInfo.gamePublicationNumber + "   " + HardCodeUtil.qqStr(R.string.f169854xz2) + this.miniAppInfo.gameOperatingCompany;
            String str2 = HardCodeUtil.qqStr(R.string.f169853xz1) + this.miniAppInfo.gameApprovalNumber + "   " + HardCodeUtil.qqStr(R.string.xz8) + this.miniAppInfo.gamePublicationCompany;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.mGamePublicationInfoFirstLineView.setText(str);
            this.mGamePublicationInfoSecondLineView.setText(str2);
            return;
        }
        this.mGamePublicationInfoFirstLineView.setVisibility(8);
        this.mGamePublicationInfoSecondLineView.setVisibility(8);
        this.mDeveloperDescView.setVisibility(0);
    }

    private void startAdBarAnimation() {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo;
        PBStringField pBStringField;
        TextView textView;
        GdtAd gdtAd = this.mAdInfo;
        if (gdtAd == null || (adInfo = gdtAd.info) == null || (displayInfo = adInfo.display_info) == null || (basicInfo = displayInfo.basic_info) == null || (pBStringField = basicInfo.txt) == null) {
            return;
        }
        String str = pBStringField.get();
        if (TextUtils.isEmpty(str) || (textView = this.mLoadingAdTextView) == null || this.mUiHandler == null) {
            return;
        }
        textView.setText(str);
    }

    private void startCountDown() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MiniLoadingAdLayout miniLoadingAdLayout = MiniLoadingAdLayout.this;
                miniLoadingAdLayout.countdownTime--;
                if (MiniLoadingAdLayout.this.countdownTime == MiniLoadingAdLayout.this.showSkipTime) {
                    MiniLoadingAdLayout.this.mLoadingAdSkipBtn.setVisibility(0);
                }
                if (MiniLoadingAdLayout.this.countdownTime > 0) {
                    MiniLoadingAdLayout.this.mCountdownTextView.setText(MiniLoadingAdLayout.this.countdownTime + "\u79d2");
                    MiniLoadingAdLayout.this.mUiHandler.postDelayed(this, 1000L);
                    return;
                }
                MiniLoadingAdLayout miniLoadingAdLayout2 = MiniLoadingAdLayout.this;
                miniLoadingAdLayout2.dismiss(false, miniLoadingAdLayout2.mDismissListener);
            }
        };
        this.mCountdownRunnable = runnable;
        this.mUiHandler.postDelayed(runnable, 1000L);
    }

    public String getTraceId() {
        GdtAd gdtAd = this.mAdInfo;
        if (gdtAd == null) {
            return "";
        }
        return gdtAd.getTraceId();
    }

    public void initUI(int i3) {
        this.mUIType = i3;
        boolean z16 = true;
        if (i3 == 0) {
            LayoutInflater.from(getContext()).inflate(R.layout.dko, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.dkp, (ViewGroup) this, true);
        }
        this.mCountdownContainerBg = (ImageView) findViewById(R.id.riu);
        this.mLoadingAdBottomLayoutContainer = (FrameLayout) findViewById(R.id.rit);
        this.mCountdownTextView = (TextView) findViewById(R.id.rex);
        if (this.mUIType == 0) {
            this.mLoadingAdSkipBtn = (TextView) findViewById(R.id.f163700rj2);
        } else {
            this.mLoadingAdSkipBtn = (TextView) findViewById(R.id.f163678rf0);
        }
        this.mDeveloperDescView = (TextView) findViewById(R.id.rcy);
        this.mLoadingAdImgView = (ImageView) findViewById(R.id.rey);
        this.mLoadingAdBar = (ImageView) findViewById(R.id.rir);
        this.mLoadingAdTextView = (TextView) findViewById(R.id.riq);
        this.mGamePublicationInfoFirstLineView = (TextView) findViewById(R.id.rdo);
        this.mGamePublicationInfoSecondLineView = (TextView) findViewById(R.id.rdp);
        int i16 = this.mUIType;
        if (i16 != 0) {
            if (i16 != 2 && i16 != 3 && i16 != 4) {
                z16 = false;
            }
            this.mLoadingSlideAdBar = (RelativeLayout) ((ViewStub) findViewById(R.id.rj7)).inflate();
            this.mLoadingAdSlideView = findViewById(R.id.f163679rf1);
            this.mLoadingAdSlideIcon = (ImageView) findViewById(R.id.f163702rj4);
            this.mLoadingAdSlideMask = findViewById(R.id.f163680rf2);
            this.mLoadingAdSlideLight = (ImageView) this.mLoadingSlideAdBar.findViewById(R.id.rj5);
            this.mLoadingAdSlideText = (TextView) this.mLoadingSlideAdBar.findViewById(R.id.rj6);
            this.mLoadingAdSlideView.setVisibility(z16 ? 0 : 8);
            this.mLoadingSlideAdBar.setVisibility(z16 ? 0 : 8);
            this.mLoadingAdSlideMask.setVisibility(z16 ? 0 : 8);
            this.mLoadingAdSlideIcon.setVisibility(z16 ? 0 : 8);
            this.mLoadingAdBar.setVisibility(z16 ? 8 : 0);
            this.mLoadingAdTextView.setVisibility(z16 ? 8 : 0);
            findViewById(R.id.ris).setVisibility(z16 ? 8 : 0);
            if (this.mUIType == 4) {
                this.mLoadingAdSlideText.setText(SLIDE_UP_TEXT);
            }
        }
        this.densityDpi = DisplayHelper.getDensity(getContext());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    private void startSlideAdMaskAnimation() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(700L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.mini.widget.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MiniLoadingAdLayout.this.lambda$startSlideAdMaskAnimation$0(valueAnimator);
            }
        });
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(700L);
        animatorSet.playTogether(ofInt);
        animatorSet.addListener(new LoadingAdAnimatorListener(this, animatorSet));
        this.mUiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.5
            @Override // java.lang.Runnable
            public void run() {
                animatorSet.start();
            }
        }, 0L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int x16 = (int) (motionEvent.getX() / this.densityDpi);
            int y16 = (int) (motionEvent.getY() / this.densityDpi);
            if (motionEvent.getAction() == 0) {
                this.lastTouchDownX = x16;
                this.lastTouchDownY = y16;
                this.touchStamp = System.currentTimeMillis();
            } else if (motionEvent.getAction() == 1) {
                this.lastTouchUpX = x16;
                this.lastTouchUpY = y16;
                this.pressInterval = System.currentTimeMillis() - this.touchStamp;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dispatchTouchEvent failed,", e16);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean setupUIForSDK(MiniAppInfo miniAppInfo, boolean z16, String str, String str2, String str3, String str4, String str5, String str6, long j3, AdProxy.ILoadingAdListener iLoadingAdListener) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<GdtAd> convertJson2GdtAds = AdUtils.convertJson2GdtAds(str);
            if (convertJson2GdtAds != null && !convertJson2GdtAds.isEmpty()) {
                this.miniAppInfo = miniAppInfo;
                for (int i3 = 0; i3 < convertJson2GdtAds.size(); i3++) {
                    GdtAd gdtAd = convertJson2GdtAds.get(i3);
                    if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && (traceInfo = reportInfo.trace_info) != null && traceInfo.aid.get() == j3) {
                        this.mAdInfo = gdtAd;
                    }
                }
                GdtAd gdtAd2 = this.mAdInfo;
                if (gdtAd2 == null) {
                    QLog.i(TAG, 1, "setupUIForSDK adInfo is null");
                    return false;
                }
                if (MiniLoadingAdManager.isVideoAd(gdtAd2)) {
                    initVideo(str6);
                }
                adjustUI(z16, str2, str3, str4, str5, iLoadingAdListener);
                return true;
            }
            QLog.i(TAG, 1, "setupUIForSDK ads is empty");
            return false;
        }
        QLog.i(TAG, 1, "setupUIForSDK adJson||name||iconUrl is empty");
        return false;
    }

    public void show(OnDismissListener onDismissListener) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        setVisibility(0);
        this.showAdStamp = System.currentTimeMillis();
        this.mDismissListener = onDismissListener;
        startCountDown();
        int i3 = this.mUIType;
        if (i3 == 0) {
            startAdBarAnimation();
        } else if (i3 != 2 && i3 != 3 && i3 != 4) {
            showAdBar();
        } else {
            startSlideAdMaskAnimation();
        }
        showPublicationInfo();
        GdtAd gdtAd = this.mAdInfo;
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && reportInfo.exposure_url != null) {
            JSONObject createLoadingAntiParamForExpoCGI = createLoadingAntiParamForExpoCGI(this.miniAppInfo);
            try {
                QLog.i(TAG, 1, "report expo antiSpamParams=" + createLoadingAntiParamForExpoCGI.toString());
                reportToGdt(this.mAdInfo.info.report_info.exposure_url.get() + "&s=" + URLEncoder.encode(createLoadingAntiParamForExpoCGI.toString(), "utf-8"), this.showAdStamp);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "reportToGdt failed", e16);
            }
        }
        if (this.mAdInfo != null) {
            QLog.i(TAG, 1, "C2S Exposure third::" + this.mAdInfo.info.get());
            com.tencent.gdtad.statistics.a.b(0, 0, this.mAdInfo.info);
        }
        this.mLoadingAdSkipBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiniLoadingAdLayout miniLoadingAdLayout = MiniLoadingAdLayout.this;
                miniLoadingAdLayout.dismiss(true, miniLoadingAdLayout.mDismissListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class WeakListener implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISPlayerVideoView.IVideoViewCallBack, ISuperPlayer.OnInfoListener {
        WeakListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInfo$0() {
            MiniLoadingAdLayout.this.mLoadingAdImgView.setVisibility(8);
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            MiniLoadingAdLayout.this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.WeakListener.1
                @Override // java.lang.Runnable
                public void run() {
                    MiniLoadingAdLayout miniLoadingAdLayout = MiniLoadingAdLayout.this;
                    miniLoadingAdLayout.dismiss(false, miniLoadingAdLayout.mDismissListener);
                }
            });
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            QLog.e(MiniLoadingAdLayout.TAG, 1, "super player play error" + i17);
            return false;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            MiniLoadingAdLayout.this.mVideoPlayer.start();
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            if (i3 == 105) {
                MiniLoadingAdLayout.this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniLoadingAdLayout.WeakListener.this.lambda$onInfo$0();
                    }
                });
                QLog.i(MiniLoadingAdLayout.TAG, 1, "first video frame rendered, what:" + i3);
                return false;
            }
            QLog.i(MiniLoadingAdLayout.TAG, 1, "onInfo do nothing, what:" + i3);
            return false;
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
        }
    }

    public void dismiss(boolean z16, OnDismissListener onDismissListener) {
        setVisibility(8);
        this.mUiHandler.removeCallbacks(this.mCountdownRunnable);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(z16);
        }
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
    }

    public MiniLoadingAdLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
        this.countdownTime = config;
        this.showSkipTime = config - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 0);
        this.autoDownload = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.densityDpi = 1.0f;
    }

    public MiniLoadingAdLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int config = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_duration", 5);
        this.countdownTime = config;
        this.showSkipTime = config - QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_skip_time", 0);
        this.autoDownload = QzoneConfig.getInstance().getConfig("qqminiapp", "launch_adv_app_auto_download", 0) == 1;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.densityDpi = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class LoadingAdAnimatorListener implements Animator.AnimatorListener {
        private WeakReference<AnimatorSet> mAnimatorSetWeak;
        private Animation mMaskAnimation;
        private WeakReference<MiniLoadingAdLayout> mMiniLoadingAdLayout;

        public LoadingAdAnimatorListener(MiniLoadingAdLayout miniLoadingAdLayout, AnimatorSet animatorSet) {
            this.mMiniLoadingAdLayout = new WeakReference<>(miniLoadingAdLayout);
            this.mAnimatorSetWeak = new WeakReference<>(animatorSet);
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
            this.mMaskAnimation = translateAnimation;
            translateAnimation.setDuration(700L);
            this.mMaskAnimation.setInterpolator(new LinearInterpolator());
            this.mMaskAnimation.setFillBefore(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MiniLoadingAdLayout miniLoadingAdLayout = this.mMiniLoadingAdLayout.get();
            if (miniLoadingAdLayout == null) {
                QLog.e(MiniLoadingAdLayout.TAG, 1, "onAnimationEnd mMiniLoadingAdLayout == null!");
                return;
            }
            miniLoadingAdLayout.mUiHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.LoadingAdAnimatorListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoadingAdAnimatorListener.this.mAnimatorSetWeak.get() != null) {
                        ((AnimatorSet) LoadingAdAnimatorListener.this.mAnimatorSetWeak.get()).start();
                    }
                }
            }, 2000L);
            if (miniLoadingAdLayout.mLoadingAdSlideLight != null) {
                miniLoadingAdLayout.mLoadingAdSlideLight.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MiniLoadingAdLayout miniLoadingAdLayout = this.mMiniLoadingAdLayout.get();
            if (miniLoadingAdLayout != null) {
                if (miniLoadingAdLayout.mLoadingAdSlideLight != null) {
                    miniLoadingAdLayout.mLoadingAdSlideLight.setVisibility(0);
                    miniLoadingAdLayout.mLoadingAdSlideLight.startAnimation(this.mMaskAnimation);
                }
                miniLoadingAdLayout.playSlideTipApng();
                return;
            }
            QLog.e(MiniLoadingAdLayout.TAG, 1, "onAnimationStart mMiniLoadingAdLayout == null!");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
