package com.tencent.kuikly.core.render.android.performace.frame;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.kuikly.core.render.android.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J0\u0010\n\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J&\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004R8\u0010\u0019\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R8\u0010\u001b\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R8\u0010\u001c\u001a&\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004 \u0017*\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/frame/b;", "Lcom/tencent/kuikly/core/render/android/f;", "Lcom/tencent/kuikly/core/render/android/context/a;", "", "", LinkReportConstant$GlobalKey.EVENTS, "startTime", "endTime", "", "ensureThreadSafe", "i", h.F, "g", "", "", "e", "c", "b", "d", "a", "frameStartTimeNanos", "frameEndTimeNanos", "k", "kotlin.jvm.PlatformType", "Ljava/util/List;", "updateViewTaskEnqueuedEvents", "updateViewTaskFinishEvents", "transitionToIdleEvents", "transitionToBusyEvents", "Z", "isLastFrameEndOfIdle", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b implements f, com.tencent.kuikly.core.render.android.context.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<Long> updateViewTaskEnqueuedEvents = Collections.synchronizedList(new ArrayList());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<Long> updateViewTaskFinishEvents = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Long> transitionToIdleEvents = Collections.synchronizedList(new ArrayList());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Long> transitionToBusyEvents = Collections.synchronizedList(new ArrayList());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLastFrameEndOfIdle = true;

    private final void e(List<Long> events, long endTime, boolean ensureThreadSafe) {
        if (ensureThreadSafe) {
            synchronized (events) {
                Iterator<Long> it = events.iterator();
                while (it.hasNext()) {
                    if (it.next().longValue() < endTime) {
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        Iterator<Long> it5 = events.iterator();
        while (it5.hasNext()) {
            if (it5.next().longValue() < endTime) {
                it5.remove();
            }
        }
    }

    static /* synthetic */ void f(b bVar, List list, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        bVar.e(list, j3, z16);
    }

    private final boolean g(long startTime, long endTime) {
        List<Long> transitionToIdleEvents = this.transitionToIdleEvents;
        Intrinsics.checkNotNullExpressionValue(transitionToIdleEvents, "transitionToIdleEvents");
        long h16 = h(transitionToIdleEvents, startTime, endTime);
        List<Long> transitionToBusyEvents = this.transitionToBusyEvents;
        Intrinsics.checkNotNullExpressionValue(transitionToBusyEvents, "transitionToBusyEvents");
        long h17 = h(transitionToBusyEvents, startTime, endTime);
        if (h16 == -1 && h17 == -1) {
            return this.isLastFrameEndOfIdle;
        }
        if (h16 > h17) {
            return true;
        }
        return false;
    }

    private final long h(List<Long> events, long startTime, long endTime) {
        synchronized (events) {
            Iterator<T> it = events.iterator();
            long j3 = -1;
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                if (startTime <= longValue && endTime > longValue) {
                    j3 = longValue;
                } else if (longValue >= endTime) {
                    return j3;
                }
            }
            Unit unit = Unit.INSTANCE;
            return j3;
        }
    }

    private final boolean i(List<Long> events, long startTime, long endTime, boolean ensureThreadSafe) {
        if (ensureThreadSafe) {
            synchronized (events) {
                Iterator<T> it = events.iterator();
                while (it.hasNext()) {
                    long longValue = ((Number) it.next()).longValue();
                    if (startTime <= longValue && endTime > longValue) {
                        return true;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return false;
            }
        }
        Iterator<T> it5 = events.iterator();
        while (it5.hasNext()) {
            long longValue2 = ((Number) it5.next()).longValue();
            if (startTime <= longValue2 && endTime > longValue2) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean j(b bVar, List list, long j3, long j16, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return bVar.i(list, j3, j16, z16);
    }

    @Override // com.tencent.kuikly.core.render.android.context.a
    public void a() {
        this.transitionToBusyEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.tencent.kuikly.core.render.android.f
    public void b() {
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        this.updateViewTaskFinishEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.tencent.kuikly.core.render.android.f
    public void c() {
        this.updateViewTaskEnqueuedEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.tencent.kuikly.core.render.android.context.a
    public void d() {
        this.transitionToIdleEvents.add(Long.valueOf(System.nanoTime()));
    }

    public final boolean k(long frameStartTimeNanos, long frameEndTimeNanos) {
        boolean z16;
        com.tencent.kuikly.core.render.android.css.ktx.b.l();
        boolean i3 = i(this.updateViewTaskFinishEvents, frameStartTimeNanos, frameEndTimeNanos, false);
        boolean g16 = g(frameStartTimeNanos, frameEndTimeNanos);
        List<Long> updateViewTaskEnqueuedEvents = this.updateViewTaskEnqueuedEvents;
        Intrinsics.checkNotNullExpressionValue(updateViewTaskEnqueuedEvents, "updateViewTaskEnqueuedEvents");
        boolean z17 = !j(this, updateViewTaskEnqueuedEvents, frameStartTimeNanos, frameEndTimeNanos, false, 8, null);
        if (!i3 && (!g16 || !z17)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isLastFrameEndOfIdle = g16;
        e(this.updateViewTaskFinishEvents, frameEndTimeNanos, false);
        List<Long> updateViewTaskEnqueuedEvents2 = this.updateViewTaskEnqueuedEvents;
        Intrinsics.checkNotNullExpressionValue(updateViewTaskEnqueuedEvents2, "updateViewTaskEnqueuedEvents");
        f(this, updateViewTaskEnqueuedEvents2, frameEndTimeNanos, false, 4, null);
        List<Long> transitionToIdleEvents = this.transitionToIdleEvents;
        Intrinsics.checkNotNullExpressionValue(transitionToIdleEvents, "transitionToIdleEvents");
        f(this, transitionToIdleEvents, frameEndTimeNanos, false, 4, null);
        List<Long> transitionToBusyEvents = this.transitionToBusyEvents;
        Intrinsics.checkNotNullExpressionValue(transitionToBusyEvents, "transitionToBusyEvents");
        f(this, transitionToBusyEvents, frameEndTimeNanos, false, 4, null);
        return z16;
    }
}
