package com.tencent.gdtad.basics.motivevideo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtRewardTimeCounter {

    /* renamed from: b, reason: collision with root package name */
    private m f108890b;

    /* renamed from: c, reason: collision with root package name */
    private long f108891c;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f108889a = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private long f108892d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f108893e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f108894f = false;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f108895g = new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.GdtRewardTimeCounter.1
        @Override // java.lang.Runnable
        public void run() {
            long j3 = GdtRewardTimeCounter.this.f108891c - GdtRewardTimeCounter.this.f108892d;
            if (j3 < GdtRewardTimeCounter.this.f108893e) {
                j3 = 0;
            }
            if (GdtRewardTimeCounter.this.f108890b != null) {
                GdtRewardTimeCounter.this.f108890b.a(j3);
            }
            if (j3 > 0 && GdtRewardTimeCounter.this.f108889a != null) {
                GdtRewardTimeCounter.this.f108892d += GdtRewardTimeCounter.this.f108893e;
                GdtRewardTimeCounter.this.f108889a.postDelayed(this, GdtRewardTimeCounter.this.f108893e);
            }
        }
    };

    public GdtRewardTimeCounter(long j3, @NotNull m mVar) {
        if (j3 <= 0) {
            QLog.e("GdtRewardTimeCounter", 1, "GdtRewardTimeCounter fail: totalRewardTimeMilSec =" + j3);
            return;
        }
        this.f108891c = j3;
        this.f108890b = mVar;
    }

    public void g(long j3) {
        this.f108893e = j3;
    }

    public void h(boolean z16) {
        this.f108894f = z16;
    }

    public void i() {
        if (this.f108889a != null && this.f108894f) {
            this.f108889a.removeCallbacks(this.f108895g);
            long j3 = this.f108891c - this.f108892d;
            QLog.d("GdtRewardTimeCounter", 1, "startCount leftMilSec:" + j3);
            if (j3 > 0) {
                this.f108889a.post(this.f108895g);
                return;
            }
            m mVar = this.f108890b;
            if (mVar != null) {
                mVar.a(0L);
            }
            j();
            return;
        }
        QLog.e("GdtRewardTimeCounter", 1, "startCount fail: mCountHandler is null");
    }

    public void j() {
        if (this.f108889a == null) {
            return;
        }
        QLog.d("GdtRewardTimeCounter", 1, "stopCount");
        this.f108889a.removeCallbacks(this.f108895g);
    }
}
