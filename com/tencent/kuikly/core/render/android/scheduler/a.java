package com.tencent.kuikly.core.render.android.scheduler;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/render/android/scheduler/a;", "", "", "delayMs", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KuiklyRenderCoreTask;", "task", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.scheduler.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5875a {
        public static /* synthetic */ void a(a aVar, long j3, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = 0;
                }
                aVar.a(j3, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scheduleTask");
        }
    }

    void a(long delayMs, @NotNull Function0<Unit> task);
}
