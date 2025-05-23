package org.json;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JSONTokener {

    /* renamed from: in, reason: collision with root package name */
    private final String f423669in;
    private int pos;

    public JSONTokener(String str) {
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        this.f423669in = str;
    }

    public static int dehexchar(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return c16 - '0';
        }
        char c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
        if (c16 < 'A' || c16 > 'F') {
            c17 = 'a';
            if (c16 < 'a' || c16 > 'f') {
                return -1;
            }
        }
        return (c16 - c17) + 10;
    }

    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.f423669in.length()) {
            String str = this.f423669in;
            int i3 = this.pos;
            this.pos = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                if (charAt != '#') {
                    if (charAt != '/') {
                        return charAt;
                    }
                    if (this.pos == this.f423669in.length()) {
                        return charAt;
                    }
                    char charAt2 = this.f423669in.charAt(this.pos);
                    if (charAt2 != '*') {
                        if (charAt2 != '/') {
                            return charAt;
                        }
                        this.pos++;
                        skipToEndOfLine();
                    } else {
                        int i16 = this.pos + 1;
                        this.pos = i16;
                        int indexOf = this.f423669in.indexOf("*/", i16);
                        if (indexOf != -1) {
                            this.pos = indexOf + 2;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    }
                } else {
                    skipToEndOfLine();
                }
            }
        }
        return -1;
    }

    private String nextToInternal(String str) {
        int i3 = this.pos;
        while (this.pos < this.f423669in.length()) {
            char charAt = this.f423669in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n' && str.indexOf(charAt) == -1) {
                this.pos++;
            } else {
                return this.f423669in.substring(i3, this.pos);
            }
        }
        return this.f423669in.substring(i3);
    }

    private JSONArray readArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        boolean z16 = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal != -1) {
                if (nextCleanInternal != 44 && nextCleanInternal != 59) {
                    if (nextCleanInternal != 93) {
                        this.pos--;
                        jSONArray.mo162put(nextValue());
                        int nextCleanInternal2 = nextCleanInternal();
                        if (nextCleanInternal2 != 44 && nextCleanInternal2 != 59) {
                            if (nextCleanInternal2 == 93) {
                                return jSONArray;
                            }
                            throw syntaxError("Unterminated array");
                        }
                    } else {
                        if (z16) {
                            jSONArray.mo162put((Object) null);
                        }
                        return jSONArray;
                    }
                } else {
                    jSONArray.mo162put((Object) null);
                }
                z16 = true;
            } else {
                throw syntaxError("Unterminated array");
            }
        }
    }

    private char readEscapeCharacter() throws JSONException {
        String str = this.f423669in;
        int i3 = this.pos;
        this.pos = i3 + 1;
        char charAt = str.charAt(i3);
        if (charAt != 'b') {
            if (charAt != 'f') {
                if (charAt != 'n') {
                    if (charAt != 'r') {
                        if (charAt != 't') {
                            if (charAt != 'u') {
                                return charAt;
                            }
                            if (this.pos + 4 <= this.f423669in.length()) {
                                String str2 = this.f423669in;
                                int i16 = this.pos;
                                String substring = str2.substring(i16, i16 + 4);
                                this.pos += 4;
                                return (char) Integer.parseInt(substring, 16);
                            }
                            throw syntaxError("Unterminated escape sequence");
                        }
                        return '\t';
                    }
                    return '\r';
                }
                return '\n';
            }
            return '\f';
        }
        return '\b';
    }

    private Object readLiteral() throws JSONException {
        String substring;
        int i3;
        String nextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
        if (nextToInternal.length() != 0) {
            if ("null".equalsIgnoreCase(nextToInternal)) {
                return JSONObject.NULL;
            }
            if ("true".equalsIgnoreCase(nextToInternal)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(nextToInternal)) {
                return Boolean.FALSE;
            }
            if (nextToInternal.indexOf(46) == -1) {
                if (!nextToInternal.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING) && !nextToInternal.startsWith("0X")) {
                    if (nextToInternal.startsWith("0") && nextToInternal.length() > 1) {
                        substring = nextToInternal.substring(1);
                        i3 = 8;
                    } else {
                        i3 = 10;
                        substring = nextToInternal;
                    }
                } else {
                    substring = nextToInternal.substring(2);
                    i3 = 16;
                }
                try {
                    long parseLong = Long.parseLong(substring, i3);
                    if (parseLong <= TTL.MAX_VALUE && parseLong >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                        return Integer.valueOf((int) parseLong);
                    }
                    return Long.valueOf(parseLong);
                } catch (NumberFormatException unused) {
                }
            }
            try {
                return Double.valueOf(nextToInternal);
            } catch (NumberFormatException unused2) {
                return new String(nextToInternal);
            }
        }
        throw syntaxError("Expected literal value");
    }

    private JSONObject readObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (!(nextValue instanceof String)) {
                if (nextValue == null) {
                    throw syntaxError("Names cannot be null");
                }
                throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
            }
            int nextCleanInternal2 = nextCleanInternal();
            if (nextCleanInternal2 != 58 && nextCleanInternal2 != 61) {
                throw syntaxError("Expected ':' after " + nextValue);
            }
            if (this.pos < this.f423669in.length() && this.f423669in.charAt(this.pos) == '>') {
                this.pos++;
            }
            jSONObject.put((String) nextValue, nextValue());
            int nextCleanInternal3 = nextCleanInternal();
            if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                if (nextCleanInternal3 == 125) {
                    return jSONObject;
                }
                throw syntaxError("Unterminated object");
            }
        }
    }

    private void skipToEndOfLine() {
        while (this.pos < this.f423669in.length()) {
            char charAt = this.f423669in.charAt(this.pos);
            if (charAt != '\r' && charAt != '\n') {
                this.pos++;
            } else {
                this.pos++;
                return;
            }
        }
    }

    public void back() {
        int i3 = this.pos - 1;
        this.pos = i3;
        if (i3 == -1) {
            this.pos = 0;
        }
    }

    public boolean more() {
        if (this.pos < this.f423669in.length()) {
            return true;
        }
        return false;
    }

    public char next() {
        if (this.pos >= this.f423669in.length()) {
            return (char) 0;
        }
        String str = this.f423669in;
        int i3 = this.pos;
        this.pos = i3 + 1;
        return str.charAt(i3);
    }

    public char nextClean() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == -1) {
            return (char) 0;
        }
        return (char) nextCleanInternal;
    }

    public String nextString(char c16) throws JSONException {
        int i3 = this.pos;
        StringBuilder sb5 = null;
        while (this.pos < this.f423669in.length()) {
            String str = this.f423669in;
            int i16 = this.pos;
            this.pos = i16 + 1;
            char charAt = str.charAt(i16);
            if (charAt == c16) {
                if (sb5 == null) {
                    return new String(this.f423669in.substring(i3, this.pos - 1));
                }
                sb5.append((CharSequence) this.f423669in, i3, this.pos - 1);
                return sb5.toString();
            }
            if (charAt == '\\') {
                if (this.pos != this.f423669in.length()) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    sb5.append((CharSequence) this.f423669in, i3, this.pos - 1);
                    sb5.append(readEscapeCharacter());
                    i3 = this.pos;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
        }
        throw syntaxError("Unterminated string");
    }

    public String nextTo(String str) {
        if (str != null) {
            return nextToInternal(str).trim();
        }
        throw new NullPointerException("excluded == null");
    }

    public Object nextValue() throws JSONException {
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal != -1) {
            if (nextCleanInternal != 34 && nextCleanInternal != 39) {
                if (nextCleanInternal != 91) {
                    if (nextCleanInternal != 123) {
                        this.pos--;
                        return readLiteral();
                    }
                    return readObject();
                }
                return readArray();
            }
            return nextString((char) nextCleanInternal);
        }
        throw syntaxError("End of input");
    }

    public void skipPast(String str) {
        int length;
        int indexOf = this.f423669in.indexOf(str, this.pos);
        if (indexOf == -1) {
            length = this.f423669in.length();
        } else {
            length = str.length() + indexOf;
        }
        this.pos = length;
    }

    public char skipTo(char c16) {
        int indexOf = this.f423669in.indexOf(c16, this.pos);
        if (indexOf != -1) {
            this.pos = indexOf;
            return c16;
        }
        return (char) 0;
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + this);
    }

    public String toString() {
        return " at character " + this.pos + " of " + this.f423669in;
    }

    public char next(char c16) throws JSONException {
        char next = next();
        if (next == c16) {
            return next;
        }
        throw syntaxError("Expected " + c16 + " but was " + next);
    }

    public String nextTo(char c16) {
        return nextToInternal(String.valueOf(c16)).trim();
    }

    public String next(int i3) throws JSONException {
        if (this.pos + i3 <= this.f423669in.length()) {
            String str = this.f423669in;
            int i16 = this.pos;
            String substring = str.substring(i16, i16 + i3);
            this.pos += i3;
            return substring;
        }
        throw syntaxError(i3 + " is out of bounds");
    }
}
