package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/n;", "videoTrackModel", "Li63/b;", "scaleCalculator", "", "isChanged", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/i;", "variableClipModel", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class VideoTrackDataTransHelperKt {
    @NotNull
    public static final VideoTrackModel a(@NotNull VariableClipModel variableClipModel, @NotNull i63.b scaleCalculator) {
        int y16;
        int y17;
        Intrinsics.checkNotNullParameter(variableClipModel, "variableClipModel");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        if (variableClipModel.getType() == 0) {
            TimeData timeData = variableClipModel.getTimeData();
            y16 = scaleCalculator.y(((float) timeData.getTimelineStartTimeUs()) - (((float) (timeData.getSelectStartTimeUs() - timeData.getSourceStartTimeUs())) * timeData.e()));
        } else {
            y16 = scaleCalculator.y(variableClipModel.getTimeData().getTimelineStartTimeUs());
        }
        int i3 = y16;
        if (variableClipModel.getType() == 0) {
            TimeData timeData2 = variableClipModel.getTimeData();
            y17 = scaleCalculator.y(((float) (timeData2.getSourceDurationUs() - timeData2.getSelectStartTimeUs())) * timeData2.e());
        } else {
            TimeData timeData3 = variableClipModel.getTimeData();
            y17 = scaleCalculator.y(((float) (10000000 - timeData3.getSelectStartTimeUs())) * timeData3.e());
        }
        int i16 = y17;
        int y18 = scaleCalculator.y(variableClipModel.getTimeData().getTimelineStartTimeUs());
        return new VideoTrackModel(variableClipModel.getUuid(), variableClipModel.getType(), variableClipModel.getPath(), y18, y18 - i3, i3, scaleCalculator.y(variableClipModel.getTimeData().getTimelineDurationUs()), i16, scaleCalculator.y(variableClipModel.getStartOverlapTimeUs()), scaleCalculator.y(variableClipModel.getEndOverlapTimeUs()), variableClipModel.getTimeData().f(), scaleCalculator.y(1000000L), variableClipModel, variableClipModel.getDrawData());
    }

    @NotNull
    public static final ClipModel b(@NotNull VideoTrackModel videoTrackModel, @NotNull final i63.b scaleCalculator, boolean z16) {
        Intrinsics.checkNotNullParameter(videoTrackModel, "videoTrackModel");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        if (z16) {
            Function2<Integer, Long, Long> function2 = new Function2<Integer, Long, Long>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackDataTransHelperKt$transVideoTrackModelToClipModel$1$getTime$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Long invoke(Integer num, Long l3) {
                    return invoke(num.intValue(), l3.longValue());
                }

                @NotNull
                public final Long invoke(int i3, long j3) {
                    if (i63.b.this.y(j3) != i3) {
                        j3 = i63.b.this.x(i3);
                    }
                    return Long.valueOf(j3);
                }
            };
            long longValue = function2.invoke(Integer.valueOf(videoTrackModel.getWidth()), Long.valueOf(videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs())).longValue();
            long longValue2 = function2.invoke(Integer.valueOf(videoTrackModel.getLeftMargin()), Long.valueOf(videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs())).longValue();
            TimeData timeData = videoTrackModel.getSourceData().getTimeData();
            return new ClipModel(videoTrackModel.getUuid(), videoTrackModel.getType(), videoTrackModel.getPath(), new TimeData(longValue2, longValue, longValue, ((float) longValue) / videoTrackModel.getSourceData().getTimeData().e(), ((float) timeData.getSelectStartTimeUs()) - (((float) (timeData.getTimelineStartTimeUs() - longValue2)) / timeData.e()), videoTrackModel.getSourceData().getTimeData().getSourceDurationUs(), videoTrackModel.getSourceData().getTimeData().getSourceStartTimeUs()), videoTrackModel.getSourceData().getDrawData());
        }
        return new ClipModel(videoTrackModel.getSourceData().getUuid(), videoTrackModel.getSourceData().getType(), videoTrackModel.getSourceData().getPath(), videoTrackModel.getSourceData().getTimeData(), videoTrackModel.getSourceData().getDrawData());
    }
}
