package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.view.d;
import com.tencent.mobileqq.zplan.friend.ForwardZPlanUserList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import rn2.b;

/* loaded from: classes18.dex */
public class ZPlanSearchFragment extends ContactSearchFragment {
    private String W;
    private final HashSet<String> X = new HashSet<>();

    private void Dh() {
        List<String> readFromDB = ForwardZPlanUserList.readFromDB(this.appInterface.getEntityManagerFactory().createEntityManager(), this.appInterface.getCurrentAccountUin(), this.W);
        if (readFromDB == null) {
            return;
        }
        int size = readFromDB.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.X.add(readFromDB.get(i3));
        }
    }

    public static ZPlanSearchFragment Eh(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3, String str2) {
        ZPlanSearchFragment zPlanSearchFragment = new ZPlanSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("contactSearchSource", i16);
        bundle.putString("specifiedTroopUin", str);
        bundle.putInt("ContactCombineType", i17);
        bundle.putString(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID, str2);
        if (list != null) {
            bundle.putStringArray("hiddenUinSet", (String[]) list.toArray(new String[list.size()]));
        }
        if (dVar != null) {
            bundle.putLong("contactSearchOnActionListener", b.b().a(dVar));
        }
        if (j3 > 0) {
            bundle.putLong("contactSearchResultFilterType", j3);
        }
        zPlanSearchFragment.setArguments(bundle);
        return zPlanSearchFragment;
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.W = arguments.getString(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID);
        }
        Dh();
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanSearchFragment", 2, "onFinish with status:", Integer.valueOf(i3));
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj instanceof y) {
                    y yVar = (y) obj;
                    if (!this.appInterface.getCurrentAccountUin().equals(yVar.getUin()) && this.X.contains(yVar.getUin())) {
                        arrayList.add(yVar);
                    }
                }
            }
        }
        super.onFinish(arrayList, i3);
    }
}
