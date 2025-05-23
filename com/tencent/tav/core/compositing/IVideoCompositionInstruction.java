package com.tencent.tav.core.compositing;

import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoCompositionInstruction {
    int getBackgroundColor();

    List<? extends VideoCompositionLayerInstruction> getLayerInstructions();

    int getPassthroughTrackID();

    List<Integer> getRequiredSourceTrackIDs();

    CMTimeRange getTimeRange();

    boolean isEnablePostProcessing();
}
