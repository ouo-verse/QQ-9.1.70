package com.tencent.mobileqq.friend.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListCategory;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FriendHandlerServiceImpl implements IFriendHandlerService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IMCore.friend.FriendHandlerServiceImp";
    private FriendHandler mHandler;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements IBuddyListCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendHandlerServiceImpl.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback
        public void onResult(int i3, String str, ArrayList<BuddyListCategory> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(FriendHandlerServiceImpl.TAG, 1, "requestFriendListFromNT result:" + i3 + " errMsg:" + str);
            }
        }
    }

    public FriendHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void requestAddFriendReal(String str, String str2, int i3, byte b16, String str3, int i16, int i17, byte[] bArr, boolean z16, byte[] bArr2, boolean z17, String str4, String str5, byte b17, String str6, Bundle bundle, boolean z18, byte[] bArr3) {
        this.mHandler.Q2(str, str2, i3, b16, str3, i16, i17, bArr, z16, bArr2, z17, str4, str5, b17, str6, bundle, z18, bArr3);
    }

    private void requestFriendListFromNT(boolean z16) {
        if (!z16) {
            QLog.e(TAG, 1, "requestFriendListFromNT isPullRefresh is false");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "requestFriendListFromNT app == null");
            return;
        }
        m buddyService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getBuddyService();
        if (buddyService == null) {
            QLog.e(TAG, 1, "requestFriendListFromNT buddyService == null");
        } else {
            buddyService.getBuddyListV2("requestFriendListFromNT", true, com.tencent.qqnt.ntrelation.constant.a.f359917a.a(RelationListReqType.NORMAL), new a());
            f.f().startStatusPolling(true);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void addFriendGroup(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Byte.valueOf(b16), str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "addFriendGroup| name is empty");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addFriendGroup| sortId: " + ((int) b16) + ", name: " + str);
        }
        GroupRequestData groupRequestData = new GroupRequestData();
        groupRequestData.setReqType(0);
        groupRequestData.setSortId(b16);
        groupRequestData.setName(str);
        this.mHandler.S2(groupRequestData);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void cacheToken(String str, int i3, int i16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cacheToken uin: " + str + " token: " + bArr.toString());
        }
        FriendHandler friendHandler = this.mHandler;
        if (friendHandler != null && friendHandler.E2() != null) {
            this.mHandler.E2().a(str, i3, i16, bArr);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void deleteFriendGroup(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Byte.valueOf(b16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteFriendGroup| groupId: " + ((int) b16));
        }
        GroupRequestData groupRequestData = new GroupRequestData();
        groupRequestData.setReqType(2);
        groupRequestData.setGroupId(b16);
        this.mHandler.S2(groupRequestData);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void getOnlyChatPermissionBatchByPage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mHandler.J2(i3);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void getPermissionSelectFriend(List<String> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mHandler.K2(list, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void getSingleFriendPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.mHandler.K2(arrayList, 0, 1);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public boolean isRequestingFriendList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mHandler.M2();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mHandler = (FriendHandler) ((AppInterface) appRuntime).getBusinessHandler(FriendHandler.class.getName());
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void renameFriendGroup(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Byte.valueOf(b16), str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "renameFriendGroup| name is empty");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "renameFriendGroup| groupId: " + ((int) b16) + ", name: " + str);
        }
        GroupRequestData groupRequestData = new GroupRequestData();
        groupRequestData.setReqType(1);
        groupRequestData.setGroupId(b16);
        groupRequestData.setName(str);
        this.mHandler.S2(groupRequestData);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAddBatchPhoneFriend(ArrayList<PhoneContact> arrayList, String str, int i3, int i16, ArrayList<AddBatchPhoneFriendResult> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, arrayList, str, Integer.valueOf(i3), Integer.valueOf(i16), arrayList2);
        } else {
            this.mHandler.P2(arrayList, str, i3, i16, arrayList2);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAddFriend(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            requestAddFriendReal(str, str2, i3, b16, str3, i16, i17, null, z16, bArr, z17, str4, str5, (byte) 0, "", null, false, null);
        } else {
            iPatchRedirector.redirect((short) 13, this, str, str2, Integer.valueOf(i3), Byte.valueOf(b16), str3, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), bArr, Boolean.valueOf(z17), str4, str5);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAddFriendWithMyCard(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5, byte b17, String str6, Bundle bundle, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            requestAddFriendReal(str, str2, i3, b16, str3, i16, i17, null, z16, bArr, z17, str4, str5, b17, str6, bundle, z18, null);
        } else {
            iPatchRedirector.redirect((short) 15, this, str, str2, Integer.valueOf(i3), Byte.valueOf(b16), str3, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), bArr, Boolean.valueOf(z17), str4, str5, Byte.valueOf(b17), str6, bundle, Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAutoInfo(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mHandler.R2(str, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestFriendInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "requestFriendInfo, friendUin: " + str);
            }
            FriendListRequestData friendListRequestData = new FriendListRequestData();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            friendListRequestData.setRequestSingle(true);
            friendListRequestData.setUinList(arrayList);
            this.mHandler.T2(friendListRequestData, false);
            return;
        }
        QLog.e(TAG, 1, "requestFriendInfo, friendUin is empty");
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestFriendList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            requestFriendList(z16, 0);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestInfoWithOpenId(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mHandler.U2(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestUinSafetyFlag(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.mHandler.W2(j3);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestUserAddFriendSetting(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            this.mHandler.X2(str, i3, i16, str2);
        } else {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void resortFriendGroup(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr, (Object) bArr2);
            return;
        }
        if (bArr != null && bArr2 != null && bArr.length == bArr2.length) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resortFriendGroup");
            }
            GroupRequestData groupRequestData = new GroupRequestData();
            groupRequestData.setReqType(3);
            groupRequestData.setGroupIdList(bArr);
            groupRequestData.setSortIdList(bArr2);
            this.mHandler.S2(groupRequestData);
            return;
        }
        QLog.e(TAG, 1, "resortFriendGroup| params error");
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void setBatchFriendPermission(List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) list, i3);
        } else {
            this.mHandler.Z2(list, i3);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void setFriendPermission(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.mHandler.Z2(arrayList, i3);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAddFriend(String str, String str2, int i3, byte b16, String str3, int i16, int i17, boolean z16, byte[] bArr, boolean z17, String str4, String str5, Bundle bundle, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            requestAddFriendReal(str, str2, i3, b16, str3, i16, i17, null, z16, bArr, z17, str4, str5, (byte) 0, "", bundle, z18, null);
        } else {
            iPatchRedirector.redirect((short) 14, this, str, str2, Integer.valueOf(i3), Byte.valueOf(b16), str3, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), bArr, Boolean.valueOf(z17), str4, str5, bundle, Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestAddFriendWithMyCard(String str, String str2, int i3, byte b16, String str3, int i16, int i17, byte[] bArr, boolean z16, byte[] bArr2, boolean z17, String str4, String str5, byte b17, String str6, Bundle bundle, boolean z18, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            requestAddFriendReal(str, str2, i3, b16, str3, i16, i17, bArr, z16, bArr2, z17, str4, str5, b17, str6, bundle, z18, bArr3);
        } else {
            iPatchRedirector.redirect((short) 16, this, str, str2, Integer.valueOf(i3), Byte.valueOf(b16), str3, Integer.valueOf(i16), Integer.valueOf(i17), bArr, Boolean.valueOf(z16), bArr2, Boolean.valueOf(z17), str4, str5, Byte.valueOf(b17), str6, bundle, Boolean.valueOf(z18), bArr3);
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestFriendList(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "requestFriendList| isPullRefresh: " + z16);
        }
        FriendListRequestData friendListRequestData = new FriendListRequestData();
        friendListRequestData.setFriendStartIndex(0);
        friendListRequestData.setFriendCount(20);
        friendListRequestData.setGroupStartIndex(0);
        friendListRequestData.setGroupCount(100);
        friendListRequestData.setShowTermType(1);
        friendListRequestData.setPullRefresh(z16);
        friendListRequestData.setNtFriendListSeq(i3);
        this.mHandler.T2(friendListRequestData, true);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendHandlerService
    public void requestUserAddFriendSetting(String str, int i3, int i16, String str2, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            this.mHandler.Y2(str, i3, i16, str2, i17);
        } else {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17));
        }
    }
}
