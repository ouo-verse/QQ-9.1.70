package com.tencent.mobileqq.zplan.event.impl;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.f;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.event.impl.db.ZPlanRealtimeEventEntity;
import com.tencent.mobileqq.zplan.utils.i;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vu4.c;
import vu4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tJ\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000eJ'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00030\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/a;", "", "", "", TtmlNode.ATTR_TTS_ORIGIN, "a", "", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "eventList", "Lvu4/c;", "c", "event", "d", "eventLog", "Lcom/tencent/mobileqq/zplan/event/impl/db/ZPlanRealtimeEventEntity;", "b", "entityList", "e", "entity", "f", "map", "", "Lvu4/d;", "g", "(Ljava/util/Map;)[Lvu4/d;", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "qqVersion", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f333441a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String qqVersion = f.b(BaseApplication.context);

    a() {
    }

    private final Map<String, String> a(Map<String, String> origin) {
        HashMap hashMap = new HashMap(origin);
        hashMap.put("zplan_net_status", String.valueOf(NetworkUtil.isNetworkAvailable()));
        hashMap.put("k_server_env", v84.a.a());
        hashMap.put("k_is_public_version", "true");
        return hashMap;
    }

    public final ZPlanRealtimeEventEntity b(c eventLog) {
        Intrinsics.checkNotNullParameter(eventLog, "eventLog");
        ZPlanRealtimeEventEntity zPlanRealtimeEventEntity = new ZPlanRealtimeEventEntity();
        String str = eventLog.f443566l;
        Intrinsics.checkNotNullExpressionValue(str, "eventLog.eventName");
        zPlanRealtimeEventEntity.eventName = str;
        byte[] byteArray = MessageNano.toByteArray(eventLog);
        zPlanRealtimeEventEntity.eventData = byteArray;
        String md5 = MD5.toMD5(byteArray);
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(entity.eventData)");
        zPlanRealtimeEventEntity.eventId = md5;
        return zPlanRealtimeEventEntity;
    }

    public final List<c> c(List<Event> eventList) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = eventList.iterator();
        while (it.hasNext()) {
            arrayList.add(f333441a.d((Event) it.next()));
        }
        return arrayList;
    }

    public final c d(Event event) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(event, "event");
        c cVar = new c();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(currentUin);
        cVar.f443555a = longOrNull != null ? longOrNull.longValue() : 0L;
        cVar.f443556b = event.getSource();
        cVar.f443558d = event.getErrCode();
        cVar.f443559e = event.getMsg();
        cVar.f443560f = System.currentTimeMillis() / 1000;
        cVar.f443561g = qqVersion;
        cVar.f443562h = 109;
        cVar.f443563i = DeviceInfoMonitor.getModel();
        cVar.f443564j = i.a();
        cVar.f443565k = g(a(event.getExtData()));
        cVar.f443566l = event.getName();
        return cVar;
    }

    public final List<c> e(List<ZPlanRealtimeEventEntity> entityList) {
        Intrinsics.checkNotNullParameter(entityList, "entityList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entityList.iterator();
        while (it.hasNext()) {
            arrayList.add(f333441a.f((ZPlanRealtimeEventEntity) it.next()));
        }
        return arrayList;
    }

    public final c f(ZPlanRealtimeEventEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        c cVar = new c();
        try {
            MessageNano.mergeFrom(cVar, entity.eventData);
        } catch (Throwable th5) {
            QLog.e("ZPlanEventDataUtil_", 1, "buildEventLog failed!", th5);
        }
        return cVar;
    }

    public final d[] g(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                if (!(key == null || key.length() == 0)) {
                    String value = next.getValue();
                    if (!(value == null || value.length() == 0)) {
                        d dVar = new d();
                        dVar.f443568a = next.getKey();
                        dVar.f443569b = next.getValue();
                        arrayList.add(dVar);
                    }
                }
            } else {
                Object[] array = arrayList.toArray(new d[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (d[]) array;
            }
        }
    }
}
