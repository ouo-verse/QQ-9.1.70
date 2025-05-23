package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.qcircle.application.QCircleApplication;
import java.util.ArrayList;
import java.util.List;
import p40.u;

/* loaded from: classes4.dex */
public class QFSLayerPageFolderFragment extends QFSBaseFragment {
    private List<Part> E;
    private QCircleInitBean F;

    private void rh() {
        u.H().E0();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        if (this.E == null) {
            this.F = QCirclePluginUtil.getQCircleInitBean(getActivity());
            ArrayList arrayList = new ArrayList();
            this.E = arrayList;
            arrayList.add(new o50.b(getPartManager(), this.F));
            this.E.add(new o50.a(this.F));
            this.E.add(new o50.e(this.F));
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gfz;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageFolderFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void onBackPressed() {
        super.onBackPressed();
        com.tencent.biz.qqcircle.launcher.d.c(this.F);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!h20.c.c()) {
            QCircleApplication.makeSureApplicationLazyLoad();
        }
        rh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QCircleInitBean qCircleInitBean = this.F;
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            com.tencent.biz.qqcircle.launcher.d.a(this.F.getSchemeAttrs());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context hostContext = ASEngineUtils.getHostContext(getActivity());
        if (!(hostContext instanceof Activity)) {
            return;
        }
        RFWThemeUtil.setStatusBarColor((Activity) hostContext, 0);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public void registerDaTongReportPageId() {
    }
}
