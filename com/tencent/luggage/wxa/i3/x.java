package com.tencent.luggage.wxa.i3;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f129431a = new x();

    /* renamed from: b, reason: collision with root package name */
    public static final c f129432b;

    /* renamed from: c, reason: collision with root package name */
    public static a f129433c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(String str, e eVar, d dVar, String str2);

        void a(String str, com.tencent.luggage.wxa.ki.a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, e eVar, d dVar, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements a {
        @Override // com.tencent.luggage.wxa.i3.x.a
        public void a(String instanceId, e eventGroup, d event, String str) {
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.Standalone.WxaLaunchTracer", "onEvent instanceId[" + instanceId + "] group[" + eventGroup + "] event[" + event + "] message[" + str + ']');
        }

        @Override // com.tencent.luggage.wxa.i3.x.a
        public void a(String instanceId, com.tencent.luggage.wxa.ki.a params) {
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Intrinsics.checkNotNullParameter(params, "params");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onNewInstanceStart instanceId[");
            sb5.append(instanceId);
            sb5.append("] appId[");
            sb5.append(params.f132018b);
            sb5.append("] versionType[");
            sb5.append(params.f132022d);
            sb5.append("] scene[");
            com.tencent.luggage.wxa.bk.e eVar = params.f132032i;
            sb5.append(eVar != null ? eVar.f122984c : 0);
            sb5.append(']');
            com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.Standalone.WxaLaunchTracer", sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        NONE,
        START,
        OK,
        FAIL,
        CLOSE_BEFORE_START
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        NONE,
        GET_ATTRS,
        GET_LAUNCH,
        GET_WXA_PKG,
        GET_DEMO_INFO,
        GET_WXA_DEBUG_INFO,
        START_UP
    }

    static {
        c cVar = new c();
        f129432b = cVar;
        f129433c = cVar;
    }

    public final void a(String instanceId, e eventGroup, d event) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this, instanceId, eventGroup, event, null, 8, null);
    }

    public final void a(String instanceId, d event) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(event, "event");
        a(this, instanceId, event, null, 4, null);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            aVar = f129432b;
        }
        f129433c = aVar;
    }

    public static /* synthetic */ void a(x xVar, String str, e eVar, d dVar, Object obj, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            obj = null;
        }
        xVar.a(str, eVar, dVar, obj);
    }

    public final void a(String instanceId, e eventGroup, d event, Object obj) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(eventGroup, "eventGroup");
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = f129433c;
        b bVar = aVar instanceof b ? (b) aVar : null;
        if (bVar != null) {
            bVar.a(instanceId, eventGroup, event, obj);
        } else {
            aVar.a(instanceId, eventGroup, event, obj != null ? obj.toString() : null);
        }
    }

    public final void a(String instanceId, com.tencent.luggage.wxa.ki.a params) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(params, "params");
        f129433c.a(instanceId, params);
        f129433c.a(instanceId, e.START_UP, d.START, null);
    }

    public static /* synthetic */ void a(x xVar, String str, d dVar, Object obj, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            obj = null;
        }
        xVar.a(str, dVar, obj);
    }

    public final void a(String instanceId, d event, Object obj) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(event, "event");
        a(instanceId, e.START_UP, event, obj);
    }
}
