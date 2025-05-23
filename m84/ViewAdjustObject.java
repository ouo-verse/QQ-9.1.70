package m84;

import android.graphics.Rect;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0010\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u0015\u0010\u001dR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\n\u0010 \u00a8\u0006$"}, d2 = {"Lm84/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "f", "()Landroid/view/View;", "view", "", "b", UserInfo.SEX_FEMALE, "e", "()F", "scale", "c", "I", "d", "()I", "originalWidth", "originalHeight", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "originalMarginParams", "Z", "()Z", "needMarginScale", "<init>", "(Landroid/view/View;FIILandroid/graphics/Rect;Z)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: m84.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class ViewAdjustObject {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float scale;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int originalWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int originalHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final Rect originalMarginParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needMarginScale;

    public ViewAdjustObject(View view, float f16, int i3, int i16, Rect rect, boolean z16) {
        this.view = view;
        this.scale = f16;
        this.originalWidth = i3;
        this.originalHeight = i16;
        this.originalMarginParams = rect;
        this.needMarginScale = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedMarginScale() {
        return this.needMarginScale;
    }

    /* renamed from: b, reason: from getter */
    public final int getOriginalHeight() {
        return this.originalHeight;
    }

    /* renamed from: c, reason: from getter */
    public final Rect getOriginalMarginParams() {
        return this.originalMarginParams;
    }

    /* renamed from: d, reason: from getter */
    public final int getOriginalWidth() {
        return this.originalWidth;
    }

    /* renamed from: e, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* renamed from: f, reason: from getter */
    public final View getView() {
        return this.view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        View view = this.view;
        int hashCode = (((((((view == null ? 0 : view.hashCode()) * 31) + Float.floatToIntBits(this.scale)) * 31) + this.originalWidth) * 31) + this.originalHeight) * 31;
        Rect rect = this.originalMarginParams;
        int hashCode2 = (hashCode + (rect != null ? rect.hashCode() : 0)) * 31;
        boolean z16 = this.needMarginScale;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "ViewAdjustObject(view=" + this.view + ", scale=" + this.scale + ", originalWidth=" + this.originalWidth + ", originalHeight=" + this.originalHeight + ", originalMarginParams=" + this.originalMarginParams + ", needMarginScale=" + this.needMarginScale + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewAdjustObject)) {
            return false;
        }
        ViewAdjustObject viewAdjustObject = (ViewAdjustObject) other;
        return Intrinsics.areEqual(this.view, viewAdjustObject.view) && Float.compare(this.scale, viewAdjustObject.scale) == 0 && this.originalWidth == viewAdjustObject.originalWidth && this.originalHeight == viewAdjustObject.originalHeight && Intrinsics.areEqual(this.originalMarginParams, viewAdjustObject.originalMarginParams) && this.needMarginScale == viewAdjustObject.needMarginScale;
    }

    public /* synthetic */ ViewAdjustObject(View view, float f16, int i3, int i16, Rect rect, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, f16, i3, i16, (i17 & 16) != 0 ? null : rect, (i17 & 32) != 0 ? true : z16);
    }
}
