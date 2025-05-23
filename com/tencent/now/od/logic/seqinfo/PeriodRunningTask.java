package com.tencent.now.od.logic.seqinfo;

import android.os.Handler;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/now/od/logic/seqinfo/PeriodRunningTask;", "Ljava/lang/Runnable;", "", WidgetCacheConstellationData.INTERVAL, "", "g", "e", TencentLocation.RUN_MODE, "f", "d", "J", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class PeriodRunningTask implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long interval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(long interval) {
        this.interval = interval;
    }

    @Override // java.lang.Runnable
    public void run() {
        f();
        this.handler.removeCallbacks(this);
        this.handler.postDelayed(this, this.interval);
    }
}
