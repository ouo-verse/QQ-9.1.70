package com.tencent.av.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ab {

    /* renamed from: i, reason: collision with root package name */
    private final long f76934i;

    /* renamed from: j, reason: collision with root package name */
    private final long[] f76935j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f76937l;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f76926a = new ArrayList<>(10);

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, Long> f76927b = new HashMap<>(10);

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, Long> f76928c = new HashMap<>(10);

    /* renamed from: d, reason: collision with root package name */
    private long f76929d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f76930e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f76931f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f76932g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f76933h = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f76936k = 0;

    public ab(int i3) {
        long[] jArr = new long[20];
        this.f76935j = jArr;
        this.f76937l = false;
        this.f76937l = e.e(34) == 1;
        Arrays.fill(jArr, 0L);
        if (i3 >= 7) {
            this.f76934i = 30L;
        } else if (i3 >= 4) {
            this.f76934i = 48L;
        } else {
            this.f76934i = 66L;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PerfRecorder", 2, "logPerfData[" + this.f76937l + "], machineLevel[" + i3 + "], frameCostLine[" + this.f76934i + "]");
        }
    }

    public void a() {
        long j3;
        float f16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("endOfOneChat, frameAvgCost[");
        sb5.append(this.f76933h);
        sb5.append("], frameCount[");
        sb5.append(this.f76930e);
        sb5.append("], frameTotalCost[");
        sb5.append(this.f76932g);
        sb5.append("], frameAvgCost2[");
        int i3 = this.f76930e;
        if (i3 > 0) {
            j3 = this.f76932g / i3;
        } else {
            j3 = 0;
        }
        sb5.append(j3);
        sb5.append("], frameCostLine[");
        sb5.append(this.f76934i);
        sb5.append("], frameCostOverLineCnt[");
        sb5.append(this.f76931f);
        sb5.append("], frameCostOverLine[");
        int i16 = this.f76930e;
        if (i16 > 0) {
            f16 = this.f76931f / i16;
        } else {
            f16 = 0.0f;
        }
        sb5.append(f16);
        sb5.append("], {");
        for (long j16 : this.f76935j) {
            sb5.append(j16);
            sb5.append(",");
        }
        sb5.append("}");
        QLog.i("PerfRecorder", 2, sb5.toString());
        this.f76930e = 0;
        this.f76932g = 0L;
        this.f76933h = 0L;
        Arrays.fill(this.f76935j, 0L);
        this.f76936k = 0;
        this.f76931f = 0;
    }

    public void b(long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f76929d;
        this.f76930e++;
        this.f76932g += elapsedRealtime;
        long j16 = this.f76933h;
        if (j16 == 0) {
            this.f76933h = elapsedRealtime;
        } else {
            this.f76933h = (j16 + elapsedRealtime) / 2;
        }
        long[] jArr = this.f76935j;
        int i3 = this.f76936k;
        if (elapsedRealtime > jArr[i3]) {
            jArr[i3] = elapsedRealtime;
        }
        long j17 = jArr[i3];
        int i16 = 0;
        while (true) {
            long[] jArr2 = this.f76935j;
            if (i16 >= jArr2.length) {
                break;
            }
            long j18 = jArr2[i16];
            if (j18 < j17) {
                this.f76936k = i16;
                j17 = j18;
            }
            i16++;
        }
        if (elapsedRealtime > this.f76934i) {
            this.f76931f++;
        }
        this.f76928c.clear();
        if (this.f76937l && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(500);
            sb5.append("frameEnd, frameIndex: ");
            sb5.append(j3);
            sb5.append(", curFrameCost: ");
            sb5.append(elapsedRealtime);
            sb5.append(", frameCount: ");
            sb5.append(this.f76930e);
            sb5.append(", frameTotalCost: ");
            sb5.append(this.f76932g);
            sb5.append(", stepCost{");
            Iterator<String> it = this.f76926a.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Long l3 = this.f76927b.get(next);
                sb5.append(next);
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(l3);
                sb5.append(", ");
            }
            sb5.append("}, ");
            QLog.i("PerfRecorder", 2, sb5.toString());
        }
    }

    public void c() {
        this.f76927b.clear();
        this.f76926a.clear();
        this.f76929d = SystemClock.elapsedRealtime();
    }

    public void d(String str) {
        Long l3;
        if (!TextUtils.isEmpty(str) && (l3 = this.f76928c.get(str)) != null) {
            this.f76927b.put(str, Long.valueOf(SystemClock.elapsedRealtime() - l3.longValue()));
        }
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f76928c.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
            this.f76926a.add(str);
        }
    }
}
