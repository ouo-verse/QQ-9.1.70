package com.tencent.karaoke.audiobasesdk.segment.strategy;

import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.segment.HighLightItem;
import com.tencent.karaoke.audiobasesdk.segment.SingScoreData;
import com.tencent.karaoke.audiobasesdk.segment.SingSegmentData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/segment/strategy/SimpleHighLightStrategy;", "Lcom/tencent/karaoke/audiobasesdk/segment/strategy/BaseHighLightStrategy;", "offsetTime", "", "segmentList", "", "Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;", "singScoreList", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/segment/SingScoreData;", "Lkotlin/collections/ArrayList;", "(I[Lcom/tencent/karaoke/audiobasesdk/segment/SingSegmentData;Ljava/util/ArrayList;)V", "TAG", "", "abandonSegment", "", "alignSegment", "mergeSegment", "pickScoreToSegment", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class SimpleHighLightStrategy extends BaseHighLightStrategy {
    private final String TAG;

    public /* synthetic */ SimpleHighLightStrategy(int i3, SingSegmentData[] singSegmentDataArr, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, singSegmentDataArr, arrayList);
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void alignSegment() {
        Iterator<T> it = getMHighLightSegmentList().iterator();
        while (it.hasNext()) {
            calculateHighLightTime((HighLightItem) it.next());
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void mergeSegment() {
        setMMergedSegmentList(new ArrayList<>());
        CollectionsKt__MutableCollectionsKt.addAll(getMMergedSegmentList(), getMSegmentList());
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void pickScoreToSegment() {
        int i3;
        int i16 = 0;
        for (SingSegmentData singSegmentData : getMMergedSegmentList()) {
            singSegmentData.startTime += getOffsetTime();
            singSegmentData.endTime += getOffsetTime();
            HighLightItem highLightItem = new HighLightItem();
            highLightItem.clipStarTime = singSegmentData.startTime;
            highLightItem.clipEndTime = singSegmentData.endTime;
            while (i16 < getMSingScoreList().size()) {
                SingScoreData singScoreData = getMSingScoreList().get(i16);
                Intrinsics.checkExpressionValueIsNotNull(singScoreData, "mSingScoreList[singScoreIndex]");
                SingScoreData singScoreData2 = singScoreData;
                if (singSegmentData.startTime <= singScoreData2.getStartTime() && singSegmentData.endTime >= singScoreData2.getEndTime()) {
                    if (highLightItem.beginLyricIndex == -1) {
                        highLightItem.beginLyricIndex = i16;
                        highLightItem.endLyricIndex = i16;
                    } else {
                        highLightItem.endLyricIndex = i16;
                    }
                    if (!isIgnoreScore(singScoreData2)) {
                        float f16 = highLightItem.totalScore;
                        if (singScoreData2.getScore() > 0) {
                            i3 = singScoreData2.getScore();
                        } else {
                            i3 = 0;
                        }
                        highLightItem.totalScore = f16 + i3;
                        highLightItem.hitCount++;
                    } else {
                        LogUtil.w(this.TAG, "ignore item start: " + singScoreData2.getStartTime() + " ,end : " + singScoreData2.getEndTime() + " , score: " + singScoreData2.getScore());
                    }
                } else if (singSegmentData.startTime <= singScoreData2.getStartTime() && singSegmentData.startTime <= singScoreData2.getEndTime()) {
                    break;
                }
                i16++;
            }
            getMHighLightSegmentList().add(highLightItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleHighLightStrategy(int i3, @NotNull SingSegmentData[] segmentList, @NotNull ArrayList<SingScoreData> singScoreList) {
        super(i3, segmentList, singScoreList);
        Intrinsics.checkParameterIsNotNull(segmentList, "segmentList");
        Intrinsics.checkParameterIsNotNull(singScoreList, "singScoreList");
        this.TAG = "SimpleHighLightStrategy";
    }

    @Override // com.tencent.karaoke.audiobasesdk.segment.strategy.BaseHighLightStrategy
    public void abandonSegment() {
    }
}
