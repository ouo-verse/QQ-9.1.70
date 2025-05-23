package com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.a;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0017J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u001ej\b\u0012\u0004\u0012\u00020\f`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/api/impl/QQStrangerSelfSignalInfoServiceImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/api/IQQStrangerSelfSignalInfoService;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "", "updateSelfSignalInfoToCache", "", "justNowPublish", "notifySelfSignalInfoUpdate", "Lkotlin/Function0;", "block", "runLock", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "listener", "addListener", "removeListener", "loadCacheFirst", "refreshSelfSignalInfo", "upsetSelfSignalInfo", "getSelfSignalInfoCache", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfRepository;", "factory$delegate", "Lkotlin/Lazy;", "getFactory", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfRepository;", "factory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listenerList", "Ljava/util/ArrayList;", "selfSignalInfo", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock$delegate", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSelfSignalInfoServiceImpl implements IQQStrangerSelfSignalInfoService {

    /* renamed from: factory$delegate, reason: from kotlin metadata */
    private final Lazy factory;
    private final ArrayList<a> listenerList;

    /* renamed from: lock$delegate, reason: from kotlin metadata */
    private final Lazy lock;
    private SignalPlazaSvrPB$SignalInfo selfSignalInfo;

    public QQStrangerSelfSignalInfoServiceImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalSelfRepository>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$factory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalSelfRepository invoke() {
                return new QQStrangerSignalSelfRepository();
            }
        });
        this.factory = lazy;
        this.listenerList = new ArrayList<>();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$lock$2
            @Override // kotlin.jvm.functions.Function0
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        this.lock = lazy2;
    }

    private final QQStrangerSignalSelfRepository getFactory() {
        return (QQStrangerSignalSelfRepository) this.factory.getValue();
    }

    private final ReentrantLock getLock() {
        return (ReentrantLock) this.lock.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySelfSignalInfoUpdate(final SignalPlazaSvrPB$SignalInfo signalInfo, final boolean justNowPublish) {
        runLock(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$notifySelfSignalInfoUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                arrayList = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = signalInfo;
                boolean z16 = justNowPublish;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(signalPlazaSvrPB$SignalInfo, z16);
                }
            }
        });
    }

    private final void runLock(Function0<Unit> block) {
        try {
            getLock().lock();
            block.invoke();
        } finally {
            getLock().unlock();
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService
    public void addListener(final a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        runLock(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$addListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                ArrayList arrayList2;
                arrayList = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                if (arrayList.contains(listener)) {
                    return;
                }
                arrayList2 = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                arrayList2.add(listener);
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService
    /* renamed from: getSelfSignalInfoCache, reason: from getter */
    public SignalPlazaSvrPB$SignalInfo getSelfSignalInfo() {
        return this.selfSignalInfo;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService
    public void refreshSelfSignalInfo(boolean loadCacheFirst) {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(FlowKt.flowOn(getFactory().d(loadCacheFirst), Dispatchers.getIO()), new QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1(this, null)), Dispatchers.getMain()), GlobalScope.INSTANCE);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService
    public void removeListener(final a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        runLock(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$removeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                ArrayList arrayList2;
                arrayList = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                if (arrayList.contains(listener)) {
                    arrayList2 = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                    arrayList2.remove(listener);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.api.IQQStrangerSelfSignalInfoService
    public void upsetSelfSignalInfo(SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
        this.selfSignalInfo = signalInfo;
        updateSelfSignalInfoToCache(signalInfo);
        notifySelfSignalInfoUpdate(signalInfo, justNowPublish);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.selfSignalInfo = null;
        runLock(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$onDestroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList;
                arrayList = QQStrangerSelfSignalInfoServiceImpl.this.listenerList;
                arrayList.clear();
            }
        });
    }

    private final void updateSelfSignalInfoToCache(SignalPlazaSvrPB$SignalInfo signalInfo) {
        if (signalInfo != null) {
            FlowKt.launchIn(FlowKt.flowOn(getFactory().f(signalInfo), Dispatchers.getIO()), GlobalScope.INSTANCE);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
