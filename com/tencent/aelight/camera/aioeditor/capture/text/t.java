package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t extends w {
    private static final int B;
    private static final int C;
    private static final int D;
    private int A;

    /* renamed from: y, reason: collision with root package name */
    private Paint f67155y;

    /* renamed from: z, reason: collision with root package name */
    private RectF f67156z;

    static {
        Resources resources = BaseApplication.getContext().getResources();
        D = BaseAIOUtils.f(22.0f, resources);
        C = BaseAIOUtils.f(22.0f, resources);
        B = BaseAIOUtils.f(11.0f, resources);
    }

    public t(int i3, List<String> list) {
        super(i3, list);
        this.A = Color.parseColor("#FFFFFF");
        Paint paint = new Paint();
        this.f67155y = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f67155y.setColor(16777215);
        this.f67155y.setAlpha(230);
        this.f67155y.setAntiAlias(true);
        this.f67156z = new RectF();
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
                int i3 = B;
                float f16 = ((i3 * 2) + ceil) / 2.0f;
                RectF rectF = this.f67156z;
                float f17 = measureText;
                float f18 = (f16 * 2.0f) + f17;
                rectF.left = (-f18) / 2.0f;
                rectF.right = f18 / 2.0f;
                rectF.top = (-((i3 * 2) + ceil)) / 2.0f;
                rectF.bottom = ((i3 * 2) + ceil) / 2.0f;
                canvas.drawRoundRect(rectF, f16, f16, this.f67155y);
                canvas.drawText(k3, 0.0f, -((this.f67167s.descent() + this.f67167s.ascent()) / 2.0f), this.f67167s);
                if (super.H(0)) {
                    RectF rectF2 = this.f67164p;
                    rectF2.left = (-measureText) / 2.0f;
                    rectF2.top = (-ceil) / 2.0f;
                    rectF2.right = f17 / 2.0f;
                    rectF2.bottom = ceil / 2.0f;
                    canvas.drawRoundRect(rectF2, 6.0f, 6.0f, j());
                }
                canvas.restore();
                return;
            }
            this.f67167s.setTextAlign(Paint.Align.LEFT);
            canvas.save();
            int i16 = D;
            int i17 = B;
            canvas.translate(i16, i17);
            float x16 = super.x(this.f66898k);
            float height = this.f66898k.getHeight();
            RectF rectF3 = this.f67156z;
            rectF3.left = -i16;
            rectF3.right = i16 + x16;
            rectF3.top = -i17;
            rectF3.bottom = i17 + height;
            canvas.drawRoundRect(rectF3, i16, i16, this.f67155y);
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
        this.f67155y.setColor(i3);
        this.f67155y.setAlpha(230);
        this.A = i3;
        if (i3 != Color.parseColor("#FFFFFF") && i3 != Color.parseColor("#F7E368") && i3 != Color.parseColor("#7ED5F8")) {
            this.f67167s.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        } else {
            this.f67167s.setColor(Color.parseColor("#000000"));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67169u + (B * 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.w, com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67168t + (D * 2);
    }
}
