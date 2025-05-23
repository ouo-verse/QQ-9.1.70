package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.layer.base.b;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedBigCardItemView extends QFSLayerDittoItemView {
    public QFSLayerFeedBigCardItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ge7;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> c16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        b q06 = q0();
        if (q06 != null && (c16 = q06.c()) != null) {
            arrayList.addAll(c16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        super.bindData(bVar, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(e30.b bVar, int i3) {
    }
}
