package com.tencent.luggage.wxa.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f123750c = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");

    /* renamed from: d, reason: collision with root package name */
    public static final Comparator f123751d = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f123752a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f123753b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f123755b - bVar2.f123755b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f123754a;

        /* renamed from: b, reason: collision with root package name */
        public final int f123755b;

        /* renamed from: c, reason: collision with root package name */
        public final int f123756c;

        public b(String str, int i3, int i16) {
            this.f123754a = str;
            this.f123755b = i3;
            this.f123756c = i16;
        }
    }

    public g(String str) {
        this.f123752a = str;
        if (str == null) {
            this.f123753b = null;
            return;
        }
        Matcher matcher = f123750c.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(new b(matcher.group(1), matcher.start(), matcher.end()));
            } while (matcher.find());
            b[] bVarArr = (b[]) arrayList.toArray(new b[0]);
            this.f123753b = bVarArr;
            Arrays.sort(bVarArr, f123751d);
            return;
        }
        this.f123753b = null;
    }

    public String a(Map map) {
        if (this.f123753b != null && this.f123752a != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            for (b bVar : this.f123753b) {
                String a16 = c0.a(map, bVar.f123754a);
                if (a16 == null) {
                    return null;
                }
                sb5.append((CharSequence) this.f123752a, i3, bVar.f123755b);
                sb5.append(a16);
                i3 = bVar.f123756c;
            }
            String str = this.f123752a;
            sb5.append((CharSequence) str, i3, str.length());
            return sb5.toString();
        }
        return this.f123752a;
    }

    public String[] b(Map map) {
        boolean z16;
        String str = this.f123752a;
        if (str == null) {
            return null;
        }
        b[] bVarArr = this.f123753b;
        if (bVarArr == null) {
            return new String[]{str};
        }
        int length = bVarArr.length;
        Object[] objArr = new Object[length];
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = map.get(this.f123753b[i3].f123754a);
            if (obj == null) {
                return null;
            }
            objArr[i3] = obj;
        }
        int i16 = 1;
        for (int i17 = 0; i17 < length; i17++) {
            Object obj2 = objArr[i17];
            if (obj2 instanceof String[]) {
                i16 *= ((String[]) obj2).length;
            }
        }
        if (i16 == 0) {
            return null;
        }
        int length2 = this.f123753b.length;
        int[] iArr = new int[length2];
        String[] strArr = new String[i16];
        StringBuilder sb5 = new StringBuilder();
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < length2; i26++) {
                b bVar = this.f123753b[i26];
                Object obj3 = objArr[i26];
                sb5.append((CharSequence) this.f123752a, i19, bVar.f123755b);
                if (obj3 instanceof String) {
                    sb5.append((String) obj3);
                } else {
                    if (!(obj3 instanceof String[])) {
                        return null;
                    }
                    sb5.append(((String[]) obj3)[iArr[i26]]);
                }
                i19 = bVar.f123756c;
            }
            String str2 = this.f123752a;
            sb5.append((CharSequence) str2, i19, str2.length());
            strArr[i18] = sb5.toString();
            sb5.setLength(0);
            int i27 = length2 - 1;
            while (true) {
                if (i27 >= 0) {
                    Object obj4 = objArr[i27];
                    if (obj4 instanceof String[]) {
                        int length3 = ((String[]) obj4).length;
                        z16 = true;
                        int i28 = iArr[i27] + 1;
                        iArr[i27] = i28;
                        if (i28 < length3) {
                            break;
                        }
                        iArr[i27] = 0;
                    }
                    i27--;
                } else {
                    z16 = true;
                    break;
                }
            }
        }
        return strArr;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof g) && c0.a(this.f123752a, ((g) obj).f123752a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f123752a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        String str = this.f123752a;
        if (str == null) {
            return "(null)";
        }
        return str;
    }

    public boolean a() {
        return this.f123753b != null;
    }
}
