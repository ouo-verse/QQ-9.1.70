package com.tencent.mobileqq.guild.util.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b \u0010!J0\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0017j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019RH\u0010\u001d\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\u0004\u0012\u00020\u001c0\u0017j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\u0004\u0012\u00020\u001c`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019RH\u0010\u001f\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\u0004\u0012\u00020\u001e0\u0017j\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\u0004\u0012\u00020\u001e`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/util/report/SampleReporter;", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "tag", "Lcom/tencent/mobileqq/guild/util/report/c;", "callback", "", "isPublicVersion", "isGrayVersion", "isDebugVersion", "d", "f", "", "e", "b", "", "subTag", h.F, "c", "g", "a", "Lcom/tencent/mobileqq/guild/util/report/c;", "reportCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "tagEnableMap", "Lkotlin/Pair;", "", "startTimeMap", "", "avgTimeCostMap", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SampleReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c reportCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<GuildHistogramScene, Boolean> tagEnableMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Pair<GuildHistogramScene, String>, Long> startTimeMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Pair<GuildHistogramScene, String>, Float> avgTimeCostMap = new HashMap<>();

    private final boolean d(GuildHistogramScene tag, c callback, boolean isPublicVersion, boolean isGrayVersion, boolean isDebugVersion) {
        if (isDebugVersion) {
            return false;
        }
        if ((isPublicVersion && !isGrayVersion) || Random.INSTANCE.nextInt(1000) > callback.b(tag, isPublicVersion)) {
            return false;
        }
        return true;
    }

    private final boolean f(GuildHistogramScene tag) {
        Boolean bool = this.tagEnableMap.get(tag);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void b() {
        this.reportCallback = null;
        this.tagEnableMap.clear();
        this.startTimeMap.clear();
        this.avgTimeCostMap.clear();
    }

    public final void c(@NotNull GuildHistogramScene tag, @NotNull String subTag) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        if (!f(tag)) {
            return;
        }
        Pair<GuildHistogramScene, String> pair = new Pair<>(tag, subTag);
        if (this.startTimeMap.containsKey(pair)) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            Long l3 = this.startTimeMap.get(pair);
            Intrinsics.checkNotNull(l3);
            float longValue = ((float) (elapsedRealtimeNanos - l3.longValue())) / 1000000.0f;
            Float f16 = this.avgTimeCostMap.get(pair);
            if (f16 == null) {
                f16 = Float.valueOf(0.0f);
            }
            float floatValue = f16.floatValue();
            HashMap<Pair<GuildHistogramScene, String>, Float> hashMap = this.avgTimeCostMap;
            if (floatValue == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                longValue = (longValue + floatValue) / 2.0f;
            }
            hashMap.put(pair, Float.valueOf(longValue));
        }
    }

    public final void e(@NotNull c callback, boolean isPublicVersion, boolean isGrayVersion, boolean isDebugVersion) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        b();
        this.reportCallback = callback;
        for (GuildHistogramScene guildHistogramScene : callback.a()) {
            this.tagEnableMap.put(guildHistogramScene, Boolean.valueOf(d(guildHistogramScene, callback, isPublicVersion, isGrayVersion, isDebugVersion)));
        }
    }

    public final void g() {
        if (!this.avgTimeCostMap.isEmpty()) {
            Object clone = this.avgTimeCostMap.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.HashMap<kotlin.Pair<com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene, kotlin.String>, kotlin.Float>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Pair<com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene, kotlin.String>, kotlin.Float> }");
            HashMap hashMap = (HashMap) clone;
            this.avgTimeCostMap.clear();
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "GuildAioSampleReporter_report", null, null, null, new SampleReporter$report$1(hashMap, this, null), 14, null);
            }
        }
    }

    public final void h(@NotNull GuildHistogramScene tag, @NotNull String subTag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        if (!f(tag)) {
            return;
        }
        this.startTimeMap.put(new Pair<>(tag, subTag), Long.valueOf(SystemClock.elapsedRealtimeNanos()));
    }
}
