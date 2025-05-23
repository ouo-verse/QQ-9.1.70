package com.tencent.mobileqq.activity.aio;

import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.requests.QCircleTroopGreyRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleTroopRedDotRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.supportui.utils.struct.ArrayMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter$CountInfoRsp;
import qqcircle.QQCircleCounter$GroupInfoRsp;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOTroopQcircleRedDotManager {

    /* renamed from: j, reason: collision with root package name */
    private static volatile AIOTroopQcircleRedDotManager f178009j;

    /* renamed from: f, reason: collision with root package name */
    private long f178015f;

    /* renamed from: h, reason: collision with root package name */
    private String f178017h;

    /* renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<String, Set<String>> f178018i = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private long f178011b = uq3.k.a().f("qcircle_troop_redpoint_pull_time_threshold", 90000);

    /* renamed from: c, reason: collision with root package name */
    private long f178012c = uq3.k.a().f("qcircle_troop_redpoint_pull_amount_threshold", 50);

    /* renamed from: d, reason: collision with root package name */
    private long f178013d = uq3.k.a().f("qcircle_troop_redpoint_grey_time_threshold", 90000);

    /* renamed from: e, reason: collision with root package name */
    private long f178014e = uq3.k.a().f("qcircle_troop_redpoint_grey_last_timestamp", -1);

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f178010a = com.tencent.mobileqq.persistence.l.c(com.tencent.mobileqq.config.e.l()).createEntityManager();

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f178016g = z();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleCounter$CountInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f178023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayMap f178024b;

        a(String str, ArrayMap arrayMap) {
            this.f178023a = str;
            this.f178024b = arrayMap;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleCounter$CountInfoRsp qQCircleCounter$CountInfoRsp) {
            boolean z17;
            if (z16 && j3 == 0 && qQCircleCounter$CountInfoRsp != null) {
                if (qQCircleCounter$CountInfoRsp.extInfo.mapInfo.size() > 1) {
                    AIOTroopQcircleRedDotManager.this.f178011b = Integer.valueOf(qQCircleCounter$CountInfoRsp.extInfo.mapInfo.get(0).value.get()).intValue() * 1000;
                    AIOTroopQcircleRedDotManager.this.f178012c = Integer.valueOf(qQCircleCounter$CountInfoRsp.extInfo.mapInfo.get(1).value.get()).intValue();
                }
                for (int i3 = 0; i3 < qQCircleCounter$CountInfoRsp.rptRedPoint.size(); i3++) {
                    String str2 = qQCircleCounter$CountInfoRsp.rptRedPoint.get(i3).groupInfo.get().touin.get();
                    if (qQCircleCounter$CountInfoRsp.rptRedPoint.get(i3).groupInfo.get().num.get() != 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    String str3 = qQCircleCounter$CountInfoRsp.rptRedPoint.get(i3).groupInfo.get().jumpSchema.get();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(this.f178023a)) {
                        str3 = str3 + "&xsj_share_from_group_id=" + this.f178023a;
                    }
                    this.f178024b.put(str2, new QcircleRedDotEntity(str2, z17, currentTimeMillis, str3));
                }
                AIOTroopQcircleRedDotManager.this.A(this.f178023a, this.f178024b);
                AIOTroopQcircleRedDotManager.this.I(this.f178024b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<QQCircleCounter$GroupInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f178026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f178027b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f178028c;

        b(List list, String str, Map map) {
            this.f178026a = list;
            this.f178027b = str;
            this.f178028c = map;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleCounter$GroupInfoRsp qQCircleCounter$GroupInfoRsp) {
            if (z16 && j3 == 0) {
                if (qQCircleCounter$GroupInfoRsp != null) {
                    if (qQCircleCounter$GroupInfoRsp.groupinfo.size() == this.f178026a.size()) {
                        for (int i3 = 0; i3 < qQCircleCounter$GroupInfoRsp.groupinfo.size(); i3++) {
                            if (qQCircleCounter$GroupInfoRsp.groupinfo.get(i3).isOpen.get()) {
                                AIOTroopQcircleRedDotManager.this.f178016g.put(qQCircleCounter$GroupInfoRsp.groupinfo.get(i3).groupid.get(), 1);
                            } else {
                                AIOTroopQcircleRedDotManager.this.f178016g.remove(qQCircleCounter$GroupInfoRsp.groupinfo.get(i3).groupid.get());
                            }
                        }
                    } else {
                        QZLog.d("AIOTroopQcircleRedDotManager", 2, "size of troop greyinfo rsp not equals to size of req");
                    }
                    AIOTroopQcircleRedDotManager.this.r(this.f178027b, this.f178028c);
                    AIOTroopQcircleRedDotManager aIOTroopQcircleRedDotManager = AIOTroopQcircleRedDotManager.this;
                    aIOTroopQcircleRedDotManager.B(aIOTroopQcircleRedDotManager.f178016g.keySet());
                    AIOTroopQcircleRedDotManager.this.f178014e = System.currentTimeMillis();
                    AIOTroopQcircleRedDotManager.this.f178013d = qQCircleCounter$GroupInfoRsp.nextTime.get() * 1000;
                    uq3.k.a().n("qcircle_troop_redpoint_grey_last_timestamp", AIOTroopQcircleRedDotManager.this.f178014e);
                    uq3.k.a().n("qcircle_troop_redpoint_grey_time_threshold", AIOTroopQcircleRedDotManager.this.f178013d);
                    QZLog.d("AIOTroopQcircleRedDotManager", 2, "new greyTimeLimits from backend: " + AIOTroopQcircleRedDotManager.this.f178013d);
                    return;
                }
                return;
            }
            AIOTroopQcircleRedDotManager.this.r(this.f178027b, this.f178028c);
        }
    }

    AIOTroopQcircleRedDotManager() {
        this.f178017h = "";
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            this.f178015f = runtime.getLongAccountUin();
        } else {
            this.f178015f = -1L;
        }
        this.f178017h = QzoneConfig.getQcircleTroopRedDotIconUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(final String str, final Map<String, QcircleRedDotEntity> map) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                for (QcircleRedDotEntity qcircleRedDotEntity : map.values()) {
                    arrayList.add(new com.tencent.qqnt.bus.event.v(qcircleRedDotEntity.uin, qcircleRedDotEntity.isShowRedDot, AIOTroopQcircleRedDotManager.this.f178017h, qcircleRedDotEntity.jumpSchema));
                }
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.w(str, arrayList));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Set<String> set) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (set != null && set.size() != 0 && qQAppInterface != null) {
            HashSet hashSet = new HashSet(set);
            StringBuilder sb5 = new StringBuilder(1024);
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                sb5.append((String) it.next());
                sb5.append(',');
            }
            uq3.k.a().p("qcircle_redpoint_grey_troop_uin", sb5.toString());
        }
    }

    public static void C(EntityManager entityManager, Entity entity) {
        if (entityManager != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PersistOrReplaceTransaction(entity));
            entityManager.doMultiDBOperateByTransaction(arrayList);
        }
    }

    public static void D(EntityManager entityManager, Collection<QcircleRedDotEntity> collection) {
        if (entityManager != null) {
            ArrayList arrayList = new ArrayList();
            for (QcircleRedDotEntity qcircleRedDotEntity : collection) {
                arrayList.add(new PersistOrReplaceTransaction(qcircleRedDotEntity));
                if (qcircleRedDotEntity.isShowRedDot) {
                    ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(qcircleRedDotEntity.uin).setActionType(61).setSubActionType(1).setThrActionType(1));
                }
            }
            entityManager.doMultiDBOperateByTransaction(arrayList);
        }
    }

    private void F(String str, @NonNull Set<String> set, ArrayMap<String, QcircleRedDotEntity> arrayMap) {
        if (arrayMap != null && arrayMap.size() != 0) {
            QZLog.d("AIOTroopQcircleRedDotManager", 2, "pullQcircleRedDotFromBackend" + arrayMap.size());
            Set<String> set2 = this.f178018i.get(str);
            if (set2 == null) {
                set2 = new HashSet<>();
            }
            set2.addAll(set);
            this.f178018i.put(str, set2);
            QCircleTroopRedDotRequest qCircleTroopRedDotRequest = new QCircleTroopRedDotRequest(arrayMap.keySet());
            qCircleTroopRedDotRequest.setEnableCache(false);
            VSNetworkHelper.getInstance().sendRequest(qCircleTroopRedDotRequest, new a(str, arrayMap));
        }
    }

    private void G(String str, Map<String, String> map, List<Long> list) {
        QCircleTroopGreyRequest qCircleTroopGreyRequest = new QCircleTroopGreyRequest(list);
        qCircleTroopGreyRequest.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(qCircleTroopGreyRequest, new b(list, str, map));
    }

    public static void H() {
        QLog.d("AIOTroopQcircleRedDotManager", 1, "releaseInstance");
        if (f178009j != null) {
            synchronized (AIOTroopQcircleRedDotManager.class) {
                if (f178009j != null) {
                    f178009j = new AIOTroopQcircleRedDotManager();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final ArrayMap<String, QcircleRedDotEntity> arrayMap) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.4
            @Override // java.lang.Runnable
            public void run() {
                AIOTroopQcircleRedDotManager.D(AIOTroopQcircleRedDotManager.this.f178010a, arrayMap.values());
            }
        }, 160, null, true);
        uq3.k.a().n("qcircle_troop_redpoint_pull_time_threshold", this.f178011b);
        uq3.k.a().n("qcircle_troop_redpoint_pull_amount_threshold", this.f178012c);
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "backend timeLimits: " + this.f178011b + "amountLimits: " + this.f178012c);
    }

    private static Entity t(EntityManager entityManager, String str) {
        if (entityManager != null) {
            return DBMethodProxy.find(entityManager, (Class<? extends Entity>) QcircleRedDotEntity.class, str);
        }
        return null;
    }

    public static synchronized AIOTroopQcircleRedDotManager u() {
        AIOTroopQcircleRedDotManager aIOTroopQcircleRedDotManager;
        synchronized (AIOTroopQcircleRedDotManager.class) {
            if (f178009j == null) {
                synchronized (AIOTroopQcircleRedDotManager.class) {
                    if (f178009j == null) {
                        QLog.d("AIOTroopQcircleRedDotManager", 1, "getInstance");
                        f178009j = new AIOTroopQcircleRedDotManager();
                    }
                }
            }
            aIOTroopQcircleRedDotManager = f178009j;
        }
        return aIOTroopQcircleRedDotManager;
    }

    public static boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(String str, Map map) {
        if (this.f178010a != null && str != null && w(str)) {
            ArraySet arraySet = new ArraySet();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap<String, QcircleRedDotEntity> arrayMap2 = new ArrayMap<>();
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            for (String str2 : map.values()) {
                if (!str2.equals(account)) {
                    arraySet.add(str2);
                }
            }
            Iterator it = arraySet.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                QcircleRedDotEntity qcircleRedDotEntity = (QcircleRedDotEntity) t(this.f178010a, str3);
                long currentTimeMillis = System.currentTimeMillis();
                if (qcircleRedDotEntity != null) {
                    if (currentTimeMillis - qcircleRedDotEntity.timeStamp >= this.f178011b) {
                        arrayMap2.put(str3, qcircleRedDotEntity);
                    } else {
                        arrayMap.put(str3, qcircleRedDotEntity);
                    }
                } else {
                    arrayMap2.put(str3, new QcircleRedDotEntity(str3, false, currentTimeMillis, ""));
                }
            }
            F(str, map.keySet(), arrayMap2);
            A(str, arrayMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, Map map) {
        if (this.f178010a != null && str != null && w(str)) {
            ArrayMap<String, QcircleRedDotEntity> arrayMap = new ArrayMap<>();
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            for (Map.Entry entry : map.entrySet()) {
                Set<String> set = this.f178018i.get(str);
                if (!((String) entry.getValue()).equals(account) && (set == null || !set.contains(entry.getKey()))) {
                    arrayMap.put((String) entry.getValue(), new QcircleRedDotEntity((String) entry.getValue(), false, System.currentTimeMillis(), ""));
                }
            }
            if (arrayMap.size() >= this.f178012c) {
                F(str, map.keySet(), arrayMap);
            } else {
                for (String str2 : arrayMap.keySet()) {
                    QcircleRedDotEntity qcircleRedDotEntity = (QcircleRedDotEntity) t(this.f178010a, str2);
                    if (qcircleRedDotEntity != null) {
                        arrayMap.put(str2, qcircleRedDotEntity);
                    }
                }
            }
            A(str, arrayMap);
        }
    }

    private ConcurrentHashMap<String, Integer> z() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        if (qQAppInterface != null) {
            String h16 = uq3.k.a().h("qcircle_redpoint_grey_troop_uin", "");
            if (!"".equals(h16)) {
                for (String str : h16.split(",")) {
                    concurrentHashMap.put(str, 1);
                }
            }
        }
        return concurrentHashMap;
    }

    public void E(String str, Map<String, String> map) {
        ArrayList arrayList;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        QZLog.d("AIOTroopQcircleRedDotManager", 2, "first into AIO, try to pull grey info and reddot info");
        if (qQAppInterface != null) {
            List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
            arrayList = new ArrayList();
            Iterator<TroopInfo> it = joinedTroopInfoFromCache.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().troopuin));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() != 0) {
            G(str, map, arrayList);
        } else {
            r(str, map);
        }
    }

    public void o(String str) {
        this.f178018i.remove(str);
    }

    public void p(String str, final String str2) {
        if (str2 != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager.2
                @Override // java.lang.Runnable
                public void run() {
                    AIOTroopQcircleRedDotManager.C(AIOTroopQcircleRedDotManager.this.f178010a, new QcircleRedDotEntity(str2, false, System.currentTimeMillis(), ""));
                }
            }, 160, null, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.qqnt.bus.event.v(str2, false, "", ""));
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.w(str, arrayList));
        }
    }

    public void q(String str, Map<String, String> map) {
        long j3;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            j3 = runtime.getLongAccountUin();
        } else {
            j3 = -1;
        }
        if (this.f178015f >= 0 && j3 >= 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f178015f != j3) {
                H();
                E(str, map);
                return;
            }
            long j16 = this.f178014e;
            if (j16 != -1 && currentTimeMillis - j16 < this.f178013d) {
                r(str, map);
                return;
            }
            this.f178016g = z();
            this.f178018i.clear();
            E(str, map);
        }
    }

    public void r(final String str, @NonNull final Map<String, String> map) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.h
            @Override // java.lang.Runnable
            public final void run() {
                AIOTroopQcircleRedDotManager.this.x(str, map);
            }
        });
    }

    public void s(final String str, @NonNull final Map<String, String> map) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.g
            @Override // java.lang.Runnable
            public final void run() {
                AIOTroopQcircleRedDotManager.this.y(str, map);
            }
        });
    }

    public boolean w(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f178016g;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            return true;
        }
        return false;
    }
}
