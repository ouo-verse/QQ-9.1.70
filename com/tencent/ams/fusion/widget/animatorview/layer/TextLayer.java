package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import com.tencent.ams.fusion.widget.animatorview.AnimatorUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_ = null;
    private static final String ELLIPSIS = "...";
    Camera mCamera;
    private boolean mEllipsizeAtEnd;
    private float mLineSpacingExtra;
    private int mMaxLines;
    private int mShadowColor;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;
    private String mText;

    public TextLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMaxLines = 1;
        this.mCamera = new Camera();
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

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
        } else if (this.mMaxLines == 1) {
            drawSingleLineText(canvas);
        } else {
            drawMultipleLineText(canvas);
        }
    }

    public String getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        String str = this.mText;
        if (str != null && this.mAlpha != 0) {
            return str;
        }
        return "";
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public boolean isMatrixNeedPreTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        super.postAlpha(i3);
        if (this.mPaint != null && (i16 = this.mShadowColor) > 0 && Build.VERSION.SDK_INT >= 29) {
            this.mPaint.setShadowLayer(this.mShadowRadius, this.mShadowDx, this.mShadowDy, AnimatorUtils.getColorWithAlpha((i3 * AnimatorUtils.getAlphaForColor(i16)) / 255, this.mShadowColor));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postTranslate(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            super.postTranslate(f16, f17);
        }
    }

    public void setEllipsizeAtEnd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mEllipsizeAtEnd = z16;
        }
    }

    public void setLetterSpacing(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else if (getPaint() != null) {
            getPaint().setLetterSpacing(f16);
        }
    }

    public void setLineSpacingExtra(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else {
            this.mLineSpacingExtra = f16;
        }
    }

    public void setMaxLines(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mMaxLines = i3;
        }
    }

    public TextLayer setShadowLayer(float f16, float f17, float f18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TextLayer) iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Integer.valueOf(i3));
        }
        this.mShadowRadius = f16;
        this.mShadowDx = f17;
        this.mShadowDy = f18;
        this.mShadowColor = i3;
        Paint paint = this.mPaint;
        if (paint != null && Build.VERSION.SDK_INT >= 29) {
            paint.setShadowLayer(f16, f17, f18, i3);
        }
        return this;
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mText = str;
        }
    }

    public TextLayer setTextAlign(Paint.Align align) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TextLayer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) align);
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTextAlign(align);
        }
        return this;
    }

    public TextLayer setTextBold(boolean z16) {
        Typeface typeface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TextLayer) iPatchRedirector.redirect((short) 17, (Object) this, z16);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            return;
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTextSize(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        }
        return super.setX(f16);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public AnimatorLayer setY(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AnimatorLayer) iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        }
        return super.setY(f16);
    }

    public TextLayer(String str, int i3, float f16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        setText(str);
        setTextColor(i3);
        setTextSize(f16);
    }
}
