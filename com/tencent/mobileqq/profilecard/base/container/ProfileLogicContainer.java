package com.tencent.mobileqq.profilecard.base.container;

import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class ProfileLogicContainer extends AbsQQProfileContainer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileLogicContainer";
    private final CardObserver cardObserver;
    private final ar friendListObserver;
    private final com.tencent.mobileqq.friend.observer.a mFriendObserver;

    public ProfileLogicContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.friendListObserver = new ar() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLogicContainer.this);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSetComment(boolean z16, String str, String str2, byte b16) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
                String str3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
                    return;
                }
                if (z16 && ((ProfileCardInfo) ((AbsComponent) ProfileLogicContainer.this).mData).allInOne.uin != null && ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) ((AbsComponent) ProfileLogicContainer.this).mData).allInOne) && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) ((AbsComponent) ProfileLogicContainer.this).mData).allInOne.uin), ProfileLogicContainer.TAG)) != null) {
                    if (friendsSimpleInfoWithUid.r() != null) {
                        str3 = friendsSimpleInfoWithUid.r();
                    } else {
                        str3 = "";
                    }
                    if (((AbsProfileComponent) ProfileLogicContainer.this).mDelegate != null) {
                        ((AbsProfileComponent) ProfileLogicContainer.this).mDelegate.setRemark(str3);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onUpdateDelFriend(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                    return;
                }
                if (!z16 || !((ProfileCardInfo) ((AbsComponent) ProfileLogicContainer.this).mData).allInOne.uin.equals(String.valueOf(obj)) || ((AbsComponent) ProfileLogicContainer.this).mActivity == null) {
                    return;
                }
                if (AppSetting.t(((AbsComponent) ProfileLogicContainer.this).mActivity)) {
                    m.e(((AbsComponent) ProfileLogicContainer.this).mActivity);
                } else {
                    ((AbsComponent) ProfileLogicContainer.this).mActivity.finish();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.ar
            public void onUpdateFriendList(boolean z16, boolean z17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    ProfileLogicContainer.this.handleUpdateFriendList(z16, z17);
                } else {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                }
            }
        };
        this.mFriendObserver = new com.tencent.mobileqq.friend.observer.a() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLogicContainer.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.friend.observer.a
            public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                } else if (z16 && z17 && z18) {
                    ProfileLogicContainer.this.handleUpdateAddFriend(str, bundle);
                }
            }
        };
        this.cardObserver = new CardObserver() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileLogicContainer.this);
                }
            }

            @Override // com.tencent.mobileqq.app.CardObserver
            protected void onGetLocationDescription(boolean z16, String str, Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    try {
                        ProfileLogicContainer.this.onLocationUpdate(z16, str, card);
                        return;
                    } catch (Exception e16) {
                        QLog.e(ProfileLogicContainer.TAG, 1, e16.getMessage());
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleUpdateAddFriend(String str, Bundle bundle) {
        IProfileActivityDelegate iProfileActivityDelegate;
        String string = bundle.getString(ISelectMemberActivityConstants.Result_Uin);
        if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne) && ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) this.mData).allInOne).equals(str)) {
            IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
            if (iProfileActivityDelegate2 != null) {
                iProfileActivityDelegate2.checkAndSwitch2Friend(true, false, string);
                return;
            }
            return;
        }
        if (string != null) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne != null && string.equalsIgnoreCase(((ProfileCardInfo) data).allInOne.uin) && (iProfileActivityDelegate = this.mDelegate) != null) {
                iProfileActivityDelegate.checkAndSwitch2Friend(false, false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handleUpdateFriendList(boolean z16, boolean z17) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        IProfileActivityDelegate iProfileActivityDelegate;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("handleUpdateFriendList isSuccess=%s isComplete=%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        if (z16 && z17 && ((ProfileCardInfo) this.mData).allInOne.uin != null) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid2 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((ProfileCardInfo) this.mData).allInOne.uin), TAG);
            String str = "";
            if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne)) {
                if (friendsSimpleInfoWithUid2 != null) {
                    if (friendsSimpleInfoWithUid2.r() != null) {
                        str = friendsSimpleInfoWithUid2.r();
                    }
                    IProfileActivityDelegate iProfileActivityDelegate2 = this.mDelegate;
                    if (iProfileActivityDelegate2 != null) {
                        iProfileActivityDelegate2.setRemark(str);
                        return;
                    }
                    return;
                }
                return;
            }
            PhoneContact phoneContact = null;
            if (ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo) this.mData).allInOne)) {
                if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 53) {
                    IProfileActivityDelegate iProfileActivityDelegate3 = this.mDelegate;
                    if (iProfileActivityDelegate3 != null) {
                        iProfileActivityDelegate3.requestUpdateCard();
                        return;
                    }
                    return;
                }
                IPhoneContactService iPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
                if (iPhoneContactService != null) {
                    phoneContact = iPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo) this.mData).allInOne));
                }
                if (phoneContact != null && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact.uin), TAG)) != null && friendsSimpleInfoWithUid.B() && (iProfileActivityDelegate = this.mDelegate) != null) {
                    iProfileActivityDelegate.checkAndSwitch2Friend(true, false, phoneContact.uin);
                    return;
                }
                return;
            }
            if (friendsSimpleInfoWithUid2 != null && friendsSimpleInfoWithUid2.B() && !((ProfileCardInfo) this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileLogicContainer.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else if (((AbsProfileComponent) ProfileLogicContainer.this).mDelegate != null) {
                            ((AbsProfileComponent) ProfileLogicContainer.this).mDelegate.checkAndSwitch2Friend(false, false, ((ProfileCardInfo) ((AbsComponent) ProfileLogicContainer.this).mData).allInOne.uin);
                        }
                    }
                }, 16, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onLocationUpdate(boolean z16, String str, Card card) {
        DATA data;
        IComponentCenter iComponentCenter;
        IComponent component;
        if (!z16 || card == null || (data = this.mData) == 0 || !((ProfileCardInfo) data).allInOne.uin.equals(card.uin) || (iComponentCenter = this.mComponentCenter) == null || (component = iComponentCenter.getComponent(1023)) == null) {
            return;
        }
        DATA data2 = this.mData;
        ((ProfileCardInfo) data2).card = card;
        component.lambda$checkValidComponent$3(data2);
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    protected List<Integer> getChildComponentTypeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1034);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 108;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IProfileActivityDelegate iProfileActivityDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 4 && i16 == -1 && intent != null && intent.hasExtra("result")) {
            String stringExtra = intent.getStringExtra("result");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onActivityResult, resultStr : " + stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    Object obj = new JSONObject(stringExtra).get("payState");
                    if (obj != null && "0".equals(String.valueOf(obj)) && (iProfileActivityDelegate = this.mDelegate) != null) {
                        iProfileActivityDelegate.requestUpdateCard();
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onActivityResult, Exception : " + e16.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer, com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.addObserver(this.friendListObserver);
            this.mApp.addObserver(this.mFriendObserver);
            this.mApp.addObserver(this.cardObserver);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.removeObserver(this.friendListObserver);
            this.mApp.removeObserver(this.mFriendObserver);
            this.mApp.removeObserver(this.cardObserver);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra("key_back_from_add_friend", false)) {
                this.mActivity.setResult(-1);
                this.mActivity.finish();
            }
        } catch (BadParcelableException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
