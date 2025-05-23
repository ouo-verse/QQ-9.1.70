package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/i;", "", "", "key", "", "b", "event", "timestamp", "", "f", "e", "Lj01/a;", "data", "d", "", "forceUpdate", "c", "a", "toString", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "eventTimestamps", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, Long> eventTimestamps = new ConcurrentHashMap<>();

    private final long b(String key) {
        Long l3 = this.eventTimestamps.get(key);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Long> entry : this.eventTimestamps.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue().longValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
        return jSONObject2;
    }

    public final void c(boolean forceUpdate) {
        long j3;
        ConcurrentHashMap<String, Long> concurrentHashMap = this.eventTimestamps;
        if (forceUpdate) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        concurrentHashMap.put("is_force_update_load", Long.valueOf(j3));
    }

    public final void d(@NotNull j01.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.eventTimestamps.put("render_layer_read_cache_start", Long.valueOf(data.b(6)));
        this.eventTimestamps.put("render_layer_read_cache_end", Long.valueOf(data.b(7)));
        this.eventTimestamps.put("render_layer_render_cache_start", Long.valueOf(data.b(8)));
        this.eventTimestamps.put("render_layer_render_cache_end", Long.valueOf(data.b(9)));
        this.eventTimestamps.put("render_context_init_start", Long.valueOf(data.b(4)));
        this.eventTimestamps.put("render_context_init_end", Long.valueOf(data.b(5)));
        this.eventTimestamps.put("view_load_start", Long.valueOf(data.b(13)));
        this.eventTimestamps.put("view_load_end", Long.valueOf(data.b(14)));
        this.eventTimestamps.put("layout_start", Long.valueOf(data.b(15)));
        this.eventTimestamps.put("layout_end", Long.valueOf(data.b(16)));
    }

    public final void e(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        f(event, System.currentTimeMillis());
    }

    public final void f(@NotNull String event, long timestamp) {
        Intrinsics.checkNotNullParameter(event, "event");
        ConcurrentHashMap<String, Long> concurrentHashMap = this.eventTimestamps;
        if (timestamp <= 0) {
            timestamp = System.currentTimeMillis();
        }
        concurrentHashMap.put(event, Long.valueOf(timestamp));
    }

    @NotNull
    public String toString() {
        return "[LaunchCost]:isForceUpdate:" + this.eventTimestamps.get("is_force_update_load") + ",readCacheCost:" + (b("render_layer_read_cache_end") - b("render_layer_read_cache_start")) + ",renderCacheCost:" + (b("render_layer_render_cache_end") - b("render_layer_render_cache_start")) + ",fetchContextCost:" + (b("fetch_context_code_end") - b("fetch_context_code_start")) + ",initRenderContextCost: " + (b("render_context_init_end") - b("fetch_context_code_end")) + ",initModulesCost: " + (b("view_load_start") - b("render_context_init_end")) + ",pageBuildCost: " + (b("view_load_end") - b("view_load_start")) + ",pageLayoutCost: " + (b("layout_end") - b("layout_start")) + ",firstFramePaintCost: " + (b("content_view_created") - b("fetch_context_code_end")) + ",firstFrameAllCost: " + (b("content_view_created") - b(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS)) + ',';
    }
}
