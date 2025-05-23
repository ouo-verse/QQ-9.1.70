package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.TimingFuncType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/views/an;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "height", "duration", "c", "I", "getDurationMills", "()I", "durationMills", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "d", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "getCurve", "()Lcom/tencent/kuikly/core/base/TimingFuncType;", "curve", "<init>", "(FFILcom/tencent/kuikly/core/base/TimingFuncType;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.views.an, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class KeyboardParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float height;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float duration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int durationMills;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final TimingFuncType curve;

    public KeyboardParams(float f16, float f17, int i3, TimingFuncType curve) {
        Intrinsics.checkNotNullParameter(curve, "curve");
        this.height = f16;
        this.duration = f17;
        this.durationMills = i3;
        this.curve = curve;
    }

    /* renamed from: a, reason: from getter */
    public final float getDuration() {
        return this.duration;
    }

    /* renamed from: b, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.height) * 31) + Float.floatToIntBits(this.duration)) * 31) + this.durationMills) * 31) + this.curve.hashCode();
    }

    public String toString() {
        return "KeyboardParams(height=" + this.height + ", duration=" + this.duration + ", durationMills=" + this.durationMills + ", curve=" + this.curve + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardParams)) {
            return false;
        }
        KeyboardParams keyboardParams = (KeyboardParams) other;
        return Float.compare(this.height, keyboardParams.height) == 0 && Float.compare(this.duration, keyboardParams.duration) == 0 && this.durationMills == keyboardParams.durationMills && this.curve == keyboardParams.curve;
    }
}
