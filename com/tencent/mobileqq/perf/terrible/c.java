package com.tencent.mobileqq.perf.terrible;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/c;", "", "Lcom/tencent/mobileqq/perf/terrible/c$a;", "onTurnFinishedCallback", "", "b", "Lcom/tencent/mobileqq/perf/terrible/a;", "envStateData", "a", "", "I", "getSize", "()I", "size", "getNext", "setNext", "(I)V", "next", "Lcom/tencent/mobileqq/perf/terrible/e;", "c", "Lcom/tencent/mobileqq/perf/terrible/e;", "getSamples", "()Lcom/tencent/mobileqq/perf/terrible/e;", "samples", "d", "Lcom/tencent/mobileqq/perf/terrible/a;", "getAccumulated", "()Lcom/tencent/mobileqq/perf/terrible/a;", "accumulated", "e", "getMaxValue", "maxValue", "f", "getTotal", "total", "g", "Lcom/tencent/mobileqq/perf/terrible/c$a;", "turnFinishedCallback", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int next;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e<com.tencent.mobileqq.perf.terrible.a> samples;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.perf.terrible.a accumulated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.perf.terrible.a maxValue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.perf.terrible.a total;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a turnFinishedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/c$a;", "", "Lcom/tencent/mobileqq/perf/terrible/a;", "accumulatedData", "maxValue", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull com.tencent.mobileqq.perf.terrible.a accumulatedData, @NotNull com.tencent.mobileqq.perf.terrible.a maxValue);
    }

    public c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.size = i3;
        this.samples = new e<>(i3);
        this.accumulated = new com.tencent.mobileqq.perf.terrible.a(0, 0, 0, 7, null);
        this.maxValue = new com.tencent.mobileqq.perf.terrible.a(0, 0, 0, 7, null);
        this.total = new com.tencent.mobileqq.perf.terrible.a(0, 0, 0, 7, null);
    }

    public final void a(@NotNull com.tencent.mobileqq.perf.terrible.a envStateData) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtLeast3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) envStateData);
            return;
        }
        Intrinsics.checkNotNullParameter(envStateData, "envStateData");
        if (this.next == this.size) {
            this.next = 0;
            a aVar = this.turnFinishedCallback;
            if (aVar != null) {
                aVar.a(this.accumulated.c(), this.maxValue.c());
            }
            this.accumulated.b();
            this.maxValue.b();
        }
        this.next++;
        this.samples.a(envStateData);
        this.accumulated.a(envStateData);
        this.total.a(envStateData);
        com.tencent.mobileqq.perf.terrible.a aVar2 = this.maxValue;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(aVar2.d(), envStateData.d());
        aVar2.g(coerceAtLeast);
        com.tencent.mobileqq.perf.terrible.a aVar3 = this.maxValue;
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(aVar3.f(), envStateData.f());
        aVar3.i(coerceAtLeast2);
        com.tencent.mobileqq.perf.terrible.a aVar4 = this.maxValue;
        coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(aVar4.e(), envStateData.e());
        aVar4.h(coerceAtLeast3);
    }

    public final void b(@NotNull a onTurnFinishedCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onTurnFinishedCallback);
        } else {
            Intrinsics.checkNotNullParameter(onTurnFinishedCallback, "onTurnFinishedCallback");
            this.turnFinishedCallback = onTurnFinishedCallback;
        }
    }
}
