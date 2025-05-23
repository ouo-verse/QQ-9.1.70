package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements Comparator<PhoneContact> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f258507d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<String> f258508e;

    /* renamed from: f, reason: collision with root package name */
    private IAddFriendServiceApi f258509f;

    public c(int[] iArr, Set<String> set, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iArr, set, appInterface);
            return;
        }
        this.f258507d = iArr;
        this.f258508e = set;
        if (appInterface != null) {
            this.f258509f = (IAddFriendServiceApi) appInterface.getRuntimeService(IAddFriendServiceApi.class, "");
        }
    }

    private int a(PhoneContact phoneContact) {
        int i3;
        int a16 = com.tencent.mobileqq.friend.status.b.a(phoneContact.detalStatusFlag, phoneContact.iTermType);
        if (a16 != 6 && a16 != 0) {
            i3 = 65536;
        } else {
            i3 = 131072;
        }
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3 && a16 != 4) {
                    if (a16 != 7) {
                        return ((int) j(phoneContact.unifiedCode)) | i3;
                    }
                } else {
                    return i3 | 1;
                }
            }
            return i3 | 3;
        }
        return i3 | 2;
    }

    private int c(PhoneContact phoneContact, PhoneContact phoneContact2) {
        int i3 = phoneContact2.samFriend;
        int i16 = phoneContact.samFriend;
        if (i3 > i16) {
            return 1;
        }
        if (i3 < i16) {
            return -1;
        }
        return 0;
    }

    private int d(PhoneContact phoneContact, PhoneContact phoneContact2) {
        int i3 = phoneContact2.samFriend;
        if (i3 > 0 && phoneContact.samFriend > 0) {
            return 0;
        }
        if (i3 <= 0 && phoneContact.samFriend <= 0) {
            return 0;
        }
        return c(phoneContact, phoneContact2);
    }

    private int e(PhoneContact phoneContact, PhoneContact phoneContact2) {
        String str = phoneContact.pinyinFirst;
        String str2 = phoneContact2.pinyinFirst;
        if (str.endsWith("#")) {
            str = "Za";
        }
        if (str2.endsWith("#")) {
            str2 = "Za";
        }
        int compareTo = str.compareTo(str2);
        if (compareTo == 0) {
            return phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
        }
        return compareTo;
    }

    private int f(PhoneContact phoneContact, PhoneContact phoneContact2) {
        IAddFriendServiceApi iAddFriendServiceApi = this.f258509f;
        if (iAddFriendServiceApi == null) {
            return 0;
        }
        boolean hasSendAddFriendReq = iAddFriendServiceApi.hasSendAddFriendReq(phoneContact.unifiedCode, true);
        boolean hasSendAddFriendReq2 = this.f258509f.hasSendAddFriendReq(phoneContact2.unifiedCode, true);
        if (hasSendAddFriendReq) {
            return 1;
        }
        if (!hasSendAddFriendReq2) {
            return 0;
        }
        return -1;
    }

    private int g(PhoneContact phoneContact, PhoneContact phoneContact2) {
        return a(phoneContact) - a(phoneContact2);
    }

    private int h(PhoneContact phoneContact, PhoneContact phoneContact2) {
        int i3;
        int i16 = 1;
        if (!"0".equals(phoneContact.uin) && !TextUtils.isEmpty(phoneContact.uin)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if ("0".equals(phoneContact2.uin) || TextUtils.isEmpty(phoneContact2.uin)) {
            i16 = 0;
        }
        return i16 - i3;
    }

    private int i(PhoneContact phoneContact, PhoneContact phoneContact2) {
        boolean z16 = phoneContact.isNewRecommend;
        boolean z17 = phoneContact2.isNewRecommend;
        if (z16 || z17) {
            if (z16 && z17) {
                return 0;
            }
            if (z17) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
        }
        if (phoneContact != null && phoneContact2 != null) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr = this.f258507d;
                if (i3 < iArr.length) {
                    switch (iArr[i3]) {
                        case 1:
                            i16 = i(phoneContact, phoneContact2);
                            break;
                        case 2:
                            i16 = g(phoneContact, phoneContact2);
                            break;
                        case 3:
                            i16 = c(phoneContact, phoneContact2);
                            break;
                        case 4:
                            i16 = e(phoneContact, phoneContact2);
                            break;
                        case 5:
                            i16 = f(phoneContact, phoneContact2);
                            break;
                        case 6:
                            i16 = h(phoneContact, phoneContact2);
                            break;
                        case 7:
                            i16 = d(phoneContact, phoneContact2);
                            break;
                        default:
                            i16 = 0;
                            break;
                    }
                    if (i16 == 0) {
                        i3++;
                    }
                }
            }
            return i16;
        }
        if (phoneContact != null) {
            return 1;
        }
        if (phoneContact2 == null) {
            return 0;
        }
        return -1;
    }

    public long j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).longValue();
        }
        Set<String> set = this.f258508e;
        if (set == null) {
            return 0L;
        }
        if (set.contains(str)) {
            return 1L;
        }
        return 10L;
    }
}
