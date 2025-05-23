package com.tencent.local_edit.andserver.util;

import android.text.TextUtils;
import com.tencent.local_edit.andserver.error.InvalidMimeTypeException;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MimeType implements Comparable<MimeType>, Serializable {
    protected static final String WILDCARD_TYPE = "*";

    /* renamed from: d, reason: collision with root package name */
    private static final BitSet f119872d;
    private final Map<String, String> parameters;
    private final String subtype;
    private final String type;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a<T extends MimeType> implements Comparator<T> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(T t16, T t17) {
            if (t16.isWildcardType() && !t17.isWildcardType()) {
                return 1;
            }
            if (t17.isWildcardType() && !t16.isWildcardType()) {
                return -1;
            }
            if (!t16.getType().equals(t17.getType())) {
                return 0;
            }
            if (t16.isWildcardSubtype() && !t17.isWildcardSubtype()) {
                return 1;
            }
            if (t17.isWildcardSubtype() && !t16.isWildcardSubtype()) {
                return -1;
            }
            if (!t16.getSubtype().equals(t17.getSubtype())) {
                return 0;
            }
            return b(t16, t17);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int b(T t16, T t17) {
            int size = t16.getParameters().size();
            int size2 = t17.getParameters().size();
            if (size2 < size) {
                return -1;
            }
            if (size2 == size) {
                return 0;
            }
            return 1;
        }
    }

    static {
        BitSet bitSet = new BitSet(128);
        for (int i3 = 0; i3 <= 31; i3++) {
            bitSet.set(i3);
        }
        bitSet.set(127);
        BitSet bitSet2 = new BitSet(128);
        bitSet2.set(40);
        bitSet2.set(41);
        bitSet2.set(60);
        bitSet2.set(62);
        bitSet2.set(64);
        bitSet2.set(44);
        bitSet2.set(59);
        bitSet2.set(58);
        bitSet2.set(92);
        bitSet2.set(34);
        bitSet2.set(47);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(63);
        bitSet2.set(61);
        bitSet2.set(123);
        bitSet2.set(125);
        bitSet2.set(32);
        bitSet2.set(9);
        BitSet bitSet3 = new BitSet(128);
        f119872d = bitSet3;
        bitSet3.set(0, 128);
        bitSet3.andNot(bitSet);
        bitSet3.andNot(bitSet2);
    }

    public MimeType(String str) {
        this(str, "*");
    }

    private static Map<String, String> c(Charset charset, Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(HttpMsg.CHARSET, charset.name());
        return linkedHashMap;
    }

    private void d(Map<String, String> map, StringBuilder sb5) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb5.append(';');
            sb5.append(entry.getKey());
            sb5.append('=');
            sb5.append(entry.getValue());
        }
    }

    private void e(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (!f119872d.get(charAt)) {
                throw new IllegalArgumentException("Invalid token character '" + charAt + "' in token \"" + str + "\"");
            }
        }
    }

    private boolean f(String str) {
        if (str.length() < 2) {
            return false;
        }
        if ((!str.startsWith("\"") || !str.endsWith("\"")) && (!str.startsWith("'") || !str.endsWith("'"))) {
            return false;
        }
        return true;
    }

    private boolean g(MimeType mimeType) {
        if (this.parameters.size() != mimeType.parameters.size()) {
            return false;
        }
        for (String str : this.parameters.keySet()) {
            if (!mimeType.parameters.containsKey(str)) {
                return false;
            }
            if (HttpMsg.CHARSET.equals(str)) {
                Charset charset = getCharset();
                Charset charset2 = mimeType.getCharset();
                if (charset == null || !charset.equals(charset2)) {
                    return false;
                }
                return true;
            }
            String str2 = this.parameters.get(str);
            String str3 = mimeType.parameters.get(str);
            if (str2 == null || !str2.equals(str3)) {
                return false;
            }
        }
        return true;
    }

    public static MimeType valueOf(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(59);
            if (indexOf >= 0) {
                str2 = str.substring(0, indexOf);
            } else {
                str2 = str;
            }
            String trim = str2.trim();
            if (!trim.isEmpty()) {
                if ("*".equals(trim)) {
                    trim = "*/*";
                }
                int indexOf2 = trim.indexOf(47);
                if (indexOf2 != -1) {
                    if (indexOf2 != trim.length() - 1) {
                        String substring = trim.substring(0, indexOf2);
                        String substring2 = trim.substring(indexOf2 + 1, trim.length());
                        if ("*".equals(substring) && !"*".equals(substring2)) {
                            throw new InvalidMimeTypeException(str, "wildcard type is legal only in '*/*' (all mime types)");
                        }
                        LinkedHashMap linkedHashMap = null;
                        while (true) {
                            int i3 = indexOf + 1;
                            int i16 = i3;
                            boolean z16 = false;
                            while (i16 < str.length()) {
                                char charAt = str.charAt(i16);
                                if (charAt == ';') {
                                    if (!z16) {
                                        break;
                                    }
                                } else if (charAt == '\"') {
                                    z16 = !z16;
                                }
                                i16++;
                            }
                            String trim2 = str.substring(i3, i16).trim();
                            if (trim2.length() > 0) {
                                if (linkedHashMap == null) {
                                    linkedHashMap = new LinkedHashMap(4);
                                }
                                int indexOf3 = trim2.indexOf(61);
                                if (indexOf3 >= 0) {
                                    linkedHashMap.put(trim2.substring(0, indexOf3), trim2.substring(indexOf3 + 1, trim2.length()));
                                }
                            }
                            if (i16 >= str.length()) {
                                try {
                                    return new MimeType(substring, substring2, linkedHashMap);
                                } catch (UnsupportedCharsetException e16) {
                                    throw new InvalidMimeTypeException(str, "unsupported charset '" + e16.getCharsetName() + "'");
                                } catch (IllegalArgumentException e17) {
                                    throw new InvalidMimeTypeException(str, e17.getMessage());
                                }
                            }
                            indexOf = i16;
                        }
                    } else {
                        throw new InvalidMimeTypeException(str, "does not contain subtype after '/'");
                    }
                } else {
                    throw new InvalidMimeTypeException(str, "does not contain '/'");
                }
            } else {
                throw new InvalidMimeTypeException(str, "'contentType' must not be empty");
            }
        } else {
            throw new InvalidMimeTypeException(str, "[mimeType] must not be empty");
        }
    }

    protected void appendTo(StringBuilder sb5) {
        sb5.append(this.type);
        sb5.append('/');
        sb5.append(this.subtype);
        d(this.parameters, sb5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkParameters(String str, String str2) {
        com.tencent.local_edit.andserver.util.a.a(str, "'attribute' must not be empty.");
        com.tencent.local_edit.andserver.util.a.a(str2, "'value' must not be empty.");
        e(str);
        if (HttpMsg.CHARSET.equals(str)) {
            Charset.forName(unquote(str2));
        } else if (!f(str2)) {
            e(str2);
        }
    }

    public boolean equals(Object obj) {
        if (!equalsExcludeParameter(obj)) {
            return false;
        }
        return g((MimeType) obj);
    }

    public boolean equalsExcludeParameter(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MimeType)) {
            return false;
        }
        MimeType mimeType = (MimeType) obj;
        if (this.type.equalsIgnoreCase(mimeType.type) && this.subtype.equalsIgnoreCase(mimeType.subtype)) {
            return true;
        }
        return false;
    }

    public Charset getCharset() {
        String parameter = getParameter(HttpMsg.CHARSET);
        if (parameter != null) {
            return Charset.forName(unquote(parameter));
        }
        return null;
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.subtype.hashCode()) * 31) + this.parameters.hashCode();
    }

    public boolean includes(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (isWildcardType()) {
            return true;
        }
        if (getType().equals(mimeType.getType())) {
            if (getSubtype().equals(mimeType.getSubtype())) {
                return true;
            }
            if (isWildcardSubtype()) {
                int indexOf = getSubtype().indexOf(43);
                if (indexOf == -1) {
                    return true;
                }
                int indexOf2 = mimeType.getSubtype().indexOf(43);
                if (indexOf2 != -1) {
                    String substring = getSubtype().substring(0, indexOf);
                    if (getSubtype().substring(indexOf + 1).equals(mimeType.getSubtype().substring(indexOf2 + 1)) && "*".equals(substring)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCompatibleWith(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (isWildcardType() || mimeType.isWildcardType()) {
            return true;
        }
        if (getType().equals(mimeType.getType())) {
            if (getSubtype().equals(mimeType.getSubtype())) {
                return true;
            }
            if (isWildcardSubtype() || mimeType.isWildcardSubtype()) {
                int indexOf = getSubtype().indexOf(43);
                int indexOf2 = mimeType.getSubtype().indexOf(43);
                if (indexOf == -1 && indexOf2 == -1) {
                    return true;
                }
                if (indexOf != -1 && indexOf2 != -1) {
                    String substring = getSubtype().substring(0, indexOf);
                    String substring2 = mimeType.getSubtype().substring(0, indexOf2);
                    if (getSubtype().substring(indexOf + 1).equals(mimeType.getSubtype().substring(indexOf2 + 1)) && ("*".equals(substring) || "*".equals(substring2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isConcrete() {
        if (!isWildcardType() && !isWildcardSubtype()) {
            return true;
        }
        return false;
    }

    public boolean isWildcardSubtype() {
        if (!"*".equals(getSubtype()) && !getSubtype().startsWith("*+")) {
            return false;
        }
        return true;
    }

    public boolean isWildcardType() {
        return "*".equals(getType());
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        appendTo(sb5);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String unquote(String str) {
        if (str == null) {
            return null;
        }
        if (f(str)) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public MimeType(String str, String str2) {
        this(str, str2, (Map<String, String>) Collections.emptyMap());
    }

    @Override // java.lang.Comparable
    public int compareTo(MimeType mimeType) {
        int compareToIgnoreCase = getType().compareToIgnoreCase(mimeType.getType());
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        int compareToIgnoreCase2 = getSubtype().compareToIgnoreCase(mimeType.getSubtype());
        if (compareToIgnoreCase2 != 0) {
            return compareToIgnoreCase2;
        }
        int size = getParameters().size() - mimeType.getParameters().size();
        if (size != 0) {
            return size;
        }
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(getParameters().keySet());
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(mimeType.getParameters().keySet());
        Iterator it = treeSet.iterator();
        Iterator it5 = treeSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) it5.next();
            int compareToIgnoreCase3 = str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase3 != 0) {
                return compareToIgnoreCase3;
            }
            String str3 = getParameters().get(str);
            String str4 = mimeType.getParameters().get(str2);
            if (str4 == null) {
                str4 = "";
            }
            int compareTo = str3.compareTo(str4);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public MimeType(String str, String str2, Charset charset) {
        this(str, str2, (Map<String, String>) Collections.singletonMap(HttpMsg.CHARSET, charset.name()));
    }

    public MimeType(MimeType mimeType, Charset charset) {
        this(mimeType.getType(), mimeType.getSubtype(), c(charset, mimeType.getParameters()));
    }

    public static String toString(Collection<? extends MimeType> collection) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<? extends MimeType> it = collection.iterator();
        while (it.hasNext()) {
            it.next().appendTo(sb5);
            if (it.hasNext()) {
                sb5.append(", ");
            }
        }
        return sb5.toString();
    }

    public MimeType(MimeType mimeType, Map<String, String> map) {
        this(mimeType.getType(), mimeType.getSubtype(), map);
    }

    public MimeType(String str, String str2, Map<String, String> map) {
        e(str);
        e(str2);
        Locale locale = Locale.ENGLISH;
        this.type = str.toLowerCase(locale);
        this.subtype = str2.toLowerCase(locale);
        if (map != null && !map.isEmpty()) {
            LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), locale);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                checkParameters(key, value);
                linkedCaseInsensitiveMap.put((LinkedCaseInsensitiveMap) key, value);
            }
            this.parameters = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
            return;
        }
        this.parameters = Collections.emptyMap();
    }
}
