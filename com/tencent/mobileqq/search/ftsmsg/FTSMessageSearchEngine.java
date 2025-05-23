package com.tencent.mobileqq.search.ftsmsg;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vy2.b;

/* compiled from: P */
@Deprecated
/* loaded from: classes18.dex */
public class FTSMessageSearchEngine extends ep2.b {

    /* renamed from: d, reason: collision with root package name */
    private String f283239d;

    /* renamed from: e, reason: collision with root package name */
    private Object f283240e;

    /* renamed from: f, reason: collision with root package name */
    private RecentUserProxy f283241f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f283242h;

    /* renamed from: i, reason: collision with root package name */
    private Comparator<FTSEntity> f283243i;

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f283238m = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, SoftReference<ArrayList<FTSEntity>>> C = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, SoftReference<ArrayList<ep2.d>>> D = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements Comparator<d> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int signum = Long.signum(dVar.f283253c - dVar2.f283253c);
            if (signum == 0) {
                int signum2 = Long.signum(dVar.f283254d - dVar2.f283254d);
                if (signum2 == 0) {
                    return Long.signum((-dVar.f283255e) + dVar2.f283255e);
                }
                return signum2;
            }
            return signum;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Comparator<FTSEntity> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FTSEntity fTSEntity, FTSEntity fTSEntity2) {
            long j3;
            TextMsgExts textMsgExts = (TextMsgExts) ((FTSMessage) fTSEntity).msgExts;
            TextMsgExts textMsgExts2 = (TextMsgExts) ((FTSMessage) fTSEntity2).msgExts;
            long j16 = 0;
            if (textMsgExts != null) {
                j3 = textMsgExts.time;
            } else {
                j3 = 0;
            }
            if (textMsgExts2 != null) {
                j16 = textMsgExts2.time;
            }
            return Long.signum(j16 - j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements Comparator<d> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            int signum = Long.signum(dVar.f283252b - dVar2.f283252b);
            if (signum == 0) {
                int signum2 = Long.signum(dVar.f283253c - dVar2.f283253c);
                if (signum2 == 0) {
                    int signum3 = Long.signum(dVar.f283254d - dVar2.f283254d);
                    if (signum3 == 0) {
                        return Long.signum((-dVar.f283255e) + dVar2.f283255e);
                    }
                    return signum3;
                }
                return signum2;
            }
            return signum;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public List<FTSMessage> f283251a;

        /* renamed from: b, reason: collision with root package name */
        public int f283252b;

        /* renamed from: c, reason: collision with root package name */
        public int f283253c;

        /* renamed from: d, reason: collision with root package name */
        public int f283254d;

        /* renamed from: e, reason: collision with root package name */
        public long f283255e;

        /* renamed from: f, reason: collision with root package name */
        public HashSet<Long> f283256f;

        /* renamed from: g, reason: collision with root package name */
        public int f283257g;

        /* renamed from: h, reason: collision with root package name */
        public int f283258h;

        /* renamed from: i, reason: collision with root package name */
        public int f283259i;

        /* renamed from: j, reason: collision with root package name */
        public int f283260j;
    }

    public FTSMessageSearchEngine(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f283240e = new Object();
        this.f283241f = null;
        this.f283243i = new b();
        try {
            this.f283242h = ((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("fts_message_search_reaport");
        } catch (Exception e16) {
            QLog.i("FTSMessageSearchEngine", 1, "isFeatureSwitchEnable", e16);
        }
    }

    private static boolean h(AppInterface appInterface, String str, int i3) {
        if (i3 == 1) {
            TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
            if (k3 == null || k3.troopname == null) {
                return false;
            }
        } else {
            if (3000 != i3) {
                return true;
            }
            DiscussionInfo h16 = ((n) appInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str);
            if (h16 == null || TextUtils.isEmpty(h16.discussionName)) {
                return false;
            }
        }
        return true;
    }

    private int i(String str, int i3) {
        int i16;
        if (this.f283241f == null) {
            this.f283241f = ((IRecentUserProxyService) d().getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        }
        if (!this.f283241f.isRecentUserInCache(str, i3)) {
            i16 = 10;
        } else {
            i16 = 0;
        }
        if (i3 == 3000) {
            return i16 + 2;
        }
        if (i3 == 1) {
            if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopMark(d(), str, i3)) {
                i16 += 4;
            }
            return i16 + 3;
        }
        return i16 + 1;
    }

    public static boolean j(String str) {
        synchronized (f283238m) {
            Boolean bool = f283238m.get(str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    private ArrayList<d> p(ArrayList<FTSEntity> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator<FTSEntity> it = arrayList.iterator();
            while (it.hasNext()) {
                FTSMessage fTSMessage = (FTSMessage) it.next();
                if (fTSMessage != null && fTSMessage.msgExts != null) {
                    int i3 = fTSMessage.istroop;
                    String valueOf = String.valueOf(fTSMessage.uin);
                    String f16 = ao.f(valueOf, i3);
                    if (!hashMap.containsKey(f16)) {
                        d dVar = new d();
                        ArrayList arrayList2 = new ArrayList();
                        dVar.f283251a = arrayList2;
                        arrayList2.add(fTSMessage);
                        dVar.f283252b = fTSMessage.mSearchScene;
                        dVar.f283253c = fTSMessage.mProximity;
                        dVar.f283254d = i(valueOf, i3);
                        dVar.f283255e = ((TextMsgExts) fTSMessage.msgExts).time;
                        HashSet<Long> hashSet = new HashSet<>();
                        dVar.f283256f = hashSet;
                        hashSet.add(Long.valueOf(fTSMessage.mOId));
                        dVar.f283257g = fTSMessage.searchStrategy;
                        dVar.f283258h = fTSMessage.senderNum;
                        dVar.f283259i = fTSMessage.friendNum;
                        dVar.f283260j = fTSMessage.friendIndex;
                        hashMap.put(f16, dVar);
                    } else {
                        d dVar2 = (d) hashMap.get(f16);
                        if (dVar2.f283256f.add(Long.valueOf(fTSMessage.mOId))) {
                            int i16 = fTSMessage.mSearchScene;
                            int i17 = dVar2.f283252b;
                            if (i16 == i17) {
                                int i18 = fTSMessage.mProximity;
                                if (i18 < dVar2.f283253c) {
                                    dVar2.f283253c = i18;
                                }
                                MsgExts msgExts = fTSMessage.msgExts;
                                if (((TextMsgExts) msgExts).time > dVar2.f283255e) {
                                    dVar2.f283255e = ((TextMsgExts) msgExts).time;
                                }
                                int i19 = fTSMessage.senderNum;
                                if (i19 > dVar2.f283258h) {
                                    dVar2.f283258h = i19;
                                }
                                int i26 = fTSMessage.friendNum;
                                if (i26 > dVar2.f283259i) {
                                    dVar2.f283259i = i26;
                                }
                                int i27 = fTSMessage.friendIndex;
                                if (i27 > dVar2.f283260j) {
                                    dVar2.f283260j = i27;
                                }
                            } else if (i16 < i17) {
                                dVar2.f283253c = fTSMessage.mProximity;
                                dVar2.f283255e = ((TextMsgExts) fTSMessage.msgExts).time;
                                dVar2.f283258h = fTSMessage.senderNum;
                                dVar2.f283259i = fTSMessage.friendNum;
                                dVar2.f283260j = fTSMessage.friendIndex;
                            }
                            if (i16 < i17) {
                                dVar2.f283252b = i16;
                            }
                            int i28 = fTSMessage.searchStrategy;
                            if (i28 < dVar2.f283257g) {
                                dVar2.f283257g = i28;
                            }
                            dVar2.f283251a.add(fTSMessage);
                        }
                    }
                }
            }
            ArrayList<d> arrayList3 = new ArrayList<>();
            Iterator it5 = hashMap.entrySet().iterator();
            while (it5.hasNext()) {
                arrayList3.add((d) ((Map.Entry) it5.next()).getValue());
            }
            Collections.sort(arrayList3, new c());
            return arrayList3;
        }
        return new ArrayList<>();
    }

    private List<ep2.d> q(String str, String str2, String str3, boolean z16, ArrayList<FTSEntity> arrayList, boolean z17) {
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        Iterator<FTSEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            FTSMessage fTSMessage = (FTSMessage) it.next();
            if (fTSMessage != null && fTSMessage.msgExts != null) {
                int i3 = fTSMessage.istroop;
                String valueOf = String.valueOf(fTSMessage.uin);
                String f16 = ao.f(valueOf, i3);
                if (!hashMap.containsKey(f16)) {
                    d dVar = new d();
                    ArrayList arrayList2 = new ArrayList();
                    dVar.f283251a = arrayList2;
                    arrayList2.add(fTSMessage);
                    dVar.f283253c = fTSMessage.mProximity;
                    dVar.f283254d = i(valueOf, i3);
                    dVar.f283255e = ((TextMsgExts) fTSMessage.msgExts).time;
                    HashSet<Long> hashSet = new HashSet<>();
                    dVar.f283256f = hashSet;
                    hashSet.add(Long.valueOf(fTSMessage.mOId));
                    dVar.f283257g = fTSMessage.searchStrategy;
                    hashMap.put(f16, dVar);
                } else {
                    d dVar2 = (d) hashMap.get(f16);
                    if (dVar2.f283256f.add(Long.valueOf(fTSMessage.mOId))) {
                        int i16 = fTSMessage.mProximity;
                        if (i16 < dVar2.f283253c) {
                            dVar2.f283253c = i16;
                        }
                        MsgExts msgExts = fTSMessage.msgExts;
                        if (((TextMsgExts) msgExts).time > dVar2.f283255e) {
                            dVar2.f283255e = ((TextMsgExts) msgExts).time;
                        }
                        int i17 = fTSMessage.searchStrategy;
                        if (i17 < dVar2.f283257g) {
                            dVar2.f283257g = i17;
                        }
                        dVar2.f283251a.add(fTSMessage);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = hashMap.entrySet().iterator();
        while (it5.hasNext()) {
            arrayList3.add((d) ((Map.Entry) it5.next()).getValue());
        }
        Collections.sort(arrayList3, new a());
        ArrayList<String> l3 = vy2.b.l(str2);
        ArrayList arrayList4 = new ArrayList();
        int e16 = nn2.a.e("fts_native_chathistory_maxnum", 3);
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            d dVar3 = (d) it6.next();
            if (dVar3.f283251a.get(0).istroop == 10007) {
                AppInterface d16 = d();
                if (str == null) {
                    str5 = str2;
                } else {
                    str5 = str;
                }
                List<FTSMessage> list = dVar3.f283251a;
                g gVar = new g(d16, str5, str2, l3, list, String.valueOf(list.get(0).uin));
                gVar.N = dVar3.f283257g;
                gVar.P = dVar3.f283258h;
                gVar.Q = dVar3.f283259i;
                gVar.R = dVar3.f283260j;
                if (gVar.I()) {
                    arrayList4.add(gVar);
                }
            } else if (h(d(), String.valueOf(dVar3.f283251a.get(0).uin), dVar3.f283251a.get(0).istroop)) {
                AppInterface d17 = d();
                if (str == null) {
                    str4 = str2;
                } else {
                    str4 = str;
                }
                e eVar = new e(d17, str4, str2, l3, dVar3.f283251a, str3, null);
                eVar.N = dVar3.f283257g;
                eVar.P = dVar3.f283258h;
                eVar.Q = dVar3.f283259i;
                eVar.R = dVar3.f283260j;
                arrayList4.add(eVar);
            }
            if (z16 && arrayList4.size() >= e16 + 1) {
                break;
            }
        }
        return arrayList4;
    }

    @Override // on2.b
    public List<ep2.d> a(pn2.a aVar) {
        boolean z16;
        if (aVar == null) {
            return null;
        }
        b.a.f443726o = System.nanoTime();
        b.a.f443727p = 0L;
        Bundle bundle = aVar.f426496b;
        if (bundle != null) {
            z16 = bundle.getBoolean("fts_search_is_limited", true);
        } else {
            z16 = true;
        }
        if (vy2.b.f(d()) == 1) {
            return o(aVar, z16);
        }
        return m(aVar, z16);
    }

    @Override // on2.b
    public void c(final pn2.a aVar, final on2.d<ep2.d> dVar) {
        b.a.f443726o = System.nanoTime();
        b.a.f443727p = 0L;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
            @Override // java.lang.Runnable
            public void run() {
                List<ep2.d> m3;
                if (vy2.b.f(FTSMessageSearchEngine.this.d()) == 1) {
                    m3 = FTSMessageSearchEngine.this.o(aVar, false);
                } else {
                    m3 = FTSMessageSearchEngine.this.m(aVar, false);
                }
                on2.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onFinish(m3, 1);
                }
            }
        }, 8, null, true);
    }

    @Override // ep2.b
    public void e(final pn2.a aVar, final on2.d<ep2.c> dVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.3
            @Override // java.lang.Runnable
            public void run() {
                List<ep2.c> n3 = FTSMessageSearchEngine.this.n(aVar);
                on2.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onFinish(n3, 1);
                }
            }
        }, 8, null, true);
    }

    @Override // ep2.b
    public void f(String str, List<FTSEntity> list) {
        Collections.sort(list, this.f283243i);
    }

    @Override // ep2.b, on2.b
    public void init() {
        super.init();
        if (this.f283242h) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FTSMessageSearchEngine.this.l();
                    } catch (Exception e16) {
                        QLog.i("FTSMessageSearchEngine", 1, "isFeatureSwitchEnable", e16);
                    }
                }
            }, 32, null, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0047, code lost:
    
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l() {
        EntityManager createEntityManager = d().getEntityManagerFactory().createEntityManager();
        Cursor query = createEntityManager.query(false, "msg_sync_log", new String[]{"count(*)"}, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        long j3 = 0;
        try {
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j3 = query.getLong(0);
                    }
                } catch (Exception e16) {
                    QLog.i("FTSMessageSearchEngine", 1, "reportUnHandledMsgSize", e16);
                    HashMap hashMap = new HashMap();
                    hashMap.put("size", String.valueOf(j3));
                    hashMap.put("plan", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD);
                    QQBeaconReport.reportWithAppKey("0S200MNJT807V3GE", "", "search_fts_unhandled_msg_size", hashMap);
                    createEntityManager.close();
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<ep2.d> m(pn2.a aVar, boolean z16) {
        int length;
        int i3;
        byte b16;
        int i16;
        int length2;
        if (QLog.isColorLevel()) {
            QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
        }
        int i17 = !TextUtils.isEmpty(aVar.f426495a) ? 1 : 0;
        if (TextUtils.isEmpty(aVar.f426495a)) {
            length = 0;
        } else {
            length = aVar.f426495a.length();
        }
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        b.a.f443712a = i17;
        b.a.f443713b = length;
        String str = aVar.f426495a;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("keyword bytes length: ");
            if (str == null) {
                length2 = 0;
            } else {
                length2 = str.getBytes().length;
            }
            sb5.append(length2);
            QLog.i("FTSMessageSearchEngine", 2, sb5.toString());
        }
        Bundle bundle = aVar.f426496b;
        if (bundle != null && bundle.containsKey("search_restrict_mem")) {
            aVar.f426496b.getString("search_restrict_mem");
            aVar.f426496b.getString("search_restrict_uin");
            aVar.f426496b.getBoolean("search_restrict_empty");
            aVar.f426496b.getInt("search_restrict_uintype");
            b16 = true;
        } else {
            if (TextUtils.isEmpty(aVar.f426495a)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine, keyword is null");
                }
                return new ArrayList();
            }
            b16 = false;
        }
        if (b16 == false) {
            if (z16) {
                f283238m.clear();
                C.clear();
            } else {
                synchronized (f283238m) {
                    if (!f283238m.keySet().contains(str)) {
                        f283238m.clear();
                    }
                }
                synchronized (C) {
                    if (!C.keySet().contains(str)) {
                        C.clear();
                    } else {
                        ArrayList<FTSEntity> arrayList = C.get(str).get();
                        if (arrayList != null) {
                            int size = arrayList.size();
                            long nanoTime = System.nanoTime();
                            List<ep2.d> q16 = q(str, str, null, z16, arrayList, true);
                            long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
                            long j3 = nanoTime2 + 0;
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("keyNum", String.valueOf(i17));
                            hashMap.put("firstKeyLen", String.valueOf(length));
                            hashMap.put("searchPage", String.valueOf(i3));
                            hashMap.put("useCache", String.valueOf(1));
                            hashMap.put("searchCost", String.valueOf(j3));
                            hashMap.put("singleSearchResultNum", String.valueOf(size));
                            hashMap.put("singleSearchCost", String.valueOf(0L));
                            hashMap.put("groupSortCost", String.valueOf(nanoTime2));
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, j3, 0L, hashMap, null);
                            return q16;
                        }
                    }
                }
            }
        }
        long nanoTime3 = System.nanoTime();
        long nanoTime4 = System.nanoTime();
        long nanoTime5 = System.nanoTime();
        long nanoTime6 = System.nanoTime();
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("queryConversationSize", Integer.toString(0));
        hashMap2.put("resultSize", Integer.toString(0));
        if (str != null) {
            i16 = str.length();
        } else {
            i16 = 0;
        }
        hashMap2.put("keyLength", Integer.toString(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchMessageStatistic_FTS", true, (nanoTime6 - nanoTime4) / 1000000, 0L, hashMap2, null);
        long nanoTime7 = System.nanoTime();
        if (QLog.isColorLevel()) {
            QLog.d("FTSMessageSearchEngine", 2, String.format("fts search,size:%d, refresh time: %dms, query time: %dms, convert time: %dms, report time: %dms", 0, Long.valueOf((nanoTime4 - nanoTime3) / 1000000), Long.valueOf((nanoTime5 - nanoTime4) / 1000000), Long.valueOf((nanoTime6 - nanoTime5) / 1000000), Long.valueOf((nanoTime7 - nanoTime6) / 1000000)));
        }
        if (b16 == false) {
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put("keyNum", String.valueOf(i17));
            hashMap3.put("firstKeyLen", String.valueOf(length));
            hashMap3.put("searchPage", String.valueOf(i3));
            hashMap3.put("useCache", String.valueOf(0));
            hashMap3.put("searchCost", String.valueOf(0L));
            hashMap3.put("singleSearchResultNum", String.valueOf(0));
            hashMap3.put("singleSearchCost", String.valueOf(0L));
            hashMap3.put("groupSortCost", String.valueOf(0L));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, 0L, 0L, hashMap3, null);
            return null;
        }
        return null;
    }

    public List<ep2.c> n(pn2.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
        }
        return new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0339 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x030b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ep2.d> o(pn2.a aVar, boolean z16) {
        int i3;
        boolean z17;
        int i16;
        int i17;
        int i18;
        String str;
        int i19;
        int i26;
        int i27;
        long j3;
        int i28;
        long j16;
        int i29;
        int i36;
        String str2;
        int i37;
        int i38;
        int i39;
        ArrayList arrayList;
        int i46;
        int length;
        if (QLog.isColorLevel()) {
            QLog.d("FTSMessageSearchEngine", 2, "========== search message use FTSMessageSearchEngine");
        }
        String str3 = aVar.f426495a;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("keyword bytes length: ");
            if (str3 == null) {
                length = 0;
            } else {
                length = str3.getBytes().length;
            }
            sb5.append(length);
            QLog.i("FTSMessageSearchEngine", 2, sb5.toString());
        }
        this.f283239d = str3;
        if (TextUtils.isEmpty(str3)) {
            return m(aVar, z16);
        }
        ArrayList<String> l3 = vy2.b.l(str3);
        if (l3.size() != 0 && l3.size() != 1) {
            Bundle bundle = aVar.f426496b;
            if (bundle != null && bundle.containsKey("search_restrict_mem")) {
                return m(aVar, z16);
            }
            int size = l3.size();
            int length2 = l3.get(0).length();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            b.a.f443712a = size;
            b.a.f443713b = length2;
            if (z16) {
                f283238m.clear();
                D.clear();
            } else {
                synchronized (f283238m) {
                    if (!f283238m.keySet().contains(str3)) {
                        f283238m.clear();
                    }
                }
                synchronized (D) {
                    if (!D.keySet().contains(str3)) {
                        D.clear();
                    } else {
                        ArrayList<ep2.d> arrayList2 = D.get(str3).get();
                        if (arrayList2 != null) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("keyNum", String.valueOf(size));
                            hashMap.put("firstKeyLen", String.valueOf(length2));
                            hashMap.put("searchPage", String.valueOf(i3));
                            hashMap.put("useCache", String.valueOf(1));
                            hashMap.put("searchCost", String.valueOf(0L));
                            hashMap.put("andSearchResultNum", String.valueOf(0));
                            hashMap.put("andSearchCost", String.valueOf(0L));
                            hashMap.put("senderSearchResultNum", String.valueOf(0));
                            hashMap.put("senderSearchCost", String.valueOf(0L));
                            hashMap.put("fallSearchResultNum", String.valueOf(0));
                            hashMap.put("fallSearchCost", String.valueOf(0L));
                            hashMap.put("groupSortCost", String.valueOf(0L));
                            hashMap.put("contactSearchCost", String.valueOf(0L));
                            hashMap.put("contactNum", String.valueOf(0));
                            hashMap.put(ComicCancelRedPointPopItemData.JSON_KEY_FRIEND_NUM, String.valueOf(0));
                            hashMap.put("isMyself", String.valueOf(0));
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, 0L, 0L, hashMap, null);
                            return arrayList2;
                        }
                    }
                }
            }
            ArrayList<FTSEntity> arrayList3 = new ArrayList<>();
            long nanoTime = System.nanoTime();
            ArrayList arrayList4 = new ArrayList();
            long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
            int size2 = arrayList4.size();
            long j17 = 0 + nanoTime2;
            if (arrayList4.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!arrayList4.isEmpty()) {
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    FTSEntity fTSEntity = (FTSEntity) it.next();
                    fTSEntity.mSearchScene = 0;
                    ((FTSMessage) fTSEntity).searchStrategy = 2;
                }
                arrayList3.addAll(arrayList4);
                i16 = 1;
            } else {
                i16 = 0;
            }
            String str4 = l3.get(0);
            String trim = str3.substring(str3.indexOf(str4) + str4.length()).trim();
            long nanoTime3 = System.nanoTime();
            ArrayList<b.C11446b> b16 = vy2.b.b(d(), str4);
            long nanoTime4 = (System.nanoTime() - nanoTime3) / 1000000;
            if (b16 != null && !b16.isEmpty()) {
                int size3 = b16.size();
                Iterator<b.C11446b> it5 = b16.iterator();
                int i47 = 0;
                while (it5.hasNext()) {
                    int i48 = it5.next().f443730b;
                    if (i48 == 0 || i48 == 1004) {
                        i47++;
                    }
                }
                i18 = size3;
                i17 = i47;
            } else {
                i17 = 0;
                i18 = 0;
            }
            long j18 = j17 + nanoTime4;
            if (b16 != null && !b16.isEmpty()) {
                int i49 = 0;
                int i56 = 0;
                i27 = 0;
                j3 = 0;
                while (i49 < b16.size()) {
                    String str5 = b16.get(i49).f443729a;
                    int i57 = b16.get(i49).f443730b;
                    ArrayList<b.C11446b> arrayList5 = b16;
                    Pair<CharSequence, CharSequence> pair = b16.get(i49).f443731c;
                    if (TextUtils.equals(d().getCurrentAccountUin(), str5)) {
                        i38 = 1;
                    } else {
                        i38 = i27;
                    }
                    String str6 = trim;
                    if (!TextUtils.equals(str5, d().getCurrentUin()) && vy2.b.e(d()) == 1) {
                        ArrayList arrayList6 = new ArrayList();
                        if (!arrayList6.isEmpty()) {
                            Iterator it6 = arrayList6.iterator();
                            while (it6.hasNext()) {
                                Iterator it7 = it6;
                                FTSEntity fTSEntity2 = (FTSEntity) it6.next();
                                fTSEntity2.mSearchScene = i16;
                                ((FTSMessage) fTSEntity2).searchStrategy = 3;
                                i3 = i3;
                                it6 = it7;
                            }
                            i39 = i3;
                            i16++;
                            arrayList3.addAll(arrayList6);
                            if (i57 != 1 && i57 != 3000 && (i57 == 0 || i57 == 1004)) {
                                long nanoTime5 = System.nanoTime();
                                arrayList = new ArrayList();
                                j3 += (System.nanoTime() - nanoTime5) / 1000000;
                                i56 += arrayList.size();
                                j18 += j3;
                                if (arrayList.isEmpty()) {
                                    Iterator it8 = arrayList.iterator();
                                    while (it8.hasNext()) {
                                        FTSEntity fTSEntity3 = (FTSEntity) it8.next();
                                        fTSEntity3.mSearchScene = i16;
                                        FTSMessage fTSMessage = (FTSMessage) fTSEntity3;
                                        fTSMessage.searchStrategy = 3;
                                        fTSMessage.senderNum = i18;
                                        fTSMessage.friendNum = i17;
                                        if (i38 == 1) {
                                            i46 = 0;
                                        } else {
                                            i46 = i49 + 1;
                                        }
                                        fTSMessage.friendIndex = i46;
                                    }
                                    i16++;
                                    arrayList3.addAll(arrayList);
                                }
                            }
                            i49++;
                            i27 = i38;
                            trim = str6;
                            b16 = arrayList5;
                            i3 = i39;
                        }
                    }
                    i39 = i3;
                    if (i57 != 1) {
                        long nanoTime52 = System.nanoTime();
                        arrayList = new ArrayList();
                        j3 += (System.nanoTime() - nanoTime52) / 1000000;
                        i56 += arrayList.size();
                        j18 += j3;
                        if (arrayList.isEmpty()) {
                        }
                    }
                    i49++;
                    i27 = i38;
                    trim = str6;
                    b16 = arrayList5;
                    i3 = i39;
                }
                str = trim;
                i19 = i3;
                i26 = i56;
            } else {
                str = trim;
                i19 = i3;
                i26 = 0;
                i27 = 0;
                j3 = 0;
            }
            if (!z17 && arrayList3.isEmpty()) {
                long nanoTime6 = System.nanoTime();
                ArrayList arrayList7 = new ArrayList();
                long nanoTime7 = (System.nanoTime() - nanoTime6) / 1000000;
                int size4 = arrayList7.size();
                j18 += nanoTime7;
                if (!arrayList7.isEmpty()) {
                    Iterator it9 = arrayList7.iterator();
                    while (it9.hasNext()) {
                        FTSEntity fTSEntity4 = (FTSEntity) it9.next();
                        fTSEntity4.mSearchScene = i16;
                        ((FTSMessage) fTSEntity4).searchStrategy = 4;
                    }
                    arrayList3.addAll(arrayList7);
                }
                i28 = size4;
                j16 = nanoTime7;
            } else {
                i28 = 0;
                j16 = 0;
            }
            ArrayList arrayList8 = new ArrayList();
            long nanoTime8 = System.nanoTime();
            ArrayList<d> p16 = p(arrayList3);
            long nanoTime9 = (System.nanoTime() - nanoTime8) / 1000000;
            long j19 = j18 + nanoTime9;
            ArrayList<String> l16 = vy2.b.l(str3);
            Iterator<d> it10 = p16.iterator();
            while (it10.hasNext()) {
                d next = it10.next();
                FTSMessage fTSMessage2 = next.f283251a.get(0);
                if (h(d(), String.valueOf(fTSMessage2.uin), fTSMessage2.istroop)) {
                    i36 = i17;
                    str2 = str;
                    i37 = i18;
                    i29 = i28;
                    e eVar = new e(d(), str3, str3, l16, next.f283251a, null, null);
                    eVar.N = next.f283257g;
                    eVar.P = next.f283258h;
                    eVar.Q = next.f283259i;
                    eVar.R = next.f283260j;
                    arrayList8.add(eVar);
                } else {
                    i29 = i28;
                    i36 = i17;
                    str2 = str;
                    i37 = i18;
                }
                i28 = i29;
                i18 = i37;
                i17 = i36;
                str = str2;
            }
            int i58 = i28;
            ConcurrentHashMap<String, Boolean> concurrentHashMap = f283238m;
            Boolean bool = Boolean.TRUE;
            concurrentHashMap.put(str3, bool);
            f283238m.put(str, bool);
            D.put(str3, new SoftReference<>(arrayList8));
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("keyNum", String.valueOf(size));
            hashMap2.put("firstKeyLen", String.valueOf(length2));
            hashMap2.put("searchPage", String.valueOf(i19));
            hashMap2.put("useCache", String.valueOf(0));
            hashMap2.put("searchCost", String.valueOf(j19));
            hashMap2.put("andSearchResultNum", String.valueOf(size2));
            hashMap2.put("andSearchCost", String.valueOf(nanoTime2));
            hashMap2.put("senderSearchResultNum", String.valueOf(i26));
            hashMap2.put("senderSearchCost", String.valueOf(j3));
            hashMap2.put("fallSearchResultNum", String.valueOf(i58));
            hashMap2.put("fallSearchCost", String.valueOf(j16));
            hashMap2.put("groupSortCost", String.valueOf(nanoTime9));
            hashMap2.put("contactSearchCost", String.valueOf(nanoTime4));
            hashMap2.put("contactNum", String.valueOf(i18));
            hashMap2.put(ComicCancelRedPointPopItemData.JSON_KEY_FRIEND_NUM, String.valueOf(i17));
            hashMap2.put("isMyself", String.valueOf(i27));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFtsSearchEvent", true, j19, 0L, hashMap2, null);
            return arrayList8;
        }
        return m(aVar, z16);
    }

    public void g() {
    }

    public void k() {
    }
}
