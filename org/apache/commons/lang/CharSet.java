package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    protected static final Map COMMON;
    public static final CharSet EMPTY;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set set = Collections.synchronizedSet(new HashSet());

    static {
        CharSet charSet = new CharSet((String) null);
        EMPTY = charSet;
        CharSet charSet2 = new CharSet("a-zA-Z");
        ASCII_ALPHA = charSet2;
        CharSet charSet3 = new CharSet("a-z");
        ASCII_ALPHA_LOWER = charSet3;
        CharSet charSet4 = new CharSet("A-Z");
        ASCII_ALPHA_UPPER = charSet4;
        CharSet charSet5 = new CharSet("0-9");
        ASCII_NUMERIC = charSet5;
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put(null, charSet);
        synchronizedMap.put("", charSet);
        synchronizedMap.put("a-zA-Z", charSet2);
        synchronizedMap.put("A-Za-z", charSet2);
        synchronizedMap.put("a-z", charSet3);
        synchronizedMap.put("A-Z", charSet4);
        synchronizedMap.put("0-9", charSet5);
    }

    protected CharSet(String str) {
        add(str);
    }

    public static CharSet getInstance(String str) {
        Object obj = COMMON.get(str);
        if (obj != null) {
            return (CharSet) obj;
        }
        return new CharSet(str);
    }

    protected void add(String str) {
        if (str == null) {
            return;
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i16 = length - i3;
            if (i16 >= 4 && str.charAt(i3) == '^' && str.charAt(i3 + 2) == '-') {
                this.set.add(CharRange.isNotIn(str.charAt(i3 + 1), str.charAt(i3 + 3)));
                i3 += 4;
            } else if (i16 >= 3 && str.charAt(i3 + 1) == '-') {
                this.set.add(CharRange.isIn(str.charAt(i3), str.charAt(i3 + 2)));
                i3 += 3;
            } else if (i16 >= 2 && str.charAt(i3) == '^') {
                this.set.add(CharRange.isNot(str.charAt(i3 + 1)));
                i3 += 2;
            } else {
                this.set.add(CharRange.is(str.charAt(i3)));
                i3++;
            }
        }
    }

    public boolean contains(char c16) {
        Iterator it = this.set.iterator();
        while (it.hasNext()) {
            if (((CharRange) it.next()).contains(c16)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharSet)) {
            return false;
        }
        return this.set.equals(((CharSet) obj).set);
    }

    public CharRange[] getCharRanges() {
        Set set = this.set;
        return (CharRange[]) set.toArray(new CharRange[set.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSet(String[] strArr) {
        for (String str : strArr) {
            add(str);
        }
    }

    public static CharSet getInstance(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return new CharSet(strArr);
    }
}
