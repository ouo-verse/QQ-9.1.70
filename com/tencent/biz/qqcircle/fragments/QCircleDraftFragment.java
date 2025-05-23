package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import com.tencent.biz.qqcircle.bizparts.f;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleDraftFragment extends QCircleBaseFragment {
    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        f fVar = new f();
        fVar.setReportBean(getReportBean());
        arrayList.add(fVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        int i3;
        try {
            i3 = getActivity().getIntent().getIntExtra("key_bundle_draft_count", -1);
        } catch (Exception e16) {
            QLog.w("QCircleDraftFragment", 1, "getChildDaTongPageParams, error ", e16);
            i3 = -1;
        }
        HashMap hashMap = new HashMap();
        if (i3 != -1) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_DRAFTS_FEEDS_NUM, Integer.valueOf(i3));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g3i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_DRAFTBOX_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDraftFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 33;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(32);
        }
    }
}
