package com.tencent.ams.mosaic.jsengine.animation.layer.container;

import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ContainerLayer {
    void addLayer(LayerBase layerBase);

    void masksToBounds(boolean z16);

    void removeAllLayers();

    void removeLayer(LayerBase layerBase);
}
