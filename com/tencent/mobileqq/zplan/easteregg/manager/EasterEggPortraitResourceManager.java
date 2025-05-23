package com.tencent.mobileqq.zplan.easteregg.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.ErrorMsg;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.easteregg.model.QueryInfoPair;
import com.tencent.mobileqq.zplan.easteregg.repository.LocalRepository;
import com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository;
import com.tencent.mobileqq.zplan.easteregg.repository.RemoteRepository;
import com.tencent.mobileqq.zplan.easteregg.repository.ResultData;
import com.tencent.mobileqq.zplan.easteregg.t;
import com.tencent.mobileqq.zplan.easteregg.x;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b)\u0010*J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u001b\u0010&\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b'\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/EasterEggPortraitResourceManager;", "Lcom/tencent/mobileqq/zplan/easteregg/x;", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "resultData", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "listener", "", "l", "", "c", "e", "d", "", "g", "f", "a", "Lcom/tencent/mobileqq/zplan/easteregg/repository/a;", "Lkotlin/Lazy;", tl.h.F, "()Lcom/tencent/mobileqq/zplan/easteregg/repository/a;", "easterEggRepositoryFactory", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/zplan/easteregg/model/g;", "b", "k", "()Ljava/util/concurrent/ConcurrentHashMap;", "queryListenerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloading", "i", "()Z", "enableBatchQuery", "j", "enableSingleQuery", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EasterEggPortraitResourceManager implements x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy easterEggRepositoryFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy queryListenerMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isPreloading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableBatchQuery;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableSingleQuery;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f332904a;

        static {
            int[] iArr = new int[PortraitQueryType.values().length];
            try {
                iArr[PortraitQueryType.BATCH_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PortraitQueryType.SINGLE_QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f332904a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/manager/EasterEggPortraitResourceManager$c", "Lhh3/a;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/c;", "resultData", "", "b", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements hh3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t f332905a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EasterEggPortraitResourceManager f332906b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.model.d f332907c;

        c(t tVar, EasterEggPortraitResourceManager easterEggPortraitResourceManager, com.tencent.mobileqq.zplan.easteregg.model.d dVar) {
            this.f332905a = tVar;
            this.f332906b = easterEggPortraitResourceManager;
            this.f332907c = dVar;
        }

        @Override // hh3.a
        public void a(PortraitSource source, String errMsg) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("[EasterEggResource]EasterEggPortraitResourceManager", 1, "queryPortrait onError " + this.f332907c.getId() + ", " + source + ", " + errMsg);
            t tVar = this.f332905a;
            if (tVar != null) {
                tVar.b(new ErrorMsg(this.f332907c.getId(), Integer.valueOf(VideoResultCode.ERROR_PLAY_START_IO_EXCEPTION_BASE)));
            }
        }

        @Override // hh3.a
        public void b(ResultData resultData) {
            t tVar = this.f332905a;
            if (tVar != null) {
                this.f332906b.l(this.f332907c, resultData, tVar);
            }
        }
    }

    public EasterEggPortraitResourceManager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.easteregg.repository.a>() { // from class: com.tencent.mobileqq.zplan.easteregg.manager.EasterEggPortraitResourceManager$easterEggRepositoryFactory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.easteregg.repository.a invoke() {
                return new com.tencent.mobileqq.zplan.easteregg.repository.a(new LocalRepository(), new RemoteRepository(), new RecordRepository());
            }
        });
        this.easterEggRepositoryFactory = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, List<QueryInfoPair>>>() { // from class: com.tencent.mobileqq.zplan.easteregg.manager.EasterEggPortraitResourceManager$queryListenerMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, List<QueryInfoPair>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.queryListenerMap = lazy2;
        this.lock = new ReentrantLock();
        this.isPreloading = new AtomicBoolean(false);
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.easteregg.manager.EasterEggPortraitResourceManager$enableBatchQuery$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanFeatureSwitch.f369852a.p0());
            }
        });
        this.enableBatchQuery = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.easteregg.manager.EasterEggPortraitResourceManager$enableSingleQuery$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanFeatureSwitch.f369852a.v0());
            }
        });
        this.enableSingleQuery = lazy4;
    }

    private final boolean c(com.tencent.mobileqq.zplan.easteregg.model.d param) {
        int i3 = b.f332904a[param.getType().ordinal()];
        if (i3 == 1) {
            return i();
        }
        if (i3 == 2) {
            return j();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:3:0x0009, B:6:0x0018, B:8:0x0022, B:10:0x002e, B:16:0x003b, B:18:0x0047, B:19:0x0051, B:21:0x0084, B:27:0x0098), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean d(com.tencent.mobileqq.zplan.easteregg.model.d param, t listener) {
        List<QueryInfoPair> mutableListOf;
        boolean z16;
        String g16 = g(param);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!k().isEmpty() && k().containsKey(g16)) {
                List<QueryInfoPair> list = k().get(g16);
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                    if (z16) {
                        List<QueryInfoPair> list2 = k().get(g16);
                        QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "checkQueryAlreadyExists true, param: " + param + ", queryKey: " + g16 + ",  listSize: " + (list2 != null ? Integer.valueOf(list2.size()) : null));
                        List<QueryInfoPair> list3 = k().get(g16);
                        if (list3 != null) {
                            Intrinsics.checkNotNullExpressionValue(list3, "queryListenerMap[queryKey]");
                            CollectionsKt___CollectionsKt.plus((Collection<? extends QueryInfoPair>) ((Collection<? extends Object>) list3), new QueryInfoPair(param, listener));
                        }
                        return true;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "checkQueryAlreadyExists false, param: " + param);
            ConcurrentHashMap<String, List<QueryInfoPair>> k3 = k();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QueryInfoPair(param, listener));
            k3.put(g16, mutableListOf);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean e(com.tencent.mobileqq.zplan.easteregg.model.d param) {
        int i3 = b.f332904a[param.getType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (param.getId() == null) {
                    return false;
                }
                Integer id5 = param.getId();
                Intrinsics.checkNotNull(id5);
                if (id5.intValue() <= 0 || !(!param.e().isEmpty())) {
                    return false;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (param.e().isEmpty()) {
            return false;
        }
        return true;
    }

    private final com.tencent.mobileqq.zplan.easteregg.model.d f(com.tencent.mobileqq.zplan.easteregg.model.d param) {
        String appearanceKey = param.getAppearanceKey();
        List<Integer> e16 = param.e();
        if (appearanceKey.length() == 0) {
            if (((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(param.getUin()).gender == 1) {
                appearanceKey = "0000000000001";
            } else {
                appearanceKey = "0000000000002";
            }
        }
        if (e16.isEmpty()) {
            QLog.e("[EasterEggResource]EasterEggPortraitResourceManager", 1, "query param invalid, appearanceKey: " + ((Object) appearanceKey) + ", idList: " + e16);
            return null;
        }
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue < 0) {
                QLog.e("[EasterEggResource]EasterEggPortraitResourceManager", 1, "query param idList contains bad id, it will be deleted, id: " + intValue);
                e16.remove(Integer.valueOf(intValue));
            }
        }
        if (e16.isEmpty()) {
            QLog.e("[EasterEggResource]EasterEggPortraitResourceManager", 1, "query param invalid, idList invalid.");
            return null;
        }
        com.tencent.mobileqq.zplan.easteregg.model.d b16 = com.tencent.mobileqq.zplan.easteregg.model.d.INSTANCE.b(param, e16, appearanceKey);
        QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "checkParamValid passed, param: " + b16);
        return b16;
    }

    private final String g(com.tencent.mobileqq.zplan.easteregg.model.d param) {
        String str;
        String appearanceKey = param.getAppearanceKey();
        int i3 = b.f332904a[param.getType().ordinal()];
        if (i3 == 1) {
            str = "batch";
        } else if (i3 == 2) {
            str = String.valueOf(param.getId());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str2 = appearanceKey + "_" + str;
        QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "generateQueryKey: " + str2 + ", param: " + param);
        return str2;
    }

    private final com.tencent.mobileqq.zplan.easteregg.repository.a h() {
        return (com.tencent.mobileqq.zplan.easteregg.repository.a) this.easterEggRepositoryFactory.getValue();
    }

    private final boolean i() {
        return ((Boolean) this.enableBatchQuery.getValue()).booleanValue();
    }

    private final boolean j() {
        return ((Boolean) this.enableSingleQuery.getValue()).booleanValue();
    }

    private final ConcurrentHashMap<String, List<QueryInfoPair>> k() {
        return (ConcurrentHashMap) this.queryListenerMap.getValue();
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.x
    public void a(com.tencent.mobileqq.zplan.easteregg.model.d param, t listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (!c(param)) {
            if (listener != null) {
                t.a.a(listener, PortraitSource.NOT_ALLOWED, null, null, "toggle switch off, no query is allowed, param: " + param + ".", 6, null);
                return;
            }
            return;
        }
        if (!e(param)) {
            if (listener != null) {
                t.a.a(listener, PortraitSource.NOT_ALLOWED, null, null, "query portrait resource failed, query type invalid, param: " + param + ".", 6, null);
                return;
            }
            return;
        }
        com.tencent.mobileqq.zplan.easteregg.model.d f16 = f(param);
        if (f16 == null) {
            if (listener != null) {
                t.a.a(listener, PortraitSource.NOT_ALLOWED, null, null, "query portrait resource failed, param invalid, param: " + param, 6, null);
                return;
            }
            return;
        }
        if (d(f16, listener)) {
            QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "query already exists, param: " + f16);
            return;
        }
        h().d(f16, new c(listener, this, f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(com.tencent.mobileqq.zplan.easteregg.model.d param, ResultData resultData, t listener) {
        ResultCode code = resultData != null ? resultData.getCode() : null;
        QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "onQueryResult, result: " + resultData + ", isSuccess: " + code + "\uff0cappearanceKey: " + param.getAppearanceKey());
        if (resultData != null) {
            ResultCode code2 = resultData.getCode();
            ResultCode resultCode = ResultCode.SUCCESS;
            if (code2 == resultCode) {
                if (resultData.getCode() == resultCode) {
                    PortraitSource source = resultData.getSource();
                    List<Integer> c16 = resultData.c();
                    List<String> d16 = resultData.d();
                    String g16 = g(param);
                    List<QueryInfoPair> list = k().get(g16);
                    QLog.i("[EasterEggResource]EasterEggPortraitResourceManager", 1, "onResource, queryKey: " + g16 + ", listSize: " + (list != null ? Integer.valueOf(list.size()) : null));
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        List<QueryInfoPair> queryInfoPairList = k().get(g16);
                        if (queryInfoPairList != null) {
                            Intrinsics.checkNotNullExpressionValue(queryInfoPairList, "queryInfoPairList");
                            Iterator<T> it = queryInfoPairList.iterator();
                            while (it.hasNext()) {
                                t listener2 = ((QueryInfoPair) it.next()).getListener();
                                if (listener2 != null) {
                                    t.a.a(listener2, source == null ? PortraitSource.UNKNOWN : source, c16, d16, null, 8, null);
                                }
                            }
                            k().remove(g16);
                        }
                        return;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return;
            }
        }
        listener.b(null);
    }
}
