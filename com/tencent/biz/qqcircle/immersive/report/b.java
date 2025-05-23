package com.tencent.biz.qqcircle.immersive.report;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QFSFirstRenderCostInfoListBean;
import com.tencent.biz.qqcircle.utils.bv;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Integer, Integer> f89704f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<Integer, String> f89705g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile b f89706h;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, List<a>> f89707a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, a> f89708b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Long> f89709c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final c f89710d = new c();

    /* renamed from: e, reason: collision with root package name */
    private final c f89711e = new c();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f89712a = -1;

        /* renamed from: b, reason: collision with root package name */
        private long f89713b = 0;

        /* renamed from: c, reason: collision with root package name */
        private long f89714c = 0;

        /* renamed from: d, reason: collision with root package name */
        private long f89715d = 0;

        public a() {
        }

        public int a() {
            return (int) (this.f89714c - this.f89713b);
        }

        public long b() {
            return this.f89714c;
        }

        public long c() {
            return this.f89715d;
        }

        public long d() {
            return this.f89713b;
        }

        public int e() {
            return this.f89712a;
        }

        public void f(long j3) {
            this.f89714c = j3;
        }

        public void g(long j3) {
            this.f89715d = j3;
        }

        public void h(long j3) {
            this.f89713b = j3;
        }

        public void i(int i3) {
            this.f89712a = i3;
        }

        public String toString() {
            return "QFSFirstRenderInfo{mStartTime=" + this.f89713b + ", mEndTime=" + this.f89714c + ", mFrontTime=" + this.f89715d + "ms}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.report.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0907b {

        /* renamed from: a, reason: collision with root package name */
        public long f89717a;

        /* renamed from: b, reason: collision with root package name */
        public long f89718b;

        /* renamed from: c, reason: collision with root package name */
        public long f89719c;

        /* renamed from: d, reason: collision with root package name */
        public long f89720d;

        public C0907b(long j3, long j16, long j17, long j18) {
            this.f89717a = j3;
            this.f89718b = j16;
            this.f89719c = j17;
            this.f89720d = j18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReference<String> f89721a = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        public final List<a> f89722b = new CopyOnWriteArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final AtomicLong f89723c = new AtomicLong(0);

        /* renamed from: d, reason: collision with root package name */
        public a f89724d;

        /* renamed from: e, reason: collision with root package name */
        public long f89725e;

        c() {
        }

        public void a() {
            try {
                this.f89721a.set("");
                this.f89723c.set(0L);
                this.f89722b.clear();
            } catch (Throwable th5) {
                QLog.d("QFSFirstRenderDetailCollector", 1, "[clear] ex: ", th5);
            }
        }

        public long b() {
            return this.f89725e;
        }

        public List<a> c() {
            return this.f89722b;
        }

        public String d() {
            return this.f89721a.get();
        }

        public a e() {
            return this.f89724d;
        }

        public long f() {
            return this.f89723c.get();
        }

        public boolean g() {
            return this.f89722b.isEmpty();
        }

        public void h(List<a> list) {
            try {
                this.f89722b.clear();
                this.f89722b.addAll(list);
            } catch (Throwable th5) {
                QLog.d("QFSFirstRenderDetailCollector", 1, "[setDataSource] ex: ", th5);
            }
        }

        public void i(long j3) {
            this.f89725e = j3;
        }

        public void j(String str) {
            this.f89721a.set(str);
        }

        public void k(a aVar) {
            this.f89724d = aVar;
        }

        public void l(long j3) {
            this.f89723c.set(j3);
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f89704f = concurrentHashMap;
        concurrentHashMap.put(203, 13);
        concurrentHashMap.put(205, 14);
        concurrentHashMap.put(100, 15);
        concurrentHashMap.put(122, 16);
        concurrentHashMap.put(124, 17);
        concurrentHashMap.put(251, 18);
        concurrentHashMap.put(114, 19);
        concurrentHashMap.put(115, 20);
        concurrentHashMap.put(102, 20);
        concurrentHashMap.put(103, 21);
        concurrentHashMap.put(104, 22);
        concurrentHashMap.put(105, 23);
        concurrentHashMap.put(106, 24);
        concurrentHashMap.put(255, 25);
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        f89705g = concurrentHashMap2;
        concurrentHashMap2.put(1, "EVENT_BUSINESS_URL_EXCHANGE");
        concurrentHashMap2.put(2, "EVENT_BUSINESS_URL_EXCHANGE_ERROR");
        concurrentHashMap2.put(3, "EVENT_BUSINESS_HTTP_ADD_SCENE");
        concurrentHashMap2.put(4, "EVENT_RFW_LOCAL_CHANGE");
        concurrentHashMap2.put(5, "EVENT_RFW_PRELOAD_CHECK");
        concurrentHashMap2.put(6, "EVENT_RFW_URL_SELECTED");
        concurrentHashMap2.put(7, "EVENT_RFW_H264_RESELECTED");
        concurrentHashMap2.put(8, "EVENT_RFW_HTTP_VALID");
        concurrentHashMap2.put(9, "EVENT_RFW_DIRECT_IP");
        concurrentHashMap2.put(10, "EVENT_RFW_SDK_CHECK");
        concurrentHashMap2.put(11, "EVENT_RFW_OPEN_MEDIA_SOURCE");
        concurrentHashMap2.put(12, "EVENT_PLAYER_ACTIVE");
        concurrentHashMap2.put(13, "EVENT_PLAYER_VIDEO_URL_CHANGE");
        concurrentHashMap2.put(14, "EVENT_PLAYER_VIDEO_PROTOCOL_CHANGE");
        concurrentHashMap2.put(15, "EVENT_PLAYER_FIRST_CLIP");
        concurrentHashMap2.put(16, "EVENT_PLAYER_SURFACE_DECODE");
        concurrentHashMap2.put(17, "EVENT_PLAYER_CHANGE_DECODE_FORMAT");
        concurrentHashMap2.put(18, "EVENT_PLAYER_INFO_PCDN_DOWNLOAD_FAILED");
        concurrentHashMap2.put(19, "EVENT_PLAYER_INFO_AUDIO_DECODER_TYPE");
        concurrentHashMap2.put(20, "EVENT_PLAYER_INFO_VIDEO_DECODER_TYPE");
        concurrentHashMap2.put(20, "EVENT_PLAYER_INIT_AUDIO_DECODER");
        concurrentHashMap2.put(21, "EVENT_PLAYER_INIT_VIDEO_DECODER");
        concurrentHashMap2.put(22, "EVENT_PLAYER_DECODE_FIRST_AUDIO");
        concurrentHashMap2.put(23, "EVENT_PLAYER_DECODE_FIRST_VIDEO");
        concurrentHashMap2.put(26, "EVENT_PLAYER_FIRST_RENDER");
        concurrentHashMap2.put(24, "EVENT_PLAYER_FIRST_PACKET_READ");
        concurrentHashMap2.put(25, "EVENT_PLAYER_INFO_NEW_DROP_FRAME");
        concurrentHashMap2.put(27, "EVENT_PLAYER_PLAY_ERROR");
    }

    b() {
    }

    private a a(String str, int i3) {
        List<a> k3 = k(str);
        if (k3 == null) {
            return null;
        }
        a aVar = new a();
        aVar.i(i3);
        k3.add(aVar);
        return aVar;
    }

    private C0907b b(Long l3, Long l16, a aVar, List<a> list) {
        long j3;
        if (list.isEmpty() || l16 == null) {
            return null;
        }
        Pair<StringBuilder, Integer> i3 = i(list);
        if (aVar != null) {
            j3 = aVar.b();
        } else {
            j3 = 0;
        }
        long longValue = l3.longValue() - l16.longValue();
        long longValue2 = l3.longValue();
        if (j3 <= 0) {
            j3 = l3.longValue();
        }
        long j16 = longValue2 - j3;
        return new C0907b(i3.second.intValue(), j16, (longValue - i3.second.intValue()) - j16, longValue);
    }

    private int c(int i3) {
        Integer num = f89704f.get(Integer.valueOf(i3));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private a d(List<a> list, int i3) {
        a aVar = null;
        if (list == null) {
            return null;
        }
        for (a aVar2 : list) {
            if (aVar2.e() == i3) {
                aVar = aVar2;
            }
        }
        return aVar;
    }

    private QFSFirstRenderCostInfoListBean e(long j3, long j16, a aVar, List<a> list) {
        C0907b b16 = b(Long.valueOf(j3), Long.valueOf(j16), aVar, list);
        if (b16 == null) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[getFileCostBean] calculate result should not be null.");
            return null;
        }
        QFSFirstRenderCostInfoListBean qFSFirstRenderCostInfoListBean = new QFSFirstRenderCostInfoListBean();
        ArrayList<QFSFirstRenderCostInfoListBean.QFSFirstRenderCostInfo> arrayList = new ArrayList<>();
        for (a aVar2 : list) {
            QFSFirstRenderCostInfoListBean.QFSFirstRenderCostInfo qFSFirstRenderCostInfo = new QFSFirstRenderCostInfoListBean.QFSFirstRenderCostInfo();
            qFSFirstRenderCostInfo.setType(aVar2.e());
            qFSFirstRenderCostInfo.setCurCost(aVar2.a());
            qFSFirstRenderCostInfo.setFrontCost(aVar2.c());
            arrayList.add(qFSFirstRenderCostInfo);
        }
        qFSFirstRenderCostInfoListBean.setList(arrayList);
        qFSFirstRenderCostInfoListBean.setSceneSumCost(b16.f89717a);
        qFSFirstRenderCostInfoListBean.setLastToPreparedCost(b16.f89718b);
        qFSFirstRenderCostInfoListBean.setOtherCost(b16.f89719c);
        qFSFirstRenderCostInfoListBean.setPrepareCost(b16.f89720d);
        return qFSFirstRenderCostInfoListBean;
    }

    public static b f() {
        if (f89706h == null) {
            synchronized (b.class) {
                if (f89706h == null) {
                    f89706h = new b();
                }
            }
        }
        return f89706h;
    }

    private boolean g(int i3) {
        return !f89704f.containsKey(Integer.valueOf(i3));
    }

    private Pair<StringBuilder, Integer> i(List<a> list) {
        int i3 = 0;
        Pair<StringBuilder, Integer> pair = new Pair<>(new StringBuilder(), 0);
        if (list == null) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[obtainFirstInfoSetResult] first map should not be null.");
            return pair;
        }
        StringBuilder sb5 = new StringBuilder();
        int size = list.size();
        int i16 = 0;
        for (a aVar : list) {
            long a16 = aVar.a() + aVar.c();
            i3 = (int) (i3 + a16);
            sb5.append("[");
            sb5.append("type:");
            sb5.append(aVar.e());
            sb5.append(",");
            sb5.append("fc:");
            sb5.append(aVar.c());
            sb5.append("ms,");
            sb5.append("cc:");
            sb5.append(aVar.a());
            sb5.append("ms,");
            sb5.append("cs:");
            sb5.append(a16);
            sb5.append("ms");
            sb5.append("]");
            if (i16 == size - 1) {
                sb5.append(".");
            } else {
                sb5.append("|");
            }
            i16++;
        }
        return new Pair<>(sb5, Integer.valueOf(i3));
    }

    private List<a> k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f89707a.get(str);
    }

    private void l(String str, String str2, C0907b c0907b) {
        if (c0907b == null) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[" + str + "] result should not be null.");
            return;
        }
        QLog.d("QFSFirstRenderDetailCollector", 1, "[" + str + "] fileId:" + str2 + " | prepareCost: " + c0907b.f89720d + "ms | sceneSumCost: " + c0907b.f89717a + "ms | lastToPreparedCost: " + c0907b.f89718b + "ms | otherCost: " + c0907b.f89719c + "ms");
    }

    private void m(String str, List<a> list) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[putFirstRenderInfoVal] current file id should not be null.");
        } else {
            this.f89707a.put(str, list);
        }
    }

    private void n(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordInfoToPreRenderMap] current filed id should not be null.");
        } else if (aVar == null) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordInfoToPreRenderMap] current info should not be null.");
        } else {
            this.f89708b.put(str, aVar);
        }
    }

    private void w(List<a> list, String str, Long l3, a aVar, long j3) {
        if (this.f89710d.g()) {
            this.f89710d.h(list);
            this.f89710d.j(str);
            this.f89710d.l(l3.longValue());
            this.f89710d.k(aVar);
            this.f89710d.i(j3);
        }
        this.f89711e.h(list);
        this.f89711e.j(str);
        this.f89711e.l(l3.longValue());
        this.f89711e.k(aVar);
        this.f89711e.i(j3);
    }

    public QFSFirstRenderCostInfoListBean h() {
        long b16;
        if (this.f89711e.g()) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[obtainCurrentPlayBean] current source is empty.");
            return null;
        }
        try {
            long j3 = 0;
            if (this.f89711e.b() == 0) {
                b16 = System.currentTimeMillis();
            } else {
                b16 = this.f89711e.b();
            }
            QFSFirstRenderCostInfoListBean e16 = e(b16, this.f89711e.f(), this.f89711e.e(), this.f89711e.c());
            int i3 = RFWLog.USR;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[obtainCurrentPlayBean] fileId: ");
            sb5.append(this.f89711e.d());
            sb5.append(" | prepareCost: ");
            if (e16 != null) {
                j3 = e16.getPrepareCost();
            }
            sb5.append(j3);
            objArr[0] = sb5.toString();
            RFWLog.d("QFSFirstRenderDetailCollector", i3, objArr);
            return e16;
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[obtainCurrentFileId] ex: ", th5);
            return null;
        }
    }

    public QFSFirstRenderCostInfoListBean j(String str) {
        long b16;
        if (!this.f89710d.g() && TextUtils.equals(this.f89710d.d(), str)) {
            try {
                long j3 = 0;
                if (this.f89710d.b() == 0) {
                    b16 = System.currentTimeMillis();
                } else {
                    b16 = this.f89710d.b();
                }
                QFSFirstRenderCostInfoListBean e16 = e(b16, this.f89710d.f(), this.f89710d.e(), this.f89710d.c());
                int i3 = RFWLog.USR;
                Object[] objArr = new Object[1];
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[obtainFirstPlayCostBean] fileId: ");
                sb5.append(str);
                sb5.append(" | prepareCost: ");
                if (e16 != null) {
                    j3 = e16.getPrepareCost();
                }
                sb5.append(j3);
                objArr[0] = sb5.toString();
                RFWLog.d("QFSFirstRenderDetailCollector", i3, objArr);
                return e16;
            } catch (Throwable th5) {
                RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[obtainFirstPlayCostBean] ex: ", th5);
            }
        }
        return null;
    }

    public void o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayFirstPrepared] filed id should not be null.");
                return;
            }
            List<a> k3 = k(str);
            if (k3 != null && !k3.isEmpty()) {
                Long l3 = this.f89709c.get(str);
                if (l3 == null) {
                    RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayFirstPrepared] preparedTimeMillis == null.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = this.f89708b.get(str);
                l("recordPlayFirstPrepared", str, b(Long.valueOf(currentTimeMillis), l3, aVar, k3));
                w(k(str), str, l3, aVar, currentTimeMillis);
                t(str);
                return;
            }
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayFirstPrepared] first map should not be null. fileId: " + str);
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayFirstPrepared] ex: ", th5);
        }
    }

    public void p(String str, int i3, int i16, int i17, String str2) {
        try {
            List<a> k3 = k(str);
            if (k3 != null && !k3.isEmpty()) {
                RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayerError] fileId: " + str + " | module: " + i3 + " | errorType: " + i16 + " | errorCode: " + i17 + " | extraInfo: " + str2);
                a a16 = a(str, 27);
                if (a16 == null) {
                    return;
                }
                a16.h(System.currentTimeMillis());
                a16.f(System.currentTimeMillis());
                n(str, a16);
            }
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayerError] error: ", th5);
        }
    }

    public void q(String str, int i3, long j3, long j16, Object obj) {
        if (!this.f89707a.containsKey(str)) {
            return;
        }
        if (g(i3)) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayerInfo] illegality type, fileId: " + str + " | what: " + i3 + " | arg1: " + j3 + " | arg2: " + j16 + " | json: " + bv.b(obj));
            return;
        }
        try {
            int c16 = c(i3);
            if (c16 == -1) {
                return;
            }
            d(k(str), c16);
            a a16 = a(str, c16);
            if (a16 == null) {
                return;
            }
            a aVar = this.f89708b.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar != null) {
                currentTimeMillis = aVar.b();
            }
            a16.h(currentTimeMillis);
            a16.f(System.currentTimeMillis());
            n(str, a16);
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordPlayerInfo] error: ", th5);
        }
    }

    public void r(String str, int i3) {
        try {
            List<a> k3 = k(str);
            if (k3 == null) {
                return;
            }
            a d16 = d(k3, i3);
            if (d16 == null) {
                RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordTypeEnd] render info should not be null.");
                return;
            }
            if (d16.d() <= 0) {
                d16.h(System.currentTimeMillis());
            }
            d16.f(System.currentTimeMillis());
            n(str, d16);
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordTypeEnd] error: ", th5);
        }
    }

    public void s(String str, int i3) {
        Long l3;
        try {
            a a16 = a(str, i3);
            if (a16 == null) {
                return;
            }
            a aVar = this.f89708b.get(str);
            if (aVar != null) {
                a16.g(System.currentTimeMillis() - aVar.b());
            }
            if (this.f89708b.isEmpty() && (l3 = this.f89709c.get(str)) != null) {
                a16.g(System.currentTimeMillis() - l3.longValue());
            }
            a16.i(i3);
            a16.h(System.currentTimeMillis());
            a16.f(System.currentTimeMillis());
            n(str, a16);
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[recordTypeStart] error: ", th5);
        }
    }

    public void t(String str) {
        try {
            if (!this.f89707a.containsKey(str)) {
                return;
            }
            this.f89707a.remove(str);
            this.f89708b.remove(str);
            this.f89709c.remove(str);
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[removeFirstRenderInfo] fileId: " + str);
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[removeFirstRenderInfo] ex: ", th5);
        }
    }

    public void u() {
        this.f89710d.a();
    }

    public void v(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[resetPlayRecord] filed id should not be null.");
                return;
            }
            this.f89711e.a();
            if (this.f89707a.containsKey(str)) {
                List<a> list = this.f89707a.get(str);
                Long l3 = this.f89709c.get(str);
                if (l3 == null) {
                    RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[resetPlayRecord] preparedTimeMillis == null.");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = this.f89708b.get(str);
                l("resetPlayRecord", str, b(Long.valueOf(currentTimeMillis), l3, aVar, list));
                w(list, str, l3, aVar, currentTimeMillis);
                t(str);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            QLog.d("QFSFirstRenderDetailCollector", 1, "[resetPlayRecord] file id: " + str + " start first play, startTime: " + currentTimeMillis2);
            m(str, new ArrayList());
            this.f89709c.put(str, Long.valueOf(currentTimeMillis2));
        } catch (Throwable th5) {
            RFWLog.d("QFSFirstRenderDetailCollector", RFWLog.USR, "[resetPlayRecord] error: ", th5);
        }
    }
}
