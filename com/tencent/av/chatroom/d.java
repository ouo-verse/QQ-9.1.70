package com.tencent.av.chatroom;

import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static d f73535f;

    /* renamed from: g, reason: collision with root package name */
    private static int f73536g;

    /* renamed from: a, reason: collision with root package name */
    public EmoticonSpan f73538a;

    /* renamed from: b, reason: collision with root package name */
    public int f73539b;

    /* renamed from: c, reason: collision with root package name */
    public int f73540c;

    /* renamed from: d, reason: collision with root package name */
    private d f73541d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f73534e = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator<d> f73537h = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Comparator<d> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar == dVar2) {
                return 0;
            }
            if (dVar == null) {
                return -1;
            }
            if (dVar2 == null) {
                return 1;
            }
            return dVar.f73539b - dVar2.f73539b;
        }
    }

    d(EmoticonSpan emoticonSpan, int i3, int i16) {
        this.f73538a = emoticonSpan;
        this.f73539b = i3;
        this.f73540c = i16;
    }

    public static d a(EmoticonSpan emoticonSpan, int i3, int i16) {
        synchronized (f73534e) {
            d dVar = f73535f;
            if (dVar != null) {
                f73535f = dVar.f73541d;
                dVar.d(emoticonSpan, i3, i16);
                f73536g--;
                return dVar;
            }
            return new d(emoticonSpan, i3, i16);
        }
    }

    public static void c(List<d> list) {
        if (list != null && list.size() != 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                d remove = list.remove(size);
                if (remove != null) {
                    remove.b();
                }
            }
        }
    }

    private void d(EmoticonSpan emoticonSpan, int i3, int i16) {
        this.f73541d = null;
        this.f73538a = emoticonSpan;
        this.f73539b = i3;
        this.f73540c = i16;
    }

    public void b() {
        d(null, -1, -1);
        synchronized (f73534e) {
            int i3 = f73536g;
            if (i3 < 50) {
                this.f73541d = f73535f;
                f73535f = this;
                f73536g = i3 + 1;
            }
        }
    }
}
