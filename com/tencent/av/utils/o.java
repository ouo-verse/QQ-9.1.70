package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final String f77115a;

    /* renamed from: c, reason: collision with root package name */
    private final long f77117c;

    /* renamed from: d, reason: collision with root package name */
    private long f77118d;

    /* renamed from: e, reason: collision with root package name */
    private long f77119e;

    /* renamed from: f, reason: collision with root package name */
    private long f77120f;

    /* renamed from: g, reason: collision with root package name */
    private long f77121g;

    /* renamed from: h, reason: collision with root package name */
    private long f77122h;

    /* renamed from: i, reason: collision with root package name */
    private long f77123i;

    /* renamed from: j, reason: collision with root package name */
    private long f77124j;

    /* renamed from: b, reason: collision with root package name */
    private final long f77116b = 200;

    /* renamed from: k, reason: collision with root package name */
    private final int f77125k = 5;

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList<a> f77126l = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f77127a;

        /* renamed from: b, reason: collision with root package name */
        long f77128b;

        /* renamed from: c, reason: collision with root package name */
        long f77129c;

        /* renamed from: d, reason: collision with root package name */
        long f77130d;

        /* renamed from: e, reason: collision with root package name */
        long f77131e;

        /* renamed from: f, reason: collision with root package name */
        long f77132f;

        /* renamed from: g, reason: collision with root package name */
        long f77133g;

        /* renamed from: h, reason: collision with root package name */
        long f77134h;

        a() {
        }
    }

    public o(String str, long j3) {
        this.f77115a = str;
        this.f77117c = j3;
    }

    private void a(a aVar) {
        this.f77126l.add(aVar);
        if (this.f77126l.size() < 5) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("\ncycleIndex[");
        StringBuilder sb6 = new StringBuilder("cycleCnt[");
        StringBuilder sb7 = new StringBuilder("cycleBeginTimeMs[");
        StringBuilder sb8 = new StringBuilder("cyclePeriod[");
        StringBuilder sb9 = new StringBuilder("cycleAvgFps[");
        StringBuilder sb10 = new StringBuilder("cycleAvgIntervalMs[");
        StringBuilder sb11 = new StringBuilder("cycleMaxIntervalMs[");
        StringBuilder sb12 = new StringBuilder("cycleAvgCostMs[");
        Iterator<a> it = this.f77126l.iterator();
        while (it.hasNext()) {
            a next = it.next();
            sb5.append(next.f77127a);
            sb5.append(",");
            sb6.append(next.f77128b);
            sb6.append(",");
            sb7.append(next.f77129c);
            sb7.append(",");
            sb8.append(next.f77130d);
            sb8.append(",");
            sb9.append(next.f77131e);
            sb9.append(",");
            sb10.append(next.f77132f);
            sb10.append(",");
            sb11.append(next.f77133g);
            sb11.append(",");
            sb12.append(next.f77134h);
            sb12.append(",");
        }
        this.f77126l.clear();
        sb5.append("]\n");
        sb6.append("]\n");
        sb5.append((CharSequence) sb6);
        sb7.append("]\n");
        sb5.append((CharSequence) sb7);
        sb8.append("]\n");
        sb5.append((CharSequence) sb8);
        sb9.append("]\n");
        sb5.append((CharSequence) sb9);
        sb10.append("]\n");
        sb5.append((CharSequence) sb10);
        sb11.append("]\n");
        sb5.append((CharSequence) sb11);
        sb12.append("]\n");
        sb5.append((CharSequence) sb12);
        QLog.d(this.f77115a, 1, sb5.toString());
    }

    private void b() {
        this.f77119e = 0L;
        this.f77118d = 0L;
        this.f77121g = 0L;
        this.f77122h = 0L;
        this.f77123i = 0L;
        this.f77124j = 0L;
    }

    public void c(long j3, long j16) {
        this.f77121g++;
        this.f77124j += j16;
        long j17 = this.f77118d;
        if (j17 == 0) {
            this.f77120f++;
            this.f77119e = j3;
            this.f77118d = j3;
            return;
        }
        this.f77118d = j3;
        long j18 = j3 - j17;
        if (j18 > 200) {
            QLog.d(this.f77115a, 1, "warning!!! should check related-status, mCurCycleIndex\uff1a=" + this.f77120f + ", IntervalMs:= " + j18 + ", CostTimeMs:= " + j16);
        }
        this.f77123i = Math.max(j18, this.f77123i);
        long j19 = this.f77119e;
        if (j3 - j19 > this.f77117c) {
            this.f77122h = (j3 - j19) / this.f77121g;
            a aVar = new a();
            aVar.f77127a = this.f77120f;
            long j26 = this.f77121g;
            aVar.f77128b = j26;
            long j27 = this.f77119e;
            aVar.f77129c = j27;
            aVar.f77130d = j3 - j27;
            aVar.f77131e = (1000 * j26) / (j3 - j27);
            aVar.f77132f = this.f77122h;
            aVar.f77133g = this.f77123i;
            aVar.f77134h = this.f77124j / j26;
            a(aVar);
            b();
        }
    }
}
