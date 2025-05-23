package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TextLayer extends AnimatorLayer {
    private static final String ELLIPSIS = "...";
    private boolean mEllipsizeAtEnd;
    private float mLineSpacingExtra;
    private int mMaxLines = 1;
    private String mText;

    public TextLayer() {
        initPaint();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: all -> 0x009f, TRY_ENTER, TryCatch #1 {all -> 0x009f, blocks: (B:18:0x003e, B:23:0x004c, B:24:0x0057, B:26:0x007c, B:29:0x008e, B:31:0x0095), top: B:17:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[Catch: all -> 0x009f, TryCatch #1 {all -> 0x009f, blocks: (B:18:0x003e, B:23:0x004c, B:24:0x0057, B:26:0x007c, B:29:0x008e, B:31:0x0095), top: B:17:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawMultipleLineText(Canvas canvas) {
        String[] strArr;
        boolean z16;
        boolean z17;
        String str;
        String text = getText();
        int width = getWidth();
        if (width > 0 && text != null && text.length() > 0) {
            try {
                int ceil = (int) Math.ceil(getPaint().measureText(text) / width);
                int i3 = this.mMaxLines;
                if (ceil > i3) {
                    ceil = i3;
                    z16 = true;
                } else {
                    z16 = false;
                }
                strArr = new String[ceil];
                int i16 = 0;
                while (i16 < ceil) {
                    if (i16 == ceil - 1 && ceil > 1 && z16) {
                        try {
                            if (this.mEllipsizeAtEnd) {
                                z17 = true;
                                if (z17) {
                                    width = (int) (width - getPaint().measureText("..."));
                                }
                                int i17 = i16;
                                int breakText = getPaint().breakText(text, 0, text.length(), true, width, null);
                                String substring = text.substring(0, breakText);
                                if (z17) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(substring);
                                    if (this.mEllipsizeAtEnd) {
                                        str = "...";
                                    } else {
                                        str = "";
                                    }
                                    sb5.append(str);
                                    substring = sb5.toString();
                                }
                                strArr[i17] = substring;
                                text = text.substring(breakText);
                                i16 = i17 + 1;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                    int i172 = i16;
                    int breakText2 = getPaint().breakText(text, 0, text.length(), true, width, null);
                    String substring2 = text.substring(0, breakText2);
                    if (z17) {
                    }
                    strArr[i172] = substring2;
                    text = text.substring(breakText2);
                    i16 = i172 + 1;
                }
            } catch (Throwable unused2) {
            }
            if (!this.mMatrixChanged) {
                canvas.setMatrix(getMatrix());
                drawText(canvas, strArr);
                canvas.setMatrix(null);
                return;
            }
            drawText(canvas, strArr);
            return;
        }
        strArr = null;
        if (!this.mMatrixChanged) {
        }
    }

    private void drawSingleLineText(Canvas canvas) {
        String text = getText();
        int width = getWidth();
        if (width > 0 && text != null && text.length() > 0) {
            try {
                float f16 = width;
                if (getPaint().measureText(text) > f16) {
                    String str = "...";
                    if (this.mEllipsizeAtEnd) {
                        width = (int) (f16 - getPaint().measureText("..."));
                    }
                    int breakText = getPaint().breakText(text, 0, text.length(), true, width, null);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(text.substring(0, breakText));
                    if (!this.mEllipsizeAtEnd) {
                        str = "";
                    }
                    sb5.append(str);
                    text = sb5.toString();
                }
            } catch (Throwable unused) {
            }
        }
        if (this.mMatrixChanged) {
            canvas.setMatrix(getMatrix());
            canvas.drawText(text, getX(), getY(), getPaint());
            canvas.setMatrix(null);
            return;
        }
        canvas.drawText(text, getX(), getY(), getPaint());
    }

    private void drawText(Canvas canvas, String[] strArr) {
        Paint.FontMetrics fontMetrics;
        float abs;
        if (canvas != null && strArr != null) {
            Paint paint = getPaint();
            if (paint == null) {
                fontMetrics = null;
            } else {
                fontMetrics = paint.getFontMetrics();
            }
            float f16 = 0.0f;
            if (fontMetrics == null) {
                abs = 0.0f;
            } else {
                abs = Math.abs(fontMetrics.top);
            }
            float y16 = (getY() - abs) + getHeight();
            if (fontMetrics != null) {
                f16 = this.mLineSpacingExtra + Math.abs(fontMetrics.top);
            }
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                float f17 = i3 * f16;
                if (getY() + f17 <= y16) {
                    canvas.drawText(strArr[i3], getX(), getY() + f17, paint);
                }
            }
        }
    }

    private void initPaint() {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setFlags(1);
            this.mPaint.setAntiAlias(true);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        if (this.mMaxLines == 1) {
            drawSingleLineText(canvas);
        } else {
            drawMultipleLineText(canvas);
        }
    }

    public String getText() {
        String str = this.mText;
        if (str != null && this.mAlpha != 0) {
            return str;
        }
        return "";
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        return false;
    }

    public void setEllipsizeAtEnd(boolean z16) {
        this.mEllipsizeAtEnd = z16;
    }

    public void setLineSpacingExtra(float f16) {
        this.mLineSpacingExtra = f16;
    }

    public TextLayer setShadowLayer(float f16, float f17, float f18, int i3) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setShadowLayer(f16, f17, f18, i3);
        }
        return this;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public TextLayer setTextAlign(Paint.Align align) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTextAlign(align);
        }
        return this;
    }

    public TextLayer setTextBold(boolean z16) {
        Typeface typeface;
        Paint paint = this.mPaint;
        if (paint != null) {
            if (z16) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            paint.setTypeface(typeface);
        }
        return this;
    }

    public void setTextColor(int i3) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setTextSize(float f16) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTextSize(f16);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public AnimatorLayer setX(float f16) {
        return super.setX(f16);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public AnimatorLayer setY(float f16) {
        return super.setY(f16);
    }

    public TextLayer(String str, int i3, float f16) {
        this.mText = str;
        setTextColor(i3);
        setTextSize(f16);
        initPaint();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
    }
}
