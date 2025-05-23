package com.tencent.mobileqq.guild.util.performance;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002R2\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/util/performance/f;", "", "", "scene", "", "b", "c", "sensorId", "", "a", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/util/performance/e;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "sCounterMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f235588a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Integer, e> sCounterMap;

    static {
        HashMap<Integer, e> hashMap = new HashMap<>();
        sCounterMap = hashMap;
        hashMap.put(0, new e(1));
    }

    f() {
    }

    public final long a(int sensorId) {
        long j3;
        synchronized (f.class) {
            j3 = 0;
            for (e eVar : sCounterMap.values()) {
                if (eVar.getSensorId() == sensorId) {
                    j3 += eVar.c();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return j3;
    }

    public final void b(int scene) {
        e eVar = sCounterMap.get(Integer.valueOf(scene));
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void c(int scene) {
        e eVar = sCounterMap.get(Integer.valueOf(scene));
        if (eVar != null) {
            eVar.d();
        }
    }
}
