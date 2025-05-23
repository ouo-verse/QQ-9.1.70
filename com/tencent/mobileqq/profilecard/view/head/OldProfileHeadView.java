package com.tencent.mobileqq.profilecard.view.head;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class OldProfileHeadView extends AbsZPlanProfileHeaderView {
    public OldProfileHeadView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        super(qBaseActivity, profileCardInfo);
        this.mDelegate = iProfileActivityDelegate;
    }

    private void adaptBgViewNightMode() {
        if (this.mContentBgView == null) {
            return;
        }
        if (ThemeUtil.isInNightMode(this.mApp)) {
            this.mContentBgView.setBackgroundColor(-16777216);
        } else {
            this.mContentBgView.setBackgroundResource(R.drawable.qq_profilecard_info_bg);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected View initContentView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.f168962be0, (ViewGroup) this, true);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected void initCustomView() {
        QidCoolTextView qidCoolTextView = (QidCoolTextView) this.mContentView.findViewById(R.id.f61892zc);
        this.mQidInfoView = qidCoolTextView;
        this.mHeaderChildMap.put("map_key_qid_info", qidCoolTextView);
        this.mQidInfoView.setOnClickListener(this.mOnClickListener);
        this.mAvatarPendant.setVisibility(4);
        adaptBgViewNightMode();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    protected int initHeadViewResource() {
        return R.layout.f168963be1;
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void onCoverModeChange(int i3, ProfileCardInfo profileCardInfo) {
        String string;
        if (QLog.isColorLevel()) {
            QLog.i(AbsProfileHeaderView.TAG, 2, String.format("onCoverModeChange mode: %s", Integer.valueOf(i3)));
        }
        int i16 = R.color.skin_black;
        if (i3 == 1) {
            ProfileNameView profileNameView = this.mNameView;
            if (profileNameView != null) {
                profileNameView.setTextColor(getResources().getColor(R.color.skin_black));
            }
            VoteViewV2 voteViewV2 = this.mVoteView;
            if (voteViewV2 != null) {
                voteViewV2.d(1);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(10, 1);
            this.mContentBgView.setLayoutParams(layoutParams);
            this.mCoverView.setTag(null);
            this.mCoverView.setOnClickListener(null);
            this.mCoverView.setClickable(false);
            this.mCoverView.setContentDescription(null);
        } else {
            if (this.mNameView != null) {
                if (!ThemeUtil.isInNightMode(this.mApp)) {
                    i16 = R.color.skin_white;
                }
                this.mNameView.setTextColor(getResources().getColor(i16));
            }
            VoteViewV2 voteViewV22 = this.mVoteView;
            if (voteViewV22 != null) {
                voteViewV22.d(0);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentBgView.getLayoutParams();
            layoutParams2.addRule(3, R.id.dkn);
            layoutParams2.addRule(10, 0);
            this.mContentBgView.setLayoutParams(layoutParams2);
            com.tencent.mobileqq.profile.b bVar = new com.tencent.mobileqq.profile.b(17, null);
            if (profileCardInfo.allInOne.f260789pa == 0) {
                string = getContext().getString(R.string.abn);
            } else {
                string = getContext().getString(R.string.abm);
            }
            this.mCoverView.setTag(bVar);
            this.mCoverView.setOnClickListener(this.mOnClickListener);
            this.mCoverView.setClickable(true);
            this.mCoverView.setContentDescription(string);
        }
        updateLayoutMargin(i3);
        updateQidViewMargin(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void onUpdate(ProfileCardInfo profileCardInfo, boolean z16) {
        super.onUpdate(profileCardInfo, z16);
        adaptBgViewNightMode();
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView, com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
    public void updateHead(ProfileCardInfo profileCardInfo) {
        super.updateHead(profileCardInfo);
        updateQidViewMargin(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public void updateLayoutMargin(int i3) {
        if (this.mNameView == null || this.mUinLayout == null || this.mNameLayout == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mVoteHeartLayout.getLayoutParams();
        if (i3 == 1) {
            marginLayoutParams.bottomMargin = ScreenUtil.dip2px(5.0f);
            this.mVoteHeartLayout.setLayoutParams(marginLayoutParams);
            if (this.mNameView.d() == 2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mNameLayout.getLayoutParams();
                if (this.mRemarkName.getVisibility() == 0) {
                    layoutParams.bottomMargin = ScreenUtil.dip2px(-2.0f);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mUinLayout.getLayoutParams();
                    layoutParams2.addRule(3, this.mNameLayout.getId());
                    this.mUinLayout.setLayoutParams(layoutParams2);
                }
                layoutParams.addRule(6, this.mAvatar.getId());
                layoutParams.addRule(8, 0);
                this.mNameLayout.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mNameLayout.getLayoutParams();
            layoutParams3.addRule(6, 0);
            layoutParams3.addRule(8, R.id.d38);
            this.mNameLayout.setLayoutParams(layoutParams3);
            return;
        }
        marginLayoutParams.bottomMargin = ScreenUtil.dip2px(15.0f);
        this.mVoteHeartLayout.setLayoutParams(marginLayoutParams);
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.a0c);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.a0e);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mNameLayout.getLayoutParams();
        layoutParams4.addRule(6, 0);
        layoutParams4.addRule(8, R.id.d38);
        this.mNameLayout.setLayoutParams(layoutParams4);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mNameLayout.getLayoutParams();
        if (marginLayoutParams2.bottomMargin != dimensionPixelSize) {
            marginLayoutParams2.bottomMargin = dimensionPixelSize;
            this.mNameLayout.setLayoutParams(marginLayoutParams2);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.mUinLayout.getLayoutParams();
        if (marginLayoutParams3.topMargin != dimensionPixelSize2) {
            marginLayoutParams3.topMargin = dimensionPixelSize2;
            this.mUinLayout.setLayoutParams(marginLayoutParams3);
        }
        if (QLog.isColorLevel()) {
            QLog.i(AbsProfileHeaderView.TAG, 2, String.format("updateLayoutMargin mode: %s, name:%s, level:%s", Integer.valueOf(i3), Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView
    public void updateQidViewMargin(ProfileCardInfo profileCardInfo) {
        int baseCardBottomMargin;
        QidCoolTextView qidCoolTextView = this.mQidInfoView;
        if (qidCoolTextView == null || (baseCardBottomMargin = qidCoolTextView.baseCardBottomMargin(profileCardInfo)) == 0) {
            return;
        }
        this.mQidInfoView.adapterQidMargin(0.0f, baseCardBottomMargin);
    }
}
