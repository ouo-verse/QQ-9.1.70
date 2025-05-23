package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLScoreBoard extends GLFrameImage {
    public static final int MAX_SCORE = 99999;
    private float heightBoard;
    private boolean mHasComputeWidth;
    private int mInterval;
    private float mNumberImageSlope;
    private RectF mNumberRegion;
    private float mNumberWidthSize;
    private RectF mParentSize;
    private int mScore;
    private RectF mScoreBoardSize;
    private int[] number;
    private float widthBoard;
    private float xOffsetFromParent;
    private float yOffsetFromParent;

    public GLScoreBoard(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mScoreBoardSize = new RectF();
        this.mParentSize = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mNumberRegion = new RectF();
        this.number = new int[5];
        this.mNumberImageSlope = 0.25f;
        this.mHasComputeWidth = false;
        this.xOffsetFromParent = 0.0f;
        this.yOffsetFromParent = 0.0f;
        setTemporaryRelease(false);
    }

    private void computeNumberWidthSize() {
        if (!this.mHasComputeWidth) {
            GLImage imageByIndex = getImageByIndex(0);
            this.mNumberWidthSize = ((imageByIndex.getWidth() * 1.0f) / imageByIndex.getHeight()) * this.mScoreBoardSize.height();
            this.mHasComputeWidth = true;
        }
    }

    private void computeOffsetFromParen() {
        RectF rectF = this.mScoreBoardSize;
        float f16 = rectF.left;
        RectF rectF2 = this.mParentSize;
        this.xOffsetFromParent = f16 - rectF2.left;
        this.yOffsetFromParent = rectF.top - rectF2.top;
    }

    private void computeScoreNumberAndDraw() {
        float width;
        float f16;
        float f17;
        float f18;
        int i3;
        RectF rectF = this.mScoreBoardSize;
        RectF rectF2 = this.mParentSize;
        float f19 = rectF2.left + this.xOffsetFromParent;
        rectF.left = f19;
        float f26 = rectF2.top + this.yOffsetFromParent;
        rectF.top = f26;
        rectF.right = f19 + this.widthBoard;
        rectF.bottom = f26 + this.heightBoard;
        int[] iArr = this.number;
        int i16 = this.mScore;
        int i17 = i16 / 10000;
        int i18 = 4;
        iArr[4] = i17;
        int i19 = i16 % 10000;
        int i26 = i19 / 1000;
        iArr[3] = i26;
        int i27 = i19 % 1000;
        int i28 = i27 / 100;
        iArr[2] = i28;
        int i29 = i27 % 100;
        int i36 = i29 / 10;
        iArr[1] = i36;
        iArr[0] = i29 % 10;
        if (i17 == 0) {
            if (i26 == 0) {
                if (i28 == 0) {
                    if (i36 == 0) {
                        i18 = 1;
                    } else {
                        i18 = 2;
                    }
                } else {
                    i18 = 3;
                }
            }
        } else {
            i18 = 5;
        }
        float f27 = i18;
        int i37 = i18 - 1;
        float f28 = (this.mNumberWidthSize * f27) + (this.mInterval * i37);
        if (rectF.width() >= f28) {
            width = this.mNumberWidthSize;
            RectF rectF3 = this.mScoreBoardSize;
            f16 = rectF3.top;
            f17 = rectF3.bottom;
            f18 = (((rectF3.width() - f28) / 2.0f) + this.mScoreBoardSize.left) - (this.mNumberImageSlope * width);
        } else {
            width = (this.mScoreBoardSize.width() - (i37 * this.mInterval)) / f27;
            GLImage imageByIndex = getImageByIndex(0);
            float height = ((imageByIndex.getHeight() * 1.0f) / imageByIndex.getWidth()) * width;
            if (height >= this.mScoreBoardSize.height()) {
                RectF rectF4 = this.mScoreBoardSize;
                float f29 = rectF4.top;
                f17 = rectF4.bottom;
                f16 = f29;
            } else {
                float height2 = (this.mScoreBoardSize.height() - height) / 2.0f;
                RectF rectF5 = this.mScoreBoardSize;
                f16 = rectF5.top + height2;
                f17 = rectF5.bottom - height2;
            }
            f18 = this.mScoreBoardSize.left;
        }
        for (int i38 = i18; i38 > 0; i38--) {
            if (i38 == i18) {
                i3 = 0;
            } else {
                i3 = this.mInterval;
            }
            int i39 = this.number[i38 - 1];
            float f36 = f18 + i3;
            this.mNumberRegion.set(f36, f16, f36 + width, f17);
            super.setImageClipDrawRegion(this.mNumberRegion);
            super.setImageRegion(this.mNumberRegion);
            super.setCurrentImage(i39);
            super.draw();
            f18 = this.mNumberRegion.right;
        }
    }

    public void changeParentSize(RectF rectF) {
        this.mParentSize.set(rectF);
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        computeNumberWidthSize();
        computeScoreNumberAndDraw();
    }

    public int getScore() {
        return this.mScore;
    }

    public void setNumberImageSlope(float f16) {
        this.mNumberImageSlope = f16;
    }

    public void setNumberInterval(int i3) {
        this.mInterval = i3;
    }

    public void setScore(int i3) {
        this.mScore = i3;
        if (i3 > 99999) {
            this.mScore = 99999;
        }
    }

    public void setScoreBoardSize(RectF rectF) {
        if (!this.mScoreBoardSize.equals(rectF)) {
            this.mScoreBoardSize.set(rectF);
            this.widthBoard = this.mScoreBoardSize.width();
            this.heightBoard = this.mScoreBoardSize.height();
        }
        computeOffsetFromParen();
    }

    public void setScoreBoardSize(RectF rectF, RectF rectF2) {
        this.mParentSize.set(rectF2);
        setScoreBoardSize(rectF);
    }
}
