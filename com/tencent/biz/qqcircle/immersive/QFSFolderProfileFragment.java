package com.tencent.biz.qqcircle.immersive;

import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QFSFolderProfileFragment extends QFSPersonalDetailsFragment {
    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFolderPersonalDetailsFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment, com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            super.load();
            getPartManager().broadcastMessage("personal_detail_show_publish", Boolean.FALSE);
            QLog.d("QFSFolderPersonalDetailsFragment", 1, "lazyInit");
        }
    }
}
