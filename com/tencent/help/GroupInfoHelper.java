package com.tencent.help;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.impl.QQFriendsInfoApiImpl;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.c;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/help/GroupInfoHelper;", "", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes31.dex */
public final class GroupInfoHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final a f113996b = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105JD\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007JN\u0010!\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0004j\b\u0012\u0004\u0012\u00020\u0018`\u00062\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0004j\b\u0012\u0004\u0012\u00020\u001f`\u0006J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010%J\u0018\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010%R\u0017\u0010.\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00066"}, d2 = {"Lcom/tencent/help/GroupInfoHelper$instance;", "", "Lcom/tencent/mobileqq/friend/api/IFriendDataService;", "friendsDataService", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/Groups;", "Lkotlin/collections/ArrayList;", "groupInfoList", "Landroid/util/SparseArray;", "", "Lcom/tencent/mobileqq/data/Friends;", "groupMembers", "Landroid/util/SparseIntArray;", "onlineMemberCounts", "", "g", "members", "k", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "f", "friends", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "d", VipFunCallConstants.KEY_GROUP, "", "categoryCount", "onlineCategoryCount", "buddyList", "", "buddyUidList", "i", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "j", GuildMsgItem.NICK_FRIEND, "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "ntFriendDetailInfo", "", "a", "b", "Lcom/tencent/mobileqq/data/SpecialCareInfo;", "specialCareInfo", "c", "Lcom/tencent/help/a;", "S_STATUS_COMPARATOR", "Lcom/tencent/help/a;", h.F, "()Lcom/tencent/help/a;", "TAG", "Ljava/lang/String;", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.help.GroupInfoHelper$instance, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void k(List<? extends Friends> members) {
            try {
                Collections.sort(members, h());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(QQFriendsInfoApiImpl.TAG, 2, "", e16);
                }
            }
        }

        public final boolean a(Friends friend, c ntFriendDetailInfo) {
            boolean z16;
            String x16;
            Intrinsics.checkNotNullParameter(friend, "friend");
            if (ntFriendDetailInfo != null && (x16 = ntFriendDetailInfo.x()) != null) {
                friend.uin = x16;
            }
            if (ntFriendDetailInfo == null) {
                return false;
            }
            String p16 = ntFriendDetailInfo.p();
            if (p16 != null) {
                friend.name = p16;
                z16 = true;
            } else {
                z16 = false;
            }
            String r16 = ntFriendDetailInfo.r();
            if (r16 != null) {
                friend.remark = r16;
                z16 = true;
            }
            if (!(ntFriendDetailInfo.w() == Integer.MIN_VALUE)) {
                friend.status = (byte) ntFriendDetailInfo.w();
                z16 = true;
            }
            Byte e16 = ntFriendDetailInfo.e();
            if (e16 != null) {
                friend.cSpecialFlag = e16.byteValue();
                z16 = true;
            }
            if (ntFriendDetailInfo.f() != Integer.MIN_VALUE) {
                friend.groupid = ntFriendDetailInfo.f();
                z16 = true;
            }
            if (ntFriendDetailInfo.l() != Long.MIN_VALUE) {
                friend.datetime = ntFriendDetailInfo.l();
                z16 = true;
            }
            String c16 = ntFriendDetailInfo.c();
            if (c16 != null) {
                friend.alias = c16;
                z16 = true;
            }
            Byte n3 = ntFriendDetailInfo.n();
            if (n3 != null) {
                friend.gathtertype = n3.byteValue();
                z16 = true;
            }
            if (ntFriendDetailInfo.b() != Integer.MIN_VALUE) {
                friend.age = ntFriendDetailInfo.b();
                z16 = true;
            }
            if (ntFriendDetailInfo.v() != Integer.MIN_VALUE) {
                friend.gender = (byte) ntFriendDetailInfo.v();
                z16 = true;
            }
            String q16 = ntFriendDetailInfo.q();
            if (q16 != null) {
                friend.recommReason = q16;
                z16 = true;
            }
            if (ntFriendDetailInfo.j() != Integer.MIN_VALUE) {
                friend.mComparePartInt = ntFriendDetailInfo.j();
                z16 = true;
            }
            String k3 = ntFriendDetailInfo.k();
            if (k3 != null) {
                friend.mCompareSpell = k3;
                z16 = true;
            }
            if (ntFriendDetailInfo.o() != Integer.MIN_VALUE) {
                friend.multiFlags = ntFriendDetailInfo.o();
                z16 = true;
            }
            Boolean z17 = ntFriendDetailInfo.z();
            if (z17 != null) {
                friend.isBlack = z17.booleanValue() ? 1 : 0;
                z16 = true;
            }
            Boolean A = ntFriendDetailInfo.A();
            if (A == null) {
                return z16;
            }
            A.booleanValue();
            friend.isBlacked = Intrinsics.areEqual(ntFriendDetailInfo.A(), Boolean.TRUE) ? 1 : 0;
            return true;
        }

        public final boolean b(ExtensionInfo extensionInfo, c ntFriendDetailInfo) {
            boolean z16;
            String u16;
            Intrinsics.checkNotNullParameter(extensionInfo, "extensionInfo");
            int i3 = 0;
            if (ntFriendDetailInfo == null) {
                return false;
            }
            Boolean C = ntFriendDetailInfo.C();
            if (C != null) {
                extensionInfo.openDoNotDisturbTime = C.booleanValue() ? System.currentTimeMillis() : 0L;
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean y16 = ntFriendDetailInfo.y();
            if (y16 != null) {
                extensionInfo.isAdded2C2C = y16.booleanValue();
                z16 = true;
            }
            if (ntFriendDetailInfo.t() != Long.MIN_VALUE) {
                extensionInfo.richTime = ntFriendDetailInfo.t();
                z16 = true;
            }
            byte[] s16 = ntFriendDetailInfo.s();
            if (s16 != null) {
                extensionInfo.richBuffer = s16;
                z16 = true;
            }
            if (ntFriendDetailInfo.u() == null) {
                return z16;
            }
            if (StringUtils.isNumeric(ntFriendDetailInfo.u()) && (u16 = ntFriendDetailInfo.u()) != null) {
                i3 = Integer.parseInt(u16);
            }
            extensionInfo.friendRingId = i3;
            return true;
        }

        public final boolean c(SpecialCareInfo specialCareInfo, c ntFriendDetailInfo) {
            Boolean G;
            String u16;
            Intrinsics.checkNotNullParameter(specialCareInfo, "specialCareInfo");
            boolean z16 = true;
            boolean z17 = false;
            if (ntFriendDetailInfo != null && (u16 = ntFriendDetailInfo.u()) != null) {
                specialCareInfo.friendRingId = Integer.parseInt(u16);
                z17 = true;
            }
            if (ntFriendDetailInfo != null && (G = ntFriendDetailInfo.G()) != null) {
                specialCareInfo.qzoneSwitch = G.booleanValue() ? 1 : 0;
                z17 = true;
            }
            if (ntFriendDetailInfo == null) {
                return z17;
            }
            Boolean F = ntFriendDetailInfo.F();
            if (F != null) {
                specialCareInfo.globalSwitch = F.booleanValue() ? 1 : 0;
            } else {
                z16 = z17;
            }
            return z16;
        }

        public final d d(Friends friends, ExtensionInfo extensionInfo) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(friends, "friends");
            d dVar = new d(null, null, 3, null);
            String str = friends.uin;
            Intrinsics.checkNotNullExpressionValue(str, "friends.uin");
            dVar.w0(str);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friends.uin);
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026etUidFromUin(friends.uin)");
            dVar.v0(uidFromUin);
            dVar.k0(friends.name);
            dVar.m0(friends.remark);
            dVar.u0(friends.status);
            dVar.c0(Byte.valueOf(friends.cSpecialFlag));
            dVar.d0(friends.groupid);
            dVar.g0(friends.datetime);
            dVar.Z(friends.alias);
            dVar.h0(Byte.valueOf(friends.gathtertype));
            dVar.V(friends.age);
            dVar.q0(friends.gender);
            dVar.l0(friends.recommReason);
            dVar.e0(friends.mComparePartInt);
            String str2 = friends.mCompareSpell;
            if (str2 == null) {
                str2 = "";
            }
            dVar.f0(str2);
            dVar.j0(friends.multiFlags);
            dVar.a0(Boolean.valueOf(friends.isBlack == 1));
            dVar.b0(Boolean.valueOf(friends.isBlacked == 1));
            dVar.o0(extensionInfo != null ? extensionInfo.richTime : 0L);
            dVar.n0(extensionInfo != null ? extensionInfo.richBuffer : null);
            if (extensionInfo != null) {
                bool = Boolean.valueOf(extensionInfo.isAdded2C2C);
            } else {
                bool = Boolean.FALSE;
            }
            dVar.N(bool);
            dVar.p0(String.valueOf(extensionInfo != null ? Integer.valueOf(extensionInfo.friendRingId) : null));
            dVar.i0(Boolean.valueOf((extensionInfo != null ? extensionInfo.openDoNotDisturbTime : 0L) != 0));
            return dVar;
        }

        public final synchronized e<b> f(IFriendDataService friendsDataService) {
            e<b> eVar;
            Intrinsics.checkNotNullParameter(friendsDataService, "friendsDataService");
            eVar = new e<>();
            ArrayList<Groups> arrayList = new ArrayList<>();
            SparseArray<List<Friends>> sparseArray = new SparseArray<>();
            SparseIntArray sparseIntArray = new SparseIntArray();
            g(friendsDataService, arrayList, sparseArray, sparseIntArray);
            ArrayList<b> arrayList2 = new ArrayList<>();
            Iterator<Groups> it = arrayList.iterator();
            while (it.hasNext()) {
                Groups group = it.next();
                ArrayList<d> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                Iterator<Friends> it5 = sparseArray.get(group.group_id).iterator();
                while (it5.hasNext()) {
                    d e16 = e(this, it5.next(), null, 2, null);
                    arrayList3.add(e16);
                    arrayList4.add(e16.getUid());
                }
                Intrinsics.checkNotNullExpressionValue(group, "group");
                arrayList2.add(i(group, arrayList3.size(), sparseIntArray.get(group.group_id), arrayList3, arrayList4));
            }
            eVar.e(arrayList2);
            return eVar;
        }

        public final a h() {
            return GroupInfoHelper.f113996b;
        }

        public final b i(Groups group, int categoryCount, int onlineCategoryCount, ArrayList<d> buddyList, ArrayList<String> buddyUidList) {
            Intrinsics.checkNotNullParameter(group, "group");
            Intrinsics.checkNotNullParameter(buddyList, "buddyList");
            Intrinsics.checkNotNullParameter(buddyUidList, "buddyUidList");
            return new b(group.group_id, group.group_name, categoryCount, onlineCategoryCount, group.seqid, buddyList, buddyUidList);
        }

        public final com.tencent.qqnt.ntrelation.friendsinfo.bean.a j(Groups group) {
            Intrinsics.checkNotNullParameter(group, "group");
            return new com.tencent.qqnt.ntrelation.friendsinfo.bean.a(group.group_id, group.group_name, group.group_friend_count, 0, group.seqid, 8, null);
        }

        Companion() {
        }

        public static /* synthetic */ d e(Companion companion, Friends friends, ExtensionInfo extensionInfo, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                extensionInfo = null;
            }
            return companion.d(friends, extensionInfo);
        }

        private final void g(IFriendDataService friendsDataService, ArrayList<Groups> groupInfoList, SparseArray<List<Friends>> groupMembers, SparseIntArray onlineMemberCounts) {
            ArrayList<Groups> arrayList = groupInfoList;
            List<Groups> groupList = friendsDataService.getGroupList();
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            AppRuntime peekAppRuntime = sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            Manager manager = qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
            FriendsManager friendsManager = (FriendsManager) manager;
            Groups groups = new Groups();
            if (groupList != null && groupList.size() > 0) {
                groups.group_id = 1004;
                groups.group_name = sMobileQQ.getString(R.string.f172976g92);
                groups.group_friend_count = 1;
                groups.seqid = (byte) 0;
                arrayList.add(groups);
            }
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (Groups groups2 : groupList) {
                if (groups2 != null) {
                    arrayList.add(groups2);
                    List<Friends> friendList = friendsDataService.getFriendList(groups2.group_id);
                    if (friendList == null) {
                        friendList = new ArrayList<>();
                    }
                    if (com.tencent.relation.common.utils.e.f364767a.a()) {
                        CollectionsKt__MutableCollectionsKt.removeAll((List) friendList, (Function1) new Function1<Friends, Boolean>() { // from class: com.tencent.help.GroupInfoHelper$instance$getGroupInfoList$1
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
                        int a16 = com.tencent.mobileqq.friend.status.b.a(next.detalStatusFlag, next.iTermType);
                        if (friendsManager == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GroupInfoHelper", 2, "friendsManager == null");
                            }
                            it = it5;
                        } else {
                            SpecialCareInfo O = friendsManager.O(next.uin);
                            FriendsManager friendsManager2 = friendsManager;
                            if (O != null && O.globalSwitch != 0) {
                                arrayList2.add(next);
                                if (a16 != 0 && a16 != 6) {
                                    i3++;
                                }
                            }
                            int i17 = i3;
                            if (next.gathtertype != 1) {
                                i16 = (a16 == 0 || a16 == 6) ? i16 : i16 + 1;
                                try {
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                                if (Intrinsics.areEqual(next.uin, qQAppInterface.getAccount())) {
                                    friends = next;
                                    i3 = i17;
                                    it = it5;
                                    friendsManager = friendsManager2;
                                }
                                arrayList3.add(next);
                            }
                            i3 = i17;
                            it = it5;
                            friendsManager = friendsManager2;
                        }
                    }
                    FriendsManager friendsManager3 = friendsManager;
                    int i18 = i16;
                    k(arrayList3);
                    Friends friends2 = friends;
                    if (friends2 != null) {
                        arrayList3.add(0, friends2);
                    }
                    onlineMemberCounts.put(groups2.group_id, i18);
                    groupMembers.put(groups2.group_id, arrayList3);
                    if (QLog.isColorLevel()) {
                        QLog.d(QQFriendsInfoApiImpl.TAG, 2, "groupId: " + groups2.group_id + " num: " + friendList.size());
                    }
                    arrayList = groupInfoList;
                    friendsManager = friendsManager3;
                }
            }
            k(arrayList2);
            onlineMemberCounts.put(1004, i3);
            groupMembers.put(1004, arrayList2);
            groups.group_friend_count = arrayList2.size();
        }
    }
}
