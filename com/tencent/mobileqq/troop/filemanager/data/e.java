package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f295829a;

    /* renamed from: b, reason: collision with root package name */
    public String f295830b;

    /* renamed from: c, reason: collision with root package name */
    public String f295831c;

    /* renamed from: d, reason: collision with root package name */
    public String f295832d;

    /* renamed from: e, reason: collision with root package name */
    public String f295833e;

    /* renamed from: f, reason: collision with root package name */
    public String f295834f;

    /* renamed from: g, reason: collision with root package name */
    public String f295835g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<a> f295836h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<a> f295837i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<a> f295838j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<a> f295839k;

    public e(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2, str3);
            return;
        }
        this.f295836h = null;
        this.f295837i = null;
        this.f295838j = null;
        this.f295839k = null;
        this.f295829a = str;
        this.f295830b = str2;
        this.f295833e = str3;
        this.f295831c = ChnToSpell.d(str2, 1).toLowerCase();
        this.f295832d = ChnToSpell.d(str2, 2).toLowerCase();
        this.f295834f = ChnToSpell.d(str3, 1).toLowerCase();
        this.f295835g = ChnToSpell.d(str3, 2).toLowerCase();
        if (!TextUtils.isEmpty(str2)) {
            String trim = str2.trim();
            int length = trim.length();
            this.f295836h = new ArrayList<>(length);
            this.f295837i = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = trim.charAt(i3);
                if (charAt >= '\u4e00' && charAt <= '\u9fa5') {
                    String substring = trim.substring(i3, i3 + 1);
                    this.f295836h.add(new a(context, substring, ChnToSpell.d(substring, 1).toLowerCase()));
                    this.f295837i.add(new a(context, substring, ChnToSpell.d(substring, 2).toLowerCase()));
                }
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            String trim2 = str3.trim();
            int length2 = trim2.length();
            this.f295838j = new ArrayList<>(length2);
            this.f295839k = new ArrayList<>(length2);
            for (int i16 = 0; i16 < length2; i16++) {
                char charAt2 = trim2.charAt(i16);
                if (charAt2 >= '\u4e00' && charAt2 <= '\u9fa5') {
                    String substring2 = trim2.substring(i16, i16 + 1);
                    this.f295838j.add(new a(context, substring2, ChnToSpell.d(substring2, 1).toLowerCase()));
                    this.f295839k.add(new a(context, substring2, ChnToSpell.d(substring2, 2).toLowerCase()));
                }
            }
        }
    }

    protected static int a(int i3, ArrayList<a> arrayList) {
        int size = arrayList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            i16 += arrayList.get(i17).f295789c;
            if (i16 >= i3) {
                break;
            }
        }
        return i16;
    }

    protected static final String b(int i3, int i16, String str, e eVar) {
        ArrayList<a> arrayList;
        if (i3 == 5) {
            arrayList = eVar.f295838j;
        } else if (i3 == 6) {
            arrayList = eVar.f295839k;
        } else if (i3 == 2) {
            arrayList = eVar.f295836h;
        } else if (i3 == 3) {
            arrayList = eVar.f295837i;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        return d(g(i16, arrayList), a(str.length() + i16, arrayList), arrayList);
    }

    public static final String c(String str, e eVar) {
        int f16 = f(str, eVar);
        int e16 = e(f16, str, eVar);
        if ((e16 == 0 && f16 == 5 && str.equalsIgnoreCase(eVar.f295834f)) || (f16 == 6 && str.equalsIgnoreCase(eVar.f295835g))) {
            return eVar.f295833e;
        }
        if ((e16 == 0 && f16 == 2 && str.equalsIgnoreCase(eVar.f295831c)) || (f16 == 3 && str.equalsIgnoreCase(eVar.f295832d))) {
            return eVar.f295830b;
        }
        if (e16 > -1) {
            return b(f16, e16, str, eVar);
        }
        return null;
    }

    public static String d(int i3, int i16, ArrayList<a> arrayList) {
        int size = arrayList.size();
        StringBuilder sb5 = new StringBuilder();
        int i17 = 0;
        boolean z16 = false;
        for (int i18 = 0; i18 < size; i18++) {
            a aVar = arrayList.get(i18);
            if (i17 == i3) {
                z16 = true;
            }
            if (i17 == i16) {
                break;
            }
            if (z16) {
                sb5.append(aVar.f295787a);
            }
            i17 += aVar.f295789c;
        }
        return sb5.toString();
    }

    protected static final int e(int i3, String str, e eVar) {
        if (i3 == 5) {
            return eVar.f295834f.indexOf(str);
        }
        if (i3 == 6) {
            return eVar.f295835g.indexOf(str);
        }
        if (i3 == 2) {
            return eVar.f295831c.indexOf(str);
        }
        if (i3 == 3) {
            return eVar.f295832d.indexOf(str);
        }
        return -1;
    }

    protected static final int f(String str, e eVar) {
        String str2 = eVar.f295834f;
        if (str2 != null && str2.indexOf(str) > -1) {
            return 5;
        }
        String str3 = eVar.f295835g;
        if (str3 != null && str3.indexOf(str) > -1) {
            return 6;
        }
        String str4 = eVar.f295831c;
        if (str4 != null && str4.indexOf(str) > -1) {
            return 2;
        }
        String str5 = eVar.f295832d;
        if (str5 != null && str5.indexOf(str) > -1) {
            return 3;
        }
        return 0;
    }

    protected static int g(int i3, ArrayList<a> arrayList) {
        int size = arrayList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            int i18 = arrayList.get(i17).f295789c;
            if (i16 + i18 > i3) {
                break;
            }
            i16 += i18;
        }
        return i16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f295829a != null) {
            sb5.append("uin = " + this.f295829a);
        }
        if (this.f295830b != null) {
            sb5.append(", name = " + this.f295830b);
        }
        if (this.f295833e != null) {
            sb5.append(", remark = " + this.f295833e);
        }
        return sb5.toString();
    }
}
