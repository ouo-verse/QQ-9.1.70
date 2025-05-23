package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i extends e {

    /* renamed from: i, reason: collision with root package name */
    public Boolean f197262i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f197263j;

    /* renamed from: k, reason: collision with root package name */
    public int f197264k;

    /* renamed from: l, reason: collision with root package name */
    public int f197265l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<c.a> f197266m;

    /* renamed from: n, reason: collision with root package name */
    public String f197267n;

    /* renamed from: o, reason: collision with root package name */
    public String f197268o;

    public String a() {
        if (!this.f197266m.isEmpty() && this.f197266m.size() <= 1) {
            return this.f197266m.get(0).f196880c;
        }
        return null;
    }

    public c.a b(int i3) {
        QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromClickOperation");
        if (this.f197266m.isEmpty()) {
            return null;
        }
        Iterator<c.a> it = this.f197266m.iterator();
        while (it.hasNext()) {
            c.a next = it.next();
            if (i3 <= next.f196884g && i3 >= next.f196883f && next.f196882e == 1) {
                return next;
            }
        }
        return null;
    }

    public c.a c() {
        QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromRandFunction");
        if (this.f197266m.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c.a> it = this.f197266m.iterator();
        while (it.hasNext()) {
            c.a next = it.next();
            if (next.f196882e == 3) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (c.a) arrayList.get(new Random().nextInt(arrayList.size()));
    }

    public c.a d() {
        QLog.i("ARTransferResourceInfo", 2, "getTriggleUrlFromTime");
        if (this.f197266m.isEmpty()) {
            return null;
        }
        int i3 = Calendar.getInstance().get(11);
        Iterator<c.a> it = this.f197266m.iterator();
        while (it.hasNext()) {
            c.a next = it.next();
            if (i3 < next.f196884g && i3 >= next.f196883f && next.f196882e == 2) {
                return next;
            }
        }
        return null;
    }

    public boolean e(int i3) {
        if (this.f197266m.isEmpty()) {
            return false;
        }
        Iterator<c.a> it = this.f197266m.iterator();
        while (it.hasNext()) {
            if (it.next().f196882e == i3) {
                return true;
            }
        }
        return false;
    }
}
