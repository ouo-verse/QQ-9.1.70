package com.tencent.mobileqq.troop.file.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class TroopFileSearchManager {

    /* renamed from: c, reason: collision with root package name */
    private static volatile TroopFileSearchManager f295433c;

    /* renamed from: a, reason: collision with root package name */
    protected List<com.tencent.mobileqq.search.j> f295434a = null;

    /* renamed from: b, reason: collision with root package name */
    protected List<p> f295435b = null;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class RunnableForSearchData implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private Context f295436d;

        /* renamed from: e, reason: collision with root package name */
        private QQAppInterface f295437e;

        /* renamed from: f, reason: collision with root package name */
        private long f295438f;

        /* renamed from: h, reason: collision with root package name */
        private a f295439h;

        /* compiled from: P */
        /* loaded from: classes35.dex */
        class a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
            a() {
            }

            @Override // hx3.b
            public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                Object valueOf;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onQueryResult troopPlugin CategoryInfo success code is ");
                if (eVar == null) {
                    valueOf = "";
                } else {
                    valueOf = Integer.valueOf(eVar.a());
                }
                sb5.append(valueOf);
                QLog.d("troopPluginTroopFileSearchManager", 1, sb5.toString());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (eVar == null || eVar.a() != 0) {
                    if (RunnableForSearchData.this.f295439h != null) {
                        QLog.e("troopPluginTroopFileSearchManager", 1, "error, inputSetFriends.size: " + arrayList.size() + " troopFileFriends.size(): " + arrayList2.size());
                        RunnableForSearchData.this.f295439h.a(new ArrayList(arrayList));
                    }
                } else {
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    HashMap hashMap = new HashMap();
                    Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> it = eVar.b().iterator();
                    while (it.hasNext()) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.b next = it.next();
                        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = next.b().iterator();
                        while (it5.hasNext()) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d next2 = it5.next();
                            arrayList3.add(next2.getUid());
                            hashMap.put(next2.getUid(), next.f());
                        }
                    }
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(arrayList3, "TroopFileSearchManager", new C8683a(arrayList, hashMap, arrayList2));
                }
                TroopFileSearchManager troopFileSearchManager = TroopFileSearchManager.this;
                troopFileSearchManager.f295434a = arrayList;
                troopFileSearchManager.f295435b = arrayList2;
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.troop.file.data.TroopFileSearchManager$RunnableForSearchData$a$a, reason: collision with other inner class name */
            /* loaded from: classes35.dex */
            class C8683a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ List f295441a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Map f295442b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ List f295443c;

                C8683a(List list, Map map, List list2) {
                    this.f295441a = list;
                    this.f295442b = map;
                    this.f295443c = list2;
                }

                @Override // hx3.b
                public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                    Object valueOf;
                    String str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onQueryResult troopPlugin FriendDetailInfo success code is ");
                    if (eVar == null) {
                        valueOf = "";
                    } else {
                        valueOf = Integer.valueOf(eVar.a());
                    }
                    sb5.append(valueOf);
                    QLog.d("troopPluginTroopFileSearchManager", 1, sb5.toString());
                    if (eVar != null && eVar.a() == 0) {
                        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = eVar.b().iterator();
                        while (it.hasNext()) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
                            List list = this.f295441a;
                            Context context = RunnableForSearchData.this.f295436d;
                            QQAppInterface qQAppInterface = RunnableForSearchData.this.f295437e;
                            if (next.n().byteValue() == 1) {
                                str = RunnableForSearchData.this.f295436d.getResources().getString(R.string.f173238ia0);
                            } else {
                                str = (String) this.f295442b.get(next.getUid());
                            }
                            list.add(new com.tencent.mobileqq.search.c(context, qQAppInterface, next, str, 0L, RunnableForSearchData.this.f295438f));
                            this.f295443c.add(new p(RunnableForSearchData.this.f295436d, next.x(), next.p(), next.r()));
                        }
                        this.f295441a.add(new com.tencent.mobileqq.search.c(RunnableForSearchData.this.f295436d, RunnableForSearchData.this.f295437e, new com.tencent.qqnt.ntrelation.friendsinfo.bean.c(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(RunnableForSearchData.this.f295437e.getCurrentAccountUin()), RunnableForSearchData.this.f295437e.getCurrentAccountUin(), RunnableForSearchData.this.f295437e.getCurrentNickname(), "", 10, 0, false), RunnableForSearchData.this.f295436d.getResources().getString(R.string.f173238ia0), 0L, RunnableForSearchData.this.f295438f));
                    }
                    if (RunnableForSearchData.this.f295439h != null) {
                        QLog.i("troopPluginTroopFileSearchManager", 1, "onQueryResult, inputSetFriends.size: " + this.f295441a.size() + " troopFileFriends.size(): " + this.f295443c.size());
                        RunnableForSearchData.this.f295439h.a(new ArrayList(this.f295441a));
                    }
                }
            }
        }

        public RunnableForSearchData(Context context, QQAppInterface qQAppInterface, long j3, a aVar) {
            this.f295436d = context;
            this.f295437e = qQAppInterface;
            this.f295438f = j3;
            this.f295439h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "troopPluginTroopFileSearchManager", false, new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(List<com.tencent.mobileqq.search.j> list);
    }

    TroopFileSearchManager() {
    }

    private static boolean a(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str2) && str2.contains(str)) || (!TextUtils.isEmpty(str3) && str3.contains(str));
    }

    private static boolean b(String str, String str2, String str3) {
        return (!TextUtils.isEmpty(str2) && str2.contains(str)) || (!TextUtils.isEmpty(str3) && str3.contains(str));
    }

    public static final int e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String lowerCase = str == null ? "" : str.trim().toLowerCase();
        if (TextUtils.isEmpty(lowerCase)) {
            return 0;
        }
        String lowerCase2 = str3 == null ? null : str3.trim().toLowerCase();
        String lowerCase3 = str4 == null ? null : str4.trim().toLowerCase();
        String lowerCase4 = str5 == null ? null : str5.trim().toLowerCase();
        String lowerCase5 = str6 == null ? null : str6.trim().toLowerCase();
        String lowerCase6 = str7 == null ? null : str7.trim().toLowerCase();
        String lowerCase7 = str8 == null ? null : str8.trim().toLowerCase();
        String lowerCase8 = str2 != null ? str2.trim().toLowerCase() : null;
        if (!TextUtils.isEmpty(lowerCase8) && lowerCase8.contains(lowerCase)) {
            return 7;
        }
        if (!TextUtils.isEmpty(lowerCase5) && lowerCase5.contains(lowerCase)) {
            return 4;
        }
        if (!TextUtils.isEmpty(lowerCase2) && lowerCase2.contains(lowerCase)) {
            return 1;
        }
        if (!TextUtils.isEmpty(lowerCase6) && lowerCase6.contains(lowerCase)) {
            return 5;
        }
        if (!TextUtils.isEmpty(lowerCase7) && lowerCase7.contains(lowerCase)) {
            return 6;
        }
        if (a(lowerCase, lowerCase3, lowerCase4)) {
            return 2;
        }
        return b(lowerCase, lowerCase3, lowerCase4) ? 3 : 0;
    }

    public static TroopFileSearchManager g() {
        if (f295433c == null) {
            synchronized (TroopFileSearchManager.class) {
                if (f295433c == null) {
                    f295433c = new TroopFileSearchManager();
                }
            }
        }
        return f295433c;
    }

    public static final String h(String str, String str2, String str3, int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return str2;
        }
        if (i3 == 4 || i3 == 5 || i3 == 6) {
            return str3;
        }
        if (i3 != 7) {
            return null;
        }
        return str;
    }

    public final com.tencent.mobileqq.search.c d(String str) {
        List<com.tencent.mobileqq.search.j> list = this.f295434a;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.search.j jVar = this.f295434a.get(i3);
            if ((jVar instanceof com.tencent.mobileqq.search.c) && str.equals(jVar.d())) {
                return (com.tencent.mobileqq.search.c) jVar;
            }
        }
        return null;
    }

    public String f(String str, String str2) {
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        List<p> list = this.f295435b;
        int i3 = 0;
        int size = list == null ? 0 : list.size();
        while (true) {
            if (i3 >= size) {
                str3 = null;
                break;
            }
            p pVar = this.f295435b.get(i3);
            if (pVar.f295513a.equals(str2)) {
                str3 = p.c(str, pVar);
                break;
            }
            i3++;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (currentTimeMillis2 - currentTimeMillis) + " , hanzi = " + str3 + ", input = " + str + ", uin = " + str2);
        }
        return str3;
    }

    public void i(Context context, QQAppInterface qQAppInterface, int i3, a aVar) {
        ThreadManagerV2.excute(new RunnableForSearchData(context, qQAppInterface, com.tencent.mobileqq.search.j.M, aVar), 64, null, false);
    }

    public void j() {
        List<com.tencent.mobileqq.search.j> list = this.f295434a;
        if (list != null) {
            list.clear();
        }
        List<p> list2 = this.f295435b;
        if (list2 != null) {
            list2.clear();
        }
    }

    public static ArrayList<Long> c(List<? extends com.tencent.mobileqq.search.l> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.search.l lVar = list.get(i3);
            if (lVar instanceof com.tencent.mobileqq.search.c) {
                com.tencent.mobileqq.search.c cVar = (com.tencent.mobileqq.search.c) lVar;
                try {
                    if (cVar.m() != 0 && cVar.m() != 3) {
                        arrayList.add(Long.valueOf(Long.parseLong(cVar.d())));
                    }
                } catch (NullPointerException e16) {
                    e16.printStackTrace();
                } catch (NumberFormatException e17) {
                    e17.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
