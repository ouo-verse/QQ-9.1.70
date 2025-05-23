package n64;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* compiled from: P */
    /* renamed from: n64.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C10827a {

        /* renamed from: g, reason: collision with root package name */
        private static final String[] f418541g = {"/\u5472\u7259", "/\u8c03\u76ae", "/\u6d41\u6c57", "/\u5077\u7b11", "/\u518d\u89c1", "/\u6572\u6253", "/\u64e6\u6c57", "/\u732a\u5934", "/\u73ab\u7470", "/\u6d41\u6cea", "/\u5927\u54ed", "/\u5618...", "/\u9177", "/\u6293\u72c2", "/\u59d4\u5c48", "/\u4fbf\u4fbf", "/\u70b8\u5f39", "/\u83dc\u5200", "/\u53ef\u7231", "/\u8272", "/\u5bb3\u7f9e", "/\u5f97\u610f", "/\u5410", "/\u5fae\u7b11", "/\u53d1\u6012", "/\u5c34\u5c2c", "/\u60ca\u6050", "/\u51b7\u6c57", "/\u7231\u5fc3", "/\u793a\u7231", "/\u767d\u773c", "/\u50b2\u6162", "/\u96be\u8fc7", "/\u60ca\u8bb6", "/\u7591\u95ee", "/\u7761", "/\u4eb2\u4eb2", "/\u61a8\u7b11", "/\u7231\u60c5", "/\u8870", "/\u6487\u5634", "/\u9634\u9669", "/\u594b\u6597", "/\u53d1\u5446", "/\u53f3\u54fc\u54fc", "/\u62e5\u62b1", "/\u574f\u7b11", "/\u98de\u543b", "/\u9119\u89c6", "/\u6655", "/\u60a0\u95f2", "/\u53ef\u601c", "/\u8d5e", "/\u8e29", "/\u63e1\u624b", "/\u80dc\u5229", "/\u62b1\u62f3", "/\u51cb\u8c22", "/\u996d", "/\u86cb\u7cd5", "/\u897f\u74dc", "/\u5564\u9152", "/\u74e2\u866b", "/\u52fe\u5f15", "/OK", "/\u7231\u4f60", "/\u5496\u5561", "/\u94b1", "/\u6708\u4eae", "/\u7f8e\u5973", "/\u5200", "/\u53d1\u6296", "/\u5dee\u52b2", "/\u62f3\u5934", "/\u5fc3\u788e", "/\u592a\u9633", "/\u793c\u7269", "/\u8db3\u7403", "/\u9ab7\u9ac5", "/\u6325\u624b", "/\u95ea\u7535", "/\u9965\u997f", "/\u56f0", "/\u5492\u9a82", "/\u6298\u78e8", "/\u62a0\u9f3b", "/\u9f13\u638c", "/\u7cd7\u5927\u4e86", "/\u5de6\u54fc\u54fc", "/\u54c8\u6b20", "/\u5feb\u54ed\u4e86", "/\u5413", "/\u7bee\u7403", "/\u4e52\u4e53", "/NO", "/\u8df3\u8df3", "/\u6004\u706b", "/\u8f6c\u5708", "/\u78d5\u5934", "/\u56de\u5934", "/\u8df3\u7ef3", "/\u6fc0\u52a8", "/\u8857\u821e", "/\u732e\u543b", "/\u5de6\u592a\u6781", "/\u53f3\u592a\u6781", "/\u95ed\u5634", "/\u62db\u8d22\u8fdb\u5b9d", "/\u53cc\u559c", "/\u97ad\u70ae", "/\u706f\u7b3c", "/\u53d1\u8d22", "/K\u6b4c", "/\u8d2d\u7269", "/\u90ae\u4ef6", "/\u5e05", "/\u559d\u5f69", "/\u7948\u7977", "/\u7206\u7b4b", "/\u68d2\u68d2\u7cd6", "/\u559d\u5976", "/\u4e0b\u9762", "/\u9999\u8549", "/\u98de\u673a", "/\u5f00\u8f66", "/\u9ad8\u94c1\u5de6\u8f66\u5934", "/\u8f66\u53a2", "/\u9ad8\u94c1\u53f3\u8f66\u5934", "/\u591a\u4e91", "/\u4e0b\u96e8", "/\u949e\u7968", "/\u718a\u732b", "/\u706f\u6ce1", "/\u98ce\u8f66", "/\u95f9\u949f", "/\u6253\u4f1e", "/\u5f69\u7403", "/\u94bb\u6212", "/\u6c99\u53d1", "/\u7eb8\u5dfe", "/\u836f", "/\u624b\u67aa", "/\u9752\u86d9", "/\u4e0d\u5f00\u5fc3", "/\u554a", "/\u60f6\u6050", "/\u51b7\u6f20", "/\u5443", "/\u597d\u68d2", "/\u62dc\u6258", "/\u70b9\u8d5e", "/\u65e0\u804a", "/\u6258\u8138", "/\u5403", "/\u9001\u82b1", "/\u5bb3\u6015", "/\u82b1\u75f4", "/\u5c0f\u6837\u513f", "/\u8138\u7ea2", "/\u98d9\u6cea", "/\u6211\u4e0d\u770b", "/\u6258\u816e", "/\u54c7\u54e6", "/\u8336", "/\u7728\u773c\u775b", "/\u6cea\u5954", "/\u65e0\u5948", "/\u5356\u840c", "/\u5c0f\u7ea0\u7ed3", "/\u55b7\u8840", "/\u659c\u773c\u7b11", "/doge", "/\u60ca\u559c", "/\u9a9a\u6270", "/\u7b11\u54ed", "/\u6211\u6700\u7f8e", "/\u6cb3\u87f9", "/\u7f8a\u9a7c", "/\u6817\u5b50", "/\u5e7d\u7075", "/\u86cb", "/\u9a6c\u8d5b\u514b", "/\u83ca\u82b1", "/\u80a5\u7682", "/\u7ea2\u5305", "/\u5927\u7b11", "/\u5575\u5575", "/\u7cca\u8138", "/\u62cd\u5934", "/\u626f\u4e00\u626f", "/\u8214\u4e00\u8214", "/\u8e6d\u4e00\u8e6d", "/\u62fd\u70b8\u5929", "/\u9876\u5471\u5471", "/\u62b1\u62b1", "/\u66b4\u51fb", "/\u5f00\u67aa", "/\u64a9\u4e00\u64a9", "/\u62cd\u684c", "/\u62cd\u624b", "/\u606d\u559c", "/\u5e72\u676f", "/\u5632\u8bbd", "/\u54fc", "/\u4f5b\u7cfb", "/\u6390\u4e00\u6390", "/\u60ca\u5446", "/\u98a4\u6296", "/\u5543\u5934", "/\u5077\u770b", "/\u6247\u8138", "/\u539f\u8c05", "/\u55b7\u8138", "/\u751f\u65e5\u5feb\u4e50", "/\u5934\u649e\u51fb", "/\u7529\u5934", "/\u6254\u72d7", "/\u52a0\u6cb9\u5fc5\u80dc", "/\u52a0\u6cb9\u62b1\u62b1", "/\u53e3\u7f69\u62a4\u4f53"};

        /* renamed from: a, reason: collision with root package name */
        public String f418542a;

        /* renamed from: b, reason: collision with root package name */
        public String f418543b;

        /* renamed from: c, reason: collision with root package name */
        public String f418544c;

        /* renamed from: d, reason: collision with root package name */
        public int f418545d;

        /* renamed from: e, reason: collision with root package name */
        public int f418546e;

        /* renamed from: f, reason: collision with root package name */
        public int f418547f;

        public String toString() {
            return this.f418544c + ", (" + this.f418546e + ", " + this.f418547f + "), mode=" + this.f418545d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        public String a(String str, boolean z16) {
            int i3;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            return ChnToSpell.d(str, i3);
        }
    }

    public static boolean a(String str) {
        return Pattern.compile("[\u4e00-\u9fa5]{1}").matcher(str).find();
    }

    public static boolean b(String str) {
        return Pattern.compile("[a-zA-Z]{1}").matcher(str).find();
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0624 A[LOOP:3: B:58:0x01b2->B:180:0x0624, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x063d A[EDGE_INSN: B:181:0x063d->B:182:0x063d BREAK  A[LOOP:3: B:58:0x01b2->B:180:0x0624], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x063d A[EDGE_INSN: B:215:0x063d->B:182:0x063d BREAK  A[LOOP:3: B:58:0x01b2->B:180:0x0624], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C10827a> c(String str, String str2, int i3, int i16, int i17, b bVar) {
        Pattern pattern;
        int i18;
        boolean z16;
        C10827a c10827a;
        boolean z17;
        int i19;
        int indexOf;
        boolean z18;
        int length;
        char c16;
        boolean equals;
        Iterator it;
        String a16;
        ArrayList arrayList;
        int indexOf2;
        int i26;
        String str3;
        ArrayList arrayList2;
        char c17;
        Iterator it5;
        ArrayList arrayList3;
        String a17;
        int indexOf3;
        int indexOf4;
        b bVar2 = bVar;
        if (TextUtils.isEmpty(str) || str2 == null) {
            return null;
        }
        ArrayList arrayList4 = new ArrayList();
        int i27 = 1;
        if (b(str)) {
            Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(str);
            ArrayList arrayList5 = new ArrayList();
            int i28 = 0;
            int i29 = 0;
            while (matcher.find()) {
                C10827a c10827a2 = new C10827a();
                c10827a2.f418544c = matcher.group();
                c10827a2.f418546e = matcher.start();
                c10827a2.f418547f = matcher.end();
                if (c10827a2.f418546e > i29) {
                    C10827a c10827a3 = new C10827a();
                    c10827a3.f418544c = str.substring(i29, c10827a2.f418546e);
                    c10827a3.f418546e = i29;
                    c10827a3.f418547f = c10827a2.f418546e;
                    arrayList5.add(c10827a3);
                }
                arrayList5.add(c10827a2);
                i29 = c10827a2.f418547f;
            }
            if (i29 < str.length()) {
                C10827a c10827a4 = new C10827a();
                c10827a4.f418544c = str.substring(i29);
                c10827a4.f418546e = i29;
                c10827a4.f418547f = str.length();
                arrayList5.add(c10827a4);
            }
            StringBuilder sb5 = new StringBuilder();
            boolean z19 = bVar2 != null && (i17 & 12) > 0;
            String str4 = z19 ? "[a-zA-Z\u4e00-\u9fa5]" : "[a-zA-Z]";
            boolean z26 = (i17 & 2) > 0;
            Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                C10827a c10827a5 = (C10827a) it6.next();
                if (b("" + c10827a5.f418544c.charAt(0))) {
                    if (z26) {
                        c10827a5.f418544c = c10827a5.f418544c.toLowerCase();
                    }
                    if (arrayList5.size() == i27) {
                        sb5.append("(" + str4 + "+)");
                    } else if (z19 && (i17 & 8) > 0) {
                        sb5.append("(" + str4 + "{1," + (c10827a5.f418547f - c10827a5.f418546e) + "})");
                    } else {
                        sb5.append("(" + str4 + "{" + (c10827a5.f418547f - c10827a5.f418546e) + "})");
                    }
                } else {
                    sb5.append(Pattern.quote(c10827a5.f418544c));
                }
                i27 = 1;
            }
            Matcher matcher2 = Pattern.compile(sb5.toString()).matcher(str2);
            Pattern compile = Pattern.compile("[\u4e00-\u9fa5]{1}");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("");
            sb6.append(((C10827a) arrayList5.get(0)).f418544c.charAt(0));
            int i36 = !b(sb6.toString()) ? 1 : 0;
            boolean z27 = z19;
            boolean z28 = z26;
            while (arrayList4.size() < i16 && matcher2.find()) {
                C10827a c10827a6 = new C10827a();
                c10827a6.f418546e = matcher2.start();
                c10827a6.f418547f = matcher2.end();
                int i37 = i28;
                int i38 = 1;
                boolean z29 = true;
                boolean z36 = z27;
                boolean z37 = z28;
                while (arrayList4.size() < i16 && i38 <= matcher2.groupCount()) {
                    String group = matcher2.group(i38);
                    C10827a c10827a7 = c10827a6;
                    C10827a c10827a8 = (C10827a) arrayList5.get(((i38 - 1) * 2) + i36);
                    if (z37) {
                        i37 |= 2;
                        group = group.toLowerCase();
                    }
                    i18 = i36;
                    if (a(group)) {
                        z17 = z37;
                        if (arrayList5.size() != 1) {
                            pattern = compile;
                            ArrayList arrayList6 = arrayList5;
                            if (!z36) {
                                z16 = z36;
                                c10827a = c10827a7;
                                arrayList5 = arrayList6;
                                i19 = 0;
                                z29 = false;
                                break;
                            }
                            if ((i17 & 4) > 0 && (a16 = bVar2.a(group, true)) != null && ((z29 = z29 & a16.equals(c10827a8.f418544c)))) {
                                i37 |= 4;
                            }
                            if (!z29 && (i17 & 8) > 0) {
                                String a18 = bVar2.a(group, false);
                                if (a18 != null) {
                                    i37 |= 8;
                                    arrayList5 = arrayList6;
                                    if (c10827a8 != arrayList5.get(0) && c10827a8 != arrayList5.get(arrayList5.size() - 1)) {
                                        z29 = a18.equals(c10827a8.f418544c) & z29;
                                        z18 = z36;
                                        c10827a = c10827a7;
                                    } else {
                                        Pattern pattern2 = pattern;
                                        Matcher matcher3 = pattern2.matcher(group);
                                        ArrayList<int[]> arrayList7 = new ArrayList();
                                        int i39 = 0;
                                        boolean z38 = z36;
                                        while (matcher3.find()) {
                                            Pattern pattern3 = pattern2;
                                            boolean z39 = z38;
                                            String a19 = bVar2.a(matcher3.group(), false);
                                            if (a19 != null && a19.length() > 1) {
                                                arrayList7.add(new int[]{matcher3.start() + i39, a19.length()});
                                                i39 += a19.length() - 1;
                                            }
                                            bVar2 = bVar;
                                            z38 = z39;
                                            pattern2 = pattern3;
                                        }
                                        pattern = pattern2;
                                        z16 = z38;
                                        if (c10827a8 == arrayList5.get(0)) {
                                            length = a18.length() - c10827a8.f418544c.length();
                                            equals = a18.substring(length).equals(c10827a8.f418544c);
                                            c16 = 0;
                                        } else {
                                            length = c10827a8.f418544c.length();
                                            c16 = 0;
                                            equals = a18.substring(0, length).equals(c10827a8.f418544c);
                                        }
                                        if (equals) {
                                            Iterator it7 = arrayList7.iterator();
                                            while (it7.hasNext()) {
                                                int[] iArr = (int[]) it7.next();
                                                int i46 = iArr[c16];
                                                boolean z46 = (length <= i46 || length >= i46 + iArr[1]) & equals;
                                                if ((i17 & 16) == 0) {
                                                    it = it7;
                                                    z46 &= str.length() + length <= iArr[0] || str.length() + length >= iArr[0] + iArr[1];
                                                } else {
                                                    it = it7;
                                                }
                                                equals = z46;
                                                if (!equals) {
                                                    break;
                                                }
                                                it7 = it;
                                                c16 = 0;
                                            }
                                        }
                                        if (equals && c10827a8 == arrayList5.get(0)) {
                                            c10827a = c10827a7;
                                            c10827a.f418546e = matcher2.end(i38) - c10827a8.f418544c.length();
                                            for (int[] iArr2 : arrayList7) {
                                                if (length <= iArr2[0]) {
                                                    c10827a.f418546e += iArr2[1] - 1;
                                                }
                                            }
                                        } else {
                                            c10827a = c10827a7;
                                            if (equals) {
                                                c10827a.f418547f = matcher2.start(i38) + c10827a8.f418544c.length();
                                                for (int[] iArr3 : arrayList7) {
                                                    int i47 = iArr3[1];
                                                    if (length > i47) {
                                                        c10827a.f418547f -= i47 - 1;
                                                    } else {
                                                        int i48 = iArr3[0];
                                                        if (length > i48 && (i17 & 16) > 0) {
                                                            c10827a.f418547f -= (i48 - length) - 1;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i19 = 0;
                                        z29 = equals;
                                    }
                                } else {
                                    i19 = 0;
                                    z16 = z36;
                                    c10827a = c10827a7;
                                    arrayList5 = arrayList6;
                                }
                                if (!z29) {
                                    break;
                                }
                            } else {
                                z18 = z36;
                                c10827a = c10827a7;
                                arrayList5 = arrayList6;
                            }
                            i19 = 0;
                            z16 = z18;
                            if (!z29) {
                            }
                        } else {
                            int i49 = 0;
                            while (arrayList4.size() < i16 && (indexOf4 = group.indexOf(c10827a8.f418544c, i49)) != -1) {
                                int length2 = str.length() + indexOf4;
                                C10827a c10827a9 = new C10827a();
                                c10827a9.f418542a = str2;
                                c10827a9.f418543b = str;
                                int start = matcher2.start(i38) + indexOf4;
                                c10827a9.f418546e = start;
                                int length3 = start + str.length();
                                c10827a9.f418547f = length3;
                                c10827a9.f418544c = str2.substring(c10827a9.f418546e, length3);
                                c10827a9.f418545d = i37 == 0 ? 1 : i37;
                                arrayList4.add(c10827a9);
                                i49 = length2;
                            }
                            if (z36 && (i17 & 4) > 0 && arrayList4.size() < i16 && (a17 = bVar2.a(group, true)) != null) {
                                int i56 = 0;
                                while (arrayList4.size() < i16 && (indexOf3 = a17.indexOf(c10827a8.f418544c, i56)) != -1) {
                                    int length4 = str.length() + indexOf3;
                                    String str5 = a17;
                                    C10827a c10827a10 = new C10827a();
                                    c10827a10.f418542a = str2;
                                    c10827a10.f418543b = str;
                                    int start2 = matcher2.start(i38) + indexOf3;
                                    c10827a10.f418546e = start2;
                                    int length5 = start2 + str.length();
                                    c10827a10.f418547f = length5;
                                    c10827a10.f418544c = str2.substring(c10827a10.f418546e, length5);
                                    c10827a10.f418545d = i37 | 4;
                                    arrayList4.add(c10827a10);
                                    a17 = str5;
                                    i56 = length4;
                                }
                            }
                            if (z36 && (i17 & 8) > 0 && arrayList4.size() < i16) {
                                boolean z47 = false;
                                String a26 = bVar2.a(group, false);
                                if (a26 != null) {
                                    Matcher matcher4 = compile.matcher(group);
                                    ArrayList arrayList8 = new ArrayList();
                                    int i57 = 0;
                                    while (matcher4.find()) {
                                        Pattern pattern4 = compile;
                                        String a27 = bVar2.a(matcher4.group(), z47);
                                        if (a27 != null) {
                                            arrayList3 = arrayList5;
                                            if (a27.length() > 1) {
                                                arrayList8.add(new int[]{matcher4.start() + i57, a27.length()});
                                                i57 += a27.length() - 1;
                                            }
                                        } else {
                                            arrayList3 = arrayList5;
                                        }
                                        compile = pattern4;
                                        arrayList5 = arrayList3;
                                        z47 = false;
                                    }
                                    pattern = compile;
                                    arrayList = arrayList5;
                                    int i58 = 0;
                                    while (arrayList4.size() < i16 && (indexOf2 = a26.indexOf(c10827a8.f418544c, i58)) != -1) {
                                        int length6 = str.length() + indexOf2;
                                        Iterator it8 = arrayList8.iterator();
                                        boolean z48 = false;
                                        while (true) {
                                            if (!it8.hasNext()) {
                                                i26 = length6;
                                                break;
                                            }
                                            int[] iArr4 = (int[]) it8.next();
                                            i26 = length6;
                                            int i59 = iArr4[0];
                                            boolean z49 = (indexOf2 > i59 && indexOf2 < i59 + iArr4[1]) | z48;
                                            if ((i17 & 16) == 0) {
                                                it5 = it8;
                                                z49 |= str.length() + indexOf2 > iArr4[0] && str.length() + indexOf2 < iArr4[0] + iArr4[1];
                                            } else {
                                                it5 = it8;
                                            }
                                            z48 = z49;
                                            if (z48) {
                                                break;
                                            }
                                            length6 = i26;
                                            it8 = it5;
                                        }
                                        if (z48) {
                                            str3 = a26;
                                            arrayList2 = arrayList8;
                                        } else {
                                            C10827a c10827a11 = new C10827a();
                                            c10827a11.f418542a = str2;
                                            c10827a11.f418543b = str;
                                            int start3 = matcher2.start(i38) + indexOf2;
                                            c10827a11.f418546e = start3;
                                            c10827a11.f418547f = start3 + str.length();
                                            Iterator it9 = arrayList8.iterator();
                                            while (true) {
                                                if (!it9.hasNext()) {
                                                    str3 = a26;
                                                    break;
                                                }
                                                int[] iArr5 = (int[]) it9.next();
                                                Iterator it10 = it9;
                                                if (indexOf2 > iArr5[0]) {
                                                    c17 = 1;
                                                    c10827a11.f418546e -= iArr5[1] - 1;
                                                } else {
                                                    c17 = 1;
                                                }
                                                int length7 = str.length() + indexOf2;
                                                int i65 = iArr5[0];
                                                int i66 = iArr5[c17];
                                                str3 = a26;
                                                if (length7 <= i65 + i66) {
                                                    if ((i17 & 16) <= 0) {
                                                        break;
                                                    }
                                                    arrayList2 = arrayList8;
                                                    if (str.length() + indexOf2 <= iArr5[0]) {
                                                        break;
                                                    }
                                                    c10827a11.f418547f -= ((str.length() + indexOf2) - iArr5[0]) - 1;
                                                } else {
                                                    c10827a11.f418547f -= i66 - 1;
                                                    arrayList2 = arrayList8;
                                                }
                                                it9 = it10;
                                                arrayList8 = arrayList2;
                                                a26 = str3;
                                            }
                                            arrayList2 = arrayList8;
                                            c10827a11.f418544c = str2.substring(c10827a11.f418546e, c10827a11.f418547f);
                                            c10827a11.f418545d = i37 | 8;
                                            arrayList4.add(c10827a11);
                                        }
                                        i58 = i26;
                                        arrayList8 = arrayList2;
                                        a26 = str3;
                                    }
                                    z16 = z36;
                                    c10827a = c10827a7;
                                    arrayList5 = arrayList;
                                    i19 = 0;
                                    z29 = false;
                                }
                            }
                            pattern = compile;
                            arrayList = arrayList5;
                            z16 = z36;
                            c10827a = c10827a7;
                            arrayList5 = arrayList;
                            i19 = 0;
                            z29 = false;
                        }
                        if (z29) {
                            break;
                        }
                        i38++;
                        bVar2 = bVar;
                        c10827a6 = c10827a;
                        i36 = i18;
                        z37 = z17;
                        z36 = z16;
                        compile = pattern;
                    } else {
                        pattern = compile;
                        z16 = z36;
                        z17 = z37;
                        c10827a = c10827a7;
                        i19 = 0;
                        if (arrayList5.size() == 1) {
                            int i67 = 0;
                            while (arrayList4.size() < i16 && (indexOf = group.indexOf(c10827a8.f418544c, i67)) != -1) {
                                i67 = str.length() + indexOf;
                                C10827a c10827a12 = new C10827a();
                                c10827a12.f418542a = str2;
                                c10827a12.f418543b = str;
                                int start4 = matcher2.start(i38) + indexOf;
                                c10827a12.f418546e = start4;
                                int length8 = start4 + str.length();
                                c10827a12.f418547f = length8;
                                c10827a12.f418544c = str2.substring(c10827a12.f418546e, length8);
                                c10827a12.f418545d = i37 == 0 ? 1 : i37;
                                arrayList4.add(c10827a12);
                            }
                            z29 = false;
                        } else {
                            z29 &= group.equals(c10827a8.f418544c);
                            if (!z29) {
                                break;
                            }
                        }
                        if (z29) {
                        }
                    }
                }
                pattern = compile;
                i18 = i36;
                z16 = z36;
                c10827a = c10827a6;
                z17 = z37;
                i19 = 0;
                int i68 = i37;
                if (z29) {
                    c10827a.f418542a = str2;
                    c10827a.f418543b = str;
                    c10827a.f418544c = str2.substring(c10827a.f418546e, c10827a.f418547f);
                    if (i68 == 0) {
                        i68 = 1;
                    }
                    c10827a.f418545d = i68;
                    arrayList4.add(c10827a);
                }
                bVar2 = bVar;
                i28 = i19;
                i36 = i18;
                z28 = z17;
                z27 = z16;
                compile = pattern;
            }
        } else {
            Matcher matcher5 = Pattern.compile(Pattern.quote(str)).matcher(str2);
            while (matcher5.find() && arrayList4.size() < i16) {
                C10827a c10827a13 = new C10827a();
                c10827a13.f418542a = str2;
                c10827a13.f418543b = str;
                c10827a13.f418544c = str;
                c10827a13.f418545d = 1;
                int start5 = matcher5.start();
                c10827a13.f418546e = start5;
                c10827a13.f418547f = start5 + str.length();
                arrayList4.add(c10827a13);
            }
        }
        if (arrayList4.size() > 0) {
            return arrayList4;
        }
        return null;
    }
}
