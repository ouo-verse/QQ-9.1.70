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
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QColorClearableEditText extends ClearableEditText {
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
        public int f316038a;

        /* renamed from: b, reason: collision with root package name */
        public int f316039b;

        /* renamed from: c, reason: collision with root package name */
        public String f316040c;

        /* renamed from: d, reason: collision with root package name */
        public CharacterStyle f316041d;

        /* renamed from: e, reason: collision with root package name */
        public int f316042e;

        public a(int i3, int i16, int i17, String str, CharacterStyle characterStyle) {
            this.f316042e = i3;
            this.f316038a = i16;
            this.f316039b = i17;
            this.f316040c = str;
            this.f316041d = characterStyle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements Comparator<CharacterStyle> {

        /* renamed from: d, reason: collision with root package name */
        Spanned f316043d;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            Spanned spanned = this.f316043d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f316043d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f316043d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f316043d.getSpanEnd(characterStyle2);
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
            this.f316043d = spanned;
        }
    }

    public QColorClearableEditText(Context context) {
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

    private Canvas g(int i3, int i16) {
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

    public static void i(List<a> list, b bVar, Spannable spannable) {
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
            if (characterStyle instanceof IEmoticonSpanRefreshCallback) {
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

    public void h() {
        i(this.Q, this.S, getText());
    }

    public void j() {
        h();
    }

    @Override // com.tencent.mobileqq.widget.ClearableEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        if (this.I != 0) {
            i(this.Q, this.S, getText());
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
                                        Canvas g16 = g((int) f28, i17);
                                        int width = this.M.getWidth();
                                        int i18 = 0;
                                        while (i18 < f28) {
                                            int i19 = i18 + width;
                                            this.P.set(i18, 0, i19, i17);
                                            g16.drawBitmap(this.M, this.N, this.P, getPaint());
                                            i18 = i19;
                                        }
                                        Bitmap bitmap = this.G;
                                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                        getPaint().setShader(new BitmapShader(bitmap, tileMode, tileMode));
                                    }
                                }
                            } else {
                                getPaint().setShader(null);
                                Canvas g17 = g((int) f28, (int) f29);
                                Paint paint = new Paint(getPaint());
                                int i26 = 0;
                                for (int i27 = 0; i27 < this.Q.size(); i27++) {
                                    a aVar = this.Q.get(i27);
                                    int i28 = aVar.f316042e;
                                    if (i28 != 1) {
                                        if (i28 == 2) {
                                            f36 += ((IEmoticonSpanRefreshCallback) aVar.f316041d).getDrawable().getBounds().width();
                                        }
                                    } else {
                                        int i29 = i26;
                                        float f37 = f36;
                                        int i36 = 0;
                                        while (i36 < aVar.f316040c.length()) {
                                            int i37 = i36 + 1;
                                            float measureText = getPaint().measureText(aVar.f316040c, i36, i37);
                                            int[] iArr = this.J;
                                            paint.setColor(iArr[i29 % iArr.length]);
                                            paint.setStyle(Paint.Style.FILL);
                                            float f38 = f37 + measureText;
                                            g17.drawRect(f37, 0.0f, f38, f29, paint);
                                            i29++;
                                            f37 = f38;
                                            i36 = i37;
                                        }
                                        f36 = f37;
                                        i26 = i29;
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
                        Canvas g18 = g((int) f28, (int) f29);
                        Paint paint2 = new Paint(getPaint());
                        int i38 = 0;
                        int i39 = 0;
                        while (i39 < this.Q.size()) {
                            a aVar2 = this.Q.get(i39);
                            int i46 = aVar2.f316042e;
                            if (i46 != 1) {
                                if (i46 == i16) {
                                    f36 += ((IEmoticonSpanRefreshCallback) aVar2.f316041d).getDrawable().getBounds().width();
                                }
                            } else {
                                if (i38 == 0) {
                                    TextPaint paint3 = getPaint();
                                    String str = aVar2.f316040c;
                                    paint3.getTextBounds(str, 0, str.length(), this.H);
                                    i38 = this.H.height();
                                }
                                int i47 = i38;
                                float f46 = f36;
                                int i48 = 0;
                                while (i48 < aVar2.f316040c.length()) {
                                    int i49 = i48 + 1;
                                    float measureText2 = getPaint().measureText(aVar2.f316040c, i48, i49);
                                    int i56 = this.L;
                                    if (i56 == 1) {
                                        f17 = f46;
                                    } else {
                                        f17 = (measureText2 * 0.5f) + f46;
                                    }
                                    float f47 = i47;
                                    if (i56 == 1) {
                                        f18 = ((f47 * 0.5f) + f29) - f47;
                                    } else {
                                        f18 = f29 - f47;
                                    }
                                    if (i56 == 1) {
                                        f19 = f46 + measureText2;
                                    } else {
                                        f19 = (measureText2 * 0.5f) + f46;
                                    }
                                    float f48 = f19;
                                    if (i56 == 1) {
                                        float f49 = i47;
                                        f26 = ((f49 * 0.5f) + f29) - f49;
                                    } else {
                                        f26 = i47;
                                    }
                                    paint2.setShader(new LinearGradient(f17, f18, f48, f26, this.J, this.K, Shader.TileMode.CLAMP));
                                    paint2.setStyle(Paint.Style.FILL);
                                    float f56 = f46 + measureText2;
                                    g18.drawRect(f46, f29 - i47, f56, f29, paint2);
                                    f46 = f56;
                                    i48 = i49;
                                    i47 = i47;
                                }
                                f36 = f46;
                                i38 = i47;
                            }
                            i39++;
                            i16 = 2;
                        }
                        Bitmap bitmap3 = this.G;
                        Shader.TileMode tileMode3 = Shader.TileMode.CLAMP;
                        getPaint().setShader(new BitmapShader(bitmap3, tileMode3, tileMode3));
                    }
                } else {
                    getPaint().setShader(null);
                    int i57 = this.L;
                    if (i57 == 1) {
                        f16 = 0.0f;
                    } else {
                        f16 = f28 * 0.5f;
                    }
                    if (i57 == 1) {
                        f36 = f29 * 0.5f;
                    }
                    float f57 = f36;
                    if (i57 != 1) {
                        f28 *= 0.5f;
                    }
                    float f58 = f28;
                    if (i57 == 1) {
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
        j();
    }

    public QColorClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = new Rect();
        this.I = 0;
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new ArrayList<>();
        this.S = new b();
    }

    public QColorClearableEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new Rect();
        this.I = 0;
        this.N = new Rect();
        this.P = new Rect();
        this.Q = new ArrayList<>();
        this.S = new b();
    }
}
