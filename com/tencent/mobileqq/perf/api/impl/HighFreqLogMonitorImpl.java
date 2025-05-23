package com.tencent.mobileqq.perf.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.perf.api.IHighFreqLogMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl;", "Lcom/tencent/mobileqq/perf/api/IHighFreqLogMonitor;", "", "getCurrentStack", "", "printStackForMainThread", "printStackForAllThread", "printHighFreqLogStack", "", "start", "stop", "Lcom/tencent/mobileqq/perf/api/impl/a;", "detector", "Lcom/tencent/mobileqq/perf/api/impl/a;", "Z", "com/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$d", "logCallback", "Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$d;", "isMonitoring", "Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$c;", "getThreadLocalData", "()Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$c;", "threadLocalData", "<init>", "()V", "Companion", "b", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class HighFreqLogMonitorImpl implements IHighFreqLogMonitor {
    private static final String STACK_TRACE_SEPARATOR = "-#-";
    private static final Set<String> whitelistTags;
    private final com.tencent.mobileqq.perf.api.impl.a detector;
    private boolean isMonitoring;
    private final d logCallback;
    private boolean printHighFreqLogStack;
    private boolean printStackForAllThread;
    private boolean printStackForMainThread;
    private static final ThreadLocal<c> threadLocalStringBuilder = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$a", "Ljava/lang/ThreadLocal;", "Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$c;", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends ThreadLocal<c> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c initialValue() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$c;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "a", "Ljava/lang/StringBuilder;", "()Ljava/lang/StringBuilder;", "stringBuilder", "", "b", "Z", "()Z", "c", "(Z)V", "isHandlingLog", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final StringBuilder stringBuilder = new StringBuilder();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isHandlingLog;

        /* renamed from: a, reason: from getter */
        public final StringBuilder getStringBuilder() {
            return this.stringBuilder;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsHandlingLog() {
            return this.isHandlingLog;
        }

        public final void c(boolean z16) {
            this.isHandlingLog = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/perf/api/impl/HighFreqLogMonitorImpl$d", "Lcom/tencent/qphone/base/util/QLog$IAddLogCallback;", "", "logLevel", "", "tag", "msg", "onAddLog", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements QLog.IAddLogCallback {
        d() {
        }

        @Override // com.tencent.qphone.base.util.QLog.IAddLogCallback
        public String onAddLog(int logLevel, String tag, String msg2) {
            String str;
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (HighFreqLogMonitorImpl.whitelistTags.contains(tag) || HighFreqLogMonitorImpl.this.getThreadLocalData().getIsHandlingLog()) {
                return msg2;
            }
            HighFreqLogMonitorImpl.this.getThreadLocalData().c(true);
            try {
                if (HighFreqLogMonitorImpl.this.printHighFreqLogStack) {
                    HighFreqLogMonitorImpl.this.detector.a(System.currentTimeMillis(), tag, msg2);
                }
                if (!HighFreqLogMonitorImpl.this.printStackForMainThread || Looper.getMainLooper() != Looper.myLooper()) {
                    if (HighFreqLogMonitorImpl.this.printStackForAllThread) {
                        str = msg2 + " <hash>" + msg2.hashCode() + " <stack>" + HighFreqLogMonitorImpl.this.getCurrentStack();
                    } else {
                        str = msg2 + " <hash>" + msg2.hashCode();
                    }
                } else {
                    str = msg2 + " <hash>" + msg2.hashCode() + " <stack>" + HighFreqLogMonitorImpl.this.getCurrentStack();
                }
                return str;
            } finally {
                HighFreqLogMonitorImpl.this.getThreadLocalData().c(false);
            }
        }
    }

    static {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("MSF.D.Proxy", "mqq", "NTKernel");
        whitelistTags = mutableSetOf;
    }

    public HighFreqLogMonitorImpl() {
        com.tencent.mobileqq.perf.api.impl.a aVar = new com.tencent.mobileqq.perf.api.impl.a(2000, 50);
        this.detector = aVar;
        this.printStackForAllThread = true;
        this.printHighFreqLogStack = true;
        this.logCallback = new d();
        aVar.d(new Function3<String, Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.perf.api.impl.HighFreqLogMonitorImpl.1
            public final void invoke(String tag, int i3, int i16) {
                Intrinsics.checkNotNullParameter(tag, "tag");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, Integer num2) {
                invoke(str, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentStack() {
        int coerceAtMost;
        long nanoTime = System.nanoTime();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        long nanoTime2 = System.nanoTime();
        StringBuilder stringBuilder = getThreadLocalData().getStringBuilder();
        stringBuilder.setLength(0);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(stackTrace.length, 16);
        for (int i3 = 7; i3 < coerceAtMost; i3++) {
            stringBuilder.append(stackTrace[i3].toString());
            stringBuilder.append(STACK_TRACE_SEPARATOR);
        }
        stringBuilder.append("<time>time1: " + (nanoTime2 - nanoTime) + " ns, time2: " + (System.nanoTime() - nanoTime2) + " ns total: " + (System.nanoTime() - nanoTime) + " ns");
        String sb5 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "sb.toString()");
        return sb5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c getThreadLocalData() {
        c cVar = threadLocalStringBuilder.get();
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Override // com.tencent.mobileqq.perf.api.IHighFreqLogMonitor
    public void start(boolean printStackForMainThread, boolean printStackForAllThread, boolean printHighFreqLogStack) {
        this.printStackForMainThread = printStackForMainThread;
        this.printStackForAllThread = printStackForAllThread;
        this.printHighFreqLogStack = printHighFreqLogStack;
        if (this.isMonitoring) {
            return;
        }
        this.isMonitoring = true;
        QLog.setAddLogCallback(this.logCallback);
    }

    @Override // com.tencent.mobileqq.perf.api.IHighFreqLogMonitor
    public void stop() {
        if (this.isMonitoring) {
            this.isMonitoring = false;
            QLog.removeAddLogCallback(this.logCallback);
        }
    }
}
