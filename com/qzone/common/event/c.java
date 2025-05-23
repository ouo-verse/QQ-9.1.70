package com.qzone.common.event;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
final class c {

    /* renamed from: d, reason: collision with root package name */
    private static final List<c> f45868d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    Object f45869a;

    /* renamed from: b, reason: collision with root package name */
    b f45870b;

    /* renamed from: c, reason: collision with root package name */
    c f45871c;

    c(Object obj, b bVar) {
        this.f45869a = obj;
        this.f45870b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(b bVar, Object obj) {
        List<c> list = f45868d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                c remove = list.remove(size - 1);
                remove.f45869a = obj;
                remove.f45870b = bVar;
                remove.f45871c = null;
                return remove;
            }
            return new c(obj, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        cVar.f45869a = null;
        cVar.f45870b = null;
        cVar.f45871c = null;
        List<c> list = f45868d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(cVar);
            }
        }
    }
}
