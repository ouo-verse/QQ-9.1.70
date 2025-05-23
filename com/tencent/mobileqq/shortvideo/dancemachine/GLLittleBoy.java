package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLLittleBoy extends GLFrameImage {
    public boolean isReadyMatch;
    int mCurrMatchTimes;
    private RectF mCurrentCacheRegion;
    int mCurrentCenterY;
    BoyDataReport.BoyItem mDataReport;
    private boolean mEnableFrameAnimation;
    public int mIndex;
    boolean mIsValidBoy;
    boolean mMatched;
    int mMatchedStatus;
    int mMaxMatchTimes;
    boolean mMissed;
    boolean mNeedContinuousMatch;
    boolean mNeedMatch;
    private ResourceManager.DancePosture mPrivateDanceData;

    public GLLittleBoy(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mCurrentCacheRegion = new RectF();
        this.mEnableFrameAnimation = true;
        this.mCurrMatchTimes = 0;
        this.mMaxMatchTimes = 1;
        this.mNeedContinuousMatch = true;
        this.mDataReport = new BoyDataReport.BoyItem();
        this.isReadyMatch = false;
        resetValidBoyStatus();
        this.mIsValidBoy = true;
        this.mEnableFrameAnimation = true;
        this.mIsBoyFilterPrivateRes = true;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage, com.tencent.mobileqq.shortvideo.dancemachine.GLImageView, com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void clearStatus() {
        super.clearStatus();
        resetValidBoyStatus();
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        if (this.mVisible && this.mEnableFrameAnimation) {
            startFrameAnimation();
            setCurrentImage(getAnimationCurrentIndex());
        }
        super.draw();
    }

    public ResourceManager.DancePosture getDanceData() {
        return this.mPrivateDanceData;
    }

    public RectF getSaveMatchedPointRegion() {
        return this.mCurrentCacheRegion;
    }

    public boolean isMatched() {
        return this.mMatched;
    }

    public boolean needDoMatch() {
        return this.mNeedMatch;
    }

    public void resetValidBoyStatus() {
        this.mNeedMatch = true;
        this.mMissed = false;
        this.mMatched = false;
        this.mMatchedStatus = -1;
    }

    public void saveMatchedPointRegion() {
        this.mCurrentCacheRegion.set(getCurrentDrawRegionSize());
    }

    public void setFilterPrivateImage(String str, boolean z16, boolean z17) {
        GLImage imageByPath = GLFrameImage.getImageByPath(str, z16, z17);
        DanceLog.printFrameQueue("GLFrameImage", "GLLittleBoy:getImageByPath");
        this.mCurrentTexture = imageByPath.getTexture();
        this.mEnableFrameAnimation = false;
    }

    public void setFrameAnimationParams(ResourceManager.DancePosture dancePosture) {
        this.mPrivateDanceData = dancePosture;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
    public void setImageRes(String str) {
        setFilterPrivateImage(str, false, false);
    }

    public void setMatch(boolean z16) {
        if (z16) {
            int i3 = this.mCurrMatchTimes + 1;
            this.mCurrMatchTimes = i3;
            if (i3 >= this.mMaxMatchTimes) {
                this.mMatched = z16;
                this.mCurrMatchTimes = 0;
                return;
            }
            return;
        }
        this.mMatched = z16;
        if (this.mNeedContinuousMatch) {
            this.mCurrMatchTimes = 0;
        }
    }

    public void setMaxMatchTimes(int i3, boolean z16) {
        if (i3 < 1) {
            this.mMaxMatchTimes = 1;
        } else {
            this.mMaxMatchTimes = i3;
        }
        this.mNeedContinuousMatch = z16;
    }
}
