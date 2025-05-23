package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.fts.data.troop.TroopIndex;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RelationFriendsSearchHelperImpl implements IRelationFriendsSearchHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RelationFriendsSearchHelperImpl";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Comparator<Map.Entry<String, c>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RelationFriendsSearchHelperImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, c> entry, Map.Entry<String, c> entry2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry, (Object) entry2)).intValue();
            }
            float a16 = entry2.getValue().a() - entry.getValue().a();
            if (a16 > 0.0f) {
                return 1;
            }
            if (a16 < 0.0f) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements Comparator<Map.Entry<String, c>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RelationFriendsSearchHelperImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, c> entry, Map.Entry<String, c> entry2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry, (Object) entry2)).intValue();
            }
            long j3 = entry2.getValue().f294330d - entry.getValue().f294330d;
            if (j3 > 0) {
                return 1;
            }
            if (j3 < 0) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final float f294327a;

        /* renamed from: b, reason: collision with root package name */
        public float f294328b;

        /* renamed from: c, reason: collision with root package name */
        public int f294329c;

        /* renamed from: d, reason: collision with root package name */
        public long f294330d;

        public c(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
                return;
            }
            this.f294328b = 0.0f;
            this.f294329c = 0;
            this.f294330d = 0L;
            this.f294327a = f16;
        }

        public float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return (this.f294329c * this.f294327a * 0.4f) + (this.f294328b * 0.6f);
        }
    }

    public RelationFriendsSearchHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ca  */
    @Override // com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<Object> search(String str, AppInterface appInterface) {
        int i3;
        int i16;
        int i17;
        long j3;
        Iterator it;
        float f16;
        float f17;
        RecentUserProxy recentUserProxy;
        String str2;
        long j16;
        long j17;
        String str3 = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3, (Object) appInterface);
        }
        int i18 = 1;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "uin empty");
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        ArrayList arrayList = new ArrayList();
        if (arrayList.size() == 0) {
            QLog.e(TAG, 1, "Search ftsEntities empty");
            return null;
        }
        HashMap hashMap = new HashMap();
        long serverTime = NetConnInfoCenter.getServerTime() + 100;
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        long j18 = 0;
        long j19 = 0;
        int i19 = 0;
        int i26 = 0;
        while (i19 < arrayList.size()) {
            TroopIndex troopIndex = (TroopIndex) arrayList.get(i19);
            if (!hashMap.containsKey(troopIndex.mTroopUin)) {
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(troopIndex.mTroopUin, i18);
                j16 = serverTime;
                if (findRecentUserByUin != null) {
                    long j26 = findRecentUserByUin.lastmsgtime;
                    if (j26 > j18) {
                        long j27 = j16 - j26;
                        i26++;
                        j19 += j27;
                        hashMap.put(troopIndex.mTroopUin, Long.valueOf(j27));
                        i19++;
                        serverTime = j16;
                        i18 = 1;
                        j18 = 0;
                    }
                }
                j17 = j19;
                hashMap.put(troopIndex.mTroopUin, 0L);
            } else {
                j16 = serverTime;
                j17 = j19;
            }
            j19 = j17;
            i19++;
            serverTime = j16;
            i18 = 1;
            j18 = 0;
        }
        long j28 = j19;
        long currentTimeMillis = System.currentTimeMillis();
        IFriendDataService iFriendDataService = (IFriendDataService) qQAppInterface.getRuntimeService(IFriendDataService.class, "");
        HashMap hashMap2 = new HashMap();
        float size = 1.0f / hashMap.size();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        Iterator it5 = hashMap.keySet().iterator();
        long j29 = 0;
        while (it5.hasNext()) {
            String str4 = (String) it5.next();
            float f18 = size;
            RecentUserProxy recentUserProxy2 = m3;
            long longValue = ((Long) hashMap.get(str4)).longValue();
            float f19 = 0.0f;
            if (longValue > 0 && j28 > 0) {
                it = it5;
                float f26 = (((float) longValue) + 0.0f) / ((float) j28);
                if (f26 <= 1.0f && i26 > 0) {
                    if (i26 == 1) {
                        f16 = 1.0f;
                        if (!QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            j3 = j28;
                            sb5.append("troopUin:");
                            sb5.append(str4);
                            sb5.append(",delta:");
                            sb5.append(longValue);
                            sb5.append("troopActiveFator_delta:");
                            sb5.append(f16);
                            QLog.i(TAG, 2, sb5.toString());
                        } else {
                            j3 = j28;
                        }
                    } else {
                        f19 = (1.0f - f26) / (i26 - 1);
                    }
                }
                f16 = f19;
                if (!QLog.isColorLevel()) {
                }
            } else {
                j3 = j28;
                it = it5;
                f16 = 0.0f;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            ArrayList arrayList2 = new ArrayList();
            j29 += System.currentTimeMillis() - currentTimeMillis2;
            if (arrayList2.size() == 0) {
                QLog.e(TAG, 1, "Search ftsMembers empty");
            } else {
                int i27 = 0;
                while (i27 < arrayList2.size()) {
                    TroopIndex troopIndex2 = (TroopIndex) arrayList2.get(i27);
                    if (iFriendDataService.isFriend(troopIndex2.mMemberUin) && !currentAccountUin.equals(troopIndex2.mMemberUin) && !str3.equals(troopIndex2.mMemberUin)) {
                        if (!hashMap2.containsKey(troopIndex2.mMemberUin)) {
                            f17 = f18;
                            c cVar = new c(f17);
                            cVar.f294328b = f16;
                            cVar.f294329c = 1;
                            RecentUserProxy recentUserProxy3 = recentUserProxy2;
                            str2 = currentAccountUin;
                            RecentUser findRecentUserByUin2 = recentUserProxy3.findRecentUserByUin(troopIndex2.mMemberUin, 0);
                            recentUserProxy = recentUserProxy3;
                            if (findRecentUserByUin2 != null) {
                                cVar.f294330d = findRecentUserByUin2.lastmsgtime;
                            }
                            hashMap2.put(troopIndex2.mMemberUin, cVar);
                        } else {
                            f17 = f18;
                            recentUserProxy = recentUserProxy2;
                            str2 = currentAccountUin;
                            c cVar2 = (c) hashMap2.get(troopIndex2.mMemberUin);
                            cVar2.f294329c++;
                            cVar2.f294328b += f16;
                        }
                    } else {
                        f17 = f18;
                        recentUserProxy = recentUserProxy2;
                        str2 = currentAccountUin;
                    }
                    i27++;
                    str3 = str;
                    currentAccountUin = str2;
                    recentUserProxy2 = recentUserProxy;
                    f18 = f17;
                }
            }
            str3 = str;
            size = f18;
            it5 = it;
            currentAccountUin = currentAccountUin;
            m3 = recentUserProxy2;
            j28 = j3;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "querycostmember:" + j29 + ",troopsSize:" + hashMap.size() + "Members:" + hashMap2.size());
        }
        ArrayList arrayList3 = new ArrayList(hashMap2.entrySet());
        Collections.sort(arrayList3, new a());
        int size2 = arrayList3.size();
        if (size2 > 1) {
            i3 = 0;
            if (((c) ((Map.Entry) arrayList3.get(size2 - 1)).getValue()).a() == ((c) ((Map.Entry) arrayList3.get(0)).getValue()).a()) {
                i16 = 1;
                if (i16 != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "isAllMemberScoreEqual");
                    }
                    Collections.sort(arrayList3, new b());
                }
                ArrayList<Object> arrayList4 = new ArrayList<>();
                IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                for (i17 = i3; i17 < arrayList3.size(); i17++) {
                    c cVar3 = (c) ((Map.Entry) arrayList3.get(i17)).getValue();
                    d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(iRelationNTUinAndUidApi.getUidFromUin((String) ((Map.Entry) arrayList3.get(i17)).getKey()), TAG);
                    if (friendsSimpleInfoWithUid != null) {
                        arrayList4.add(friendsSimpleInfoWithUid);
                        if (i17 < 20 && QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "top20:uin" + StringUtil.getSimpleUinForPrint(friendsSimpleInfoWithUid.x()) + ",scores:" + cVar3.a() + ",frequency:" + cVar3.f294329c + ",activefactor:" + cVar3.f294328b + ",c2clastmsgtime:" + cVar3.f294330d);
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "friends null");
                    }
                }
                return arrayList4;
            }
        } else {
            i3 = 0;
        }
        i16 = i3;
        if (i16 != 0) {
        }
        ArrayList<Object> arrayList42 = new ArrayList<>();
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi2 = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        while (i17 < arrayList3.size()) {
        }
        return arrayList42;
    }
}
