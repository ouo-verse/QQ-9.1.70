package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.cache.FriendCache;
import com.tencent.mobileqq.friend.cache.GroupCache;
import com.tencent.mobileqq.friend.utils.MMKForUinUid;
import com.tencent.mobileqq.friend.utils.b;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import hx3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import uc1.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FriendDataServiceImpl implements IFriendDataService {
    static IPatchRedirector $redirector_ = null;
    private static final String SEPARATOR = "_";
    private static final String TAG = "IMCore.friend.FriendDataServiceImpl";
    private static final String UID_PREFIX_KEY = "uid_prefix_key";
    private EntityManager mEntityManager;
    private FriendCache mFriendCache;
    private GroupCache mGroupCache;

    public FriendDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void deleteUinMapping(String str) {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101972", false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "deleteMMKVFriendUinSwitch = " + isSwitchOn);
        }
        if (isSwitchOn) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "removeUinAndUidMap uin is:" + str);
            }
            b.d().g(str);
        }
    }

    public static FriendDataServiceImpl getService(AppRuntime appRuntime) {
        return (FriendDataServiceImpl) appRuntime.getRuntimeService(IFriendDataService.class, "all");
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Groups> asyncGetGroupList(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this, (Object) aVar);
        }
        return this.mGroupCache.j(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.tencent.mobileqq.persistence.EntityTransaction] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.mobileqq.data.Friends] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Friends deleteFriend(String str) {
        Friends friends;
        Groups group;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Friends) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        ?? r16 = 0;
        Friends friends2 = null;
        EntityTransaction entityTransaction = null;
        boolean z16 = true;
        try {
            try {
                EntityTransaction transaction = this.mEntityManager.getTransaction();
                try {
                    transaction.begin();
                    this.mFriendCache.u(str);
                    friends2 = this.mFriendCache.b(str);
                    if (friends2 != null && (group = getGroup(friends2.groupid, true)) != null) {
                        group.group_friend_count--;
                        saveGroup(group);
                    }
                    deleteUinMapping(str);
                    transaction.commit();
                    transaction.end();
                    r16 = friends2;
                } catch (Exception e16) {
                    e = e16;
                    friends = friends2;
                    entityTransaction = transaction;
                    QLog.d(TAG, 1, "deleteFriend", e);
                    if (entityTransaction != null) {
                        entityTransaction.end();
                    }
                    z16 = false;
                    r16 = friends;
                    if (QLog.isColorLevel()) {
                    }
                    return r16;
                } catch (Throwable th5) {
                    th = th5;
                    r16 = transaction;
                    if (r16 != 0) {
                        r16.end();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                friends = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteFriend| friendUin: " + str + ", isSuccess: " + z16);
            }
            return r16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Friends> getAllFriends() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? getAllFriends(false) : (List) iPatchRedirector.redirect((short) 24, (Object) this);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Friends getFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? getFriend(str, false) : (Friends) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public int getFriendCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int n3 = this.mFriendCache.n(false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFriendCount| friendCount: " + n3);
        }
        return n3;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Friends getFriendFromMemoryCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Friends) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        FriendCache friendCache = this.mFriendCache;
        if (friendCache == null) {
            return null;
        }
        return friendCache.o(str);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Friends> getFriendList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (List) iPatchRedirector.redirect((short) 35, (Object) this, i3);
        }
        List<Friends> allFriends = getAllFriends();
        ArrayList arrayList = new ArrayList();
        if (allFriends != null) {
            for (Friends friends : allFriends) {
                if (friends.groupid == i3) {
                    arrayList.add(friends);
                }
            }
        }
        if (QLog.isColorLevel() && allFriends != null) {
            QLog.d(TAG, 2, "getGroupFriends| groupId: " + i3 + ", size: " + arrayList.size() + " allFriendList size: " + allFriends.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Groups getGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? getGroup(i3, false) : (Groups) iPatchRedirector.redirect((short) 26, (Object) this, i3);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Groups> getGroupList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        List<Groups> n3 = this.mGroupCache.n();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getGroupList| getGroupList: " + n3);
        }
        return n3;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void initFriendCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initFriendCache");
        }
        this.mFriendCache.q();
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void initGroupCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initGroupCache");
        }
        this.mGroupCache.o();
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean isFriend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? isFriend(str, true) : ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean isInitFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mFriendCache.f211572f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0093: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:148), block:B:40:0x0093 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void moveFriendToNewGroup(String str, int i3) {
        EntityTransaction entityTransaction;
        Exception e16;
        EntityTransaction entityTransaction2;
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EntityTransaction entityTransaction3 = null;
        int i16 = -1;
        try {
            try {
                entityTransaction = this.mEntityManager.getTransaction();
            } catch (Exception e17) {
                entityTransaction = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (entityTransaction3 != null) {
                }
                throw th;
            }
            try {
                entityTransaction.begin();
                i16 = getFriend(str, true, true, true).groupid;
                Groups group = getGroup(i16);
                if (group != null) {
                    group.group_friend_count--;
                } else {
                    QLog.e(TAG, 1, "moveFriendToNewGroup| oldGroup is null");
                }
                saveGroup(group);
                c16 = MMKForUinUid.c("uid_prefix_key_" + str, "");
            } catch (Exception e18) {
                e16 = e18;
                QLog.d(TAG, 1, "deleteFriend", e16);
            }
            if (c16 == null) {
                entityTransaction.end();
                return;
            }
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            d dVar = new d(c16, str);
            dVar.M();
            dVar.d0(i3);
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, TAG, (c<d>) null);
            Groups group2 = getGroup(i3);
            if (group2 != null) {
                group2.group_friend_count++;
                saveGroup(group2);
            } else {
                QLog.e(TAG, 1, "moveFriendToNewGroup| newGroup is null");
            }
            entityTransaction.commit();
            entityTransaction.end();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteFriendFromGroup| friendUin: " + str + ", oldGroupId: " + i16 + ", newGroupId: " + i3);
            }
        } catch (Throwable th6) {
            th = th6;
            entityTransaction3 = entityTransaction2;
            if (entityTransaction3 != null) {
                entityTransaction3.end();
            }
            throw th;
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void moveGroup(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == i16) {
            QLog.d(TAG, 1, "srcGroupId == dstGroupId");
            return;
        }
        if (this.mGroupCache.m(Integer.valueOf(i16)) == null) {
            QLog.d(TAG, 1, "dstGroupId: " + i16 + ", groups == null");
        }
        List<Friends> p16 = this.mFriendCache.p(Integer.valueOf(i3));
        EntityTransaction entityTransaction = null;
        try {
            try {
                entityTransaction = this.mEntityManager.getTransaction();
                entityTransaction.begin();
                if (p16 != null) {
                    for (Friends friends : p16) {
                        friends.groupid = i16;
                        this.mFriendCache.d(friends);
                    }
                }
                this.mGroupCache.b(Integer.valueOf(i3));
                entityTransaction.commit();
                entityTransaction.end();
                z16 = true;
            } catch (Exception e16) {
                QLog.d(TAG, 1, "moveGroup", e16);
                if (entityTransaction != null) {
                    entityTransaction.end();
                }
            }
            Iterator<Friends> it = p16.iterator();
            while (it.hasNext()) {
                this.mFriendCache.x(it.next());
            }
            this.mGroupCache.q(Integer.valueOf(i3));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "moveGroup| srcGroupId: " + i3 + ", dstGroupId: " + i16 + ", isSuccess: " + z16);
            }
        } catch (Throwable th5) {
            if (entityTransaction != null) {
                entityTransaction.end();
            }
            throw th5;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        this.mEntityManager = createEntityManager;
        this.mGroupCache = new GroupCache(createEntityManager);
        this.mFriendCache = new FriendCache(this.mEntityManager);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mFriendCache.k();
            this.mGroupCache.k();
        }
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Friends> preloadPartFriendCache(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        return this.mFriendCache.s(list);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    @Deprecated
    public boolean saveFriend(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) friends)).booleanValue();
        }
        if (friends == null) {
            return false;
        }
        String str = friends.mCompareSpell;
        if (str == null || str.length() == 0) {
            com.tencent.mobileqq.friend.utils.c.d(friends);
        }
        this.mFriendCache.x(friends);
        return this.mFriendCache.d(friends);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void saveFriendCache(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) friends);
            return;
        }
        if (friends == null) {
            return;
        }
        String str = friends.mCompareSpell;
        if (str == null || str.length() == 0) {
            com.tencent.mobileqq.friend.utils.c.d(friends);
        }
        this.mFriendCache.x(friends);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean saveFriendList(List<Friends> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) list)).booleanValue();
        }
        int i3 = 0;
        if (list != null && list.size() != 0) {
            for (Friends friends : list) {
                if (friends == null) {
                    i3++;
                } else {
                    String str = friends.mCompareSpell;
                    if (str == null || str.length() == 0) {
                        com.tencent.mobileqq.friend.utils.c.d(friends);
                    }
                    this.mFriendCache.x(friends);
                }
            }
            boolean a16 = this.mFriendCache.a(list);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "saveFriendList| isSuccess = " + a16 + ", size = " + list.size() + " emptyCount=" + i3);
            }
            return a16;
        }
        QLog.e(TAG, 1, "saveFriendList| friendList is empty!");
        return false;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean saveGroup(Groups groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) groups)).booleanValue();
        }
        if (groups == null) {
            return false;
        }
        boolean d16 = this.mGroupCache.d(groups);
        if (d16) {
            this.mGroupCache.s(groups);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateGroup| isSuccess: " + d16 + ", group: " + groups);
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean saveGroupList(List<Groups> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) list)).booleanValue();
        }
        if (list != null && !list.isEmpty()) {
            boolean a16 = this.mGroupCache.a(list);
            if (a16) {
                this.mGroupCache.t(list);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateGroupList| isSuccess: " + a16 + ", groupList: " + list);
            }
            return a16;
        }
        QLog.d(TAG, 1, "updateGroupList| groupList == null");
        return false;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void setNtRequestFriendListSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mFriendCache.f211573g = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r2 == null) goto L34;
     */
    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateGroupSortIds(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bArr, (Object) bArr2);
            return;
        }
        if (bArr != null && bArr2 != null && bArr.length == bArr2.length) {
            EntityTransaction entityTransaction = null;
            try {
                try {
                    entityTransaction = this.mEntityManager.getTransaction();
                    entityTransaction.begin();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < bArr.length; i3++) {
                        byte b16 = bArr[i3];
                        Groups group = getGroup(b16, true);
                        if (group != null) {
                            byte b17 = group.seqid;
                            byte b18 = bArr2[i3];
                            if (b17 != b18) {
                                group.seqid = b18;
                            }
                            saveGroup(group);
                            arrayList.add(group);
                        } else {
                            QLog.d(TAG, 1, "updateGroupSortIds| group not exist, groupId: " + ((int) b16));
                        }
                    }
                    this.mGroupCache.t(arrayList);
                    entityTransaction.commit();
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "deleteFriend", e16);
                }
                entityTransaction.end();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "updateGroupSortIds| groupIds: " + bArr + ", sortIds: " + bArr2);
                    return;
                }
                return;
            } catch (Throwable th5) {
                if (entityTransaction != null) {
                    entityTransaction.end();
                }
                throw th5;
            }
        }
        QLog.e(TAG, 1, "updateGroupSortIds| params error!");
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public List<Friends> getAllFriends(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (List) iPatchRedirector.redirect((short) 25, (Object) this, z16);
        }
        List<Friends> m3 = this.mFriendCache.m();
        Iterator<Friends> it = m3.iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            Friends next = it.next();
            if (!next.isFriend() || (z16 && next.gathtertype == 1)) {
                it.remove();
                arrayList.add(next.uin);
            }
        }
        return m3;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Friends getFriend(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? getFriend(str, z16, false) : (Friends) iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Groups getGroup(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Groups) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        Groups m3 = this.mGroupCache.m(Integer.valueOf(i3));
        if (m3 == null) {
            m3 = this.mGroupCache.c(Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getGroup| groupId: " + i3 + ", queryDBIfNotExist: " + z16 + ", group: " + m3);
        }
        return m3;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean isFriend(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        Friends friend = getFriend(str, z16);
        if (friend != null) {
            return friend.isFriend();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Friends getFriend(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? getFriend(str, z16, z17, false) : (Friends) iPatchRedirector.redirect((short) 12, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public Friends getFriend(String str, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Friends) iPatchRedirector.redirect((short) 13, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        Friends o16 = this.mFriendCache.o(str);
        if (o16 == null) {
            boolean z19 = this.mFriendCache.f211572f;
            if (z17 || (!z19 && z16)) {
                o16 = this.mFriendCache.c(str);
            }
        }
        if (o16 != null || !z18) {
            return o16;
        }
        Friends friends = new Friends();
        friends.uin = str;
        this.mFriendCache.x(friends);
        return friends;
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void initFriendCache(uc1.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initFriendCache");
        }
        this.mFriendCache.z(cVar);
        this.mFriendCache.q();
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public void getFriend(String str, uc1.b<Friends> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        Friends friendFromMemoryCache = getFriendFromMemoryCache(str);
        if (friendFromMemoryCache != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "callback from memory cache ");
            }
            if (bVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "callback from memory cache null == queryCallback");
                    return;
                }
                return;
            }
            bVar.a(friendFromMemoryCache);
            return;
        }
        ThreadManagerV2.excute(new Runnable(str, bVar) { // from class: com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f211547d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ uc1.b f211548e;

            {
                this.f211547d = str;
                this.f211548e = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FriendDataServiceImpl.this, str, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Friends c16 = FriendDataServiceImpl.this.mFriendCache.c(this.f211547d);
                if (c16 != null) {
                    FriendDataServiceImpl.this.mFriendCache.x(c16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(FriendDataServiceImpl.TAG, 1, "callback from memory db ");
                }
                if (this.f211548e == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(FriendDataServiceImpl.TAG, 1, "callback from memory db null == queryCallback");
                    }
                } else {
                    QLog.d(FriendDataServiceImpl.TAG, 2, "getFriend: " + c16);
                    this.f211548e.a(c16);
                }
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.friend.api.IFriendDataService
    public boolean saveFriendList(List<Friends> list, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, list, Boolean.valueOf(z16), Long.valueOf(j3))).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null && list.size() != 0) {
            EntityTransaction entityTransaction = null;
            try {
                try {
                    entityTransaction = this.mEntityManager.getTransaction();
                    entityTransaction.begin();
                    for (Friends friends : list) {
                        if (friends == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "saveFriendList, friend == null");
                            }
                        } else {
                            String str = friends.mCompareSpell;
                            if (str == null || str.length() == 0) {
                                com.tencent.mobileqq.friend.utils.c.d(friends);
                            }
                            this.mFriendCache.x(friends);
                            this.mFriendCache.d(friends);
                        }
                    }
                    if (z16) {
                        for (Friends friends2 : getAllFriends()) {
                            if (friends2.datetime < j3 && friends2.isFriend()) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 1, "removeFromCache,uin " + friends2.uin + " friend.datetime is " + friends2.datetime + " requestTimestamp is " + j3);
                                }
                                this.mFriendCache.u(friends2.uin);
                                this.mFriendCache.b(friends2.uin);
                            }
                        }
                    }
                    entityTransaction.commit();
                    entityTransaction.end();
                    z17 = true;
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "deleteFriend", e16);
                    if (entityTransaction != null) {
                        entityTransaction.end();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "saveFriendList| friend size: " + list.size() + ", isComplete: " + z16 + ", requestTimestamp: " + j3 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                return z17;
            } catch (Throwable th5) {
                if (entityTransaction != null) {
                    entityTransaction.end();
                }
                throw th5;
            }
        }
        QLog.e(TAG, 1, "saveFriendList| friendList is empty!");
        return false;
    }
}
