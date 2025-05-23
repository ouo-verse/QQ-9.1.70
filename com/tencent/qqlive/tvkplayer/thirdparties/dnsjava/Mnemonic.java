package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
class Mnemonic {
    static final int CASE_LOWER = 3;
    static final int CASE_SENSITIVE = 1;
    static final int CASE_UPPER = 2;
    private final String description;
    private boolean numericok;
    private String prefix;
    private final int wordcase;
    private final HashMap<String, Integer> strings = new HashMap<>();
    private final HashMap<Integer, String> values = new HashMap<>();
    private int max = Integer.MAX_VALUE;

    public Mnemonic(String str, int i3) {
        this.description = str;
        this.wordcase = i3;
    }

    private int parseNumeric(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                if (parseInt <= this.max) {
                    return parseInt;
                }
                return -1;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String sanitize(String str) {
        int i3 = this.wordcase;
        if (i3 == 2) {
            return str.toUpperCase();
        }
        if (i3 == 3) {
            return str.toLowerCase();
        }
        return str;
    }

    public void add(int i3, String str) {
        check(i3);
        String sanitize = sanitize(str);
        this.strings.put(sanitize, Integer.valueOf(i3));
        this.values.put(Integer.valueOf(i3), sanitize);
    }

    public void addAlias(int i3, String str) {
        check(i3);
        this.strings.put(sanitize(str), Integer.valueOf(i3));
    }

    public void addAll(Mnemonic mnemonic) {
        if (this.wordcase == mnemonic.wordcase) {
            this.strings.putAll(mnemonic.strings);
            this.values.putAll(mnemonic.values);
        } else {
            throw new IllegalArgumentException(mnemonic.description + ": wordcases do not match");
        }
    }

    public void check(int i3) {
        if (i3 >= 0 && i3 <= this.max) {
            return;
        }
        throw new IllegalArgumentException(this.description + " " + i3 + " is out of range");
    }

    public String getText(int i3) {
        check(i3);
        String str = this.values.get(Integer.valueOf(i3));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i3);
        if (this.prefix != null) {
            return this.prefix + num;
        }
        return num;
    }

    public int getValue(String str) {
        int parseNumeric;
        String sanitize = sanitize(str);
        Integer num = this.strings.get(sanitize);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.prefix;
        if (str2 != null && sanitize.startsWith(str2) && (parseNumeric = parseNumeric(sanitize.substring(this.prefix.length()))) >= 0) {
            return parseNumeric;
        }
        if (this.numericok) {
            return parseNumeric(sanitize);
        }
        return -1;
    }

    public void remove(int i3) {
        this.values.remove(Integer.valueOf(i3));
        Iterator<Map.Entry<String, Integer>> it = this.strings.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().intValue() == i3) {
                it.remove();
            }
        }
    }

    public void removeAlias(String str) {
        this.strings.remove(sanitize(str));
    }

    public void setMaximum(int i3) {
        this.max = i3;
    }

    public void setNumericAllowed(boolean z16) {
        this.numericok = z16;
    }

    public void setPrefix(String str) {
        this.prefix = sanitize(str);
    }
}
