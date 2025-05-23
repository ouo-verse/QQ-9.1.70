package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LongTimingRunnable extends BaseTimerRunnable {

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<TimingLogicHandler> f303669f = new CopyOnWriteArrayList<>();

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable
    protected void f() {
        Iterator<TimingLogicHandler> it = this.f303669f.iterator();
        while (it.hasNext()) {
            TimingLogicHandler next = it.next();
            if (next != null) {
                next.d();
            }
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable
    protected int h() {
        return 1000;
    }

    public void i(TimingLogicHandler timingLogicHandler) {
        this.f303669f.add(timingLogicHandler);
    }

    public void j(TimingLogicHandler timingLogicHandler) {
        this.f303669f.remove(timingLogicHandler);
        if (this.f303669f.size() == 0) {
            stop();
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.BaseTimerRunnable
    protected void e() {
    }
}
