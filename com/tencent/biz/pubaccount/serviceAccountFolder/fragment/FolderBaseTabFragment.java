package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class FolderBaseTabFragment extends BaseFragment {
    public static String F = "FolderBaseTabFragment";
    public static int G = 0;
    public static int H = 1;
    protected View C;
    protected boolean D = false;
    protected String E = "";

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getBaseActivity() != null) {
            this.E = getBaseActivity().app.getAccount();
        }
        if (!this.D && getBaseActivity() != null) {
            ph();
            this.D = true;
        }
    }

    protected abstract void ph();

    public abstract void qh(ServiceAccountFolderActivityNew serviceAccountFolderActivityNew, int i3);

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        QLog.d(F, 4, "setUserVisibleHint :" + getUserVisibleHint());
    }
}
