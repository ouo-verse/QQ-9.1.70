package com.tencent.mobileqq.phonecontact.api;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.qroute.annotation.Service;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;
import od2.a;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IPhoneContactService extends IRuntimeService {
    void OnDisableMobileBindSuc();

    boolean addContactAndUpload(String str, String str2);

    void addFriendSuccessNotify(String str, String str2);

    void addListener(a aVar);

    void addUinByPhoneNum(String str, String str2);

    com.tencent.mobileqq.phonecontact.data.a asyncInitContactBindedData(List<PhoneContact> list);

    void changeHidenStatus(String str, boolean z16);

    boolean checkAndUploadContact(boolean z16);

    void checkUpdateBindStateAndListIgnoreBindState(boolean z16, boolean z17, int i3);

    void checkUpdateLocalContact(boolean z16, int i3);

    void clearRecommendBadge();

    void deleteContactMatch(ContactMatch contactMatch);

    void deletePhoneContactAddInfo(PhoneContactAdd phoneContactAdd);

    boolean deletePhoneContactAddInfo(String str);

    void disableMobileMatch(String str, String str2);

    boolean existContact(String str, String str2);

    void fillToMaxCountIfNeeded(ArrayList<PhoneContact> arrayList, int i3);

    ArrayList<PhoneContact> generateRandomList();

    int getBannerState();

    List<PhoneContact> getBindAllFriendList();

    List<PhoneContact> getBindHideNoneFriendList(boolean z16);

    List<PhoneContact> getBindNonfriendList();

    List<PhoneContact> getBindNonfriendList(int[] iArr);

    List<Object> getBindNonfriendListInObject();

    List<Object> getBindNonfriendListInObject(int[] iArr);

    int getBindStateForServer();

    com.tencent.mobileqq.phonecontact.data.a getContactBoundDataCache();

    List<PhoneContact> getContactList();

    List<PhoneContact> getContactListForContactListView(Map<String, PhoneContact> map, boolean z16);

    List<PhoneContact> getContactListForContactListView(boolean z16);

    List<List<PhoneContact>> getContactListForDisplay();

    List<PhoneContact> getContactListForPhoneSelector();

    List<PhoneContact> getContactListForSelector();

    Object[] getFriendHasBindPhone();

    long getLastLoginType(String str);

    ArrayList<PhoneContactAdd> getPhoneContactAddList();

    PhoneContact getPhoneContactByMD5(String str);

    String getPhoneNumByUin(String str);

    ArrayList<Entity> getRecommendContact();

    int getRecommendUnreadCount();

    List<PhoneContact> getRecommendUnreadList();

    RespondQueryQQBindingStat getSelfBindInfo();

    int getSelfBindState();

    long getUIBits();

    String getUNIQUE_NO();

    String getUinByPhoneNum(String str);

    int getUploadPackages();

    int getsAllEntranceConfigVersion();

    void hideContact(String str, boolean z16);

    void initContactCache();

    boolean isAutoUploadContacts();

    boolean isBindContactOk();

    boolean isBindNoneFriendListEmpty();

    boolean isBindedIgnoreUpload();

    boolean isDestroyed();

    int loadContactFriendList(List<String> list);

    Map<String, PhoneContact> loadContactFromPhoneWithoutCaches();

    void makePhoneContactAddInfo(String str, int i3, String str2);

    void markAndUploadForNewGuide();

    void markOrClearUserSettingFlag(boolean z16);

    void markRecommendReaded();

    void markUploadedContact(List<AddressBookItem> list);

    void markUploadedContactNotBind(List<AddressBookItem> list);

    boolean needShowToastWhenUpload();

    boolean needUploadContact();

    void notifyContactChanged();

    void onAppRunBackground();

    void onAppRunForeground();

    void onFriendListChanged();

    void onGetFriendsHasBindPhone(int i3, List<String> list);

    PhoneContact queryContactByCodeNumber(String str);

    PhoneContact queryPhoneContactByMobile(String str);

    PhoneContact queryPhoneContactByUin(String str);

    void removeListener(a aVar);

    void saveBindConfig(int i3, String str, String str2);

    boolean saveBindInfo(RespondQueryQQBindingStat respondQueryQQBindingStat, String str);

    int saveContactFromServer(boolean z16, int i3, long j3, boolean z17, long j16, long j17, List<MobileContactsFriendInfo> list, List<MobileContactsNotFriendInfo> list2);

    int saveContactFromServerNotBind(boolean z16, int i3, long j3, long j16, ArrayList<NotBindContactFriendInfo> arrayList, ArrayList<NotBindContactNotFriendInfo> arrayList2);

    void saveLastLoginList(List<String> list, long j3, long j16);

    void saveQueryInterval(long j3, long j16, long j17);

    void saveUIBits(long j3);

    void sendBindMobile(String str, String str2);

    void sendBindMobile(String str, String str2, int i3, boolean z16, boolean z17);

    void sendBindMobileEncrypt(String str, byte[] bArr, int i3, boolean z16, boolean z17);

    void sendRebindMobile(String str, String str2);

    void sendRebindMobile(String str, String str2, int i3, boolean z16, boolean z17);

    void sendRebindMobileEncrypt(String str, byte[] bArr, int i3, boolean z16, boolean z17);

    void sendVerifySmsCode(String str);

    void sendVerifySmsCode(String str, int i3, boolean z16, boolean z17);

    void setContactBoundDataCache(com.tencent.mobileqq.phonecontact.data.a aVar);

    void setNeedUploadResultTip(boolean z16);

    void setOpeningShareFlag(boolean z16);

    void setUploadToastSwitch(boolean z16);

    boolean shouldBlockMessageTips();

    void unbindMobile();

    void unbindMobile(boolean z16, boolean z17);

    void unbindMobileEncrypt(byte[] bArr, boolean z16, boolean z17);

    void updateAllEntranceConfig(int i3, String str);

    void updateOnlineStatus(String str, GetOnlineInfoResp getOnlineInfoResp);

    void updateRenameList(ArrayList<PhoneContact> arrayList);

    void updateSessionId(byte[] bArr);

    void uploadOrUpdateContact();

    boolean uploadPhoneContact();

    boolean uploadPhoneContactNotBind();
}
