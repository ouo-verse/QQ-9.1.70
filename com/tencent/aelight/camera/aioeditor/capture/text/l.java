package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class l extends DynamicTextItem {
    private float A;
    private float B;
    private int C;
    private int D;
    private Bitmap E;
    private Resources F;
    private RectF G;
    private RectF H;
    private int I;
    private ArrayList<String> J;
    private InputFilter K;

    /* renamed from: p, reason: collision with root package name */
    private int f67081p;

    /* renamed from: q, reason: collision with root package name */
    private int f67082q;

    /* renamed from: r, reason: collision with root package name */
    private int f67083r;

    /* renamed from: s, reason: collision with root package name */
    private int f67084s;

    /* renamed from: t, reason: collision with root package name */
    private int f67085t;

    /* renamed from: u, reason: collision with root package name */
    private int f67086u;

    /* renamed from: v, reason: collision with root package name */
    private TextPaint f67087v;

    /* renamed from: w, reason: collision with root package name */
    private int f67088w;

    /* renamed from: x, reason: collision with root package name */
    private int f67089x;

    /* renamed from: y, reason: collision with root package name */
    private int f67090y;

    /* renamed from: z, reason: collision with root package name */
    private String f67091z;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends EditTextDialog.j {
        b(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j
        public int a(CharSequence charSequence) {
            return 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
            this.f68129d = (str.length() - TroopFileUtils.g(str).length()) + 20;
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    public l(int i3, List<String> list, Typeface typeface, Bitmap bitmap) {
        super(i3, list);
        this.f67091z = TipsElementData.DEFAULT_COLOR;
        this.A = 0.73f;
        this.B = 0.31f;
        this.G = new RectF();
        this.H = new RectF();
        this.J = new ArrayList<>();
        this.K = null;
        R(typeface, bitmap);
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    private int Q(float f16) {
        return (int) (this.F.getDisplayMetrics().density * f16);
    }

    private void R(Typeface typeface, Bitmap bitmap) {
        this.F = BaseApplication.getContext().getResources();
        this.E = bitmap;
        S(typeface);
        int Q = Q(48.75f);
        this.f67084s = Q;
        this.f67087v.setTextSize(Q);
        this.f67081p = (int) this.f67087v.measureText(HardCodeUtil.qqStr(R.string.mnn));
        int Q2 = Q(27.0f);
        this.f67085t = Q2;
        this.f67087v.setTextSize(Q2);
        this.f67082q = (int) this.f67087v.measureText(HardCodeUtil.qqStr(R.string.mnm));
        int Q3 = Q(18.0f);
        this.f67086u = Q3;
        this.f67087v.setTextSize(Q3);
        this.f67083r = (int) this.f67087v.measureText(HardCodeUtil.qqStr(R.string.mno));
        this.C = Q(0.0f);
        this.D = Q(0.0f);
        this.f67088w = (int) (this.E.getWidth() * 0.98d);
        this.f67089x = (int) (this.E.getHeight() * 0.98d);
    }

    private void S(Typeface typeface) {
        TextPaint textPaint = new TextPaint();
        this.f67087v = textPaint;
        textPaint.setAntiAlias(true);
        this.f67087v.setColor(Color.parseColor(this.f67091z));
        this.f67087v.setTypeface(typeface);
        this.f67087v.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67087v.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        Rect rect = new Rect();
        rect.set(0, 0, this.E.getWidth(), this.E.getHeight());
        canvas.drawBitmap(this.E, rect, this.G, (Paint) null);
        if (super.H(0)) {
            RectF rectF = this.H;
            canvas.drawRoundRect(new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom + (this.I * 0.1f)), 6.0f, 6.0f, j());
        }
        RectF rectF2 = this.H;
        double d16 = rectF2.left;
        int i3 = this.I;
        int i16 = (int) (d16 + (i3 * 0.5d));
        int i17 = (int) (rectF2.top + i3);
        for (int size = this.J.size() - 1; size >= 0; size--) {
            String str = this.J.get(size);
            int length = str.length();
            int i18 = 0;
            while (i18 < length) {
                int i19 = i18 + 1;
                canvas.drawText(str.substring(i18, i19), i16, i17, this.f67087v);
                i17 += this.I + this.D;
                i18 = i19;
            }
            int i26 = this.I;
            i16 += this.C + i26;
            i17 = (int) (this.H.top + i26);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        int i16;
        int i17;
        int i18;
        int max;
        int i19;
        int i26;
        super.M(i3, str);
        String l3 = super.l(i3, new a());
        this.J.clear();
        int length = l3.length();
        if (length > 10) {
            this.J.add(l3.substring(0, 10));
            this.J.add(l3.substring(10, Math.min(length, 20)));
            int i27 = this.f67086u;
            this.f67090y = i27;
            this.f67087v.setTextSize(i27);
            int i28 = this.f67083r;
            this.I = i28;
            i26 = (i28 * 2) + this.C;
            i19 = (i28 * 10) + (this.D * 9);
        } else {
            if (length > 5) {
                this.J.add(l3);
                int i29 = this.f67085t;
                this.f67090y = i29;
                this.f67087v.setTextSize(i29);
                int i36 = this.f67082q;
                this.I = i36;
                i16 = i36 * 1;
                i17 = i36 * length;
                i18 = this.D;
                max = Math.max(length - 1, 0);
            } else {
                this.J.add(l3);
                int i37 = this.f67084s;
                this.f67090y = i37;
                this.f67087v.setTextSize(i37);
                int i38 = this.f67081p;
                this.I = i38;
                i16 = i38 * 1;
                if (length == 0) {
                    length = 2;
                }
                i17 = i38 * length;
                i18 = this.D;
                max = Math.max(length - 1, 0);
            }
            i19 = i17 + (i18 * max);
            i26 = i16;
        }
        float f16 = i19;
        int i39 = this.f67089x;
        float f17 = this.A;
        if (f16 > i39 * f17) {
            this.G.set(0.0f, f16 - (i39 * f17), this.f67088w, (i39 * (1.0f - f17)) + f16);
            RectF rectF = this.H;
            int i46 = this.f67088w;
            float f18 = this.B;
            rectF.set((i46 - i26) * f18, 0.0f, (i46 * f18) + (i26 * (1.0f - f18)), f16);
            return;
        }
        this.G.set(0.0f, 0.0f, this.f67088w, i39);
        RectF rectF2 = this.H;
        int i47 = this.f67088w;
        float f19 = this.B;
        int i48 = this.f67089x;
        float f26 = this.A;
        rectF2.set((i47 - i26) * f19, ((i48 * f26) - f16) / 2.0f, (i47 * f19) + (i26 * (1.0f - f19)), ((i48 * f26) + f16) / 2.0f);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        RectF rectF = this.G;
        return rectF.bottom - Math.min(this.H.top, rectF.top);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.K == null) {
            this.K = new b(20);
        }
        return this.K;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67088w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            if (i3 == 0) {
                return TroopFileUtils.g(str);
            }
            return "";
        }
    }
}
