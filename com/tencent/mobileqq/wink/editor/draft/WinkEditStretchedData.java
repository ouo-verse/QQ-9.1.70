package com.tencent.mobileqq.wink.editor.draft;

import com.heytap.databaseengine.model.UserInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BI\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00c6\u0003JO\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "component7", "isStretched", "originWidth", "originHeight", "originTopY", "originBottomY", "originScaleX", "originScaleY", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Z", "()Z", "setStretched", "(Z)V", UserInfo.SEX_FEMALE, "getOriginWidth", "()F", "setOriginWidth", "(F)V", "getOriginHeight", "setOriginHeight", "getOriginTopY", "setOriginTopY", "getOriginBottomY", "setOriginBottomY", "getOriginScaleX", "setOriginScaleX", "getOriginScaleY", "setOriginScaleY", "<init>", "(ZFFFFFF)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkEditStretchedData implements Serializable {
    private static final long serialVersionUID = 599093938747237757L;
    private boolean isStretched;
    private float originBottomY;
    private float originHeight;
    private float originScaleX;
    private float originScaleY;
    private float originTopY;
    private float originWidth;

    public WinkEditStretchedData(boolean z16, float f16, float f17, float f18, float f19, float f26, float f27) {
        this.isStretched = z16;
        this.originWidth = f16;
        this.originHeight = f17;
        this.originTopY = f18;
        this.originBottomY = f19;
        this.originScaleX = f26;
        this.originScaleY = f27;
    }

    public static /* synthetic */ WinkEditStretchedData copy$default(WinkEditStretchedData winkEditStretchedData, boolean z16, float f16, float f17, float f18, float f19, float f26, float f27, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = winkEditStretchedData.isStretched;
        }
        if ((i3 & 2) != 0) {
            f16 = winkEditStretchedData.originWidth;
        }
        float f28 = f16;
        if ((i3 & 4) != 0) {
            f17 = winkEditStretchedData.originHeight;
        }
        float f29 = f17;
        if ((i3 & 8) != 0) {
            f18 = winkEditStretchedData.originTopY;
        }
        float f36 = f18;
        if ((i3 & 16) != 0) {
            f19 = winkEditStretchedData.originBottomY;
        }
        float f37 = f19;
        if ((i3 & 32) != 0) {
            f26 = winkEditStretchedData.originScaleX;
        }
        float f38 = f26;
        if ((i3 & 64) != 0) {
            f27 = winkEditStretchedData.originScaleY;
        }
        return winkEditStretchedData.copy(z16, f28, f29, f36, f37, f38, f27);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsStretched() {
        return this.isStretched;
    }

    /* renamed from: component2, reason: from getter */
    public final float getOriginWidth() {
        return this.originWidth;
    }

    /* renamed from: component3, reason: from getter */
    public final float getOriginHeight() {
        return this.originHeight;
    }

    /* renamed from: component4, reason: from getter */
    public final float getOriginTopY() {
        return this.originTopY;
    }

    /* renamed from: component5, reason: from getter */
    public final float getOriginBottomY() {
        return this.originBottomY;
    }

    /* renamed from: component6, reason: from getter */
    public final float getOriginScaleX() {
        return this.originScaleX;
    }

    /* renamed from: component7, reason: from getter */
    public final float getOriginScaleY() {
        return this.originScaleY;
    }

    @NotNull
    public final WinkEditStretchedData copy(boolean isStretched, float originWidth, float originHeight, float originTopY, float originBottomY, float originScaleX, float originScaleY) {
        return new WinkEditStretchedData(isStretched, originWidth, originHeight, originTopY, originBottomY, originScaleX, originScaleY);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEditStretchedData)) {
            return false;
        }
        WinkEditStretchedData winkEditStretchedData = (WinkEditStretchedData) other;
        if (this.isStretched == winkEditStretchedData.isStretched && Float.compare(this.originWidth, winkEditStretchedData.originWidth) == 0 && Float.compare(this.originHeight, winkEditStretchedData.originHeight) == 0 && Float.compare(this.originTopY, winkEditStretchedData.originTopY) == 0 && Float.compare(this.originBottomY, winkEditStretchedData.originBottomY) == 0 && Float.compare(this.originScaleX, winkEditStretchedData.originScaleX) == 0 && Float.compare(this.originScaleY, winkEditStretchedData.originScaleY) == 0) {
            return true;
        }
        return false;
    }

    public final float getOriginBottomY() {
        return this.originBottomY;
    }

    public final float getOriginHeight() {
        return this.originHeight;
    }

    public final float getOriginScaleX() {
        return this.originScaleX;
    }

    public final float getOriginScaleY() {
        return this.originScaleY;
    }

    public final float getOriginTopY() {
        return this.originTopY;
    }

    public final float getOriginWidth() {
        return this.originWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z16 = this.isStretched;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((r06 * 31) + Float.floatToIntBits(this.originWidth)) * 31) + Float.floatToIntBits(this.originHeight)) * 31) + Float.floatToIntBits(this.originTopY)) * 31) + Float.floatToIntBits(this.originBottomY)) * 31) + Float.floatToIntBits(this.originScaleX)) * 31) + Float.floatToIntBits(this.originScaleY);
    }

    public final boolean isStretched() {
        return this.isStretched;
    }

    public final void setOriginBottomY(float f16) {
        this.originBottomY = f16;
    }

    public final void setOriginHeight(float f16) {
        this.originHeight = f16;
    }

    public final void setOriginScaleX(float f16) {
        this.originScaleX = f16;
    }

    public final void setOriginScaleY(float f16) {
        this.originScaleY = f16;
    }

    public final void setOriginTopY(float f16) {
        this.originTopY = f16;
    }

    public final void setOriginWidth(float f16) {
        this.originWidth = f16;
    }

    public final void setStretched(boolean z16) {
        this.isStretched = z16;
    }

    @NotNull
    public String toString() {
        return "WinkEditStretchedData(isStretched=" + this.isStretched + ", originWidth=" + this.originWidth + ", originHeight=" + this.originHeight + ", originTopY=" + this.originTopY + ", originBottomY=" + this.originBottomY + ", originScaleX=" + this.originScaleX + ", originScaleY=" + this.originScaleY + ")";
    }

    public /* synthetic */ WinkEditStretchedData(boolean z16, float f16, float f17, float f18, float f19, float f26, float f27, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, f16, f17, (i3 & 8) != 0 ? 0.0f : f18, (i3 & 16) != 0 ? 0.0f : f19, (i3 & 32) != 0 ? 1.0f : f26, (i3 & 64) != 0 ? 1.0f : f27);
    }
}
