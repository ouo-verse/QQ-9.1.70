package com.tencent.qqnt.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qqnt.startup.task.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/startup/task/c;", "Lcom/tencent/qqnt/startup/task/b;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c extends b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static boolean a(@NotNull c cVar) {
            return b.C9701b.a(cVar);
        }

        public static int b(@NotNull c cVar) {
            return b.C9701b.b(cVar);
        }

        public static boolean c(@NotNull c cVar) {
            return b.C9701b.c(cVar);
        }
    }

    void run(@NotNull Context context);
}
