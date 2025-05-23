package com.tencent.mobileqq.newfriend.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.handler.NewFriendVerificationHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendVerificationServiceImpl implements INewFriendVerificationService {
    static IPatchRedirector $redirector_ = null;
    private static final String ADD_FRIEND_BLOCKED_CONFIG_SP = "add_friend_blocked_cfg_sp";
    private static final String ADD_FRIEND_BLOCKED_SHOW_ENTRANCE = "add_friend_blocked_show_entrance";
    private static final String ADD_FRIEND_BLOCKED_SHOW_RED_POINT = "add_friend_blocked_show_red_point";
    private static final String ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER = "add_friend_blocked_show_red_point_at_new_friend_banner";
    public static final int ENTRANCE_TYPE_BLOCKED = 3;
    public static final int ENTRANCE_TYPE_NONE = 0;
    private static final int REQ_NUM = 500;
    public static final String TAG = "NEW_FRD.NewFriendVerificationServiceImpl";
    private static int mUiBuilderExposeCnt;
    public List<AddFriendBlockedInfo> addFriendBlockedInfoList;
    private com.tencent.mobileqq.profilecommon.observer.a commonObserver;
    private com.tencent.mobileqq.friend.observer.a friendObserver;
    public boolean isClearAddFriendBlockedListSuccess;
    public boolean isReportAddFriendBlockedSuccess;
    public boolean isShowAddFriendBlockedEntrance;
    public boolean isShowRedPoint;
    public boolean isShowRedPointAtNewFriendBanner;
    AppInterface mApp;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.profilecommon.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerificationServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.profilecommon.observer.a
        protected void b(boolean z16, int i3) {
            NewFriendVerificationServiceImpl newFriendVerificationServiceImpl;
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NewFriendVerificationServiceImpl.TAG, 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + i3);
            }
            if (NewFriendVerificationServiceImpl.this.checkIsSetAddFriendAnswer(i3) && (appInterface = (newFriendVerificationServiceImpl = NewFriendVerificationServiceImpl.this).mApp) != null) {
                newFriendVerificationServiceImpl.getAddFriendBlockedRedPoint(appInterface.getCurrentUin());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendVerificationServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onAddFriendSecCheck(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NewFriendVerificationServiceImpl.this.innerReportAddFriend(z17, bundle);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            mUiBuilderExposeCnt = 0;
        }
    }

    public NewFriendVerificationServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.addFriendBlockedInfoList = new ArrayList();
        this.commonObserver = new a();
        this.friendObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsSetAddFriendAnswer(int i3) {
        return i3 == 3 || i3 == 4;
    }

    public static NewFriendVerificationServiceImpl getService(AppRuntime appRuntime) {
        return (NewFriendVerificationServiceImpl) appRuntime.getRuntimeService(INewFriendVerificationService.class, "all");
    }

    public static int getUiBuilderExposeCnt() {
        return mUiBuilderExposeCnt;
    }

    private void initConfigFromSp(AppInterface appInterface, String str) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(appInterface.getCurrentUin() + ADD_FRIEND_BLOCKED_CONFIG_SP, 4);
        if (ADD_FRIEND_BLOCKED_SHOW_ENTRANCE.equals(str)) {
            this.isShowAddFriendBlockedEntrance = sharedPreferences.getBoolean(str, false);
        } else if (ADD_FRIEND_BLOCKED_SHOW_RED_POINT.equals(str)) {
            this.isShowRedPoint = sharedPreferences.getBoolean(str, false);
        } else if (ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER.equals(str)) {
            this.isShowRedPointAtNewFriendBanner = sharedPreferences.getBoolean(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerReportAddFriend(boolean z16, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "innerReportAddFriend() isSuccess:" + z16);
        }
        if (!z16 && checkIsSetAddFriendAnswer(bundle.getInt("friend_setting"))) {
            String string = bundle.getString("uin");
            int i3 = bundle.getInt("source_id");
            int i16 = bundle.getInt("sub_source_id");
            String string2 = bundle.getString("troop_uin");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "innerReportAddFriend  friendUin = " + string + " troopUin = " + string2);
            }
            NewFriendVerificationHandler handler = getHandler();
            if (handler == null) {
                return;
            }
            handler.K2(this.mApp.getCurrentUin(), string, i3, i16, string2);
        }
    }

    private boolean saveConfigToSp(String str, Object obj) {
        if (this.mApp == null) {
            QLog.e(TAG, 2, " saveConfigToSp(key[" + str + "],value[" + obj + "])-->  failed,mapp is null!!  ");
            return false;
        }
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getSharedPreferences(this.mApp.getCurrentUin() + ADD_FRIEND_BLOCKED_CONFIG_SP, 0).edit();
        if (ADD_FRIEND_BLOCKED_SHOW_ENTRANCE.equals(str) || ADD_FRIEND_BLOCKED_SHOW_RED_POINT.equals(str) || ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER.equals(str)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public static void setUiBuilderExposeCnt(int i3) {
        mUiBuilderExposeCnt = i3;
    }

    public void clearAddFriendBlockedList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " start-> clearAddFriendBlockedList() uin = " + str);
        }
        getHandler().D2(str);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public void clearRedPointAtNewFriendBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearRedPointAtNewFriendBanner()");
        }
        setShowRedPointAtNewFriendBanner(false);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public void getAddFriendBlockedList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (checkIsSetAddFriendAnswer()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "start -> getAddFriendBlockedList()");
            }
            if (this.addFriendBlockedInfoList == null) {
                this.addFriendBlockedInfoList = new ArrayList();
            }
            getHandler().F2(str, 500, "");
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public void getAddFriendBlockedRedPoint(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            if (checkIsSetAddFriendAnswer()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "start -> getAddFriendBlockedRedPoint() ");
                }
                getHandler().E2(str);
                return;
            }
            onGetAddFriendBlockedRedPoint(true, false, false, "", false);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public int getEntranceType() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (this.isShowAddFriendBlockedEntrance) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getEntranceType, type=" + i3 + ", entrance=" + this.isShowAddFriendBlockedEntrance);
        }
        return i3;
    }

    public NewFriendVerificationHandler getHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (NewFriendVerificationHandler) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return null;
        }
        return (NewFriendVerificationHandler) appInterface.getBusinessHandler(NewFriendVerificationHandler.class.getName());
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public boolean isShowRedPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isShowRedPoint, isShowRedPoint:" + this.isShowRedPoint);
        }
        return this.isShowRedPoint;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public boolean isShowRedPointAtNewFriendBanner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isShowRedPointAtNewFriendBanner, isShowRedPointAtNewFriendBanner:" + this.isShowRedPointAtNewFriendBanner);
        }
        return this.isShowRedPointAtNewFriendBanner;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public void leaveNewFriend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "leaveNewFriend()");
        }
        setShowRedPoint(false);
        if (getUiBuilderExposeCnt() > 0) {
            ReportController.n(null, "dc00898", "", "", "0X800A3A3", "0X800A3A3", 0, getUiBuilderExposeCnt(), 0, "", "", "", "");
        }
        setUiBuilderExposeCnt(0);
    }

    public void onClearAddFriendBlockedList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " onClearAddFriendBlockedList()-->  success=  " + z16);
        }
        List<AddFriendBlockedInfo> list = this.addFriendBlockedInfoList;
        if (list != null) {
            list.clear();
        }
        this.isClearAddFriendBlockedListSuccess = z16;
        getHandler().notifyUI(1, z16, null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mApp = appInterface;
        initConfigFromSp(appInterface, ADD_FRIEND_BLOCKED_SHOW_ENTRANCE);
        initConfigFromSp(this.mApp, ADD_FRIEND_BLOCKED_SHOW_RED_POINT);
        initConfigFromSp(this.mApp, ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER);
        this.mApp.addObserver(this.commonObserver);
        this.mApp.addObserver(this.friendObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        List<AddFriendBlockedInfo> list = this.addFriendBlockedInfoList;
        if (list != null) {
            list.clear();
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.removeObserver(this.commonObserver);
            this.commonObserver = null;
            this.mApp.removeObserver(this.friendObserver);
            this.friendObserver = null;
            this.mApp = null;
        }
    }

    public void onGetAddFriendBlockedList(boolean z16, List<AddFriendBlockedInfo> list, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), list, str);
            return;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" onGetAddFriendBlockedList()--> blockedInfos =  ");
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                QLog.d(TAG, 2, sb5.toString());
            }
            this.addFriendBlockedInfoList.clear();
            this.addFriendBlockedInfoList.addAll(list);
        }
        getHandler().notifyUI(4, z16, new Object[]{list, str});
    }

    public void onGetAddFriendBlockedRedPoint(boolean z16, boolean z17, boolean z18, String str, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Boolean.valueOf(z19));
            return;
        }
        setShowAddFriendBlockedEntrance(z17);
        setShowRedPoint(z18);
        setShowRedPointAtNewFriendBanner(z19);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " onGetAddFriendBlockedRedPoint() --> isShowAddFriendBlockedEntrance = " + z17 + " isShowRedPoint = " + z18 + " blockedUin = " + str + " isShowRedPointAtNewFriendBanner = " + z19);
        }
        NewFriendVerificationHandler handler = getHandler();
        if (handler == null) {
            return;
        }
        handler.notifyUI(3, z16, new Object[]{Boolean.valueOf(z17), Boolean.valueOf(z18), str, Boolean.valueOf(z19)});
    }

    public void onReportAddFriendBlocked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " onReportAddFriendBlocked()-->  success=  " + z16);
        }
        this.isReportAddFriendBlockedSuccess = z16;
        getHandler().notifyUI(2, z16, null);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
    public void reportAddFriendBlocked(String str, int i3, int i16, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start --> reportAddFriendBlocked() friendUin :" + str + " friendSetting=" + i3 + " troopUin = " + str2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("friend_setting", i3);
        bundle.putString("uin", str);
        bundle.putInt("source_id", i16);
        bundle.putInt("sub_source_id", i17);
        bundle.putString("troop_uin", str2);
        innerReportAddFriend(false, bundle);
    }

    public void setBlockInfoHasRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        List<AddFriendBlockedInfo> list = this.addFriendBlockedInfoList;
        if (list != null && list.size() != 0) {
            Iterator<AddFriendBlockedInfo> it = this.addFriendBlockedInfoList.iterator();
            while (it.hasNext()) {
                it.next().C = true;
            }
        }
    }

    public void setShowAddFriendBlockedEntrance(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isShowAddFriendBlockedEntrance = z16;
            saveConfigToSp(ADD_FRIEND_BLOCKED_SHOW_ENTRANCE, Boolean.valueOf(z16));
        }
    }

    public void setShowRedPoint(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.isShowRedPoint = z16;
            saveConfigToSp(ADD_FRIEND_BLOCKED_SHOW_RED_POINT, Boolean.valueOf(z16));
        }
    }

    public void setShowRedPointAtNewFriendBanner(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.isShowRedPointAtNewFriendBanner = z16;
            saveConfigToSp(ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER, Boolean.valueOf(z16));
        }
    }

    private boolean checkIsSetAddFriendAnswer() {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return false;
        }
        return checkIsSetAddFriendAnswer(MobileQQ.sMobileQQ.getSharedPreferences(appInterface.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101));
    }
}
