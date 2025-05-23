package com.tencent.luggage.wxa.xi;

import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public volatile int f144993a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f144994b = new LinkedList();

    public b(int i3) {
        this.f144993a = i3;
    }

    public void a(Runnable runnable) {
        LinkedList linkedList;
        synchronized (this) {
            if (runnable != null) {
                this.f144994b.addLast(runnable);
            }
            int i3 = this.f144993a - 1;
            this.f144993a = i3;
            if (i3 <= 0 && this.f144994b.size() > 0) {
                linkedList = new LinkedList();
                linkedList.addAll(this.f144994b);
                this.f144994b.clear();
            } else {
                linkedList = null;
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }
}
