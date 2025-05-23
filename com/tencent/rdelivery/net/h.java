package com.tencent.rdelivery.net;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0015\u001a\u00020\u00072\u001a\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00110\tJ'\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001bR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001d0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/rdelivery/net/h;", "", "", "size", "", "f", "mergeReqId", "", "b", "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "reqList", "Lcom/tencent/raft/standard/net/IRNetwork;", "netInterface", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "d", "Landroid/util/Pair;", "Lcom/tencent/rdelivery/RDelivery;", "Liz3/e;", "instancePairList", "e", Const.BUNDLE_KEY_REQUEST, "a", "(Lcom/tencent/rdelivery/net/RDeliveryRequest;Lcom/tencent/raft/standard/net/IRNetwork;Lcom/tencent/rdelivery/RDeliverySetting;)V", "c", "", "Ljava/util/Map;", "mergeReqIdToSubReqCountMap", "", "mergeReqIdToSubReqListMap", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final h f364359c = new h();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, Integer> mergeReqIdToSubReqCountMap = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, List<RDeliveryRequest>> mergeReqIdToSubReqListMap = new LinkedHashMap();

    h() {
    }

    private final void b(long mergeReqId) {
        mergeReqIdToSubReqCountMap.remove(Long.valueOf(mergeReqId));
        mergeReqIdToSubReqListMap.remove(Long.valueOf(mergeReqId));
    }

    private final void d(List<RDeliveryRequest> reqList, IRNetwork netInterface, RDeliverySetting setting) {
        c.Companion companion = c.INSTANCE;
        companion.b(companion.a(reqList), netInterface, setting);
    }

    private final long f(int size) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        mergeReqIdToSubReqCountMap.put(Long.valueOf(elapsedRealtime), Integer.valueOf(size));
        return elapsedRealtime;
    }

    public final synchronized void a(@NotNull RDeliveryRequest request, @NotNull IRNetwork netInterface, @NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(netInterface, "netInterface");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Long mergeReqId = request.getMergeReqId();
        if (mergeReqId != null) {
            mergeReqId.longValue();
            Integer num = mergeReqIdToSubReqCountMap.get(mergeReqId);
            if (num != null) {
                num.intValue();
                Map<Long, List<RDeliveryRequest>> map = mergeReqIdToSubReqListMap;
                List<RDeliveryRequest> list = map.get(mergeReqId);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(mergeReqId, list);
                }
                List<RDeliveryRequest> list2 = list;
                list2.add(request);
                com.tencent.rdelivery.util.c logger = setting.getLogger();
                if (logger != null) {
                    logger.a(com.tencent.rdelivery.util.d.a("RDelivery_RequestMerger", setting.getRdInstanceIdentifier()), "addRequest finalCount = " + num + "\uff0ccurCount = " + list2.size(), setting.getEnableDetailLog());
                }
                if (list2.size() == num.intValue()) {
                    d(list2, netInterface, setting);
                    b(mergeReqId.longValue());
                }
            }
        }
    }

    public final synchronized void c(long mergeReqId, @NotNull RDeliverySetting setting) {
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Map<Long, Integer> map = mergeReqIdToSubReqCountMap;
        Integer num = map.get(Long.valueOf(mergeReqId));
        com.tencent.rdelivery.util.c logger = setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_RequestMerger", setting.getRdInstanceIdentifier()), "onSingleReqLimited finalCount = " + num, false, 4, null);
        }
        if (num != null) {
            num.intValue();
            map.put(Long.valueOf(mergeReqId), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final synchronized void e(@NotNull List<? extends Pair<RDelivery, iz3.e>> instancePairList) {
        Intrinsics.checkParameterIsNotNull(instancePairList, "instancePairList");
        long f16 = f(instancePairList.size());
        for (Pair<RDelivery, iz3.e> pair : instancePairList) {
            ((RDelivery) pair.first).H((iz3.e) pair.second, f16);
        }
    }
}
