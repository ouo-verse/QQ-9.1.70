package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelBuddyService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelBuddyService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native void native_SetSpecialCare(long j3, String str, SpecialCareSetting specialCareSetting, IOperateCallback iOperateCallback);

        private native void native_addCategory(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_addCategoryV2(long j3, String str, byte[] bArr, IModifyCategoryCallback iModifyCategoryCallback);

        private native long native_addKernelBuddyListener(long j3, IKernelBuddyListener iKernelBuddyListener);

        private native void native_approvalDoubtBuddyReq(long j3, String str, Long l3, String str2, IOperateCallback iOperateCallback);

        private native void native_approvalFriendRequest(long j3, ApprovalBuddyRequest approvalBuddyRequest, IOperateCallback iOperateCallback);

        private native HashMap<String, Boolean> native_areBuddies(long j3, String str, ArrayList<String> arrayList);

        private native void native_checkIsBuddyAsync(long j3, String str, ICheckIsBuddyCallback iCheckIsBuddyCallback);

        private native void native_clearAddFriendBlockedList(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_clearBuddyReqUnreadCnt(long j3, IOperateCallback iOperateCallback);

        private native void native_delAllDoubtBuddyReq(long j3, IOperateCallback iOperateCallback);

        private native void native_delBatchBuddy(long j3, ArrayList<DelBuddyInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_delBuddy(long j3, DelBuddyInfo delBuddyInfo, IOperateCallback iOperateCallback);

        private native void native_delBuddyReq(long j3, DelBuddyReqInfo delBuddyReqInfo, IOperateCallback iOperateCallback);

        private native void native_delCategory(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_delDoubtBuddyReq(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_getAddFriendBlockedList(long j3, String str, byte[] bArr, IGetAddFriendBlockedListCallback iGetAddFriendBlockedListCallback);

        private native void native_getAddFriendBlockedRedPoint(long j3, String str, byte[] bArr, IGetAddFriendBlockedRedPointCallback iGetAddFriendBlockedRedPointCallback);

        private native void native_getAddMeSetting(long j3, IOperateCallback iOperateCallback);

        private native int native_getAllBuddyCount(long j3);

        private native void native_getBuddyList(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native ArrayList<BuddyListCategory> native_getBuddyListFromCache(long j3, String str, BuddyListReqType buddyListReqType);

        private native void native_getBuddyListV2(long j3, String str, boolean z16, BuddyListReqType buddyListReqType, IBuddyListCallback iBuddyListCallback);

        private native HashMap<String, String> native_getBuddyNick(long j3, ArrayList<String> arrayList);

        private native void native_getBuddyRecommendContactArkJson(long j3, long j16, String str, IGetBuddyRecommendContactArkJsonCallback iGetBuddyRecommendContactArkJsonCallback);

        private native HashMap<String, String> native_getBuddyRemark(long j3, ArrayList<String> arrayList);

        private native void native_getBuddyReq(long j3, IOperateCallback iOperateCallback);

        private native void native_getBuddyReqUnreadCnt(long j3, IOperateCallback iOperateCallback);

        private native BuddyListCategory native_getCategoryById(long j3, int i3);

        private native String native_getCategoryNameWithUid(long j3, String str);

        private native void native_getDoubtBuddyReq(long j3, String str, int i3, String str2, IOperateCallback iOperateCallback);

        private native void native_getDoubtBuddyUnreadNum(long j3, IOperateCallback iOperateCallback);

        private native void native_getSmartInfos(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_getTargetBuddySetting(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_getTargetBuddySettingByType(long j3, long j16, String str, ReqBuddySettingType reqBuddySettingType, IOperateCallback iOperateCallback);

        private native boolean native_hasBuddyList(long j3);

        private native boolean native_isBlocked(long j3, String str);

        private native boolean native_isBuddy(long j3, String str);

        private native boolean native_isNewBuddylistVersion(long j3);

        private native void native_modifyAddMeSetting(long j3, int i3, HashMap<String, String> hashMap, IOperateCallback iOperateCallback);

        private native void native_pullCategory(long j3, IOperateCallback iOperateCallback);

        private native void native_removeKernelBuddyListener(long j3, long j16);

        private native void native_renameCategory(long j3, int i3, String str, IOperateCallback iOperateCallback);

        private native void native_reportAddFriendBlocked(long j3, String str, ReportBlockReq reportBlockReq, byte[] bArr, IReportBlockCallback iReportBlockCallback);

        private native void native_reportDoubtBuddyReqUnread(long j3, IOperateCallback iOperateCallback);

        private native void native_reqToAddFriends(long j3, ReqToFriend reqToFriend, IOperateCallback iOperateCallback);

        private native void native_resortCategory(long j3, ArrayList<BuddyCategorySortInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_setBatchBuddyCategory(long j3, ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

        private native void native_setBlock(long j3, String str, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setBuddyCategory(long j3, String str, int i3, IOperateCallback iOperateCallback);

        private native void native_setBuddyRemark(long j3, RemarkParams remarkParams, IOperateCallback iOperateCallback);

        private native void native_setMsgNotify(long j3, String str, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setSpacePermission(long j3, SetSpacePermissionReq setSpacePermissionReq, IOperateCallback iOperateCallback);

        private native void native_setTop(long j3, String str, boolean z16, IOperateCallback iOperateCallback);

        private native void native_setWXMsgNotify(long j3, String str, String str2, boolean z16, IOperateCallback iOperateCallback);

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void SetSpecialCare(String str, SpecialCareSetting specialCareSetting, IOperateCallback iOperateCallback) {
            native_SetSpecialCare(this.nativeRef, str, specialCareSetting, iOperateCallback);
        }

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void addCategory(String str, IOperateCallback iOperateCallback) {
            native_addCategory(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void addCategoryV2(String str, byte[] bArr, IModifyCategoryCallback iModifyCategoryCallback) {
            native_addCategoryV2(this.nativeRef, str, bArr, iModifyCategoryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public long addKernelBuddyListener(IKernelBuddyListener iKernelBuddyListener) {
            return native_addKernelBuddyListener(this.nativeRef, iKernelBuddyListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void approvalDoubtBuddyReq(String str, Long l3, String str2, IOperateCallback iOperateCallback) {
            native_approvalDoubtBuddyReq(this.nativeRef, str, l3, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void approvalFriendRequest(ApprovalBuddyRequest approvalBuddyRequest, IOperateCallback iOperateCallback) {
            native_approvalFriendRequest(this.nativeRef, approvalBuddyRequest, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public HashMap<String, Boolean> areBuddies(String str, ArrayList<String> arrayList) {
            return native_areBuddies(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void checkIsBuddyAsync(String str, ICheckIsBuddyCallback iCheckIsBuddyCallback) {
            native_checkIsBuddyAsync(this.nativeRef, str, iCheckIsBuddyCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void clearAddFriendBlockedList(String str, IOperateCallback iOperateCallback) {
            native_clearAddFriendBlockedList(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void clearBuddyReqUnreadCnt(IOperateCallback iOperateCallback) {
            native_clearBuddyReqUnreadCnt(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delAllDoubtBuddyReq(IOperateCallback iOperateCallback) {
            native_delAllDoubtBuddyReq(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delBatchBuddy(ArrayList<DelBuddyInfo> arrayList, IOperateCallback iOperateCallback) {
            native_delBatchBuddy(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delBuddy(DelBuddyInfo delBuddyInfo, IOperateCallback iOperateCallback) {
            native_delBuddy(this.nativeRef, delBuddyInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delBuddyReq(DelBuddyReqInfo delBuddyReqInfo, IOperateCallback iOperateCallback) {
            native_delBuddyReq(this.nativeRef, delBuddyReqInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delCategory(int i3, IOperateCallback iOperateCallback) {
            native_delCategory(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void delDoubtBuddyReq(String str, IOperateCallback iOperateCallback) {
            native_delDoubtBuddyReq(this.nativeRef, str, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getAddFriendBlockedList(String str, byte[] bArr, IGetAddFriendBlockedListCallback iGetAddFriendBlockedListCallback) {
            native_getAddFriendBlockedList(this.nativeRef, str, bArr, iGetAddFriendBlockedListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getAddFriendBlockedRedPoint(String str, byte[] bArr, IGetAddFriendBlockedRedPointCallback iGetAddFriendBlockedRedPointCallback) {
            native_getAddFriendBlockedRedPoint(this.nativeRef, str, bArr, iGetAddFriendBlockedRedPointCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getAddMeSetting(IOperateCallback iOperateCallback) {
            native_getAddMeSetting(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public int getAllBuddyCount() {
            return native_getAllBuddyCount(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getBuddyList(boolean z16, IOperateCallback iOperateCallback) {
            native_getBuddyList(this.nativeRef, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public ArrayList<BuddyListCategory> getBuddyListFromCache(String str, BuddyListReqType buddyListReqType) {
            return native_getBuddyListFromCache(this.nativeRef, str, buddyListReqType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getBuddyListV2(String str, boolean z16, BuddyListReqType buddyListReqType, IBuddyListCallback iBuddyListCallback) {
            native_getBuddyListV2(this.nativeRef, str, z16, buddyListReqType, iBuddyListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public HashMap<String, String> getBuddyNick(ArrayList<String> arrayList) {
            return native_getBuddyNick(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getBuddyRecommendContactArkJson(long j3, String str, IGetBuddyRecommendContactArkJsonCallback iGetBuddyRecommendContactArkJsonCallback) {
            native_getBuddyRecommendContactArkJson(this.nativeRef, j3, str, iGetBuddyRecommendContactArkJsonCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public HashMap<String, String> getBuddyRemark(ArrayList<String> arrayList) {
            return native_getBuddyRemark(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getBuddyReq(IOperateCallback iOperateCallback) {
            native_getBuddyReq(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getBuddyReqUnreadCnt(IOperateCallback iOperateCallback) {
            native_getBuddyReqUnreadCnt(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public BuddyListCategory getCategoryById(int i3) {
            return native_getCategoryById(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public String getCategoryNameWithUid(String str) {
            return native_getCategoryNameWithUid(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getDoubtBuddyReq(String str, int i3, String str2, IOperateCallback iOperateCallback) {
            native_getDoubtBuddyReq(this.nativeRef, str, i3, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getDoubtBuddyUnreadNum(IOperateCallback iOperateCallback) {
            native_getDoubtBuddyUnreadNum(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getSmartInfos(String str, IOperateCallback iOperateCallback) {
            native_getSmartInfos(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getTargetBuddySetting(String str, IOperateCallback iOperateCallback) {
            native_getTargetBuddySetting(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void getTargetBuddySettingByType(long j3, String str, ReqBuddySettingType reqBuddySettingType, IOperateCallback iOperateCallback) {
            native_getTargetBuddySettingByType(this.nativeRef, j3, str, reqBuddySettingType, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public boolean hasBuddyList() {
            return native_hasBuddyList(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public boolean isBlocked(String str) {
            return native_isBlocked(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public boolean isBuddy(String str) {
            return native_isBuddy(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public boolean isNewBuddylistVersion() {
            return native_isNewBuddylistVersion(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void modifyAddMeSetting(int i3, HashMap<String, String> hashMap, IOperateCallback iOperateCallback) {
            native_modifyAddMeSetting(this.nativeRef, i3, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void pullCategory(IOperateCallback iOperateCallback) {
            native_pullCategory(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void removeKernelBuddyListener(long j3) {
            native_removeKernelBuddyListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void renameCategory(int i3, String str, IOperateCallback iOperateCallback) {
            native_renameCategory(this.nativeRef, i3, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void reportAddFriendBlocked(String str, ReportBlockReq reportBlockReq, byte[] bArr, IReportBlockCallback iReportBlockCallback) {
            native_reportAddFriendBlocked(this.nativeRef, str, reportBlockReq, bArr, iReportBlockCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void reportDoubtBuddyReqUnread(IOperateCallback iOperateCallback) {
            native_reportDoubtBuddyReqUnread(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void reqToAddFriends(ReqToFriend reqToFriend, IOperateCallback iOperateCallback) {
            native_reqToAddFriends(this.nativeRef, reqToFriend, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void resortCategory(ArrayList<BuddyCategorySortInfo> arrayList, IOperateCallback iOperateCallback) {
            native_resortCategory(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setBatchBuddyCategory(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback) {
            native_setBatchBuddyCategory(this.nativeRef, arrayList, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setBlock(String str, boolean z16, IOperateCallback iOperateCallback) {
            native_setBlock(this.nativeRef, str, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setBuddyCategory(String str, int i3, IOperateCallback iOperateCallback) {
            native_setBuddyCategory(this.nativeRef, str, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setBuddyRemark(RemarkParams remarkParams, IOperateCallback iOperateCallback) {
            native_setBuddyRemark(this.nativeRef, remarkParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setMsgNotify(String str, boolean z16, IOperateCallback iOperateCallback) {
            native_setMsgNotify(this.nativeRef, str, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setSpacePermission(SetSpacePermissionReq setSpacePermissionReq, IOperateCallback iOperateCallback) {
            native_setSpacePermission(this.nativeRef, setSpacePermissionReq, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setTop(String str, boolean z16, IOperateCallback iOperateCallback) {
            native_setTop(this.nativeRef, str, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyService
        public void setWXMsgNotify(String str, String str2, boolean z16, IOperateCallback iOperateCallback) {
            native_setWXMsgNotify(this.nativeRef, str, str2, z16, iOperateCallback);
        }
    }

    void SetSpecialCare(String str, SpecialCareSetting specialCareSetting, IOperateCallback iOperateCallback);

    void addCategory(String str, IOperateCallback iOperateCallback);

    void addCategoryV2(String str, byte[] bArr, IModifyCategoryCallback iModifyCategoryCallback);

    long addKernelBuddyListener(IKernelBuddyListener iKernelBuddyListener);

    void approvalDoubtBuddyReq(String str, Long l3, String str2, IOperateCallback iOperateCallback);

    void approvalFriendRequest(ApprovalBuddyRequest approvalBuddyRequest, IOperateCallback iOperateCallback);

    HashMap<String, Boolean> areBuddies(String str, ArrayList<String> arrayList);

    void checkIsBuddyAsync(String str, ICheckIsBuddyCallback iCheckIsBuddyCallback);

    void clearAddFriendBlockedList(String str, IOperateCallback iOperateCallback);

    void clearBuddyReqUnreadCnt(IOperateCallback iOperateCallback);

    void delAllDoubtBuddyReq(IOperateCallback iOperateCallback);

    void delBatchBuddy(ArrayList<DelBuddyInfo> arrayList, IOperateCallback iOperateCallback);

    void delBuddy(DelBuddyInfo delBuddyInfo, IOperateCallback iOperateCallback);

    void delBuddyReq(DelBuddyReqInfo delBuddyReqInfo, IOperateCallback iOperateCallback);

    void delCategory(int i3, IOperateCallback iOperateCallback);

    void delDoubtBuddyReq(String str, IOperateCallback iOperateCallback);

    void getAddFriendBlockedList(String str, byte[] bArr, IGetAddFriendBlockedListCallback iGetAddFriendBlockedListCallback);

    void getAddFriendBlockedRedPoint(String str, byte[] bArr, IGetAddFriendBlockedRedPointCallback iGetAddFriendBlockedRedPointCallback);

    void getAddMeSetting(IOperateCallback iOperateCallback);

    int getAllBuddyCount();

    void getBuddyList(boolean z16, IOperateCallback iOperateCallback);

    ArrayList<BuddyListCategory> getBuddyListFromCache(String str, BuddyListReqType buddyListReqType);

    void getBuddyListV2(String str, boolean z16, BuddyListReqType buddyListReqType, IBuddyListCallback iBuddyListCallback);

    HashMap<String, String> getBuddyNick(ArrayList<String> arrayList);

    void getBuddyRecommendContactArkJson(long j3, String str, IGetBuddyRecommendContactArkJsonCallback iGetBuddyRecommendContactArkJsonCallback);

    HashMap<String, String> getBuddyRemark(ArrayList<String> arrayList);

    void getBuddyReq(IOperateCallback iOperateCallback);

    void getBuddyReqUnreadCnt(IOperateCallback iOperateCallback);

    BuddyListCategory getCategoryById(int i3);

    String getCategoryNameWithUid(String str);

    void getDoubtBuddyReq(String str, int i3, String str2, IOperateCallback iOperateCallback);

    void getDoubtBuddyUnreadNum(IOperateCallback iOperateCallback);

    void getSmartInfos(String str, IOperateCallback iOperateCallback);

    void getTargetBuddySetting(String str, IOperateCallback iOperateCallback);

    void getTargetBuddySettingByType(long j3, String str, ReqBuddySettingType reqBuddySettingType, IOperateCallback iOperateCallback);

    boolean hasBuddyList();

    boolean isBlocked(String str);

    boolean isBuddy(String str);

    boolean isNewBuddylistVersion();

    void modifyAddMeSetting(int i3, HashMap<String, String> hashMap, IOperateCallback iOperateCallback);

    void pullCategory(IOperateCallback iOperateCallback);

    void removeKernelBuddyListener(long j3);

    void renameCategory(int i3, String str, IOperateCallback iOperateCallback);

    void reportAddFriendBlocked(String str, ReportBlockReq reportBlockReq, byte[] bArr, IReportBlockCallback iReportBlockCallback);

    void reportDoubtBuddyReqUnread(IOperateCallback iOperateCallback);

    void reqToAddFriends(ReqToFriend reqToFriend, IOperateCallback iOperateCallback);

    void resortCategory(ArrayList<BuddyCategorySortInfo> arrayList, IOperateCallback iOperateCallback);

    void setBatchBuddyCategory(ArrayList<String> arrayList, int i3, IOperateCallback iOperateCallback);

    void setBlock(String str, boolean z16, IOperateCallback iOperateCallback);

    void setBuddyCategory(String str, int i3, IOperateCallback iOperateCallback);

    void setBuddyRemark(RemarkParams remarkParams, IOperateCallback iOperateCallback);

    void setMsgNotify(String str, boolean z16, IOperateCallback iOperateCallback);

    void setSpacePermission(SetSpacePermissionReq setSpacePermissionReq, IOperateCallback iOperateCallback);

    void setTop(String str, boolean z16, IOperateCallback iOperateCallback);

    void setWXMsgNotify(String str, String str2, boolean z16, IOperateCallback iOperateCallback);
}
