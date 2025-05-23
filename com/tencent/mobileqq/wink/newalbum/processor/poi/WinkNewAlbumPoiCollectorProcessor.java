package com.tencent.mobileqq.wink.newalbum.processor.poi;

import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorResultReportInfo;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.collector.j;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.wink.newalbum.processor.poi.c;
import com.tencent.mobileqq.wink.utils.ak;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\tB!\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010N\u001a\u00020\u0016\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u001e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u0004H\u0002R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010.R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00104R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00104R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010?R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010;R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010;R\u0016\u0010E\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010;R\u0016\u0010G\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010;R\u0016\u0010I\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010%R\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00160\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u00101\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/poi/WinkNewAlbumPoiCollectorProcessor;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "g", DKHippyEvent.EVENT_STOP, "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "a", "i", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "stop", "B", "", UserInfo.SEX_FEMALE, "L", BdhLogUtil.LogTag.Tag_Conn, "", "key", "", "Lz83/a;", "albumList", "E", "G", "cityName", "D", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "album", "H", "", "startCollectTime", "K", "J", "La93/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "La93/b;", "terminatorProcessor", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "normalScope", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/util/concurrent/LinkedBlockingQueue;", "pendingList", "", "Ljava/util/List;", "clusteringList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInterrupted", "isFinished", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "databaseImp", "Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c;", "I", "Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c;", "poiRequestUtils", "Ljava/util/Timer;", "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "", "totalCount", "hasGPSCount", "M", "noGPSCount", "N", "usedCount", "P", "collectStartTime", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "templateIDList", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "next", "traceId", "<init>", "(Lcom/tencent/mobileqq/wink/newalbum/processor/a;Ljava/lang/String;La93/b;)V", BdhLogUtil.LogTag.Tag_Req, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumPoiCollectorProcessor extends com.tencent.mobileqq.wink.newalbum.processor.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String S = "WinkNewAlbumPoiProcessor";

    @NotNull
    private static String T = "memory_dd";

    @NotNull
    private static final List<String> U;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope normalScope;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LinkedBlockingQueue<WinkNewAlbumContext> pendingList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<WinkNewAlbumContext> clusteringList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isInterrupted;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isFinished;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final WinkNewAlbumDatabaseImp databaseImp;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.newalbum.processor.poi.c poiRequestUtils;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Timer timer;

    /* renamed from: K, reason: from kotlin metadata */
    private int totalCount;

    /* renamed from: L, reason: from kotlin metadata */
    private int hasGPSCount;

    /* renamed from: M, reason: from kotlin metadata */
    private int noGPSCount;

    /* renamed from: N, reason: from kotlin metadata */
    private int usedCount;

    /* renamed from: P, reason: from kotlin metadata */
    private long collectStartTime;

    /* renamed from: Q, reason: from kotlin metadata */
    private List<String> templateIDList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a93.b terminatorProcessor;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/poi/WinkNewAlbumPoiCollectorProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.poi.WinkNewAlbumPoiCollectorProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return WinkNewAlbumPoiCollectorProcessor.S;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Pair) t17).getSecond(), (Integer) ((Pair) t16).getSecond());
            return compareValues;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((z83.a) t17).getAestheticScore()), Float.valueOf(((z83.a) t16).getAestheticScore()));
            return compareValues;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/newalbum/processor/poi/WinkNewAlbumPoiCollectorProcessor$d", "Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c$b;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements c.b {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.newalbum.processor.poi.c.b
        public void a() {
            WinkNewAlbumPoiCollectorProcessor.this.L();
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u4e4b\u65c5", "\u65f6\u5149", "\u4e4b\u884c"});
        U = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumPoiCollectorProcessor(@Nullable com.tencent.mobileqq.wink.newalbum.processor.a aVar, @NotNull String traceId, @NotNull a93.b terminatorProcessor) {
        super(aVar, traceId);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(terminatorProcessor, "terminatorProcessor");
        this.terminatorProcessor = terminatorProcessor;
        this.normalScope = CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d());
        this.pendingList = new LinkedBlockingQueue<>();
        this.clusteringList = new ArrayList();
        this.isInterrupted = new AtomicBoolean(false);
        this.isFinished = new AtomicBoolean(false);
        this.databaseImp = new WinkNewAlbumDatabaseImp();
        this.poiRequestUtils = new com.tencent.mobileqq.wink.newalbum.processor.poi.c();
        this.timer = new BaseTimer();
        this.collectStartTime = System.currentTimeMillis();
    }

    private final void C() {
        int collectionSizeOrDefault;
        String joinToString$default;
        Object obj;
        Map mutableMap;
        int collectionSizeOrDefault2;
        List sortedWith;
        List take;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        final Map mutableMap2;
        List list;
        QLog.i(S, 1, "doCollect");
        if (this.clusteringList.isEmpty()) {
            QLog.i(S, 1, "doCollect, clusteringList isEmpty");
            return;
        }
        for (WinkNewAlbumContext winkNewAlbumContext : this.clusteringList) {
            winkNewAlbumContext.getMetaData().R(winkNewAlbumContext.getMetaData().getCity() + "_" + winkNewAlbumContext.getMetaData().getYear() + "_" + winkNewAlbumContext.getMetaData().getMonth() + "_" + winkNewAlbumContext.getMetaData().getDayOfMonth());
        }
        List<WinkNewAlbumContext> list2 = this.clusteringList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WinkNewAlbumContext) it.next()).getMetaData());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            String city = ((z83.a) next).getCity();
            if (!(city == null || city.length() == 0)) {
                arrayList2.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList2) {
            String city2 = ((z83.a) obj2).getCity();
            Object obj3 = linkedHashMap.get(city2);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(city2, obj3);
            }
            ((List) obj3).add(obj2);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedHashMap.entrySet(), ", ", null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends List<? extends z83.a>>, CharSequence>() { // from class: com.tencent.mobileqq.wink.newalbum.processor.poi.WinkNewAlbumPoiCollectorProcessor$doCollect$groups$4$result$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends List<? extends z83.a>> entry) {
                return invoke2((Map.Entry<String, ? extends List<z83.a>>) entry);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(@NotNull Map.Entry<String, ? extends List<z83.a>> entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                String key = entry.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue().size();
            }
        }, 30, null);
        QLog.d(S, 4, "collect finish, " + joinToString$default);
        Iterator it6 = linkedHashMap.entrySet().iterator();
        if (it6.hasNext()) {
            Object next2 = it6.next();
            if (it6.hasNext()) {
                int size = ((List) ((Map.Entry) next2).getValue()).size();
                do {
                    Object next3 = it6.next();
                    int size2 = ((List) ((Map.Entry) next3).getValue()).size();
                    if (size < size2) {
                        next2 = next3;
                        size = size2;
                    }
                } while (it6.hasNext());
            }
            obj = next2;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        int size3 = (entry == null || (list = (List) entry.getValue()) == null) ? 0 : list.size();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (!(((List) entry2.getValue()).size() == size3 || ((List) entry2.getValue()).size() < 5)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap2);
        Set<Map.Entry> entrySet = mutableMap.entrySet();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        for (Map.Entry entry3 : entrySet) {
            arrayList3.add(TuplesKt.to(entry3.getKey(), Integer.valueOf(((List) entry3.getValue()).size())));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new b());
        take = CollectionsKt___CollectionsKt.take(sortedWith, 9);
        List list3 = take;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
        Iterator it7 = list3.iterator();
        while (it7.hasNext()) {
            arrayList4.add((String) ((Pair) it7.next()).getFirst());
        }
        List<WinkNewAlbumContext> list4 = this.clusteringList;
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault4);
        Iterator<T> it8 = list4.iterator();
        while (it8.hasNext()) {
            arrayList5.add(((WinkNewAlbumContext) it8.next()).getMetaData());
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : arrayList5) {
            if (arrayList4.contains(((z83.a) obj4).getCity())) {
                arrayList6.add(obj4);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj5 : arrayList6) {
            String tempAlbumName = ((z83.a) obj5).getTempAlbumName();
            Object obj6 = linkedHashMap3.get(tempAlbumName);
            if (obj6 == null) {
                obj6 = new ArrayList();
                linkedHashMap3.put(tempAlbumName, obj6);
            }
            ((List) obj6).add(obj5);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry entry4 : linkedHashMap3.entrySet()) {
            if (((List) entry4.getValue()).size() >= 5) {
                linkedHashMap4.put(entry4.getKey(), entry4.getValue());
            }
        }
        mutableMap2 = MapsKt__MapsKt.toMutableMap(linkedHashMap4);
        for (Map.Entry entry5 : mutableMap2.entrySet()) {
            String str = (String) entry5.getKey();
            List list5 = (List) entry5.getValue();
            QLog.d(S, 4, "City: " + str + ", Count: " + list5.size());
        }
        if (mutableMap2.isEmpty()) {
            QLog.i(S, 1, "doCollect result size = 0, return");
            return;
        }
        try {
            this.timer.scheduleAtFixedRate(new TimerTask() { // from class: com.tencent.mobileqq.wink.newalbum.processor.poi.WinkNewAlbumPoiCollectorProcessor$doCollect$3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Timer timer;
                    boolean z16;
                    Iterator<Map.Entry<String, List<z83.a>>> it9 = mutableMap2.entrySet().iterator();
                    while (it9.hasNext()) {
                        Map.Entry<String, List<z83.a>> next4 = it9.next();
                        List<z83.a> value = next4.getValue();
                        boolean z17 = false;
                        if (!(value instanceof Collection) || !value.isEmpty()) {
                            Iterator<T> it10 = value.iterator();
                            while (true) {
                                if (!it10.hasNext()) {
                                    break;
                                }
                                if (((z83.a) it10.next()).getAestheticScore() == -100.0f) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    z17 = true;
                                    break;
                                }
                            }
                        }
                        if (z17) {
                            WinkNewAlbumPoiCollectorProcessor winkNewAlbumPoiCollectorProcessor = this;
                            String key = next4.getKey();
                            Intrinsics.checkNotNull(key);
                            winkNewAlbumPoiCollectorProcessor.E(key, next4.getValue());
                            it9.remove();
                        }
                    }
                    if (mutableMap2.isEmpty()) {
                        QLog.i(WinkNewAlbumPoiCollectorProcessor.INSTANCE.a(), 2, "\u6240\u6709\u5217\u8868\u5df2\u6e05\u7a7a\uff0c\u505c\u6b62\u5b9a\u65f6\u5668");
                        timer = this.timer;
                        timer.cancel();
                    }
                }
            }, 0L, 1000L);
        } catch (Exception e16) {
            QLog.e(S, 1, e16, new Object[0]);
        }
    }

    private final String D(String cityName) {
        boolean endsWith$default;
        Object random;
        Object random2;
        if (cityName == null) {
            return "";
        }
        if (cityName.length() < 5) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(cityName, "\u5e02", false, 2, null);
            if (!endsWith$default) {
                random = CollectionsKt___CollectionsKt.random(U, Random.INSTANCE);
                return cityName + random;
            }
            String substring = cityName.substring(0, cityName.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            random2 = CollectionsKt___CollectionsKt.random(U, Random.INSTANCE);
            return substring + random2;
        }
        return cityName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String key, List<z83.a> albumList) {
        List<z83.a> sortedWith;
        List<String> mutableListOf;
        List<z83.a> list = albumList;
        for (z83.a aVar : list) {
            QLog.d(S, 4, "city:" + aVar.getTempAlbumName() + ", aestheticScore:" + aVar.getAestheticScore() + ", path:" + aVar.getPath());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((z83.a) next).getAestheticScore() <= w83.b.f445025a.c()) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() >= 5) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
            if (sortedWith.size() > 10) {
                sortedWith = CollectionsKt___CollectionsKt.take(sortedWith, 10);
            }
            WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = new WinkNewMemoryAlbumResult();
            winkNewMemoryAlbumResult.H(T + "_" + ak.f326673a.b(key));
            winkNewMemoryAlbumResult.w(D(sortedWith.get(0).getCity()));
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(sortedWith.get(0).getCity());
            winkNewMemoryAlbumResult.I(mutableListOf);
            List<String> list2 = this.templateIDList;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("templateIDList");
                list2 = null;
            }
            winkNewMemoryAlbumResult.J(list2);
            winkNewMemoryAlbumResult.A(sortedWith);
            H(winkNewMemoryAlbumResult);
            return;
        }
        QLog.e(S, 1, "generateAlbumResult fail, size:" + arrayList.size() + ", city:" + key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F(WinkNewAlbumContext context) {
        boolean z16;
        String city = context.getMetaData().getCity();
        if (city != null && city.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        List<String> split$default;
        List<String> mutableListOf;
        split$default = StringsKt__StringsKt.split$default((CharSequence) w83.b.f445025a.F(), new String[]{","}, false, 0, 6, (Object) null);
        this.templateIDList = split$default;
        if (split$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateIDList");
            split$default = null;
        }
        if (split$default.isEmpty()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("dapian_yuanxiangji", "dapian_fuguluxiang", "dapian_zaiyujian", "dapian_meirixinqing");
            this.templateIDList = mutableListOf;
        }
    }

    private final void H(final WinkNewMemoryAlbumResult album) {
        this.databaseImp.P(album.getStoryID(), new t83.c() { // from class: com.tencent.mobileqq.wink.newalbum.processor.poi.b
            @Override // t83.c
            public final void a(List list) {
                WinkNewAlbumPoiCollectorProcessor.I(WinkNewAlbumPoiCollectorProcessor.this, album, list);
            }
        });
        K(this.collectStartTime, album);
        this.collectStartTime = System.currentTimeMillis();
        this.usedCount += album.i().size();
        QLog.i(S, 1, "pushCollectedAlbumResult storyId:=" + album.getStoryID() + ", albumId:" + album.getAlbumID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(WinkNewAlbumPoiCollectorProcessor this$0, WinkNewMemoryAlbumResult album, List list) {
        List<WinkNewMemoryAlbumResult> mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(album, "$album");
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                if (Intrinsics.areEqual(album, list.get(0))) {
                    QLog.e(S, 1, "pushCollectedAlbumResult db contain the same one");
                    return;
                }
                QLog.e(S, 1, "pushCollectedAlbumResult db contain one, need update");
                album.v(((WinkNewMemoryAlbumResult) list.get(0)).getAlbumID());
                this$0.databaseImp.T(album);
                return;
            }
            QLog.e(S, 1, "pushCollectedAlbumResult contain more one");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this$0.databaseImp.v(((WinkNewMemoryAlbumResult) it.next()).getAlbumID());
            }
            WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp = this$0.databaseImp;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(album);
            winkNewAlbumDatabaseImp.H(mutableListOf, null);
            return;
        }
        QLog.e(S, 1, "pushCollectedAlbumResult db not contain, insert");
        a93.b bVar = this$0.terminatorProcessor;
        if (bVar != null) {
            bVar.f(album);
        }
    }

    private final void J() {
        h(j.INSTANCE.c(this.totalCount, this.hasGPSCount, this.noGPSCount, this.usedCount, System.currentTimeMillis() - getStartTime()));
    }

    private final void K(long startCollectTime, WinkNewMemoryAlbumResult album) {
        long currentTimeMillis = System.currentTimeMillis() - startCollectTime;
        WinkNewAlbumCollectorResultReportInfo winkNewAlbumCollectorResultReportInfo = new WinkNewAlbumCollectorResultReportInfo(0, 0, null, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
        winkNewAlbumCollectorResultReportInfo.o(album.getStoryID());
        winkNewAlbumCollectorResultReportInfo.q(album.i().size());
        winkNewAlbumCollectorResultReportInfo.r(getTraceId());
        h(j.INSTANCE.f(winkNewAlbumCollectorResultReportInfo, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        QLog.i(S, 1, "tryDoCollect");
        if (this.isFinished.get() && this.poiRequestUtils.c()) {
            C();
        }
    }

    public final void B() {
        this.pendingList.clear();
        this.clusteringList.clear();
        this.poiRequestUtils.b();
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        i(context);
        if (!w83.b.f445025a.B()) {
            return;
        }
        int i3 = this.totalCount + 1;
        this.totalCount = i3;
        QLog.d(S, 4, "totalNum:" + i3);
        this.pendingList.offer(context);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
        if (!w83.b.f445025a.B()) {
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        BuildersKt__Builders_commonKt.launch$default(this.normalScope, null, null, new WinkNewAlbumPoiCollectorProcessor$onStart$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QcircleLbsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void i(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.i(context);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.poiRequestUtils.d(event, this.databaseImp, new d());
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void stop() {
        super.stop();
        this.isInterrupted.set(true);
        B();
        this.timer.cancel();
        J();
    }
}
