package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class w extends DynamicTextItem {

    /* renamed from: v, reason: collision with root package name */
    public static final int f67161v;

    /* renamed from: w, reason: collision with root package name */
    public static final int f67162w;

    /* renamed from: x, reason: collision with root package name */
    public static final int f67163x;

    /* renamed from: p, reason: collision with root package name */
    protected RectF f67164p;

    /* renamed from: q, reason: collision with root package name */
    protected int f67165q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f67166r;

    /* renamed from: s, reason: collision with root package name */
    protected TextPaint f67167s;

    /* renamed from: t, reason: collision with root package name */
    protected float f67168t;

    /* renamed from: u, reason: collision with root package name */
    protected float f67169u;

    static {
        Resources resources = BaseApplication.getContext().getResources();
        f67161v = BaseAIOUtils.f(22.0f, resources);
        f67163x = BaseAIOUtils.f(14.0f, resources);
        f67162w = Math.min(resources.getDisplayMetrics().widthPixels - com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67981e0, BaseAIOUtils.f(270.0f, resources));
    }

    public w() {
        this(0, DynamicTextBuilder.e(0));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void I(Canvas canvas) {
        StaticLayout staticLayout = this.f66898k;
        if (staticLayout != null) {
            if (staticLayout.getLineCount() == 1) {
                canvas.save();
                canvas.translate(w() / 2.0f, m() / 2.0f);
                this.f67167s.setTextAlign(Paint.Align.CENTER);
                float f16 = -((this.f67167s.descent() + this.f67167s.ascent()) / 2.0f);
                String k3 = super.k(0);
                if (TextUtils.isEmpty(k3)) {
                    k3 = "\u3000\u3000";
                }
                canvas.drawText(k3, 0.0f, f16, this.f67167s);
                if (super.H(0)) {
                    int measureText = (int) this.f67167s.measureText(k3);
                    int ceil = (int) Math.ceil(this.f67167s.descent() - this.f67167s.ascent());
                    RectF rectF = this.f67164p;
                    rectF.left = (-measureText) / 2.0f;
                    rectF.top = (-ceil) / 2.0f;
                    rectF.right = measureText / 2.0f;
                    rectF.bottom = ceil / 2.0f;
                    canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
                }
                canvas.restore();
                return;
            }
            this.f67167s.setTextAlign(Paint.Align.LEFT);
            canvas.save();
            this.f66898k.draw(canvas);
            if (super.H(0)) {
                float x16 = super.x(this.f66898k);
                float height = this.f66898k.getHeight();
                RectF rectF2 = this.f67164p;
                rectF2.left = 0.0f;
                rectF2.top = 0.0f;
                rectF2.right = x16;
                rectF2.bottom = height;
                canvas.drawRoundRect(rectF2, 6.0f, 6.0f, j());
            }
            canvas.restore();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void N(int i3) {
        this.f67167s.setTextSize(i3);
        this.f66889b = i3;
        this.f66890c = true;
    }

    public int Q() {
        StaticLayout staticLayout = this.f66898k;
        if (staticLayout == null) {
            return 0;
        }
        return staticLayout.getLineCount();
    }

    public int R() {
        return this.f67167s.getColor();
    }

    public boolean S(String str) {
        return str.length() > this.f66898k.getLineEnd(this.f66898k.getLineCount() - 1) + 1;
    }

    public boolean T() {
        return this.f67166r;
    }

    public void U(boolean z16) {
        this.f67166r = z16;
    }

    public void V(int i3) {
        this.f67167s.setColor(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67169u;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67168t;
    }

    public w(int i3, List<String> list) {
        super(i3, list);
        this.f67164p = new RectF();
        this.f67165q = Integer.MAX_VALUE;
        this.f67166r = false;
        TextPaint textPaint = new TextPaint();
        this.f67167s = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.f67167s.setTextAlign(Paint.Align.CENTER);
        this.f67167s.setAntiAlias(true);
        this.f67167s.setStyle(Paint.Style.FILL_AND_STROKE);
        TextPaint textPaint2 = this.f67167s;
        int i16 = f67161v;
        textPaint2.setTextSize(i16);
        this.f67167s.setColor(-1);
        this.f67167s.setTextAlign(Paint.Align.LEFT);
        if (!list.isEmpty()) {
            M(0, list.get(0));
        }
        this.f66889b = i16;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        if (this.f66890c) {
            this.f67167s.setTextSize(this.f66889b);
        }
        int length = k3.length();
        TextPaint textPaint = this.f67167s;
        int i16 = f67162w;
        StaticLayout a16 = ag.a(k3, 0, length, textPaint, i16, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, this.f67165q);
        this.f66898k = a16;
        int lineCount = a16.getLineCount();
        int i17 = this.f67165q;
        if (lineCount > i17) {
            int lineEnd = this.f66898k.getLineEnd(i17 - 1);
            if (lineEnd < k3.length()) {
                k3 = ((Object) k3.subSequence(0, lineEnd)) + "";
            }
            this.f66898k = ag.a(k3, 0, k3.length(), this.f67167s, i16, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, this.f67165q);
        }
        if (this.f66898k.getLineCount() == 1) {
            this.f67168t = this.f67167s.measureText(k3);
            this.f67169u = this.f67167s.descent() - this.f67167s.ascent();
            return;
        }
        float f16 = 0.0f;
        for (int i18 = 0; i18 < this.f66898k.getLineCount(); i18++) {
            f16 = Math.max(f16, this.f66898k.getLineWidth(i18));
        }
        this.f67168t = f16;
        this.f67169u = this.f66898k.getHeight();
    }

    public boolean W(int i3, String str, int i16, int i17) {
        boolean z16;
        while (true) {
            i17 -= 10;
            if (i17 <= f67163x) {
                z16 = true;
                break;
            }
            N(i17);
            M(i3, str);
            if (this.f66898k.getHeight() < i16) {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return false;
        }
        this.f67165q = (int) (i16 / (this.f66898k.getHeight() / this.f66898k.getLineCount()));
        M(i3, str);
        return true;
    }

    public int X(int i3, String str, int i16, int i17) {
        int i18 = i17 + 10;
        N(i18);
        M(i3, str);
        if (this.f66898k.getHeight() < i16) {
            return i18;
        }
        N(i17);
        M(i3, str);
        return i17;
    }
}
