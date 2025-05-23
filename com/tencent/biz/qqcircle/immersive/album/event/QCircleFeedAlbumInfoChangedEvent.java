package com.tencent.biz.qqcircle.immersive.album.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedAlbumInfoChangedEvent extends SimpleBaseEvent {
    public QQCircleFeedBase$AlbumPageData mFeedAlbumInfo;

    public QCircleFeedAlbumInfoChangedEvent(QQCircleFeedBase$AlbumPageData qQCircleFeedBase$AlbumPageData) {
        this.mFeedAlbumInfo = qQCircleFeedBase$AlbumPageData;
    }
}
