package com.tencent.ntcompose.material;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB(\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR \u0010\u0016\u001a\u00020\u00128\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ntcompose/material/ad;", "Lcom/tencent/ntcompose/material/l;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "width", "getMiter", "miter", "Lcom/tencent/ntcompose/material/ae;", "c", "I", "()I", "cap", "<init>", "(FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "d", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.ntcompose.material.ad, reason: from toString */
/* loaded from: classes34.dex */
public final class Stroke extends l {

    /* renamed from: e, reason: collision with root package name */
    private static final int f339362e = ae.INSTANCE.a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float miter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cap;

    public /* synthetic */ Stroke(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, i3);
    }

    /* renamed from: a, reason: from getter */
    public final int getCap() {
        return this.cap;
    }

    /* renamed from: b, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.width) * 31) + Float.floatToIntBits(this.miter)) * 31) + ae.f(this.cap);
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) ae.h(this.cap)) + ')';
    }

    public /* synthetic */ Stroke(float f16, float f17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0.0f : f16, (i16 & 2) != 0 ? 4.0f : f17, (i16 & 4) != 0 ? f339362e : i3, null);
    }

    Stroke(float f16, float f17, int i3) {
        super(null);
        this.width = f16;
        this.miter = f17;
        this.cap = i3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) other;
        if (this.width == stroke.width) {
            return ((this.miter > stroke.miter ? 1 : (this.miter == stroke.miter ? 0 : -1)) == 0) && ae.d(this.cap, stroke.cap);
        }
        return false;
    }
}
