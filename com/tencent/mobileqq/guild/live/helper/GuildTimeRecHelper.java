package com.tencent.mobileqq.guild.live.helper;

import com.tencent.mobileqq.guild.util.timerecord.GuildAudioTimeEvent;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/live/helper/GuildTimeRecHelper;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTimeRecHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>>> f226685b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d>> f226686c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0007J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0018\u0010\u0017\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015H\u0007R\u007f\u0010\u001c\u001af\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u00060\u0004j2\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u0006`\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bRG\u0010 \u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u0004j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0015\u0012\u0004\u0012\u00020\u001d`\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/live/helper/GuildTimeRecHelper$a;", "", "Lcom/tencent/mobileqq/guild/util/timerecord/c;", "event", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/live/helper/d;", "Lkotlin/collections/HashMap;", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "accEvent", "a", "", "time", "d", "", "removeRecord", "j", "", "exitSituation", "l", "Ljava/lang/Class;", "clazz", "b", "sCacheMap$delegate", "Lkotlin/Lazy;", "g", "()Ljava/util/HashMap;", "sCacheMap", "Lcom/tencent/mobileqq/guild/util/timerecord/d;", "sReportProcessorMap$delegate", h.F, "sReportProcessorMap", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(Companion companion, com.tencent.mobileqq.guild.util.timerecord.c cVar, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = System.currentTimeMillis();
            }
            companion.d(cVar, j3);
        }

        private final HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord> f(com.tencent.mobileqq.guild.util.timerecord.c event) {
            HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord> hashMap = g().get(event.getClass());
            Intrinsics.checkNotNull(hashMap);
            return hashMap;
        }

        private final HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>> g() {
            return (HashMap) GuildTimeRecHelper.f226685b.getValue();
        }

        private final HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d> h() {
            return (HashMap) GuildTimeRecHelper.f226686c.getValue();
        }

        public static /* synthetic */ long k(Companion companion, com.tencent.mobileqq.guild.util.timerecord.c cVar, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            return companion.j(cVar, z16);
        }

        @JvmStatic
        public final void a(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event, @NotNull com.tencent.mobileqq.guild.util.timerecord.c accEvent) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(accEvent, "accEvent");
            e(this, accEvent, 0L, 2, null);
            long k3 = k(this, accEvent, false, 2, null);
            if (k3 == -1) {
                return;
            }
            HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord> f16 = f(event);
            if (!f16.containsKey(event)) {
                f16.put(event, new GuildTimeRecord(0L, k3));
                return;
            }
            GuildTimeRecord guildTimeRecord = f16.get(event);
            Intrinsics.checkNotNull(guildTimeRecord);
            GuildTimeRecord guildTimeRecord2 = guildTimeRecord;
            guildTimeRecord2.c(guildTimeRecord2.getEnd() + k3);
        }

        @JvmStatic
        public final void b(@NotNull Class<? extends com.tencent.mobileqq.guild.util.timerecord.c> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord> hashMap = g().get(clazz);
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        @JvmStatic
        @JvmOverloads
        public final void c(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event) {
            Intrinsics.checkNotNullParameter(event, "event");
            e(this, event, 0L, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void d(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event, long time) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildTimeRecord guildTimeRecord = f(event).get(event);
            if (guildTimeRecord != null) {
                guildTimeRecord.c(time);
            }
        }

        @JvmStatic
        @JvmOverloads
        public final long i(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return k(this, event, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        public final long j(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event, boolean removeRecord) {
            GuildTimeRecord guildTimeRecord;
            Intrinsics.checkNotNullParameter(event, "event");
            if (removeRecord) {
                guildTimeRecord = f(event).remove(event);
            } else {
                guildTimeRecord = f(event).get(event);
            }
            GuildTimeRecord guildTimeRecord2 = guildTimeRecord;
            if (guildTimeRecord2 != null) {
                return guildTimeRecord2.b();
            }
            return -1L;
        }

        @JvmStatic
        public final void l(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event, int exitSituation) {
            Intrinsics.checkNotNullParameter(event, "event");
            long k3 = k(this, event, false, 2, null);
            if (k3 == -1) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_stay_mic_time", Long.valueOf(k3));
            hashMap.put("sgrp_exit_situation", Integer.valueOf(exitSituation));
            com.tencent.mobileqq.guild.util.timerecord.d dVar = h().get(event.getClass());
            if (dVar != null) {
                dVar.a("ev_mic_stay_time", hashMap);
            }
        }

        @JvmStatic
        public final void m(@NotNull com.tencent.mobileqq.guild.util.timerecord.c event) {
            Intrinsics.checkNotNullParameter(event, "event");
            f(event).put(event, new GuildTimeRecord(System.currentTimeMillis(), 0L, 2, null));
        }

        Companion() {
        }
    }

    static {
        Lazy<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>>> lazy;
        Lazy<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d>> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>>>() { // from class: com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper$Companion$sCacheMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>> invoke() {
                HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, HashMap<com.tencent.mobileqq.guild.util.timerecord.c, GuildTimeRecord>> hashMap = new HashMap<>();
                hashMap.put(GuildAudioTimeEvent.class, new HashMap<>());
                hashMap.put(GuildLiveTimeEvent.class, new HashMap<>());
                return hashMap;
            }
        });
        f226685b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d>>() { // from class: com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper$Companion$sReportProcessorMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d> invoke() {
                HashMap<Class<? extends com.tencent.mobileqq.guild.util.timerecord.c>, com.tencent.mobileqq.guild.util.timerecord.d> hashMap = new HashMap<>();
                hashMap.put(GuildAudioTimeEvent.class, new com.tencent.mobileqq.guild.util.timerecord.a());
                hashMap.put(GuildLiveTimeEvent.class, new com.tencent.mobileqq.guild.util.timerecord.b());
                return hashMap;
            }
        });
        f226686c = lazy2;
    }

    @JvmStatic
    public static final void c(@NotNull Class<? extends com.tencent.mobileqq.guild.util.timerecord.c> cls) {
        INSTANCE.b(cls);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull com.tencent.mobileqq.guild.util.timerecord.c cVar) {
        INSTANCE.c(cVar);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@NotNull com.tencent.mobileqq.guild.util.timerecord.c cVar, long j3) {
        INSTANCE.d(cVar, j3);
    }

    @JvmStatic
    @JvmOverloads
    public static final long f(@NotNull com.tencent.mobileqq.guild.util.timerecord.c cVar) {
        return INSTANCE.i(cVar);
    }

    @JvmStatic
    public static final void g(@NotNull com.tencent.mobileqq.guild.util.timerecord.c cVar) {
        INSTANCE.m(cVar);
    }
}
