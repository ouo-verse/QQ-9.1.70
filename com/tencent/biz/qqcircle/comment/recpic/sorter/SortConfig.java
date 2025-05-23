package com.tencent.biz.qqcircle.comment.recpic.sorter;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\u000bBw\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0014\u0010\u001eR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u0019R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u0019R\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0018\u001a\u0004\b \u0010\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "", "a", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "strategyWeights", "b", UserInfo.SEX_FEMALE, "()F", "decayFactor", "c", "getMinScore", "minScore", "d", "I", "()I", "decayThreshold", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/FilterStrategy;", "e", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/FilterStrategy;", "()Lcom/tencent/biz/qqcircle/comment/recpic/sorter/FilterStrategy;", "filterStrategy", "f", "hybridThresholdStart", "hybridThresholdEnd", h.F, "getMaxUnSortedCount", "maxUnSortedCount", "i", "getMaxUnSortedTime", "maxUnSortedTime", "j", "maxCount", "<init>", "(Ljava/util/Map;FFILcom/tencent/biz/qqcircle/comment/recpic/sorter/FilterStrategy;IIIII)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.sorter.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class SortConfig {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<Integer, Float> strategyWeights;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float decayFactor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float minScore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int decayThreshold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FilterStrategy filterStrategy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hybridThresholdStart;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hybridThresholdEnd;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxUnSortedCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxUnSortedTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\r\u001a\u00020\f*\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b$a;", "", "", "index", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/FilterStrategy;", "c", "Lorg/json/JSONArray;", HippyControllerProps.ARRAY, "", "", "b", "Lorg/json/JSONObject;", "Lcom/tencent/biz/qqcircle/comment/recpic/sorter/b;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.comment.recpic.sorter.b$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<Integer, Float> b(JSONArray array) {
            HashMap hashMap = new HashMap();
            if (array != null) {
                int length = array.length();
                int i3 = 0;
                while (i3 < length) {
                    int i16 = i3 + 1;
                    hashMap.put(Integer.valueOf(i16), Float.valueOf((float) array.optDouble(i3)));
                    i3 = i16;
                }
            }
            return hashMap;
        }

        private final FilterStrategy c(int index) {
            if (index != 0) {
                if (index != 1) {
                    return FilterStrategy.HYBRID;
                }
                return FilterStrategy.ADJACENT_DIFFERENT;
            }
            return FilterStrategy.GLOBAL_DIFFERENT;
        }

        @NotNull
        public final SortConfig a(@NotNull JSONObject jSONObject) {
            int optInt;
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new SortConfig(null, 0.0f, 0.0f, 0, null, 0, 0, 0, 0, 0, 1023, null);
            }
            Map<Integer, Float> b16 = b(jSONObject.optJSONArray("weights"));
            float optDouble = (float) jSONObject.optDouble("dacay_factor");
            float optDouble2 = (float) jSONObject.optDouble("min_score");
            int optInt2 = jSONObject.optInt("decay_threshold");
            FilterStrategy c16 = c(jSONObject.optInt("filter_strategy"));
            int optInt3 = jSONObject.optInt("hybrid_threshold_start");
            int optInt4 = jSONObject.optInt("hybrid_threshold_end");
            int optInt5 = jSONObject.optInt("max_unsorted_count");
            int optInt6 = jSONObject.optInt("max_unsorted_time");
            if (jSONObject.optInt("max_count") == 0) {
                optInt = 30;
            } else {
                optInt = jSONObject.optInt("max_count");
            }
            return new SortConfig(b16, optDouble, optDouble2, optInt2, c16, optInt3, optInt4, optInt5, optInt6, optInt);
        }

        Companion() {
        }
    }

    public SortConfig() {
        this(null, 0.0f, 0.0f, 0, null, 0, 0, 0, 0, 0, 1023, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getDecayFactor() {
        return this.decayFactor;
    }

    /* renamed from: b, reason: from getter */
    public final int getDecayThreshold() {
        return this.decayThreshold;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final FilterStrategy getFilterStrategy() {
        return this.filterStrategy;
    }

    /* renamed from: d, reason: from getter */
    public final int getHybridThresholdEnd() {
        return this.hybridThresholdEnd;
    }

    /* renamed from: e, reason: from getter */
    public final int getHybridThresholdStart() {
        return this.hybridThresholdStart;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SortConfig)) {
            return false;
        }
        SortConfig sortConfig = (SortConfig) other;
        if (Intrinsics.areEqual(this.strategyWeights, sortConfig.strategyWeights) && Float.compare(this.decayFactor, sortConfig.decayFactor) == 0 && Float.compare(this.minScore, sortConfig.minScore) == 0 && this.decayThreshold == sortConfig.decayThreshold && this.filterStrategy == sortConfig.filterStrategy && this.hybridThresholdStart == sortConfig.hybridThresholdStart && this.hybridThresholdEnd == sortConfig.hybridThresholdEnd && this.maxUnSortedCount == sortConfig.maxUnSortedCount && this.maxUnSortedTime == sortConfig.maxUnSortedTime && this.maxCount == sortConfig.maxCount) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    public final Map<Integer, Float> g() {
        return this.strategyWeights;
    }

    public int hashCode() {
        return (((((((((((((((((this.strategyWeights.hashCode() * 31) + Float.floatToIntBits(this.decayFactor)) * 31) + Float.floatToIntBits(this.minScore)) * 31) + this.decayThreshold) * 31) + this.filterStrategy.hashCode()) * 31) + this.hybridThresholdStart) * 31) + this.hybridThresholdEnd) * 31) + this.maxUnSortedCount) * 31) + this.maxUnSortedTime) * 31) + this.maxCount;
    }

    @NotNull
    public String toString() {
        return "SortConfig(strategyWeights=" + this.strategyWeights + ", decayFactor=" + this.decayFactor + ", minScore=" + this.minScore + ", decayThreshold=" + this.decayThreshold + ", filterStrategy=" + this.filterStrategy + ", hybridThresholdStart=" + this.hybridThresholdStart + ", hybridThresholdEnd=" + this.hybridThresholdEnd + ", maxUnSortedCount=" + this.maxUnSortedCount + ", maxUnSortedTime=" + this.maxUnSortedTime + ", maxCount=" + this.maxCount + ")";
    }

    public SortConfig(@NotNull Map<Integer, Float> strategyWeights, float f16, float f17, int i3, @NotNull FilterStrategy filterStrategy, int i16, int i17, int i18, int i19, int i26) {
        Intrinsics.checkNotNullParameter(strategyWeights, "strategyWeights");
        Intrinsics.checkNotNullParameter(filterStrategy, "filterStrategy");
        this.strategyWeights = strategyWeights;
        this.decayFactor = f16;
        this.minScore = f17;
        this.decayThreshold = i3;
        this.filterStrategy = filterStrategy;
        this.hybridThresholdStart = i16;
        this.hybridThresholdEnd = i17;
        this.maxUnSortedCount = i18;
        this.maxUnSortedTime = i19;
        this.maxCount = i26;
    }

    public /* synthetic */ SortConfig(Map map, float f16, float f17, int i3, FilterStrategy filterStrategy, int i16, int i17, int i18, int i19, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? MapsKt__MapsKt.mapOf(TuplesKt.to(1, Float.valueOf(1.0f)), TuplesKt.to(2, Float.valueOf(1.0f)), TuplesKt.to(3, Float.valueOf(1.2f)), TuplesKt.to(4, Float.valueOf(1.5f)), TuplesKt.to(5, Float.valueOf(1.4f)), TuplesKt.to(6, Float.valueOf(1.5f)), TuplesKt.to(7, Float.valueOf(1.0f))) : map, (i27 & 2) != 0 ? 0.5f : f16, (i27 & 4) != 0 ? 0.1f : f17, (i27 & 8) != 0 ? 4 : i3, (i27 & 16) != 0 ? FilterStrategy.HYBRID : filterStrategy, (i27 & 32) == 0 ? i16 : 4, (i27 & 64) != 0 ? 10 : i17, (i27 & 128) == 0 ? i18 : 5, (i27 & 256) == 0 ? i19 : 3, (i27 & 512) != 0 ? 30 : i26);
    }
}
