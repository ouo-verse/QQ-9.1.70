package com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.part.cf;
import com.tencent.biz.qqcircle.immersive.part.dg;
import com.tencent.biz.qqcircle.immersive.part.dl;
import com.tencent.biz.qqcircle.immersive.part.dn;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.f {
    private boolean x(QCircleInitBean qCircleInitBean) {
        if (!(qCircleInitBean instanceof QCircleLayerBean)) {
            return false;
        }
        QCircleLayerBean qCircleLayerBean = (QCircleLayerBean) qCircleInitBean;
        if (qCircleLayerBean.getExtraTypeInfo().sourceType != 45 && qCircleLayerBean.getExtraTypeInfo().sourceType != 46) {
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
        arrayList.add(new e(((com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar).b()));
        cf cfVar = new cf();
        cfVar.aa(aVar.b());
        arrayList.add(cfVar);
        arrayList.add(new dn(v()));
        arrayList.add(new dl(v()));
        arrayList.add(new dg(v()));
        arrayList.add(new br());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public Class<? extends com.tencent.biz.qqcircle.viewmodels.a> v() {
        return QFSLayerSubscribeViewModel.class;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.isMiddlePage() && x(qCircleInitBean)) {
            return true;
        }
        return false;
    }
}
