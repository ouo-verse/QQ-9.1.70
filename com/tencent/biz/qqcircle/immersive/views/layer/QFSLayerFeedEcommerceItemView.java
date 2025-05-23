package com.tencent.biz.qqcircle.immersive.views.layer;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildEcommerceTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoErrorPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildVideoSprPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ab;
import com.tencent.biz.qqcircle.immersive.feed.ah;
import com.tencent.biz.qqcircle.immersive.feed.ax;
import com.tencent.biz.qqcircle.immersive.feed.cl;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class QFSLayerFeedEcommerceItemView extends QFSLayerFeedItemView {
    public QFSLayerFeedEcommerceItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    protected String getLogTag() {
        return "QFSLayerFeedEcommerceItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedItemView, com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p06 = super.p0();
        p06.add(ab.class);
        p06.add(QFSFeedChildEcommerceTopViewPresenter.class);
        int i3 = this.mViewType;
        if (i3 == 3003) {
            p06.add(QFSFeedChildVideoPresenter.class);
            p06.add(QFSFeedChildVideoErrorPresenter.class);
            p06.add(ah.class);
            p06.add(cl.class);
            p06.add(ax.class);
            p06.add(QFSFeedChildVideoSprPresenter.class);
        } else if (i3 == 3002) {
            p06.add(QFSFeedChildPicPresenter.class);
        }
        return p06;
    }
}
