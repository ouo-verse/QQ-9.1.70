package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopMemberInfoService extends IRuntimeService {
    public static final int INVALID_UIN = -100;
    public static final String IS_FIRST_UPGRADE_TO_500 = "is_first_upgrade_to_500";
    public static final int VALUE_INVALID = -100;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(TroopMemberInfo troopMemberInfo);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(String str);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str);

        void e(String str, List<TroopMemberInfo> list);

        void f(String str, String str2);

        void g(ArrayList<String> arrayList);
    }

    void addTroopMemberUpdateObserver(b bVar);

    @Deprecated
    boolean deleteTroopMember(String str, String str2);

    @Deprecated
    boolean deleteTroopMember(String str, String str2, boolean z16);

    TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(String str, String str2, String str3, a aVar);

    void getTroopMemberInfoAsync(String str, String str2, String str3, a aVar);

    void getTroopsMemberList();

    void notifyChangeMember(String str, String str2);

    void notifyChangeMemberWithInfo(String str, List<TroopMemberInfo> list);

    void notifyFriendRemarkChange(String str, String str2);

    void notifyGetTroopMembersFailed(String str);

    void notifyKickoutMember(String str, String str2);

    void notifyQuitTroop(String str);

    void notifyTroopMembersUpdate(ArrayList<String> arrayList);

    void removeTroopMemberUpdateObserver(b bVar);
}
