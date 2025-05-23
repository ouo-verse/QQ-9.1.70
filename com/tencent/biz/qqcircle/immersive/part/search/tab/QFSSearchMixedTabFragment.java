package com.tencent.biz.qqcircle.immersive.part.search.tab;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import h60.k;
import i60.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchMixedTabFragment extends QFSBaseSearchTabFragment {
    private k H;
    private a I;

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        k kVar = new k();
        this.H = kVar;
        kVar.Ha(this.I);
        assembleParts.add(this.H);
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchMixedTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public void reset() {
        k kVar = this.H;
        if (kVar != null) {
            kVar.Fa();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.search.tab.QFSBaseSearchTabFragment
    public boolean sh() {
        return false;
    }

    public void th(a aVar) {
        this.I = aVar;
    }
}
