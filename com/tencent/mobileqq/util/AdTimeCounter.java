package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/util/AdTimeCounter;", "", "", "g", "", "currentTimeMs", tl.h.F, "i", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mCountHandler", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/util/d;", "b", "Ljava/lang/ref/WeakReference;", "mTimeCallbackRef", "c", "J", "mTotalTimeMs", "d", "mCurrentTimeMs", "e", "mCallbackFreq", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "mCountRunnable", "totalTimeMs", "adTimeCallbackRef", "freq", "<init>", "(JLjava/lang/ref/WeakReference;J)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AdTimeCounter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mCountHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<d> mTimeCallbackRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mTotalTimeMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mCurrentTimeMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mCallbackFreq;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable mCountRunnable;

    public AdTimeCounter(long j3, @NotNull WeakReference<d> adTimeCallbackRef, long j16) {
        Intrinsics.checkNotNullParameter(adTimeCallbackRef, "adTimeCallbackRef");
        this.mCountHandler = new Handler(Looper.getMainLooper());
        this.mTimeCallbackRef = adTimeCallbackRef;
        this.mTotalTimeMs = j3;
        this.mCallbackFreq = j16;
        this.mCountRunnable = new Runnable() { // from class: com.tencent.mobileqq.util.AdTimeCounter$mCountRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                long j17;
                long j18;
                long j19;
                WeakReference weakReference;
                WeakReference weakReference2;
                long j26;
                long j27;
                Handler handler;
                long j28;
                long j29;
                j17 = AdTimeCounter.this.mTotalTimeMs;
                j18 = AdTimeCounter.this.mCurrentTimeMs;
                long j36 = j17 - j18;
                j19 = AdTimeCounter.this.mCallbackFreq;
                if (j36 < j19) {
                    j36 = 0;
                }
                weakReference = AdTimeCounter.this.mTimeCallbackRef;
                d dVar = (d) weakReference.get();
                if (dVar != null) {
                    j29 = AdTimeCounter.this.mCurrentTimeMs;
                    dVar.a(j29);
                }
                weakReference2 = AdTimeCounter.this.mTimeCallbackRef;
                d dVar2 = (d) weakReference2.get();
                if (dVar2 != null) {
                    dVar2.b(j36);
                }
                if (j36 <= 0) {
                    return;
                }
                AdTimeCounter adTimeCounter = AdTimeCounter.this;
                j26 = adTimeCounter.mCurrentTimeMs;
                j27 = AdTimeCounter.this.mCallbackFreq;
                adTimeCounter.mCurrentTimeMs = j26 + j27;
                handler = AdTimeCounter.this.mCountHandler;
                j28 = AdTimeCounter.this.mCallbackFreq;
                handler.postDelayed(this, j28);
            }
        };
    }

    public final void g() {
        if (this.mTotalTimeMs <= 0) {
            QLog.e("GdtRewardTimeCounter", 1, "AdTimeCounter fail: totalTimeMs <= 0:" + this.mTotalTimeMs);
            return;
        }
        this.mCountHandler.removeCallbacks(this.mCountRunnable);
        long j3 = this.mTotalTimeMs - this.mCurrentTimeMs;
        QLog.d("GdtRewardTimeCounter", 1, "startCount leftMilSec:" + j3);
        if (j3 > 0) {
            this.mCountHandler.post(this.mCountRunnable);
            return;
        }
        d dVar = this.mTimeCallbackRef.get();
        if (dVar != null) {
            dVar.b(0L);
        }
        i();
    }

    public final void h(long currentTimeMs) {
        this.mCurrentTimeMs = currentTimeMs;
        g();
    }

    public final void i() {
        QLog.d("GdtRewardTimeCounter", 2, "stopCount");
        this.mCountHandler.removeCallbacks(this.mCountRunnable);
    }

    public /* synthetic */ AdTimeCounter(long j3, WeakReference weakReference, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, weakReference, (i3 & 4) != 0 ? 1000L : j16);
    }
}
