package com.tencent.ttpic.openapi.manager;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public enum TouchTriggerManager {
    INSTANCE;

    public static final int ACTION_CLICK_AND_MOVE_SCREEN = 103;
    public static final int ACTION_DOUBLE_CLICK_SCREEN = 101;
    public static final int ACTION_LONG_CLICK_SCREEN = 102;
    public static final int ACTION_TAP_SCREEN = 100;
    private static final int ACTIVE_NOT_TOUCH = -1;
    private static final String TAG = TouchTriggerManager.class.getSimpleName();
    private static int mCurExpression = -1;
    private static PointF mCurPosition = new PointF();
    private static PointF mNextPosition = new PointF();
    private static long bgmTriggerTime = 0;
    private static float bgmClockTime = 0.0f;
    private static long musicStartTime = 0;
    private static int musicDuration = 0;
    private static int musicCurrentPosition = 0;
    private static int mTouchCount = 0;
    private static boolean isLocked = false;

    public static TouchTriggerManager getInstance() {
        return INSTANCE;
    }

    private int getTouchState(int i3) {
        if (i3 != 100) {
            mCurExpression = -1;
        } else {
            mCurExpression = PTFaceAttr.PTExpression.TAP_SCREEN.value;
        }
        return mCurExpression;
    }

    public void clear() {
        mCurExpression = -1;
        PointF pointF = mCurPosition;
        pointF.x = -1.0f;
        pointF.y = -1.0f;
        PointF pointF2 = mNextPosition;
        pointF2.x = 0.0f;
        pointF2.y = 0.0f;
        bgmClockTime = 0.0f;
        bgmTriggerTime = 0L;
        musicDuration = 0;
        musicStartTime = 0L;
        musicCurrentPosition = 0;
        isLocked = false;
        mTouchCount = 0;
    }

    public void clearAction() {
        isLocked = false;
    }

    public float getBgmClockTime() {
        return bgmClockTime;
    }

    public long getBgmTriggerTime() {
        return bgmTriggerTime;
    }

    public PointF getCurTouchPosition() {
        return mCurPosition;
    }

    public int getMusicCurrentPosition() {
        return musicCurrentPosition;
    }

    public int getMusicDuration() {
        return musicDuration;
    }

    public long getMusicStartTime() {
        return musicStartTime;
    }

    public int getTouchCount() {
        return mTouchCount;
    }

    public void lockAction() {
        isLocked = true;
    }

    public void reset() {
        mCurExpression = -1;
        PointF pointF = mCurPosition;
        pointF.x = -1.0f;
        pointF.y = -1.0f;
        PointF pointF2 = mNextPosition;
        pointF2.x = 0.0f;
        pointF2.y = 0.0f;
        bgmClockTime = 0.0f;
        bgmTriggerTime = 0L;
        musicDuration = 0;
        musicStartTime = 0L;
        musicCurrentPosition = 0;
        isLocked = false;
        mTouchCount = 0;
    }

    public void setBgmClockTime(float f16) {
        bgmClockTime = f16;
    }

    public void setBgmTriggerTime(long j3) {
        bgmTriggerTime = j3;
    }

    public void setMusicCurrentPosition(int i3) {
        musicCurrentPosition = i3;
    }

    public void setMusicDuration(int i3) {
        musicDuration = i3;
    }

    public void setMusicStartTime(long j3) {
        musicStartTime = j3;
    }

    public void setTouchState(int i3) {
        mCurExpression = getTouchState(i3);
        if (isLocked) {
            return;
        }
        mTouchCount++;
    }

    public void updateTouchTriggerState(PTDetectInfo pTDetectInfo) {
        Set<Integer> set;
        int i3;
        if (pTDetectInfo != null && (set = pTDetectInfo.triggeredExpression) != null && (i3 = mCurExpression) != -1) {
            set.add(Integer.valueOf(i3));
            PointF pointF = mCurPosition;
            PointF pointF2 = mNextPosition;
            pointF.x = pointF2.x;
            pointF.y = pointF2.y;
        } else {
            PointF pointF3 = mCurPosition;
            pointF3.x = -1.0f;
            pointF3.y = -1.0f;
        }
        mCurExpression = -1;
        PointF pointF4 = mNextPosition;
        pointF4.x = 0.0f;
        pointF4.y = 0.0f;
    }

    public void setTouchState(int i3, float f16, float f17) {
        mCurExpression = getTouchState(i3);
        PointF pointF = mNextPosition;
        pointF.x = f16;
        pointF.y = f17;
        if (isLocked) {
            return;
        }
        mTouchCount++;
    }
}
