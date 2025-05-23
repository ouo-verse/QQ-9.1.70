package m;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.api.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f415888a;

    /* renamed from: e, reason: collision with root package name */
    public ETFont f415892e;

    /* renamed from: f, reason: collision with root package name */
    public ValueAnimator f415893f;

    /* renamed from: g, reason: collision with root package name */
    public volatile int f415894g;

    /* renamed from: b, reason: collision with root package name */
    public int[] f415889b = {-1, -1};

    /* renamed from: c, reason: collision with root package name */
    public int f415890c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f415891d = -1;

    /* renamed from: h, reason: collision with root package name */
    protected Canvas f415895h = new Canvas();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i3, int i16);

        int b(int i3, int i16);

        void h();

        void i(int i3, @NonNull int[] iArr, boolean z16);
    }

    public void c() {
        this.f415892e.mShouldDisplayAnimation = true;
        ValueAnimator valueAnimator = this.f415893f;
        if (valueAnimator == null) {
            e();
            this.f415893f.start();
        } else if (!valueAnimator.isRunning()) {
            this.f415893f.setIntValues(this.f415890c);
            this.f415893f.setDuration(this.f415890c * this.f415891d);
            this.f415893f.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.f415895h == null) {
            this.f415895h = new Canvas();
        }
        this.f415895h.setBitmap(this.f415888a);
        this.f415895h.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f415890c);
        this.f415893f = ofInt;
        ofInt.setDuration(this.f415890c * this.f415891d);
        this.f415893f.setRepeatCount(0);
        this.f415893f.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(int i3, int i16) {
        try {
            Bitmap bitmap = this.f415888a;
            if (bitmap == null) {
                this.f415888a = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                return true;
            }
            if (i3 > bitmap.getWidth() || i16 > this.f415888a.getHeight() || ((i3 << 1) < this.f415888a.getWidth() && (i16 << 1) < this.f415888a.getHeight())) {
                this.f415888a = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                return true;
            }
            return true;
        } catch (OutOfMemoryError e16) {
            QLog.e("FounderBaseLayout", 2, "FounderColorLayout#createNewWordBitmapIfNeed w=" + i3 + " h=" + i16, e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        if (g.f308459b.isDebugVersion()) {
            return getClass().getSimpleName();
        }
        return "BaseLayout";
    }

    public abstract boolean j(Canvas canvas);

    public abstract int[] k(int i3, int i16, long j3, boolean z16, ETFont eTFont) throws Exception;

    public void l() {
        Bitmap bitmap = this.f415888a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f415888a = null;
        }
        ValueAnimator valueAnimator = this.f415893f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f415893f = null;
        }
        this.f415895h = null;
    }

    public void m() {
        ValueAnimator valueAnimator = this.f415893f;
        if (valueAnimator != null && valueAnimator.isRunning() && this.f415894g > 0) {
            this.f415893f.cancel();
            this.f415892e.mShouldDisplayAnimation = false;
        }
    }

    public void n() {
        ValueAnimator valueAnimator;
        if (this.f415892e != null && this.f415890c > 0 && this.f415891d > 0 && (valueAnimator = this.f415893f) != null && !valueAnimator.isRunning() && this.f415894g > 0 && this.f415894g < this.f415890c) {
            this.f415892e.mShouldDisplayAnimation = true;
            this.f415893f.setIntValues(this.f415894g, this.f415890c);
            this.f415893f.setDuration((this.f415890c - this.f415894g) * this.f415891d);
            this.f415893f.start();
        }
    }

    public abstract void o();
}
