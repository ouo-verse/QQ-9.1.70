package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p extends o {
    static IPatchRedirector $redirector_;
    private final HashSet<String> N;

    public p(Activity activity, ExpandableListView expandableListView, QQAppInterface qQAppInterface, List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list, o.d dVar, boolean z16, hx3.c<Boolean> cVar) {
        super(activity, expandableListView, qQAppInterface, list, dVar, z16, cVar, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, expandableListView, qQAppInterface, list, dVar, Boolean.valueOf(z16), cVar);
            return;
        }
        this.N = new HashSet<>();
        if (activity != null) {
            q(activity.getIntent());
        }
    }

    private boolean r(String str) {
        return this.N.contains(str);
    }

    @Override // com.tencent.mobileqq.adapter.o, android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        ForwardRecentItemView forwardRecentItemView;
        o.e eVar;
        String nameWithConfig;
        String x16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), view, viewGroup);
        }
        if (view == null) {
            forwardRecentItemView = new ForwardRecentItemView(this.E);
            eVar = new o.e();
            forwardRecentItemView.setTag(eVar);
        } else {
            forwardRecentItemView = (ForwardRecentItemView) view;
            eVar = (o.e) forwardRecentItemView.getTag();
        }
        Object child = getChild(i3, i16);
        if (child instanceof PhoneContact) {
            PhoneContact phoneContact = (PhoneContact) child;
            nameWithConfig = phoneContact.name;
            x16 = phoneContact.mobileCode;
            if (TextUtils.isEmpty(x16)) {
                x16 = phoneContact.mobileNo;
            } else {
                int indexOf = x16.indexOf("|");
                if (indexOf > -1) {
                    x16 = x16.substring(0, indexOf);
                }
            }
            eVar.f187211e = 11;
            i17 = 1006;
        } else if (child instanceof RobotCoreInfo) {
            RobotCoreInfo robotCoreInfo = (RobotCoreInfo) child;
            x16 = String.valueOf(robotCoreInfo.robotUin);
            eVar.f187211e = 1;
            nameWithConfig = robotCoreInfo.name;
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) child;
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            aVar.d(dVar.getUid());
            nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            x16 = dVar.x();
            eVar.f187211e = 1;
        }
        int i18 = i17;
        String str = nameWithConfig;
        String str2 = x16;
        eVar.f187212f = forwardRecentItemView.f187013m;
        eVar.f187210d = str2;
        eVar.f187232i = child;
        boolean a16 = this.K.a(str2, i18);
        boolean l3 = com.tencent.mobileqq.troop.utils.k.l(this.D, str2);
        ResultRecord resultRecord = forwardRecentItemView.J;
        if (resultRecord == null) {
            resultRecord = new ResultRecord();
        }
        ResultRecord resultRecord2 = resultRecord;
        resultRecord2.init(str2, str, i18, "", "");
        forwardRecentItemView.b(str, "", null, resultRecord2, this.H, a16, l3);
        c(eVar, null);
        forwardRecentItemView.setOnClickListener(this.L);
        boolean r16 = r(str2);
        forwardRecentItemView.C.setEnabled(!r16);
        forwardRecentItemView.setEnabled(true ^ r16);
        if (AppSetting.f99565y) {
            forwardRecentItemView.setContentDescription(str);
        }
        return forwardRecentItemView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.adapter.o
    public ArrayList<Object> j(ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList, i3);
        }
        ArrayList<Object> j3 = super.j(arrayList, i3);
        Iterator<Object> it = j3.iterator();
        while (it.hasNext()) {
            try {
                String x16 = ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it.next()).x();
                if (this.D.getCurrentAccountUin().equals(x16) || Utils.I(x16) || Utils.G(x16)) {
                    it.remove();
                }
            } catch (Exception e16) {
                QLog.e("FriendPermissionSelectFriendListAdapter", 1, "getFriendList error", e16);
            }
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.adapter.o
    public ArrayList<Object> l(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        ArrayList<Object> l3 = super.l(list);
        if (l3 == null) {
            QLog.e("FriendPermissionSelectFriendListAdapter", 1, "recentFriendList is null.");
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>(l3);
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) it.next();
                if (r(dVar.x())) {
                    it.remove();
                } else if (this.D.getCurrentAccountUin().equals(dVar.x())) {
                    it.remove();
                }
            } catch (Exception e16) {
                QLog.e("FriendPermissionSelectFriendListAdapter", 1, "getRecentFriendList error", e16);
            }
        }
        return arrayList;
    }

    public void q(Intent intent) {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("only_chat_uins")) != null) {
            this.N.addAll(stringArrayListExtra);
        }
    }
}
