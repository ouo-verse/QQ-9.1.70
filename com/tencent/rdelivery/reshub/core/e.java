package com.tencent.rdelivery.reshub.core;

import androidx.annotation.GuardedBy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0017j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0004`\u00198\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/e;", "", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/core/ResLoadingTask;", "e", "d", "", "a", "", "status", "", "downloadSize", "totalSize", "", "f", "isSuccess", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "c", "Ljz3/e;", "resConfig", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "loadingTasks", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f364425b = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @GuardedBy("this")
    private static final HashMap<String, ResLoadingTask> loadingTasks = new HashMap<>();

    e() {
    }

    private final synchronized ResLoadingTask d(k req) {
        return loadingTasks.remove(k.p(req, null, 1, null));
    }

    private final synchronized ResLoadingTask e(k req) {
        return loadingTasks.get(k.p(req, null, 1, null));
    }

    public final synchronized boolean a(@NotNull k req) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(req, "req");
        z16 = true;
        String p16 = k.p(req, null, 1, null);
        HashMap<String, ResLoadingTask> hashMap = loadingTasks;
        ResLoadingTask resLoadingTask = hashMap.get(p16);
        if (resLoadingTask != null) {
            resLoadingTask.a(req);
            jz3.d.e("GlobalLoadingTask", "Request(" + p16 + ") is Already Loading, Add to Exist LoadingTask.");
            z16 = false;
        } else {
            ResLoadingTask resLoadingTask2 = new ResLoadingTask();
            resLoadingTask2.a(req);
            hashMap.put(p16, resLoadingTask2);
        }
        return z16;
    }

    public final void b(@NotNull k req, @Nullable jz3.e resConfig) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        ResLoadingTask d16 = d(req);
        if (d16 != null) {
            d16.d(resConfig);
        }
    }

    public final void c(boolean isSuccess, int status, @NotNull k req, @NotNull com.tencent.rdelivery.reshub.report.a errorInfo) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        ResLoadingTask d16 = d(req);
        if (d16 != null) {
            d16.e(isSuccess, errorInfo);
        }
    }

    public final void f(int status, long downloadSize, long totalSize, @NotNull k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        ResLoadingTask e16 = e(req);
        if (e16 != null) {
            e16.g(status, downloadSize, totalSize);
        }
    }
}
