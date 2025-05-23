package com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.immersive.part.br;
import com.tencent.biz.qqcircle.immersive.part.cf;
import com.tencent.biz.qqcircle.immersive.part.dg;
import com.tencent.biz.qqcircle.immersive.part.dl;
import com.tencent.biz.qqcircle.immersive.part.dn;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.f {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0886a extends com.tencent.biz.qqcircle.immersive.layer.base.a {
        @Override // com.tencent.biz.qqcircle.immersive.layer.base.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QCirclePolymerizeDetailBean b() {
            QCircleInitBean qCircleInitBean = this.f86508a;
            if (qCircleInitBean instanceof QCirclePolymerizeDetailBean) {
                return (QCirclePolymerizeDetailBean) qCircleInitBean;
            }
            return null;
        }
    }

    private boolean x(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.isNeedHideBottomCommentBtn()) {
            return true;
        }
        return false;
    }

    private boolean y(QCircleInitBean qCircleInitBean) {
        int i3;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null) {
            return false;
        }
        String str = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.Detail.SHOW_NEXT_GUILD);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            QLog.e("QFSLayerPolymerizeDetailAssembler", 1, "isShowNextGuild  e = " + e16.getMessage());
            i3 = 1;
        }
        QLog.d("QFSLayerPolymerizeDetailAssembler", 1, "isShowNextGuild showNextGuid = " + i3);
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof C0886a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(((C0886a) aVar).b()));
        if (!x(aVar.b())) {
            cf cfVar = new cf();
            cfVar.aa(aVar.b());
            arrayList.add(cfVar);
        }
        arrayList.add(new dn(v()));
        if (y(aVar.b())) {
            arrayList.add(new dl(v()));
        }
        arrayList.add(new dg(v()));
        arrayList.add(new br());
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public com.tencent.biz.qqcircle.immersive.layer.base.a u() {
        return new C0886a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    public Class<? extends com.tencent.biz.qqcircle.viewmodels.a> v() {
        return QFSLayerPolymerizeDetailViewModel.class;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.f
    public boolean w(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.isMiddlePage() && (qCircleInitBean instanceof QCirclePolymerizeDetailBean)) {
            return true;
        }
        return false;
    }
}
