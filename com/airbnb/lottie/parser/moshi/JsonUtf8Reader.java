package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
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
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Buffer buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;

    @Nullable
    private String peekedString;
    private final BufferedSource source;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    private static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
    private static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.source = bufferedSource;
            this.buffer = bufferedSource.getBufferField();
            pushScope(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void checkLenient() throws IOException {
        if (this.lenient) {
        } else {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws IOException {
        int[] iArr = this.scopes;
        int i3 = this.stackSize;
        int i16 = iArr[i3 - 1];
        if (i16 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i16 == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace == 93) {
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
                int nextNonWhitespace2 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace2 != 58) {
                    if (nextNonWhitespace2 == 61) {
                        checkLenient();
                        if (this.source.request(1L) && this.buffer.getByte(0L) == 62) {
                            this.buffer.readByte();
                        }
                    } else {
                        throw syntaxError("Expected ':'");
                    }
                }
            } else if (i16 == 6) {
                iArr[i3 - 1] = 7;
            } else if (i16 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 18;
                    return 18;
                }
                checkLenient();
            } else if (i16 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i3 - 1] = 4;
            if (i16 == 5) {
                int nextNonWhitespace3 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace3 != 44) {
                    if (nextNonWhitespace3 != 59) {
                        if (nextNonWhitespace3 == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
            }
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 34) {
                if (nextNonWhitespace4 != 39) {
                    if (nextNonWhitespace4 != 125) {
                        checkLenient();
                        if (isLiteral((char) nextNonWhitespace4)) {
                            this.peeked = 14;
                            return 14;
                        }
                        throw syntaxError("Expected name");
                    }
                    if (i16 != 5) {
                        this.buffer.readByte();
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Expected name");
                }
                this.buffer.readByte();
                checkLenient();
                this.peeked = 12;
                return 12;
            }
            this.buffer.readByte();
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
                                int peekKeyword = peekKeyword();
                                if (peekKeyword != 0) {
                                    return peekKeyword;
                                }
                                int peekNumber = peekNumber();
                                if (peekNumber != 0) {
                                    return peekNumber;
                                }
                                if (isLiteral(this.buffer.getByte(0L))) {
                                    checkLenient();
                                    this.peeked = 10;
                                    return 10;
                                }
                                throw syntaxError("Expected value");
                            }
                            this.buffer.readByte();
                            this.peeked = 1;
                            return 1;
                        }
                        if (i16 == 1) {
                            this.buffer.readByte();
                            this.peeked = 4;
                            return 4;
                        }
                    } else {
                        this.buffer.readByte();
                        this.peeked = 3;
                        return 3;
                    }
                }
                if (i16 != 1 && i16 != 2) {
                    throw syntaxError("Unexpected value");
                }
                checkLenient();
                this.peeked = 7;
                return 7;
            }
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        }
        this.buffer.readByte();
        this.peeked = 9;
        return 9;
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(options.strings[i3])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i3;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i3) throws IOException {
        if (i3 != 9 && i3 != 10 && i3 != 12 && i3 != 13 && i3 != 32) {
            if (i3 != 35) {
                if (i3 != 44) {
                    if (i3 != 47 && i3 != 61) {
                        if (i3 != 123 && i3 != 125 && i3 != 58) {
                            if (i3 != 59) {
                                switch (i3) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.buffer.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r1 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r6.source.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        checkLenient();
        r3 = r6.buffer.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (skipToEndOfBlockComment() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
    
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003b, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int nextNonWhitespace(boolean z16) throws IOException {
        while (true) {
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                if (this.source.request(i16)) {
                    byte b16 = this.buffer.getByte(i3);
                    if (b16 != 10 && b16 != 32 && b16 != 13 && b16 != 9) {
                        break;
                    }
                    i3 = i16;
                } else {
                    if (!z16) {
                        return -1;
                    }
                    throw new EOFException("End of input");
                }
            }
        }
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb5 = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.buffer.getByte(indexOfElement) == 92) {
                    if (sb5 == null) {
                        sb5 = new StringBuilder();
                    }
                    sb5.append(this.buffer.readUtf8(indexOfElement));
                    this.buffer.readByte();
                    sb5.append(readEscapeCharacter());
                } else {
                    if (sb5 == null) {
                        String readUtf8 = this.buffer.readUtf8(indexOfElement);
                        this.buffer.readByte();
                        return readUtf8;
                    }
                    sb5.append(this.buffer.readUtf8(indexOfElement));
                    this.buffer.readByte();
                    return sb5.toString();
                }
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        if (indexOfElement != -1) {
            return this.buffer.readUtf8(indexOfElement);
        }
        return this.buffer.readUtf8();
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i3;
        byte b16 = this.buffer.getByte(0L);
        if (b16 != 116 && b16 != 84) {
            if (b16 != 102 && b16 != 70) {
                if (b16 != 110 && b16 != 78) {
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
        int i16 = 1;
        while (i16 < length) {
            int i17 = i16 + 1;
            if (!this.source.request(i17)) {
                return 0;
            }
            byte b17 = this.buffer.getByte(i16);
            if (b17 != str.charAt(i16) && b17 != str2.charAt(i16)) {
                return 0;
            }
            i16 = i17;
        }
        if (this.source.request(length + 1) && isLiteral(this.buffer.getByte(length))) {
            return 0;
        }
        this.buffer.skip(length);
        this.peeked = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (isLiteral(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.peekedLong = r8;
        r16.buffer.skip(r5);
        r16.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.peekedNumberLength = r5;
        r16.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int peekNumber() throws IOException {
        char c16;
        boolean z16;
        boolean z17 = true;
        long j3 = 0;
        int i3 = 0;
        char c17 = 0;
        boolean z18 = false;
        boolean z19 = true;
        while (true) {
            int i16 = i3 + 1;
            if (!this.source.request(i16)) {
                break;
            }
            byte b16 = this.buffer.getByte(i3);
            if (b16 != 43) {
                if (b16 != 69 && b16 != 101) {
                    if (b16 != 45) {
                        if (b16 != 46) {
                            if (b16 < 48 || b16 > 57) {
                                break;
                            }
                            if (c17 != z17 && c17 != 0) {
                                if (c17 == 2) {
                                    if (j3 == 0) {
                                        return 0;
                                    }
                                    long j16 = (10 * j3) - (b16 - 48);
                                    if (j3 <= -922337203685477580L && (j3 != -922337203685477580L || j16 >= j3)) {
                                        z16 = false;
                                    } else {
                                        z16 = true;
                                    }
                                    z19 &= z16;
                                    j3 = j16;
                                } else if (c17 == 3) {
                                    c17 = 4;
                                } else if (c17 == 5 || c17 == 6) {
                                    c17 = 7;
                                }
                            } else {
                                j3 = -(b16 - 48);
                                c17 = 2;
                            }
                        } else {
                            if (c17 != 2) {
                                return 0;
                            }
                            c17 = 3;
                        }
                    } else {
                        c16 = 6;
                        if (c17 == 0) {
                            c17 = 1;
                            z18 = true;
                        } else if (c17 != 5) {
                            return 0;
                        }
                    }
                } else {
                    if (c17 != 2 && c17 != 4) {
                        return 0;
                    }
                    c17 = 5;
                }
                i3 = i16;
                z17 = true;
            } else {
                c16 = 6;
                if (c17 != 5) {
                    return 0;
                }
            }
            c17 = c16;
            i3 = i16;
            z17 = true;
        }
    }

    private char readEscapeCharacter() throws IOException {
        int i3;
        int i16;
        if (this.source.request(1L)) {
            byte readByte = this.buffer.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.lenient) {
                                        return (char) readByte;
                                    }
                                    throw syntaxError("Invalid escape sequence: \\" + ((char) readByte));
                                }
                                if (this.source.request(4L)) {
                                    char c16 = 0;
                                    for (int i17 = 0; i17 < 4; i17++) {
                                        byte b16 = this.buffer.getByte(i17);
                                        char c17 = (char) (c16 << 4);
                                        if (b16 >= 48 && b16 <= 57) {
                                            i16 = b16 - 48;
                                        } else {
                                            if (b16 >= 97 && b16 <= 102) {
                                                i3 = b16 - 97;
                                            } else {
                                                if (b16 < 65 || b16 > 70) {
                                                    throw syntaxError("\\u" + this.buffer.readUtf8(4L));
                                                }
                                                i3 = b16 - 65;
                                            }
                                            i16 = i3 + 10;
                                        }
                                        c16 = (char) (c17 + i16);
                                    }
                                    this.buffer.skip(4L);
                                    return c16;
                                }
                                throw new EOFException("Unterminated escape sequence at path " + getPath());
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                if (this.buffer.getByte(indexOfElement) == 92) {
                    this.buffer.skip(indexOfElement + 1);
                    readEscapeCharacter();
                } else {
                    this.buffer.skip(indexOfElement + 1);
                    return;
                }
            } else {
                throw syntaxError("Unterminated string");
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        boolean z16;
        long size;
        long indexOf = this.source.indexOf(CLOSING_BLOCK_COMMENT);
        if (indexOf != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        Buffer buffer = this.buffer;
        if (z16) {
            size = indexOf + r1.size();
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
        return z16;
    }

    private void skipToEndOfLine() throws IOException {
        long size;
        long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer = this.buffer;
        if (indexOfElement != -1) {
            size = indexOfElement + 1;
        } else {
            size = buffer.size();
        }
        buffer.skip(size);
    }

    private void skipUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginArray() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void beginObject() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 1) {
            pushScope(3);
            this.peeked = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean hasNext() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 != 2 && i3 != 4 && i3 != 18) {
            return true;
        }
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double nextDouble() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr[i16] = iArr[i16] + 1;
            return this.peekedLong;
        }
        if (i3 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i3 == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i3 == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i3 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i3 != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i17 = this.stackSize - 1;
            iArr2[i17] = iArr2[i17] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int nextInt() throws IOException {
        String nextQuotedValue;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 16) {
            long j3 = this.peekedLong;
            int i16 = (int) j3;
            if (j3 == i16) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i17 = this.stackSize - 1;
                iArr[i17] = iArr[i17] + 1;
                return i16;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (i3 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i3 != 9 && i3 != 8) {
            if (i3 != 11) {
                throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
            }
        } else {
            if (i3 == 9) {
                nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(nextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i18 = this.stackSize - 1;
                iArr2[i18] = iArr2[i18] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        try {
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
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextName() throws IOException {
        String str;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 14) {
            str = nextUnquotedValue();
        } else if (i3 == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i3 == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i3 == 15) {
            str = this.peekedString;
        } else {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String nextString() throws IOException {
        String readUtf8;
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 == 10) {
            readUtf8 = nextUnquotedValue();
        } else if (i3 == 9) {
            readUtf8 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i3 == 8) {
            readUtf8 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i3 == 11) {
            readUtf8 = this.peekedString;
            this.peekedString = null;
        } else if (i3 == 16) {
            readUtf8 = Long.toString(this.peekedLong);
        } else if (i3 == 17) {
            readUtf8 = this.buffer.readUtf8(this.peekedNumberLength);
        } else {
            throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i16 = this.stackSize - 1;
        iArr[i16] = iArr[i16] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token peek() throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        switch (i3) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws IOException {
        int i3 = this.peeked;
        if (i3 == 0) {
            i3 = doPeek();
        }
        if (i3 < 12 || i3 > 15) {
            return -1;
        }
        if (i3 == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[select];
            return select;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipName() throws IOException {
        if (!this.failOnUnknown) {
            int i3 = this.peeked;
            if (i3 == 0) {
                i3 = doPeek();
            }
            if (i3 == 14) {
                skipUnquotedValue();
            } else if (i3 == 13) {
                skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (i3 == 12) {
                skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (i3 != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            int i3 = 0;
            do {
                int i16 = this.peeked;
                if (i16 == 0) {
                    i16 = doPeek();
                }
                if (i16 == 3) {
                    pushScope(1);
                } else if (i16 == 1) {
                    pushScope(3);
                } else {
                    if (i16 == 4) {
                        i3--;
                        if (i3 >= 0) {
                            this.stackSize--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i16 == 2) {
                        i3--;
                        if (i3 >= 0) {
                            this.stackSize--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                        }
                    } else if (i16 != 14 && i16 != 10) {
                        if (i16 != 9 && i16 != 13) {
                            if (i16 != 8 && i16 != 12) {
                                if (i16 == 17) {
                                    this.buffer.skip(this.peekedNumberLength);
                                } else if (i16 == 18) {
                                    throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                                }
                            } else {
                                skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                            }
                        } else {
                            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                        }
                    } else {
                        skipUnquotedValue();
                    }
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
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }
}
