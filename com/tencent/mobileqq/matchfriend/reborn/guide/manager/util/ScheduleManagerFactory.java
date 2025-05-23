package com.tencent.mobileqq.matchfriend.reborn.guide.manager.util;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManagerFactory;", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ScheduleManagerFactory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy<ConcurrentHashMap<String, ScheduleManager>> f245112b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManagerFactory$a;", "", "", "businessTag", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "sInstanceMap$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/ConcurrentHashMap;", "sInstanceMap", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManagerFactory$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ConcurrentHashMap<String, ScheduleManager> b() {
            return (ConcurrentHashMap) ScheduleManagerFactory.f245112b.getValue();
        }

        @JvmStatic
        public final ScheduleManager a(String businessTag) {
            Intrinsics.checkNotNullParameter(businessTag, "businessTag");
            ScheduleManager scheduleManager = b().get(businessTag);
            if (scheduleManager == null) {
                synchronized (this) {
                    Companion companion = ScheduleManagerFactory.INSTANCE;
                    ScheduleManager scheduleManager2 = companion.b().get(businessTag);
                    if (scheduleManager2 == null) {
                        scheduleManager2 = new ScheduleManager(businessTag);
                        companion.b().put(businessTag, scheduleManager2);
                    }
                    scheduleManager = scheduleManager2;
                    Intrinsics.checkNotNullExpressionValue(scheduleManager, "sInstanceMap[businessTag\u2026g] = it\n                }");
                }
            }
            return scheduleManager;
        }

        Companion() {
        }
    }

    static {
        Lazy<ConcurrentHashMap<String, ScheduleManager>> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, ScheduleManager>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManagerFactory$Companion$sInstanceMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, ScheduleManager> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        f245112b = lazy;
    }
}
