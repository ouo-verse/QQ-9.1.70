package com.qzone.adapter.feedcomponent;

import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public EventSource f41884a;

        a(EventSource eventSource) {
            this.f41884a = eventSource;
        }

        public static a a(EventSource eventSource) {
            return new a(eventSource);
        }
    }

    public static void a(a aVar, int i3, Object obj) {
        EventCenter.getInstance().post(aVar.f41884a, i3, obj);
    }

    public static void b(String str, Object obj, int i3, Object obj2) {
        EventCenter.getInstance().post(new EventSource(str, obj), i3, obj2);
    }
}
