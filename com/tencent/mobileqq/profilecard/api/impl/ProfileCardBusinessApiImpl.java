package com.tencent.mobileqq.profilecard.api.impl;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.KPLProfileCardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileOpenApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.profilecard.api.IVasProfileComponentFactory;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.slf4j.Marker;

/* loaded from: classes16.dex */
public class ProfileCardBusinessApiImpl implements IProfileCardBusinessApi {
    static IPatchRedirector $redirector_;

    public ProfileCardBusinessApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String addNationCodeIfNeeded(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) str);
        }
        if (str != null && !str.startsWith(Marker.ANY_NON_NULL_MARKER) && str.length() == 11 && !str.startsWith("0")) {
            RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) appRuntime.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
            if (selfBindInfo != null && !TextUtils.isEmpty(selfBindInfo.nationCode)) {
                return selfBindInfo.nationCode + str.trim();
            }
            return "+86" + str.trim();
        }
        return str;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void batchFetchFriendNick(ArrayList<String> arrayList, IProfileCardBusinessApi.CommonCallback commonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList, (Object) commonCallback);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof AppInterface)) {
                commonCallback.onResult(1, new Bundle());
                return;
            }
            AppInterface appInterface = (AppInterface) peekAppRuntime;
            appInterface.addObserver(new ar(appInterface, commonCallback, arrayList) { // from class: com.tencent.mobileqq.profilecard.api.impl.ProfileCardBusinessApiImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppInterface val$appInterface;
                final /* synthetic */ IProfileCardBusinessApi.CommonCallback val$callback;
                final /* synthetic */ ArrayList val$uinList;

                {
                    this.val$appInterface = appInterface;
                    this.val$callback = commonCallback;
                    this.val$uinList = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileCardBusinessApiImpl.this, appInterface, commonCallback, arrayList);
                    }
                }

                @Override // com.tencent.mobileqq.app.ar
                protected void onUpdateFriendInfoFinished(ArrayList arrayList2, boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, arrayList2, Boolean.valueOf(z16));
                        return;
                    }
                    this.val$appInterface.removeObserver(this);
                    Bundle bundle = new Bundle();
                    if (!z16) {
                        this.val$callback.onResult(1, bundle);
                        return;
                    }
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (!(peekAppRuntime2 instanceof QQAppInterface)) {
                        this.val$callback.onResult(1, bundle);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    FriendsManager friendsManager = (FriendsManager) ((QQAppInterface) peekAppRuntime2).getManager(QQManagerFactory.FRIENDS_MANAGER);
                    Iterator it = this.val$uinList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        Card t16 = friendsManager.t(str);
                        if (t16 != null) {
                            hashMap.put(str, t16.strNick);
                        }
                    }
                    SerializableMap serializableMap = new SerializableMap();
                    serializableMap.setMap(hashMap);
                    bundle.putSerializable(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK_MAP, serializableMap);
                    this.val$callback.onResult(0, bundle);
                }
            });
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendsInfo((String[]) arrayList.toArray(new String[arrayList.size()]));
            return;
        }
        commonCallback.onResult(1, new Bundle());
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public IProfileConfig createProfileConfig(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IProfileConfig) iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInterface);
        }
        return new ProfileConfig(appInterface);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public AbsProfileComponent createVasProfileComponent(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (AbsProfileComponent) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), iComponentCenter, profileCardInfo);
        }
        return ((IVasProfileComponentFactory) QRoute.api(IVasProfileComponentFactory.class)).create(i3, iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void dealTextViewForCopyAction(TextView textView, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, textView, str, str2);
        } else {
            ProfileCardUtil.e(textView, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public Intent getBabyQProfileCardIntent(Context context, AllInOne allInOne) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) allInOne);
        }
        if (Utils.G(allInOne.uin) && !TextUtils.isEmpty(Utils.f306522e)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", Utils.f306522e);
            return intent;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String getConstellation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        return NearbyProfileUtil.b(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String getJob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        return NearbyProfileUtil.d(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String getJobTag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        return NearbyProfileUtil.e(i3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public Intent getKPLProfileCardIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return KPLProfileCardActivity.K2(context);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public Class<?> getQQBrowserActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return QQBrowserActivity.class;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void initContactCardInfoList(AppInterface appInterface, ProfileCardInfo profileCardInfo, boolean z16) {
        IPhoneContactService iPhoneContactService;
        PhoneContact phoneContact;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appInterface, profileCardInfo, Boolean.valueOf(z16));
            return;
        }
        if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne) || (i3 = profileCardInfo.allInOne.f260789pa) == 33 || i3 == 32 || i3 == 31 || i3 == 34 || i3 == 51 || i3 == 50 || i3 == 36 || i3 == 29 || i3 == 53) {
            AllInOne allInOne = profileCardInfo.allInOne;
            if (allInOne.contactArray == null) {
                allInOne.contactArray = new ArrayList<>();
            }
            if (profileCardInfo.allInOne.contactArray.size() != 0 || (iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "")) == null) {
                return;
            }
            if (ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne)) {
                phoneContact = iPhoneContactService.queryPhoneContactByUin(profileCardInfo.allInOne.uin);
                if (!z16) {
                    FriendListHandler friendListHandler = (FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    if (!friendListHandler.isGetOnlineListRecently() && !friendListHandler.shouldGetOnlineInfo()) {
                        friendListHandler.getOnlineInfo(profileCardInfo.allInOne.uin, false);
                    }
                    ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).requestNTOnlineStatusByUin(profileCardInfo.allInOne.uin, false, "ProfileCardBusinessApiImpl");
                }
            } else {
                PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(profileCardInfo.allInOne.uin);
                if (queryContactByCodeNumber == null) {
                    phoneContact = iPhoneContactService.queryPhoneContactByMobile(profileCardInfo.allInOne.uin);
                    if (phoneContact != null && !TextUtils.isEmpty(phoneContact.mobileCode)) {
                        profileCardInfo.allInOne.uin = phoneContact.mobileCode;
                    }
                } else {
                    phoneContact = queryContactByCodeNumber;
                }
                if (phoneContact != null) {
                    FriendListHandler friendListHandler2 = (FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    if (!friendListHandler2.shouldGetOnlineInfo()) {
                        friendListHandler2.getOnlineInfo(profileCardInfo.allInOne.uin, true);
                    }
                }
            }
            AllInOne allInOne2 = profileCardInfo.allInOne;
            int i16 = allInOne2.f260789pa;
            if (i16 == 53) {
                ArrayList<ProfileContactInfo> arrayList = allInOne2.contactArray;
                AllInOne allInOne3 = profileCardInfo.allInOne;
                arrayList.add(new ProfileContactInfo(allInOne3.contactName, allInOne3.uin, ""));
            } else {
                if (phoneContact != null) {
                    allInOne2.contactArray.add(new ProfileContactInfo(phoneContact.name, phoneContact.mobileCode, phoneContact.nationCode));
                    return;
                }
                if (i16 == 33 || i16 == 32 || i16 == 31 || i16 == 34 || i16 == 51 || i16 == 50 || i16 == 36 || i16 == 29) {
                    allInOne2.contactArray.add(new ProfileContactInfo("", profileCardInfo.allInOne.uin, ""));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public boolean isBindedIgnoreUpload(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return ((IPhoneContactService) appRuntime.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload();
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public boolean isDefaultProfile(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        return ProfileCardUtils.isDefaultProfile(profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void jumpProfileOpenDetails(ProfileCardInfo profileCardInfo, AppInterface appInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, profileCardInfo, appInterface, activity);
        } else {
            ProfileCardUtil.p0(profileCardInfo, (QQAppInterface) appInterface, activity);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public SpannableString makeSchoolAuthenticationIcon(String str, boolean z16, int i3, int i16, int i17, Context context, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (SpannableString) iPatchRedirector.redirect((short) 20, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), context, appInterface);
        }
        return ProfileCardUtil.Y(str, z16, i3, i16, i17, context, (QQAppInterface) appInterface);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String makeSexAgeArea(Context context, int i3, int i16, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, context, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3);
        }
        return ProfileCardUtil.Z(context, i3, i16, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public byte needReqMedalWall(Context context, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Byte) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) appRuntime)).byteValue();
        }
        return (byte) ea.x0(context, appRuntime.getCurrentAccountUin());
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public boolean needReqOCRCard(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime)).booleanValue();
        }
        BusinessCardManager businessCardManager = (BusinessCardManager) appRuntime.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        if (businessCardManager != null) {
            return businessCardManager.j(1);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void onProfileRedTouchClick(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            ((LocalRedTouchManager) appRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).s(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean openRobotProfileCard(Context context, AllInOne allInOne) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) allInOne)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !k.l(peekAppRuntime, allInOne.uin)) {
            return false;
        }
        int i17 = allInOne.profileEntryType;
        if (i17 != 61) {
            if (i17 == 1) {
                i16 = 11;
            } else {
                i3 = 0;
                Bundle bundle = new Bundle();
                if (allInOne.preWinUin.equals(allInOne.uin)) {
                    bundle.putBoolean("key_enter_chat_by_finish", true);
                }
                ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, allInOne.uin, "", i3, 0, bundle));
                return true;
            }
        }
        i3 = i16;
        Bundle bundle2 = new Bundle();
        if (allInOne.preWinUin.equals(allInOne.uin)) {
        }
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, allInOne.uin, "", i3, 0, bundle2));
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public void setFriendComment(AppInterface appInterface, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, appInterface, str, str2, Boolean.valueOf(z16));
            return;
        }
        FriendListHandler friendListHandler = (FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler != null) {
            friendListHandler.setFriendComment(str, str2, z16);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi
    public String syncFetchFriendNick(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return str;
        }
        return ac.y((QQAppInterface) peekAppRuntime, str);
    }
}
