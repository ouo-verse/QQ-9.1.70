package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.adapter.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.zplan.friend.ForwardZPlanUserList;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class am extends o {
    static IPatchRedirector $redirector_;
    private final HashSet<String> N;
    private String P;

    public am(Activity activity, ExpandableListView expandableListView, QQAppInterface qQAppInterface, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list, o.d dVar, boolean z16, hx3.c<Boolean> cVar) {
        super(activity, expandableListView, qQAppInterface, list, dVar, z16, cVar, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, expandableListView, qQAppInterface, list, dVar, Boolean.valueOf(z16), cVar);
            return;
        }
        this.N = new HashSet<>();
        this.P = "";
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.P = intent.getStringExtra(ForwardRecentActivity.KEY_FORWARD_SHARE_FROM_ZPLAN_APPID);
        }
        q();
    }

    private void q() {
        List<String> readFromDB = ForwardZPlanUserList.readFromDB(this.D.getEntityManagerFactory().createEntityManager(), this.D.getCurrentAccountUin(), this.P);
        if (readFromDB == null) {
            return;
        }
        int size = readFromDB.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.N.add(readFromDB.get(i3));
        }
    }

    private boolean r(String str) {
        return this.N.contains(str);
    }

    @Override // com.tencent.mobileqq.adapter.o
    protected ArrayList<Object> j(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, i3);
        }
        ArrayList<Object> j3 = super.j(arrayList, i3);
        Iterator<Object> it = j3.iterator();
        while (it.hasNext()) {
            try {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it.next();
                if (!r(dVar.x())) {
                    it.remove();
                } else if (this.D.getCurrentAccountUin().equals(dVar.x())) {
                    it.remove();
                }
            } catch (Exception e16) {
                QLog.e("ZPlanSelectionFriendListAdapter", 1, "filterFriendListByCategoryId error: " + e16);
            }
        }
        return j3;
    }
}
