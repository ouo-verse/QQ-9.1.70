package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalEditInfoPart;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSQUIPersonalEditTitlePart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalEditViewModel;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalEditFragment extends QCircleBaseFragment {
    private List<Part> C;
    private QFSQUIPersonalEditTitlePart D;
    private QFSPersonalEditInfoPart E;
    private QFSPersonalEditViewModel F;

    private void initViewModel() {
        if (this.F == null) {
            this.F = (QFSPersonalEditViewModel) getViewModel(QFSPersonalEditViewModel.class);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        initViewModel();
        if (this.C == null) {
            this.C = new ArrayList();
            this.D = new QFSQUIPersonalEditTitlePart();
            this.E = new QFSPersonalEditInfoPart();
            this.C.add(this.D);
            this.C.add(this.E);
        }
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean enableSetStatusBarColor() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.glv;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_EDIT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalEditFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QFSQUIUtilsKt.g(getContext());
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).detachConditionSearchManager();
        QFSPersonalEditViewModel qFSPersonalEditViewModel = this.F;
        if (qFSPersonalEditViewModel != null) {
            qFSPersonalEditViewModel.d2();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSQUIUtilsKt.h(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.D.A9(com.tencent.biz.qqcircle.utils.h.a(R.string.f1927548c));
        this.F.a2(getActivity().getIntent());
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).attachConditionSearchManager();
    }
}
