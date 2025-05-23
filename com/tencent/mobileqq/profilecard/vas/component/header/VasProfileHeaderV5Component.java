package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileQVipV5View;

/* loaded from: classes16.dex */
public class VasProfileHeaderV5Component extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderV5Component";
    private boolean mIsFromArkBabyQ;

    public VasProfileHeaderV5Component(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent
    protected void initHeaderView() {
        if (this.mHeaderView == null) {
            VasProfileQVipV5View vasProfileQVipV5View = new VasProfileQVipV5View(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileQVipV5View.setProfileArgs(this.mIsFromArkBabyQ);
            vasProfileQVipV5View.setClickListener(this);
            vasProfileQVipV5View.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mHeaderView = vasProfileQVipV5View;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        Intent intent = qBaseActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        super.onCreate(qBaseActivity, bundle);
    }
}
