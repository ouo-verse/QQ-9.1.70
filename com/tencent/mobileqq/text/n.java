package com.tencent.mobileqq.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.utils.cg;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f292692a;

    /* renamed from: b, reason: collision with root package name */
    static String f292693b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f292694c;

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f292695d;

    /* renamed from: e, reason: collision with root package name */
    static final Pattern f292696e;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f292697f;

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f292698g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f292699h;

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f292700i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f292701j;

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f292702k;

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f292703l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f292692a = Pattern.compile("(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)");
        f292693b = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
        f292694c = Pattern.compile("[\\d]{5,15}");
        f292695d = Pattern.compile("[\\d,]+");
        f292696e = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
        f292697f = Pattern.compile(f292693b);
        f292698g = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
        String str = cg.f307524c.pattern() + "|" + cg.f307525d.pattern() + "|[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+|(?=.*,)(?=.*#)(\\+*[0-9]+[\\-,]*)?(\\([0-9]+\\)[\\-,]*)?([0-9][0-9\\-,][0-9\\-,#]+#)|" + cg.f307530i + "|[\\d]{5,15}|" + f292693b;
        f292699h = str;
        f292700i = Pattern.compile(str, 2);
        Pattern pattern = IHashTagSearchLinkApi.HASHTAG_LINK_PATTERN;
        f292701j = pattern;
        f292702k = Pattern.compile("[a-zA-Z0-9" + IHashTagSearchLinkApi.GOOD_HASHTAG_CHAR + "]", 2);
        f292703l = Pattern.compile(str + "|" + pattern, 2);
    }

    private static boolean a(String str) {
        if (str != null && !"".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean b(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return true;
        }
        return false;
    }

    public static List<d> c(String str, boolean z16, Set<Integer> set) {
        Pattern pattern;
        Pattern pattern2;
        ArrayList arrayList = new ArrayList();
        if (a(str)) {
            return arrayList;
        }
        if (z16) {
            pattern = f292702k;
        } else {
            pattern = cg.f307523b;
        }
        if (!pattern.matcher(str).find()) {
            return arrayList;
        }
        if (z16) {
            pattern2 = f292703l;
        } else {
            pattern2 = f292700i;
        }
        Matcher matcher = pattern2.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String substring = str.substring(start, end);
            if (!d(5, set) || !cg.f307530i.matcher(substring).find()) {
                if (d(3, set)) {
                    if (cg.f307524c.matcher(substring).find()) {
                        arrayList.add(new d(substring, start, end));
                    } else if (cg.f307525d.matcher(substring).find()) {
                        arrayList.add(new d(substring, start, end));
                    }
                }
                if (d(2, set) && f292692a.matcher(substring).find()) {
                    arrayList.add(new d(substring, start, end));
                } else if (z16 && f292701j.matcher(substring).find()) {
                    arrayList.add(new d(substring, start, end));
                } else if (d(1, set)) {
                    if (f292695d.matcher(substring).find()) {
                        int i3 = end - start;
                        if (i3 >= 5 && i3 <= 16) {
                            Matcher matcher2 = f292696e.matcher(substring);
                            if (i3 != 5 || matcher2.find()) {
                                if (start <= 0 || !b(str.charAt(start - 1))) {
                                    if (end >= str.length() || !b(str.charAt(end))) {
                                        arrayList.add(new d(substring, start, end));
                                    }
                                }
                            }
                        }
                    } else {
                        arrayList.add(new d(substring, start, end));
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean d(int i3, Set<Integer> set) {
        if (set != null && set.contains(Integer.valueOf(i3))) {
            return false;
        }
        return true;
    }
}
