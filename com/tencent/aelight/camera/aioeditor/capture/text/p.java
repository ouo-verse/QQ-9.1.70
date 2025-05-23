package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p extends DynamicTextItem {
    private int A;
    private TextPaint B;
    private TextPaint C;
    private TextPaint D;
    private NinePatch E;
    private NinePatch F;
    private RectF G;
    private RectF H;
    private RectF I;
    private StaticLayout J;
    private RectF K;
    private RectF L;
    private List<String> M;
    private String N;
    private int O;
    private Resources P;
    private InputFilter Q;

    /* renamed from: p, reason: collision with root package name */
    private int f67127p;

    /* renamed from: q, reason: collision with root package name */
    private int f67128q;

    /* renamed from: r, reason: collision with root package name */
    private int f67129r;

    /* renamed from: s, reason: collision with root package name */
    private int f67130s;

    /* renamed from: t, reason: collision with root package name */
    private int f67131t;

    /* renamed from: u, reason: collision with root package name */
    private int f67132u;

    /* renamed from: v, reason: collision with root package name */
    private int f67133v;

    /* renamed from: w, reason: collision with root package name */
    private int f67134w;

    /* renamed from: x, reason: collision with root package name */
    private int f67135x;

    /* renamed from: y, reason: collision with root package name */
    private int f67136y;

    /* renamed from: z, reason: collision with root package name */
    private int f67137z;

    public p(int i3, List<String> list, Bitmap bitmap, Bitmap bitmap2) {
        super(i3, list);
        this.f67127p = 16;
        this.f67128q = 8;
        this.f67129r = -1;
        this.f67130s = 12;
        this.f67131t = 10;
        this.f67132u = 15;
        this.f67133v = 25;
        this.f67134w = 20;
        this.f67135x = 5;
        this.f67136y = 3;
        this.f67137z = -5;
        this.G = new RectF();
        this.H = new RectF();
        this.I = new RectF();
        this.K = new RectF();
        this.L = new RectF();
        this.M = new ArrayList();
        this.N = HardCodeUtil.qqStr(R.string.nid);
        this.Q = null;
        Resources resources = BaseApplication.getContext().getResources();
        this.P = resources;
        this.f67132u = BaseAIOUtils.f(this.f67132u, resources);
        this.f67127p = BaseAIOUtils.f(this.f67127p, this.P);
        this.f67128q = BaseAIOUtils.f(this.f67128q, this.P);
        this.f67130s = BaseAIOUtils.f(this.f67130s, this.P);
        this.f67131t = BaseAIOUtils.f(this.f67131t, this.P);
        this.f67133v = BaseAIOUtils.f(this.f67133v, this.P);
        this.f67134w = BaseAIOUtils.f(this.f67134w, this.P);
        this.f67135x = BaseAIOUtils.f(this.f67135x, this.P);
        this.f67136y = BaseAIOUtils.f(this.f67136y, this.P);
        this.f67137z = BaseAIOUtils.f(this.f67137z, this.P);
        this.E = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
        this.F = new NinePatch(bitmap2, bitmap2.getNinePatchChunk(), null);
        Q();
        this.A = (int) this.B.measureText(HardCodeUtil.qqStr(R.string.nie));
        this.O = (int) (this.C.measureText(HardCodeUtil.qqStr(R.string.nic)) * 10.0f);
        int size = list == null ? 0 : list.size();
        for (int i16 = 0; i16 < size; i16++) {
            M(i16, list.get(i16));
            QLog.i("JourneyTextItem", 2, "JourneyTextItem index: " + i16 + " text: " + list.get(i16));
        }
    }

    private void Q() {
        TextPaint textPaint = new TextPaint();
        this.B = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.B.setTextAlign(Paint.Align.CENTER);
        this.B.setAntiAlias(true);
        this.B.setStyle(Paint.Style.FILL_AND_STROKE);
        this.B.setTextSize(this.f67127p);
        this.B.setColor(this.f67129r);
        TextPaint textPaint2 = new TextPaint();
        this.D = textPaint2;
        textPaint2.setTypeface(Typeface.DEFAULT);
        this.D.setAntiAlias(true);
        this.D.setTextSize(this.f67127p * 0.8f);
        this.D.setColor(this.f67129r);
        TextPaint textPaint3 = new TextPaint();
        this.C = textPaint3;
        textPaint3.setAntiAlias(true);
        this.C.setColor(this.f67129r);
        this.C.setTextSize(this.f67128q);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean D() {
        return (TextUtils.isEmpty(l(0, new b())) && TextUtils.isEmpty(k(1))) || super.D();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.H.bottom - this.G.top;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.Q == null) {
            this.Q = new c(20);
        }
        return this.Q;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 2;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int t(float f16, float f17, float f18, float f19) {
        float w3 = f16 / w();
        RectF rectF = this.G;
        RectF rectF2 = new RectF(rectF.left * w3, rectF.top * w3, rectF.right * w3, rectF.bottom * w3);
        RectF rectF3 = this.L;
        RectF rectF4 = new RectF(rectF3.left * w3, rectF3.top * w3, rectF3.right * w3, rectF3.bottom * w3);
        PointF pointF = new PointF((-f16) / 2.0f, (-f17) / 2.0f);
        if (R(f18, f19, rectF2, pointF)) {
            return 0;
        }
        return R(f18, f19, rectF4, pointF) ? 1 : -1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int u(MotionEvent motionEvent, float f16, float f17, g.c cVar, zr.c cVar2) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (cVar != null) {
            return cVar2.p(cVar, x16, y16);
        }
        PointF pointF = new PointF((f16 - w()) / 2.0f, (f17 - m()) / 2.0f);
        if (R(x16, y16, this.G, pointF)) {
            return 0;
        }
        return R(x16, y16, this.L, pointF) ? 1 : -1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return (int) Math.max(this.G.width(), this.H.width());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            return i3 == 0 ? TroopFileUtils.g(str) : str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements DynamicTextItem.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            return i3 == 0 ? TroopFileUtils.g(str) : str;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        if (H(0)) {
            canvas.drawRoundRect(this.I, 6.0f, 6.0f, j());
        }
        if (H(1)) {
            canvas.drawRoundRect(this.L, 6.0f, 6.0f, j());
        }
        this.E.draw(canvas, this.G);
        this.F.draw(canvas, this.H);
        int i3 = (int) (this.G.left + (this.f67133v * 1.3d));
        int i16 = (int) (this.f67134w + (this.A * 0.8d));
        for (int size = this.M.size() - 1; size >= 0; size--) {
            String str = this.M.get(size);
            int length = str.length();
            int i17 = 0;
            while (i17 < length) {
                int i18 = i17 + 1;
                canvas.drawText(str.substring(i17, i18), i3, i16, this.B);
                i16 += this.A + this.f67131t;
                i17 = i18;
            }
            int i19 = this.A;
            i3 += this.f67132u + i19;
            i16 = (int) (this.f67134w + (i19 * 0.8d));
        }
        RectF rectF = this.K;
        canvas.translate(rectF.left, rectF.top);
        StaticLayout staticLayout = this.J;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends EditTextDialog.j {
        c(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            if (p.this.h() == 0) {
                String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
                String g16 = TroopFileUtils.g(str);
                int i19 = 0;
                for (String str2 : p.this.y(g16).split("\n")) {
                    int length = str2.length();
                    i19 += (length / 5) + (length % 5 > 0 ? 1 : 0);
                }
                if (TextUtils.equals(charSequence, "\n")) {
                    i19++;
                }
                if (i19 > 4) {
                    if (!TextUtils.equals("", charSequence)) {
                        b();
                    }
                    return "";
                }
                this.f68129d = (str.length() - g16.length()) + 20;
                return super.filter(charSequence, i3, i16, spanned, i17, i18);
            }
            this.f68129d = 20;
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    private boolean R(float f16, float f17, RectF rectF, PointF pointF) {
        if (rectF != null && pointF != null) {
            float f18 = rectF.left;
            float f19 = pointF.x;
            float f26 = rectF.top;
            float f27 = pointF.y;
            RectF rectF2 = new RectF(f18 + f19, f26 + f27, rectF.right + f19, rectF.bottom + f27);
            if (f16 > rectF2.left && f16 < rectF2.right && f17 > rectF2.top && f17 < rectF2.bottom) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0162 A[LOOP:0: B:14:0x0093->B:21:0x0162, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0159 A[SYNTHETIC] */
    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M(int i3, String str) {
        String str2;
        float f16;
        float f17;
        if (i3 < 0 || i3 >= o()) {
            return;
        }
        super.M(i3, str);
        String l3 = l(i3, new a());
        if (QLog.isColorLevel()) {
            QLog.i("JourneyTextItem", 2, "setText index: " + i3 + " text: " + l3);
        }
        if (i3 == 0) {
            str2 = TroopFileUtils.g(l3);
            this.M.clear();
        } else {
            this.N = l3;
            if (l3.length() >= 20) {
                this.N = this.N.substring(0, 20);
            }
            str2 = "";
        }
        float width = this.G.width();
        float height = this.G.height();
        float width2 = this.H.width();
        this.H.height();
        float width3 = this.K.width();
        float height2 = this.K.height();
        if (i3 == 0) {
            String[] split = str2.split("\n");
            int length = split.length;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                String str3 = split[i16];
                if (str3.length() >= 20) {
                    this.M.add(str3.substring(0, 5));
                    this.M.add(str3.substring(5, 10));
                    this.M.add(str3.substring(10, 15));
                    this.M.add(str3.substring(15, 20));
                } else if (str3.length() > 15) {
                    this.M.add(str3.substring(0, 5));
                    this.M.add(str3.substring(5, 10));
                    this.M.add(str3.substring(10, 15));
                    this.M.add(str3.substring(15, str3.length()));
                } else if (str3.length() > 10) {
                    this.M.add(str3.substring(0, 5));
                    this.M.add(str3.substring(5, 10));
                    this.M.add(str3.substring(10, str3.length()));
                } else if (str3.length() > 5) {
                    this.M.add(str3.substring(0, 5));
                    this.M.add(str3.substring(5, str3.length()));
                } else {
                    this.M.add(str3.substring(0, str3.length()));
                    i17 = Math.max(i17, str3.length());
                    if (this.M.size() <= 4) {
                        this.M = this.M.subList(0, 4);
                        break;
                    }
                    i16++;
                }
                i17 = 5;
                if (this.M.size() <= 4) {
                }
            }
            int size = this.M.size();
            int i18 = (this.f67133v * 2) + ((size - 1) * this.f67132u);
            int i19 = this.f67127p;
            f16 = i18 + (size * i19);
            f17 = (this.f67134w * 2) + ((i17 - 1) * this.f67131t) + (i17 * i19);
        } else {
            StaticLayout a16 = ag.a(l3, 0, l3.length(), this.C, this.O, Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, false, null, 0, 2);
            this.J = a16;
            width3 = a16.getLineWidth(0);
            height2 = this.J.getHeight();
            width2 = width3 + this.f67135x;
            f16 = width;
            f17 = height;
        }
        int i26 = this.f67130s;
        if (f16 > width2) {
            this.G.set(0.0f, 0.0f, f16, f17);
            RectF rectF = this.K;
            float f18 = (f16 - width3) * 0.5f;
            float f19 = f17 + i26;
            int i27 = this.f67136y;
            rectF.set(f18, i27 + f19, width3 + f18, f19 + height2 + i27);
        } else {
            float f26 = (width2 - f16) * 0.5f;
            this.G.set(f26, 0.0f, f16 + f26, f17);
            RectF rectF2 = this.K;
            float f27 = (width2 - width3) * 0.5f;
            float f28 = f17 + i26;
            int i28 = this.f67136y;
            rectF2.set(f27, i28 + f28, width3 + f27, f28 + height2 + i28);
        }
        RectF rectF3 = this.I;
        RectF rectF4 = this.G;
        float f29 = rectF4.left;
        int i29 = this.f67133v;
        float f36 = rectF4.top;
        int i36 = this.f67134w;
        rectF3.set(f29 + (i29 * 0.8f), f36 + (i36 * 0.7f), rectF4.right - (i29 * 0.8f), rectF4.bottom - (i36 * 0.7f));
        RectF rectF5 = this.L;
        RectF rectF6 = this.K;
        float f37 = rectF6.left;
        int i37 = this.f67133v;
        float f38 = rectF6.top;
        int i38 = this.f67134w;
        rectF5.set(f37 - (i37 * 0.3f), f38 - (i38 * 0.2f), rectF6.right + (i37 * 0.3f), rectF6.bottom + (i38 * 0.2f));
        RectF rectF7 = this.H;
        RectF rectF8 = this.L;
        float f39 = rectF8.left;
        float f46 = rectF8.bottom;
        int i39 = this.f67137z;
        rectF7.set(f39, i39 + f46, width2 + f39, f46 + height2 + i39);
    }
}
