package com.tencent.biz.qqcircle.immersive.personal.part;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.QFSFolderFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.engineer.test.api.RFWTestDataSource;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f88883d;

    private void x9() {
        if (QCircleHostGlobalInfo.isNowFlatState() && QCirclePluginUtil.isTabMode()) {
            QLog.d("QFSPersonalTitlePart", 1, "[onBackClick] in split view mode");
            QCirclePluginUtil.setIsSplitModeInnerBackClk(true);
        }
        if (QCirclePluginUtil.isQFSTabNativeFragmentMode(getActivity()) && getHostFragment() != null && (getHostFragment().getParentFragment() instanceof QFSFolderFragment) && ((QFSFolderFragment) getHostFragment().getParentFragment()).onBackEvent()) {
            QLog.d("QFSPersonalTitlePart", 1, "[onBackClick] in fragmentMode");
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f44611pn && !getPartManager().onBackEvent()) {
            x9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @RFWTestDataSource(key = "personal_iv_title_back", objName = "mIvTitleBack")
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.f44611pn);
        this.f88883d = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }
}
