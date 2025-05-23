package c50;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lc50/f;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/QFSLayerBaseMiddleListPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "isContainerOnScreen", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "Le30/b;", "getViewModelSurface", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "initBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleLayerBean initBean;

    public f(@NotNull QCircleLayerBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    @NotNull
    public QCircleInitBean getInitBean() {
        return this.initBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    @Nullable
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        List listOf;
        super.onInitView(rootView);
        this.mLayerPageContainer.setRefreshEnable(false);
        this.mLayerPageContainer.setLoadMoreEnable(false);
        FeedCloudMeta$StFeed feed = this.initBean.getFeed();
        feed.video = this.initBean.getFeedVideo();
        feed.cover = this.initBean.getFeedCover();
        UIStateData obtainSuccess = UIStateData.obtainSuccess(false);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new e30.b(feed));
        Z9(obtainSuccess.setDataList(listOf));
    }
}
