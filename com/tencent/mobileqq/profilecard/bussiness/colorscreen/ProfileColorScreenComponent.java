package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.floatscr.a;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.quickupdate.ColorScreenBusiness;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* loaded from: classes16.dex */
public class ProfileColorScreenComponent extends AbsQQProfileComponent<FrameLayout> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileColorScreenComponent";
    private ColorScreenLoader mColorScreenLoader;
    private LottieAnimationView mColorScreenView;
    private boolean mHaveLoadedOnce;
    private int mLastColorScreen;
    private Handler mUIHandler;
    private boolean mValidate;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class ColorScreenLoader implements VasManager.CompleteListener<a>, Runnable {
        static IPatchRedirector $redirector_;
        private int colorScreenId;
        private LottieComposition mComposition;
        private a mConfig;

        ColorScreenLoader(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileColorScreenComponent.this, i3);
            } else {
                this.colorScreenId = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (!ProfileColorScreenComponent.this.isValidate()) {
                QLog.e(ProfileColorScreenComponent.TAG, 1, "early return, invalid before setComposition");
                return;
            }
            if (ProfileColorScreenComponent.this.mLastColorScreen == this.colorScreenId) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileColorScreenComponent.TAG, 2, "play : " + this.colorScreenId);
                }
                ProfileColorScreenComponent.this.mColorScreenView.cancelAnimation();
                ProfileColorScreenComponent.this.mColorScreenView.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ColorScreenLoader.this);
                        }
                    }

                    @Override // com.airbnb.lottie.ImageAssetDelegate
                    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (Bitmap) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) lottieImageAsset);
                        }
                        String str = ((ColorScreenBusiness) QQVasUpdateBusiness.getBusiness(ColorScreenBusiness.class)).getImagesDir(ColorScreenLoader.this.colorScreenId) + File.separator + lottieImageAsset.getFileName();
                        if (!new File(str).exists()) {
                            QLog.e(ProfileColorScreenComponent.TAG, 1, "fetchBitmap  bitmapPath is not exists: " + str);
                            return null;
                        }
                        return LottieHelper.a(str);
                    }
                });
                try {
                    ColorScreenListener colorScreenListener = new ColorScreenListener(this.mComposition.getDuration());
                    ProfileColorScreenComponent.this.mColorScreenView.setComposition(this.mComposition);
                    ProfileColorScreenComponent.this.mColorScreenView.setProgress(0.0f);
                    ProfileColorScreenComponent.this.mColorScreenView.setRepeatCount(this.mConfig.f209990c);
                    ProfileColorScreenComponent.this.mColorScreenView.addAnimatorListener(colorScreenListener);
                    ProfileColorScreenComponent.this.mColorScreenView.addAnimatorUpdateListener(colorScreenListener);
                    ProfileColorScreenComponent.this.mColorScreenView.setVisibility(0);
                    ProfileColorScreenComponent.this.mColorScreenView.playAnimation();
                    return;
                } catch (Exception e16) {
                    QLog.e(ProfileColorScreenComponent.TAG, 1, "", e16);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(ProfileColorScreenComponent.TAG, 2, "won't play old anim: " + this.colorScreenId + " because have new anim: " + ProfileColorScreenComponent.this.mLastColorScreen);
            }
        }

        /* loaded from: classes16.dex */
        private class ColorScreenListener implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
            static IPatchRedirector $redirector_;
            public long mDuration;
            private boolean mForbidAlpha;
            public int mRepeatTimes;
            public long mTotalTime;

            public ColorScreenListener(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ColorScreenLoader.this, Long.valueOf(j3));
                    return;
                }
                this.mDuration = j3;
                this.mTotalTime = j3 * (ColorScreenLoader.this.mConfig.f209990c + 1);
                this.mForbidAlpha = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileColorScreenComponent.TAG, 2, "onAnimationEnd: " + ColorScreenLoader.this.colorScreenId);
                }
                ProfileColorScreenComponent.this.mColorScreenView.setVisibility(8);
                if (ProfileColorScreenComponent.this.mUIHandler != null) {
                    ProfileColorScreenComponent.this.mUIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.ColorScreenListener.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ColorScreenListener.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ProfileColorScreenComponent.this.mColorScreenView.removeAnimatorListener(ColorScreenListener.this);
                                ProfileColorScreenComponent.this.mColorScreenView.removeUpdateListener(ColorScreenListener.this);
                            }
                        }
                    });
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                } else {
                    this.mRepeatTimes++;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                } else if (QLog.isColorLevel()) {
                    QLog.d(ProfileColorScreenComponent.TAG, 2, "onAnimationStart: " + ColorScreenLoader.this.colorScreenId);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) valueAnimator);
                    return;
                }
                if (!this.mForbidAlpha) {
                    try {
                        float animatedFraction = (valueAnimator.getAnimatedFraction() + this.mRepeatTimes) * ((float) this.mDuration);
                        if (animatedFraction <= ((float) ColorScreenLoader.this.mConfig.f209991d)) {
                            ProfileColorScreenComponent.this.mColorScreenView.setAlpha(animatedFraction / ((float) ColorScreenLoader.this.mConfig.f209991d));
                        } else {
                            long j3 = this.mTotalTime;
                            if (j3 > 0 && ((float) j3) - animatedFraction <= ((float) ColorScreenLoader.this.mConfig.f209992e)) {
                                ProfileColorScreenComponent.this.mColorScreenView.setAlpha((((float) this.mTotalTime) - animatedFraction) / ((float) ColorScreenLoader.this.mConfig.f209992e));
                            }
                        }
                    } catch (Exception e16) {
                        this.mForbidAlpha = true;
                        QLog.e(ProfileColorScreenComponent.TAG, 1, "onAnimationUpdate: ", e16);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                    onAnimationStart(animator);
                } else {
                    iPatchRedirector.redirect((short) 7, this, animator, Boolean.valueOf(z16));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                    onAnimationEnd(animator);
                } else {
                    iPatchRedirector.redirect((short) 8, this, animator, Boolean.valueOf(z16));
                }
            }
        }

        @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
        public void onComplete(a aVar, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, obj);
                return;
            }
            if (aVar != null && ProfileColorScreenComponent.this.isValidate() && ((AbsComponent) ProfileColorScreenComponent.this).mActivity != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(ProfileColorScreenComponent.TAG, 2, "onComplete, anim file is " + aVar.f209988a);
                }
                this.mConfig = aVar;
                try {
                    LottieComposition.Factory.fromInputStream(new FileInputStream(aVar.f209988a), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent.ColorScreenLoader.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ColorScreenLoader.this);
                            }
                        }

                        @Override // com.airbnb.lottie.OnCompositionLoadedListener
                        public void onCompositionLoaded(LottieComposition lottieComposition) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) lottieComposition);
                                return;
                            }
                            if (QLog.isColorLevel() || lottieComposition == null) {
                                QLog.d(ProfileColorScreenComponent.TAG, 1, "onCompositionLoaded: composition= " + lottieComposition);
                            }
                            if (lottieComposition != null) {
                                ColorScreenLoader.this.mComposition = lottieComposition;
                                if (ProfileColorScreenComponent.this.mUIHandler != null) {
                                    ProfileColorScreenComponent.this.mUIHandler.postDelayed(ColorScreenLoader.this, 500L);
                                    return;
                                }
                                return;
                            }
                            VasMonitorDT.reportErrCode("individual_v2_colorscreen_parse_fail", "id:" + ColorScreenLoader.this.colorScreenId);
                        }
                    });
                    return;
                } catch (FileNotFoundException e16) {
                    QLog.e(ProfileColorScreenComponent.TAG, 1, ColorScreenJsPlugin.BUSINESS_NAME, e16);
                    return;
                }
            }
            QLog.e(ProfileColorScreenComponent.TAG, 1, "early return, config is " + aVar);
        }
    }

    public ProfileColorScreenComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mValidate = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void destroyColorScreenView() {
        LottieAnimationView lottieAnimationView = this.mColorScreenView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            VIEW view = this.mViewContainer;
            ((FrameLayout) view).removeView((View) view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initColorScreenView() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.mActivity);
        ((FrameLayout) this.mViewContainer).addView(lottieAnimationView, new ViewGroup.LayoutParams(-1, -1));
        this.mColorScreenView = lottieAnimationView;
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidate() {
        return this.mValidate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void loadColorScreenInner() {
        String str;
        if (this.mApp != null) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne != null && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin)) {
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    QLog.i(TAG, 1, "loadColorScreen, SimpleUIMode is open now");
                    return;
                }
                this.mHaveLoadedOnce = true;
                int colorScreenId = ((ISVIPHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getColorScreenId(((ProfileCardInfo) this.mData).allInOne.uin);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "loadColorScreen " + colorScreenId + " mLastColorScreen " + this.mLastColorScreen);
                }
                if (colorScreenId > 0 && colorScreenId != this.mLastColorScreen) {
                    this.mColorScreenView.cancelAnimation();
                    this.mLastColorScreen = colorScreenId;
                    if (((ProfileCardInfo) this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "Bubble", "ShowEffect", str, 1, 0, 0, null, Integer.toString(colorScreenId), null);
                    this.mColorScreenLoader = new ColorScreenLoader(colorScreenId);
                    VasUtil.getSignedService(this.mApp).getColorScreen().a(colorScreenId, VasManager.weakWrap(this.mColorScreenLoader));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "loadColorScreen early return");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void tryLoadColorScreenOnResume() {
        boolean z16;
        if (this.mHaveLoadedOnce) {
            AbsProfileHeaderComponent absProfileHeaderComponent = (AbsProfileHeaderComponent) this.mComponentCenter.getComponent(1002);
            if (absProfileHeaderComponent != null) {
                AbsProfileHeaderView headerView = absProfileHeaderComponent.getHeaderView();
                if ((headerView instanceof VasProfileTagView) && ((VasProfileTagView) headerView).isFullScreen) {
                    z16 = false;
                    this.mLastColorScreen = 0;
                    if (!z16) {
                        loadColorScreenInner();
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            this.mLastColorScreen = 0;
            if (!z16) {
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1004;
    }

    public void loadColorScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            loadColorScreenInner();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        initColorScreenView();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mValidate = true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mValidate = false;
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mUIHandler = null;
        }
        destroyColorScreenView();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            tryLoadColorScreenOnResume();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileColorScreenComponent) profileCardInfo);
        DATA data = this.mData;
        if (((ProfileCardInfo) data).card != null && (((ProfileCardInfo) data).card.lCurrentStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_TAG || ((ProfileCardInfo) data).allInOne.colorScreen == 1)) {
            loadColorScreenInner();
        }
        return lambda$checkValidComponent$3;
    }
}
