package com.tencent.richframework.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWLayerFileStateChangeEvent extends SimpleBaseEvent {
    public RFWLayerFileDownloadState mState;

    public RFWLayerFileStateChangeEvent(RFWLayerFileDownloadState rFWLayerFileDownloadState) {
        this.mState = rFWLayerFileDownloadState;
    }
}
