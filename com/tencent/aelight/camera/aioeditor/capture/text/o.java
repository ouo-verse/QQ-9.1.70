package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.text.f;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class o extends DynamicTextItem {

    /* renamed from: p, reason: collision with root package name */
    private RectF f67116p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f67117q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f67118r;

    /* renamed from: s, reason: collision with root package name */
    private int f67119s;

    /* renamed from: t, reason: collision with root package name */
    private int f67120t;

    /* renamed from: u, reason: collision with root package name */
    private TextPaint f67121u;

    /* renamed from: v, reason: collision with root package name */
    private float f67122v;

    /* renamed from: w, reason: collision with root package name */
    private float f67123w;

    /* renamed from: x, reason: collision with root package name */
    ai f67124x;

    /* renamed from: y, reason: collision with root package name */
    private Bitmap f67125y;

    /* renamed from: z, reason: collision with root package name */
    private Bitmap f67126z;
    public static final float B = ScreenUtil.dip2px(45.0f);
    public static final int A = BaseAIOUtils.f(24.0f, BaseApplication.getContext().getResources());

    public o(int i3, List<String> list, Bitmap bitmap, Bitmap bitmap2, Typeface typeface) {
        super(i3, list);
        this.f67116p = new RectF();
        this.f67117q = new RectF();
        this.f67118r = new RectF();
        TextPaint textPaint = new TextPaint();
        this.f67121u = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.f67121u.setTextAlign(Paint.Align.CENTER);
        if (typeface == null) {
            this.f67121u.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.f67121u.setTypeface(typeface);
        }
        this.f67121u.setAntiAlias(true);
        this.f67121u.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67121u.setColor(-16777216);
        this.f67121u.setTextAlign(Paint.Align.LEFT);
        int i16 = A;
        this.f67120t = i16 * 9;
        new f.a().e(0.0f, 0.0f).f(this.f67120t, i16, 5, 9).b();
        this.f67119s = i16;
        this.f67121u.setTextSize(i16);
        this.f67125y = bitmap;
        this.f67126z = bitmap2;
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
        if (this.f67124x == null) {
            return;
        }
        canvas.save();
        this.f67121u.setTextAlign(Paint.Align.LEFT);
        canvas.save();
        for (int i3 = 0; i3 < this.f67124x.c(); i3++) {
            this.f67118r.set(this.f67124x.e(i3));
            this.f67117q.set(this.f67118r);
            Q(this.f67124x.d(i3), this.f67117q, canvas, this.f67121u);
            RectF rectF = this.f67118r;
            rectF.bottom -= B;
            this.f67117q.set(rectF);
        }
        canvas.restore();
        canvas.rotate(-10.0f, this.f67122v / 2.0f, this.f67123w / 2.0f);
        canvas.translate(0.0f, -ScreenUtil.dip2px(5.0f));
        this.f67121u.setColor(-16777216);
        this.f67124x.b(canvas, 0, 0);
        if (super.H(0)) {
            RectF rectF2 = this.f67116p;
            ai aiVar = this.f67124x;
            rectF2.set(aiVar.f(1, aiVar.c()));
            canvas.drawRoundRect(this.f67116p, 6.0f, 6.0f, j());
        }
        canvas.restore();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        ai aiVar = new ai(0);
        this.f67124x = aiVar;
        aiVar.i(k3, this.f67120t, A, this.f67121u);
        this.f67124x.a(new r((int) B));
        ai aiVar2 = this.f67124x;
        this.f67122v = aiVar2.f(1, aiVar2.c()).width();
        ai aiVar3 = this.f67124x;
        this.f67123w = aiVar3.f(1, aiVar3.c()).height();
        int i16 = 0;
        for (int i17 = 0; i17 < this.f67124x.c(); i17++) {
            int d16 = this.f67124x.d(i17);
            if (i16 <= d16) {
                i16 = d16;
            }
        }
        if (i16 <= 4) {
            this.f67122v = this.f67125y.getWidth();
        } else {
            this.f67122v = this.f67126z.getWidth();
        }
        this.f67124x.a(new j(this.f67122v, this.f67123w));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67123w;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67122v;
    }

    private void Q(int i3, RectF rectF, Canvas canvas, Paint paint) {
        if (i3 < 0 || rectF == null || canvas == null || paint == null) {
            return;
        }
        if (i3 < 4) {
            canvas.drawBitmap(this.f67125y, rectF.left + ((rectF.width() - this.f67125y.getWidth()) / 2.0f), rectF.top + ((rectF.height() - this.f67125y.getHeight()) / 2.0f), paint);
        } else {
            canvas.drawBitmap(this.f67126z, rectF.left + ((rectF.width() - this.f67126z.getWidth()) / 2.0f), rectF.top + ((rectF.height() - this.f67126z.getHeight()) / 2.0f), paint);
        }
    }
}
