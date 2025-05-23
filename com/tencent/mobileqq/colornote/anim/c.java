package com.tencent.mobileqq.colornote.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends Drawable implements com.tencent.mobileqq.colornote.anim.b {
    private int C;
    private ValueAnimator D;

    /* renamed from: d, reason: collision with root package name */
    private Paint f201366d;

    /* renamed from: e, reason: collision with root package name */
    private List<b> f201367e;

    /* renamed from: f, reason: collision with root package name */
    private int f201368f;

    /* renamed from: h, reason: collision with root package name */
    private int f201369h;

    /* renamed from: i, reason: collision with root package name */
    private int f201370i;

    /* renamed from: m, reason: collision with root package name */
    private int f201371m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float h16;
            float f16;
            float f17;
            float h17;
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i3 = 0; i3 < c.this.f201367e.size(); i3++) {
                b bVar = (b) c.this.f201367e.get(i3);
                if (i3 != 0 && i3 != 4) {
                    if (i3 != 1 && i3 != 3) {
                        f16 = bVar.f201374b;
                        f17 = bVar.f201375c - bVar.f201374b;
                        h17 = c.this.h(1.0f + floatValue);
                    } else {
                        f16 = bVar.f201374b;
                        f17 = bVar.f201375c - bVar.f201374b;
                        h17 = c.this.h(1.0f + floatValue);
                    }
                    h16 = f16 + (f17 * h17);
                } else {
                    h16 = ((bVar.f201375c - bVar.f201374b) * c.this.h(floatValue)) + bVar.f201374b;
                }
                bVar.e((int) h16);
            }
            c.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f201373a;

        /* renamed from: b, reason: collision with root package name */
        private int f201374b;

        /* renamed from: c, reason: collision with root package name */
        private int f201375c;

        /* renamed from: d, reason: collision with root package name */
        private int f201376d;

        b(int i3, int i16, int i17, int i18) {
            this.f201374b = i3;
            this.f201375c = i16;
            this.f201376d = i17;
        }

        public void e(int i3) {
            this.f201373a = i3;
        }
    }

    private static int f(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private int g(Context context, int i3, int i16) {
        return (int) (f(i16, context.getResources()) * ((i3 * 1.0f) / f(20.0f, context.getResources())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(float f16) {
        float f17 = f16 % 2.0f;
        if (f17 < 1.0f) {
            return f17;
        }
        return 2.0f - f17;
    }

    private void i(int i3) {
        ValueAnimator valueAnimator = this.D;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
        this.D = ofFloat;
        ofFloat.setRepeatMode(1);
        this.D.setRepeatCount(-1);
        this.D.setDuration(i3);
        this.D.addUpdateListener(new a());
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void a(Context context, int i3, int i16, int i17) {
        this.f201371m = i3;
        this.C = i16;
        this.f201367e = new ArrayList();
        Paint paint = new Paint();
        this.f201366d = paint;
        paint.setAntiAlias(true);
        this.f201366d.setColor(i17);
        this.f201369h = i16;
        this.f201370i = f(2.0f, context.getResources());
        IAppSettingApi iAppSettingApi = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
        if (this.f201370i < 0 && iAppSettingApi.isDebugVersion()) {
            throw new IllegalStateException("MusicDanceView#mBarPadding mast > 0");
        }
        int i18 = (i3 - (this.f201370i * 4)) / 5;
        for (int i19 = 0; this.f201367e.size() < 5 && i19 < 5; i19++) {
            if (i19 != 0 && i19 != 4) {
                if (i19 != 1 && i19 != 3) {
                    e(g(context, i16, 2), i16, i18, -1);
                } else {
                    e(g(context, i16, 8), i16 - g(context, i16, 6), i18, -1);
                }
            } else {
                e(g(context, i16, 6), i16 - g(context, i16, 4), i18, -1);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void b(Context context, int i3, int i16) {
        a(context, i3, i16, -16777216);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f201368f = 0;
        for (int i3 = 0; i3 < this.f201367e.size(); i3++) {
            b bVar = this.f201367e.get(i3);
            canvas.drawRect(this.f201368f, (this.f201369h / 2) - (bVar.f201373a / 2), this.f201368f + bVar.f201376d, (this.f201369h / 2) + (bVar.f201373a / 2), this.f201366d);
            this.f201368f += bVar.f201376d + this.f201370i;
        }
    }

    public void e(int i3, int i16, int i17, int i18) {
        this.f201367e.add(new b(i3, i16, i17, i18));
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f201371m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void start(int i3) {
        if (this.D == null) {
            i(i3);
        }
        this.D.start();
        if (QLog.isColorLevel()) {
            QLog.d("MusicDanceViewV2", 1, "Start music dance animation");
        }
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void stop() {
        this.D.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
