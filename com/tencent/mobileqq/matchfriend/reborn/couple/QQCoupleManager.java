package com.tencent.mobileqq.matchfriend.reborn.couple;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000F\u00a2\u0006\u0004\bH\u0010IJ\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002JK\u0010\u0013\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\f2-\u0010\u0012\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0002J&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J9\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\u001c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J=\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042#\u0010\u001c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0000\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001a\u00020\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010)\u001a\u00020\nR\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010*R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010*R2\u00100\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170-0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010/R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00102R,\u00104\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000-0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010/R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R*\u0010E\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleManager;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/b;", "", "coupleId", QCircleLpReportDc010001.KEY_SUBTYPE, ReportConstant.COSTREPORT_PREFIX, "", "changedSubTypeList", "", "u", "", "coupleMap", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "afterPrecessMap", "cb", "y", "Lkotlin/Function0;", "block", "w", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "listener", "a", "c", "coupleList", "callback", "f", "e", "couple", "b", "newCouple", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;)V", "newCoupleList", "d", "subTypes", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", "Ljava/lang/String;", "bizId", "tag", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "listenerMap", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleStorage;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleStorage;", QQPermissionConstants.Permission.STORAGE_GROUP, "cache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasPreLoad", "Ljava/util/concurrent/locks/ReentrantLock;", "g", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadLock", h.F, "prepareLock", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", "getPreprocessor", "()Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/mobileqq/matchfriend/reborn/couple/preprocessor/a;)V", "preprocessor", "Ljava/lang/Class;", "clz", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQCoupleManager<T extends IQQCoupleModel> implements b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String bizId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String tag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, a<T>>> listenerMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQCoupleStorage<T> storage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, T>> cache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasPreLoad;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock preLoadLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock prepareLock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<T> preprocessor;

    public QQCoupleManager(String bizId, Class<T> clz) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(clz, "clz");
        this.bizId = bizId;
        this.tag = "QQCoupleManager_" + bizId;
        this.listenerMap = new ConcurrentHashMap<>();
        this.storage = new QQCoupleStorage<>(bizId, clz);
        this.cache = new ConcurrentHashMap<>();
        this.hasPreLoad = new AtomicBoolean(false);
        this.preLoadLock = new ReentrantLock();
        this.prepareLock = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String s(String coupleId, String subType) {
        return coupleId + "_" + subType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final String coupleId, final List<String> changedSubTypeList) {
        if ((coupleId.length() == 0) || changedSubTypeList.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.d
            @Override // java.lang.Runnable
            public final void run() {
                QQCoupleManager.v(QQCoupleManager.this, coupleId, changedSubTypeList);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final QQCoupleManager this$0, final String coupleId, final List changedSubTypeList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coupleId, "$coupleId");
        Intrinsics.checkNotNullParameter(changedSubTypeList, "$changedSubTypeList");
        ConcurrentHashMap<String, T> concurrentHashMap = this$0.cache.get(coupleId);
        if (concurrentHashMap == null) {
            concurrentHashMap = MapsKt__MapsKt.emptyMap();
        }
        this$0.y(concurrentHashMap, new Function1<Map<String, ? extends T>, Unit>(this$0) { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$notifyCouplesUpdate$1$1
            final /* synthetic */ QQCoupleManager<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((Map) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, ? extends T> afterPrecessMap) {
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                String s16;
                String str;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(afterPrecessMap, "afterPrecessMap");
                if (QLog.isDevelopLevel()) {
                    str3 = ((QQCoupleManager) this.this$0).tag;
                    QLog.i(str3, 1, "notifyCouplesUpdate coupleId=" + coupleId);
                }
                ArrayList arrayList = new ArrayList(afterPrecessMap.size());
                Iterator<Map.Entry<String, ? extends T>> it = afterPrecessMap.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((IQQCoupleModel) it.next().getValue());
                }
                if (QLog.isDevelopLevel()) {
                    str2 = ((QQCoupleManager) this.this$0).tag;
                    QLog.i(str2, 1, "notifyCouplesUpdate notifyCoupleList size=" + arrayList.size());
                }
                concurrentHashMap2 = ((QQCoupleManager) this.this$0).listenerMap;
                ConcurrentHashMap concurrentHashMap4 = (ConcurrentHashMap) concurrentHashMap2.get(QQCoupleManager.t(this.this$0, coupleId, null, 2, null));
                if (concurrentHashMap4 != null) {
                    Iterator it5 = concurrentHashMap4.entrySet().iterator();
                    while (it5.hasNext()) {
                        ((a) ((Map.Entry) it5.next()).getValue()).a(arrayList);
                    }
                }
                List<String> list = changedSubTypeList;
                ArrayList<String> arrayList2 = new ArrayList();
                for (T t16 : list) {
                    if (((String) t16).length() > 0) {
                        arrayList2.add(t16);
                    }
                }
                QQCoupleManager<T> qQCoupleManager = this.this$0;
                String str4 = coupleId;
                for (String str5 : arrayList2) {
                    concurrentHashMap3 = ((QQCoupleManager) qQCoupleManager).listenerMap;
                    s16 = qQCoupleManager.s(str4, str5);
                    ConcurrentHashMap concurrentHashMap5 = (ConcurrentHashMap) concurrentHashMap3.get(s16);
                    if (concurrentHashMap5 != null) {
                        Intrinsics.checkNotNullExpressionValue(concurrentHashMap5, "listenerMap[genListenerKey(coupleId, subType)]");
                        for (Map.Entry entry : concurrentHashMap5.entrySet()) {
                            IQQCoupleModel iQQCoupleModel = (IQQCoupleModel) afterPrecessMap.get(str5);
                            if (QLog.isDevelopLevel()) {
                                str = ((QQCoupleManager) qQCoupleManager).tag;
                                QLog.i(str, 1, "notifyCouplesUpdate couple=" + iQQCoupleModel + ", listener=" + entry.getValue().hashCode());
                            }
                            ((a) entry.getValue()).a(iQQCoupleModel != null ? CollectionsKt__CollectionsJVMKt.listOf(iQQCoupleModel) : CollectionsKt__CollectionsKt.emptyList());
                        }
                    }
                }
            }
        });
    }

    private final void w(final String coupleId, final Function0<Unit> block) {
        if (this.cache.get(coupleId) != null) {
            block.invoke();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQCoupleManager.x(QQCoupleManager.this, coupleId, block);
                }
            }, 32, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:3:0x0017, B:5:0x001b, B:6:0x0021, B:8:0x002b, B:13:0x0037, B:14:0x003d, B:16:0x0043, B:18:0x004f), top: B:2:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void x(QQCoupleManager this$0, String coupleId, Function0 block) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coupleId, "$coupleId");
        Intrinsics.checkNotNullParameter(block, "$block");
        ReentrantLock reentrantLock = this$0.prepareLock;
        reentrantLock.lock();
        try {
            QQCoupleStorage<T> qQCoupleStorage = this$0.storage;
            List<T> c16 = qQCoupleStorage != null ? qQCoupleStorage.c(coupleId) : null;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            List<T> list = c16;
            if (list != null && !list.isEmpty()) {
                z16 = false;
                if (!z16) {
                    for (T t16 : c16) {
                        concurrentHashMap.put(t16.subtype, t16);
                    }
                }
                this$0.cache.put(coupleId, concurrentHashMap);
                block.invoke();
                Unit unit = Unit.INSTANCE;
            }
            z16 = true;
            if (!z16) {
            }
            this$0.cache.put(coupleId, concurrentHashMap);
            block.invoke();
            Unit unit2 = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Map<String, ? extends T> coupleMap, final Function1<? super Map<String, ? extends T>, Unit> cb5) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends T> entry : coupleMap.entrySet()) {
            String key = entry.getKey();
            IQQCoupleModel deepCopy = entry.getValue().deepCopy();
            Intrinsics.checkNotNull(deepCopy, "null cannot be cast to non-null type T of com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager.preprocessBeforeNotify$lambda$3");
            linkedHashMap.put(key, deepCopy);
        }
        com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<T> aVar = this.preprocessor;
        if (aVar == null) {
            cb5.invoke(linkedHashMap);
        } else if (aVar != null) {
            aVar.a(linkedHashMap, new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$preprocessBeforeNotify$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    cb5.invoke(linkedHashMap);
                }
            });
        }
    }

    public void A(T newCouple) {
        List<? extends T> listOf;
        Intrinsics.checkNotNullParameter(newCouple, "newCouple");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(newCouple);
        d(listOf);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public void a(String coupleId, String subType, a<? super T> listener) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String s16 = s(coupleId, subType);
        if (!this.listenerMap.containsKey(s16)) {
            this.listenerMap.put(s16, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<Integer, a<T>> concurrentHashMap = this.listenerMap.get(s16);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(Integer.valueOf(listener.hashCode()), listener);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public void b(final String coupleId, final String subType, final Function1<? super T, Unit> callback) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(coupleId.length() == 0)) {
            if (!(subType.length() == 0)) {
                w(coupleId, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$getCoupleByCoupleIdAndSubtype$1
                    final /* synthetic */ QQCoupleManager<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ConcurrentHashMap concurrentHashMap;
                        IQQCoupleModel iQQCoupleModel;
                        Map mapOf;
                        concurrentHashMap = ((QQCoupleManager) this.this$0).cache;
                        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) concurrentHashMap.get(coupleId);
                        if (concurrentHashMap2 != null && (iQQCoupleModel = (IQQCoupleModel) concurrentHashMap2.get(subType)) != null) {
                            QQCoupleManager<T> qQCoupleManager = this.this$0;
                            final Function1<T, Unit> function1 = callback;
                            final String str = subType;
                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(iQQCoupleModel.subtype, iQQCoupleModel));
                            qQCoupleManager.y(mapOf, new Function1<Map<String, ? extends T>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$getCoupleByCoupleIdAndSubtype$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                    invoke((Map) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Map<String, ? extends T> afterPrecessMap) {
                                    Intrinsics.checkNotNullParameter(afterPrecessMap, "afterPrecessMap");
                                    function1.invoke(afterPrecessMap.get(str));
                                }
                            });
                            return;
                        }
                        callback.invoke(null);
                    }
                });
                return;
            }
        }
        callback.invoke(null);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public void c(String coupleId, String subType, a<? super T> listener) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String s16 = s(coupleId, subType);
        ConcurrentHashMap<Integer, a<T>> concurrentHashMap = this.listenerMap.get(s16);
        if (concurrentHashMap == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(listener.hashCode()));
        if (concurrentHashMap.isEmpty()) {
            this.listenerMap.remove(s16);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public void d(List<? extends T> newCoupleList) {
        Intrinsics.checkNotNullParameter(newCoupleList, "newCoupleList");
        if (newCoupleList.isEmpty()) {
            return;
        }
        String str = newCoupleList.get(0).coupleId;
        w(str, new QQCoupleManager$upsertCouples$1(newCoupleList, this, str));
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public List<T> e(String coupleId) {
        List<T> emptyList;
        List<T> emptyList2;
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        if (coupleId.length() == 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        ConcurrentHashMap<String, T> concurrentHashMap = this.cache.get(coupleId);
        if (concurrentHashMap == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        Iterator<Map.Entry<String, T>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.b
    public void f(final String coupleId, final Function1<? super List<? extends T>, Unit> callback) {
        List emptyList;
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (coupleId.length() == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        } else {
            w(coupleId, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$getCouplesByCoupleId$1
                final /* synthetic */ QQCoupleManager<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap;
                    List emptyList2;
                    concurrentHashMap = ((QQCoupleManager) this.this$0).cache;
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) concurrentHashMap.get(coupleId);
                    if (concurrentHashMap2 != null) {
                        QQCoupleManager<T> qQCoupleManager = this.this$0;
                        final Function1<List<? extends T>, Unit> function1 = callback;
                        qQCoupleManager.y(concurrentHashMap2, new Function1<Map<String, ? extends T>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManager$getCouplesByCoupleId$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke((Map) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Map<String, ? extends T> afterPrecessMap) {
                                Intrinsics.checkNotNullParameter(afterPrecessMap, "afterPrecessMap");
                                Function1<List<? extends T>, Unit> function12 = function1;
                                ArrayList arrayList = new ArrayList(afterPrecessMap.size());
                                Iterator<Map.Entry<String, ? extends T>> it = afterPrecessMap.entrySet().iterator();
                                while (it.hasNext()) {
                                    arrayList.add((IQQCoupleModel) it.next().getValue());
                                }
                                function12.invoke(arrayList);
                            }
                        });
                    } else {
                        Function1<List<? extends T>, Unit> function12 = callback;
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        function12.invoke(emptyList2);
                    }
                }
            });
        }
    }

    public void p(String coupleId) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        if (coupleId.length() == 0) {
            return;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        q(coupleId, emptyList);
    }

    public void q(String coupleId, List<String> subTypes) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(subTypes, "subTypes");
        if (coupleId.length() == 0) {
            return;
        }
        w(coupleId, new QQCoupleManager$deleteCouplesByCoupleIdAndSubtype$1(this, coupleId, subTypes));
    }

    public final void r() {
        this.cache.clear();
        this.listenerMap.clear();
    }

    public final void z(com.tencent.mobileqq.matchfriend.reborn.couple.preprocessor.a<T> aVar) {
        this.preprocessor = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String t(QQCoupleManager qQCoupleManager, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return qQCoupleManager.s(str, str2);
    }
}
