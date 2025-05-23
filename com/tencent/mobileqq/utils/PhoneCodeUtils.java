package com.tencent.mobileqq.utils;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* loaded from: classes20.dex */
public class PhoneCodeUtils {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f307041a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f307042b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f307043c;

    /* renamed from: d, reason: collision with root package name */
    private static String f307044d;

    /* renamed from: e, reason: collision with root package name */
    private static char[] f307045e;

    /* renamed from: f, reason: collision with root package name */
    private static int f307046f;

    static {
        HashMap<String, String> hashMap = new HashMap<>(250);
        f307041a = hashMap;
        f307044d = null;
        hashMap.put("IL", "972");
        f307041a.put("AF", "93");
        f307041a.put("AL", "355");
        f307041a.put("DZ", ThemeReporter.FROM_NIGHT_ROAMING);
        f307041a.put("AS", "1684");
        f307041a.put("AD", "376");
        f307041a.put("AO", "244");
        f307041a.put("AI", "1264");
        f307041a.put("AQ", "672");
        f307041a.put("AG", "1268");
        f307041a.put("AR", "54");
        f307041a.put("AM", "374");
        f307041a.put("AW", "297");
        f307041a.put("AU", "61");
        f307041a.put("AT", "43");
        f307041a.put("AZ", "994");
        f307041a.put("BS", "1242");
        f307041a.put("BH", "973");
        f307041a.put(ky.f149113s, "880");
        f307041a.put("BB", "1246");
        f307041a.put("BY", "375");
        f307041a.put("BE", "32");
        f307041a.put("BZ", "501");
        f307041a.put("BJ", "229");
        f307041a.put("BM", "1441");
        f307041a.put("BT", "975");
        f307041a.put("BA", "387");
        f307041a.put("BW", "267");
        f307041a.put("BR", "55");
        f307041a.put("IO", "246");
        f307041a.put("BG", "359");
        f307041a.put("BF", "226");
        f307041a.put("BI", "257");
        f307041a.put("KH", "855");
        f307041a.put("CM", "237");
        f307041a.put("CA", "1");
        f307041a.put("CV", "238");
        f307041a.put("KY", "345");
        f307041a.put("CF", "236");
        f307041a.put("TD", "235");
        f307041a.put("CL", "56");
        f307041a.put(LocaleManager.MOBILE_COUNTRY_CODE_CN_STR, "86");
        f307041a.put("CX", "61");
        f307041a.put("CO", "57");
        f307041a.put("KM", "269");
        f307041a.put("CG", "242");
        f307041a.put("CK", "682");
        f307041a.put("CR", "506");
        f307041a.put("HR", "385");
        f307041a.put("CU", "53");
        f307041a.put("CY", "537");
        f307041a.put("CZ", "420");
        f307041a.put("DK", "45");
        f307041a.put("DJ", "253");
        f307041a.put("DM", "1767");
        f307041a.put("DO", "1809");
        f307041a.put(KeyPropertiesCompact.KEY_ALGORITHM_EC, "593");
        f307041a.put("EG", "20");
        f307041a.put("SV", "503");
        f307041a.put("GQ", "240");
        f307041a.put("ER", "291");
        f307041a.put("EE", "372");
        f307041a.put("ET", "251");
        f307041a.put("FO", "298");
        f307041a.put("FJ", "679");
        f307041a.put("FI", "358");
        f307041a.put("FR", WadlProxyConsts.OPER_TYPE_APK_SIGN);
        f307041a.put("GF", "594");
        f307041a.put("PF", "689");
        f307041a.put("GA", "241");
        f307041a.put("GM", "220");
        f307041a.put("GE", "995");
        f307041a.put("DE", "49");
        f307041a.put("GH", "233");
        f307041a.put("GI", "350");
        f307041a.put("GR", "30");
        f307041a.put("GL", "299");
        f307041a.put(ky.f149115u, "1473");
        f307041a.put("GP", "590");
        f307041a.put("GU", "1671");
        f307041a.put("GT", "502");
        f307041a.put("GN", "224");
        f307041a.put("GW", "245");
        f307041a.put("GY", "595");
        f307041a.put("HT", "509");
        f307041a.put("HN", "504");
        f307041a.put("HU", "36");
        f307041a.put("IS", "354");
        f307041a.put("IN", "91");
        f307041a.put("ID", "62");
        f307041a.put("IQ", "964");
        f307041a.put("IE", "353");
        f307041a.put("IL", "972");
        f307041a.put("IT", "39");
        f307041a.put("JM", "1876");
        f307041a.put("JP", "81");
        f307041a.put("JO", "962");
        f307041a.put("KZ", "77");
        f307041a.put("KE", "254");
        f307041a.put("KI", "686");
        f307041a.put("KW", "965");
        f307041a.put("KG", "996");
        f307041a.put("LV", "371");
        f307041a.put("LB", "961");
        f307041a.put("LS", "266");
        f307041a.put("LR", "231");
        f307041a.put("LI", "423");
        f307041a.put("LT", "370");
        f307041a.put("LU", "352");
        f307041a.put("MG", "261");
        f307041a.put("MW", "265");
        f307041a.put("MY", "60");
        f307041a.put("MV", "960");
        f307041a.put("ML", "223");
        f307041a.put("MT", "356");
        f307041a.put("MH", "692");
        f307041a.put("MQ", "596");
        f307041a.put("MR", "222");
        f307041a.put("MU", "230");
        f307041a.put("YT", "262");
        f307041a.put("MX", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
        f307041a.put(ky.f149112r, "377");
        f307041a.put("MN", "976");
        f307041a.put("ME", "382");
        f307041a.put("MS", "1664");
        f307041a.put("MA", ThemeReporter.FROM_SIMPLE_INIT);
        f307041a.put("MM", "95");
        f307041a.put("NA", "264");
        f307041a.put("NR", "674");
        f307041a.put("NP", "977");
        f307041a.put("NL", "31");
        f307041a.put("AN", "599");
        f307041a.put("NC", "687");
        f307041a.put("NZ", IPreloadResource.ABI_64);
        f307041a.put("NI", "505");
        f307041a.put("NE", "227");
        f307041a.put("NG", "234");
        f307041a.put("NU", "683");
        f307041a.put("NF", "672");
        f307041a.put("MP", "1670");
        f307041a.put("NO", "47");
        f307041a.put(ky.f149116v, "968");
        f307041a.put("PK", "92");
        f307041a.put("PW", "680");
        f307041a.put("PA", "507");
        f307041a.put("PG", "675");
        f307041a.put("PY", "595");
        f307041a.put("PE", "51");
        f307041a.put("PH", "63");
        f307041a.put("PL", "48");
        f307041a.put("PT", "351");
        f307041a.put("PR", "1");
        f307041a.put("QA", "974");
        f307041a.put("RO", "40");
        f307041a.put("RW", "250");
        f307041a.put("WS", "685");
        f307041a.put("SM", "378");
        f307041a.put("SA", "966");
        f307041a.put("SN", "221");
        f307041a.put("RS", "381");
        f307041a.put("SC", "248");
        f307041a.put("SL", "232");
        f307041a.put("SG", "65");
        f307041a.put("SK", "421");
        f307041a.put("SI", "386");
        f307041a.put("SB", "677");
        f307041a.put("ZA", "27");
        f307041a.put("GS", "500");
        f307041a.put("ES", WadlProxyConsts.OPER_TYPE_MONITOR);
        f307041a.put("LK", "94");
        f307041a.put("SD", "249");
        f307041a.put("SR", "597");
        f307041a.put("SZ", IFeatureRuntimeService.MODULE_ID);
        f307041a.put("SE", "46");
        f307041a.put("CH", "41");
        f307041a.put("TJ", "992");
        f307041a.put("TH", "66");
        f307041a.put("TG", "228");
        f307041a.put("TK", "690");
        f307041a.put(ky.f149103i, "676");
        f307041a.put(ky.f149099e, "1868");
        f307041a.put("TN", "216");
        f307041a.put("TR", "90");
        f307041a.put("TM", "993");
        f307041a.put(ky.f149100f, "1649");
        f307041a.put("TV", "688");
        f307041a.put("UG", "256");
        f307041a.put("UA", "380");
        f307041a.put("AE", "971");
        f307041a.put("GB", "44");
        f307041a.put("US", "1");
        f307041a.put("UY", "598");
        f307041a.put("UZ", "998");
        f307041a.put("VU", "678");
        f307041a.put("WF", "681");
        f307041a.put("YE", "967");
        f307041a.put("ZM", "260");
        f307041a.put("ZW", "263");
        f307041a.put("BO", "591");
        f307041a.put("BN", "673");
        f307041a.put("CC", "61");
        f307041a.put("CD", "243");
        f307041a.put("CI", "225");
        f307041a.put("FK", "500");
        f307041a.put("GG", "44");
        f307041a.put("VA", "379");
        f307041a.put("HK", "852");
        f307041a.put("IR", QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE);
        f307041a.put("IM", "44");
        f307041a.put("JE", "44");
        f307041a.put("KP", "850");
        f307041a.put("KR", "82");
        f307041a.put("LA", "856");
        f307041a.put("LY", "218");
        f307041a.put("MO", "853");
        f307041a.put("MK", "389");
        f307041a.put("FM", "691");
        f307041a.put("MD", "373");
        f307041a.put("MZ", "258");
        f307041a.put("PS", "970");
        f307041a.put("PN", "872");
        f307041a.put("RE", "262");
        f307041a.put("RU", "7");
        f307041a.put("BL", "590");
        f307041a.put("SH", "290");
        f307041a.put("KN", "1869");
        f307041a.put("LC", "1758");
        f307041a.put("MF", "590");
        f307041a.put("PM", "508");
        f307041a.put("VC", "1784");
        f307041a.put(NowProxyConstants.AccountInfoKey.ST, "239");
        f307041a.put("SO", "252");
        f307041a.put("SJ", "47");
        f307041a.put("SY", "963");
        f307041a.put("TW", "886");
        f307041a.put("TZ", "255");
        f307041a.put("TL", "670");
        f307041a.put("VE", "58");
        f307041a.put("VN", "84");
        f307041a.put("VG", "1284");
        f307041a.put("VI", "1340");
        f307042b = new HashMap<String, String>(130) { // from class: com.tencent.mobileqq.utils.PhoneCodeUtils.1
            {
                put("460", "86");
                put("454", "852");
                put("466", "886");
                put("455", "853");
                put("525", "65");
                put("502", "60");
                put("520", "66");
                put("510", "62");
                put("440", "81");
                put("450", "82");
                put("515", "63");
                put("404", "55");
                put("420", "966");
                put("432", QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE);
                put("412", "93");
                put("424", "971");
                put("410", "92");
                put("426", "973");
                put("402", "975");
                put("401", "7");
                put("437", "996");
                put("456", "855");
                put("427", "974");
                put("419", "965");
                put("457", "856");
                put("415", "961");
                put("472", "960");
                put("414", "95");
                put("413", "94");
                put("436", "992");
                put("438", "993");
                put("434", "998");
                put("417", "963");
                put("421", "967");
                put("418", "964");
                put("425", "972");
                put("416", "962");
                put("452", "84");
                put("505", "61");
                put("536", "674");
                put("234", "44");
                put("262", "49");
                put(ThemeReporter.FROM_UPDATE, WadlProxyConsts.OPER_TYPE_APK_SIGN);
                put("222", "39");
                put("244", "358");
                put("228", "41");
                put(ThemeReporter.FROM_DIR_COVER, WadlProxyConsts.OPER_TYPE_MONITOR);
                put("240", "46");
                put("238", "45");
                put(ThemeReporter.FROM_INIT_THEME, "32");
                put("286", "90");
                put(IFeatureRuntimeService.MODULE_ID, "351");
                put("250", "7");
                put("260", "48");
                put("232", "43");
                put("272", "353");
                put("248", "372");
                put(ThemeReporter.FROM_NIGHT_ROAMING, "376");
                put("257", "375");
                put("284", "359");
                put("274", "354");
                put("282", "995");
                put("230", "420");
                put("247", "371");
                put("246", "370");
                put("295", "423");
                put("270", "352");
                put("226", "40");
                put("278", "356");
                put(ThemeReporter.FROM_SIMPLE_INIT, "377");
                put("242", "47");
                put("280", "357");
                put("231", "421");
                put("293", "386");
                put("255", "380");
                put(ThemeReporter.FROM_NIGHT, "30");
                put("216", "36");
                put("266", "350");
                put("310", "1");
                put("311", "1");
                put("313", "1");
                put("316", "1");
                put("302", "1");
                put("364", "1242");
                put(QZoneClickReport.ClickReportConfig.ACTION_TYPE_QQ_AIO_FEED_CARD, "939");
                put("370", "1890");
                put("368", "53");
                put("372", "509");
                put("334", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE);
                put("374", "1868");
                put("338", "1876");
                put("724", "55");
                put("722", "54");
                put("730", "56");
                put("734", "58");
                put("714", "507");
                put("726", "591");
                put("702", "501");
                put("740", "593");
                put("732", "57");
                put("712", "506");
                put("708", "504");
                put("706", "503");
                put("734", "58");
                put("748", "598");
                put(QZoneClickReport.ClickReportConfig.ACTION_TYPE_TEMPLATE_SHUOSHUO, "27");
                put("602", "20");
                put("629", "242");
                put("604", "377");
                put("603", ThemeReporter.FROM_NIGHT_ROAMING);
                put("605", "216");
                put("621", "234");
                put("624", "237");
                put("631", "244");
                put("615", "228");
                put("652", "267");
                put("607", "220");
                put("611", "224");
                put("620", "233");
                put("612", "225");
                put("639", "254");
                put("606", "218");
                put("646", "261");
                put("608", "221");
                put("634", "249");
                put("637", "252");
                put("623", "236");
            }
        };
        f307043c = new HashMap<String, String>(20) { // from class: com.tencent.mobileqq.utils.PhoneCodeUtils.2
            {
                put("zh-cn", "86");
                put("zh-hk", "852");
                put("zh-tw", "886");
                put("zh-sg", "853");
                put("en-us", "1");
                put("en-gb", "44");
                put("en-au", "61");
                put("en-ca", "1");
                put("ja-jp", "81");
                put("ko-kr", "82");
                put("pt-br", "55");
                put("pt-pt", "351");
                put("es-es", WadlProxyConsts.OPER_TYPE_MONITOR);
                put("de-de", "49");
                put("fr-fr", WadlProxyConsts.OPER_TYPE_APK_SIGN);
                put("it-it", "39");
                put("en-ph", "63");
                put("en-my", "60");
            }
        };
        char[] cArr = {0, 1, 0, 1};
        f307045e = cArr;
        f307046f = cArr.length;
    }

    public static String a() {
        String b16 = b(null);
        if (!TextUtils.isEmpty(b16)) {
            HashSet hashSet = new HashSet();
            for (Map.Entry<String, String> entry : f307042b.entrySet()) {
                if (b16.equals(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            if (!hashSet.isEmpty()) {
                return (String) hashSet.iterator().next();
            }
            return "";
        }
        return "";
    }

    public static String b(Context context) {
        return c();
    }

    public static String c() {
        String d16 = d(Locale.getDefault());
        if (f307043c.containsKey(d16)) {
            if (QLog.isColorLevel()) {
                QLog.d("PhoneCodeUtil", 2, "code from Locale=" + d16);
            }
            return f307043c.get(d16);
        }
        return "86";
    }

    public static String d(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (!StringUtil.isEmpty(country)) {
            language = language + "-" + country;
        }
        return language.toLowerCase();
    }

    public static LinkedHashMap<String, Integer> e(String[] strArr, List<a> list) {
        if (list != null && strArr != null) {
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            int i3 = 0;
            for (a aVar : list) {
                if (!linkedHashMap.containsKey(aVar.f307047a)) {
                    linkedHashMap.put(aVar.f307047a, Integer.valueOf(i3));
                }
                i3++;
            }
            int i16 = 0;
            for (String str : strArr) {
                if (linkedHashMap.containsKey(str)) {
                    i16 = linkedHashMap.get(str).intValue();
                } else {
                    linkedHashMap.put(str, Integer.valueOf(i16));
                }
            }
            return linkedHashMap;
        }
        QLog.e("PhoneCodeUtils", 1, "getNavigateMap error : countryCodes is null or navigationTags is null");
        return null;
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f307044d)) {
            String country = context.getResources().getConfiguration().locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                f307044d = f307041a.get(country.toUpperCase());
            }
            if (TextUtils.isEmpty(f307044d)) {
                f307044d = "86";
            }
            f307044d = Marker.ANY_NON_NULL_MARKER + f307044d;
        }
        return f307044d;
    }

    public static ArrayList<a> g(String str) {
        QLog.d("PhoneCodeUtils", 1, "start parseCountryList");
        if (TextUtils.isEmpty(str)) {
            QLog.d("PhoneCodeUtils", 1, "parseCountryList error : countryData is empty");
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("favList");
            JSONArray optJSONArray2 = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
            ArrayList<a> h16 = h(optJSONArray);
            if (h16 != null) {
                arrayList.addAll(h16);
            }
            ArrayList<a> h17 = h(optJSONArray2);
            if (h17 != null) {
                arrayList.addAll(h17);
            }
            QLog.d("PhoneCodeUtils", 1, "parseCountryList finish");
        } catch (JSONException e16) {
            QLog.e("PhoneCodeUtils", 1, "parseCountryList JSONException : ", e16.getMessage());
        }
        return arrayList;
    }

    public static ArrayList<a> h(JSONArray jSONArray) {
        String str = null;
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList<a> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String optString = jSONObject.optString("tag");
                    String optString2 = jSONObject.optString("name");
                    String optString3 = jSONObject.optString("abbr");
                    String optString4 = jSONObject.optString("code");
                    if (str == null || !str.equals(optString)) {
                        arrayList.add(new a(optString));
                        str = optString;
                    }
                    arrayList.add(new a(optString, optString3, optString2, optString4));
                } catch (JSONException e16) {
                    QLog.e("PhoneCodeUtils", 1, "parseCountryList JSONException : ", e16.getMessage());
                }
            }
            return arrayList;
        }
        QLog.e("PhoneCodeUtils", 1, "parseCountryList error : countryArray is null or empty");
        return null;
    }

    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f307047a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f307048b = true;

        /* renamed from: c, reason: collision with root package name */
        public String f307049c;

        /* renamed from: d, reason: collision with root package name */
        public String f307050d;

        /* renamed from: e, reason: collision with root package name */
        public String f307051e;

        public a(String str, String str2, String str3, String str4) {
            this.f307051e = str2;
            this.f307047a = str;
            this.f307050d = str4;
            this.f307049c = str3;
        }

        public a(String str) {
            this.f307047a = str;
        }
    }
}
