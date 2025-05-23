package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ae extends DynamicTextItem {

    /* renamed from: w, reason: collision with root package name */
    private static float[] f66959w = {62.0f, 35.5f, 8.0f, 13.0f, 117.0f, 35.0f, 22.0f, 14.0f, 181.0f, 40.0f, 25.0f, 13.0f};

    /* renamed from: p, reason: collision with root package name */
    List<Bitmap> f66960p;

    /* renamed from: q, reason: collision with root package name */
    private TextPaint f66961q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f66962r;

    /* renamed from: s, reason: collision with root package name */
    private int f66963s;

    /* renamed from: t, reason: collision with root package name */
    private float f66964t;

    /* renamed from: u, reason: collision with root package name */
    Resources f66965u;

    /* renamed from: v, reason: collision with root package name */
    private InputFilter f66966v;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends EditTextDialog.j {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j
        public int a(CharSequence charSequence) {
            return 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int i19;
            int i26;
            String replaceAll = charSequence.subSequence(i3, i16).toString().replaceAll("\n", "");
            boolean z16 = i16 - i3 != replaceAll.length();
            if (z16) {
                i26 = replaceAll.length();
                i19 = 0;
            } else {
                replaceAll = charSequence;
                i19 = i3;
                i26 = i16;
            }
            CharSequence filter = super.filter(replaceAll, i19, i26, spanned, i17, i18);
            return (filter == null && z16) ? replaceAll : filter;
        }
    }

    public ae(int i3, Typeface typeface, List<String> list, List<Bitmap> list2) {
        super(i3, list);
        this.f66960p = new ArrayList(3);
        this.f66961q = null;
        this.f66962r = new RectF();
        this.f66964t = 0.0f;
        this.f66966v = null;
        this.f66965u = BaseApplication.getContext().getResources();
        this.f66960p.clear();
        this.f66960p.addAll(list2);
        TextPaint textPaint = new TextPaint();
        this.f66961q = textPaint;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        this.f66961q.setAntiAlias(true);
        this.f66961q.setColor(-16777216);
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
    protected void I(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.f66960p.get(this.f66963s), 0.0f, 0.0f, this.f66961q);
        if (this.f66898k != null) {
            float f16 = BaseAIOUtils.f(f66959w[(this.f66963s * 4) + 2], this.f66965u);
            float f17 = BaseAIOUtils.f(f66959w[(this.f66963s * 4) + 3], this.f66965u);
            float f18 = BaseAIOUtils.f(f66959w[this.f66963s * 4], this.f66965u);
            float f19 = BaseAIOUtils.f(f66959w[(this.f66963s * 4) + 1], this.f66965u);
            float x16 = super.x(this.f66898k);
            float height = this.f66898k.getHeight();
            this.f66964t = BaseAIOUtils.f(2.0f, this.f66965u);
            canvas.translate(f16 + ((f18 - x16) * 0.5f), f17 + ((f19 - height) * 0.5f));
            this.f66898k.draw(canvas);
            if (H(0)) {
                RectF rectF = this.f66962r;
                float f26 = this.f66964t;
                rectF.left = 0.0f - f26;
                rectF.top = 0.0f - f26;
                rectF.right = x16 + (f26 * 2.0f);
                rectF.bottom = height + (f26 * 2.0f);
                canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
            }
        }
        canvas.restore();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "  ";
        }
        String e16 = e(10, k3);
        Point[] pointArr = new Point[3];
        float[] fArr = new float[3];
        boolean[] zArr = new boolean[3];
        StaticLayout[] staticLayoutArr = new StaticLayout[3];
        int[] iArr = new int[3];
        for (int i16 = 0; i16 < 3; i16++) {
            pointArr[i16] = new Point(0, 0);
            zArr[i16] = false;
            int i17 = i16 * 4;
            zArr[i16] = Q(BaseAIOUtils.f(f66959w[i17], this.f66965u), BaseAIOUtils.f(f66959w[i17 + 1], this.f66965u), 37, e16, pointArr[i16]);
            StaticLayout staticLayout = this.f66898k;
            staticLayoutArr[i16] = staticLayout;
            fArr[i16] = staticLayout.getPaint().getTextSize();
        }
        float[] fArr2 = new float[3];
        for (int i18 = 0; i18 < 3; i18++) {
            this.f66961q.setTextSize(fArr[i18]);
            iArr[i18] = staticLayoutArr[i18].getLineCount();
            if (zArr[i18]) {
                int i19 = i18 * 4;
                fArr2[i18] = (super.x(staticLayoutArr[i18]) * staticLayoutArr[i18].getHeight()) / (BaseAIOUtils.f(f66959w[i19], this.f66965u) * BaseAIOUtils.f(f66959w[i19 + 1], this.f66965u));
            } else {
                fArr2[i18] = 0.0f;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ShadowBubbleTextItem", 2, "scale:" + fArr2[i18] + " index:" + i18);
            }
        }
        int i26 = 2;
        for (int i27 = 2; i27 >= 0; i27--) {
            boolean z16 = zArr[i27];
            if (!z16 || !zArr[i26] || iArr[i27] >= iArr[i26]) {
                if (fArr2[i27] > fArr2[i26]) {
                    if (z16 && zArr[i26] && iArr[i27] > iArr[i26]) {
                    }
                }
            }
            i26 = i27;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ShadowBubbleTextItem", 2, "curIndex:" + i26);
        }
        this.f66963s = i26;
        this.f66898k = staticLayoutArr[i26];
        this.f66961q.setTextSize(fArr[i26]);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f66960p.get(this.f66963s).getHeight();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.f66966v == null) {
            this.f66966v = new a(20);
        }
        return this.f66966v;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f66960p.get(this.f66963s).getWidth();
    }

    private boolean Q(int i3, int i16, int i17, String str, Point point) {
        for (int i18 = i17; i18 >= 16; i18 -= 2) {
            this.f66961q.setTextSize(BaseAIOUtils.f(i18, this.f66965u));
            StaticLayout a16 = ag.a(str, 0, str.length(), this.f66961q, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, 2);
            this.f66898k = a16;
            boolean z16 = a16.getLineCount() <= 1 || a16.getLineVisibleEnd(1) >= str.length();
            if (a16.getHeight() > i16) {
                z16 = false;
            }
            if (z16) {
                point.set((int) (i3 - super.x(a16)), (int) (i16 - a16.getHeight()));
                return true;
            }
            point.set(0, 0);
        }
        return false;
    }
}
