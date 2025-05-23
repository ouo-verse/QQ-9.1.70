package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class x extends c {

    /* renamed from: e, reason: collision with root package name */
    private static final double f67170e = Math.abs(Math.tan(Math.toRadians(10.0d)));

    /* renamed from: b, reason: collision with root package name */
    private Path f67171b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private float f67172c;

    /* renamed from: d, reason: collision with root package name */
    private float f67173d;

    public x(int i3, int i16, int i17) {
        this.f67003a.setColor(i3);
        this.f67172c = i16 + ScreenUtil.dip2px(4.0f);
        this.f67173d = i17;
    }

    private float c(float f16) {
        if (f16 < 0.0f) {
            return 0.0f;
        }
        return f16;
    }

    private boolean d(float f16, float f17, float f18) {
        if (f16 - f17 >= f18 * 0.15f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.c
    public void b(Canvas canvas, ArrayList<aa> arrayList, int i3, int i16) {
        int i17;
        float c16;
        float f16;
        float c17;
        float f17;
        float f18;
        if (canvas == null || arrayList == null) {
            return;
        }
        this.f67171b.reset();
        int i18 = 0;
        RectF rectF = arrayList.get(0).f67006c;
        RectF rectF2 = arrayList.get(arrayList.size() - 1).f67006c;
        float width = rectF.width() / arrayList.get(0).f66921e.length();
        float f19 = i3;
        float f26 = i16;
        this.f67171b.moveTo(rectF2.right + f19 + this.f67172c, rectF2.bottom + f26 + this.f67173d);
        this.f67171b.lineTo((rectF2.left + f19) - this.f67172c, rectF2.bottom + f26 + this.f67173d);
        this.f67171b.lineTo((rectF.left + f19) - this.f67172c, (rectF.top + f26) - this.f67173d);
        this.f67171b.lineTo(rectF.right + f19 + this.f67172c, (rectF.top + f26) - this.f67173d);
        if (arrayList.size() == 1) {
            this.f67171b.lineTo(((float) ((rectF2.right - (f67170e * arrayList.get(0).f67006c.height())) + i3)) + this.f67172c, rectF2.bottom + f26 + this.f67173d);
        } else {
            float f27 = -1.0f;
            float f28 = -1.0f;
            float f29 = -1.0f;
            while (i18 < arrayList.size()) {
                RectF rectF3 = arrayList.get(i18).f67006c;
                if (f28 != f27 && f29 != f27) {
                    int i19 = i18 + 1;
                    if (arrayList.size() == i19) {
                        float f36 = rectF3.top;
                        if (f29 == f36) {
                            this.f67171b.lineTo(rectF3.right + f19 + this.f67172c, f36 + f26);
                            f28 = c((float) (rectF3.right - (f67170e * rectF3.height())));
                            f17 = rectF3.bottom;
                            f18 = this.f67173d;
                        } else {
                            float c18 = c((f28 - (0.75f * width)) + this.f67172c);
                            this.f67171b.lineTo(c18 + f19, f29 + (rectF3.height() * 0.1f) + f26);
                            f28 = c((float) (c18 - ((rectF3.height() * 0.9f) * f67170e)));
                            f17 = rectF3.bottom;
                            f18 = this.f67173d;
                        }
                        f29 = f17 + f18;
                        this.f67171b.lineTo(f28 + f19, f29 + f26);
                        i17 = i18;
                    } else {
                        RectF rectF4 = arrayList.get(i19).f67006c;
                        float f37 = rectF3.top;
                        if (f29 == f37) {
                            this.f67171b.lineTo(rectF3.right + this.f67172c + f19, f37 + f26);
                        } else {
                            float c19 = c((f28 - (0.75f * width)) + this.f67172c);
                            f37 = (rectF3.height() * 0.1f) + f29;
                            this.f67171b.lineTo(c19 + f19, f37 + f26);
                        }
                        if (d(rectF3.width(), rectF4.width(), width)) {
                            float height = (rectF3.bottom - f37) + (rectF4.height() * 0.1f);
                            f29 = rectF3.top + height;
                            i17 = i18;
                            c17 = c(((float) (rectF3.right - (f67170e * height))) + this.f67172c);
                        } else {
                            i17 = i18;
                            c17 = c(((float) (rectF3.right - (f67170e * rectF3.height()))) + this.f67172c);
                            f29 = rectF4.top;
                        }
                        this.f67171b.lineTo(c17 + f19, f29 + f26);
                        f28 = c17;
                    }
                } else {
                    i17 = i18;
                    RectF rectF5 = arrayList.get(i17 + 1).f67006c;
                    if (d(rectF3.width(), rectF5.width(), width)) {
                        float height2 = rectF3.height() + (rectF5.height() * 0.1f);
                        f16 = rectF3.top + height2;
                        c16 = c((float) ((rectF3.right - (f67170e * height2)) + this.f67172c));
                    } else {
                        c16 = c((float) ((rectF3.right - (f67170e * rectF3.height())) + this.f67172c));
                        f16 = rectF5.top;
                    }
                    this.f67171b.lineTo(c16 + f19, f16 + f26);
                    f29 = f16;
                    f28 = c16;
                }
                i18 = i17 + 1;
                f27 = -1.0f;
            }
        }
        canvas.drawPath(this.f67171b, this.f67003a);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.c
    public void a(Canvas canvas, RectF rectF, int i3, int i16) {
    }
}
