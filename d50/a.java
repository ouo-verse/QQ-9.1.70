package d50;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.t;
import com.tencent.biz.qqcircle.immersive.layer.base.f;
import com.tencent.biz.qqcircle.immersive.part.cf;
import com.tencent.biz.qqcircle.immersive.part.dg;
import com.tencent.biz.qqcircle.immersive.part.dl;
import com.tencent.biz.qqcircle.immersive.part.dn;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends f {
    private boolean x(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || !TextUtils.equals(qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid"), QCircleDaTongConstant.PageId.PG_XSJ_MINIGAME_FEED_PAGE)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.biz.qqcircle.immersive.layer.biz.f(((com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar).b()));
        arrayList.add(new cf());
        arrayList.add(new dn(v()));
        arrayList.add(new dl(v()));
        arrayList.add(new dg(v()));
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q16 = super.q();
        q16.add(t.class);
        return q16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.isMiddlePage() && x(qCircleInitBean)) {
            return true;
        }
        return false;
    }
}
