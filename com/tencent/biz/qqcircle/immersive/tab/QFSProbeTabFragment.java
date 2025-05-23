package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.immersive.part.ef;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSProbeTabFragment extends QFSAutoMemoryFragment {
    private ef G;

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSProbeTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
    }

    private void uh() {
        byte[] bArr;
        if (y.g().l() == 14) {
            bArr = y.g().m(true);
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            if (this.G == null) {
                QLog.e("QFSBaseFragment", 1, "[handleBottomTabRedPoint] account staggered tab part should not be null.");
                return;
            }
            QLog.d("QFSBaseFragment", 1, "[handleBottomTabRedPoint] refreshAction trans info length: " + bArr.length);
            this.G.ba(bArr, true);
            return;
        }
        QLog.d("QFSBaseFragment", 1, "[handleBottomTabRedPoint] refreshAction trans info is empty.");
    }

    private void vh() {
        if (this.G == null) {
            QLog.e("QFSBaseFragment", 1, "[updateInitBean] probe part must not be null.");
            return;
        }
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean == null) {
            QLog.e("QFSBaseFragment", 1, "[updateInitBean] init bean must not be null, ex: ", new NullPointerException());
            return;
        }
        if (qCircleInitBean.getFromReportBean() == null) {
            QCircleReportBean qCircleReportBean = new QCircleReportBean();
            qCircleReportBean.setPageId(getPageId());
            qCircleReportBean.setDtPageId(getDaTongPageId());
            qCircleInitBean.setFromReportBean(qCircleReportBean);
        }
        this.G.Z9(qCircleInitBean);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putSerializable("key_bundle_common_init_bean", qCircleInitBean);
        this.G.Y9(arguments);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        ef efVar = new ef(this, null);
        this.G = efVar;
        arrayList.add(efVar);
        vh();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ghq;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSAutoMemoryFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_EXPLORE_TAB_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        String name;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QFSBaseFragment");
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo == null) {
            name = "null";
        } else {
            name = qCircleTabInfo.getName();
        }
        sb5.append(name);
        return sb5.toString();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 505;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        vh();
        uh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        View findViewById = view.findViewById(R.id.f165301vg1);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = r.K(getContext()) + cx.a(48.0f);
        findViewById.setLayoutParams(layoutParams2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSAutoMemoryFragment
    public boolean sh() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSAutoMemoryFragment
    public void th() {
        ef efVar = this.G;
        if (efVar == null) {
            QLog.e("QFSBaseFragment", 1, "[scrollToTopAndRefresh] public account staggered tab part.", new NullPointerException());
        } else {
            efVar.ba(null, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
    }
}
