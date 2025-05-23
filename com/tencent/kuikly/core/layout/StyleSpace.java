package com.tencent.kuikly.core.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0002\n\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/layout/StyleSpace;", "", "Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "spacingType", "fallbackType", "", "b", "value", "", "c", "a", "", "[F", "spacing", "", "I", "valueFlags", "<init>", "()V", "Type", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StyleSpace {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f117299d = {1, 2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float[] spacing = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int valueFlags;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/kuikly/core/layout/StyleSpace$Type;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "LEFT", "TOP", "RIGHT", "BOTTOM", "VERTICAL", "HORIZONTAL", "START", "END", "ALL", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public enum Type {
        LEFT(0),
        TOP(1),
        RIGHT(2),
        BOTTOM(3),
        VERTICAL(4),
        HORIZONTAL(5),
        START(6),
        END(7),
        ALL(8);

        Type(int i3) {
        }
    }

    public final float a(Type spacingType) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        return this.spacing[spacingType.ordinal()];
    }

    public final float b(Type spacingType, Type fallbackType) {
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        Intrinsics.checkNotNullParameter(fallbackType, "fallbackType");
        if ((this.valueFlags & f117299d[spacingType.ordinal()]) != 0) {
            return this.spacing[spacingType.ordinal()];
        }
        return this.spacing[fallbackType.ordinal()];
    }

    public final void c(Type spacingType, float value) {
        int i3;
        Intrinsics.checkNotNullParameter(spacingType, "spacingType");
        float f16 = this.spacing[spacingType.ordinal()];
        boolean z16 = true;
        if (Float.isNaN(f16) || Float.isNaN(value) ? !Float.isNaN(f16) || !Float.isNaN(value) : Math.abs(value - f16) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.spacing[spacingType.ordinal()] = value;
        if (Float.isNaN(value)) {
            i3 = (~f117299d[spacingType.ordinal()]) & this.valueFlags;
        } else {
            i3 = f117299d[spacingType.ordinal()] | this.valueFlags;
        }
        this.valueFlags = i3;
    }
}
