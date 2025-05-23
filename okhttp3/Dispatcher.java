package okhttp3;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010 \u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000\u00a2\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b$J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b%J\u0016\u0010&\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J)\u0010)\u001a\u00020\u001f\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\u0006\u0010!\u001a\u0002H*H\u0002\u00a2\u0006\u0002\u0010-J\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b.J\u0019\u0010)\u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000\u00a2\u0006\u0002\b.J\b\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00104\u001a\u00020\u0010J\f\u00105\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00106\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lokhttp3/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "()V", "()Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "<set-?>", "Ljava/lang/Runnable;", "idleCallback", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequests", "", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "runningAsyncCalls", "runningSyncCalls", "cancelAll", "", "enqueue", "call", "enqueue$okhttp", "executed", "executed$okhttp", "-deprecated_executorService", "findExistingCallWithHost", "host", "", IXWebBroadcastListener.STAGE_FINISHED, "T", "calls", "Ljava/util/Deque;", "(Ljava/util/Deque;Ljava/lang/Object;)V", "finished$okhttp", "promoteAndExecute", "", "queuedCalls", "", "Lokhttp3/Call;", "queuedCallsCount", "runningCalls", "runningCallsCount", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String host) {
        Iterator<RealCall.AsyncCall> it = this.runningAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (Intrinsics.areEqual(next.getHost(), host)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it5 = this.readyAsyncCalls.iterator();
        while (it5.hasNext()) {
            RealCall.AsyncCall next2 = it5.next();
            if (Intrinsics.areEqual(next2.getHost(), host)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> calls, T call) {
        Runnable runnable;
        synchronized (this) {
            if (calls.remove(call)) {
                runnable = this.idleCallback;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    private final boolean promoteAndExecute() {
        int i3;
        boolean z16;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST NOT hold lock on ");
            sb5.append(this);
            throw new AssertionError(sb5.toString());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                RealCall.AsyncCall asyncCall = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                }
                if (asyncCall.getCallsPerHost().get() < this.maxRequestsPerHost) {
                    it.remove();
                    asyncCall.getCallsPerHost().incrementAndGet();
                    Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.runningAsyncCalls.add(asyncCall);
                }
            }
            if (runningCallsCount() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        int size = arrayList.size();
        for (i3 = 0; i3 < size; i3++) {
            ((RealCall.AsyncCall) arrayList.get(i3)).executeOn(executorService());
        }
        return z16;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))
    @JvmName(name = "-deprecated_executorService")
    @NotNull
    /* renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m2099deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            it.next().getThis$0().cancel();
        }
        Iterator<RealCall.AsyncCall> it5 = this.runningAsyncCalls.iterator();
        while (it5.hasNext()) {
            it5.next().getThis$0().cancel();
        }
        Iterator<RealCall> it6 = this.runningSyncCalls.iterator();
        while (it6.hasNext()) {
            it6.next().cancel();
        }
    }

    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        RealCall.AsyncCall findExistingCallWithHost;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(call);
            if (!call.getThis$0().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(call.getHost())) != null) {
                call.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.runningSyncCalls.add(call);
    }

    @JvmName(name = "executorService")
    @NotNull
    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        Intrinsics.checkNotNull(executorService);
        return executorService;
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, call);
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    @NotNull
    public final synchronized List<Call> queuedCalls() {
        int collectionSizeOrDefault;
        List<Call> unmodifiableList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayDeque, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            arrayList.add(((RealCall.AsyncCall) it.next()).getThis$0());
        }
        unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable\u2026yncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    @NotNull
    public final synchronized List<Call> runningCalls() {
        int collectionSizeOrDefault;
        List plus;
        List<Call> unmodifiableList;
        ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayDeque2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayDeque2.iterator();
        while (it.hasNext()) {
            arrayList.add(((RealCall.AsyncCall) it.next()).getThis$0());
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayDeque, (Iterable) arrayList);
        unmodifiableList = Collections.unmodifiableList(plus);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable\u2026yncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i3) {
        boolean z16 = true;
        if (i3 < 1) {
            z16 = false;
        }
        if (z16) {
            synchronized (this) {
                this.maxRequests = i3;
                Unit unit = Unit.INSTANCE;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i3).toString());
    }

    public final void setMaxRequestsPerHost(int i3) {
        boolean z16 = true;
        if (i3 < 1) {
            z16 = false;
        }
        if (z16) {
            synchronized (this) {
                this.maxRequestsPerHost = i3;
                Unit unit = Unit.INSTANCE;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i3).toString());
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        finished(this.runningSyncCalls, call);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dispatcher(@NotNull ExecutorService executorService) {
        this();
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }
}
