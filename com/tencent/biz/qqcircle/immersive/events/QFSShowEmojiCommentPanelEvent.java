package com.tencent.biz.qqcircle.immersive.events;

import android.widget.ImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import e30.b;

/* loaded from: classes4.dex */
public class QFSShowEmojiCommentPanelEvent extends SimpleBaseEvent {
    private final ImageView mAnchor;
    private final b mFeedBlockData;
    private final int mHashCode;
    private final String mPageId;

    public QFSShowEmojiCommentPanelEvent(b bVar, ImageView imageView, String str, int i3) {
        this.mFeedBlockData = bVar;
        this.mAnchor = imageView;
        this.mPageId = str;
        this.mHashCode = i3;
    }

    public ImageView getAnchor() {
        return this.mAnchor;
    }

    public b getFeedBlockData() {
        return this.mFeedBlockData;
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public String getPageId() {
        return this.mPageId;
    }
}
