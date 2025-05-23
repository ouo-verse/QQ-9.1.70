package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends DynamicTextItem {

    /* renamed from: w, reason: collision with root package name */
    private static final int f67057w = BaseAIOUtils.f(20.0f, BaseApplication.getContext().getResources());

    /* renamed from: x, reason: collision with root package name */
    private static final int f67058x = BaseAIOUtils.f(12.0f, BaseApplication.getContext().getResources());

    /* renamed from: p, reason: collision with root package name */
    private StaticLayout f67059p;

    /* renamed from: q, reason: collision with root package name */
    private NinePatch f67060q;

    /* renamed from: r, reason: collision with root package name */
    private TextPaint f67061r;

    /* renamed from: s, reason: collision with root package name */
    float f67062s;

    /* renamed from: t, reason: collision with root package name */
    float f67063t;

    /* renamed from: u, reason: collision with root package name */
    private RectF f67064u;

    /* renamed from: v, reason: collision with root package name */
    private RectF f67065v;

    public i(int i3, List<String> list, Typeface typeface, Bitmap bitmap) {
        super(i3, list);
        this.f67064u = new RectF();
        this.f67065v = new RectF();
        TextPaint textPaint = new TextPaint();
        this.f67061r = textPaint;
        textPaint.setAntiAlias(true);
        this.f67061r.setTypeface(typeface);
        this.f67061r.setTextSize(BaseAIOUtils.f(20.0f, BaseApplication.getContext().getResources()));
        this.f67061r.setColor(-16777216);
        this.f67060q = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
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
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        int measureText = (int) this.f67061r.measureText(HardCodeUtil.qqStr(R.string.f171672k42));
        StaticLayout a16 = ag.a(k3, 0, k3.length(), this.f67061r, measureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, 3);
        this.f67059p = a16;
        int lineCount = a16.getLineCount();
        float f16 = 0.0f;
        for (int i16 = 0; i16 < lineCount; i16++) {
            f16 = Math.max(f16, this.f67059p.getLineWidth(i16));
        }
        float height = this.f67059p.getHeight();
        this.f67064u.set(0.0f, 0.0f, Math.max(this.f67060q.getWidth(), f67058x + f67057w + f16), (this.f67060q.getHeight() * 0.7f) + height);
        this.f67062s = f16;
        this.f67063t = height;
        hd0.c.a("BubbleTextItem", "set text " + k3 + " max " + measureText + " tw " + f16 + " th " + height);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67064u.height() + 20.0f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67064u.width() + 20.0f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void I(Canvas canvas) {
        canvas.translate(10.0f, 10.0f);
        this.f67060q.draw(canvas, this.f67064u);
        canvas.translate(f67057w, this.f67060q.getHeight() * 0.4f);
        this.f67059p.draw(canvas);
        if (super.H(0)) {
            float height = this.f67059p.getHeight();
            float x16 = super.x(this.f67059p);
            RectF rectF = this.f67065v;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = x16;
            rectF.bottom = height;
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
        }
    }
}
