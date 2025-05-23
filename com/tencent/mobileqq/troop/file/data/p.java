package com.tencent.mobileqq.troop.file.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes35.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    String f295513a;

    /* renamed from: b, reason: collision with root package name */
    String f295514b;

    /* renamed from: c, reason: collision with root package name */
    String f295515c;

    /* renamed from: d, reason: collision with root package name */
    String f295516d;

    /* renamed from: e, reason: collision with root package name */
    String f295517e;

    /* renamed from: f, reason: collision with root package name */
    String f295518f;

    /* renamed from: g, reason: collision with root package name */
    String f295519g;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<a> f295520h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<a> f295521i;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<a> f295522j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<a> f295523k;

    public p(Context context, String str, String str2, String str3) {
        this.f295520h = null;
        this.f295521i = null;
        this.f295522j = null;
        this.f295523k = null;
        this.f295513a = str;
        this.f295514b = str2;
        this.f295517e = str3;
        this.f295515c = ChnToSpell.d(str2, 1).toLowerCase();
        this.f295516d = ChnToSpell.d(str2, 2).toLowerCase();
        this.f295518f = ChnToSpell.d(str3, 1).toLowerCase();
        this.f295519g = ChnToSpell.d(str3, 2).toLowerCase();
        if (!TextUtils.isEmpty(str2)) {
            String trim = str2.trim();
            int length = trim.length();
            this.f295520h = new ArrayList<>(length);
            this.f295521i = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = trim.charAt(i3);
                if (charAt >= '\u4e00' && charAt <= '\u9fa5') {
                    String substring = trim.substring(i3, i3 + 1);
                    this.f295520h.add(new a(context, substring, ChnToSpell.d(substring, 1).toLowerCase()));
                    this.f295521i.add(new a(context, substring, ChnToSpell.d(substring, 2).toLowerCase()));
                }
            }
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        String trim2 = str3.trim();
        int length2 = trim2.length();
        this.f295522j = new ArrayList<>(length2);
        this.f295523k = new ArrayList<>(length2);
        for (int i16 = 0; i16 < length2; i16++) {
            char charAt2 = trim2.charAt(i16);
            if (charAt2 >= '\u4e00' && charAt2 <= '\u9fa5') {
                String substring2 = trim2.substring(i16, i16 + 1);
                this.f295522j.add(new a(context, substring2, ChnToSpell.d(substring2, 1).toLowerCase()));
                this.f295523k.add(new a(context, substring2, ChnToSpell.d(substring2, 2).toLowerCase()));
            }
        }
    }

    protected static int a(int i3, ArrayList<a> arrayList) {
        int size = arrayList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            i16 += arrayList.get(i17).f295453c;
            if (i16 >= i3) {
                break;
            }
        }
        return i16;
    }

    public static final String c(String str, p pVar) {
        int f16 = f(str, pVar);
        int e16 = e(f16, str, pVar);
        if ((e16 == 0 && f16 == 5 && str.equalsIgnoreCase(pVar.f295518f)) || (f16 == 6 && str.equalsIgnoreCase(pVar.f295519g))) {
            return pVar.f295517e;
        }
        if ((e16 == 0 && f16 == 2 && str.equalsIgnoreCase(pVar.f295515c)) || (f16 == 3 && str.equalsIgnoreCase(pVar.f295516d))) {
            return pVar.f295514b;
        }
        if (e16 > -1) {
            return b(f16, e16, str, pVar);
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
                sb5.append(aVar.f295451a);
            }
            i17 += aVar.f295453c;
        }
        return sb5.toString();
    }

    protected static final int f(String str, p pVar) {
        String str2 = pVar.f295518f;
        if (str2 != null && str2.indexOf(str) > -1) {
            return 5;
        }
        String str3 = pVar.f295519g;
        if (str3 != null && str3.indexOf(str) > -1) {
            return 6;
        }
        String str4 = pVar.f295515c;
        if (str4 != null && str4.indexOf(str) > -1) {
            return 2;
        }
        String str5 = pVar.f295516d;
        return (str5 == null || str5.indexOf(str) <= -1) ? 0 : 3;
    }

    protected static int g(int i3, ArrayList<a> arrayList) {
        int size = arrayList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            int i18 = arrayList.get(i17).f295453c;
            if (i16 + i18 > i3) {
                break;
            }
            i16 += i18;
        }
        return i16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.f295513a != null) {
            sb5.append("uin = " + this.f295513a);
        }
        if (this.f295514b != null) {
            sb5.append(", name = " + this.f295514b);
        }
        if (this.f295517e != null) {
            sb5.append(", remark = " + this.f295517e);
        }
        return sb5.toString();
    }

    protected static final int e(int i3, String str, p pVar) {
        if (i3 == 5) {
            return pVar.f295518f.indexOf(str);
        }
        if (i3 == 6) {
            return pVar.f295519g.indexOf(str);
        }
        if (i3 == 2) {
            return pVar.f295515c.indexOf(str);
        }
        if (i3 == 3) {
            return pVar.f295516d.indexOf(str);
        }
        return -1;
    }

    protected static final String b(int i3, int i16, String str, p pVar) {
        ArrayList<a> arrayList;
        if (i3 == 5) {
            arrayList = pVar.f295522j;
        } else if (i3 == 6) {
            arrayList = pVar.f295523k;
        } else if (i3 == 2) {
            arrayList = pVar.f295520h;
        } else {
            arrayList = i3 == 3 ? pVar.f295521i : null;
        }
        if (arrayList != null) {
            return d(g(i16, arrayList), a(str.length() + i16, arrayList), arrayList);
        }
        return null;
    }
}
