package com.tencent.tav.core.composition;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableVideoCompositionInstruction extends VideoCompositionInstruction {
    public void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public void setEnablePostProcessing(boolean z16) {
        this.enablePostProcessing = z16;
    }

    public void setLayerInstructions(@NonNull List<VideoCompositionLayerInstruction> list) {
        this.layerInstructions.clear();
        this.layerInstructions.addAll(list);
        this.requiredSourceTrackIDs.clear();
        Iterator<VideoCompositionLayerInstruction> it = list.iterator();
        while (it.hasNext()) {
            this.requiredSourceTrackIDs.add(Integer.valueOf(it.next().getTrackID()));
        }
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }
}
