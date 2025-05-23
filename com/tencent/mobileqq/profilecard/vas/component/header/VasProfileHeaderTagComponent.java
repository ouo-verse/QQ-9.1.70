package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes16.dex */
public class VasProfileHeaderTagComponent extends AbsVasProfileHeaderComponent {
    private static final String TAG = "VasProfileHeaderTagComponent";

    public VasProfileHeaderTagComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleTagEditClick() {
        Intent intent = new Intent(this.mActivity, (Class<?>) ProfileLabelEditorActivity.class);
        intent.putExtra("uin", ((ProfileCardInfo) this.mData).allInOne.uin);
        this.mActivity.startActivityForResult(intent, 1004);
        ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
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
            boolean booleanExtra = this.mActivity.getIntent().getBooleanExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS, false);
            VasProfileTagView vasProfileTagView = new VasProfileTagView(this.mActivity, (ProfileCardInfo) this.mData);
            vasProfileTagView.setFromExtendFriend(booleanExtra);
            vasProfileTagView.setProfileArgs(this.mComponentCenter, this.mDelegate);
            vasProfileTagView.setClickListener(this);
            vasProfileTagView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            this.mDelegate.getListView().setMotionEventInterceptor(vasProfileTagView);
            this.mHeaderView = vasProfileTagView;
            ((FrameLayout) this.mViewContainer).removeAllViews();
            ((FrameLayout) this.mViewContainer).addView(this.mHeaderView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        Card r16;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1004 && (r16 = ((FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.mApp.getCurrentAccountUin())) != null) {
            DATA data = this.mData;
            ((ProfileCardInfo) data).card = r16;
            this.mHeaderView.updateTagCloud((ProfileCardInfo) data);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if ((view.getTag() instanceof b) && ((b) view.getTag()).f260135a == 32) {
            handleTagEditClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
