package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.af;
import com.tencent.mobileqq.search.model.ah;
import com.tencent.mobileqq.search.model.i;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.mostused.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import do2.GroupSearchModelNtTroopResult;
import do2.f;
import do2.g;
import do2.h;
import do2.j;
import do2.l;
import do2.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lo2.NetSearchTemplateUsedMiniAppItem;
import lo2.ai;
import pn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f283571a = 3;

    private static x a(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            j jVar2 = new j(new ArrayList(jVar.f394379h), jVar.getKeyword(), jVar.s());
            jVar2.j(jVar.f());
            return jVar2;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            h hVar2 = new h(new ArrayList(hVar.f394373h), hVar.getKeyword(), hVar.t());
            hVar2.j(hVar.f());
            return hVar2;
        }
        if (obj instanceof com.tencent.mobileqq.search.model.j) {
            com.tencent.mobileqq.search.model.j jVar3 = (com.tencent.mobileqq.search.model.j) obj;
            com.tencent.mobileqq.search.model.j jVar4 = new com.tencent.mobileqq.search.model.j(new ArrayList(jVar3.f283540h), jVar3.getKeyword(), jVar3.s());
            jVar4.j(jVar3.f());
            return jVar4;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            g gVar2 = new g(new ArrayList(gVar.f394370h), gVar.getKeyword(), gVar.s());
            gVar2.j(gVar.f());
            return gVar2;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            n nVar2 = new n(nVar.getFromType(), new ArrayList(nVar.o()), nVar.getKeyword(), nVar.getRecallReason());
            nVar2.j(nVar.f());
            return nVar2;
        }
        if (obj instanceof GroupSearchModelNtTroopResult) {
            GroupSearchModelNtTroopResult groupSearchModelNtTroopResult = (GroupSearchModelNtTroopResult) obj;
            GroupSearchModelNtTroopResult groupSearchModelNtTroopResult2 = new GroupSearchModelNtTroopResult(groupSearchModelNtTroopResult.getFromType(), new ArrayList(groupSearchModelNtTroopResult.o()), groupSearchModelNtTroopResult.getKeyword(), groupSearchModelNtTroopResult.getRecallReason());
            groupSearchModelNtTroopResult2.j(groupSearchModelNtTroopResult.f());
            return groupSearchModelNtTroopResult2;
        }
        return null;
    }

    public static boolean b(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(List list, String str) {
        int i3;
        int i16;
        ArrayList arrayList;
        lo2.b bVar;
        int i17;
        int i18;
        ac acVar;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity;
        if (list != null && list.size() != 0) {
            ArrayList<String> g16 = g(list);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            lo2.b bVar2 = null;
            ac acVar2 = null;
            lo2.ac acVar3 = null;
            lo2.b bVar3 = null;
            lo2.b bVar4 = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                Object obj = list.get(size);
                if (obj instanceof i) {
                    x v3 = ((i) obj).v();
                    boolean z16 = v3 instanceof lo2.b;
                    if (z16) {
                        lo2.b bVar5 = (lo2.b) v3;
                        acVar = acVar2;
                        if (bVar5.D == 1701) {
                            list.remove(size);
                            bVar3 = bVar5;
                        }
                    } else {
                        acVar = acVar2;
                    }
                    if (z16) {
                        lo2.b bVar6 = (lo2.b) v3;
                        if (bVar6.D == Constant.FROM_ID_START_ACTIVITY) {
                            list.remove(size);
                            bVar4 = bVar6;
                        }
                    }
                    if (z16) {
                        lo2.b bVar7 = (lo2.b) v3;
                        if (bVar7.D == 1105) {
                            list.remove(size);
                            bVar2 = bVar7;
                        }
                    }
                } else {
                    acVar = acVar2;
                    if (obj instanceof f) {
                        long j3 = ((f) obj).F;
                        if (j3 == 1701 || j3 == Constant.FROM_ID_START_ACTIVITY) {
                            list.remove(size);
                        }
                    }
                    if (obj instanceof ah) {
                        ah ahVar = (ah) obj;
                        up2.a aVar = ahVar.f283512b0;
                        if (aVar != null && (miniAppLocalSearchEntity = aVar.X) != null) {
                            String str2 = miniAppLocalSearchEntity.appId;
                            list.remove(size);
                            if (!b(str2, g16)) {
                                if (ahVar.f283513c0) {
                                    arrayList2.add(0, ahVar);
                                } else {
                                    arrayList3.add(0, ahVar);
                                }
                            }
                        }
                    } else if (obj instanceof ai) {
                        ai aiVar = (ai) obj;
                        if (aiVar.J == Constant.FROM_ID_START_ACTIVITY) {
                            list.remove(size);
                            if (aiVar.O() && arrayList4.size() == 0) {
                                arrayList4.add(0, aiVar);
                                com.tencent.mobileqq.search.report.b.e(null, 0, aiVar.R, "0X800AC11", 0, 0, "", "");
                            } else {
                                arrayList5.add(0, aiVar);
                            }
                        }
                    } else if (obj instanceof ac) {
                        list.remove(size);
                        acVar2 = (ac) obj;
                    } else if (obj instanceof lo2.ac) {
                        list.remove(size);
                        acVar3 = (lo2.ac) obj;
                    }
                }
                acVar2 = acVar;
            }
            ac acVar4 = acVar2;
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < list.size(); i27++) {
                Object obj2 = list.get(i27);
                boolean z17 = obj2 instanceof l;
                if (z17) {
                    i19 = i27 + 1;
                }
                if ((((obj2 instanceof g) && j((g) obj2, str)) || z17 || (obj2 instanceof h) || (obj2 instanceof com.tencent.mobileqq.search.model.j) || (obj2 instanceof c)) && i26 <= i27) {
                    i26 = i27 + 1;
                }
            }
            if (arrayList2.size() > 0) {
                i16 = 0;
                arrayList = arrayList5;
                bVar = bVar2;
                d(list, i19, arrayList2, bVar3, false, f283571a, true);
                int size2 = arrayList2.size() + i26 + 1;
                if (list.size() >= size2) {
                    i3 = 2;
                    QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF MINI");
                    i17 = size2;
                    if (arrayList3.size() > 0) {
                        d(list, i17, arrayList3, bVar3, true, f283571a, false);
                    }
                    int i28 = i16;
                    i18 = i28;
                    int i29 = i18;
                    while (i18 < list.size()) {
                        Object obj3 = list.get(i18);
                        boolean z18 = obj3 instanceof l;
                        if (z18 || (((obj3 instanceof ah) && ((ah) obj3).f283513c0) || ((obj3 instanceof g) && j((g) obj3, str)))) {
                            i28 = i18 + 1;
                        }
                        if (((obj3 instanceof g) || z18 || (obj3 instanceof h) || (obj3 instanceof com.tencent.mobileqq.search.model.j) || (obj3 instanceof c) || (obj3 instanceof ah) || (obj3 instanceof do2.i) || (obj3 instanceof com.tencent.mobileqq.search.ftsmsg.a) || (obj3 instanceof af)) && i29 <= i18) {
                            i29 = i18 + 1;
                        }
                        i18++;
                    }
                    if (arrayList4.size() > 0) {
                        d(list, i28, arrayList4, bVar4, false, f283571a, true);
                        int size3 = arrayList4.size() + i29 + 1;
                        if (list.size() >= size3) {
                            QLog.e("MostUsedFilterForMultiGroupResultLists", i3, "OUT OF INDEX OF PUBLLIC");
                            i29 = size3;
                        }
                    }
                    if (acVar4 == null) {
                        list.add(i29, acVar4);
                        i iVar = new i((x) bVar, true, bVar.N);
                        iVar.j(acVar4.f());
                        list.add(i29, iVar);
                    } else {
                        if (acVar3 != null) {
                            list.add(i29, acVar3);
                            i iVar2 = new i((x) bVar, true, bVar.N);
                            iVar2.j(acVar3.f());
                            list.add(i29, iVar2);
                        }
                        int i36 = i29;
                        if (arrayList.size() > 0) {
                            d(list, i36, arrayList, bVar4, true, f283571a, false);
                            return;
                        }
                        return;
                    }
                    i29 += 2;
                    int i362 = i29;
                    if (arrayList.size() > 0) {
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 2;
                i16 = 0;
                arrayList = arrayList5;
                bVar = bVar2;
            }
            i17 = i26;
            if (arrayList3.size() > 0) {
            }
            int i282 = i16;
            i18 = i282;
            int i292 = i18;
            while (i18 < list.size()) {
            }
            if (arrayList4.size() > 0) {
            }
            if (acVar4 == null) {
            }
            i292 += 2;
            int i3622 = i292;
            if (arrayList.size() > 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(List list, int i3, List<y> list2, lo2.b bVar, boolean z16, int i16, boolean z17) {
        int i17;
        boolean z18;
        int i18;
        lo2.b bVar2;
        List<y> list3;
        String str;
        int i19;
        boolean z19;
        if (list != null && list2 != null && list2.size() != 0) {
            if (list.size() < i3) {
                int size = list.size();
                QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " INDEX OUT OF RANGE");
                i17 = size;
            } else {
                i17 = i3;
            }
            QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "addListAndTitleToIndex " + list2.size());
            if (i16 > 0 && list2.size() > i16) {
                for (int size2 = list2.size() - 1; size2 >= i16; size2--) {
                    list2.remove(size2);
                }
                z18 = true;
            } else {
                z18 = false;
            }
            if (bVar != null) {
                i18 = i17;
                list3 = list2;
                bVar2 = new lo2.b(bVar.getKeyword(), bVar.D, bVar.l(), list2, list2.size(), bVar.x(), bVar.w(), bVar.L, bVar.M, bVar.N, bVar.P, bVar.J, bVar.K);
                str = "MostUsedFilterForMultiGroupResultLists";
                i19 = 2;
            } else {
                i18 = i17;
                bVar2 = new lo2.b();
                list3 = list2;
                bVar2.F = list3;
                str = "MostUsedFilterForMultiGroupResultLists";
                i19 = 2;
                QLog.e(str, 2, "oldTitleGroupMode is empty");
            }
            if (z16 && z18) {
                if (!TextUtils.isEmpty(bVar2.x())) {
                    z19 = true;
                    if (list2.size() <= 0) {
                        for (int size3 = list2.size() - 1; size3 >= 0; size3--) {
                            list.add(i18, list3.get(size3));
                        }
                        int i26 = i18;
                        int f16 = list3.get(0).f();
                        i iVar = new i(bVar2, z19, bVar2.N);
                        iVar.j(f16);
                        bVar2.j(f16);
                        if (z17) {
                            iVar.J = true;
                        }
                        list.add(i26, iVar);
                        return;
                    }
                    return;
                }
                QLog.e(str, i19, "newModel.getMoreUrl() is empty");
            }
            z19 = false;
            if (list2.size() <= 0) {
            }
        } else {
            QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " no list to add");
        }
    }

    private static boolean e(a.c cVar, x xVar) {
        int f16;
        if (xVar == null || (f16 = f(cVar, xVar.o())) < 0) {
            return false;
        }
        xVar.o().remove(f16);
        return true;
    }

    private static int f(a.c cVar, List<y> list) {
        int i3;
        if (list == null || list.size() == 0) {
            return -1;
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            y yVar = list.get(i16);
            String str = "";
            if (yVar instanceof k) {
                k kVar = (k) yVar;
                if (kVar.getUin() instanceof String) {
                    str = (String) kVar.getUin();
                }
                i3 = kVar.H();
            } else if (yVar instanceof lo2.c) {
                lo2.c cVar2 = (lo2.c) yVar;
                str = cVar2.K();
                i3 = cVar2.L();
            } else {
                QLog.e("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "unknown type extends ISearchResultModel");
                i3 = -1;
            }
            if (str.equals(cVar.f283566a.identify) && i3 == cVar.f283566a.identifyType) {
                cVar.f283569d = true;
                cVar.f283567b = yVar;
                QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
                return i16;
            }
        }
        return -1;
    }

    private static ArrayList<String> g(List list) {
        l lVar;
        List<y> o16;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity;
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (next instanceof l) {
                    lVar = (l) next;
                    break;
                }
            } else {
                lVar = null;
                break;
            }
        }
        if (lVar != null && (o16 = lVar.o()) != null && o16.size() > 0) {
            for (y yVar : o16) {
                if (yVar != null && (yVar instanceof up2.a) && (miniAppLocalSearchEntity = ((up2.a) yVar).X) != null && (str = miniAppLocalSearchEntity.appId) != null && !TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static int h(x xVar) {
        if (xVar instanceof j) {
            return 2;
        }
        if ((xVar instanceof h) || (xVar instanceof com.tencent.mobileqq.search.model.j) || (xVar instanceof n) || (xVar instanceof GroupSearchModelNtTroopResult)) {
            return 1;
        }
        if (xVar instanceof g) {
            return 3;
        }
        return 0;
    }

    private static boolean i(List<y> list, NetSearchTemplateUsedMiniAppItem netSearchTemplateUsedMiniAppItem) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            y yVar = list.get(i3);
            if (yVar instanceof up2.a) {
                MiniAppLocalSearchEntity miniAppLocalSearchEntity = ((up2.a) yVar).X;
                if (TextUtils.equals(miniAppLocalSearchEntity.appId, netSearchTemplateUsedMiniAppItem.b0().appId) && TextUtils.equals(miniAppLocalSearchEntity.appName, netSearchTemplateUsedMiniAppItem.b0().appName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean j(g gVar, String str) {
        List<y> list;
        if (gVar == null || (list = gVar.f394370h) == null || list.size() <= 0 || !(gVar.f394370h.get(0) instanceof lo2.c) || !((lo2.c) gVar.f394370h.get(0)).I.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean k(int i3, List<v> list) {
        if (i3 > 0 && (list.get(i3 - 1) instanceof i)) {
            if (i3 == list.size() - 1 || (list.get(i3 + 1) instanceof i)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static ArrayList l(String str, ArrayList<a.c> arrayList, List list) {
        boolean z16;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                Object obj = list.get(i3);
                x a16 = a(obj);
                if (a16 != null) {
                    arrayList2.add(a16);
                } else {
                    arrayList2.add(obj);
                }
                QLog.d("MostUsedFilterForMultiGroupResultListsMostUsed", 2, "the i name " + arrayList2.get(i3).getClass().getName());
            }
            ArrayList arrayList3 = new ArrayList();
            int i16 = 0;
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                a.c cVar = arrayList.get(i17);
                for (int i18 = 0; i18 < arrayList2.size(); i18++) {
                    if (arrayList2.get(i18) instanceof x) {
                        int h16 = h((x) arrayList2.get(i18));
                        if (h16 != 0 && cVar.f283566a.businessType == h16) {
                            z16 = e(cVar, (x) arrayList2.get(i18));
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    }
                }
                if (cVar.f283569d) {
                    y yVar = cVar.f283567b;
                    if (yVar instanceof k) {
                        ((k) yVar).Q(cVar.f283566a.searchKey);
                    }
                    y yVar2 = cVar.f283567b;
                    if (yVar2 instanceof lo2.c) {
                        ((lo2.c) yVar2).U(cVar.f283566a.searchKey);
                    }
                    y yVar3 = cVar.f283567b;
                    if (yVar3 instanceof z) {
                        ((z) yVar3).E(true);
                    }
                    arrayList3.add(cVar.f283567b);
                    i16++;
                    if (i16 == 3) {
                        break;
                    }
                }
            }
            n(arrayList2);
            if (i16 > 0) {
                l lVar = new l(arrayList3, str);
                i iVar = new i((x) lVar, lVar.l(), false);
                int s16 = SearchUtil.s();
                lVar.j(s16);
                iVar.j(s16);
                arrayList2.add(0, lVar);
                arrayList2.add(0, iVar);
                QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "add GroupSearchModelMostUsed");
            }
            QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "the finish Wash orgList size " + list.size() + " match mostUsedList size:" + arrayList.size() + " resultlist " + arrayList2.size());
            return arrayList2;
        }
        return new ArrayList(list);
    }

    public static ArrayList<v> m(List<y> list, List<v> list2) {
        if (list != null && !list.isEmpty()) {
            ArrayList<v> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < list2.size(); i3++) {
                v vVar = list2.get(i3);
                if (vVar instanceof NetSearchTemplateUsedMiniAppItem) {
                    NetSearchTemplateUsedMiniAppItem netSearchTemplateUsedMiniAppItem = (NetSearchTemplateUsedMiniAppItem) vVar;
                    if (i(list, netSearchTemplateUsedMiniAppItem)) {
                        QLog.d("MostUsedFilterForMultiGroupResultLists", 1, "mergeMostUsedAndNetList find mostused mini item " + netSearchTemplateUsedMiniAppItem.b0().appName);
                        if (k(i3, list2) && !arrayList.isEmpty()) {
                            arrayList.remove(arrayList.size() - 1);
                            QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "mergeMostUsedAndNetList remove mini title");
                        }
                    }
                }
                arrayList.add(vVar);
            }
            QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "mergeMostUsedAndNetList originListSize=", Integer.valueOf(list2.size()), " resultList.size=", Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        return new ArrayList<>(list2);
    }

    public static boolean n(ArrayList arrayList) {
        int i3;
        boolean z16;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        int size = arrayList.size() - 1;
        boolean z17 = false;
        while (size >= 0) {
            if (arrayList.get(size) instanceof x) {
                x xVar = (x) arrayList.get(size);
                if (xVar.o() != null && xVar.o().size() == 0) {
                    int i16 = size - 1;
                    if (i16 >= 0 && (arrayList.get(i16) instanceof i) && ((i) arrayList.get(i16)).l().equals(xVar.l())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    arrayList.remove(size);
                    if (z16) {
                        arrayList.remove(i16);
                        size = i16;
                    }
                    z17 = true;
                } else if (h(xVar) != 0 && size - 1 >= 0 && (arrayList.get(i3) instanceof i) && ((i) arrayList.get(i3)).l().equals(xVar.l())) {
                    i iVar = (i) arrayList.get(i3);
                    if (iVar.v() != null && xVar.o() != null && iVar.v().o() != null && iVar.v().o().size() != xVar.o().size()) {
                        QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                        arrayList.remove(i3);
                        i iVar2 = new i(xVar);
                        iVar2.j(xVar.f());
                        arrayList.add(i3, iVar2);
                    }
                }
            }
            size--;
        }
        return z17;
    }
}
