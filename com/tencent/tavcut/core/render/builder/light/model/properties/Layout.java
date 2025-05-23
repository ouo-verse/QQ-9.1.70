package com.tencent.tavcut.core.render.builder.light.model.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;", "", "width", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/tavcut/core/render/builder/light/model/properties/Layout;", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Layout {

    @Nullable
    private final Integer height;

    @Nullable
    private final Integer width;

    public Layout() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Layout copy$default(Layout layout, Integer num, Integer num2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = layout.width;
        }
        if ((i3 & 2) != 0) {
            num2 = layout.height;
        }
        return layout.copy(num, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    @NotNull
    public final Layout copy(@Nullable Integer width, @Nullable Integer height) {
        return new Layout(width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Layout) {
                Layout layout = (Layout) other;
                if (!Intrinsics.areEqual(this.width, layout.width) || !Intrinsics.areEqual(this.height, layout.height)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        Integer num = this.width;
        int i16 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Integer num2 = this.height;
        if (num2 != null) {
            i16 = num2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "Layout(width=" + this.width + ", height=" + this.height + ")";
    }

    public Layout(@Nullable Integer num, @Nullable Integer num2) {
        this.width = num;
        this.height = num2;
    }

    public /* synthetic */ Layout(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : num, (i3 & 2) != 0 ? 0 : num2);
    }
}
