package com.qzone.reborn.feedx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.feedx.part.detail.n;
import com.qzone.reborn.feedx.part.i;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import gf.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBlogDetailFragment extends QZoneBaseFragment implements k {
    private com.qzone.reborn.feedx.viewmodel.h C;

    private void initIoc() {
        registerIoc(this, k.class);
    }

    private void initViewModel() {
        this.C = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(QZoneBlogDetailViewModel.class);
    }

    private void parseIntent(Intent intent) {
        this.C.G2(intent);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.feedx.part.detail.e());
        arrayList.add(new com.qzone.reborn.feedx.part.detail.c());
        arrayList.add(new com.qzone.reborn.feedx.part.detail.d());
        arrayList.add(new n(true));
        arrayList.add(new i(true));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.chs;
    }

    @Override // gf.k
    public int getPageType() {
        return 2;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        com.qzone.reborn.feedx.viewmodel.h hVar = this.C;
        if (hVar == null || hVar.p2() == -1) {
            return 3;
        }
        return this.C.p2();
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        initIoc();
        initViewModel();
        if (getActivity() != null) {
            parseIntent(getActivity().getIntent());
        }
    }
}
