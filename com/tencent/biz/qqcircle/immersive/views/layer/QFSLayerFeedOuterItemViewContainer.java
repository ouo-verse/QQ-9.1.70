package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.layer.base.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedOuterItemViewContainer extends QFSLayerFeedAbsItemView {
    public QFSLayerFeedOuterItemViewContainer(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedOuterItemViewContainer";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> n3;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        b q06 = q0();
        if (q06 != null && (n3 = q06.n()) != null) {
            arrayList.addAll(n3);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(e30.b bVar, int i3) {
    }
}
