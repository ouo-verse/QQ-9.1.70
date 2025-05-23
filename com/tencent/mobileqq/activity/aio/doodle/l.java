package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import android.graphics.PathMeasure;
import com.tencent.mobileqq.activity.aio.doodle.m;
import com.tencent.mobileqq.activity.aio.doodle.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private int f178557a = 10;

    /* renamed from: b, reason: collision with root package name */
    private int f178558b = 25;

    /* renamed from: c, reason: collision with root package name */
    private float f178559c = 1.0f;

    private long c(long j3, long j16, int i3, int i16) {
        if (i3 <= 1) {
            return (j3 + j16) / 2;
        }
        return (((j16 - j3) * (i16 + 1)) / i3) + j3;
    }

    private float d(float f16, float f17, int i3, int i16) {
        if (i3 <= 1) {
            return (f16 + f17) / 2.0f;
        }
        return (((f17 - f16) * (i16 + 1)) / i3) + f16;
    }

    public abstract void b(float f16, float f17, float f18, long j3, Path path, List<o.b> list);

    public abstract void e(Path path, List<o.b> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(List<o.b> list, Path path) {
        int i3 = 0;
        if (list == null || path == null || list.size() == 0) {
            return false;
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        float f16 = 0.0f;
        while (i3 < list.size()) {
            Path path2 = new Path();
            float b16 = list.get(i3).b() + f16;
            if (b16 > length) {
                b16 = length;
            }
            pathMeasure.getSegment(f16, b16, path2, true);
            path2.rLineTo(0.0f, 0.0f);
            path.addPath(path2);
            list.get(i3).j(path2);
            i3++;
            f16 = b16;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(List<o.b> list, Path path, float f16, float f17, long j3, long j16) {
        float f18;
        boolean z16;
        if (list == null) {
            return false;
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int ceil = (int) Math.ceil(length / this.f178557a);
        if (ceil == 0) {
            return false;
        }
        o.b bVar = null;
        int i3 = 0;
        while (i3 < ceil) {
            Path path2 = new Path();
            int i16 = i3 + 1;
            float f19 = i16 * this.f178557a;
            if (f19 > length) {
                f18 = length;
            } else {
                f18 = f19;
            }
            pathMeasure.getSegment(r1 * i3, f18, path2, true);
            path2.rLineTo(0.0f, 0.0f);
            o.b bVar2 = new o.b(path2);
            bVar2.m(d(f16, f17, ceil, i3));
            bVar2.l(c(j3, j16, ceil, i3));
            bVar2.i(f18 - (i3 * this.f178557a));
            if (bVar != null && bVar.e() == bVar2.e()) {
                bVar2.k(bVar.d() + 1);
                z16 = false;
            } else {
                z16 = false;
                bVar2.k(0);
            }
            list.add(bVar2);
            bVar = bVar2;
            i3 = i16;
        }
        return true;
    }

    public void h(int i3, int i16, float f16) {
        this.f178557a = i3;
        this.f178558b = i16;
        this.f178559c = f16;
        if (i3 <= 0) {
            this.f178557a = 10;
        }
        if (i16 <= 0) {
            this.f178558b = 25;
        }
        if (f16 <= 0.0f) {
            this.f178559c = 1.0f;
        }
    }

    public abstract void i(float f16, float f17, float f18, long j3, Path path, List<o.b> list);

    public void j(List<o.b> list, int i3) {
        if (list != null && list.size() != 0) {
            if (i3 < 0) {
                i3 = 0;
            }
            if (list.size() <= i3) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            o.b bVar = list.get(i3);
            while (true) {
                i3++;
                if (i3 < list.size()) {
                    o.b bVar2 = list.get(i3);
                    if (bVar2.e() - bVar.e() < this.f178558b && Math.abs(bVar2.f() - bVar.f()) < this.f178559c) {
                        bVar.g(bVar2);
                    } else {
                        arrayList.add(bVar);
                        if (bVar.e() != bVar2.e()) {
                            bVar2.k(0);
                        } else {
                            bVar2.k(bVar.d() + 1);
                        }
                        bVar = bVar2;
                    }
                } else {
                    arrayList.add(bVar);
                    list.clear();
                    list.addAll(arrayList);
                    return;
                }
            }
        }
    }

    public abstract void k(List<m.a> list, Path path, List<o.b> list2);

    public abstract void l(List<m.a> list, Path path, List<o.b> list2, int i3);
}
