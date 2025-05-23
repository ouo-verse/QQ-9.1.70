package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer;

import android.os.SystemClock;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.TimingLogicHandler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TimingLogicHandler {

    /* renamed from: b, reason: collision with root package name */
    private long f303671b;

    /* renamed from: c, reason: collision with root package name */
    protected long f303672c;

    /* renamed from: f, reason: collision with root package name */
    private a f303675f;

    /* renamed from: a, reason: collision with root package name */
    protected long f303670a = TTL.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private long f303673d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f303674e = 0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface TimingState {
        public static final int PAUSE_TIMING = 0;
        public static final int START_TIMING = 1;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f303675f.a();
    }

    public synchronized long b() {
        return this.f303670a - this.f303672c;
    }

    public long c() {
        return this.f303673d;
    }

    public synchronized void d() {
        if (this.f303674e == 0) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f303673d;
        long j16 = this.f303671b;
        this.f303673d = j3 + (elapsedRealtime - j16);
        this.f303672c += elapsedRealtime - j16;
        n.a("[QAd]TimingLogicHandler", "handleTimeUpLogic, mTimeCount = " + this.f303672c);
        this.f303671b = elapsedRealtime;
        if (this.f303672c >= this.f303670a) {
            n.a("[QAd]TimingLogicHandler", "time up, mTimeInterval = " + this.f303670a + ",mTimeStart = " + this.f303671b);
            QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: av2.b
                @Override // java.lang.Runnable
                public final void run() {
                    TimingLogicHandler.this.e();
                }
            });
        }
    }

    public synchronized void f() {
        this.f303674e = 0;
    }

    public synchronized void g() {
        this.f303672c = 0L;
    }

    public synchronized void h(long j3) {
        this.f303672c = this.f303670a - j3;
    }

    public synchronized void i(long j3) {
        this.f303670a = j3;
    }

    public void j(a aVar) {
        this.f303675f = aVar;
    }

    public synchronized void k() {
        this.f303674e = 1;
        this.f303671b = SystemClock.elapsedRealtime();
    }
}
