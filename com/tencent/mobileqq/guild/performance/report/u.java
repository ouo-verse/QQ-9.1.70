package com.tencent.mobileqq.guild.performance.report;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/u;", "", "", "event", "", "costTime", "", "a", AppConstants.Key.COLUMN_EXT_STR, "b", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f231061a = new u();

    u() {
    }

    @JvmStatic
    public static final void a(@NotNull String event, long costTime) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @JvmStatic
    public static final void b(@NotNull String event, long costTime, @NotNull String extStr) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(extStr, "extStr");
    }
}
