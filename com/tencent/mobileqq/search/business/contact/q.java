package com.tencent.mobileqq.search.business.contact;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import java.util.Comparator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends ContactSearchEngine {

    /* renamed from: a0, reason: collision with root package name */
    public final a f282994a0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static final class a implements Comparator<com.tencent.mobileqq.search.model.k> {

        /* renamed from: d, reason: collision with root package name */
        private final IPhoneContactService f282995d;

        /* renamed from: e, reason: collision with root package name */
        AppInterface f282996e;

        a(AppInterface appInterface) {
            this.f282996e = appInterface;
            this.f282995d = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
        }

        private boolean b(String str, boolean z16) {
            return ((IAddFriendServiceApi) this.f282996e.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(str, z16, false);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.search.model.k kVar, com.tencent.mobileqq.search.model.k kVar2) {
            PhoneContact queryContactByCodeNumber = this.f282995d.queryContactByCodeNumber(((wn2.m) kVar).R());
            PhoneContact queryContactByCodeNumber2 = this.f282995d.queryContactByCodeNumber(((wn2.m) kVar2).R());
            if (queryContactByCodeNumber != null && queryContactByCodeNumber2 != null) {
                if (queryContactByCodeNumber.uin.equals("0") && queryContactByCodeNumber2.uin.equals("0")) {
                    boolean b16 = b(queryContactByCodeNumber.unifiedCode, true);
                    boolean b17 = b(queryContactByCodeNumber2.unifiedCode, true);
                    if (!b16 && !b17) {
                        boolean isEmpty = TextUtils.isEmpty(queryContactByCodeNumber.pinyinFirst);
                        boolean isEmpty2 = TextUtils.isEmpty(queryContactByCodeNumber2.pinyinFirst);
                        if (!isEmpty && !isEmpty2) {
                            return queryContactByCodeNumber.pinyinFirst.toLowerCase().charAt(0) - queryContactByCodeNumber2.pinyinFirst.toLowerCase().charAt(0);
                        }
                        if (isEmpty && isEmpty2) {
                            return 0;
                        }
                        if (isEmpty2) {
                            return -1;
                        }
                        return 1;
                    }
                    if (b16 && b17) {
                        return 0;
                    }
                    if (b17) {
                        return -1;
                    }
                    return 1;
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

    public q(AppInterface appInterface, int i3, int i16, String str, Set<String> set) {
        super(appInterface, i3, i16, str, set);
        this.f282994a0 = new a(appInterface);
    }

    @Override // com.tencent.mobileqq.search.business.contact.ContactSearchEngine
    public Comparator<com.tencent.mobileqq.search.model.k> u() {
        return this.f282994a0;
    }
}
