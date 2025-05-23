package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.event.EventBean;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b extends c.a<EventBean, com.tencent.beacon.event.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private final C0787b f77904a = new C0787b();

    /* renamed from: b, reason: collision with root package name */
    private final a f77905b = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class a implements com.tencent.beacon.base.net.a.c<EventBean, com.tencent.beacon.event.a.b> {
        a() {
        }

        @Override // com.tencent.beacon.base.net.a.c
        public com.tencent.beacon.event.a.b a(EventBean eventBean) {
            com.tencent.beacon.event.a.b bVar = new com.tencent.beacon.event.a.b();
            bVar.f77891b = eventBean.getEventTime();
            bVar.f77893d = eventBean.getAppKey();
            byte[] a16 = com.tencent.beacon.base.util.b.a(eventBean);
            bVar.f77894e = a16;
            if (a16 != null) {
                bVar.f77892c = a16.length;
            }
            return bVar;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.event.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0787b implements com.tencent.beacon.base.net.a.c<com.tencent.beacon.event.a.b, EventBean> {
        C0787b() {
        }

        @Override // com.tencent.beacon.base.net.a.c
        public EventBean a(com.tencent.beacon.event.a.b bVar) {
            Object a16 = com.tencent.beacon.base.util.b.a(bVar.f77894e);
            if (a16 == null || !(a16 instanceof EventBean)) {
                return null;
            }
            EventBean eventBean = (EventBean) a16;
            eventBean.setCid(bVar.f77890a);
            return eventBean;
        }
    }

    b() {
    }

    public static b a() {
        return new b();
    }

    public com.tencent.beacon.base.net.a.c<EventBean, com.tencent.beacon.event.a.b> b() {
        return this.f77905b;
    }

    public com.tencent.beacon.base.net.a.c<com.tencent.beacon.event.a.b, EventBean> c() {
        return this.f77904a;
    }
}
