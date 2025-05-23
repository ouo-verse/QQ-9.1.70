package org.apache.commons.fileupload;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.fileupload.util.mime.MimeUtility;

/* loaded from: classes29.dex */
public class ParameterParser {
    private char[] chars = null;
    private int pos = 0;
    private int len = 0;

    /* renamed from: i1, reason: collision with root package name */
    private int f423529i1 = 0;

    /* renamed from: i2, reason: collision with root package name */
    private int f423530i2 = 0;
    private boolean lowerCaseNames = false;

    private String getToken(boolean z16) {
        while (true) {
            int i3 = this.f423529i1;
            if (i3 >= this.f423530i2 || !Character.isWhitespace(this.chars[i3])) {
                break;
            }
            this.f423529i1++;
        }
        while (true) {
            int i16 = this.f423530i2;
            if (i16 <= this.f423529i1 || !Character.isWhitespace(this.chars[i16 - 1])) {
                break;
            }
            this.f423530i2--;
        }
        if (z16) {
            int i17 = this.f423530i2;
            int i18 = this.f423529i1;
            if (i17 - i18 >= 2) {
                char[] cArr = this.chars;
                if (cArr[i18] == '\"' && cArr[i17 - 1] == '\"') {
                    this.f423529i1 = i18 + 1;
                    this.f423530i2 = i17 - 1;
                }
            }
        }
        int i19 = this.f423530i2;
        int i26 = this.f423529i1;
        if (i19 > i26) {
            return new String(this.chars, i26, i19 - i26);
        }
        return null;
    }

    private boolean hasChar() {
        if (this.pos < this.len) {
            return true;
        }
        return false;
    }

    private boolean isOneOf(char c16, char[] cArr) {
        for (char c17 : cArr) {
            if (c16 == c17) {
                return true;
            }
        }
        return false;
    }

    private String parseQuotedToken(char[] cArr) {
        int i3 = this.pos;
        this.f423529i1 = i3;
        this.f423530i2 = i3;
        boolean z16 = false;
        boolean z17 = false;
        while (hasChar()) {
            char c16 = this.chars[this.pos];
            if (!z16 && isOneOf(c16, cArr)) {
                break;
            }
            if (!z17 && c16 == '\"') {
                z16 = !z16;
            }
            if (!z17 && c16 == '\\') {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f423530i2++;
            this.pos++;
        }
        return getToken(true);
    }

    private String parseToken(char[] cArr) {
        int i3 = this.pos;
        this.f423529i1 = i3;
        this.f423530i2 = i3;
        while (hasChar() && !isOneOf(this.chars[this.pos], cArr)) {
            this.f423530i2++;
            this.pos++;
        }
        return getToken(false);
    }

    public boolean isLowerCaseNames() {
        return this.lowerCaseNames;
    }

    public Map<String, String> parse(String str, char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            char c16 = cArr[0];
            if (str != null) {
                int length = str.length();
                for (char c17 : cArr) {
                    int indexOf = str.indexOf(c17);
                    if (indexOf != -1 && indexOf < length) {
                        c16 = c17;
                        length = indexOf;
                    }
                }
            }
            return parse(str, c16);
        }
        return new HashMap();
    }

    public void setLowerCaseNames(boolean z16) {
        this.lowerCaseNames = z16;
    }

    public Map<String, String> parse(String str, char c16) {
        if (str == null) {
            return new HashMap();
        }
        return parse(str.toCharArray(), c16);
    }

    public Map<String, String> parse(char[] cArr, char c16) {
        if (cArr == null) {
            return new HashMap();
        }
        return parse(cArr, 0, cArr.length, c16);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> parse(char[] cArr, int i3, int i16, char c16) {
        String str;
        if (cArr == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        this.chars = cArr;
        this.pos = i3;
        this.len = i16;
        while (hasChar()) {
            String parseToken = parseToken(new char[]{'=', c16});
            if (hasChar()) {
                int i17 = this.pos;
                if (cArr[i17] == '=') {
                    this.pos = i17 + 1;
                    str = parseQuotedToken(new char[]{c16});
                    if (str != null) {
                        try {
                            str = MimeUtility.decodeText(str);
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                    if (hasChar()) {
                        int i18 = this.pos;
                        if (cArr[i18] == c16) {
                            this.pos = i18 + 1;
                        }
                    }
                    if (parseToken != null && parseToken.length() > 0) {
                        if (this.lowerCaseNames) {
                            parseToken = parseToken.toLowerCase(Locale.ENGLISH);
                        }
                        hashMap.put(parseToken, str);
                    }
                }
            }
            str = null;
            if (hasChar()) {
            }
            if (parseToken != null) {
                if (this.lowerCaseNames) {
                }
                hashMap.put(parseToken, str);
            }
        }
        return hashMap;
    }
}
