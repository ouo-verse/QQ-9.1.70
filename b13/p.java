package b13;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class p extends m {

    /* renamed from: j0, reason: collision with root package name */
    private IEmoticonSpanApi f27741j0;

    /* renamed from: k0, reason: collision with root package name */
    private Paint f27742k0;

    /* renamed from: l0, reason: collision with root package name */
    private int[] f27743l0;

    public p(ETDrawable eTDrawable, ETFont eTFont) {
        super(eTDrawable, eTFont);
        this.f27741j0 = IEmoticonSpanApi.INSTANCE.a();
    }

    private void d0() {
        int[] iArr;
        if (this.f415892e != null && !S() && (iArr = this.f27730t) != null && iArr.length > 0) {
            if (this.f27743l0 == null) {
                e0();
            }
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (m.c.f415878f) {
                    m.d.b(g(), "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                } else {
                    final long j3 = this.f415892e.mAnimationId;
                    FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            p.this.g0(j3);
                        }
                    });
                    return;
                }
            }
            m.d.a(g(), "0\u884c\u6216\u8d85\u8fc75\u884c\u6216\u5168EMOJI\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }

    private void e0() {
        Canvas canvas = this.f27721k;
        if (canvas == null) {
            this.f27721k = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        if (this.f27742k0 == null) {
            Paint paint = new Paint();
            this.f27742k0 = paint;
            paint.setColor(-16777216);
        }
        this.f27743l0 = new int[this.f27723m.size()];
        for (int i3 = 0; i3 < this.f27723m.size(); i3++) {
            m.f fVar = this.f27723m.get(i3);
            if (!fVar.f415904i) {
                this.f27743l0[i3] = 0;
            } else {
                this.f27743l0[i3] = 1;
                this.f27742k0.setTextSize(fVar.f415900e);
                this.f27721k.drawText(String.valueOf(fVar.f415897b), fVar.f415901f, fVar.f415902g + ((fVar.f415900e / 2.0f) - ((this.f27742k0.descent() + this.f27742k0.ascent()) / 2.0f)), this.f27742k0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(long j3) {
        this.f415894g = 0;
        m.c.e().n(this.f415892e.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27743l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, j3, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
        int[] iArr = this.f415889b;
        this.f415890c = iArr[0];
        this.f415891d = iArr[1];
        QLog.d("StrikingLayout", 4, this + " \u65b9\u6b63\u5b57\u4f53\u7ed8\u5236\u52a8\u753b\u6570\u636e\u83b7\u53d6 renderStrikingBitmap text: " + ((Object) this.f415892e.mText) + ", mFont.mFontId " + this.f415892e.mFontId + " chars " + this.f27730t + " x " + this.f27731u + " y " + this.f27732v + " width " + this.f27733w + " height " + this.f27734x + " charTypes " + this.f27743l0 + " wordBitmap " + this.f415888a + " realWidth - paddingLeft - paddingRight : " + ((this.f27728r - this.f27724n) - this.f27725o) + " realHeight - paddingTop - paddingBottom : " + ((this.f27729s - this.f27726p) - this.f27727q) + " rows " + this.f27735y + " columns " + this.f27736z + " lineSpace " + this.A + " mFont.mAnimationId " + j3 + " frameIndex " + this.f415894g + " mFont.animCount " + this.f415890c);
        if (this.f415890c > 0 && this.f415891d > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: b13.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.c();
                }
            });
        }
    }

    private boolean h0(Canvas canvas) {
        int i3;
        if (!w()) {
            return false;
        }
        long nanoTime = System.nanoTime();
        z(canvas);
        e0();
        int e16 = m.b.e(this.f415892e.mFontId);
        if (!this.E && (i3 = this.f27735y) > 0 && i3 < 6) {
            if (this.f415892e.mShouldDisplayAnimation) {
                f0();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                return true;
            }
            if (e16 == 1) {
                f0();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                return true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
        if (currentTimeMillis > 250) {
            VasFontReporter.INSTANCE.report(this.f415892e.mFontId, currentTimeMillis, "FastColorFontHelper.getInstance().renderSeriesColorWordBitmap", this.f27719i.getText().toString());
        }
        A();
        canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
        if (m.f27710i0) {
            C(canvas);
        }
        if (m.c.f415878f) {
            m.d.c(g(), nanoTime, "\u5b57\u6570\uff1a" + this.f27730t.length + "\n   \u5b57\u53f7\uff1a" + this.f27719i.getTextSize() + "px\n");
            a0("StrikingLayout::onDraw......");
        }
        return true;
    }

    @Override // b13.m
    protected void Y() {
        int i3;
        int i16;
        int e16 = m.b.e(this.f415892e.mFontId);
        if (this.f415892e.mShouldDisplayAnimation && !this.E && (i16 = this.f27735y) > 0 && i16 < 6) {
            m.c e17 = m.c.e();
            ETFont eTFont = this.f415892e;
            e17.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27743l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
            return;
        }
        if (!this.E && (i3 = this.f27735y) > 0 && i3 < 6 && e16 == 1) {
            m.c e18 = m.c.e();
            ETFont eTFont2 = this.f415892e;
            int i17 = eTFont2.mFontId;
            int[] iArr = this.f27730t;
            int[] iArr2 = this.f27731u;
            int[] iArr3 = this.f27732v;
            int[] iArr4 = this.f27733w;
            int[] iArr5 = this.f27734x;
            int[] iArr6 = this.f27743l0;
            Bitmap bitmap = this.f415888a;
            int i18 = (this.f27728r - this.f27724n) - this.f27725o;
            int i19 = (this.f27729s - this.f27726p) - this.f27727q;
            int i26 = this.f27735y;
            int i27 = this.f27736z;
            int i28 = this.A;
            long j3 = eTFont2.mAnimationId;
            int[] iArr7 = this.f415889b;
            e18.n(i17, iArr, iArr2, iArr3, iArr4, iArr5, iArr6, bitmap, null, i18, i19, i26, i27, i28, j3, iArr7[0], iArr7, eTFont2.mComboIndex);
            return;
        }
        this.C = new int[0];
        m.c.e().l(this.f415892e.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.B, this.C, this.D);
    }

    protected void f0() {
        int textSize = this.f27719i.getTextSize() / 15;
        Canvas canvas = this.f27720j;
        if (canvas == null) {
            this.f27720j = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        int size = this.f27723m.size();
        for (int i3 = 0; i3 < size; i3++) {
            m.f fVar = this.f27723m.get(i3);
            int i16 = fVar.f415896a;
            if (i16 != 1) {
                if (i16 == 2) {
                    this.f27720j.drawRect(fVar.f415901f, fVar.f415902g, r6 + fVar.f415899d, r7 + fVar.f415900e, this.F);
                    if (this.f27741j0.isEmoticonSpan(fVar.f415905j)) {
                        IEmoticonSpanApi iEmoticonSpanApi = this.f27741j0;
                        CharacterStyle characterStyle = fVar.f415905j;
                        Canvas canvas2 = this.f27720j;
                        float f16 = fVar.f415901f;
                        int i17 = fVar.f415902g;
                        int i18 = fVar.f415900e;
                        iEmoticonSpanApi.draw(characterStyle, canvas2, null, 0, 0, f16, i17, i17 + i18, i17 + i18, this.f27719i.getPaint());
                    } else {
                        CharacterStyle characterStyle2 = fVar.f415905j;
                        if (characterStyle2 instanceof y03.d) {
                            y03.d dVar = (y03.d) characterStyle2;
                            dVar.C = false;
                            Canvas canvas3 = this.f27720j;
                            float f17 = fVar.f415901f;
                            int i19 = fVar.f415902g;
                            dVar.draw(canvas3, null, 0, 0, f17, i19, i19, i19 + fVar.f415900e, this.f27719i.getPaint());
                        }
                    }
                }
            } else {
                this.f27720j.drawBitmap(L(fVar.f415899d, textSize), fVar.f415901f, (fVar.f415902g + fVar.f415900e) - textSize, this.f27719i.getPaint());
            }
        }
    }

    @Override // b13.m, m.e
    public boolean j(Canvas canvas) {
        long j3;
        int i3;
        if (FontInfoManager.INSTANCE.a()) {
            return h0(canvas);
        }
        if (S()) {
            a0("StrikingLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return false;
        }
        if (!Z()) {
            a0("StrikingLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        List<List<m.f>> list = this.f27722l;
        if (list != null && !list.isEmpty()) {
            if (this.f27730t.length <= 0) {
                a0("StrikingLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
                return false;
            }
            long nanoTime = System.nanoTime();
            d();
            z(canvas);
            e0();
            int e16 = m.b.e(this.f415892e.mFontId);
            if (!this.E && (i3 = this.f27735y) > 0 && i3 < 6) {
                if (this.f415892e.mShouldDisplayAnimation) {
                    m.c e17 = m.c.e();
                    ETFont eTFont = this.f415892e;
                    e17.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27743l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
                    int[] iArr = this.f415889b;
                    this.f415890c = iArr[0];
                    this.f415891d = iArr[1];
                    f0();
                    canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                    if (this.f415894g == 0) {
                        o();
                    }
                    if (m.c.f415878f) {
                        m.d.c(g(), nanoTime, "\u5b57\u6570\uff1a" + this.f27730t.length + "\n   \u5b57\u53f7\uff1a" + this.f27719i.getTextSize() + "px\n");
                        a0("StrikingLayout::onDraw......");
                    }
                    return true;
                }
                j3 = nanoTime;
                if (e16 == 1) {
                    m.c e18 = m.c.e();
                    ETFont eTFont2 = this.f415892e;
                    int i16 = eTFont2.mFontId;
                    int[] iArr2 = this.f27730t;
                    int[] iArr3 = this.f27731u;
                    int[] iArr4 = this.f27732v;
                    int[] iArr5 = this.f27733w;
                    int[] iArr6 = this.f27734x;
                    int[] iArr7 = this.f27743l0;
                    Bitmap bitmap = this.f415888a;
                    int i17 = (this.f27728r - this.f27724n) - this.f27725o;
                    int i18 = (this.f27729s - this.f27726p) - this.f27727q;
                    int i19 = this.f27735y;
                    int i26 = this.f27736z;
                    int i27 = this.A;
                    long j16 = eTFont2.mAnimationId;
                    int[] iArr8 = this.f415889b;
                    e18.n(i16, iArr2, iArr3, iArr4, iArr5, iArr6, iArr7, bitmap, null, i17, i18, i19, i26, i27, j16, iArr8[0], iArr8, eTFont2.mComboIndex);
                    int[] iArr9 = this.f415889b;
                    this.f415890c = iArr9[0];
                    this.f415891d = iArr9[1];
                    f0();
                    canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                    if (m.c.f415878f) {
                        m.d.c(g(), j3, "\u5b57\u6570\uff1a" + this.f27730t.length + "\n   \u5b57\u53f7\uff1a" + this.f27719i.getTextSize() + "px\n");
                        a0("StrikingLayout::onDraw......");
                    }
                    return true;
                }
            } else {
                j3 = nanoTime;
            }
            this.C = new int[0];
            long currentTimeMillis = System.currentTimeMillis();
            long j17 = j3;
            m.c.e().l(this.f415892e.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.B, this.C, this.D);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 250) {
                VasFontReporter.INSTANCE.report(this.f415892e.mFontId, currentTimeMillis2, "FastColorFontHelper.getInstance().renderSeriesColorWordBitmap", this.f27719i.getText().toString());
            }
            A();
            canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            if (m.f27710i0) {
                C(canvas);
            }
            if (m.c.f415878f) {
                m.d.c(g(), j17, "\u5b57\u6570\uff1a" + this.f27730t.length + "\n   \u5b57\u53f7\uff1a" + this.f27719i.getTextSize() + "px\n");
                a0("StrikingLayout::onDraw......");
                return true;
            }
            return true;
        }
        a0("StrikingLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
        return false;
    }

    @Override // b13.m, m.e
    public void o() {
        int[] iArr;
        if (FontInfoManager.INSTANCE.a()) {
            d0();
            return;
        }
        if (this.f415892e != null && !S() && (iArr = this.f27730t) != null && iArr.length > 0) {
            if (this.f27743l0 == null) {
                e0();
            }
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (m.c.f415878f) {
                    m.d.b(g(), "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                }
                this.f415894g = 0;
                m.c e16 = m.c.e();
                ETFont eTFont = this.f415892e;
                e16.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27743l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
                int[] iArr2 = this.f415889b;
                int i16 = iArr2[0];
                this.f415890c = i16;
                int i17 = iArr2[1];
                this.f415891d = i17;
                if (i16 > 0 && i17 > 0) {
                    c();
                    return;
                }
                m.d.a(g(), "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
                return;
            }
            m.d.a(g(), "0\u884c\u6216\u8d85\u8fc75\u884c\u6216\u5168EMOJI\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }
}
