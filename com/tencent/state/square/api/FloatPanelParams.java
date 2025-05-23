package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/api/FloatPanelParams;", "", "height", "", "isMaskBackground", "", "isDragViewTransparent", "dragHandleResource", "(IZZLjava/lang/Integer;)V", "getDragHandleResource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "()I", "()Z", "component1", "component2", "component3", "component4", "copy", "(IZZLjava/lang/Integer;)Lcom/tencent/state/square/api/FloatPanelParams;", "equals", "other", "hashCode", "toString", "", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class FloatPanelParams {

    @Nullable
    private final Integer dragHandleResource;
    private final int height;
    private final boolean isDragViewTransparent;
    private final boolean isMaskBackground;

    public FloatPanelParams() {
        this(0, false, false, null, 15, null);
    }

    public static /* synthetic */ FloatPanelParams copy$default(FloatPanelParams floatPanelParams, int i3, boolean z16, boolean z17, Integer num, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = floatPanelParams.height;
        }
        if ((i16 & 2) != 0) {
            z16 = floatPanelParams.isMaskBackground;
        }
        if ((i16 & 4) != 0) {
            z17 = floatPanelParams.isDragViewTransparent;
        }
        if ((i16 & 8) != 0) {
            num = floatPanelParams.dragHandleResource;
        }
        return floatPanelParams.copy(i3, z16, z17, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMaskBackground() {
        return this.isMaskBackground;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsDragViewTransparent() {
        return this.isDragViewTransparent;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getDragHandleResource() {
        return this.dragHandleResource;
    }

    @NotNull
    public final FloatPanelParams copy(int height, boolean isMaskBackground, boolean isDragViewTransparent, @Nullable Integer dragHandleResource) {
        return new FloatPanelParams(height, isMaskBackground, isDragViewTransparent, dragHandleResource);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FloatPanelParams) {
                FloatPanelParams floatPanelParams = (FloatPanelParams) other;
                if (this.height != floatPanelParams.height || this.isMaskBackground != floatPanelParams.isMaskBackground || this.isDragViewTransparent != floatPanelParams.isDragViewTransparent || !Intrinsics.areEqual(this.dragHandleResource, floatPanelParams.dragHandleResource)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getDragHandleResource() {
        return this.dragHandleResource;
    }

    public final int getHeight() {
        return this.height;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16 = this.height * 31;
        boolean z16 = this.isMaskBackground;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.isDragViewTransparent;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        int i26 = (i19 + i17) * 31;
        Integer num = this.dragHandleResource;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        return i26 + i3;
    }

    public final boolean isDragViewTransparent() {
        return this.isDragViewTransparent;
    }

    public final boolean isMaskBackground() {
        return this.isMaskBackground;
    }

    @NotNull
    public String toString() {
        return "FloatPanelParams(height=" + this.height + ", isMaskBackground=" + this.isMaskBackground + ", isDragViewTransparent=" + this.isDragViewTransparent + ", dragHandleResource=" + this.dragHandleResource + ")";
    }

    public FloatPanelParams(int i3, boolean z16, boolean z17, @Nullable Integer num) {
        this.height = i3;
        this.isMaskBackground = z16;
        this.isDragViewTransparent = z17;
        this.dragHandleResource = num;
    }

    public /* synthetic */ FloatPanelParams(int i3, boolean z16, boolean z17, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? false : z17, (i16 & 8) != 0 ? null : num);
    }
}
