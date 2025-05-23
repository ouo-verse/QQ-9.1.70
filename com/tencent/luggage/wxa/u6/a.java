package com.tencent.luggage.wxa.u6;

import com.tencent.luggage.wxa.l3.g;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity1;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity2;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity3;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity4;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity0;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity1;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity2;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity3;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerMultiTaskActivity4;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v7.h;
import com.tencent.luggage.wxa.z4.f;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f142122a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f142123b = new AtomicBoolean(false);

    public final ArrayList a() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new g(WxaContainerMultiTaskActivity0.class, WxaContainerActivity0.class), new g(WxaContainerMultiTaskActivity1.class, WxaContainerActivity1.class), new g(WxaContainerMultiTaskActivity2.class, WxaContainerActivity2.class), new g(WxaContainerMultiTaskActivity3.class, WxaContainerActivity3.class), new g(WxaContainerMultiTaskActivity4.class, WxaContainerActivity4.class));
        return arrayListOf;
    }

    public final void b() {
        synchronized (this) {
            if (f142123b.getAndSet(true)) {
                return;
            }
            w.d("Luggage.WXA.WxaContainerTaskList", "init task manager at [%s]", z.i());
            f.a aVar = f.f146283b;
            Object[] array = f142122a.a().toArray(new g[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            aVar.a(new h((g[]) array));
            Unit unit = Unit.INSTANCE;
        }
    }
}
