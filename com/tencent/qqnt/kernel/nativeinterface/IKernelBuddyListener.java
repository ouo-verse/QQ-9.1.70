package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelBuddyListener {
    void onAddBuddyNeedVerify(BuddyVerify buddyVerify);

    void onAddMeSettingChanged(int i3, HashMap<String, String> hashMap);

    void onAvatarUrlUpdated(String str);

    void onBlockChanged(HashMap<String, Boolean> hashMap);

    void onBuddyDeleted(String str);

    void onBuddyListChange(ArrayList<BuddyCategory> arrayList);

    void onBuddyListChangedV2(boolean z16);

    void onBuddyRemarkUpdated(String str, String str2);

    void onBuddyReqChange(BuddyReqInfo buddyReqInfo);

    void onBuddyReqUnreadCntChange(int i3);

    void onCheckBuddySettingResult(BuddySetting buddySetting);

    void onDelBatchBuddyInfos(ArrayList<DelBuddyResult> arrayList);

    void onDoubtBuddyReqChange(DoubtBuddyReqListRsp doubtBuddyReqListRsp);

    void onDoubtBuddyReqUnreadNumChange(int i3);

    void onNickUpdated(String str, String str2);

    void onSmartInfos(String str, String str2, int i3);

    void onSpacePermissionInfos(HashMap<Long, Integer> hashMap);
}
