package com.tencent.biz.qqcircle.immersive.part.search.tab;

import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import i60.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchTagTabFragment extends QFSBaseSearchTabFragment {
    private f H;

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        f fVar = new f();
        this.H = fVar;
        assembleParts.add(fVar);
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_VERTICAL_SEARCH_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public String getLogTag() {
        return "QFSSearchTagTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public void reset() {
        f fVar = this.H;
        if (fVar != null) {
            fVar.F9();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public boolean sh() {
        return true;
    }
}
