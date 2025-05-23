package com.tencent.biz.qqcircle.immersive.album.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenFeedAlbumChangeEvent extends SimpleBaseEvent {
    private b mBlockData;

    public QFSFullScreenFeedAlbumChangeEvent(b bVar) {
        this.mBlockData = bVar;
    }

    public b getBlockData() {
        return this.mBlockData;
    }
}
