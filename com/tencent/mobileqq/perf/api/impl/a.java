package com.tencent.mobileqq.perf.api.impl;

import android.util.Log;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eRi\u0010(\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b\u0017\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/perf/api/impl/a;", "", "", "tag", "", "contentHash", "count", "", "b", "c", "", "timestamp", "content", "a", "I", WidgetCacheConstellationData.INTERVAL, "threshold", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mobileqq/perf/api/impl/c;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "logQueue", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/perf/api/impl/d;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "logStatInfo", "e", "lastTimeExceedThreshold", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "logQueueSize", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "g", "Lkotlin/jvm/functions/Function3;", "getOnThresholdExceed", "()Lkotlin/jvm/functions/Function3;", "(Lkotlin/jvm/functions/Function3;)V", "onThresholdExceed", "<init>", "(II)V", h.F, "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int interval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int threshold;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<LogRecord> logQueue = new ConcurrentLinkedQueue<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, d> logStatInfo = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Long> lastTimeExceedThreshold = new ConcurrentHashMap<>(2048);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger logQueueSize = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function3<? super String, ? super Integer, ? super Integer, Unit> onThresholdExceed;

    public a(int i3, int i16) {
        this.interval = i3;
        this.threshold = i16;
    }

    private final void b(String tag, int contentHash, int count) {
        Long l3 = this.lastTimeExceedThreshold.get(tag);
        if (l3 == null || System.currentTimeMillis() - l3.longValue() >= 200) {
            this.lastTimeExceedThreshold.put(tag, Long.valueOf(System.currentTimeMillis()));
            Function3<? super String, ? super Integer, ? super Integer, Unit> function3 = this.onThresholdExceed;
            if (function3 != null) {
                function3.invoke(tag, Integer.valueOf(contentHash), Integer.valueOf(count));
            }
            Log.i("HighFreqLogDetector", "onExceedThreshold: queue:" + this.logQueueSize.get() + " stat:" + this.logStatInfo.size() + " time:" + this.lastTimeExceedThreshold.size());
        }
    }

    private final void c() {
        LogRecord peek;
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (!(!this.logQueue.isEmpty()) || (peek = this.logQueue.peek()) == null || currentTimeMillis - peek.getTimestamp() <= this.interval) {
                return;
            }
            if (this.logQueue.remove(peek)) {
                this.logQueueSize.decrementAndGet();
            }
            d dVar = this.logStatInfo.get(peek.getTag());
            if (dVar != null && dVar.b()) {
                this.logStatInfo.remove(peek.getTag());
                this.lastTimeExceedThreshold.remove(peek.getTag());
            }
        }
    }

    public final void a(long timestamp, String tag, String content) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(content, "content");
        c();
        this.logQueue.add(new LogRecord(timestamp, tag));
        this.logQueueSize.incrementAndGet();
        int hashCode = content.hashCode();
        d dVar = this.logStatInfo.get(tag);
        if (dVar != null) {
            int a16 = dVar.a();
            if (a16 >= this.threshold) {
                b(tag, hashCode, a16);
                return;
            }
            return;
        }
        this.logStatInfo.put(tag, new d(tag));
    }

    public final void d(Function3<? super String, ? super Integer, ? super Integer, Unit> function3) {
        this.onThresholdExceed = function3;
    }
}
