package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import com.qzone.feed.gift.widget.FeedGiftLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class NormalAbsFeedView extends AbsFeedView {
    public int mIndex;

    public NormalAbsFeedView(Context context) {
        super(context);
        this.mIndex = -1;
    }

    public abstract FeedAutoVideo getAutoVideoView();

    public abstract FeedComment getFeedComment();

    public abstract FeedContent getFeedContent();

    public abstract FeedAutoVideo getFeedContentAutoVideo();

    public abstract CanvasFeedContentView getFeedContentView();

    public abstract FeedForward getFeedForward();

    public abstract FeedGiftLayout getFeedGiftLayout();

    public abstract PanoramaLayout getFeedPanoramaView();

    public abstract FeedScrollContainerArea getFeedScrollContainer();

    public abstract CanvasQzoneCardView getQzoneCardView();

    public abstract CanvasRecommAction getRecommAction();

    public abstract void setFeedViewPauseListener(com.qzone.proxy.feedcomponent.ui.j jVar);
}
