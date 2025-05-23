package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLAudioWaveN extends GLImageView {
    public static final int NUM_OF_COLUMN = 5;
    public static final int WAVE_COLUMN = 15;
    private float extraSizeH;
    private float extraSizeV;
    private float mHeightBlock;
    private Random mRandom;
    private RectF mSoundRegion;
    private float mTotalHeight;
    private float[] mWaveColumn;
    private RectF mWaveRegion;
    private float mWidthBlock;
    private float spacing;

    public GLAudioWaveN(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mWaveColumn = new float[15];
        this.mRandom = new Random();
        float pixelToRealPixel = DisplayUtils.pixelToRealPixel(2.0f);
        this.spacing = pixelToRealPixel;
        this.extraSizeH = (this.mWaveColumn.length - 1) * pixelToRealPixel;
        this.extraSizeV = pixelToRealPixel * 4.0f;
        this.mWaveRegion = new RectF();
        this.mSoundRegion = new RectF();
    }

    private void computeBlockSize() {
        int width = this.mBackGround.getWidth();
        int height = this.mBackGround.getHeight();
        float width2 = (this.mWaveRegion.width() - this.extraSizeH) / this.mWaveColumn.length;
        this.mWidthBlock = width2;
        float min = Math.min((this.mWaveRegion.height() - this.extraSizeV) / 5.0f, ((height * 1.0f) / width) * width2);
        this.mHeightBlock = min;
        this.mTotalHeight = (min * 5.0f) + this.extraSizeV;
    }

    private void drawColumn(float f16, float f17) {
        float f18 = this.mWaveRegion.bottom;
        float f19 = (int) f17;
        float f26 = this.mHeightBlock;
        this.mSoundRegion.set(f16, f18 - (((this.spacing + f26) * f19) + ((f17 - f19) * f26)), this.mWidthBlock + f16, f18);
        super.setImageClipDrawRegion(this.mSoundRegion);
        this.mSoundRegion.set(f16, f18 - this.mTotalHeight, this.mWidthBlock + f16, f18);
        super.setImageRegion(this.mSoundRegion);
        this.mEnableClip = true;
        super.draw();
    }

    private void generateWaveColumnValue() {
        for (int i3 = 0; i3 < this.mWaveColumn.length; i3++) {
            this.mRandom.setSeed(System.nanoTime());
            this.mWaveColumn[i3] = this.mRandom.nextFloat() * 5.0f;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        generateWaveColumnValue();
        float f16 = this.mWaveRegion.left;
        for (float f17 : this.mWaveColumn) {
            drawColumn(f16, f17);
            f16 += this.spacing + this.mWidthBlock;
        }
    }

    public void setWaveRegion(RectF rectF) {
        this.mWaveRegion.set(rectF);
        computeBlockSize();
    }
}
