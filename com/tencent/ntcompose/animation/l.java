package com.tencent.ntcompose.animation;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BM\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\r\u0010\u0012R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0018\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/ntcompose/animation/l;", "T", "", "other", "", "equals", "", "hashCode", "", "a", UserInfo.SEX_FEMALE, "()F", "dampingRatio", "b", "getStiffness", "stiffness", "c", "I", "()I", "durationMillis", "d", "f", "velocity", "Lcom/tencent/ntcompose/animation/h;", "e", "Lcom/tencent/ntcompose/animation/h;", "()Lcom/tencent/ntcompose/animation/h;", "easing", "delayMillis", "g", "Z", "()Z", "repeatForever", "<init>", "(FFIFLcom/tencent/ntcompose/animation/h;IZ)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l<T> implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float dampingRatio;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float stiffness;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int durationMillis;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float velocity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final h easing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int delayMillis;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean repeatForever;

    public l() {
        this(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    /* renamed from: b, reason: from getter */
    public final int getDelayMillis() {
        return this.delayMillis;
    }

    /* renamed from: c, reason: from getter */
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: d, reason: from getter */
    public final h getEasing() {
        return this.easing;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRepeatForever() {
        return this.repeatForever;
    }

    public boolean equals(Object other) {
        if (!(other instanceof l)) {
            return false;
        }
        l lVar = (l) other;
        if (!(lVar.dampingRatio == this.dampingRatio)) {
            return false;
        }
        if (lVar.stiffness == this.stiffness) {
            return ((lVar.velocity > this.velocity ? 1 : (lVar.velocity == this.velocity ? 0 : -1)) == 0) && Intrinsics.areEqual(lVar.easing, this.easing) && lVar.delayMillis == this.delayMillis && lVar.repeatForever == this.repeatForever;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final float getVelocity() {
        return this.velocity;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.velocity) * 31) + Float.floatToIntBits(this.dampingRatio)) * 31) + Float.floatToIntBits(this.stiffness);
    }

    public l(float f16, float f17, int i3, float f18, h easing, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.dampingRatio = f16;
        this.stiffness = f17;
        this.durationMillis = i3;
        this.velocity = f18;
        this.easing = easing;
        this.delayMillis = i16;
        this.repeatForever = z16;
    }

    public /* synthetic */ l(float f16, float f17, int i3, float f18, h hVar, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 1.0f : f16, (i17 & 2) != 0 ? 1500.0f : f17, (i17 & 4) != 0 ? 300 : i3, (i17 & 8) == 0 ? f18 : 1.0f, (i17 & 16) != 0 ? i.b() : hVar, (i17 & 32) != 0 ? 0 : i16, (i17 & 64) != 0 ? false : z16);
    }
}
