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
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends DynamicTextItem {
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private Resources H;
    private ArrayList<String> I;
    private RectF J;
    private RectF K;
    private int L;
    private String M;
    private Rect N;
    private InputFilter O;

    /* renamed from: p, reason: collision with root package name */
    private Bitmap f66990p;

    /* renamed from: q, reason: collision with root package name */
    private Bitmap f66991q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f66992r;

    /* renamed from: s, reason: collision with root package name */
    private TextPaint f66993s;

    /* renamed from: t, reason: collision with root package name */
    private TextPaint f66994t;

    /* renamed from: u, reason: collision with root package name */
    private int f66995u;

    /* renamed from: v, reason: collision with root package name */
    private int f66996v;

    /* renamed from: w, reason: collision with root package name */
    private int f66997w;

    /* renamed from: x, reason: collision with root package name */
    private int f66998x;

    /* renamed from: y, reason: collision with root package name */
    private int f66999y;

    /* renamed from: z, reason: collision with root package name */
    private int f67000z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            return TroopFileUtils.g(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.text.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0580b extends EditTextDialog.j {
        C0580b(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
            this.f68129d = (str.length() - TroopFileUtils.g(str).length()) + 20;
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    public b(int i3, List<String> list, Typeface typeface, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        super(i3, list);
        this.f66995u = 4;
        this.f66996v = 4;
        this.f66997w = 36;
        this.f66998x = 36;
        this.f66999y = 95;
        this.f67000z = 180;
        this.A = 0.85f;
        this.B = 0.9f;
        this.C = 2.0f;
        this.I = new ArrayList<>();
        this.J = new RectF();
        this.K = new RectF();
        this.L = 1;
        this.M = "";
        this.N = new Rect();
        this.O = null;
        this.f66990p = bitmap;
        this.f66991q = bitmap2;
        this.f66992r = bitmap3;
        Resources resources = BaseApplication.getContext().getResources();
        this.H = resources;
        this.f66995u = BaseAIOUtils.f(this.f66995u, resources);
        this.f66997w = BaseAIOUtils.f(this.f66997w, this.H);
        this.f66996v = BaseAIOUtils.f(this.f66996v, this.H);
        this.f66998x = BaseAIOUtils.f(this.f66998x, this.H);
        this.f66999y = BaseAIOUtils.f(this.f66999y, this.H);
        this.f67000z = BaseAIOUtils.f(this.f67000z, this.H);
        this.G = this.f66995u;
        R(typeface);
        int min = Math.min(list.size(), o());
        for (int i16 = 0; i16 < min; i16++) {
            M(i16, list.get(i16));
        }
    }

    private void Q() {
        this.D *= this.B;
    }

    private void R(Typeface typeface) {
        TextPaint textPaint = new TextPaint();
        this.f66993s = textPaint;
        textPaint.setTypeface(typeface);
        this.f66993s.setAntiAlias(true);
        this.f66993s.setColor(Color.parseColor("#045389"));
        this.f66993s.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f66993s.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint2 = new TextPaint();
        this.f66994t = textPaint2;
        textPaint2.setTypeface(typeface);
        this.f66994t.setAntiAlias(true);
        this.f66994t.setStyle(Paint.Style.STROKE);
        this.f66994t.setStrokeJoin(Paint.Join.ROUND);
        this.f66994t.setStrokeCap(Paint.Cap.ROUND);
        this.f66994t.setTextAlign(Paint.Align.CENTER);
        this.f66994t.setColor(Color.parseColor("#ddf3fd"));
        this.f66994t.setStrokeWidth(BaseAIOUtils.f(2.0f, this.H));
        this.f66994t.setShadowLayer(BaseAIOUtils.f(1.0f, this.H), BaseAIOUtils.f(1.0f, this.H), BaseAIOUtils.f(1.0f, this.H), Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean D() {
        return TextUtils.isEmpty(this.M) || super.D();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        Bitmap bitmap;
        int i3 = this.L;
        if (1 == i3) {
            bitmap = this.f66990p;
        } else if (2 == i3) {
            bitmap = this.f66991q;
        } else {
            bitmap = 3 == i3 ? this.f66992r : null;
        }
        if (bitmap != null) {
            this.N.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.N, this.K, (Paint) null);
        }
        if (super.H(0)) {
            canvas.drawRoundRect(this.J, 6.0f, 6.0f, j());
        }
        this.f66993s.setTextSize(this.D);
        this.f66994t.setTextSize(this.D);
        double d16 = this.f66996v + this.F;
        float f16 = this.D;
        int i16 = (int) (d16 + (f16 * 0.5d));
        int i17 = (int) (this.f66995u + (f16 * this.A) + this.G);
        for (int size = this.I.size() - 1; size >= 0; size--) {
            String str = this.I.get(size);
            int length = str.length();
            int i18 = 0;
            while (i18 < length) {
                int i19 = i18 + 1;
                float f17 = i16;
                float f18 = i17;
                canvas.drawText(str.substring(i18, i19), f17, f18, this.f66994t);
                canvas.drawText(str.substring(i18, i19), f17, f18, this.f66993s);
                i17 = (int) (f18 + this.D);
                i18 = i19;
            }
            float f19 = this.E;
            float f26 = this.D;
            i16 = (int) (i16 + f19 + f26);
            i17 = (int) (this.f66995u + (f26 * this.A) + this.G);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String replaceAll = TroopFileUtils.g(super.l(i3, new a())).replaceAll("\n", "");
        this.M = replaceAll;
        this.I.clear();
        int length = replaceAll.length();
        if (length > 10) {
            this.I.add(replaceAll.substring(0, 10));
            this.I.add(replaceAll.substring(10, Math.min(20, length)));
            this.D = Math.min(this.f67000z / 10, this.f66997w / this.C);
            Q();
            int i16 = this.f66997w;
            float f16 = this.D;
            int i17 = (int) ((i16 - (2.0f * f16)) / 3.0f);
            this.F = i17;
            this.E = i17;
            this.K.set(0.0f, 0.0f, i16 + (this.f66996v * 2), (f16 * 10.0f) + (this.f66995u * 2) + (this.G * 2));
            this.L = 3;
        } else if (length > 5) {
            this.I.add(replaceAll.substring(0, 5));
            this.I.add(replaceAll.substring(5, length));
            this.D = (int) Math.min(this.f66999y / 5, this.f66997w / this.C);
            Q();
            int i18 = this.f66997w;
            float f17 = this.D;
            int i19 = (int) ((i18 - (2.0f * f17)) / 3.0f);
            this.F = i19;
            this.E = i19;
            this.K.set(0.0f, 0.0f, i18 + (this.f66996v * 2), (f17 * 5.0f) + (this.f66995u * 2) + (this.G * 2));
            this.L = 2;
        } else if (length > 1) {
            this.I.add(replaceAll);
            this.D = Math.min(this.f66997w, this.f66999y / length);
            Q();
            this.E = 0;
            int i26 = this.f66997w;
            float f18 = this.D;
            this.F = (int) ((i26 - f18) / 2.0f);
            this.K.set(0.0f, 0.0f, i26 + (this.f66996v * 2), (length * f18) + (this.f66995u * 2) + (this.G * 2));
            this.L = 2;
        } else {
            this.I.add(replaceAll);
            this.D = this.f66997w;
            Q();
            this.K.set(0.0f, 0.0f, this.f66997w + (this.f66996v * 2), this.D + (this.f66995u * 2) + (this.G * 2));
            this.E = 0;
            this.F = (int) ((this.f66997w - this.D) / 2.0f);
            this.L = 1;
        }
        RectF rectF = this.J;
        RectF rectF2 = this.K;
        float f19 = rectF2.left;
        int i27 = this.f66996v;
        float f26 = rectF2.top;
        int i28 = this.f66995u;
        rectF.set(f19 + (i27 * 1.2f), f26 + (i28 * 1.2f), rectF2.right - (i27 * 1.2f), rectF2.bottom - (i28 * 1.2f));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.K.height();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.O == null) {
            this.O = new C0580b(20);
        }
        return this.O;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.K.width();
    }
}
