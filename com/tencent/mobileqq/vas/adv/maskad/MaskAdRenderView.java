package com.tencent.mobileqq.vas.adv.maskad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.image.URLDrawable;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import com.tencent.jalpha.videoplayer.view.JalphaTextureView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import java.net.URL;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MaskAdRenderView implements RenderFactory {
    private static final String AD_ENTRY_IMAGE_URL_KEY = "icon_url";
    private static final int FULL_SCREEN_ENTRY_LAYOUT_MARGIN_BOTTOM = 104;
    private static final String TAG = "MaskAdRenderView";
    private static final int TRANSITION_ANIMATION_DURATION = 1000;
    private static boolean mIsTianShuAd;
    private final FrameLayout mContentView;
    private final Context mContext;
    private final GdtAd mGdtAd;
    private ConstraintLayout mMaskAdAnimatorLayout;
    private MaskAdDisappearListener mMaskAdDisappearListener;
    private ImageView mMaskAdEntryBtnImage;
    private ImageView mMaskAdEntryImage;
    private RelativeLayout mMaskAdEntryLayout;
    private MaskAdRender mMaskAdRender;
    private JalphaTextureView mMaskAdTextureView;
    private String mResFilePath;
    private final MaskAdvName mSource;
    private long mStartExposeTime;
    private boolean mIsAnimationPlaying = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int sHippyTop = -1;
    private int sHippyHeight = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MaskAdRenderView.this.reportWeatherHealthAction("new_folder_splashad_exit_click", "");
            if (!MaskAdRenderView.this.mIsAnimationPlaying) {
                MaskAdRenderView.this.mMaskAdAnimatorLayout.startAnimation(MaskAdRenderView.this.getTransitionAnimation());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MaskAdRenderView(Context context, MaskAdvName maskAdvName, String str, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        this.mContext = context;
        this.mSource = maskAdvName;
        this.mResFilePath = str;
        this.mGdtAd = new GdtAd(adInfo);
        this.mContentView = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.i48, (ViewGroup) null);
        initLayout();
        adjustEntryLayout();
        addMaskAdVideo();
        loadAdImage();
        loadAdEntryImage();
    }

    private void addMaskAdVideo() {
        JalphaTextureView jalphaTextureView = this.mMaskAdTextureView;
        if (jalphaTextureView == null) {
            return;
        }
        jalphaTextureView.setPlayListener(new b());
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        int i3 = (int) (displayMetrics.widthPixels * 1.778f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        if (i3 > displayMetrics.heightPixels) {
            layoutParams = new FrameLayout.LayoutParams((int) (displayMetrics.heightPixels * 0.5625f), -1);
            layoutParams.width = (int) (layoutParams.width * 0.84f);
            layoutParams.height = (int) (displayMetrics.heightPixels * 0.84f);
        }
        layoutParams.topMargin = ViewUtils.dpToPx(30.0f);
        this.mMaskAdTextureView.setLoopState(false);
        this.mMaskAdTextureView.setLayoutParams(layoutParams);
        this.mMaskAdTextureView.setRenderFactory(this);
        this.mMaskAdTextureView.setEnabled(true);
        this.mMaskAdTextureView.setOpaque(false);
    }

    private void adjustEntryLayout() {
        if (!MaskAdLoadHelper.INSTANCE.checkIsFullScreenDisplay(this.mContext)) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mMaskAdEntryLayout.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = Utils.n(104.0f, Resources.getSystem());
        this.mMaskAdEntryLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet getTransitionAnimation() {
        int i3;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000L);
        animationSet.addAnimation(scaleAnimation);
        if (this.sHippyHeight != -1 && this.sHippyTop != -1 && !mIsTianShuAd) {
            QLog.e(TAG, 1, "height: " + (this.sHippyHeight / 2) + "top:" + this.sHippyTop + "mcontentview :" + (this.mContext.getResources().getDisplayMetrics().heightPixels / 2));
            i3 = ((this.sHippyHeight / 2) + this.sHippyTop) - (this.mContext.getResources().getDisplayMetrics().heightPixels / 2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("target::");
            sb5.append(i3);
            QLog.e(TAG, 1, sb5.toString());
        } else {
            i3 = 0;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, i3);
        translateAnimation.setDuration(1000L);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(1000L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(1000L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderView.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                MaskAdRenderView.this.mIsAnimationPlaying = false;
                long currentTimeMillis = System.currentTimeMillis() - MaskAdRenderView.this.mStartExposeTime;
                MaskAdRenderView.this.reportWeatherHealthAction("new_folder_splashad_staytime", "|" + currentTimeMillis);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MaskAdRenderView.this.hide();
                    }
                }, 100L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                MaskAdRenderView.this.mIsAnimationPlaying = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return animationSet;
    }

    private void initLayout() {
        this.mMaskAdAnimatorLayout = (ConstraintLayout) this.mContentView.findViewById(R.id.yxk);
        this.mMaskAdEntryLayout = (RelativeLayout) this.mContentView.findViewById(R.id.yxm);
        this.mMaskAdEntryBtnImage = (ImageView) this.mContentView.findViewById(R.id.yxl);
        ViewStub viewStub = (ViewStub) this.mContentView.findViewById(R.id.yxt);
        if (MaskAdClickHelper.INSTANCE.isImageAd(this.mGdtAd.getInnerShowType())) {
            this.mMaskAdEntryImage = (ImageView) ((ViewStub) this.mContentView.findViewById(R.id.yxp)).inflate().findViewById(R.id.yxn);
        } else {
            this.mMaskAdTextureView = (JalphaTextureView) viewStub.inflate().findViewById(R.id.yxq);
        }
        this.mMaskAdEntryBtnImage.setContentDescription(this.mContext.getString(R.string.f213685qv));
        this.mMaskAdAnimatorLayout.setOnClickListener(new a());
    }

    private void loadAdEntryImage() {
        if (this.mGdtAd.info == null) {
            QLog.d(TAG, 2, "adInfo is null, cancel load entry image");
            return;
        }
        try {
            String optString = new JSONObject(this.mGdtAd.info.ext_json.get()).optString("icon_url", "");
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.n5s);
            if (TextUtils.isEmpty(optString)) {
                this.mMaskAdEntryBtnImage.setImageDrawable(drawable);
                QLog.i(TAG, 1, "load image url is null");
                return;
            }
            URL url = new URL(optString);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            this.mMaskAdEntryBtnImage.setImageDrawable(URLDrawable.getDrawable(url, obtain));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "load entry image exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdImage() {
        if (this.mMaskAdEntryImage == null) {
            return;
        }
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setUseCache(true);
        this.mMaskAdEntryImage.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.mGdtAd.info.ext.img2.get(), apngOptions, this.mResFilePath));
    }

    private void playMaskAdAnimator(String str) {
        JalphaTextureView jalphaTextureView = this.mMaskAdTextureView;
        if (jalphaTextureView != null) {
            jalphaTextureView.setContentVisible(true);
            this.mMaskAdTextureView.playFile(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWeatherHealthAction(String str, String str2) {
        String str3;
        MaskAdvName maskAdvName = this.mSource;
        if (maskAdvName != MaskAdvName.QQ_HEALTH && maskAdvName != MaskAdvName.QQ_WEATHER) {
            return;
        }
        MaskAdReportHelper maskAdReportHelper = MaskAdReportHelper.INSTANCE;
        String valueOf = String.valueOf(this.mGdtAd.getAId());
        if (this.mSource == MaskAdvName.QQ_WEATHER) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        maskAdReportHelper.reportAction(str, valueOf, "", str3, str2);
    }

    private void showMaskAd(String str) {
        if (MaskAdClickHelper.INSTANCE.isImageAd(this.mGdtAd.getInnerShowType())) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderView.4
                @Override // java.lang.Runnable
                public void run() {
                    MaskAdRenderView.this.loadAdImage();
                }
            });
        } else {
            playMaskAdAnimator(str);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderView.5
            @Override // java.lang.Runnable
            public void run() {
                if (!MaskAdRenderView.this.mIsAnimationPlaying) {
                    MaskAdRenderView.this.mMaskAdAnimatorLayout.startAnimation(MaskAdRenderView.this.getTransitionAnimation());
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addClickAreaView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mMaskAdAnimatorLayout.addView(view, layoutParams);
        ((TextView) this.mContentView.findViewById(R.id.yxr)).setText(this.mContext.getString(R.string.f213715qy));
    }

    public void addSkipButton() {
        TextView textView = new TextView(this.mContext);
        textView.setOnClickListener(new c());
        Resources resources = this.mContext.getResources();
        textView.setBackground(resources.getDrawable(R.drawable.n5r));
        textView.setTextColor(resources.getColor(R.color.f158017al3));
        textView.setGravity(17);
        textView.setTextSize(12.0f);
        textView.setText(resources.getText(R.string.f1377907t));
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewUtils.dip2px(83.0f), ViewUtils.dip2px(32.0f));
        layoutParams.endToEnd = R.id.yxk;
        layoutParams.topToTop = R.id.yxk;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(54.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(21.0f);
        this.mMaskAdAnimatorLayout.addView(textView, layoutParams);
    }

    @Override // com.tencent.jalpha.videoplayer.render.RenderFactory
    public BaseRender createRender() {
        MaskAdRender maskAdRender = new MaskAdRender();
        this.mMaskAdRender = maskAdRender;
        return maskAdRender;
    }

    public View getAdContentView() {
        return this.mContentView;
    }

    public boolean getIsTianShuAd() {
        return mIsTianShuAd;
    }

    public void hide() {
        this.mHandler.removeCallbacksAndMessages(null);
        JalphaTextureView jalphaTextureView = this.mMaskAdTextureView;
        if (jalphaTextureView != null) {
            jalphaTextureView.setVisibility(8);
            this.mMaskAdTextureView.setContentVisible(false);
            this.mMaskAdTextureView.stop();
        }
        if (this.mContentView.getParent() != null) {
            ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
        }
        MaskAdRender maskAdRender = this.mMaskAdRender;
        if (maskAdRender != null) {
            maskAdRender.realDestory();
        }
        setHippyAdSize(-1, -1);
        MaskAdDisappearListener maskAdDisappearListener = this.mMaskAdDisappearListener;
        if (maskAdDisappearListener == null) {
            return;
        }
        maskAdDisappearListener.sendMaskAdDisappear("maskAdDidDisappear");
    }

    public void setAdClickListener(View.OnClickListener onClickListener) {
        this.mMaskAdEntryLayout.setOnClickListener(onClickListener);
        this.mMaskAdEntryBtnImage.setOnClickListener(onClickListener);
    }

    public void setDisappearListener(MaskAdDisappearListener maskAdDisappearListener) {
        this.mMaskAdDisappearListener = maskAdDisappearListener;
    }

    public void setHippyAdSize(int i3, int i16) {
        this.sHippyHeight = i3;
        this.sHippyTop = i16;
    }

    public void setIsTianShuAd(boolean z16) {
        mIsTianShuAd = z16;
    }

    public void show(final ViewGroup viewGroup) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderView.3
            @Override // java.lang.Runnable
            public void run() {
                if (MaskAdRenderView.this.mContentView.getParent() != null) {
                    ((ViewGroup) MaskAdRenderView.this.mContentView.getParent()).removeView(MaskAdRenderView.this.mContentView);
                }
                viewGroup.addView(MaskAdRenderView.this.mContentView, new ViewGroup.LayoutParams(-1, -1));
            }
        });
        this.mStartExposeTime = System.currentTimeMillis();
        showMaskAd(this.mResFilePath);
    }

    public void updateResPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mResFilePath = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements IVideoPLayListener {
        b() {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onEnd() {
            MaskAdRenderView.this.mMaskAdTextureView.setVisibility(0);
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onStart() {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onError(int i3) {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onPlayAtTime(long j3) {
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onVideoSize(int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
