package com.tencent.luggage.wxa.g7;

import com.tencent.luggage.wxa.q5.a;
import com.tencent.luggage.wxa.s6.h;
import com.tencent.mars.cdn.CronetLogic;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements com.tencent.luggage.wxa.q5.a {

    /* renamed from: a, reason: collision with root package name */
    public static final c f126580a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f126581b = a.NOT_PRELOAD;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f126582c = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedList f126583d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedList f126584e = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        NOT_PRELOAD,
        PRELOADING,
        PRELOADED
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f126589a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.PRELOADED.ordinal()] = 1;
            iArr[a.PRELOADING.ordinal()] = 2;
            iArr[a.NOT_PRELOAD.ordinal()] = 3;
            f126589a = iArr;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g7.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6235c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public static final RunnableC6235c f126590a = new RunnableC6235c();

        @Override // java.lang.Runnable
        public final void run() {
            LinkedList linkedList;
            CronetLogic.initializeNativeLib();
            com.tencent.luggage.wxa.h7.b b16 = com.tencent.luggage.wxa.h7.b.INSTANCE.b();
            b16.Z();
            synchronized (c.f126582c) {
                c.f126584e.addLast(b16);
                linkedList = new LinkedList(c.f126583d);
                c.f126583d.clear();
                c.f126581b = a.PRELOADED;
                Unit unit = Unit.INSTANCE;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((a.InterfaceC6617a) it.next()).onReady();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h b(String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.h7.b a() {
        com.tencent.luggage.wxa.h7.b bVar;
        synchronized (f126582c) {
            bVar = (com.tencent.luggage.wxa.h7.b) f126584e.peek();
        }
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public boolean b() {
        boolean z16;
        synchronized (f126582c) {
            z16 = a.PRELOADED == f126581b;
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public boolean c() {
        synchronized (f126582c) {
            int i3 = b.f126589a[f126581b.ordinal()];
            if (i3 != 1) {
                return i3 != 2;
            }
            return f126584e.isEmpty();
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.h7.b a(String str) {
        com.tencent.luggage.wxa.h7.b bVar;
        synchronized (f126582c) {
            bVar = (com.tencent.luggage.wxa.h7.b) f126584e.poll();
        }
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public void a(a.InterfaceC6617a interfaceC6617a, boolean z16, boolean z17) {
        synchronized (f126582c) {
            int i3 = b.f126589a[f126581b.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    f126583d.addLast(interfaceC6617a);
                    return;
                } else if (i3 == 3) {
                    f126583d.addLast(interfaceC6617a);
                }
            } else if (!z16) {
                return;
            } else {
                f126583d.addLast(interfaceC6617a);
            }
            f126581b = a.PRELOADING;
            Unit unit = Unit.INSTANCE;
            com.tencent.luggage.wxa.zp.h.f146825d.execute(RunnableC6235c.f126590a);
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public boolean a(a.InterfaceC6617a interfaceC6617a) {
        if (interfaceC6617a == null) {
            return false;
        }
        synchronized (f126582c) {
            if (f126581b == a.PRELOADING) {
                f126583d.addLast(interfaceC6617a);
                return true;
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }
}
