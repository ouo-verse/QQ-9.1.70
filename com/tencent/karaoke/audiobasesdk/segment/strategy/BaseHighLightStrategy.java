package com.tencent.karaoke.audiobasesdk.segment.strategy;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.karaoke.audiobasesdk.segment.HighLightItem;
import com.tencent.karaoke.audiobasesdk.segment.SingScoreData;
import com.tencent.karaoke.audiobasesdk.segment.SingSegmentData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rJ\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tJ\u0016\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\tJ\b\u0010%\u001a\u00020\u001bH&J\b\u0010&\u001a\u00020\u001bH&J\b\u0010'\u001a\u00020\u001bH\u0016R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/strategy/BaseHighLightStrategy;", "", "offsetTime", "", "mSegmentList", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "mSingScoreList", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/segment/SingScoreData;", "Lkotlin/collections/ArrayList;", "(I[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;Ljava/util/ArrayList;)V", "mHighLightSegmentList", "Lcom/tencent/karaoke/audiobasesdk/segment/HighLightItem;", "getMHighLightSegmentList", "()Ljava/util/ArrayList;", "mMergedSegmentList", "getMMergedSegmentList", "setMMergedSegmentList", "(Ljava/util/ArrayList;)V", "getMSegmentList", "()[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "getMSingScoreList", "getOffsetTime", "()I", "abandonSegment", "", "alignSegment", "calculateHighLightTime", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "execute", "isIgnoreScore", "", "singScoreData", "isIncludeScoreItem", "singSegmentData", "mergeSegment", "pickScoreToSegment", "sortSegment", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public abstract class BaseHighLightStrategy {

    @NotNull
    private final ArrayList<HighLightItem> mHighLightSegmentList;

    @NotNull
    public ArrayList<SingSegmentData> mMergedSegmentList;

    @NotNull
    private final SingSegmentData[] mSegmentList;

    @NotNull
    private final ArrayList<SingScoreData> mSingScoreList;
    private final int offsetTime;

    public BaseHighLightStrategy(int i3, @NotNull SingSegmentData[] mSegmentList, @NotNull ArrayList<SingScoreData> mSingScoreList) {
        Intrinsics.checkParameterIsNotNull(mSegmentList, "mSegmentList");
        Intrinsics.checkParameterIsNotNull(mSingScoreList, "mSingScoreList");
        this.offsetTime = i3;
        this.mSegmentList = mSegmentList;
        this.mSingScoreList = mSingScoreList;
        this.mHighLightSegmentList = new ArrayList<>();
    }

    public abstract void abandonSegment();

    public void alignSegment() {
        Iterator<T> it = this.mHighLightSegmentList.iterator();
        while (it.hasNext()) {
            calculateHighLightTime((HighLightItem) it.next());
        }
    }

    @NotNull
    public final HighLightItem calculateHighLightTime(@NotNull HighLightItem item) {
        float f16;
        Intrinsics.checkParameterIsNotNull(item, "item");
        int i3 = item.hitCount;
        if (i3 > 0) {
            f16 = item.totalScore / i3;
        } else {
            f16 = 0.0f;
        }
        item.avgScore = f16;
        item.startTime = item.clipStarTime;
        item.endTime = item.clipEndTime;
        ArrayList<SingScoreData> arrayList = this.mSingScoreList;
        int i16 = item.beginLyricIndex;
        if (i16 >= 0) {
            item.startTime = arrayList.get(i16).getStartTime();
            item.endTime = arrayList.get(item.endLyricIndex).getEndTime();
        }
        return item;
    }

    @NotNull
    public final ArrayList<HighLightItem> execute() {
        mergeSegment();
        pickScoreToSegment();
        alignSegment();
        abandonSegment();
        sortSegment();
        return this.mHighLightSegmentList;
    }

    @NotNull
    public final ArrayList<HighLightItem> getMHighLightSegmentList() {
        return this.mHighLightSegmentList;
    }

    @NotNull
    public final ArrayList<SingSegmentData> getMMergedSegmentList() {
        ArrayList<SingSegmentData> arrayList = this.mMergedSegmentList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMergedSegmentList");
        }
        return arrayList;
    }

    @NotNull
    public final SingSegmentData[] getMSegmentList() {
        return this.mSegmentList;
    }

    @NotNull
    public final ArrayList<SingScoreData> getMSingScoreList() {
        return this.mSingScoreList;
    }

    public final int getOffsetTime() {
        return this.offsetTime;
    }

    public final boolean isIgnoreScore(@NotNull SingScoreData singScoreData) {
        Intrinsics.checkParameterIsNotNull(singScoreData, "singScoreData");
        if (singScoreData.getScore() < 0) {
            return true;
        }
        return false;
    }

    public final boolean isIncludeScoreItem(@NotNull SingSegmentData singSegmentData, @NotNull SingScoreData singScoreData) {
        Intrinsics.checkParameterIsNotNull(singSegmentData, "singSegmentData");
        Intrinsics.checkParameterIsNotNull(singScoreData, "singScoreData");
        if (singSegmentData.startTime <= singScoreData.getStartTime() && singSegmentData.endTime >= singScoreData.getEndTime()) {
            return true;
        }
        return false;
    }

    public abstract void mergeSegment();

    public abstract void pickScoreToSegment();

    public final void setMMergedSegmentList(@NotNull ArrayList<SingSegmentData> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.mMergedSegmentList = arrayList;
    }

    public void sortSegment() {
        List sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.mHighLightSegmentList, new Comparator<T>() { // from class: com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy$sortSegment$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(-((HighLightItem) t16).avgScore), Float.valueOf(-((HighLightItem) t17).avgScore));
                return compareValues;
            }
        });
        this.mHighLightSegmentList.clear();
        this.mHighLightSegmentList.addAll(sortedWith);
    }

    public /* synthetic */ BaseHighLightStrategy(int i3, SingSegmentData[] singSegmentDataArr, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, singSegmentDataArr, arrayList);
    }
}
