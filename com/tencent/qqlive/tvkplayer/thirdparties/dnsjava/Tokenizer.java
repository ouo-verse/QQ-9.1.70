package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.RelativeNameException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.exception.TextParseException;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils.base16;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils.base32;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.utils.base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Tokenizer implements AutoCloseable {
    public static final int COMMENT = 5;
    private static final String DEFAULT_DELIMITERS = " \t\n;()\"";
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    private static final String QUOTES = "\"";
    public static final int WHITESPACE = 2;
    private Token current;
    private String delimiters;
    private String filename;

    /* renamed from: is, reason: collision with root package name */
    private final PushbackInputStream f345851is;
    private int line;
    private int multiline;
    private boolean quoting;

    /* renamed from: sb, reason: collision with root package name */
    private final StringBuilder f345852sb;
    private boolean ungottenToken;
    private boolean wantClose;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Token {

        @Deprecated
        public int type;

        @Deprecated
        public String value;

        public boolean isEOL() {
            int i3 = this.type;
            if (i3 == 1 || i3 == 0) {
                return true;
            }
            return false;
        }

        public boolean isString() {
            int i3 = this.type;
            if (i3 != 3 && i3 != 4) {
                return false;
            }
            return true;
        }

        public String toString() {
            int i3 = this.type;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    return "<unknown>";
                                }
                                return "<comment: " + this.value + ">";
                            }
                            return "<quoted_string: " + this.value + ">";
                        }
                        return "<identifier: " + this.value + ">";
                    }
                    return "<whitespace>";
                }
                return "<eol>";
            }
            return "<eof>";
        }

        public int type() {
            return this.type;
        }

        public String value() {
            return this.value;
        }

        Token(int i3, StringBuilder sb5) {
            if (i3 >= 0) {
                this.type = i3;
                this.value = sb5 == null ? null : sb5.toString();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.f345851is = new PushbackInputStream(inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream), 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = DEFAULT_DELIMITERS;
        this.f345852sb = new StringBuilder();
        this.filename = "<none>";
        this.line = 1;
    }

    private void checkUnbalancedParens() throws TextParseException {
        if (this.multiline <= 0) {
        } else {
            throw exception("unbalanced parentheses");
        }
    }

    private int getChar() throws IOException {
        int read = this.f345851is.read();
        if (read == 13) {
            int read2 = this.f345851is.read();
            if (read2 != 10) {
                this.f345851is.unread(read2);
            }
            read = 10;
        }
        if (read == 10) {
            this.line++;
        }
        return read;
    }

    private String getIdentifier(String str) throws IOException {
        Token token = get();
        if (token.type == 3) {
            return token.value;
        }
        throw exception("expected " + str);
    }

    private String remainingStrings() throws IOException {
        StringBuilder sb5 = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (sb5 == null) {
                sb5 = new StringBuilder();
            }
            sb5.append(token.value);
        }
        unget();
        if (sb5 == null) {
            return null;
        }
        return sb5.toString();
    }

    private Token setCurrentToken(int i3, StringBuilder sb5) {
        Token token = new Token(i3, sb5);
        this.current = token;
        return token;
    }

    private int skipWhitespace() throws IOException {
        int i3;
        int i16 = 0;
        while (true) {
            i3 = getChar();
            if (i3 == 32 || i3 == 9 || (i3 == 10 && this.multiline > 0)) {
                i16++;
            }
        }
        ungetChar(i3);
        return i16;
    }

    private void ungetChar(int i3) throws IOException {
        if (i3 == -1) {
            return;
        }
        this.f345851is.unread(i3);
        if (i3 == 10) {
            this.line--;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.wantClose) {
            try {
                this.f345851is.close();
            } catch (IOException unused) {
            }
        }
    }

    public TextParseException exception(String str) {
        return new TextParseException(this.filename + ":" + this.line + MsgSummary.STR_COLON + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0131, code lost:
    
        ungetChar(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x013a, code lost:
    
        if (r9.f345852sb.length() != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x013c, code lost:
    
        if (r10 == 4) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x013e, code lost:
    
        checkUnbalancedParens();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0145, code lost:
    
        return setCurrentToken(0, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x014c, code lost:
    
        return setCurrentToken(r10, r9.f345852sb);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Token get(boolean z16, boolean z17) throws IOException {
        int i3;
        if (this.ungottenToken) {
            this.ungottenToken = false;
            Token token = this.current;
            int i16 = token.type;
            if (i16 == 2) {
                if (z16) {
                    return token;
                }
            } else {
                if (i16 != 5) {
                    if (i16 == 1) {
                        this.line++;
                    }
                    return token;
                }
                if (z17) {
                    return token;
                }
            }
        }
        if (skipWhitespace() > 0 && z16) {
            return setCurrentToken(2, null);
        }
        this.f345852sb.setLength(0);
        int i17 = 3;
        while (true) {
            int i18 = getChar();
            if (i18 != -1 && this.delimiters.indexOf(i18) == -1) {
                if (i18 == 92) {
                    i18 = getChar();
                    if (i18 != -1) {
                        this.f345852sb.append('\\');
                    } else {
                        throw exception("unterminated escape sequence");
                    }
                } else if (this.quoting && i18 == 10) {
                    throw exception("newline in quoted string");
                }
                this.f345852sb.append((char) i18);
            } else {
                if (i18 == -1) {
                    if (!this.quoting) {
                        if (this.f345852sb.length() == 0) {
                            return setCurrentToken(0, null);
                        }
                        return setCurrentToken(i17, this.f345852sb);
                    }
                    throw exception("EOF in quoted string");
                }
                if (this.f345852sb.length() != 0 || i17 == 4) {
                    break;
                }
                if (i18 == 40) {
                    this.multiline++;
                    skipWhitespace();
                } else if (i18 == 41) {
                    int i19 = this.multiline;
                    if (i19 > 0) {
                        this.multiline = i19 - 1;
                        skipWhitespace();
                    } else {
                        throw exception("invalid close parenthesis");
                    }
                } else if (i18 == 34) {
                    if (!this.quoting) {
                        this.quoting = true;
                        this.delimiters = QUOTES;
                        i17 = 4;
                    } else {
                        this.quoting = false;
                        this.delimiters = DEFAULT_DELIMITERS;
                        skipWhitespace();
                    }
                } else {
                    if (i18 == 10) {
                        return setCurrentToken(1, null);
                    }
                    if (i18 != 59) {
                        throw new IllegalStateException();
                    }
                    while (true) {
                        i3 = getChar();
                        if (i3 == 10 || i3 == -1) {
                            break;
                        }
                        this.f345852sb.append((char) i3);
                    }
                    if (z17) {
                        ungetChar(i3);
                        return setCurrentToken(5, this.f345852sb);
                    }
                    if (i3 == -1 && i17 != 4) {
                        checkUnbalancedParens();
                        return setCurrentToken(0, null);
                    }
                    if (this.multiline > 0) {
                        skipWhitespace();
                        this.f345852sb.setLength(0);
                    } else {
                        return setCurrentToken(1, null);
                    }
                }
            }
        }
    }

    public InetAddress getAddress(int i3) throws IOException {
        try {
            return Address.getByAddress(getIdentifier("an address"), i3);
        } catch (UnknownHostException e16) {
            throw exception(e16.getMessage());
        }
    }

    public byte[] getAddressBytes(int i3) throws IOException {
        String identifier = getIdentifier("an address");
        byte[] byteArray = Address.toByteArray(identifier, i3);
        if (byteArray != null) {
            return byteArray;
        }
        throw exception("Invalid address: " + identifier);
    }

    public byte[] getBase32String(base32 base32Var) throws IOException {
        byte[] fromString = base32Var.fromString(getIdentifier("a base32 string"));
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid base32 encoding");
    }

    public byte[] getBase64(boolean z16) throws IOException {
        String remainingStrings = remainingStrings();
        if (remainingStrings == null) {
            if (z16) {
                throw exception("expected base64 encoded string");
            }
            return null;
        }
        byte[] fromString = base64.fromString(remainingStrings);
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid base64 encoding");
    }

    public void getEOL() throws IOException {
        int i3 = get().type;
        if (i3 != 1 && i3 != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    public byte[] getHex(boolean z16) throws IOException {
        String remainingStrings = remainingStrings();
        if (remainingStrings == null) {
            if (z16) {
                throw exception("expected hex encoded string");
            }
            return null;
        }
        byte[] fromString = base16.fromString(remainingStrings);
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid hex encoding");
    }

    public byte[] getHexString() throws IOException {
        byte[] fromString = base16.fromString(getIdentifier("a hex string"));
        if (fromString != null) {
            return fromString;
        }
        throw exception("invalid hex encoding");
    }

    public long getLong() throws IOException {
        String identifier = getIdentifier("an integer");
        if (Character.isDigit(identifier.charAt(0))) {
            try {
                return Long.parseLong(identifier);
            } catch (NumberFormatException unused) {
                throw exception("expected an integer");
            }
        }
        throw exception("expected an integer");
    }

    public Name getName(Name name) throws IOException {
        try {
            Name fromString = Name.fromString(getIdentifier("a name"), name);
            if (fromString.isAbsolute()) {
                return fromString;
            }
            throw new RelativeNameException(fromString);
        } catch (TextParseException e16) {
            throw exception(e16.getMessage());
        }
    }

    public String getString() throws IOException {
        Token token = get();
        if (token.isString()) {
            return token.value;
        }
        throw exception("expected a string");
    }

    public long getTTL() throws IOException {
        try {
            return TTL.parseTTL(getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() throws IOException {
        try {
            return TTL.parse(getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public int getUInt16() throws IOException {
        long j3 = getLong();
        if (j3 >= 0 && j3 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return (int) j3;
        }
        throw exception("expected an 16 bit unsigned integer");
    }

    public long getUInt32() throws IOException {
        long j3 = getLong();
        if (j3 >= 0 && j3 <= 4294967295L) {
            return j3;
        }
        throw exception("expected an 32 bit unsigned integer");
    }

    public int getUInt8() throws IOException {
        long j3 = getLong();
        if (j3 >= 0 && j3 <= 255) {
            return (int) j3;
        }
        throw exception("expected an 8 bit unsigned integer");
    }

    public void unget() {
        if (!this.ungottenToken) {
            if (this.current.type == 1) {
                this.line--;
            }
            this.ungottenToken = true;
            return;
        }
        throw new IllegalStateException("Cannot unget multiple tokens");
    }

    public byte[] getBase64() throws IOException {
        return getBase64(false);
    }

    public byte[] getHex() throws IOException {
        return getHex(false);
    }

    public String getIdentifier() throws IOException {
        return getIdentifier("an identifier");
    }

    public Tokenizer(String str) {
        this(new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    public Token get() throws IOException {
        return get(false, false);
    }
}
