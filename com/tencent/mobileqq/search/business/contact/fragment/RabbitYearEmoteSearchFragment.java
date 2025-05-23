package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.view.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import rn2.b;
import wn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RabbitYearEmoteSearchFragment extends ContactSearchFragment {
    public static RabbitYearEmoteSearchFragment Dh(int i3, int i16, String str, List<String> list, d dVar) {
        return Eh(i3, i16, str, list, dVar, 0, -1L);
    }

    public static RabbitYearEmoteSearchFragment Eh(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3) {
        RabbitYearEmoteSearchFragment rabbitYearEmoteSearchFragment = new RabbitYearEmoteSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("contactSearchSource", i16);
        bundle.putString("specifiedTroopUin", str);
        bundle.putInt("ContactCombineType", i17);
        if (list != null) {
            bundle.putStringArray("hiddenUinSet", (String[]) list.toArray(new String[list.size()]));
        }
        if (dVar != null) {
            bundle.putLong("contactSearchOnActionListener", b.b().a(dVar));
        }
        if (j3 > 0) {
            bundle.putLong("contactSearchResultFilterType", j3);
        }
        rabbitYearEmoteSearchFragment.setArguments(bundle);
        return rabbitYearEmoteSearchFragment;
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("RabbitYearEmoteSearchFragment", 2, "onFinish with status:", Integer.valueOf(i3));
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (Object obj : list) {
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    int M = kVar.M();
                    if (M == 1) {
                        arrayList.add(kVar);
                    }
                    boolean z16 = kVar instanceof c;
                    if (M == 0 && !z16) {
                        arrayList.add(kVar);
                    }
                    if (M == 0 && z16 && !((c) kVar).c0()) {
                        arrayList.add(kVar);
                    }
                }
            }
            super.onFinish(arrayList, i3);
            return;
        }
        super.onFinish(arrayList, i3);
    }
}
