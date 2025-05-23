package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLRecognizeRegionView {
    public static final int GOOD = 1;
    public static final int GREAT = 2;
    public static final int INVALID_STATUS = -1;
    public static final int MISS = 0;
    public static final int PERFECT = 3;
    private GLViewContext context;
    private MatchStatusShow mCurrentMessage;
    private GLImageView mLeftBottom;
    private GLImageView mLeftTop;
    private GLImageView mRightBottom;
    private GLImageView mRightTop;
    private GLFrameImage mScoreStatus;
    private GLFrameImage mScoreStatusBackground;
    private GLFrameImage mScoreStatusMongolian;
    private StatusListener mStatusListener;
    private TranslateAnimation mTransformLeftBottom;
    private TranslateAnimation mTransformLeftTop;
    private TranslateAnimation mTransformRightBottom;
    private TranslateAnimation mTransformRightTop;
    private List<Animation> mVibrateAnimGreat;
    private List<Animation> mVibrateAnimPerfect;
    private List<GLImageView> mVibrateLayout;
    private boolean mAnimationHasStarted = false;
    private RectF mRegionSize = new RectF();
    private RectF mExpandRegionSize = new RectF();
    private LinkedList<MatchStatusShow> mMessageShowMgr = new LinkedList<>();
    private ArrayList<MatchStatusShow> mCacheMessageShow = new ArrayList<>();
    private RectF mGoodTypefaceRegion = new RectF();
    private RectF mGreatTypefaceRegion = new RectF();
    private RectF mPerfectTypefaceRegion = new RectF();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface StatusListener {
        void onStatusChanged(int i3);
    }

    public GLRecognizeRegionView(GLViewContext gLViewContext, String str) {
        this.context = gLViewContext;
        this.mLeftTop = new GLImageView(gLViewContext, str);
        this.mLeftBottom = new GLImageView(gLViewContext, str);
        this.mRightTop = new GLImageView(gLViewContext, str);
        this.mRightBottom = new GLImageView(gLViewContext, str);
        this.mScoreStatus = new GLFrameImage(gLViewContext, str);
        this.mScoreStatusMongolian = new GLFrameImage(gLViewContext, str);
        this.mScoreStatusBackground = new GLFrameImage(gLViewContext, str);
        clearStatus();
    }

    private void changeScoreStatus(int i3) {
        this.mScoreStatusMongolian.setCurrentImage(i3);
        this.mScoreStatusMongolian.setVisibility(true);
        this.mScoreStatusMongolian.clearAnimation();
        this.mScoreStatusBackground.setCurrentImage(i3);
        this.mScoreStatusBackground.setVisibility(true);
        this.mScoreStatusBackground.clearAnimation();
        if (i3 == 0) {
            this.mScoreStatus.setVisibility(false);
            this.mScoreStatus.clearAnimation();
        } else {
            this.mScoreStatus.setCurrentImage(i3);
            this.mScoreStatus.setVisibility(true);
            this.mScoreStatus.clearAnimation();
        }
        setScoreStatusTypefaceBarRegion(i3);
    }

    private void initAnimation() {
        float centerX = this.mRegionSize.centerX();
        float centerY = this.mRegionSize.centerY();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RectF imageClipDrawRegion = this.mLeftTop.getImageClipDrawRegion();
        TranslateAnimation translateAnimation = new TranslateAnimation(centerX, imageClipDrawRegion.left, centerY, imageClipDrawRegion.top);
        this.mTransformLeftTop = translateAnimation;
        translateAnimation.setDuration(200L);
        this.mTransformLeftTop.setInterpolator(linearInterpolator);
        RectF imageClipDrawRegion2 = this.mLeftBottom.getImageClipDrawRegion();
        TranslateAnimation translateAnimation2 = new TranslateAnimation(centerX, imageClipDrawRegion2.left, centerY, imageClipDrawRegion2.top);
        this.mTransformLeftBottom = translateAnimation2;
        translateAnimation2.setDuration(200L);
        this.mTransformLeftBottom.setInterpolator(linearInterpolator);
        RectF imageClipDrawRegion3 = this.mRightTop.getImageClipDrawRegion();
        TranslateAnimation translateAnimation3 = new TranslateAnimation(centerX, imageClipDrawRegion3.left, centerY, imageClipDrawRegion3.top);
        this.mTransformRightTop = translateAnimation3;
        translateAnimation3.setDuration(200L);
        this.mTransformRightTop.setInterpolator(linearInterpolator);
        RectF imageClipDrawRegion4 = this.mRightBottom.getImageClipDrawRegion();
        TranslateAnimation translateAnimation4 = new TranslateAnimation(centerX, imageClipDrawRegion4.left, centerY, imageClipDrawRegion4.top);
        this.mTransformRightBottom = translateAnimation4;
        translateAnimation4.setDuration(200L);
        this.mTransformRightBottom.setInterpolator(linearInterpolator);
        setupVibrateAnimation();
    }

    private void newGreatVibrateAnimation() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mVibrateLayout.size(); i3++) {
            arrayList.add(setupSingleVibrateAnimation(this.mVibrateLayout.get(i3), 75, 1));
        }
        this.mVibrateAnimGreat = arrayList;
    }

    private void newPerfectVibrateAnimation() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.mVibrateLayout.size(); i3++) {
            arrayList.add(setupSingleVibrateAnimation(this.mVibrateLayout.get(i3), 75, 2));
        }
        this.mVibrateAnimPerfect = arrayList;
    }

    private void setScoreStatusInvisible() {
        this.mScoreStatus.setVisibility(false);
        this.mScoreStatusBackground.setVisibility(false);
        this.mScoreStatusMongolian.setVisibility(false);
    }

    private void setScoreStatusTypefaceBarRegion(int i3) {
        RectF rectF;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    rectF = null;
                } else {
                    rectF = this.mPerfectTypefaceRegion;
                }
            } else {
                rectF = this.mGreatTypefaceRegion;
            }
        } else {
            rectF = this.mGoodTypefaceRegion;
        }
        if (rectF != null) {
            this.mScoreStatus.setImageRegion(rectF);
            this.mScoreStatus.setImageClipDrawRegion(rectF);
        }
    }

    private void setupVibrateAnimation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mLeftTop);
        arrayList.add(this.mLeftBottom);
        arrayList.add(this.mRightTop);
        arrayList.add(this.mRightBottom);
        this.mVibrateLayout = arrayList;
    }

    public void addMatchStatusShowToCache(MatchStatusShow matchStatusShow) {
        this.mCacheMessageShow.add(matchStatusShow);
    }

    public void addQueueScoreStatus(int i3) {
        if (i3 > -1) {
            MatchStatusShow newMatchStatusShow = getNewMatchStatusShow();
            newMatchStatusShow.status = i3;
            this.mMessageShowMgr.add(newMatchStatusShow);
        }
    }

    public void clearStatus() {
        this.mMessageShowMgr.clear();
        this.mCurrentMessage = null;
        this.mAnimationHasStarted = false;
    }

    public void draw() {
        startAnimation();
        this.mLeftTop.draw();
        this.mLeftBottom.draw();
        this.mRightTop.draw();
        this.mRightBottom.draw();
        MatchStatusShow matchStatusShow = this.mCurrentMessage;
        if (matchStatusShow != null && matchStatusShow.checkHaveStopped()) {
            addMatchStatusShowToCache(this.mCurrentMessage);
            this.mCurrentMessage = null;
            setScoreStatusInvisible();
        }
        if (this.mMessageShowMgr.isEmpty()) {
            if (this.mCurrentMessage == null) {
                setScoreStatusInvisible();
            }
        } else {
            MatchStatusShow removeLast = this.mMessageShowMgr.removeLast();
            MatchStatusShow matchStatusShow2 = this.mCurrentMessage;
            boolean z16 = true;
            if (matchStatusShow2 != null) {
                if (removeLast.status > matchStatusShow2.status) {
                    matchStatusShow2.setHaveStopped();
                    addMatchStatusShowToCache(this.mCurrentMessage);
                    this.mCurrentMessage = removeLast;
                } else {
                    z16 = false;
                }
            } else {
                this.mCurrentMessage = removeLast;
            }
            this.mMessageShowMgr.clear();
            if (z16) {
                changeScoreStatus(this.mCurrentMessage.status);
                StatusListener statusListener = this.mStatusListener;
                if (statusListener != null) {
                    statusListener.onStatusChanged(this.mCurrentMessage.status);
                }
                this.mScoreStatusMongolian.startAnimation(this.mCurrentMessage.getMongolianAnimation());
                AnimationSet backGroundAnimation = this.mCurrentMessage.getBackGroundAnimation();
                if (backGroundAnimation != null) {
                    this.mScoreStatusBackground.startAnimation(backGroundAnimation);
                }
                AnimationSet typefaceAnimation = this.mCurrentMessage.getTypefaceAnimation();
                if (typefaceAnimation != null) {
                    this.mScoreStatus.startAnimation(typefaceAnimation);
                }
                if (this.mCurrentMessage.status == 2) {
                    newGreatVibrateAnimation();
                    startVibrateAnimation(this.mVibrateAnimGreat);
                }
                if (this.mCurrentMessage.status == 3) {
                    newPerfectVibrateAnimation();
                    startVibrateAnimation(this.mVibrateAnimPerfect);
                }
                playAudioTips(this.mCurrentMessage.status);
            } else {
                DanceLog.print("GLRecognizeRegionView", "newMessageItem=false  mCurrentMessage=" + this.mCurrentMessage.getMessageStatus() + " topMessage=" + removeLast.getMessageStatus() + this.mCurrentMessage.getAnimationLog());
            }
        }
        this.mScoreStatusMongolian.draw();
        this.mScoreStatusBackground.draw();
        this.mScoreStatus.draw();
    }

    public MatchStatusShow getNewMatchStatusShow() {
        MatchStatusShow matchStatusShow;
        if (this.mCacheMessageShow.size() > 0) {
            matchStatusShow = this.mCacheMessageShow.remove(0);
        } else {
            matchStatusShow = new MatchStatusShow();
        }
        matchStatusShow.resetStatus();
        return matchStatusShow;
    }

    public void playAudioTips(int i3) {
        ResourceManager.GamingResource gamingResource = ResourceManager.getInstance().mGamingResource;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.context.playSound(gamingResource.perfectSound);
                        return;
                    }
                    return;
                }
                this.context.playSound(gamingResource.greatSound);
                return;
            }
            this.context.playSound(gamingResource.goodSound);
            return;
        }
        this.context.playSound(gamingResource.missSound);
    }

    public void setExpandRecognizeRegion(RectF rectF) {
        this.mExpandRegionSize.set(rectF);
    }

    public void setLeftBottomImage(String str) {
        this.mLeftBottom.setImageRes(str);
    }

    public void setLeftTopImage(String str) {
        this.mLeftTop.setImageRes(str);
    }

    public void setRecognizeRegion(RectF rectF) {
        if (!this.mRegionSize.equals(rectF)) {
            this.mRegionSize.set(rectF);
            float pixelToRealPixel = DisplayUtils.pixelToRealPixel(82.0f);
            RectF rectF2 = new RectF();
            float f16 = rectF.left;
            rectF2.left = f16;
            float f17 = rectF.top;
            rectF2.top = f17;
            rectF2.right = f16 + pixelToRealPixel;
            rectF2.bottom = f17 + pixelToRealPixel;
            this.mLeftTop.setImageRegion(rectF2);
            this.mLeftTop.setImageClipDrawRegion(rectF2);
            rectF2.left = rectF.left;
            float f18 = rectF.bottom;
            rectF2.top = f18 - pixelToRealPixel;
            rectF2.right = rectF.left + pixelToRealPixel;
            rectF2.bottom = f18;
            this.mLeftBottom.setImageRegion(rectF2);
            this.mLeftBottom.setImageClipDrawRegion(rectF2);
            float f19 = rectF.right;
            rectF2.left = f19 - pixelToRealPixel;
            rectF2.top = rectF.top;
            rectF2.right = f19;
            rectF2.bottom = rectF.top + pixelToRealPixel;
            this.mRightTop.setImageRegion(rectF2);
            this.mRightTop.setImageClipDrawRegion(rectF2);
            float f26 = rectF.right;
            rectF2.left = f26 - pixelToRealPixel;
            float f27 = rectF.bottom;
            rectF2.top = f27 - pixelToRealPixel;
            rectF2.right = f26;
            rectF2.bottom = f27;
            this.mRightBottom.setImageRegion(rectF2);
            this.mRightBottom.setImageClipDrawRegion(rectF2);
            this.context.mapNormalRegion(this.mRegionSize);
            initAnimation();
        }
    }

    public void setRightBottomImage(String str) {
        this.mRightBottom.setImageRes(str);
    }

    public void setRightTopImage(String str) {
        this.mRightTop.setImageRes(str);
    }

    public void setScoreStatusBackgroundBarRegion(RectF rectF) {
        this.mScoreStatusBackground.setImageRegion(rectF);
        this.mScoreStatusBackground.setImageClipDrawRegion(rectF);
    }

    public void setScoreStatusBackgroundImage(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, str);
        arrayList.add(1, str2);
        arrayList.add(2, str3);
        arrayList.add(3, str4);
        this.mScoreStatusBackground.setAnimationFrames(arrayList);
        this.mScoreStatusBackground.setLoadTextureMode(0);
        this.mScoreStatusBackground.initAnimationFrame();
        this.mScoreStatusBackground.setVisibility(false);
    }

    public void setScoreStatusMongolianBarRegion(RectF rectF) {
        this.mScoreStatusMongolian.setImageRegion(rectF);
        this.mScoreStatusMongolian.setImageClipDrawRegion(rectF);
    }

    public void setScoreStatusMongolianImage(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, str);
        arrayList.add(1, str2);
        arrayList.add(2, str3);
        arrayList.add(3, str4);
        this.mScoreStatusMongolian.setAnimationFrames(arrayList);
        this.mScoreStatusMongolian.setLoadTextureMode(0);
        this.mScoreStatusMongolian.initAnimationFrame();
        this.mScoreStatusMongolian.setVisibility(false);
    }

    public void setScoreStatusTypefaceImage(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, str);
        arrayList.add(1, str2);
        arrayList.add(2, str3);
        arrayList.add(3, str4);
        this.mScoreStatus.setAnimationFrames(arrayList);
        this.mScoreStatus.setLoadTextureMode(0);
        this.mScoreStatus.initAnimationFrame();
        this.mScoreStatus.setVisibility(false);
    }

    public void setStatusListner(StatusListener statusListener) {
        this.mStatusListener = statusListener;
    }

    public void setVisibility(boolean z16) {
        this.mLeftTop.setVisibility(z16);
        this.mLeftBottom.setVisibility(z16);
        this.mRightTop.setVisibility(z16);
        this.mRightBottom.setVisibility(z16);
    }

    public AnimationSet setupSingleVibrateAnimation(GlView glView, int i3, int i16) {
        TranslateAnimation translateAnimation;
        RectF rectF = glView.mClipRegion;
        float f16 = rectF.left;
        float f17 = rectF.top;
        float realVideoRatio = glView.context.getRealVideoRatio();
        AnimationSet animationSet = new AnimationSet(true);
        for (int i17 = 0; i17 < i16; i17++) {
            if (i17 == 0) {
                translateAnimation = new TranslateAnimation(f16, f16 - (10.0f * realVideoRatio), f17, f17 - (18.0f * realVideoRatio));
            } else {
                translateAnimation = new TranslateAnimation(0.0f, realVideoRatio * (-10.0f), 0.0f, (-18.0f) * realVideoRatio);
            }
            long j3 = i3;
            translateAnimation.setDuration(j3);
            translateAnimation.setStartOffset(i17 * 4 * i3);
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillBefore(false);
            translateAnimation.setFillAfter(true);
            animationSet.addAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 20.0f * realVideoRatio, 0.0f, 36.0f * realVideoRatio);
            translateAnimation2.setStartOffset((i3 * 1) + r14);
            translateAnimation2.setDuration(j3);
            translateAnimation2.setFillEnabled(true);
            translateAnimation2.setFillBefore(false);
            translateAnimation2.setFillAfter(true);
            animationSet.addAnimation(translateAnimation2);
            TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (-23.0f) * realVideoRatio);
            translateAnimation3.setStartOffset((i3 * 2) + r14);
            translateAnimation3.setDuration(j3);
            translateAnimation3.setFillEnabled(true);
            translateAnimation3.setFillBefore(false);
            translateAnimation3.setFillAfter(true);
            animationSet.addAnimation(translateAnimation3);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, (-10.0f) * realVideoRatio, 0.0f, 5.0f * realVideoRatio);
            translateAnimation4.setStartOffset(r14 + (i3 * 3));
            translateAnimation4.setDuration(j3);
            translateAnimation4.setFillEnabled(true);
            translateAnimation4.setFillBefore(false);
            translateAnimation4.setFillAfter(true);
            animationSet.addAnimation(translateAnimation4);
        }
        return animationSet;
    }

    public void startAnimation() {
        if (!this.mAnimationHasStarted) {
            this.mLeftTop.startAnimation(this.mTransformLeftTop);
            this.mLeftBottom.startAnimation(this.mTransformLeftBottom);
            this.mRightTop.startAnimation(this.mTransformRightTop);
            this.mRightBottom.startAnimation(this.mTransformRightBottom);
            this.mAnimationHasStarted = true;
        }
    }

    public void startVibrateAnimation(List<Animation> list) {
        if (this.mVibrateLayout.size() != list.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.mVibrateLayout.size(); i3++) {
            GLImageView gLImageView = this.mVibrateLayout.get(i3);
            gLImageView.clearAnimation();
            gLImageView.startAnimation(list.get(i3));
        }
    }

    public void updateScoreStatusTypefaceRegion(int i3) {
        int width = this.context.getSurfaceViewSize().width();
        GLImage imageByIndex = this.mScoreStatus.getImageByIndex(1);
        float f16 = i3;
        this.mGoodTypefaceRegion.set((width - DisplayUtils.pixelToRealPixel(imageByIndex.getWidth())) / 2, f16, width - r2, DisplayUtils.pixelToRealPixel(imageByIndex.getHeight()) + i3);
        GLImage imageByIndex2 = this.mScoreStatus.getImageByIndex(2);
        this.mGreatTypefaceRegion.set((width - DisplayUtils.pixelToRealPixel(imageByIndex2.getWidth())) / 2, f16, width - r2, DisplayUtils.pixelToRealPixel(imageByIndex2.getHeight()) + i3);
        GLImage imageByIndex3 = this.mScoreStatus.getImageByIndex(3);
        this.mPerfectTypefaceRegion.set((width - DisplayUtils.pixelToRealPixel(imageByIndex3.getWidth())) / 2, f16, width - r2, i3 + DisplayUtils.pixelToRealPixel(imageByIndex3.getHeight()));
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class MatchStatusShow implements Animation.AnimationListener {
        AnimationSet backgroundAnimation;
        boolean haveBackgroundStop;
        boolean haveMongolianStop;
        boolean haveTypefaceStop;
        AnimationSet mongolianAnimation;
        int status;
        AnimationSet typefaceAnimation;

        MatchStatusShow() {
            resetStatus();
        }

        private AnimationSet getMatchedTypeAnimation() {
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            alphaAnimation.setFillEnabled(true);
            alphaAnimation.setFillBefore(true);
            animationSet.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.5f, 3.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(100L);
            scaleAnimation.setFillEnabled(true);
            scaleAnimation.setFillBefore(true);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(100L);
            alphaAnimation2.setStartOffset(500L);
            alphaAnimation2.setFillEnabled(true);
            alphaAnimation2.setFillBefore(false);
            animationSet.addAnimation(alphaAnimation2);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation2.setStartOffset(500L);
            scaleAnimation2.setFillEnabled(true);
            scaleAnimation2.setFillBefore(false);
            animationSet.addAnimation(scaleAnimation2);
            animationSet.setFillEnabled(true);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(this);
            return animationSet;
        }

        private AnimationSet getMissTypeAnimation() {
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(150L);
            alphaAnimation.setFillEnabled(true);
            alphaAnimation.setFillBefore(true);
            animationSet.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.0f, 3.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(150L);
            scaleAnimation.setFillEnabled(true);
            scaleAnimation.setFillBefore(true);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(100L);
            alphaAnimation2.setStartOffset(500L);
            alphaAnimation2.setFillEnabled(true);
            alphaAnimation2.setFillBefore(false);
            animationSet.addAnimation(alphaAnimation2);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation2.setStartOffset(500L);
            scaleAnimation2.setFillEnabled(true);
            scaleAnimation2.setFillBefore(false);
            animationSet.addAnimation(scaleAnimation2);
            animationSet.setFillEnabled(true);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(this);
            return animationSet;
        }

        private AnimationSet getPerfectTypeAnimation() {
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            alphaAnimation.setFillEnabled(true);
            alphaAnimation.setFillBefore(true);
            animationSet.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.5f, 3.0f, 1.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(100L);
            scaleAnimation.setFillEnabled(true);
            scaleAnimation.setFillBefore(true);
            animationSet.addAnimation(scaleAnimation);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(100L);
            alphaAnimation2.setStartOffset(500L);
            alphaAnimation2.setFillEnabled(true);
            alphaAnimation2.setFillBefore(false);
            animationSet.addAnimation(alphaAnimation2);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.5f, 2.5f, 1.5f, 0.05f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation2.setStartOffset(500L);
            scaleAnimation2.setFillEnabled(true);
            scaleAnimation2.setFillBefore(false);
            animationSet.addAnimation(scaleAnimation2);
            animationSet.setFillEnabled(true);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(this);
            return animationSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AnimationSet getTypefaceAnimation() {
            this.typefaceAnimation = null;
            int i3 = this.status;
            if (i3 != 0) {
                if (i3 != 1 && i3 != 2) {
                    if (i3 == 3) {
                        this.typefaceAnimation = getPerfectTypeAnimation();
                    }
                } else {
                    this.typefaceAnimation = getMatchedTypeAnimation();
                }
            } else {
                this.typefaceAnimation = null;
            }
            AnimationSet animationSet = this.typefaceAnimation;
            if (animationSet == null) {
                this.haveTypefaceStop = true;
            }
            return animationSet;
        }

        boolean checkHaveStopped() {
            if (this.haveMongolianStop && this.haveBackgroundStop && this.haveTypefaceStop) {
                return true;
            }
            return false;
        }

        String getAnimationLog() {
            return " haveMongolianStop=" + this.haveMongolianStop + " haveBackgroundStop=" + this.haveBackgroundStop + " haveTypefaceStop=" + this.haveTypefaceStop;
        }

        AnimationSet getBackGroundAnimation() {
            this.backgroundAnimation = null;
            int i3 = this.status;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            this.backgroundAnimation = newMongolianAnimation();
                        }
                    } else {
                        this.backgroundAnimation = newMongolianAnimation();
                    }
                } else {
                    this.backgroundAnimation = newMongolianAnimation();
                }
            } else {
                this.backgroundAnimation = getMissTypeAnimation();
            }
            AnimationSet animationSet = this.backgroundAnimation;
            if (animationSet == null) {
                this.haveBackgroundStop = true;
            }
            return animationSet;
        }

        String getMessageStatus() {
            int i3 = this.status;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return "unKnown";
                        }
                        return "PERFECT";
                    }
                    return "GREAT";
                }
                return "GOOD";
            }
            return "MISS";
        }

        AnimationSet getMongolianAnimation() {
            AnimationSet newMongolianAnimation = newMongolianAnimation();
            this.mongolianAnimation = newMongolianAnimation;
            return newMongolianAnimation;
        }

        AnimationSet newMongolianAnimation() {
            AnimationSet animationSet = new AnimationSet(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(150L);
            alphaAnimation.setFillEnabled(true);
            alphaAnimation.setFillBefore(true);
            animationSet.addAnimation(alphaAnimation);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(100L);
            alphaAnimation2.setStartOffset(500L);
            alphaAnimation2.setFillEnabled(true);
            alphaAnimation2.setFillBefore(false);
            animationSet.addAnimation(alphaAnimation2);
            animationSet.setFillEnabled(true);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(this);
            return animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.mongolianAnimation == animation) {
                this.haveMongolianStop = true;
            } else if (this.backgroundAnimation == animation) {
                this.haveBackgroundStop = true;
            } else if (this.typefaceAnimation == animation) {
                this.haveTypefaceStop = true;
            }
        }

        void resetStatus() {
            this.mongolianAnimation = null;
            this.backgroundAnimation = null;
            this.typefaceAnimation = null;
            this.haveMongolianStop = false;
            this.haveBackgroundStop = false;
            this.haveTypefaceStop = false;
        }

        void setHaveStopped() {
            this.haveMongolianStop = true;
            this.haveBackgroundStop = true;
            this.haveTypefaceStop = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
