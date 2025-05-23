package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelProfileService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelProfileService {
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

        private native long native_addKernelProfileListener(long j3, IKernelProfileListener iKernelProfileListener);

        private native long native_addKernelProfileListenerForUICache(long j3, IKernelProfileListener iKernelProfileListener);

        private native void native_asyncGetCoreInfo(long j3, String str, ArrayList<String> arrayList, IAsyncCoreInfoInfoCallback iAsyncCoreInfoInfoCallback);

        private native ArrayList<String> native_enumAreaOptions(long j3, String str, String str2, String str3);

        private native ArrayList<String> native_enumCityOptions(long j3, String str, String str2);

        private native ArrayList<String> native_enumCountryOptions(long j3);

        private native ArrayList<String> native_enumProvinceOptions(long j3, String str);

        private native void native_fetchUserDetailInfo(long j3, String str, ArrayList<String> arrayList, Source source, ArrayList<ProfileBizType> arrayList2, IDetailInfoCallback iDetailInfoCallback);

        private native void native_getAiAvatarCategoryInfos(long j3, GetAiAvatarCategoryInfosReq getAiAvatarCategoryInfosReq, boolean z16, IGetAiAvatarCategoryInfosCallback iGetAiAvatarCategoryInfosCallback);

        private native HashMap<String, UserSimpleInfo> native_getCoreAndBaseInfo(long j3, String str, ArrayList<String> arrayList);

        private native HashMap<String, CoreInfo> native_getCoreInfo(long j3, String str, ArrayList<String> arrayList);

        private native HashMap<String, Intimate> native_getIntimate(long j3, String str, ArrayList<String> arrayList);

        private native void native_getLocalStrangerRemark(long j3);

        private native HashMap<String, OtherFlag> native_getOtherFlag(long j3, String str, ArrayList<String> arrayList);

        private native void native_getProfileQzonePicInfo(long j3, String str, int i3, boolean z16, IGetProfileQzonePicInfoCallback iGetProfileQzonePicInfoCallback);

        private native HashMap<String, RelationFlag> native_getRelationFlag(long j3, String str, ArrayList<String> arrayList);

        private native void native_getSelfStatus(long j3, IOperateCallback iOperateCallback);

        private native void native_getStatus(long j3, String str, boolean z16, IOperateCallback iOperateCallback);

        private native HashMap<String, StatusInfo> native_getStatusInfo(long j3, String str, ArrayList<String> arrayList);

        private native HashMap<String, StockLocalData> native_getStockLocalData(long j3, String str, ArrayList<String> arrayList);

        private native HashMap<Long, String> native_getUidByUin(long j3, String str, ArrayList<Long> arrayList);

        private native HashMap<String, Long> native_getUinByUid(long j3, String str, ArrayList<String> arrayList);

        private native void native_getUserDetailInfo(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_getUserDetailInfoByUin(long j3, long j16, IDetailInfoByUinCallback iDetailInfoByUinCallback);

        private native void native_getUserDetailInfoWithBizInfo(long j3, String str, ArrayList<BizKey> arrayList, IOperateCallback iOperateCallback);

        private native void native_getUserSimpleInfo(long j3, boolean z16, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

        private native HashMap<String, VasInfo> native_getVasInfo(long j3, String str, ArrayList<String> arrayList);

        private native void native_getZplanAvatarInfos(long j3, ArrayList<String> arrayList, IZplanAvatarInfoCallback iZplanAvatarInfoCallback);

        private native void native_modifyDesktopMiniProfile(long j3, DesktopQQMiniProfile desktopQQMiniProfile, IOperateCallback iOperateCallback);

        private native void native_modifySelfProfile(long j3, UserSimpleInfo userSimpleInfo, IOperateCallback iOperateCallback);

        private native void native_prepareRegionConfig(long j3, IOperateCallback iOperateCallback);

        private native void native_removeKernelProfileListener(long j3, long j16);

        private native void native_setAiAvatarActionStatus(long j3, ArrayList<AiAvatarActionStatus> arrayList, IOperateCallback iOperateCallback);

        private native void native_setBirthday(long j3, int i3, int i16, int i17, IOperateCallback iOperateCallback);

        private native void native_setGander(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_setHeader(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_setLongNick(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_setNickName(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_setRecommendImgFlag(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_setdisableEmojiShortCuts(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_startStatusPolling(long j3, boolean z16);

        private native void native_updateProfileData(long j3, String str, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_updateStockLocalData(long j3, String str, HashMap<String, StockLocalData> hashMap, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public long addKernelProfileListener(IKernelProfileListener iKernelProfileListener) {
            return native_addKernelProfileListener(this.nativeRef, iKernelProfileListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public long addKernelProfileListenerForUICache(IKernelProfileListener iKernelProfileListener) {
            return native_addKernelProfileListenerForUICache(this.nativeRef, iKernelProfileListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void asyncGetCoreInfo(String str, ArrayList<String> arrayList, IAsyncCoreInfoInfoCallback iAsyncCoreInfoInfoCallback) {
            native_asyncGetCoreInfo(this.nativeRef, str, arrayList, iAsyncCoreInfoInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public ArrayList<String> enumAreaOptions(String str, String str2, String str3) {
            return native_enumAreaOptions(this.nativeRef, str, str2, str3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public ArrayList<String> enumCityOptions(String str, String str2) {
            return native_enumCityOptions(this.nativeRef, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public ArrayList<String> enumCountryOptions() {
            return native_enumCountryOptions(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public ArrayList<String> enumProvinceOptions(String str) {
            return native_enumProvinceOptions(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void fetchUserDetailInfo(String str, ArrayList<String> arrayList, Source source, ArrayList<ProfileBizType> arrayList2, IDetailInfoCallback iDetailInfoCallback) {
            native_fetchUserDetailInfo(this.nativeRef, str, arrayList, source, arrayList2, iDetailInfoCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getAiAvatarCategoryInfos(GetAiAvatarCategoryInfosReq getAiAvatarCategoryInfosReq, boolean z16, IGetAiAvatarCategoryInfosCallback iGetAiAvatarCategoryInfosCallback) {
            native_getAiAvatarCategoryInfos(this.nativeRef, getAiAvatarCategoryInfosReq, z16, iGetAiAvatarCategoryInfosCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, UserSimpleInfo> getCoreAndBaseInfo(String str, ArrayList<String> arrayList) {
            return native_getCoreAndBaseInfo(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, CoreInfo> getCoreInfo(String str, ArrayList<String> arrayList) {
            return native_getCoreInfo(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, Intimate> getIntimate(String str, ArrayList<String> arrayList) {
            return native_getIntimate(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getLocalStrangerRemark() {
            native_getLocalStrangerRemark(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, OtherFlag> getOtherFlag(String str, ArrayList<String> arrayList) {
            return native_getOtherFlag(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getProfileQzonePicInfo(String str, int i3, boolean z16, IGetProfileQzonePicInfoCallback iGetProfileQzonePicInfoCallback) {
            native_getProfileQzonePicInfo(this.nativeRef, str, i3, z16, iGetProfileQzonePicInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, RelationFlag> getRelationFlag(String str, ArrayList<String> arrayList) {
            return native_getRelationFlag(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getSelfStatus(IOperateCallback iOperateCallback) {
            native_getSelfStatus(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getStatus(String str, boolean z16, IOperateCallback iOperateCallback) {
            native_getStatus(this.nativeRef, str, z16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, StatusInfo> getStatusInfo(String str, ArrayList<String> arrayList) {
            return native_getStatusInfo(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, StockLocalData> getStockLocalData(String str, ArrayList<String> arrayList) {
            return native_getStockLocalData(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<Long, String> getUidByUin(String str, ArrayList<Long> arrayList) {
            return native_getUidByUin(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, Long> getUinByUid(String str, ArrayList<String> arrayList) {
            return native_getUinByUid(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getUserDetailInfo(String str, IOperateCallback iOperateCallback) {
            native_getUserDetailInfo(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getUserDetailInfoByUin(long j3, IDetailInfoByUinCallback iDetailInfoByUinCallback) {
            native_getUserDetailInfoByUin(this.nativeRef, j3, iDetailInfoByUinCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getUserDetailInfoWithBizInfo(String str, ArrayList<BizKey> arrayList, IOperateCallback iOperateCallback) {
            native_getUserDetailInfoWithBizInfo(this.nativeRef, str, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getUserSimpleInfo(boolean z16, ArrayList<String> arrayList, IOperateCallback iOperateCallback) {
            native_getUserSimpleInfo(this.nativeRef, z16, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public HashMap<String, VasInfo> getVasInfo(String str, ArrayList<String> arrayList) {
            return native_getVasInfo(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void getZplanAvatarInfos(ArrayList<String> arrayList, IZplanAvatarInfoCallback iZplanAvatarInfoCallback) {
            native_getZplanAvatarInfos(this.nativeRef, arrayList, iZplanAvatarInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void modifyDesktopMiniProfile(DesktopQQMiniProfile desktopQQMiniProfile, IOperateCallback iOperateCallback) {
            native_modifyDesktopMiniProfile(this.nativeRef, desktopQQMiniProfile, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void modifySelfProfile(UserSimpleInfo userSimpleInfo, IOperateCallback iOperateCallback) {
            native_modifySelfProfile(this.nativeRef, userSimpleInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void prepareRegionConfig(IOperateCallback iOperateCallback) {
            native_prepareRegionConfig(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void removeKernelProfileListener(long j3) {
            native_removeKernelProfileListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setAiAvatarActionStatus(ArrayList<AiAvatarActionStatus> arrayList, IOperateCallback iOperateCallback) {
            native_setAiAvatarActionStatus(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setBirthday(int i3, int i16, int i17, IOperateCallback iOperateCallback) {
            native_setBirthday(this.nativeRef, i3, i16, i17, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setGander(int i3, IOperateCallback iOperateCallback) {
            native_setGander(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setHeader(String str, IOperateCallback iOperateCallback) {
            native_setHeader(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setLongNick(String str, IOperateCallback iOperateCallback) {
            native_setLongNick(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setNickName(String str, IOperateCallback iOperateCallback) {
            native_setNickName(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setRecommendImgFlag(int i3, IOperateCallback iOperateCallback) {
            native_setRecommendImgFlag(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void setdisableEmojiShortCuts(int i3, IOperateCallback iOperateCallback) {
            native_setdisableEmojiShortCuts(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void startStatusPolling(boolean z16) {
            native_startStatusPolling(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void updateProfileData(String str, byte[] bArr, IOperateCallback iOperateCallback) {
            native_updateProfileData(this.nativeRef, str, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService
        public void updateStockLocalData(String str, HashMap<String, StockLocalData> hashMap, IOperateCallback iOperateCallback) {
            native_updateStockLocalData(this.nativeRef, str, hashMap, iOperateCallback);
        }
    }

    long addKernelProfileListener(IKernelProfileListener iKernelProfileListener);

    long addKernelProfileListenerForUICache(IKernelProfileListener iKernelProfileListener);

    void asyncGetCoreInfo(String str, ArrayList<String> arrayList, IAsyncCoreInfoInfoCallback iAsyncCoreInfoInfoCallback);

    ArrayList<String> enumAreaOptions(String str, String str2, String str3);

    ArrayList<String> enumCityOptions(String str, String str2);

    ArrayList<String> enumCountryOptions();

    ArrayList<String> enumProvinceOptions(String str);

    void fetchUserDetailInfo(String str, ArrayList<String> arrayList, Source source, ArrayList<ProfileBizType> arrayList2, IDetailInfoCallback iDetailInfoCallback);

    void getAiAvatarCategoryInfos(GetAiAvatarCategoryInfosReq getAiAvatarCategoryInfosReq, boolean z16, IGetAiAvatarCategoryInfosCallback iGetAiAvatarCategoryInfosCallback);

    HashMap<String, UserSimpleInfo> getCoreAndBaseInfo(String str, ArrayList<String> arrayList);

    HashMap<String, CoreInfo> getCoreInfo(String str, ArrayList<String> arrayList);

    HashMap<String, Intimate> getIntimate(String str, ArrayList<String> arrayList);

    void getLocalStrangerRemark();

    HashMap<String, OtherFlag> getOtherFlag(String str, ArrayList<String> arrayList);

    void getProfileQzonePicInfo(String str, int i3, boolean z16, IGetProfileQzonePicInfoCallback iGetProfileQzonePicInfoCallback);

    HashMap<String, RelationFlag> getRelationFlag(String str, ArrayList<String> arrayList);

    void getSelfStatus(IOperateCallback iOperateCallback);

    void getStatus(String str, boolean z16, IOperateCallback iOperateCallback);

    HashMap<String, StatusInfo> getStatusInfo(String str, ArrayList<String> arrayList);

    HashMap<String, StockLocalData> getStockLocalData(String str, ArrayList<String> arrayList);

    HashMap<Long, String> getUidByUin(String str, ArrayList<Long> arrayList);

    HashMap<String, Long> getUinByUid(String str, ArrayList<String> arrayList);

    void getUserDetailInfo(String str, IOperateCallback iOperateCallback);

    void getUserDetailInfoByUin(long j3, IDetailInfoByUinCallback iDetailInfoByUinCallback);

    void getUserDetailInfoWithBizInfo(String str, ArrayList<BizKey> arrayList, IOperateCallback iOperateCallback);

    void getUserSimpleInfo(boolean z16, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

    HashMap<String, VasInfo> getVasInfo(String str, ArrayList<String> arrayList);

    void getZplanAvatarInfos(ArrayList<String> arrayList, IZplanAvatarInfoCallback iZplanAvatarInfoCallback);

    void modifyDesktopMiniProfile(DesktopQQMiniProfile desktopQQMiniProfile, IOperateCallback iOperateCallback);

    void modifySelfProfile(UserSimpleInfo userSimpleInfo, IOperateCallback iOperateCallback);

    void prepareRegionConfig(IOperateCallback iOperateCallback);

    void removeKernelProfileListener(long j3);

    void setAiAvatarActionStatus(ArrayList<AiAvatarActionStatus> arrayList, IOperateCallback iOperateCallback);

    void setBirthday(int i3, int i16, int i17, IOperateCallback iOperateCallback);

    void setGander(int i3, IOperateCallback iOperateCallback);

    void setHeader(String str, IOperateCallback iOperateCallback);

    void setLongNick(String str, IOperateCallback iOperateCallback);

    void setNickName(String str, IOperateCallback iOperateCallback);

    void setRecommendImgFlag(int i3, IOperateCallback iOperateCallback);

    void setdisableEmojiShortCuts(int i3, IOperateCallback iOperateCallback);

    void startStatusPolling(boolean z16);

    void updateProfileData(String str, byte[] bArr, IOperateCallback iOperateCallback);

    void updateStockLocalData(String str, HashMap<String, StockLocalData> hashMap, IOperateCallback iOperateCallback);
}
