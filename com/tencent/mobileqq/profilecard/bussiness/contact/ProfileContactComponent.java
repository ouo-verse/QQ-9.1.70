package com.tencent.mobileqq.profilecard.bussiness.contact;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unifiedname.a;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileContactComponent extends AbsProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_MENU_ITEM_COUNT = 5;
    private static final String TAG = "ProfileContactComponent";
    private String[] mMenuItems;
    private int[] mMenuShowItemIndex;
    private ProfileContactInfo mSelectContactInfo;

    public ProfileContactComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private ViewGroup addAccountBaseInfoItem(ViewGroup viewGroup, int i3, CharSequence charSequence, boolean z16) {
        if (viewGroup == null || i3 <= 0 || TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.f168839b00, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.icon);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.info);
        findViewById.setBackgroundResource(i3);
        if (charSequence instanceof String) {
            textView.setText(((String) charSequence).trim());
        } else {
            textView.setText(charSequence);
        }
        viewGroup.addView(viewGroup2);
        if (z16) {
            LongClickCopyAction.attachCopyAction(textView);
        }
        updateItemTheme(viewGroup2, textView, null, null);
        return viewGroup2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ViewGroup addPhoneInfoViewPhoneItem(ViewGroup viewGroup, ProfileContactInfo profileContactInfo) {
        String str;
        if (viewGroup == null || profileContactInfo == null) {
            return null;
        }
        CharSequence charSequence = profileContactInfo.phoneNumber;
        ViewGroup viewGroup2 = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.f168840b05, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.f165861dq1);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.info);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.f164472yw);
        findViewById.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.qq_profilecard_item_tel);
        textView.setText(charSequence);
        viewGroup.addView(viewGroup2);
        String string = this.mActivity.getString(R.string.aet);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 33) {
            str = profileContactInfo.phoneNumber;
        } else {
            str = profileContactInfo.phoneName + " " + profileContactInfo.phoneNumber;
        }
        LongClickCopyAction.attachCopyAction(textView, string, str);
        updateItemTheme(viewGroup2, textView, null, imageView);
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callContact(ProfileContactInfo profileContactInfo) {
        String str;
        if (profileContactInfo != null) {
            str = profileContactInfo.phoneNumber;
        } else {
            str = null;
        }
        if (str != null && str.length() > 0) {
            try {
                this.mActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str)));
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "callContact fail.", e16);
                return;
            }
        }
        ProfileUIUtils.notifyUser(1, R.string.buj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handlePhoneClick() {
        if (this.mMenuShowItemIndex == null) {
            this.mMenuShowItemIndex = new int[5];
        }
        int[] iArr = this.mMenuShowItemIndex;
        iArr[0] = 7;
        iArr[1] = 8;
        if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
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
        showActionSheet(iArr4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [VIEW, android.view.ViewGroup] */
    private boolean makeOrRefreshPhoneInfoView(ProfileCardInfo profileCardInfo) {
        boolean z16;
        boolean z17;
        ViewGroup viewGroup;
        DATA data = this.mData;
        ContactCard contactCard = ((ProfileCardInfo) data).contactCard;
        ArrayList<ProfileContactInfo> arrayList = ((ProfileCardInfo) data).allInOne.contactArray;
        if (!ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne) && profileCardInfo.allInOne.f260789pa != 80) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (contactCard == null || arrayList == null || arrayList.isEmpty() || ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).isContactProfileElegantVersion()) {
            z16 = false;
        }
        if (!z16) {
            if (this.mViewContainer == 0) {
                return false;
            }
            this.mViewContainer = null;
            return true;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mViewContainer;
        if (viewGroup2 == null) {
            ?? r26 = (ViewGroup) this.mActivity.getLayoutInflater().inflate(R.layout.b0d, (ViewGroup) null);
            this.mViewContainer = r26;
            z17 = true;
            viewGroup = r26;
        } else {
            z17 = false;
            viewGroup = viewGroup2;
        }
        List<a> list = profileCardInfo.profileName.f305806b;
        if (list != null) {
            list.clear();
        }
        viewGroup.removeAllViews();
        addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_account, contactCard.nickName, true);
        addAccountBaseInfoItem(viewGroup, R.drawable.qq_profilecard_item_information, ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).makeSexAgeArea(this.mActivity, contactCard.bSex, contactCard.bAge, contactCard.strCountry, contactCard.strProvince, contactCard.strCity), true);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ProfileContactInfo profileContactInfo = arrayList.get(i3);
            ViewGroup addPhoneInfoViewPhoneItem = addPhoneInfoViewPhoneItem(viewGroup, profileContactInfo);
            if (addPhoneInfoViewPhoneItem != null) {
                addPhoneInfoViewPhoneItem.setTag(new b(4, profileContactInfo));
                addPhoneInfoViewPhoneItem.setOnClickListener(this);
            }
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(ProfileContactInfo profileContactInfo) {
        String str;
        if (profileContactInfo != null) {
            str = profileContactInfo.phoneNumber;
        } else {
            str = null;
        }
        if (str != null && str.length() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse(SmsPlugin.KEY_SYSTEM_SMS_URI + str));
            try {
                this.mActivity.startActivity(intent);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "callContact fail.", e16);
                return;
            }
        }
        ProfileUIUtils.notifyUser(1, R.string.buj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setRemarks(ProfileContactInfo profileContactInfo) {
        String str;
        if (profileContactInfo == null) {
            str = null;
        } else {
            str = profileContactInfo.phoneName;
        }
        if (str != null && str.length() > 0) {
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                if (!"".equals(str) && !str.equals(((ProfileCardInfo) this.mData).allInOne.remark)) {
                    IProfileCardBusinessApi iProfileCardBusinessApi = (IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class);
                    if (iProfileCardBusinessApi != null) {
                        iProfileCardBusinessApi.setFriendComment(this.mApp, ((ProfileCardInfo) this.mData).allInOne.uin, str, false);
                        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
                        if (iProfileActivityDelegate != null) {
                            iProfileActivityDelegate.setRemark(str);
                            return;
                        }
                        return;
                    }
                    ProfileUIUtils.notifyUser(1, R.string.bw_);
                    return;
                }
                ProfileUIUtils.notifyUser(1, R.string.bvs);
                return;
            }
            ProfileUIUtils.notifyUser(1, R.string.cjl);
        }
    }

    private void showActionSheet(int[] iArr) {
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
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.contact.ProfileContactComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileContactComponent.this);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i16);
                    return;
                }
                int i17 = ProfileContactComponent.this.mMenuShowItemIndex[i16];
                if (i17 != 7) {
                    if (i17 != 8) {
                        if (i17 == 9) {
                            ProfileContactComponent profileContactComponent = ProfileContactComponent.this;
                            profileContactComponent.setRemarks(profileContactComponent.mSelectContactInfo);
                            return;
                        }
                        return;
                    }
                    ProfileContactComponent profileContactComponent2 = ProfileContactComponent.this;
                    profileContactComponent2.sendMsg(profileContactComponent2.mSelectContactInfo);
                    return;
                }
                ProfileContactComponent profileContactComponent3 = ProfileContactComponent.this;
                profileContactComponent3.callContact(profileContactComponent3.mSelectContactInfo);
            }
        });
        try {
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showActionSheet fail.", e16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1030;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_PHONE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof b) {
                b bVar = (b) tag;
                if (bVar.f260135a == 4) {
                    this.mSelectContactInfo = (ProfileContactInfo) bVar.f260136b;
                    handlePhoneClick();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        return makeOrRefreshPhoneInfoView(profileCardInfo) | super.lambda$checkValidComponent$3((ProfileContactComponent) profileCardInfo);
    }
}
