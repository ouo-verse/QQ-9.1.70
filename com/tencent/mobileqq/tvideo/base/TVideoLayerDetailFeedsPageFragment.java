package com.tencent.mobileqq.tvideo.base;

import com.tencent.mobileqq.R;
import com.tencent.qqlive.common.screen.ScreenUtils;

/* loaded from: classes19.dex */
public class TVideoLayerDetailFeedsPageFragment extends QFSLayerTVideoPageFragment {
    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.ggb;
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "page_ugqqoa_sec_play";
    }

    @Override // com.tencent.mobileqq.tvideo.base.QFSLayerTVideoPageFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getPartManager().onBackEvent()) {
            return true;
        }
        if (getActivity() == null) {
            return false;
        }
        if (ScreenUtils.isLandscape()) {
            jy2.g.Q(getActivity(), 1);
        } else {
            getActivity().finish();
            Nh(false, true);
        }
        return true;
    }
}
