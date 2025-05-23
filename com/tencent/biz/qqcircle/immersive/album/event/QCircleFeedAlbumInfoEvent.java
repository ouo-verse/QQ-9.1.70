package com.tencent.biz.qqcircle.immersive.album.event;

import com.tencent.biz.qqcircle.beans.QCircleFeedAlbumInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedAlbumInfoEvent extends SimpleBaseEvent {
    public QCircleFeedAlbumInfo mFeedAlbumInfo;

    public QCircleFeedAlbumInfoEvent(QCircleFeedAlbumInfo qCircleFeedAlbumInfo) {
        this.mFeedAlbumInfo = qCircleFeedAlbumInfo;
    }
}
