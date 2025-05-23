package com.tencent.state.square.api;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "", "textSize", "", "normalTextColor", "", "(FI)V", "getNormalTextColor", "()I", "getTextSize", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SquareSummaryViewConfig {
    private static final int DEFAULT_NORMAL_TEXT_COLOR = Color.parseColor("#888888");
    private static final float DEFAULT_TEXT_SIZE = 11.0f;
    private final int normalTextColor;
    private final float textSize;

    public SquareSummaryViewConfig() {
        this(0.0f, 0, 3, null);
    }

    public static /* synthetic */ SquareSummaryViewConfig copy$default(SquareSummaryViewConfig squareSummaryViewConfig, float f16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            f16 = squareSummaryViewConfig.textSize;
        }
        if ((i16 & 2) != 0) {
            i3 = squareSummaryViewConfig.normalTextColor;
        }
        return squareSummaryViewConfig.copy(f16, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNormalTextColor() {
        return this.normalTextColor;
    }

    @NotNull
    public final SquareSummaryViewConfig copy(float textSize, int normalTextColor) {
        return new SquareSummaryViewConfig(textSize, normalTextColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareSummaryViewConfig) {
                SquareSummaryViewConfig squareSummaryViewConfig = (SquareSummaryViewConfig) other;
                if (Float.compare(this.textSize, squareSummaryViewConfig.textSize) != 0 || this.normalTextColor != squareSummaryViewConfig.normalTextColor) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getNormalTextColor() {
        return this.normalTextColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.textSize) * 31) + this.normalTextColor;
    }

    @NotNull
    public String toString() {
        return "SquareSummaryViewConfig(textSize=" + this.textSize + ", normalTextColor=" + this.normalTextColor + ")";
    }

    public SquareSummaryViewConfig(float f16, int i3) {
        this.textSize = f16;
        this.normalTextColor = i3;
    }

    public /* synthetic */ SquareSummaryViewConfig(float f16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? DEFAULT_TEXT_SIZE : f16, (i16 & 2) != 0 ? DEFAULT_NORMAL_TEXT_COLOR : i3);
    }
}
