package com.qzone.widget.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends b {

    /* renamed from: s, reason: collision with root package name */
    private int f60960s;

    public c(int i3) {
        super(i3);
        this.f60960s = 0;
    }

    @Override // com.qzone.widget.particle.b
    public void a(Canvas canvas, Paint paint) {
        if (this.f60954m <= 0) {
            if (this.f60955n) {
                this.f60960s += 20;
                this.f60942a = (float) (this.f60942a + 0.1d);
            } else {
                this.f60960s -= 20;
                this.f60942a = (float) (this.f60942a - 0.1d);
            }
            float f16 = this.f60942a;
            float f17 = this.f60959r;
            if (f16 > f17) {
                this.f60942a = f17;
            }
            int i3 = this.f60960s;
            if (i3 > 255) {
                i3 = 255;
            }
            this.f60960s = i3;
            if (i3 < 0) {
                i3 = 0;
            }
            this.f60960s = i3;
            paint.setAlpha(i3);
            paint.setColor(this.f60956o);
            canvas.drawCircle((int) this.f60945d, (int) this.f60946e, this.f60942a, paint);
        }
    }

    @Override // com.qzone.widget.particle.b
    public void n() {
        super.n();
        this.f60942a = (int) (Math.random() * (this.f60959r / 2.0f));
        this.f60960s = ((int) (Math.random() * 100.0d)) + 155;
        this.f60954m = (int) (Math.random() * 15.0d);
        this.f60955n = true;
    }
}
