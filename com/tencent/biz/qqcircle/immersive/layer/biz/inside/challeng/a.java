package com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng;

import com.tencent.biz.qqcircle.immersive.part.QFSTagChallengeBannerPart;
import com.tencent.biz.qqcircle.immersive.part.ar;
import com.tencent.biz.qqcircle.immersive.part.fs;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.b {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return null;
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar2 = (com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new f(aVar2.b()));
        arrayList.add(new QFSTagChallengeBannerPart(aVar2.b()));
        arrayList.add(new ar());
        arrayList.add(new fs(aVar2.b()));
        return arrayList;
    }
}
