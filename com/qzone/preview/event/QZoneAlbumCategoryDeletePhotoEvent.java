package com.qzone.preview.event;

import com.qzone.reborn.layer.share.QZoneDeletePhotoBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes39.dex */
public class QZoneAlbumCategoryDeletePhotoEvent extends SimpleBaseEvent {
    public QZoneDeletePhotoBean deletePhotoBean;

    public QZoneAlbumCategoryDeletePhotoEvent(QZoneDeletePhotoBean qZoneDeletePhotoBean) {
        this.deletePhotoBean = qZoneDeletePhotoBean;
    }
}
