package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import uk0.e;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0005RP\u0010\u0010\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000e0\fj\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000e`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentEventDispatcher;", "", "", "type", "eventData", "", "onEvent", "Luk0/e;", "listener", "addListener", "removeListener", "removeAllListener", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "eventListenerMap", "Ljava/util/HashMap;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentEventDispatcher {
    private final HashMap<String, ArrayList<e>> eventListenerMap = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public final void addListener(@NotNull String type, @NotNull e listener) {
        ArrayList<e> arrayListOf;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.eventListenerMap.containsKey(type)) {
                ArrayList<e> arrayList = this.eventListenerMap.get(type);
                if (arrayList != null) {
                    arrayList.add(listener);
                }
            } else {
                HashMap<String, ArrayList<e>> hashMap = this.eventListenerMap;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(listener);
                hashMap.put(type, arrayListOf);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @NativeMethodProxy
    public final void onEvent(@NotNull String type, @NotNull String eventData) {
        List list;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ArrayList<e> arrayList = this.eventListenerMap.get(type);
            if (arrayList != null) {
                list = CollectionsKt___CollectionsKt.toList(arrayList);
            } else {
                list = null;
            }
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).onEvent(type, eventData);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeAllListener() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.eventListenerMap.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeListener(@NotNull String type, @NotNull e listener) {
        e eVar;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ArrayList<e> arrayList = this.eventListenerMap.get(type);
            if (arrayList != null) {
                Intrinsics.checkNotNullExpressionValue(arrayList, "eventListenerMap[type] ?: return");
                Iterator<e> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        eVar = null;
                        break;
                    } else {
                        eVar = it.next();
                        if (Intrinsics.areEqual(eVar, listener)) {
                            break;
                        }
                    }
                }
                if (eVar != null) {
                    arrayList.remove(eVar);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeListener(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.eventListenerMap.remove(type);
        } finally {
            reentrantLock.unlock();
        }
    }
}
