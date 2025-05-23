package com.tencent.mobileqq.minigame.publicaccount.gamecenter;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.util.UiThreadUtil;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WebUiStrategy2GameCenter implements CustomWebView.d {
    private static final float ANIMATION_X_DELTA = 0.6754386f;
    private static final int IDLE_TIME_TO_SHRINK = 10000;
    private static final float SHRINK_LENGTH = 77.0f;
    private static final float TOTAL_LENGTH = 114.0f;
    private TranslateAnimation mExtendAnimation;
    private URLImageView mGameCenterBtn;
    private TranslateAnimation mShrinkAnimation;
    private boolean mIsExtendStatus = false;
    private Runnable mShrinkRunnable = new Runnable() { // from class: com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.4
        @Override // java.lang.Runnable
        public void run() {
            WebUiStrategy2GameCenter.this.shrinkBtn();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void extendBtn() {
        if (this.mGameCenterBtn == null || this.mIsExtendStatus) {
            return;
        }
        this.mIsExtendStatus = true;
        if (this.mExtendAnimation == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 1.6754386f, 1.0f, 1.0f);
            this.mExtendAnimation = translateAnimation;
            translateAnimation.setDuration(300L);
            this.mExtendAnimation.setFillAfter(true);
            this.mExtendAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) WebUiStrategy2GameCenter.this.mGameCenterBtn.getLayoutParams();
                    layoutParams.rightMargin = 0;
                    WebUiStrategy2GameCenter.this.mGameCenterBtn.setLayoutParams(layoutParams);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
        this.mGameCenterBtn.clearAnimation();
        this.mGameCenterBtn.startAnimation(this.mExtendAnimation);
        UiThreadUtil.runOnUiThread(this.mShrinkRunnable, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoGameCenter(Activity activity) {
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_URL), 4011, null);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("minigamechengzaiye", "top_minigame", "click", null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shrinkBtn() {
        if (this.mGameCenterBtn == null || !this.mIsExtendStatus) {
            return;
        }
        this.mIsExtendStatus = false;
        UiThreadUtil.remove(this.mShrinkRunnable);
        if (this.mShrinkAnimation == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, 0.32456142f, 1.0f, 1.0f);
            this.mShrinkAnimation = translateAnimation;
            translateAnimation.setDuration(300L);
            this.mShrinkAnimation.setFillAfter(true);
            this.mShrinkAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) WebUiStrategy2GameCenter.this.mGameCenterBtn.getLayoutParams();
                    layoutParams.rightMargin = -x.c(WebUiStrategy2GameCenter.this.mGameCenterBtn.getContext(), WebUiStrategy2GameCenter.SHRINK_LENGTH);
                    WebUiStrategy2GameCenter.this.mGameCenterBtn.setLayoutParams(layoutParams);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
        this.mGameCenterBtn.clearAnimation();
        this.mGameCenterBtn.startAnimation(this.mShrinkAnimation);
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView.d
    public void onSChanged(int i3, int i16, int i17, int i18) {
        shrinkBtn();
    }

    public void initView(final Activity activity, View view, MiniGamePublicAccountWebView miniGamePublicAccountWebView) {
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.rdn);
        this.mGameCenterBtn = uRLImageView;
        uRLImageView.setVisibility(0);
        this.mGameCenterBtn.setBackgroundURL(GameWnsUtils.getMiniGamePublicAccountGameStoreButtonUrl());
        this.mGameCenterBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (WebUiStrategy2GameCenter.this.mIsExtendStatus) {
                    WebUiStrategy2GameCenter.this.gotoGameCenter(activity);
                } else {
                    WebUiStrategy2GameCenter.this.extendBtn();
                }
            }
        });
        miniGamePublicAccountWebView.setScrollInterface(this);
    }
}
