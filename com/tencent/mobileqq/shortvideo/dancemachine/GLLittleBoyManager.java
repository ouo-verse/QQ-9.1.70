package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLLittleBoyManager implements Animation.AnimationListener {
    private GLViewContext context;
    private String key;
    private int mCurrentScoreLevel;
    private float mDistanceX20;
    private float mDistanceX40;
    private float mDistanceX60;
    private float mDistanceX80;
    private boolean mHaveMatched;
    private boolean mHaveMissed;
    private int mScoreTotal;
    private ArrayList<GLLittleBoy> mLittleBoyList = new ArrayList<>();
    private RectF mRecognizeRegion = new RectF();
    private ArrayList<GLLittleBoy> mDeadBoyList = new ArrayList<>();
    private RectF[] mLittleBoyColum = new RectF[2];
    private RectF mCurrentBlastRegion = new RectF();
    private int mLittleBoyCount = 0;
    private final int mOffsetBoy = 65;
    private float halfSizeDismiss = 0.0f;
    private Comparator<GLLittleBoy> mCompare = new Comparator<GLLittleBoy>() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.4
        @Override // java.util.Comparator
        public int compare(GLLittleBoy gLLittleBoy, GLLittleBoy gLLittleBoy2) {
            int centerY = (int) gLLittleBoy.getCurrentDrawRegionSize().centerY();
            gLLittleBoy.mCurrentCenterY = centerY;
            int centerY2 = (int) gLLittleBoy2.getCurrentDrawRegionSize().centerY();
            gLLittleBoy2.mCurrentCenterY = centerY2;
            if (centerY < centerY2) {
                return -1;
            }
            return centerY > centerY2 ? 1 : 0;
        }
    };
    private long mStartRecordMis = 0;
    private TreeSet<GLLittleBoy> mSortedLittleBoyList = new TreeSet<>(this.mCompare);

    public GLLittleBoyManager(GLViewContext gLViewContext, String str) {
        this.context = gLViewContext;
        this.key = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDeadListLittleBoy(Animation animation) {
        for (int i3 = 0; i3 < this.mLittleBoyList.size(); i3++) {
            GLLittleBoy gLLittleBoy = this.mLittleBoyList.get(i3);
            if (gLLittleBoy.getAnimation() == animation) {
                addDeadListLittleBoy(gLLittleBoy);
                return;
            }
        }
    }

    private void adjustLittleBoyRegion(int i3, int i16, int i17) {
        Rect surfaceViewSize = this.context.getSurfaceViewSize();
        int width = surfaceViewSize.width();
        int height = surfaceViewSize.height();
        ResourceManager resourceManager = ResourceManager.getInstance();
        if (resourceManager.isCompressed) {
            float f16 = resourceManager.compressRatio;
            i16 = (int) (i16 / f16);
            i17 = (int) (i17 / f16);
        }
        int i18 = (int) (i16 * 0.82f);
        int i19 = (int) (i17 * 0.82f);
        if (i3 == 0) {
            this.mLittleBoyColum[0].set(DisplayUtils.pixelToRealPixel(65.0f), height, DisplayUtils.pixelToRealPixel(i18 + 65), height + DisplayUtils.pixelToRealPixel(i19));
        } else {
            this.mLittleBoyColum[1] = new RectF(width - DisplayUtils.pixelToRealPixel(i18 + 65), height, width - DisplayUtils.pixelToRealPixel(65.0f), height + DisplayUtils.pixelToRealPixel(i19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeLittleBoyMissStatus(Animation animation) {
        for (int i3 = 0; i3 < this.mLittleBoyList.size(); i3++) {
            GLLittleBoy gLLittleBoy = this.mLittleBoyList.get(i3);
            if (gLLittleBoy.getAnimation() == animation && gLLittleBoy.mIsValidBoy) {
                gLLittleBoy.mMissed = true;
                DanceLog.print("changeLittleBoyMissStatus", "[false]ID=" + gLLittleBoy.getDanceData().f287854id + " index" + gLLittleBoy.mIndex + " centerY=" + gLLittleBoy.getCurrentDrawRegionSize().centerY() + " top=" + this.mRecognizeRegion.top);
            }
        }
    }

    private Animation getLittleBoyAnimation(GLLittleBoy gLLittleBoy, double d16) {
        RectF imageRegion = gLLittleBoy.getImageRegion();
        imageRegion.height();
        this.context.getViewPortRatio();
        float f16 = imageRegion.left;
        TranslateAnimation translateAnimation = new TranslateAnimation(f16, f16, imageRegion.top, 0.0f);
        translateAnimation.setDuration((int) ((1.0d / d16) * 1000.0d));
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GLLittleBoyManager.this.changeLittleBoyMissStatus(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        return translateAnimation;
    }

    private Animation getMissedAnimation() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.5f));
        animationSet.setFillEnabled(true);
        animationSet.setFillAfter(true);
        animationSet.setDuration(160L);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GLLittleBoyManager.this.addDeadListLittleBoy(animation);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        return animationSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void judgeHaveMatchedItemsAndComputeScore() {
        int i3;
        int i16;
        this.mHaveMatched = false;
        this.mHaveMissed = false;
        this.mCurrentScoreLevel = -1;
        Iterator<GLLittleBoy> it = this.mLittleBoyList.iterator();
        while (it.hasNext()) {
            GLLittleBoy next = it.next();
            if (!next.mIsValidBoy) {
                makeSureBoyIsInvalid(next);
            } else {
                if (next.mMatched) {
                    this.mHaveMatched = true;
                    float centerY = next.getCurrentDrawRegionSize().centerY() - this.mRecognizeRegion.top;
                    if (centerY <= 0.0f) {
                        next.mMissed = true;
                        next.mNeedMatch = false;
                    } else {
                        float f16 = this.mDistanceX20;
                        if (centerY >= f16) {
                            float f17 = this.mDistanceX80;
                            if (centerY <= f17) {
                                if ((centerY >= f16 && centerY <= this.mDistanceX40) || (centerY >= this.mDistanceX60 && centerY <= f17)) {
                                    i3 = 40;
                                    this.mScoreTotal += 40;
                                    next.mMatchedStatus = 2;
                                } else {
                                    i3 = 50;
                                    this.mScoreTotal += 50;
                                    next.mMatchedStatus = 3;
                                }
                                next.mDataReport.mScore = i3;
                                i16 = next.mMatchedStatus;
                                if (i16 > this.mCurrentScoreLevel) {
                                    this.mCurrentScoreLevel = i16;
                                }
                            }
                        }
                        i3 = 20;
                        this.mScoreTotal += 20;
                        next.mMatchedStatus = 1;
                        next.mDataReport.mScore = i3;
                        i16 = next.mMatchedStatus;
                        if (i16 > this.mCurrentScoreLevel) {
                        }
                    }
                }
                RectF currentDrawRegionSize = next.getCurrentDrawRegionSize();
                float centerY2 = currentDrawRegionSize.centerY();
                if (centerY2 <= this.mRecognizeRegion.top) {
                    next.mMissed = true;
                    next.mNeedMatch = false;
                    DanceLog.print("HaveMatchedItems", "[true]ID=" + next.getDanceData().f287854id + " index" + next.mIndex + " centerY=" + centerY2 + " top=" + this.mRecognizeRegion.top);
                } else {
                    DanceLog.print("HaveMatchedItems", "[false]ID=" + next.getDanceData().f287854id + " index" + next.mIndex + " centerY=" + centerY2 + " top=" + this.mRecognizeRegion.top + " [AccumulationBug]region.top=" + currentDrawRegionSize.top);
                }
                if (next.mMissed) {
                    next.mMatchedStatus = 0;
                    this.mHaveMissed = true;
                }
            }
        }
    }

    private void judgeLittleBoyValidate() {
        Iterator<GLLittleBoy> it = this.mLittleBoyList.iterator();
        while (it.hasNext()) {
            GLLittleBoy next = it.next();
            if (!next.mIsValidBoy) {
                makeSureBoyIsInvalid(next);
                next.mNeedMatch = false;
            } else {
                RectF currentDrawRegionSize = next.getCurrentDrawRegionSize();
                float centerY = currentDrawRegionSize.centerY();
                next.resetValidBoyStatus();
                RectF rectF = this.mRecognizeRegion;
                if (centerY >= rectF.bottom) {
                    next.mNeedMatch = false;
                } else if (centerY <= rectF.top) {
                    next.mMissed = true;
                    next.mNeedMatch = false;
                    DanceLog.print("judgeLittleBoyValidate", "[true]ID=" + next.getDanceData().f287854id + " index" + next.mIndex + " centerY=" + centerY + " top=" + this.mRecognizeRegion.top);
                } else {
                    DanceLog.print("judgeLittleBoyValidate", "[false]ID=" + next.getDanceData().f287854id + " index" + next.mIndex + " centerY=" + centerY + " top=" + this.mRecognizeRegion.top + " [AccumulationBug]region.top=" + currentDrawRegionSize.top);
                    if (currentDrawRegionSize.top <= 0.0f) {
                        float f16 = centerY - this.mRecognizeRegion.top;
                        if (f16 < 45.0f) {
                            next.mMissed = true;
                            next.mNeedMatch = false;
                        } else {
                            throw new RuntimeException("judgeLittleBoyValidate:centerY=" + centerY + " mRecognizeRegion.top" + this.mRecognizeRegion.top + " diff=" + f16 + " \u56fe\u7247\u8fc7\u5927,\u8bbe\u8ba1\u4f18\u5316\u8d44\u6e90");
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private void makeSureBoyIsInvalid(GLLittleBoy gLLittleBoy) {
        if (!gLLittleBoy.mIsValidBoy && !gLLittleBoy.mMatched && !gLLittleBoy.mMissed) {
            throw new RuntimeException("\u5bf9\u8c61\u4e0d\u662f\u65e0\u6548\u5bf9\u8c61,mMatched=false mMissed=false");
        }
    }

    private void sortByCenterHeightValue() {
        this.mSortedLittleBoyList.clear();
        Iterator<GLLittleBoy> it = this.mLittleBoyList.iterator();
        while (it.hasNext()) {
            this.mSortedLittleBoyList.add(it.next());
        }
    }

    public void clearStatus() {
        this.mDeadBoyList.clear();
        this.mLittleBoyList.clear();
        this.mSortedLittleBoyList.clear();
        this.mStartRecordMis = 0L;
        this.mScoreTotal = 0;
        this.mHaveMatched = false;
        this.mHaveMissed = false;
        this.mLittleBoyCount = 0;
        this.mCurrentScoreLevel = -1;
        Iterator<ResourceManager.DancePosture> it = ResourceManager.getInstance().getDancePostures().iterator();
        while (it.hasNext()) {
            it.next().haveCreated = false;
        }
    }

    public void drawFrame() {
        if (this.mStartRecordMis > 0) {
            judgeHaveMatchedItemsAndComputeScore();
            generateNewLittleBoy();
            Iterator<GLLittleBoy> it = this.mLittleBoyList.iterator();
            while (it.hasNext()) {
                GLLittleBoy next = it.next();
                if (next.mIsValidBoy) {
                    if (next.mMissed) {
                        next.mIsValidBoy = false;
                        initLittleBoyNewRegion(next, false);
                        BoyDataReport.BoyItem boyItem = next.mDataReport;
                        boyItem.mEnd = true;
                        boyItem.status = 0;
                        BoyDataReport boyDataReport = this.context.mReport;
                        if (!boyDataReport.mHasReported) {
                            boyDataReport.mBoyData.add(boyItem);
                        }
                    }
                    if (next.mMatched) {
                        next.mIsValidBoy = false;
                        initLittleBoyNewRegion(next, true);
                        BoyDataReport.BoyItem boyItem2 = next.mDataReport;
                        boyItem2.mEnd = true;
                        boyItem2.status = next.mMatchedStatus;
                        BoyDataReport boyDataReport2 = this.context.mReport;
                        if (!boyDataReport2.mHasReported) {
                            boyDataReport2.mBoyData.add(boyItem2);
                        }
                    }
                } else {
                    makeSureBoyIsInvalid(next);
                }
                next.draw();
            }
            Iterator<GLLittleBoy> it5 = this.mDeadBoyList.iterator();
            while (it5.hasNext()) {
                GLLittleBoy next2 = it5.next();
                if (!next2.mIsValidBoy) {
                    this.mLittleBoyList.remove(next2);
                } else {
                    throw new RuntimeException("\u72b6\u6001\u9519\u8bef,\u6e05\u7406\u7684\u5bf9\u8c61\u662f\u6709\u6548\u5bf9\u8c61");
                }
            }
            this.mDeadBoyList.clear();
        }
    }

    public void generateNewLittleBoy() {
        float uptimeMillis = ((float) ((SystemClock.uptimeMillis() - this.mStartRecordMis) / 100)) / 10.0f;
        ResourceManager resourceManager = ResourceManager.getInstance();
        for (ResourceManager.DancePosture dancePosture : resourceManager.getDancePostures()) {
            if (dancePosture.appearTime <= uptimeMillis && !dancePosture.haveCreated) {
                GLLittleBoy gLLittleBoy = new GLLittleBoy(this.context, this.key);
                gLLittleBoy.setAnimationFrames(resourceManager.getPostureById(dancePosture.f287854id).danceCartoon);
                gLLittleBoy.setAnimationPlayMode(1);
                gLLittleBoy.setLoadTextureMode(1);
                gLLittleBoy.setFrameDuration(62.0f);
                gLLittleBoy.initAnimationFrame();
                gLLittleBoy.setFrameAnimationParams(dancePosture);
                int i3 = this.mLittleBoyCount;
                this.mLittleBoyCount = i3 + 1;
                gLLittleBoy.mIndex = i3;
                GLImage imageSize = gLLittleBoy.getImageSize();
                int i16 = dancePosture.appearCol - 1;
                adjustLittleBoyRegion(i16, imageSize.getWidth(), imageSize.getHeight());
                RectF rectF = this.mLittleBoyColum[i16];
                gLLittleBoy.setImageRegion(rectF);
                gLLittleBoy.setImageClipDrawRegion(rectF);
                gLLittleBoy.setVisibility(true);
                gLLittleBoy.startAnimation(getLittleBoyAnimation(gLLittleBoy, dancePosture.speed));
                this.mLittleBoyList.add(gLLittleBoy);
                dancePosture.haveCreated = true;
                BoyDataReport.BoyItem boyItem = gLLittleBoy.mDataReport;
                boyItem.mEnd = false;
                boyItem.mId = gLLittleBoy.getDanceData().f287854id;
            }
        }
    }

    public Animation getBlastAnimation() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setFillEnabled(true);
        animationSet.setFillAfter(true);
        animationSet.setDuration(130L);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setAnimationListener(this);
        return animationSet;
    }

    public TreeSet<GLLittleBoy> getItems() {
        judgeLittleBoyValidate();
        sortByCenterHeightValue();
        return this.mSortedLittleBoyList;
    }

    public Animation getMatchedAnimation() {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100L);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillBefore(true);
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.1f, 0.0f, 1.1f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setStartOffset(100L);
        scaleAnimation2.setFillEnabled(true);
        scaleAnimation2.setFillBefore(false);
        animationSet.addAnimation(scaleAnimation2);
        animationSet.setFillEnabled(true);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                for (int i3 = 0; i3 < GLLittleBoyManager.this.mLittleBoyList.size(); i3++) {
                    GLLittleBoy gLLittleBoy = (GLLittleBoy) GLLittleBoyManager.this.mLittleBoyList.get(i3);
                    if (gLLittleBoy.getAnimation() == animation) {
                        gLLittleBoy.setFilterPrivateImage(ResourceManager.getInstance().getPostureById(gLLittleBoy.getDanceData().f287854id).blastPicture, true, true);
                        RectF saveMatchedPointRegion = gLLittleBoy.getSaveMatchedPointRegion();
                        if (GLLittleBoyManager.this.halfSizeDismiss == 0.0f) {
                            GLLittleBoyManager.this.halfSizeDismiss = saveMatchedPointRegion.width() / 2.2f;
                        }
                        float centerX = saveMatchedPointRegion.centerX();
                        float centerY = saveMatchedPointRegion.centerY();
                        GLLittleBoyManager.this.mCurrentBlastRegion.set(centerX - GLLittleBoyManager.this.halfSizeDismiss, centerY - GLLittleBoyManager.this.halfSizeDismiss, centerX + GLLittleBoyManager.this.halfSizeDismiss, centerY + GLLittleBoyManager.this.halfSizeDismiss);
                        gLLittleBoy.setConvertedImageAndClipRegion(GLLittleBoyManager.this.mCurrentBlastRegion);
                        gLLittleBoy.clearAnimation();
                        gLLittleBoy.startAnimation(GLLittleBoyManager.this.getBlastAnimation());
                        return;
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        return animationSet;
    }

    public int getShowStatus() {
        if (this.mHaveMatched) {
            int i3 = this.mCurrentScoreLevel;
            if (i3 != -1) {
                return i3;
            }
            throw new RuntimeException("\u5339\u914d\u6210\u529f\uff0c\u4f46\u662f\u72b6\u6001\u4e0d\u5bf9.mHaveMatched=true,mCurrentScoreLevel=" + this.mCurrentScoreLevel);
        }
        if (!this.mHaveMissed) {
            return -1;
        }
        return 0;
    }

    public int getTotalScore() {
        return this.mScoreTotal;
    }

    public void initLittleBoyBeginRegion() {
        Rect surfaceViewSize = this.context.getSurfaceViewSize();
        int width = surfaceViewSize.width();
        float height = surfaceViewSize.height();
        float f16 = 315;
        float f17 = 400;
        this.mLittleBoyColum[0] = new RectF(DisplayUtils.pixelToRealPixel(65.0f), height, DisplayUtils.pixelToRealPixel(f16), DisplayUtils.pixelToRealPixel(f17) + r0);
        this.mLittleBoyColum[1] = new RectF(width - DisplayUtils.pixelToRealPixel(f16), height, width - DisplayUtils.pixelToRealPixel(65.0f), r0 + DisplayUtils.pixelToRealPixel(f17));
    }

    public void initLittleBoyNewRegion(GLLittleBoy gLLittleBoy, boolean z16) {
        gLLittleBoy.saveMatchedPointRegion();
        gLLittleBoy.setConvertedImageAndClipRegion(gLLittleBoy.getSaveMatchedPointRegion());
        gLLittleBoy.clearAnimation();
        if (z16) {
            if (gLLittleBoy.mMatched) {
                gLLittleBoy.startAnimation(getMatchedAnimation());
                return;
            }
            throw new RuntimeException("initLittleBoyNewRegion,\u72b6\u6001\u9519\u8bef mMatched=false");
        }
        if (gLLittleBoy.mMissed) {
            gLLittleBoy.startAnimation(getMissedAnimation());
            return;
        }
        throw new RuntimeException("initLittleBoyNewRegion,\u72b6\u6001\u9519\u8bef mMissed=false");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        addDeadListLittleBoy(animation);
    }

    public void updateRecognizeRegion(RectF rectF) {
        if (!this.mRecognizeRegion.equals(rectF)) {
            this.mRecognizeRegion.set(rectF);
            this.context.mapNormalRegion(this.mRecognizeRegion);
        }
        float height = this.mRecognizeRegion.height() / 5.0f;
        this.mDistanceX20 = height;
        this.mDistanceX40 = 2.0f * height;
        this.mDistanceX60 = 3.0f * height;
        this.mDistanceX80 = height * 4.0f;
    }

    public void updateStartTimestamp(long j3) {
        this.mStartRecordMis = j3;
        this.mScoreTotal = 0;
        this.mHaveMatched = false;
    }

    private void addDeadListLittleBoy(GLLittleBoy gLLittleBoy) {
        if (!gLLittleBoy.mIsValidBoy) {
            gLLittleBoy.setVisibility(false);
            gLLittleBoy.clearAnimation();
            gLLittleBoy.clearStatus();
            this.mDeadBoyList.add(gLLittleBoy);
            return;
        }
        throw new RuntimeException("\u72b6\u6001\u9519\u8bef,\u6d88\u5931\u52a8\u753b\u7684\u5bf9\u8c61\u662f\u6709\u6548\u5bf9\u8c61");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
