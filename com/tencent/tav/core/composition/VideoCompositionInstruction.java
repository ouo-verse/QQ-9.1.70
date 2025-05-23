package com.tencent.tav.core.composition;

import androidx.annotation.Nullable;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoCompositionInstruction implements IVideoCompositionInstruction {

    @Nullable
    protected int backgroundColor;
    protected boolean enablePostProcessing;
    protected CMTimeRange timeRange;
    protected List<VideoCompositionLayerInstruction> layerInstructions = new ArrayList();
    protected List<Integer> requiredSourceTrackIDs = new ArrayList();
    protected int passthroughTrackID = -1;

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<? extends VideoCompositionLayerInstruction> getLayerInstructions() {
        return this.layerInstructions;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getPassthroughTrackID() {
        return this.passthroughTrackID;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<Integer> getRequiredSourceTrackIDs() {
        return this.requiredSourceTrackIDs;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @Override // com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public boolean isEnablePostProcessing() {
        return this.enablePostProcessing;
    }
}
