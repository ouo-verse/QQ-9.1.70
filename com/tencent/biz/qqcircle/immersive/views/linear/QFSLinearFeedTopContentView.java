package com.tencent.biz.qqcircle.immersive.views.linear;

import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m40.a;
import m40.d;
import m40.l;
import m40.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0014J4\u0010\u0010\u001a.\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u000bj\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f`\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/linear/QFSLinearFeedTopContentView;", "Lcom/tencent/biz/qqcircle/immersive/views/layer/QFSLayerFeedAbsItemView;", "", "getLogTag", "", "getLayoutId", "Le30/b;", "data", c.G, "", "n0", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lkotlin/collections/ArrayList;", "p0", "", "isVideoType", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLinearFeedTopContentView extends QFSLayerFeedAbsItemView {
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ghl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSLinearFeedTopContentView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public boolean isVideoType() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(@NotNull b data, int pos) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    @NotNull
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        arrayList.add(s.class);
        arrayList.add(m40.b.class);
        arrayList.add(d.class);
        arrayList.add(a.class);
        arrayList.add(l.class);
        return arrayList;
    }
}
