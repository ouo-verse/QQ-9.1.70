package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
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
public class h extends DynamicTextItem {

    /* renamed from: p, reason: collision with root package name */
    private TextPaint f67051p;

    /* renamed from: q, reason: collision with root package name */
    private TextPaint f67052q;

    /* renamed from: r, reason: collision with root package name */
    private float f67053r;

    /* renamed from: s, reason: collision with root package name */
    private float f67054s;

    /* renamed from: t, reason: collision with root package name */
    private RectF f67055t;

    /* renamed from: u, reason: collision with root package name */
    private StaticLayout f67056u;

    public h(int i3, List<String> list, Typeface typeface) {
        super(i3, list);
        this.f67055t = new RectF();
        this.f67051p = new TextPaint();
        this.f67052q = new TextPaint();
        if (typeface != null) {
            this.f67051p.setTypeface(typeface);
            this.f67052q.setTypeface(typeface);
        } else {
            this.f67051p.setTypeface(Typeface.defaultFromStyle(1));
            this.f67052q.setTypeface(Typeface.defaultFromStyle(1));
        }
        this.f67051p.setTextAlign(Paint.Align.LEFT);
        this.f67051p.setAntiAlias(true);
        this.f67051p.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f67051p.setTextSize(BaseAIOUtils.f(22.0f, BaseApplication.getContext().getResources()));
        this.f67051p.setColor(-1);
        this.f67052q.setTextAlign(Paint.Align.LEFT);
        this.f67052q.setAntiAlias(true);
        this.f67052q.setStyle(Paint.Style.STROKE);
        this.f67052q.setStrokeJoin(Paint.Join.ROUND);
        this.f67052q.setTextSize(BaseAIOUtils.f(22.0f, BaseApplication.getContext().getResources()));
        this.f67052q.setColor(-16777216);
        this.f67052q.setStrokeWidth(BaseAIOUtils.f(6.0f, BaseApplication.getContext().getResources()));
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
        if (this.f66898k != null) {
            canvas.save();
            this.f67056u.draw(canvas);
            this.f66898k.draw(canvas);
            if (H(0)) {
                RectF rectF = this.f67055t;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = super.x(this.f66898k);
                this.f67055t.bottom = this.f66898k.getHeight();
                canvas.drawRoundRect(this.f67055t, 6.0f, 6.0f, j());
            }
            canvas.restore();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        int measureText = (int) this.f67051p.measureText(HardCodeUtil.qqStr(R.string.k2n));
        this.f66898k = ag.a(k3, 0, k3.length(), this.f67051p, measureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, 2);
        this.f67056u = ag.a(k3, 0, k3.length(), this.f67052q, measureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, 2);
        this.f67053r = super.x(this.f66898k);
        this.f67054s = this.f66898k.getHeight();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67054s;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67053r;
    }
}
