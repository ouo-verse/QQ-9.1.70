package com.tencent.ntcompose.animation;

import com.tencent.kuikly.core.base.TimingFuncType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ntcompose/animation/m;", "T", "Lcom/tencent/ntcompose/animation/g;", "", "other", "", "equals", "", "hashCode", "a", "I", "b", "()I", "durationMillis", "delay", "Lcom/tencent/ntcompose/animation/h;", "c", "Lcom/tencent/ntcompose/animation/h;", "()Lcom/tencent/ntcompose/animation/h;", "easing", "d", "Z", "()Z", "repeatForever", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "e", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "()Lcom/tencent/kuikly/core/base/TimingFuncType;", "timingFuncType", "<init>", "(IILcom/tencent/ntcompose/animation/h;ZLcom/tencent/kuikly/core/base/TimingFuncType;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int durationMillis;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int delay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h easing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean repeatForever;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TimingFuncType timingFuncType;

    public m() {
        this(0, 0, null, false, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    /* renamed from: b, reason: from getter */
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: c, reason: from getter */
    public final h getEasing() {
        return this.easing;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getRepeatForever() {
        return this.repeatForever;
    }

    /* renamed from: e, reason: from getter */
    public final TimingFuncType getTimingFuncType() {
        return this.timingFuncType;
    }

    public boolean equals(Object other) {
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return mVar.durationMillis == this.durationMillis && mVar.delay == this.delay && Intrinsics.areEqual(mVar.easing, this.easing) && mVar.repeatForever == this.repeatForever;
    }

    public int hashCode() {
        return (((this.durationMillis * 31) + this.easing.hashCode()) * 31) + this.delay;
    }

    public m(int i3, int i16, h easing, boolean z16, TimingFuncType timingFuncType) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.durationMillis = i3;
        this.delay = i16;
        this.easing = easing;
        this.repeatForever = z16;
        this.timingFuncType = timingFuncType;
    }

    public /* synthetic */ m(int i3, int i16, h hVar, boolean z16, TimingFuncType timingFuncType, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 300 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? i.b() : hVar, (i17 & 8) == 0 ? z16 : false, (i17 & 16) != 0 ? null : timingFuncType);
    }
}
