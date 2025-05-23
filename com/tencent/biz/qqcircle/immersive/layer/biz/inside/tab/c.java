package com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab;

import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.aw;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.immersive.layer.base.b {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends com.tencent.biz.qqcircle.immersive.layer.base.a {

        /* renamed from: c, reason: collision with root package name */
        private QCircleTabInfo f86659c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f86660d;

        public QCircleTabInfo e() {
            return this.f86659c;
        }

        public boolean f() {
            return this.f86660d;
        }

        public a g(boolean z16) {
            this.f86660d = z16;
            return this;
        }

        public a h(QCircleTabInfo qCircleTabInfo) {
            this.f86659c = qCircleTabInfo;
            return this;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> e(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        a aVar2 = (a) aVar;
        QFSLayerTabPart qFSLayerTabPart = new QFSLayerTabPart(aVar2.b(), aVar2.e());
        qFSLayerTabPart.Ma(aVar2.f());
        arrayList.add(qFSLayerTabPart);
        arrayList.add(new aw());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public com.tencent.biz.qqcircle.immersive.layer.base.a u() {
        return new a();
    }
}
