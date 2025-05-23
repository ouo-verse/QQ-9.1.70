package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import com.tencent.shadow.dynamic.host.Constant;
import do2.GroupSearchModelNtTroopResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<Integer> f285036a = new HashSet<>(Arrays.asList(1000000, 1117));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f285037a;

        /* renamed from: b, reason: collision with root package name */
        int f285038b;

        public a(int i3, int i16) {
            this.f285037a = i3;
            this.f285038b = i16;
        }
    }

    private void a(List<com.tencent.mobileqq.search.model.v> list) {
        ArrayList arrayList;
        if (list != null && list.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int i3 = 0;
            while (i3 < list.size()) {
                com.tencent.mobileqq.search.model.v vVar = list.get(i3);
                if (vVar instanceof lo2.am) {
                    if (((lo2.am) vVar).c0()) {
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList4;
                    }
                    if (i3 > 0) {
                        com.tencent.mobileqq.search.model.v vVar2 = list.get(i3 - 1);
                        if (vVar2 instanceof com.tencent.mobileqq.search.model.i) {
                            arrayList.add(vVar2);
                            arrayList2.remove(vVar2);
                        }
                    }
                    arrayList.add(vVar);
                    int i16 = i3 + 1;
                    if (i16 > list.size()) {
                        com.tencent.mobileqq.search.model.v vVar3 = list.get(i16);
                        if (vVar3 instanceof do2.f) {
                            arrayList.add(vVar3);
                            i3 = i16;
                        }
                    }
                } else {
                    if ((vVar instanceof lo2.e) && QLog.isColorLevel()) {
                        QLog.e("GroupSearchResultHandler", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
                    }
                    arrayList2.add(vVar);
                }
                i3++;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupSearchResultHandler", 2, "adjustRichNodePosition, total:" + list.size() + " exact:" + arrayList3.size() + " fuzzy:" + arrayList4.size() + " other:" + arrayList2.size());
            }
            if (arrayList3.size() == 0 && arrayList4.size() == 0) {
                return;
            }
            if (arrayList4.size() == 0) {
                list.clear();
                list.addAll(arrayList3);
                list.addAll(arrayList2);
                return;
            }
            list.clear();
            list.addAll(arrayList3);
            if (arrayList2.size() == 0) {
                list.addAll(arrayList4);
                return;
            }
            int d16 = d(arrayList2);
            if (QLog.isColorLevel()) {
                QLog.d("GroupSearchResultHandler", 2, "adjustRichNodePosition, fuzzy pos:" + d16);
            }
            if (d16 <= 0) {
                list.addAll(arrayList4);
                list.addAll(arrayList2);
                return;
            }
            for (int i17 = 0; i17 < d16; i17++) {
                list.add(arrayList2.get(i17));
            }
            list.addAll(arrayList4);
            while (d16 < arrayList2.size()) {
                list.add(arrayList2.get(d16));
                d16++;
            }
        }
    }

    private int d(List<com.tencent.mobileqq.search.model.v> list) {
        boolean z16;
        if (list == null) {
            return -1;
        }
        if (list.size() == 0) {
            return 0;
        }
        List<com.tencent.mobileqq.search.model.y> list2 = null;
        int i3 = 0;
        while (i3 < list.size()) {
            com.tencent.mobileqq.search.model.v vVar = list.get(i3);
            if (vVar instanceof com.tencent.mobileqq.search.model.i) {
                com.tencent.mobileqq.search.model.i iVar = (com.tencent.mobileqq.search.model.i) vVar;
                com.tencent.mobileqq.search.model.x v3 = iVar.v();
                if (v3 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GroupSearchResultHandler", 2, "getFuzzyPotision error, groupmodel is null:" + vVar);
                    }
                } else {
                    list2 = v3.o();
                    String l3 = iVar.l();
                    if (!HardCodeUtil.qqStr(R.string.n5t).equals(l3) && !HardCodeUtil.qqStr(R.string.n5q).equals(l3) && !HardCodeUtil.qqStr(R.string.n5b).equals(l3) && !do2.l.f394384m.equals(l3)) {
                        if (HardCodeUtil.qqStr(R.string.n58).equals(l3)) {
                            if ((list2 == null || list2.size() == 0) && QLog.isColorLevel()) {
                                QLog.e("GroupSearchResultHandler", 2, "getFuzzyPotision error, only has title\uff0c miniprogram");
                            }
                        } else if (!iVar.J) {
                            String c16 = nn2.a.c();
                            boolean z17 = true;
                            if (!TextUtils.isEmpty(c16) && c16.equals(iVar.l())) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                break;
                            }
                            if (list2 != null && list2.size() != 0) {
                                if (list2.get(0) instanceof lo2.c) {
                                    lo2.c cVar = (lo2.c) list2.get(0);
                                    String str = cVar.I;
                                    String keyword = cVar.getKeyword();
                                    if (TextUtils.isEmpty(str) || !str.equals(keyword)) {
                                        z17 = false;
                                    }
                                    z16 = z17;
                                }
                                if (!z16) {
                                    break;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                i3++;
            } else {
                if (!(vVar instanceof do2.f)) {
                    if (vVar instanceof pn2.c) {
                        if (!((pn2.c) vVar).J()) {
                            break;
                        }
                    } else {
                        if (!(vVar instanceof do2.l) && !(vVar instanceof do2.h) && !(vVar instanceof do2.n) && !(vVar instanceof do2.j) && !(vVar instanceof do2.g) && !(vVar instanceof com.tencent.mobileqq.search.model.j) && !(vVar instanceof GroupSearchModelNtTroopResult) && ((!(vVar instanceof lo2.ai) || !((lo2.ai) vVar).W()) && (list2 == null || !list2.contains(vVar)))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GroupSearchResultHandler", 2, "getFuzzyPotision, break:" + vVar);
                            }
                        }
                        i3++;
                    }
                }
                list2 = null;
                i3++;
            }
        }
        return i3;
    }

    private a e(List<com.tencent.mobileqq.search.model.v> list, int i3) {
        int f16 = list.get(i3).f();
        int i16 = i3;
        do {
            i16--;
            if (i16 < 0) {
                break;
            }
        } while (list.get(i16).f() == f16);
        int i17 = i16 + 1;
        do {
            i3++;
            if (i3 >= list.size()) {
                break;
            }
        } while (list.get(i3).f() == f16);
        return new a(i17, i3);
    }

    public List<com.tencent.mobileqq.search.model.v> b(List<com.tencent.mobileqq.search.model.v> list, int i3) {
        QLog.d("GroupSearchResultHandler", 1, "filterStudyModeNetworkResult");
        if (list != null && !list.isEmpty()) {
            if (i3 != 1 && i3 != 2 && i3 != 21) {
                QLog.d("GroupSearchResultHandler", 1, "filterStudyModeNetworkResult fromType pass " + i3);
                return list;
            }
            int i16 = 0;
            if (!StudyModeManager.w()) {
                if (StudyModeManager.t()) {
                    QLog.d("GroupSearchResultHandler", 1, "filterStudyModeNetworkResult studyModeSwitch(ON) BanSearchNet(OFF)");
                    ArrayList arrayList = new ArrayList();
                    while (i16 < list.size()) {
                        if (f(list.get(i16)) == 1114) {
                            a e16 = e(list, i16);
                            arrayList.addAll(list.subList(e16.f285037a, e16.f285038b));
                            i16 = e16.f285038b - 1;
                        }
                        i16++;
                    }
                    list.removeAll(arrayList);
                }
                return list;
            }
            ArrayList arrayList2 = new ArrayList();
            while (i16 < list.size()) {
                if (f285036a.contains(Integer.valueOf(f(list.get(i16))))) {
                    a e17 = e(list, i16);
                    arrayList2.addAll(list.subList(e17.f285037a, e17.f285038b));
                    i16 = e17.f285038b - 1;
                }
                i16++;
            }
            return arrayList2;
        }
        return list;
    }

    public void c(List<com.tencent.mobileqq.search.model.v> list, String str) {
        com.tencent.mobileqq.search.mostused.b.c(list, str);
        a(list);
    }

    public int f(com.tencent.mobileqq.search.model.v vVar) {
        if (vVar instanceof com.tencent.mobileqq.search.model.z) {
            if (vVar instanceof lo2.m) {
                if ((vVar instanceof lo2.am) && ((lo2.am) vVar).c0()) {
                    return UfsGROUPMASK.GROUP_MASK_PRECISE_RICH;
                }
                if ((vVar instanceof com.tencent.mobileqq.search.model.ah) && ((com.tencent.mobileqq.search.model.ah) vVar).f283513c0) {
                    return UfsGROUPMASK.GROUP_MASK_PRECISE_MINI_APP;
                }
                lo2.m mVar = (lo2.m) vVar;
                if (mVar.J == Constant.FROM_ID_START_ACTIVITY && mVar.O()) {
                    return UfsGROUPMASK.GROUP_MASK_PRECISE_OFFICIAL_ACCOUNT;
                }
                if (vVar instanceof lo2.t) {
                    return 1108;
                }
                if (vVar instanceof lo2.s) {
                    return 1109;
                }
                return (int) mVar.J;
            }
            if (vVar instanceof lo2.c) {
                lo2.c cVar = (lo2.c) vVar;
                if (cVar.J() == 268435456 && cVar.B()) {
                    return UfsGROUPMASK.GROUP_MASK_PRECISE_FEATURE;
                }
                return cVar.J();
            }
            if ((vVar instanceof pn2.c) && ((pn2.c) vVar).I == -4) {
                return UfsGROUPMASK.GROUP_MASK_TOPIC_ENTRANCE;
            }
        }
        if (vVar instanceof com.tencent.mobileqq.search.model.x) {
            if (vVar instanceof do2.l) {
                return 1200;
            }
            if ((vVar instanceof do2.h) || (vVar instanceof do2.n)) {
                return 1201;
            }
            if ((vVar instanceof com.tencent.mobileqq.search.model.j) || (vVar instanceof GroupSearchModelNtTroopResult)) {
                return 1202;
            }
            if (vVar instanceof do2.m) {
                return 1207;
            }
            if (vVar instanceof do2.j) {
                return UfsGROUPMASK.GROUP_MASK_MINI_APP;
            }
            if (vVar instanceof do2.g) {
                for (com.tencent.mobileqq.search.model.y yVar : ((do2.g) vVar).f394370h) {
                    if (yVar instanceof lo2.c) {
                        lo2.c cVar2 = (lo2.c) yVar;
                        if (cVar2.J() == 268435456 && cVar2.B()) {
                            return UfsGROUPMASK.GROUP_MASK_PRECISE_FEATURE;
                        }
                    }
                }
                return 268435456;
            }
            if (!(vVar instanceof do2.i) && !(vVar instanceof com.tencent.mobileqq.search.ftsmsg.a)) {
                if (vVar instanceof do2.d) {
                    return 1205;
                }
                if (vVar instanceof do2.e) {
                    return 1206;
                }
            } else {
                return 1204;
            }
        }
        if ((vVar instanceof pn2.c) && ((pn2.c) vVar).I == -1) {
            return 1203;
        }
        return Integer.MIN_VALUE;
    }
}
