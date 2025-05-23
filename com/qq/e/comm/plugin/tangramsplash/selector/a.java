package com.qq.e.comm.plugin.tangramsplash.selector;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.u;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.ArrayUtilStub;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.PreCacheSplashAd;
import com.qq.e.tg.splash.TGSplashBackupOrderHolder;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.could.huiyansdk.exception.CallbackErrorCode;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.light.LightConstants;
import ot.d;
import ot.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, List<r>> f40309a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final c.b f40310b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0294a f40311c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f40312d;

    /* renamed from: e, reason: collision with root package name */
    private long f40313e;

    /* renamed from: f, reason: collision with root package name */
    private ADListener f40314f;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.tangramsplash.selector.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0294a {
        void a(String str, int i3, int i16);

        void a(String str, r rVar);
    }

    public a(c.b bVar, boolean z16, InterfaceC0294a interfaceC0294a) {
        this.f40310b = bVar;
        this.f40312d = z16;
        this.f40311c = interfaceC0294a;
    }

    private void b(List<r> list, int i3) {
        if (ArrayUtilStub.isNullOrEmpty(list)) {
            GDTLogger.e("PreCacheSelector [preparePreloadDataByDate] error invalid datas");
            return;
        }
        boolean z16 = false;
        if (!this.f40312d) {
            GDTLogger.i("PreCacheSelector[preparePreloadDataByDate] cold start clearPreCacheData.");
            TGSplashPreCacheUtil.clearPreCacheData(false);
        }
        c.b bVar = this.f40310b;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1320054, bVar != null ? bVar.f40335b : null, (r) null, i3);
        Map<String, List<r>> map = f40309a;
        if (map != null) {
            map.clear();
        }
        for (r rVar : list) {
            if (rVar != null) {
                if (com.qq.e.comm.plugin.j.c.a("checkSplashAdModeBeforeSelect", 1, 1) && !b.a(rVar)) {
                    GDTLogger.e("not support this ad mode:" + rVar.bP());
                    c.b bVar2 = this.f40310b;
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(13100210, bVar2 != null ? bVar2.f40335b : null, rVar, i3);
                } else {
                    if (rVar.bk() && !z16) {
                        a(rVar, i3);
                        z16 = true;
                    }
                    List<u> bs5 = rVar.bs();
                    if (!ArrayUtilStub.isNullOrEmpty(bs5)) {
                        for (u uVar : bs5) {
                            if (uVar != null) {
                                String a16 = uVar.a();
                                if (f40309a.containsKey(a16)) {
                                    List<r> list2 = f40309a.get(a16);
                                    if (list2 == null) {
                                        list2 = new ArrayList<>();
                                        f40309a.put(a16, list2);
                                    }
                                    if (a(list2, rVar)) {
                                        GDTLogger.i("PreCacheSelector [preparePreloadDataByDate] add " + rVar.f() + " to " + a16);
                                    }
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(rVar);
                                    f40309a.put(a16, arrayList);
                                }
                            }
                        }
                    }
                }
            }
        }
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.a(f40309a);
    }

    public void a(ADListener aDListener) {
        this.f40314f = aDListener;
    }

    private boolean a(List<r> list, r rVar) {
        boolean z16;
        if (!ArrayUtilStub.isNullOrEmpty(list) && rVar != null) {
            Iterator<r> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                r next = it.next();
                if (next != null && !TextUtils.isEmpty(next.bn()) && next.bn().equals(rVar.bn())) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                list.add(rVar);
                return true;
            }
        }
        return false;
    }

    public void a(List<r> list, int i3) {
        GDTLogger.i("startSelect from :" + i3);
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100100, this.f40310b, (r) null, i3);
        this.f40313e = System.currentTimeMillis();
        synchronized (a.class) {
            try {
                b(list, i3);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
                a((String) null, LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT, this.f40313e, i3);
                return;
            }
        }
        if (f40309a.size() > 0) {
            for (String str : f40309a.keySet()) {
                if (!TextUtils.isEmpty(str) && !ArrayUtilStub.isNullOrEmpty(f40309a.get(str))) {
                    a(str, i3);
                }
            }
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100101, this.f40310b, (r) null, i3);
        a((String) null, LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT, this.f40313e, i3);
    }

    private void a(final String str, final int i3) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100102, this.f40310b, (r) null, i3);
        final long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("FusionAd\uff0cdate null");
            a(str, -601, currentTimeMillis, i3);
            return;
        }
        com.tencent.ams.fusion.service.b b16 = com.tencent.ams.fusion.service.b.b();
        e o16 = b16 != null ? b16.o() : null;
        if (o16 == null) {
            GDTLogger.e("FusionAd\uff0cservice null");
            a(str, -602, currentTimeMillis, i3);
            return;
        }
        com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a aVar = new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.b.a();
        c.b bVar = this.f40310b;
        if (bVar != null) {
            aVar.f40021j = str;
            aVar.f40020i = bVar.f40334a;
            String str2 = bVar.f40335b;
            aVar.f40019h = str2;
            int d16 = this.f40312d ? f.d(str2) : f.c(str2);
            aVar.f40017f = d16;
            aVar.f40018g = d16;
            HashMap hashMap = new HashMap();
            hashMap.put("splashPreloadGap", Integer.valueOf(this.f40310b.f40340g));
            hashMap.put("fetch_ad_only", Boolean.valueOf(this.f40310b.f40339f));
            aVar.f40022k = hashMap;
            LoadAdParams loadAdParams = this.f40310b.f40338e;
            if (loadAdParams != null) {
                aVar.f40013b = loadAdParams.getFilterOneShotFlag();
            }
            aVar.f40028q = f.e(this.f40310b.f40335b);
        }
        boolean z16 = this.f40312d;
        aVar.f40012a = z16;
        aVar.f40014c = z16;
        aVar.f40016e = Integer.MAX_VALUE;
        aVar.f40023l = this.f40313e;
        GDTLogger.d("FusionAd\uff0cselect :" + str);
        o16.c(aVar, new ot.a() { // from class: com.qq.e.comm.plugin.tangramsplash.selector.a.1
            @Override // ot.a
            public void a(pt.a aVar2) {
            }

            @Override // ot.a
            public void a(d dVar) {
                if (dVar == null || dVar.d() == -1) {
                    a.this.a(str, CallbackErrorCode.HY_INNER_TURING_NOT_CREATE, currentTimeMillis, i3);
                } else {
                    GDTLogger.d("FusionAd\uff0conSelectFinish type :" + dVar.d() + ", cost time :" + dVar.c() + ", from :" + i3 + ", date :" + str);
                    List<SplashOrder> a16 = dVar.a();
                    if (g.b(a16)) {
                        a.this.a(str, CallbackErrorCode.HY_INNER_TURING_NOT_CREATE, currentTimeMillis, i3);
                    } else {
                        for (SplashOrder splashOrder : a16) {
                            if (splashOrder != null) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("\u5355\u5929\u672c\u5730\u9009\u5355\u6210\u529f cl:");
                                sb5.append(splashOrder.f());
                                sb5.append(", uoid :");
                                sb5.append(splashOrder.bn());
                                sb5.append(", from :");
                                sb5.append(i3);
                                sb5.append(", date :");
                                sb5.append(str);
                                sb5.append(", isHotStart :");
                                sb5.append(a.this.f40310b != null && com.qq.e.comm.plugin.tangramsplash.d.a.a(a.this.f40310b.f40338e));
                                sb5.append(", pvlimit :");
                                sb5.append(splashOrder.bd());
                                sb5.append(", showtimes :");
                                sb5.append(i.a(splashOrder));
                                GDTLogger.i(sb5.toString());
                            }
                        }
                        if (i3 == 4) {
                            if (a.this.f40310b != null && com.qq.e.comm.plugin.tangramsplash.d.a.a(a.this.f40310b.f40338e)) {
                                a.this.a(a16, str, currentTimeMillis);
                            } else {
                                a(dVar, a16);
                            }
                        } else {
                            a(dVar, a16);
                        }
                    }
                }
                com.qq.e.comm.plugin.g.a.c.a();
            }

            private void a(d dVar, List<SplashOrder> list) {
                if (list == null) {
                    return;
                }
                for (SplashOrder splashOrder : list) {
                    if (splashOrder != null) {
                        a.this.a(dVar, splashOrder, str, i3, currentTimeMillis);
                    }
                }
            }

            @Override // ot.a
            public void b(pt.a aVar2) {
            }

            @Override // ot.a
            public void c(pt.a aVar2) {
            }

            @Override // ot.a
            public void d(pt.a aVar2) {
            }
        });
    }

    private void b(List<SplashOrder> list, String str, long j3) {
        if (!TextUtils.isEmpty(str) && !g.b(list)) {
            ArrayList arrayList = new ArrayList();
            for (SplashOrder splashOrder : list) {
                if (splashOrder instanceof r) {
                    r rVar = (r) splashOrder;
                    PreCacheSplashAd a16 = a(rVar, str);
                    if (a16 != null) {
                        TGSplashPreCacheUtil.fetchPreloadData(GDTADManager.getInstance().getAppContext(), a16.getPosId(), a16, true);
                        arrayList.add(a16);
                    }
                    a(str, rVar, j3, 4);
                }
            }
            if (g.b(arrayList)) {
                GDTLogger.e("[buildPreCacheAdListAndSave] error no ad");
                a(str, CallbackErrorCode.HY_INNER_TURING_INTERFACE_IS_NULL, j3, 4);
                return;
            }
            GDTLogger.i("[buildPreCacheAdListAndSave] ready to save :" + str);
            TGSplashBackupOrderHolder.getInstance().cacheOrderListByDate(arrayList, str);
            return;
        }
        GDTLogger.e("[buildPreCacheAdListAndSave] error no data");
    }

    private String b(r rVar) {
        if (rVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(rVar.bs());
        if (ArrayUtilStub.isNullOrEmpty(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<u>() { // from class: com.qq.e.comm.plugin.tangramsplash.selector.a.2
            /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int compare(u uVar, u uVar2) {
                Date date;
                if (uVar == null && uVar2 == null) {
                    return 0;
                }
                if (uVar != null && uVar2 != null) {
                    String a16 = uVar.a();
                    String a17 = uVar2.a();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                    Date date2 = null;
                    try {
                        date = simpleDateFormat.parse(a16);
                    } catch (Throwable th5) {
                        th = th5;
                        date = null;
                    }
                    try {
                        date2 = simpleDateFormat.parse(a17);
                    } catch (Throwable th6) {
                        th = th6;
                        GDTLogger.e("caculateMaxExposureDate error:", th);
                        if (date != null) {
                        }
                        if (date == null) {
                        }
                        if (date != null) {
                        }
                    }
                    if (date != null && date2 == null) {
                        return 0;
                    }
                    if (date == null && date2 != null) {
                        return date.compareTo(date2);
                    }
                    if (date != null) {
                        return 1;
                    }
                    return -1;
                }
                if (uVar == null) {
                    return 1;
                }
                return -1;
            }
        });
        u uVar = (u) arrayList.get(arrayList.size() - 1);
        if (uVar != null) {
            return uVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<SplashOrder> list, String str, long j3) {
        List<SplashOrder> a16 = a(list);
        if (g.a(a16)) {
            list = a16;
        }
        b(list, str, j3);
        long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100300, this.f40310b, (r) null, 4);
        SplashOrder a17 = a(str, list, currentTimeMillis);
        if (a17 instanceof r) {
            r rVar = (r) a17;
            PreCacheSplashAd a18 = a(rVar, str);
            TGSplashPreCacheUtil.fetchPreloadData(GDTADManager.getInstance().getAppContext(), a18.getPosId(), a18, true);
            GDTLogger.i("[recordHotLaunchResultsToMemory] find backup :" + str + " uoid :" + a18.getUoid() + " aid :" + a18.getAid());
            HashMap hashMap = new HashMap();
            hashMap.put("date", str);
            hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            c.b bVar = this.f40310b;
            if (bVar != null) {
                hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
            }
            c.b bVar2 = this.f40310b;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(13100301, bVar2 != null ? bVar2.f40335b : null, rVar, hashMap);
            TGSplashBackupOrderHolder.getInstance().cacheBackupOrder(a18);
            ADListener aDListener = this.f40314f;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(4, new Object[]{a18}));
            }
        }
    }

    private List<SplashOrder> a(List<SplashOrder> list) {
        c.b bVar = this.f40310b;
        List<SplashOrder> list2 = null;
        if (bVar != null && bVar.f40338e != null && g.a(list)) {
            List<String> blackAidList = this.f40310b.f40338e.getBlackAidList();
            if (!g.a(blackAidList)) {
                return null;
            }
            list2 = new ArrayList<>(list);
            for (String str : blackAidList) {
                if (!TextUtils.isEmpty(str)) {
                    for (SplashOrder splashOrder : list) {
                        if (splashOrder != null && TextUtils.equals(splashOrder.f(), str)) {
                            GDTLogger.e("[recordHotLaunchResultsToMemory] hit blacklist remove from ad list:" + str);
                            list2.remove(splashOrder);
                        }
                    }
                }
            }
        }
        return list2;
    }

    private PreCacheSplashAd a(r rVar, String str) {
        if (rVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        PreCacheSplashAd.Builder effectTimes = new PreCacheSplashAd.Builder().setUoid(rVar.bn()).setPosId(rVar.s()).setDate(str).setAid(rVar.f()).setImg(rVar.h()).setIconZipUrl(rVar.ch()).setCollisionAnimationUrl(rVar.ci()).setVideo(TextUtils.isEmpty(rVar.bt()) ? rVar.x() : rVar.bt()).setVideoFirstFrameUrl(rVar.ag()).setTimeLife(!TextUtils.isEmpty(rVar.x()) ? rVar.bN() : rVar.bq()).setValidTimeDuration(a(rVar)).setGotDataTimeMillis(rVar.az() == 1 ? this.f40313e : 0L).setEffectTimes(rVar.F(str));
        rVar.F(str);
        return effectTimes.build();
    }

    private Pair<Long, Long> a(r rVar) {
        Pair<Long, Long> pair;
        if (rVar == null) {
            return null;
        }
        if (rVar.av() != 0) {
            long j3 = this.f40313e;
            pair = new Pair<>(Long.valueOf(j3), Long.valueOf((rVar.av() * 60000) + j3));
        } else {
            List<Pair<Integer, Integer>> F = rVar.F(TGSplashPreCacheUtil.getTodayDate());
            if (!g.a(F) || F.get(0) == null) {
                return null;
            }
            long intValue = ((Integer) F.get(0).first).intValue() * 60000;
            long intValue2 = ((Integer) F.get(0).second).intValue() * 60000;
            Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
            calendar.set(14, 0);
            long timeInMillis = calendar.getTimeInMillis();
            GDTLogger.d("[calculateValidTimeDuration] current:" + System.currentTimeMillis());
            GDTLogger.d("[calculateValidTimeDuration] pair 1:" + timeInMillis + intValue);
            GDTLogger.d("[calculateValidTimeDuration] pair 2:" + timeInMillis + intValue2);
            pair = new Pair<>(Long.valueOf(intValue + timeInMillis), Long.valueOf(timeInMillis + intValue2));
        }
        return pair;
    }

    private SplashOrder a(String str, List<SplashOrder> list, long j3) {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(str) && !g.b(list)) {
            if (!str.equals(com.qq.e.comm.plugin.tangramsplash.d.a.b())) {
                GDTLogger.e("[selectBackupOrder] not today");
                i3 = -2;
            } else {
                SplashOrder[] splashOrderArr = new SplashOrder[4];
                Iterator<SplashOrder> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SplashOrder next = it.next();
                    if (next != null && !next.bk() && next.aA()) {
                        if (next.az() == 1 && next.av() == 0 && splashOrderArr[0] == null) {
                            splashOrderArr[0] = next;
                            break;
                        }
                        List<Pair<Integer, Integer>> F = next.F(str);
                        if (next.az() == 0 && !g.b(F)) {
                            for (Pair<Integer, Integer> pair : F) {
                                if (pair != null && ((Integer) pair.first).intValue() == 0 && ((Integer) pair.second).intValue() == 1440) {
                                    if (splashOrderArr[1] == null) {
                                        splashOrderArr[1] = next;
                                    } else {
                                        GDTLogger.e("[selectBackupOrder] ordersWithPriority already has 2 Priority");
                                    }
                                }
                            }
                        }
                        if (next.az() == 1 && next.av() != 0) {
                            if (splashOrderArr[2] == null) {
                                splashOrderArr[2] = next;
                            } else {
                                GDTLogger.e("[selectBackupOrder] ordersWithPriority already has 3 Priority");
                            }
                        }
                        if (next.az() == 0 && !g.b(F)) {
                            for (Pair<Integer, Integer> pair2 : F) {
                                if (pair2 != null && (((Integer) pair2.first).intValue() != 0 || ((Integer) pair2.second).intValue() != 1440)) {
                                    if (splashOrderArr[3] == null) {
                                        splashOrderArr[3] = next;
                                    } else {
                                        GDTLogger.e("[selectBackupOrder] ordersWithPriority already has 4 Priority");
                                    }
                                }
                            }
                        }
                    }
                }
                for (i16 = 0; i16 < 4; i16++) {
                    SplashOrder splashOrder = splashOrderArr[i16];
                    if (splashOrder != null) {
                        GDTLogger.i("[selectBackupOrder] choose level :" + (i16 + 1));
                        return splashOrder;
                    }
                }
                i3 = Integer.MIN_VALUE;
            }
        } else {
            GDTLogger.e("[selectBackupOrder] error no data");
            i3 = -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("date", str);
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j3));
        hashMap.put("error_code", Integer.valueOf(i3));
        c.b bVar = this.f40310b;
        if (bVar != null) {
            hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
        }
        c.b bVar2 = this.f40310b;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100302, bVar2 != null ? bVar2.f40335b : null, (r) null, hashMap);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, SplashOrder splashOrder, String str, int i3, long j3) {
        if (dVar == null || splashOrder == null) {
            return;
        }
        r rVar = splashOrder instanceof r ? (r) splashOrder : null;
        if (rVar != null) {
            GDTLogger.d("FusionAd\uff0cselect succ :" + rVar.f());
            if (!rVar.bk()) {
                TGSplashPreCacheUtil.updatePreCacheInfo(a(rVar, str), rVar.F(str));
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1320052, rVar.s(), (r) null, i3);
            }
            a(str, rVar, j3, i3);
            return;
        }
        if (dVar instanceof com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) {
            a(str, ((com.tencent.ams.fusion.service.splash.c.a.a.c.b.a) dVar).l(), j3, i3);
        } else {
            a(str, CallbackErrorCode.HY_INNER_TURING_NOT_CREATE, j3, i3);
        }
    }

    private void a(r rVar, int i3) {
        GDTLogger.i("[saveEmptyOrderInfo] from :" + i3);
        PreCacheSplashAd build = new PreCacheSplashAd.Builder().setApUrl(rVar.j()).setPosId(rVar.s()).setMaxExposureDate(b(rVar)).build();
        if (i3 == 4) {
            TGSplashBackupOrderHolder.getInstance().cacheEmptyOrder(build);
        } else {
            TGSplashPreCacheUtil.updatePreCacheInfo(build, null);
        }
    }

    private void a(String str, r rVar, long j3, int i3) {
        InterfaceC0294a interfaceC0294a = this.f40311c;
        if (interfaceC0294a != null) {
            interfaceC0294a.a(str, rVar);
        }
        if (rVar != null) {
            int i16 = rVar.bk() ? 13100104 : 13100103;
            HashMap hashMap = new HashMap();
            hashMap.put("date", str);
            hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j3));
            hashMap.put("error_code", Integer.valueOf(i3));
            c.b bVar = this.f40310b;
            if (bVar != null) {
                hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
            }
            c.b bVar2 = this.f40310b;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(i16, bVar2 != null ? bVar2.f40335b : null, rVar, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i3, long j3, int i16) {
        InterfaceC0294a interfaceC0294a = this.f40311c;
        if (interfaceC0294a != null) {
            interfaceC0294a.a(str, i3, i16);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("date", str);
        hashMap.put("cost_time", Long.valueOf(System.currentTimeMillis() - j3));
        hashMap.put("error_code", Integer.valueOf(i3));
        hashMap.put("code", Integer.valueOf(i16));
        c.b bVar = this.f40310b;
        if (bVar != null) {
            hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
        }
        c.b bVar2 = this.f40310b;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(13100105, bVar2 != null ? bVar2.f40335b : null, (r) null, hashMap);
    }
}
