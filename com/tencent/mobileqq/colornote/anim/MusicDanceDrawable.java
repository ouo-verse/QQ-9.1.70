package com.tencent.mobileqq.colornote.anim;

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
public class MusicDanceDrawable extends Drawable implements b, Runnable {
    private static List<Double>[] F;
    private int C;
    private boolean D;
    private int E = 0;

    /* renamed from: d, reason: collision with root package name */
    private Paint f201343d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f201344e;

    /* renamed from: f, reason: collision with root package name */
    private int f201345f;

    /* renamed from: h, reason: collision with root package name */
    private int f201346h;

    /* renamed from: i, reason: collision with root package name */
    private int f201347i;

    /* renamed from: m, reason: collision with root package name */
    private int f201348m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private int f201349a;

        /* renamed from: b, reason: collision with root package name */
        private int f201350b;

        /* renamed from: c, reason: collision with root package name */
        private int f201351c;

        /* renamed from: d, reason: collision with root package name */
        private int f201352d;

        a(int i3, int i16, int i17, int i18) {
            this.f201350b = i3;
            this.f201351c = i16;
            this.f201352d = i17;
        }

        public void d(int i3) {
            this.f201349a = i3;
        }
    }

    private static int d(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void a(Context context, int i3, int i16, int i17) {
        this.f201348m = i3;
        this.C = i16;
        this.f201344e = new ArrayList();
        Paint paint = new Paint();
        this.f201343d = paint;
        paint.setAntiAlias(true);
        this.f201343d.setColor(i17);
        this.f201346h = i16;
        this.f201347i = d(2.0f, context.getResources());
        IAppSettingApi iAppSettingApi = (IAppSettingApi) QRoute.api(IAppSettingApi.class);
        if (this.f201347i < 0 && iAppSettingApi.isDebugVersion()) {
            throw new IllegalStateException("MusicDanceView#mBarPadding mast > 0");
        }
        int i18 = (i3 - (this.f201347i * 2)) / 3;
        for (int i19 = 0; this.f201344e.size() < 3 && i19 < 3; i19++) {
            c(0, i16, i18, -1);
        }
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void b(Context context, int i3, int i16) {
        a(context, i3, i16, -16777216);
    }

    public void c(int i3, int i16, int i17, int i18) {
        this.f201344e.add(new a(i3, i16, i17, i18));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f201345f = 0;
        for (int i3 = 0; i3 < this.f201344e.size(); i3++) {
            a aVar = this.f201344e.get(i3);
            canvas.drawRect(this.f201345f, this.f201346h - aVar.f201349a, this.f201345f + aVar.f201352d, this.f201346h, this.f201343d);
            this.f201345f += aVar.f201352d + this.f201347i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f201348m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.D) {
            for (int i3 = 0; i3 < this.f201344e.size(); i3++) {
                double doubleValue = F[i3].get(this.E).doubleValue();
                this.f201344e.get(i3).d((int) (r4.f201351c * doubleValue));
            }
            scheduleSelf(this, 50L);
            invalidateSelf();
            int i16 = this.E + 1;
            this.E = i16;
            if (i16 >= F[0].size()) {
                this.E = 0;
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void start(int i3) {
        if (F == null) {
            F = new ArrayList[3];
            for (int i16 = 0; i16 < 3; i16++) {
                F[i16] = new ArrayList();
            }
            for (double d16 = 0.0d; d16 < 3.141592653589793d; d16 += 0.05d) {
                F[0].add(Double.valueOf(Math.abs(Math.sin(d16 + 0.0d))));
                F[1].add(Double.valueOf(Math.abs(Math.sin(1.0d + d16))));
                F[2].add(Double.valueOf(Math.abs(Math.sin(2.0d + d16))));
            }
        }
        if (!this.D) {
            scheduleSelf(this, 0L);
            invalidateSelf();
            this.D = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicDanceView", 2, "start music animation");
        }
    }

    @Override // com.tencent.mobileqq.colornote.anim.b
    public void stop() {
        this.D = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
