package com.tencent.mobileqq.profilecard.component.head;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.view.head.OldProfileHeadView;
import com.tencent.mobileqq.profilecard.view.head.ZplanProfileHeadViewOld;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;

/* loaded from: classes35.dex */
public class OldProfileHeaderComponent extends BaseProfileHeaderComponent {
    private boolean isShowQCircleCover;
    private boolean isShowZplanCover;
    private AbsProfileContentComponent mAccountInfoComponent;
    private AbsProfileContentComponent mAccountLevelComponent;
    private ZplanProfileHeadViewOld mZplanProfileHeadViewOld;

    public OldProfileHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mZplanProfileHeadViewOld = null;
    }

    private void destroyProfileAccountInfoComponent() {
        AbsProfileContentComponent absProfileContentComponent = this.mAccountInfoComponent;
        if (absProfileContentComponent != null) {
            removeComponent(absProfileContentComponent);
            this.mAccountInfoComponent.detachFromComponentCenter();
            this.mAccountInfoComponent = null;
        }
    }

    private void destroyProfileAccountLevelComponent() {
        AbsProfileContentComponent absProfileContentComponent = this.mAccountLevelComponent;
        if (absProfileContentComponent != null) {
            removeComponent(absProfileContentComponent);
            this.mAccountLevelComponent.detachFromComponentCenter();
            this.mAccountLevelComponent = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initProfileAccountInfoComponent() {
        if (this.mAccountInfoComponent == null) {
            View findViewById = this.mHeaderView.findViewById(R.id.f58532q_);
            AbsProfileContentComponent absProfileContentComponent = (AbsProfileContentComponent) ProfileUtils.create(1024, this.mComponentCenter, (ProfileCardInfo) this.mData, this.mDelegate);
            this.mAccountInfoComponent = absProfileContentComponent;
            absProfileContentComponent.setContainerView(findViewById);
            this.mAccountInfoComponent.attachToComponentCenter();
            addComponent(this.mAccountInfoComponent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initProfileAccountLevelComponent() {
        if (this.mAccountLevelComponent == null) {
            View findViewById = this.mHeaderView.findViewById(R.id.f58542qa);
            AbsProfileContentComponent absProfileContentComponent = (AbsProfileContentComponent) ProfileUtils.create(1022, this.mComponentCenter, (ProfileCardInfo) this.mData, this.mDelegate);
            this.mAccountLevelComponent = absProfileContentComponent;
            absProfileContentComponent.setContainerView(findViewById);
            this.mAccountLevelComponent.attachToComponentCenter();
            addComponent(this.mAccountLevelComponent);
        }
    }

    private void readjustAccountInfoComponent() {
        destroyProfileAccountInfoComponent();
        initProfileAccountInfoComponent();
    }

    private void readjustAccountLevelComponent() {
        destroyProfileAccountLevelComponent();
        initProfileAccountLevelComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent
    protected ProfileBaseView initProfileBaseView() {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        boolean z16 = false;
        this.isShowZplanCover = iProfileActivityDelegate != null ? iProfileActivityDelegate.getIsShowZplanCover() : false;
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        if (iProfileActivityDelegate2 != null && iProfileActivityDelegate2.isShowQCircleCover()) {
            z16 = true;
        }
        this.isShowQCircleCover = z16;
        if (!this.isShowZplanCover && !z16) {
            return new OldProfileHeadView(this.mActivity, (ProfileCardInfo) this.mData, this.mDelegate);
        }
        ZplanProfileHeadViewOld zplanProfileHeadViewOld = new ZplanProfileHeadViewOld(this.mActivity, (ProfileCardInfo) this.mData, this.mDelegate);
        this.mZplanProfileHeadViewOld = zplanProfileHeadViewOld;
        return zplanProfileHeadViewOld;
    }

    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getTag() instanceof b) {
            int i3 = ((b) view.getTag()).f260135a;
            if (i3 == 1 || i3 == 17) {
                dtReport(view);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        AbsProfileHeaderView absProfileHeaderView = this.mHeaderView;
        if (absProfileHeaderView != null) {
            if (absProfileHeaderView.getChildView("map_key_qzonecover") != null) {
                ProfileCardDtReportUtil.initElementWithExposure(this.mHeaderView.getChildView("map_key_qzonecover"), ProfileCardDtReportUtil.DT_REPORT_COVER);
            }
            if (this.mHeaderView.getChildView("map_key_face") != null) {
                ProfileCardDtReportUtil.initElementWithExposure(this.mHeaderView.getChildView("map_key_face"), ProfileCardDtReportUtil.DT_REPORT_AVATAR);
            }
        }
        initProfileAccountInfoComponent();
        initProfileAccountLevelComponent();
    }

    @Override // com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        destroyProfileAccountInfoComponent();
        destroyProfileAccountLevelComponent();
        ZplanProfileHeadViewOld zplanProfileHeadViewOld = this.mZplanProfileHeadViewOld;
        if (zplanProfileHeadViewOld != null) {
            zplanProfileHeadViewOld.onDestroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        Card card;
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        boolean z16 = iProfileActivityDelegate != null && iProfileActivityDelegate.getIsShowZplanCover();
        IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
        boolean z17 = iProfileActivityDelegate2 != null && iProfileActivityDelegate2.isShowQCircleCover();
        if (this.isShowZplanCover != z16 || this.isShowQCircleCover != z17) {
            this.isShowZplanCover = z16;
            this.isShowQCircleCover = z17;
            if (!z16 && !z17) {
                super.resetHeaderView(new OldProfileHeadView(this.mActivity, (ProfileCardInfo) this.mData, this.mDelegate));
                readjustAccountInfoComponent();
                readjustAccountLevelComponent();
            } else {
                ZplanProfileHeadViewOld zplanProfileHeadViewOld = new ZplanProfileHeadViewOld(this.mActivity, (ProfileCardInfo) this.mData, this.mDelegate);
                this.mZplanProfileHeadViewOld = zplanProfileHeadViewOld;
                super.resetHeaderView(zplanProfileHeadViewOld);
                this.mZplanProfileHeadViewOld.onResume();
            }
            IProfileActivityDelegate iProfileActivityDelegate3 = this.mDelegate;
            PullToZoomHeaderListView listView = iProfileActivityDelegate3 != null ? iProfileActivityDelegate3.getListView() : null;
            if (listView != null) {
                listView.setSelection(0);
            }
            this.mZplanProfileHeadViewOld.adjustTitle();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3(profileCardInfo);
        if (this.isShowZplanCover || this.isShowQCircleCover) {
            updateItemTheme(this.mZplanProfileHeadViewOld.mNickView, (View) null);
            if (profileCardInfo != null && (card = profileCardInfo.card) != null && PrettyAccountUtil.isPrettyOpenForCard(card) != 1) {
                updateItemTheme(this.mZplanProfileHeadViewOld.mRemarkPreView, (View) null);
            }
        }
        return lambda$checkValidComponent$3;
    }
}
