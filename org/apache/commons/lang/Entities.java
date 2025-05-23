package org.apache.commons.lang;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes29.dex */
class Entities {
    private static final String[][] APOS_ARRAY;
    private static final String[][] BASIC_ARRAY;
    public static final Entities HTML32;
    public static final Entities HTML40;
    static final String[][] HTML40_ARRAY;
    static final String[][] ISO8859_1_ARRAY;
    public static final Entities XML;
    private final EntityMap map;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class BinaryEntityMap extends ArrayEntityMap {
        public BinaryEntityMap() {
        }

        private int binarySearch(int i3) {
            int i16 = this.size - 1;
            int i17 = 0;
            while (i17 <= i16) {
                int i18 = (i17 + i16) >>> 1;
                int i19 = this.values[i18];
                if (i19 < i3) {
                    i17 = i18 + 1;
                } else if (i19 > i3) {
                    i16 = i18 - 1;
                } else {
                    return i18;
                }
            }
            return -(i17 + 1);
        }

        @Override // org.apache.commons.lang.Entities.ArrayEntityMap, org.apache.commons.lang.Entities.EntityMap
        public void add(String str, int i3) {
            ensureCapacity(this.size + 1);
            int binarySearch = binarySearch(i3);
            if (binarySearch > 0) {
                return;
            }
            int i16 = -(binarySearch + 1);
            int[] iArr = this.values;
            int i17 = i16 + 1;
            System.arraycopy(iArr, i16, iArr, i17, this.size - i16);
            this.values[i16] = i3;
            String[] strArr = this.names;
            System.arraycopy(strArr, i16, strArr, i17, this.size - i16);
            this.names[i16] = str;
            this.size++;
        }

        @Override // org.apache.commons.lang.Entities.ArrayEntityMap, org.apache.commons.lang.Entities.EntityMap
        public String name(int i3) {
            int binarySearch = binarySearch(i3);
            if (binarySearch < 0) {
                return null;
            }
            return this.names[binarySearch];
        }

        public BinaryEntityMap(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface EntityMap {
        void add(String str, int i3);

        String name(int i3);

        int value(String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class HashEntityMap extends MapIntMap {
        public HashEntityMap() {
            super(new HashMap(), new HashMap());
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class LookupEntityMap extends PrimitiveEntityMap {
        private static final int LOOKUP_TABLE_SIZE = 256;
        private String[] lookupTable;

        LookupEntityMap() {
        }

        private void createLookupTable() {
            this.lookupTable = new String[256];
            for (int i3 = 0; i3 < 256; i3++) {
                this.lookupTable[i3] = super.name(i3);
            }
        }

        private String[] lookupTable() {
            if (this.lookupTable == null) {
                createLookupTable();
            }
            return this.lookupTable;
        }

        @Override // org.apache.commons.lang.Entities.PrimitiveEntityMap, org.apache.commons.lang.Entities.EntityMap
        public String name(int i3) {
            if (i3 < 256) {
                return lookupTable()[i3];
            }
            return super.name(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static abstract class MapIntMap implements EntityMap {
        protected final Map mapNameToValue;
        protected final Map mapValueToName;

        MapIntMap(Map map, Map map2) {
            this.mapNameToValue = map;
            this.mapValueToName = map2;
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public void add(String str, int i3) {
            this.mapNameToValue.put(str, new Integer(i3));
            this.mapValueToName.put(new Integer(i3), str);
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public String name(int i3) {
            return (String) this.mapValueToName.get(new Integer(i3));
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class PrimitiveEntityMap implements EntityMap {
        private final Map mapNameToValue = new HashMap();
        private final IntHashMap mapValueToName = new IntHashMap();

        PrimitiveEntityMap() {
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public void add(String str, int i3) {
            this.mapNameToValue.put(str, new Integer(i3));
            this.mapValueToName.put(i3, str);
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public String name(int i3) {
            return (String) this.mapValueToName.get(i3);
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class TreeEntityMap extends MapIntMap {
        public TreeEntityMap() {
            super(new TreeMap(), new TreeMap());
        }
    }

    static {
        String[][] strArr = {new String[]{"quot", WadlProxyConsts.OPER_TYPE_MONITOR}, new String[]{"amp", "38"}, new String[]{"lt", "60"}, new String[]{"gt", "62"}};
        BASIC_ARRAY = strArr;
        String[][] strArr2 = {new String[]{"apos", "39"}};
        APOS_ARRAY = strArr2;
        String[][] strArr3 = {new String[]{"nbsp", "160"}, new String[]{"iexcl", "161"}, new String[]{"cent", "162"}, new String[]{"pound", "163"}, new String[]{"curren", "164"}, new String[]{"yen", "165"}, new String[]{"brvbar", "166"}, new String[]{"sect", "167"}, new String[]{"uml", "168"}, new String[]{"copy", "169"}, new String[]{"ordf", "170"}, new String[]{"laquo", "171"}, new String[]{"not", "172"}, new String[]{"shy", QAdConfigDefine$CHID.LITE}, new String[]{"reg", "174"}, new String[]{"macr", "175"}, new String[]{"deg", "176"}, new String[]{"plusmn", "177"}, new String[]{"sup2", "178"}, new String[]{"sup3", "179"}, new String[]{"acute", "180"}, new String[]{"micro", "181"}, new String[]{"para", "182"}, new String[]{"middot", "183"}, new String[]{"cedil", "184"}, new String[]{"sup1", "185"}, new String[]{"ordm", "186"}, new String[]{"raquo", "187"}, new String[]{"frac14", "188"}, new String[]{"frac12", QAdConfigDefine$CHID.SUBMARINE}, new String[]{"frac34", "190"}, new String[]{"iquest", "191"}, new String[]{"Agrave", "192"}, new String[]{"Aacute", QAdConfigDefine$CHID.QQ}, new String[]{"Acirc", "194"}, new String[]{"Atilde", "195"}, new String[]{"Auml", "196"}, new String[]{"Aring", "197"}, new String[]{"AElig", "198"}, new String[]{"Ccedil", "199"}, new String[]{"Egrave", "200"}, new String[]{"Eacute", ThemeReporter.FROM_DIY}, new String[]{"Ecirc", ThemeReporter.FROM_NIGHT}, new String[]{"Euml", ThemeReporter.FROM_WEEKLOOP}, new String[]{"Igrave", ThemeReporter.FROM_AUTH}, new String[]{"Iacute", ThemeReporter.FROM_ENGINE}, new String[]{"Icirc", ThemeReporter.FROM_INIT_THEME}, new String[]{"Iuml", ThemeReporter.FROM_SERVER_SET_THEME}, new String[]{"ETH", ThemeReporter.FROM_UPDATE}, new String[]{"Ntilde", ThemeReporter.FROM_PUSH}, new String[]{"Ograve", ThemeReporter.FROM_CLEANER}, new String[]{"Oacute", ThemeReporter.FROM_SIMPLE}, new String[]{"Ocirc", ThemeReporter.FROM_SIMPLE_INIT}, new String[]{"Otilde", ThemeReporter.FROM_NIGHT_ROAMING}, new String[]{"Ouml", ThemeReporter.FROM_DIR_COVER}, new String[]{Element.ELEMENT_NAME_TIMES, ThemeReporter.FROM_VIP}, new String[]{"Oslash", "216"}, new String[]{"Ugrave", "217"}, new String[]{"Uacute", "218"}, new String[]{"Ucirc", "219"}, new String[]{"Uuml", "220"}, new String[]{"Yacute", "221"}, new String[]{"THORN", "222"}, new String[]{"szlig", "223"}, new String[]{"agrave", "224"}, new String[]{"aacute", "225"}, new String[]{"acirc", "226"}, new String[]{"atilde", "227"}, new String[]{"auml", "228"}, new String[]{"aring", "229"}, new String[]{"aelig", "230"}, new String[]{"ccedil", "231"}, new String[]{"egrave", "232"}, new String[]{"eacute", "233"}, new String[]{"ecirc", "234"}, new String[]{"euml", "235"}, new String[]{"igrave", "236"}, new String[]{"iacute", "237"}, new String[]{"icirc", "238"}, new String[]{"iuml", "239"}, new String[]{"eth", "240"}, new String[]{"ntilde", "241"}, new String[]{"ograve", "242"}, new String[]{"oacute", "243"}, new String[]{"ocirc", "244"}, new String[]{"otilde", "245"}, new String[]{"ouml", "246"}, new String[]{"divide", "247"}, new String[]{"oslash", "248"}, new String[]{"ugrave", "249"}, new String[]{"uacute", "250"}, new String[]{"ucirc", "251"}, new String[]{"uuml", "252"}, new String[]{"yacute", "253"}, new String[]{"thorn", "254"}, new String[]{"yuml", "255"}};
        ISO8859_1_ARRAY = strArr3;
        HTML40_ARRAY = new String[][]{new String[]{"fnof", "402"}, new String[]{"Alpha", "913"}, new String[]{"Beta", "914"}, new String[]{ExifInterface.TAG_GAMMA, "915"}, new String[]{"Delta", "916"}, new String[]{"Epsilon", "917"}, new String[]{"Zeta", "918"}, new String[]{"Eta", "919"}, new String[]{"Theta", "920"}, new String[]{"Iota", "921"}, new String[]{"Kappa", "922"}, new String[]{"Lambda", "923"}, new String[]{"Mu", "924"}, new String[]{"Nu", "925"}, new String[]{"Xi", "926"}, new String[]{"Omicron", "927"}, new String[]{"Pi", "928"}, new String[]{"Rho", "929"}, new String[]{"Sigma", "931"}, new String[]{"Tau", "932"}, new String[]{"Upsilon", "933"}, new String[]{"Phi", "934"}, new String[]{"Chi", "935"}, new String[]{"Psi", "936"}, new String[]{"Omega", "937"}, new String[]{c.f123400v, "945"}, new String[]{"beta", "946"}, new String[]{"gamma", "947"}, new String[]{EventListener.KEY_DELTA, "948"}, new String[]{"epsilon", "949"}, new String[]{"zeta", "950"}, new String[]{"eta", "951"}, new String[]{"theta", "952"}, new String[]{"iota", "953"}, new String[]{"kappa", "954"}, new String[]{"lambda", "955"}, new String[]{"mu", "956"}, new String[]{"nu", "957"}, new String[]{"xi", "958"}, new String[]{"omicron", "959"}, new String[]{"pi", "960"}, new String[]{"rho", "961"}, new String[]{"sigmaf", "962"}, new String[]{"sigma", "963"}, new String[]{"tau", "964"}, new String[]{"upsilon", "965"}, new String[]{"phi", "966"}, new String[]{"chi", "967"}, new String[]{"psi", "968"}, new String[]{"omega", "969"}, new String[]{"thetasym", "977"}, new String[]{"upsih", "978"}, new String[]{"piv", "982"}, new String[]{"bull", "8226"}, new String[]{"hellip", "8230"}, new String[]{"prime", "8242"}, new String[]{"Prime", "8243"}, new String[]{"oline", "8254"}, new String[]{"frasl", "8260"}, new String[]{"weierp", "8472"}, new String[]{"image", "8465"}, new String[]{"real", "8476"}, new String[]{"trade", "8482"}, new String[]{"alefsym", "8501"}, new String[]{"larr", "8592"}, new String[]{"uarr", "8593"}, new String[]{"rarr", "8594"}, new String[]{"darr", "8595"}, new String[]{"harr", "8596"}, new String[]{"crarr", "8629"}, new String[]{"lArr", "8656"}, new String[]{"uArr", "8657"}, new String[]{"rArr", "8658"}, new String[]{"dArr", "8659"}, new String[]{"hArr", "8660"}, new String[]{"forall", "8704"}, new String[]{"part", "8706"}, new String[]{"exist", "8707"}, new String[]{GlobalUtil.DEF_STRING, "8709"}, new String[]{"nabla", "8711"}, new String[]{"isin", "8712"}, new String[]{"notin", "8713"}, new String[]{"ni", "8715"}, new String[]{"prod", "8719"}, new String[]{"sum", "8721"}, new String[]{"minus", "8722"}, new String[]{"lowast", "8727"}, new String[]{"radic", "8730"}, new String[]{"prop", "8733"}, new String[]{"infin", "8734"}, new String[]{"ang", "8736"}, new String[]{"and", "8743"}, new String[]{"or", "8744"}, new String[]{"cap", "8745"}, new String[]{"cup", "8746"}, new String[]{PoiListCacheRecord.WEIGHT_TYPE, "8747"}, new String[]{"there4", "8756"}, new String[]{"sim", "8764"}, new String[]{"cong", "8773"}, new String[]{"asymp", "8776"}, new String[]{"ne", "8800"}, new String[]{"equiv", "8801"}, new String[]{"le", "8804"}, new String[]{"ge", "8805"}, new String[]{"sub", "8834"}, new String[]{HiHealthActivities.SUP, "8835"}, new String[]{"sube", "8838"}, new String[]{"supe", "8839"}, new String[]{"oplus", "8853"}, new String[]{"otimes", "8855"}, new String[]{"perp", "8869"}, new String[]{"sdot", "8901"}, new String[]{"lceil", "8968"}, new String[]{"rceil", "8969"}, new String[]{"lfloor", "8970"}, new String[]{"rfloor", "8971"}, new String[]{"lang", "9001"}, new String[]{"rang", "9002"}, new String[]{"loz", "9674"}, new String[]{"spades", "9824"}, new String[]{"clubs", "9827"}, new String[]{"hearts", "9829"}, new String[]{"diams", "9830"}, new String[]{"OElig", "338"}, new String[]{"oelig", "339"}, new String[]{"Scaron", "352"}, new String[]{"scaron", "353"}, new String[]{"Yuml", "376"}, new String[]{"circ", "710"}, new String[]{"tilde", "732"}, new String[]{"ensp", "8194"}, new String[]{"emsp", "8195"}, new String[]{"thinsp", "8201"}, new String[]{"zwnj", "8204"}, new String[]{"zwj", "8205"}, new String[]{"lrm", "8206"}, new String[]{"rlm", "8207"}, new String[]{"ndash", "8211"}, new String[]{"mdash", "8212"}, new String[]{"lsquo", "8216"}, new String[]{"rsquo", "8217"}, new String[]{"sbquo", "8218"}, new String[]{"ldquo", "8220"}, new String[]{"rdquo", "8221"}, new String[]{"bdquo", "8222"}, new String[]{"dagger", "8224"}, new String[]{"Dagger", "8225"}, new String[]{"permil", "8240"}, new String[]{"lsaquo", "8249"}, new String[]{"rsaquo", "8250"}, new String[]{"euro", "8364"}};
        Entities entities = new Entities();
        entities.addEntities(strArr);
        entities.addEntities(strArr2);
        XML = entities;
        Entities entities2 = new Entities();
        entities2.addEntities(strArr);
        entities2.addEntities(strArr3);
        HTML32 = entities2;
        Entities entities3 = new Entities();
        fillWithHtml40Entities(entities3);
        HTML40 = entities3;
    }

    public Entities() {
        this.map = new LookupEntityMap();
    }

    private StringWriter createStringWriter(String str) {
        return new StringWriter((int) (str.length() + (str.length() * 0.1d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0067, code lost:
    
        if (r2 > 65535) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doUnescape(Writer writer, String str, int i3) throws IOException {
        int i16;
        writer.write(str, 0, i3);
        int length = str.length();
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt == '&') {
                int i17 = i3 + 1;
                int indexOf = str.indexOf(59, i17);
                if (indexOf == -1) {
                    writer.write(charAt);
                } else {
                    int indexOf2 = str.indexOf(38, i17);
                    if (indexOf2 != -1 && indexOf2 < indexOf) {
                        writer.write(charAt);
                    } else {
                        String substring = str.substring(i17, indexOf);
                        int length2 = substring.length();
                        if (length2 > 0) {
                            if (substring.charAt(0) == '#') {
                                if (length2 > 1) {
                                    char charAt2 = substring.charAt(1);
                                    if (charAt2 != 'X' && charAt2 != 'x') {
                                        try {
                                            i16 = Integer.parseInt(substring.substring(1), 10);
                                        } catch (NumberFormatException unused) {
                                        }
                                    } else {
                                        i16 = Integer.parseInt(substring.substring(2), 16);
                                    }
                                }
                            } else {
                                i16 = entityValue(substring);
                            }
                            if (i16 != -1) {
                                writer.write(38);
                                writer.write(substring);
                                writer.write(59);
                            } else {
                                writer.write(i16);
                            }
                            i3 = indexOf;
                        }
                        i16 = -1;
                        if (i16 != -1) {
                        }
                        i3 = indexOf;
                    }
                }
            } else {
                writer.write(charAt);
            }
            i3++;
        }
    }

    static void fillWithHtml40Entities(Entities entities) {
        entities.addEntities(BASIC_ARRAY);
        entities.addEntities(ISO8859_1_ARRAY);
        entities.addEntities(HTML40_ARRAY);
    }

    public void addEntities(String[][] strArr) {
        for (String[] strArr2 : strArr) {
            addEntity(strArr2[0], Integer.parseInt(strArr2[1]));
        }
    }

    public void addEntity(String str, int i3) {
        this.map.add(str, i3);
    }

    public String entityName(int i3) {
        return this.map.name(i3);
    }

    public int entityValue(String str) {
        return this.map.value(str);
    }

    public String escape(String str) {
        StringWriter createStringWriter = createStringWriter(str);
        try {
            escape(createStringWriter, str);
            return createStringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public String unescape(String str) {
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            return str;
        }
        StringWriter createStringWriter = createStringWriter(str);
        try {
            doUnescape(createStringWriter, str, indexOf);
            return createStringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    Entities(EntityMap entityMap) {
        this.map = entityMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ArrayEntityMap implements EntityMap {
        protected final int growBy;
        protected String[] names;
        protected int size;
        protected int[] values;

        public ArrayEntityMap() {
            this.size = 0;
            this.growBy = 100;
            this.names = new String[100];
            this.values = new int[100];
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public void add(String str, int i3) {
            ensureCapacity(this.size + 1);
            String[] strArr = this.names;
            int i16 = this.size;
            strArr[i16] = str;
            this.values[i16] = i3;
            this.size = i16 + 1;
        }

        protected void ensureCapacity(int i3) {
            if (i3 > this.names.length) {
                int max = Math.max(i3, this.size + this.growBy);
                String[] strArr = new String[max];
                System.arraycopy(this.names, 0, strArr, 0, this.size);
                this.names = strArr;
                int[] iArr = new int[max];
                System.arraycopy(this.values, 0, iArr, 0, this.size);
                this.values = iArr;
            }
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public String name(int i3) {
            for (int i16 = 0; i16 < this.size; i16++) {
                if (this.values[i16] == i3) {
                    return this.names[i16];
                }
            }
            return null;
        }

        @Override // org.apache.commons.lang.Entities.EntityMap
        public int value(String str) {
            for (int i3 = 0; i3 < this.size; i3++) {
                if (this.names[i3].equals(str)) {
                    return this.values[i3];
                }
            }
            return -1;
        }

        public ArrayEntityMap(int i3) {
            this.size = 0;
            this.growBy = i3;
            this.names = new String[i3];
            this.values = new int[i3];
        }
    }

    public void escape(Writer writer, String str) throws IOException {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            String entityName = entityName(charAt);
            if (entityName != null) {
                writer.write(38);
                writer.write(entityName);
                writer.write(59);
            } else if (charAt > '\u007f') {
                writer.write("&#");
                writer.write(Integer.toString(charAt, 10));
                writer.write(59);
            } else {
                writer.write(charAt);
            }
        }
    }

    public void unescape(Writer writer, String str) throws IOException {
        int indexOf = str.indexOf(38);
        if (indexOf < 0) {
            writer.write(str);
        } else {
            doUnescape(writer, str, indexOf);
        }
    }
}
