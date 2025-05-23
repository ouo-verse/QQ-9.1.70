package androidx.recyclerview.widget;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\tH\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Landroidx/recyclerview/widget/ItemPreloadConfig;", "", "createNodeIfEmpty", "", "useQuickRecord", "minHeightPercent", "", "useSection", "postTaskMode", "", "preloadPageCount", "considerRecycler", "(ZZFZIFZ)V", "getConsiderRecycler", "()Z", "getCreateNodeIfEmpty", "getMinHeightPercent", "()F", "getPostTaskMode", "()I", "getPreloadPageCount", "getUseQuickRecord", "getUseSection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final /* data */ class ItemPreloadConfig {
    private final boolean considerRecycler;
    private final boolean createNodeIfEmpty;
    private final float minHeightPercent;
    private final int postTaskMode;
    private final float preloadPageCount;
    private final boolean useQuickRecord;
    private final boolean useSection;

    public ItemPreloadConfig() {
        this(false, false, 0.0f, false, 0, 0.0f, false, 127, null);
    }

    public static /* synthetic */ ItemPreloadConfig copy$default(ItemPreloadConfig itemPreloadConfig, boolean z16, boolean z17, float f16, boolean z18, int i3, float f17, boolean z19, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = itemPreloadConfig.createNodeIfEmpty;
        }
        if ((i16 & 2) != 0) {
            z17 = itemPreloadConfig.useQuickRecord;
        }
        boolean z26 = z17;
        if ((i16 & 4) != 0) {
            f16 = itemPreloadConfig.minHeightPercent;
        }
        float f18 = f16;
        if ((i16 & 8) != 0) {
            z18 = itemPreloadConfig.useSection;
        }
        boolean z27 = z18;
        if ((i16 & 16) != 0) {
            i3 = itemPreloadConfig.postTaskMode;
        }
        int i17 = i3;
        if ((i16 & 32) != 0) {
            f17 = itemPreloadConfig.preloadPageCount;
        }
        float f19 = f17;
        if ((i16 & 64) != 0) {
            z19 = itemPreloadConfig.considerRecycler;
        }
        return itemPreloadConfig.copy(z16, z26, f18, z27, i17, f19, z19);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCreateNodeIfEmpty() {
        return this.createNodeIfEmpty;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getUseQuickRecord() {
        return this.useQuickRecord;
    }

    /* renamed from: component3, reason: from getter */
    public final float getMinHeightPercent() {
        return this.minHeightPercent;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUseSection() {
        return this.useSection;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPostTaskMode() {
        return this.postTaskMode;
    }

    /* renamed from: component6, reason: from getter */
    public final float getPreloadPageCount() {
        return this.preloadPageCount;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getConsiderRecycler() {
        return this.considerRecycler;
    }

    @NotNull
    public final ItemPreloadConfig copy(boolean createNodeIfEmpty, boolean useQuickRecord, float minHeightPercent, boolean useSection, int postTaskMode, float preloadPageCount, boolean considerRecycler) {
        return new ItemPreloadConfig(createNodeIfEmpty, useQuickRecord, minHeightPercent, useSection, postTaskMode, preloadPageCount, considerRecycler);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ItemPreloadConfig) {
                ItemPreloadConfig itemPreloadConfig = (ItemPreloadConfig) other;
                if (this.createNodeIfEmpty != itemPreloadConfig.createNodeIfEmpty || this.useQuickRecord != itemPreloadConfig.useQuickRecord || Float.compare(this.minHeightPercent, itemPreloadConfig.minHeightPercent) != 0 || this.useSection != itemPreloadConfig.useSection || this.postTaskMode != itemPreloadConfig.postTaskMode || Float.compare(this.preloadPageCount, itemPreloadConfig.preloadPageCount) != 0 || this.considerRecycler != itemPreloadConfig.considerRecycler) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean getConsiderRecycler() {
        return this.considerRecycler;
    }

    public final boolean getCreateNodeIfEmpty() {
        return this.createNodeIfEmpty;
    }

    public final float getMinHeightPercent() {
        return this.minHeightPercent;
    }

    public final int getPostTaskMode() {
        return this.postTaskMode;
    }

    public final float getPreloadPageCount() {
        return this.preloadPageCount;
    }

    public final boolean getUseQuickRecord() {
        return this.useQuickRecord;
    }

    public final boolean getUseSection() {
        return this.useSection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.createNodeIfEmpty;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.useQuickRecord;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int floatToIntBits = (((i16 + i17) * 31) + Float.floatToIntBits(this.minHeightPercent)) * 31;
        ?? r27 = this.useSection;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int floatToIntBits2 = (((((floatToIntBits + i18) * 31) + this.postTaskMode) * 31) + Float.floatToIntBits(this.preloadPageCount)) * 31;
        boolean z17 = this.considerRecycler;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return floatToIntBits2 + i3;
    }

    @NotNull
    public String toString() {
        return "ItemPreloadConfig(createNodeIfEmpty=" + this.createNodeIfEmpty + ", useQuickRecord=" + this.useQuickRecord + ", minHeightPercent=" + this.minHeightPercent + ", useSection=" + this.useSection + ", postTaskMode=" + this.postTaskMode + ", preloadPageCount=" + this.preloadPageCount + ", considerRecycler=" + this.considerRecycler + ")";
    }

    public ItemPreloadConfig(boolean z16, boolean z17, float f16, boolean z18, int i3, float f17, boolean z19) {
        this.createNodeIfEmpty = z16;
        this.useQuickRecord = z17;
        this.minHeightPercent = f16;
        this.useSection = z18;
        this.postTaskMode = i3;
        this.preloadPageCount = f17;
        this.considerRecycler = z19;
    }

    public /* synthetic */ ItemPreloadConfig(boolean z16, boolean z17, float f16, boolean z18, int i3, float f17, boolean z19, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? true : z16, (i16 & 2) == 0 ? z17 : true, (i16 & 4) != 0 ? 0.4f : f16, (i16 & 8) != 0 ? false : z18, (i16 & 16) != 0 ? 2 : i3, (i16 & 32) != 0 ? 2.0f : f17, (i16 & 64) != 0 ? false : z19);
    }
}
