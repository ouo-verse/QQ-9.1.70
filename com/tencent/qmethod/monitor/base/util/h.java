package com.tencent.qmethod.monitor.base.util;

import android.util.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004R0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8\u0000@BX\u0080\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/h;", "", "", "scene", "", "e", "b", "endScene", "nextScene", "a", "d", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "timeMap", "<set-?>", "J", "c", "()J", "startTime", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: c, reason: collision with root package name */
    public static final h f343541c = new h();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Long> timeMap = new HashMap<>();

    h() {
    }

    public final void a(@NotNull String endScene, @NotNull String nextScene) {
        Intrinsics.checkParameterIsNotNull(endScene, "endScene");
        Intrinsics.checkParameterIsNotNull(nextScene, "nextScene");
        b(endScene);
        e(nextScene);
    }

    public final void b(@NotNull String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            long nanoTime = System.nanoTime();
            Long it = timeMap.get(scene);
            if (it != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(scene);
                sb5.append(" cost={");
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                sb5.append((nanoTime - it.longValue()) / 1000000.0d);
                sb5.append("ms}");
                Log.d("PandoraEx.TraceUtils", sb5.toString());
            }
        }
    }

    public final long c() {
        return startTime;
    }

    public final void d() {
        startTime = System.currentTimeMillis();
    }

    public final void e(@NotNull String scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            timeMap.put(scene, Long.valueOf(System.nanoTime()));
        }
    }
}
