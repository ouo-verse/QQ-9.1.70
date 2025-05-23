package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.utils.eb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class as extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile as f195274d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.onlinestatus.av {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f195275d;

        /* renamed from: e, reason: collision with root package name */
        QQAppInterface f195276e;

        public a(int i3, QQAppInterface qQAppInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, as.this, Integer.valueOf(i3), qQAppInterface);
            } else {
                this.f195275d = i3;
                this.f195276e = qQAppInterface;
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i("FriendQIPCModule", 1, "onSetOnlineStatus: isSuccess " + z16);
            Bundle bundle2 = new Bundle();
            if (!z16) {
                i3 = -1;
            }
            bundle2.putInt("KEY_SUCCESS", i3);
            as.this.callbackResult(this.f195275d, EIPCResult.createSuccessResult(bundle2));
            this.f195276e.removeObserver(this);
        }
    }

    public as(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static as b() {
        if (f195274d == null) {
            synchronized (as.class) {
                if (f195274d == null) {
                    f195274d = new as("FriendQIPCModule");
                }
            }
        }
        return f195274d;
    }

    private EIPCResult c(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("KEY_UIN");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(string);
        Bundle bundle2 = new Bundle();
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "FriendQIPCModule");
        bundle2.putBoolean("KEY_IS_FRIEND", isFriend);
        if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, isFriend: %s", string, Boolean.valueOf(isFriend)));
        }
        return EIPCResult.createSuccessResult(bundle2);
    }

    private EIPCResult d(QQAppInterface qQAppInterface, Bundle bundle) {
        IStrangerService iStrangerService;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_BE_DELETE_SINGLE_WAY_FRIENDS");
        QLog.d("FriendQIPCModule", 1, "delete single way friends: " + stringArrayList);
        if (stringArrayList != null && !stringArrayList.isEmpty() && (iStrangerService = (IStrangerService) qQAppInterface.getRuntimeService(IStrangerService.class, "all")) != null) {
            iStrangerService.notifyUI(4, true, stringArrayList);
        }
        return EIPCResult.createSuccessResult(null);
    }

    private EIPCResult e(QQAppInterface qQAppInterface, Bundle bundle) {
        boolean z16;
        String str;
        IPhoneContactService iPhoneContactService;
        int selfBindState;
        PhoneContact queryPhoneContactByUin;
        String string = bundle.getString("KEY_UIN");
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Bundle bundle2 = new Bundle();
        if (friendsManager != null) {
            z16 = friendsManager.c0(string);
        } else {
            z16 = false;
        }
        if (z16 && (iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")) != null && (((selfBindState = iPhoneContactService.getSelfBindState()) == 9 || selfBindState == 8 || selfBindState == 4 || selfBindState == 2) && PermissionChecker.h().f() && (queryPhoneContactByUin = iPhoneContactService.queryPhoneContactByUin(string)) != null)) {
            str = queryPhoneContactByUin.unifiedCode;
        } else {
            str = null;
        }
        bundle2.putString("PHONE_NUMBER", str);
        if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("onCall uin: %s, phoneNumber: %s", string, str));
        }
        return EIPCResult.createSuccessResult(bundle2);
    }

    private EIPCResult f(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("KEY_UIN");
        SpecialCareInfo O = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).O(string);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("KEY_SCF_INFO", O);
        if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("getSCFInfo: %s", O));
        }
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
        String str = "special_care_voice_red_dot" + qQAppInterface.getCurrentAccountUin();
        Set a16 = eb.a(sharedPreferences, str, null);
        if (a16 == null) {
            a16 = new HashSet();
        }
        if (a16.add(string)) {
            bundle2.putBoolean("KEY_SCF_VOICE_NEW_FLAG", true);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            eb.c(edit, str, a16.toArray());
            edit.commit();
        } else {
            bundle2.putBoolean("KEY_SCF_VOICE_NEW_FLAG", false);
        }
        return EIPCResult.createSuccessResult(bundle2);
    }

    private EIPCResult g(QQAppInterface qQAppInterface, Bundle bundle) {
        String string = bundle.getString("KEY_UIN");
        long a16 = com.tencent.mobileqq.notification.util.a.a(string);
        String v3 = MessageNotificationSettingManager.l(qQAppInterface).v((int) a16, string, 0);
        Bundle bundle2 = new Bundle();
        bundle2.putString("KEY_SCF_RING_NAME", v3);
        if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("SCP getRingName, ringId: %s, ringName: %s", Long.valueOf(a16), v3));
        }
        return EIPCResult.createSuccessResult(bundle2);
    }

    private void h(QQAppInterface qQAppInterface, Bundle bundle, int i3) {
        int i16;
        long j3;
        if (bundle != null) {
            i16 = bundle.getInt("KEY_STATE");
        } else {
            i16 = -1;
        }
        QLog.i("FriendQIPCModule", 2, "set status is " + i16);
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) qQAppInterface.getRuntimeService(IOnlineStatusService.class, "");
        AppRuntime.Status status = AppRuntime.Status.online;
        if (i16 == -1) {
            j3 = 1080;
        } else {
            j3 = i16;
        }
        iOnlineStatusService.updateOnlineStatus(status, j3);
        qQAppInterface.addObserver(new a(i3, qQAppInterface));
    }

    private void i(QQAppInterface qQAppInterface, Bundle bundle) {
        SpecialCareInfo O;
        String string = bundle.getString("KEY_UIN");
        int i3 = bundle.getInt("KEY_SCF_SWITCH_TYPE");
        boolean z16 = bundle.getBoolean("KEY_SCF_SWITCH_STATUS");
        if (QLog.isColorLevel()) {
            QLog.d("FriendQIPCModule", 2, String.format("SCP set switch, switchType: %s, switchStatus", Integer.valueOf(i3), Boolean.valueOf(z16)));
        }
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (i3 == 1) {
            if (z16) {
                friendsManager.m(string);
                SpecialCareInfo specialCareInfo = new SpecialCareInfo();
                specialCareInfo.globalSwitch = 1;
                specialCareInfo.specialRingSwitch = 1;
                specialCareInfo.friendRingId = 1;
                specialCareInfo.qzoneSwitch = 1;
                specialCareInfo.uin = string;
                friendsManager.w0(specialCareInfo);
                com.tencent.mobileqq.activity.specialcare.e.t(string, "1", qQAppInterface);
                return;
            }
            friendsManager.m(string);
            return;
        }
        if (i3 == 2 && (O = friendsManager.O(string)) != null) {
            O.qzoneSwitch = z16 ? 1 : 0;
            friendsManager.w0(O);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if ("ACTION_IS_FRIEND".equals(str)) {
            return c(qQAppInterface, bundle);
        }
        if ("ACTION_GET_PHONE_NUMBER".equals(str)) {
            return e(qQAppInterface, bundle);
        }
        if ("ACTION_GET_SPECIAL_CARE_INFO".equals(str)) {
            return f(qQAppInterface, bundle);
        }
        if ("ACTION_GET_SCF_RING_NAME".equals(str)) {
            return g(qQAppInterface, bundle);
        }
        if ("ACTION_SET_SAVE_SWITCH".equals(str)) {
            i(qQAppInterface, bundle);
        } else {
            if ("ACTION_DELETE_SINGLE_WAY_FRIENDS".equals(str)) {
                return d(qQAppInterface, bundle);
            }
            if ("ACTION_SET_ONLINE_STATUS".equals(str)) {
                h(qQAppInterface, bundle, i3);
            }
        }
        return null;
    }
}
