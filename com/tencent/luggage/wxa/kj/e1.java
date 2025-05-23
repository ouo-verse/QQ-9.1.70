package com.tencent.luggage.wxa.kj;

import android.util.SparseIntArray;
import java.util.Iterator;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e1 extends b {

    /* renamed from: c, reason: collision with root package name */
    public final SparseIntArray f132167c;

    public e1(o1 o1Var) {
        super(o1Var);
        this.f132167c = new SparseIntArray();
    }

    public boolean a(String str) {
        String b16 = com.tencent.luggage.wxa.h6.o.b(str);
        Iterator it = iterator();
        m1 m1Var = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            m1 m1Var2 = (m1) it.next();
            boolean z16 = this.f132167c.get(m1Var2.hashCode(), 0) == 1;
            if (StringUtils.equals(b16, m1Var2.c()) && z16) {
                it.remove();
                m1Var = m1Var2;
            } else if (!z16) {
                it.remove();
            }
        }
        if (m1Var == null) {
            return false;
        }
        this.f132074b.addLast(m1Var);
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.b, com.tencent.luggage.wxa.kj.n1
    public int size() {
        Iterator it = this.f132074b.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (this.f132167c.get(((m1) it.next()).hashCode(), 0) != 1) {
                i3++;
            }
        }
        if (this.f132167c.size() > 0) {
            return i3 + 1;
        }
        return i3;
    }

    public boolean a(String str, int i3, long j3) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (this.f132167c.get(((m1) it.next()).hashCode(), 0) != 1) {
                it.remove();
            }
        }
        m1 m1Var = new m1(com.tencent.luggage.wxa.h6.o.b(str), i3, j3);
        a(m1Var);
        this.f132167c.put(m1Var.hashCode(), 1);
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.b, com.tencent.luggage.wxa.kj.n1
    public void a(m1 m1Var) {
        if (isEmpty()) {
            this.f132167c.put(m1Var.hashCode(), 1);
        }
        super.a(m1Var);
    }
}
