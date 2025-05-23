package nc3;

import android.os.CountDownTimer;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lnc3/b;", "", "", "c", "", "e", h.F, "d", "f", "Lnc3/b$a;", "beatConsumer", "i", "", "g", "j", "Landroid/os/CountDownTimer;", "b", "Landroid/os/CountDownTimer;", "mHeartBeatTimer", "Lnc3/b$a;", "mBeatConsumer", "", "J", "mLastTickTime", "mNextTickInterval", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mTicking", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static CountDownTimer mHeartBeatTimer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static a mBeatConsumer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mLastTickTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mNextTickInterval;

    /* renamed from: a, reason: collision with root package name */
    public static final b f419923a = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean mTicking = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lnc3/b$a;", "", "", "a", "", "duration", "c", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static abstract class a {
        public abstract void a();

        public abstract void b(int duration);

        public abstract void c(int duration);
    }

    b() {
    }

    private final int c() {
        long serverTimeMillis = mTicking.get() ? (NetConnInfoCenter.getServerTimeMillis() - mLastTickTime) / 1000 : 0L;
        QLog.i("HeartBeatGenerator_", 1, "getCurrentDuration duration:" + serverTimeMillis);
        return (int) serverTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        QLog.i("HeartBeatGenerator_", 4, "handleTick mLastTickTime:" + mLastTickTime + ", mNextTickInterval:" + mNextTickInterval + ", current:" + serverTimeMillis);
        long j3 = mLastTickTime;
        if (serverTimeMillis - j3 < mNextTickInterval) {
            return;
        }
        long j16 = (serverTimeMillis - j3) / 1000;
        QLog.i("HeartBeatGenerator_", 1, "handleTick  duration:" + j16);
        h();
        a aVar = mBeatConsumer;
        if (aVar != null) {
            aVar.c((int) j16);
        }
    }

    private final void e() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        mLastTickTime = serverTimeMillis;
        mNextTickInterval = 150000L;
        QLog.i("HeartBeatGenerator_", 1, "initTickParams  mLastTickTime:" + serverTimeMillis + ", mNextTickInterval:150000");
    }

    private final void f() {
        if (mHeartBeatTimer != null) {
            return;
        }
        mHeartBeatTimer = new CountDownTimerC10841b();
    }

    private final void h() {
        mLastTickTime = NetConnInfoCenter.getServerTimeMillis();
        long nextInt = RandomKt.Random(r0).nextInt(150, 210) * 1000;
        mNextTickInterval = nextInt;
        QLog.i("HeartBeatGenerator_", 1, "refreshTickParams  mLastTickTime:" + mLastTickTime + ", mNextTickInterval:" + nextInt);
    }

    public final boolean g() {
        return mTicking.get();
    }

    public final void i(a beatConsumer) {
        Intrinsics.checkNotNullParameter(beatConsumer, "beatConsumer");
        j();
        e();
        mTicking.set(true);
        f();
        CountDownTimer countDownTimer = mHeartBeatTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
        mBeatConsumer = beatConsumer;
        if (beatConsumer != null) {
            beatConsumer.a();
        }
    }

    public final void j() {
        mTicking.set(false);
        CountDownTimer countDownTimer = mHeartBeatTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        mHeartBeatTimer = null;
        a aVar = mBeatConsumer;
        if (aVar != null) {
            aVar.b(c());
        }
        mBeatConsumer = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"nc3/b$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nc3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class CountDownTimerC10841b extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            if (b.mTicking.get()) {
                b.f419923a.d();
            }
        }

        CountDownTimerC10841b() {
            super(Long.MAX_VALUE, 5000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }
    }
}
