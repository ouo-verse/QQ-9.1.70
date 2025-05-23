package av2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.LongTimingRunnable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.TimingLogicHandler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    LongTimingRunnable f26999a = new LongTimingRunnable();

    /* compiled from: P */
    /* renamed from: av2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0072a {

        /* renamed from: a, reason: collision with root package name */
        private static a f27000a = new a();
    }

    public static a a() {
        return C0072a.f27000a;
    }

    public void b(TimingLogicHandler timingLogicHandler) {
        this.f26999a.i(timingLogicHandler);
    }

    public synchronized void c() {
        if (this.f26999a.g()) {
            return;
        }
        QAdThreadManager.INSTANCE.execIo(this.f26999a);
    }

    public void d(TimingLogicHandler timingLogicHandler) {
        this.f26999a.j(timingLogicHandler);
    }
}
