package com.tencent.oskplayer.util.apache;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RegexValidator implements Serializable {
    private static final long serialVersionUID = -8832409930574867162L;
    private final Pattern[] patterns;

    public RegexValidator(String str) {
        this(str, true);
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        int i3 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i3 >= patternArr.length) {
                return false;
            }
            if (patternArr[i3].matcher(str).matches()) {
                return true;
            }
            i3++;
        }
    }

    public String[] match(String str) {
        if (str == null) {
            return null;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i16 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i16].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                String[] strArr = new String[groupCount];
                while (i3 < groupCount) {
                    int i17 = i3 + 1;
                    strArr[i3] = matcher.group(i17);
                    i3 = i17;
                }
                return strArr;
            }
            i16++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegexValidator{");
        for (int i3 = 0; i3 < this.patterns.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(this.patterns[i3].pattern());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String validate(String str) {
        if (str == null) {
            return null;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i16 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i16].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                if (groupCount == 1) {
                    return matcher.group(1);
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (i3 < groupCount) {
                    i3++;
                    String group = matcher.group(i3);
                    if (group != null) {
                        stringBuffer.append(group);
                    }
                }
                return stringBuffer.toString();
            }
            i16++;
        }
    }

    public RegexValidator(String str, boolean z16) {
        this(new String[]{str}, z16);
    }

    public RegexValidator(String[] strArr) {
        this(strArr, true);
    }

    public RegexValidator(String[] strArr, boolean z16) {
        if (strArr != null && strArr.length != 0) {
            this.patterns = new Pattern[strArr.length];
            int i3 = z16 ? 0 : 2;
            for (int i16 = 0; i16 < strArr.length; i16++) {
                String str = strArr[i16];
                if (str != null && str.length() != 0) {
                    this.patterns[i16] = Pattern.compile(strArr[i16], i3);
                } else {
                    throw new IllegalArgumentException("Regular expression[" + i16 + "] is missing");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Regular expressions are missing");
    }
}
