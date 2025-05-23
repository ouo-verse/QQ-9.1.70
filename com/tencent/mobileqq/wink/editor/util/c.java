package com.tencent.mobileqq.wink.editor.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0003R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/c;", "", "Lkotlin/Function0;", "", "action", "b", "a", "", "J", "timePeriod", "lastStartTime", "<init>", "(J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long timePeriod;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long lastStartTime;

    public c(long j3) {
        this.timePeriod = j3;
    }

    public final void a() {
        this.lastStartTime = System.currentTimeMillis();
    }

    public final void b(@NotNull Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastStartTime < this.timePeriod) {
            return;
        }
        action.invoke();
        this.lastStartTime = currentTimeMillis;
    }
}
