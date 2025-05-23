package lp;

import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<String, Integer> f415320g;

    /* renamed from: h, reason: collision with root package name */
    private static HashMap<String, String> f415321h;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f415314a = Pattern.compile("<uin:.*?,nick(name):.*?>(?#NICK_PATTERN)|@?\\{uin:.*?\\}(?#AT_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[em\\]e\\d{1,}\\[/em\\](?#SMILEY_PATTERN)|\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\](?#QUICK_SMILEY_PATTERN)|\\{text:.*?,color:.*?\\}(?#COLOR_PATTERN)|\\[hlt\\].*?\\[/hlt\\](?#HIGHLIGHT_PATTERN)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f415315b = Pattern.compile("<uin:.*?,nick(name):.*?>(?#NICK_PATTERN)|@?\\{uin:.*?\\}(?#AT_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[em\\]e\\d{1,}\\[/em\\](?#SMILEY_PATTERN)|\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\](?#QUICK_SMILEY_PATTERN)|\\{text:.*?,color:.*?\\}(?#COLOR_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[hlt\\].*?\\[/hlt\\](?#HIGHLIGHT_PATTERN)");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f415316c = Pattern.compile("<uin:.*?,nick(name):.*?>");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f415317d = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);

    /* renamed from: e, reason: collision with root package name */
    public static boolean f415318e = true;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f415319f = {"[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[em]e175[/em]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f415322i = {":-)", ":-(", ";-)", ":-P", "=-O", ":-*", ":O", "B-)", ":-$", ":-!", ":-[", "O:-)", ":'(", ":-X", ":-D", "o_O"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f415323j = {"\u1f601", "\u1f614", "\u1f60a", "\u1f61c", "\u1f633", "\u1f444", "\u1f631", "\u1f60c", "\u1f60d", "\u1f623", "\u1f613", "\u1f60f", "\u1f62d", "\u1f612", "\u1f604", "\u1f616"};

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f415324k = Pattern.compile("@?\\{uin:.*?\\}");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f415325l = Pattern.compile("\\{url:.*?,text:.*?\\}");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f415326m = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f415327n = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f415328o = Pattern.compile("\\{text:.*?,color:.*?\\}");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f415329p = Pattern.compile("\\[hlt\\].*?\\[/hlt\\]", 2);

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f415330q = Pattern.compile("[\u1f000-\u1f3ff]|[\u1f400-\u1f7ff]|[\u2600-\u27ff]", 66);

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f415331r = Pattern.compile("\\{topic:.*?,url:.*?\\}");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f415332s = Pattern.compile("\\[dra\\].*?\\[/dra\\]", 2);

    static {
        b();
        a();
    }

    private static void a() {
        f415321h = new HashMap<>();
        int i3 = 0;
        while (true) {
            String[] strArr = f415322i;
            if (i3 >= strArr.length) {
                return;
            }
            f415321h.put(strArr[i3], f415323j[i3]);
            i3++;
        }
    }

    private static void b() {
        f415320g = new HashMap<>();
        int i3 = 0;
        while (true) {
            String[] strArr = f415319f;
            if (i3 >= strArr.length) {
                return;
            }
            f415320g.put(strArr[i3], Integer.valueOf(i3));
            i3++;
        }
    }
}
