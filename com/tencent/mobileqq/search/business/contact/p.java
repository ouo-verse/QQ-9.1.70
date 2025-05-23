package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import java.util.Comparator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends ContactSearchEngine {

    /* renamed from: a0, reason: collision with root package name */
    private Comparator<com.tencent.mobileqq.search.model.k> f282960a0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<com.tencent.mobileqq.search.model.k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) p.this.f282844d.getRuntimeService(IPhoneContactService.class, "");
            PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(((wn2.m) kVar).R());
            PhoneContact queryContactByCodeNumber2 = iPhoneContactService.queryContactByCodeNumber(((wn2.m) kVar2).R());
            if (queryContactByCodeNumber != null && queryContactByCodeNumber2 != null) {
                if (queryContactByCodeNumber.uin.equals("0") && queryContactByCodeNumber2.uin.equals("0")) {
                    if (queryContactByCodeNumber.uin.equals("0")) {
                        boolean Q = p.this.Q(queryContactByCodeNumber.unifiedCode, true);
                        boolean Q2 = p.this.Q(queryContactByCodeNumber2.unifiedCode, true);
                        if (Q || Q2) {
                            if (Q && Q2) {
                                return 0;
                            }
                            if (Q2) {
                                return -1;
                            }
                            return 1;
                        }
                    }
                    return 0;
                }
                if (!queryContactByCodeNumber.uin.equals("0") && !queryContactByCodeNumber2.uin.equals("0")) {
                    return 0;
                }
                if (!queryContactByCodeNumber2.uin.equals("0")) {
                    return -1;
                }
                return 1;
            }
            if (queryContactByCodeNumber == null && queryContactByCodeNumber2 == null) {
                return 0;
            }
            if (queryContactByCodeNumber2 == null) {
                return -1;
            }
            return 1;
        }
    }

    public p(AppInterface appInterface, int i3, int i16, String str, Set<String> set) {
        super(appInterface, i3, i16, str, set);
        this.f282960a0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(String str, boolean z16) {
        return ((IAddFriendServiceApi) this.f282844d.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, z16, false);
    }

    @Override // com.tencent.mobileqq.search.business.contact.ContactSearchEngine
    public Comparator<com.tencent.mobileqq.search.model.k> u() {
        return this.f282960a0;
    }
}
