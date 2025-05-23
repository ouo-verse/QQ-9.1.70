package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Rect;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0016\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\t\u0010\"R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b \u0010\u0011R\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "text", "b", "I", "i", "()I", "res", "c", "e", "drawablePadding", "d", "drawableLeft", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "drawableLeftBounds", "f", "drawableRight", "g", "drawableRightBounds", tl.h.F, "Z", "()Z", LayoutAttrDefine.ALIGN_TOP, "k", "width", "height", "contentPadding", "<init>", "(Ljava/lang/String;IIILandroid/graphics/Rect;ILandroid/graphics/Rect;ZIII)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.g, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TagData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int res;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int drawablePadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int drawableLeft;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Rect drawableLeftBounds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int drawableRight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Rect drawableRightBounds;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean alignTop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentPadding;

    public TagData(@NotNull String text, int i3, int i16, int i17, @Nullable Rect rect, int i18, @Nullable Rect rect2, boolean z16, int i19, int i26, int i27) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.res = i3;
        this.drawablePadding = i16;
        this.drawableLeft = i17;
        this.drawableLeftBounds = rect;
        this.drawableRight = i18;
        this.drawableRightBounds = rect2;
        this.alignTop = z16;
        this.width = i19;
        this.height = i26;
        this.contentPadding = i27;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAlignTop() {
        return this.alignTop;
    }

    /* renamed from: b, reason: from getter */
    public final int getContentPadding() {
        return this.contentPadding;
    }

    /* renamed from: c, reason: from getter */
    public final int getDrawableLeft() {
        return this.drawableLeft;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Rect getDrawableLeftBounds() {
        return this.drawableLeftBounds;
    }

    /* renamed from: e, reason: from getter */
    public final int getDrawablePadding() {
        return this.drawablePadding;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagData)) {
            return false;
        }
        TagData tagData = (TagData) other;
        if (Intrinsics.areEqual(this.text, tagData.text) && this.res == tagData.res && this.drawablePadding == tagData.drawablePadding && this.drawableLeft == tagData.drawableLeft && Intrinsics.areEqual(this.drawableLeftBounds, tagData.drawableLeftBounds) && this.drawableRight == tagData.drawableRight && Intrinsics.areEqual(this.drawableRightBounds, tagData.drawableRightBounds) && this.alignTop == tagData.alignTop && this.width == tagData.width && this.height == tagData.height && this.contentPadding == tagData.contentPadding) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getDrawableRight() {
        return this.drawableRight;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Rect getDrawableRightBounds() {
        return this.drawableRightBounds;
    }

    /* renamed from: h, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.text.hashCode() * 31) + this.res) * 31) + this.drawablePadding) * 31) + this.drawableLeft) * 31;
        Rect rect = this.drawableLeftBounds;
        int i3 = 0;
        if (rect == null) {
            hashCode = 0;
        } else {
            hashCode = rect.hashCode();
        }
        int i16 = (((hashCode2 + hashCode) * 31) + this.drawableRight) * 31;
        Rect rect2 = this.drawableRightBounds;
        if (rect2 != null) {
            i3 = rect2.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.alignTop;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return ((((((i17 + i18) * 31) + this.width) * 31) + this.height) * 31) + this.contentPadding;
    }

    /* renamed from: i, reason: from getter */
    public final int getRes() {
        return this.res;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: k, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "TagData(text=" + this.text + ", res=" + this.res + ", drawablePadding=" + this.drawablePadding + ", drawableLeft=" + this.drawableLeft + ", drawableLeftBounds=" + this.drawableLeftBounds + ", drawableRight=" + this.drawableRight + ", drawableRightBounds=" + this.drawableRightBounds + ", alignTop=" + this.alignTop + ", width=" + this.width + ", height=" + this.height + ", contentPadding=" + this.contentPadding + ")";
    }

    public /* synthetic */ TagData(String str, int i3, int i16, int i17, Rect rect, int i18, Rect rect2, boolean z16, int i19, int i26, int i27, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i28 & 2) != 0 ? 0 : i3, (i28 & 4) != 0 ? 0 : i16, (i28 & 8) != 0 ? 0 : i17, (i28 & 16) != 0 ? null : rect, (i28 & 32) != 0 ? 0 : i18, (i28 & 64) == 0 ? rect2 : null, (i28 & 128) == 0 ? z16 : false, (i28 & 256) != 0 ? -2 : i19, (i28 & 512) != 0 ? ViewExKt.d(16) : i26, (i28 & 1024) != 0 ? ViewExKt.d(4) : i27);
    }
}
