package com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GestureFilterManager extends VideoFilterBase {
    public static int GestureFilterManager_Layout_AV = 1;
    public static int GestureFilterManager_Layout_None = 0;
    public static int GestureFilterManager_Layout_ShortVideo = 0;
    public static final int MAX_GESTURE_NUMS = 3;
    public static final String TAG = "GestureFilterManager";
    public static volatile String sGestureTips = "";
    public static volatile String sGestureType = "";
    public static volatile int sLayoutType;
    private ArrayList<AnimationWrapper> deadQueue;
    private long lastConsumerTime;
    private volatile boolean mAllowedInsertAction;
    private int mCurrentAnimationNums;
    public int mGestureAnimGapTime;
    public int mGestureAnimType;
    public int mGesturePointIndex;
    private boolean mHasAdd;
    public StickerItem mItem;
    private GestureKeyInfo mLastGestureInfo;
    private AnimationWrapper mLastRecongnizeAnimation;
    private ArrayList<AnimationWrapper> runQueue;
    public long startTimes;
    private int[] tex;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class AnimationWrapper {
        public static final int ANIMATION_PLAY = 1;
        public static final int ANIMATION_STOP = 2;
        public NonFit2DFilter mFilter;
        public GestureKeyInfo mGestureInfo;
        private boolean mHasCallApplyGLSLFilter = false;
        private long deadlineTimeStamp = 0;

        public AnimationWrapper(StickerItem stickerItem, String str, GestureKeyInfo gestureKeyInfo, PointF pointF, boolean z16) {
            NonFit2DFilter nonFit2DFilter = new NonFit2DFilter(stickerItem, str);
            this.mFilter = nonFit2DFilter;
            this.mGestureInfo = gestureKeyInfo;
            nonFit2DFilter.updateFilterPosition(pointF);
        }

        public static boolean compareGestureInfo(GestureKeyInfo gestureKeyInfo, GestureKeyInfo gestureKeyInfo2, float f16) {
            if (Math.abs(gestureKeyInfo.hotPoints[0].x - gestureKeyInfo2.hotPoints[0].x) > f16 || Math.abs(gestureKeyInfo.hotPoints[0].y - gestureKeyInfo2.hotPoints[0].y) > f16) {
                return false;
            }
            return true;
        }

        public void clearGLSLSelf() {
            if (SLog.isEnable()) {
                SLog.d("TimGestureLog", "mFilter.clearGLSLSelf");
            }
            this.mFilter.clearGLSLSelf();
        }

        public void destroyAudio() {
            this.mFilter.destroyAudio();
        }

        public int getAnimationStatus(long j3) {
            if (this.mFilter.isAnimationPlay(j3)) {
                return 1;
            }
            return 2;
        }

        public long getDeadLineTimeStamp() {
            return this.deadlineTimeStamp;
        }

        public void renderTexture(int i3, int i16, int i17) {
            if (!this.mFilter.isHasCleared()) {
                this.mFilter.OnDrawFrameGLSL();
                this.mFilter.renderTexture(i3, i16, i17);
            }
        }

        public void resetAnimationEndStatus() {
            this.mFilter.resetAnimationEndStatus();
        }

        public void setRenderMode(int i3) {
            this.mFilter.setRenderMode(i3);
        }

        public void updateDeadLineTimeStamp(long j3) {
            this.deadlineTimeStamp = j3;
        }

        public void updateFilterPostion(GestureKeyInfo gestureKeyInfo, PointF pointF) {
            this.mGestureInfo = gestureKeyInfo;
            this.mFilter.updateFilterPosition(pointF);
        }

        public void updatePreview(PTDetectInfo pTDetectInfo) {
            this.mFilter.updatePreview(pTDetectInfo);
        }

        public void updateVideoSize(int i3, int i16, double d16) {
            if (!this.mHasCallApplyGLSLFilter) {
                this.mFilter.ApplyGLSLFilter();
                this.mFilter.setRenderMode(1);
                this.mHasCallApplyGLSLFilter = true;
            }
            this.mFilter.updateVideoSize(i3, i16, d16);
        }
    }

    public GestureFilterManager(StickerItem stickerItem, String str) {
        super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL));
        this.mCurrentAnimationNums = 0;
        this.mAllowedInsertAction = false;
        this.runQueue = new ArrayList<>();
        this.deadQueue = new ArrayList<>();
        this.lastConsumerTime = 0L;
        this.mLastRecongnizeAnimation = null;
        this.mLastGestureInfo = null;
        this.tex = new int[1];
        this.mGestureAnimType = -1;
        this.mGestureAnimGapTime = -1;
        this.mGesturePointIndex = -1;
        this.mHasAdd = false;
        this.mItem = stickerItem;
        this.mAllowedInsertAction = true;
        this.dataPath = str;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        super.ApplyGLSLFilter();
        this.startTimes = System.currentTimeMillis();
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void OnDrawFrameGLSL() {
        super.OnDrawFrameGLSL();
    }

    public void addAnimationToList(StickerItem stickerItem, GestureKeyInfo gestureKeyInfo, PointF pointF) {
        AnimationWrapper animationWrapper = new AnimationWrapper(stickerItem, this.dataPath, gestureKeyInfo, pointF, false);
        if (this.mCurrentAnimationNums <= 3 && this.mAllowedInsertAction) {
            animationWrapper.updateVideoSize(this.width, this.height, this.mFaceDetScale);
            this.runQueue.add(animationWrapper);
            this.mLastRecongnizeAnimation = animationWrapper;
            this.mCurrentAnimationNums++;
            if (SLog.isEnable()) {
                SLog.d(TAG, "have add complete ok here");
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean canUseBlendMode() {
        return true;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void clearGLSLSelf() {
        super.clearGLSLSelf();
        Iterator<AnimationWrapper> it = this.runQueue.iterator();
        while (it.hasNext()) {
            it.next().clearGLSLSelf();
        }
        Iterator<AnimationWrapper> it5 = this.deadQueue.iterator();
        while (it5.hasNext()) {
            it5.next().clearGLSLSelf();
        }
        this.runQueue.clear();
        this.deadQueue.clear();
        this.mCurrentAnimationNums = 0;
        this.mAllowedInsertAction = false;
    }

    public void destroyAudio() {
        Iterator<AnimationWrapper> it = this.runQueue.iterator();
        while (it.hasNext()) {
            it.next().destroyAudio();
        }
        Iterator<AnimationWrapper> it5 = this.deadQueue.iterator();
        while (it5.hasNext()) {
            it5.next().destroyAudio();
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.IntParam("texNeedTransform", -1));
        addParam(new UniformParam.IntParam(c.W, 1));
        addParam(new UniformParam.Float2fParam("displacement", 0.0f, 0.0f));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
    }

    public String printControllerInfo() {
        return "mGestureAnimType:=" + this.mGestureAnimType + ";" + this.mGestureAnimGapTime + ";" + this.mGesturePointIndex;
    }

    public void removeAnimationFromList() {
        Iterator<AnimationWrapper> it = this.runQueue.iterator();
        while (it.hasNext()) {
            it.next().clearGLSLSelf();
            this.mCurrentAnimationNums--;
        }
        this.runQueue.clear();
    }

    public void removeAnimationFromRunQueue(AnimationWrapper animationWrapper) {
        if (animationWrapper != null && this.runQueue.contains(animationWrapper)) {
            this.runQueue.remove(animationWrapper);
            this.mCurrentAnimationNums--;
            if (SLog.isEnable()) {
                SLog.d(TAG, "have remove animation here");
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean renderTexture(int i3, int i16, int i17) {
        Iterator<AnimationWrapper> it = this.runQueue.iterator();
        while (it.hasNext()) {
            it.next().renderTexture(i3, i16, i17);
        }
        Iterator<AnimationWrapper> it5 = this.deadQueue.iterator();
        while (it5.hasNext()) {
            it5.next().renderTexture(i3, i16, i17);
        }
        return true;
    }

    public void setControllerInfo(int i3, int i16, int i17) {
        this.mGestureAnimType = i3;
        this.mGestureAnimGapTime = i16;
        this.mGesturePointIndex = i17;
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public boolean setRenderMode(int i3) {
        return super.setRenderMode(i3);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
        PTDetectInfo pTDetectInfo;
        boolean z16;
        boolean z17;
        boolean z18;
        if (obj instanceof PTDetectInfo) {
            pTDetectInfo = (PTDetectInfo) obj;
        } else {
            pTDetectInfo = null;
        }
        if (pTDetectInfo == null) {
            return;
        }
        this.lastConsumerTime = System.currentTimeMillis();
        GestureKeyInfo gestureInfo = GestureMgrRecognize.getInstance().getGestureInfo();
        GestureKeyInfo gestureKeyInfo = this.mLastGestureInfo;
        if (gestureKeyInfo != null && gestureInfo.timeStamp == gestureKeyInfo.timeStamp) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mLastGestureInfo = gestureInfo;
        if (gestureInfo != null && gestureInfo.vaild && gestureInfo.type.equalsIgnoreCase(sGestureType) && z16) {
            if (SLog.isEnable()) {
                SLog.d(TAG, "gesture info is x" + gestureInfo.hotPoints[0].x + ":y =" + gestureInfo.hotPoints[0].y + "lastAnimation is " + this.mLastRecongnizeAnimation);
            }
            if (this.mGestureAnimType == 1) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                AnimationWrapper animationWrapper = this.mLastRecongnizeAnimation;
                if (animationWrapper != null) {
                    if (AnimationWrapper.compareGestureInfo(animationWrapper.mGestureInfo, gestureInfo, this.width * 0.08f)) {
                        if (this.mLastRecongnizeAnimation.getAnimationStatus(pTDetectInfo.timestamp) == 2) {
                            this.mLastRecongnizeAnimation.resetAnimationEndStatus();
                            this.mLastRecongnizeAnimation.updateFilterPostion(gestureInfo, gestureInfo.hotPoints[0]);
                            if (SLog.isEnable()) {
                                SLog.d(TAG, "update old point position");
                            }
                        } else if (SLog.isEnable()) {
                            SLog.d(TAG, "old animation is play now " + this.runQueue.contains(this.mLastRecongnizeAnimation) + " animation status is" + this.mLastRecongnizeAnimation.getAnimationStatus(pTDetectInfo.timestamp));
                        }
                    } else {
                        if (this.mLastRecongnizeAnimation.getAnimationStatus(pTDetectInfo.timestamp) == 2) {
                            this.mLastRecongnizeAnimation.clearGLSLSelf();
                            removeAnimationFromRunQueue(this.mLastRecongnizeAnimation);
                        } else {
                            this.mLastRecongnizeAnimation.updateDeadLineTimeStamp(pTDetectInfo.timestamp + this.mGestureAnimGapTime);
                            this.deadQueue.add(this.mLastRecongnizeAnimation);
                        }
                        addAnimationToList(this.mItem, gestureInfo, gestureInfo.hotPoints[0]);
                        if (SLog.isEnable()) {
                            SLog.d(TAG, "stop old point position");
                        }
                    }
                } else {
                    addAnimationToList(this.mItem, gestureInfo, gestureInfo.hotPoints[0]);
                }
            } else {
                Iterator<AnimationWrapper> it = this.runQueue.iterator();
                while (true) {
                    if (it.hasNext()) {
                        AnimationWrapper next = it.next();
                        if (AnimationWrapper.compareGestureInfo(next.mGestureInfo, gestureInfo, this.width * 0.08f)) {
                            if (next.getAnimationStatus(pTDetectInfo.timestamp) == 2) {
                                next.resetAnimationEndStatus();
                            }
                            next.updateFilterPostion(gestureInfo, gestureInfo.hotPoints[0]);
                            this.mLastRecongnizeAnimation = next;
                            z18 = true;
                        }
                    } else {
                        z18 = false;
                        break;
                    }
                }
                if (!z18) {
                    addAnimationToList(this.mItem, gestureInfo, gestureInfo.hotPoints[0]);
                }
            }
        } else if (!gestureInfo.vaild || !gestureInfo.type.equalsIgnoreCase(sGestureType)) {
            removeAnimationFromList();
            this.mLastRecongnizeAnimation = null;
        }
        Iterator<AnimationWrapper> it5 = this.runQueue.iterator();
        while (it5.hasNext()) {
            AnimationWrapper next2 = it5.next();
            if (next2.getAnimationStatus(pTDetectInfo.timestamp) == 2) {
                if (SLog.isEnable()) {
                    SLog.d(TAG, "runQueue remove this item " + next2 + " animation status is" + next2.getAnimationStatus(pTDetectInfo.timestamp));
                }
                if (next2 == this.mLastRecongnizeAnimation) {
                    this.mLastRecongnizeAnimation = null;
                }
                next2.clearGLSLSelf();
                it5.remove();
                this.mCurrentAnimationNums--;
            }
        }
        Iterator<AnimationWrapper> it6 = this.deadQueue.iterator();
        while (it6.hasNext()) {
            AnimationWrapper next3 = it6.next();
            if (next3.getAnimationStatus(pTDetectInfo.timestamp) == 2 || next3.getDeadLineTimeStamp() >= pTDetectInfo.timestamp) {
                if (SLog.isEnable()) {
                    SLog.d(TAG, "deadQueue remove this item " + next3);
                }
                next3.clearGLSLSelf();
                it6.remove();
            }
        }
        Iterator<AnimationWrapper> it7 = this.runQueue.iterator();
        while (it7.hasNext()) {
            it7.next().updatePreview(pTDetectInfo);
        }
        Iterator<AnimationWrapper> it8 = this.deadQueue.iterator();
        while (it8.hasNext()) {
            it8.next().updatePreview(pTDetectInfo);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        Iterator<AnimationWrapper> it = this.runQueue.iterator();
        while (it.hasNext()) {
            it.next().updateVideoSize(i3, i16, d16);
        }
    }

    protected void updatePositions(List<PointF> list, float[] fArr, float f16) {
    }
}
