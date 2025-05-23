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
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.api.ITroopNickEdit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ColorClearableEditText extends ClearableEditText {
    private Bitmap G;
    private Rect H;
    private int I;
    private int[] J;
    private float[] K;
    private int L;
    private Bitmap M;
    private Rect N;
    private Rect P;
    private ArrayList<a> Q;
    private int R;
    private b S;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f315538a;

        /* renamed from: b, reason: collision with root package name */
        public int f315539b;

        /* renamed from: c, reason: collision with root package name */
        public String f315540c;

        /* renamed from: d, reason: collision with root package name */
        public CharacterStyle f315541d;

        /* renamed from: e, reason: collision with root package name */
        public int f315542e;

        public a(int i3, int i16, int i17, String str, CharacterStyle characterStyle) {
            this.f315542e = i3;
            this.f315538a = i16;
            this.f315539b = i17;
            this.f315540c = str;
            this.f315541d = characterStyle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements Comparator<CharacterStyle> {

        /* renamed from: d, reason: collision with root package name */
        Spanned f315543d;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            Spanned spanned = this.f315543d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f315543d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f315543d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f315543d.getSpanEnd(characterStyle2);
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
            this.f315543d = spanned;
        }
    }

    public ColorClearableEditText(Context context) {
        super(context);
        this.H = new Rect();
        this.I = 0;
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new ArrayList<>();
        this.S = new b();
    }

    private PointF f() {
        PointF pointF = new PointF();
        Rect rect = new Rect();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            a aVar = this.Q.get(i3);
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

    private Canvas i(int i3, int i16) {
        Bitmap bitmap = this.G;
        if (bitmap == null || bitmap.getWidth() != i3 || this.G.getHeight() != i16) {
            Bitmap bitmap2 = this.G;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.G = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.G);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        return canvas;
    }

    public static void k(List<a> list, b bVar, Spannable spannable) {
        int i3;
        list.clear();
        int i16 = 0;
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannable.getSpans(0, spannable.length(), CharacterStyle.class);
        if (characterStyleArr.length == 0) {
            list.add(new a(1, 0, spannable.length(), spannable.toString(), null));
            return;
        }
        bVar.b(spannable);
        Arrays.sort(characterStyleArr, bVar);
        int i17 = 0;
        while (i16 < characterStyleArr.length) {
            int spanStart = spannable.getSpanStart(characterStyleArr[i16]);
            int spanEnd = spannable.getSpanEnd(characterStyleArr[i16]);
            if (spanStart > i17) {
                list.add(new a(1, i17, spanStart, spannable.subSequence(i17, spanStart).toString(), null));
            }
            String charSequence = spannable.subSequence(spanStart, spanEnd).toString();
            CharacterStyle characterStyle = characterStyleArr[i16];
            if (characterStyle instanceof EmoticonSpan) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            list.add(new a(i3, spanStart, spanEnd, charSequence, characterStyle));
            if (i16 == characterStyleArr.length - 1 && spanEnd < spannable.length()) {
                list.add(new a(1, spanEnd, spannable.length(), spannable.subSequence(spanEnd, spannable.length()).toString(), null));
            }
            i16++;
            i17 = spanEnd;
        }
    }

    public ArrayList<a> g() {
        return this.Q;
    }

    public int h() {
        return this.R;
    }

    public void j() {
        k(this.Q, this.S, getText());
    }

    public void l() {
        j();
        ((ITroopNickEdit) QRoute.api(ITroopNickEdit.class)).updateDrawablePadding(getBackground(), f());
    }

    @Override // com.tencent.mobileqq.widget.ClearableEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((ITroopNickEdit) QRoute.api(ITroopNickEdit.class)).onDetachedFromWindow(getBackground());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        if (this.I != 0) {
            k(this.Q, this.S, getText());
            PointF f27 = f();
            float f28 = f27.x;
            float f29 = f27.y;
            float f36 = 0.0f;
            if (f28 > 0.0f && f29 > 0.0f) {
                int i3 = this.I;
                if (i3 != 1) {
                    int i16 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    getPaint().setShader(null);
                                    if (this.M != null) {
                                        int i17 = (int) f29;
                                        Canvas i18 = i((int) f28, i17);
                                        int width = this.M.getWidth();
                                        int i19 = 0;
                                        while (i19 < f28) {
                                            int i26 = i19 + width;
                                            this.P.set(i19, 0, i26, i17);
                                            i18.drawBitmap(this.M, this.N, this.P, getPaint());
                                            i19 = i26;
                                        }
                                        Bitmap bitmap = this.G;
                                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                        getPaint().setShader(new BitmapShader(bitmap, tileMode, tileMode));
                                    }
                                }
                            } else {
                                getPaint().setShader(null);
                                Canvas i27 = i((int) f28, (int) f29);
                                Paint paint = new Paint(getPaint());
                                int i28 = 0;
                                for (int i29 = 0; i29 < this.Q.size(); i29++) {
                                    a aVar = this.Q.get(i29);
                                    int i36 = aVar.f315542e;
                                    if (i36 != 1) {
                                        if (i36 == 2) {
                                            f36 += ((EmoticonSpan) aVar.f315541d).getDrawable().getBounds().width();
                                        }
                                    } else {
                                        int i37 = i28;
                                        float f37 = f36;
                                        int i38 = 0;
                                        while (i38 < aVar.f315540c.length()) {
                                            int i39 = i38 + 1;
                                            float measureText = getPaint().measureText(aVar.f315540c, i38, i39);
                                            int[] iArr = this.J;
                                            paint.setColor(iArr[i37 % iArr.length]);
                                            paint.setStyle(Paint.Style.FILL);
                                            float f38 = f37 + measureText;
                                            i27.drawRect(f37, 0.0f, f38, f29, paint);
                                            i37++;
                                            f37 = f38;
                                            i38 = i39;
                                        }
                                        f36 = f37;
                                        i28 = i37;
                                    }
                                }
                                Bitmap bitmap2 = this.G;
                                Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                                getPaint().setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
                            }
                        } else {
                            float f39 = f28 / 2.0f;
                            getPaint().setShader(new RadialGradient(f39, f29 / 2.0f, f39, this.J, this.K, Shader.TileMode.CLAMP));
                        }
                    } else {
                        getPaint().setShader(null);
                        Canvas i46 = i((int) f28, (int) f29);
                        Paint paint2 = new Paint(getPaint());
                        int i47 = 0;
                        int i48 = 0;
                        while (i48 < this.Q.size()) {
                            a aVar2 = this.Q.get(i48);
                            int i49 = aVar2.f315542e;
                            if (i49 != 1) {
                                if (i49 == i16) {
                                    f36 += ((EmoticonSpan) aVar2.f315541d).getDrawable().getBounds().width();
                                }
                            } else {
                                if (i47 == 0) {
                                    TextPaint paint3 = getPaint();
                                    String str = aVar2.f315540c;
                                    paint3.getTextBounds(str, 0, str.length(), this.H);
                                    i47 = this.H.height();
                                }
                                int i56 = i47;
                                float f46 = f36;
                                int i57 = 0;
                                while (i57 < aVar2.f315540c.length()) {
                                    int i58 = i57 + 1;
                                    float measureText2 = getPaint().measureText(aVar2.f315540c, i57, i58);
                                    int i59 = this.L;
                                    if (i59 == 1) {
                                        f17 = f46;
                                    } else {
                                        f17 = (measureText2 * 0.5f) + f46;
                                    }
                                    float f47 = i56;
                                    if (i59 == 1) {
                                        f18 = ((f47 * 0.5f) + f29) - f47;
                                    } else {
                                        f18 = f29 - f47;
                                    }
                                    if (i59 == 1) {
                                        f19 = f46 + measureText2;
                                    } else {
                                        f19 = (measureText2 * 0.5f) + f46;
                                    }
                                    float f48 = f19;
                                    if (i59 == 1) {
                                        float f49 = i56;
                                        f26 = ((f49 * 0.5f) + f29) - f49;
                                    } else {
                                        f26 = i56;
                                    }
                                    paint2.setShader(new LinearGradient(f17, f18, f48, f26, this.J, this.K, Shader.TileMode.CLAMP));
                                    paint2.setStyle(Paint.Style.FILL);
                                    float f56 = f46 + measureText2;
                                    i46.drawRect(f46, f29 - i56, f56, f29, paint2);
                                    f46 = f56;
                                    i57 = i58;
                                    i56 = i56;
                                }
                                f36 = f46;
                                i47 = i56;
                            }
                            i48++;
                            i16 = 2;
                        }
                        Bitmap bitmap3 = this.G;
                        Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                        getPaint().setShader(new BitmapShader(bitmap3, tileMode3, tileMode3));
                    }
                } else {
                    getPaint().setShader(null);
                    int i65 = this.L;
                    if (i65 == 1) {
                        f16 = 0.0f;
                    } else {
                        f16 = f28 * 0.5f;
                    }
                    if (i65 == 1) {
                        f36 = f29 * 0.5f;
                    }
                    float f57 = f36;
                    if (i65 != 1) {
                        f28 *= 0.5f;
                    }
                    float f58 = f28;
                    if (i65 == 1) {
                        f29 *= 0.5f;
                    }
                    getPaint().setShader(new LinearGradient(f16, f57, f58, f29, this.J, this.K, Shader.TileMode.CLAMP));
                }
            }
        } else {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCustomCloth(int i3) {
        setCustomCloth(i3, false);
    }

    public void setSpecialColor(int i3, int[] iArr, float[] fArr, int i16, Bitmap bitmap) {
        this.I = i3;
        this.L = i16;
        if (iArr != null) {
            this.J = Arrays.copyOf(iArr, iArr.length);
        }
        if (fArr != null) {
            this.K = Arrays.copyOf(fArr, fArr.length);
        }
        this.M = bitmap;
        if (bitmap != null) {
            this.N.set(0, 0, bitmap.getWidth(), this.M.getHeight());
        }
        invalidate();
    }

    public void setCustomCloth(int i3, boolean z16) {
        this.R = i3;
        ((ITroopNickEdit) QRoute.api(ITroopNickEdit.class)).setCustomCloth(this, getContext(), i3, z16);
        l();
    }

    public ColorClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new Rect();
        this.I = 0;
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new ArrayList<>();
        this.S = new b();
    }

    public ColorClearableEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new Rect();
        this.I = 0;
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new ArrayList<>();
        this.S = new b();
    }
}
