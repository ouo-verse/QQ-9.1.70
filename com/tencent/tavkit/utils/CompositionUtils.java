package com.tencent.tavkit.utils;

import androidx.annotation.NonNull;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVCompositionTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CompositionUtils {
    private static final String TAG = "CompositionUtils";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface TransitionTimeCalculator {
        CMTime transition(int i3);
    }

    private static void checkScaleTimeRange(MutableCompositionTrack mutableCompositionTrack, CMTimeRange cMTimeRange, CMTimeRange cMTimeRange2) {
        if (!CMTime.CMTimeInvalid.equalsTo(cMTimeRange.getDuration()) && !cMTimeRange2.getDuration().equalsTo(cMTimeRange.getDuration())) {
            mutableCompositionTrack.scaleTimeRange(new CMTimeRange(cMTimeRange.getStart(), cMTimeRange2.getDuration()), cMTimeRange.getDuration());
        }
    }

    @NonNull
    public static TAVEmptyResource createEmptyResource(CMTime cMTime) {
        TAVEmptyResource tAVEmptyResource = new TAVEmptyResource(cMTime);
        tAVEmptyResource.setDuration(cMTime);
        tAVEmptyResource.setScaledDuration(cMTime);
        return tAVEmptyResource;
    }

    private static CMTime getTransitionDuration(List<? extends TAVCompositionTimeRange> list, TransitionTimeCalculator transitionTimeCalculator, int i3, CMTime cMTime) {
        CMTime cMTime2;
        CMTime cMTime3 = CMTime.CMTimeZero;
        if (transitionTimeCalculator != null) {
            cMTime2 = transitionTimeCalculator.transition(i3);
        } else {
            cMTime2 = cMTime3;
        }
        if (!cMTime.smallThan(cMTime2) && i3 < list.size() - 1) {
            if (list.get(i3 + 1).getTimeRange().getDuration().smallThan(cMTime2)) {
                return cMTime3;
            }
            return cMTime2;
        }
        return cMTime3;
    }

    public static void insertTimeRangeToTrack(TrackInfo trackInfo, MutableCompositionTrack mutableCompositionTrack, CMTimeRange cMTimeRange) {
        try {
            CMTimeRange selectedTimeRange = trackInfo.getSelectedTimeRange();
            if (trackInfo.getTrack() != null) {
                mutableCompositionTrack.insertTimeRange(selectedTimeRange, trackInfo.getTrack(), cMTimeRange.getStart());
                checkScaleTimeRange(mutableCompositionTrack, cMTimeRange, selectedTimeRange);
            } else if (trackInfo.getCompositionTrackSegment(cMTimeRange) != null) {
                mutableCompositionTrack.insertCompositionTrackSegment(trackInfo.getCompositionTrackSegment(cMTimeRange));
            } else {
                Logger.e(TAG, "insertTimeRangeToTrack: TrackInfo track and segment are null !!!");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static MutableCompositionTrack mutableTrackCompatibleWithTimeRange(MutableComposition mutableComposition, CMTimeRange cMTimeRange, int i3) {
        for (MutableCompositionTrack mutableCompositionTrack : mutableComposition.tracksWithMediaType(i3)) {
            CMTimeRange intersection = TAVTimeUtil.getIntersection(mutableCompositionTrack.getTimeRange(), cMTimeRange);
            if (intersection == null || intersection.getDuration().getTimeSeconds() <= 0.0f) {
                return mutableCompositionTrack;
            }
        }
        return null;
    }

    public static void reloadAudioStartTimeWithTransitionableAudio(final List<? extends TAVTransitionableAudio> list) {
        reloadStartTimeWithTransitionable(list, new TransitionTimeCalculator() { // from class: com.tencent.tavkit.utils.CompositionUtils.2
            @Override // com.tencent.tavkit.utils.CompositionUtils.TransitionTimeCalculator
            public CMTime transition(int i3) {
                TAVAudioTransition audioTransition = ((TAVTransitionableAudio) list.get(i3)).getAudioTransition();
                if (audioTransition != null) {
                    return audioTransition.getDuration();
                }
                return CMTime.CMTimeZero;
            }
        });
    }

    private static void reloadStartTimeWithTransitionable(List<? extends TAVCompositionTimeRange> list, TransitionTimeCalculator transitionTimeCalculator) {
        CMTime cMTime = CMTime.CMTimeZero;
        int i3 = 0;
        CMTime cMTime2 = cMTime;
        while (i3 < list.size()) {
            TAVCompositionTimeRange tAVCompositionTimeRange = list.get(i3);
            CMTime duration = tAVCompositionTimeRange.getTimeRange().getDuration();
            CMTime transitionDuration = getTransitionDuration(list, transitionTimeCalculator, i3, duration);
            CMTime sub = cMTime.sub(cMTime2);
            tAVCompositionTimeRange.setStartTime(sub);
            cMTime = sub.add(duration);
            i3++;
            cMTime2 = transitionDuration;
        }
    }

    public static void reloadVideoStartTimeWithTransitionableVideo(final List<? extends TAVTransitionableVideo> list) {
        reloadStartTimeWithTransitionable(list, new TransitionTimeCalculator() { // from class: com.tencent.tavkit.utils.CompositionUtils.1
            @Override // com.tencent.tavkit.utils.CompositionUtils.TransitionTimeCalculator
            public CMTime transition(int i3) {
                TAVVideoTransition videoTransition = ((TAVTransitionableVideo) list.get(i3)).getVideoTransition();
                if (videoTransition != null) {
                    return videoTransition.getDuration();
                }
                return CMTime.CMTimeZero;
            }
        });
    }
}
