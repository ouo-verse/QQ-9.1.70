package com.tencent.biz.qqcircle.immersive.album.event;

import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSelectAlbumEvent extends SimpleBaseEvent {
    private QCircleAlbumBean mAlbumBean;
    private int mHashCode;

    public QFSSelectAlbumEvent(QCircleAlbumBean qCircleAlbumBean, int i3) {
        this.mAlbumBean = qCircleAlbumBean;
        this.mHashCode = i3;
    }

    public QCircleAlbumBean getAlbumBean() {
        return this.mAlbumBean;
    }

    public int getHashCode() {
        return this.mHashCode;
    }
}
