package com.tencent.qqnt.ntrelation.api;

import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/IFriendsTABService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getCacheFriendCount", "", "getNormalBuddyListSyncSwitch", "", "getSpecialCareCategoryId", "isDataFromSimpleInfo", "isNTLogOpen", "isNewAlphabetFriendFragment", "isNewGroupFragment", "isNtDataService", "isOnlineStatusNTDataService", "isSupportFriendListCache", "isVasAccurateWrite", "refreshAndCheckIsNtDataService", "setAlphabetFriendFragmentSwitch", "", h.f248218g, "setDebugDataSwitch", "setNewGroupFragmentSwitch", "setVasAccurateSwitch", "shieldOptSwitch", "contacts_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IFriendsTABService extends QRouteApi {
    int getCacheFriendCount();

    boolean getNormalBuddyListSyncSwitch();

    int getSpecialCareCategoryId();

    boolean isDataFromSimpleInfo();

    boolean isNTLogOpen();

    boolean isNewAlphabetFriendFragment();

    boolean isNewGroupFragment();

    boolean isNtDataService();

    boolean isOnlineStatusNTDataService();

    boolean isSupportFriendListCache();

    boolean isVasAccurateWrite();

    boolean refreshAndCheckIsNtDataService();

    void setAlphabetFriendFragmentSwitch(boolean isOpen);

    void setDebugDataSwitch(boolean isOpen);

    void setNewGroupFragmentSwitch(boolean isOpen);

    void setVasAccurateSwitch(boolean isOpen);

    boolean shieldOptSwitch();
}
