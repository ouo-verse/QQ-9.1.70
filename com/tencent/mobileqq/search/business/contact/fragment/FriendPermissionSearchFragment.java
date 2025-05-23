package com.tencent.mobileqq.search.business.contact.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.view.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rn2.b;

/* loaded from: classes18.dex */
public class FriendPermissionSearchFragment extends ContactSearchFragment {
    private int W;
    private final Set<String> X = new HashSet();

    private void Dh(List<String> list) {
        if (list != null) {
            this.X.addAll(list);
        }
    }

    private boolean Eh(String str) {
        return this.X.contains(str);
    }

    public static FriendPermissionSearchFragment Fh(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3, int i18, ArrayList<String> arrayList) {
        FriendPermissionSearchFragment friendPermissionSearchFragment = new FriendPermissionSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("contactSearchSource", i16);
        bundle.putString("specifiedTroopUin", str);
        bundle.putInt("ContactCombineType", i17);
        bundle.putInt("key_friend_permission_select_type", i18);
        bundle.putStringArrayList("key_only_chat_uins", arrayList);
        if (list != null) {
            bundle.putStringArray("hiddenUinSet", (String[]) list.toArray(new String[list.size()]));
        }
        if (dVar != null) {
            bundle.putLong("contactSearchOnActionListener", b.b().a(dVar));
        }
        if (j3 > 0) {
            bundle.putLong("contactSearchResultFilterType", j3);
        }
        friendPermissionSearchFragment.setArguments(bundle);
        return friendPermissionSearchFragment;
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.W = arguments.getInt("key_friend_permission_select_type");
            Dh(arguments.getStringArrayList("key_only_chat_uins"));
        }
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendPermissionSearchFragment", 2, "onFinish with status:", Integer.valueOf(i3));
        }
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            super.onFinish(arrayList, i3);
            return;
        }
        for (Object obj : list) {
            if (obj instanceof y) {
                y yVar = (y) obj;
                if (!this.appInterface.getCurrentUin().equals(yVar.getUin())) {
                    if (this.W == 1 && Eh(yVar.getUin())) {
                        arrayList.add(yVar);
                    }
                    if (this.W == 2 && !Eh(yVar.getUin())) {
                        arrayList.add(yVar);
                    }
                }
            }
        }
        super.onFinish(arrayList, i3);
    }
}
