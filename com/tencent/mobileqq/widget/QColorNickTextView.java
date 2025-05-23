package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.widget.QColorClearableEditText;
import com.tencent.mobileqq.widget.t;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QColorNickTextView extends TextView implements t.a {
    private int mColorNickId;
    private int mColorType;
    private int[] mColors;
    private t mMosaicEffect;
    private int mOrientation;
    private ArrayList<QColorClearableEditText.a> mParagraphs;
    private float[] mPositions;
    private Bitmap mShaderBitmap;
    private QColorClearableEditText.b mSpanComparator;
    private CharSequence mSplitedText;
    private Rect mTextBound;
    private Bitmap mTexture;
    private Rect mTextureDstRect;
    private Rect mTextureRect;
    public boolean needRefreshSpecialColor;

    public QColorNickTextView(Context context) {
        this(context, null);
    }

    private Canvas getShaderCanvas(int i3, int i16) {
        Bitmap bitmap = this.mShaderBitmap;
        if (bitmap == null || bitmap.getWidth() != i3 || this.mShaderBitmap.getHeight() != i16) {
            Bitmap bitmap2 = this.mShaderBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.mShaderBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.mShaderBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        return canvas;
    }

    private void onDrawInner(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        if (this.mColorType != 0) {
            splitParagraph();
            if (this.mParagraphs.size() == 0) {
                getPaint().setShader(null);
                super.onDraw(canvas);
                return;
            }
            PointF contentSize = getContentSize();
            float f27 = contentSize.x;
            float f28 = contentSize.y;
            float f29 = 0.0f;
            if (f27 > 0.0f && f28 > 0.0f) {
                getPaint().setColor(-16777216);
                int i3 = this.mColorType;
                if (i3 != 1) {
                    int i16 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    getPaint().setShader(null);
                                    if (this.mTexture != null) {
                                        int i17 = (int) f28;
                                        Canvas shaderCanvas = getShaderCanvas((int) f27, i17);
                                        int width = this.mTexture.getWidth();
                                        int i18 = 0;
                                        while (i18 < f27) {
                                            int i19 = i18 + width;
                                            this.mTextureDstRect.set(i18, 0, i19, i17);
                                            shaderCanvas.drawBitmap(this.mTexture, this.mTextureRect, this.mTextureDstRect, getPaint());
                                            i18 = i19;
                                        }
                                        Bitmap bitmap = this.mShaderBitmap;
                                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                        getPaint().setShader(new BitmapShader(bitmap, tileMode, tileMode));
                                    }
                                }
                            } else {
                                getPaint().setShader(null);
                                Canvas shaderCanvas2 = getShaderCanvas((int) f27, (int) f28);
                                Paint paint = new Paint(getPaint());
                                int i26 = 0;
                                for (int i27 = 0; i27 < this.mParagraphs.size(); i27++) {
                                    QColorClearableEditText.a aVar = this.mParagraphs.get(i27);
                                    int i28 = aVar.f316042e;
                                    if (i28 != 1) {
                                        if (i28 == 2) {
                                            f29 += ((IEmoticonSpanRefreshCallback) aVar.f316041d).getDrawable().getBounds().width();
                                        }
                                    } else {
                                        int i29 = i26;
                                        float f36 = f29;
                                        int i36 = 0;
                                        while (i36 < aVar.f316040c.length()) {
                                            int i37 = i36 + 1;
                                            float measureText = getPaint().measureText(aVar.f316040c, i36, i37);
                                            int[] iArr = this.mColors;
                                            paint.setColor(iArr[i29 % iArr.length]);
                                            paint.setStyle(Paint.Style.FILL);
                                            float f37 = f36 + measureText;
                                            shaderCanvas2.drawRect(f36, 0.0f, f37, f28, paint);
                                            i29++;
                                            f36 = f37;
                                            i36 = i37;
                                        }
                                        f29 = f36;
                                        i26 = i29;
                                    }
                                }
                                Bitmap bitmap2 = this.mShaderBitmap;
                                Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                                getPaint().setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                            }
                        } else {
                            float f38 = f27 / 2.0f;
                            getPaint().setShader(new RadialGradient(f38, f28 / 2.0f, f38, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
                        }
                    } else {
                        getPaint().setShader(null);
                        Canvas shaderCanvas3 = getShaderCanvas((int) f27, (int) f28);
                        Paint paint2 = new Paint(getPaint());
                        int i38 = 0;
                        int i39 = 0;
                        while (i39 < this.mParagraphs.size()) {
                            QColorClearableEditText.a aVar2 = this.mParagraphs.get(i39);
                            int i46 = aVar2.f316042e;
                            if (i46 != 1) {
                                if (i46 == i16) {
                                    f29 += ((IEmoticonSpanRefreshCallback) aVar2.f316041d).getDrawable().getBounds().width();
                                }
                            } else {
                                if (i38 == 0) {
                                    TextPaint paint3 = getPaint();
                                    String str = aVar2.f316040c;
                                    paint3.getTextBounds(str, 0, str.length(), this.mTextBound);
                                    i38 = this.mTextBound.height();
                                }
                                int i47 = i38;
                                float f39 = f29;
                                int i48 = 0;
                                while (i48 < aVar2.f316040c.length()) {
                                    int i49 = i48 + 1;
                                    float measureText2 = getPaint().measureText(aVar2.f316040c, i48, i49);
                                    int i56 = this.mOrientation;
                                    if (i56 == 1) {
                                        f17 = f39;
                                    } else {
                                        f17 = (measureText2 * 0.5f) + f39;
                                    }
                                    float f46 = i47;
                                    if (i56 == 1) {
                                        f18 = ((f46 * 0.5f) + f28) - f46;
                                    } else {
                                        f18 = f28 - f46;
                                    }
                                    if (i56 == 1) {
                                        f19 = f39 + measureText2;
                                    } else {
                                        f19 = (measureText2 * 0.5f) + f39;
                                    }
                                    float f47 = f19;
                                    if (i56 == 1) {
                                        float f48 = i47;
                                        f26 = ((f48 * 0.5f) + f28) - f48;
                                    } else {
                                        f26 = i47;
                                    }
                                    paint2.setShader(new LinearGradient(f17, f18, f47, f26, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
                                    paint2.setStyle(Paint.Style.FILL);
                                    float f49 = f39 + measureText2;
                                    shaderCanvas3.drawRect(f39, f28 - i47, f49, f28, paint2);
                                    f39 = f49;
                                    i48 = i49;
                                    i47 = i47;
                                }
                                f29 = f39;
                                i38 = i47;
                            }
                            i39++;
                            i16 = 2;
                        }
                        Bitmap bitmap3 = this.mShaderBitmap;
                        Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                        getPaint().setShader(new BitmapShader(bitmap3, tileMode3, tileMode3));
                    }
                } else {
                    getPaint().setShader(null);
                    int i57 = this.mOrientation;
                    if (i57 == 1) {
                        f16 = 0.0f;
                    } else {
                        f16 = f27 * 0.5f;
                    }
                    if (i57 == 1) {
                        f29 = f28 * 0.5f;
                    }
                    float f56 = f29;
                    if (i57 != 1) {
                        f27 *= 0.5f;
                    }
                    float f57 = f27;
                    if (i57 == 1) {
                        f28 *= 0.5f;
                    }
                    getPaint().setShader(new LinearGradient(f16, f56, f57, f28, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
                }
            }
        } else {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.mMosaicEffect;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public int getColorNickId() {
        return this.mColorNickId;
    }

    public PointF getContentSize() {
        PointF pointF = new PointF();
        Rect rect = new Rect();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.mParagraphs.size(); i3++) {
            QColorClearableEditText.a aVar = this.mParagraphs.get(i3);
            int i16 = aVar.f316042e;
            if (i16 != 1) {
                if (i16 == 2) {
                    IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback = (IEmoticonSpanRefreshCallback) aVar.f316041d;
                    pointF.x += iEmoticonSpanRefreshCallback.getDrawable().getBounds().width();
                    f16 = Math.max(f16, iEmoticonSpanRefreshCallback.getDrawable().getBounds().height());
                }
            } else {
                pointF.x += getPaint().measureText(aVar.f316040c);
                TextPaint paint = getPaint();
                String str = aVar.f316040c;
                paint.getTextBounds(str, 0, str.length(), rect);
                f16 = Math.max(f16, rect.height());
            }
        }
        pointF.y = f16;
        return pointF;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        t tVar = this.mMosaicEffect;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            onDrawInner(canvas);
        }
    }

    public void setCustomCloth(int i3) {
        this.mColorNickId = i3;
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.mMosaicEffect;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.mMosaicEffect = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    public void setSpecialColor(int i3, int[] iArr, float[] fArr, int i16, Bitmap bitmap) {
        this.mColorType = i3;
        this.mOrientation = i16;
        if (iArr != null) {
            this.mColors = Arrays.copyOf(iArr, iArr.length);
        }
        if (fArr != null) {
            this.mPositions = Arrays.copyOf(fArr, fArr.length);
        }
        this.mTexture = bitmap;
        if (bitmap != null) {
            this.mTextureRect.set(0, 0, bitmap.getWidth(), this.mTexture.getHeight());
        }
        invalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        updateDrawablePadding();
    }

    public void splitParagraph() {
        Spanned spanned;
        int i3;
        CharSequence text = getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned != null) {
            this.mSplitedText = getText();
            this.mParagraphs.clear();
            int i16 = 0;
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, getText().length(), CharacterStyle.class);
            if (characterStyleArr.length == 0) {
                this.mParagraphs.add(new QColorClearableEditText.a(1, 0, this.mSplitedText.length(), this.mSplitedText.toString(), null));
                return;
            }
            this.mSpanComparator.b(spanned);
            Arrays.sort(characterStyleArr, this.mSpanComparator);
            int i17 = 0;
            while (i16 < characterStyleArr.length) {
                int spanStart = spanned.getSpanStart(characterStyleArr[i16]);
                int spanEnd = spanned.getSpanEnd(characterStyleArr[i16]);
                if (spanStart > i17) {
                    this.mParagraphs.add(new QColorClearableEditText.a(1, i17, spanStart, getText().subSequence(i17, spanStart).toString(), null));
                }
                String charSequence = getText().subSequence(spanStart, spanEnd).toString();
                CharacterStyle characterStyle = characterStyleArr[i16];
                if (characterStyle instanceof IEmoticonSpanRefreshCallback) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                this.mParagraphs.add(new QColorClearableEditText.a(i3, spanStart, spanEnd, charSequence, characterStyle));
                if (i16 == characterStyleArr.length - 1 && spanEnd < getText().length()) {
                    this.mParagraphs.add(new QColorClearableEditText.a(1, spanEnd, getText().length(), getText().subSequence(spanEnd, getText().length()).toString(), null));
                }
                i16++;
                i17 = spanEnd;
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        onDrawInner(canvas);
    }

    public QColorNickTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QColorNickTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTextBound = new Rect();
        this.mColorType = 0;
        this.mTextureRect = new Rect();
        this.mTextureDstRect = new Rect();
        this.needRefreshSpecialColor = false;
        this.mParagraphs = new ArrayList<>();
        this.mSpanComparator = new QColorClearableEditText.b();
        setLayerType(1, null);
    }

    public void updateDrawablePadding() {
    }
}
