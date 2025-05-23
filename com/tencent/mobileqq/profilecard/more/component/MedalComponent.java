package com.tencent.mobileqq.profilecard.more.component;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;
import com.tencent.mobileqq.profilecard.utils.URLSafeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;

/* compiled from: P */
/* loaded from: classes35.dex */
public class MedalComponent extends AbsMoreComponent {
    private static String TAG = "MedalComponent";

    public MedalComponent(ProfileCardMoreController profileCardMoreController) {
        super(profileCardMoreController);
    }

    private String getMedalNum() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        int i3 = profileCardMoreController.mCard.iMedalCount;
        if (i3 <= 0) {
            i3 = 0;
        }
        return String.format(profileCardMoreController.mActivity.getString(R.string.x4d), Integer.valueOf(i3));
    }

    private String getMedalUrl() {
        String str;
        if (!this.mMoreController.isSelf()) {
            str = "https://ti.qq.com/qqmedal2/index.html?_wv=1&_bid=2450&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&_wwv=4&tuin=" + URLSafeUtil.encode(this.mMoreController.mTargetUin) + "&from=2";
        } else {
            str = ProfileCardMoreConstants.MODEL_WELL;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "url=" + str);
        }
        return str;
    }

    private void handleModelClick() {
        Intent intent = new Intent(this.mMoreController.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", getMedalUrl());
        this.mMoreController.mActivity.startActivity(intent);
        VideoReport.reportEvent("dt_clck", this.mViewContainer, null);
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getComponentKey() {
        return ProfileCardMoreConstants.MORE_COMPONENT_KEY_MEDAL;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getPartIndex() {
        return 2;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public boolean isNeedShow() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        return !profileCardMoreController.mCard.medalSwitchDisable && profileCardMoreController.isFriend(profileCardMoreController.mTargetUin) && this.mMoreController.mCard.iMedalCount > 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        handleModelClick();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onCreate(LayoutInflater layoutInflater) {
        super.onCreate(layoutInflater);
        this.mViewContainer.setTitle(R.string.x4c);
        this.mViewContainer.setRightTxt(getMedalNum());
        this.mViewContainer.setOnClickListener(this);
        this.mMoreController.initDtElementReport(this.mViewContainer, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_MEDAL, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }
}
