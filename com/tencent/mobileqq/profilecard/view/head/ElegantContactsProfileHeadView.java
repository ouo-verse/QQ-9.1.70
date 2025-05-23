package com.tencent.mobileqq.profilecard.view.head;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ElegantContactsProfileHeadView extends AbsElegantProfileHeadView {
    private static final int MAX_MENU_ITEM_COUNT = 5;
    private static final String MOBILE_REMARK_PREFIX = "\u624b\u673a\u53f7: ";
    private String[] mMenuItems;
    private int[] mMenuShowItemIndex;

    public ElegantContactsProfileHeadView(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate) {
        super(qBaseActivity, profileCardInfo, iProfileActivityDelegate);
    }

    private void showActionSheet(int[] iArr, final ProfileContactInfo profileContactInfo, final AllInOne allInOne) {
        if (this.mMenuItems == null) {
            this.mMenuItems = this.mActivity.getResources().getStringArray(R.array.f155206av);
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mActivity, null);
        for (int i3 : iArr) {
            if (i3 == 16) {
                actionSheet.addCancelButton(this.mMenuItems[i3]);
            } else if (i3 >= 0) {
                String[] strArr = this.mMenuItems;
                if (i3 < strArr.length) {
                    actionSheet.addButton(strArr[i3], 1);
                }
            }
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.view.head.ElegantContactsProfileHeadView.1
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i16) {
                int i17 = ElegantContactsProfileHeadView.this.mMenuShowItemIndex[i16];
                if (i17 == 7) {
                    ElegantContactsProfileHeadView.this.callContact(profileContactInfo);
                } else if (i17 == 8) {
                    ElegantContactsProfileHeadView.this.sendMsg(profileContactInfo);
                } else {
                    if (i17 != 9) {
                        return;
                    }
                    ElegantContactsProfileHeadView.this.setRemarks(profileContactInfo, allInOne);
                }
            }
        });
        try {
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "showActionSheet fail.", e16);
        }
    }

    public void handlePhoneClick(AllInOne allInOne, ProfileContactInfo profileContactInfo) {
        if (this.mMenuShowItemIndex == null) {
            this.mMenuShowItemIndex = new int[5];
        }
        int[] iArr = this.mMenuShowItemIndex;
        iArr[0] = 7;
        iArr[1] = 8;
        if (ProfilePAUtils.isPaTypeFriend(allInOne)) {
            int[] iArr2 = this.mMenuShowItemIndex;
            iArr2[2] = 9;
            iArr2[3] = 16;
        } else {
            int[] iArr3 = this.mMenuShowItemIndex;
            iArr3[2] = 16;
            iArr3[3] = -1;
        }
        int[] iArr4 = this.mMenuShowItemIndex;
        iArr4[4] = -1;
        showActionSheet(iArr4, profileContactInfo, allInOne);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.view.head.AbsElegantProfileHeadView, com.tencent.mobileqq.profilecard.view.head.AbsQCircleProfileHeaderView, com.tencent.mobileqq.profilecard.view.head.AbsZPlanProfileHeaderView, com.tencent.mobileqq.profilecard.base.view.ProfileBaseView
    public int initCoverMode(ProfileCardInfo profileCardInfo) {
        if (ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne)) {
            Object[] coverData = profileCardInfo.card.getCoverData(this.mCoverTimeStamp);
            String str = (String) coverData[0];
            if (!TextUtils.isEmpty(str)) {
                this.mCoverUrl = str;
                this.mCoverTimeStamp = ((Integer) coverData[1]).intValue();
            }
            return (TextUtils.isEmpty(this.mCoverUrl) || profileCardInfo.card.isNoCover()) ? 1 : 0;
        }
        return super.initCoverMode(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsElegantProfileHeadView
    public void onPhoneClick(AllInOne allInOne) {
        if (allInOne == null) {
            QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "onPhoneClick error, allInOne is null");
            return;
        }
        ArrayList<ProfileContactInfo> arrayList = allInOne.contactArray;
        if (arrayList != null && !arrayList.isEmpty()) {
            handlePhoneClick(allInOne, arrayList.get(0));
        } else {
            QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "onPhoneClick error, contactArray is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callContact(ProfileContactInfo profileContactInfo) {
        String str = profileContactInfo != null ? profileContactInfo.phoneNumber : null;
        if (str != null && str.length() > 0) {
            try {
                this.mActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str)));
                return;
            } catch (Exception e16) {
                QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "callContact fail.", e16);
                return;
            }
        }
        ProfileUIUtils.notifyUser(1, R.string.buj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(ProfileContactInfo profileContactInfo) {
        String str = profileContactInfo != null ? profileContactInfo.phoneNumber : null;
        if (str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + str));
            try {
                this.mActivity.startActivity(intent);
                return;
            } catch (Exception e16) {
                QLog.e(AbsQCircleProfileHeaderView.TAG, 1, "callContact fail.", e16);
                return;
            }
        }
        ProfileUIUtils.notifyUser(1, R.string.buj);
    }

    @Override // com.tencent.mobileqq.profilecard.view.head.AbsElegantProfileHeadView
    public void initRemarkView(ProfileCardInfo profileCardInfo) {
        ContactCard contactCard;
        if (profileCardInfo == null || (contactCard = profileCardInfo.contactCard) == null || TextUtils.isEmpty(contactCard.mobileNo)) {
            return;
        }
        if (((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
            this.mRemarkPreView.setText(MOBILE_REMARK_PREFIX + contactCard.mobileNo);
            this.mRemarkPreView.setEllipsize(TextUtils.TruncateAt.END);
            this.mRemarkPreView.setVisibility(0);
            return;
        }
        this.mRemarkPreView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRemarks(ProfileContactInfo profileContactInfo, AllInOne allInOne) {
        String str = profileContactInfo == null ? null : profileContactInfo.phoneName;
        if (str == null || str.length() <= 0) {
            return;
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            if (!str.equals(allInOne.remark)) {
                ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).setFriendComment(this.mApp, allInOne.uin, str, false);
                IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
                if (iProfileActivityDelegate != null) {
                    iProfileActivityDelegate.setRemark(str);
                    return;
                }
                return;
            }
            ProfileUIUtils.notifyUser(1, R.string.bvs);
            return;
        }
        ProfileUIUtils.notifyUser(1, R.string.cjl);
    }
}
