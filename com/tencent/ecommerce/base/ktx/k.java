package com.tencent.ecommerce.base.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/k;", "", "Lkotlin/Function0;", "", "callback", "a", "", "J", "lastRunTime", "b", "timeMills", "<init>", "(J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastRunTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long timeMills;

    public k(long j3) {
        this.timeMills = j3;
    }

    public final synchronized void a(Function0<Unit> callback) {
        if (System.currentTimeMillis() - this.lastRunTime > this.timeMills) {
            this.lastRunTime = System.currentTimeMillis();
            callback.invoke();
        } else {
            cg0.a.f("TriggerRunner", "trigger too fast, ignore...");
        }
    }
}
