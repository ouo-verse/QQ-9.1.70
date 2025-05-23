package com.tencent.biz.subscribe.comment;

import com.tencent.mobileqq.R;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class o {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<String, Integer> f96038i;

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<String, Integer> f96039j;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f96030a = Pattern.compile("<uin:.*?,nickname:.*?>");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f96031b = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);

    /* renamed from: c, reason: collision with root package name */
    public static boolean f96032c = true;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f96033d = {"[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[em]e175[/em]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f96034e = {"[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[/\u94b1]", "[em]e175[/em]", "[/\u7f8e\u5973]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]", "[em]e121001[/em]", "[em]e121002[/em]", "[em]e121003[/em]", "[em]e121005[/em]", "[em]e121009[/em]", "[em]e121010[/em]", "[em]e121011[/em]", "[em]e121012[/em]", "[em]e121013[/em]", "[em]e121016[/em]", "[em]e121023[/em]", "[em]e121033[/em]", "[em]e121034[/em]", "[em]e241[/em]", "[em]e242[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e245[/em]", "[em]e246[/em]", "[em]e247[/em]", "[em]e248[/em]", "[em]e249[/em]", "[em]e250[/em]", "[em]e251[/em]", "[em]e252[/em]", "[em]e253[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e256[/em]", "[em]e257[/em]", "[em]e258[/em]", "[em]e259[/em]", "[em]e260[/em]", "[em]e261[/em]", "[em]e262[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e265[/em]", "[em]e266[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[em]e279[/em]", "[em]e280[/em]", "[em]e281[/em]", "[em]e282[/em]", "[em]e283[/em]", "[em]e284[/em]", "[em]e285[/em]", "[em]e286[/em]", "[em]e287[/em]", "[em]e288[/em]", "[em]e289[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e292[/em]", "[em]e293[/em]", "[em]e295[/em]", "[em]e296[/em]", "[em]e297[/em]", "[em]e294[/em]", "[em]e298[/em]"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f96035f = {"[em]e252[/em]", "[em]e249[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e282[/em]", "[em]e245[/em]", "[em]e248[/em]", "[em]e247[/em]", "[em]e250[/em]", "[em]e246[/em]", "[em]e241[/em]", "[em]e205[/em]", "[em]e206[/em]", "[em]e207[/em]", "[em]e209[/em]", "[em]e213[/em]", "[em]e215[/em]", "[em]e216[/em]", "[em]e217[/em]", "[em]e220[/em]", "[em]e227[/em]", "[em]e237[/em]", "[em]e238[/em]", "[em]e258[/em]", "[em]e262[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e260[/em]", "[em]e257[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[em]e280[/em]", "[em]e281[/em]"};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f96036g = {R.drawable.bom, R.drawable.bow, R.drawable.bot, R.drawable.bon, R.drawable.boo, R.drawable.boj, R.drawable.bop, R.drawable.bos, R.drawable.bor, R.drawable.bou, R.drawable.bov, R.drawable.mbb, R.drawable.mbc, R.drawable.mbd, R.drawable.mbf, R.drawable.mbj, R.drawable.mbl, R.drawable.mbm, R.drawable.mbn, R.drawable.mbq, R.drawable.mbx, R.drawable.mc7, R.drawable.mc8, R.drawable.f160708bp2, R.drawable.bp6, R.drawable.boy, R.drawable.boz, R.drawable.f160710bp4, R.drawable.f160707bp1, R.drawable.bp7, R.drawable.f160703bo2, R.drawable.bo5, R.drawable.bo6, R.drawable.bo7, R.drawable.bo8, R.drawable.bo9, R.drawable.bo_, R.drawable.boa, R.drawable.bob, R.drawable.boc, R.drawable.bod, R.drawable.boe, R.drawable.bof, R.drawable.boh, R.drawable.boi};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f96037h = {R.drawable.blo, R.drawable.blp, R.drawable.blq, R.drawable.blr, R.drawable.bls, R.drawable.blt, R.drawable.blu, R.drawable.mas, R.drawable.mat, R.drawable.blv, R.drawable.blw, R.drawable.blx, R.drawable.bly, R.drawable.blz, R.drawable.f160681bm0, R.drawable.f160682bm1, R.drawable.mau, R.drawable.f160683bm2, R.drawable.f160684bm3, R.drawable.f160685bm4, R.drawable.bm5, R.drawable.bm6, R.drawable.bm7, R.drawable.bm8, R.drawable.bm9, R.drawable.bm_, R.drawable.bma, R.drawable.bmb, R.drawable.mav, R.drawable.bmc, R.drawable.bmd, R.drawable.bme, R.drawable.maw, R.drawable.bmf, R.drawable.bmg, R.drawable.bmh, R.drawable.bmi, R.drawable.bmj, R.drawable.bmk, R.drawable.max, R.drawable.bml, R.drawable.bmm, R.drawable.bmn, R.drawable.bmo, R.drawable.bmp, R.drawable.bmq, R.drawable.bmr, R.drawable.may, R.drawable.bms, R.drawable.bmt, R.drawable.bmu, R.drawable.bmv, R.drawable.bmw, R.drawable.bmx, R.drawable.bmy, R.drawable.bmz, R.drawable.f160686bn0, R.drawable.maz, R.drawable.f160687mb0, R.drawable.f160688bn1, R.drawable.f160689mb1, R.drawable.f160690bn2, R.drawable.f160691bn3, R.drawable.f160692bn4, R.drawable.f160693mb2, R.drawable.bn5, R.drawable.bn6, R.drawable.f160694mb3, R.drawable.f160695mb4, R.drawable.mb5, R.drawable.bn7, R.drawable.mb6, R.drawable.bn8, R.drawable.bn9, R.drawable.bn_, R.drawable.mb7, R.drawable.mb8, R.drawable.bna, R.drawable.mb9, R.drawable.bnb, R.drawable.mb_, R.drawable.bnc, R.drawable.bnd, R.drawable.bne, R.drawable.bnf, R.drawable.bng, R.drawable.bnh, R.drawable.bni, R.drawable.bnj, R.drawable.bnk, R.drawable.bnl, R.drawable.bnm, R.drawable.bnn, R.drawable.bno, R.drawable.bnp, R.drawable.bnq, R.drawable.bnr, R.drawable.bns, R.drawable.bnt, R.drawable.bnu, R.drawable.bnv, R.drawable.bnw, R.drawable.bnx, R.drawable.bny, R.drawable.bnz, R.drawable.f160696bo0, R.drawable.f160697bo1, R.drawable.mbb, R.drawable.mbc, R.drawable.mbd, R.drawable.mbe, R.drawable.mbf, R.drawable.mbg, R.drawable.mbh, R.drawable.mbi, R.drawable.mbj, R.drawable.mbk, R.drawable.mbl, R.drawable.mbm, R.drawable.mbn, R.drawable.mbo, R.drawable.mbp, R.drawable.mbq, R.drawable.mbr, R.drawable.mbs, R.drawable.mbt, R.drawable.mbu, R.drawable.mbv, R.drawable.mbw, R.drawable.mbx, R.drawable.mby, R.drawable.mbz, R.drawable.f160698mc0, R.drawable.f160699mc1, R.drawable.f160700mc2, R.drawable.f160701mc3, R.drawable.f160702mc4, R.drawable.mc5, R.drawable.mc6, R.drawable.mc7, R.drawable.mc8, R.drawable.mc9};

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f96040k = Pattern.compile("@?\\{uid:.*?\\}");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f96041l = Pattern.compile("#?\\{id:.*?,title:.*?\\}#");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f96042m = Pattern.compile("\\{url:.*?,text:.*?\\}");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f96043n = Pattern.compile("\\[/(.+?)\\]", 2);

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f96044o = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f96045p = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f96046q = Pattern.compile("\\{text:.*?,color:.*?\\}");

    /* renamed from: r, reason: collision with root package name */
    public static String f96047r = QzoneEmotionUtils.SIGN_ICON_URL_END;

    static {
        c();
        d();
    }

    public static int a(String str) {
        Integer num;
        HashMap<String, Integer> hashMap = f96038i;
        if (hashMap != null && (num = hashMap.get(str)) != null) {
            return num.intValue();
        }
        return -1;
    }

    public static int b(String str) {
        Integer num;
        HashMap<String, Integer> hashMap = f96039j;
        if (hashMap == null || !hashMap.containsKey(str) || (num = f96039j.get(str)) == null) {
            return -2;
        }
        return num.intValue();
    }

    private static void c() {
        f96038i = new HashMap<>();
        int i3 = 0;
        while (true) {
            String[] strArr = f96034e;
            if (i3 < strArr.length) {
                f96038i.put(strArr[i3], Integer.valueOf(i3));
                i3++;
            } else {
                return;
            }
        }
    }

    private static void d() {
        if (f96039j == null) {
            f96039j = new HashMap<>();
            int i3 = 0;
            while (true) {
                String[] strArr = f96035f;
                if (i3 < strArr.length) {
                    f96039j.put(strArr[i3], Integer.valueOf(i3));
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
