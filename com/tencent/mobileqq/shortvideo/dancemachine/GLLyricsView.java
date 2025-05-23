package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLLyricsView extends GLImageView {
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private boolean mNeedDrawText;
    private Paint mShadowPaint;
    private Paint mStrokePaint;
    private Paint mTextPaint;
    private int textColor;
    private int textShadowPadding;
    private int textSize;
    private String textString;
    private float totalWidth;

    public GLLyricsView(GLViewContext gLViewContext, String str) {
        super(gLViewContext, str);
        this.mTextPaint = new Paint();
        this.totalWidth = 0.0f;
        this.textSize = 0;
        this.textShadowPadding = 0;
        initView(4);
    }

    public void clearTextCache() {
        this.textString = null;
        this.totalWidth = 0.0f;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GlView
    public void draw() {
        if (this.mNeedDrawText) {
            drawText();
        }
        super.draw();
    }

    public void drawText() {
        float textWidth = getTextWidth();
        int i3 = this.textShadowPadding;
        this.mBitmap = Bitmap.createBitmap((int) (textWidth + i3), this.textSize + i3, Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);
        this.mTextPaint.setTextSize(this.textSize);
        this.mTextPaint.setColor(this.textColor);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(true);
        this.mTextPaint.setDither(true);
        float abs = Math.abs(this.mTextPaint.getFontMetrics().ascent) + (this.textShadowPadding / 2);
        if (this.mStrokePaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mStrokePaint = textPaint;
            textPaint.setTextSize(this.textSize);
            this.mStrokePaint.setFakeBoldText(true);
            this.mStrokePaint.setAntiAlias(true);
            this.mStrokePaint.setColor(-12779354);
            this.mStrokePaint.setStrokeWidth(15.0f);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeJoin(Paint.Join.ROUND);
            this.mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
        }
        if (this.mShadowPaint == null) {
            TextPaint textPaint2 = new TextPaint();
            this.mShadowPaint = textPaint2;
            textPaint2.setTextSize(this.textSize);
            this.mShadowPaint.setFakeBoldText(true);
            this.mShadowPaint.setAntiAlias(true);
            this.mShadowPaint.setStrokeWidth(30.0f);
            this.mShadowPaint.setColor(-9636865);
            this.mShadowPaint.setStyle(Paint.Style.STROKE);
            this.mShadowPaint.setStrokeJoin(Paint.Join.ROUND);
            this.mShadowPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mShadowPaint.setShadowLayer(20.0f, 0.0f, 0.0f, -9636865);
        }
        this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, abs, this.mShadowPaint);
        this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, abs, this.mStrokePaint);
        this.mCanvas.drawText(this.textString, this.textShadowPadding / 2, abs, this.mTextPaint);
        super.setImageBitmap(this.mBitmap);
        this.mNeedDrawText = false;
    }

    public int getShadowPadding() {
        return this.textShadowPadding;
    }

    public int getTextHeight() {
        return this.textSize;
    }

    public float getTextWidth() {
        if (this.totalWidth == 0.0f) {
            this.mTextPaint.setTextSize(this.textSize);
            this.totalWidth = this.mTextPaint.measureText(this.textString);
        }
        return this.totalWidth;
    }

    public void setShadowPadding(int i3) {
        this.textShadowPadding = i3;
    }

    public void setText(String str, int i3) {
        this.textString = str;
        this.textColor = i3;
        this.mNeedDrawText = true;
    }

    public void setTextSize(int i3) {
        this.textSize = i3;
    }

    public void setmStrokePaint(Paint paint, Paint paint2) {
        this.mStrokePaint = paint;
        this.mShadowPaint = paint2;
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
    public void setImageBitmap(Bitmap bitmap) {
    }

    @Override // com.tencent.mobileqq.shortvideo.dancemachine.GLImageView
    public void setImageRes(String str) {
    }
}
