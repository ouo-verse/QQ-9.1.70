package com.qzone.feed.business.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.business.model.e;
import com.qzone.feed.business.service.QZoneRapidCommentService;
import com.qzone.util.al;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.qzone.widget.u;
import com.qzone.widget.v;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RapidCommentDataManager implements Handler.Callback {
    public static final String D = RapidCommentDataManager.class.toString();
    public static int E = 0;
    public static int F = 0;
    private static final al<RapidCommentDataManager, Void> G = new a();

    /* renamed from: d, reason: collision with root package name */
    private SparseIntArray f47110d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<ArrayList<Long>> f47111e;

    /* renamed from: f, reason: collision with root package name */
    private int f47112f;

    /* renamed from: i, reason: collision with root package name */
    private v f47114i;

    /* renamed from: h, reason: collision with root package name */
    private Handler f47113h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<b> f47115m = new ArrayList<>();
    private final Object C = new Object();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<RapidCommentDataManager, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RapidCommentDataManager a(Void r16) {
            return new RapidCommentDataManager();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ArrayList arrayList;
        synchronized (this.C) {
            arrayList = new ArrayList(this.f47115m);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        v vVar = this.f47114i;
        int i3 = 0;
        if (vVar == null || vVar.rapidCommentTabInfoList == null) {
            return 0;
        }
        int i16 = 0;
        while (true) {
            v vVar2 = this.f47114i;
            if (i3 >= vVar2.rcTabNum) {
                return i16;
            }
            u uVar = vVar2.rapidCommentTabInfoList.get(i3);
            if (uVar != null && C(uVar.rcTabId)) {
                i16++;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
            this.f47113h.post(new Runnable() { // from class: com.qzone.feed.business.model.RapidCommentDataManager.3
                @Override // java.lang.Runnable
                public void run() {
                    RapidCommentDataManager.this.z();
                    RapidCommentDataManager.this.B();
                }
            });
        } else {
            z();
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(final int i3) {
        if (Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
            this.f47113h.post(new Runnable() { // from class: com.qzone.feed.business.model.RapidCommentDataManager.4
                @Override // java.lang.Runnable
                public void run() {
                    RapidCommentDataManager.this.A(i3);
                    RapidCommentDataManager.this.B();
                }
            });
        } else {
            A(i3);
            B();
        }
    }

    private String l(long j3) {
        return QZoneRapidCommentService.v().t(j3);
    }

    public static RapidCommentDataManager n() {
        return G.get(null);
    }

    public void A(int i3) {
        v vVar = this.f47114i;
        if (vVar == null || vVar.rapidCommentTabInfoList == null || i3 <= 0) {
            return;
        }
        this.f47110d = new SparseIntArray();
        this.f47111e = new SparseArray<>();
        this.f47112f = 0;
        int i16 = E - 1;
        int i17 = 0;
        while (i17 < F) {
            this.f47110d.put(i17, i17);
            i17++;
        }
        int i18 = this.f47114i.rcTabNum;
        if (i3 > i18) {
            i3 = i18;
        }
        for (int i19 = 0; i19 < i3; i19++) {
            u uVar = this.f47114i.rapidCommentTabInfoList.get(i19);
            ArrayList<Long> arrayList = uVar.rcExpressionList;
            if (arrayList == null) {
                QZLog.e(D, "initPages, rapidCommentTabInfo.rcExpressionList is null");
            } else {
                i16++;
                uVar.tabIndex = i16;
                uVar.tabPageCount = arrayList.size();
                int i26 = this.f47112f;
                int i27 = F;
                uVar.pageBeginIndex = i26 + i27;
                uVar.pageEndIndex = i27 + i26;
                this.f47112f = i26 + 1;
                this.f47110d.put(i17, i16);
                this.f47111e.put(i17, uVar.rcExpressionList);
                i17++;
            }
        }
    }

    public boolean C(long j3) {
        return QZoneRapidCommentService.v().A(j3);
    }

    public void E() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.feed.business.model.RapidCommentDataManager.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (QZoneRapidCommentService.M == 1) {
                    if (RapidCommentDataManager.this.f47114i != null && RapidCommentDataManager.this.D() >= RapidCommentDataManager.this.f47114i.rcTabNum) {
                        u5.b.q0("hasLoadRapidCommentNum", RapidCommentDataManager.this.f47114i.rcTabNum);
                        RapidCommentDataManager.this.F();
                        return;
                    }
                    int G2 = u5.b.G("hasLoadRapidCommentNum", 0);
                    RapidCommentDataManager.this.f47114i = QZoneRapidCommentService.v().x();
                    if (QLog.isColorLevel()) {
                        QLog.d(RapidCommentDataManager.D, 2, "mTabList=" + RapidCommentDataManager.this.f47114i);
                    }
                    if (RapidCommentDataManager.this.f47114i != null && RapidCommentDataManager.this.f47114i.rapidCommentTabInfoList != null && !RapidCommentDataManager.this.f47114i.rapidCommentTabInfoList.isEmpty()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(RapidCommentDataManager.D, 2, "load data from cache");
                        }
                        int i16 = G2 + 1;
                        long I = u5.b.I("recom_tab_id", -1L);
                        if (I != -1) {
                            Iterator<u> it = RapidCommentDataManager.this.f47114i.rapidCommentTabInfoList.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                i3++;
                                if (I == it.next().rcTabId) {
                                    break;
                                }
                            }
                        } else {
                            i3 = 0;
                        }
                        e.c().f47156a = false;
                        int i17 = QZoneRapidCommentService.N;
                        if (i3 > i17 && i16 <= i3) {
                            RapidCommentDataManager.this.G(i3);
                            QZoneRapidCommentService.v().H(1);
                            e c16 = e.c();
                            Objects.requireNonNull(c16);
                            e.c().b(new e.a(RapidCommentDataManager.this.f47114i, true, false, i3));
                            e.c().g();
                            return;
                        }
                        if (i16 < i17) {
                            RapidCommentDataManager.this.G(i17);
                            QZoneRapidCommentService.v().H(1);
                            e c17 = e.c();
                            Objects.requireNonNull(c17);
                            e.c().b(new e.a(RapidCommentDataManager.this.f47114i, true, false, i17));
                            e.c().g();
                        } else {
                            i17 = RapidCommentDataManager.this.f47114i.rcTabNum;
                            RapidCommentDataManager.this.G(i17);
                            QZoneRapidCommentService.v().H(1);
                            for (int i18 = 0; i18 < i17; i18++) {
                                RapidCommentDataManager rapidCommentDataManager = RapidCommentDataManager.this;
                                if (!rapidCommentDataManager.C(rapidCommentDataManager.f47114i.rapidCommentTabInfoList.get(i18).rcTabId)) {
                                    e c18 = e.c();
                                    Objects.requireNonNull(c18);
                                    e.c().b(new e.a(RapidCommentDataManager.this.f47114i, true, true, i18));
                                }
                            }
                            e.c().g();
                        }
                        u5.b.q0("hasLoadRapidCommentNum", i17);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(RapidCommentDataManager.D, 2, "load data from server");
                    }
                    QZoneRapidCommentService.v().w(RapidCommentDataManager.this.f47113h, 1);
                    return;
                }
                if (RapidCommentDataManager.this.f47114i != null) {
                    RapidCommentDataManager.this.F();
                    return;
                }
                RapidCommentDataManager.this.f47114i = QZoneRapidCommentService.v().x();
                if (QLog.isColorLevel()) {
                    QLog.d(RapidCommentDataManager.D, 2, "mTabList=" + RapidCommentDataManager.this.f47114i);
                }
                if (RapidCommentDataManager.this.f47114i != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(RapidCommentDataManager.D, 2, "load data from cache");
                    }
                    RapidCommentDataManager.this.F();
                    QZoneRapidCommentService.v().H(1);
                    QZoneRapidCommentService.v().J(RapidCommentDataManager.this.f47114i, true);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(RapidCommentDataManager.D, 2, "load data from server");
                }
                QZoneRapidCommentService.v().w(RapidCommentDataManager.this.f47113h, 1);
            }
        });
    }

    public void H(int i3, int i16) {
        int i17;
        F = i3;
        E = i16;
        if (QZoneRapidCommentService.M == 1) {
            int G2 = u5.b.G("hasLoadRapidCommentNum", 0);
            v vVar = this.f47114i;
            if (vVar != null && G2 >= (i17 = vVar.rcTabNum)) {
                G2 = i17;
            }
            int i18 = QZoneRapidCommentService.N;
            if (G2 <= i18) {
                A(i18);
                return;
            } else {
                A(G2);
                return;
            }
        }
        z();
    }

    public void I(b bVar) {
        synchronized (this.C) {
            if (bVar != null) {
                this.f47115m.remove(bVar);
            }
        }
    }

    public void h(b bVar) {
        synchronized (this.C) {
            if (bVar != null) {
                if (!this.f47115m.contains(bVar)) {
                    this.f47115m.add(bVar);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        QZoneResult unpack;
        if (message.what != 1000093 || (unpack = QZoneResult.unpack(message)) == null) {
            return false;
        }
        v vVar = (v) unpack.getData();
        if (vVar == null) {
            if (this.f47114i == null) {
                B();
            }
            return true;
        }
        this.f47114i = vVar;
        if (QZoneRapidCommentService.M == 1) {
            int G2 = u5.b.G("hasLoadRapidCommentNum", 0);
            int i3 = this.f47114i.rcTabNum;
            if (G2 >= i3) {
                G2 = i3;
            }
            int i16 = QZoneRapidCommentService.N;
            if (G2 > i16) {
                G(G2);
            } else {
                G(i16);
            }
        } else {
            F();
        }
        return true;
    }

    public ArrayList<Long> i(int i3) {
        SparseArray<ArrayList<Long>> sparseArray = this.f47111e;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public String j(long j3, long j16) {
        return l(j3) + "150/" + j16 + ".png";
    }

    public String k(long j3, long j16) {
        return l(j3) + p() + "/" + j16 + ".png";
    }

    public String m(long j3) {
        return QZoneRapidCommentService.v().u(j3);
    }

    public ArrayList<u> o() {
        v vVar = this.f47114i;
        if (vVar != null) {
            return vVar.rapidCommentTabInfoList;
        }
        return null;
    }

    public long p() {
        return 100L;
    }

    public String q(long j3, long j16) {
        v vVar = this.f47114i;
        if (vVar == null || vVar.rapidCommentUrl == null) {
            return null;
        }
        return String.format(this.f47114i.rapidCommentUrl + "%d/%d/%d.png", Long.valueOf(j3), Long.valueOf(p()), Long.valueOf(j16));
    }

    public String s(long j3, long j16) {
        v vVar = this.f47114i;
        if (vVar == null || vVar.rapidCommentUrl == null) {
            return null;
        }
        return String.format(this.f47114i.rapidCommentUrl + "%d/150/%d.png", Long.valueOf(j3), Long.valueOf(j16));
    }

    public int t(int i3) {
        if (v(i3) != -1) {
            return v(i3) - E;
        }
        return -1;
    }

    public u u(int i3) {
        ArrayList<u> arrayList;
        v vVar = this.f47114i;
        if (vVar == null || (arrayList = vVar.rapidCommentTabInfoList) == null || i3 == -1 || i3 >= arrayList.size()) {
            return null;
        }
        return this.f47114i.rapidCommentTabInfoList.get(i3);
    }

    public int v(int i3) {
        SparseIntArray sparseIntArray = this.f47110d;
        if (sparseIntArray == null || i3 >= sparseIntArray.size()) {
            return -1;
        }
        return this.f47110d.get(i3);
    }

    public int w(int i3) {
        ArrayList<u> arrayList;
        v vVar = this.f47114i;
        if (vVar != null && (arrayList = vVar.rapidCommentTabInfoList) != null) {
            Iterator<u> it = arrayList.iterator();
            while (it.hasNext()) {
                u next = it.next();
                if (next.rcTabId == i3) {
                    return next.tabIndex;
                }
            }
        }
        return -1;
    }

    public int x() {
        return this.f47112f + F;
    }

    public int y() {
        return this.f47112f;
    }

    public void z() {
        v vVar = this.f47114i;
        if (vVar == null || vVar.rapidCommentTabInfoList == null) {
            return;
        }
        this.f47110d = new SparseIntArray();
        this.f47111e = new SparseArray<>();
        int i3 = 0;
        this.f47112f = 0;
        int i16 = E - 1;
        while (i3 < F) {
            this.f47110d.put(i3, i3);
            i3++;
        }
        Iterator<u> it = this.f47114i.rapidCommentTabInfoList.iterator();
        while (it.hasNext()) {
            u next = it.next();
            ArrayList<Long> arrayList = next.rcExpressionList;
            if (arrayList == null) {
                QZLog.e(D, "initPages, rapidCommentTabInfo.rcExpressionList is null");
            } else {
                i16++;
                next.tabIndex = i16;
                next.tabPageCount = arrayList.size();
                int i17 = this.f47112f;
                int i18 = F;
                next.pageBeginIndex = i17 + i18;
                next.pageEndIndex = i18 + i17;
                this.f47112f = i17 + 1;
                this.f47110d.put(i3, i16);
                this.f47111e.put(i3, next.rcExpressionList);
                i3++;
            }
        }
    }

    public RapidCommentExpressionInfo r(u uVar, long j3) {
        HashMap<Long, RapidCommentExpressionInfo> hashMap;
        if (uVar == null || (hashMap = uVar.rcExpressionInfoMap) == null) {
            return null;
        }
        RapidCommentExpressionInfo rapidCommentExpressionInfo = hashMap.get(Long.valueOf(j3));
        if (rapidCommentExpressionInfo != null && !rapidCommentExpressionInfo.D) {
            rapidCommentExpressionInfo.f60639d = String.valueOf(uVar.rcTabId);
            rapidCommentExpressionInfo.f60641f = s(uVar.rcTabId, j3);
            rapidCommentExpressionInfo.f60642h = q(uVar.rcTabId, j3);
            rapidCommentExpressionInfo.f60643i = j(uVar.rcTabId, j3);
            rapidCommentExpressionInfo.f60644m = k(uVar.rcTabId, j3);
            rapidCommentExpressionInfo.C = p();
            rapidCommentExpressionInfo.D = true;
        }
        return rapidCommentExpressionInfo;
    }
}
