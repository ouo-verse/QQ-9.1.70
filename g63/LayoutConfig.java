package g63;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.videocut.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003JE\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016\u00a8\u0006!"}, d2 = {"Lg63/b;", "", "", "a", "b", "c", "", "panelStartOffset", "courseTopMargin", "courseWidth", "courseHeight", "courseElevation", "courseColor", "d", "", "toString", "hashCode", "other", "", "equals", "I", "k", "()I", UserInfo.SEX_FEMALE, "i", "()F", "j", h.F, "e", "g", "f", "<init>", "(IFFFFI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g63.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class LayoutConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int panelStartOffset;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseTopMargin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseElevation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int courseColor;

    public LayoutConfig() {
        this(0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 63, null);
    }

    public static /* synthetic */ LayoutConfig e(LayoutConfig layoutConfig, int i3, float f16, float f17, float f18, float f19, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = layoutConfig.panelStartOffset;
        }
        if ((i17 & 2) != 0) {
            f16 = layoutConfig.courseTopMargin;
        }
        float f26 = f16;
        if ((i17 & 4) != 0) {
            f17 = layoutConfig.courseWidth;
        }
        float f27 = f17;
        if ((i17 & 8) != 0) {
            f18 = layoutConfig.courseHeight;
        }
        float f28 = f18;
        if ((i17 & 16) != 0) {
            f19 = layoutConfig.courseElevation;
        }
        float f29 = f19;
        if ((i17 & 32) != 0) {
            i16 = layoutConfig.courseColor;
        }
        return layoutConfig.d(i3, f26, f27, f28, f29, i16);
    }

    /* renamed from: a, reason: from getter */
    public final float getCourseWidth() {
        return this.courseWidth;
    }

    /* renamed from: b, reason: from getter */
    public final float getCourseHeight() {
        return this.courseHeight;
    }

    /* renamed from: c, reason: from getter */
    public final float getCourseElevation() {
        return this.courseElevation;
    }

    @NotNull
    public final LayoutConfig d(int panelStartOffset, float courseTopMargin, float courseWidth, float courseHeight, float courseElevation, int courseColor) {
        return new LayoutConfig(panelStartOffset, courseTopMargin, courseWidth, courseHeight, courseElevation, courseColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutConfig)) {
            return false;
        }
        LayoutConfig layoutConfig = (LayoutConfig) other;
        if (this.panelStartOffset == layoutConfig.panelStartOffset && Float.compare(this.courseTopMargin, layoutConfig.courseTopMargin) == 0 && Float.compare(this.courseWidth, layoutConfig.courseWidth) == 0 && Float.compare(this.courseHeight, layoutConfig.courseHeight) == 0 && Float.compare(this.courseElevation, layoutConfig.courseElevation) == 0 && this.courseColor == layoutConfig.courseColor) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getCourseColor() {
        return this.courseColor;
    }

    public final float g() {
        return this.courseElevation;
    }

    public final float h() {
        return this.courseHeight;
    }

    public int hashCode() {
        return (((((((((this.panelStartOffset * 31) + Float.floatToIntBits(this.courseTopMargin)) * 31) + Float.floatToIntBits(this.courseWidth)) * 31) + Float.floatToIntBits(this.courseHeight)) * 31) + Float.floatToIntBits(this.courseElevation)) * 31) + this.courseColor;
    }

    /* renamed from: i, reason: from getter */
    public final float getCourseTopMargin() {
        return this.courseTopMargin;
    }

    public final float j() {
        return this.courseWidth;
    }

    /* renamed from: k, reason: from getter */
    public final int getPanelStartOffset() {
        return this.panelStartOffset;
    }

    @NotNull
    public String toString() {
        return "LayoutConfig(panelStartOffset=" + this.panelStartOffset + ", courseTopMargin=" + this.courseTopMargin + ", courseWidth=" + this.courseWidth + ", courseHeight=" + this.courseHeight + ", courseElevation=" + this.courseElevation + ", courseColor=" + this.courseColor + ")";
    }

    public LayoutConfig(int i3, float f16, float f17, float f18, float f19, int i16) {
        this.panelStartOffset = i3;
        this.courseTopMargin = f16;
        this.courseWidth = f17;
        this.courseHeight = f18;
        this.courseElevation = f19;
        this.courseColor = i16;
    }

    public /* synthetic */ LayoutConfig(int i3, float f16, float f17, float f18, float f19, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? o.g() / 2 : i3, (i17 & 2) != 0 ? 1.0f : f16, (i17 & 4) != 0 ? 3.0f : f17, (i17 & 8) != 0 ? 68.0f : f18, (i17 & 16) == 0 ? f19 : 3.0f, (i17 & 32) != 0 ? -1 : i16);
    }
}
