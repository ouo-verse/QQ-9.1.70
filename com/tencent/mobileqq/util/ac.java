package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ad;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f306532a;

    /* renamed from: b, reason: collision with root package name */
    private ad f306533b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ad.a {
        a() {
        }

        @Override // com.tencent.mobileqq.util.ad.a
        public void a(int i3, List<ae> list) {
            StringBuilder sb5;
            if (i3 == 1 && list != null && !list.isEmpty()) {
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder(200);
                    sb5.append("fetchInfoBatch size:");
                    sb5.append(list.size());
                    sb5.append("  [");
                } else {
                    sb5 = null;
                }
                ArrayList<String> arrayList = new ArrayList<>(list.size());
                for (ae aeVar : list) {
                    if (aeVar != null && aeVar.f306540a == 1 && aeVar.a()) {
                        String str = aeVar.f306541b;
                        if (str != null && str.length() > 0) {
                            arrayList.add(aeVar.f306541b);
                        }
                        if (sb5 != null) {
                            sb5.append(aeVar.f306541b);
                            sb5.append(",");
                        }
                    }
                }
                if (QLog.isColorLevel() && sb5 != null) {
                    sb5.append("]");
                    QLog.i("FetchBuddyAndTroopNameHelper", 2, sb5.toString());
                }
                FriendListHandler friendListHandler = (FriendListHandler) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (friendListHandler != null) {
                    friendListHandler.getFriendInfoBatch(arrayList, false);
                }
            }
        }

        @Override // com.tencent.mobileqq.util.ad.a
        public void b(ae aeVar) {
            FriendListHandler friendListHandler;
            if (aeVar != null && aeVar.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("FetchBuddyAndTroopNameHelper", 2, StringUtil.makeLogMsg("fetchInfo()", aeVar.toString()));
                }
                int i3 = aeVar.f306540a;
                if (i3 == 2) {
                    com.tencent.mobileqq.troop.api.handler.h hVar = (com.tencent.mobileqq.troop.api.handler.h) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
                    if (hVar != null) {
                        hVar.T(aeVar.f306541b);
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    FriendListHandler friendListHandler2 = (FriendListHandler) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    if (friendListHandler2 != null) {
                        friendListHandler2.getFriendInfo(aeVar.f306541b);
                        return;
                    }
                    return;
                }
                if (i3 == 3) {
                    com.tencent.mobileqq.troop.api.handler.f fVar = (com.tencent.mobileqq.troop.api.handler.f) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
                    com.tencent.mobileqq.troop.api.handler.e eVar = (com.tencent.mobileqq.troop.api.handler.e) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
                    if (fVar != null && eVar != null) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(aeVar.f306541b);
                        Bundle bundle = aeVar.f306544e;
                        if (bundle != null && bundle.getInt(com.tencent.mobileqq.utils.ac.f307393c) == com.tencent.mobileqq.utils.ac.f307395e) {
                            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberNickName(aeVar.f306542c, arrayList, false, aeVar.f306544e, null, null);
                            return;
                        } else {
                            eVar.i1(aeVar.f306542c, (String) aeVar.f306543d, arrayList);
                            return;
                        }
                    }
                    return;
                }
                if (i3 == 4 && (friendListHandler = (FriendListHandler) ac.this.f306532a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)) != null) {
                    friendListHandler.getFriendInfo(aeVar.f306541b, true);
                }
            }
        }
    }

    public ac(QQAppInterface qQAppInterface) {
        this.f306532a = qQAppInterface;
    }

    private ad c() {
        ad adVar = new ad(new a());
        if (QLog.isColorLevel()) {
            QLog.i("FetchInfoListManager", 2, "createFetchInfoListManager fm: " + adVar);
        }
        return adVar;
    }

    public void b() {
        ad adVar = this.f306533b;
        if (adVar != null) {
            adVar.d();
            this.f306533b = null;
        }
    }

    public void d(String str) {
        if (this.f306533b == null) {
            this.f306533b = c();
        }
        this.f306533b.b(1, str, null, null, null);
    }

    public void e(String str) {
        if (this.f306533b == null) {
            this.f306533b = c();
        }
        this.f306533b.b(4, str, null, null, null);
    }

    public void f(String str) {
        if (this.f306533b == null) {
            this.f306533b = c();
        }
        this.f306533b.b(2, str, null, null, null);
    }

    public void g(String str, String str2, String str3, Bundle bundle) {
        if (this.f306533b == null) {
            this.f306533b = c();
        }
        this.f306533b.b(3, str, str2, str3, bundle);
    }
}
