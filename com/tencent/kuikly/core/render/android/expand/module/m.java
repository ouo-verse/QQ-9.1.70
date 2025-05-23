package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.performace.KRPerformanceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J5\u0010\r\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/m;", "Li01/e;", "", "jsonStr", "", "c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "method", "params", "call", "Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;", "d", "Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;", "performanceManager", "<init>", "(Lcom/tencent/kuikly/core/render/android/performace/KRPerformanceManager;)V", "e", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class m extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final KRPerformanceManager performanceManager;

    public m(@Nullable KRPerformanceManager kRPerformanceManager) {
        this.performanceManager = kRPerformanceManager;
    }

    private final void a(Function1<Object, Unit> callback) {
        com.tencent.kuikly.core.render.android.performace.c cVar;
        KRPerformanceManager kRPerformanceManager = this.performanceManager;
        JSONObject jSONObject = null;
        if (kRPerformanceManager != null) {
            cVar = kRPerformanceManager.s();
        } else {
            cVar = null;
        }
        if (callback != null) {
            if (cVar != null) {
                jSONObject = cVar.a();
            }
            callback.invoke(jSONObject);
        }
    }

    private final void c(String jsonStr) {
        KRPerformanceManager kRPerformanceManager;
        j01.b bVar;
        if (jsonStr != null && (kRPerformanceManager = this.performanceManager) != null && (bVar = (j01.b) kRPerformanceManager.r("KRLaunchMonitor")) != null) {
            bVar.t(new u(jsonStr));
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1234274083) {
            if (hashCode == -689852988 && method.equals("getPerformanceData")) {
                a(callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("onPageCreateFinish")) {
            c(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
