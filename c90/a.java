package c90;

import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.views.search.hotrank.QFSSearchHotRankView;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import l80.b;
import p70.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends b {
    private static int i(ImageView imageView) {
        for (ViewParent parent = imageView.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof QFSSearchHotRankView) {
                return parent.hashCode();
            }
        }
        throw new RuntimeException("QFSSearchHotRankView not found");
    }

    @Override // l80.b
    public void a(QCircleLayerBean qCircleLayerBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, ImageView imageView) {
        super.a(qCircleLayerBean, feedCloudMeta$StFeed, i3, imageView);
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], imageView.getWidth() + i16, iArr[1] + imageView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setBackTransition(true));
        qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(imageView.getDrawable());
        i iVar = this.f413956b;
        if (iVar != null) {
            qCircleLayerBean.setPageCode(iVar.hashCode());
        } else {
            qCircleLayerBean.setPageCode(i(imageView));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l80.b
    public IDataDisplaySurface<e30.b> b() {
        i iVar = this.f413956b;
        if (iVar != null) {
            return iVar;
        }
        com.tencent.xaction.log.b.a("QFSSearchHotRankViewModelHelper", 1, "[getDataDisplaySurface] no searchResultViewModel");
        return super.b();
    }
}
