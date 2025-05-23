package com.tencent.mobileqq.troop.filemanager.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileSearchManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile TroopFileSearchManager f295775c;

    /* renamed from: a, reason: collision with root package name */
    protected List<j> f295776a;

    /* renamed from: b, reason: collision with root package name */
    protected List<e> f295777b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class RunnableForSearchData implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Context f295778d;

        /* renamed from: e, reason: collision with root package name */
        private QQAppInterface f295779e;

        /* renamed from: f, reason: collision with root package name */
        private long f295780f;

        /* renamed from: h, reason: collision with root package name */
        private a f295781h;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager$RunnableForSearchData$a$a, reason: collision with other inner class name */
            /* loaded from: classes19.dex */
            class C8689a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ List f295783a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Map f295784b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ List f295785c;

                C8689a(List list, Map map, List list2) {
                    this.f295783a = list;
                    this.f295784b = map;
                    this.f295785c = list2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, a.this, list, map, list2);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar) {
                    Object valueOf;
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onQueryResult FriendDetailInfo success code is ");
                    if (eVar == null) {
                        valueOf = "";
                    } else {
                        valueOf = Integer.valueOf(eVar.a());
                    }
                    sb5.append(valueOf);
                    QLog.d("fileManagerTroopFileSearchManager", 1, sb5.toString());
                    if (eVar != null && eVar.a() == 0) {
                        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = eVar.b().iterator();
                        while (it.hasNext()) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
                            List list = this.f295783a;
                            Context context = RunnableForSearchData.this.f295778d;
                            QQAppInterface qQAppInterface = RunnableForSearchData.this.f295779e;
                            if (next.n().byteValue() == 1) {
                                str = RunnableForSearchData.this.f295778d.getResources().getString(R.string.f173238ia0);
                            } else {
                                str = (String) this.f295784b.get(next.getUid());
                            }
                            list.add(new com.tencent.mobileqq.search.c(context, qQAppInterface, next, str, 0L, RunnableForSearchData.this.f295780f));
                            this.f295785c.add(new e(RunnableForSearchData.this.f295778d, next.x(), next.p(), next.r()));
                        }
                        this.f295783a.add(new com.tencent.mobileqq.search.c(RunnableForSearchData.this.f295778d, RunnableForSearchData.this.f295779e, new com.tencent.qqnt.ntrelation.friendsinfo.bean.c(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(RunnableForSearchData.this.f295779e.getCurrentAccountUin()), RunnableForSearchData.this.f295779e.getCurrentAccountUin(), RunnableForSearchData.this.f295779e.getCurrentNickname(), "", 10, 0, false), RunnableForSearchData.this.f295778d.getResources().getString(R.string.f173238ia0), 0L, RunnableForSearchData.this.f295780f));
                    }
                    if (RunnableForSearchData.this.f295781h != null) {
                        QLog.i("fileManagerTroopFileSearchManager", 1, "suc, inputSetFriends.size: " + this.f295783a.size() + " troopFileFriends.size(): " + this.f295785c.size());
                        RunnableForSearchData.this.f295781h.a(new ArrayList(this.f295783a));
                    }
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableForSearchData.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar == null) {
                    QLog.e("fileManagerTroopFileSearchManager", 1, "onQueryResult responseData == null");
                    return;
                }
                QLog.d("fileManagerTroopFileSearchManager", 1, "onQueryResult CategoryInfo success code is " + eVar.a());
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (eVar.a() == 0) {
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
                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsDetailInfoWithUid(arrayList3, "TroopFileSearchManager", new C8689a(arrayList, hashMap, arrayList2));
                } else if (RunnableForSearchData.this.f295781h != null) {
                    QLog.e("fileManagerTroopFileSearchManager", 1, "error, inputSetFriends.size: " + arrayList.size() + " troopFileFriends.size(): " + arrayList2.size());
                    RunnableForSearchData.this.f295781h.a(new ArrayList(arrayList));
                }
                TroopFileSearchManager troopFileSearchManager = TroopFileSearchManager.this;
                troopFileSearchManager.f295776a = arrayList;
                troopFileSearchManager.f295777b = arrayList2;
            }
        }

        public RunnableForSearchData(Context context, QQAppInterface qQAppInterface, long j3, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileSearchManager.this, context, qQAppInterface, Long.valueOf(j3), aVar);
                return;
            }
            this.f295778d = context;
            this.f295779e = qQAppInterface;
            this.f295780f = j3;
            this.f295781h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(false, "fileManagerTroopFileSearchManager", false, new a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(List<j> list);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f295775c = null;
        }
    }

    TroopFileSearchManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f295776a = null;
            this.f295777b = null;
        }
    }

    public static ArrayList<Long> a(List<? extends l> list) {
        if (list != null) {
            int size = list.size();
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = list.get(i3);
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
        return null;
    }

    public static final int c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String i3 = i(str);
        if (TextUtils.isEmpty(i3)) {
            return 0;
        }
        String i16 = i(str3);
        String i17 = i(str4);
        String i18 = i(str5);
        String i19 = i(str6);
        String i26 = i(str7);
        String i27 = i(str8);
        if (i(str2).contains(i3)) {
            return 7;
        }
        if (!TextUtils.isEmpty(i19) && i19.contains(i3)) {
            return 4;
        }
        if (i16.contains(i3)) {
            return 1;
        }
        if (i26.contains(i3)) {
            return 5;
        }
        if (i27.contains(i3)) {
            return 6;
        }
        if (!i17.contains(i3) && !i18.contains(i3)) {
            return 0;
        }
        return 2;
    }

    public static TroopFileSearchManager e() {
        if (f295775c == null) {
            synchronized (TroopFileSearchManager.class) {
                if (f295775c == null) {
                    f295775c = new TroopFileSearchManager();
                }
            }
        }
        return f295775c;
    }

    public static final String f(String str, String str2, String str3, int i3) {
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

    private static String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.trim().toLowerCase();
    }

    public final com.tencent.mobileqq.search.c b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.search.c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        List<j> list = this.f295776a;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.f295776a.get(i3);
            if ((jVar instanceof com.tencent.mobileqq.search.c) && str.equals(jVar.d())) {
                return (com.tencent.mobileqq.search.c) jVar;
            }
        }
        return null;
    }

    public String d(String str, String str2) {
        int size;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<e> list = this.f295777b;
        int i3 = 0;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        while (true) {
            if (i3 < size) {
                e eVar = this.f295777b.get(i3);
                if (eVar.f295829a.equals(str2)) {
                    str3 = e.c(str, eVar);
                    break;
                }
                i3++;
            } else {
                str3 = null;
                break;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("TroopFileSearchManager", 2, "getFriendsSearchedSet() time cost = " + (currentTimeMillis2 - currentTimeMillis) + " , hanzi = " + str3 + ", input = " + str + ", uin = " + str2);
        }
        return str3;
    }

    @SuppressLint({"UseSparseArrays"})
    public void g(Context context, QQAppInterface qQAppInterface, int i3, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, qQAppInterface, Integer.valueOf(i3), aVar);
        } else {
            ThreadManagerV2.excute(new RunnableForSearchData(context, qQAppInterface, j.M, aVar), 64, null, false);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        List<j> list = this.f295776a;
        if (list != null) {
            list.clear();
        }
        List<e> list2 = this.f295777b;
        if (list2 != null) {
            list2.clear();
        }
    }
}
