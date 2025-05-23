package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MTVBaseFilter {
    public static final int PLAY_MODE_NONE = 0;
    public static final int PLAY_MODE_NORMAL = 1;
    public static final int PLAY_MODE_REVERSE = 2;
    private static final String TAG = "MTVBaseFilter";
    private int mFilterType;
    private String mMaterialPath;
    protected RandomGenerator mRandom = new RandomGenerator(System.currentTimeMillis());
    private int mWidth = 0;
    private int mHeight = 0;
    private boolean mRevert = false;
    private final float[] mReversetexMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private int mPlayMode = 0;
    private long mLastTime = -1;

    public MTVBaseFilter(int i3, String str) {
        this.mFilterType = -1;
        this.mFilterType = i3;
        this.mMaterialPath = str;
    }

    private boolean checkReset(long j3) {
        int i3 = this.mPlayMode;
        if (i3 == 0) {
            long j16 = this.mLastTime;
            if (j16 == -1) {
                this.mLastTime = j3;
                if (j3 == 0) {
                    return true;
                }
                return false;
            }
            if (j3 - j16 > 0) {
                this.mPlayMode = 1;
            } else if (j3 - j16 < 0) {
                this.mPlayMode = 2;
            } else {
                this.mPlayMode = 0;
            }
            if (j16 != 0) {
                this.mLastTime = j3;
                if (this.mPlayMode != 0) {
                    return true;
                }
                return false;
            }
            this.mLastTime = j3;
            return false;
        }
        if (i3 == 1) {
            if (j3 < this.mLastTime) {
                this.mLastTime = j3;
                this.mPlayMode = 0;
                if (j3 == 0) {
                    return true;
                }
                return false;
            }
            this.mLastTime = j3;
        } else if (i3 == 2) {
            if (j3 > this.mLastTime) {
                this.mLastTime = j3;
                this.mPlayMode = 0;
                if (j3 == 0) {
                    return true;
                }
                return false;
            }
            this.mLastTime = j3;
        }
        return false;
    }

    public boolean checkRandomTime(RandomTime randomTime, long j3, long j16, long j17, long j18) {
        if (randomTime == null || getPlayMode() == 0) {
            return false;
        }
        long j19 = getPlayMode() == 2 ? -1L : 1L;
        long j26 = randomTime.mStartPos;
        if (j26 < 0) {
            randomTime.mStartPos = (this.mRandom.nextLong(0L, j18) * j19) + j3;
            randomTime.mEndPos = (this.mRandom.nextLong(j16, j17) * j19) + randomTime.mStartPos;
        } else if ((j19 != 1 || j26 <= j3) && (j19 != -1 || j26 >= j3)) {
            if (j19 == 1 && randomTime.mEndPos > j3) {
                return true;
            }
            if (j19 == -1 && randomTime.mEndPos < j3) {
                return true;
            }
            if (randomTime.isLoop()) {
                randomTime.reset();
            }
        }
        return false;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getMaterialPath() {
        return this.mMaterialPath;
    }

    public int getPlayMode() {
        return this.mPlayMode;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean onDraw(RenderBuffer renderBuffer, int i3, long j3, float f16, float[] fArr, float[] fArr2) {
        SLog.d(TAG, "onDraw, inTexID:" + i3 + " currentMs:" + j3 + " musicScale:" + f16 + " playMode:" + this.mPlayMode + " lastTime:" + this.mLastTime);
        return false;
    }

    public void onDrawFrame(int i3, RenderBuffer renderBuffer, long j3, float f16) {
        float[] fArr;
        if (checkReset(j3)) {
            SLog.d(TAG, "onDrawFrame, need reset:" + j3);
            onReset(j3);
        }
        if (this.mRevert) {
            fArr = this.mReversetexMatrix;
        } else {
            fArr = null;
        }
        if (!onDraw(renderBuffer, i3, j3, f16, fArr, null)) {
            updateRendBuffer(renderBuffer, i3);
        }
    }

    public void onSurfaceChange(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public void revert(boolean z16) {
        this.mRevert = z16;
    }

    public void setSeed(long j3) {
        this.mRandom.setSeed(j3);
    }

    public boolean updateRendBuffer(RenderBuffer renderBuffer, int i3) {
        if (i3 >= 0) {
            if (i3 != renderBuffer.getTexId()) {
                renderBuffer.setTexId(i3);
            }
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TextParam {
        public boolean mChangeColor;
        public int mColor;
        public boolean mDistortion;
        public int mGlitchID;
        public RectF mRect;
        public boolean mShow;

        public TextParam() {
            this.mGlitchID = -1;
            this.mChangeColor = false;
            this.mColor = 0;
            this.mShow = false;
            this.mDistortion = false;
        }

        public TextParam(int i3, boolean z16, RectF rectF, boolean z17, int i16, boolean z18) {
            this.mGlitchID = i3;
            this.mRect = rectF;
            this.mChangeColor = z17;
            this.mColor = i16;
            this.mShow = z16;
            this.mDistortion = z18;
        }
    }

    public boolean checkRandomTime(RandomTime randomTime, long j3, long j16, long j17) {
        if (randomTime == null) {
            return false;
        }
        long j18 = getPlayMode() == 2 ? -1L : 1L;
        long j19 = randomTime.mStartPos;
        if (j19 < 0) {
            long nextLong = (this.mRandom.nextLong(0L, j17) * j18) + j3;
            randomTime.mStartPos = nextLong;
            randomTime.mEndPos = (j18 * j16) + nextLong;
        } else if ((j18 != 1 || j19 <= j3) && (j18 != -1 || j19 >= j3)) {
            if (j18 == 1 && randomTime.mEndPos > j3) {
                return true;
            }
            if (j18 == -1 && randomTime.mEndPos < j3) {
                return true;
            }
            if (randomTime.isLoop()) {
                randomTime.reset();
            }
        }
        return false;
    }

    public void onSurfaceDestroy() {
    }

    public void onReset(long j3) {
    }
}
