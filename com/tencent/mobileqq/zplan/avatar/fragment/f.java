package com.tencent.mobileqq.zplan.avatar.fragment;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f implements a {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, me3.b> f331780a = new ConcurrentHashMap<>();

    public f(List<Integer> list, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Integer num : list) {
            this.f331780a.put(num, new me3.b(0, str, num.intValue(), ""));
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.fragment.a
    public void a(int i3, int i16, String str) {
        me3.b bVar = this.f331780a.get(Integer.valueOf(i3));
        if (bVar != null) {
            bVar.c(i16);
            bVar.d(str);
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.fragment.a
    public boolean b(List<Integer> list, int i3) {
        if (list != null && list.size() != 0) {
            Iterator<Integer> it = list.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                me3.b bVar = this.f331780a.get(Integer.valueOf(intValue));
                if (bVar == null) {
                    QLog.e("ZPlanAvatarEditResourceManager", 1, "[getIsFailedNumTooMuch] actionId:", Integer.valueOf(intValue), " is not included");
                    return false;
                }
                if (bVar.getStatus() == -1) {
                    i16++;
                }
            }
            if (i16 != 0) {
                QLog.d("ZPlanAvatarEditResourceManager", 1, "[getIsFailedNumTooMuch] failedCount :", Integer.valueOf(i16));
            }
            return i16 > list.size() - i3;
        }
        QLog.e("ZPlanAvatarEditResourceManager", 1, "[getIsFailedNumTooMuch] input actionList is empty");
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.fragment.a
    public List<Integer> c(List<Integer> list, int i3) {
        QLog.i("ZPlanAvatarEditResourceManager", 4, "getFirstScreenListIfReady, batchCount: " + i3);
        List<Integer> d16 = d(list);
        if (d16 == null || d16.size() < i3) {
            return null;
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.fragment.a
    public void prepare() {
        Iterator<me3.b> it = this.f331780a.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public List<Integer> d(List<Integer> list) {
        if (list != null && list.size() != 0) {
            QLog.i("ZPlanAvatarEditResourceManager", 4, "getBatchActionReadyList, actionList: " + list);
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                me3.b bVar = this.f331780a.get(Integer.valueOf(intValue));
                if (bVar == null) {
                    QLog.e("ZPlanAvatarEditResourceManager", 1, "[getIsAllActionReady] actionId:", Integer.valueOf(intValue), " is not included");
                    return null;
                }
                if (bVar.getStatus() == 1) {
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            QLog.d("ZPlanAvatarEditResourceManager", 4, "[getIsBatchActionReady] preparedCount :" + arrayList.size());
            return arrayList;
        }
        QLog.e("ZPlanAvatarEditResourceManager", 1, "[getIsBatchActionReady] input actionList is empty");
        return null;
    }
}
