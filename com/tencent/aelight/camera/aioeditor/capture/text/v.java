package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class v extends w {
    private static final int C;
    public static final int D;
    private static final int E;
    private int A;
    private int B;

    /* renamed from: y, reason: collision with root package name */
    private Paint f67159y;

    /* renamed from: z, reason: collision with root package name */
    private RectF f67160z;

    static {
        Resources resources = BaseApplication.getContext().getResources();
        E = BaseAIOUtils.f(1.0f, resources);
        D = BaseAIOUtils.f(22.0f, resources);
        C = BaseAIOUtils.f(11.0f, resources);
    }

    public v(int i3, List<String> list) {
        super(i3, list);
        this.A = Color.parseColor("#FFFFFF");
        TextPaint textPaint = new TextPaint();
        this.f67159y = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.f67159y.setColor(16777215);
        this.f67159y.setAlpha(230);
        this.f67159y.setAntiAlias(true);
        this.f67160z = new RectF();
        this.B = E;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void I(Canvas canvas) {
        StaticLayout staticLayout = this.f66898k;
        if (staticLayout != null) {
            if (staticLayout.getLineCount() == 1) {
                canvas.save();
                canvas.translate(w() / 2.0f, m() / 2.0f);
                this.f67167s.setTextAlign(Paint.Align.CENTER);
                String k3 = super.k(0);
                if (TextUtils.isEmpty(k3)) {
                    k3 = "\u3000\u3000";
                }
                int measureText = (int) this.f67167s.measureText(k3);
                int ceil = (int) Math.ceil(this.f67167s.descent() - this.f67167s.ascent());
                RectF rectF = this.f67160z;
                int i3 = D;
                rectF.left = (-((i3 * 2) + measureText)) / 2.0f;
                rectF.right = ((i3 * 2) + measureText) / 2.0f;
                int i16 = C;
                rectF.top = (-((i16 * 2) + ceil)) / 2.0f;
                rectF.bottom = ((i16 * 2) + ceil) / 2.0f;
                int i17 = this.B;
                canvas.drawRoundRect(rectF, i17, i17, this.f67159y);
                canvas.drawText(k3, 0.0f, -((this.f67167s.descent() + this.f67167s.ascent()) / 2.0f), this.f67167s);
                if (super.H(0)) {
                    RectF rectF2 = this.f67164p;
                    rectF2.left = (-measureText) / 2.0f;
                    rectF2.top = (-ceil) / 2.0f;
                    rectF2.right = measureText / 2.0f;
                    rectF2.bottom = ceil / 2.0f;
                    canvas.drawRoundRect(rectF2, 6.0f, 6.0f, j());
                }
                canvas.restore();
                return;
            }
            this.f67167s.setTextAlign(Paint.Align.LEFT);
            canvas.save();
            int i18 = D;
            int i19 = C;
            canvas.translate(i18, i19);
            float x16 = super.x(this.f66898k);
            float height = this.f66898k.getHeight();
            RectF rectF3 = this.f67160z;
            rectF3.left = -i18;
            rectF3.right = i18 + x16;
            rectF3.top = -i19;
            rectF3.bottom = i19 + height;
            int i26 = this.B;
            canvas.drawRoundRect(rectF3, i26, i26, this.f67159y);
            this.f66898k.draw(canvas);
            if (super.H(0)) {
                RectF rectF4 = this.f67164p;
                rectF4.left = 0.0f;
                rectF4.top = 0.0f;
                rectF4.right = x16;
                rectF4.bottom = height;
                canvas.drawRoundRect(rectF4, 6.0f, 6.0f, j());
            }
            canvas.restore();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w
    public int R() {
        return this.A;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w
    public void V(int i3) {
        this.f67159y.setColor(i3);
        this.f67159y.setAlpha(230);
        this.A = i3;
        if (i3 != Color.parseColor("#FFFFFF") && i3 != Color.parseColor("#F7E368") && i3 != Color.parseColor("#7ED5F8")) {
            this.f67167s.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        } else {
            this.f67167s.setColor(Color.parseColor("#000000"));
        }
    }

    public void Y(int i3) {
        this.B = i3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67169u + (C * 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67168t + (D * 2);
    }
}
