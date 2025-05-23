package com.tencent.mobileqq.zplan.easteregg.repository;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.avatar.image.easterEgg.ZPlanAvatarEasterEggPortraitCacheManager;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository;
import com.tencent.mobileqq.zplan.manager.ZPlanThreadManager;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.servlet.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.AppSetting;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeZPlanBatchAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.BatchRecordRequestParams;
import com.tencent.zplan.record.model.ExpireConfig;
import com.tencent.zplan.record.model.Source;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.aspectj.lang.JoinPoint;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0003\"',B\u0007\u00a2\u0006\u0004\b?\u0010@J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J#\u0010\u0014\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\fH\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R-\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00180 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R!\u0010*\u001a\b\u0012\u0004\u0012\u00020!0\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00108R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00108R\u001b\u0010>\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository;", "", "", "resultId", "", "resultPath", "", "l", "(Ljava/lang/Integer;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "", h.F, "Lhh3/a;", "listener", "g", "u", "id", "path", "i", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "isForce", "j", "", "originIdList", DomainData.DOMAIN_NAME, "Lcom/tencent/zplan/meme/action/MemeZPlanBatchAction;", "action", "Ljava/lang/Runnable;", "r", "t", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$c;", "a", "Lkotlin/Lazy;", "o", "()Ljava/util/concurrent/ConcurrentHashMap;", "recordingListenerMap", "b", "p", "()Ljava/util/List;", "recordingListeners", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "d", "Ljava/util/List;", "recordingList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecording", "f", "resultPaths", "Ljava/lang/String;", "recordAppearanceKey", "recordUin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "timeout", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RecordRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy recordingListenerMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy recordingListeners;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> recordingList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isRecording;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<String> resultPaths;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String recordAppearanceKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String recordUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy timeout;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333044a;

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
            f333044a = iArr;
        }
    }

    public RecordRepository() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<Integer, List<RecordInfoPair>>>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository$recordingListenerMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<Integer, List<RecordRepository.RecordInfoPair>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.recordingListenerMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<RecordInfoPair>>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository$recordingListeners$2
            @Override // kotlin.jvm.functions.Function0
            public final List<RecordRepository.RecordInfoPair> invoke() {
                return new ArrayList();
            }
        });
        this.recordingListeners = lazy2;
        this.lock = new ReentrantLock();
        this.recordingList = new ArrayList();
        this.isRecording = new AtomicBoolean(false);
        this.resultPaths = new ArrayList();
        this.recordAppearanceKey = "";
        this.recordUin = "";
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository$timeout$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(ZPlanFeatureSwitch.f369852a.i1());
            }
        });
        this.timeout = lazy3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:
    
        if ((r4 == null || r4.isEmpty()) != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean g(com.tencent.mobileqq.zplan.easteregg.model.d param, hh3.a listener) {
        Integer id5;
        int intValue;
        Integer id6;
        int intValue2;
        List<RecordInfoPair> mutableListOf;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.isRecording.compareAndSet(false, true)) {
                u();
                this.recordingList.addAll(param.e());
                int i3 = d.f333044a[param.getType().ordinal()];
                if (i3 == 1) {
                    p().add(new RecordInfoPair(param, listener));
                } else if (i3 == 2 && (id6 = param.getId()) != null && (intValue2 = id6.intValue()) > 0) {
                    ConcurrentHashMap<Integer, List<RecordInfoPair>> o16 = o();
                    Integer valueOf = Integer.valueOf(intValue2);
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new RecordInfoPair(param, listener));
                    o16.put(valueOf, mutableListOf);
                }
                return false;
            }
            Integer id7 = param.getId();
            if (id7 != null && !this.recordingList.contains(Integer.valueOf(id7.intValue()))) {
                return true;
            }
            int i16 = d.f333044a[param.getType().ordinal()];
            if (i16 == 1) {
                p().add(new RecordInfoPair(param, listener));
            } else if (i16 == 2 && (id5 = param.getId()) != null && (intValue = id5.intValue()) > 0) {
                if (!o().isEmpty() && o().containsKey(Integer.valueOf(intValue))) {
                    List<RecordInfoPair> list = o().get(Integer.valueOf(intValue));
                }
                o().put(Integer.valueOf(intValue), new ArrayList());
                List<RecordInfoPair> list2 = o().get(Integer.valueOf(intValue));
                if (list2 != null) {
                    list2.add(new RecordInfoPair(param, listener));
                }
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean h(com.tencent.mobileqq.zplan.easteregg.model.d param) {
        if (param.e().isEmpty()) {
            QLog.e("RecordRepository", 1, "checkRecordParamValid failed, idList null or empty.");
            return false;
        }
        if (param.getType() == PortraitQueryType.SINGLE_QUERY) {
            Integer id5 = param.getId();
            return id5 != null && id5.intValue() > 0;
        }
        String appearanceKey = param.getAppearanceKey();
        if (appearanceKey.length() == 0) {
            QLog.e("RecordRepository", 1, "checkRecordParamValid failed, appearanceKey empty.");
            return false;
        }
        if (!this.isRecording.get() || Intrinsics.areEqual(appearanceKey, this.recordAppearanceKey)) {
            return true;
        }
        String str = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(param.getUin()).appearanceKey;
        QLog.w("RecordRepository", 1, "checkRecordParamValid, isRecording: " + this.isRecording + ", currAppearanceKey: " + appearanceKey + ", recordingAppearanceKey: " + this.recordAppearanceKey + ", appearanceKeyInUserInfo: " + str);
        if (!Intrinsics.areEqual(str, appearanceKey)) {
            return false;
        }
        u();
        this.isRecording.getAndSet(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Integer resultId, String resultPath) {
        List listOf;
        QLog.e("RecordRepository", 1, "record failed or record result invalid, resultId: " + resultId + ", resultPath: " + resultPath);
        if (resultId == null || resultId.intValue() < 0) {
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.recordingList.remove(resultId);
            if (o().containsKey(resultId)) {
                List<RecordInfoPair> recordInfoPairList = o().get(resultId);
                if (recordInfoPairList != null) {
                    Intrinsics.checkNotNullExpressionValue(recordInfoPairList, "recordInfoPairList");
                    Iterator<T> it = recordInfoPairList.iterator();
                    while (it.hasNext()) {
                        hh3.a listener = ((RecordInfoPair) it.next()).getListener();
                        ResultCode resultCode = ResultCode.FAIL;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(resultId.intValue()));
                        listener.b(new ResultData(resultCode, listOf, null, PortraitSource.RECORD, null, null, 52, null));
                    }
                }
                o().remove(resultId);
            }
            k(this, false, 1, null);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final List<Integer> n(List<Integer> originIdList) {
        ArrayList arrayList = new ArrayList();
        File c16 = di3.b.f393984a.c(this.recordAppearanceKey);
        Iterator<T> it = originIdList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (!arrayList.contains(Integer.valueOf(intValue))) {
                File file = new File(c16, intValue + ".png");
                if (!file.exists() || !file.isFile()) {
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
        }
        return arrayList;
    }

    private final ConcurrentHashMap<Integer, List<RecordInfoPair>> o() {
        return (ConcurrentHashMap) this.recordingListenerMap.getValue();
    }

    private final List<RecordInfoPair> p() {
        return (List) this.recordingListeners.getValue();
    }

    private final long q() {
        return ((Number) this.timeout.getValue()).longValue();
    }

    private final Runnable r(final MemeZPlanBatchAction action) {
        return new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.b
            @Override // java.lang.Runnable
            public final void run() {
                RecordRepository.s(RecordRepository.this, action);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(RecordRepository this$0, MemeZPlanBatchAction action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        QLog.i("RecordRepository", 1, "easter egg portrait record timeout!");
        ReentrantLock reentrantLock = this$0.lock;
        reentrantLock.lock();
        try {
            Meme.f385754h.g(action);
            this$0.j(true);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.recordingList.clear();
            p().clear();
            o().clear();
            this.resultPaths.clear();
            this.recordAppearanceKey = "";
            this.recordUin = "";
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "b", "()Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "Lhh3/a;", "Lhh3/a;", "()Lhh3/a;", "listener", "<init>", "(Lcom/tencent/mobileqq/zplan/easteregg/model/d;Lhh3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class RecordInfoPair {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final com.tencent.mobileqq.zplan.easteregg.model.d param;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final hh3.a listener;

        public RecordInfoPair(com.tencent.mobileqq.zplan.easteregg.model.d param, hh3.a listener) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.param = param;
            this.listener = listener;
        }

        /* renamed from: a, reason: from getter */
        public final hh3.a getListener() {
            return this.listener;
        }

        /* renamed from: b, reason: from getter */
        public final com.tencent.mobileqq.zplan.easteregg.model.d getParam() {
            return this.param;
        }

        public int hashCode() {
            return (this.param.hashCode() * 31) + this.listener.hashCode();
        }

        public String toString() {
            return "RecordInfoPair(param=" + this.param + ", listener=" + this.listener + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordInfoPair)) {
                return false;
            }
            RecordInfoPair recordInfoPair = (RecordInfoPair) other;
            return Intrinsics.areEqual(this.param, recordInfoPair.param) && Intrinsics.areEqual(this.listener, recordInfoPair.listener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$b;", "", "", "isSuccess", "", "url", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(boolean isSuccess, String url);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, boolean z16, String str, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        str = "";
                    }
                    bVar.a(z16, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUploaded");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$e", "Lcom/tencent/mobileqq/zplan/easteregg/repository/RecordRepository$b;", "", "isSuccess", "", "url", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements b {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.repository.RecordRepository.b
        public void a(boolean isSuccess, String url) {
            String str;
            List<String> listOf;
            if (isSuccess) {
                if (!(url == null || url.length() == 0)) {
                    if (!AppSetting.isPublicVersion()) {
                        str = RecordRepository.this.recordAppearanceKey + "_TEST";
                    } else {
                        str = RecordRepository.this.recordAppearanceKey;
                    }
                    i iVar = i.f335409a;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(url);
                    iVar.f(str, listOf, System.currentTimeMillis());
                }
            }
            RecordRepository.this.isRecording.getAndSet(false);
            RecordRepository.this.u();
        }
    }

    private final boolean i(Integer id5, String path) {
        if (id5 != null && id5.intValue() >= 0) {
            if (!(path == null || path.length() == 0) && new File(path).exists()) {
                return true;
            }
        }
        QLog.e("RecordRepository", 1, "record succeed, recordResult invalid.");
        return false;
    }

    private final void j(boolean isForce) {
        if (!isForce && this.resultPaths.size() != this.recordingList.size()) {
            QLog.i("RecordRepository", 1, "easterEgg portrait record not completed, need record: " + this.recordingList.size() + ", already done: " + this.resultPaths.size());
            return;
        }
        QLog.i("RecordRepository", 1, "doOnCompleteIfNeed, isForce: " + isForce + ", need record: " + this.recordingList.size() + ", already done: " + this.resultPaths.size());
        for (RecordInfoPair recordInfoPair : p()) {
            recordInfoPair.getListener().b(new ResultData(ResultCode.SUCCESS, recordInfoPair.getParam().e(), this.resultPaths, PortraitSource.RECORD, null, null, 48, null));
            p().remove(recordInfoPair);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("RecordRepository", 1, "upload easterEgg portrait zip failed, appRuntime null.");
            return;
        }
        if (ZPlanFeatureSwitch.f369852a.q0() && Intrinsics.areEqual(peekAppRuntime.getCurrentUin(), this.recordUin)) {
            ZPlanAvatarEasterEggPortraitCacheManager zPlanAvatarEasterEggPortraitCacheManager = ZPlanAvatarEasterEggPortraitCacheManager.f331820a;
            String str = this.recordAppearanceKey;
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "appRuntime.currentUin");
            zPlanAvatarEasterEggPortraitCacheManager.g(str, currentUin, new e());
        }
    }

    static /* synthetic */ void k(RecordRepository recordRepository, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        recordRepository.j(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0076 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:48:0x0067, B:10:0x0076, B:11:0x007b, B:13:0x0086, B:15:0x0092, B:16:0x009e, B:18:0x00a4, B:20:0x00b4, B:34:0x00c0, B:26:0x00c4, B:28:0x00ce, B:29:0x00d4, B:38:0x00f2, B:39:0x00f9), top: B:47:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:48:0x0067, B:10:0x0076, B:11:0x007b, B:13:0x0086, B:15:0x0092, B:16:0x009e, B:18:0x00a4, B:20:0x00b4, B:34:0x00c0, B:26:0x00c4, B:28:0x00ce, B:29:0x00d4, B:38:0x00f2, B:39:0x00f9), top: B:47:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Integer resultId, String resultPath) {
        boolean z16;
        boolean z17;
        List listOf;
        List listOf2;
        QLog.i("RecordRepository", 1, "record success, resultId: " + resultId + ", resultPath: " + resultPath);
        if (!i(resultId, resultPath)) {
            m(resultId, resultPath);
            return;
        }
        ZPlanAvatarEasterEggPortraitCacheManager zPlanAvatarEasterEggPortraitCacheManager = ZPlanAvatarEasterEggPortraitCacheManager.f331820a;
        Intrinsics.checkNotNull(resultId);
        int intValue = resultId.intValue();
        String str = this.recordAppearanceKey;
        Intrinsics.checkNotNull(resultPath);
        String m3 = zPlanAvatarEasterEggPortraitCacheManager.m(intValue, str, resultPath);
        QLog.w("RecordRepository", 1, "doOnRecordDone, set to local cache: " + m3 + ".");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (m3 != null) {
            try {
                if (m3.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        this.resultPaths.add(m3);
                    }
                    if (o().containsKey(resultId)) {
                        List<RecordInfoPair> recordInfoPairList = o().get(resultId);
                        if (recordInfoPairList != null) {
                            Intrinsics.checkNotNullExpressionValue(recordInfoPairList, "recordInfoPairList");
                            for (RecordInfoPair recordInfoPair : recordInfoPairList) {
                                com.tencent.mobileqq.zplan.easteregg.model.d param = recordInfoPair.getParam();
                                hh3.a listener = recordInfoPair.getListener();
                                if (m3 != null && m3.length() != 0) {
                                    z17 = false;
                                    if (!z17) {
                                        listener.b(null);
                                    } else {
                                        ResultCode resultCode = ResultCode.SUCCESS;
                                        Integer id5 = param.getId();
                                        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(id5 != null ? id5.intValue() : -1));
                                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(m3);
                                        listener.b(new ResultData(resultCode, listOf, listOf2, PortraitSource.RECORD, null, null, 48, null));
                                    }
                                }
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        }
                        o().remove(resultId);
                    }
                    k(this, false, 1, null);
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                }
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (o().containsKey(resultId)) {
        }
        k(this, false, 1, null);
        Unit unit2 = Unit.INSTANCE;
        reentrantLock.unlock();
    }

    public void t(com.tencent.mobileqq.zplan.easteregg.model.d param, hh3.a listener) {
        boolean t06;
        List<Source> listOf;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        if (!zPlanFeatureSwitch.g0()) {
            if (!Intrinsics.areEqual(param.getUin(), peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null)) {
                listener.b(null);
                return;
            }
        }
        if (!h(param)) {
            listener.a(PortraitSource.RECORD, "record param invalid, param: " + param);
            return;
        }
        if (g(param, listener)) {
            return;
        }
        this.recordAppearanceKey = param.getAppearanceKey();
        this.recordUin = param.getUin();
        List<Integer> n3 = n(param.e());
        boolean s06 = zPlanFeatureSwitch.s0();
        int width = param.getWidth();
        int height = param.getHeight();
        String uin = param.getUin();
        MODE mode = MODE.FRAME;
        AppTheme appTheme = AppTheme.DAY;
        ZPlanThreadManager.f333874a.c(r(new MemeZPlanBatchAction(n3, width, height, uin, mode, appTheme, s06, null, null, null, null, 1920, null)), q());
        HashMap hashMap = new HashMap();
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        ZPlanRecordScene zPlanRecordScene = ZPlanRecordScene.EASTER_EGG;
        EngineType targetEngineForRecord = iZPlanApi.getTargetEngineForRecord(zPlanRecordScene);
        boolean enableCancelGlassesMetallic = ZPlanQQMC.INSTANCE.enableCancelGlassesMetallic();
        String uin2 = param.getUin();
        String str = null;
        int width2 = param.getWidth();
        int height2 = param.getHeight();
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
        businessConfig.C(BusinessConfig.FrameType.PNG);
        businessConfig.y(0);
        businessConfig.M(zPlanFeatureSwitch.u0());
        if (targetEngineForRecord != null) {
            businessConfig.G(targetEngineForRecord);
            businessConfig.A(businessConfig.getTargetEngine() instanceof EngineType.Filament ? Boolean.TRUE : null);
        }
        businessConfig.x(1);
        businessConfig.z(Boolean.valueOf(enableCancelGlassesMetallic));
        Unit unit = Unit.INSTANCE;
        int i3 = 4;
        Priority priority = Priority.HIGH;
        if (targetEngineForRecord instanceof EngineType.Filament) {
            t06 = ((IZPlanApi) QRoute.api(IZPlanApi.class)).enableFilamentRecordResultUpload(zPlanRecordScene);
        } else {
            t06 = zPlanFeatureSwitch.t0();
        }
        BatchRecordRequestParams batchRecordRequestParams = new BatchRecordRequestParams(n3, hashMap, appTheme, uin2, str, width2, height2, mode, businessConfig, i3, priority, new UploadConfig(t06, UploadConfig.UploadTarget.CDN, true, false, 8, null), new ExpireConfig(false, 0L, 0L, 7, null), 0, false, null, null, 114688, null);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        if (!Intrinsics.areEqual(param.getUin(), peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Source[]{Source.LOCAL_CACHE, Source.CLOUD_CACHE});
        } else {
            listOf = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getRecordSourceWhenUsingFilament(zPlanRecordScene);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new RecordRepository$queryPortrait$1(batchRecordRequestParams, listOf, this, null), 3, null);
    }
}
