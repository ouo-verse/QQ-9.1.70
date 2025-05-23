package com.tencent.biz.qqcircle.immersive.layer.biz;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.part.cc;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.immersive.layer.base.b {
    private boolean w(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.isMiddlePage()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof a)) {
            return null;
        }
        a aVar2 = (a) aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(aVar2.b()));
        arrayList.add(new cc());
        if (w(aVar2.b())) {
            arrayList.add(new br());
        }
        return arrayList;
    }
}
