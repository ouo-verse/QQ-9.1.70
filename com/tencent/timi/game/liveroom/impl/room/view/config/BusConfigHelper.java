package com.tencent.timi.game.liveroom.impl.room.view.config;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.sso.request.QQLiveBusConfigRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uq4.c;
import uq4.d;
import uq4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001d\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0006R&\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R0\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/config/BusConfigHelper;", "", "", "roomId", "Luq4/c;", "confRsp", "", "o", "", "programId", "i", "Lcom/tencent/timi/game/liveroom/impl/room/view/config/BusConfigHelper$a;", "onConfigUpdateListener", h.F, "r", "", "type", "rsp", "", "g", "f", "d", "e", "c", "Luq4/d;", "l", "id", "Luq4/g$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", DomainData.DOMAIN_NAME, "(J)[Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Ljava/util/concurrent/ConcurrentHashMap;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "listenerList", "j", "()Ljava/util/concurrent/ConcurrentHashMap;", "setConfigResult", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "configResult", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class BusConfigHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final BusConfigHelper f378723a = new BusConfigHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, List<a>> listenerList = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Long, c> configResult = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/config/BusConfigHelper$a;", "", "", "roomId", "Luq4/c;", DownloadInfo.spKey_Config, "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(long roomId, @Nullable c config);
    }

    BusConfigHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(long roomId, c confRsp) {
        Boolean bool;
        Integer num;
        Float f16;
        if (confRsp != null) {
            StringBuilder sb5 = new StringBuilder();
            uq4.a[] boolConfig = confRsp.f439826a;
            if (boolConfig != null) {
                Intrinsics.checkNotNullExpressionValue(boolConfig, "boolConfig");
                for (uq4.a aVar : boolConfig) {
                    sb5.append(aVar.f439822a + "-" + aVar.f439823b + " ");
                }
            }
            d dVar = confRsp.f439827b;
            Float f17 = null;
            if (dVar != null) {
                bool = Boolean.valueOf(dVar.f439831a);
            } else {
                bool = null;
            }
            d dVar2 = confRsp.f439827b;
            if (dVar2 != null) {
                num = Integer.valueOf(dVar2.f439832b);
            } else {
                num = null;
            }
            d dVar3 = confRsp.f439827b;
            if (dVar3 != null) {
                f16 = Float.valueOf(dVar3.f439833c);
            } else {
                f16 = null;
            }
            d dVar4 = confRsp.f439827b;
            if (dVar4 != null) {
                f17 = Float.valueOf(dVar4.f439834d);
            }
            sb5.append("freeLove:[" + bool + ", " + num + ", " + f16 + ", " + f17 + "]");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("printConfigLog, roomId:");
            sb6.append(roomId);
            sb6.append(", rsp:");
            sb6.append((Object) sb5);
            QLog.d("BusConfigHelper", 1, sb6.toString());
        }
    }

    public final long c(long roomId) {
        if (l(roomId) != null) {
            return r3.f439834d * ((float) 1000);
        }
        return 700L;
    }

    public final boolean d(long roomId) {
        d l3 = l(roomId);
        if (l3 != null) {
            return l3.f439831a;
        }
        return false;
    }

    public final long e(long roomId) {
        if (l(roomId) != null) {
            return r3.f439833c * ((float) 1000);
        }
        return 500L;
    }

    public final boolean f(int type, long roomId) {
        uq4.a[] boolConfig;
        c cVar = configResult.get(Long.valueOf(roomId));
        if (cVar != null && (boolConfig = cVar.f439826a) != null) {
            Intrinsics.checkNotNullExpressionValue(boolConfig, "boolConfig");
            for (uq4.a aVar : boolConfig) {
                if (aVar.f439822a == type) {
                    return aVar.f439823b;
                }
            }
        }
        return false;
    }

    public final boolean g(int type, @Nullable c rsp) {
        uq4.a[] aVarArr;
        if (rsp != null && (aVarArr = rsp.f439826a) != null) {
            for (uq4.a aVar : aVarArr) {
                if (aVar.f439822a == type) {
                    return aVar.f439823b;
                }
            }
        }
        return false;
    }

    public final void h(long roomId, @Nullable a onConfigUpdateListener) {
        if (onConfigUpdateListener != null) {
            ConcurrentHashMap<Long, List<a>> concurrentHashMap = listenerList;
            List<a> list = concurrentHashMap.get(Long.valueOf(roomId));
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!list.contains(onConfigUpdateListener)) {
                list.add(onConfigUpdateListener);
            }
            concurrentHashMap.put(Long.valueOf(roomId), list);
        }
    }

    public final void i(final long roomId, @NotNull String programId) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveBusConfigRequest(roomId, programId), new Function1<QQLiveResponse<c>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper$fetchConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<c> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<c> response) {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                Intrinsics.checkNotNullParameter(response, "response");
                c rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
                    busConfigHelper.j().put(Long.valueOf(roomId), rsp);
                    c cVar = busConfigHelper.j().get(Long.valueOf(roomId));
                    if (cVar != null) {
                        long j3 = roomId;
                        concurrentHashMap2 = BusConfigHelper.listenerList;
                        List list = (List) concurrentHashMap2.get(Long.valueOf(j3));
                        if (list != null) {
                            Intrinsics.checkNotNullExpressionValue(list, "listenerList[roomId]");
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((BusConfigHelper.a) it.next()).a(j3, cVar);
                            }
                        }
                    }
                    BusConfigHelper busConfigHelper2 = BusConfigHelper.f378723a;
                    busConfigHelper2.o(roomId, busConfigHelper2.j().get(Long.valueOf(roomId)));
                    return;
                }
                QLog.e("BusConfigHelper", 1, "[fetchConfig] failed, errCode:" + response.getRetCode() + ", errMsg:" + response.getErrMsg());
                concurrentHashMap = BusConfigHelper.listenerList;
                List list2 = (List) concurrentHashMap.get(Long.valueOf(roomId));
                if (list2 != null) {
                    long j16 = roomId;
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        ((BusConfigHelper.a) it5.next()).a(j16, null);
                    }
                }
            }
        });
    }

    @NotNull
    public final ConcurrentHashMap<Long, c> j() {
        return configResult;
    }

    @Nullable
    public final c k(long roomId) {
        return configResult.get(Long.valueOf(roomId));
    }

    @Nullable
    public final d l(long roomId) {
        c cVar = configResult.get(Long.valueOf(roomId));
        if (cVar != null) {
            return cVar.f439827b;
        }
        d dVar = new d();
        dVar.f439831a = true;
        dVar.f439832b = 2000000021;
        return dVar;
    }

    @Nullable
    public final g.a m(long roomId, @NotNull String id5) {
        g gVar;
        g.a[] aVarArr;
        Intrinsics.checkNotNullParameter(id5, "id");
        c cVar = configResult.get(Long.valueOf(roomId));
        if (cVar != null && (gVar = cVar.f439828c) != null && (aVarArr = gVar.f439849a) != null) {
            for (g.a aVar : aVarArr) {
                if (aVar.f439852a.compareTo(id5) == 0) {
                    return aVar;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final String[] n(long roomId) {
        g gVar;
        c cVar = configResult.get(Long.valueOf(roomId));
        if (cVar != null && (gVar = cVar.f439828c) != null) {
            return gVar.f439850b;
        }
        return null;
    }

    public final void p() {
        listenerList.clear();
    }

    public final void q(long roomId) {
        listenerList.remove(Long.valueOf(roomId));
    }

    public final void r(long roomId, @Nullable a onConfigUpdateListener) {
        List<a> list;
        if (onConfigUpdateListener != null && (list = listenerList.get(Long.valueOf(roomId))) != null) {
            list.remove(onConfigUpdateListener);
        }
    }
}
