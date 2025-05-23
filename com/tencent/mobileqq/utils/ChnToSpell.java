package com.tencent.mobileqq.utils;

import SLICE_UPLOAD.cnst.appid_qun;
import android.text.TextUtils;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ads.data.AdParam;
import com.tencent.cache.api.Business;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChnToSpell {

    /* renamed from: e, reason: collision with root package name */
    private static short[] f306898e;

    /* renamed from: g, reason: collision with root package name */
    private static com.tencent.cache.api.collection.a<String, b> f306900g;

    /* renamed from: h, reason: collision with root package name */
    private static com.tencent.cache.api.collection.a<String, b> f306901h;

    /* renamed from: i, reason: collision with root package name */
    private static com.tencent.cache.api.collection.a<String, c> f306902i;

    /* renamed from: j, reason: collision with root package name */
    private static Map<Character, List<d>> f306903j;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f306894a = {QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "a", "ai", com.tencent.av.ui.an.f75362j, "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", WidgetCacheLunarData.CHENG, "chi", WidgetCacheLunarData.CHONG, "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fu", "fou", "ga", "gai", "gan", "gang", "gao", "ge", WidgetCacheLunarData.JI, "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "jia", "jian", "jiang", "qiao", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", PoiListCacheRecord.TIMESTAMP_TYPE, "lou", "lu", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", Element.ELEMENT_NAME_MIN, "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nuan", "nue", "yao", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", AdParam.PU, "qi", "qia", "qian", "qiang", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", appid_qun.value, "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", TencentLocation.RUN_MODE, "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", WidgetCacheLunarData.SHA, "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "ye", WidgetCacheLunarData.YI, "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo", "ei", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "dia", "cen", "nou", "jv", "qv", "xv", "lv", "nv"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f306895b = {QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "a", "ai", com.tencent.av.ui.an.f75362j, "ang", "ao", "b-a", "b-ai", "b-an", "b-ang", "b-ao", "b-ei", "b-en", "b-eng", "b-i", "b-ian", "b-iao", "b-ie", "b-in", "b-ing", "b-o", "b-u", "c-a", "c-ai", "c-an", "c-ang", "c-ao", "c-e", "c-eng", "ch-a", "ch-ai", "ch-an", "ch-ang", "ch-ao", "ch-e", "ch-en", "ch-eng", "ch-i", "ch-ong", "ch-ou", "ch-u", "ch-uai", "ch-uan", "ch-uang", "ch-ui", "ch-un", "ch-uo", "c-i", "c-ong", "c-ou", "c-u", "c-uan", "c-ui", "c-un", "c-uo", "d-a", "d-ai", "d-an", "d-ang", "d-ao", "d-e", "d-eng", "d-i", "d-ian", "d-iao", "d-ie", "d-ing", "d-iu", "d-ong", "d-ou", "d-u", "d-uan", "d-ui", "d-un", "d-uo", "e", "en", "er", "f-a", "f-an", "f-ang", "f-ei", "f-en", "f-eng", "f-u", "f-ou", "g-a", "g-ai", "g-an", "g-ang", "g-ao", "g-e", "j-i", "g-en", "g-eng", "g-ong", "g-ou", "g-u", "g-ua", "g-uai", "g-uan", "g-uang", "g-ui", "g-un", "g-uo", "h-a", "h-ai", "h-an", "h-ang", "h-ao", "h-e", "h-ei", "h-en", "h-eng", "h-ong", "h-ou", "h-u", "h-ua", "h-uai", "h-uan", "h-uang", "h-ui", "h-un", "h-uo", "j-ia", "j-ian", "j-iang", "q-iao", "j-iao", "j-ie", "j-in", "j-ing", "j-iong", "j-iu", "j-u", "j-uan", "j-ue", "j-un", "k-a", "k-ai", "k-an", "k-ang", "k-ao", "k-e", "k-en", "k-eng", "k-ong", "k-ou", "k-u", "k-ua", "k-uai", "k-uan", "k-uang", "k-ui", "k-un", "k-uo", "l-a", "l-ai", "l-an", "l-ang", "l-ao", "l-e", "l-ei", "l-eng", "l-i", "l-ia", "l-ian", "l-iang", "l-iao", "l-ie", "l-in", "l-ing", "l-iu", "l-ong", "l-ou", "l-u", "l-uan", "l-ue", "l-un", "l-uo", "m-a", "m-ai", "m-an", "m-ang", "m-ao", "m-e", "m-ei", "m-en", "m-eng", "m-i", "m-ian", "m-iao", "m-ie", "m-in", "m-ing", "m-iu", "m-o", "m-ou", "m-u", "n-a", "n-ai", "n-an", "n-ang", "n-ao", "n-e", "n-ei", "n-en", "n-eng", "n-i", "n-ian", "n-iang", "n-iao", "n-ie", "n-in", "n-ing", "n-iu", "n-ong", "n-u", "n-uan", "n-ue", "y-ao", "n-uo", "o", "ou", "p-a", "p-ai", "p-an", "p-ang", "p-ao", "p-ei", "p-en", "p-eng", "p-i", "p-ian", "p-iao", "p-ie", "p-in", "p-ing", "p-o", "p-ou", "p-u", "q-i", "q-ia", "q-ian", "q-iang", "q-ie", "q-in", "q-ing", "q-iong", "q-iu", "q-u", "q-uan", "q-ue", "q-un", "r-an", "r-ang", "r-ao", "r-e", "r-en", "r-eng", "r-i", "r-ong", "r-ou", "r-u", "r-uan", "r-ui", "r-un", "r-uo", "s-a", "s-ai", "s-an", "s-ang", "s-ao", "s-e", "s-en", "s-eng", "sh-a", "sh-ai", "sh-an", "sh-ang", "sh-ao", "sh-e", "sh-en", "sh-eng", "sh-i", "sh-ou", "sh-u", "sh-ua", "sh-uai", "sh-uan", "sh-uang", "sh-ui", "sh-un", "sh-uo", "s-i", "s-ong", "s-ou", "s-u", "s-uan", "s-ui", "s-un", "s-uo", "t-a", "t-ai", "t-an", "t-ang", "t-ao", "t-e", "t-eng", "t-i", "t-ian", "t-iao", "t-ie", "t-ing", "t-ong", "t-ou", "t-u", "t-uan", "t-ui", "t-un", "t-uo", "w-a", "w-ai", "w-an", "w-ang", "w-ei", "w-en", "w-eng", "w-o", "w-u", "x-i", "x-ia", "x-ian", "x-iang", "x-iao", "x-ie", "x-in", "x-ing", "x-iong", "x-iu", "x-u", "x-uan", "x-ue", "x-un", "y-a", "y-an", "y-ang", "y-e", "y-i", "y-in", "y-ing", "y-o", "y-ong", "y-ou", "y-u", "y-uan", "y-ue", "y-un", "z-a", "z-ai", "z-an", "z-ang", "z-ao", "z-e", "z-ei", "z-en", "z-eng", "zh-a", "zh-ai", "zh-an", "zh-ang", "zh-ao", "zh-e", "zh-en", "zh-eng", "zh-i", "zh-ong", "zh-ou", "zh-u", "zh-ua", "zh-uai", "zh-uan", "zh-uang", "zh-ui", "zh-un", "zh-uo", "z-i", "z-ong", "z-ou", "z-u", "z-uan", "z-ui", "z-un", "z-uo", "ei", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "d-ia", "c-en", "n-ou", "j-v", "q-v", "x-v", "l-v", "n-v"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f306896c = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "50", "100", "500", "1000"};

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, String[]> f306897d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f306899f = {0, 47, 58, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65280, 65375, Integer.MAX_VALUE};

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f306904a;

        /* renamed from: b, reason: collision with root package name */
        public String f306905b;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f306906a;

        /* renamed from: b, reason: collision with root package name */
        public String f306907b;

        /* renamed from: c, reason: collision with root package name */
        public List<Integer> f306908c;

        /* renamed from: d, reason: collision with root package name */
        public HashSet<Integer> f306909d;

        /* renamed from: e, reason: collision with root package name */
        public HashSet<Integer> f306910e;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c extends b {

        /* renamed from: f, reason: collision with root package name */
        public String f306911f;

        /* renamed from: g, reason: collision with root package name */
        public String f306912g;

        /* renamed from: h, reason: collision with root package name */
        public String f306913h;

        /* renamed from: i, reason: collision with root package name */
        public List<Integer> f306914i;

        /* renamed from: j, reason: collision with root package name */
        public List<Integer> f306915j;

        /* renamed from: k, reason: collision with root package name */
        public List<Integer> f306916k;

        public b a() {
            b bVar = new b();
            bVar.f306907b = this.f306912g;
            bVar.f306908c = this.f306915j;
            bVar.f306906a = 2;
            return bVar;
        }

        public b b() {
            b bVar = new b();
            bVar.f306907b = this.f306911f;
            bVar.f306908c = this.f306914i;
            bVar.f306910e = this.f306910e;
            bVar.f306909d = this.f306909d;
            bVar.f306906a = 1;
            return bVar;
        }
    }

    static {
        Business business = Business.Default;
        f306900g = new com.tencent.cache.api.collection.a<>(business, "quanpin", 512);
        f306901h = new com.tencent.cache.api.collection.a<>(business, "init", 512);
        f306902i = new com.tencent.cache.api.collection.a<>(business, "all", 512);
        f306903j = new ConcurrentHashMap();
    }

    public static a b(char c16, int i3) {
        a aVar = new a();
        if (i3 == 0) {
            if (c16 == '\u5355') {
                aVar.f306904a = 5;
                aVar.f306905b = "shan";
                return aVar;
            }
            if (c16 == '\u4ec7') {
                aVar.f306904a = 5;
                aVar.f306905b = "qiu";
                return aVar;
            }
            if (c16 == '\u66fe') {
                aVar.f306904a = 5;
                aVar.f306905b = "zeng";
                return aVar;
            }
        }
        int binarySearch = Arrays.binarySearch(f306899f, (int) c16);
        if (binarySearch != -14) {
            if (binarySearch != -12) {
                if (binarySearch != -9) {
                    if (binarySearch != -7) {
                        if (binarySearch != -5) {
                            if (binarySearch != 7) {
                                if (Character.isHighSurrogate(c16)) {
                                    aVar.f306904a = 0;
                                    aVar.f306905b = "??";
                                } else {
                                    aVar.f306904a = 0;
                                    aVar.f306905b = String.valueOf(c16);
                                }
                            } else {
                                aVar.f306904a = 2;
                                aVar.f306905b = "ling";
                            }
                        } else {
                            aVar.f306904a = 4;
                            aVar.f306905b = String.valueOf(c16);
                        }
                    } else {
                        aVar.f306904a = 3;
                        aVar.f306905b = String.valueOf(c16);
                    }
                } else {
                    int i16 = c16 - '\u2160';
                    String[] strArr = f306896c;
                    if (i16 >= strArr.length) {
                        i16 -= strArr.length;
                    }
                    aVar.f306904a = 1;
                    aVar.f306905b = strArr[i16];
                }
            } else {
                aVar.f306904a = 5;
                aVar.f306905b = f306894a[f306898e[c16 - '\u4e00']];
            }
        } else {
            aVar.f306904a = 6;
            aVar.f306905b = String.valueOf(Character.toLowerCase((char) (c16 - '\ufee0')));
        }
        return aVar;
    }

    public static void c() {
        if (!f306903j.isEmpty()) {
            return;
        }
        f306903j.put('\u5355', Collections.singletonList(new d('\u5355', "shan", "sh-an")));
        f306903j.put('\u4ec7', Collections.singletonList(new d('\u4ec7', "qiu", "q-iu")));
        f306903j.put('\u66fe', Collections.singletonList(new d('\u66fe', "zeng", "z-eng")));
        f306903j.put('\u4e07', Collections.singletonList(new d('\u4e07', "mo", '\u4fdf', "qi")));
        f306903j.put('\u91cd', Collections.singletonList(new d('\u91cd', WidgetCacheLunarData.CHONG, '\u5e86', "qing")));
        f306903j.put('\u957f', Arrays.asList(new d('\u957f', "chang", '\u6c99', WidgetCacheLunarData.SHA), new d('\u957f', "chang", '\u76f8', "xiang")));
        f306903j.put('\u9ce5', Collections.singletonList(new d('\u9ce5', "niao", "n-iao")));
    }

    public static String d(String str, int i3) {
        b e16 = e(str, i3);
        if (TextUtils.isEmpty(e16.f306907b)) {
            return "";
        }
        return e16.f306907b;
    }

    public static b e(String str, int i3) {
        b e16;
        int i16;
        if (str != null && str.length() != 0) {
            if (i3 == 1) {
                b e17 = f306900g.e(str);
                if (e17 != null) {
                    return e17;
                }
            } else if (i3 == 2 && (e16 = f306901h.e(str)) != null) {
                return e16;
            }
            b bVar = new b();
            bVar.f306906a = i3;
            bVar.f306908c = new ArrayList();
            bVar.f306910e = new HashSet<>();
            bVar.f306909d = new HashSet<>();
            if (f306898e == null) {
                h();
            }
            c();
            StringBuilder sb5 = new StringBuilder();
            int length = str.length();
            str.charAt(0);
            bVar.f306909d.add(0);
            bVar.f306910e.add(0);
            int b16 = d.b(str, bVar, i3, sb5);
            if (length > b16) {
                i16 = Arrays.binarySearch(f306899f, (int) str.charAt(b16));
            } else {
                i16 = 15;
            }
            while (b16 < length) {
                char charAt = str.charAt(b16);
                bVar.f306908c.add(Integer.valueOf(sb5.length()));
                int binarySearch = Arrays.binarySearch(f306899f, (int) charAt);
                int i17 = -14;
                if (binarySearch != -14) {
                    i17 = -12;
                    if (binarySearch != -12) {
                        i17 = -9;
                        if (binarySearch != -9) {
                            i17 = -5;
                            if (binarySearch != -7) {
                                if (binarySearch != -5) {
                                    i16 = 7;
                                    if (binarySearch != 7) {
                                        if (Character.isHighSurrogate(charAt)) {
                                            if (i3 == 1) {
                                                bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                bVar.f306910e.add(Integer.valueOf(b16));
                                            }
                                            sb5.append('?');
                                            bVar.f306908c.add(Integer.valueOf(sb5.length()));
                                            b16++;
                                            if (i3 == 1) {
                                                bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                bVar.f306910e.add(Integer.valueOf(b16));
                                            }
                                            sb5.append('?');
                                        } else {
                                            if (i3 == 1) {
                                                bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                bVar.f306910e.add(Integer.valueOf(b16));
                                            }
                                            sb5.append(charAt);
                                        }
                                        i16 = 15;
                                    } else if (i3 == 1) {
                                        bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                        bVar.f306910e.add(Integer.valueOf(b16));
                                        sb5.append("ling");
                                    } else {
                                        sb5.append('l');
                                    }
                                } else {
                                    if (i16 != -5 && i16 != -7 && i3 == 1) {
                                        bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                        bVar.f306910e.add(Integer.valueOf(b16));
                                    }
                                    sb5.append(Character.toLowerCase(charAt));
                                }
                            } else {
                                if (i16 != -5 && i16 != -7 && i3 == 1) {
                                    bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                    bVar.f306910e.add(Integer.valueOf(b16));
                                }
                                sb5.append(charAt);
                                i16 = -7;
                            }
                            b16++;
                        } else {
                            int i18 = charAt - '\u2160';
                            String[] strArr = f306896c;
                            if (i18 >= strArr.length) {
                                i18 -= strArr.length;
                            }
                            if (i16 != -9 && i3 == 1) {
                                bVar.f306909d.add(Integer.valueOf(sb5.length()));
                                bVar.f306910e.add(Integer.valueOf(b16));
                            }
                            sb5.append(strArr[i18]);
                        }
                    } else if (i3 == 1) {
                        bVar.f306909d.add(Integer.valueOf(sb5.length()));
                        bVar.f306910e.add(Integer.valueOf(b16));
                        sb5.append(f306894a[f306898e[charAt - '\u4e00']]);
                    } else {
                        sb5.append(f306894a[f306898e[charAt - '\u4e00']].charAt(0));
                    }
                } else {
                    if (i3 == 1) {
                        bVar.f306909d.add(Integer.valueOf(sb5.length()));
                        bVar.f306910e.add(Integer.valueOf(b16));
                    }
                    sb5.append(Character.toLowerCase((char) (charAt - '\ufee0')));
                }
                i16 = i17;
                b16++;
            }
            if (i3 == 1) {
                bVar.f306909d.add(Integer.valueOf(sb5.length()));
                bVar.f306910e.add(Integer.valueOf(length));
            }
            bVar.f306907b = sb5.toString();
            if (i3 == 1) {
                f306900g.f(str, bVar);
            } else if (i3 == 2) {
                f306901h.f(str, bVar);
            }
            return bVar;
        }
        b bVar2 = new b();
        bVar2.f306906a = i3;
        bVar2.f306908c = new ArrayList();
        bVar2.f306910e = new HashSet<>();
        bVar2.f306909d = new HashSet<>();
        bVar2.f306907b = "";
        return bVar2;
    }

    public static c f(String str) {
        int i3;
        if (str != null && str.length() != 0) {
            c e16 = f306902i.e(str);
            if (e16 != null) {
                return e16;
            }
            c cVar = new c();
            cVar.f306908c = new ArrayList();
            cVar.f306914i = new ArrayList();
            cVar.f306915j = new ArrayList();
            cVar.f306916k = new ArrayList();
            cVar.f306910e = new HashSet<>();
            cVar.f306909d = new HashSet<>();
            if (f306898e == null) {
                h();
            }
            c();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            int length = str.length();
            str.charAt(0);
            cVar.f306909d.add(0);
            cVar.f306910e.add(0);
            int a16 = d.a(str, cVar, sb5, sb6, sb7);
            if (str.length() > a16) {
                i3 = Arrays.binarySearch(f306899f, (int) str.charAt(a16));
            } else {
                i3 = 15;
            }
            while (a16 < length) {
                char charAt = str.charAt(a16);
                cVar.f306914i.add(Integer.valueOf(sb5.length()));
                cVar.f306915j.add(Integer.valueOf(sb6.length()));
                cVar.f306916k.add(Integer.valueOf(sb7.length()));
                if (charAt != '-' && charAt != '#') {
                    int binarySearch = Arrays.binarySearch(f306899f, (int) charAt);
                    int i16 = -14;
                    if (binarySearch != -14) {
                        i16 = -12;
                        if (binarySearch != -12) {
                            i16 = -9;
                            if (binarySearch != -9) {
                                i16 = -5;
                                if (binarySearch != -7) {
                                    if (binarySearch != -5) {
                                        i3 = 7;
                                        if (binarySearch != 7) {
                                            if (Character.isHighSurrogate(charAt)) {
                                                cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                cVar.f306910e.add(Integer.valueOf(a16));
                                                sb5.append('?');
                                                sb6.append('?');
                                                sb7.append('?');
                                                sb7.append("#");
                                                cVar.f306914i.add(Integer.valueOf(sb5.length()));
                                                cVar.f306915j.add(Integer.valueOf(sb6.length()));
                                                cVar.f306916k.add(Integer.valueOf(sb7.length()));
                                                a16++;
                                                cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                cVar.f306910e.add(Integer.valueOf(a16));
                                                sb5.append('?');
                                                sb6.append('?');
                                                sb7.append('?');
                                                sb7.append("#");
                                            } else {
                                                cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                                cVar.f306910e.add(Integer.valueOf(a16));
                                                sb5.append('?');
                                                sb6.append('?');
                                                sb7.append('?');
                                                sb7.append("#");
                                            }
                                        } else {
                                            cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                            cVar.f306910e.add(Integer.valueOf(a16));
                                            sb5.append("ling");
                                            sb6.append('l');
                                            sb7.append("l-ing");
                                            sb7.append("#");
                                        }
                                    } else {
                                        if (i3 != -5 && i3 != -7) {
                                            cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                            cVar.f306910e.add(Integer.valueOf(a16));
                                        }
                                        sb5.append(Character.toLowerCase(charAt));
                                        sb6.append(Character.toLowerCase(charAt));
                                        sb7.append(Character.toLowerCase(charAt));
                                        sb7.append("#");
                                    }
                                } else {
                                    if (i3 != -5 && i3 != -7) {
                                        cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                        cVar.f306910e.add(Integer.valueOf(a16));
                                    }
                                    sb5.append(charAt);
                                    sb6.append(charAt);
                                    sb7.append(charAt);
                                    sb7.append("#");
                                    i3 = -7;
                                }
                                a16++;
                            } else {
                                int i17 = charAt - '\u2160';
                                String[] strArr = f306896c;
                                if (i17 >= strArr.length) {
                                    i17 -= strArr.length;
                                }
                                if (i3 != -9) {
                                    cVar.f306909d.add(Integer.valueOf(sb5.length()));
                                    cVar.f306910e.add(Integer.valueOf(a16));
                                }
                                sb5.append(strArr[i17]);
                                sb6.append(strArr[i17]);
                                sb7.append(strArr[i17]);
                                sb7.append("#");
                            }
                        } else {
                            cVar.f306909d.add(Integer.valueOf(sb5.length()));
                            cVar.f306910e.add(Integer.valueOf(a16));
                            String[] strArr2 = f306894a;
                            int i18 = charAt - '\u4e00';
                            sb5.append(strArr2[f306898e[i18]]);
                            sb6.append(strArr2[f306898e[i18]].charAt(0));
                            sb7.append(f306895b[f306898e[i18]]);
                            sb7.append("#");
                        }
                    } else {
                        cVar.f306909d.add(Integer.valueOf(sb5.length()));
                        cVar.f306910e.add(Integer.valueOf(a16));
                        char c16 = (char) (charAt - '\ufee0');
                        sb5.append(Character.toLowerCase(c16));
                        sb6.append(Character.toLowerCase(c16));
                        sb7.append(Character.toLowerCase(c16));
                        sb7.append("#");
                    }
                    i3 = i16;
                    a16++;
                } else {
                    cVar.f306909d.add(Integer.valueOf(sb5.length()));
                    cVar.f306910e.add(Integer.valueOf(a16));
                    sb5.append(charAt);
                    sb6.append(charAt);
                    sb7.append('0');
                    sb7.append("#");
                }
                i3 = 15;
                a16++;
            }
            if (sb7.length() > 0) {
                sb7.deleteCharAt(sb7.length() - 1);
            }
            cVar.f306909d.add(Integer.valueOf(sb5.length()));
            cVar.f306910e.add(Integer.valueOf(length));
            cVar.f306907b = sb5.toString();
            cVar.f306908c = cVar.f306914i;
            cVar.f306911f = sb5.toString();
            cVar.f306912g = sb6.toString();
            cVar.f306913h = sb7.toString();
            f306902i.f(str, cVar);
            return cVar;
        }
        return null;
    }

    public static a g(char c16) {
        a aVar = new a();
        int binarySearch = Arrays.binarySearch(f306899f, (int) c16);
        if (binarySearch != -14) {
            if (binarySearch != -12) {
                if (binarySearch != -7) {
                    if (binarySearch != -5) {
                        if (binarySearch != -3) {
                            aVar.f306904a = 6;
                            aVar.f306905b = String.valueOf(c16);
                        } else {
                            aVar.f306904a = 4;
                            aVar.f306905b = String.valueOf(c16);
                        }
                    } else {
                        aVar.f306904a = 2;
                        aVar.f306905b = String.valueOf(c16);
                    }
                } else {
                    aVar.f306904a = 3;
                    aVar.f306905b = String.valueOf(c16);
                }
            } else {
                aVar.f306904a = 1;
                aVar.f306905b = String.valueOf(c16);
            }
        } else {
            aVar.f306904a = 5;
            aVar.f306905b = String.valueOf(Character.toLowerCase((char) (c16 - '\ufee0')));
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6 A[LOOP:0: B:11:0x0015->B:30:0x00a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void h() {
        Throwable th5;
        InputStream inputStream;
        synchronized (ChnToSpell.class) {
            if (f306898e != null) {
                return;
            }
            int i3 = 20902;
            f306898e = new short[20902];
            byte[] bArr = new byte[2048];
            int i16 = 0;
            while (true) {
                BufferedInputStream bufferedInputStream = null;
                try {
                    inputStream = BaseApplication.getContext().getResources().getAssets().open("qq_uni2py.db");
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    inputStream = null;
                }
                try {
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(bArr);
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
                        try {
                            int read = bufferedInputStream2.read(bArr, 0, 2048) / 2;
                            int i17 = 0;
                            while (read != 0) {
                                int i18 = i17 + read;
                                if (i18 <= i3) {
                                    wrap.position(0);
                                    wrap.asShortBuffer().get(f306898e, i17, Math.min(read, 20902 - i17));
                                    read = bufferedInputStream2.read(bArr, 0, 2048) / 2;
                                    i17 = i18;
                                    i3 = 20902;
                                }
                            }
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            i16 = 3;
                        } catch (Exception e19) {
                            e = e19;
                            bufferedInputStream = bufferedInputStream2;
                            QLog.d("ChnToSpell", 1, "", e);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e26) {
                                    e26.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                }
                            }
                            i16++;
                            if (i16 < 3) {
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            bufferedInputStream = bufferedInputStream2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e28) {
                                    e28.printStackTrace();
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                    throw th5;
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (Exception e36) {
                        e = e36;
                    }
                    i16++;
                    if (i16 < 3) {
                        return;
                    } else {
                        i3 = 20902;
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public char f306917a;

        /* renamed from: b, reason: collision with root package name */
        public char f306918b;

        /* renamed from: c, reason: collision with root package name */
        public String f306919c;

        /* renamed from: d, reason: collision with root package name */
        public String f306920d;

        /* renamed from: e, reason: collision with root package name */
        public String f306921e;

        /* renamed from: f, reason: collision with root package name */
        public int f306922f = 2;

        public d(char c16, String str, String str2) {
            this.f306917a = c16;
            this.f306919c = str;
            this.f306921e = str2;
        }

        public static int a(String str, c cVar, StringBuilder sb5, StringBuilder sb6, StringBuilder sb7) {
            List<d> list;
            if (str != null && str.length() > 0 && cVar != null && sb5 != null && sb6 != null && sb7 != null) {
                char charAt = str.charAt(0);
                if (!ChnToSpell.f306903j.containsKey(Character.valueOf(charAt)) || (list = (List) ChnToSpell.f306903j.get(Character.valueOf(charAt))) == null) {
                    return 0;
                }
                for (d dVar : list) {
                    if (dVar.f306922f == 1) {
                        sb5.append(dVar.f306919c);
                        sb6.append(dVar.f306919c.charAt(0));
                        sb7.append(dVar.f306921e);
                        sb7.append("#");
                        cVar.f306914i.add(0);
                        cVar.f306915j.add(0);
                        cVar.f306916k.add(0);
                        return dVar.f306922f;
                    }
                }
            }
            return 0;
        }

        public static int b(String str, b bVar, int i3, StringBuilder sb5) {
            char c16;
            List list;
            if (str != null && str.length() > 0 && bVar != null && sb5 != null) {
                char charAt = str.charAt(0);
                if (str.length() > 1) {
                    c16 = str.charAt(1);
                } else {
                    c16 = '~';
                }
                if (ChnToSpell.f306903j.containsKey(Character.valueOf(charAt)) && (list = (List) ChnToSpell.f306903j.get(Character.valueOf(charAt))) != null && !list.isEmpty()) {
                    d dVar = (d) list.get(0);
                    if (str.length() > 1) {
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d dVar2 = (d) it.next();
                            if (dVar2.f306922f == 2 && c16 == dVar2.f306918b) {
                                dVar = dVar2;
                                break;
                            }
                        }
                    }
                    int i16 = dVar.f306922f;
                    if (i16 == 1) {
                        if (i3 == 1) {
                            sb5.append(dVar.f306919c);
                            bVar.f306908c.add(0);
                            return dVar.f306922f;
                        }
                        if (i3 == 2) {
                            sb5.append(dVar.f306919c.charAt(0));
                            bVar.f306908c.add(0);
                            return dVar.f306922f;
                        }
                    } else if (i16 == 2 && str.length() > 1 && c16 == dVar.f306918b) {
                        if (i3 == 1) {
                            sb5.append(dVar.f306919c);
                            sb5.append(dVar.f306920d);
                            bVar.f306908c.add(0);
                            bVar.f306908c.add(Integer.valueOf(dVar.f306919c.length()));
                            bVar.f306909d.add(Integer.valueOf(dVar.f306919c.length()));
                            bVar.f306910e.add(1);
                            return dVar.f306922f;
                        }
                        if (i3 == 2) {
                            sb5.append(dVar.f306919c.charAt(0));
                            sb5.append(dVar.f306920d.charAt(0));
                            bVar.f306908c.add(0);
                            bVar.f306908c.add(1);
                            return dVar.f306922f;
                        }
                    }
                }
            }
            return 0;
        }

        public d(char c16, String str, char c17, String str2) {
            this.f306917a = c16;
            this.f306919c = str;
            this.f306918b = c17;
            this.f306920d = str2;
        }
    }
}
