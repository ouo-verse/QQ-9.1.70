package com.tencent.biz.richframework.layoutinflater;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003Js\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001J\t\u0010+\u001a\u00020,H\u00d6\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/PreloadConfig;", "", "launchPreloadCount", "", "launchGapMillTime", "preloadEnable", "", "blackLayoutIds", "", "tryFixMerge", "parentViewGroupPoolSize", "layoutTypeCacheCount", "viewClassTypeCount", "eachCacheCount", "preloadActivityTaskRecycle", "(IIZLjava/util/List;ZIIIIZ)V", "getBlackLayoutIds", "()Ljava/util/List;", "getEachCacheCount", "()I", "getLaunchGapMillTime", "getLaunchPreloadCount", "getLayoutTypeCacheCount", "getParentViewGroupPoolSize", "getPreloadActivityTaskRecycle", "()Z", "getPreloadEnable", "getTryFixMerge", "getViewClassTypeCount", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class PreloadConfig {

    @NotNull
    private final List<Integer> blackLayoutIds;
    private final int eachCacheCount;
    private final int launchGapMillTime;
    private final int launchPreloadCount;
    private final int layoutTypeCacheCount;
    private final int parentViewGroupPoolSize;
    private final boolean preloadActivityTaskRecycle;
    private final boolean preloadEnable;
    private final boolean tryFixMerge;
    private final int viewClassTypeCount;

    public PreloadConfig() {
        this(0, 0, false, null, false, 0, 0, 0, 0, false, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLaunchPreloadCount() {
        return this.launchPreloadCount;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getPreloadActivityTaskRecycle() {
        return this.preloadActivityTaskRecycle;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLaunchGapMillTime() {
        return this.launchGapMillTime;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPreloadEnable() {
        return this.preloadEnable;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.blackLayoutIds;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getTryFixMerge() {
        return this.tryFixMerge;
    }

    /* renamed from: component6, reason: from getter */
    public final int getParentViewGroupPoolSize() {
        return this.parentViewGroupPoolSize;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLayoutTypeCacheCount() {
        return this.layoutTypeCacheCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getViewClassTypeCount() {
        return this.viewClassTypeCount;
    }

    /* renamed from: component9, reason: from getter */
    public final int getEachCacheCount() {
        return this.eachCacheCount;
    }

    @NotNull
    public final PreloadConfig copy(int launchPreloadCount, int launchGapMillTime, boolean preloadEnable, @NotNull List<Integer> blackLayoutIds, boolean tryFixMerge, int parentViewGroupPoolSize, int layoutTypeCacheCount, int viewClassTypeCount, int eachCacheCount, boolean preloadActivityTaskRecycle) {
        Intrinsics.checkNotNullParameter(blackLayoutIds, "blackLayoutIds");
        return new PreloadConfig(launchPreloadCount, launchGapMillTime, preloadEnable, blackLayoutIds, tryFixMerge, parentViewGroupPoolSize, layoutTypeCacheCount, viewClassTypeCount, eachCacheCount, preloadActivityTaskRecycle);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PreloadConfig) {
                PreloadConfig preloadConfig = (PreloadConfig) other;
                if (this.launchPreloadCount != preloadConfig.launchPreloadCount || this.launchGapMillTime != preloadConfig.launchGapMillTime || this.preloadEnable != preloadConfig.preloadEnable || !Intrinsics.areEqual(this.blackLayoutIds, preloadConfig.blackLayoutIds) || this.tryFixMerge != preloadConfig.tryFixMerge || this.parentViewGroupPoolSize != preloadConfig.parentViewGroupPoolSize || this.layoutTypeCacheCount != preloadConfig.layoutTypeCacheCount || this.viewClassTypeCount != preloadConfig.viewClassTypeCount || this.eachCacheCount != preloadConfig.eachCacheCount || this.preloadActivityTaskRecycle != preloadConfig.preloadActivityTaskRecycle) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Integer> getBlackLayoutIds() {
        return this.blackLayoutIds;
    }

    public final int getEachCacheCount() {
        return this.eachCacheCount;
    }

    public final int getLaunchGapMillTime() {
        return this.launchGapMillTime;
    }

    public final int getLaunchPreloadCount() {
        return this.launchPreloadCount;
    }

    public final int getLayoutTypeCacheCount() {
        return this.layoutTypeCacheCount;
    }

    public final int getParentViewGroupPoolSize() {
        return this.parentViewGroupPoolSize;
    }

    public final boolean getPreloadActivityTaskRecycle() {
        return this.preloadActivityTaskRecycle;
    }

    public final boolean getPreloadEnable() {
        return this.preloadEnable;
    }

    public final boolean getTryFixMerge() {
        return this.tryFixMerge;
    }

    public final int getViewClassTypeCount() {
        return this.viewClassTypeCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16 = ((this.launchPreloadCount * 31) + this.launchGapMillTime) * 31;
        boolean z16 = this.preloadEnable;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        List<Integer> list = this.blackLayoutIds;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = (i19 + i3) * 31;
        boolean z17 = this.tryFixMerge;
        int i27 = z17;
        if (z17 != 0) {
            i27 = 1;
        }
        int i28 = (((((((((i26 + i27) * 31) + this.parentViewGroupPoolSize) * 31) + this.layoutTypeCacheCount) * 31) + this.viewClassTypeCount) * 31) + this.eachCacheCount) * 31;
        boolean z18 = this.preloadActivityTaskRecycle;
        if (!z18) {
            i17 = z18 ? 1 : 0;
        }
        return i28 + i17;
    }

    @NotNull
    public String toString() {
        return "PreloadConfig(launchPreloadCount=" + this.launchPreloadCount + ", launchGapMillTime=" + this.launchGapMillTime + ", preloadEnable=" + this.preloadEnable + ", blackLayoutIds=" + this.blackLayoutIds + ", tryFixMerge=" + this.tryFixMerge + ", parentViewGroupPoolSize=" + this.parentViewGroupPoolSize + ", layoutTypeCacheCount=" + this.layoutTypeCacheCount + ", viewClassTypeCount=" + this.viewClassTypeCount + ", eachCacheCount=" + this.eachCacheCount + ", preloadActivityTaskRecycle=" + this.preloadActivityTaskRecycle + ")";
    }

    public PreloadConfig(int i3, int i16, boolean z16, @NotNull List<Integer> blackLayoutIds, boolean z17, int i17, int i18, int i19, int i26, boolean z18) {
        Intrinsics.checkNotNullParameter(blackLayoutIds, "blackLayoutIds");
        this.launchPreloadCount = i3;
        this.launchGapMillTime = i16;
        this.preloadEnable = z16;
        this.blackLayoutIds = blackLayoutIds;
        this.tryFixMerge = z17;
        this.parentViewGroupPoolSize = i17;
        this.layoutTypeCacheCount = i18;
        this.viewClassTypeCount = i19;
        this.eachCacheCount = i26;
        this.preloadActivityTaskRecycle = z18;
    }

    public /* synthetic */ PreloadConfig(int i3, int i16, boolean z16, List list, boolean z17, int i17, int i18, int i19, int i26, boolean z18, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? 50 : i3, (i27 & 2) != 0 ? 20000 : i16, (i27 & 4) != 0 ? true : z16, (i27 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i27 & 16) != 0 ? true : z17, (i27 & 32) == 0 ? i17 : 50, (i27 & 64) != 0 ? 100 : i18, (i27 & 128) == 0 ? i19 : 100, (i27 & 256) != 0 ? 30 : i26, (i27 & 512) == 0 ? z18 : true);
    }
}
