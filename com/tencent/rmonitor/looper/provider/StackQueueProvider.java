package com.tencent.rmonitor.looper.provider;

import android.os.Handler;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.looper.MonitorInfo;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J%\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0004H\u0016R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/rmonitor/looper/provider/StackQueueProvider;", "Lcom/tencent/rmonitor/looper/provider/d;", "Ld14/c;", "stackQueue", "", "E", "", "Ld14/b;", "stackFrameQueue", "Lorg/json/JSONObject;", "B", "Ljava/lang/StringBuffer;", "buffer", "", "Ljava/lang/StackTraceElement;", "stackTrace", "", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/StringBuffer;[Ljava/lang/StackTraceElement;)Ljava/lang/String;", "Lcom/tencent/rmonitor/looper/c;", "monitorInfo", "p", "v", "(Lcom/tencent/rmonitor/looper/c;[Ljava/lang/StackTraceElement;)V", "", "isOverThreshold", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "", "I", "Ljava/util/concurrent/ConcurrentHashMap;", "stackQueueMap", "Ljava/util/concurrent/atomic/AtomicInteger;", "J", "Ljava/util/concurrent/atomic/AtomicInteger;", "tryRecycleStackQueueCount", "K", "realRecycleStackQueueCount", "<init>", "()V", "L", "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class StackQueueProvider extends d {

    /* renamed from: I, reason: from kotlin metadata */
    private final ConcurrentHashMap<Long, d14.c> stackQueueMap = new ConcurrentHashMap<>();

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicInteger tryRecycleStackQueueCount = new AtomicInteger();

    /* renamed from: K, reason: from kotlin metadata */
    private final AtomicInteger realRecycleStackQueueCount = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject B(List<d14.b> stackFrameQueue) {
        JSONArray jSONArray = new JSONArray();
        StringBuffer stringBuffer = new StringBuffer(2048);
        int size = stackFrameQueue.size();
        for (int i3 = 0; i3 < size; i3++) {
            d14.b bVar = stackFrameQueue.get(i3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "normal");
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, k());
            jSONObject.put(CrashHianalyticsData.THREAD_ID, j());
            jSONObject.put("index", bVar.getFrameIndex());
            jSONObject.put("repeat_count", bVar.getFrameCount());
            jSONObject.put("timestamp", bVar.getStartTime());
            jSONObject.put("end_time", bVar.getEndTime());
            jSONObject.put("call_stack", C(stringBuffer, bVar.getStack()));
            jSONArray.mo162put(jSONObject);
        }
        if (jSONArray.length() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("stacks", jSONArray);
            return jSONObject2;
        }
        return null;
    }

    private final String C(StringBuffer buffer, StackTraceElement[] stackTrace) {
        buffer.delete(0, buffer.length());
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                buffer.append(stackTraceElement.toString());
                buffer.append("\n");
            }
        }
        String stringBuffer = buffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer, "buffer.toString()");
        return stringBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(d14.c stackQueue) {
        d14.c.INSTANCE.b(stackQueue);
        this.realRecycleStackQueueCount.incrementAndGet();
        D();
        e();
    }

    public final void D() {
        Iterator it;
        d14.c remove;
        if (this.stackQueueMap.size() > 20) {
            Enumeration<Long> keys = this.stackQueueMap.keys();
            Intrinsics.checkExpressionValueIsNotNull(keys, "stackQueueMap.keys()");
            it = CollectionsKt__IteratorsJVMKt.iterator(keys);
            while (it.hasNext()) {
                Long l3 = (Long) it.next();
                if (l3 != null && (remove = this.stackQueueMap.remove(l3)) != null) {
                    this.tryRecycleStackQueueCount.incrementAndGet();
                    d14.c.INSTANCE.b(remove);
                    this.realRecycleStackQueueCount.incrementAndGet();
                }
            }
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void e() {
        int size = this.stackQueueMap.size();
        int i3 = this.tryRecycleStackQueueCount.get() - this.realRecycleStackQueueCount.get();
        if (size <= 20 && i3 <= 100) {
            if (size < 10 && i3 < 50) {
                m(true);
                return;
            }
            return;
        }
        m(false);
    }

    @Override // com.tencent.rmonitor.looper.provider.d
    public void p(@NotNull MonitorInfo monitorInfo) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
    }

    @Override // com.tencent.rmonitor.looper.provider.d
    public void q(@NotNull final MonitorInfo monitorInfo, boolean isOverThreshold) {
        final d14.c remove;
        Handler stackThreadHandler;
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        boolean isDetectedLongLag = monitorInfo.getIsDetectedLongLag();
        if (isDetectedLongLag) {
            remove = this.stackQueueMap.get(Long.valueOf(monitorInfo.getLastStackRequestTime()));
        } else {
            remove = this.stackQueueMap.remove(Long.valueOf(monitorInfo.getLastStackRequestTime()));
        }
        if (remove != null) {
            Intrinsics.checkExpressionValueIsNotNull(remove, "(if (isDetectedLongLag) \u2026ime)\n        }) ?: return");
            if (isOverThreshold) {
                remove.e(new Function1<List<d14.b>, Unit>() { // from class: com.tencent.rmonitor.looper.provider.StackQueueProvider$endTrace$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<d14.b> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<d14.b> it) {
                        JSONObject B;
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        try {
                            MonitorInfo monitorInfo2 = monitorInfo;
                            B = StackQueueProvider.this.B(it);
                            monitorInfo2.u(B);
                        } catch (Throwable unused) {
                            monitorInfo.u(null);
                        }
                    }
                });
            }
            if (!isDetectedLongLag && (stackThreadHandler = getStackThreadHandler()) != null) {
                this.tryRecycleStackQueueCount.incrementAndGet();
                stackThreadHandler.post(new Runnable() { // from class: com.tencent.rmonitor.looper.provider.StackQueueProvider$endTrace$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        StackQueueProvider.this.E(remove);
                    }
                });
            }
            e();
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.d
    public void v(@NotNull MonitorInfo monitorInfo, @NotNull StackTraceElement[] stackTrace) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        Intrinsics.checkParameterIsNotNull(stackTrace, "stackTrace");
        d14.c cVar = this.stackQueueMap.get(Long.valueOf(monitorInfo.getLastStackRequestTime()));
        if (cVar == null && u(monitorInfo)) {
            cVar = d14.c.INSTANCE.a();
            if (cVar != null) {
                this.stackQueueMap.put(Long.valueOf(monitorInfo.getLastStackRequestTime()), cVar);
            }
        } else if (cVar == null) {
            Logger.f365497g.d("RMonitor_looper_StackProvider", "deal msg not latest msg on trace, deal: " + monitorInfo.getLastStackRequestTime());
        }
        if (cVar != null) {
            cVar.c(stackTrace);
        }
    }
}
