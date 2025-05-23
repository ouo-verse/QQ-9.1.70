package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.aio.doodle.m;
import com.tencent.mobileqq.activity.aio.doodle.o;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class HalfAlgorithm extends l implements u {

    /* renamed from: d, reason: collision with root package name */
    private q f178427d = new q();

    /* renamed from: e, reason: collision with root package name */
    private Path f178428e = null;

    /* renamed from: f, reason: collision with root package name */
    private List<o.b> f178429f = null;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, r> f178430g = null;

    /* renamed from: h, reason: collision with root package name */
    private int f178431h = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Object f178432i = new Object();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class TransPathJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private List<q> f178433d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<u> f178434e;

        /* renamed from: f, reason: collision with root package name */
        private int f178435f;

        public TransPathJob(int i3, List<q> list, u uVar) {
            this.f178435f = i3;
            this.f178433d = list;
            this.f178434e = new WeakReference<>(uVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            u uVar;
            WeakReference<u> weakReference;
            boolean z16;
            q qVar;
            TransPathJob transPathJob;
            String str;
            ArrayList arrayList;
            Path path;
            TransPathJob transPathJob2 = this;
            List<q> list = transPathJob2.f178433d;
            if (list != null && list.size() != 0 && (weakReference = transPathJob2.f178434e) != null && weakReference.get() != null) {
                String str2 = "TransPathJob";
                QLog.d("TransPathJob", 2, "TransPathJob begin:" + transPathJob2.f178435f + " - " + System.currentTimeMillis());
                Path path2 = new Path();
                path2.reset();
                ArrayList arrayList2 = new ArrayList();
                Path path3 = new Path();
                ArrayList arrayList3 = new ArrayList();
                q qVar2 = null;
                for (q qVar3 : transPathJob2.f178433d) {
                    if (qVar2 != null) {
                        qVar3.c(qVar2);
                        qVar = null;
                    } else {
                        qVar = qVar2;
                    }
                    HalfAlgorithm halfAlgorithm = HalfAlgorithm.this;
                    p pVar = qVar3.f178593a;
                    float f16 = pVar.f178589a;
                    float f17 = pVar.f178590b;
                    float f18 = pVar.f178591c;
                    long j3 = pVar.f178592d;
                    p pVar2 = qVar3.f178595c;
                    float f19 = pVar2.f178589a;
                    float f26 = pVar2.f178590b;
                    p pVar3 = qVar3.f178594b;
                    Path path4 = path3;
                    String str3 = str2;
                    ArrayList arrayList4 = arrayList2;
                    Path path5 = path2;
                    q qVar4 = qVar3;
                    ArrayList arrayList5 = arrayList3;
                    if (halfAlgorithm.p(f16, f17, f18, j3, f19, f26, pVar3.f178589a, pVar3.f178590b, pVar3.f178591c, pVar3.f178592d, path4, arrayList5)) {
                        if (arrayList5.size() > 0) {
                            path = path5;
                            path.addPath(path4);
                            transPathJob = this;
                            arrayList = arrayList4;
                            HalfAlgorithm.this.o(arrayList, arrayList5);
                            str = str3;
                        } else {
                            transPathJob = this;
                            arrayList = arrayList4;
                            path = path5;
                            str = str3;
                            QLog.d(str, 2, "TransPathJob segment == 0:" + System.currentTimeMillis());
                        }
                        path4.reset();
                        arrayList5.clear();
                        qVar4 = qVar;
                    } else {
                        transPathJob = this;
                        str = str3;
                        arrayList = arrayList4;
                        path = path5;
                        QLog.d(str, 2, "TransPathJob no segment:" + System.currentTimeMillis());
                    }
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList;
                    path3 = path4;
                    str2 = str;
                    qVar2 = qVar4;
                    TransPathJob transPathJob3 = transPathJob;
                    path2 = path;
                    transPathJob2 = transPathJob3;
                }
                String str4 = str2;
                ArrayList arrayList6 = arrayList2;
                Path path6 = path2;
                TransPathJob transPathJob4 = transPathJob2;
                u uVar2 = transPathJob4.f178434e.get();
                if (uVar2 != null) {
                    int i3 = transPathJob4.f178435f;
                    if (arrayList6.size() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    uVar2.a(i3, z16, path6, arrayList6);
                }
                QLog.d(str4, 2, "TransPathJob end:" + transPathJob4.f178435f + "-" + System.currentTimeMillis());
                return;
            }
            WeakReference<u> weakReference2 = transPathJob2.f178434e;
            if (weakReference2 != null && (uVar = weakReference2.get()) != null) {
                uVar.a(transPathJob2.f178435f, false, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(List<o.b> list, List<o.b> list2) {
        long j3;
        int i3;
        if (list2 != null && list != null && list2.size() != 0) {
            if (list.size() > 0) {
                j3 = list.get(list.size() - 1).e();
                i3 = list.get(list.size() - 1).d();
            } else {
                j3 = -1;
                i3 = 0;
            }
            if (list2.get(0).e() == j3) {
                QLog.d("DoodleAlgorithm", 2, "addjust time and seg :" + j3);
                for (o.b bVar : list2) {
                    if (bVar.e() != j3) {
                        break;
                    } else {
                        bVar.k(bVar.d() + i3 + 1);
                    }
                }
            }
            list.addAll(list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(float f16, float f17, float f18, long j3, float f19, float f26, float f27, float f28, float f29, long j16, Path path, List<o.b> list) {
        path.moveTo(f16, f17);
        path.quadTo(f19, f26, f27, f28);
        return g(list, path, f18, f29, j3, j16);
    }

    private void q() {
        if (this.f178429f == null) {
            this.f178429f = new ArrayList();
        }
        this.f178429f.clear();
        if (this.f178428e == null) {
            this.f178428e = new Path();
        }
        this.f178428e.reset();
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.u
    public void a(int i3, boolean z16, Path path, List<o.b> list) {
        if (this.f178430g == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoodleAlgorithm", 2, "onResult :" + i3 + ProgressTracer.SEPARATOR + this.f178431h);
        }
        if ((!z16 || list == null || path == null) && QLog.isColorLevel()) {
            QLog.d("DoodleAlgorithm", 2, "onResult error!!");
        }
        synchronized (this.f178432i) {
            r rVar = new r();
            rVar.f178597a = i3;
            rVar.f178599c = z16;
            rVar.f178598b = path;
            rVar.f178600d = list;
            this.f178430g.put(Integer.valueOf(i3), rVar);
            if (this.f178430g.size() == this.f178431h) {
                this.f178430g.notifyAll();
                QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.l
    public void b(float f16, float f17, float f18, long j3, Path path, List<o.b> list) {
        if (path == null) {
            return;
        }
        if (list == null) {
            this.f178427d.d(f16, f17, f18, j3, true);
            q qVar = this.f178427d;
            p pVar = qVar.f178595c;
            float f19 = pVar.f178589a;
            float f26 = pVar.f178590b;
            p pVar2 = qVar.f178594b;
            path.quadTo(f19, f26, pVar2.f178589a, pVar2.f178590b);
            return;
        }
        q();
        q qVar2 = this.f178427d;
        p pVar3 = qVar2.f178594b;
        float f27 = pVar3.f178589a;
        float f28 = pVar3.f178590b;
        float f29 = pVar3.f178591c;
        long j16 = pVar3.f178592d;
        p pVar4 = qVar2.f178596d;
        float f36 = pVar4.f178589a;
        float f37 = pVar4.f178590b;
        boolean p16 = p(f27, f28, f29, j16, f36, f37, (f36 + f16) / 2.0f, (f37 + f17) / 2.0f, (pVar4.f178591c + f18) / 2.0f, (pVar4.f178592d + j3) / 2, this.f178428e, this.f178429f);
        this.f178427d.d(f16, f17, f18, j3, p16);
        if (p16) {
            if (this.f178429f.size() > 0) {
                path.addPath(this.f178428e);
                o(list, this.f178429f);
                return;
            } else {
                QLog.d("DoodleAlgorithm", 2, "addpoint segment == 0:" + System.currentTimeMillis());
                return;
            }
        }
        QLog.d("DoodleAlgorithm", 2, "addpoint failed:" + System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.l
    public void e(Path path, List<o.b> list) {
        if (list == null) {
            this.f178427d.a();
            q qVar = this.f178427d;
            p pVar = qVar.f178595c;
            float f16 = pVar.f178589a;
            float f17 = pVar.f178590b;
            p pVar2 = qVar.f178594b;
            path.quadTo(f16, f17, pVar2.f178589a, pVar2.f178590b);
            return;
        }
        q();
        this.f178427d.a();
        q qVar2 = this.f178427d;
        p pVar3 = qVar2.f178593a;
        float f18 = pVar3.f178589a;
        float f19 = pVar3.f178590b;
        float f26 = pVar3.f178591c;
        long j3 = pVar3.f178592d;
        p pVar4 = qVar2.f178595c;
        float f27 = pVar4.f178589a;
        float f28 = pVar4.f178590b;
        p pVar5 = qVar2.f178594b;
        if (p(f18, f19, f26, j3, f27, f28, pVar5.f178589a, pVar5.f178590b, pVar5.f178591c, pVar5.f178592d, this.f178428e, this.f178429f)) {
            if (this.f178429f.size() > 0) {
                path.addPath(this.f178428e);
                o(list, this.f178429f);
                this.f178428e = null;
                this.f178429f = null;
                return;
            }
            QLog.d("DoodleAlgorithm", 2, "finish segment == 0:" + System.currentTimeMillis());
            return;
        }
        QLog.d("DoodleAlgorithm", 2, "finish failed:" + System.currentTimeMillis());
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.l
    public void i(float f16, float f17, float f18, long j3, Path path, List<o.b> list) {
        if (path == null) {
            return;
        }
        path.reset();
        path.moveTo(f16, f17);
        this.f178427d.b(f16, f17, f18, j3);
        if (list == null) {
            return;
        }
        list.clear();
        q();
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.l
    public void k(List<m.a> list, Path path, List<o.b> list2) {
        if (list != null && list.size() != 0 && path != null && list2 != null) {
            QLog.d("DoodleAlgorithm", 2, "patchPath begin:");
            boolean z16 = true;
            for (m.a aVar : list) {
                if (z16) {
                    i(aVar.d(), aVar.e(), aVar.c(), aVar.b(), path, null);
                    z16 = false;
                } else {
                    b(aVar.d(), aVar.e(), aVar.c(), aVar.b(), path, null);
                }
            }
            e(path, null);
            f(list2, path);
            QLog.d("DoodleAlgorithm", 2, "patchpath end:" + list2.size());
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.l
    public void l(List<m.a> list, Path path, List<o.b> list2, int i3) {
        boolean z16;
        if (list != null && list.size() != 0 && path != null && list2 != null) {
            QLog.d("DoodleAlgorithm", 2, "transPath begin:" + System.currentTimeMillis());
            if (list.size() > i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.d("DoodleAlgorithm", 2, "transPath begin singlethread begin");
                boolean z17 = true;
                for (m.a aVar : list) {
                    if (z17) {
                        i(aVar.d(), aVar.e(), aVar.c(), aVar.b(), path, list2);
                        z17 = false;
                    } else {
                        b(aVar.d(), aVar.e(), aVar.c(), aVar.b(), path, list2);
                    }
                }
                e(path, list2);
                QLog.d("DoodleAlgorithm", 2, "before merge:" + list2.size());
                j(list2, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleAlgorithm", 2, "after merge:" + list2.size());
                    return;
                }
                return;
            }
            path.reset();
            list2.clear();
            this.f178431h = 0;
            if (this.f178430g == null) {
                this.f178430g = new TreeMap();
            }
            this.f178430g.clear();
            QLog.d("DoodleAlgorithm", 2, "transPath begin multithread begin");
            t tVar = null;
            for (m.a aVar2 : list) {
                if (tVar == null) {
                    tVar = new t();
                    tVar.d(i3);
                    tVar.b(aVar2.d(), aVar2.e(), aVar2.c(), aVar2.b());
                    path.moveTo(aVar2.d(), aVar2.e());
                } else {
                    if (tVar.c(aVar2.d(), aVar2.e(), aVar2.c(), aVar2.b())) {
                        List<q> e16 = tVar.e();
                        int i16 = this.f178431h + 1;
                        this.f178431h = i16;
                        ThreadManagerV2.post(new TransPathJob(i16, e16, this), 8, null, true);
                    }
                }
            }
            if (tVar == null) {
                return;
            }
            tVar.a();
            int i17 = this.f178431h + 1;
            this.f178431h = i17;
            ThreadManagerV2.post(new TransPathJob(i17, tVar.f178601a, this), 8, null, true);
            synchronized (this.f178432i) {
                QLog.d("DoodleAlgorithm", 2, "tranpath wait:" + this.f178431h + " - " + this.f178430g.size());
                if (this.f178430g.size() < this.f178431h) {
                    try {
                        this.f178430g.wait(60000L);
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleAlgorithm", 2, "transPath exception:" + e17);
                        }
                    }
                }
                if (this.f178430g.size() == this.f178431h) {
                    for (r rVar : this.f178430g.values()) {
                        Path path2 = rVar.f178598b;
                        if (path2 != null) {
                            path.addPath(path2);
                        }
                        List<o.b> list3 = rVar.f178600d;
                        if (list3 != null) {
                            o(list2, list3);
                        }
                    }
                    QLog.d("DoodleAlgorithm", 2, "transPath end :" + this.f178431h);
                } else if (QLog.isColorLevel()) {
                    QLog.d("DoodleAlgorithm", 2, "transPath end with error:" + this.f178430g.size() + " ---" + this.f178431h);
                }
                this.f178430g = null;
                this.f178431h = 0;
            }
            QLog.d("DoodleAlgorithm", 2, "before merge:" + list2.size());
            j(list2, 0);
            if (QLog.isColorLevel()) {
                QLog.d("DoodleAlgorithm", 2, "transPath end:" + list2.size());
            }
        }
    }
}
