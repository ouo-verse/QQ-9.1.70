package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ah extends DynamicTextItem {

    /* renamed from: w, reason: collision with root package name */
    public static final int f66974w;

    /* renamed from: x, reason: collision with root package name */
    public static final int f66975x;

    /* renamed from: y, reason: collision with root package name */
    public static final int f66976y;

    /* renamed from: p, reason: collision with root package name */
    private RectF f66977p;

    /* renamed from: q, reason: collision with root package name */
    private int f66978q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f66979r;

    /* renamed from: s, reason: collision with root package name */
    private TextPaint f66980s;

    /* renamed from: t, reason: collision with root package name */
    private float f66981t;

    /* renamed from: u, reason: collision with root package name */
    private float f66982u;

    /* renamed from: v, reason: collision with root package name */
    ai f66983v;

    static {
        Resources resources = BaseApplication.getContext().getResources();
        f66974w = BaseAIOUtils.f(36.0f, resources);
        f66976y = BaseAIOUtils.f(6.0f, resources);
        f66975x = (resources.getDisplayMetrics().widthPixels - com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67981e0) - (zr.a.d() * 2);
    }

    public ah(int i3, List<String> list, Typeface typeface) {
        super(i3, list);
        this.f66977p = new RectF();
        this.f66978q = 0;
        this.f66979r = true;
        TextPaint textPaint = new TextPaint();
        this.f66980s = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.f66980s.setTextAlign(Paint.Align.CENTER);
        if (typeface == null) {
            this.f66980s.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.f66980s.setTypeface(typeface);
        }
        this.f66980s.setAntiAlias(true);
        this.f66980s.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f66980s.setTextSize(f66974w);
        this.f66980s.setColor(-1);
        this.f66980s.setTextAlign(Paint.Align.LEFT);
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
        this.f66983v.b(canvas, 0, 0);
        if (super.H(0)) {
            RectF rectF = this.f66977p;
            ai aiVar = this.f66983v;
            rectF.set(aiVar.f(1, aiVar.c()));
            canvas.drawRoundRect(this.f66977p, 6.0f, 6.0f, j());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        this.f66978q = BaseAIOUtils.f(18.0f, BaseApplication.getContext().getResources());
        ai aiVar = new ai(0);
        this.f66983v = aiVar;
        aiVar.j(new y(SupportMenu.CATEGORY_MASK, f66976y));
        this.f66983v.i(k3, f66975x, f66974w, this.f66980s);
        this.f66983v.a(new r(this.f66978q));
        ai aiVar2 = this.f66983v;
        this.f66981t = aiVar2.f(1, aiVar2.c()).width();
        ai aiVar3 = this.f66983v;
        float height = aiVar3.f(1, aiVar3.c()).height();
        this.f66982u = height;
        this.f66983v.a(new j(this.f66981t, height));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f66982u;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f66981t;
    }
}
