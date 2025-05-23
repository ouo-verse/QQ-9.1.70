package com.tencent.mobileqq.friend.utils;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Comparator<Groups> f211740a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<Groups> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Groups groups, Groups groups2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groups, (Object) groups2)).intValue();
            }
            return groups.seqid - groups2.seqid;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41730);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f211740a = new a();
        }
    }

    public static String a(Friends friends) {
        return friends.getFriendNick() + "-" + friends.uin;
    }

    public static int b(String str, String str2) {
        int i3;
        int i16 = 0;
        char charAt = str2.charAt(0);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            i3 = 65536;
        } else if (charAt >= '0' && charAt <= '9') {
            i3 = 262144;
        } else {
            i3 = 131072;
        }
        int i17 = (charAt << '\b') | i3 | 0;
        if (str.charAt(0) >= '\u00ff') {
            i16 = 1;
        }
        return i17 | i16;
    }

    public static LinkedList<Groups> c(LinkedList<Groups> linkedList, Groups groups) {
        if (linkedList == null) {
            return null;
        }
        LinkedList<Groups> linkedList2 = new LinkedList<>(linkedList);
        if (linkedList2.size() == 0) {
            linkedList2.add(groups);
            return linkedList2;
        }
        int size = linkedList2.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) / 2;
            if (groups.seqid > linkedList2.get(i16).seqid) {
                i3 = i16 + 1;
            } else {
                size = i16 - 1;
            }
        }
        linkedList2.add(size + 1, groups);
        return linkedList2;
    }

    public static void d(Friends friends) {
        String a16 = a(friends);
        String d16 = ChnToSpell.d(a16, 1);
        friends.mCompareSpell = d16;
        friends.mComparePartInt = b(a16, d16);
    }
}
