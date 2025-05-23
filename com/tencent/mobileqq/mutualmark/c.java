package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.ad;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static Comparator<com.tencent.mobileqq.mutualmark.info.d> f252019a;

    /* renamed from: b, reason: collision with root package name */
    static Comparator<com.tencent.mobileqq.mutualmark.info.c> f252020b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Comparator<com.tencent.mobileqq.mutualmark.info.d> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.mutualmark.info.d dVar, com.tencent.mobileqq.mutualmark.info.d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            return dVar.f252128t - dVar2.f252128t;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Comparator<com.tencent.mobileqq.mutualmark.info.c> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.mutualmark.info.c cVar, com.tencent.mobileqq.mutualmark.info.c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            int i3 = cVar.f252096l;
            int i16 = cVar2.f252096l;
            if (i3 < i16) {
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f252019a = new a();
            f252020b = new b();
        }
    }

    public static void a(com.tencent.mobileqq.mutualmark.info.c cVar, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        com.tencent.mobileqq.mutualmark.info.d dVar;
        if (aVar != null && cVar != null && g.o(cVar.f252085a)) {
            com.tencent.mobileqq.mutualmark.info.f fVar = new com.tencent.mobileqq.mutualmark.info.f(aVar);
            ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
            if (concurrentHashMap != null && (dVar = concurrentHashMap.get(Long.valueOf(cVar.f252085a))) != null) {
                dVar.f252122n = cVar.f252094j;
                dVar.f252123o = cVar.f252095k;
            }
            fVar.a(aVar);
        }
    }

    private static void b(com.tencent.mobileqq.mutualmark.info.c cVar) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_mutualmark_vip_iconformat_switch", false)) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("MutualMarkDataCenter", 1, "replace old VipUrl:" + cVar.f252102r + " with new iconApngUrl:" + cVar.f252106v);
        }
        cVar.f252102r = cVar.f252106v;
    }

    public static Pair<com.tencent.mobileqq.mutualmark.info.c, com.tencent.mobileqq.mutualmark.info.c> c(QQAppInterface qQAppInterface, String str) {
        com.tencent.mobileqq.mutualmark.info.c cVar;
        com.tencent.mobileqq.mutualmark.info.c cVar2;
        ArrayList<com.tencent.mobileqq.mutualmark.info.c> d16 = d(qQAppInterface, str, false, 1);
        com.tencent.mobileqq.mutualmark.info.c cVar3 = null;
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
            if (d16 != null && !d16.isEmpty()) {
                cVar2 = null;
                for (int i3 = 0; i3 < d16.size(); i3++) {
                    if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                        QLog.e("MutualMarkDataCenter", 1, "getAIOTitleMutualMarkDisplayInfos uin:" + str + " index:" + i3 + "displayInfo: " + d16.get(i3));
                    }
                    if (i3 != 0) {
                        if (i3 == 1) {
                            cVar2 = d16.get(i3);
                        }
                    } else {
                        cVar3 = d16.get(i3);
                    }
                }
                if (cVar3 != null && TextUtils.isEmpty(cVar3.f252102r)) {
                    com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, cVar3);
                }
                if (cVar2 != null && TextUtils.isEmpty(cVar2.f252102r)) {
                    com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, cVar2);
                }
            } else {
                cVar2 = null;
            }
            return new Pair<>(cVar3, cVar2);
        }
        if (d16 != null && !d16.isEmpty()) {
            Iterator<com.tencent.mobileqq.mutualmark.info.c> it = d16.iterator();
            cVar = null;
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.c next = it.next();
                if (!next.f252097m) {
                    if (cVar3 == null || next.f252098n < cVar3.f252098n) {
                        cVar3 = next;
                    }
                } else if (cVar == null || next.f252098n < cVar.f252098n) {
                    cVar = next;
                }
            }
            if (cVar3 != null && TextUtils.isEmpty(cVar3.f252102r)) {
                com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, cVar3);
            }
            if (cVar != null && TextUtils.isEmpty(cVar.f252102r)) {
                com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, cVar);
            }
        } else {
            cVar = null;
        }
        return new Pair<>(cVar3, cVar);
    }

    public static ArrayList<com.tencent.mobileqq.mutualmark.info.c> d(QQAppInterface qQAppInterface, String str, boolean z16, int i3) {
        boolean E;
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            return null;
        }
        if (i3 != 2 && i3 != 1) {
            E = friendsManager.E(false);
        } else {
            E = friendsManager.E(true);
        }
        if (E | ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getDisableInteractiveSwitchLocal()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks disableReactive: true , mutualmark switch is close");
            }
            return null;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "MutualMarkDataCenter")) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks fm.isFriendJustInCache: " + str + " == false");
            }
            return null;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "MutualMarkDataCenter");
        if (intimateSimpleInfoWithUid == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks simpleInfo == null, queryDBIfNotInCache == " + z16);
            }
            return null;
        }
        return g(qQAppInterface, str, intimateSimpleInfoWithUid.m());
    }

    public static com.tencent.mobileqq.mutualmark.info.c e(QQAppInterface qQAppInterface, String str, boolean z16) {
        FriendsManager friendsManager;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)) == null) {
            return null;
        }
        if (friendsManager.E(false)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo disableReactive: true , mutualmark switch is close");
            }
            return null;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "MutualMarkDataCenter")) {
            QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo fm.isFriendJustInCache: " + str + " == false");
            return null;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "MutualMarkDataCenter");
        if (intimateSimpleInfoWithUid == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getIntimateMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == " + z16);
            }
            return null;
        }
        return com.tencent.mobileqq.activity.aio.intimate.e.c(qQAppInterface, str, intimateSimpleInfoWithUid);
    }

    public static com.tencent.mobileqq.mutualmark.info.c f(QQAppInterface qQAppInterface, String str, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, long j3) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && aVar != null) {
            com.tencent.mobileqq.mutualmark.info.d i3 = i(qQAppInterface, str, aVar, j3);
            if (i3 != null && !i3.f252121m) {
                ad a16 = MutualMarkConfProcessor.a();
                com.tencent.mobileqq.mutualmark.info.b e16 = a16.e(i3.f252109a);
                if (e16 != null) {
                    com.tencent.mobileqq.mutualmark.info.c cVar = new com.tencent.mobileqq.mutualmark.info.c();
                    cVar.b(i3);
                    cVar.f252100p = e16.f252073f;
                    cVar.f252099o = e16.c(cVar.f252086b);
                    cVar.f252097m = e16.f252071d;
                    cVar.f252098n = e16.f252072e;
                    cVar.f252096l = e16.f252070c;
                    cVar.f252101q = com.tencent.mobileqq.mutualmark.b.a(qQAppInterface, str, cVar.f252085a, cVar.f252086b);
                    cVar.f252103s = g.b(cVar.f252103s);
                    com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, cVar);
                    cVar.f252103s = com.tencent.mobileqq.mutualmark.alienation.a.c(qQAppInterface, str, cVar.f252085a, cVar.f252086b, cVar.f252093i, cVar.f252103s);
                    if (!cVar.c()) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisPlayInfo IconResource InValid displayInfo:" + cVar + ", friendUin" + MobileQQ.getShortUinStr(str));
                            return null;
                        }
                        return null;
                    }
                    if (e16.e(cVar.f252086b) && com.tencent.mobileqq.mutualmark.b.i(qQAppInterface, cVar.f252085a, cVar.f252086b)) {
                        return cVar;
                    }
                    if (e16.d() && com.tencent.mobileqq.mutualmark.b.h(qQAppInterface, cVar.f252085a)) {
                        long a17 = e16.a(cVar.f252086b);
                        if (a17 != -1) {
                            cVar.f252086b = a17;
                            return cVar;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MutualMarkDataCenter", 2, str + "getMutualMarkDisPlayInfo# displayInfo:" + cVar + ", bean:" + a16 + ",type = " + j3);
                        return null;
                    }
                    return null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("MutualMarkDataCenter", 1, "MutualMarkConfBean getMutualMarkConfig(mutualMarkInfo.type): null\uff0ctype = " + j3 + "\uff0cbean = " + a16);
                    return null;
                }
                return null;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisPlayInfo# may null\uff0cmutualMarkInfo: " + i3);
                return null;
            }
            return null;
        }
        return null;
    }

    public static ArrayList<com.tencent.mobileqq.mutualmark.info.c> g(QQAppInterface qQAppInterface, String str, String str2) {
        ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> c16;
        Collection<com.tencent.mobileqq.mutualmark.info.d> values;
        if (TextUtils.isEmpty(str2) || (c16 = com.tencent.mobileqq.mutualmark.info.d.c(str2)) == null || c16.size() == 0 || (values = c16.values()) == null) {
            return null;
        }
        ArrayList<com.tencent.mobileqq.mutualmark.info.d> arrayList = new ArrayList(values);
        Collections.sort(arrayList, f252019a);
        ArrayList<com.tencent.mobileqq.mutualmark.info.c> arrayList2 = new ArrayList<>();
        for (com.tencent.mobileqq.mutualmark.info.d dVar : arrayList) {
            if (dVar != null && !dVar.f252121m && dVar.f252126r) {
                com.tencent.mobileqq.mutualmark.info.c cVar = new com.tencent.mobileqq.mutualmark.info.c();
                cVar.b(dVar);
                int l3 = ff.l(qQAppInterface, str, ff.v((int) cVar.f252085a));
                int g16 = ff.g(qQAppInterface, str, cVar.f252085a);
                if (QLog.isDebugVersion()) {
                    QLog.d("MutualMarkDataCenter", 4, "friendUin=" + str + "getMutualMarkDisPlayInfoForNewVersion,type=" + dVar.f252109a + ",isWearing=" + dVar.f252126r + ",iconUrl=" + cVar.f252106v + ",iconFormat=" + cVar.f252108x + ",alienationType=" + l3 + ",curSpecialType=" + g16);
                }
                if ((l3 != 0 || g16 != 0) && !TextUtils.isEmpty(cVar.f252108x)) {
                    String str3 = cVar.f252108x;
                    cVar.f252106v = str3;
                    if (l3 != 0) {
                        cVar.f252106v = str3.replace("{alienation}", String.valueOf(l3));
                    }
                    if (cVar.f252106v.contains("{alienation}")) {
                        cVar.f252106v = cVar.f252106v.replace("{alienation}", String.valueOf(g16));
                    } else if (g16 != 0) {
                        cVar.f252106v = cVar.f252106v.replace("/{level}", g16 + "/{level}");
                    }
                    cVar.f252106v = cVar.f252106v.replace("{level}", String.valueOf(cVar.f252086b)).replace("{sub_level}", String.valueOf(cVar.f252093i)).replace("{style}", "0").replace("{size}", NtFaceConstant.SMALL);
                    if (QLog.isDebugVersion()) {
                        QLog.d("MutualMarkDataCenter", 4, "friendUin=" + str + "getMutualMarkDisPlayInfoForNewVersion,type=" + dVar.f252109a + " ,displayInfo=" + cVar.f252106v);
                    }
                    b(cVar);
                }
                if (cVar.f252107w == 0) {
                    if (!TextUtils.isEmpty(cVar.f252106v)) {
                        cVar.f252103s = cVar.f252106v;
                    } else {
                        cVar.f252101q = com.tencent.mobileqq.mutualmark.b.a(qQAppInterface, str, dVar.f252109a, dVar.f252110b);
                    }
                }
                o(cVar);
                arrayList2.add(cVar);
            }
        }
        return arrayList2;
    }

    public static com.tencent.mobileqq.mutualmark.info.c h(QQAppInterface qQAppInterface, String str, long j3, boolean z16) {
        FriendsManager friendsManager;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)) == null) {
            return null;
        }
        if (friendsManager.E(false)) {
            QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo disableReactive: true , mutualmark switch is close");
            return null;
        }
        if (!friendsManager.e0(str)) {
            QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo fm.isFriendJustInCache: " + str + " == false");
            return null;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "MutualMarkDataCenter");
        if (intimateSimpleInfoWithUid == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getMutualMarkDisplayInfo extensionInfo == null, queryDBIfNotInCache == " + z16);
            }
            return null;
        }
        com.tencent.mobileqq.mutualmark.info.c f16 = f(qQAppInterface, str, intimateSimpleInfoWithUid, j3);
        if (f16 == null) {
            return null;
        }
        return f16;
    }

    private static com.tencent.mobileqq.mutualmark.info.d i(QQAppInterface qQAppInterface, String str, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, long j3) {
        com.tencent.mobileqq.mutualmark.info.d dVar = null;
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && aVar != null) {
            if (g.o(j3)) {
                com.tencent.mobileqq.mutualmark.info.f fVar = new com.tencent.mobileqq.mutualmark.info.f(aVar);
                ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    dVar = fVar.f252151a.get(Long.valueOf(j3));
                    if (dVar == null && QLog.isDevelopLevel()) {
                        QLog.i("MutualMarkDataCenter", 1, "getMutualMarkInfo# extensionMutualMarkData.mutualMarks.get(type), " + j3 + ", mutualMarkInfo == null");
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.i("MutualMarkDataCenter", 1, "getMutualMarkInfo# extensionInfo.getBusinessData(ExtensionMutualMarkData.class), " + j3 + ", extensionMutualMarkData = " + fVar);
                }
            } else if (g.n(j3)) {
                if (com.tencent.mobileqq.activity.aio.intimate.e.e(j3)) {
                    if (aVar.j() == j3 && aVar.f() >= 0 && aVar.f() <= 2) {
                        dVar = new com.tencent.mobileqq.mutualmark.info.d();
                        dVar.f252109a = aVar.j();
                        dVar.f252110b = aVar.f();
                        if (aVar.o().booleanValue()) {
                            dVar.f252115g = 1L;
                        }
                        dVar.f252113e = aVar.k();
                        dVar.f252112d = aVar.e();
                    }
                } else if (QLog.isDevelopLevel()) {
                    QLog.i("MutualMarkDataCenter", 1, "getMutualMarkInfo# IntimateUtil.isFriendIntimateType(type)=false, " + j3);
                }
            }
        }
        return dVar;
    }

    public static ArrayList<SingleLineTextView.IconDrawableInfo> j(QQAppInterface qQAppInterface, String str, ArrayList<com.tencent.mobileqq.mutualmark.info.c> arrayList) {
        ArrayList<SingleLineTextView.IconDrawableInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb5 = new StringBuilder("uin " + str);
            Iterator<com.tencent.mobileqq.mutualmark.info.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.mutualmark.info.c next = it.next();
                SingleLineTextView.IconDrawableInfo iconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
                iconDrawableInfo.iconResId = next.f252101q;
                iconDrawableInfo.icon_static_url = next.f252103s;
                iconDrawableInfo.iconUrl = next.f252106v;
                iconDrawableInfo.markVersion = next.f252107w;
                if (TextUtils.isEmpty(next.f252102r)) {
                    com.tencent.mobileqq.mutualmark.alienation.f.i().g(str, next);
                }
                if (!TextUtils.isEmpty(next.f252102r)) {
                    iconDrawableInfo.iconDynamicUrl = next.f252102r;
                }
                iconDrawableInfo.icon_status_alpha = next.a();
                arrayList2.add(iconDrawableInfo);
                sb5.append(" ");
                sb5.append(iconDrawableInfo);
            }
            if (QLog.isDevelopLevel()) {
                QLog.e("MutualMarkDataCenter", 1, sb5);
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.i("MutualMarkDataCenter", 1, "getRecentListIconDrawableInfos mutualMarkInfos: null");
        }
        return arrayList2;
    }

    public static ArrayList<com.tencent.mobileqq.mutualmark.info.c> k(QQAppInterface qQAppInterface, String str, int i3) {
        boolean E;
        String str2;
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            return null;
        }
        if (i3 != 2 && i3 != 1) {
            E = friendsManager.E(false);
        } else {
            E = friendsManager.E(true);
        }
        if (E | ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getDisableInteractiveSwitchLocal()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "getFriendMutualMarks disableReactive: true , mutualmark switch is close");
            }
            return null;
        }
        String uidFromUin = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            return null;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "MutualMarkDataCenter");
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "MutualMarkDataCenter");
        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() < 0) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MutualMarkDataCenter", 1, "ntSimpleInfo is not friend");
            }
            return null;
        }
        if (intimateSimpleInfoWithUid != null) {
            str2 = intimateSimpleInfoWithUid.m();
        } else {
            str2 = "";
        }
        return g(qQAppInterface, str, str2);
    }

    public static boolean l(QQAppInterface qQAppInterface, String str, boolean z16) {
        ArrayList<com.tencent.mobileqq.mutualmark.info.c> d16 = d(qQAppInterface, str, z16, 0);
        if (d16 == null || d16.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void m(QQAppInterface qQAppInterface, String str, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, long j3) {
        ArrayList<com.tencent.mobileqq.mutualmark.info.b> d16;
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && aVar != null && i(qQAppInterface, str, aVar, j3) != null && (d16 = MutualMarkConfProcessor.a().d(j3)) != null && !d16.isEmpty()) {
            Iterator<com.tencent.mobileqq.mutualmark.info.b> it = d16.iterator();
            while (it.hasNext()) {
                n(qQAppInterface, str, aVar, it.next().f252068a);
            }
        }
    }

    public static void n(QQAppInterface qQAppInterface, String str, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, long j3) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && aVar != null) {
            if (g.o(j3)) {
                com.tencent.mobileqq.mutualmark.info.f fVar = new com.tencent.mobileqq.mutualmark.info.f(aVar);
                ConcurrentHashMap<Long, com.tencent.mobileqq.mutualmark.info.d> concurrentHashMap = fVar.f252151a;
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    fVar.f252151a.remove(Long.valueOf(j3));
                }
                fVar.a(aVar);
                return;
            }
            if (g.n(j3) && com.tencent.mobileqq.activity.aio.intimate.e.e(j3) && aVar.j() == j3) {
                aVar.v(0);
                aVar.u(0);
                aVar.t(0);
                aVar.w(0L);
                aVar.r(Boolean.FALSE);
            }
        }
    }

    private static void o(com.tencent.mobileqq.mutualmark.info.c cVar) {
        if (!TextUtils.isEmpty(cVar.f252106v)) {
            cVar.f252106v = g.r(cVar.f252106v);
        }
        if (cVar.f252107w == 0 && !TextUtils.isEmpty(cVar.f252103s)) {
            cVar.f252103s = g.r(cVar.f252103s);
        }
        if (!TextUtils.isEmpty(cVar.f252102r)) {
            cVar.f252102r = g.r(cVar.f252102r);
        }
    }
}
