package com.qzone.preview.event;

import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes39.dex */
public class QZoneLayerDeletePhotoEvent extends SimpleBaseEvent {
    public QZoneInteractPhotoRequestBuilder mBuilder;

    public QZoneLayerDeletePhotoEvent(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder) {
        this.mBuilder = qZoneInteractPhotoRequestBuilder;
    }
}
