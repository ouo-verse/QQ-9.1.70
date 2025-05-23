package com.tencent.qqnt.ntrelation.api.impl;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import ix3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/impl/FriendsTABServiceImpl;", "Lcom/tencent/qqnt/ntrelation/api/IFriendsTABService;", "", "refreshAndCheckIsNtDataService", "isNewAlphabetFriendFragment", "isNewGroupFragment", "isNtDataService", "isSupportFriendListCache", "isVasAccurateWrite", "", "getCacheFriendCount", "isDataFromSimpleInfo", "", "type", "getLocalData", h.f248218g, "", "setDebugDataSwitch", "setNewGroupFragmentSwitch", "setAlphabetFriendFragmentSwitch", "setVasAccurateSwitch", "isNTLogOpen", "getSpecialCareCategoryId", "shieldOptSwitch", "getNormalBuddyListSyncSwitch", "isOnlineStatusNTDataService", "isNewFriendFragment", "Z", "isLogOpen", "dataSourceSwitch", "relationTabFragmentSwitch", "vasAccurateWrite", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendsTABServiceImpl implements IFriendsTABService {
    public static final int DEFAULT_CACHE_SIZE = 200;
    public static final String KEY_DATA_SOURCE = "FRIENDS_AB_TEST_DATA_SWITCH";
    public static final String KEY_RELATION_TAB_FRAGMENT = "FRIENDS_AB_TEST_RELATION_TAB_FRAGMENT_SWITCH";
    public static final String KEY_VAS_ACCURATE_WRITE = "FRIENDS_AB_TEST_VAS_ACCURATE_WRITE";
    private static final int NT_SPECAIL_GROUP_ID = 9999;
    public static final String TAG = "FriendsAbTestServiceImpl";
    public static final String TYPE_DATA_SOURCE = "DATA_SOURCE";
    public static final String TYPE_RELATION_TAB_FRAGMENT = "RELATION_TAB_FRAGMENT";
    public static final String TYPE_VAS_ACCURATE_WRITE = "VAS_ACCURATE_WRITE";
    private boolean isNewFriendFragment = getLocalData(TYPE_RELATION_TAB_FRAGMENT);
    private boolean isNtDataService = getLocalData(TYPE_DATA_SOURCE);
    private boolean isVasAccurateWrite = getLocalData(TYPE_VAS_ACCURATE_WRITE);
    private boolean isLogOpen = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101925", false);
    private boolean dataSourceSwitch = true;
    private boolean relationTabFragmentSwitch = true;
    private boolean vasAccurateWrite = true;

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public int getCacheFriendCount() {
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101859");
        int cacheSize = aVar != null ? aVar.getCacheSize() : 200;
        if (QLog.isColorLevel()) {
            QLog.i("FriendsAbTestServiceImpl", 1, "cacheFriendCount " + cacheSize);
        }
        return cacheSize;
    }

    public final boolean getLocalData(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int hashCode = type.hashCode();
        if (hashCode != -845586864) {
            if (hashCode != 466032843) {
                if (hashCode == 1769172285 && type.equals(TYPE_RELATION_TAB_FRAGMENT)) {
                    return this.relationTabFragmentSwitch;
                }
            } else if (type.equals(TYPE_VAS_ACCURATE_WRITE)) {
                return this.vasAccurateWrite;
            }
        } else if (type.equals(TYPE_DATA_SOURCE)) {
            return this.dataSourceSwitch;
        }
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean getNormalBuddyListSyncSwitch() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103151", true);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public int getSpecialCareCategoryId() {
        return this.isNtDataService ? 9999 : 1004;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isDataFromSimpleInfo() {
        boolean z16 = isNewAlphabetFriendFragment() || isNewGroupFragment();
        QLog.i("FriendsAbTestServiceImpl", 1, "isDataFromSimpleInfo isNew " + z16);
        return z16;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    /* renamed from: isNTLogOpen, reason: from getter */
    public boolean getIsLogOpen() {
        return this.isLogOpen;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isNewAlphabetFriendFragment() {
        boolean z16 = this.isNewFriendFragment;
        QLog.i("FriendsAbTestServiceImpl", 1, "isNewAlphabetFriendFragment is " + z16);
        return z16;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isNewGroupFragment() {
        boolean z16 = this.isNewFriendFragment;
        QLog.i("FriendsAbTestServiceImpl", 1, "isNewGroupFragment isNew " + z16);
        return z16;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isNtDataService() {
        boolean z16 = this.isNtDataService;
        if (getIsLogOpen()) {
            QLog.i("FriendsAbTestServiceImpl", 1, "isNewDataService" + z16);
        }
        return z16;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isOnlineStatusNTDataService() {
        return OnlineStatusToggleUtils.F();
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isSupportFriendListCache() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101859", false);
        if (QLog.isColorLevel()) {
            QLog.i("FriendsAbTestServiceImpl", 1, "isSupportFriendListCache " + isSwitchOn);
        }
        return isSwitchOn;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean isVasAccurateWrite() {
        boolean z16 = this.isVasAccurateWrite;
        if (getIsLogOpen()) {
            QLog.i("FriendsAbTestServiceImpl", 1, "isVasInfoUseNTData" + z16);
        }
        return z16;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean refreshAndCheckIsNtDataService() {
        this.isNewFriendFragment = getLocalData(TYPE_RELATION_TAB_FRAGMENT);
        this.isNtDataService = getLocalData(TYPE_DATA_SOURCE);
        this.isVasAccurateWrite = getLocalData(TYPE_VAS_ACCURATE_WRITE);
        return this.isNtDataService;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public void setAlphabetFriendFragmentSwitch(boolean isOpen) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(KEY_RELATION_TAB_FRAGMENT, isOpen);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public void setDebugDataSwitch(boolean isOpen) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(KEY_DATA_SOURCE, isOpen);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public void setNewGroupFragmentSwitch(boolean isOpen) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(KEY_RELATION_TAB_FRAGMENT, isOpen);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public void setVasAccurateSwitch(boolean isOpen) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(KEY_VAS_ACCURATE_WRITE, isOpen);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendsTABService
    public boolean shieldOptSwitch() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103047", true);
        QLog.i("FriendsAbTestServiceImpl", 1, "shieldOptSwitch " + isSwitchOn);
        return isSwitchOn;
    }
}
