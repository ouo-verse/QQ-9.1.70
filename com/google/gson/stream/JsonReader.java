package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;

    /* renamed from: in, reason: collision with root package name */
    private final Reader f35227in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 0 + 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i3 = jsonReader.peeked;
                if (i3 == 0) {
                    i3 = jsonReader.doPeek();
                }
                if (i3 == 13) {
                    jsonReader.peeked = 9;
                    return;
                }
                if (i3 == 12) {
                    jsonReader.peeked = 8;
                    return;
                }
                if (i3 == 14) {
                    jsonReader.peeked = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.f35227in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        if (this.lenient) {
        } else {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i3 = this.pos - 1;
        this.pos = i3;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i3 + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i16 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i16 < cArr2.length) {
                if (this.buffer[this.pos + i16] != cArr2[i16]) {
                    return;
                } else {
                    i16++;
                }
            } else {
                this.pos += cArr2.length;
                return;
            }
        }
    }

    private boolean fillBuffer(int i3) throws IOException {
        int i16;
        int i17;
        char[] cArr = this.buffer;
        int i18 = this.lineStart;
        int i19 = this.pos;
        this.lineStart = i18 - i19;
        int i26 = this.limit;
        if (i26 != i19) {
            int i27 = i26 - i19;
            this.limit = i27;
            System.arraycopy(cArr, i19, cArr, 0, i27);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f35227in;
            int i28 = this.limit;
            int read = reader.read(cArr, i28, cArr.length - i28);
            if (read == -1) {
                return false;
            }
            i16 = this.limit + read;
            this.limit = i16;
            if (this.lineNumber == 0 && (i17 = this.lineStart) == 0 && i16 > 0 && cArr[0] == '\ufeff') {
                this.pos++;
                this.lineStart = i17 + 1;
                i3++;
            }
        } while (i16 < i3);
        return true;
    }

    private boolean isLiteral(char c16) throws IOException {
        if (c16 != '\t' && c16 != '\n' && c16 != '\f' && c16 != '\r' && c16 != ' ') {
            if (c16 != '#') {
                if (c16 != ',') {
                    if (c16 != '/' && c16 != '=') {
                        if (c16 != '{' && c16 != '}' && c16 != ':') {
                            if (c16 != ';') {
                                switch (c16) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            checkLenient();
            return false;
        }
        return false;
    }

    private int nextNonWhitespace(boolean z16) throws IOException {
        char[] cArr = this.buffer;
        int i3 = this.pos;
        int i16 = this.limit;
        while (true) {
            if (i3 == i16) {
                this.pos = i3;
                if (!fillBuffer(1)) {
                    if (!z16) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i3 = this.pos;
                i16 = this.limit;
            }
            int i17 = i3 + 1;
            char c16 = cArr[i3];
            if (c16 == '\n') {
                this.lineNumber++;
                this.lineStart = i17;
            } else if (c16 != ' ' && c16 != '\r' && c16 != '\t') {
                if (c16 == '/') {
                    this.pos = i17;
                    if (i17 == i16) {
                        this.pos = i17 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c16;
                        }
                    }
                    checkLenient();
                    int i18 = this.pos;
                    char c17 = cArr[i18];
                    if (c17 != '*') {
                        if (c17 != '/') {
                            return c16;
                        }
                        this.pos = i18 + 1;
                        skipToEndOfLine();
                        i3 = this.pos;
                        i16 = this.limit;
                    } else {
                        this.pos = i18 + 1;
                        if (skipTo("*/")) {
                            i3 = this.pos + 2;
                            i16 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    }
                } else if (c16 == '#') {
                    this.pos = i17;
                    checkLenient();
                    skipToEndOfLine();
                    i3 = this.pos;
                    i16 = this.limit;
                } else {
                    this.pos = i17;
                    return c16;
                }
            }
            i3 = i17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextQuotedValue(char c16) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb5 = null;
        do {
            int i3 = this.pos;
            int i16 = this.limit;
            while (true) {
                int i17 = i16;
                int i18 = i3;
                while (i3 < i17) {
                    int i19 = i3 + 1;
                    char c17 = cArr[i3];
                    if (c17 == c16) {
                        this.pos = i19;
                        int i26 = (i19 - i18) - 1;
                        if (sb5 == null) {
                            return new String(cArr, i18, i26);
                        }
                        sb5.append(cArr, i18, i26);
                        return sb5.toString();
                    }
                    if (c17 == '\\') {
                        this.pos = i19;
                        int i27 = (i19 - i18) - 1;
                        if (sb5 == null) {
                            sb5 = new StringBuilder(Math.max((i27 + 1) * 2, 16));
                        }
                        sb5.append(cArr, i18, i27);
                        sb5.append(readEscapeCharacter());
                        i3 = this.pos;
                        i16 = this.limit;
                    } else {
                        if (c17 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i19;
                        }
                        i3 = i19;
                    }
                }
                break;
            }
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        checkLenient();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String nextUnquotedValue() throws IOException {
        String sb5;
        StringBuilder sb6 = null;
        int i3 = 0;
        do {
            int i16 = 0;
            while (true) {
                int i17 = this.pos;
                if (i17 + i16 < this.limit) {
                    char c16 = this.buffer[i17 + i16];
                    if (c16 != '\t' && c16 != '\n' && c16 != '\f' && c16 != '\r' && c16 != ' ') {
                        if (c16 != '#') {
                            if (c16 != ',') {
                                if (c16 != '/' && c16 != '=') {
                                    if (c16 != '{' && c16 != '}' && c16 != ':') {
                                        if (c16 != ';') {
                                            switch (c16) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i16++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i16 < this.buffer.length) {
                    if (fillBuffer(i16 + 1)) {
                    }
                } else {
                    if (sb6 == null) {
                        sb6 = new StringBuilder(Math.max(i16, 16));
                    }
                    sb6.append(this.buffer, this.pos, i16);
                    this.pos += i16;
                }
            }
            i3 = i16;
            if (sb6 != null) {
                sb5 = new String(this.buffer, this.pos, i3);
            } else {
                sb6.append(this.buffer, this.pos, i3);
                sb5 = sb6.toString();
            }
            this.pos += i3;
            return sb5;
        } while (fillBuffer(1));
        if (sb6 != null) {
        }
        this.pos += i3;
        return sb5;
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i3;
        char c16 = this.buffer[this.pos];
        if (c16 != 't' && c16 != 'T') {
            if (c16 != 'f' && c16 != 'F') {
                if (c16 != 'n' && c16 != 'N') {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i3 = 7;
            } else {
                str = "false";
                str2 = Constants.KEY_OPTION_FALSE;
                i3 = 6;
            }
        } else {
            str = "true";
            str2 = Constants.KEY_OPTION_TRUE;
            i3 = 5;
        }
        int length = str.length();
        for (int i16 = 1; i16 < length; i16++) {
            if (this.pos + i16 >= this.limit && !fillBuffer(i16 + 1)) {
                return 0;
            }
            char c17 = this.buffer[this.pos + i16];
            if (c17 != str.charAt(i16) && c17 != str2.charAt(i16)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
    
        r18.peekedLong = r11;
        r18.pos += r8;
        r18.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        r18.peekedNumberLength = r8;
        r18.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0091, code lost:
    
        if (isLiteral(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c9, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        char c16;
        boolean z16;
        char[] cArr = this.buffer;
        int i3 = this.pos;
        int i16 = this.limit;
        int i17 = 0;
        int i18 = 0;
        char c17 = 0;
        boolean z17 = false;
        boolean z18 = true;
        long j3 = 0;
        while (true) {
            if (i3 + i18 == i16) {
                if (i18 == cArr.length) {
                    return i17;
                }
                if (!fillBuffer(i18 + 1)) {
                    break;
                }
                i3 = this.pos;
                i16 = this.limit;
            }
            char c18 = cArr[i3 + i18];
            if (c18 != '+') {
                if (c18 != 'E' && c18 != 'e') {
                    if (c18 != '-') {
                        c16 = 3;
                        if (c18 != '.') {
                            if (c18 < '0' || c18 > '9') {
                                break;
                            }
                            if (c17 != 1 && c17 != 0) {
                                if (c17 == 2) {
                                    if (j3 == 0) {
                                        return 0;
                                    }
                                    long j16 = (10 * j3) - (c18 - '0');
                                    if (j3 <= -922337203685477580L && (j3 != -922337203685477580L || j16 >= j3)) {
                                        z16 = false;
                                    } else {
                                        z16 = true;
                                    }
                                    z18 &= z16;
                                    j3 = j16;
                                } else if (c17 == 3) {
                                    i17 = 0;
                                    c17 = 4;
                                } else if (c17 == 5 || c17 == 6) {
                                    i17 = 0;
                                    c17 = 7;
                                }
                            } else {
                                j3 = -(c18 - '0');
                                c17 = 2;
                            }
                            i17 = 0;
                        } else {
                            i17 = 0;
                            if (c17 != 2) {
                                return 0;
                            }
                        }
                    } else {
                        c16 = 6;
                        i17 = 0;
                        if (c17 == 0) {
                            c17 = 1;
                            z17 = true;
                        } else if (c17 != 5) {
                            return 0;
                        }
                    }
                } else {
                    i17 = 0;
                    if (c17 != 2 && c17 != 4) {
                        return 0;
                    }
                    c17 = 5;
                }
                i18++;
            } else {
                c16 = 6;
                i17 = 0;
                if (c17 != 5) {
                    return 0;
                }
            }
            c17 = c16;
            i18++;
        }
    }

    private void push(int i3) {
        int i16 = this.stackSize;
        int[] iArr = this.stack;
        if (i16 == iArr.length) {
            int[] iArr2 = new int[i16 * 2];
            int[] iArr3 = new int[i16 * 2];
            String[] strArr = new String[i16 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i16);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i17 = this.stackSize;
        this.stackSize = i17 + 1;
        iArr4[i17] = i3;
    }

    private char readEscapeCharacter() throws IOException {
        int i3;
        int i16;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i17 = this.pos;
        int i18 = i17 + 1;
        this.pos = i18;
        char c16 = cArr[i17];
        if (c16 != '\n') {
            if (c16 != '\"' && c16 != '\'' && c16 != '/' && c16 != '\\') {
                if (c16 != 'b') {
                    if (c16 != 'f') {
                        if (c16 == 'n') {
                            return '\n';
                        }
                        if (c16 != 'r') {
                            if (c16 != 't') {
                                if (c16 == 'u') {
                                    if (i18 + 4 > this.limit && !fillBuffer(4)) {
                                        throw syntaxError("Unterminated escape sequence");
                                    }
                                    int i19 = this.pos;
                                    int i26 = i19 + 4;
                                    char c17 = 0;
                                    while (i19 < i26) {
                                        char c18 = this.buffer[i19];
                                        char c19 = (char) (c17 << 4);
                                        if (c18 >= '0' && c18 <= '9') {
                                            i16 = c18 - '0';
                                        } else {
                                            if (c18 >= 'a' && c18 <= 'f') {
                                                i3 = c18 - 'a';
                                            } else if (c18 >= 'A' && c18 <= 'F') {
                                                i3 = c18 - 'A';
                                            } else {
                                                throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                            }
                                            i16 = i3 + 10;
                                        }
                                        c17 = (char) (c19 + i16);
                                        i19++;
                                    }
                                    this.pos += 4;
                                    return c17;
                                }
                                throw syntaxError("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
        } else {
            this.lineNumber++;
            this.lineStart = i18;
        }
        return c16;
    }

    private void skipQuotedValue(char c16) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i3 = this.pos;
            int i16 = this.limit;
            while (i3 < i16) {
                int i17 = i3 + 1;
                char c17 = cArr[i3];
                if (c17 == c16) {
                    this.pos = i17;
                    return;
                }
                if (c17 == '\\') {
                    this.pos = i17;
                    readEscapeCharacter();
                    i3 = this.pos;
                    i16 = this.limit;
                } else {
                    if (c17 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i17;
                    }
                    i3 = i17;
                }
            }
            this.pos = i3;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i3 = this.pos;
            if (cArr[i3] == '\n') {
                this.lineNumber++;
                this.lineStart = i3 + 1;
            } else {
                for (int i16 = 0; i16 < length; i16++) {
                    if (this.buffer[this.pos + i16] != str.charAt(i16)) {
                        break;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c16;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i3 = this.pos;
                int i16 = i3 + 1;
                this.pos = i16;
                c16 = cArr[i3];
                if (c16 == '\n') {
                    this.lineNumber++;
                    this.lineStart = i16;
                    return;
                }
            } else {
                return;
            }
        } while (c16 != '\r');
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L51
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.checkLenient()
        L4b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L51:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 1) {
            push(3);
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f35227in.close();
    }

    int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i3 = this.stackSize;
        int i16 = iArr[i3 - 1];
        if (i16 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i16 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 != 59) {
                    if (nextNonWhitespace2 == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        } else if (i16 != 3 && i16 != 5) {
            if (i16 == 4) {
                iArr[i3 - 1] = 5;
                int nextNonWhitespace3 = nextNonWhitespace(true);
                if (nextNonWhitespace3 != 58) {
                    if (nextNonWhitespace3 == 61) {
                        checkLenient();
                        if (this.pos < this.limit || fillBuffer(1)) {
                            char[] cArr = this.buffer;
                            int i17 = this.pos;
                            if (cArr[i17] == '>') {
                                this.pos = i17 + 1;
                            }
                        }
                    } else {
                        throw syntaxError("Expected ':'");
                    }
                }
            } else if (i16 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i16 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i16 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i3 - 1] = 4;
            if (i16 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace == 125) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Unterminated object");
                }
                checkLenient();
            }
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 34) {
                if (nextNonWhitespace4 != 39) {
                    if (nextNonWhitespace4 != 125) {
                        checkLenient();
                        this.pos--;
                        if (isLiteral((char) nextNonWhitespace4)) {
                            this.peeked = 14;
                            return 14;
                        }
                        throw syntaxError("Expected name");
                    }
                    if (i16 != 5) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                }
                checkLenient();
                this.peeked = 12;
                return 12;
            }
            this.peeked = 13;
            return 13;
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 != 34) {
            if (nextNonWhitespace5 != 39) {
                if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                    if (nextNonWhitespace5 != 91) {
                        if (nextNonWhitespace5 != 93) {
                            if (nextNonWhitespace5 != 123) {
                                this.pos--;
                                int peekKeyword = peekKeyword();
                                if (peekKeyword != 0) {
                                    return peekKeyword;
                                }
                                int peekNumber = peekNumber();
                                if (peekNumber != 0) {
                                    return peekNumber;
                                }
                                if (isLiteral(this.buffer[this.pos])) {
                                    checkLenient();
                                    this.peeked = 10;
                                    return 10;
                                }
                                throw syntaxError("Expected value");
                            }
                            this.peeked = 1;
                            return 1;
                        }
                        if (i16 == 1) {
                            this.peeked = 4;
                            return 4;
                        }
                    } else {
                        this.peeked = 3;
                        return 3;
                    }
                }
                if (i16 != 1 && i16 != 2) {
                    throw syntaxError("Unexpected value");
                }
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            checkLenient();
            this.peeked = 8;
            return 8;
        }
        this.peeked = 9;
        return 9;
    }

    public void endArray() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 4) {
            int i16 = this.stackSize - 1;
            this.stackSize = i16;
            int[] iArr = this.pathIndices;
            int i17 = i16 - 1;
            iArr[i17] = iArr[i17] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 2) {
            int i16 = this.stackSize - 1;
            this.stackSize = i16;
            this.pathNames[i16] = null;
            int[] iArr = this.pathIndices;
            int i17 = i16 - 1;
            iArr[i17] = iArr[i17] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('$');
        int i3 = this.stackSize;
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = this.stack[i16];
            if (i17 != 1 && i17 != 2) {
                if (i17 == 3 || i17 == 4 || i17 == 5) {
                    sb5.append('.');
                    String str = this.pathNames[i16];
                    if (str != null) {
                        sb5.append(str);
                    }
                }
            } else {
                sb5.append('[');
                sb5.append(this.pathIndices[i16]);
                sb5.append(']');
            }
        }
        return sb5.toString();
    }

    public boolean hasNext() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 != 2 && i3 != 4) {
            return true;
        }
        return false;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr[i16] = iArr[i16] + 1;
            return true;
        }
        if (i3 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i17 = this.stackSize - 1;
            iArr2[i17] = iArr2[i17] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        char c16;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr[i16] = iArr[i16] + 1;
            return this.peekedLong;
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i3 != 8 && i3 != 9) {
            if (i3 == 10) {
                this.peekedString = nextUnquotedValue();
            } else if (i3 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
        } else {
            if (i3 == 8) {
                c16 = '\'';
            } else {
                c16 = '\"';
            }
            this.peekedString = nextQuotedValue(c16);
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i17 = this.stackSize - 1;
        iArr2[i17] = iArr2[i17] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        char c16;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            long j3 = this.peekedLong;
            int i16 = (int) j3;
            if (j3 == i16) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i17 = this.stackSize - 1;
                iArr[i17] = iArr[i17] + 1;
                return i16;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (i3 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i3 == 8) {
                    c16 = '\'';
                } else {
                    c16 = '\"';
                }
                this.peekedString = nextQuotedValue(c16);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i18 = this.stackSize - 1;
                iArr2[i18] = iArr2[i18] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i19 = (int) parseDouble;
        if (i19 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i26 = this.stackSize - 1;
            iArr3[i26] = iArr3[i26] + 1;
            return i19;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        char c16;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr[i16] = iArr[i16] + 1;
            return this.peekedLong;
        }
        if (i3 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (i3 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i3 == 8) {
                    c16 = '\'';
                } else {
                    c16 = '\"';
                }
                this.peekedString = nextQuotedValue(c16);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i17 = this.stackSize - 1;
                iArr2[i17] = iArr2[i17] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j3 = (long) parseDouble;
        if (j3 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i18 = this.stackSize - 1;
            iArr3[i18] = iArr3[i18] + 1;
            return j3;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (i3 == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else if (i3 == 13) {
            nextQuotedValue = nextQuotedValue('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr[i16] = iArr[i16] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 10) {
            str = nextUnquotedValue();
        } else if (i3 == 8) {
            str = nextQuotedValue('\'');
        } else if (i3 == 9) {
            str = nextQuotedValue('\"');
        } else if (i3 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i3 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i3 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i16 = this.stackSize - 1;
        iArr[i16] = iArr[i16] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        switch (i3) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z16) {
        this.lenient = z16;
    }

    public void skipValue() throws IOException {
        int i3 = 0;
        do {
            int i16 = this.peeked;
            if (i16 == 0) {
                i16 = doPeek();
            }
            if (i16 == 3) {
                push(1);
            } else if (i16 == 1) {
                push(3);
            } else {
                if (i16 == 4) {
                    this.stackSize--;
                } else if (i16 == 2) {
                    this.stackSize--;
                } else {
                    if (i16 != 14 && i16 != 10) {
                        if (i16 != 8 && i16 != 12) {
                            if (i16 != 9 && i16 != 13) {
                                if (i16 == 16) {
                                    this.pos += this.peekedNumberLength;
                                }
                            } else {
                                skipQuotedValue('\"');
                            }
                        } else {
                            skipQuotedValue('\'');
                        }
                    } else {
                        skipUnquotedValue();
                    }
                    this.peeked = 0;
                }
                i3--;
                this.peeked = 0;
            }
            i3++;
            this.peeked = 0;
        } while (i3 != 0);
        int[] iArr = this.pathIndices;
        int i17 = this.stackSize;
        int i18 = i17 - 1;
        iArr[i18] = iArr[i18] + 1;
        this.pathNames[i17 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
