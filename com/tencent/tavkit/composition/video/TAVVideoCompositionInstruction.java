package com.tencent.tavkit.composition.video;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.tav.core.composition.VideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVVideoCompositionInstruction extends VideoCompositionInstruction {
    private static final String TAG = "TAVVideoCompositionInst";

    @NonNull
    private List<List<TAVVideoCompositionLayerInstruction>> channelLayers;
    private TAVVideoEffect globalVideoEffect;

    @NonNull
    private List<TAVVideoCompositionLayerInstruction> overlayLayers;
    private TAVVideoEffect sourceVideoEffect;
    private final CMTimeRange timeRange;
    private TAVVideoMixEffect videoMixEffect;

    public TAVVideoCompositionInstruction(List<Integer> list, @NonNull CMTimeRange cMTimeRange) {
        this.requiredSourceTrackIDs = list;
        this.timeRange = cMTimeRange;
        this.enablePostProcessing = false;
        this.backgroundColor = -16777216;
        this.channelLayers = new ArrayList();
        this.overlayLayers = new ArrayList();
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotNull
    public List<List<TAVVideoCompositionLayerInstruction>> getChannelLayers() {
        return this.channelLayers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TAVVideoEffect getGlobalVideoEffect() {
        return this.globalVideoEffect;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public List<TAVVideoCompositionLayerInstruction> getLayerInstructions() {
        ArrayList arrayList = new ArrayList();
        Iterator<List<TAVVideoCompositionLayerInstruction>> it = this.channelLayers.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        arrayList.addAll(this.overlayLayers);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotNull
    public List<TAVVideoCompositionLayerInstruction> getOverlayLayers() {
        return this.overlayLayers;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    public int getPassthroughTrackID() {
        Log.e(TAG, "getPassthroughTrackID: \u65b9\u6cd5\u672a\u5b9e\u73b0");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TAVVideoEffect getSourceVideoEffect() {
        return this.sourceVideoEffect;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionInstruction, com.tencent.tav.core.compositing.IVideoCompositionInstruction
    @NonNull
    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TAVVideoMixEffect getVideoMixEffect() {
        return this.videoMixEffect;
    }

    public void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public void setChannelLayers(List<List<TAVVideoCompositionLayerInstruction>> list) {
        if (list == null) {
            return;
        }
        this.channelLayers = list;
    }

    public void setEnablePostProcessing(boolean z16) {
        this.enablePostProcessing = z16;
    }

    public void setGlobalVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.globalVideoEffect = tAVVideoEffect;
    }

    public void setOverlayLayers(List<TAVVideoCompositionLayerInstruction> list) {
        if (list == null) {
            return;
        }
        this.overlayLayers = list;
        this.requiredSourceTrackIDs.clear();
        Iterator<TAVVideoCompositionLayerInstruction> it = list.iterator();
        while (it.hasNext()) {
            this.requiredSourceTrackIDs.add(Integer.valueOf(it.next().getTrackID()));
        }
    }

    public void setSourceVideoEffect(TAVVideoEffect tAVVideoEffect) {
        this.sourceVideoEffect = tAVVideoEffect;
    }

    public void setVideoMixEffect(TAVVideoMixEffect tAVVideoMixEffect) {
        this.videoMixEffect = tAVVideoMixEffect;
    }

    public String toString() {
        return "TAVVideoCompositionInstruction{timeRange=" + this.timeRange.toSimpleString() + ", backgroundColor=" + this.backgroundColor + ", overlayLayers=" + this.overlayLayers + '}';
    }
}
