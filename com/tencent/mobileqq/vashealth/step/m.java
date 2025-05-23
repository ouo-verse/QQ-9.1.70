package com.tencent.mobileqq.vashealth.step;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0012\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/m;", "", "", "toString", "a", "Ljava/lang/String;", "getDayKey", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "dayKey", "", "b", "I", "()I", "g", "(I)V", "step", "c", "e", "sensorValue", "", "J", "()J", tl.h.F, "(J)V", "updateTime", "getShutdownTime", "f", "shutdownTime", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String dayKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int step;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int sensorValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long updateTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long shutdownTime;

    /* renamed from: a, reason: from getter */
    public final int getSensorValue() {
        return this.sensorValue;
    }

    /* renamed from: b, reason: from getter */
    public final int getStep() {
        return this.step;
    }

    /* renamed from: c, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void d(@Nullable String str) {
        this.dayKey = str;
    }

    public final void e(int i3) {
        this.sensorValue = i3;
    }

    public final void f(long j3) {
        this.shutdownTime = j3;
    }

    public final void g(int i3) {
        this.step = i3;
    }

    public final void h(long j3) {
        this.updateTime = j3;
    }

    @NotNull
    public String toString() {
        return " dayKey=" + this.dayKey + ",step=" + this.step + ",sensorValue=" + this.sensorValue + ",updateTime=" + this.updateTime + ",shutdownTime=" + this.shutdownTime;
    }
}
