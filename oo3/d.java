package oo3;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f423266a = ValueAnimator.ofFloat(0.0f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    private b f423267b;

    /* renamed from: c, reason: collision with root package name */
    private a f423268c;

    public d(@NonNull c cVar) {
        this.f423267b = new b(cVar);
        this.f423268c = new a(cVar);
        this.f423266a.addUpdateListener(this.f423267b);
        this.f423266a.addListener(this.f423268c);
    }

    public void a() {
        this.f423266a.removeAllListeners();
        this.f423266a.removeAllUpdateListeners();
    }

    public void b(float f16, float f17) {
        this.f423267b.b(f16, f17);
    }

    public void c(long j3, long j16) {
        this.f423267b.a(j3, j16);
    }

    public boolean d() {
        if (this.f423266a.isRunning()) {
            QLog.i("ScoreGrowthAnimation", 1, "animation is running, should cancel.");
            this.f423266a.cancel();
        }
        this.f423266a.setDuration(1000L);
        this.f423266a.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f423266a.setRepeatCount(0);
        this.f423266a.start();
        return true;
    }
}
