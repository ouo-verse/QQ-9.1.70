package b13;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends m {

    /* renamed from: j0, reason: collision with root package name */
    private IEmoticonSpanApi f27676j0;

    /* renamed from: k0, reason: collision with root package name */
    private Paint f27677k0;

    /* renamed from: l0, reason: collision with root package name */
    private int[] f27678l0;

    public b(ETDrawable eTDrawable, ETFont eTFont) {
        super(eTDrawable, eTFont);
        this.f27676j0 = IEmoticonSpanApi.INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
        int[] iArr = this.f415889b;
        int i3 = iArr[0];
        this.f415890c = i3;
        int i16 = iArr[1];
        this.f415891d = i16;
        if (i3 > 0 && i16 > 0) {
            c();
            return;
        }
        m.d.a("DynamicMultipleStyleLayout", "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
    }

    private void d0() {
        Canvas canvas = this.f27721k;
        if (canvas == null) {
            this.f27721k = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        if (this.f27677k0 == null) {
            Paint paint = new Paint();
            this.f27677k0 = paint;
            paint.setColor(-16777216);
        }
        this.f27678l0 = new int[this.f27723m.size()];
        for (int i3 = 0; i3 < this.f27723m.size(); i3++) {
            m.f fVar = this.f27723m.get(i3);
            if (!fVar.f415904i) {
                this.f27678l0[i3] = 0;
            } else {
                this.f27678l0[i3] = 1;
                this.f27677k0.setTextSize(fVar.f415900e);
                this.f27721k.drawText(String.valueOf(fVar.f415897b), fVar.f415901f, fVar.f415902g + ((fVar.f415900e / 2.0f) - ((this.f27677k0.descent() + this.f27677k0.ascent()) / 2.0f)), this.f27677k0);
            }
        }
    }

    private void u() {
        if (this.f415892e != null && !S() && this.f27730t != null) {
            if (this.f27678l0 == null) {
                d0();
            }
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (m.c.f415878f) {
                    m.d.b("DynamicMultipleStyleLayout", "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                } else {
                    this.f415894g = 0;
                    FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.T();
                        }
                    });
                    return;
                }
            }
            m.d.a("DynamicMultipleStyleLayout", "0\u884c\u6216\u8d85\u8fc75\u884c\u6216\u5168EMOJI\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }

    private boolean y(Canvas canvas) {
        int i3;
        if (!w()) {
            return false;
        }
        z(canvas);
        d0();
        if (this.f415892e.mShouldDisplayAnimation && !this.E && (i3 = this.f27735y) > 0 && i3 < 6) {
            e0();
            canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            if (this.f415894g == 0) {
                o();
                return true;
            }
            return true;
        }
        this.f415894g = 0;
        A();
        canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
        return true;
    }

    @Override // b13.m
    protected void Y() {
        int i3;
        if (this.f415892e.mShouldDisplayAnimation && !this.E && (i3 = this.f27735y) > 0 && i3 < 6) {
            m.c e16 = m.c.e();
            ETFont eTFont = this.f415892e;
            e16.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
        } else {
            m.c e17 = m.c.e();
            ETFont eTFont2 = this.f415892e;
            e17.n(eTFont2.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont2.mAnimationId, 0, this.f415889b, eTFont2.mComboIndex);
        }
    }

    protected void e0() {
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
                    if (this.f27676j0.isEmoticonSpan(fVar.f415905j)) {
                        IEmoticonSpanApi iEmoticonSpanApi = this.f27676j0;
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
        String str;
        int i3;
        if (FontInfoManager.INSTANCE.a()) {
            return y(canvas);
        }
        if (S()) {
            m.d.a("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8......");
            return false;
        }
        if (!Z()) {
            m.d.a("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        List<List<m.f>> list = this.f27722l;
        if (list != null && !list.isEmpty()) {
            if (this.f27730t.length <= 0) {
                m.d.a("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw \u5b57\u6570\u4e3a\u96f6\uff01");
                return false;
            }
            long nanoTime = System.nanoTime();
            d();
            z(canvas);
            d0();
            if (this.f415892e.mShouldDisplayAnimation && !this.E && (i3 = this.f27735y) > 0 && i3 < 6) {
                m.c e16 = m.c.e();
                ETFont eTFont = this.f415892e;
                e16.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
                int[] iArr = this.f415889b;
                this.f415890c = iArr[0];
                this.f415891d = iArr[1];
                e0();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                if (this.f415894g == 0) {
                    o();
                }
                str = "DynamicMultipleStyleLayout";
            } else {
                this.f415894g = 0;
                m.c e17 = m.c.e();
                ETFont eTFont2 = this.f415892e;
                str = "DynamicMultipleStyleLayout";
                e17.n(eTFont2.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont2.mAnimationId, 0, this.f415889b, eTFont2.mComboIndex);
                int[] iArr2 = this.f415889b;
                this.f415890c = iArr2[0];
                this.f415891d = iArr2[1];
                A();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            }
            if (m.c.f415878f) {
                m.d.a(str, "\u52a8\u753b\u5e27\u8017\u65f6 frameIndex:" + this.f415894g + "  \u884c\uff1a" + this.f27735y + "  \u5217\uff1a" + this.f27736z + "  \u8017\u65f6\uff1a" + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f) + "ms");
                if (this.f415894g == 0) {
                    a0("drawAnimationText.....");
                    return true;
                }
                return true;
            }
            return true;
        }
        m.d.a("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
        return false;
    }

    @Override // b13.m, m.e
    public void o() {
        if (FontInfoManager.INSTANCE.a()) {
            u();
            return;
        }
        if (this.f415892e != null && !S() && this.f27730t != null) {
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (m.c.f415878f) {
                    m.d.b("DynamicMultipleStyleLayout", "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                }
                this.f415894g = 0;
                m.c e16 = m.c.e();
                ETFont eTFont = this.f415892e;
                e16.n(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f27678l0, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b, this.f415892e.mComboIndex);
                int[] iArr = this.f415889b;
                int i16 = iArr[0];
                this.f415890c = i16;
                int i17 = iArr[1];
                this.f415891d = i17;
                if (i16 > 0 && i17 > 0) {
                    m.d.a("DynamicMultipleStyleLayout", "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
                    return;
                }
                c();
                return;
            }
            m.d.a("DynamicMultipleStyleLayout", "0\u884c\u6216\u8d85\u8fc75\u884c\u6216\u5168EMOJI\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }
}
