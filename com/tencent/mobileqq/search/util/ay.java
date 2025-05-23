package com.tencent.mobileqq.search.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ay {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ay f285028a = new ay();
    }

    ay() {
    }

    @NonNull
    private HashMap<Integer, List<com.tencent.mobileqq.search.model.v>> a(List<com.tencent.mobileqq.search.model.v> list) {
        com.tencent.mobileqq.search.model.v vVar;
        HashMap<Integer, List<com.tencent.mobileqq.search.model.v>> hashMap = new HashMap<>();
        int i3 = 0;
        while (i3 < list.size()) {
            com.tencent.mobileqq.search.model.v vVar2 = list.get(i3);
            i3++;
            if (i3 < list.size()) {
                vVar = list.get(i3);
            } else {
                vVar = null;
            }
            int e16 = e(vVar2, vVar);
            List<com.tencent.mobileqq.search.model.v> list2 = hashMap.get(Integer.valueOf(e16));
            if (list2 == null) {
                list2 = new ArrayList<>(3);
                hashMap.put(Integer.valueOf(e16), list2);
            }
            list2.add(vVar2);
        }
        return hashMap;
    }

    private boolean b(List<com.tencent.mobileqq.search.model.v> list) {
        for (com.tencent.mobileqq.search.model.v vVar : list) {
            if (vVar.f() == -1) {
                QLog.e("TnnSearchHelper", 1, "preProcessByConfig: groupId not set!: " + vVar.getClass().getSimpleName());
                return false;
            }
        }
        return true;
    }

    public static int c() {
        if (StudyModeManager.t()) {
            return 3;
        }
        if (QQTheme.isNowSimpleUI()) {
            return 2;
        }
        if (QQTheme.isDefaultTheme()) {
            return 1;
        }
        return 4;
    }

    public static ay d() {
        return a.f285028a;
    }

    private int e(@NonNull com.tencent.mobileqq.search.model.v vVar, @Nullable com.tencent.mobileqq.search.model.v vVar2) {
        int k3;
        if (vVar instanceof com.tencent.mobileqq.search.model.i) {
            com.tencent.mobileqq.search.model.i iVar = (com.tencent.mobileqq.search.model.i) vVar;
            if (vVar2 != null && vVar2.f() == iVar.f()) {
                int e16 = e(vVar2, null);
                iVar.r(e16);
                if (iVar.v() != null) {
                    iVar.v().r(e16);
                }
                return e16;
            }
            if (iVar.k() != 0) {
                k3 = iVar.k();
            } else {
                if (iVar.v() == null) {
                    return 0;
                }
                k3 = iVar.v().k();
            }
            return k3;
        }
        if (vVar instanceof com.tencent.mobileqq.search.model.x) {
            return ((com.tencent.mobileqq.search.model.x) vVar).k();
        }
        if (vVar instanceof com.tencent.mobileqq.search.model.z) {
            return ((com.tencent.mobileqq.search.model.z) vVar).x();
        }
        if (!(vVar instanceof com.tencent.mobileqq.search.tux.g)) {
            return 0;
        }
        return 30;
    }

    private void f(wp2.b bVar, HashMap<Integer, List<com.tencent.mobileqq.search.model.v>> hashMap, ArrayList<com.tencent.mobileqq.search.model.v> arrayList) {
        for (wp2.a aVar : bVar.f446027a) {
            List<com.tencent.mobileqq.search.model.v> remove = hashMap.remove(Integer.valueOf(aVar.h()));
            if (!aVar.j() && remove != null) {
                arrayList.addAll(remove);
            }
        }
        for (List<com.tencent.mobileqq.search.model.v> list : hashMap.values()) {
            if (list != null) {
                arrayList.addAll(list);
            }
        }
    }

    private void g(ArrayList<com.tencent.mobileqq.search.model.v> arrayList) {
        if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("processByConfig: after changed: {");
        Iterator<com.tencent.mobileqq.search.model.v> it = arrayList.iterator();
        while (it.hasNext()) {
            sb5.append(e(it.next(), null));
            sb5.append(", ");
        }
        sb5.append("}");
        QLog.d("TnnSearchHelper", 2, sb5);
    }

    private void h(List<com.tencent.mobileqq.search.model.v> list, wp2.b bVar) {
        if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder("processByConfig: before handle: {");
        Iterator<com.tencent.mobileqq.search.model.v> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(e(it.next(), null));
            sb5.append(", ");
        }
        sb5.append("}");
        sb5.append("\nconfig change: considerUnknownItem ? ");
        sb5.append(cp2.d.a(bVar.f446028b));
        sb5.append(", {");
        for (wp2.a aVar : bVar.f446027a) {
            if (aVar.j()) {
                break;
            }
            sb5.append(aVar.h());
            sb5.append(", ");
        }
        sb5.append("}");
        QLog.d("TnnSearchHelper", 2, sb5);
    }

    public static int j(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                if (i3 != 21) {
                    return 4;
                }
                return 3;
            }
        }
        return i16;
    }

    public List<com.tencent.mobileqq.search.model.v> i(List<com.tencent.mobileqq.search.model.v> list, wp2.b bVar) {
        QLog.d("TnnSearchHelper", 1, "processBySortInfoConfig is call!");
        if (list != null && !list.isEmpty() && bVar != null) {
            if (!b(list)) {
                return list;
            }
            HashMap<Integer, List<com.tencent.mobileqq.search.model.v>> a16 = a(list);
            ArrayList<com.tencent.mobileqq.search.model.v> arrayList = new ArrayList<>(list.size());
            h(list, bVar);
            f(bVar, a16, arrayList);
            g(arrayList);
            return arrayList;
        }
        return list;
    }
}
