package com.tencent.karaoke.audiobasesdk.segment.strategy;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.segment.HighLightItem;
import com.tencent.karaoke.audiobasesdk.segment.MediaSingSegmentBusiness;
import com.tencent.karaoke.audiobasesdk.segment.SingScoreData;
import com.tencent.karaoke.audiobasesdk.segment.SingSegmentData;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0002J\b\u0010,\u001a\u00020\u0018H\u0016J(\u0010-\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0003H\u0002J\b\u0010/\u001a\u00020\u0018H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/strategy/GreedyHighLightStrategy;", "Lcom/tencent/karaoke/audiobasesdk/segment/strategy/BaseHighLightStrategy;", "offsetTime", "", "filterConfig", "Lcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;", "segmentList", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "singScoreList", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/segment/SingScoreData;", "Lkotlin/collections/ArrayList;", "(ILcom/tencent/karaoke/audiobasesdk/segment/MediaSingSegmentBusiness$FilterConfig;[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;Ljava/util/ArrayList;)V", "AverageScoreAtLeast", "", "MergeMaxDuration", "MergeMaxInterval", "MergeMinDuration", "MinLineRequired", "TAG", "", "clipTimePadding", "abandonSegment", "", "addSegmentPadding", "curSegmentData", "starIndex", "endIndex", "alignSegment", "createSegmentData", "oldSegment", "startIndex", "distinctHighLightList", "isCrossScoreItem", "", "singSegmentData", "singScoreData", "isInValidItem", "highLightItem", "Lcom/tencent/karaoke/audiobasesdk/segment/HighLightItem;", "mergeItem", "startItem", "endItem", "mergeSegment", "pickScoreInclude", "curScoreIndex", "pickScoreToSegment", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class GreedyHighLightStrategy extends BaseHighLightStrategy {
    private final float AverageScoreAtLeast;
    private final int MergeMaxDuration;
    private final int MergeMaxInterval;
    private final int MergeMinDuration;
    private final int MinLineRequired;
    private final String TAG;
    private final int clipTimePadding;

    public /* synthetic */ GreedyHighLightStrategy(int i3, MediaSingSegmentBusiness.FilterConfig filterConfig, SingSegmentData[] singSegmentDataArr, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, filterConfig, singSegmentDataArr, arrayList);
    }

    private final void addSegmentPadding(SingSegmentData curSegmentData, int starIndex, int endIndex) {
        Object orNull;
        Object orNull2;
        int i3;
        int coerceIn;
        int i16;
        int coerceIn2;
        orNull = ArraysKt___ArraysKt.getOrNull(getMSegmentList(), starIndex - 1);
        SingSegmentData singSegmentData = (SingSegmentData) orNull;
        orNull2 = ArraysKt___ArraysKt.getOrNull(getMSegmentList(), endIndex + 1);
        SingSegmentData singSegmentData2 = (SingSegmentData) orNull2;
        int i17 = curSegmentData.startTime;
        if (singSegmentData != null) {
            i3 = singSegmentData.endTime;
        } else {
            i3 = i17 - this.clipTimePadding;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(i17 - i3, 0, this.clipTimePadding);
        if (singSegmentData2 != null) {
            i16 = singSegmentData2.startTime;
        } else {
            int i18 = curSegmentData.endTime;
            i16 = i18 - i18;
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn(i16, 0, this.clipTimePadding);
        int i19 = curSegmentData.startTime - coerceIn;
        curSegmentData.startTime = i19;
        if (i19 >= 0) {
            RangesKt___RangesKt.coerceIn(i19, 0, i19);
        } else {
            curSegmentData.startTime = 0;
        }
        curSegmentData.endTime += coerceIn2;
    }

    private final SingSegmentData createSegmentData(SingSegmentData oldSegment, int startIndex, int endIndex) {
        SingSegmentData singSegmentData = new SingSegmentData();
        singSegmentData.startTime = oldSegment.startTime;
        singSegmentData.endTime = oldSegment.endTime;
        addSegmentPadding(singSegmentData, startIndex, endIndex);
        return singSegmentData;
    }

    private final void distinctHighLightList() {
        float f16;
        HashMap hashMap = new HashMap();
        for (HighLightItem highLightItem : getMHighLightSegmentList()) {
            if (!isInValidItem(highLightItem)) {
                HighLightItem highLightItem2 = (HighLightItem) hashMap.get(Integer.valueOf(highLightItem.startTime));
                float f17 = highLightItem.avgScore;
                if (highLightItem2 != null) {
                    f16 = highLightItem2.avgScore;
                } else {
                    f16 = 0.0f;
                }
                if (f17 > f16) {
                    hashMap.put(Integer.valueOf(highLightItem.startTime), highLightItem);
                } else if (highLightItem2 != null && f17 == highLightItem2.avgScore) {
                    Integer valueOf = Integer.valueOf(highLightItem.startTime);
                    if (highLightItem.endTime <= highLightItem2.endTime) {
                        highLightItem = highLightItem2;
                    }
                    hashMap.put(valueOf, highLightItem);
                }
            }
        }
        getMHighLightSegmentList().clear();
        getMHighLightSegmentList().addAll(hashMap.values());
    }

    private final boolean isCrossScoreItem(SingSegmentData singSegmentData, SingScoreData singScoreData) {
        int startTime = singScoreData.getStartTime();
        int endTime = singScoreData.getEndTime();
        int i3 = singSegmentData.startTime;
        if (startTime > i3 || endTime < i3) {
            int startTime2 = singScoreData.getStartTime();
            int endTime2 = singScoreData.getEndTime();
            int i16 = singSegmentData.endTime;
            if (startTime2 > i16 || endTime2 < i16) {
                return false;
            }
        }
        return true;
    }

    private final boolean isInValidItem(HighLightItem highLightItem) {
        if (highLightItem.hitCount >= this.MinLineRequired && highLightItem.avgScore >= this.AverageScoreAtLeast) {
            int i3 = highLightItem.endTime;
            int i16 = highLightItem.startTime;
            if (i3 - i16 >= this.MergeMinDuration && i3 - i16 <= this.MergeMaxDuration + (this.clipTimePadding * 2)) {
                return false;
            }
        }
        return true;
    }

    private final SingSegmentData mergeItem(SingSegmentData startItem, SingSegmentData endItem) {
        SingSegmentData singSegmentData = new SingSegmentData();
        singSegmentData.startTime = startItem.startTime;
        singSegmentData.endTime = endItem.endTime;
        return singSegmentData;
    }

    private final boolean pickScoreInclude(HighLightItem highLightItem, SingSegmentData singSegmentData, SingScoreData singScoreData, int curScoreIndex) {
        int i3 = 0;
        if (!isIncludeScoreItem(singSegmentData, singScoreData)) {
            return false;
        }
        if (highLightItem.beginLyricIndex == -1) {
            highLightItem.beginLyricIndex = curScoreIndex;
            highLightItem.endLyricIndex = curScoreIndex;
        } else {
            highLightItem.endLyricIndex = curScoreIndex;
        }
        if (!isIgnoreScore(singScoreData)) {
            float f16 = highLightItem.totalScore;
            if (singScoreData.getScore() > 0) {
                i3 = singScoreData.getScore();
            }
            float f17 = f16 + i3;
            highLightItem.totalScore = f17;
            int i16 = highLightItem.hitCount + 1;
            highLightItem.hitCount = i16;
            highLightItem.avgScore = f17 / i16;
        } else {
            LogUtil.w(this.TAG, "ignore item start: " + singScoreData.getStartTime() + " ,end : " + singScoreData.getEndTime() + " , score: " + singScoreData.getScore());
        }
        highLightItem.startTime = singSegmentData.startTime;
        highLightItem.endTime = singSegmentData.endTime;
        return true;
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void abandonSegment() {
        LogUtil.i(this.TAG, "abandonSegment before size: " + getMHighLightSegmentList().size() + TokenParser.SP);
        distinctHighLightList();
        LogUtil.i(this.TAG, "abandonSegment after distinct size: " + getMHighLightSegmentList().size() + TokenParser.SP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, com.tencent.karaoke.audiobasesdk.segment.SingSegmentData] */
    /* JADX WARN: Type inference failed for: r10v3, types: [T, com.tencent.karaoke.audiobasesdk.segment.SingSegmentData] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.tencent.karaoke.audiobasesdk.segment.SingSegmentData] */
    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void mergeSegment() {
        setMMergedSegmentList(new ArrayList());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        LogUtil.i(this.TAG, "mergeSegment mSegmentList:" + getMSegmentList().length + TokenParser.SP);
        SingSegmentData[] mSegmentList = getMSegmentList();
        int length = mSegmentList.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            ?? r75 = mSegmentList[i3];
            int i17 = i16 + 1;
            getMMergedSegmentList().add(createSegmentData(r75, i16, i16));
            if (i16 != getMSegmentList().length - 1) {
                objectRef.element = r75;
                int length2 = getMSegmentList().length;
                for (int i18 = i17; i18 < length2; i18++) {
                    ?? r102 = getMSegmentList()[i18];
                    objectRef2.element = r102;
                    int i19 = r102.startTime;
                    T t16 = objectRef.element;
                    if (i19 - ((SingSegmentData) t16).endTime <= this.MergeMaxInterval && r102.endTime - ((SingSegmentData) t16).startTime < this.MergeMaxDuration) {
                        objectRef.element = mergeItem((SingSegmentData) t16, r102);
                        getMMergedSegmentList().add(createSegmentData((SingSegmentData) objectRef.element, i16, i18));
                    }
                }
            }
            i3++;
            i16 = i17;
        }
        LogUtil.i(this.TAG, "mergeSegment before size: " + getMSegmentList().length + " , after size: " + getMMergedSegmentList().size() + TokenParser.SP);
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void pickScoreToSegment() {
        int i3 = 0;
        for (Object obj : getMMergedSegmentList()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SingSegmentData singSegmentData = (SingSegmentData) obj;
            singSegmentData.startTime += getOffsetTime();
            singSegmentData.endTime += getOffsetTime();
            HighLightItem highLightItem = new HighLightItem();
            highLightItem.clipStarTime = singSegmentData.startTime;
            highLightItem.clipEndTime = singSegmentData.endTime;
            int i17 = 0;
            boolean z16 = false;
            for (Object obj2 : getMSingScoreList()) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (pickScoreInclude(highLightItem, singSegmentData, (SingScoreData) obj2, i17)) {
                    z16 = true;
                } else if (z16) {
                    break;
                }
                i17 = i18;
            }
            getMHighLightSegmentList().add(highLightItem);
            i3 = i16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GreedyHighLightStrategy(int i3, @NotNull MediaSingSegmentBusiness.FilterConfig filterConfig, @NotNull SingSegmentData[] segmentList, @NotNull ArrayList<SingScoreData> singScoreList) {
        super(i3, segmentList, singScoreList);
        Intrinsics.checkParameterIsNotNull(filterConfig, "filterConfig");
        Intrinsics.checkParameterIsNotNull(segmentList, "segmentList");
        Intrinsics.checkParameterIsNotNull(singScoreList, "singScoreList");
        this.TAG = "GreedyHighLightStrategy";
        this.MergeMaxInterval = filterConfig.getMergeMaxInterval();
        this.MergeMinDuration = filterConfig.getMinDuration();
        this.MergeMaxDuration = filterConfig.getMaxDuration();
        this.AverageScoreAtLeast = filterConfig.getAvgScoreAtLeast();
        this.MinLineRequired = filterConfig.getMinCount();
        this.clipTimePadding = filterConfig.getClipTimePadding();
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void alignSegment() {
    }
}
