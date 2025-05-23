package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n extends DynamicTextItem {
    private int A;
    private int B;
    private boolean C;
    private RectF D;

    /* renamed from: p, reason: collision with root package name */
    List<Bitmap> f67105p;

    /* renamed from: q, reason: collision with root package name */
    private TextPaint f67106q;

    /* renamed from: r, reason: collision with root package name */
    Resources f67107r;

    /* renamed from: s, reason: collision with root package name */
    private int f67108s;

    /* renamed from: t, reason: collision with root package name */
    private int f67109t;

    /* renamed from: u, reason: collision with root package name */
    private int f67110u;

    /* renamed from: v, reason: collision with root package name */
    private int f67111v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f67112w;

    /* renamed from: x, reason: collision with root package name */
    private float f67113x;

    /* renamed from: y, reason: collision with root package name */
    private int f67114y;

    /* renamed from: z, reason: collision with root package name */
    private String f67115z;

    public n(int i3, List<String> list, Typeface typeface, List<Bitmap> list2) {
        super(i3, list);
        this.f67105p = new ArrayList(2);
        this.f67106q = null;
        this.f67112w = false;
        this.D = new RectF();
        this.f67105p.addAll(list2);
        this.f67107r = BaseApplication.getContext().getResources();
        TextPaint textPaint = new TextPaint();
        this.f67106q = textPaint;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        this.f67106q.setAntiAlias(true);
        this.f67106q.setColor(-1);
        this.f67106q.setTextSize(BaseAIOUtils.f(9.0f, this.f67107r));
        int fontMetricsInt = this.f67106q.getFontMetricsInt(null);
        this.A = fontMetricsInt;
        int i16 = this.f67108s;
        if (i16 <= 0) {
            int i17 = i16 + fontMetricsInt;
            this.f67108s = i17;
            int f16 = i17 + BaseAIOUtils.f(3.0f, this.f67107r);
            this.f67108s = f16;
            this.f67108s = f16 + this.f67105p.get(0).getHeight();
        }
        int i18 = this.f67109t;
        if (i18 <= 0) {
            int i19 = i18 + this.A;
            this.f67109t = i19;
            int f17 = i19 + BaseAIOUtils.f(3.0f, this.f67107r);
            this.f67109t = f17;
            this.f67109t = f17 + this.f67105p.get(1).getHeight();
        }
        if (this.B <= 0) {
            this.B = BaseAIOUtils.f(2.0f, this.f67107r);
        }
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        int i16;
        int i17;
        super.M(i3, str);
        String k3 = super.k(i3);
        this.f67115z = k3;
        String replaceAll = k3.replaceAll(RedTouch.NEWLINE_CHAR, "");
        this.f67115z = replaceAll;
        String replaceAll2 = replaceAll.replaceAll("\\r", "");
        this.f67115z = replaceAll2;
        if (TextUtils.isEmpty(replaceAll2)) {
            this.C = true;
            this.f67115z = " ";
        } else {
            this.C = false;
        }
        this.f67112w = false;
        int b16 = af.b(this.f67115z);
        if (b16 < 5) {
            this.f67114y = 1;
            int width = this.f67105p.get(0).getWidth() * b16;
            this.f67110u = width;
            if (b16 > 1) {
                this.f67110u = width + ((b16 - 1) * BaseAIOUtils.f(9.0f, this.f67107r));
            }
            if (this.C) {
                i17 = this.f67105p.get(0).getHeight();
            } else {
                i17 = this.f67108s;
            }
            this.f67111v = i17;
            return;
        }
        this.f67110u = (this.f67105p.get(1).getWidth() * 5) + (BaseAIOUtils.f(9.0f, this.f67107r) * 4);
        int i18 = b16 / 5;
        this.f67114y = i18;
        if (b16 % 5 > 0) {
            this.f67114y = i18 + 1;
        }
        int i19 = this.f67114y;
        int f16 = ((i19 - 1) * this.f67109t) + ((i19 - 1) * BaseAIOUtils.f(15.0f, this.f67107r));
        this.f67111v = f16;
        if (this.f67112w) {
            i16 = (int) ((this.f67113x * this.f67109t) + 0.5f);
        } else {
            i16 = this.f67109t;
        }
        this.f67111v = f16 + i16;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67111v + (this.B * 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67110u + (this.B * 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i3;
        float f16;
        int i16;
        int i17;
        String substring;
        int i18;
        String str;
        float f17;
        int i19;
        Bitmap bitmap3;
        if (TextUtils.isEmpty(this.f67115z)) {
            return;
        }
        boolean z16 = true;
        boolean z17 = af.b(this.f67115z) < 5;
        List<Bitmap> list = this.f67105p;
        if (z17) {
            bitmap = list.get(0);
        } else {
            bitmap = list.get(1);
        }
        int width = bitmap.getWidth();
        List<Bitmap> list2 = this.f67105p;
        if (z17) {
            bitmap2 = list2.get(0);
        } else {
            bitmap2 = list2.get(1);
        }
        int height = bitmap2.getHeight();
        int f18 = BaseAIOUtils.f(9.0f, this.f67107r);
        int f19 = BaseAIOUtils.f(15.0f, this.f67107r);
        int f26 = BaseAIOUtils.f(3.0f, this.f67107r);
        if (z17) {
            i3 = this.f67108s;
        } else {
            i3 = this.f67109t;
        }
        int f27 = BaseAIOUtils.f(z17 ? 40.0f : 36.0f, this.f67107r);
        float f28 = BaseAIOUtils.f(9.0f, this.f67107r);
        float f29 = f27;
        this.f67106q.setTextSize(f29);
        int fontMetricsInt = this.f67106q.getFontMetricsInt(null);
        canvas.save();
        int i26 = this.B;
        canvas.translate(i26, i26);
        float f36 = 0.0f;
        if (this.C) {
            canvas.drawBitmap(this.f67105p.get(0), 0.0f, 0.0f, this.f67106q);
            f16 = 0.0f;
        } else {
            canvas.save();
            int i27 = 0;
            int i28 = 0;
            while (true) {
                int i29 = this.f67114y;
                if (i27 >= i29) {
                    break;
                }
                boolean z18 = (this.f67112w && i27 == i29 + (-1)) ? z16 : false;
                canvas.save();
                if (z18) {
                    float f37 = this.f67113x;
                    canvas.scale(f37, f37);
                    i16 = 6;
                } else {
                    i16 = 5;
                }
                int i36 = i28;
                int i37 = 0;
                while (i37 < i16) {
                    int i38 = i16;
                    if (i36 < this.f67115z.length()) {
                        int a16 = af.a(this.f67115z.charAt(i36));
                        int i39 = i27;
                        if (a16 == 2) {
                            i17 = f19;
                            substring = this.f67115z.substring(i36, i36 + 2);
                        } else {
                            i17 = f19;
                            substring = this.f67115z.substring(i36, i36 + 1);
                        }
                        float f38 = width * 0.5f;
                        int i46 = i3;
                        if (a16 == 0 || a16 == 3) {
                            if (a16 == 3) {
                                i18 = i37;
                                str = substring;
                            } else {
                                i18 = i37;
                                str = ChnToSpell.e(substring, 1).f306907b;
                            }
                            this.f67106q.setTextSize(f28);
                            f17 = f28;
                            float descent = this.A - this.f67106q.descent();
                            i19 = width;
                            this.f67106q.setTextAlign(Paint.Align.CENTER);
                            canvas.drawText(str, f38, descent, this.f67106q);
                        } else {
                            i18 = i37;
                            i19 = width;
                            f17 = f28;
                        }
                        canvas.save();
                        canvas.translate(0.0f, this.A + f26);
                        List<Bitmap> list3 = this.f67105p;
                        if (z17) {
                            bitmap3 = list3.get(0);
                        } else {
                            bitmap3 = list3.get(1);
                        }
                        canvas.drawBitmap(bitmap3, 0.0f, 0.0f, this.f67106q);
                        canvas.restore();
                        this.f67106q.setTextSize(f29);
                        canvas.drawText(substring, f38, ((this.A + f26) + ((height - fontMetricsInt) * 0.5f)) - this.f67106q.ascent(), this.f67106q);
                        i36 = a16 == 2 ? i36 + 2 : i36 + 1;
                        canvas.translate(i19 + f18, 0.0f);
                        i37 = i18 + 1;
                        i16 = i38;
                        i27 = i39;
                        f19 = i17;
                        i3 = i46;
                        f28 = f17;
                        width = i19;
                    }
                }
                canvas.restore();
                canvas.translate(0.0f, r21 + r19);
                i27++;
                z16 = true;
                i28 = i36;
                f19 = f19;
                i3 = i3;
                f28 = f28;
                width = width;
                f36 = 0.0f;
            }
            f16 = f36;
            canvas.restore();
        }
        canvas.restore();
        if (super.H(0)) {
            RectF rectF = this.D;
            rectF.left = f16;
            rectF.top = f16;
            rectF.right = w();
            this.D.bottom = m();
            canvas.drawRoundRect(this.D, 6.0f, 6.0f, j());
        }
    }
}
