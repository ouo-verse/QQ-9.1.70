package com.tencent.mobileqq.zplan.event.impl;

import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.event.impl.db.ZPlanRealtimeEventEntity;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sh3.d;
import uh3.e;
import uh3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J$\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/b;", "", "", "a", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "event", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "cb", "b", "", "eventList", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f333443a = new b();

    b() {
    }

    public final void a() {
        ZplanDataBaseHelper.m(new ZPlanRealtimeEventEntity(), new d());
        e.f438965d.f();
    }

    public final void b(Event event, com.tencent.mobileqq.zootopia.api.e<vu4.b> cb5) {
        Intrinsics.checkNotNullParameter(event, "event");
        ArrayList arrayList = new ArrayList();
        arrayList.add(event);
        c(arrayList, cb5);
    }

    public final void c(List<Event> eventList, com.tencent.mobileqq.zootopia.api.e<vu4.b> cb5) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        i.f438976a.b(eventList, cb5);
    }
}
