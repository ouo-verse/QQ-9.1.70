package com.qzone.reborn.qzmoment.fragment;

import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.part.w;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZMPraiseListFragment extends QZMBaseFragment {
    private w C;

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        w wVar = new w();
        this.C = wVar;
        arrayList.add(wVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1283636;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected String getDaTongPageId() {
        if (getActivity() == null || getActivity().getIntent() == null || !getActivity().getIntent().hasExtra("key_bundle_fragment_page_id")) {
            return "";
        }
        return getActivity().getIntent().getStringExtra("key_bundle_fragment_page_id");
    }
}
