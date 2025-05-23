package com.tencent.qqnt.bus.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zv3.b;
import zv3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J(\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0014\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J \u0010\u0017\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J \u0010\u001a\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100RS\u00108\u001a:\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050302j\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000503`48BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00107RG\u0010;\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\u0012\u0004\u0012\u00020\u001502j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u000b\u0012\u0004\u0012\u00020\u0015`48BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u00107\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/bus/api/impl/BusManagerImpl;", "Lcom/tencent/qqnt/bus/api/IBusManager;", "Lzv3/a;", "event", "", "Lzv3/c;", "observers", "", "dispatchEvent", "", "name", "Ljava/lang/Class;", "", "printLog", "Lkotlin/Function0;", "block", "tryCatchExp", "", "start", "logWithLimit", "checkAndRunOnWorkThread", "Lzv3/b;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "configEventStrategy", "observer", "registerEvent", "unRegisterEvent", "clearEventObservers", "clearAndStop", "reInit", "sendEvent", "", "lastPrintTime", "I", "lastPrintEvent", "Ljava/lang/Class;", "lastPrintT", "J", "Lcom/tencent/qqnt/bus/helper/a;", "monitor", "Lcom/tencent/qqnt/bus/helper/a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enableAcceptEvent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/os/Handler;", "workHandler$delegate", "Lkotlin/Lazy;", "getWorkHandler", "()Landroid/os/Handler;", "workHandler", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mapEventToObservers$delegate", "getMapEventToObservers", "()Ljava/util/HashMap;", "mapEventToObservers", "mapEventToStrategy$delegate", "getMapEventToStrategy", "mapEventToStrategy", "<init>", "()V", "Companion", "a", "bus_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BusManagerImpl implements IBusManager {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<com.tencent.qqnt.bus.strategy.a> DEFAULT_STRATEGY$delegate;

    @NotNull
    private static final String TAG = "BusManagerImpl";

    @NotNull
    private final AtomicBoolean enableAcceptEvent;

    @Nullable
    private Class<zv3.a> lastPrintEvent;
    private long lastPrintT;
    private int lastPrintTime;

    /* renamed from: mapEventToObservers$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mapEventToObservers;

    /* renamed from: mapEventToStrategy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mapEventToStrategy;

    @NotNull
    private final com.tencent.qqnt.bus.helper.a monitor;

    /* renamed from: workHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy workHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/bus/api/impl/BusManagerImpl$a;", "", "Lcom/tencent/qqnt/bus/strategy/a;", "DEFAULT_STRATEGY$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/qqnt/bus/strategy/a;", "DEFAULT_STRATEGY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "bus_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.bus.api.impl.BusManagerImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.tencent.qqnt.bus.strategy.a b() {
            return (com.tencent.qqnt.bus.strategy.a) BusManagerImpl.DEFAULT_STRATEGY$delegate.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<com.tencent.qqnt.bus.strategy.a> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39696);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BusManagerImpl$Companion$DEFAULT_STRATEGY$2.INSTANCE);
        DEFAULT_STRATEGY$delegate = lazy;
    }

    public BusManagerImpl() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lastPrintT = System.currentTimeMillis();
        this.monitor = new com.tencent.qqnt.bus.helper.a();
        this.enableAcceptEvent = new AtomicBoolean(true);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) BusManagerImpl$workHandler$2.INSTANCE);
        this.workHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) BusManagerImpl$mapEventToObservers$2.INSTANCE);
        this.mapEventToObservers = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) BusManagerImpl$mapEventToStrategy$2.INSTANCE);
        this.mapEventToStrategy = lazy3;
    }

    private final void checkAndRunOnWorkThread(final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.myLooper(), getWorkHandler().getLooper())) {
            block.invoke();
        } else {
            getWorkHandler().post(new Runnable() { // from class: com.tencent.qqnt.bus.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    BusManagerImpl.checkAndRunOnWorkThread$lambda$1(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndRunOnWorkThread$lambda$1(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchEvent(zv3.a event, List<? extends c> observers) {
        Iterator<T> it = observers.iterator();
        while (it.hasNext()) {
            ((c) it.next()).B5(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Class<? extends zv3.a>, List<c>> getMapEventToObservers() {
        return (HashMap) this.mapEventToObservers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Class<? extends zv3.a>, b> getMapEventToStrategy() {
        return (HashMap) this.mapEventToStrategy.getValue();
    }

    private final Handler getWorkHandler() {
        return (Handler) this.workHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logWithLimit(Class<? extends zv3.a> event, String name, long start) {
        if (!QLog.isColorLevel()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!Intrinsics.areEqual(event, this.lastPrintEvent) || this.lastPrintTime < 10) {
            if (Intrinsics.areEqual(event, this.lastPrintEvent) && currentTimeMillis - this.lastPrintT <= 1000) {
                this.lastPrintTime++;
            } else {
                this.lastPrintTime = 0;
                this.lastPrintT = currentTimeMillis;
            }
            QLog.d(TAG, 2, "[" + name + "] for event{" + event.getName() + "} run cause time: " + (currentTimeMillis - start));
        }
    }

    private final void tryCatchExp(final String name, final Class<? extends zv3.a> event, final boolean printLog, final Function0<Unit> block) {
        checkAndRunOnWorkThread(new Function0<Unit>(block, name, printLog, this, event) { // from class: com.tencent.qqnt.bus.api.impl.BusManagerImpl$tryCatchExp$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $block;
            final /* synthetic */ Class<? extends zv3.a> $event;
            final /* synthetic */ String $name;
            final /* synthetic */ boolean $printLog;
            final /* synthetic */ BusManagerImpl this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$block = block;
                this.$name = name;
                this.$printLog = printLog;
                this.this$0 = this;
                this.$event = event;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, block, name, Boolean.valueOf(printLog), this, event);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    this.$block.invoke();
                } catch (Throwable th5) {
                    if (!QLog.isDebugVersion()) {
                        QLog.w("BusManagerImpl", 1, "[" + this.$name + "] run error: ", th5);
                    } else {
                        throw th5;
                    }
                }
                if (this.$printLog) {
                    this.this$0.logWithLimit(this.$event, this.$name, currentTimeMillis);
                }
            }
        });
    }

    static /* synthetic */ void tryCatchExp$default(BusManagerImpl busManagerImpl, String str, Class cls, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        busManagerImpl.tryCatchExp(str, cls, z16, function0);
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void clearAndStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d(TAG, 1, "[clearAndStop]");
            this.monitor.a();
        }
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void clearEventObservers(@NotNull Class<? extends zv3.a> event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            getMapEventToObservers().put(event, new ArrayList());
        }
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void configEventStrategy(@NotNull Class<? extends zv3.a> event, @NotNull b strategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) event, (Object) strategy);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        getMapEventToStrategy().put(event, strategy);
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void reInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void registerEvent(@NotNull final Class<? extends zv3.a> event, @NotNull final c observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(observer, "observer");
        tryCatchExp("registerEvent", event, false, new Function0<Unit>(event, observer) { // from class: com.tencent.qqnt.bus.api.impl.BusManagerImpl$registerEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Class<? extends zv3.a> $event;
            final /* synthetic */ c $observer;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$event = event;
                this.$observer = observer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BusManagerImpl.this, event, observer);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap mapEventToObservers;
                HashMap mapEventToObservers2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                mapEventToObservers = BusManagerImpl.this.getMapEventToObservers();
                List list = (List) mapEventToObservers.get(this.$event);
                if (list == null) {
                    list = new ArrayList();
                    BusManagerImpl busManagerImpl = BusManagerImpl.this;
                    Class<? extends zv3.a> cls = this.$event;
                    mapEventToObservers2 = busManagerImpl.getMapEventToObservers();
                    mapEventToObservers2.put(cls, list);
                }
                c cVar = this.$observer;
                if (list.contains(cVar)) {
                    return;
                }
                list.add(cVar);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void sendEvent(@NotNull final zv3.a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        this.monitor.b(event.getClass());
        tryCatchExp$default(this, "sendEvent", event.getClass(), false, new Function0<Unit>(event) { // from class: com.tencent.qqnt.bus.api.impl.BusManagerImpl$sendEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ zv3.a $event;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$event = event;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BusManagerImpl.this, (Object) event);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap mapEventToObservers;
                final ArrayList arrayList;
                HashMap mapEventToStrategy;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                mapEventToObservers = BusManagerImpl.this.getMapEventToObservers();
                List list = (List) mapEventToObservers.get(this.$event.getClass());
                if (list != null) {
                    if (list.isEmpty()) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(list);
                        arrayList = arrayList2;
                    }
                    if (arrayList != null) {
                        final BusManagerImpl busManagerImpl = BusManagerImpl.this;
                        final zv3.a aVar = this.$event;
                        mapEventToStrategy = busManagerImpl.getMapEventToStrategy();
                        b bVar = (b) mapEventToStrategy.get(aVar.getClass());
                        if (bVar == null) {
                            bVar = BusManagerImpl.INSTANCE.b();
                        }
                        Intrinsics.checkNotNullExpressionValue(bVar, "mapEventToStrategy[event\u2026lass] ?: DEFAULT_STRATEGY");
                        bVar.a(aVar, new Function0<Unit>(aVar, arrayList) { // from class: com.tencent.qqnt.bus.api.impl.BusManagerImpl$sendEvent$1$2$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ zv3.a $event;
                            final /* synthetic */ List<c> $it;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$event = aVar;
                                this.$it = arrayList;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, BusManagerImpl.this, aVar, arrayList);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    BusManagerImpl.this.dispatchEvent(this.$event, this.$it);
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            }
        }, 4, null);
    }

    @Override // com.tencent.qqnt.bus.api.IBusManager
    public void unRegisterEvent(@NotNull final Class<? extends zv3.a> event, @NotNull final c observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(observer, "observer");
        tryCatchExp("unRegisterEvent", event, false, new Function0<Unit>(event, observer) { // from class: com.tencent.qqnt.bus.api.impl.BusManagerImpl$unRegisterEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Class<? extends zv3.a> $event;
            final /* synthetic */ c $observer;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$event = event;
                this.$observer = observer;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BusManagerImpl.this, event, observer);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap mapEventToObservers;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                mapEventToObservers = BusManagerImpl.this.getMapEventToObservers();
                List list = (List) mapEventToObservers.get(this.$event);
                if (list != null) {
                    list.remove(this.$observer);
                }
            }
        });
    }
}
