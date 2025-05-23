package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.QQFriendsInfoApiImpl;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000e2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/UidCategoryListUtil;", "", "", "Lcom/tencent/mobileqq/data/Friends;", "members", "", "c", "Lcom/tencent/mobileqq/data/Groups;", "groups", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "a", "Lcom/tencent/mobileqq/friend/api/IFriendDataService;", "friendsDataService", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UidCategoryListUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final UidCategoryListUtil f360227a = new UidCategoryListUtil();

    UidCategoryListUtil() {
    }

    private final com.tencent.qqnt.ntrelation.friendsinfo.bean.b a(Groups groups) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, null, 0, 0, (byte) 0, null, null, 127, null);
        bVar.j(groups.group_id);
        bVar.l(groups.group_name);
        bVar.k(1);
        bVar.n(groups.seqid);
        return bVar;
    }

    private final void c(List<? extends Friends> members) {
        try {
            Collections.sort(members, new com.tencent.help.a());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(QQFriendsInfoApiImpl.TAG, 2, "", e16);
            }
        }
    }

    public final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b(IFriendDataService friendsDataService) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        IFriendDataService friendsDataService2 = friendsDataService;
        Intrinsics.checkNotNullParameter(friendsDataService2, "friendsDataService");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = new ArrayList<>();
        List<Groups> groupList = friendsDataService.getGroupList();
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        QQAppInterface qQAppInterface = (QQAppInterface) sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return new ArrayList<>();
        }
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            return new ArrayList<>();
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, null, 0, 0, (byte) 0, null, null, 127, null);
        boolean z16 = true;
        if (groupList == null || groupList.size() <= 0) {
            bVar = bVar2;
        } else {
            bVar = bVar2;
            bVar.j(1004);
            bVar.l(sMobileQQ.getString(R.string.f172976g92));
            bVar.k(1);
            bVar.n((byte) 0);
            arrayList.add(bVar);
        }
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (Groups groups : groupList) {
            if (groups != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b a16 = a(groups);
                arrayList.add(a16);
                List<Friends> friendList = friendsDataService2.getFriendList(a16.d());
                if (friendList == null) {
                    friendList = new ArrayList<>();
                }
                if (com.tencent.relation.common.utils.e.f364767a.a()) {
                    CollectionsKt__MutableCollectionsKt.removeAll((List) friendList, (Function1) new Function1<Friends, Boolean>() { // from class: com.tencent.qqnt.ntrelation.util.UidCategoryListUtil$getGroupInfoUidList$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Friends friends) {
                            return Boolean.valueOf((friends.robotVersion == 0 && friends.robotType == 0) ? false : true);
                        }
                    });
                }
                ArrayList arrayList3 = new ArrayList(friendList.size());
                Iterator<Friends> it = friendList.iterator();
                Friends friends = null;
                int i16 = 0;
                while (it.hasNext()) {
                    Friends next = it.next();
                    Iterator<Friends> it5 = it;
                    int a17 = com.tencent.mobileqq.friend.status.b.a(next.detalStatusFlag, next.iTermType);
                    SpecialCareInfo O = friendsManager.O(next.uin);
                    FriendsManager friendsManager2 = friendsManager;
                    if (O != null && O.globalSwitch != 0) {
                        arrayList2.add(next);
                        if (a17 != 0 && a17 != 6) {
                            i3++;
                        }
                    }
                    int i17 = i3;
                    if (next.gathtertype != 1) {
                        i16 = (a17 == 0 || a17 == 6) ? i16 : i16 + 1;
                        try {
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        if (Intrinsics.areEqual(next.uin, qQAppInterface.getAccount())) {
                            friends = next;
                            i3 = i17;
                            it = it5;
                            z16 = true;
                            friendsManager = friendsManager2;
                        }
                        arrayList3.add(next);
                    }
                    z16 = true;
                    i3 = i17;
                    it = it5;
                    friendsManager = friendsManager2;
                }
                FriendsManager friendsManager3 = friendsManager;
                int i18 = i16;
                c(arrayList3);
                Friends friends2 = friends;
                if (friends2 != null) {
                    arrayList3.add(0, friends2);
                }
                a16.k(arrayList3.size());
                a16.m(i18);
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
                Iterator it6 = arrayList3.iterator();
                while (it6.hasNext()) {
                    arrayList4.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((Friends) it6.next()).uin));
                }
                a16.i(new ArrayList<>(arrayList4));
                if (QLog.isColorLevel()) {
                    QLog.d(QQFriendsInfoApiImpl.TAG, 2, "groupId: " + groups.group_id + " num: " + friendList.size());
                }
                friendsDataService2 = friendsDataService;
                friendsManager = friendsManager3;
                z16 = true;
            }
        }
        c(arrayList2);
        bVar.m(i3);
        bVar.k(arrayList2.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault);
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            arrayList5.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(((Friends) it7.next()).uin));
        }
        bVar.i(new ArrayList<>(arrayList5));
        return arrayList;
    }
}
