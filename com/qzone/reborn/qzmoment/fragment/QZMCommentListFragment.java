package com.qzone.reborn.qzmoment.fragment;

import com.qzone.reborn.qzmoment.base.QZMBaseFragment;
import com.qzone.reborn.qzmoment.part.QZMCommentListPart;
import com.qzone.reborn.qzmoment.part.c;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMCommentListFragment extends QZMBaseFragment {
    private QZMCommentListPart C;
    private c D;

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QZMCommentListPart qZMCommentListPart = new QZMCommentListPart();
        this.C = qZMCommentListPart;
        arrayList.add(qZMCommentListPart);
        c cVar = new c();
        this.D = cVar;
        arrayList.add(cVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f1279623;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    protected String getDaTongPageId() {
        if (getActivity() == null || getActivity().getIntent() == null || !getActivity().getIntent().hasExtra("key_bundle_fragment_page_id")) {
            return "";
        }
        return getActivity().getIntent().getStringExtra("key_bundle_fragment_page_id");
    }
}
