package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/p;", "videoTrackModel", "Lrj2/a;", "scaleCalculator", "", "isChanged", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/i;", "variableClipModel", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoTrackDataTransHelperKt {
    @NotNull
    public static final VideoTrackModel a(@NotNull VariableClipModel variableClipModel, @NotNull rj2.a scaleCalculator) {
        int u16;
        int u17;
        Intrinsics.checkNotNullParameter(variableClipModel, "variableClipModel");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        if (variableClipModel.getType() == 0) {
            h timeData = variableClipModel.getTimeData();
            u16 = scaleCalculator.u(((float) timeData.getTimelineStartTimeUs()) - (((float) (timeData.getSelectStartTimeUs() - timeData.getSourceStartTimeUs())) * timeData.a()));
        } else {
            u16 = scaleCalculator.u(variableClipModel.getTimeData().getTimelineStartTimeUs());
        }
        int i3 = u16;
        if (variableClipModel.getType() == 0) {
            h timeData2 = variableClipModel.getTimeData();
            u17 = scaleCalculator.u(((float) (timeData2.getSourceDurationUs() - timeData2.getSelectStartTimeUs())) * timeData2.a());
        } else {
            h timeData3 = variableClipModel.getTimeData();
            u17 = scaleCalculator.u(((float) (10000000 - timeData3.getSelectStartTimeUs())) * timeData3.a());
        }
        int i16 = u17;
        int u18 = scaleCalculator.u(variableClipModel.getTimeData().getTimelineStartTimeUs());
        return new VideoTrackModel(variableClipModel.getUuid(), variableClipModel.getType(), variableClipModel.getPath(), u18, u18 - i3, i3, scaleCalculator.u(variableClipModel.getTimeData().getTimelineDurationUs()), i16, scaleCalculator.u(variableClipModel.getStartOverlapTimeUs()), scaleCalculator.u(variableClipModel.getEndOverlapTimeUs()), variableClipModel.getTimeData().getScaleDurationUs(), scaleCalculator.u(1000000L), variableClipModel, variableClipModel.getDrawData());
    }

    @NotNull
    public static final ClipModel b(@NotNull VideoTrackModel videoTrackModel, @NotNull final rj2.a scaleCalculator, boolean z16) {
        Intrinsics.checkNotNullParameter(videoTrackModel, "videoTrackModel");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        if (z16) {
            Function2<Integer, Long, Long> function2 = new Function2<Integer, Long, Long>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackDataTransHelperKt$transVideoTrackModelToClipModel$1$getTime$1
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
                    if (rj2.a.this.u(j3) != i3) {
                        j3 = rj2.a.this.t(i3);
                    }
                    return Long.valueOf(j3);
                }
            };
            long longValue = function2.invoke(Integer.valueOf(videoTrackModel.getWidth()), Long.valueOf(videoTrackModel.getSourceData().getTimeData().getTimelineDurationUs())).longValue();
            long longValue2 = function2.invoke(Integer.valueOf(videoTrackModel.getLeftMargin()), Long.valueOf(videoTrackModel.getSourceData().getTimeData().getTimelineStartTimeUs())).longValue();
            h timeData = videoTrackModel.getSourceData().getTimeData();
            long selectStartTimeUs = ((float) timeData.getSelectStartTimeUs()) - (((float) (timeData.getTimelineStartTimeUs() - longValue2)) / timeData.a());
            return new ClipModel(videoTrackModel.getUuid(), videoTrackModel.getType(), videoTrackModel.getPath(), new h(selectStartTimeUs, longValue, longValue, ((float) longValue) / videoTrackModel.getSourceData().getTimeData().a(), selectStartTimeUs, videoTrackModel.getSourceData().getTimeData().getSourceDurationUs(), videoTrackModel.getSourceData().getTimeData().getSourceStartTimeUs()), videoTrackModel.getSourceData().getDrawData());
        }
        return new ClipModel(videoTrackModel.getSourceData().getUuid(), videoTrackModel.getSourceData().getType(), videoTrackModel.getSourceData().getPath(), videoTrackModel.getSourceData().getTimeData(), videoTrackModel.getSourceData().getDrawData());
    }
}
