package com.tencent.biz.qqcircle.immersive.part.search.tab;

import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import i60.i;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchUserTabFragment extends QFSBaseSearchTabFragment {
    private i H;

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        i iVar = new i();
        this.H = iVar;
        assembleParts.add(iVar);
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_USER_VERTICAL_SEARCH_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public String getLogTag() {
        return "QFSSearchUserTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public void reset() {
        i iVar = this.H;
        if (iVar != null) {
            iVar.F9();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public boolean sh() {
        return true;
    }
}
