package com.tencent.mobileqq.tvideo.base;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.parts.TVideoLayerMultiTabPart;
import com.tencent.mobileqq.tvideo.parts.ab;
import com.tencent.mobileqq.tvideo.parts.ag;
import com.tencent.mobileqq.tvideo.parts.aj;
import com.tencent.mobileqq.tvideo.parts.o;
import com.tencent.mobileqq.tvideo.parts.s;
import com.tencent.mobileqq.tvideo.parts.z;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.f {
    private boolean x(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null || qCircleInitBean.getFeed() == null || qCircleInitBean.getSchemeAttrs() == null) {
            return false;
        }
        if (!"tvideo_public_account".equals(qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance")) && !(qCircleInitBean instanceof TVideoLayerBean)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> e(@NonNull com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        return new ArrayList();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(@NonNull com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        QCircleInitBean b16 = aVar.b();
        ArrayList arrayList = new ArrayList();
        if (!(b16 instanceof TVideoLayerBean)) {
            return arrayList;
        }
        arrayList.add(new z());
        arrayList.add(new s());
        TVideoLayerBean tVideoLayerBean = (TVideoLayerBean) b16;
        if (tVideoLayerBean.isDetailFeedsPage()) {
            arrayList.add(new ab());
            arrayList.add(new o(tVideoLayerBean));
            if (qx2.a.c().l()) {
                arrayList.add(new ag(v()));
            }
            arrayList.add(new aj((QCircleLayerBean) b16));
            return arrayList;
        }
        arrayList.add(new com.tencent.mobileqq.tvideo.parts.b());
        arrayList.add(new TVideoLayerMultiTabPart(tVideoLayerBean));
        arrayList.add(new lx2.c());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        return new ArrayList();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public Class<? extends com.tencent.biz.qqcircle.viewmodels.a> v() {
        return com.tencent.mobileqq.tvideo.viewmodel.g.class;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        return x(qCircleInitBean);
    }
}
