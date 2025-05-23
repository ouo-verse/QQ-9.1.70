package com.tencent.mobileqq.relation.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.qcircle.widget.QFSFollowView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.al;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.b;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.relation.fragment.AddRequestNewMsgFragment;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.settings.fragment.permissionprivacy.PermissionPrivacyFragmentKotlin;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.systemmsg.a;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactRemoteConfig;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.webview.api.IAddContactSecCheckWebApi;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.widget.d;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;
import mqq.app.MainService;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AddFriendTempApiImpl implements IAddFriendTempApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AddFriendTempApiImpl";

    public AddFriendTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void openAddContactsPageInPad(Context context, Bundle bundle, LaunchMode launchMode) {
        i.e(context, bundle, AddContactFragmentV2.class, new b().e(false).g(true).h(launchMode).c(R.anim.f154476ii, R.anim.f154480ae, R.anim.f154476ii, R.anim.f154480ae).a());
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void addBatchQIMFriends(List<QIMNotifyAddFriend> list, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, (Object) list, (Object) appInterface);
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addBatchQIMFriends(list);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void addFriendToFriendList(AppInterface appInterface, String str, int i3, int i16, String str2, boolean z16, boolean z17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(str, 0, BuddySource.DEFAULT, "", true, false, -1L);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void addListener(Object obj, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, obj, (Object) appInterface);
        } else {
            ((StatusManager) appInterface.getManager(QQManagerFactory.STATUS_MANAGER)).C(obj);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void cancelMayKnowRecommend(String str, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str, (Object) appInterface);
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(str);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void changeStructMsgActions(structmsg$StructMsg structmsg_structmsg, int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, structmsg_structmsg, Integer.valueOf(i3), str, Integer.valueOf(i16));
        } else {
            a.d(structmsg_structmsg, i3, str, i16);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean changeStructMsgActionsWhenFail(structmsg$StructMsg structmsg_structmsg, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, this, structmsg_structmsg, Integer.valueOf(i3), str, str2)).booleanValue();
        }
        return a.e(structmsg_structmsg, i3, str, str2);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void checkReadContactPermission(Runnable runnable, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) runnable, (Object) appInterface);
            return;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            PermissionChecker.e(qBaseActivity, runnable, new DenyRunnable(qBaseActivity, new DenyRunnable.a((QQAppInterface) appInterface)));
        } else {
            QLog.e(TAG, 1, "checkReadContactPermission is error! activity is invalid!");
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void checkUpdate(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) appInterface, (Object) str);
        } else {
            AntiFraudConfigFileUtil.n().f((QQAppInterface) appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void clearAllSystemMsg(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) appInterface);
        } else if (appInterface instanceof QQAppInterface) {
            ((QQAppInterface) appInterface).getMsgHandler().m3().O();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void clickQIMSource(Context context, MessageRecord messageRecord, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, context, messageRecord, appInterface);
        } else {
            ((FlashChatManager) appInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).d(context, null);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Intent composeReturnIntent(Class<?> cls, String str, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Intent) iPatchRedirector.redirect((short) 9, this, cls, str, activity);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MainService.QQPROCESSNAME, cls.getName()));
        if (cls.equals(((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass()) || cls.equals(QidianProfileCardActivity.class)) {
            ProfileActivity.F2(activity, str, intent);
        }
        intent.setFlags(67108864);
        intent.putExtra("key_back_from_add_friend", true);
        return intent;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void deleteAllSuspiciousMsg(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) appInterface);
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteAllSuspiciousMsg();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void deleteQIMNotifyAddFriendData(QIMNotifyAddFriend qIMNotifyAddFriend, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) qIMNotifyAddFriend, (Object) appInterface);
        } else {
            ((QIMNewFriendManager) appInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).b(qIMNotifyAddFriend);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean enableCheckPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return al.d(BaseApplicationImpl.getApplication()).a();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void followUser(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        } else {
            QFSFollowView.d(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Intent getAddRequestIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Intent) iPatchRedirector.redirect((short) 35, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) AddRequestActivity.class);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Intent getBindNumberIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (Intent) iPatchRedirector.redirect((short) 57, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) BindNumberActivity.class);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Intent getChatActivityIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (Intent) iPatchRedirector.redirect((short) 59, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) ChatActivity.class);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void getDiscussInfo(long j3, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), appInterface);
            return;
        }
        DiscussionHandler discussionHandler = (DiscussionHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        if (discussionHandler != null) {
            discussionHandler.S2(j3);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public String getDiscussionNameCanNull(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) appInterface, (Object) str);
        }
        if (appInterface instanceof QQAppInterface) {
            return ac.q((QQAppInterface) appInterface, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public int getForwardSelectionRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }
        return 20000;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Intent getFriendProfileMoreInfoIntent(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (Intent) iPatchRedirector.redirect((short) 58, (Object) this, (Object) context);
        }
        return new Intent(context, (Class<?>) FriendProfileMoreInfoActivity.class);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public int getMayKnowLoadConnectionBizTypeFirstLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Integer) iPatchRedirector.redirect((short) 68, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean getMayKnowRecommendRemoteFromNewFrd(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) appInterface)).booleanValue();
        }
        MayknowRecommendManager mayknowRecommendManager = (MayknowRecommendManager) appInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (mayknowRecommendManager != null) {
            return mayknowRecommendManager.g(4);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public String getQIMNewFriendSource(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this, (Object) appInterface);
        }
        return ((FlashChatManager) appInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).n();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public ArrayList<r> getQIMNotifyAddFriendsMsg(boolean z16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ArrayList) iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(z16), appInterface);
        }
        return ((QIMNewFriendManager) appInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).c(z16);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public String getQQInfoFromQQUin(long j3, long j16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), Long.valueOf(j16), appInterface);
        }
        return ((QIMNewFriendManager) appInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).e(j3, j16);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public HashMap<String, String> getQidianExternal(HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (HashMap) iPatchRedirector.redirect((short) 17, (Object) this, (Object) hashMap);
        }
        if (hasQidianExternal(hashMap)) {
            QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) hashMap.get("external");
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("qidian_uin", qidianExternalInfo.uin);
            hashMap2.put("qidian_nickname", qidianExternalInfo.nickname);
            return hashMap2;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public String getRecommendLabelString(List<MayKnowRecommend.MayKnowRecommendLabel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this, (Object) list);
        }
        return ContactReportUtils.b(list);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public int getRequestForSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }
        return 9999;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public int getSizeSmall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return 200;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void getSuspiciousFriendsUnreadNum(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface);
        } else {
            ((FriendListHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSuspiciousFriendsUnreadNum();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public int getTypeSetConnectionsSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return 108;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public Object getValue(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return iPatchRedirector.redirect((short) 14, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return AntiFraudConfigFileUtil.n().p(str, str2, i3, i16);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void gotoFriendSettingBrowser(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
        } else {
            PermissionPrivacyFragmentKotlin.INSTANCE.b(context);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean hasQidianExternal(HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) hashMap)).booleanValue();
        }
        if (hashMap != null && hashMap.containsKey("external") && hashMap.get("external") != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean hasQimSource(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((FlashChatManager) appInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).s();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void insertCommonHobbyIfNeeded(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) appInterface, (Object) str);
        } else {
            ChatActivityFacade.j0((QQAppInterface) appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean isNewFrdMiniCardSwitchOn(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((IceBreakingMng) appInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).J();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean isQidianMaster(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return QidianManager.P((QQAppInterface) appInterface, str);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean isStudyMode(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, (Object) appInterface)).booleanValue();
        }
        return StudyModeManager.t();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean isSuspiciousSwitchOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return SysSuspiciousConfProcessor.a().a();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void jumpToMoveGroup(Activity activity, Fragment fragment, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, fragment, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Intent putExtra = new Intent(activity, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", str).putExtra("mgid", (byte) i3);
        putExtra.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
        fragment.startActivityForResult(putExtra, i16);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            PublicFragmentActivity.start(context, NewFriendMoreSysMsgSuspiciousFragment.class);
        } else {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void jumpToQidianProfile(String str, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) activity);
            return;
        }
        AllInOne allInOne = new AllInOne(str, 1);
        Intent intent = new Intent(activity, (Class<?>) QidianProfileCardActivity.class);
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        intent.addFlags(536870912);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void jumpToSplash(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent.setFlags(67108864);
        activity.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void launchPluginBroadcastWhenToggleSwitch(String str, AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, appInterface, Boolean.valueOf(z16));
            return;
        }
        Intent intent = new Intent("com.tencent.qzone.action.OperateQZonePermission");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setClassName(BaseApplication.getContext().getPackageName(), QZoneHelper.BROADCAST_RECEIVER_PERMISSION);
        intent.putExtra("qzone_permission_uin", str);
        intent.putExtra("qzone_permission_operateType", 1);
        intent.putExtra("qzone_permission_value", z16);
        appInterface.getApp().sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void markQIMNotifyAddFriendsRead(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) appInterface);
        } else {
            ((QIMNewFriendManager) appInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).f();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void openSecCheckWebForFragment(AppInterface appInterface, Context context, QBaseFragment qBaseFragment, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appInterface, context, qBaseFragment, Integer.valueOf(i3), str, str2);
        } else {
            ((IAddContactSecCheckWebApi) QRoute.api(IAddContactSecCheckWebApi.class)).openSecCheckWebForFragment(appInterface, context, qBaseFragment, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void removeListener(Object obj, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, obj, (Object) appInterface);
        } else {
            ((StatusManager) appInterface.getManager(QQManagerFactory.STATUS_MANAGER)).b0(obj);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void reportExtendFriend(int i3, String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, intent);
            return;
        }
        if (i3 == 3094) {
            String valueOf = String.valueOf(intent.getIntExtra("sub_source_id", 8));
            HashMap hashMap = new HashMap();
            hashMap.put("frompage", valueOf);
            hashMap.put("to_uid", str);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#send_request_all", true, -1L, -1L, hashMap, true, true);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void reportRecommend(AppInterface appInterface, String str, String str2, int i3, int i16, String str3, int i17, byte[] bArr, String str4, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, appInterface, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, Integer.valueOf(i17), bArr, str4, Integer.valueOf(i18));
        } else {
            ContactReportUtils.e((QQAppInterface) appInterface, str, str2, i3, i16, str3, i17, bArr, str4, i18, "3");
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void reportRecommendExpose(AppInterface appInterface, int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Integer> arrayList3, ArrayList<byte[]> arrayList4, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, appInterface, Integer.valueOf(i3), arrayList, arrayList2, arrayList3, arrayList4, Integer.valueOf(i16));
        } else {
            ContactReportUtils.f((QQAppInterface) appInterface, i3, arrayList, arrayList2, arrayList3, arrayList4, i16, "3");
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendAddFriendNoticeForBaby(AppInterface appInterface, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appInterface, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendDelSingleSystemMsg(structmsg$StructMsg structmsg_structmsg, String str, int i3, long j3, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, structmsg_structmsg, str, Integer.valueOf(i3), Long.valueOf(j3), appInterface);
        } else {
            ((QQAppInterface) appInterface).getMsgHandler().m3().q0(structmsg_structmsg, str, i3, j3);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendFriendSystemMsgAction(int i3, long j3, long j16, int i16, int i17, int i18, int i19, structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo, int i26, structmsg$StructMsg structmsg_structmsg, boolean z16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), structmsg_systemmsgactioninfo, Integer.valueOf(i26), structmsg_structmsg, Boolean.valueOf(z16), appInterface);
        } else {
            ((QQAppInterface) appInterface).getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, i26, structmsg_structmsg, z16);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendFriendSystemMsgReadedReport(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) appInterface);
        } else {
            ((QQAppInterface) appInterface).getMsgHandler().m3().s0();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendGetNextFriendSystemMsg(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) appInterface);
        } else {
            ((QQAppInterface) appInterface).getMsgHandler().m3().u0();
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void sendPokeMsg(AppInterface appInterface, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, appInterface, context, str);
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        String valueOf = String.valueOf(str);
        sessionInfo.f179557e = valueOf;
        sessionInfo.f179559f = valueOf;
        ChatActivityFacade.N0((QQAppInterface) appInterface, context, sessionInfo);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public boolean shouldShowMayKnowInNewFriend(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((MayknowRecommendManager) appInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).s();
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startAddContactsPage(Context context, int i3, int i16, LaunchMode launchMode, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, this, context, Integer.valueOf(i3), Integer.valueOf(i16), launchMode, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("entrance_data_report", i3);
        bundle2.putInt("EntranceId", i16);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (!((IAddContactRemoteConfig) QRoute.api(IAddContactRemoteConfig.class)).showNewPage()) {
            Intent intent = new Intent(context, (Class<?>) AddContactsActivity.class);
            boolean booleanValue = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("101775", Boolean.FALSE).booleanValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "setClassLoader :" + booleanValue);
            }
            if (booleanValue) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
            }
            intent.putExtras(bundle2);
            if (launchMode == LaunchMode.singleTop) {
                intent.setFlags(67108864);
            }
            context.startActivity(intent);
            return;
        }
        bundle2.putLong("launcher_time", System.currentTimeMillis());
        if (AppSetting.t(context)) {
            openAddContactsPageInPad(context, bundle2, launchMode);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtras(bundle2);
        QPublicFragmentActivity.start(context, intent2, AddContactFragmentV2.class);
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startAddContactsPageForResult(Activity activity, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, this, activity, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("entrance_data_report", i3);
        bundle.putInt("EntranceId", i16);
        if (!((IAddContactRemoteConfig) QRoute.api(IAddContactRemoteConfig.class)).showNewPage()) {
            Intent intent = new Intent(activity, (Class<?>) AddContactsActivity.class);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i17);
        } else {
            bundle.putLong("launcher_time", System.currentTimeMillis());
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            QPublicFragmentActivity.startForResult(activity, intent2, (Class<? extends QPublicBaseFragment>) AddContactFragmentV2.class, i17);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startAddRequestPage(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) context, (Object) intent);
        } else if (context != null && intent != null) {
            QPublicFragmentActivity.start(context, intent, AddRequestNewMsgFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startAddRequestPageForResult(Activity activity, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, activity, intent, Integer.valueOf(i3));
        } else if (activity != null && intent != null) {
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) AddRequestNewMsgFragment.class, i3);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startAddRequestSuspiciousPage(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) context, (Object) intent);
        } else if (context != null && intent != null) {
            QPublicFragmentActivity.start(context, intent, AddRequestNewMsgFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startContactBindFromOther(AppInterface appInterface, int i3, ArrayList<PhoneContact> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 50)) {
            ContactBindedActivity.V2((QQAppInterface) appInterface, i3, arrayList);
        } else {
            iPatchRedirector.redirect((short) 50, this, appInterface, Integer.valueOf(i3), arrayList);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startRemarkAfterAgree(Activity activity, int i3, String str, long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, activity, Integer.valueOf(i3), str, Long.valueOf(j3), bundle);
        } else {
            AutoRemarkActivity.startRemarkAfterAgree(activity, i3, str, j3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void updateCustomNoteTxt(TextView textView, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, textView, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            d.b(textView, 3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            PublicFragmentActivity.startForResult((Activity) context, intent, NewFriendMoreSysMsgSuspiciousFragment.class, i3);
        } else {
            iPatchRedirector.redirect((short) 32, this, context, intent, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.relation.api.IAddFriendTempApi
    public void startContactBindFromOther(AppInterface appInterface, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            ContactBindedActivity.U2((QQAppInterface) appInterface, i3, i16, intent);
        } else {
            iPatchRedirector.redirect((short) 51, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }
}
