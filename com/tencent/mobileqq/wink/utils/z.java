package com.tencent.mobileqq.wink.utils;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/z;", "", "Lkotlin/Function0;", "", "callback", "a", "", "J", "timeMills", "b", "lastRunTime", "<init>", "(J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long timeMills;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastRunTime;

    public z(long j3) {
        this.timeMills = j3;
    }

    public final synchronized void a(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (SystemClock.uptimeMillis() - this.lastRunTime <= this.timeMills) {
            return;
        }
        this.lastRunTime = SystemClock.uptimeMillis();
        callback.invoke();
    }
}
