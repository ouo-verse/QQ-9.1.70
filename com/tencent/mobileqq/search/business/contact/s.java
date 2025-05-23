package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Comparator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s extends ContactSearchEngine {

    /* renamed from: a0, reason: collision with root package name */
    private Comparator<com.tencent.mobileqq.search.model.k> f282999a0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<com.tencent.mobileqq.search.model.k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
            int T;
            int T2;
            wn2.s sVar = (wn2.s) kVar;
            wn2.s sVar2 = (wn2.s) kVar2;
            boolean E = s.this.E((String) sVar.getUin());
            boolean E2 = s.this.E((String) sVar2.getUin());
            if (!E && !E2) {
                boolean R = s.this.R((String) sVar.getUin());
                boolean R2 = s.this.R((String) sVar2.getUin());
                if (!R && !R2) {
                    T = sVar2.T();
                    T2 = sVar.T();
                } else {
                    if (R != R2) {
                        if (R2) {
                            return -1;
                        }
                        return 1;
                    }
                    T = sVar2.T();
                    T2 = sVar.T();
                }
            } else {
                if (E != E2) {
                    if (E2) {
                        return -1;
                    }
                    return 1;
                }
                T = sVar2.T();
                T2 = sVar.T();
            }
            return T - T2;
        }
    }

    public s(AppInterface appInterface, int i3, int i16, String str, Set<String> set) {
        super(appInterface, i3, i16, str, set);
        this.f282999a0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "TroopBatchAddFrdsSearchEngine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(String str) {
        return ((IAddFriendServiceApi) this.f282844d.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, false);
    }

    @Override // com.tencent.mobileqq.search.business.contact.ContactSearchEngine
    public Comparator<com.tencent.mobileqq.search.model.k> u() {
        return this.f282999a0;
    }
}
