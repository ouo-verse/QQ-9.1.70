package com.tencent.ntcompose.foundation.layout;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ntcompose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001B?\u0012\f\b\u0002\u0010\u0017\u001a\u00060\u0004j\u0002`\u0005\u0012\f\b\u0002\u0010\u001a\u001a\u00060\u0004j\u0002`\u0005\u0012\f\b\u0002\u0010\u001d\u001a\u00060\u0004j\u0002`\u0005\u0012\f\b\u0002\u0010 \u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\b\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\f\u0010\t\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0017\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R$\u0010\u001d\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R$\u0010 \u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001e\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/m;", "Lcom/tencent/ntcompose/foundation/layout/l;", "Lcom/tencent/ntcompose/ui/unit/LayoutDirection;", "layoutDirection", "", "Lcom/tencent/ntcompose/ui/unit/Dp;", "a", "c", "b", "d", "", "other", "", "equals", "", "hashCode", "", "toString", UserInfo.SEX_FEMALE, "getStart", "()F", "getStart$annotations", "()V", "start", "getTop", "getTop$annotations", "top", "getEnd", "getEnd$annotations", "end", "getBottom", "getBottom$annotations", "bottom", "<init>", "(FFFF)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.ntcompose.foundation.layout.m, reason: from toString */
/* loaded from: classes34.dex */
public final class PaddingValues implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float start;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float top;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float end;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float bottom;

    public PaddingValues() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    @Override // com.tencent.ntcompose.foundation.layout.l
    public float a(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.start;
        }
        return this.end;
    }

    @Override // com.tencent.ntcompose.foundation.layout.l
    public float b(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.end;
        }
        return this.start;
    }

    @Override // com.tencent.ntcompose.foundation.layout.l
    /* renamed from: c, reason: from getter */
    public float getTop() {
        return this.top;
    }

    @Override // com.tencent.ntcompose.foundation.layout.l
    /* renamed from: d, reason: from getter */
    public float getBottom() {
        return this.bottom;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PaddingValues)) {
            return false;
        }
        PaddingValues paddingValues = (PaddingValues) other;
        if (!(this.start == paddingValues.start)) {
            return false;
        }
        if (!(this.top == paddingValues.top)) {
            return false;
        }
        if (this.end == paddingValues.end) {
            return (this.bottom > paddingValues.bottom ? 1 : (this.bottom == paddingValues.bottom ? 0 : -1)) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.start) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.end)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + this.start + ", top=" + this.top + ", end=" + this.end + ", bottom=" + this.bottom + ')';
    }

    public PaddingValues(float f16, float f17, float f18, float f19) {
        this.start = f16;
        this.top = f17;
        this.end = f18;
        this.bottom = f19;
    }

    public /* synthetic */ PaddingValues(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : f16, (i3 & 2) != 0 ? 0 : f17, (i3 & 4) != 0 ? 0 : f18, (i3 & 8) != 0 ? 0 : f19);
    }
}
