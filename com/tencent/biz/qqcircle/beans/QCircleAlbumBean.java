package com.tencent.biz.qqcircle.beans;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAlbumBean extends QCircleLayerBean {
    private QCircleFeedAlbumInfo mFeedAlbumInfo;
    private boolean mNeedShowAlbumPanel = true;

    public QCircleAlbumBean(QCircleFeedAlbumInfo qCircleFeedAlbumInfo) {
        this.mFeedAlbumInfo = qCircleFeedAlbumInfo;
        setLayerBizAssemblerType("biz_album_page");
    }

    public QCircleFeedAlbumInfo getFeedAlbumInfo() {
        return this.mFeedAlbumInfo;
    }

    public boolean needShowAlbumPanel() {
        return this.mNeedShowAlbumPanel;
    }

    public void setFeedAlbum(QCircleFeedAlbumInfo qCircleFeedAlbumInfo) {
        this.mFeedAlbumInfo = qCircleFeedAlbumInfo;
    }

    public void setNeedShowAlbumPanel(boolean z16) {
        this.mNeedShowAlbumPanel = z16;
    }
}
