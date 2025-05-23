package com.tencent.zplan.zplantracing;

import androidx.annotation.Keep;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/zplan/zplantracing/ZPlanSpanFactory;", "", "", "enable", "", "setSpanEnable", "Lcom/tencent/zplan/zplantracing/a;", "processor", "registerZPlanSpanEndProcessor", "", "getRegisterProcessorSize", "", "name", "Lcom/tencent/zplan/zplantracing/b;", "startRootSpan", HippyNestedScrollComponent.PRIORITY_PARENT, "startSpan", "Lcom/tencent/zplan/zplantracing/c;", "parentContext", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "spanData", "handleSpanData", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "", "processors", "Ljava/util/List;", "spanEnable", "Z", "<init>", "()V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanSpanFactory {

    @NotNull
    public static final ZPlanSpanFactory INSTANCE = new ZPlanSpanFactory();
    private static final ReentrantLock lock = new ReentrantLock();
    private static final List<a> processors = new ArrayList();
    private static boolean spanEnable = true;

    ZPlanSpanFactory() {
    }

    public final int getRegisterProcessorSize() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            return processors.size();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void handleSpanData(@NotNull ZPlanSpanData spanData) {
        List mutableList;
        Intrinsics.checkNotNullParameter(spanData, "spanData");
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) processors);
            reentrantLock.unlock();
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).handleSpanData(spanData);
            }
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public final void registerZPlanSpanEndProcessor(@NotNull a processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            List<a> list = processors;
            if (!list.contains(processor)) {
                list.add(processor);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setSpanEnable(boolean enable) {
        spanEnable = enable;
    }

    @Nullable
    public final b startRootSpan(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!spanEnable) {
            return null;
        }
        return startSpan(name, (b) null);
    }

    @Nullable
    public final b startSpan(@NotNull String name, @Nullable b parent) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!spanEnable) {
            return null;
        }
        b bVar = new b(this, name, parent != null ? parent.c() : null);
        bVar.d();
        return bVar;
    }

    @Nullable
    public final b startSpan(@NotNull String name, @Nullable c parentContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!spanEnable || parentContext == null) {
            return null;
        }
        b bVar = new b(this, name, parentContext);
        bVar.d();
        return bVar;
    }
}
