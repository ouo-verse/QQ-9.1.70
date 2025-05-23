package com.tencent.biz.qqcircle.fragments.polymerization;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPolymerizationRecentTagFragment extends QFSPolymerizationTagBaseFragment {
    private boolean U = true;

    /* loaded from: classes4.dex */
    class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState() && QFSPolymerizationRecentTagFragment.this.P != null) {
                RFWLog.d("QFSPolymerizationRecentTagFragment", RFWLog.USR, "[onLoadData] tag: recent tab load more by user scroll");
                QFSPolymerizationRecentTagFragment qFSPolymerizationRecentTagFragment = QFSPolymerizationRecentTagFragment.this;
                qFSPolymerizationRecentTagFragment.P.h2(qFSPolymerizationRecentTagFragment.getContext(), QFSPolymerizationRecentTagFragment.this.Q, true, false, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationTagBaseFragment
    public void Gh(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        super.Gh(uIStateData, z16);
        if (!z16 && this.U && f.i()) {
            RFWLog.d("QFSPolymerizationRecentTagFragment", RFWLog.USR, "[handleSuccessRsp] tag: recent tab load more in advance");
            this.P.h2(getContext(), this.Q, true, true, 1);
            this.U = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationTagBaseFragment
    public void Hh() {
        super.Hh();
        this.N.setOnLoadDataDelegate(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationTagBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> childDaTongPageParams = super.getChildDaTongPageParams();
        if (childDaTongPageParams == null) {
            return new HashMap();
        }
        childDaTongPageParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TAB_TITLE, h.a(R.string.f196094gd));
        return childDaTongPageParams;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPolymerizationRecentTagFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.polymerization.QFSPolymerizationTagBaseFragment
    public void initViewModel() {
        super.initViewModel();
        this.P.D.observe((QCirclePolymerizationFragment) getParentFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.fragments.polymerization.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPolymerizationRecentTagFragment.this.Ch((UIStateData) obj);
            }
        });
    }
}
