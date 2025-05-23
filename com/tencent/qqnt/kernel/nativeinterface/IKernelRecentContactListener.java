package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelRecentContactListener {
    void onDeletedContactsNotify(ArrayList<DeleteRecentContactInfo> arrayList);

    void onMsgUnreadCountUpdate(HashMap<String, Integer> hashMap);

    void onRecentContactListChanged(ArrayList<Long> arrayList, ArrayList<RecentContactInfo> arrayList2, RecentContactExtra recentContactExtra);

    void onRecentContactListChangedVer2(ArrayList<RecentContactListChangedInfo> arrayList, int i3);

    void onRecentContactNotification(ArrayList<RecentContactInfo> arrayList, NotificationCommonInfo notificationCommonInfo, int i3);
}
