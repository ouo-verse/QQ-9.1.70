package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Comparator<Object> f195808a;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Comparator<Object> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            String str;
            int i3;
            String str2;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            if (obj instanceof Groups) {
                return ((Groups) obj).seqid - ((Groups) obj2).seqid;
            }
            if (obj instanceof Friends) {
                Friends friends = (Friends) obj;
                Friends friends2 = (Friends) obj2;
                i3 = friends.mComparePartInt;
                str = friends.mCompareSpell;
                i16 = friends2.mComparePartInt;
                str2 = friends2.mCompareSpell;
            } else if (obj instanceof TroopInfo) {
                TroopExtDBInfo troopExtDBInfo = ((TroopInfo) obj).extDBInfo;
                i3 = troopExtDBInfo.comparePartInt;
                TroopExtDBInfo troopExtDBInfo2 = ((TroopInfo) obj2).extDBInfo;
                i16 = troopExtDBInfo2.comparePartInt;
                str = troopExtDBInfo.compareSpell;
                str2 = troopExtDBInfo2.compareSpell;
            } else if (obj instanceof DiscussionInfo) {
                DiscussionInfo discussionInfo = (DiscussionInfo) obj;
                DiscussionInfo discussionInfo2 = (DiscussionInfo) obj2;
                i3 = discussionInfo.mComparePartInt;
                i16 = discussionInfo2.mComparePartInt;
                str = discussionInfo.mCompareSpell;
                str2 = discussionInfo2.mCompareSpell;
            } else if (obj instanceof PublicAccountInfo) {
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) obj;
                PublicAccountInfo publicAccountInfo2 = (PublicAccountInfo) obj2;
                i3 = publicAccountInfo.mComparePartInt;
                i16 = publicAccountInfo2.mComparePartInt;
                str = publicAccountInfo.mCompareSpell;
                str2 = publicAccountInfo2.mCompareSpell;
            } else {
                str = "-";
                i3 = 0;
                str2 = "-";
                i16 = 0;
            }
            return j.a(i3, str, i16, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b implements Comparator<DiscussionMemberInfo> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DiscussionMemberInfo discussionMemberInfo, DiscussionMemberInfo discussionMemberInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) discussionMemberInfo, (Object) discussionMemberInfo2)).intValue();
            }
            if (discussionMemberInfo != null && discussionMemberInfo2 != null) {
                Long valueOf = Long.valueOf(Long.parseLong(discussionMemberInfo.memberUin));
                Long valueOf2 = Long.valueOf(Long.parseLong(discussionMemberInfo2.memberUin));
                if (valueOf.longValue() > valueOf2.longValue()) {
                    return 1;
                }
                if (valueOf.longValue() < valueOf2.longValue()) {
                    return -1;
                }
                return 0;
            }
            if (discussionMemberInfo != null) {
                return 1;
            }
            if (discussionMemberInfo2 != null) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c implements Comparator<DiscussionMemberInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f195809d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f195810e;

        /* renamed from: f, reason: collision with root package name */
        private QQAppInterface f195811f;

        public c(QQAppInterface qQAppInterface, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, str2);
                return;
            }
            this.f195811f = qQAppInterface;
            this.f195809d = str;
            this.f195810e = str2.equals(str);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DiscussionMemberInfo discussionMemberInfo, DiscussionMemberInfo discussionMemberInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) discussionMemberInfo, (Object) discussionMemberInfo2)).intValue();
            }
            if (discussionMemberInfo.memberUin.equals(this.f195809d)) {
                if (!this.f195810e) {
                    return -1;
                }
                return 1;
            }
            if (discussionMemberInfo2.memberUin.equals(this.f195809d)) {
                if (this.f195810e) {
                    return -1;
                }
                return 1;
            }
            String m3 = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo, this.f195811f);
            String m16 = com.tencent.mobileqq.utils.ac.m(discussionMemberInfo2, this.f195811f);
            if (m3 != null && m3.length() != 0) {
                if (m16 != null && m16.length() != 0) {
                    if (!Character.isDigit(m3.charAt(0)) && !Character.isDigit(m16.charAt(0))) {
                        String d16 = ChnToSpell.d(m3, 1);
                        String d17 = ChnToSpell.d(m16, 1);
                        if (d16.length() != 0 && d17.length() != 0) {
                            if (d16.charAt(0) == d17.charAt(0)) {
                                if (StringUtil.isAsciiAlpha(m3.charAt(0)) && StringUtil.isAsciiAlpha(m16.charAt(0))) {
                                    return m3.charAt(0) - m16.charAt(0);
                                }
                                if (Character.isLetter(m3.charAt(0))) {
                                    return 1;
                                }
                                if (Character.isLetter(m16.charAt(0))) {
                                    return -1;
                                }
                                return d16.compareTo(d17);
                            }
                            return d16.charAt(0) - d17.charAt(0);
                        }
                        return -d16.compareTo(d17);
                    }
                    if (Character.isDigit(m3.charAt(0)) && Character.isDigit(m16.charAt(0))) {
                        return m3.charAt(0) - m16.charAt(0);
                    }
                    if (!Character.isDigit(m3.charAt(0))) {
                        return -1;
                    }
                    return 1;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("ContactUtils", 2, "rhsName is null");
                }
                throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils  int compare rhsName is null for check ");
            }
            if (QLog.isColorLevel()) {
                QLog.e("ContactUtils", 2, "lhsName is null");
            }
            throw new NullPointerException("com.tencent.mobileqq.utils.ContactUtils int compare lhsName is null for check ");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f195808a = new a();
        }
    }

    public static int a(int i3, String str, int i16, String str2) {
        if (i3 > i16) {
            return 1;
        }
        if (i3 < i16) {
            return -1;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str.compareTo(str2);
    }

    public static String b(DiscussionInfo discussionInfo) {
        return discussionInfo.discussionName + "-" + discussionInfo.uin;
    }

    public static String c(Friends friends) {
        return friends.getFriendNick() + "-" + friends.uin;
    }

    public static int d(String str, String str2) {
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

    public static String e(PublicAccountInfo publicAccountInfo) {
        return publicAccountInfo.name + "-" + publicAccountInfo.uin;
    }

    public static void f(DiscussionInfo discussionInfo) {
        String b16 = b(discussionInfo);
        String d16 = ChnToSpell.d(b16, 1);
        discussionInfo.mCompareSpell = d16;
        discussionInfo.mComparePartInt = d(b16, d16);
    }

    public static void g(Friends friends) {
        String c16 = c(friends);
        String d16 = ChnToSpell.d(c16, 1);
        friends.mCompareSpell = d16;
        friends.mComparePartInt = d(c16, d16);
    }

    public static void h(PublicAccountInfo publicAccountInfo) {
        String e16 = e(publicAccountInfo);
        String d16 = ChnToSpell.d(e16, 1);
        publicAccountInfo.mCompareSpell = d16;
        publicAccountInfo.mComparePartInt = d(e16, d16);
    }
}
