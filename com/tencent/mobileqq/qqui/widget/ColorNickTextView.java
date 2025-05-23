package com.tencent.mobileqq.qqui.widget;

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
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.widget.b;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ColorNickTextView extends TextView implements b.a {
    static IPatchRedirector $redirector_;
    private int C;
    private Bitmap D;
    private Rect E;
    private Rect F;
    private CharSequence G;
    public boolean H;
    private ArrayList<a> I;
    private b J;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.qqui.widget.b f274745d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f274746e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f274747f;

    /* renamed from: h, reason: collision with root package name */
    private int f274748h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f274749i;

    /* renamed from: m, reason: collision with root package name */
    private float[] f274750m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f274751a;

        /* renamed from: b, reason: collision with root package name */
        public int f274752b;

        /* renamed from: c, reason: collision with root package name */
        public String f274753c;

        /* renamed from: d, reason: collision with root package name */
        public CharacterStyle f274754d;

        /* renamed from: e, reason: collision with root package name */
        public int f274755e;

        public a(int i3, int i16, int i17, String str, CharacterStyle characterStyle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, characterStyle);
                return;
            }
            this.f274755e = i3;
            this.f274751a = i16;
            this.f274752b = i17;
            this.f274753c = str;
            this.f274754d = characterStyle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b implements Comparator<CharacterStyle> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Spanned f274756d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) characterStyle, (Object) characterStyle2)).intValue();
            }
            Spanned spanned = this.f274756d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f274756d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f274756d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f274756d.getSpanEnd(characterStyle2);
                if (spanEnd == spanEnd2) {
                    return 0;
                }
                if (spanEnd > spanEnd2) {
                    return 1;
                }
                return -1;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return -1;
        }

        public void b(Spanned spanned) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) spanned);
            } else {
                this.f274756d = spanned;
            }
        }
    }

    public ColorNickTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private PointF a() {
        PointF pointF = new PointF();
        Rect rect = new Rect();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.I.size(); i3++) {
            a aVar = this.I.get(i3);
            int i16 = aVar.f274755e;
            if (i16 != 1) {
                if (i16 == 2) {
                    EmoticonSpan emoticonSpan = (EmoticonSpan) aVar.f274754d;
                    pointF.x += emoticonSpan.getDrawable().getBounds().width();
                    f16 = Math.max(f16, emoticonSpan.getDrawable().getBounds().height());
                }
            } else {
                pointF.x += getPaint().measureText(aVar.f274753c);
                TextPaint paint = getPaint();
                String str = aVar.f274753c;
                paint.getTextBounds(str, 0, str.length(), rect);
                f16 = Math.max(f16, rect.height());
            }
        }
        pointF.y = f16;
        return pointF;
    }

    private Canvas b(int i3, int i16) {
        Bitmap bitmap = this.f274746e;
        if (bitmap == null || bitmap.getWidth() != i3 || this.f274746e.getHeight() != i16) {
            Bitmap bitmap2 = this.f274746e;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f274746e = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.f274746e);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        return canvas;
    }

    private void c(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        if (this.f274748h != 0) {
            d();
            if (this.I.size() == 0) {
                getPaint().setShader(null);
                super.onDraw(canvas);
                return;
            }
            PointF a16 = a();
            float f27 = a16.x;
            float f28 = a16.y;
            float f29 = 0.0f;
            if (f27 > 0.0f && f28 > 0.0f) {
                getPaint().setColor(-16777216);
                int i3 = this.f274748h;
                if (i3 != 1) {
                    int i16 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    getPaint().setShader(null);
                                    if (this.D != null) {
                                        int i17 = (int) f28;
                                        Canvas b16 = b((int) f27, i17);
                                        int width = this.D.getWidth();
                                        int i18 = 0;
                                        while (i18 < f27) {
                                            int i19 = i18 + width;
                                            this.F.set(i18, 0, i19, i17);
                                            b16.drawBitmap(this.D, this.E, this.F, getPaint());
                                            i18 = i19;
                                        }
                                        Bitmap bitmap = this.f274746e;
                                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                        getPaint().setShader(new BitmapShader(bitmap, tileMode, tileMode));
                                    }
                                }
                            } else {
                                getPaint().setShader(null);
                                Canvas b17 = b((int) f27, (int) f28);
                                Paint paint = new Paint(getPaint());
                                int i26 = 0;
                                for (int i27 = 0; i27 < this.I.size(); i27++) {
                                    a aVar = this.I.get(i27);
                                    int i28 = aVar.f274755e;
                                    if (i28 != 1) {
                                        if (i28 == 2) {
                                            f29 += ((EmoticonSpan) aVar.f274754d).getDrawable().getBounds().width();
                                        }
                                    } else {
                                        int i29 = i26;
                                        float f36 = f29;
                                        int i36 = 0;
                                        while (i36 < aVar.f274753c.length()) {
                                            int i37 = i36 + 1;
                                            float measureText = getPaint().measureText(aVar.f274753c, i36, i37);
                                            int[] iArr = this.f274749i;
                                            paint.setColor(iArr[i29 % iArr.length]);
                                            paint.setStyle(Paint.Style.FILL);
                                            float f37 = f36 + measureText;
                                            b17.drawRect(f36, 0.0f, f37, f28, paint);
                                            i29++;
                                            f36 = f37;
                                            i36 = i37;
                                        }
                                        f29 = f36;
                                        i26 = i29;
                                    }
                                }
                                Bitmap bitmap2 = this.f274746e;
                                Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                                getPaint().setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                            }
                        } else {
                            float f38 = f27 / 2.0f;
                            getPaint().setShader(new RadialGradient(f38, f28 / 2.0f, f38, this.f274749i, this.f274750m, Shader.TileMode.CLAMP));
                        }
                    } else {
                        getPaint().setShader(null);
                        Canvas b18 = b((int) f27, (int) f28);
                        Paint paint2 = new Paint(getPaint());
                        int i38 = 0;
                        int i39 = 0;
                        while (i39 < this.I.size()) {
                            a aVar2 = this.I.get(i39);
                            int i46 = aVar2.f274755e;
                            if (i46 != 1) {
                                if (i46 == i16) {
                                    f29 += ((EmoticonSpan) aVar2.f274754d).getDrawable().getBounds().width();
                                }
                            } else {
                                if (i38 == 0) {
                                    TextPaint paint3 = getPaint();
                                    String str = aVar2.f274753c;
                                    paint3.getTextBounds(str, 0, str.length(), this.f274747f);
                                    i38 = this.f274747f.height();
                                }
                                int i47 = i38;
                                float f39 = f29;
                                int i48 = 0;
                                while (i48 < aVar2.f274753c.length()) {
                                    int i49 = i48 + 1;
                                    float measureText2 = getPaint().measureText(aVar2.f274753c, i48, i49);
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
                                    paint2.setShader(new LinearGradient(f17, f18, f47, f26, this.f274749i, this.f274750m, Shader.TileMode.CLAMP));
                                    paint2.setStyle(Paint.Style.FILL);
                                    float f49 = f39 + measureText2;
                                    b18.drawRect(f39, f28 - i47, f49, f28, paint2);
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
                        Bitmap bitmap3 = this.f274746e;
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
                    getPaint().setShader(new LinearGradient(f16, f56, f57, f28, this.f274749i, this.f274750m, Shader.TileMode.CLAMP));
                }
            }
        } else {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    public void d() {
        Spanned spanned;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        CharSequence text = getText();
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
        } else {
            spanned = null;
        }
        if (spanned != null) {
            this.G = getText();
            this.I.clear();
            int i16 = 0;
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, getText().length(), CharacterStyle.class);
            if (characterStyleArr.length == 0) {
                this.I.add(new a(1, 0, this.G.length(), this.G.toString(), null));
                return;
            }
            this.J.b(spanned);
            Arrays.sort(characterStyleArr, this.J);
            int i17 = 0;
            while (i16 < characterStyleArr.length) {
                int spanStart = spanned.getSpanStart(characterStyleArr[i16]);
                int spanEnd = spanned.getSpanEnd(characterStyleArr[i16]);
                if (spanStart > i17) {
                    this.I.add(new a(1, i17, spanStart, getText().subSequence(i17, spanStart).toString(), null));
                }
                String charSequence = getText().subSequence(spanStart, spanEnd).toString();
                CharacterStyle characterStyle = characterStyleArr[i16];
                if (characterStyle instanceof EmoticonSpan) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                this.I.add(new a(i3, spanStart, spanEnd, charSequence, characterStyle));
                if (i16 == characterStyleArr.length - 1 && spanEnd < getText().length()) {
                    this.I.add(new a(1, spanEnd, getText().length(), getText().subSequence(spanEnd, getText().length()).toString(), null));
                }
                i16++;
                i17 = spanEnd;
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        com.tencent.mobileqq.qqui.widget.b bVar = this.f274745d;
        if (bVar != null) {
            bVar.b(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        com.tencent.mobileqq.qqui.widget.b bVar = this.f274745d;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            c(canvas);
        }
    }

    public void setMosaicEffect(com.tencent.mobileqq.qqui.widget.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.qqui.widget.b bVar2 = this.f274745d;
        if (bVar2 != null) {
            bVar2.d(null);
        }
        this.f274745d = bVar;
        if (bVar != null) {
            bVar.d(this);
        }
        invalidate();
    }

    public void setSpecialColor(int i3, int[] iArr, float[] fArr, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), iArr, fArr, Integer.valueOf(i16), bitmap);
            return;
        }
        this.f274748h = i3;
        this.C = i16;
        if (iArr != null) {
            this.f274749i = Arrays.copyOf(iArr, iArr.length);
        }
        if (fArr != null) {
            this.f274750m = Arrays.copyOf(fArr, fArr.length);
        }
        this.D = bitmap;
        if (bitmap != null) {
            this.E.set(0, 0, bitmap.getWidth(), this.D.getHeight());
        }
        invalidate();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) charSequence, (Object) bufferType);
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    @Override // com.tencent.mobileqq.qqui.widget.b.a
    public void superDrawMosaic(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.qqui.widget.b.a
    public void superOnDrawMosaic(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
        } else {
            c(canvas);
        }
    }

    public ColorNickTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ColorNickTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f274747f = new Rect();
        this.f274748h = 0;
        this.E = new Rect();
        this.F = new Rect();
        this.H = false;
        this.I = new ArrayList<>();
        this.J = new b();
        setLayerType(1, null);
    }
}
