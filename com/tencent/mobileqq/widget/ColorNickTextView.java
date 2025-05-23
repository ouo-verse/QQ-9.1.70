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
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.t;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorNickTextView extends TextView implements t.a {
    private int C;
    private Bitmap D;
    private Rect E;
    private Rect F;
    private CharSequence G;
    public boolean H;
    private int I;
    private ArrayList<ColorClearableEditText.a> J;
    private ColorClearableEditText.b K;

    /* renamed from: d, reason: collision with root package name */
    private t f315544d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f315545e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f315546f;

    /* renamed from: h, reason: collision with root package name */
    private int f315547h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f315548i;

    /* renamed from: m, reason: collision with root package name */
    private float[] f315549m;

    public ColorNickTextView(Context context) {
        this(context, null);
    }

    private PointF b() {
        PointF pointF = new PointF();
        Rect rect = new Rect();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.J.size(); i3++) {
            ColorClearableEditText.a aVar = this.J.get(i3);
            int i16 = aVar.f315542e;
            if (i16 != 1) {
                if (i16 == 2) {
                    EmoticonSpan emoticonSpan = (EmoticonSpan) aVar.f315541d;
                    pointF.x += emoticonSpan.getDrawable().getBounds().width();
                    f16 = Math.max(f16, emoticonSpan.getDrawable().getBounds().height());
                }
            } else {
                pointF.x += getPaint().measureText(aVar.f315540c);
                TextPaint paint = getPaint();
                String str = aVar.f315540c;
                paint.getTextBounds(str, 0, str.length(), rect);
                f16 = Math.max(f16, rect.height());
            }
        }
        pointF.y = f16;
        return pointF;
    }

    private Canvas c(int i3, int i16) {
        Bitmap bitmap = this.f315545e;
        if (bitmap == null || bitmap.getWidth() != i3 || this.f315545e.getHeight() != i16) {
            Bitmap bitmap2 = this.f315545e;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f315545e = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.f315545e);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        return canvas;
    }

    private void d(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        if (this.f315547h != 0) {
            e();
            if (this.J.size() == 0) {
                getPaint().setShader(null);
                super.onDraw(canvas);
                return;
            }
            PointF b16 = b();
            float f27 = b16.x;
            float f28 = b16.y;
            float f29 = 0.0f;
            if (f27 > 0.0f && f28 > 0.0f) {
                getPaint().setColor(-16777216);
                int i3 = this.f315547h;
                if (i3 != 1) {
                    int i16 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    getPaint().setShader(null);
                                    if (this.D != null) {
                                        int i17 = (int) f28;
                                        Canvas c16 = c((int) f27, i17);
                                        int width = this.D.getWidth();
                                        int i18 = 0;
                                        while (i18 < f27) {
                                            int i19 = i18 + width;
                                            this.F.set(i18, 0, i19, i17);
                                            c16.drawBitmap(this.D, this.E, this.F, getPaint());
                                            i18 = i19;
                                        }
                                        Bitmap bitmap = this.f315545e;
                                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                        getPaint().setShader(new BitmapShader(bitmap, tileMode, tileMode));
                                    }
                                }
                            } else {
                                getPaint().setShader(null);
                                Canvas c17 = c((int) f27, (int) f28);
                                Paint paint = new Paint(getPaint());
                                int i26 = 0;
                                for (int i27 = 0; i27 < this.J.size(); i27++) {
                                    ColorClearableEditText.a aVar = this.J.get(i27);
                                    int i28 = aVar.f315542e;
                                    if (i28 != 1) {
                                        if (i28 == 2) {
                                            f29 += ((EmoticonSpan) aVar.f315541d).getDrawable().getBounds().width();
                                        }
                                    } else {
                                        int i29 = i26;
                                        float f36 = f29;
                                        int i36 = 0;
                                        while (i36 < aVar.f315540c.length()) {
                                            int i37 = i36 + 1;
                                            float measureText = getPaint().measureText(aVar.f315540c, i36, i37);
                                            int[] iArr = this.f315548i;
                                            paint.setColor(iArr[i29 % iArr.length]);
                                            paint.setStyle(Paint.Style.FILL);
                                            float f37 = f36 + measureText;
                                            c17.drawRect(f36, 0.0f, f37, f28, paint);
                                            i29++;
                                            f36 = f37;
                                            i36 = i37;
                                        }
                                        f29 = f36;
                                        i26 = i29;
                                    }
                                }
                                Bitmap bitmap2 = this.f315545e;
                                Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                                getPaint().setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                            }
                        } else {
                            float f38 = f27 / 2.0f;
                            getPaint().setShader(new RadialGradient(f38, f28 / 2.0f, f38, this.f315548i, this.f315549m, Shader.TileMode.CLAMP));
                        }
                    } else {
                        getPaint().setShader(null);
                        Canvas c18 = c((int) f27, (int) f28);
                        Paint paint2 = new Paint(getPaint());
                        int i38 = 0;
                        int i39 = 0;
                        while (i39 < this.J.size()) {
                            ColorClearableEditText.a aVar2 = this.J.get(i39);
                            int i46 = aVar2.f315542e;
                            if (i46 != 1) {
                                if (i46 == i16) {
                                    f29 += ((EmoticonSpan) aVar2.f315541d).getDrawable().getBounds().width();
                                }
                            } else {
                                if (i38 == 0) {
                                    TextPaint paint3 = getPaint();
                                    String str = aVar2.f315540c;
                                    paint3.getTextBounds(str, 0, str.length(), this.f315546f);
                                    i38 = this.f315546f.height();
                                }
                                int i47 = i38;
                                float f39 = f29;
                                int i48 = 0;
                                while (i48 < aVar2.f315540c.length()) {
                                    int i49 = i48 + 1;
                                    float measureText2 = getPaint().measureText(aVar2.f315540c, i48, i49);
                                    int i56 = this.C;
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
                                    paint2.setShader(new LinearGradient(f17, f18, f47, f26, this.f315548i, this.f315549m, Shader.TileMode.CLAMP));
                                    paint2.setStyle(Paint.Style.FILL);
                                    float f49 = f39 + measureText2;
                                    c18.drawRect(f39, f28 - i47, f49, f28, paint2);
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
                        Bitmap bitmap3 = this.f315545e;
                        Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                        getPaint().setShader(new BitmapShader(bitmap3, tileMode3, tileMode3));
                    }
                } else {
                    getPaint().setShader(null);
                    int i57 = this.C;
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
                    getPaint().setShader(new LinearGradient(f16, f56, f57, f28, this.f315548i, this.f315549m, Shader.TileMode.CLAMP));
                }
            }
        } else {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    public int a() {
        return this.I;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.f315544d;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void e() {
        Spanned spanned;
        int i3;
        CharSequence text = getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned != null) {
            this.G = getText();
            this.J.clear();
            int i16 = 0;
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, getText().length(), CharacterStyle.class);
            if (characterStyleArr.length == 0) {
                this.J.add(new ColorClearableEditText.a(1, 0, this.G.length(), this.G.toString(), null));
                return;
            }
            this.K.b(spanned);
            Arrays.sort(characterStyleArr, this.K);
            int i17 = 0;
            while (i16 < characterStyleArr.length) {
                int spanStart = spanned.getSpanStart(characterStyleArr[i16]);
                int spanEnd = spanned.getSpanEnd(characterStyleArr[i16]);
                if (spanStart > i17) {
                    this.J.add(new ColorClearableEditText.a(1, i17, spanStart, getText().subSequence(i17, spanStart).toString(), null));
                }
                String charSequence = getText().subSequence(spanStart, spanEnd).toString();
                CharacterStyle characterStyle = characterStyleArr[i16];
                if (characterStyle instanceof EmoticonSpan) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                this.J.add(new ColorClearableEditText.a(i3, spanStart, spanEnd, charSequence, characterStyle));
                if (i16 == characterStyleArr.length - 1 && spanEnd < getText().length()) {
                    this.J.add(new ColorClearableEditText.a(1, spanEnd, getText().length(), getText().subSequence(spanEnd, getText().length()).toString(), null));
                }
                i16++;
                i17 = spanEnd;
            }
        }
    }

    public void f() {
        Drawable background = getBackground();
        if (background instanceof TroopNickResDrawable) {
            e();
            ((TroopNickResDrawable) background).f(b());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable background = getBackground();
        if (background instanceof TroopNickResDrawable) {
            TroopNickResDrawable troopNickResDrawable = (TroopNickResDrawable) background;
            troopNickResDrawable.g(null);
            troopNickResDrawable.recycle();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        t tVar = this.f315544d;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            d(canvas);
        }
    }

    public void setCustomCloth(int i3) {
        this.I = i3;
        Drawable background = getBackground();
        if (background instanceof TroopNickResDrawable) {
            TroopNickResDrawable troopNickResDrawable = (TroopNickResDrawable) background;
            troopNickResDrawable.f(b());
            troopNickResDrawable.update(i3);
            return;
        }
        com.tencent.mobileqq.vas.troopnick.a.b(this, getContext(), i3, true);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.f315544d;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.f315544d = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    public void setSpecialColor(int i3, int[] iArr, float[] fArr, int i16, Bitmap bitmap) {
        this.f315547h = i3;
        this.C = i16;
        if (iArr != null) {
            this.f315548i = Arrays.copyOf(iArr, iArr.length);
        }
        if (fArr != null) {
            this.f315549m = Arrays.copyOf(fArr, fArr.length);
        }
        this.D = bitmap;
        if (bitmap != null) {
            this.E.set(0, 0, bitmap.getWidth(), this.D.getHeight());
        }
        invalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        f();
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        d(canvas);
    }

    public ColorNickTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorNickTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315546f = new Rect();
        this.f315547h = 0;
        this.E = new Rect();
        this.F = new Rect();
        this.H = false;
        this.J = new ArrayList<>();
        this.K = new ColorClearableEditText.b();
        setLayerType(1, null);
    }
}
